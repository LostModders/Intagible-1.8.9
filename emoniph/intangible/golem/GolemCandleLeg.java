/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.api.golem.IGolem;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class GolemCandleLeg extends GolemLeg
/*    */ {
/*    */   public GolemCandleLeg(double speedBoost, int bonusThrusts, net.minecraft.util.ResourceLocation texture)
/*    */   {
/* 12 */     super(speedBoost, bonusThrusts, texture);
/*    */   }
/*    */   
/*    */   public void onUpdate(IGolem golem, BlockPos prevBlockPos)
/*    */   {
/* 17 */     if ((!golem.getGolemWorld().field_72995_K) && (prevBlockPos != null) && (golem != null)) {
/* 18 */       int x = MathHelper.func_76128_c(golem.getGolemX());
/* 19 */       int y = MathHelper.func_76128_c(golem.getGolemY());
/* 20 */       int z = MathHelper.func_76128_c(golem.getGolemZ());
/* 21 */       if ((x != prevBlockPos.func_177958_n()) || (y != prevBlockPos.func_177956_o()) || (z != prevBlockPos.func_177952_p())) {
/* 22 */         BlockPos pos = new BlockPos(x, y, z);
/* 23 */         double brightness = golem.getGolemWorld().func_175724_o(pos);
/* 24 */         if ((brightness <= 0.1D) && (golem.getGolemWorld().func_175623_d(pos)) && (!golem.getGolemWorld().func_180495_p(pos.func_177977_b()).func_177230_c().func_149688_o().func_76222_j()) && 
/* 25 */           (golem.tryRemoveItemFromInventory(new net.minecraft.item.ItemStack(net.minecraft.init.Blocks.field_150478_aa)))) {
/* 26 */           golem.getGolemWorld().func_175656_a(pos, net.minecraft.init.Blocks.field_150478_aa.func_176223_P());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemCandleLeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */