/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockShrine.TileEntityShrine;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ItemShrine extends ItemBlock
/*     */ {
/*     */   public ItemShrine(Block blockType)
/*     */   {
/*  23 */     super(blockType);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack stack, int renderPass)
/*     */   {
/*  30 */     if (renderPass == 0) {
/*  31 */       NBTTagCompound compound = stack.func_77978_p();
/*  32 */       if ((compound != null) && (compound.func_150297_b("color", 3))) {
/*  33 */         return compound.func_74762_e("color");
/*     */       }
/*     */       
/*  36 */       return 16777215;
/*     */     }
/*  38 */     return super.func_82790_a(stack, renderPass);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/*  44 */     if ((worldIn.func_180495_p(pos).func_177230_c().func_176200_f(worldIn, pos)) && (side != EnumFacing.DOWN)) {
/*  45 */       side = EnumFacing.UP;
/*  46 */       pos = pos.func_177977_b();
/*     */     }
/*  48 */     if (side == EnumFacing.DOWN) {
/*  49 */       return false;
/*     */     }
/*  51 */     IBlockState iblockstate = worldIn.func_180495_p(pos);
/*  52 */     Block block = iblockstate.func_177230_c();
/*  53 */     boolean flag = block.func_176200_f(worldIn, pos);
/*     */     
/*  55 */     if (!flag) {
/*  56 */       if (!worldIn.isSideSolid(pos, side, true)) {
/*  57 */         return false;
/*     */       }
/*     */       
/*  60 */       pos = pos.func_177972_a(side);
/*     */     }
/*     */     
/*  63 */     if (!playerIn.func_175151_a(pos, side, stack))
/*  64 */       return false;
/*  65 */     if (!Get.blocks().SHRINE.func_176196_c(worldIn, pos)) {
/*  66 */       return false;
/*     */     }
/*  68 */     if (!worldIn.field_72995_K) {
/*  69 */       if (!Get.blocks().SHRINE.func_176198_a(worldIn, pos, side)) {
/*  70 */         return false;
/*     */       }
/*     */       
/*  73 */       worldIn.func_180501_a(pos, Get.blocks().SHRINE.func_176223_P(), 3);
/*  74 */       int i = 0;
/*     */       
/*  76 */       if (side == EnumFacing.UP) {
/*  77 */         i = MathHelper.func_76128_c(playerIn.field_70177_z * 16.0F / 360.0F + 0.5D) & 0xF;
/*     */       }
/*     */       
/*  80 */       BlockShrine.TileEntityShrine tile = (BlockShrine.TileEntityShrine)emoniph.intangible.util.BlockUtil.getTileEntity(worldIn, pos, BlockShrine.TileEntityShrine.class);
/*     */       
/*  82 */       if (tile != null) {
/*  83 */         if (stack.func_77942_o()) {
/*  84 */           tile.readItemFromNBT(stack.func_77978_p());
/*     */         }
/*     */         
/*  87 */         tile.setRotation(i);
/*     */       }
/*     */       
/*  90 */       stack.field_77994_a -= 1;
/*     */     }
/*     */     
/*  93 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_179222_a(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
/*     */   {
/* 100 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemShrine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */