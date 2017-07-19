/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraftforge.fml.common.ModContainer;
/*    */ 
/*    */ public enum ModUtil
/*    */ {
/*    */   private ModUtil() {}
/*    */   
/*    */   public static String withPrefix(String id) {
/* 10 */     int index = id.indexOf(':');
/* 11 */     String oldPrefix = index == -1 ? "" : id.substring(0, index);
/*    */     
/* 13 */     ModContainer modContainer = net.minecraftforge.fml.common.Loader.instance().activeModContainer();
/*    */     String prefix;
/* 15 */     String prefix; if (modContainer != null) {
/* 16 */       prefix = modContainer.getModId();
/*    */     } else {
/* 18 */       prefix = "minecraft";
/*    */     }
/*    */     
/* 21 */     if (!oldPrefix.equals(prefix)) {
/* 22 */       id = prefix + ":" + id;
/*    */     }
/* 24 */     return id;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/ModUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */