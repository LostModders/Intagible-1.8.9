/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.IGuiHelper;
/*    */ import mezz.jei.api.gui.IDrawable;
/*    */ import mezz.jei.api.gui.IGuiItemStackGroup;
/*    */ import mezz.jei.api.gui.IRecipeLayout;
/*    */ import mezz.jei.api.recipe.IRecipeCategory;
/*    */ import mezz.jei.api.recipe.IRecipeWrapper;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class MoldRecipeCategory implements IRecipeCategory
/*    */ {
/*    */   public static final String JEI_CATEGORY = "intangible:blowmold";
/*    */   private final String localizedName;
/*    */   @Nonnull
/*    */   private final IDrawable background;
/*    */   @Nonnull
/*    */   private final IDrawable slotDrawable;
/*    */   private final IGuiHelper guiHelper;
/*    */   private static final int inSlot1 = 0;
/*    */   private static final int inSlot2 = 1;
/*    */   private static final int outSlot = 4;
/*    */   
/*    */   public MoldRecipeCategory(IGuiHelper guiHelper)
/*    */   {
/* 29 */     this.guiHelper = guiHelper;
/* 30 */     this.localizedName = mezz.jei.util.Translator.translateToLocal("gui.jei.intangible:blowmold");
/* 31 */     ResourceLocation location = new ResourceLocation("intangible:textures/gui/moldgrid_gui.png");
/* 32 */     this.background = guiHelper.createDrawable(location, 74, 97, 108, 64, 0, 0, 0, 0);
/* 33 */     this.slotDrawable = guiHelper.getSlotDrawable();
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public String getUid()
/*    */   {
/* 39 */     return "intangible:blowmold";
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public String getTitle()
/*    */   {
/* 45 */     return this.localizedName;
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public IDrawable getBackground()
/*    */   {
/* 51 */     return this.background;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void drawExtras(Minecraft minecraft) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void drawAnimations(Minecraft minecraft) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper)
/*    */   {
/* 70 */     IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
/*    */     
/* 72 */     itemStacks.init(0, true, 22, 11);
/* 73 */     itemStacks.init(1, true, 22, 32);
/* 74 */     itemStacks.init(4, false, 87, 23);
/*    */     
/* 76 */     if ((recipeWrapper instanceof MoldRecipeWrapper)) {
/* 77 */       List inputs = recipeWrapper.getInputs();
/*    */       
/* 79 */       itemStacks.setFromRecipe(0, inputs.get(0));
/* 80 */       itemStacks.setFromRecipe(1, inputs.get(1));
/* 81 */       itemStacks.setFromRecipe(4, recipeWrapper.getOutputs());
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/MoldRecipeCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */