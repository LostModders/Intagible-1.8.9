/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import emoniph.intangible.recipes.GolemPartRecipe;
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.recipe.BlankRecipeWrapper;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class GolemPartsRecipeWrapper extends BlankRecipeWrapper
/*    */ {
/*    */   private final GolemPartRecipe recipe;
/*    */   private final List inputs;
/*    */   
/*    */   public GolemPartsRecipeWrapper(GolemPartRecipe recipe)
/*    */   {
/* 19 */     this.recipe = recipe;
/* 20 */     this.inputs = Arrays.asList(recipe.getInputs());
/*    */   }
/*    */   
/*    */   public List getInputs()
/*    */   {
/* 25 */     return this.inputs;
/*    */   }
/*    */   
/*    */   public List<ItemStack> getOutputs()
/*    */   {
/* 30 */     return Collections.singletonList(this.recipe.getOutput());
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
/* 43 */     if ((obj == null) || (obj.getClass() != getClass())) {
/* 44 */       return false;
/*    */     }
/* 46 */     if (obj == this) {
/* 47 */       return true;
/*    */     }
/*    */     
/* 50 */     GolemPartsRecipeWrapper other = (GolemPartsRecipeWrapper)obj;
/*    */     
/* 52 */     return other.recipe == this.recipe;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 57 */     return this.recipe.hashCode();
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 62 */     return this.recipe.toString();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/GolemPartsRecipeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */