/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.api.IInventoryItem;
/*     */ import emoniph.intangible.api.ISoulForge;
/*     */ import emoniph.intangible.api.ISoulForgeClient;
/*     */ import emoniph.intangible.api.ISoulForgeItemSource;
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.InventoryItem;
/*     */ import emoniph.intangible.util.InventoryItem.Empty;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryHelper;
/*     */ import net.minecraft.inventory.InventoryLargeChest;
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
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.ILockableContainer;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockPlinth
/*     */   extends BlockContainer implements IBlock, ISoulForgeItemSource, ICreativeSort
/*     */ {
/*     */   BlockPlinth()
/*     */   {
/*  46 */     super(Material.field_151576_e);
/*  47 */     func_149711_c(5.0F);
/*  48 */     func_149672_a(field_149769_e);
/*  49 */     float inset = 0.15625F;
/*  50 */     func_149676_a(inset, 0.0F, inset, 1.0F - inset, 0.8125F, 1.0F - inset);
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/*  67 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  82 */     return new TileEntityPlinth();
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  87 */     TileEntity tileentity = worldIn.func_175625_s(pos);
/*     */     
/*  89 */     if ((tileentity instanceof IInventory)) {
/*  90 */       InventoryHelper.func_180175_a(worldIn, pos, (IInventory)tileentity);
/*  91 */       worldIn.func_175666_e(pos, this);
/*     */     }
/*     */     
/*  94 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 101 */     if (worldIn.field_72995_K) {
/* 102 */       return true;
/*     */     }
/* 104 */     ILockableContainer container = getLockableContainer(worldIn, pos);
/* 105 */     if (container != null) {
/* 106 */       ItemStack stack = container.func_70301_a(0);
/* 107 */       if (stack != null) {
/* 108 */         ItemStack heldStack = playerIn.func_70694_bm();
/* 109 */         if ((heldStack == null) || (!ItemStack.func_179545_c(heldStack, stack)) || (!ItemStack.func_77970_a(heldStack, stack))) {
/* 110 */           container.func_70299_a(0, null);
/* 111 */           worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.func_70047_e(), playerIn.field_70161_v, stack));
/*     */         } else {
/* 113 */           int spaceLeft = stack.func_77976_d() - stack.field_77994_a;
/* 114 */           if (spaceLeft > 0) {
/* 115 */             if (((playerIn.func_70093_af()) && (heldStack.field_77994_a <= spaceLeft)) || (heldStack.field_77994_a == 1)) {
/* 116 */               stack.field_77994_a += heldStack.field_77994_a;
/* 117 */               playerIn.func_70062_b(0, null);
/* 118 */               worldIn.func_175689_h(pos);
/*     */             } else {
/* 120 */               stack.field_77994_a += 1;
/* 121 */               heldStack.func_77979_a(1);
/* 122 */               worldIn.func_175689_h(pos);
/*     */             }
/*     */           }
/*     */         }
/*     */       } else {
/* 127 */         ItemStack heldStack = playerIn.func_70694_bm();
/* 128 */         if (heldStack != null) {
/* 129 */           if ((playerIn.func_70093_af()) || (heldStack.field_77994_a == 1)) {
/* 130 */             container.func_70299_a(0, heldStack);
/* 131 */             playerIn.func_70062_b(0, null);
/*     */           } else {
/* 133 */             ItemStack newStack = heldStack.func_77979_a(1);
/* 134 */             container.func_70299_a(0, newStack);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 140 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/* 146 */     return Container.func_94526_b(getLockableContainer(worldIn, pos));
/*     */   }
/*     */   
/*     */   public ILockableContainer getLockableContainer(World worldIn, BlockPos pos) {
/* 150 */     TileEntityPlinth plinth = (TileEntityPlinth)BlockUtil.getTileEntity(worldIn, pos, TileEntityPlinth.class);
/* 151 */     if (plinth != null) {
/* 152 */       return new InventoryLargeChest("", plinth, plinth);
/*     */     }
/*     */     
/* 155 */     return null;
/*     */   }
/*     */   
/*     */   public IInventoryItem getSoulForgeItemStack(World world, BlockPos pos, ISoulForgeClient forgeClient, BlockPos forgeClientPos, ISoulForge forge, boolean remove)
/*     */   {
/* 160 */     TileEntityPlinth tile = (TileEntityPlinth)BlockUtil.getTileEntity(world, pos, TileEntityPlinth.class);
/* 161 */     if (tile != null) {
/* 162 */       return new InventoryItem(tile, 0);
/*     */     }
/* 164 */     return new InventoryItem.Empty();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 170 */     return 66;
/*     */   }
/*     */   
/*     */   public static class TileEntityPlinth extends TileEntityLockable
/*     */   {
/*     */     private String customName;
/* 176 */     private ItemStack[] slots = new ItemStack[1];
/*     */     
/*     */     public Container func_174876_a(InventoryPlayer playerInventory, EntityPlayer playerIn)
/*     */     {
/* 180 */       return null;
/*     */     }
/*     */     
/*     */     public String func_174875_k()
/*     */     {
/* 185 */       return null;
/*     */     }
/*     */     
/*     */     public int func_70302_i_()
/*     */     {
/* 190 */       return this.slots.length;
/*     */     }
/*     */     
/*     */     public ItemStack func_70301_a(int index)
/*     */     {
/* 195 */       return this.slots[index];
/*     */     }
/*     */     
/*     */     public ItemStack func_70298_a(int index, int count)
/*     */     {
/* 200 */       if (this.slots[index] != null)
/*     */       {
/*     */ 
/* 203 */         if (this.slots[index].field_77994_a <= count) {
/* 204 */           ItemStack itemstack = this.slots[index];
/* 205 */           this.slots[index] = null;
/* 206 */           func_70296_d();
/* 207 */           return itemstack;
/*     */         }
/* 209 */         ItemStack itemstack = this.slots[index].func_77979_a(count);
/*     */         
/* 211 */         if (this.slots[index].field_77994_a == 0) {
/* 212 */           this.slots[index] = null;
/*     */         }
/*     */         
/* 215 */         func_70296_d();
/* 216 */         return itemstack;
/*     */       }
/*     */       
/* 219 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack func_70304_b(int index)
/*     */     {
/* 225 */       if (this.slots[index] != null) {
/* 226 */         ItemStack itemstack = this.slots[index];
/* 227 */         this.slots[index] = null;
/* 228 */         return itemstack;
/*     */       }
/* 230 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70299_a(int index, ItemStack stack)
/*     */     {
/* 236 */       this.slots[index] = stack;
/*     */       
/* 238 */       if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/* 239 */         stack.field_77994_a = func_70297_j_();
/*     */       }
/*     */       
/* 242 */       func_70296_d();
/* 243 */       this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */     }
/*     */     
/*     */     public int func_70297_j_()
/*     */     {
/* 248 */       return 64;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean func_70300_a(EntityPlayer player)
/*     */     {
/* 254 */       return (this.field_145850_b.func_175625_s(this.field_174879_c) == this) && (player.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 0.5D, this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D);
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
/*     */     public void func_70296_d()
/*     */     {
/* 269 */       super.func_70296_d();
/* 270 */       this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */     }
/*     */     
/*     */     public boolean func_94041_b(int index, ItemStack stack)
/*     */     {
/* 275 */       return true;
/*     */     }
/*     */     
/*     */     public int func_174887_a_(int id)
/*     */     {
/* 280 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_174885_b(int id, int value) {}
/*     */     
/*     */ 
/*     */     public int func_174890_g()
/*     */     {
/* 289 */       return 0;
/*     */     }
/*     */     
/*     */     public void func_174888_l()
/*     */     {
/* 294 */       for (int i = 0; i < this.slots.length; i++) {
/* 295 */         this.slots[i] = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public String func_70005_c_()
/*     */     {
/* 301 */       return func_145818_k_() ? this.customName : "";
/*     */     }
/*     */     
/*     */     public void setCustomName(String name) {
/* 305 */       this.customName = name;
/* 306 */       if (!this.field_145850_b.field_72995_K) {
/* 307 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean func_145818_k_()
/*     */     {
/* 313 */       return (this.customName != null) && (!this.customName.isEmpty());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound) {
/* 317 */       super.func_145839_a(compound);
/* 318 */       NBTTagList itemList = compound.func_150295_c("ModItems", 10);
/* 319 */       this.slots = new ItemStack[func_70302_i_()];
/*     */       
/* 321 */       if (compound.func_150297_b("CustomName", 8)) {
/* 322 */         this.customName = compound.func_74779_i("CustomName");
/*     */       }
/*     */       
/* 325 */       for (int i = 0; i < itemList.func_74745_c(); i++) {
/* 326 */         NBTTagCompound itemCompound = itemList.func_150305_b(i);
/* 327 */         int j = itemCompound.func_74771_c("Slot") & 0xFF;
/*     */         
/* 329 */         if ((j >= 0) && (j < this.slots.length)) {
/* 330 */           this.slots[j] = ItemStack.func_77949_a(itemCompound);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound) {
/* 336 */       super.func_145841_b(compound);
/* 337 */       NBTTagList itemList = new NBTTagList();
/*     */       
/* 339 */       for (int i = 0; i < this.slots.length; i++) {
/* 340 */         if (this.slots[i] != null) {
/* 341 */           NBTTagCompound itemCompound = new NBTTagCompound();
/* 342 */           itemCompound.func_74774_a("Slot", (byte)i);
/* 343 */           this.slots[i].func_77955_b(itemCompound);
/* 344 */           itemList.func_74742_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 348 */       compound.func_74782_a("ModItems", itemList);
/*     */       
/* 350 */       if (func_145818_k_()) {
/* 351 */         compound.func_74778_a("CustomName", this.customName);
/*     */       }
/*     */     }
/*     */     
/*     */     public Packet func_145844_m()
/*     */     {
/* 357 */       NBTTagCompound compound = new NBTTagCompound();
/* 358 */       func_145841_b(compound);
/* 359 */       if (!func_145818_k_()) {
/* 360 */         compound.func_74778_a("CustomName", "");
/*     */       }
/* 362 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 367 */       super.onDataPacket(net, packet);
/* 368 */       func_145839_a(packet.func_148857_g());
/* 369 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 375 */       AxisAlignedBB aabb = new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(1, 2, 1));
/* 376 */       return aabb;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockPlinth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */