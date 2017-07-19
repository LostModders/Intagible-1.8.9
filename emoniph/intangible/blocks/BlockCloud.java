/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.EnumWorldBlockLayer;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class BlockCloud extends Block implements IBlock
/*    */ {
/*    */   public BlockCloud()
/*    */   {
/* 19 */     super(net.minecraft.block.material.Material.field_151580_n);
/* 20 */     func_149711_c(0.0F);
/* 21 */     func_149675_a(true);
/*    */   }
/*    */   
/*    */   public boolean func_149662_c()
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*    */   {
/* 32 */     IBlockState block = worldIn.func_180495_p(pos);
/* 33 */     return block.func_177230_c() == this ? false : super.func_176225_a(worldIn, pos, side);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EnumWorldBlockLayer func_180664_k()
/*    */   {
/* 39 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {}
/*    */   
/*    */ 
/*    */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*    */   {
/* 49 */     worldIn.func_175684_a(pos, worldIn.func_180495_p(pos).func_177230_c(), TickUtil.fromSeconds(3));
/*    */   }
/*    */   
/*    */   public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand)
/*    */   {
/* 54 */     if (!worldIn.field_72995_K) {
/* 55 */       worldIn.func_175698_g(pos);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockCloud.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */