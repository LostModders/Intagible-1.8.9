/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.recipe.IRecipeHandler;
/*    */ 
/*    */ public class MoldRecipeHandler implements IRecipeHandler<MoldRecipeWrapper>
/*    */ {
/*    */   @Nonnull
/*    */   public Class<MoldRecipeWrapper> getRecipeClass()
/*    */   {
/* 12 */     return MoldRecipeWrapper.class;
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public String getRecipeCategoryUid()
/*    */   {
/* 18 */     return "intangible:blowmold";
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public mezz.jei.api.recipe.IRecipeWrapper getRecipeWrapper(@Nonnull MoldRecipeWrapper recipe)
/*    */   {
/* 24 */     return recipe;
/*    */   }
/*    */   
/*    */   public boolean isRecipeValid(@Nonnull MoldRecipeWrapper recipe)
/*    */   {
/* 29 */     return (recipe.getInputs().size() == 2) && (recipe.getOutputs().size() == 1);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/MoldRecipeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */