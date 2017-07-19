/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import emoniph.intangible.recipes.StampingRecipe;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.recipe.BlankRecipeWrapper;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class StamperRecipeWrapper extends BlankRecipeWrapper
/*    */ {
/*    */   private final StampingRecipe recipe;
/*    */   private final List inputs;
/*    */   
/*    */   public StamperRecipeWrapper(StampingRecipe recipe)
/*    */   {
/* 18 */     this.recipe = recipe;
/* 19 */     this.inputs = Arrays.asList(recipe.getInputs());
/*    */   }
/*    */   
/*    */   public List getInputs()
/*    */   {
/* 24 */     return this.inputs;
/*    */   }
/*    */   
/*    */   public List<net.minecraft.item.ItemStack> getOutputs()
/*    */   {
/* 29 */     return Collections.singletonList(this.recipe.getOutput());
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 42 */     if ((obj == null) || (obj.getClass() != getClass())) {
/* 43 */       return false;
/*    */     }
/* 45 */     if (obj == this) {
/* 46 */       return true;
/*    */     }
/*    */     
/* 49 */     StamperRecipeWrapper other = (StamperRecipeWrapper)obj;
/*    */     
/* 51 */     return other.recipe == this.recipe;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 56 */     return this.recipe.hashCode();
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 61 */     return this.recipe.toString();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/StamperRecipeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */