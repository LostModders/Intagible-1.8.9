/*    */ package emoniph.intangible.knowledge;
/*    */ 
/*    */ import emoniph.intangible.souls.EnumSoulType;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MultiBlockPlanDeityBuilder implements emoniph.intangible.api.IMultiBlockPlan
/*    */ {
/*    */   private final ItemStack[][][] plan;
/*    */   
/*    */   public MultiBlockPlanDeityBuilder()
/*    */   {
/* 12 */     ItemStack m = new ItemStack(emoniph.intangible.Get.blocks().SOUL_CAGE, 1, EnumSoulType.MALLEABLE.getMetadata());
/* 13 */     ItemStack i = new ItemStack(emoniph.intangible.Get.blocks().SOUL_CAGE, 1, EnumSoulType.IMMUTABLE.getMetadata());
/* 14 */     ItemStack f = new ItemStack(emoniph.intangible.Get.blocks().SOUL_FORGE);
/* 15 */     ItemStack a = null;
/*    */     
/* 17 */     ItemStack[][][] layers = { { { i, m, i }, { m, f, m }, { i, m, i } }, { { i, m, i }, { m, a, m }, { i, m, i } }, { { i, m, i }, { m, a, m }, { i, m, i } }, { { a, m, a }, { m, a, m }, { a, m, a } }, { { a, m, a }, { m, a, m }, { a, m, a } } };
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 45 */     this.plan = layers;
/*    */   }
/*    */   
/*    */   public ItemStack[][][] getPlan()
/*    */   {
/* 50 */     return this.plan;
/*    */   }
/*    */   
/*    */   public float getPlanRenderScale()
/*    */   {
/* 55 */     return 1.0F;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/MultiBlockPlanDeityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */