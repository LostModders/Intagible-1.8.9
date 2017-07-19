/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import emoniph.intangible.items.ICreativeSort;
/*    */ import net.minecraft.block.BlockLever.EnumOrientation;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockLargeLever extends net.minecraft.block.BlockLever implements IBlock, emoniph.intangible.api.golem.IGolemStartable, ICreativeSort
/*    */ {
/*    */   public void func_180654_a(IBlockAccess worldIn, BlockPos pos)
/*    */   {
/* 16 */     float f = 0.25F;
/*    */     
/* 18 */     switch ((BlockLever.EnumOrientation)worldIn.func_180495_p(pos).func_177229_b(field_176360_a)) {
/*    */     case EAST: 
/* 20 */       func_149676_a(0.0F, 0.2F, 0.5F - f, f * 2.0F, 0.8F, 0.5F + f);
/* 21 */       break;
/*    */     case WEST: 
/* 23 */       func_149676_a(1.0F - f * 2.0F, 0.2F, 0.5F - f, 1.0F, 0.8F, 0.5F + f);
/* 24 */       break;
/*    */     case SOUTH: 
/* 26 */       func_149676_a(0.5F - f, 0.2F, 0.0F, 0.5F + f, 0.8F, f * 2.0F);
/* 27 */       break;
/*    */     case NORTH: 
/* 29 */       func_149676_a(0.5F - f, 0.2F, 1.0F - f * 2.0F, 0.5F + f, 0.8F, 1.0F);
/* 30 */       break;
/*    */     
/*    */     case UP_Z: 
/*    */     case UP_X: 
/* 34 */       f = 0.3125F;
/* 35 */       func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.6F, 0.5F + f);
/* 36 */       break;
/*    */     case DOWN_X: 
/*    */     case DOWN_Z: 
/* 39 */       f = 0.3125F;
/* 40 */       func_149676_a(0.5F - f, 0.4F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*    */   {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public void startWithGolem(World worldIn, BlockPos pos, EntityPlayer player)
/*    */   {
/* 51 */     if (worldIn.field_72995_K) {
/* 52 */       return;
/*    */     }
/* 54 */     IBlockState state = worldIn.func_180495_p(pos);
/* 55 */     state = state.func_177231_a(field_176359_b);
/* 56 */     worldIn.func_180501_a(pos, state, 3);
/* 57 */     worldIn.func_72908_a(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, "random.click", 0.3F, ((Boolean)state.func_177229_b(field_176359_b)).booleanValue() ? 0.6F : 0.5F);
/* 58 */     worldIn.func_175685_c(pos, this);
/* 59 */     EnumFacing enumfacing = ((BlockLever.EnumOrientation)state.func_177229_b(field_176360_a)).func_176852_c();
/* 60 */     worldIn.func_175685_c(pos.func_177972_a(enumfacing.func_176734_d()), this);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 66 */     return 70;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockLargeLever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */