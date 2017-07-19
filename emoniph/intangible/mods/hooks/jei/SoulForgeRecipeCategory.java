/*     */ package emoniph.intangible.mods.hooks.jei;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.annotation.Nonnull;
/*     */ import mezz.jei.api.IGuiHelper;
/*     */ import mezz.jei.api.gui.IDrawable;
/*     */ import mezz.jei.api.gui.IGuiItemStackGroup;
/*     */ import mezz.jei.api.gui.IRecipeLayout;
/*     */ import mezz.jei.api.recipe.IRecipeWrapper;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class SoulForgeRecipeCategory implements mezz.jei.api.recipe.IRecipeCategory
/*     */ {
/*     */   public static final String JEI_CATEGORY = "intangible:soulforge";
/*     */   private final String localizedName;
/*     */   @Nonnull
/*     */   private final IDrawable background;
/*     */   @Nonnull
/*     */   private final IDrawable slotDrawable;
/*     */   private final IGuiHelper guiHelper;
/*     */   private static final int inSlot1 = 0;
/*     */   private static final int inSlot2 = 1;
/*     */   private static final int inSlot3 = 2;
/*     */   private static final int inSlot4 = 3;
/*     */   private static final int inSlot5 = 4;
/*     */   private static final int inSlot6 = 5;
/*     */   private static final int inSlot7 = 6;
/*     */   private static final int inSlot8 = 7;
/*     */   private static final int outSlot = 8;
/*     */   
/*     */   public SoulForgeRecipeCategory(IGuiHelper guiHelper)
/*     */   {
/*  34 */     this.guiHelper = guiHelper;
/*  35 */     this.localizedName = mezz.jei.util.Translator.translateToLocal("gui.jei.intangible:soulforge");
/*  36 */     ResourceLocation location = new ResourceLocation("intangible:textures/gui/soulgrid_gui.png");
/*  37 */     this.background = guiHelper.createDrawable(location, 74, 97, 108, 64, 0, 0, 0, 0);
/*  38 */     this.slotDrawable = guiHelper.getSlotDrawable();
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public String getUid()
/*     */   {
/*  44 */     return "intangible:soulforge";
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public String getTitle()
/*     */   {
/*  50 */     return this.localizedName;
/*     */   }
/*     */   
/*     */   @Nonnull
/*     */   public IDrawable getBackground()
/*     */   {
/*  56 */     return this.background;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawExtras(Minecraft minecraft) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawAnimations(Minecraft minecraft) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRecipe(@Nonnull IRecipeLayout recipeLayout, @Nonnull IRecipeWrapper recipeWrapper)
/*     */   {
/*  81 */     IGuiItemStackGroup itemStacks = recipeLayout.getItemStacks();
/*     */     
/*  83 */     itemStacks.init(0, true, 29, 0);
/*  84 */     itemStacks.init(1, true, 49, 4);
/*  85 */     itemStacks.init(2, true, 53, 24);
/*  86 */     itemStacks.init(3, true, 49, 44);
/*  87 */     itemStacks.init(4, true, 29, 48);
/*  88 */     itemStacks.init(5, true, 9, 44);
/*  89 */     itemStacks.init(6, true, 5, 24);
/*  90 */     itemStacks.init(7, true, 9, 4);
/*  91 */     itemStacks.init(8, false, 29, 24);
/*     */     
/*  93 */     if ((recipeWrapper instanceof SoulForgeRecipeWrapper)) {
/*  94 */       List inputs = recipeWrapper.getInputs();
/*     */       
/*  96 */       itemStacks.setFromRecipe(0, inputs.get(0));
/*  97 */       itemStacks.setFromRecipe(1, inputs.get(1));
/*  98 */       itemStacks.setFromRecipe(2, inputs.get(2));
/*  99 */       itemStacks.setFromRecipe(3, inputs.get(3));
/* 100 */       itemStacks.setFromRecipe(4, inputs.get(4));
/* 101 */       itemStacks.setFromRecipe(5, inputs.get(5));
/* 102 */       itemStacks.setFromRecipe(6, inputs.get(6));
/* 103 */       itemStacks.setFromRecipe(7, inputs.get(7));
/* 104 */       itemStacks.setFromRecipe(8, recipeWrapper.getOutputs());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/SoulForgeRecipeCategory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */