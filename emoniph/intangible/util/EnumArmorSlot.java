/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ public enum EnumArmorSlot {
/*  4 */   HEAD(0, 4), 
/*  5 */   CHEST(1, 3), 
/*  6 */   LEGS(2, 2), 
/*  7 */   FEET(3, 1);
/*    */   
/*    */   public final int armorType;
/*    */   public final int equipmentSlot;
/*    */   
/*    */   private EnumArmorSlot(int armorType, int equipmentSlot) {
/* 13 */     this.armorType = armorType;
/* 14 */     this.equipmentSlot = equipmentSlot;
/*    */   }
/*    */   
/* 17 */   private static final EnumArmorSlot[] BY_SLOT = { HEAD, CHEST, LEGS, FEET };
/*    */   
/*    */   public static EnumArmorSlot bySlot(int armorType) {
/* 20 */     return BY_SLOT[armorType];
/*    */   }
/*    */   
/*    */   public int getArmorSlot() {
/* 24 */     return this.equipmentSlot - 1;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/EnumArmorSlot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */