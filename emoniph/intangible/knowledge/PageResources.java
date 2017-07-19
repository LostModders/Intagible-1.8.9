/*    */ package emoniph.intangible.knowledge;
/*    */ 
/*    */ import emoniph.intangible.api.IKnol;
/*    */ import emoniph.intangible.api.ISoulSet;
/*    */ 
/*    */ public class PageResources implements emoniph.intangible.api.IBookPageResources
/*    */ {
/*    */   private final String pageId;
/*    */   private final String titleId;
/*    */   private final String contentId;
/*    */   private final net.minecraft.item.ItemStack stack;
/*    */   private final IKnol[] knols;
/*    */   private ISoulSet usedSouls;
/*    */   private ISoulSet consumedSouls;
/*    */   
/*    */   public PageResources(String pageId, String titleId, String contentId, net.minecraft.item.ItemStack stack, IKnol... knols)
/*    */   {
/* 18 */     this.titleId = titleId;
/* 19 */     this.contentId = contentId;
/* 20 */     this.pageId = pageId;
/* 21 */     this.stack = stack;
/* 22 */     this.knols = knols;
/*    */   }
/*    */   
/*    */   public PageResources setUsedSouls(ISoulSet usedSouls) {
/* 26 */     this.usedSouls = usedSouls;
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public PageResources setConsumedSouls(ISoulSet consumedSouls) {
/* 31 */     this.consumedSouls = consumedSouls;
/* 32 */     return this;
/*    */   }
/*    */   
/*    */   public String getPageId()
/*    */   {
/* 37 */     return this.pageId;
/*    */   }
/*    */   
/*    */   public String getTitleId()
/*    */   {
/* 42 */     return this.titleId;
/*    */   }
/*    */   
/*    */   public String getContentResourceId()
/*    */   {
/* 47 */     return this.contentId;
/*    */   }
/*    */   
/*    */   public net.minecraft.item.ItemStack getStack()
/*    */   {
/* 52 */     return this.stack;
/*    */   }
/*    */   
/*    */   public IKnol[] getKnowledge()
/*    */   {
/* 57 */     return this.knols;
/*    */   }
/*    */   
/*    */   public ISoulSet getUsedSouls()
/*    */   {
/* 62 */     return this.usedSouls;
/*    */   }
/*    */   
/*    */   public ISoulSet getConsumedSouls()
/*    */   {
/* 67 */     return this.consumedSouls;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/PageResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */