/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public enum GuiUtil
/*    */ {
/*    */   private GuiUtil() {}
/*    */   
/*    */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */   public static boolean isMousePointerActive()
/*    */   {
/* 12 */     Minecraft mc = Minecraft.func_71410_x();
/* 13 */     if (mc.field_71456_v.func_146158_b().func_146241_e()) {
/* 14 */       return true;
/*    */     }
/*    */     
/* 17 */     if (mc.field_71462_r != null) {
/* 18 */       return true;
/*    */     }
/*    */     
/* 21 */     return false;
/*    */   }
/*    */   
/*    */   public static boolean isContainerOpen(net.minecraft.entity.player.EntityPlayer player) {
/* 25 */     return (player.field_71070_bA != null) && (player.field_71070_bA.field_75152_c != 0);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/GuiUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */