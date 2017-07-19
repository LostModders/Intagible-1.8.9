/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.annotation.Nonnull;
/*    */ import mezz.jei.api.IGuiHelper;
/*    */ import mezz.jei.api.gui.IDrawable;
/*    */ import mezz.jei.api.gui.IGuiItemStackGroup;
/*    */ import mezz.jei.api.gui.IRecipeLayout;
/*    */ import mezz.jei.api.recipe.IRecipeWrapper;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class GolemPartsRecipeCategory implements mezz.jei.api.recipe.IRecipeCategory
/*    */ {
/*    */   public static final String JEI_CATEGORY = "intangible:golemparts";
/*    */   private final String localizedName;
/*    */   @Nonnull
/*    */   private final IDrawable background;
/*    */   @Nonnull
/*    */   private final IDrawable slotDrawable;
/*    */   private final IGuiHelper guiHelper;
/*    */   private static final int inSlot1 = 0;
/*    */   private static final int inSlot2 = 1;
/*    */   private static final int inSlot3 = 2;
/*    */   private static final int inSlot4 = 3;
/*    */   private static final int outSlot = 4;
/*    */   
/*    */   public GolemPartsRecipeCategory(IGuiHelper guiHelper)
/*    */   {
/* 29 */     this.guiHelper = guiHelper;
/* 30 */     this.localizedName = mezz.jei.util.Translator.translateToLocal("gui.jei.intangible:golemparts");
/* 31 */     net.minecraft.util.ResourceLocation location = new net.minecraft.util.ResourceLocation("intangible:textures/gui/soulgrid_gui.png");
/* 32 */     this.background = guiHelper.createDrawable(location, 74, 97, 108, 64, 0, 0, 0, 0);
/* 33 */     this.slotDrawable = guiHelper.getSlotDrawable();
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public String getUid()
/*    */   {
/* 39 */     return "intangible:golemparts";
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
/*    */ 
/*    */   public void drawAnimations(Minecraft minecraft) {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper)
/*    */   {
/* 72 */     IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
/*    */     
/* 74 */     itemStacks.init(0, true, 29, 2);
/* 75 */     itemStacks.init(3, true, 7, 24);
/* 76 */     itemStacks.init(2, true, 29, 46);
/* 77 */     itemStacks.init(1, true, 51, 24);
/* 78 */     itemStacks.init(4, false, 29, 24);
/*    */     
/* 80 */     if ((recipeWrapper instanceof GolemPartsRecipeWrapper)) {
/* 81 */       List inputs = recipeWrapper.getInputs();
/*    */       
/* 83 */       itemStacks.setFromRecipe(0, inputs.get(0));
/* 84 */       itemStacks.setFromRecipe(1, inputs.get(1));
/* 85 */       itemStacks.setFromRecipe(2, inputs.get(2));
/* 86 */       itemStacks.setFromRecipe(3, inputs.get(3));
/* 87 */       itemStacks.setFromRecipe(4, recipeWrapper.getOutputs());
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/GolemPartsRecipeCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */