/*    */ package emoniph.intangible.knowledge;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class MultiBlockPlanSoulTransfuser implements emoniph.intangible.api.IMultiBlockPlan
/*    */ {
/*    */   private final ItemStack[][][] plan;
/*    */   
/*    */   public MultiBlockPlanSoulTransfuser()
/*    */   {
/* 12 */     ItemStack b = new ItemStack(Get.blocks().SOUL_CAGE, 1, emoniph.intangible.souls.EnumSoulType.BENIGN.getMetadata());
/* 13 */     ItemStack c = new ItemStack(Get.blocks().BONE_CAGE);
/* 14 */     ItemStack r = new ItemStack(Get.blocks().RECONSTRUCTOR);
/* 15 */     ItemStack a = null;
/*    */     
/* 17 */     ItemStack[][][] layers = { { { a, b, a, b, a }, { b, a, a, a, b }, { a, a, r, a, a }, { b, a, a, a, b }, { a, b, a, b, a } }, { { a, a, a, a, a }, { a, a, a, a, a }, { a, a, c, a, a }, { a, a, a, a, a }, { a, a, a, a, a } } };
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
/* 34 */     this.plan = layers;
/*    */   }
/*    */   
/*    */   public ItemStack[][][] getPlan()
/*    */   {
/* 39 */     return this.plan;
/*    */   }
/*    */   
/*    */   public float getPlanRenderScale()
/*    */   {
/* 44 */     return 1.0F;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/MultiBlockPlanSoulTransfuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */