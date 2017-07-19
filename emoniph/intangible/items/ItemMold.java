/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ 
/*    */ public class ItemMold extends net.minecraft.item.Item implements IItem, emoniph.intangible.api.IMold, ICreativeSort
/*    */ {
/*    */   private final Recipe[] recipes;
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 11 */     return 101;
/*    */   }
/*    */   
/*    */   public static class Recipe {
/*    */     private final net.minecraft.item.ItemStack result;
/*    */     private final FluidStack input;
/*    */     
/*    */     Recipe(net.minecraft.item.ItemStack result, FluidStack input) {
/* 19 */       this.result = result;
/* 20 */       this.input = input;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public ItemMold(net.minecraft.item.ItemStack result, FluidStack input)
/*    */   {
/* 27 */     this(new Recipe[] { new Recipe(result, input) });
/*    */   }
/*    */   
/*    */   public ItemMold(Recipe... recipes) {
/* 31 */     this.recipes = recipes;
/*    */   }
/*    */   
/*    */   public FluidStack getRequiredFluid(net.minecraft.item.ItemStack result)
/*    */   {
/* 36 */     if (result != null) {
/* 37 */       for (Recipe recipe : this.recipes) {
/* 38 */         if (net.minecraft.item.ItemStack.func_179545_c(result, recipe.result)) {
/* 39 */           return recipe.input;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 44 */     return null;
/*    */   }
/*    */   
/*    */   public net.minecraft.item.ItemStack getResultForFluid(FluidStack fluid)
/*    */   {
/* 49 */     if (fluid != null) {
/* 50 */       for (Recipe recipe : this.recipes) {
/* 51 */         if (fluid.isFluidStackIdentical(recipe.input)) {
/* 52 */           return recipe.result;
/*    */         }
/*    */       }
/*    */     }
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemMold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */