/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IMold;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.fluids.Fluid;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fluids.FluidTank;
/*     */ import net.minecraftforge.fluids.FluidTankInfo;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.items.CapabilityItemHandler;
/*     */ import net.minecraftforge.items.wrapper.SidedInvWrapper;
/*     */ 
/*     */ public class BlockBlowMold extends BlockContainer implements IBlock, emoniph.intangible.api.IBellowsClient, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   BlockBlowMold()
/*     */   {
/*  39 */     super(net.minecraft.block.material.Material.field_151576_e);
/*  40 */     func_149711_c(5.0F);
/*  41 */     func_149672_a(field_149769_e);
/*     */     
/*  43 */     func_149676_a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
/*     */   }
/*     */   
/*     */   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  49 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  54 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  64 */     return new TileEntityBlowMold();
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  69 */     TileEntity tileentity = worldIn.func_175625_s(pos);
/*     */     
/*  71 */     if ((tileentity instanceof IInventory)) {
/*  72 */       net.minecraft.inventory.InventoryHelper.func_180175_a(worldIn, pos, (IInventory)tileentity);
/*  73 */       worldIn.func_175666_e(pos, this);
/*     */     }
/*     */     
/*  76 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private static ItemStack consumeItem(ItemStack stack) {
/*  80 */     if (stack.field_77994_a == 1) {
/*  81 */       if (stack.func_77973_b().hasContainerItem(stack)) {
/*  82 */         return stack.func_77973_b().getContainerItem(stack);
/*     */       }
/*  84 */       return null;
/*     */     }
/*     */     
/*  87 */     stack.func_77979_a(1);
/*  88 */     return stack;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/*  95 */     if (worldIn.field_72995_K) {
/*  96 */       return true;
/*     */     }
/*  98 */     TileEntityBlowMold tile = (TileEntityBlowMold)BlockUtil.getTileEntity(worldIn, pos, TileEntityBlowMold.class);
/*  99 */     if (tile != null) {
/* 100 */       ItemStack resultStack = tile.func_70301_a(0);
/* 101 */       ItemStack moldStack = tile.func_70301_a(1);
/*     */       
/* 103 */       if (resultStack != null) {
/* 104 */         tile.func_70299_a(0, null);
/* 105 */         worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.func_70047_e(), playerIn.field_70161_v, resultStack));
/*     */       } else {
/* 107 */         ItemStack heldStack = playerIn.func_70694_bm();
/*     */         
/* 109 */         if (heldStack != null) {
/* 110 */           FluidStack fluidStackToFill = FluidContainerRegistry.getFluidForFilledItem(heldStack);
/* 111 */           if (fluidStackToFill != null) {
/* 112 */             if (tile.canFill(EnumFacing.UP, fluidStackToFill.getFluid())) {
/* 113 */               int quantityFilled = tile.fill(EnumFacing.UP, fluidStackToFill, true);
/* 114 */               if (quantityFilled > 0) {
/* 115 */                 if (!playerIn.field_71075_bZ.field_75098_d) {
/* 116 */                   playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.field_70461_c, 
/* 117 */                     consumeItem(heldStack));
/*     */                 }
/* 119 */                 Sound.LIQUID_GLOP.playToAllNear(worldIn, pos);
/*     */               }
/*     */             }
/* 122 */             return true;
/*     */           }
/*     */           
/* 125 */           FluidStack fluidStackInTank = tile.getTankInfo(EnumFacing.UP)[0].fluid;
/* 126 */           if (fluidStackInTank != null) {
/* 127 */             ItemStack filledBucketStack = FluidContainerRegistry.fillFluidContainer(fluidStackInTank, heldStack);
/* 128 */             FluidStack fluidStackToEmpty = FluidContainerRegistry.getFluidForFilledItem(filledBucketStack);
/* 129 */             if (fluidStackToEmpty != null) {
/* 130 */               if (!playerIn.field_71075_bZ.field_75098_d) {
/* 131 */                 if (heldStack.field_77994_a > 1) {
/* 132 */                   if (!playerIn.field_71071_by.func_70441_a(filledBucketStack)) {
/* 133 */                     return false;
/*     */                   }
/* 135 */                   playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.field_70461_c, 
/* 136 */                     consumeItem(heldStack));
/*     */                 }
/*     */                 else {
/* 139 */                   playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.field_70461_c, 
/* 140 */                     consumeItem(heldStack));
/* 141 */                   playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.field_70461_c, filledBucketStack);
/*     */                 }
/*     */               }
/*     */               
/* 145 */               tile.drain(EnumFacing.UP, fluidStackToEmpty.amount, true);
/* 146 */               Sound.LIQUID_LAVA_POP.playToAllNear(worldIn, pos);
/* 147 */               return true;
/*     */             }
/*     */           }
/*     */           
/* 151 */           if ((moldStack == null) && ((heldStack.func_77973_b() instanceof IMold))) {
/* 152 */             if (heldStack.field_77994_a == 1) {
/* 153 */               tile.func_70299_a(1, heldStack);
/* 154 */               playerIn.func_70062_b(0, null);
/*     */             } else {
/* 156 */               ItemStack newStack = heldStack.func_77979_a(1);
/* 157 */               tile.func_70299_a(1, newStack);
/*     */             }
/* 159 */             return true;
/*     */           }
/*     */         }
/*     */         
/* 163 */         if (moldStack != null) {
/* 164 */           tile.func_70299_a(1, null);
/* 165 */           worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.func_70047_e(), playerIn.field_70161_v, moldStack));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 170 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_149740_M()
/*     */   {
/* 176 */     return true;
/*     */   }
/*     */   
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/* 181 */     TileEntityBlowMold tile = (TileEntityBlowMold)BlockUtil.getTileEntity(worldIn, pos, TileEntityBlowMold.class);
/* 182 */     if (tile != null) {
/* 183 */       if (tile.func_70301_a(0) != null) {
/* 184 */         return 2;
/*     */       }
/* 186 */       boolean full = tile.tank.getFluidAmount() > 0;
/*     */       
/* 188 */       if (full) {
/* 189 */         return 1;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 194 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 200 */     checkForNearbyFluids(worldIn, pos);
/*     */   }
/*     */   
/*     */   private void checkForNearbyFluids(World worldIn, BlockPos pos) {
/* 204 */     if (!worldIn.field_72995_K) {
/* 205 */       TileEntityBlowMold tile = (TileEntityBlowMold)BlockUtil.getTileEntity(worldIn, pos, TileEntityBlowMold.class);
/* 206 */       if (tile != null) {
/* 207 */         BlockPos abovePos = pos.func_177984_a();
/* 208 */         IBlockState aboveState = worldIn.func_180495_p(abovePos);
/* 209 */         Fluid fluid = net.minecraftforge.fluids.FluidRegistry.lookupFluidForBlock(aboveState.func_177230_c());
/* 210 */         if (fluid != null) {
/* 211 */           ItemStack stack = tile.func_70301_a(1);
/* 212 */           if ((stack != null) && (tile.canFill(EnumFacing.UP, fluid)) && 
/* 213 */             ((stack.func_77973_b() instanceof IMold))) {
/* 214 */             IMold mold = (IMold)stack.func_77973_b();
/* 215 */             ItemStack result = mold.getResultForFluid(new FluidStack(fluid, 1000));
/* 216 */             if (result != null) {
/* 217 */               worldIn.func_175698_g(abovePos);
/* 218 */               tile.fill(EnumFacing.UP, mold.getRequiredFluid(result).copy(), true);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void bellowsTick(World worldIn, BlockPos posIn, IBlockState stateIn, EnumFacing facingIn)
/*     */   {
/* 229 */     checkForNearbyFluids(worldIn, posIn);
/*     */   }
/*     */   
/*     */   public void bellowsComplete(World worldIn, BlockPos posIn, IBlockState stateIn, EnumFacing facingIn)
/*     */   {
/* 234 */     if (!worldIn.field_72995_K) {
/* 235 */       TileEntityBlowMold tile = (TileEntityBlowMold)BlockUtil.getTileEntity(worldIn, posIn, TileEntityBlowMold.class);
/* 236 */       if (tile != null) {
/* 237 */         ItemStack stack = tile.func_70301_a(1);
/* 238 */         FluidStack fluid = tile.getTankInfo(facingIn)[0].fluid;
/* 239 */         if ((stack != null) && (fluid != null) && 
/* 240 */           ((stack.func_77973_b() instanceof IMold))) {
/* 241 */           IMold mold = (IMold)stack.func_77973_b();
/* 242 */           ItemStack result = mold.getResultForFluid(fluid);
/* 243 */           if (result != null) {
/* 244 */             tile.drain(facingIn, fluid.amount, true);
/* 245 */             tile.func_70299_a(0, result.func_77946_l());
/* 246 */             if (!BlockUtil.isSoundDampned(worldIn, posIn)) {
/* 247 */               Sound.MOD_RANDOM_CLINK.playToAllNear(tile);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 258 */     return 55;
/*     */   }
/*     */   
/*     */   public static class TileEntityBlowMold
/*     */     extends TileEntity
/*     */     implements net.minecraft.inventory.ISidedInventory, net.minecraftforge.fluids.IFluidHandler
/*     */   {
/*     */     public static final int SLOT_OUTPUT = 0;
/*     */     public static final int SLOT_MOLD = 1;
/*     */     private String customName;
/* 268 */     private ItemStack[] slots = new ItemStack[2];
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 272 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public int func_70302_i_()
/*     */     {
/* 277 */       return this.slots.length;
/*     */     }
/*     */     
/*     */     public ItemStack func_70301_a(int index)
/*     */     {
/* 282 */       return this.slots[index];
/*     */     }
/*     */     
/*     */     public ItemStack func_70298_a(int index, int count)
/*     */     {
/* 287 */       if (this.slots[index] != null)
/*     */       {
/*     */ 
/* 290 */         if (this.slots[index].field_77994_a <= count) {
/* 291 */           ItemStack itemstack = this.slots[index];
/* 292 */           this.slots[index] = null;
/* 293 */           func_70296_d();
/* 294 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/* 295 */           return itemstack;
/*     */         }
/* 297 */         ItemStack itemstack = this.slots[index].func_77979_a(count);
/*     */         
/* 299 */         if (this.slots[index].field_77994_a == 0) {
/* 300 */           this.slots[index] = null;
/*     */         }
/*     */         
/* 303 */         func_70296_d();
/* 304 */         if (!this.field_145850_b.field_72995_K) {
/* 305 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/* 306 */           this.field_145850_b.func_175685_c(this.field_174879_c, this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c());
/*     */         }
/* 308 */         return itemstack;
/*     */       }
/*     */       
/* 311 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack func_70304_b(int index)
/*     */     {
/* 317 */       if (this.slots[index] != null) {
/* 318 */         ItemStack itemstack = this.slots[index];
/* 319 */         this.slots[index] = null;
/* 320 */         if (!this.field_145850_b.field_72995_K) {
/* 321 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/* 322 */           this.field_145850_b.func_175685_c(this.field_174879_c, this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c());
/*     */         }
/* 324 */         return itemstack;
/*     */       }
/* 326 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70299_a(int index, ItemStack stack)
/*     */     {
/* 332 */       this.slots[index] = stack;
/*     */       
/* 334 */       if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/* 335 */         stack.field_77994_a = func_70297_j_();
/*     */       }
/*     */       
/* 338 */       func_70296_d();
/* 339 */       if (!this.field_145850_b.field_72995_K) {
/* 340 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 341 */         this.field_145850_b.func_175685_c(this.field_174879_c, this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c());
/*     */       }
/*     */     }
/*     */     
/*     */     public int func_70297_j_()
/*     */     {
/* 347 */       return 16;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean func_70300_a(EntityPlayer player)
/*     */     {
/* 353 */       return (this.field_145850_b.func_175625_s(this.field_174879_c) == this) && (player.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 0.5D, this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D);
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
/*     */     public boolean func_94041_b(int slot, ItemStack stack)
/*     */     {
/* 368 */       return (slot == 1) && (stack != null) && ((stack.func_77973_b() instanceof IMold));
/*     */     }
/*     */     
/* 371 */     private final net.minecraftforge.items.IItemHandler downSideHandler = new SidedInvWrapper(this, EnumFacing.DOWN);
/* 372 */     private final net.minecraftforge.items.IItemHandler otherSideHandler = new SidedInvWrapper(this, EnumFacing.UP);
/*     */     
/*     */     public <T> T getCapability(Capability<T> capability, EnumFacing facing)
/*     */     {
/* 376 */       if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
/* 377 */         switch (BlockBlowMold.1.$SwitchMap$net$minecraft$util$EnumFacing[facing.ordinal()]) {
/*     */         case 1: 
/* 379 */           return this.downSideHandler;
/*     */         }
/* 381 */         return this.otherSideHandler;
/*     */       }
/*     */       
/* 384 */       return (T)super.getCapability(capability, facing);
/*     */     }
/*     */     
/*     */     public boolean hasCapability(Capability<?> capability, EnumFacing facing)
/*     */     {
/* 389 */       return (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) || (super.hasCapability(capability, facing));
/*     */     }
/*     */     
/*     */     public int func_174887_a_(int id)
/*     */     {
/* 394 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_174885_b(int id, int value) {}
/*     */     
/*     */ 
/*     */     public int func_174890_g()
/*     */     {
/* 403 */       return 0;
/*     */     }
/*     */     
/*     */     public void func_174888_l()
/*     */     {
/* 408 */       for (int i = 0; i < this.slots.length; i++) {
/* 409 */         this.slots[i] = null;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public String func_70005_c_()
/*     */     {
/* 416 */       return func_145818_k_() ? this.customName : "";
/*     */     }
/*     */     
/*     */     public void setCustomName(String name) {
/* 420 */       this.customName = name;
/* 421 */       if (!this.field_145850_b.field_72995_K) {
/* 422 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean func_145818_k_()
/*     */     {
/* 428 */       return (this.customName != null) && (!this.customName.isEmpty());
/*     */     }
/*     */     
/*     */     public net.minecraft.util.IChatComponent func_145748_c_()
/*     */     {
/* 433 */       return func_145818_k_() ? new net.minecraft.util.ChatComponentText(func_70005_c_()) : new net.minecraft.util.ChatComponentTranslation(func_70005_c_(), new Object[0]);
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 438 */       super.func_145839_a(compound);
/* 439 */       NBTTagList itemList = compound.func_150295_c("ModItems", 10);
/* 440 */       this.slots = new ItemStack[func_70302_i_()];
/*     */       
/* 442 */       if (compound.func_150297_b("CustomName", 8)) {
/* 443 */         this.customName = compound.func_74779_i("CustomName");
/*     */       }
/*     */       
/* 446 */       for (int i = 0; i < itemList.func_74745_c(); i++) {
/* 447 */         NBTTagCompound itemCompound = itemList.func_150305_b(i);
/* 448 */         int j = itemCompound.func_74771_c("Slot") & 0xFF;
/*     */         
/* 450 */         if ((j >= 0) && (j < this.slots.length)) {
/* 451 */           this.slots[j] = ItemStack.func_77949_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 455 */       if (compound.func_150297_b("tank", 10)) {
/* 456 */         NBTTagCompound tankCompound = compound.func_74775_l("tank");
/* 457 */         this.tank.readFromNBT(tankCompound);
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 463 */       super.func_145841_b(compound);
/* 464 */       NBTTagList itemList = new NBTTagList();
/*     */       
/* 466 */       for (int i = 0; i < this.slots.length; i++) {
/* 467 */         if (this.slots[i] != null) {
/* 468 */           NBTTagCompound itemCompound = new NBTTagCompound();
/* 469 */           itemCompound.func_74774_a("Slot", (byte)i);
/* 470 */           this.slots[i].func_77955_b(itemCompound);
/* 471 */           itemList.func_74742_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 475 */       compound.func_74782_a("ModItems", itemList);
/*     */       
/* 477 */       if (func_145818_k_()) {
/* 478 */         compound.func_74778_a("CustomName", this.customName);
/*     */       }
/*     */       
/*     */ 
/* 482 */       NBTTagCompound tankCompound = new NBTTagCompound();
/* 483 */       this.tank.writeToNBT(tankCompound);
/* 484 */       compound.func_74782_a("tank", tankCompound);
/*     */     }
/*     */     
/*     */ 
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 490 */       NBTTagCompound compound = new NBTTagCompound();
/* 491 */       func_145841_b(compound);
/* 492 */       if (!func_145818_k_()) {
/* 493 */         compound.func_74778_a("CustomName", "");
/*     */       }
/* 495 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 500 */       super.onDataPacket(net, packet);
/* 501 */       func_145839_a(packet.func_148857_g());
/* 502 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */     public net.minecraft.util.AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 508 */       return super.getRenderBoundingBox();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 513 */     private static int[] OUTPUT_SLOTS = { 0 };
/* 514 */     private static int[] OTHER_SLOTS = { 1 };
/*     */     
/*     */     public int[] func_180463_a(EnumFacing side)
/*     */     {
/* 518 */       if (side == EnumFacing.DOWN) {
/* 519 */         return OUTPUT_SLOTS;
/*     */       }
/* 521 */       return OTHER_SLOTS;
/*     */     }
/*     */     
/*     */     public boolean func_180462_a(int slot, ItemStack itemStackIn, EnumFacing direction)
/*     */     {
/* 526 */       return (slot == 1) && (itemStackIn != null) && (func_94041_b(slot, itemStackIn));
/*     */     }
/*     */     
/*     */     public boolean func_180461_b(int slot, ItemStack stack, EnumFacing face)
/*     */     {
/* 531 */       if ((face == EnumFacing.DOWN) && (slot == 0) && (this.slots[0] != null)) {
/* 532 */         return true;
/*     */       }
/*     */       
/* 535 */       if ((face != EnumFacing.DOWN) && (this.slots[1] != null) && (stack != null) && ((stack.func_77973_b() instanceof IMold))) {
/* 536 */         return true;
/*     */       }
/* 538 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 543 */     private FluidTank tank = new FluidTank(1000);
/*     */     
/*     */ 
/*     */     public int fill(EnumFacing from, FluidStack resource, boolean doFill)
/*     */     {
/* 548 */       if (resource == null)
/* 549 */         return 0;
/* 550 */       if (this.tank.getFluidAmount() == this.tank.getCapacity())
/* 551 */         return 0;
/* 552 */       if ((this.tank.getFluidAmount() != 0) && (resource.getFluid() != this.tank.getFluid().getFluid())) {
/* 553 */         return 0;
/*     */       }
/* 555 */       int quantity = this.tank.fill(resource, doFill);
/* 556 */       if ((doFill) && (quantity > 0) && 
/* 557 */         (!this.field_145850_b.field_72995_K)) {
/* 558 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 559 */         this.field_145850_b.func_175685_c(this.field_174879_c, this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c());
/*     */       }
/*     */       
/* 562 */       return quantity;
/*     */     }
/*     */     
/*     */ 
/*     */     public FluidStack drain(EnumFacing from, FluidStack resource, boolean doDrain)
/*     */     {
/* 568 */       if (resource == null) {
/* 569 */         return null;
/*     */       }
/* 571 */       return drain(from, resource.amount, doDrain);
/*     */     }
/*     */     
/*     */ 
/*     */     public FluidStack drain(EnumFacing from, int maxDrain, boolean doDrain)
/*     */     {
/* 577 */       FluidStack drained = this.tank.drain(maxDrain, doDrain);
/* 578 */       if ((drained != null) && (drained.amount > 0) && (doDrain) && 
/* 579 */         (!this.field_145850_b.field_72995_K)) {
/* 580 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 581 */         this.field_145850_b.func_175685_c(this.field_174879_c, this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c());
/*     */       }
/*     */       
/* 584 */       return drained;
/*     */     }
/*     */     
/*     */     public boolean canFill(EnumFacing from, Fluid fluid)
/*     */     {
/* 589 */       return this.tank.getFluidAmount() == 0;
/*     */     }
/*     */     
/*     */     public boolean canDrain(EnumFacing from, Fluid fluid)
/*     */     {
/* 594 */       return (this.tank.getFluidAmount() == this.tank.getCapacity()) && (fluid == this.tank.getFluid().getFluid());
/*     */     }
/*     */     
/*     */     public FluidTankInfo[] getTankInfo(EnumFacing from)
/*     */     {
/* 599 */       return new FluidTankInfo[] { this.tank.getInfo() };
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockBlowMold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */