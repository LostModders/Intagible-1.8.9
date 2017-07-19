/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.souls.EnumSoulType;
/*    */ 
/*    */ public class StrokeSet {
/*    */   private final byte[] strokes;
/*    */   private final int level;
/*    */   
/*    */   public static class Stroke { public static final byte UP = 0;
/*    */     public static final byte DOWN = 1;
/*    */     public static final byte LEFT = 3;
/*    */     public static final byte RIGHT = 2;
/*    */     public static final byte UP_LEFT = 6;
/*    */     public static final byte UP_RIGHT = 4;
/*    */     public static final byte DOWN_LEFT = 5;
/*    */     public static final byte DOWN_RIGHT = 7;
/* 17 */     public static final int[] STROKE_TO_INDEX = {EnumSoulType.NOBLE
/* 18 */       .getMetadata(), EnumSoulType.DOOMED
/* 19 */       .getMetadata(), EnumSoulType.IMMUTABLE
/* 20 */       .getMetadata(), EnumSoulType.MALLEABLE
/* 21 */       .getMetadata(), EnumSoulType.BENIGN
/* 22 */       .getMetadata(), EnumSoulType.UNHINGED
/* 23 */       .getMetadata(), EnumSoulType.WISE
/* 24 */       .getMetadata(), EnumSoulType.PREDATORY
/* 25 */       .getMetadata() };
/*    */     
/* 27 */     public static final int[] INDEX_TO_STROKE = { 0, 4, 2, 7, 1, 5, 3, 6 };
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public StrokeSet(int level, byte... strokes)
/*    */   {
/* 37 */     this.strokes = strokes;
/* 38 */     this.level = level;
/*    */   }
/*    */   
/*    */   public StrokeSet(byte... strokes) {
/* 42 */     this(1, strokes);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/StrokeSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */