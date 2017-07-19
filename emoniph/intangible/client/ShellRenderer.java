/*    */ package emoniph.intangible.client;
/*    */ 
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.util.RenderUtil;
/*    */ import emoniph.intangible.util.WorldPos;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ShellRenderer extends Gui
/*    */ {
/* 19 */   private static final ResourceLocation MAN_ICON = new ResourceLocation("intangible", "textures/gui/effect_incorporeal.png");
/*    */   private final Minecraft mc;
/*    */   
/*    */   public ShellRenderer(Minecraft minecraft)
/*    */   {
/* 24 */     this.mc = minecraft;
/*    */   }
/*    */   
/*    */   public void renderShells(EntityPlayer player, int screenWidth, int screenHeight) {
/* 28 */     GlStateManager.func_179094_E();
/* 29 */     GlStateManager.func_179147_l();
/* 30 */     this.mc.func_110434_K().func_110577_a(MAN_ICON);
/*    */     
/* 32 */     double halfWidth = 0.5D * screenWidth;
/* 33 */     double halfHeight = 0.5D * screenHeight;
/* 34 */     double pitch = player.field_70125_A + 90.0F;
/* 35 */     double yaw = ensure360(player.field_70759_as % 360.0F);
/*    */     
/* 37 */     PlayerEx playerEx = PlayerEx.get(player);
/* 38 */     for (WorldPos pos : playerEx.getShells()) {
/* 39 */       if (pos.isForWorld(player.field_70170_p)) {
/* 40 */         Vec3 vec = pos.getVectorFrom(player);
/* 41 */         double vecLenH = Math.sqrt(vec.field_72450_a * vec.field_72450_a + vec.field_72449_c * vec.field_72449_c);
/* 42 */         double pitchFromNormDegV = 90.0D - Math.toDegrees(Math.atan2(vec.field_72448_b, vecLenH));
/* 43 */         double yawFromNormDegH = ensure360(-Math.toDegrees(Math.atan2(vec.field_72450_a, vec.field_72449_c)));
/* 44 */         double angleDiffV = pitchFromNormDegV - pitch;
/* 45 */         double angleDiffH = ensure360(yawFromNormDegH - yaw);
/*    */         
/* 47 */         double fov = this.mc.field_71474_y.field_74334_X;
/* 48 */         double zoom = 40.0D / (fov + (30.0D - fov) / 40.0D * 15.0D);
/*    */         
/*    */ 
/*    */ 
/* 52 */         if ((angleDiffH < 90.0D) || (angleDiffH > 270.0D))
/*    */         {
/* 54 */           boolean selected = ((angleDiffH > 358.5D) || (angleDiffH < 1.5D)) && (angleDiffV > -1.5D) && (angleDiffV < 1.5D);
/* 55 */           int size = selected ? 16 : 8;
/* 56 */           float halfSize = size / 2;
/* 57 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.3F + 0.7F * (10.0F / (float)vecLenH));
/* 58 */           RenderUtil.drawModalRectWithCustomSizedTexture((float)(halfWidth + halfWidth * zoom * Math.tan(Math.toRadians(angleDiffH))) - halfSize, (float)(halfHeight + halfHeight * zoom * Math.tan(Math.toRadians(angleDiffV))) - halfSize, 0.0F, 0.0F, size, size, size, size);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 63 */     GlStateManager.func_179084_k();
/* 64 */     GlStateManager.func_179121_F();
/*    */   }
/*    */   
/*    */   private double ensure360(double angleInDegrees) {
/* 68 */     return angleInDegrees < 0.0D ? angleInDegrees + 360.0D : angleInDegrees;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/ShellRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */