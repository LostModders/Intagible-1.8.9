/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockDeityHammer;
/*    */ import emoniph.intangible.blocks.BlockDeityHammer.EnumPart;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemDeityHammer extends ItemBlock
/*    */ {
/*    */   public ItemDeityHammer(Block blockType)
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
/* 40 */     BlockPos blockpos2 = blockpos1.func_177984_a();
/* 41 */     BlockPos blockpos3 = blockpos2.func_177984_a();
/*    */     
/* 43 */     boolean flag1 = block.func_176200_f(worldIn, blockpos1);
/* 44 */     boolean flag2 = (worldIn.func_175623_d(pos)) || (flag);
/* 45 */     boolean flag3 = (worldIn.func_175623_d(blockpos1)) || (flag1);
/* 46 */     boolean flag4 = block.func_176200_f(worldIn, blockpos2);
/* 47 */     boolean flag5 = (worldIn.func_175623_d(blockpos2)) || (flag4);
/* 48 */     boolean flag6 = block.func_176200_f(worldIn, blockpos3);
/* 49 */     boolean flag7 = (worldIn.func_175623_d(blockpos3)) || (flag6);
/*    */     
/* 51 */     if ((playerIn.func_175151_a(pos, side, stack)) && (playerIn.func_175151_a(blockpos1, side, stack)) && (playerIn.func_175151_a(blockpos2, side, stack)) && (playerIn.func_175151_a(blockpos3, side, stack))) {
/* 52 */       if ((flag2) && (flag3) && (flag5) && (flag7) && (World.func_175683_a(worldIn, pos.func_177977_b()))) {
/* 53 */         int j = enumfacing1.func_176736_b();
/* 54 */         place(worldIn, pos, enumfacing1);
/* 55 */         stack.field_77994_a -= 1;
/* 56 */         return true;
/*    */       }
/* 58 */       return false;
/*    */     }
/*    */     
/* 61 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   public static void place(World worldIn, BlockPos pos, EnumFacing facing)
/*    */   {
/* 67 */     IBlockState state = emoniph.intangible.Get.blocks().DEITY_HAMMER.func_176223_P().func_177226_a(BlockDeityHammer.PART, BlockDeityHammer.EnumPart.BASE);
/*    */     
/* 69 */     if (worldIn.func_180501_a(pos, state, 3)) {
/* 70 */       worldIn.func_180501_a(pos.func_177984_a(), state.func_177226_a(BlockDeityHammer.PART, BlockDeityHammer.EnumPart.SHAFT1), 3);
/* 71 */       worldIn.func_180501_a(pos.func_177981_b(2), state.func_177226_a(BlockDeityHammer.PART, BlockDeityHammer.EnumPart.SHAFT2), 3);
/* 72 */       worldIn.func_180501_a(pos.func_177981_b(3), state.func_177226_a(BlockDeityHammer.PART, BlockDeityHammer.EnumPart.SHAFT3), 3);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemDeityHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */