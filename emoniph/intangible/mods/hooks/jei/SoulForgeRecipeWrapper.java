/*     */ package emoniph.intangible.mods.hooks.jei;
/*     */ 
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.recipes.SoulRecipe;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import javax.annotation.Nonnull;
/*     */ import mezz.jei.api.recipe.BlankRecipeWrapper;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class SoulForgeRecipeWrapper extends BlankRecipeWrapper
/*     */ {
/*     */   private final SoulRecipe recipe;
/*     */   private final List inputs;
/*     */   private final List<ItemStack> output;
/*     */   
/*     */   public SoulForgeRecipeWrapper(SoulRecipe recipe)
/*     */   {
/*  25 */     this.recipe = recipe;
/*  26 */     this.inputs = Arrays.asList(recipe.getInputs());
/*  27 */     ItemStack[] inputs = new ItemStack[recipe.getInputs().length];
/*  28 */     for (int i = 0; i < recipe.getInputs().length; i++) {
/*  29 */       if (recipe.getInputs()[i] != null) {
/*  30 */         inputs[i] = recipe.getInputs()[i].func_77946_l();
/*     */       } else {
/*  32 */         inputs[i] = null;
/*     */       }
/*     */     }
/*  35 */     this.output = Collections.singletonList(recipe.getOutput(inputs));
/*     */   }
/*     */   
/*     */   public List getInputs()
/*     */   {
/*  40 */     return this.inputs;
/*     */   }
/*     */   
/*     */   public List<ItemStack> getOutputs()
/*     */   {
/*  45 */     return this.output;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void drawInfo(@Nonnull Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY)
/*     */   {
/*  55 */     ISoulSet souls = this.recipe.getRequiredSouls();
/*  56 */     int i = 0;
/*  57 */     float marginX = 0.0F;
/*  58 */     float marginY = 0.0F;
/*  59 */     int W = 10;
/*  60 */     int H = 10;
/*  61 */     for (SoulType soul : SoulType.values()) {
/*  62 */       int quantity = souls.quantityOf(soul);
/*  63 */       if (quantity > 0) {
/*  64 */         float px = marginX + 8 * W;
/*  65 */         float py = marginY + (minecraft.field_71466_p.field_78288_b + 2) * i;
/*  66 */         net.minecraft.client.renderer.GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  67 */         minecraft.field_71446_o.func_110577_a(EnumSoulType.fromSoulType(soul).getIcon());
/*  68 */         RenderUtil.drawModalRectWithCustomSizedTexture(px, py, 0.0F, 0.0F, 16, 16, 16.0F, 16.0F);
/*  69 */         minecraft.field_71466_p.func_78276_b("" + quantity, (int)(px + 14.0F), (int)py + 5, -872410880);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  75 */         i++;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/*  84 */     if ((obj == null) || (obj.getClass() != getClass())) {
/*  85 */       return false;
/*     */     }
/*  87 */     if (obj == this) {
/*  88 */       return true;
/*     */     }
/*     */     
/*  91 */     SoulForgeRecipeWrapper other = (SoulForgeRecipeWrapper)obj;
/*     */     
/*  93 */     return other.recipe == this.recipe;
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/*  98 */     return this.recipe.hashCode();
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 103 */     return this.recipe.toString();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/SoulForgeRecipeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */