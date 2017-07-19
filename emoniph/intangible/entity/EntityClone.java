/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.network.NetworkPlayerInfo;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.pathfinding.PathNavigateGround;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntityClone extends EntityTameable implements net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData
/*     */ {
/*     */   private int ticksToLive;
/*     */   private UUID ownerUUID;
/*     */   private String ownerName;
/*     */   public static final String DefaultSlimCharModel = "slim";
/*     */   private String skinType;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private net.minecraft.client.renderer.ThreadDownloadImageData downloadImageSkin;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ResourceLocation locationSkin;
/*     */   
/*     */   public EntityClone(World worldIn)
/*     */   {
/*  38 */     super(worldIn);
/*     */     
/*  40 */     func_70105_a(0.6F, 1.8F);
/*  41 */     ((PathNavigateGround)func_70661_as()).func_179690_a(true);
/*  42 */     ((PathNavigateGround)func_70661_as()).func_179693_d(true);
/*     */     
/*  44 */     this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAISwimming(this));
/*  45 */     this.field_70714_bg.func_75776_a(4, new net.minecraft.entity.ai.EntityAIAttackOnCollide(this, 1.0D, true));
/*  46 */     this.field_70714_bg.func_75776_a(5, new net.minecraft.entity.ai.EntityAIFollowOwner(this, 1.0D, 10.0F, 2.0F));
/*  47 */     this.field_70714_bg.func_75776_a(7, new net.minecraft.entity.ai.EntityAIWander(this, 1.0D));
/*  48 */     this.field_70714_bg.func_75776_a(9, new net.minecraft.entity.ai.EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  49 */     this.field_70714_bg.func_75776_a(9, new net.minecraft.entity.ai.EntityAILookIdle(this));
/*  50 */     this.field_70715_bh.func_75776_a(1, new net.minecraft.entity.ai.EntityAIOwnerHurtByTarget(this));
/*  51 */     this.field_70715_bh.func_75776_a(2, new net.minecraft.entity.ai.EntityAIOwnerHurtTarget(this));
/*  52 */     this.field_70715_bh.func_75776_a(3, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, true, new Class[0]));
/*     */     
/*  54 */     this.field_70178_ae = true;
/*     */     
/*  56 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */   public EntityClone(EntityPlayer player, int ticksTolive) {
/*  60 */     this(player.field_70170_p);
/*     */     
/*  62 */     this.ownerUUID = player.func_146103_bH().getId();
/*  63 */     this.ownerName = player.func_146103_bH().getName();
/*  64 */     func_152115_b(this.ownerUUID.toString());
/*     */     
/*  66 */     func_70012_b(player.field_70165_t, player.field_70163_u, player.field_70161_v, player.field_70177_z, player.field_70125_A);
/*  67 */     this.field_70126_B = player.field_70126_B;
/*  68 */     this.field_70127_C = player.field_70127_C;
/*     */     
/*  70 */     for (int slot = 0; slot < 5; slot++) {
/*  71 */       ItemStack stack = player.func_71124_b(slot);
/*  72 */       func_70062_b(slot, stack != null ? stack.func_77946_l() : null);
/*     */     }
/*     */     
/*  75 */     func_70624_b(player.func_70643_av());
/*  76 */     func_70604_c(player.func_70643_av());
/*     */     
/*  78 */     setTicksToLive(ticksTolive);
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  82 */     super.func_110147_ax();
/*  83 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
/*  84 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3D);
/*  85 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(0.5D);
/*  86 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(5.0D);
/*     */   }
/*     */   
/*     */   public void setTicksToLive(int ticks) {
/*  90 */     this.ticksToLive = ticks;
/*     */   }
/*     */   
/*     */   public int getTicksToLive() {
/*  94 */     return this.ticksToLive;
/*     */   }
/*     */   
/*     */   public void func_70636_d()
/*     */   {
/*  99 */     super.func_70636_d();
/* 100 */     if ((!this.field_70170_p.field_72995_K) && 
/* 101 */       (func_70089_S()) && (this.ticksToLive > 0) && (--this.ticksToLive == 0)) {
/* 102 */       func_70106_y();
/*     */     }
/*     */     
/*     */ 
/* 106 */     if (this.field_70173_aa % emoniph.intangible.util.TickUtil.fromSeconds(2) == 0) {
/* 107 */       attractAttention();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 113 */     super.func_70037_a(compound);
/* 114 */     if (compound.func_74764_b("ttl")) {
/* 115 */       this.ticksToLive = compound.func_74762_e("ttl");
/*     */     } else {
/* 117 */       this.ticksToLive = -1;
/*     */     }
/*     */     
/* 120 */     if ((compound.func_74764_b("ownerName")) && (compound.func_74764_b("ownerIDL")) && (compound.func_74764_b("ownerIDM"))) {
/* 121 */       this.ownerName = compound.func_74779_i("ownerName");
/* 122 */       this.ownerUUID = new UUID(compound.func_74763_f("ownerIDM"), compound.func_74763_f("ownerIDL"));
/*     */     } else {
/* 124 */       this.ownerName = null;
/* 125 */       this.ownerUUID = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public String func_70005_c_()
/*     */   {
/* 131 */     return this.ownerName != null ? this.ownerName : super.func_70005_c_();
/*     */   }
/*     */   
/*     */   public void func_70109_d(NBTTagCompound compound)
/*     */   {
/* 136 */     super.func_70109_d(compound);
/*     */     
/* 138 */     compound.func_74768_a("ttl", getTicksToLive());
/* 139 */     compound.func_74778_a("ownerName", this.ownerName);
/* 140 */     compound.func_74772_a("ownerIDM", this.ownerUUID.getMostSignificantBits());
/* 141 */     compound.func_74772_a("ownerIDL", this.ownerUUID.getLeastSignificantBits());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String getSkinType()
/*     */   {
/* 150 */     if (this.skinType == null) {
/* 151 */       if (this.ownerUUID == null) {
/* 152 */         this.skinType = "slim";
/*     */       } else {
/* 154 */         NetworkPlayerInfo info = net.minecraft.client.Minecraft.func_71410_x().func_147114_u().func_175102_a(this.ownerUUID);
/* 155 */         if (info != null) {
/* 156 */           this.skinType = info.func_178851_f();
/*     */         } else {
/* 158 */           return net.minecraft.client.resources.DefaultPlayerSkin.func_177332_b(this.ownerUUID);
/*     */         }
/*     */       }
/*     */     }
/* 162 */     return this.skinType;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ResourceLocation getSkinLocation() {
/* 167 */     if (this.locationSkin == null) {
/* 168 */       setupCustomSkin();
/*     */     }
/* 170 */     if (this.locationSkin != null) {
/* 171 */       return this.locationSkin;
/*     */     }
/* 173 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   private void setupCustomSkin()
/*     */   {
/* 185 */     if ((this.ownerName != null) && (!this.ownerName.isEmpty())) {
/* 186 */       this.locationSkin = AbstractClientPlayer.func_110311_f(this.ownerName);
/* 187 */       this.downloadImageSkin = AbstractClientPlayer.func_110304_a(this.locationSkin, this.ownerName);
/*     */     } else {
/* 189 */       this.locationSkin = null;
/* 190 */       this.downloadImageSkin = null;
/*     */     }
/*     */   }
/*     */   
/*     */   protected int func_70682_h(int air)
/*     */   {
/* 196 */     return air;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_82160_b(boolean p_82160_1_, int p_82160_2_) {}
/*     */   
/*     */ 
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {}
/*     */   
/*     */ 
/*     */   public EntityAgeable func_90011_a(EntityAgeable ageable)
/*     */   {
/* 209 */     return null;
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf buf)
/*     */   {
/* 214 */     if (this.ownerName == null) {
/* 215 */       ByteBufUtils.writeUTF8String(buf, "");
/*     */     } else {
/* 217 */       ByteBufUtils.writeUTF8String(buf, this.ownerName);
/* 218 */       buf.writeLong(this.ownerUUID.getMostSignificantBits());
/* 219 */       buf.writeLong(this.ownerUUID.getLeastSignificantBits());
/*     */     }
/*     */     
/* 222 */     buf.writeFloat(this.field_70177_z);
/* 223 */     buf.writeFloat(this.field_70126_B);
/* 224 */     buf.writeFloat(this.field_70125_A);
/* 225 */     buf.writeFloat(this.field_70127_C);
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf buf)
/*     */   {
/* 230 */     this.ownerName = ByteBufUtils.readUTF8String(buf);
/* 231 */     if ((this.ownerName == null) || (this.ownerName.isEmpty())) {
/* 232 */       this.ownerName = null;
/* 233 */       this.ownerUUID = null;
/*     */     } else {
/* 235 */       this.ownerUUID = new UUID(buf.readLong(), buf.readLong());
/*     */     }
/*     */     
/* 238 */     this.field_70177_z = buf.readFloat();
/* 239 */     this.field_70126_B = buf.readFloat();
/* 240 */     this.field_70125_A = buf.readFloat();
/* 241 */     this.field_70127_C = buf.readFloat();
/*     */   }
/*     */   
/*     */   public void attractAttention() { net.minecraft.entity.EntityLivingBase owner;
/* 245 */     if (!this.field_70170_p.field_72995_K) {
/* 246 */       owner = func_70902_q();
/* 247 */       if (owner != null) {
/* 248 */         java.util.List<EntityCreature> list = this.field_70170_p.func_72872_a(EntityCreature.class, func_174813_aQ().func_72314_b(16.0D, 8.0D, 16.0D));
/* 249 */         for (EntityCreature mob : list) {
/* 250 */           if (mob.func_70638_az() == owner) {
/* 251 */             mob.func_70604_c(this);
/* 252 */             mob.func_70624_b(this);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityClone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */