/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.entity.EntitySoul;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderLiving;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderSoul extends RenderLiving
/*     */ {
/*     */   public RenderSoul(RenderManager renderManager)
/*     */   {
/*  24 */     super(renderManager, new net.minecraft.client.model.ModelSlime(0), 0.0F);
/*     */   }
/*     */   
/*     */   public void doRenderSoul(EntitySoul entity, double x, double y, double z, float par8, float partialTicks) {
/*  28 */     EntityLiving proxyEntity = entity.getProxyEntityWithSync();
/*     */     
/*     */ 
/*  31 */     GlStateManager.func_179094_E();
/*  32 */     GlStateManager.func_179112_b(770, 1);
/*  33 */     GlStateManager.func_179092_a(516, 0.02F);
/*  34 */     GlStateManager.func_179147_l();
/*     */     
/*     */ 
/*  37 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.3F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  42 */     Render renderer = (Render)Minecraft.func_71410_x().func_175598_ae().field_78729_o.get(proxyEntity.getClass());
/*  43 */     renderer.func_76986_a(proxyEntity, x, y, z, par8, partialTicks);
/*     */     
/*  45 */     GlStateManager.func_179121_F();
/*  46 */     GlStateManager.func_179094_E();
/*  47 */     GlStateManager.func_179112_b(770, 1);
/*  48 */     GlStateManager.func_179092_a(516, 0.02F);
/*  49 */     GlStateManager.func_179147_l();
/*     */     
/*  51 */     renderLeash(entity, x, y, z, par8, partialTicks);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  56 */     GlStateManager.func_179084_k();
/*     */     
/*  58 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   private double interpolateValue(double start, double end, double pct) {
/*  62 */     return start + (end - start) * pct;
/*     */   }
/*     */   
/*     */   protected void renderLeash(EntitySoul soul, double x, double y, double z, float par8, float partialTicks) {
/*  66 */     Entity entity = soul.getSoulLeashedToEntity();
/*     */     
/*  68 */     if (entity != null) {
/*  69 */       y -= (1.6D - soul.field_70131_O) * 0.5D;
/*  70 */       Tessellator tessellator = Tessellator.func_178181_a();
/*  71 */       WorldRenderer worldrenderer = tessellator.func_178180_c();
/*  72 */       double d3 = interpolateValue(entity.field_70126_B, entity.field_70177_z, partialTicks * 0.5F) * 0.01745329238474369D;
/*  73 */       double d4 = interpolateValue(entity.field_70127_C, entity.field_70125_A, partialTicks * 0.5F) * 0.01745329238474369D;
/*  74 */       double d5 = Math.cos(d3);
/*  75 */       double d6 = Math.sin(d3);
/*  76 */       double d7 = Math.sin(d4);
/*     */       
/*  78 */       double d8 = Math.cos(d4);
/*  79 */       double d9 = interpolateValue(entity.field_70169_q, entity.field_70165_t, partialTicks) - d5 * 0.7D - d6 * 0.5D * d8;
/*  80 */       double d10 = interpolateValue(entity.field_70167_r + entity.func_70047_e() * 0.7D, entity.field_70163_u + entity.func_70047_e() * 0.7D, partialTicks) - d7 * 0.5D - 0.25D;
/*  81 */       double d11 = interpolateValue(entity.field_70166_s, entity.field_70161_v, partialTicks) - d6 * 0.7D + d5 * 0.5D * d8;
/*  82 */       double d12 = interpolateValue(soul.field_70760_ar, soul.field_70761_aq, partialTicks) * 0.01745329238474369D + 1.5707963267948966D;
/*  83 */       d5 = Math.cos(d12) * soul.field_70130_N * 0.4D;
/*  84 */       d6 = Math.sin(d12) * soul.field_70130_N * 0.4D;
/*  85 */       double d13 = interpolateValue(soul.field_70169_q, soul.field_70165_t, partialTicks) + d5;
/*  86 */       double d14 = interpolateValue(soul.field_70167_r, soul.field_70163_u, partialTicks);
/*  87 */       double d15 = interpolateValue(soul.field_70166_s, soul.field_70161_v, partialTicks) + d6;
/*  88 */       x += d5;
/*  89 */       z += d6;
/*  90 */       double d16 = (float)(d9 - d13);
/*  91 */       double d17 = (float)(d10 - d14);
/*  92 */       double d18 = (float)(d11 - d15);
/*  93 */       GlStateManager.func_179090_x();
/*  94 */       GlStateManager.func_179140_f();
/*  95 */       GlStateManager.func_179129_p();
/*     */       
/*  97 */       worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 102 */       double width = 0.05D;
/*     */       
/*     */ 
/*     */ 
/* 106 */       for (int i = 0; i <= 24; i++) { float a;
/*     */         float r;
/* 108 */         float g; float b; float a; if (soul.field_70173_aa % 25 == i) {
/* 109 */           float r = 1.0F;
/* 110 */           float g = 0.6F;
/* 111 */           float b = 0.5F;
/* 112 */           a = 0.7F;
/*     */         }
/*     */         else {
/* 115 */           r = 0.35F;
/* 116 */           g = 0.28F;
/* 117 */           b = 0.21F;
/* 118 */           a = 0.5F;
/*     */         }
/*     */         
/*     */ 
/* 122 */         double f1 = i;
/* 123 */         double f2 = f1 / 24.0D;
/* 124 */         worldrenderer.func_181662_b(x + d16 * f2 + 0.0D, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D), z + d18 * f2).func_181666_a(r, g, b, a).func_181675_d();
/*     */         
/*     */ 
/* 127 */         worldrenderer.func_181662_b(x + d16 * f2 + width, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D) + width, z + d18 * f2).func_181666_a(r, g, b, a).func_181675_d();
/*     */       }
/*     */       
/* 130 */       tessellator.func_78381_a();
/* 131 */       worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181706_f);
/*     */       
/* 133 */       for (i = 0; i <= 24; i++) { float a;
/* 134 */         float r; float g; float b; float a; if (soul.field_70173_aa % 25 == i) {
/* 135 */           float r = 1.0F;
/* 136 */           float g = 0.6F;
/* 137 */           float b = 0.5F;
/* 138 */           a = 0.7F;
/*     */         }
/*     */         else {
/* 141 */           r = 0.35F;
/* 142 */           g = 0.28F;
/* 143 */           b = 0.21F;
/* 144 */           a = 0.5F;
/*     */         }
/*     */         
/*     */ 
/* 148 */         double f1 = i;
/* 149 */         double f2 = f1 / 24.0D;
/* 150 */         worldrenderer.func_181662_b(x + d16 * f2 + 0.0D, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D) + width, z + d18 * f2).func_181666_a(r, g, b, a).func_181675_d();
/*     */         
/*     */ 
/*     */ 
/* 154 */         worldrenderer.func_181662_b(x + d16 * f2 + width, y + d17 * (f2 * f2 + f2) * 0.5D + ((24.0D - f1) / 18.0D + 0.125D), z + d18 * f2 + width).func_181666_a(r, g, b, a).func_181675_d();
/*     */       }
/*     */       
/* 157 */       tessellator.func_78381_a();
/* 158 */       GlStateManager.func_179145_e();
/* 159 */       GlStateManager.func_179098_w();
/* 160 */       GlStateManager.func_179089_o();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void rotateSoulCorpse(EntitySoul entity, float par2, float par3, float par4) {
/* 165 */     super.func_77043_a(entity, par2, par3, par4);
/*     */   }
/*     */   
/*     */   protected ResourceLocation getSoulTexture(EntitySoul entity) {
/* 169 */     return null;
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity)
/*     */   {
/* 174 */     return getSoulTexture((EntitySoul)entity);
/*     */   }
/*     */   
/*     */   public void func_76986_a(EntityLiving entity, double par2, double par4, double par6, float par8, float par9)
/*     */   {
/* 179 */     doRenderSoul((EntitySoul)entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */   
/*     */   protected void func_77043_a(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
/*     */   {
/* 184 */     rotateSoulCorpse((EntitySoul)par1EntityLivingBase, par2, par3, par4);
/*     */   }
/*     */   
/*     */   public void func_76986_a(EntityLivingBase par1, double par2, double par4, double par6, float par8, float par9)
/*     */   {
/* 189 */     doRenderSoul((EntitySoul)par1, par2, par4, par6, par8, par9);
/*     */   }
/*     */   
/*     */   public void func_76986_a(Entity entity, double par2, double par4, double par6, float par8, float par9)
/*     */   {
/* 194 */     doRenderSoul((EntitySoul)entity, par2, par4, par6, par8, par9);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSoul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */