/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.recipes.ModRecipes;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.IItemRegistry;
/*    */ 
/*    */ public class GolemPartsRecipeMaker
/*    */ {
/*    */   @Nonnull
/*    */   public static List<GolemPartsRecipeWrapper> getRecipes(IItemRegistry itemRegistry)
/*    */   {
/* 14 */     List<GolemPartsRecipeWrapper> recipeWrappers = new java.util.ArrayList();
/* 15 */     Get.recipes(); for (emoniph.intangible.recipes.GolemPartRecipe recipe : ModRecipes.golemParts) {
/* 16 */       recipeWrappers.add(new GolemPartsRecipeWrapper(recipe));
/*    */     }
/*    */     
/* 19 */     return recipeWrappers;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/GolemPartsRecipeMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */