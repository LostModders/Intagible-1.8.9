/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import java.util.Map;
/*    */ 
/*    */ public class TextUtil
/*    */ {
/*    */   private static final String FORMAT_CHAR = "§";
/*    */   private static final String FORMAT_CLEAR = "§r";
/*    */   
/*    */   public static String parse(String s)
/*    */   {
/* 12 */     java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\[(.+?)\\]");
/* 13 */     java.util.regex.Matcher m = p.matcher(s);
/* 14 */     StringBuffer sb = new StringBuffer();
/* 15 */     while (m.find()) {
/* 16 */       String group = m.group(1);
/* 17 */       if (group != null) {
/* 18 */         String replacement = (String)FORMATS.get(group);
/* 19 */         if (replacement == null) {
/* 20 */           replacement = m.group();
/*    */         }
/* 22 */         m.appendReplacement(sb, replacement);
/*    */       }
/*    */     }
/* 25 */     m.appendTail(sb);
/* 26 */     return sb.toString();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 31 */   private static final Map<String, String> FORMATS = ;
/*    */   
/*    */   private static Map<String, String> getFormats() {
/* 34 */     Map<String, String> formats = new java.util.HashMap();
/* 35 */     formats.put("black", "§0");
/* 36 */     formats.put("darkblue", "§1");
/* 37 */     formats.put("darkgreen", "§2");
/* 38 */     formats.put("darkaqua", "§3");
/* 39 */     formats.put("darkred", "§4");
/* 40 */     formats.put("darkpurple", "§5");
/* 41 */     formats.put("darkyellow", "§6");
/* 42 */     formats.put("gray", "§7");
/* 43 */     formats.put("darkgray", "§8");
/* 44 */     formats.put("blue", "§9");
/* 45 */     formats.put("green", "§a");
/* 46 */     formats.put("aqua", "§b");
/* 47 */     formats.put("red", "§c");
/* 48 */     formats.put("purple", "§d");
/* 49 */     formats.put("yellow", "§e");
/* 50 */     formats.put("white", "§f");
/* 51 */     formats.put("b", "§l");
/* 52 */     formats.put("s", "§m");
/* 53 */     formats.put("u", "§n");
/* 54 */     formats.put("i", "§o");
/* 55 */     formats.put("/", "§r");
/* 56 */     formats.put("br", "\n");
/* 57 */     return formats;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/TextUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */