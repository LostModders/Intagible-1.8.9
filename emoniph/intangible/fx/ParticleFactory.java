/*     */ package emoniph.intangible.fx;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.init.IModPreInit;
/*     */ import emoniph.intangible.network.IPacketRegister;
/*     */ import emoniph.intangible.network.IRegisterPackets;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ 
/*     */ public class ParticleFactory implements emoniph.intangible.init.IModService, IRegisterPackets, IModPreInit
/*     */ {
/*     */   private static final double DEFAULT_RANGE = 16.0D;
/*     */   
/*     */   private static abstract class ParticleType
/*     */   {
/*     */     public abstract void spawn(World paramWorld, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, int paramInt1, int paramInt2, int paramInt3, float paramFloat2, Vec3 paramVec3);
/*     */   }
/*     */   
/*     */   private static class VanillaParticle extends ParticleFactory.ParticleType
/*     */   {
/*     */     private final EnumParticleTypes particleType;
/*     */     
/*     */     public VanillaParticle(EnumParticleTypes pt)
/*     */     {
/*  46 */       this.particleType = pt;
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/*  51 */       return Integer.valueOf(this.particleType.func_179348_c()).hashCode();
/*     */     }
/*     */     
/*     */     public boolean equals(Object obj)
/*     */     {
/*  56 */       if ((obj == null) || (obj.getClass() != getClass()))
/*  57 */         return false;
/*  58 */       if (obj == this) {
/*  59 */         return true;
/*     */       }
/*  61 */       VanillaParticle other = (VanillaParticle)obj;
/*  62 */       return other.particleType == this.particleType;
/*     */     }
/*     */     
/*     */ 
/*  66 */     private static final int[] EMPTY_ARGS = new int[0];
/*     */     
/*     */     public void spawn(World world, double x, double y, double z, float radius, int density, int color, int variation, float speed, Vec3 target)
/*     */     {
/*  70 */       for (int i = 0; i < density; i++) {
/*  71 */         double x2 = x - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*  72 */         double y2 = y - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*  73 */         double z2 = z - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*  74 */         world.func_175688_a(this.particleType, x2, y2, z2, 0.0D, 0.0D, 0.0D, EMPTY_ARGS);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static class GlowParticle
/*     */     extends ParticleFactory.ParticleType
/*     */   {
/*     */     public void spawn(World world, double x, double y, double z, float radius, int density, int color, int variation, float speed, Vec3 target)
/*     */     {
/*  85 */       if ((variation == 0) || (target == null)) {
/*  86 */         if (density == 1)
/*     */         {
/*     */ 
/*     */ 
/*  90 */           Get.glow(world, x, y, z).color(color, variation).scale(radius).duration(20);
/*     */         } else {
/*  92 */           for (int i = 0; i < density; i++) {
/*  93 */             double x2 = x - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*  94 */             double y2 = y - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*  95 */             double z2 = z - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*     */             
/*     */ 
/*  98 */             IGlow glow = Get.glow(world, x2, y2, z2).color(color, variation);
/*     */             
/* 100 */             if (target != null) {
/* 101 */               float var = variation / 256.0F;
/* 102 */               double newspeed = speed - var + 2.0D * world.field_73012_v.nextDouble() * var;
/* 103 */               double dir_x = target.field_72450_a - x2;
/* 104 */               double dir_y = target.field_72448_b - y2;
/* 105 */               double dir_z = target.field_72449_c - z2;
/* 106 */               double distance = Math.sqrt(dir_x * dir_x + dir_y * dir_y + dir_z * dir_z);
/*     */               
/* 108 */               double factor = newspeed / distance;
/* 109 */               double vel_x = dir_x * factor;
/* 110 */               double vel_y = dir_y * factor;
/* 111 */               double vel_z = dir_z * factor;
/*     */               
/* 113 */               glow.motion(vel_x, vel_y, vel_z);
/* 114 */               glow.duration(MathHelper.func_76143_f(distance / newspeed));
/*     */             }
/*     */           }
/*     */         }
/* 118 */       } else if (variation == 1) {
/* 119 */         double dx = target.field_72450_a - x;
/* 120 */         double dy = target.field_72448_b - y;
/* 121 */         double dz = target.field_72449_c - z;
/*     */         
/* 123 */         for (int i = 0; i < density; i++) {
/* 124 */           double distScale = i / density;
/* 125 */           double x2 = x + dx * distScale;
/* 126 */           double y2 = y + dy * distScale;
/* 127 */           double z2 = z + dz * distScale;
/* 128 */           IGlow glow = Get.glow(world, x2, y2, z2).color(color, 16).scale(radius);
/*     */           
/* 130 */           double newspeed = speed;
/* 131 */           double dir_x = target.field_72450_a - x2;
/* 132 */           double dir_y = target.field_72448_b - y2;
/* 133 */           double dir_z = target.field_72449_c - z2;
/* 134 */           double distance = Math.sqrt(dir_x * dir_x + dir_y * dir_y + dir_z * dir_z);
/*     */           
/* 136 */           double factor = newspeed / distance;
/* 137 */           double vel_x = dir_x * factor;
/* 138 */           double vel_y = dir_y * factor;
/* 139 */           double vel_z = dir_z * factor;
/*     */           
/* 141 */           glow.motion(vel_x, vel_y, vel_z);
/* 142 */           glow.duration(MathHelper.func_76143_f(distance / newspeed));
/*     */         }
/* 144 */       } else if (variation == 2) {
/* 145 */         for (int i = 0; i < density; i++) {
/* 146 */           double x2 = x - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/* 147 */           double y2 = y - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/* 148 */           double z2 = z - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*     */           
/*     */ 
/* 151 */           IGlow glow = Get.glow(world, x2, y2, z2).color(color, 32);
/*     */           
/* 153 */           float var = variation / 256.0F;
/* 154 */           double newspeed = speed;
/* 155 */           double dir_x = target.field_72450_a - x2;
/* 156 */           double dir_y = target.field_72448_b - y2;
/* 157 */           double dir_z = target.field_72449_c - z2;
/* 158 */           double distance = Math.sqrt(dir_x * dir_x + dir_y * dir_y + dir_z * dir_z);
/*     */           
/* 160 */           double factor = newspeed / distance;
/* 161 */           double vel_x = dir_x * factor;
/* 162 */           double vel_y = dir_y * factor;
/* 163 */           double vel_z = dir_z * factor;
/*     */           
/* 165 */           double time = distance / newspeed;
/*     */           
/* 167 */           float g = 0.8F;
/*     */           
/* 169 */           glow.motion(vel_x, vel_y + 0.04D * g * 0.5D * time, vel_z);
/* 170 */           glow.acceleration(0.0F, g, 0.0F);
/* 171 */           glow.duration(MathHelper.func_76143_f(time));
/*     */         }
/* 173 */       } else if (variation == 3) {
/* 174 */         float anglePart = 360.0F / density;
/* 175 */         for (int i = 0; i < density; i++) {
/* 176 */           float mx = (float)Math.sin(Math.toRadians(anglePart * i)) * speed;
/* 177 */           float mz = (float)Math.cos(Math.toRadians(anglePart * i)) * speed;
/* 178 */           Get.glow(world, x, y, z).color(color, 16).scale(4.0F).duration(100).acceleration(0.0F, 0.3F, 0.0F).motion(mx, 0.3D, mz);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void sendToAllNear(World world, BlockPos pos, float radius, int density, int color) {
/* 184 */       sendToAllNear(world, pos, radius, density, color, 16.0D);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(World world, BlockPos pos, float radius, int density, int color, double range) {
/* 188 */       sendToAllNear(world, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, radius, density, color, range);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(World world, BlockPos pos, float radius, int density, int color, Vec3 target, float speed) {
/* 192 */       sendToAllNear(world, pos, radius, density, color, 0, target, speed, 16.0D);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(World world, BlockPos pos, float radius, int density, int color, int variation, Vec3 target, float speed, double range) {
/* 196 */       sendToAllNear(world, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, radius, density, color, variation, target, speed, range);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(Entity entity, float radius, int density, int color) {
/* 200 */       sendToAllNear(entity, radius, density, color, 16.0D);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(Entity entity, float radius, int density, int color, double range) {
/* 204 */       sendToAllNear(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u + entity.field_70131_O * 0.5D, entity.field_70161_v, radius, density, color, range);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(Entity entity, float radius, int density, int color, Vec3 target, float speed) {
/* 208 */       sendToAllNear(entity, radius, density, color, target, speed, 16.0D);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(Entity entity, float radius, int density, int color, Vec3 target, float speed, double range)
/*     */     {
/* 213 */       sendToAllNear(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u + entity.field_70131_O * 0.5D, entity.field_70161_v, radius, density, color, 0, target, speed, range);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(World world, double x, double y, double z, float radius, int density, int color) {
/* 217 */       sendToAllNear(world, x, y, z, radius, density, color, 16.0D);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(World world, double x, double y, double z, float radius, int density, int color, double range) {
/* 221 */       int index = ((Integer)Get.fx().particleTypeToIndex.get(this)).intValue();
/* 222 */       Get.pipeline().sendToAllAround(new ParticleFactory.PacketParticle(index, x, y, z, radius, density, color), new NetworkRegistry.TargetPoint(world.field_73011_w
/* 223 */         .func_177502_q(), x, y, z, range));
/*     */     }
/*     */     
/*     */     public void sendToAllNear(Entity entity, float radius, int density, int color, int variation, Vec3 target, float speed, double range)
/*     */     {
/* 228 */       sendToAllNear(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u + entity.field_70131_O * 0.5D, entity.field_70161_v, radius, density, color, variation, target, speed, range);
/*     */     }
/*     */     
/*     */     public void sendToAllNear(World world, double x, double y, double z, float radius, int density, int color, int variation, Vec3 target, float speed, double range) {
/* 232 */       int index = ((Integer)Get.fx().particleTypeToIndex.get(this)).intValue();
/* 233 */       Get.pipeline().sendToAllAround(new ParticleFactory.PacketParticle(index, x, y, z, radius, density, color, variation, target, speed), new NetworkRegistry.TargetPoint(world.field_73011_w
/* 234 */         .func_177502_q(), x, y, z, range));
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 240 */       return super.hashCode();
/*     */     }
/*     */     
/*     */     public boolean equals(Object obj)
/*     */     {
/* 245 */       if ((obj == null) || (obj.getClass() != getClass()))
/* 246 */         return false;
/* 247 */       if (obj == this) {
/* 248 */         return true;
/*     */       }
/*     */       
/* 251 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/* 256 */   private Map<ParticleType, Integer> particleTypeToIndex = new HashMap();
/* 257 */   private List<ParticleType> indexToParticleType = new ArrayList();
/*     */   public final GlowParticle GLOW;
/*     */   
/*     */   public ParticleFactory()
/*     */   {
/* 262 */     for (EnumParticleTypes pt : EnumParticleTypes.values()) {
/* 263 */       addParticleType(new VanillaParticle(pt));
/*     */     }
/*     */     
/* 266 */     this.GLOW = ((GlowParticle)addParticleType(new GlowParticle()));
/*     */   }
/*     */   
/*     */   private <T extends ParticleType> T addParticleType(T particle) {
/* 270 */     int index = this.indexToParticleType.size();
/* 271 */     this.indexToParticleType.add(particle);
/* 272 */     this.particleTypeToIndex.put(particle, Integer.valueOf(index));
/* 273 */     return particle;
/*     */   }
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/* 278 */     Get.pipeline().registerPacketProvider(this);
/*     */   }
/*     */   
/*     */   public void registerPackets(IPacketRegister packetRegister)
/*     */   {
/* 283 */     packetRegister.registerPacket(ParticleFactory.PacketParticle.Handler.class, PacketParticle.class, net.minecraftforge.fml.relauncher.Side.CLIENT);
/*     */   }
/*     */   
/*     */   public void sendToAllNear(EnumParticleTypes particle, World world, BlockPos pos, float radius, int density) {
/* 287 */     sendToAllNear(particle, world, pos, radius, density, 16.0D);
/*     */   }
/*     */   
/*     */   public void sendToAllNear(EnumParticleTypes particle, World world, BlockPos pos, float radius, int density, double range) {
/* 291 */     sendToAllNear(particle, world, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, radius, density, range);
/*     */   }
/*     */   
/*     */   public void sendToAllNear(EnumParticleTypes particle, EntityLivingBase entity, float radius, int density, double range) {
/* 295 */     sendToAllNear(particle, entity.field_70170_p, entity.field_70165_t, entity.field_70163_u + entity.field_70131_O * 0.5D, entity.field_70161_v, radius, density, range);
/*     */   }
/*     */   
/*     */   public void sendToAllNear(EnumParticleTypes particle, World world, double x, double y, double z, float radius, int density, double range) {
/* 299 */     int index = ((Integer)this.particleTypeToIndex.get(new VanillaParticle(particle))).intValue();
/* 300 */     Get.pipeline().sendToAllAround(new PacketParticle(index, x, y, z, radius, density), new NetworkRegistry.TargetPoint(world.field_73011_w
/* 301 */       .func_177502_q(), x, y, z, range)); }
/*     */   
/*     */   public static class PacketParticle implements IMessage { private double x;
/*     */     private double y;
/*     */     private double z;
/*     */     private float radius;
/*     */     private float speed;
/*     */     private int id;
/*     */     private int density;
/*     */     private int color;
/*     */     private int variation;
/*     */     private Vec3 target;
/*     */     
/*     */     public PacketParticle() {}
/*     */     
/* 316 */     public PacketParticle(int particle, double x, double y, double z, float radius, int density, int color, int variation, Vec3 target, float speed) { this.id = particle;
/* 317 */       this.x = x;
/* 318 */       this.y = y;
/* 319 */       this.z = z;
/* 320 */       this.radius = radius;
/* 321 */       this.density = density;
/* 322 */       this.color = color;
/* 323 */       this.speed = speed;
/* 324 */       this.target = target;
/* 325 */       this.variation = variation;
/*     */     }
/*     */     
/*     */     public PacketParticle(int particle, double x, double y, double z, float radius, int density, int color) {
/* 329 */       this(particle, x, y, z, radius, density, color, 0, null, 0.0F);
/*     */     }
/*     */     
/*     */     public PacketParticle(int particle, double x, double y, double z, float radius, int density) {
/* 333 */       this(particle, x, y, z, radius, density, -1, 0, null, 0.0F);
/*     */     }
/*     */     
/*     */     public void fromBytes(ByteBuf buf)
/*     */     {
/* 338 */       this.id = buf.readInt();
/* 339 */       this.x = buf.readDouble();
/* 340 */       this.y = buf.readDouble();
/* 341 */       this.z = buf.readDouble();
/* 342 */       this.radius = buf.readFloat();
/* 343 */       this.density = buf.readInt();
/* 344 */       this.color = buf.readInt();
/* 345 */       this.speed = buf.readFloat();
/* 346 */       if (this.speed > 0.0F) {
/* 347 */         double xDest = buf.readDouble();
/* 348 */         double yDest = buf.readDouble();
/* 349 */         double zDest = buf.readDouble();
/* 350 */         this.target = new Vec3(xDest, yDest, zDest);
/*     */       }
/* 352 */       this.variation = buf.readShort();
/*     */     }
/*     */     
/*     */     public void toBytes(ByteBuf buf)
/*     */     {
/* 357 */       buf.writeInt(this.id);
/* 358 */       buf.writeDouble(this.x);
/* 359 */       buf.writeDouble(this.y);
/* 360 */       buf.writeDouble(this.z);
/* 361 */       buf.writeFloat(this.radius);
/* 362 */       buf.writeInt(this.density);
/* 363 */       buf.writeInt(this.color);
/* 364 */       if ((this.speed > 0.0F) && (this.target != null)) {
/* 365 */         buf.writeFloat(this.speed);
/* 366 */         buf.writeDouble(this.target.field_72450_a);
/* 367 */         buf.writeDouble(this.target.field_72448_b);
/* 368 */         buf.writeDouble(this.target.field_72449_c);
/*     */       } else {
/* 370 */         buf.writeFloat(0.0F);
/*     */       }
/* 372 */       buf.writeShort(this.variation);
/*     */     }
/*     */     
/*     */     public static class Handler implements net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<ParticleFactory.PacketParticle, IMessage>
/*     */     {
/*     */       public IMessage onMessage(final ParticleFactory.PacketParticle message, final MessageContext ctx)
/*     */       {
/* 379 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*     */           public void run() {
/* 381 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 382 */             if ((player != null) && (message.id >= 0) && (message.id < Get.fx().indexToParticleType.size())) {
/* 383 */               ParticleFactory.ParticleType pt = (ParticleFactory.ParticleType)Get.fx().indexToParticleType.get(message.id);
/* 384 */               pt.spawn(player.field_70170_p, message.x, message.y, message.z, message.radius, message.density, message.color, message.variation, message.speed, message.target);
/*     */             }
/*     */             
/*     */           }
/* 388 */         });
/* 389 */         return null;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/fx/ParticleFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */