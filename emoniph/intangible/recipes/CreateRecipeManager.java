/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ 
/*    */ public class CreateRecipeManager
/*    */   implements Iterable<CreatureRecipe>
/*    */ {
/* 11 */   private List<CreatureRecipe> recipes = new ArrayList();
/*    */   
/*    */   public void add(CreatureRecipe recipe) {
/* 14 */     this.recipes.add(recipe);
/*    */   }
/*    */   
/*    */   public CreatureRecipe getRecipeForInput(EntityLiving entity) {
/* 18 */     if (entity != null) {
/* 19 */       for (CreatureRecipe recipe : this.recipes) {
/* 20 */         if (recipe.isMatchFor(entity)) {
/* 21 */           return recipe;
/*    */         }
/*    */       }
/*    */     }
/* 25 */     return null;
/*    */   }
/*    */   
/*    */   public Iterator<CreatureRecipe> iterator()
/*    */   {
/* 30 */     return this.recipes.iterator();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/CreateRecipeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */