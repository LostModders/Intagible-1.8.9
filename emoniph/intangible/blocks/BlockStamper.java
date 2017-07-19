/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.recipes.ModRecipes;
/*     */ import emoniph.intangible.recipes.StampingRecipeManager;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyBool;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.inventory.InventoryHelper;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityLockable;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.items.CapabilityItemHandler;
/*     */ import net.minecraftforge.items.IItemHandler;
/*     */ import net.minecraftforge.items.wrapper.SidedInvWrapper;
/*     */ 
/*     */ public class BlockStamper
/*     */   extends BlockContainer
/*     */   implements IBlock, ICreativeSort
/*     */ {
/*  52 */   public static final PropertyBool OPEN = PropertyBool.func_177716_a("open");
/*     */   private static final float SIXTEENTH = 0.0625F;
/*     */   
/*  55 */   BlockStamper() { super(Material.field_151573_f);
/*  56 */     func_149711_c(5.0F);
/*  57 */     func_149672_a(field_149777_j);
/*  58 */     setupBounds();
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  63 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public void func_180638_a(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity)
/*     */   {
/*  68 */     boolean open = ((Boolean)state.func_177229_b(OPEN)).booleanValue();
/*  69 */     if (!open) {
/*  70 */       setupBounds();
/*  71 */       super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */     } else {
/*  73 */       float BASE_HEIGHT = 0.3125F;
/*  74 */       float LID_WIDTH = 0.0625F;
/*     */       
/*  76 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */       
/*  78 */       switch (facing) {
/*     */       case NORTH: 
/*  80 */         func_149676_a(0.0F, 0.3125F, 0.0F, 1.0F, 1.0F, 0.0625F);
/*  81 */         break;
/*     */       case SOUTH: 
/*  83 */         func_149676_a(0.0F, 0.3125F, 0.9375F, 1.0F, 1.0F, 1.0F);
/*  84 */         break;
/*     */       case EAST: 
/*  86 */         func_149676_a(0.9375F, 0.3125F, 0.0F, 1.0F, 1.0F, 1.0F);
/*  87 */         break;
/*     */       case WEST: 
/*  89 */         func_149676_a(0.0F, 0.3125F, 0.0625F, 0.0F, 1.0F, 1.0F);
/*     */       }
/*     */       
/*     */       
/*  93 */       super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */       
/*  95 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
/*  96 */       super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */       
/*  98 */       setupBounds();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void setupBounds()
/*     */   {
/* 105 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/* 116 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/* 126 */     return new TileEntityStamper();
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 131 */     TileEntity tileentity = worldIn.func_175625_s(pos);
/*     */     
/* 133 */     if ((tileentity instanceof IInventory)) {
/* 134 */       InventoryHelper.func_180175_a(worldIn, pos, (IInventory)tileentity);
/* 135 */       worldIn.func_175666_e(pos, this);
/*     */     }
/*     */     
/* 138 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 143 */     updateState(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 148 */     updateState(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private void updateState(World worldIn, BlockPos pos, IBlockState state) {
/* 152 */     if (!worldIn.field_72995_K) {
/* 153 */       boolean open = ((Boolean)state.func_177229_b(OPEN)).booleanValue();
/* 154 */       EnumFacing ourFacing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 155 */       boolean powered = false;
/* 156 */       for (EnumFacing facing : EnumFacing.field_82609_l) {
/* 157 */         if ((facing != ourFacing) && 
/* 158 */           (worldIn.func_175651_c(pos.func_177972_a(facing), facing) > 0)) {
/* 159 */           powered = true;
/* 160 */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 166 */       if ((open) && (powered)) {
/* 167 */         TileEntityStamper stamper = (TileEntityStamper)BlockUtil.getTileEntity(worldIn, pos, TileEntityStamper.class);
/* 168 */         if (stamper != null) {
/* 169 */           stamper.stamp();
/* 170 */           stamper.lastChange = worldIn.func_82737_E();
/*     */         }
/*     */         
/* 173 */         worldIn.func_175656_a(pos, state.func_177226_a(OPEN, Boolean.valueOf(false)));
/* 174 */         worldIn.func_175689_h(pos);
/*     */       }
/* 176 */       else if ((!open) && (!powered)) {
/* 177 */         TileEntityStamper stamper = (TileEntityStamper)BlockUtil.getTileEntity(worldIn, pos, TileEntityStamper.class);
/* 178 */         if (stamper != null) {
/* 179 */           stamper.lastChange = worldIn.func_82737_E();
/*     */         }
/*     */         
/* 182 */         worldIn.func_175656_a(pos, state.func_177226_a(OPEN, Boolean.valueOf(true)));
/* 183 */         worldIn.func_175689_h(pos);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_180646_a(World worldIn, BlockPos pos)
/*     */   {
/* 190 */     IBlockState state = worldIn.func_180495_p(pos);
/* 191 */     boolean open = ((Boolean)state.func_177229_b(OPEN)).booleanValue();
/*     */     
/* 193 */     return new AxisAlignedBB(pos.func_177958_n() + this.field_149759_B, pos.func_177956_o() + this.field_149760_C, pos.func_177952_p() + this.field_149754_D, pos.func_177958_n() + this.field_149755_E, pos.func_177956_o() + (open ? 5 : 8) * 0.0625F, pos.func_177952_p() + this.field_149757_G);
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 198 */     if (worldIn.field_72995_K) {
/* 199 */       return true;
/*     */     }
/* 201 */     TileEntityStamper stamper = (TileEntityStamper)BlockUtil.getTileEntity(worldIn, pos, TileEntityStamper.class);
/* 202 */     if (stamper != null) {
/* 203 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 204 */       boolean open = ((Boolean)state.func_177229_b(OPEN)).booleanValue();
/* 205 */       if (open)
/*     */       {
/* 207 */         if (hitY == 0.3125F) {
/* 208 */           float x = 0.0F;float y = 0.0F;
/* 209 */           switch (facing) {
/*     */           case NORTH: 
/* 211 */             x = hitX;
/* 212 */             y = 1.0F - hitZ;
/* 213 */             break;
/*     */           case SOUTH: 
/* 215 */             x = 1.0F - hitX;
/* 216 */             y = hitZ;
/* 217 */             break;
/*     */           case EAST: 
/* 219 */             y = hitX;
/* 220 */             x = hitZ;
/* 221 */             break;
/*     */           case WEST: 
/* 223 */             y = 1.0F - hitX;
/* 224 */             x = 1.0F - hitZ;
/*     */           }
/*     */           
/* 227 */           int quad = 0;
/* 228 */           if ((x > 0.0625F) && (x < 0.9375F) && (y > 0.0625F) && (y < 0.9375F)) {
/* 229 */             float TTWOTH = 0.03125F;
/* 230 */             if ((y > 0.5D + TTWOTH) && (x < 0.5D - TTWOTH)) {
/* 231 */               quad = 1;
/* 232 */             } else if ((y > 0.5D + TTWOTH) && (x > 0.5D + TTWOTH)) {
/* 233 */               quad = 2;
/* 234 */             } else if ((y < 0.5D - TTWOTH) && (x < 0.5D - TTWOTH)) {
/* 235 */               quad = 3;
/* 236 */             } else if ((y < 0.5D - TTWOTH) && (x > 0.5D + TTWOTH)) {
/* 237 */               quad = 4;
/*     */             }
/*     */             
/* 240 */             if (quad > 0) {
/* 241 */               ItemStack stack = stamper.func_70301_a(quad);
/* 242 */               if (stack != null) {
/* 243 */                 ItemStack heldStack = playerIn.func_70694_bm();
/* 244 */                 if ((heldStack != null) && (ItemStack.func_179545_c(stack, heldStack)) && (ItemStack.func_77970_a(stack, heldStack))) {
/* 245 */                   int maxQuadSize = stamper.getMaxStackSizeForSlot(quad);
/* 246 */                   if (stack.field_77994_a < maxQuadSize) {
/* 247 */                     int transfer = Math.min(maxQuadSize - stack.field_77994_a, heldStack.field_77994_a);
/* 248 */                     stack.field_77994_a += transfer;
/* 249 */                     heldStack.field_77994_a -= transfer;
/* 250 */                     worldIn.func_175689_h(pos);
/*     */                   }
/*     */                 } else {
/* 253 */                   worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.field_70131_O * 0.5D, playerIn.field_70161_v, stack));
/*     */                   
/* 255 */                   stamper.func_70299_a(quad, null);
/*     */                 }
/*     */               } else {
/* 258 */                 stack = playerIn.func_70694_bm();
/* 259 */                 if (stack != null) {
/* 260 */                   stamper.func_70299_a(quad, stack.func_77979_a(1));
/* 261 */                   if (stack.field_77994_a == 0) {
/* 262 */                     playerIn.func_70062_b(0, null);
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 271 */       if ((hitX == 0.0F) || (hitX == 1.0F) || (hitZ == 0.0F) || (hitZ == 1.0F) || (!open)) {
/* 272 */         ItemStack stack = stamper.func_70301_a(0);
/* 273 */         if (stack != null) {
/* 274 */           worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.field_70131_O * 0.5D, playerIn.field_70161_v, stack));
/*     */           
/* 276 */           stamper.func_70299_a(0, null);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 281 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_149740_M()
/*     */   {
/* 287 */     return true;
/*     */   }
/*     */   
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/* 292 */     TileEntityStamper tile = (TileEntityStamper)BlockUtil.getTileEntity(worldIn, pos, TileEntityStamper.class);
/* 293 */     if (tile != null) {
/* 294 */       if (tile.func_70301_a(0) != null) {
/* 295 */         return 15;
/*     */       }
/* 297 */       int count = 0;
/* 298 */       for (int i = 1; i < tile.func_70302_i_(); i++) {
/* 299 */         if (tile.func_70301_a(i) != null) {
/* 300 */           count++;
/*     */         }
/*     */       }
/* 303 */       return count * 3;
/*     */     }
/*     */     
/* 306 */     return 0;
/*     */   }
/*     */   
/*     */   public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
/* 310 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, placer.func_174811_aO());
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 315 */     EnumFacing enumfacing = EnumFacing.func_176731_b(meta & 0x2);
/* 316 */     boolean open = (meta >> 2 & 0x1) == 1;
/* 317 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, enumfacing).func_177226_a(OPEN, Boolean.valueOf(open));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 322 */     int val = ((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N)).func_176736_b();
/* 323 */     val |= (((Boolean)state.func_177229_b(OPEN)).booleanValue() ? 1 : 0) << 2;
/* 324 */     return val;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/* 329 */     return new BlockState(this, new IProperty[] { BlockDirectional.field_176387_N, OPEN });
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 334 */     return 53;
/*     */   }
/*     */   
/*     */   public static class TileEntityStamper
/*     */     extends TileEntityLockable implements ISidedInventory
/*     */   {
/*     */     public static final int SLOT_OUTPUT = 0;
/*     */     public static final int SLOT_INPUT_TOP_LEFT = 1;
/*     */     public static final int SLOT_INPUT_TOP_RIGHT = 2;
/*     */     public static final int SLOT_INPUT_BOT_LEFT = 3;
/*     */     public static final int SLOT_INPUT_BOT_RIGHT = 4;
/*     */     private String customName;
/* 346 */     private ItemStack[] slots = new ItemStack[5];
/*     */     
/*     */     private long lastChange;
/*     */     private long clientChange;
/*     */     public static final long MAX_ANIMATION_TICKS = 3L;
/*     */     
/*     */     public float getAnimationProgress()
/*     */     {
/* 354 */       float max = 4.0F;
/* 355 */       float elapsed = Math.max(Math.min((float)(this.field_145850_b.func_82737_E() - this.clientChange), max), 0.0F);
/* 356 */       float progress = elapsed / max;
/* 357 */       if (((Boolean)this.field_145850_b.func_180495_p(this.field_174879_c).func_177229_b(BlockStamper.OPEN)).booleanValue()) {
/* 358 */         return -1.5707964F * progress;
/*     */       }
/* 360 */       return -1.5707964F * (1.0F - progress);
/*     */     }
/*     */     
/*     */ 
/*     */     public void stamp()
/*     */     {
/* 366 */       ItemStack[] inputs = { this.slots[1], this.slots[2], this.slots[3], this.slots[4] };
/* 367 */       Get.recipes();ItemStack output = ModRecipes.stamping.getOutputFor(inputs);
/*     */       
/* 369 */       boolean silent = BlockUtil.isSoundDampned(this.field_145850_b, this.field_174879_c);
/* 370 */       if (output != null) {
/* 371 */         IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 372 */         EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 373 */         if ((this.field_145850_b.func_175651_c(this.field_174879_c.func_177972_a(facing), facing) > 0) && (
/* 374 */           ((this.slots[1] != null) && (this.slots[1].field_77994_a <= 1)) || ((this.slots[2] != null) && (this.slots[2].field_77994_a <= 1)) || ((this.slots[3] != null) && (this.slots[3].field_77994_a <= 1)) || ((this.slots[4] != null) && (this.slots[4].field_77994_a <= 1))))
/*     */         {
/*     */ 
/*     */ 
/* 378 */           return;
/*     */         }
/*     */         
/* 381 */         if (this.slots[0] == null) {
/* 382 */           this.slots[0] = output.func_77946_l();
/*     */         } else {
/* 384 */           ItemStack current = this.slots[0];
/* 385 */           if (ItemStack.func_179545_c(current, output)) {
/* 386 */             int space = current.func_77976_d() - current.field_77994_a;
/* 387 */             if (space >= output.field_77994_a) {
/* 388 */               current.field_77994_a += Math.min(output.field_77994_a, space);
/*     */             } else {
/* 390 */               if (!silent) {
/* 391 */                 Sound.NOTE_SNARE.playToAllNear(this);
/*     */               }
/* 393 */               return;
/*     */             }
/*     */           }
/*     */         }
/* 397 */         func_70298_a(1, 1);
/* 398 */         func_70298_a(2, 1);
/* 399 */         func_70298_a(3, 1);
/* 400 */         func_70298_a(4, 1);
/* 401 */         this.field_145850_b.func_175685_c(this.field_174879_c, this.field_145854_h);
/* 402 */         if (!silent) {
/* 403 */           Sound.MOD_RANDOM_CLUNK.playToAllNear(this, 0.5F, 1.0F);
/*     */         }
/*     */       }
/* 406 */       else if (!silent) {
/* 407 */         Sound.NOTE_SNARE.playToAllNear(this);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public Container func_174876_a(InventoryPlayer playerInventory, EntityPlayer playerIn)
/*     */     {
/* 414 */       return null;
/*     */     }
/*     */     
/*     */     public String func_174875_k()
/*     */     {
/* 419 */       return null;
/*     */     }
/*     */     
/*     */     public int func_70302_i_()
/*     */     {
/* 424 */       return this.slots.length;
/*     */     }
/*     */     
/*     */     public ItemStack func_70301_a(int slot)
/*     */     {
/* 429 */       ItemStack result = this.slots[slot];
/* 430 */       return result;
/*     */     }
/*     */     
/*     */     public ItemStack func_70298_a(int index, int count)
/*     */     {
/* 435 */       if (this.slots[index] != null)
/*     */       {
/*     */ 
/* 438 */         if (this.slots[index].field_77994_a <= count) {
/* 439 */           ItemStack itemstack = this.slots[index];
/* 440 */           this.slots[index] = null;
/* 441 */           func_70296_d();
/*     */           
/* 443 */           return itemstack;
/*     */         }
/* 445 */         ItemStack itemstack = this.slots[index].func_77979_a(count);
/*     */         
/* 447 */         if (this.slots[index].field_77994_a == 0) {
/* 448 */           this.slots[index] = null;
/*     */         }
/*     */         
/* 451 */         func_70296_d();
/*     */         
/* 453 */         return itemstack;
/*     */       }
/*     */       
/* 456 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack func_70304_b(int index)
/*     */     {
/* 462 */       if (this.slots[index] != null) {
/* 463 */         ItemStack itemstack = this.slots[index];
/* 464 */         this.slots[index] = null;
/* 465 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 466 */         return itemstack;
/*     */       }
/* 468 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70299_a(int index, ItemStack stack)
/*     */     {
/* 474 */       this.slots[index] = stack;
/*     */       
/* 476 */       if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/* 477 */         stack.field_77994_a = func_70297_j_();
/*     */       }
/*     */       
/* 480 */       func_70296_d();
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70296_d()
/*     */     {
/* 486 */       super.func_70296_d();
/* 487 */       this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */     }
/*     */     
/*     */     public int func_70297_j_()
/*     */     {
/* 492 */       return 64;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean func_70300_a(EntityPlayer player)
/*     */     {
/* 498 */       return (this.field_145850_b.func_175625_s(this.field_174879_c) == this) && (player.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 0.5D, this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D);
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
/*     */     public int func_174887_a_(int id)
/*     */     {
/* 513 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_174885_b(int id, int value) {}
/*     */     
/*     */ 
/*     */     public int func_174890_g()
/*     */     {
/* 522 */       return 0;
/*     */     }
/*     */     
/*     */     public void func_174888_l()
/*     */     {
/* 527 */       for (int i = 0; i < this.slots.length; i++) {
/* 528 */         this.slots[i] = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public String func_70005_c_()
/*     */     {
/* 534 */       return func_145818_k_() ? this.customName : "";
/*     */     }
/*     */     
/*     */     public void setCustomName(String name) {
/* 538 */       this.customName = name;
/* 539 */       if (!this.field_145850_b.field_72995_K) {
/* 540 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean func_145818_k_()
/*     */     {
/* 546 */       return (this.customName != null) && (!this.customName.isEmpty());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound) {
/* 550 */       super.func_145839_a(compound);
/* 551 */       NBTTagList itemList = compound.func_150295_c("ModItems", 10);
/* 552 */       this.slots = new ItemStack[func_70302_i_()];
/*     */       
/* 554 */       if (compound.func_150297_b("CustomName", 8)) {
/* 555 */         this.customName = compound.func_74779_i("CustomName");
/*     */       }
/*     */       
/* 558 */       for (int i = 0; i < itemList.func_74745_c(); i++) {
/* 559 */         NBTTagCompound itemCompound = itemList.func_150305_b(i);
/* 560 */         int j = itemCompound.func_74771_c("Slot") & 0xFF;
/*     */         
/* 562 */         if ((j >= 0) && (j < this.slots.length)) {
/* 563 */           this.slots[j] = ItemStack.func_77949_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 567 */       long change = compound.func_74763_f("lastChange");
/* 568 */       if ((this.lastChange > 0L) && (this.lastChange != change)) {
/* 569 */         this.clientChange = this.field_145850_b.func_82737_E();
/*     */       }
/* 571 */       this.lastChange = change;
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound) {
/* 575 */       super.func_145841_b(compound);
/* 576 */       NBTTagList itemList = new NBTTagList();
/*     */       
/* 578 */       for (int i = 0; i < this.slots.length; i++) {
/* 579 */         if (this.slots[i] != null) {
/* 580 */           NBTTagCompound itemCompound = new NBTTagCompound();
/* 581 */           itemCompound.func_74774_a("Slot", (byte)i);
/* 582 */           this.slots[i].func_77955_b(itemCompound);
/* 583 */           itemList.func_74742_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 587 */       compound.func_74782_a("ModItems", itemList);
/*     */       
/* 589 */       if (func_145818_k_()) {
/* 590 */         compound.func_74778_a("CustomName", this.customName);
/*     */       }
/*     */       
/* 593 */       compound.func_74772_a("lastChange", this.lastChange);
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 598 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public Packet func_145844_m()
/*     */     {
/* 603 */       NBTTagCompound compound = new NBTTagCompound();
/* 604 */       func_145841_b(compound);
/* 605 */       if (!func_145818_k_()) {
/* 606 */         compound.func_74778_a("CustomName", "");
/*     */       }
/*     */       
/* 609 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 614 */       super.onDataPacket(net, packet);
/* 615 */       func_145839_a(packet.func_148857_g());
/* 616 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 622 */       return new AxisAlignedBB(this.field_174879_c, this.field_174879_c.func_177982_a(1, 2, 1));
/*     */     }
/*     */     
/* 625 */     private static final int[] SLOTS_NONE = new int[0];
/* 626 */     private static final int[] SLOTS_OUTPUT = { 0 };
/* 627 */     private static final int[] SLOTS_INPUT = { 1, 2, 3, 4 };
/*     */     
/*     */     public int[] func_180463_a(EnumFacing side)
/*     */     {
/* 631 */       if (side == EnumFacing.UP)
/* 632 */         return SLOTS_INPUT;
/* 633 */       if (side == EnumFacing.DOWN) {
/* 634 */         return SLOTS_OUTPUT;
/*     */       }
/* 636 */       return SLOTS_INPUT;
/*     */     }
/*     */     
/*     */ 
/* 640 */     private final IItemHandler downSideHandler = new SidedInvWrapper(this, EnumFacing.DOWN);
/* 641 */     private final IItemHandler otherSideHandler = new SidedInvWrapper(this, EnumFacing.UP);
/*     */     
/*     */     public <T> T getCapability(Capability<T> capability, EnumFacing facing)
/*     */     {
/* 645 */       if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
/* 646 */         switch (BlockStamper.1.$SwitchMap$net$minecraft$util$EnumFacing[facing.ordinal()]) {
/*     */         case 5: 
/* 648 */           return this.downSideHandler;
/*     */         }
/* 650 */         return this.otherSideHandler;
/*     */       }
/*     */       
/* 653 */       return (T)super.getCapability(capability, facing);
/*     */     }
/*     */     
/*     */     public boolean hasCapability(Capability<?> capability, EnumFacing facing)
/*     */     {
/* 658 */       return (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) || (super.hasCapability(capability, facing));
/*     */     }
/*     */     
/*     */     public boolean func_180462_a(int slot, ItemStack stackIn, EnumFacing direction)
/*     */     {
/* 663 */       if (this.slots[slot] == null) {
/* 664 */         return true;
/*     */       }
/*     */       
/* 667 */       if (!ItemStack.func_179545_c(this.slots[slot], stackIn)) {
/* 668 */         return false;
/*     */       }
/*     */       
/* 671 */       int maxStackSize = getMaxStackSizeForSlot(slot);
/*     */       
/* 673 */       return maxStackSize >= this.slots[slot].field_77994_a + stackIn.field_77994_a;
/*     */     }
/*     */     
/*     */     private int getMaxStackSizeForSlot(int slot) {
/* 677 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 678 */       if (state.func_177230_c() == Get.blocks().CIRCUIT_STAMPER) {
/* 679 */         EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 680 */         return this.field_145850_b.func_175651_c(this.field_174879_c.func_177972_a(facing), facing) > 0 ? Math.min(2, this.slots[slot].func_77976_d()) : this.slots[slot].func_77976_d();
/*     */       }
/* 682 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean func_180461_b(int slot, ItemStack stackIn, EnumFacing direction)
/*     */     {
/* 689 */       return slot == 0;
/*     */     }
/*     */     
/*     */     public boolean func_94041_b(int slot, ItemStack stack)
/*     */     {
/* 694 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockStamper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */