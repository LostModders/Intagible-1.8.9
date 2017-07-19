/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class SoulRecipeManager
/*    */   implements Iterable<SoulRecipe>
/*    */ {
/* 12 */   public Iterator<SoulRecipe> iterator() { return this.recipes.iterator(); }
/*    */   
/*    */   public static enum Selector {
/* 15 */     All,  MAIN,  TEMPERING;
/*    */     private Selector() {} }
/* 17 */   private List<SoulRecipe> recipes = new ArrayList();
/*    */   
/*    */   public void add(SoulRecipe recipe) {
/* 20 */     this.recipes.add(recipe);
/*    */   }
/*    */   
/*    */   public SoulRecipe getOutputFor(ItemStack[] stacks) {
/* 24 */     for (SoulRecipe recipe : this.recipes) {
/* 25 */       if (recipe.isMatchFor(stacks)) {
/* 26 */         return recipe;
/*    */       }
/*    */     }
/* 29 */     return null;
/*    */   }
/*    */   
/*    */   public SoulRecipe getRecipeForOutput(ItemStack stack) {
/* 33 */     for (SoulRecipe recipe : this.recipes) {
/* 34 */       if (recipe.isMatchForOutput(stack, Selector.All)) {
/* 35 */         return recipe;
/*    */       }
/*    */     }
/* 38 */     return null;
/*    */   }
/*    */   
/*    */   public List<SoulRecipe> getRecipesForOutput(ItemStack stack, Selector selector) {
/* 42 */     List<SoulRecipe> results = new ArrayList();
/* 43 */     for (SoulRecipe recipe : this.recipes) {
/* 44 */       if (recipe.isMatchForOutput(stack, selector)) {
/* 45 */         results.add(recipe);
/*    */       }
/*    */     }
/* 48 */     return results;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/SoulRecipeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */