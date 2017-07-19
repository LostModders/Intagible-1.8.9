/*    */ package emoniph.intangible.effects;
/*    */ 
/*    */ public class EffectTimer {
/*    */   int ticks;
/*    */   int direction;
/*    */   int limit;
/*    */   
/*  8 */   public EffectTimer(int ticks, int limit) { this.ticks = ticks;
/*  9 */     setLimit(limit);
/*    */   }
/*    */   
/*    */   public boolean increment() {
/* 13 */     if (this.ticks != this.limit) {
/* 14 */       this.ticks += this.direction;
/*    */     }
/* 16 */     return this.ticks == this.limit;
/*    */   }
/*    */   
/*    */   public void setLimit(int limit) {
/* 20 */     this.direction = (limit < this.ticks ? -1 : 1);
/* 21 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public int getTicks() {
/* 25 */     return this.ticks;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/EffectTimer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */