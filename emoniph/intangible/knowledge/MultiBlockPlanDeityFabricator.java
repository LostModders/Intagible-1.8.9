/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class MultiBlockPlanDeityFabricator implements emoniph.intangible.api.IMultiBlockPlan
/*     */ {
/*     */   private final ItemStack[][][] plan;
/*     */   
/*     */   public MultiBlockPlanDeityFabricator()
/*     */   {
/*  12 */     ItemStack b = new ItemStack(Get.blocks().SOUL_CAGE, 1, emoniph.intangible.souls.EnumSoulType.BENIGN.getMetadata());
/*  13 */     ItemStack f = new ItemStack(Get.blocks().DEITY_BUILDER);
/*  14 */     ItemStack p = new ItemStack(Get.blocks().PLINTH);
/*  15 */     ItemStack a = null;
/*     */     
/*  17 */     ItemStack[][][] layers = { { { b, a, a, a, a, a, a, a, b }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { b, a, a, a, a, a, a, a, b } }, { { b, a, a, a, a, a, a, a, b }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { b, a, a, a, a, a, a, a, b } }, { { b, a, a, a, a, a, a, a, b }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { b, a, a, a, a, a, a, a, b } }, { { b, a, a, a, a, a, a, a, b }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { b, a, a, a, a, a, a, a, b } }, { { b, a, a, a, a, a, a, a, b }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { b, a, a, a, a, a, a, a, b } }, { { b, a, a, a, a, a, a, a, b }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { b, a, a, a, a, a, a, a, b } }, { { b, a, a, a, a, a, a, a, b }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { b, a, a, a, a, a, a, a, b } }, { { b, b, b, b, b, b, b, b, b }, { b, a, a, a, b, a, a, a, b }, { b, a, a, a, b, a, a, a, b }, { b, a, a, a, b, a, a, a, b }, { b, b, b, b, b, b, b, b, b }, { b, a, a, a, b, a, a, a, b }, { b, a, a, a, b, a, a, a, b }, { b, a, a, a, b, a, a, a, b }, { b, b, b, b, b, b, b, b, b } }, { { p, p, a, a, a, a, a, p, p }, { p, a, a, a, a, a, a, a, p }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { p, a, a, a, f, a, a, a, p }, { a, a, a, a, a, a, a, a, a }, { a, a, a, a, a, a, a, a, a }, { p, a, a, a, a, a, a, a, p }, { p, p, a, a, p, a, a, p, p } } };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 119 */     this.plan = layers;
/*     */   }
/*     */   
/*     */   public ItemStack[][][] getPlan()
/*     */   {
/* 124 */     return this.plan;
/*     */   }
/*     */   
/*     */   public float getPlanRenderScale()
/*     */   {
/* 129 */     return 0.4F;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/MultiBlockPlanDeityFabricator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */