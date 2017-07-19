/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class StampingRecipeManager implements Iterable<StampingRecipe>
/*    */ {
/* 10 */   private List<StampingRecipe> recipes = new ArrayList();
/*    */   
/*    */   public void add(StampingRecipe recipe) {
/* 13 */     this.recipes.add(recipe);
/*    */   }
/*    */   
/*    */   public ItemStack getOutputFor(ItemStack[] stacks) {
/* 17 */     for (StampingRecipe recipe : this.recipes) {
/* 18 */       if (recipe.isMatchFor(stacks)) {
/* 19 */         return recipe.getOutput();
/*    */       }
/*    */     }
/* 22 */     return null;
/*    */   }
/*    */   
/*    */   public Iterator<StampingRecipe> iterator()
/*    */   {
/* 27 */     return this.recipes.iterator();
/*    */   }
/*    */   
/*    */   public StampingRecipe getRecipeForOutput(ItemStack stack) {
/* 31 */     for (StampingRecipe recipe : this.recipes) {
/* 32 */       if (ItemStack.func_179545_c(recipe.getOutput(), stack)) {
/* 33 */         return recipe;
/*    */       }
/*    */     }
/* 36 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/StampingRecipeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */