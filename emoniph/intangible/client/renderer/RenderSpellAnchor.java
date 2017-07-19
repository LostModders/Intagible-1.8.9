/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.entity.EntitySpellAnchor;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderSpellAnchor extends Render<EntitySpellAnchor>
/*     */ {
/*     */   public RenderSpellAnchor(RenderManager renderManager, float scale)
/*     */   {
/*  20 */     super(renderManager);
/*     */   }
/*     */   
/*     */   public void doRender(EntitySpellAnchor entity, double x, double y, double z, float entityYaw, float partialTicks)
/*     */   {
/*  25 */     super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
/*     */     
/*  27 */     if (entity.drawConnectingLine()) {
/*  28 */       GlStateManager.func_179094_E();
/*  29 */       GlStateManager.func_179147_l();
/*  30 */       GlStateManager.func_179112_b(770, 771);
/*  31 */       renderLeash(entity, x, y, z, entityYaw, partialTicks);
/*  32 */       GlStateManager.func_179084_k();
/*  33 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */   
/*     */   protected net.minecraft.util.ResourceLocation getEntityTexture(EntitySpellAnchor entity)
/*     */   {
/*  39 */     return TextureMap.field_110575_b;
/*     */   }
/*     */   
/*     */   private double interpolateValue(double start, double end, double pct) {
/*  43 */     return start + (end - start) * pct;
/*     */   }
/*     */   
/*     */   protected void renderLeash(EntitySpellAnchor soul, double x, double y, double z, float entityYaw, float partialTicks) {
/*  47 */     y -= 1.1999999940395356D;
/*  48 */     for (EntityLivingBase entity : soul.getLinkedEntities())
/*     */     {
/*  50 */       Tessellator tessellator = Tessellator.func_178181_a();
/*  51 */       WorldRenderer worldrenderer = tessellator.func_178180_c();
/*  52 */       double d3 = interpolateValue(entity.field_70126_B, entity.field_70177_z, partialTicks * 0.5F) * 0.01745329238474369D;
/*  53 */       double d4 = interpolateValue(entity.field_70127_C, entity.field_70125_A, partialTicks * 0.5F) * 0.01745329238474369D;
/*  54 */       double d5 = Math.cos(d3);
/*  55 */       double d6 = Math.sin(d3);
/*  56 */       double d7 = Math.sin(d4);
/*     */       
/*  58 */       double d8 = Math.cos(d4);
/*  59 */       double d9 = interpolateValue(entity.field_70169_q, entity.field_70165_t, partialTicks) - d5 * 0.7D - d6 * 0.5D * d8;
/*  60 */       double d10 = interpolateValue(entity.field_70167_r + entity.func_70047_e() * 0.7D, entity.field_70163_u + entity.func_70047_e() * 0.7D, partialTicks) - d7 * 0.5D - 0.25D;
/*  61 */       double d11 = interpolateValue(entity.field_70166_s, entity.field_70161_v, partialTicks) - d6 * 0.7D + d5 * 0.5D * d8;
/*  62 */       double d12 = interpolateValue(0.5D, 0.5D, partialTicks) * 0.01745329238474369D + 1.5707963267948966D;
/*  63 */       d5 = Math.cos(d12) * soul.field_70130_N * 0.4D;
/*  64 */       d6 = Math.sin(d12) * soul.field_70130_N * 0.4D;
/*  65 */       double d13 = interpolateValue(soul.field_70169_q, soul.field_70165_t, partialTicks) + d5;
/*  66 */       double d14 = interpolateValue(soul.field_70167_r, soul.field_70163_u, partialTicks);
/*  67 */       double d15 = interpolateValue(soul.field_70166_s, soul.field_70161_v, partialTicks) + d6;
/*  68 */       x += d5;
/*  69 */       z += d6;
/*  70 */       double d16 = (float)(d9 - d13);
/*  71 */       double d17 = (float)(d10 - d14);
/*  72 */       double d18 = (float)(d11 - d15);
/*  73 */       GlStateManager.func_179090_x();
/*  74 */       GlStateManager.func_179140_f();
/*  75 */       GlStateManager.func_179129_p();
/*     */       
/*  77 */       worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  82 */       double width = 0.05D;
/*  83 */       int color = soul.getOuterColor();
/*  84 */       float a = (color >> 24 & 0xFF) / 256.0F;
/*  85 */       float r = (color >> 16 & 0xFF) / 256.0F;
/*  86 */       float g = (color >> 8 & 0xFF) / 256.0F;
/*  87 */       float b = (color & 0xFF) / 256.0F;
/*     */       
/*     */ 
/*  90 */       for (int i = 0; i <= 24; i++)
/*     */       {
/*  92 */         double f1 = i;
/*  93 */         double f2 = f1 / 24.0D;
/*  94 */         worldrenderer.func_181662_b(x + d16 * f2 + 0.0D, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D), z + d18 * f2)
/*     */         
/*     */ 
/*  97 */           .func_181666_a(r, g, b, 0.5F)
/*  98 */           .func_181675_d();
/*  99 */         worldrenderer.func_181662_b(x + d16 * f2 + width, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D) + width, z + d18 * f2)
/*     */         
/*     */ 
/* 102 */           .func_181666_a(r, g, b, 0.5F)
/* 103 */           .func_181675_d();
/*     */       }
/*     */       
/*     */ 
/* 107 */       tessellator.func_78381_a();
/* 108 */       worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);
/*     */       
/* 110 */       for (i = 0; i <= 24; i++)
/*     */       {
/* 112 */         double f1 = i;
/* 113 */         double f2 = f1 / 24.0D;
/* 114 */         worldrenderer.func_181662_b(x + d16 * f2 + 0.0D, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D) + width, z + d18 * f2)
/*     */         
/*     */ 
/* 117 */           .func_181666_a(r, g, b, 0.5F)
/* 118 */           .func_181675_d();
/* 119 */         worldrenderer.func_181662_b(x + d16 * f2 + width, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D), z + d18 * f2 + width)
/*     */         
/*     */ 
/* 122 */           .func_181666_a(r, g, b, 0.5F)
/* 123 */           .func_181675_d();
/*     */       }
/*     */       
/* 126 */       tessellator.func_78381_a();
/* 127 */       GlStateManager.func_179145_e();
/* 128 */       GlStateManager.func_179098_w();
/* 129 */       GlStateManager.func_179089_o();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSpellAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */