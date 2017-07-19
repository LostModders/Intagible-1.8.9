/*    */ package emoniph.intangible.client;
/*    */ 
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.player.PlayerEx.HudMessage;
/*    */ import emoniph.intangible.player.PlayerEx.HudMessage.DisplayAction;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MessageHudRenderer extends Gui
/*    */ {
/*    */   private final Minecraft mc;
/*    */   
/*    */   public MessageHudRenderer(Minecraft minecraft)
/*    */   {
/* 22 */     this.mc = minecraft;
/*    */   }
/*    */   
/*    */   public void renderHud(EntityPlayerSP player, int screenWidth, int screenHeight) {
/* 26 */     PlayerEx playerEx = PlayerEx.get(player);
/*    */     
/*    */ 
/*    */ 
/* 30 */     int startX = screenWidth / 2;
/* 31 */     int startY = screenHeight / 2;
/*    */     
/*    */ 
/* 34 */     FontRenderer font = this.mc.func_175598_ae().func_78716_a();
/*    */     
/* 36 */     PlayerEx.HudMessage message = playerEx.peekMessage();
/* 37 */     if (message != null) {
/* 38 */       GlStateManager.func_179094_E();
/* 39 */       GlStateManager.func_179109_b(startX, startY, 0.0F);
/* 40 */       PlayerEx.HudMessage.DisplayAction action = message.tick();
/* 41 */       switch (action) {
/*    */       case SHOW: 
/* 43 */         int duration = message.getDuration();
/* 44 */         int maxDuration = message.getMaxDuration();
/* 45 */         float start = 20.0F;
/* 46 */         float scale = Math.min(start, maxDuration - duration) / start * 1.5F;
/* 47 */         String s = message.toString();
/* 48 */         int width = font.func_78256_a(s);
/* 49 */         GlStateManager.func_179152_a(scale, scale, scale);
/* 50 */         font.func_78276_b(s, -width / 2, -20, -1);
/* 51 */         GlStateManager.func_179152_a(1.0F / scale, 1.0F / scale, 1.0F / scale);
/* 52 */         break;
/*    */       case REMOVE: 
/* 54 */         playerEx.pollMessage();
/*    */       }
/*    */       
/* 57 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/MessageHudRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */