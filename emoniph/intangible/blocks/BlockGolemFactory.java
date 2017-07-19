/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.golem.IGolemArm;
/*     */ import emoniph.intangible.api.golem.IGolemBody;
/*     */ import emoniph.intangible.api.golem.IGolemHead;
/*     */ import emoniph.intangible.api.golem.IGolemLeg;
/*     */ import emoniph.intangible.entity.EntityWreckingGolem;
/*     */ import emoniph.intangible.golem.GolemPartRegistry;
/*     */ import emoniph.intangible.golem.GolemPartRegistry.Part;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyEnum;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryHelper;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.IStringSerializable;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.items.CapabilityItemHandler;
/*     */ 
/*     */ public class BlockGolemFactory extends BlockContainer implements IBlock, IMultiBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  56 */     return 68;
/*     */   }
/*     */   
/*     */   public static enum EnumPart implements IStringSerializable {
/*  60 */     BOTTOM("bottom", 0), 
/*  61 */     MIDDLE("middle", 1), 
/*  62 */     TOP("top", 2);
/*     */     
/*     */     private final String name;
/*     */     private final int metadata;
/*     */     private static final Map<Integer, EnumPart> META_TO_PART;
/*     */     
/*  68 */     private EnumPart(String name, int metadata) { this.name = name;
/*  69 */       this.metadata = metadata;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  73 */       return this.name;
/*     */     }
/*     */     
/*     */     public String func_176610_l() {
/*  77 */       return this.name;
/*     */     }
/*     */     
/*     */ 
/*  81 */     public int toMetadata() { return this.metadata; }
/*     */     
/*     */     static {
/*  84 */       META_TO_PART = new HashMap();
/*     */       
/*     */ 
/*  87 */       for (EnumPart part : values()) {
/*  88 */         META_TO_PART.put(Integer.valueOf(part.metadata), part);
/*     */       }
/*     */     }
/*     */     
/*     */     public static EnumPart fromMetadata(int metadata) {
/*  93 */       return (EnumPart)META_TO_PART.get(Integer.valueOf(metadata));
/*     */     }
/*     */   }
/*     */   
/*  97 */   public static final PropertyEnum PART = PropertyEnum.func_177709_a("part", EnumPart.class);
/*     */   
/*     */   BlockGolemFactory() {
/* 100 */     super(Material.field_151576_e);
/* 101 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(PART, EnumPart.BOTTOM));
/* 102 */     func_149711_c(3.0F);
/*     */   }
/*     */   
/*     */   public BlockPos getMultiBlockCorePos(IBlockAccess worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 107 */     switch ((EnumPart)state.func_177229_b(PART)) {
/*     */     case TOP: 
/* 109 */       return pos.func_177979_c(2);
/*     */     case MIDDLE: 
/* 111 */       return pos.func_177977_b();
/*     */     }
/* 113 */     return pos;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/* 120 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/* 125 */     if (func_176203_a(meta).func_177229_b(PART) == EnumPart.BOTTOM) {
/* 126 */       return new TileEntityGolemFactory();
/*     */     }
/* 128 */     return new TileEntityVoid();
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_149645_b()
/*     */   {
/* 134 */     return 3;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k() {
/* 139 */     return EnumWorldBlockLayer.SOLID;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/* 144 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/* 149 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 154 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {}
/*     */   
/*     */ 
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 164 */     Object part = state.func_177229_b(PART);
/* 165 */     if (part == EnumPart.TOP) {
/* 166 */       if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) {
/* 167 */         worldIn.func_175698_g(pos);
/*     */       }
/* 169 */     } else if (part == EnumPart.MIDDLE) {
/* 170 */       if ((worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) || (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this)) {
/* 171 */         worldIn.func_175698_g(pos);
/*     */       }
/* 173 */     } else if (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this) {
/* 174 */       worldIn.func_175698_g(pos);
/* 175 */       if (!worldIn.field_72995_K) {
/* 176 */         func_176226_b(worldIn, pos, state, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Item func_180660_a(IBlockState state, Random rand, int fortune) {
/* 182 */     return state.func_177229_b(PART) == EnumPart.BOTTOM ? super.func_180660_a(state, rand, fortune) : null;
/*     */   }
/*     */   
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
/* 186 */     if (state.func_177229_b(PART) == EnumPart.BOTTOM) {
/* 187 */       super.func_180653_a(worldIn, pos, state, chance, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 192 */     if (player.field_71075_bZ.field_75098_d) {
/* 193 */       Object part = state.func_177229_b(PART);
/* 194 */       if (part == EnumPart.TOP) {
/* 195 */         BlockPos blockpos1 = pos.func_177977_b();
/* 196 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 197 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 200 */         blockpos1 = blockpos1.func_177977_b();
/* 201 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 202 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/* 204 */       } else if (part == EnumPart.MIDDLE) {
/* 205 */         BlockPos blockpos1 = pos.func_177977_b();
/* 206 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 207 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 210 */         blockpos1 = pos.func_177984_a();
/* 211 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 212 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/* 219 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, EnumFacing.func_176731_b(meta & 0x3)).func_177226_a(PART, EnumPart.fromMetadata(meta >> 2 & 0x3));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/* 223 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 224 */     EnumPart part = (EnumPart)state.func_177229_b(PART);
/* 225 */     return facing.func_176736_b() | part.toMetadata() << 2;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e() {
/* 229 */     return new BlockState(this, new IProperty[] { BlockDirectional.field_176387_N, PART });
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 234 */     if ((state.func_177229_b(PART) == EnumPart.BOTTOM) && 
/* 235 */       (!worldIn.field_72995_K)) {
/* 236 */       TileEntityGolemFactory tile = (TileEntityGolemFactory)BlockUtil.getTileEntity(worldIn, pos, TileEntityGolemFactory.class);
/* 237 */       if (tile != null) {
/* 238 */         if (tile.isComplete()) {
/* 239 */           tile.detachGolem(state);
/*     */         }
/*     */         else {
/* 242 */           GolemPartRegistry.Part<IGolemHead> partHead = Get.golems().getHeadByIndex(tile.headIndex);
/* 243 */           if (partHead != null) {
/* 244 */             func_180635_a(worldIn, pos, partHead.getStack().func_77946_l());
/*     */           }
/*     */           
/* 247 */           GolemPartRegistry.Part<IGolemArm> partArm = Get.golems().getArmByIndex(tile.leftArmIndex);
/* 248 */           if (partArm != null) {
/* 249 */             func_180635_a(worldIn, pos, partArm.getStack().func_77946_l());
/*     */           }
/*     */           
/* 252 */           partArm = Get.golems().getArmByIndex(tile.rightArmIndex);
/* 253 */           if (partArm != null) {
/* 254 */             func_180635_a(worldIn, pos, partArm.getStack().func_77946_l());
/*     */           }
/*     */           
/* 257 */           GolemPartRegistry.Part<IGolemBody> partBody = Get.golems().getBodyByIndex(tile.bodyIndex);
/* 258 */           if (partBody != null) {
/* 259 */             func_180635_a(worldIn, pos, partBody.getStack().func_77946_l());
/*     */           }
/*     */           
/* 262 */           GolemPartRegistry.Part<IGolemLeg> partLeg = Get.golems().getLegByIndex(tile.leftLegIndex);
/* 263 */           if (partLeg != null) {
/* 264 */             func_180635_a(worldIn, pos, partLeg.getStack().func_77946_l());
/*     */           }
/*     */           
/* 267 */           partLeg = Get.golems().getLegByIndex(tile.rightLegIndex);
/* 268 */           if (partLeg != null) {
/* 269 */             func_180635_a(worldIn, pos, partLeg.getStack().func_77946_l());
/*     */           }
/*     */         }
/* 272 */         InventoryHelper.func_180175_a(worldIn, pos, tile);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 278 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private void spawnAsEntityIf(boolean condition, World worldIn, BlockPos pos, ItemStack itemStack) {
/* 282 */     if (condition) {
/* 283 */       func_180635_a(worldIn, pos, itemStack);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 289 */     pos = getMultiBlockCorePos(worldIn, pos, state);
/* 290 */     TileEntityGolemFactory tile = (TileEntityGolemFactory)BlockUtil.getTileEntity(worldIn, pos, TileEntityGolemFactory.class);
/* 291 */     if (tile != null) {
/* 292 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */       boolean right;
/*     */       boolean right;
/* 295 */       if (side == facing.func_176746_e()) {
/* 296 */         right = false; } else { boolean right;
/* 297 */         if (side == facing.func_176735_f()) {
/* 298 */           right = true;
/*     */         } else {
/* 300 */           float vx = 0.0F;
/* 301 */           switch (side) {
/*     */           case NORTH: 
/* 303 */             vx = facing != side ? 1.0F - hitX : hitX;
/* 304 */             break;
/*     */           case SOUTH: 
/* 306 */             vx = facing != side ? hitX : 1.0F - hitX;
/* 307 */             break;
/*     */           case EAST: 
/* 309 */             vx = facing != side ? 1.0F - hitZ : hitZ;
/* 310 */             break;
/*     */           case WEST: 
/* 312 */             vx = facing != side ? hitZ : 1.0F - hitZ;
/*     */           }
/*     */           
/* 315 */           right = vx < 0.5D;
/*     */         }
/*     */       }
/* 318 */       ItemStack stack = playerIn.func_70694_bm();
/* 319 */       if ((stack != null) && (tile.attachPart(playerIn, stack, right)))
/* 320 */         return true;
/* 321 */       if (side == facing.func_176734_d()) {
/* 322 */         tile.detachGolem(state);
/* 323 */       } else if ((side == facing) && 
/* 324 */         (!worldIn.field_72995_K)) {
/* 325 */         playerIn.func_71007_a(tile);
/*     */       }
/*     */       
/* 328 */       return true;
/*     */     }
/* 330 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class TileEntityGolemFactory
/*     */     extends TileEntity
/*     */     implements IInventory
/*     */   {
/* 338 */     private float health = -1.0F;
/* 339 */     private int headIndex = -1;
/* 340 */     private int leftArmIndex = -1;
/* 341 */     private int rightArmIndex = -1;
/* 342 */     private int bodyIndex = -1;
/* 343 */     private int leftLegIndex = -1;
/* 344 */     private int rightLegIndex = -1;
/* 345 */     private long attachTime = 0L;
/*     */     
/* 347 */     private final net.minecraftforge.items.IItemHandler itemHandler = new net.minecraftforge.items.wrapper.InvWrapper(this);
/*     */     @SideOnly(Side.CLIENT)
/*     */     private EntityWreckingGolem proxy;
/*     */     
/* 351 */     public <T> T getCapability(Capability<T> capability, EnumFacing facing) { if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
/* 352 */         return this.itemHandler;
/*     */       }
/* 354 */       return (T)super.getCapability(capability, facing);
/*     */     }
/*     */     
/*     */     public boolean hasCapability(Capability<?> capability, EnumFacing facing)
/*     */     {
/* 359 */       return (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) || (super.hasCapability(capability, facing));
/*     */     }
/*     */     
/*     */     private boolean isAttached(int bodyPartIndex) {
/* 363 */       return bodyPartIndex >= 0;
/*     */     }
/*     */     
/*     */     public boolean attachPart(EntityPlayer player, ItemStack piece, boolean right) {
/* 367 */       boolean splitStack = false;
/* 368 */       GolemPartRegistry.Part<IGolemBody> body = Get.golems().getBodyByStack(piece);
/* 369 */       if (body != null) {
/* 370 */         if (isAttached(this.bodyIndex)) {
/* 371 */           GolemPartRegistry.Part<IGolemBody> current = Get.golems().getBodyByIndex(this.bodyIndex);
/* 372 */           if (!this.field_145850_b.field_72995_K) {
/* 373 */             this.field_145850_b.func_72838_d(new EntityItem(this.field_145850_b, player.field_70165_t, player.field_70163_u + 0.5D, player.field_70161_v, current
/* 374 */               .getStack().func_77946_l()));
/*     */           }
/*     */         }
/* 377 */         this.bodyIndex = body.getIndex();
/* 378 */         splitStack = true;
/* 379 */       } else if (this.bodyIndex >= 0) {
/* 380 */         GolemPartRegistry.Part<IGolemHead> head = Get.golems().getHeadByStack(piece);
/* 381 */         if (head != null) {
/* 382 */           if (this.headIndex >= 0) {
/* 383 */             GolemPartRegistry.Part<IGolemHead> current = Get.golems().getHeadByIndex(this.headIndex);
/* 384 */             if (!this.field_145850_b.field_72995_K) {
/* 385 */               this.field_145850_b.func_72838_d(new EntityItem(this.field_145850_b, player.field_70165_t, player.field_70163_u + 0.5D, player.field_70161_v, current
/* 386 */                 .getStack().func_77946_l()));
/*     */             }
/*     */           }
/* 389 */           this.headIndex = head.getIndex();
/* 390 */           splitStack = true;
/*     */         } else {
/* 392 */           GolemPartRegistry.Part<IGolemArm> arm = Get.golems().getArmByStack(piece);
/* 393 */           if (arm != null) {
/* 394 */             if ((right) && (this.rightArmIndex >= 0)) {
/* 395 */               GolemPartRegistry.Part<IGolemArm> current = Get.golems().getArmByIndex(this.rightArmIndex);
/* 396 */               if (!this.field_145850_b.field_72995_K) {
/* 397 */                 this.field_145850_b.func_72838_d(new EntityItem(this.field_145850_b, player.field_70165_t, player.field_70163_u + 0.5D, player.field_70161_v, current
/* 398 */                   .getStack().func_77946_l()));
/*     */               }
/* 400 */               this.rightArmIndex = -1;
/* 401 */             } else if ((!right) && (this.leftArmIndex >= 0)) {
/* 402 */               GolemPartRegistry.Part<IGolemArm> current = Get.golems().getArmByIndex(this.leftArmIndex);
/* 403 */               if (!this.field_145850_b.field_72995_K) {
/* 404 */                 this.field_145850_b.func_72838_d(new EntityItem(this.field_145850_b, player.field_70165_t, player.field_70163_u + 0.5D, player.field_70161_v, current
/* 405 */                   .getStack().func_77946_l()));
/*     */               }
/* 407 */               this.leftArmIndex = -1;
/*     */             }
/*     */             
/* 410 */             if (right) {
/* 411 */               this.rightArmIndex = arm.getIndex();
/*     */             } else {
/* 413 */               this.leftArmIndex = arm.getIndex();
/*     */             }
/* 415 */             splitStack = true;
/*     */           } else {
/* 417 */             GolemPartRegistry.Part<IGolemLeg> leg = Get.golems().getLegByStack(piece);
/* 418 */             if (leg != null) {
/* 419 */               if ((right) && (this.rightLegIndex >= 0)) {
/* 420 */                 GolemPartRegistry.Part<IGolemLeg> current = Get.golems().getLegByIndex(this.rightLegIndex);
/* 421 */                 if (!this.field_145850_b.field_72995_K) {
/* 422 */                   this.field_145850_b.func_72838_d(new EntityItem(this.field_145850_b, player.field_70165_t, player.field_70163_u + 0.5D, player.field_70161_v, current
/* 423 */                     .getStack().func_77946_l()));
/*     */                 }
/* 425 */               } else if ((!right) && (this.leftLegIndex >= 0)) {
/* 426 */                 GolemPartRegistry.Part<IGolemLeg> current = Get.golems().getLegByIndex(this.leftLegIndex);
/* 427 */                 if (!this.field_145850_b.field_72995_K) {
/* 428 */                   this.field_145850_b.func_72838_d(new EntityItem(this.field_145850_b, player.field_70165_t, player.field_70163_u + 0.5D, player.field_70161_v, current
/* 429 */                     .getStack().func_77946_l()));
/*     */                 }
/*     */               }
/*     */               
/* 433 */               if (right) {
/* 434 */                 this.rightLegIndex = leg.getIndex();
/*     */               } else {
/* 436 */                 this.leftLegIndex = leg.getIndex();
/*     */               }
/* 438 */               splitStack = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 444 */       if (splitStack) {
/* 445 */         piece.func_77979_a(1);
/* 446 */         if ((piece.field_77994_a == 0) && (!player.field_71075_bZ.field_75098_d)) {
/* 447 */           player.func_70062_b(0, null);
/*     */         }
/* 449 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 450 */         return true;
/*     */       }
/*     */       
/* 453 */       return false;
/*     */     }
/*     */     
/*     */     public void attachGolem(EntityWreckingGolem golem) {
/* 457 */       if ((!this.field_145850_b.field_72995_K) && (this.bodyIndex == -1)) {
/* 458 */         if (golem.field_70153_n != null) {
/* 459 */           Entity rider = golem.field_70153_n;
/* 460 */           rider.func_70078_a(null);
/* 461 */           if ((rider instanceof EntityPlayer)) {
/* 462 */             EntityPlayer player = (EntityPlayer)rider;
/* 463 */             player.field_70159_w = 0.0D;
/* 464 */             player.field_70179_y = 0.0D;
/* 465 */             player.field_70702_br = 0.0F;
/* 466 */             player.field_70701_bs = 0.0F;
/*     */           }
/*     */         }
/*     */         
/* 470 */         this.headIndex = golem.getHeadIndex();
/* 471 */         this.leftArmIndex = golem.getLeftArmIndex();
/* 472 */         this.rightArmIndex = golem.getRightArmIndex();
/* 473 */         this.bodyIndex = golem.getBodyIndex();
/* 474 */         this.leftLegIndex = golem.getLeftLegIndex();
/* 475 */         this.rightLegIndex = golem.getRightLegIndex();
/*     */         
/* 477 */         this.health = golem.func_110143_aJ();
/* 478 */         this.attachTime = this.field_145850_b.func_82737_E();
/*     */         
/* 480 */         golem.moveInventoryTo(this);
/*     */         
/* 482 */         this.field_145850_b.func_72900_e(golem);
/*     */         
/* 484 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 485 */         Sound.MOD_RANDOM_CLANK.playToAllNear(this, 0.5F, 1.0F);
/*     */       }
/*     */     }
/*     */     
/*     */     public void detachGolem(IBlockState state) {
/* 490 */       if ((!this.field_145850_b.field_72995_K) && (isComplete())) {
/* 491 */         EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 492 */         EntityWreckingGolem golem = new EntityWreckingGolem(this.field_145850_b);
/* 493 */         golem.setRightArmIndex(this.rightArmIndex);
/* 494 */         golem.setLeftArmIndex(this.leftArmIndex);
/* 495 */         golem.setHeadIndex(this.headIndex);
/* 496 */         golem.setRightLegIndex(this.rightLegIndex);
/* 497 */         golem.setLeftLegIndex(this.leftLegIndex);
/* 498 */         golem.setBodyIndex(this.bodyIndex);
/*     */         
/* 500 */         BlockPos deployPos = func_174877_v().func_177967_a(facing.func_176734_d(), 1);
/* 501 */         golem.func_70080_a(deployPos.func_177958_n() + 0.5D, deployPos.func_177956_o(), deployPos.func_177952_p() + 0.5D, 0.0F, 0.0F);
/* 502 */         golem.preSpawn();
/* 503 */         if (this.health >= 0.0F) {
/* 504 */           float healthBonus = 0.0F;
/* 505 */           if (this.attachTime > 0L) {
/* 506 */             long secsPassed = (this.field_145850_b.func_82737_E() - this.attachTime) / 100L;
/* 507 */             healthBonus = (float)Math.max(secsPassed * 10L, 0L);
/*     */           }
/* 509 */           golem.func_70606_j(Math.max(Math.min(this.health + healthBonus, golem.func_110138_aP()), 10.0F));
/* 510 */           this.health = -1.0F;
/*     */         } else {
/* 512 */           golem.func_70606_j(golem.func_110138_aP());
/*     */         }
/* 514 */         this.field_145850_b.func_72838_d(golem);
/* 515 */         golem.postSpawn();
/*     */         
/* 517 */         this.headIndex = -1;
/* 518 */         this.leftArmIndex = -1;
/* 519 */         this.rightArmIndex = -1;
/* 520 */         this.bodyIndex = -1;
/* 521 */         this.leftLegIndex = -1;
/* 522 */         this.rightLegIndex = -1;
/*     */         
/*     */ 
/* 525 */         this.attachTime = -1L;
/*     */         
/* 527 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 528 */         Sound.MOD_RANDOM_CLANK.playToAllNear(this, 0.5F, 1.0F);
/*     */       }
/*     */     }
/*     */     
/*     */     private boolean isComplete() {
/* 533 */       return (this.bodyIndex >= 0) && (this.leftLegIndex >= 0) && (this.rightLegIndex >= 0) && (this.headIndex >= 0) && (this.rightArmIndex >= 0) && (this.leftArmIndex >= 0);
/*     */     }
/*     */     
/*     */     public Packet func_145844_m()
/*     */     {
/* 538 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 539 */       func_145841_b(nbtTag);
/* 540 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 545 */       super.onDataPacket(net, packet);
/* 546 */       func_145839_a(packet.func_148857_g());
/* 547 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 552 */       super.func_145839_a(compound);
/* 553 */       this.headIndex = compound.func_74762_e("headIndex");
/* 554 */       this.leftArmIndex = compound.func_74762_e("leftArmIndex");
/* 555 */       this.rightArmIndex = compound.func_74762_e("rightArmIndex");
/* 556 */       this.bodyIndex = compound.func_74762_e("bodyIndex");
/* 557 */       this.leftLegIndex = compound.func_74762_e("leftLegIndex");
/* 558 */       this.rightLegIndex = compound.func_74762_e("rightLegIndex");
/*     */       
/* 560 */       this.health = compound.func_74760_g("health");
/* 561 */       this.attachTime = compound.func_74763_f("attachTime");
/*     */       
/* 563 */       this.slots = new ItemStack[func_70302_i_()];
/* 564 */       NBTTagList itemList = compound.func_150295_c("ModItems", 10);
/*     */       
/* 566 */       if (compound.func_150297_b("CustomName", 8)) {
/* 567 */         this.customName = compound.func_74779_i("CustomName");
/*     */       }
/*     */       
/* 570 */       for (int i = 0; i < itemList.func_74745_c(); i++) {
/* 571 */         NBTTagCompound itemCompound = itemList.func_150305_b(i);
/* 572 */         int j = itemCompound.func_74771_c("Slot") & 0xFF;
/*     */         
/* 574 */         if ((j >= 0) && (j < this.slots.length)) {
/* 575 */           this.slots[j] = ItemStack.func_77949_a(itemCompound);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 582 */       super.func_145841_b(compound);
/* 583 */       compound.func_74768_a("headIndex", this.headIndex);
/* 584 */       compound.func_74768_a("leftArmIndex", this.leftArmIndex);
/* 585 */       compound.func_74768_a("rightArmIndex", this.rightArmIndex);
/* 586 */       compound.func_74768_a("bodyIndex", this.bodyIndex);
/* 587 */       compound.func_74768_a("leftLegIndex", this.leftLegIndex);
/* 588 */       compound.func_74768_a("rightLegIndex", this.rightLegIndex);
/*     */       
/* 590 */       compound.func_74776_a("health", this.health);
/* 591 */       compound.func_74772_a("attachTime", this.attachTime);
/*     */       
/* 593 */       NBTTagList itemList = new NBTTagList();
/*     */       
/* 595 */       for (int i = 0; i < this.slots.length; i++) {
/* 596 */         if (this.slots[i] != null) {
/* 597 */           NBTTagCompound itemCompound = new NBTTagCompound();
/* 598 */           itemCompound.func_74774_a("Slot", (byte)i);
/* 599 */           this.slots[i].func_77955_b(itemCompound);
/* 600 */           itemList.func_74742_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 604 */       compound.func_74782_a("ModItems", itemList);
/*     */       
/* 606 */       if (func_145818_k_()) {
/* 607 */         compound.func_74778_a("CustomName", this.customName);
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 614 */       return new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(2, 3, 2));
/*     */     }
/*     */     
/*     */ 
/*     */     private String customName;
/*     */     @SideOnly(Side.CLIENT)
/*     */     public EntityWreckingGolem getProxy()
/*     */     {
/* 622 */       if (this.bodyIndex >= 0) {
/* 623 */         if ((this.proxy == null) || (this.proxy.field_70170_p != this.field_145850_b)) {
/* 624 */           this.proxy = new EntityWreckingGolem(this.field_145850_b);
/*     */         }
/*     */         
/* 627 */         if (this.proxy.getHeadIndex() != this.headIndex) {
/* 628 */           this.proxy.setHeadIndex(this.headIndex);
/*     */         }
/* 630 */         if (this.proxy.getRightArmIndex() != this.rightArmIndex) {
/* 631 */           this.proxy.setRightArmIndex(this.rightArmIndex);
/*     */         }
/* 633 */         if (this.proxy.getLeftArmIndex() != this.leftArmIndex) {
/* 634 */           this.proxy.setLeftArmIndex(this.leftArmIndex);
/*     */         }
/* 636 */         if (this.proxy.getBodyIndex() != this.bodyIndex) {
/* 637 */           this.proxy.setBodyIndex(this.bodyIndex);
/*     */         }
/* 639 */         if (this.proxy.getRightLegIndex() != this.rightLegIndex) {
/* 640 */           this.proxy.setRightLegIndex(this.rightLegIndex);
/*     */         }
/* 642 */         if (this.proxy.getLeftLegIndex() != this.leftLegIndex) {
/* 643 */           this.proxy.setLeftLegIndex(this.leftLegIndex);
/*     */         }
/*     */         
/* 646 */         return this.proxy;
/*     */       }
/* 648 */       return null;
/*     */     }
/*     */     
/*     */ 
/* 652 */     private ItemStack[] slots = new ItemStack[27];
/*     */     
/*     */     public int func_70302_i_()
/*     */     {
/* 656 */       return this.slots.length;
/*     */     }
/*     */     
/*     */     public ItemStack func_70301_a(int slot)
/*     */     {
/* 661 */       ItemStack result = this.slots[slot];
/* 662 */       return result;
/*     */     }
/*     */     
/*     */     public ItemStack func_70298_a(int index, int count)
/*     */     {
/* 667 */       if (this.slots[index] != null)
/*     */       {
/*     */ 
/* 670 */         if (this.slots[index].field_77994_a <= count) {
/* 671 */           ItemStack itemstack = this.slots[index];
/* 672 */           this.slots[index] = null;
/* 673 */           func_70296_d();
/* 674 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/* 675 */           return itemstack;
/*     */         }
/* 677 */         ItemStack itemstack = this.slots[index].func_77979_a(count);
/*     */         
/* 679 */         if (this.slots[index].field_77994_a == 0) {
/* 680 */           this.slots[index] = null;
/*     */         }
/*     */         
/* 683 */         func_70296_d();
/* 684 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 685 */         return itemstack;
/*     */       }
/*     */       
/* 688 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack func_70304_b(int index)
/*     */     {
/* 694 */       if (this.slots[index] != null) {
/* 695 */         ItemStack itemstack = this.slots[index];
/* 696 */         this.slots[index] = null;
/* 697 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 698 */         return itemstack;
/*     */       }
/* 700 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70299_a(int index, ItemStack stack)
/*     */     {
/* 706 */       this.slots[index] = stack;
/*     */       
/* 708 */       if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/* 709 */         stack.field_77994_a = func_70297_j_();
/*     */       }
/*     */       
/* 712 */       func_70296_d();
/* 713 */       this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */     }
/*     */     
/*     */     public int func_70297_j_()
/*     */     {
/* 718 */       return 64;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean func_70300_a(EntityPlayer player)
/*     */     {
/* 724 */       return (this.field_145850_b.func_175625_s(this.field_174879_c) == this) && (player.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 0.5D, this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_174889_b(EntityPlayer player) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_174886_c(EntityPlayer player) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean func_94041_b(int index, ItemStack stack)
/*     */     {
/* 739 */       return true;
/*     */     }
/*     */     
/*     */     public int func_174887_a_(int id)
/*     */     {
/* 744 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_174885_b(int id, int value) {}
/*     */     
/*     */ 
/*     */     public int func_174890_g()
/*     */     {
/* 754 */       return 0;
/*     */     }
/*     */     
/*     */     public void func_174888_l()
/*     */     {
/* 759 */       for (int i = 0; i < this.slots.length; i++) {
/* 760 */         this.slots[i] = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public String func_70005_c_()
/*     */     {
/* 766 */       return func_145818_k_() ? this.customName : Get.blocks().GOLEM_FACTORY.func_149732_F();
/*     */     }
/*     */     
/*     */     public void setCustomName(String name) {
/* 770 */       this.customName = name;
/* 771 */       if (!this.field_145850_b.field_72995_K) {
/* 772 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean func_145818_k_()
/*     */     {
/* 778 */       return (this.customName != null) && (!this.customName.isEmpty());
/*     */     }
/*     */     
/*     */     public IChatComponent func_145748_c_()
/*     */     {
/* 783 */       return func_145818_k_() ? new net.minecraft.util.ChatComponentText(func_70005_c_()) : new net.minecraft.util.ChatComponentTranslation(func_70005_c_(), new Object[0]);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockGolemFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */