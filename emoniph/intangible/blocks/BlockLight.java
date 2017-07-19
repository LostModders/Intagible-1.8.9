/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockLight extends Block implements IBlock
/*    */ {
/*    */   public BlockLight()
/*    */   {
/* 12 */     super(net.minecraft.block.material.Material.field_151579_a);
/* 13 */     func_149715_a(1.0F);
/*    */   }
/*    */   
/*    */   public int func_149645_b()
/*    */   {
/* 18 */     return -1;
/*    */   }
/*    */   
/*    */   public net.minecraft.util.AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state)
/*    */   {
/* 23 */     return super.func_180640_a(worldIn, pos, state);
/*    */   }
/*    */   
/*    */   public boolean func_149662_c()
/*    */   {
/* 28 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_176209_a(IBlockState state, boolean hitIfLiquid)
/*    */   {
/* 33 */     return false;
/*    */   }
/*    */   
/*    */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockLight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */