/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.Block.SoundType;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ItemGlass extends Item implements IItem, IMeltableItem
/*     */ {
/*     */   public final Block block;
/*     */   
/*     */   public ItemGlass()
/*     */   {
/*  29 */     this.block = Blocks.field_150359_w;
/*     */   }
/*     */   
/*     */   public int getMeltingTemperature() {
/*  33 */     return Get.fluids().MOLTEN_GLASS.getTemperature();
/*     */   }
/*     */   
/*     */   public Block getMoltenBlock() {
/*  37 */     return Get.blocks().MOLTEN_GLASS;
/*     */   }
/*     */   
/*     */   public boolean onEntityItemUpdate(EntityItem entity)
/*     */   {
/*  42 */     return MeltHandler.handleItemTick(entity, this);
/*     */   }
/*     */   
/*     */   public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
/*  46 */     IBlockState iblockstate = worldIn.func_180495_p(pos);
/*  47 */     Block block = iblockstate.func_177230_c();
/*     */     
/*  49 */     if ((block == Blocks.field_150431_aC) && (((Integer)iblockstate.func_177229_b(net.minecraft.block.BlockSnow.field_176315_a)).intValue() < 1)) {
/*  50 */       side = EnumFacing.UP;
/*  51 */     } else if (!block.func_176200_f(worldIn, pos)) {
/*  52 */       pos = pos.func_177972_a(side);
/*     */     }
/*     */     
/*  55 */     if (stack.field_77994_a == 0)
/*  56 */       return false;
/*  57 */     if (!playerIn.func_175151_a(pos, side, stack))
/*  58 */       return false;
/*  59 */     if ((pos.func_177956_o() == 255) && (this.block.func_149688_o().func_76220_a()))
/*  60 */       return false;
/*  61 */     if (worldIn.func_175716_a(this.block, pos, false, side, (Entity)null, stack)) {
/*  62 */       int i = func_77647_b(stack.func_77960_j());
/*  63 */       IBlockState iblockstate1 = this.block.func_180642_a(worldIn, pos, side, hitX, hitY, hitZ, i, playerIn);
/*     */       
/*  65 */       if (placeBlockAt(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ, iblockstate1)) {
/*  66 */         worldIn.func_72908_a(pos.func_177958_n() + 0.5F, pos.func_177956_o() + 0.5F, pos.func_177952_p() + 0.5F, this.block.field_149762_H.func_150496_b(), (this.block.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.block.field_149762_H.func_150494_d() * 0.8F);
/*  67 */         stack.field_77994_a -= 1;
/*     */       }
/*     */       
/*  70 */       return true;
/*     */     }
/*  72 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean setTileEntityNBT(World worldIn, BlockPos pos, ItemStack stack, EntityPlayer player)
/*     */   {
/*  77 */     if ((stack.func_77942_o()) && (stack.func_77978_p().func_150297_b("BlockEntityTag", 10))) {
/*  78 */       TileEntity tileentity = worldIn.func_175625_s(pos);
/*     */       
/*  80 */       if (tileentity != null)
/*     */       {
/*  82 */         MinecraftServer server = MinecraftServer.func_71276_C();
/*  83 */         if ((!worldIn.field_72995_K) && (tileentity.restrictNBTCopy()) && ((server == null) || 
/*  84 */           (server.func_71203_ab().func_152596_g(player.func_146103_bH()))))
/*  85 */           return false;
/*  86 */         NBTTagCompound nbttagcompound = new NBTTagCompound();
/*  87 */         NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttagcompound.func_74737_b();
/*  88 */         tileentity.func_145841_b(nbttagcompound);
/*  89 */         NBTTagCompound nbttagcompound2 = (NBTTagCompound)stack.func_77978_p().func_74781_a("BlockEntityTag");
/*  90 */         nbttagcompound.func_179237_a(nbttagcompound2);
/*  91 */         nbttagcompound.func_74768_a("x", pos.func_177958_n());
/*  92 */         nbttagcompound.func_74768_a("y", pos.func_177956_o());
/*  93 */         nbttagcompound.func_74768_a("z", pos.func_177952_p());
/*     */         
/*  95 */         if (!nbttagcompound.equals(nbttagcompound1)) {
/*  96 */           tileentity.func_145839_a(nbttagcompound);
/*  97 */           tileentity.func_70296_d();
/*  98 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean canPlaceBlockOnSide(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack) {
/* 108 */     Block block = worldIn.func_180495_p(pos).func_177230_c();
/*     */     
/* 110 */     if (block == Blocks.field_150431_aC) {
/* 111 */       side = EnumFacing.UP;
/* 112 */     } else if (!block.func_176200_f(worldIn, pos)) {
/* 113 */       pos = pos.func_177972_a(side);
/*     */     }
/*     */     
/* 116 */     return worldIn.func_175716_a(this.block, pos, false, side, (Entity)null, stack);
/*     */   }
/*     */   
/*     */   public String func_77667_c(ItemStack stack) {
/* 120 */     return this.block.func_149739_a();
/*     */   }
/*     */   
/*     */   public String func_77658_a() {
/* 124 */     return this.block.func_149739_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public CreativeTabs func_77640_w() {
/* 129 */     return this.block.func_149708_J();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item itemIn, CreativeTabs tab, java.util.List subItems) {
/* 134 */     this.block.func_149666_a(itemIn, tab, subItems);
/*     */   }
/*     */   
/*     */   public Block getBlock() {
/* 138 */     return this.block;
/*     */   }
/*     */   
/*     */   public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
/* 142 */     if (!world.func_180501_a(pos, newState, 3)) { return false;
/*     */     }
/* 144 */     IBlockState state = world.func_180495_p(pos);
/* 145 */     if (state.func_177230_c() == this.block) {
/* 146 */       setTileEntityNBT(world, pos, stack, player);
/* 147 */       this.block.func_180633_a(world, pos, state, player, stack);
/*     */     }
/*     */     
/* 150 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemGlass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */