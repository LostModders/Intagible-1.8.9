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
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class StamperRecipeCategory implements mezz.jei.api.recipe.IRecipeCategory
/*    */ {
/*    */   public static final String JEI_CATEGORY = "intangible:stamper";
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
/*    */   public StamperRecipeCategory(IGuiHelper guiHelper)
/*    */   {
/* 30 */     this.guiHelper = guiHelper;
/* 31 */     this.localizedName = mezz.jei.util.Translator.translateToLocal("gui.jei.intangible:stamper");
/* 32 */     ResourceLocation location = new ResourceLocation("intangible:textures/gui/stampinggrid_gui.png");
/* 33 */     this.background = guiHelper.createDrawable(location, 74, 97, 108, 64, 0, 0, 0, 0);
/* 34 */     this.slotDrawable = guiHelper.getSlotDrawable();
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public String getUid()
/*    */   {
/* 40 */     return "intangible:stamper";
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public String getTitle()
/*    */   {
/* 46 */     return this.localizedName;
/*    */   }
/*    */   
/*    */   @Nonnull
/*    */   public IDrawable getBackground()
/*    */   {
/* 52 */     return this.background;
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
/* 73 */     IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
/*    */     
/* 75 */     itemStacks.init(0, true, 11, 11);
/* 76 */     itemStacks.init(1, true, 33, 11);
/* 77 */     itemStacks.init(2, true, 11, 33);
/* 78 */     itemStacks.init(3, true, 33, 33);
/* 79 */     itemStacks.init(4, false, 87, 22);
/*    */     
/* 81 */     if ((recipeWrapper instanceof StamperRecipeWrapper)) {
/* 82 */       List inputs = recipeWrapper.getInputs();
/*    */       
/* 84 */       itemStacks.setFromRecipe(0, inputs.get(0));
/* 85 */       itemStacks.setFromRecipe(1, inputs.get(1));
/* 86 */       itemStacks.setFromRecipe(2, inputs.get(2));
/* 87 */       itemStacks.setFromRecipe(3, inputs.get(3));
/* 88 */       itemStacks.setFromRecipe(4, recipeWrapper.getOutputs());
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/StamperRecipeCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */