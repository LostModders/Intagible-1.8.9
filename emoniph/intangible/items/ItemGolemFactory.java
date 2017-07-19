/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockGolemFactory;
/*    */ import emoniph.intangible.blocks.BlockGolemFactory.EnumPart;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockDirectional;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemGolemFactory extends ItemBlock
/*    */ {
/*    */   public ItemGolemFactory(Block blockType)
/*    */   {
/* 20 */     super(blockType);
/*    */   }
/*    */   
/*    */   public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
/*    */   {
/* 25 */     if (worldIn.field_72995_K)
/* 26 */       return true;
/* 27 */     if (side != EnumFacing.UP) {
/* 28 */       return false;
/*    */     }
/* 30 */     IBlockState iblockstate = worldIn.func_180495_p(pos);
/* 31 */     Block block = iblockstate.func_177230_c();
/* 32 */     boolean flag = block.func_176200_f(worldIn, pos);
/*    */     
/* 34 */     if (!flag) {
/* 35 */       pos = pos.func_177984_a();
/*    */     }
/*    */     
/* 38 */     int i = net.minecraft.util.MathHelper.func_76128_c(playerIn.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/* 39 */     EnumFacing enumfacing1 = EnumFacing.func_176731_b(i);
/* 40 */     BlockPos blockpos1 = pos.func_177984_a();
/* 41 */     BlockPos blockpos2 = blockpos1.func_177984_a();
/*    */     
/* 43 */     boolean flag1 = block.func_176200_f(worldIn, blockpos1);
/* 44 */     boolean flag2 = (worldIn.func_175623_d(pos)) || (flag);
/* 45 */     boolean flag3 = (worldIn.func_175623_d(blockpos1)) || (flag1);
/* 46 */     boolean flag4 = block.func_176200_f(worldIn, blockpos2);
/* 47 */     boolean flag5 = (worldIn.func_175623_d(blockpos2)) || (flag4);
/*    */     
/* 49 */     if ((playerIn.func_175151_a(pos, side, stack)) && (playerIn.func_175151_a(blockpos1, side, stack)) && (playerIn.func_175151_a(blockpos2, side, stack))) {
/* 50 */       if ((flag2) && (flag3) && (flag5) && (World.func_175683_a(worldIn, pos.func_177977_b()))) {
/* 51 */         int j = enumfacing1.func_176736_b();
/* 52 */         place(worldIn, pos, enumfacing1);
/* 53 */         stack.field_77994_a -= 1;
/* 54 */         return true;
/*    */       }
/* 56 */       return false;
/*    */     }
/*    */     
/* 59 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public static void place(World worldIn, BlockPos pos, EnumFacing facing)
/*    */   {
/* 65 */     IBlockState state = emoniph.intangible.Get.blocks().GOLEM_FACTORY.func_176223_P().func_177226_a(BlockDirectional.field_176387_N, facing).func_177226_a(BlockGolemFactory.PART, BlockGolemFactory.EnumPart.BOTTOM);
/*    */     
/* 67 */     if (worldIn.func_180501_a(pos, state, 3)) {
/* 68 */       worldIn.func_180501_a(pos.func_177984_a(), state.func_177226_a(BlockGolemFactory.PART, BlockGolemFactory.EnumPart.MIDDLE), 3);
/* 69 */       worldIn.func_180501_a(pos.func_177984_a().func_177984_a(), state.func_177226_a(BlockGolemFactory.PART, BlockGolemFactory.EnumPart.TOP), 3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemGolemFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */