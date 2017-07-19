/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.souls.SoulRegistry;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBed;
/*     */ import net.minecraft.block.BlockBed.EnumPartType;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.monster.EntitySkeleton;
/*     */ import net.minecraft.entity.monster.EntitySlime;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockBoneCage extends BlockContainer implements IBlock, IMultiBlock, emoniph.intangible.api.IBellowsClient, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   BlockBoneCage()
/*     */   {
/*  41 */     super(Material.field_151576_e);
/*  42 */     func_149711_c(3.0F);
/*  43 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT));
/*  44 */     setupBounds();
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  49 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  54 */     return new TileEntityBoneCage();
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  59 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  74 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  80 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) {
/*  81 */       TileEntityBoneCage tile = (TileEntityBoneCage)BlockUtil.getTileEntity(worldIn, pos, TileEntityBoneCage.class);
/*  82 */       if ((tile != null) && 
/*  83 */         (tile.getTrappedEntity() != null)) {
/*  84 */         tile.releaseTrappedCreature((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  90 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_176199_a(World worldIn, BlockPos pos, Entity entityIn)
/*     */   {
/*  96 */     super.func_176199_a(worldIn, pos, entityIn);
/*     */   }
/*     */   
/*     */   public void func_180638_a(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity)
/*     */   {
/* 101 */     boolean top = state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD;
/*     */     
/* 103 */     TileEntityBoneCage cage = (TileEntityBoneCage)BlockUtil.getTileEntity(worldIn, pos, TileEntityBoneCage.class);
/*     */     
/* 105 */     boolean open = (cage != null) && (cage.isOpen());
/*     */     
/* 107 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */     
/* 109 */     float baseHeight = 0.0625F;
/* 110 */     float wallThick = 0.0625F;
/*     */     
/* 112 */     if (top) {
/* 113 */       func_149676_a(0.0F, 1.0F - baseHeight, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } else {
/* 115 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, baseHeight, 1.0F);
/*     */     }
/* 117 */     super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */     
/* 119 */     if ((!open) || (facing != EnumFacing.NORTH)) {
/* 120 */       func_149676_a(0.0F, baseHeight, 1.0F - wallThick, 1.0F, 1.0F, 1.0F);
/* 121 */       super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */     }
/*     */     
/* 124 */     if ((!open) || (facing != EnumFacing.SOUTH)) {
/* 125 */       func_149676_a(0.0F, baseHeight, 0.0F, 1.0F, 1.0F, wallThick);
/*     */       
/* 127 */       super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */     }
/*     */     
/*     */ 
/* 131 */     if ((!open) || (facing != EnumFacing.WEST)) {
/* 132 */       func_149676_a(1.0F - wallThick, baseHeight, 0.0F, 1.0F, 1.0F, 1.0F);
/* 133 */       super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */     }
/*     */     
/* 136 */     if ((!open) || (facing != EnumFacing.EAST)) {
/* 137 */       func_149676_a(0.0F, baseHeight, 0.0F, wallThick, 1.0F, 1.0F);
/* 138 */       super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */     }
/*     */     
/* 141 */     setupBounds();
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 147 */     if (!worldIn.field_72995_K) {
/* 148 */       TileEntityBoneCage cage = (TileEntityBoneCage)BlockUtil.getTileEntity(worldIn, getMultiBlockCorePos(worldIn, pos, state), TileEntityBoneCage.class);
/* 149 */       if (cage != null) {
/* 150 */         cage.manualToggle();
/*     */       }
/*     */     }
/* 153 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 158 */     return false;
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 163 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */     
/* 165 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 166 */       if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) {
/* 167 */         worldIn.func_175698_g(pos);
/*     */       }
/*     */     }
/* 170 */     else if (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this) {
/* 171 */       worldIn.func_175698_g(pos);
/*     */       
/* 173 */       if (!worldIn.field_72995_K) {
/* 174 */         func_176226_b(worldIn, pos, state, 0);
/*     */       }
/* 176 */       return;
/*     */     }
/*     */     
/* 179 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 180 */       pos = pos.func_177977_b();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 185 */     TileEntityBoneCage cage = (TileEntityBoneCage)BlockUtil.getTileEntity(worldIn, pos.func_177984_a(), TileEntityBoneCage.class);
/* 186 */     if (cage != null) {
/* 187 */       boolean isFrontPowered = worldIn.func_175709_b(pos.func_177972_a(facing.func_176734_d()), facing);
/* 188 */       boolean isBottomPowered = worldIn.func_175709_b(pos.func_177972_a(EnumFacing.DOWN), EnumFacing.DOWN);
/* 189 */       cage.redstoneToggle((isFrontPowered) || (isBottomPowered));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public Item func_180660_a(IBlockState state, Random rand, int fortune)
/*     */   {
/* 196 */     return state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD ? null : Item.func_150898_a(this);
/*     */   }
/*     */   
/*     */   public void func_180654_a(IBlockAccess worldIn, BlockPos pos)
/*     */   {
/* 201 */     super.func_180654_a(worldIn, pos);
/*     */   }
/*     */   
/*     */   private void setupBounds()
/*     */   {
/* 206 */     float radius = 0.0F;
/* 207 */     func_149676_a(0.0F + radius, 0.0F, 0.0F + radius, 1.0F - radius, 1.0F, 1.0F - radius);
/*     */   }
/*     */   
/*     */ 
/*     */   public AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 213 */     return super.func_180640_a(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
/*     */   {
/* 218 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) {
/* 219 */       super.func_180653_a(worldIn, pos, state, chance, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public net.minecraft.util.EnumWorldBlockLayer func_180664_k()
/*     */   {
/* 226 */     return net.minecraft.util.EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_180665_b(World worldIn, BlockPos pos)
/*     */   {
/* 232 */     return Item.func_150898_a(this);
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
/*     */   {
/* 237 */     if ((player.field_71075_bZ.field_75098_d) && (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD)) {
/* 238 */       BlockPos blockpos1 = pos.func_177977_b();
/*     */       
/* 240 */       if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 241 */         worldIn.func_175698_g(blockpos1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 248 */     EnumFacing enumfacing = EnumFacing.func_176731_b(meta);
/*     */     
/* 250 */     boolean head = (meta >> 2 & 0x1) == 1;
/*     */     
/*     */ 
/* 253 */     return func_176223_P().func_177226_a(BlockBed.field_176472_a, head ? BlockBed.EnumPartType.HEAD : BlockBed.EnumPartType.FOOT).func_177226_a(BlockDirectional.field_176387_N, enumfacing);
/*     */   }
/*     */   
/*     */   public IBlockState func_176221_a(IBlockState state, IBlockAccess worldIn, BlockPos pos)
/*     */   {
/* 258 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) {
/* 259 */       IBlockState localIBlockState = worldIn.func_180495_p(pos.func_177972_a((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N)));
/*     */     }
/*     */     
/* 262 */     return state;
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 267 */     byte b0 = 0;
/* 268 */     int i = b0 | ((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N)).func_176736_b();
/*     */     
/* 270 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 271 */       i |= 0x4;
/*     */     }
/*     */     
/* 274 */     return i;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/* 279 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { BlockDirectional.field_176387_N, BlockBed.field_176472_a });
/*     */   }
/*     */   
/*     */   public BlockPos getMultiBlockCorePos(IBlockAccess worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 284 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 285 */       return pos.func_177977_b();
/*     */     }
/* 287 */     return pos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void bellowsTick(World worldIn, BlockPos posIn, IBlockState stateIn, EnumFacing facingIn) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void bellowsComplete(World worldIn, BlockPos posIn, IBlockState stateIn, EnumFacing facingIn)
/*     */   {
/* 298 */     if (!worldIn.field_72995_K) {
/* 299 */       TileEntityBoneCage tile = (TileEntityBoneCage)BlockUtil.getTileEntity(worldIn, posIn, TileEntityBoneCage.class);
/* 300 */       if (tile != null) {
/* 301 */         EntityLiving entity = tile.getTrappedEntity();
/* 302 */         if ((entity != null) && ((entity instanceof EntityZombie))) {
/* 303 */           EntityZombie zombie = (EntityZombie)entity;
/* 304 */           if (!zombie.func_70631_g_()) {
/* 305 */             EntitySkeleton skelli = new EntitySkeleton(worldIn);
/* 306 */             skelli.func_70012_b(zombie.field_70165_t, zombie.field_70163_u, zombie.field_70161_v, zombie.field_70177_z, zombie.field_70125_A);
/* 307 */             for (int i = 0; i <= 4; i++) {
/* 308 */               skelli.func_70062_b(i, zombie.func_71124_b(i));
/*     */             }
/* 310 */             tile.setTrappedEntity(skelli, true);
/* 311 */             Get.fx().sendToAllNear(net.minecraft.util.EnumParticleTypes.REDSTONE, worldIn, posIn.func_177958_n() + 0.5D, posIn.func_177956_o() + 1, posIn.func_177952_p() + 0.5D, 0.5F, 30, 16.0D);
/* 312 */             Sound.MOD_AVATAR_HIT.playToAllNear(tile, 1.0F, 0.8F);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_149740_M()
/*     */   {
/* 321 */     return true;
/*     */   }
/*     */   
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/* 326 */     TileEntityBoneCage tile = (TileEntityBoneCage)BlockUtil.getTileEntity(worldIn, pos, TileEntityBoneCage.class);
/* 327 */     if (tile != null) {
/* 328 */       EntityLiving entity = tile.getTrappedEntity();
/* 329 */       if (entity == null)
/* 330 */         return 0;
/* 331 */       if ((Get.souls().getSoulFor(entity.getClass()) == null) || (!Get.souls().isSoulPresent(entity, false))) {
/* 332 */         return 1;
/*     */       }
/* 334 */       return 2;
/*     */     }
/*     */     
/* 337 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 343 */     return 56;
/*     */   }
/*     */   
/*     */   protected static enum RelayField {
/* 347 */     NONE(0),  SIMPLE(1),  ENHANCED(2);
/*     */     
/*     */     private final int meta;
/*     */     private static Map<Integer, RelayField> FROM_META;
/*     */     
/* 352 */     private RelayField(int meta) { this.meta = meta; }
/*     */     
/*     */ 
/*     */ 
/* 356 */     public int getMeta() { return this.meta; }
/*     */     
/*     */     static {
/* 359 */       FROM_META = new java.util.HashMap();
/*     */       
/* 361 */       for (RelayField field : values()) {
/* 362 */         FROM_META.put(Integer.valueOf(field.meta), field);
/*     */       }
/*     */     }
/*     */     
/*     */     public static RelayField fromMeta(int meta) {
/* 367 */       return (RelayField)FROM_META.get(Integer.valueOf(meta));
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TileEntityBoneCage extends TileEntity {
/*     */     private EntityLiving trappedEntity;
/*     */     private boolean open;
/* 374 */     private long openDelay = Long.MIN_VALUE;
/*     */     boolean powered;
/*     */     
/* 377 */     public EntityLiving getTrappedEntity() { return this.trappedEntity; }
/*     */     
/*     */ 
/*     */     NBTTagCompound saved;
/*     */     
/*     */     public boolean isOpen()
/*     */     {
/* 384 */       return this.open;
/*     */     }
/*     */     
/*     */     public BlockBoneCage.RelayField isInRelayField() {
/* 388 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 389 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */       
/* 391 */       EnumFacing right = facing.func_176746_e();
/* 392 */       EnumFacing left = right.func_176746_e().func_176746_e();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 398 */       BlockPos[] relayPositions = {this.field_174879_c.func_177972_a(right), this.field_174879_c.func_177972_a(right).func_177984_a(), this.field_174879_c.func_177972_a(left), this.field_174879_c.func_177972_a(left).func_177984_a() };
/*     */       
/*     */ 
/* 401 */       boolean resonator = false;
/* 402 */       BlockSyntheticResonator.TileEntitySyntheticResonator tile; if (this.field_145850_b.func_180495_p(this.field_174879_c.func_177981_b(2)).func_177230_c() == Get.blocks().SYNTHETIC_RESONATOR) {
/* 403 */         tile = (BlockSyntheticResonator.TileEntitySyntheticResonator)BlockUtil.getTileEntity(this.field_145850_b, this.field_174879_c.func_177981_b(2), BlockSyntheticResonator.TileEntitySyntheticResonator.class);
/* 404 */         if (tile != null) {
/* 405 */           resonator = tile.isActivated();
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 410 */       for (BlockPos relayPos : relayPositions) {
/* 411 */         IBlockState relayState = this.field_145850_b.func_180495_p(relayPos);
/* 412 */         if (relayState.func_177230_c() != Get.blocks().SOUL_RELAY) {
/* 413 */           return BlockBoneCage.RelayField.NONE;
/*     */         }
/*     */         
/* 416 */         if (!((Boolean)relayState.func_177229_b(BlockSoulRelay.POWERED)).booleanValue()) {
/* 417 */           return BlockBoneCage.RelayField.NONE;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 422 */       return resonator ? BlockBoneCage.RelayField.ENHANCED : BlockBoneCage.RelayField.SIMPLE;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void manualToggle()
/*     */     {
/* 429 */       toggleOpen();
/*     */     }
/*     */     
/*     */     public void redstoneToggle(boolean powered) {
/* 433 */       if ((this.powered) && (!powered)) {
/* 434 */         this.powered = false;
/* 435 */         return;
/*     */       }
/*     */       
/* 438 */       if ((!this.powered) && (powered)) {
/* 439 */         this.powered = true;
/* 440 */         toggleOpen();
/* 441 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */     public void toggleOpen() {
/* 446 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 447 */       if (state.func_177230_c() != Get.blocks().BONE_CAGE) {
/* 448 */         return;
/*     */       }
/* 450 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 451 */       if (this.open)
/*     */       {
/* 453 */         if (!this.field_145850_b.field_72995_K) {
/* 454 */           BlockPos capturePoint = func_174877_v().func_177982_a(0, -1, 0).func_177967_a(facing, 1);
/* 455 */           AxisAlignedBB aabb = new AxisAlignedBB(capturePoint, capturePoint.func_177982_a(1, 2, 1)).func_72314_b(2.0D, 0.0D, 2.0D);
/* 456 */           List<EntityLiving> entities = this.field_145850_b.func_72872_a(EntityLiving.class, aabb);
/*     */           
/* 458 */           EntityLiving closest = null;
/* 459 */           double distSq = Double.MAX_VALUE;
/* 460 */           for (EntityLiving entity : entities) {
/* 461 */             double newDistSq = entity.func_174818_b(this.field_174879_c.func_177977_b());
/* 462 */             if (((closest == null) || (newDistSq < distSq)) && 
/* 463 */               (entity.func_70089_S()) && (Get.souls().isTrappable(entity))) {
/* 464 */               closest = entity;
/* 465 */               distSq = newDistSq;
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 470 */           if (closest != null) {
/* 471 */             if (closest.field_70153_n != null) {
/* 472 */               Entity rider = closest.field_70153_n;
/* 473 */               rider.func_70078_a(null);
/* 474 */               if ((rider instanceof EntityPlayer)) {
/* 475 */                 EntityPlayer player = (EntityPlayer)rider;
/* 476 */                 player.field_70159_w = 0.0D;
/* 477 */                 player.field_70179_y = 0.0D;
/* 478 */                 player.field_70702_br = 0.0F;
/* 479 */                 player.field_70701_bs = 0.0F;
/*     */               }
/*     */             }
/* 482 */             this.trappedEntity = closest;
/* 483 */             this.field_145850_b.func_72900_e(closest);
/* 484 */             this.openDelay = (this.field_145850_b.func_82737_E() + 5L);
/*     */           }
/*     */         }
/* 487 */         this.open = false;
/* 488 */         Sound.MOD_RANDOM_BONECREEK_CLOSE.playToAllNear(this, 0.5F, 1.0F);
/*     */ 
/*     */       }
/* 491 */       else if (this.field_145850_b.func_82737_E() >= this.openDelay) {
/* 492 */         this.open = true;
/* 493 */         if (!this.field_145850_b.field_72995_K) {
/* 494 */           releaseTrappedCreature(facing);
/*     */         }
/* 496 */         Sound.MOD_RANDOM_BONECREEK_OPEN.playToAllNear(this, 0.5F, 1.0F);
/*     */       }
/*     */       
/*     */ 
/* 500 */       if (!this.field_145850_b.field_72995_K) {
/* 501 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */       
/* 504 */       this.field_145850_b.func_175685_c(this.field_174879_c, state.func_177230_c());
/*     */     }
/*     */     
/*     */     private void releaseTrappedCreature(EnumFacing facing) {
/* 508 */       if (this.trappedEntity != null) {
/* 509 */         BlockPos deployPos = func_174877_v().func_177967_a(facing.func_176734_d(), 2);
/* 510 */         if ((!this.field_145850_b.func_180495_p(deployPos).func_177230_c().func_149688_o().func_76222_j()) || (!this.field_145850_b.func_180495_p(deployPos.func_177984_a()).func_177230_c().func_149688_o().func_76222_j())) {
/* 511 */           deployPos = func_174877_v().func_177967_a(facing.func_176734_d(), 1);
/* 512 */           if ((!this.field_145850_b.func_180495_p(deployPos).func_177230_c().func_149688_o().func_76222_j()) || (!this.field_145850_b.func_180495_p(deployPos.func_177984_a()).func_177230_c().func_149688_o().func_76222_j())) {
/* 513 */             deployPos = func_174877_v();
/*     */           }
/*     */         }
/* 516 */         this.trappedEntity.func_70080_a(deployPos.func_177958_n() + 0.5D, deployPos.func_177956_o(), deployPos.func_177952_p() + 0.5D, 0.0F, 0.0F);
/* 517 */         this.trappedEntity.field_70128_L = false;
/* 518 */         this.trappedEntity.func_70029_a(this.field_145850_b);
/* 519 */         if (((this.trappedEntity instanceof EntitySlime)) && (!Get.souls().isSoulPresent(this.trappedEntity, false))) {
/* 520 */           ((EntitySlime)this.trappedEntity).func_70799_a(1);
/*     */         }
/* 522 */         this.field_145850_b.func_72838_d(this.trappedEntity);
/* 523 */         this.trappedEntity = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public void setTrappedEntity(EntityLiving entity, boolean noRemove) {
/* 528 */       if (!this.field_145850_b.field_72995_K) {
/* 529 */         if (this.trappedEntity != entity) {
/* 530 */           if ((entity.field_70170_p != null) && (!noRemove)) {
/* 531 */             entity.field_70170_p.func_72900_e(entity);
/*     */           }
/* 533 */           this.trappedEntity = entity;
/*     */         }
/* 535 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 536 */         this.field_145850_b.func_175685_c(this.field_174879_c, this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c());
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 542 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 547 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 548 */       func_145841_b(nbtTag);
/* 549 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(net.minecraft.network.NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 554 */       super.onDataPacket(net, packet);
/* 555 */       func_145839_a(packet.func_148857_g());
/* 556 */       if (this.saved != null) {
/* 557 */         Class<? extends EntityLiving> oclass = (Class)EntityList.field_75625_b.get(this.saved.func_74779_i("id"));
/* 558 */         Entity entity = null;
/* 559 */         if ((!Get.souls().isEntityRegistered(oclass)) && (net.minecraft.entity.passive.EntityVillager.class.isAssignableFrom(oclass))) {
/* 560 */           entity = new net.minecraft.entity.passive.EntityVillager(this.field_145850_b);
/*     */         } else {
/* 562 */           entity = EntityList.func_75615_a(this.saved, this.field_145850_b);
/*     */         }
/*     */         
/* 565 */         if (entity != null) {
/* 566 */           this.trappedEntity = ((EntityLiving)entity);
/*     */         }
/* 568 */         this.saved = null;
/*     */       }
/* 570 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145834_a(World worldIn)
/*     */     {
/* 575 */       super.func_145834_a(worldIn);
/* 576 */       if (this.saved != null) {
/* 577 */         Entity entity = EntityList.func_75615_a(this.saved, this.field_145850_b);
/* 578 */         if (entity != null) {
/* 579 */           this.trappedEntity = ((EntityLiving)entity);
/*     */         }
/* 581 */         this.saved = null;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 589 */       super.func_145839_a(compound);
/* 590 */       this.open = compound.func_74767_n("open");
/* 591 */       this.powered = compound.func_74767_n("powered");
/* 592 */       this.trappedEntity = null;
/* 593 */       if ((!this.open) && (compound.func_150297_b("prisoner", 10)))
/*     */       {
/* 595 */         this.saved = compound.func_74775_l("prisoner");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 602 */       super.func_145841_b(compound);
/* 603 */       compound.func_74757_a("open", this.open);
/* 604 */       compound.func_74757_a("powered", this.powered);
/* 605 */       if ((this.trappedEntity != null) && (!this.open)) {
/* 606 */         this.trappedEntity.field_70128_L = false;
/* 607 */         NBTTagCompound entity = new NBTTagCompound();
/*     */         
/* 609 */         this.trappedEntity.func_70039_c(entity);
/* 610 */         compound.func_74782_a("prisoner", entity);
/* 611 */         this.trappedEntity.field_70128_L = true;
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 618 */       AxisAlignedBB aabb = new AxisAlignedBB(func_174877_v().func_177982_a(0, 0, 0), func_174877_v().func_177982_a(1, 2, 1));
/* 619 */       return aabb;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockBoneCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */