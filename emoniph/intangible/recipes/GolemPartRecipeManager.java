/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class GolemPartRecipeManager implements Iterable<GolemPartRecipe>
/*    */ {
/* 10 */   private List<GolemPartRecipe> recipes = new ArrayList();
/*    */   
/*    */   public void add(GolemPartRecipe recipe) {
/* 13 */     this.recipes.add(recipe);
/*    */   }
/*    */   
/*    */   public ItemStack getOutputFor(ItemStack[] stacks) {
/* 17 */     GolemPartRecipe recipe = getRecipeFor(stacks);
/* 18 */     return recipe != null ? recipe.getOutput() : null;
/*    */   }
/*    */   
/*    */   public GolemPartRecipe getRecipeFor(ItemStack[] stacks) {
/* 22 */     for (GolemPartRecipe recipe : this.recipes) {
/* 23 */       if (recipe.isMatchFor(stacks)) {
/* 24 */         return recipe;
/*    */       }
/*    */     }
/* 27 */     return null;
/*    */   }
/*    */   
/*    */   public Iterator<GolemPartRecipe> iterator()
/*    */   {
/* 32 */     return this.recipes.iterator();
/*    */   }
/*    */   
/*    */   public GolemPartRecipe getRecipeForOutput(ItemStack stack) {
/* 36 */     for (GolemPartRecipe recipe : this.recipes) {
/* 37 */       if (ItemStack.func_179545_c(recipe.getOutput(), stack)) {
/* 38 */         return recipe;
/*    */       }
/*    */     }
/* 41 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/GolemPartRecipeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */