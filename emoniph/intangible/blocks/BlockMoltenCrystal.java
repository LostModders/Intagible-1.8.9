/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fluids.BlockFluidFinite;
/*    */ import net.minecraftforge.fluids.Fluid;
/*    */ 
/*    */ public class BlockMoltenCrystal extends BlockFluidFinite implements IBlock
/*    */ {
/*    */   public BlockMoltenCrystal(Fluid fluid)
/*    */   {
/* 19 */     super(fluid, Material.field_151587_i);
/* 20 */     setQuantaPerBlock(1);
/* 21 */     func_149711_c(100.0F);
/* 22 */     func_149715_a(1.0F);
/*    */   }
/*    */   
/*    */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
/* 26 */     if (!checkForMixing(worldIn, pos, state)) {
/* 27 */       super.func_176204_a(worldIn, pos, state, neighborBlock);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean checkForMixing(World worldIn, BlockPos pos, IBlockState state)
/*    */   {
/* 33 */     if (this.field_149764_J == Material.field_151587_i) {
/* 34 */       boolean flag = false;
/* 35 */       EnumFacing[] aenumfacing = EnumFacing.values();
/* 36 */       int i = aenumfacing.length;
/*    */       
/* 38 */       for (int j = 0; j < i; j++) {
/* 39 */         EnumFacing enumfacing = aenumfacing[j];
/*    */         
/* 41 */         if ((enumfacing != EnumFacing.DOWN) && (worldIn.func_180495_p(pos.func_177972_a(enumfacing)).func_177230_c().func_149688_o() == Material.field_151586_h)) {
/* 42 */           flag = true;
/* 43 */           break;
/*    */         }
/*    */       }
/*    */       
/* 47 */       if ((flag) && 
/* 48 */         (!worldIn.field_72995_K)) {
/* 49 */         worldIn.func_175698_g(pos);
/* 50 */         worldIn.func_72838_d(new EntityItem(worldIn, pos
/* 51 */           .func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, new net.minecraft.item.ItemStack(
/* 52 */           emoniph.intangible.Get.blocks().CRYSTAL)));
/* 53 */         triggerMixEffects(worldIn, pos);
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   protected void triggerMixEffects(World worldIn, BlockPos pos) {
/* 62 */     double d0 = pos.func_177958_n();
/* 63 */     double d1 = pos.func_177956_o();
/* 64 */     double d2 = pos.func_177952_p();
/* 65 */     worldIn.func_72908_a(d0 + 0.5D, d1 + 0.5D, d2 + 0.5D, "random.fizz", 0.5F, 2.6F + (worldIn.field_73012_v.nextFloat() - worldIn.field_73012_v.nextFloat()) * 0.8F);
/*    */     
/* 67 */     for (int i = 0; i < 8; i++) {
/* 68 */       worldIn.func_175688_a(net.minecraft.util.EnumParticleTypes.SMOKE_LARGE, d0 + Math.random(), d1 + 1.2D, d2 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
/*    */     }
/*    */   }
/*    */   
/*    */   public int getMaxRenderHeightMeta()
/*    */   {
/* 74 */     return 16;
/*    */   }
/*    */   
/*    */   public boolean canDisplace(IBlockAccess world, BlockPos pos)
/*    */   {
/* 79 */     if (world.func_180495_p(pos).func_177230_c().func_149688_o().func_76224_d()) {
/* 80 */       return false;
/*    */     }
/*    */     
/* 83 */     return super.canDisplace(world, pos);
/*    */   }
/*    */   
/*    */   public boolean displaceIfPossible(World world, BlockPos pos)
/*    */   {
/* 88 */     if (world.func_180495_p(pos).func_177230_c().func_149688_o().func_76224_d()) {
/* 89 */       return false;
/*    */     }
/*    */     
/* 92 */     return super.displaceIfPossible(world, pos);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockMoltenCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */