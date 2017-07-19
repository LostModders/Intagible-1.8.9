/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.recipe.BlankRecipeWrapper;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ 
/*    */ public class MoldRecipeWrapper extends BlankRecipeWrapper
/*    */ {
/*    */   private final List inputs;
/*    */   ItemStack resultStack;
/*    */   
/*    */   public MoldRecipeWrapper(ItemStack moldStack, FluidStack fluidStack, ItemStack resultStack)
/*    */   {
/* 19 */     this.resultStack = resultStack;
/* 20 */     this.inputs = Arrays.asList(new ItemStack[] { moldStack, new ItemStack(fluidStack.getFluid().getBlock()) });
/*    */   }
/*    */   
/*    */   public List getInputs()
/*    */   {
/* 25 */     return this.inputs;
/*    */   }
/*    */   
/*    */   public List<ItemStack> getOutputs()
/*    */   {
/* 30 */     return Collections.singletonList(this.resultStack);
/*    */   }
/*    */   
/*    */   public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/MoldRecipeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */