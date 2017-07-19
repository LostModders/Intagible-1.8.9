/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityJavelin;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.WorldRenderer;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderJavelin extends Render<EntityJavelin>
/*    */ {
/* 19 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/javelin.png");
/*    */   
/*    */   public RenderJavelin(RenderManager renderManager) {
/* 22 */     super(renderManager);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityJavelin entity)
/*    */   {
/* 27 */     return TEXTURE;
/*    */   }
/*    */   
/*    */   public void doRender(EntityJavelin entity, double x, double y, double z, float entityYaw, float partialTicks)
/*    */   {
/* 32 */     func_180548_c(entity);
/* 33 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 34 */     GlStateManager.func_179094_E();
/* 35 */     GlStateManager.func_179109_b((float)x, (float)y, (float)z);
/* 36 */     GlStateManager.func_179114_b(entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * partialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
/* 37 */     GlStateManager.func_179114_b(entity.field_70127_C + (entity.field_70125_A - entity.field_70127_C) * partialTicks, 0.0F, 0.0F, 1.0F);
/* 38 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 39 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 40 */     int i = 0;
/* 41 */     float f = 0.0F;
/* 42 */     float f1 = 1.0F;
/* 43 */     float f2 = (0 + i * 10) / 32.0F;
/* 44 */     float f3 = (5 + i * 10) / 32.0F;
/* 45 */     float f4 = 0.0F;
/* 46 */     float f5 = 0.15625F;
/* 47 */     float f6 = (5 + i * 10) / 32.0F;
/* 48 */     float f7 = (10 + i * 10) / 32.0F;
/* 49 */     float f8 = 0.09F;
/* 50 */     GlStateManager.func_179091_B();
/* 51 */     float f9 = entity.arrowShake - partialTicks;
/*    */     
/* 53 */     if (f9 > 0.0F) {
/* 54 */       float f10 = -MathHelper.func_76126_a(f9 * 3.0F) * f9;
/* 55 */       GlStateManager.func_179114_b(f10, 0.0F, 0.0F, 1.0F);
/*    */     }
/*    */     
/* 58 */     GlStateManager.func_179114_b(45.0F, 1.0F, 0.0F, 0.0F);
/* 59 */     GlStateManager.func_179152_a(f8, f8, f8);
/* 60 */     GlStateManager.func_179109_b(-4.0F, 0.0F, 0.0F);
/* 61 */     GL11.glNormal3f(f8, 0.0F, 0.0F);
/*    */     
/* 63 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 64 */     worldrenderer.func_181662_b(-16.0D, -2.0D, -2.0D).func_181673_a(f4, f6).func_181675_d();
/* 65 */     worldrenderer.func_181662_b(-16.0D, -2.0D, 2.0D).func_181673_a(f5, f6).func_181675_d();
/* 66 */     worldrenderer.func_181662_b(-16.0D, 2.0D, 2.0D).func_181673_a(f5, f7).func_181675_d();
/* 67 */     worldrenderer.func_181662_b(-16.0D, 2.0D, -2.0D).func_181673_a(f4, f7).func_181675_d();
/* 68 */     tessellator.func_78381_a();
/*    */     
/* 70 */     GL11.glNormal3f(-f8, 0.0F, 0.0F);
/* 71 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 72 */     worldrenderer.func_181662_b(-16.0D, 2.0D, -2.0D).func_181673_a(f4, f6).func_181675_d();
/* 73 */     worldrenderer.func_181662_b(-16.0D, 2.0D, 2.0D).func_181673_a(f5, f6).func_181675_d();
/* 74 */     worldrenderer.func_181662_b(-16.0D, -2.0D, 2.0D).func_181673_a(f5, f7).func_181675_d();
/* 75 */     worldrenderer.func_181662_b(-16.0D, -2.0D, -2.0D).func_181673_a(f4, f7).func_181675_d();
/* 76 */     tessellator.func_78381_a();
/*    */     
/* 78 */     for (int j = 0; j < 4; j++) {
/* 79 */       GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
/* 80 */       GL11.glNormal3f(0.0F, 0.0F, f8);
/* 81 */       worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 82 */       worldrenderer.func_181662_b(-16.0D, -2.0D, 0.0D).func_181673_a(f, f2).func_181675_d();
/* 83 */       worldrenderer.func_181662_b(16.0D, -2.0D, 0.0D).func_181673_a(f1, f2).func_181675_d();
/* 84 */       worldrenderer.func_181662_b(16.0D, 2.0D, 0.0D).func_181673_a(f1, f3).func_181675_d();
/* 85 */       worldrenderer.func_181662_b(-16.0D, 2.0D, 0.0D).func_181673_a(f, f3).func_181675_d();
/* 86 */       tessellator.func_78381_a();
/*    */     }
/*    */     
/* 89 */     GlStateManager.func_179101_C();
/* 90 */     GlStateManager.func_179121_F();
/* 91 */     super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderJavelin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */