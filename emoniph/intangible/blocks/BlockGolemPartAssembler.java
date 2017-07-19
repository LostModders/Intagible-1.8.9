/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IBookPageResources;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.ISoulForge;
/*     */ import emoniph.intangible.api.ISoulForgeClient;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.knowledge.PageResources;
/*     */ import emoniph.intangible.recipes.GolemPartRecipe;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryHelper;
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
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.items.CapabilityItemHandler;
/*     */ import net.minecraftforge.items.IItemHandler;
/*     */ import net.minecraftforge.items.wrapper.SidedInvWrapper;
/*     */ 
/*     */ public class BlockGolemPartAssembler extends BlockContainer implements IBlock, ISoulForgeClient, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   BlockGolemPartAssembler()
/*     */   {
/*  48 */     super(Material.field_151573_f);
/*  49 */     func_149711_c(5.0F);
/*  50 */     func_149672_a(field_149777_j);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  55 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  76 */     return new TileEntityGolemPartAssembler();
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  81 */     TileEntity tileentity = worldIn.func_175625_s(pos);
/*     */     
/*  83 */     if ((tileentity instanceof IInventory)) {
/*  84 */       InventoryHelper.func_180175_a(worldIn, pos, (IInventory)tileentity);
/*  85 */       worldIn.func_175666_e(pos, this);
/*     */     }
/*     */     
/*  88 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/*  94 */     if (worldIn.field_72995_K) {
/*  95 */       return true;
/*     */     }
/*  97 */     TileEntityGolemPartAssembler stamper = (TileEntityGolemPartAssembler)BlockUtil.getTileEntity(worldIn, pos, TileEntityGolemPartAssembler.class);
/*  98 */     if ((stamper != null) && (side != EnumFacing.DOWN)) {
/*  99 */       if (side == EnumFacing.UP) {
/* 100 */         int slot = 0;
/* 101 */         ItemStack stack = stamper.func_70301_a(slot);
/* 102 */         if (stack != null) {
/* 103 */           ItemStack heldStack = playerIn.func_70694_bm();
/* 104 */           if ((heldStack != null) && (ItemStack.func_179545_c(stack, heldStack)) && (ItemStack.func_77970_a(stack, heldStack))) {
/* 105 */             if (stack.field_77994_a < stack.func_77976_d()) {
/* 106 */               int transfer = Math.min(stack.func_77976_d() - stack.field_77994_a, heldStack.field_77994_a);
/* 107 */               stack.field_77994_a += transfer;
/* 108 */               heldStack.field_77994_a -= transfer;
/* 109 */               worldIn.func_175689_h(pos);
/*     */             }
/*     */           } else {
/* 112 */             worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.field_70131_O * 0.5D, playerIn.field_70161_v, stack));
/*     */             
/* 114 */             stamper.func_70299_a(slot, null);
/*     */           }
/*     */         }
/*     */       } else {
/* 118 */         int slot = side.func_176736_b() + 1;
/* 119 */         ItemStack stack = stamper.func_70301_a(slot);
/* 120 */         if (stack != null) {
/* 121 */           ItemStack heldStack = playerIn.func_70694_bm();
/* 122 */           if ((heldStack != null) && (ItemStack.func_179545_c(stack, heldStack)) && (ItemStack.func_77970_a(stack, heldStack))) {
/* 123 */             if (stack.field_77994_a < stack.func_77976_d()) {
/* 124 */               int transfer = Math.min(stack.func_77976_d() - stack.field_77994_a, heldStack.field_77994_a);
/* 125 */               stack.field_77994_a += transfer;
/* 126 */               heldStack.field_77994_a -= transfer;
/* 127 */               worldIn.func_175689_h(pos);
/*     */             }
/*     */           } else {
/* 130 */             worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.field_70131_O * 0.5D, playerIn.field_70161_v, stack));
/*     */             
/* 132 */             stamper.func_70299_a(slot, null);
/*     */           }
/*     */         } else {
/* 135 */           stack = playerIn.func_70694_bm();
/* 136 */           if (stack != null) {
/* 137 */             stamper.func_70299_a(slot, stack.func_77979_a(1));
/* 138 */             if (stack.field_77994_a == 0) {
/* 139 */               playerIn.func_70062_b(0, null);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 144 */       return true;
/*     */     }
/* 146 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_149740_M()
/*     */   {
/* 152 */     return true;
/*     */   }
/*     */   
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/* 157 */     TileEntityGolemPartAssembler tile = (TileEntityGolemPartAssembler)BlockUtil.getTileEntity(worldIn, pos, TileEntityGolemPartAssembler.class);
/* 158 */     if (tile != null) {
/* 159 */       if (tile.func_70301_a(0) != null) {
/* 160 */         return 15;
/*     */       }
/* 162 */       int count = 0;
/* 163 */       for (int i = 1; i < tile.func_70302_i_(); i++) {
/* 164 */         if (tile.func_70301_a(i) != null) {
/* 165 */           count++;
/*     */         }
/*     */       }
/* 168 */       return count * 3;
/*     */     }
/*     */     
/* 171 */     return 0;
/*     */   }
/*     */   
/*     */   public boolean isForgeClientValid(World world, BlockPos pos, IBlockState state, ISoulForge forge)
/*     */   {
/* 176 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isForgeClientActive(World world, BlockPos pos, IBlockState state, ISoulForge forge)
/*     */   {
/* 181 */     TileEntityGolemPartAssembler tile = (TileEntityGolemPartAssembler)BlockUtil.getTileEntity(world, pos, TileEntityGolemPartAssembler.class);
/* 182 */     if (tile != null) {
/* 183 */       return (tile.assembleTime == 0) && (tile.getValidRecipe() != null);
/*     */     }
/* 185 */     return false;
/*     */   }
/*     */   
/*     */   public boolean forgeClientTick(World world, BlockPos pos, IBlockState state, ISoulForge forge)
/*     */   {
/* 190 */     TileEntityGolemPartAssembler tile = (TileEntityGolemPartAssembler)BlockUtil.getTileEntity(world, pos, TileEntityGolemPartAssembler.class);
/* 191 */     if ((tile != null) && 
/* 192 */       (forge.requestSoulsForWork(new SoulSet().add(SoulType.MALLEABLE, 1), 200, world, pos))) {
/* 193 */       tile.powered = true;
/* 194 */       tile.assembleTime = 1;
/* 195 */       world.func_175689_h(pos);
/* 196 */       return true;
/*     */     }
/*     */     
/* 199 */     return false;
/*     */   }
/*     */   
/*     */   public List<IBookPageResources> getBookResourcePageIds()
/*     */   {
/* 204 */     List<IBookPageResources> list = new ArrayList();
/* 205 */     list.add(new PageResources(func_149739_a().substring(5), func_149739_a() + ".name", func_149739_a() + ".soulforge", null, new IKnol[0]).setUsedSouls(new SoulSet().add(SoulType.MALLEABLE, 1)));
/* 206 */     return list;
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 211 */     return 67;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class TileEntityGolemPartAssembler
/*     */     extends TileEntity
/*     */     implements net.minecraft.inventory.ISidedInventory, net.minecraft.util.ITickable
/*     */   {
/*     */     public static final int SLOT_OUTPUT = 0;
/*     */     
/*     */     public static final int TOTAL_ASSEMBLE_TIME = 200;
/* 222 */     private static final int[] SLOTS_NONE = new int[0];
/* 223 */     private static final int[] SLOTS_OUTPUT = { 0 };
/* 224 */     private static final int[][] SLOTS_INPUT = { { 1 }, { 2 }, { 3 }, { 4 } };
/*     */     
/* 226 */     private final IItemHandler downSideHandler = new SidedInvWrapper(this, EnumFacing.DOWN);
/* 227 */     private final IItemHandler otherSideHandler = new SidedInvWrapper(this, EnumFacing.UP);
/* 228 */     private final IItemHandler nSideHandler = new SidedInvWrapper(this, EnumFacing.NORTH);
/* 229 */     private final IItemHandler sSideHandler = new SidedInvWrapper(this, EnumFacing.SOUTH);
/* 230 */     private final IItemHandler eSideHandler = new SidedInvWrapper(this, EnumFacing.EAST);
/* 231 */     private final IItemHandler wSideHandler = new SidedInvWrapper(this, EnumFacing.WEST);
/*     */     
/*     */     private String customName;
/* 234 */     private ItemStack[] slots = new ItemStack[5];
/*     */     private int assembleTime;
/*     */     private boolean powered;
/*     */     
/*     */     public net.minecraft.util.IChatComponent func_145748_c_()
/*     */     {
/* 240 */       return func_145818_k_() ? new net.minecraft.util.ChatComponentText(func_70005_c_()) : new net.minecraft.util.ChatComponentTranslation(func_70005_c_(), new Object[0]);
/*     */     }
/*     */     
/*     */     private GolemPartRecipe getValidRecipe() {
/* 244 */       GolemPartRecipe recipe = null;
/* 245 */       if ((this.slots[1] != null) && (this.slots[2] != null) && (this.slots[3] != null) && (this.slots[4] != null)) {
/* 246 */         ItemStack[] slotStacks = { this.slots[1], this.slots[2], this.slots[3], this.slots[4] };
/* 247 */         Get.recipes();recipe = emoniph.intangible.recipes.ModRecipes.golemParts.getRecipeFor(slotStacks);
/* 248 */         if ((this.slots[0] != null) && (recipe != null) && (
/* 249 */           (!ItemStack.func_179545_c(this.slots[0], recipe.getOutput())) || (this.slots[0].field_77994_a + recipe.getOutput().field_77994_a >= this.slots[0].func_77976_d()))) {
/* 250 */           recipe = null;
/*     */         }
/*     */       }
/*     */       
/* 254 */       return recipe;
/*     */     }
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 259 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 260 */       if (state.func_177230_c() != Get.blocks().GOLEM_PART_ASSEMBLER) {
/* 261 */         return;
/*     */       }
/*     */       
/* 264 */       if (this.assembleTime > 0) {
/* 265 */         GolemPartRecipe recipe = getValidRecipe();
/* 266 */         if (recipe == null) {
/* 267 */           this.assembleTime -= 1;
/* 268 */           if ((!this.field_145850_b.field_72995_K) && 
/* 269 */             (this.powered)) {
/* 270 */             this.powered = false;
/* 271 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/*     */           
/*     */         }
/* 275 */         else if (this.powered) {
/* 276 */           if ((++this.assembleTime >= 200) && 
/* 277 */             (!this.field_145850_b.field_72995_K)) {
/* 278 */             this.powered = false;
/* 279 */             if (this.slots[0] == null) {
/* 280 */               this.slots[0] = recipe.getOutput().func_77946_l();
/*     */             } else {
/* 282 */               this.slots[0].field_77994_a += recipe.getOutput().field_77994_a;
/*     */             }
/* 284 */             ItemStack[] slotStacks = { this.slots[1], this.slots[2], this.slots[3], this.slots[4] };
/* 285 */             if (recipe.decreaseStacks(slotStacks)) {
/* 286 */               for (int i = 1; i < this.slots.length; i++) {
/* 287 */                 if ((this.slots[i] != null) && (this.slots[i].field_77994_a == 0)) {
/* 288 */                   this.slots[i] = null;
/*     */                 }
/*     */               }
/*     */             }
/* 292 */             if (!BlockUtil.isSoundDampned(this.field_145850_b, this.field_174879_c)) {
/* 293 */               Sound.MOD_RANDOM_CLUNK.playToAllNear(this, 0.5F, 1.0F);
/*     */             }
/* 295 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/*     */         }
/*     */         else {
/* 299 */           this.assembleTime -= 1;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public int func_70302_i_()
/*     */     {
/* 307 */       return this.slots.length;
/*     */     }
/*     */     
/*     */     public ItemStack func_70301_a(int slot)
/*     */     {
/* 312 */       ItemStack result = this.slots[slot];
/* 313 */       return result;
/*     */     }
/*     */     
/*     */     public ItemStack func_70298_a(int index, int count)
/*     */     {
/* 318 */       if (this.slots[index] != null)
/*     */       {
/*     */ 
/* 321 */         if (this.slots[index].field_77994_a <= count) {
/* 322 */           ItemStack itemstack = this.slots[index];
/* 323 */           this.slots[index] = null;
/* 324 */           func_70296_d();
/* 325 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/* 326 */           return itemstack;
/*     */         }
/* 328 */         ItemStack itemstack = this.slots[index].func_77979_a(count);
/*     */         
/* 330 */         if (this.slots[index].field_77994_a == 0) {
/* 331 */           this.slots[index] = null;
/*     */         }
/*     */         
/* 334 */         func_70296_d();
/* 335 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 336 */         return itemstack;
/*     */       }
/*     */       
/* 339 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack func_70304_b(int index)
/*     */     {
/* 345 */       if (this.slots[index] != null) {
/* 346 */         ItemStack itemstack = this.slots[index];
/* 347 */         this.slots[index] = null;
/* 348 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 349 */         return itemstack;
/*     */       }
/* 351 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70299_a(int index, ItemStack stack)
/*     */     {
/* 357 */       this.slots[index] = stack;
/*     */       
/* 359 */       if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/* 360 */         stack.field_77994_a = func_70297_j_();
/*     */       }
/*     */       
/* 363 */       func_70296_d();
/* 364 */       this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */     }
/*     */     
/*     */     public int func_70297_j_()
/*     */     {
/* 369 */       return 64;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean func_70300_a(EntityPlayer player)
/*     */     {
/* 375 */       return (this.field_145850_b.func_175625_s(this.field_174879_c) == this) && (player.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 0.5D, this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D);
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
/* 390 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_174885_b(int id, int value) {}
/*     */     
/*     */ 
/*     */     public int func_174890_g()
/*     */     {
/* 399 */       return 0;
/*     */     }
/*     */     
/*     */     public void func_174888_l()
/*     */     {
/* 404 */       for (int i = 0; i < this.slots.length; i++) {
/* 405 */         this.slots[i] = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public String func_70005_c_()
/*     */     {
/* 411 */       return func_145818_k_() ? this.customName : "";
/*     */     }
/*     */     
/*     */     public void setCustomName(String name) {
/* 415 */       this.customName = name;
/* 416 */       if (!this.field_145850_b.field_72995_K) {
/* 417 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean func_145818_k_()
/*     */     {
/* 423 */       return (this.customName != null) && (!this.customName.isEmpty());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound) {
/* 427 */       super.func_145839_a(compound);
/* 428 */       NBTTagList itemList = compound.func_150295_c("ModItems", 10);
/* 429 */       this.slots = new ItemStack[func_70302_i_()];
/*     */       
/* 431 */       if (compound.func_150297_b("CustomName", 8)) {
/* 432 */         this.customName = compound.func_74779_i("CustomName");
/*     */       }
/*     */       
/* 435 */       for (int i = 0; i < itemList.func_74745_c(); i++) {
/* 436 */         NBTTagCompound itemCompound = itemList.func_150305_b(i);
/* 437 */         int j = itemCompound.func_74771_c("Slot") & 0xFF;
/*     */         
/* 439 */         if ((j >= 0) && (j < this.slots.length)) {
/* 440 */           this.slots[j] = ItemStack.func_77949_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 444 */       this.assembleTime = compound.func_74762_e("assembleTime");
/* 445 */       this.powered = compound.func_74767_n("powered");
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound) {
/* 449 */       super.func_145841_b(compound);
/* 450 */       NBTTagList itemList = new NBTTagList();
/*     */       
/* 452 */       for (int i = 0; i < this.slots.length; i++) {
/* 453 */         if (this.slots[i] != null) {
/* 454 */           NBTTagCompound itemCompound = new NBTTagCompound();
/* 455 */           itemCompound.func_74774_a("Slot", (byte)i);
/* 456 */           this.slots[i].func_77955_b(itemCompound);
/* 457 */           itemList.func_74742_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 461 */       compound.func_74782_a("ModItems", itemList);
/*     */       
/* 463 */       if (func_145818_k_()) {
/* 464 */         compound.func_74778_a("CustomName", this.customName);
/*     */       }
/*     */       
/* 467 */       compound.func_74768_a("assembleTime", this.assembleTime);
/* 468 */       compound.func_74757_a("powered", this.powered);
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 473 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public Packet func_145844_m()
/*     */     {
/* 478 */       NBTTagCompound compound = new NBTTagCompound();
/* 479 */       func_145841_b(compound);
/* 480 */       if (!func_145818_k_()) {
/* 481 */         compound.func_74778_a("CustomName", "");
/*     */       }
/*     */       
/* 484 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 489 */       super.onDataPacket(net, packet);
/* 490 */       func_145839_a(packet.func_148857_g());
/* 491 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 497 */       return new AxisAlignedBB(this.field_174879_c, this.field_174879_c.func_177982_a(1, 1, 1));
/*     */     }
/*     */     
/*     */     public int[] func_180463_a(EnumFacing side)
/*     */     {
/* 502 */       if (side == EnumFacing.UP)
/* 503 */         return SLOTS_NONE;
/* 504 */       if (side == EnumFacing.DOWN) {
/* 505 */         return SLOTS_OUTPUT;
/*     */       }
/* 507 */       return SLOTS_INPUT[side.func_176736_b()];
/*     */     }
/*     */     
/*     */ 
/*     */     public <T> T getCapability(Capability<T> capability, EnumFacing facing)
/*     */     {
/* 513 */       if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
/* 514 */         switch (BlockGolemPartAssembler.1.$SwitchMap$net$minecraft$util$EnumFacing[facing.ordinal()]) {
/*     */         case 1: 
/* 516 */           return this.downSideHandler;
/*     */         case 2: 
/* 518 */           return this.nSideHandler;
/*     */         case 3: 
/* 520 */           return this.sSideHandler;
/*     */         case 4: 
/* 522 */           return this.eSideHandler;
/*     */         case 5: 
/* 524 */           return this.wSideHandler;
/*     */         }
/* 526 */         return this.otherSideHandler;
/*     */       }
/*     */       
/* 529 */       return (T)super.getCapability(capability, facing);
/*     */     }
/*     */     
/*     */     public boolean hasCapability(Capability<?> capability, EnumFacing facing)
/*     */     {
/* 534 */       return (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) || (super.hasCapability(capability, facing));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean func_180462_a(int slot, ItemStack stackIn, EnumFacing direction)
/*     */     {
/* 541 */       return (this.slots[slot] == null) || ((ItemStack.func_179545_c(this.slots[slot], stackIn)) && (this.slots[slot].func_77976_d() > this.slots[slot].field_77994_a + stackIn.field_77994_a));
/*     */     }
/*     */     
/*     */     public boolean func_180461_b(int slot, ItemStack stackIn, EnumFacing direction)
/*     */     {
/* 546 */       return slot == 0;
/*     */     }
/*     */     
/*     */     public boolean func_94041_b(int slot, ItemStack stack)
/*     */     {
/* 551 */       return true;
/*     */     }
/*     */     
/*     */     public int getAssembleTime() {
/* 555 */       return this.assembleTime;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockGolemPartAssembler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */