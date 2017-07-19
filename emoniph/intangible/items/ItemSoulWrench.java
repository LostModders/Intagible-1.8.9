/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.ModBlocks;
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
/*    */ public class ItemSoulWrench extends ItemBlock implements ICreativeSort
/*    */ {
/*    */   public ItemSoulWrench(Block blockType)
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
/* 38 */     BlockPos blockpos1 = pos.func_177984_a();
/* 39 */     boolean flag1 = block.func_176200_f(worldIn, blockpos1);
/* 40 */     boolean flag2 = (worldIn.func_175623_d(pos)) || (flag);
/* 41 */     boolean flag3 = (worldIn.func_175623_d(blockpos1)) || (flag1);
/*    */     
/* 43 */     if ((playerIn.func_175151_a(pos, side, stack)) && (playerIn.func_175151_a(blockpos1, side, stack))) {
/* 44 */       if ((flag2) && (flag3) && (World.func_175683_a(worldIn, pos.func_177977_b()))) {
/* 45 */         place(worldIn, pos);
/* 46 */         stack.field_77994_a -= 1;
/* 47 */         return true;
/*    */       }
/* 49 */       return false;
/*    */     }
/*    */     
/* 52 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static void place(World worldIn, BlockPos pos)
/*    */   {
/* 59 */     IBlockState stateFoot = Get.blocks().SOUL_WRENCH.func_176223_P().func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT);
/*    */     
/* 61 */     if (worldIn.func_180501_a(pos, stateFoot, 3)) {
/* 62 */       IBlockState stateHead = stateFoot.func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.HEAD);
/* 63 */       worldIn.func_180501_a(pos.func_177984_a(), stateHead, 3);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 69 */     return 98;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemSoulWrench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */