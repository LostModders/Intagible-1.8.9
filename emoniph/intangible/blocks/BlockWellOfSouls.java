/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import emoniph.intangible.materials.MaterialSoulWell;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.MapColor;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.EnumWorldBlockLayer;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class BlockWellOfSouls
/*    */   extends BlockContainer implements IBlock
/*    */ {
/*    */   BlockWellOfSouls()
/*    */   {
/* 25 */     super(MaterialSoulWell.INSTANCE);
/* 26 */     func_149722_s();
/* 27 */     func_149752_b(9999.0F);
/*    */   }
/*    */   
/*    */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*    */   {
/* 32 */     return !(entity instanceof EntityLiving);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
/* 37 */     return (side == EnumFacing.DOWN) && (super.func_176225_a(worldIn, pos, side));
/*    */   }
/*    */   
/*    */   public boolean func_149662_c() {
/* 41 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_149686_d() {
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public MapColor func_180659_g(IBlockState state) {
/* 49 */     return MapColor.field_151654_J;
/*    */   }
/*    */   
/*    */   public int func_149745_a(Random random) {
/* 53 */     return 0;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_180665_b(World worldIn, BlockPos pos)
/*    */   {
/* 59 */     return null;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public EnumWorldBlockLayer func_180664_k()
/*    */   {
/* 65 */     return EnumWorldBlockLayer.SOLID;
/*    */   }
/*    */   
/*    */   public TileEntity func_149915_a(World worldIn, int meta)
/*    */   {
/* 70 */     return new TileEntityWellOfSouls();
/*    */   }
/*    */   
/*    */   public void func_180634_a(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
/* 74 */     if ((entityIn.field_70154_o == null) && (entityIn.field_70153_n == null) && (!worldIn.field_72995_K)) {}
/*    */   }
/*    */   
/*    */   public static class TileEntityWellOfSouls
/*    */     extends TileEntity
/*    */   {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockWellOfSouls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */