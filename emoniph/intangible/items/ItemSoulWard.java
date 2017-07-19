/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockSoulWard;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockBed;
/*    */ import net.minecraft.block.BlockBed.EnumPartType;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemSoulWard extends ItemBlock
/*    */ {
/*    */   public ItemSoulWard(Block blockType)
/*    */   {
/* 19 */     super(blockType);
/*    */   }
/*    */   
/*    */   public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
/*    */   {
/* 24 */     if (worldIn.field_72995_K)
/* 25 */       return true;
/* 26 */     if (side != EnumFacing.UP) {
/* 27 */       return false;
/*    */     }
/* 29 */     IBlockState iblockstate = worldIn.func_180495_p(pos);
/* 30 */     Block block = iblockstate.func_177230_c();
/* 31 */     boolean flag = block.func_176200_f(worldIn, pos);
/*    */     
/* 33 */     if (!flag) {
/* 34 */       pos = pos.func_177984_a();
/*    */     }
/*    */     
/* 37 */     int i = net.minecraft.util.MathHelper.func_76128_c(playerIn.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/* 38 */     EnumFacing enumfacing1 = EnumFacing.func_176731_b(i);
/* 39 */     BlockPos blockpos1 = pos.func_177984_a();
/* 40 */     boolean flag1 = block.func_176200_f(worldIn, blockpos1);
/* 41 */     boolean flag2 = (worldIn.func_175623_d(pos)) || (flag);
/* 42 */     boolean flag3 = (worldIn.func_175623_d(blockpos1)) || (flag1);
/*    */     
/* 44 */     if ((playerIn.func_175151_a(pos, side, stack)) && (playerIn.func_175151_a(blockpos1, side, stack))) {
/* 45 */       if ((flag2) && (flag3) && (World.func_175683_a(worldIn, pos.func_177977_b()))) {
/* 46 */         int j = enumfacing1.func_176736_b();
/* 47 */         place(worldIn, pos, enumfacing1, false);
/* 48 */         stack.field_77994_a -= 1;
/* 49 */         return true;
/*    */       }
/* 51 */       return false;
/*    */     }
/*    */     
/* 54 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void place(World worldIn, BlockPos pos, EnumFacing facing, boolean multiBlock)
/*    */   {
/* 63 */     IBlockState stateFoot = emoniph.intangible.Get.blocks().SOUL_WARD.func_176223_P().func_177226_a(BlockBed.field_176387_N, facing).func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT).func_177226_a(BlockSoulWard.STRUCTURE, Boolean.valueOf(multiBlock));
/*    */     
/* 65 */     if (worldIn.func_180501_a(pos, stateFoot, 3)) {
/* 66 */       IBlockState stateHead = stateFoot.func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.HEAD);
/* 67 */       worldIn.func_180501_a(pos.func_177984_a(), stateHead, 3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemSoulWard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */