/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntitySoul;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulRegistry;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBed;
/*     */ import net.minecraft.block.BlockBed.EnumPartType;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockSoulWrench extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   BlockSoulWrench()
/*     */   {
/*  45 */     super(Material.field_151576_e);
/*  46 */     func_149711_c(3.0F);
/*  47 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT));
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  52 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  57 */     if (func_176203_a(meta).func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) {
/*  58 */       return new TileEntitySoulWrench();
/*     */     }
/*  60 */     return new TileEntityVoid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/*  67 */     return func_176223_P().func_177226_a(BlockBed.field_176472_a, (meta & 0x1) != 0 ? BlockBed.EnumPartType.HEAD : BlockBed.EnumPartType.FOOT);
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/*  72 */     return state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD ? 1 : 0;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/*  77 */     return new BlockState(this, new IProperty[] { BlockBed.field_176472_a });
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  82 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  97 */     return false;
/*     */   }
/*     */   
/*     */   public Item func_180660_a(IBlockState state, Random rand, int fortune)
/*     */   {
/* 102 */     return state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT ? Item.func_150898_a(this) : null;
/*     */   }
/*     */   
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
/*     */   {
/* 107 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) {
/* 108 */       super.func_180653_a(worldIn, pos, state, chance, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
/*     */   {
/* 114 */     if ((player.field_71075_bZ.field_75098_d) && (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD)) {
/* 115 */       BlockPos footPos = pos.func_177977_b();
/* 116 */       if (worldIn.func_180495_p(footPos).func_177230_c() == this) {
/* 117 */         worldIn.func_175698_g(footPos);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isPoweredStructure(World worldIn, BlockPos pos)
/*     */   {
/* 128 */     return (worldIn.func_180495_p(pos).func_177230_c() == Get.blocks().SOUL_WRENCH) && (worldIn.func_175640_z(pos)) && (isPoweredRelay(worldIn, pos.func_177982_a(1, 0, 1))) && (isPoweredRelay(worldIn, pos.func_177982_a(-1, 0, 1))) && (isPoweredRelay(worldIn, pos.func_177982_a(1, 0, -1))) && (isPoweredRelay(worldIn, pos.func_177982_a(-1, 0, -1)));
/*     */   }
/*     */   
/*     */   private static boolean isPoweredRelay(World world, BlockPos pos) {
/* 132 */     IBlockState state = world.func_180495_p(pos);
/* 133 */     return (state.func_177230_c() == Get.blocks().SOUL_RELAY) && (state.func_177229_b(BlockSoulRelay.POWERED) == Boolean.TRUE);
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 138 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 139 */       if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) {
/* 140 */         worldIn.func_175698_g(pos);
/*     */       }
/* 142 */     } else if (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this) {
/* 143 */       worldIn.func_175698_g(pos);
/* 144 */       if (!worldIn.field_72995_K) {
/* 145 */         func_176226_b(worldIn, pos, state, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 154 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class TileEntitySoulWrench
/*     */     extends TileEntity
/*     */     implements net.minecraft.util.ITickable
/*     */   {
/*     */     public static final int MAX_TICKS = 100;
/*     */     private int activeTicks;
/*     */     private long counter;
/*     */     private UUID targetId;
/*     */     private EntityLivingBase target;
/*     */     private int targetTicks;
/*     */     
/*     */     public EntityLivingBase getTarget()
/*     */     {
/* 171 */       return this.target;
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 176 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public boolean isActive() {
/* 180 */       return BlockSoulWrench.isPoweredStructure(this.field_145850_b, this.field_174879_c);
/*     */     }
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 185 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 186 */       if (state.func_177230_c() != Get.blocks().SOUL_WRENCH) {
/* 187 */         return;
/*     */       }
/* 189 */       this.counter += 1L;
/* 190 */       if (isActive()) {
/* 191 */         if (this.activeTicks == 100) {
/* 192 */           if (this.field_145850_b.field_72995_K)
/*     */           {
/* 194 */             emoniph.intangible.Intangible.PROXY.glow(this.field_145850_b, this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 1.85D, this.field_174879_c.func_177952_p() + 0.5D).color(10027008, 64).scale(2.5F);
/*     */           }
/* 196 */           else if (this.counter % 20L == 0L)
/*     */           {
/* 198 */             double RANGE = 16.0D;
/* 199 */             double RANGE_SQ = RANGE * RANGE;
/*     */             
/* 201 */             if ((this.target == null) && (this.targetId != null)) {
/* 202 */               List<EntityLivingBase> entities = this.field_145850_b.func_72872_a(EntityLivingBase.class, BlockUtil.getBounds(this.field_174879_c, RANGE, 8.0D));
/* 203 */               for (EntityLivingBase entity : entities) {
/* 204 */                 if (entity.func_110124_au().equals(this.targetId)) {
/* 205 */                   this.target = entity;
/* 206 */                   break;
/*     */                 }
/*     */               }
/* 209 */               this.targetId = null;
/* 210 */               this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */             }
/*     */             
/* 213 */             if ((this.target != null) && (this.target.func_70089_S()) && (this.target.func_174818_b(this.field_174879_c) < RANGE_SQ)) {
/* 214 */               int TARGETING_TICKS = 10;
/* 215 */               if (++this.targetTicks >= TARGETING_TICKS) {
/* 216 */                 if (Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet().add(SoulType.DOOMED, 1), 100, BlockUtil.midBlockToVec3(this.field_174879_c.func_177984_a()))) {
/* 217 */                   if ((this.target instanceof EntityLiving)) {
/* 218 */                     EntityLiving living = (EntityLiving)this.target;
/* 219 */                     EntitySoul soul = EntitySoul.removeSoulAsEntity((EntityLiving)this.target);
/* 220 */                     if (soul != null) {
/* 221 */                       soul.func_70080_a(living.field_70165_t, living.field_70163_u, living.field_70161_v, living.field_70177_z, living.field_70125_A);
/* 222 */                       this.field_145850_b.func_72838_d(soul);
/* 223 */                       Get.fx().GLOW.sendToAllNear(this.field_145850_b, living.field_70165_t, living.field_70163_u + living.field_70131_O * 0.5D, living.field_70161_v, 0.75F, 30, 16776960);
/*     */                       
/* 225 */                       Sound.MOD_RANDOM_REND_SOUL.playToAllNear(living, 0.5F, 1.0F);
/*     */                     }
/*     */                   }
/*     */                 } else {
/* 229 */                   Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.target.field_70165_t, this.target.field_70163_u + this.target.field_70131_O * 0.5D, this.target.field_70161_v, 0.75F, 30, 3355443);
/*     */                 }
/*     */                 
/* 232 */                 this.target = null;
/* 233 */                 this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */               } else {
/* 235 */                 Sound.MOD_RANDOM_WRENCH.playToAllNear(this.target, 0.25F, 1.0F);
/*     */               }
/*     */             } else {
/* 238 */               boolean sync = false;
/* 239 */               if (this.target != null) {
/* 240 */                 sync = true;
/*     */               }
/* 242 */               double closestDistSq = Double.MAX_VALUE;
/* 243 */               this.target = null;
/* 244 */               List<EntityLivingBase> entities = this.field_145850_b.func_72872_a(EntityLivingBase.class, BlockUtil.getBounds(this.field_174879_c, RANGE, 8.0D));
/* 245 */               for (EntityLivingBase entity : entities) {
/* 246 */                 double distSq = entity.func_174818_b(this.field_174879_c);
/* 247 */                 if ((distSq < RANGE_SQ) && (isValidTarget(entity)) && ((this.target == null) || (distSq < closestDistSq))) {
/* 248 */                   closestDistSq = distSq;
/* 249 */                   this.target = entity;
/*     */                 }
/*     */               }
/* 252 */               if (this.target != null) {
/* 253 */                 if (Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet().add(SoulType.PREDATORY, 1), 100, BlockUtil.midBlockToVec3(this.field_174879_c.func_177984_a()))) {
/* 254 */                   this.targetTicks = 0;
/* 255 */                   sync = true;
/*     */                 }
/*     */                 else {
/* 258 */                   this.target = null;
/*     */                 }
/*     */               }
/* 261 */               if (sync) {
/* 262 */                 this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */               }
/*     */               
/*     */             }
/*     */           }
/*     */         }
/*     */         else {
/* 269 */           this.activeTicks += 1;
/*     */         }
/* 271 */       } else if (this.activeTicks > 0) {
/* 272 */         this.activeTicks -= 1;
/* 273 */         this.target = null;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean isValidTarget(EntityLivingBase entity)
/*     */     {
/* 371 */       SoulType soulType = Get.souls().getSoulFor(entity.getClass());
/* 372 */       if ((entity instanceof EntityLiving)) {
/* 373 */         EntityLiving living = (EntityLiving)entity;
/*     */         
/* 375 */         return (soulType != null) && (!EnumSoulType.fromSoulType(soulType).isStrongSoul()) && (!EntitySoul.isSoul(entity)) && (Get.souls().isSoulPresent(living, true));
/*     */       }
/* 377 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 383 */       NBTTagCompound compound = new NBTTagCompound();
/* 384 */       func_145841_b(compound);
/* 385 */       if (this.target != null) {
/* 386 */         compound.func_74768_a("targetId", this.target.func_145782_y());
/*     */       }
/* 388 */       return new S35PacketUpdateTileEntity(this.field_174879_c, 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 393 */       super.onDataPacket(net, packet);
/* 394 */       NBTTagCompound compound = packet.func_148857_g();
/* 395 */       func_145839_a(compound);
/* 396 */       if (compound.func_150297_b("targetId", 3)) {
/* 397 */         int targetId = compound.func_74762_e("targetId");
/* 398 */         Entity entity = this.field_145850_b.func_73045_a(targetId);
/* 399 */         if ((entity instanceof EntityLivingBase)) {
/* 400 */           this.target = ((EntityLivingBase)entity);
/*     */         }
/*     */       }
/* 403 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 408 */       super.func_145839_a(compound);
/* 409 */       this.activeTicks = compound.func_74762_e("startTicks");
/* 410 */       this.target = null;
/* 411 */       this.targetTicks = compound.func_74762_e("targetTicks");
/* 412 */       if (compound.func_150297_b("target", 8)) {
/* 413 */         this.targetId = UUID.fromString(compound.func_74779_i("target"));
/*     */       } else {
/* 415 */         this.targetId = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 421 */       super.func_145841_b(compound);
/* 422 */       compound.func_74768_a("startTicks", this.activeTicks);
/* 423 */       compound.func_74768_a("targetTicks", this.targetTicks);
/* 424 */       if (this.target != null) {
/* 425 */         compound.func_74778_a("target", this.target.func_110124_au().toString());
/*     */       }
/*     */     }
/*     */     
/*     */     @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 432 */       return INFINITE_EXTENT_AABB;
/*     */     }
/*     */     
/*     */     public int getActiveTicks() {
/* 436 */       return this.activeTicks;
/*     */     }
/*     */     
/*     */     public long getCounter() {
/* 440 */       return this.counter;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockSoulWrench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */