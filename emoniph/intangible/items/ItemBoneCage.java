/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockBed;
/*    */ import net.minecraft.block.BlockBed.EnumPartType;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemBoneCage extends net.minecraft.item.ItemBlock
/*    */ {
/*    */   public ItemBoneCage(Block blockType)
/*    */   {
/* 18 */     super(blockType);
/*    */   }
/*    */   
/*    */   public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
/*    */   {
/* 23 */     if (worldIn.field_72995_K)
/* 24 */       return true;
/* 25 */     if (side != EnumFacing.UP) {
/* 26 */       return false;
/*    */     }
/* 28 */     IBlockState iblockstate = worldIn.func_180495_p(pos);
/* 29 */     Block block = iblockstate.func_177230_c();
/* 30 */     boolean flag = block.func_176200_f(worldIn, pos);
/*    */     
/* 32 */     if (!flag) {
/* 33 */       pos = pos.func_177984_a();
/*    */     }
/*    */     
/* 36 */     int i = net.minecraft.util.MathHelper.func_76128_c(playerIn.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/* 37 */     EnumFacing enumfacing1 = EnumFacing.func_176731_b(i);
/* 38 */     BlockPos blockpos1 = pos.func_177984_a();
/* 39 */     boolean flag1 = block.func_176200_f(worldIn, blockpos1);
/* 40 */     boolean flag2 = (worldIn.func_175623_d(pos)) || (flag);
/* 41 */     boolean flag3 = (worldIn.func_175623_d(blockpos1)) || (flag1);
/*    */     
/* 43 */     if ((playerIn.func_175151_a(pos, side, stack)) && (playerIn.func_175151_a(blockpos1, side, stack))) {
/* 44 */       if ((flag2) && (flag3) && ((World.func_175683_a(worldIn, pos.func_177977_b())) || (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() == emoniph.intangible.Get.blocks().RECONSTRUCTOR))) {
/* 45 */         int j = enumfacing1.func_176736_b();
/* 46 */         place(worldIn, pos, enumfacing1);
/* 47 */         stack.field_77994_a -= 1;
/* 48 */         return true;
/*    */       }
/* 50 */       return false;
/*    */     }
/*    */     
/* 53 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public static void place(World worldIn, BlockPos pos, EnumFacing facing)
/*    */   {
/* 59 */     IBlockState iblockstate1 = emoniph.intangible.Get.blocks().BONE_CAGE.func_176223_P().func_177226_a(BlockBed.field_176387_N, facing).func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT);
/*    */     
/* 61 */     if (worldIn.func_180501_a(pos, iblockstate1, 3)) {
/* 62 */       IBlockState iblockstate2 = iblockstate1.func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.HEAD);
/* 63 */       worldIn.func_180501_a(pos.func_177984_a(), iblockstate2, 3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemBoneCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */