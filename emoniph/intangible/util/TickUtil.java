/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ public enum TickUtil {
/*    */   public static final int TICKS_PER_SECOND = 20;
/*    */   public static final int TICKS_PER_MC_DAY = 24000;
/*    */   
/*    */   private TickUtil() {}
/*    */   
/*    */   public static int fromSeconds(int seconds) {
/* 10 */     return 20 * seconds;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/TickUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */