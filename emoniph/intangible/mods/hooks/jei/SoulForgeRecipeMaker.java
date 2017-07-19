/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.recipes.ModRecipes;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.IItemRegistry;
/*    */ 
/*    */ public class SoulForgeRecipeMaker
/*    */ {
/*    */   @Nonnull
/*    */   public static List<SoulForgeRecipeWrapper> getRecipes(IItemRegistry itemRegistry)
/*    */   {
/* 15 */     List<SoulForgeRecipeWrapper> recipeWrappers = new ArrayList();
/* 16 */     Get.recipes(); for (emoniph.intangible.recipes.SoulRecipe recipe : ModRecipes.souls) {
/* 17 */       recipeWrappers.add(new SoulForgeRecipeWrapper(recipe));
/*    */     }
/*    */     
/* 20 */     return recipeWrappers;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/SoulForgeRecipeMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */