/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ public class Point2d { public final double x;
/*    */   public final double y;
/*    */   
/*  6 */   public Point2d(double x, double y) { this.x = x;
/*  7 */     this.y = y;
/*    */   }
/*    */   
/*    */   public boolean containedBy(float x, float y, float width, float height) {
/* 11 */     return (this.x >= x) && (this.x <= x + width) && (this.y >= y) && (this.y <= y + height);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/Point2d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */