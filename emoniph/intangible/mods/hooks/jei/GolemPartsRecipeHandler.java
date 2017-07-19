/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.recipe.IRecipeHandler;
/*    */ 
/*    */ public class GolemPartsRecipeHandler implements IRecipeHandler<GolemPartsRecipeWrapper>
/*    */ {
/*    */   @Nonnull
/*    */   public Class<GolemPartsRecipeWrapper> getRecipeClass()
/*    */   {
/* 12 */     return GolemPartsRecipeWrapper.class;
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public String getRecipeCategoryUid()
/*    */   {
/* 18 */     return "intangible:golemparts";
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public mezz.jei.api.recipe.IRecipeWrapper getRecipeWrapper(@Nonnull GolemPartsRecipeWrapper recipe)
/*    */   {
/* 24 */     return recipe;
/*    */   }
/*    */   
/*    */   public boolean isRecipeValid(@Nonnull GolemPartsRecipeWrapper recipe)
/*    */   {
/* 29 */     return (recipe.getInputs().size() == 4) && (recipe.getOutputs().size() == 1);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/GolemPartsRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */