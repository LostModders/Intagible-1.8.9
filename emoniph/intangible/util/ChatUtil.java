/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.command.ICommandSender;
/*    */ 
/*    */ public enum ChatUtil
/*    */ {
/*    */   private ChatUtil() {}
/*    */   
/*    */   public static void send(ICommandSender player, String translationKey, Object... params) {
/* 10 */     String text = net.minecraft.util.StatCollector.func_74837_a(translationKey, params);
/* 11 */     String formatted = TextUtil.parse(text);
/* 12 */     player.func_145747_a(new net.minecraft.util.ChatComponentText(formatted));
/*    */   }
/*    */   
/*    */   public static void send(net.minecraft.util.EnumChatFormatting color, ICommandSender player, String translationKey, Object... params) {
/* 16 */     player.func_145747_a(new net.minecraft.util.ChatComponentTranslation(translationKey, params).func_150255_a(new net.minecraft.util.ChatStyle().func_150238_a(color)));
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/ChatUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */