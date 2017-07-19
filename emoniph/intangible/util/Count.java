/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ public class Count {
/*    */   private int count;
/*    */   
/*  6 */   private Count(int count) { this.count = count; }
/*    */   
/*    */   public int value()
/*    */   {
/* 10 */     return this.count;
/*    */   }
/*    */   
/*    */   public Count add(int quantity) {
/* 14 */     this.count += quantity;
/* 15 */     return this;
/*    */   }
/*    */   
/*    */   public Count add(Count quantity) {
/* 19 */     return add(quantity.value());
/*    */   }
/*    */   
/*    */   public Count deduct(int quantity) {
/* 23 */     this.count -= quantity;
/* 24 */     return this;
/*    */   }
/*    */   
/*    */   public Count deduct(Count quantity) {
/* 28 */     return deduct(quantity.value());
/*    */   }
/*    */   
/*    */   public static Count of(int quantity) {
/* 32 */     return new Count(quantity);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/Count.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */