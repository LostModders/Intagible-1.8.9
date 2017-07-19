/*    */ package emoniph.intangible.souls;
/*    */ 
/*    */ import emoniph.intangible.util.Count;
/*    */ 
/*    */ public class SoulCapacity {
/*    */   private final SoulSet souls;
/*    */   private final Count count;
/*    */   
/*    */   public SoulCapacity(SoulSet souls) {
/* 10 */     this.souls = souls;
/* 11 */     this.count = Count.of(souls.size());
/*    */   }
/*    */   
/*    */   public boolean contains(emoniph.intangible.api.ISoulSet cost) {
/* 15 */     return this.souls.contains(cost);
/*    */   }
/*    */   
/*    */   public int deduct(int size) {
/* 19 */     return this.count.deduct(size).value();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/SoulCapacity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */