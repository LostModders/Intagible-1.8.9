/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.api.IInventoryItem;
/*     */ import emoniph.intangible.api.ISoulForge;
/*     */ import emoniph.intangible.api.ISoulForgeClient;
/*     */ import emoniph.intangible.api.ISoulForgeItemSource;
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.InventoryItem.Empty;
/*     */ import emoniph.intangible.util.InventoryItem.ReadOnly;
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
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityLockable;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.ILockableContainer;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockOfferingPlate extends BlockContainer implements IBlock, ISoulForgeItemSource, ICreativeSort
/*     */ {
/*     */   BlockOfferingPlate()
/*     */   {
/*  41 */     super(Material.field_151573_f);
/*  42 */     func_149711_c(1.0F);
/*  43 */     func_149672_a(field_149777_j);
/*  44 */     func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 0.1F, 0.75F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  49 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  65 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  70 */     return new TileEntityOfferingPlate();
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  75 */     TileEntity tileentity = worldIn.func_175625_s(pos);
/*     */     
/*  77 */     if ((tileentity instanceof IInventory)) {
/*  78 */       InventoryHelper.func_180175_a(worldIn, pos, (IInventory)tileentity);
/*  79 */       worldIn.func_175666_e(pos, this);
/*     */     }
/*     */     
/*  82 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/*  87 */     if (worldIn.field_72995_K) {
/*  88 */       return true;
/*     */     }
/*  90 */     ILockableContainer container = getLockableContainer(worldIn, pos);
/*  91 */     if (container != null) {
/*  92 */       ItemStack stack = container.func_70301_a(0);
/*  93 */       if (stack != null) {
/*  94 */         for (EnumFacing facing : EnumFacing.field_176754_o)
/*     */         {
/*  96 */           BlockShrine.TileEntityShrine shrine = (BlockShrine.TileEntityShrine)BlockUtil.getTileEntity(worldIn, pos.func_177972_a(facing), BlockShrine.TileEntityShrine.class);
/*  97 */           if (shrine != null) {
/*  98 */             shrine.processTheftFrom(worldIn, pos, state, playerIn, stack);
/*     */           }
/*     */         }
/*     */         
/* 102 */         container.func_70299_a(0, null);
/* 103 */         worldIn.func_72838_d(new EntityItem(worldIn, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.func_70047_e(), playerIn.field_70161_v, stack));
/*     */       } else {
/* 105 */         stack = playerIn.func_70694_bm();
/* 106 */         if (stack != null) {
/* 107 */           if (stack.field_77994_a == 1) {
/* 108 */             container.func_70299_a(0, stack);
/* 109 */             playerIn.func_70062_b(0, null);
/*     */           } else {
/* 111 */             container.func_70299_a(0, stack.func_77979_a(1));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 117 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/* 123 */     return Container.func_94526_b(getLockableContainer(worldIn, pos));
/*     */   }
/*     */   
/*     */   public ILockableContainer getLockableContainer(World worldIn, BlockPos pos) {
/* 127 */     TileEntityOfferingPlate plinth = (TileEntityOfferingPlate)BlockUtil.getTileEntity(worldIn, pos, TileEntityOfferingPlate.class);
/* 128 */     if (plinth != null) {
/* 129 */       return new InventoryLargeChest("", plinth, plinth);
/*     */     }
/*     */     
/* 132 */     return null;
/*     */   }
/*     */   
/*     */   public IInventoryItem getSoulForgeItemStack(World world, BlockPos pos, ISoulForgeClient forgeClient, BlockPos forgeClientPos, ISoulForge forge, boolean remove)
/*     */   {
/* 137 */     TileEntityOfferingPlate tile = (TileEntityOfferingPlate)BlockUtil.getTileEntity(world, pos, TileEntityOfferingPlate.class);
/* 138 */     if (tile != null) {
/* 139 */       ItemStack templateStack = tile.func_70301_a(0);
/* 140 */       if (templateStack != null) {
/* 141 */         if (remove) {
/* 142 */           return forge.requestItemFromInventory(templateStack);
/*     */         }
/* 144 */         return new InventoryItem.ReadOnly(tile, 0);
/*     */       }
/*     */       
/* 147 */       return new InventoryItem.Empty();
/*     */     }
/*     */     
/* 150 */     return new InventoryItem.Empty();
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 156 */     return 82;
/*     */   }
/*     */   
/*     */   public static class TileEntityOfferingPlate extends TileEntityLockable
/*     */   {
/*     */     private String customName;
/* 162 */     private ItemStack[] slots = new ItemStack[1];
/*     */     
/*     */     public Container func_174876_a(InventoryPlayer playerInventory, EntityPlayer playerIn)
/*     */     {
/* 166 */       return null;
/*     */     }
/*     */     
/*     */     public String func_174875_k()
/*     */     {
/* 171 */       return null;
/*     */     }
/*     */     
/*     */     public int func_70302_i_()
/*     */     {
/* 176 */       return this.slots.length;
/*     */     }
/*     */     
/*     */     public ItemStack func_70301_a(int index)
/*     */     {
/* 181 */       return this.slots[index];
/*     */     }
/*     */     
/*     */     public ItemStack func_70298_a(int index, int count)
/*     */     {
/* 186 */       if (this.slots[index] != null)
/*     */       {
/*     */ 
/* 189 */         if (this.slots[index].field_77994_a <= count) {
/* 190 */           ItemStack itemstack = this.slots[index];
/* 191 */           this.slots[index] = null;
/* 192 */           func_70296_d();
/* 193 */           return itemstack;
/*     */         }
/* 195 */         ItemStack itemstack = this.slots[index].func_77979_a(count);
/*     */         
/* 197 */         if (this.slots[index].field_77994_a == 0) {
/* 198 */           this.slots[index] = null;
/*     */         }
/*     */         
/* 201 */         func_70296_d();
/* 202 */         return itemstack;
/*     */       }
/*     */       
/* 205 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack func_70304_b(int index)
/*     */     {
/* 211 */       if (this.slots[index] != null) {
/* 212 */         ItemStack itemstack = this.slots[index];
/* 213 */         this.slots[index] = null;
/* 214 */         return itemstack;
/*     */       }
/* 216 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70299_a(int index, ItemStack stack)
/*     */     {
/* 222 */       this.slots[index] = stack;
/*     */       
/* 224 */       if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/* 225 */         stack.field_77994_a = func_70297_j_();
/*     */       }
/*     */       
/* 228 */       func_70296_d();
/* 229 */       this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */     }
/*     */     
/*     */     public int func_70297_j_()
/*     */     {
/* 234 */       return 1;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean func_70300_a(EntityPlayer player)
/*     */     {
/* 240 */       return (this.field_145850_b.func_175625_s(this.field_174879_c) == this) && (player.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 0.5D, this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D);
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
/* 255 */       return true;
/*     */     }
/*     */     
/*     */     public int func_174887_a_(int id)
/*     */     {
/* 260 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_174885_b(int id, int value) {}
/*     */     
/*     */ 
/*     */     public int func_174890_g()
/*     */     {
/* 269 */       return 0;
/*     */     }
/*     */     
/*     */     public void func_174888_l()
/*     */     {
/* 274 */       for (int i = 0; i < this.slots.length; i++) {
/* 275 */         this.slots[i] = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public String func_70005_c_()
/*     */     {
/* 281 */       return func_145818_k_() ? this.customName : "intangible:container.offeringplate";
/*     */     }
/*     */     
/*     */     public boolean func_145818_k_()
/*     */     {
/* 286 */       return (this.customName != null) && (!this.customName.isEmpty());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound) {
/* 290 */       super.func_145839_a(compound);
/* 291 */       NBTTagList itemList = compound.func_150295_c("ModItems", 10);
/* 292 */       this.slots = new ItemStack[func_70302_i_()];
/*     */       
/* 294 */       if (compound.func_150297_b("CustomName", 8)) {
/* 295 */         this.customName = compound.func_74779_i("CustomName");
/*     */       }
/*     */       
/* 298 */       for (int i = 0; i < itemList.func_74745_c(); i++) {
/* 299 */         NBTTagCompound itemCompound = itemList.func_150305_b(i);
/* 300 */         int j = itemCompound.func_74771_c("Slot") & 0xFF;
/*     */         
/* 302 */         if ((j >= 0) && (j < this.slots.length)) {
/* 303 */           this.slots[j] = ItemStack.func_77949_a(itemCompound);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound) {
/* 309 */       super.func_145841_b(compound);
/* 310 */       NBTTagList itemList = new NBTTagList();
/*     */       
/* 312 */       for (int i = 0; i < this.slots.length; i++) {
/* 313 */         if (this.slots[i] != null) {
/* 314 */           NBTTagCompound itemCompound = new NBTTagCompound();
/* 315 */           itemCompound.func_74774_a("Slot", (byte)i);
/* 316 */           this.slots[i].func_77955_b(itemCompound);
/* 317 */           itemList.func_74742_a(itemCompound);
/*     */         }
/*     */       }
/*     */       
/* 321 */       compound.func_74782_a("ModItems", itemList);
/*     */       
/* 323 */       if (func_145818_k_()) {
/* 324 */         compound.func_74778_a("CustomName", this.customName);
/*     */       }
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 330 */       NBTTagCompound compound = new NBTTagCompound();
/* 331 */       func_145841_b(compound);
/* 332 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 337 */       super.onDataPacket(net, packet);
/* 338 */       func_145839_a(packet.func_148857_g());
/* 339 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockOfferingPlate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */