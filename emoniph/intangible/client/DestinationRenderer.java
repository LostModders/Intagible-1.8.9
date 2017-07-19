/*    */ package emoniph.intangible.client;
/*    */ 
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.Gui;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.settings.GameSettings;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class DestinationRenderer extends Gui
/*    */ {
/* 19 */   private static final ResourceLocation MAN_ICON = new ResourceLocation("intangible", "textures/gui/effect_home.png");
/*    */   private final Minecraft mc;
/*    */   
/*    */   public DestinationRenderer(Minecraft minecraft)
/*    */   {
/* 24 */     this.mc = minecraft;
/*    */   }
/*    */   
/*    */   public void render(EntityPlayer player, int screenWidth, int screenHeight)
/*    */   {
/* 29 */     PlayerEx playerEx = PlayerEx.get(player);
/* 30 */     if (playerEx.getTravelDestinations() != null) {
/* 31 */       GlStateManager.func_179094_E();
/* 32 */       GlStateManager.func_179147_l();
/* 33 */       this.mc.func_110434_K().func_110577_a(MAN_ICON);
/*    */       
/* 35 */       double halfWidth = 0.5D * screenWidth;
/* 36 */       double halfHeight = 0.5D * screenHeight;
/* 37 */       double pitch = player.field_70125_A + 90.0F;
/* 38 */       double yaw = ensure360(player.field_70759_as % 360.0F);
/*    */       
/* 40 */       for (BlockPos pos : playerEx.getTravelDestinations()) {
/* 41 */         Vec3 vec = getVectorFrom(pos, player);
/* 42 */         double vecLenH = Math.sqrt(vec.field_72450_a * vec.field_72450_a + vec.field_72449_c * vec.field_72449_c);
/* 43 */         double pitchFromNormDegV = 90.0D - Math.toDegrees(Math.atan2(vec.field_72448_b, vecLenH));
/* 44 */         double yawFromNormDegH = ensure360(-Math.toDegrees(Math.atan2(vec.field_72450_a, vec.field_72449_c)));
/* 45 */         double angleDiffV = pitchFromNormDegV - pitch;
/* 46 */         double angleDiffH = ensure360(yawFromNormDegH - yaw);
/*    */         
/* 48 */         double fov = this.mc.field_71474_y.field_74334_X;
/* 49 */         double zoom = 40.0D / (fov + (30.0D - fov) / 40.0D * 15.0D);
/*    */         
/*    */ 
/*    */ 
/* 53 */         if ((angleDiffH < 90.0D) || (angleDiffH > 270.0D))
/*    */         {
/* 55 */           boolean selected = ((angleDiffH > 358.5D) || (angleDiffH < 1.5D)) && (angleDiffV > -1.5D) && (angleDiffV < 1.5D);
/* 56 */           int size = selected ? 16 : 8;
/* 57 */           float halfSize = size / 2;
/* 58 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.3F + 0.7F * (10.0F / (float)vecLenH));
/* 59 */           emoniph.intangible.util.RenderUtil.drawModalRectWithCustomSizedTexture((float)(halfWidth + halfWidth * zoom * Math.tan(Math.toRadians(angleDiffH))) - halfSize, (float)(halfHeight + halfHeight * zoom * Math.tan(Math.toRadians(angleDiffV))) - halfSize, 0.0F, 0.0F, size, size, size, size);
/*    */         }
/*    */       }
/*    */       
/* 63 */       GlStateManager.func_179084_k();
/* 64 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */   
/*    */   public Vec3 getVectorFrom(BlockPos pos, Entity entity) {
/* 69 */     double dx = pos.func_177958_n() + 0.5D - entity.field_70165_t;
/* 70 */     double dy = pos.func_177956_o() + 0.5D - (entity.field_70163_u + entity.func_70047_e());
/* 71 */     double dz = pos.func_177952_p() + 0.5D - entity.field_70161_v;
/* 72 */     return new Vec3(dx, dy, dz);
/*    */   }
/*    */   
/*    */   private double ensure360(double angleInDegrees) {
/* 76 */     return angleInDegrees < 0.0D ? angleInDegrees + 360.0D : angleInDegrees;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/DestinationRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */