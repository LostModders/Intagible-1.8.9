/*     */ package emoniph.intangible.client.particle;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.RenderHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class BeamFX
/*     */ {
/*  24 */   private static final ResourceLocation TEXTURE1 = new ResourceLocation("intangible", "textures/blocks/soulwrenchbeam.png");
/*     */   
/*     */ 
/*     */ 
/*     */   public static void draw(BlockPos source, double x, double y, double z, float partialTicks, int ticksExisted, Entity victim)
/*     */   {
/*  30 */     double sourceX = source.func_177958_n() + 0.5D;
/*  31 */     double sourceY = source.func_177956_o() + 1.9D;
/*  32 */     double sourceZ = source.func_177952_p() + 0.5D;
/*     */     
/*  34 */     GlStateManager.func_179147_l();
/*  35 */     GlStateManager.func_179112_b(770, 1);
/*  36 */     GlStateManager.func_179092_a(516, 0.003921569F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  41 */     float f1 = victim.field_70177_z + partialTicks;
/*  42 */     float f2 = MathHelper.func_76126_a(f1 * 0.2F) / 2.0F + 0.5F;
/*  43 */     f2 = (f2 * f2 + f2) * 0.2F;
/*  44 */     float f3 = (float)(victim.field_70165_t - sourceX);
/*  45 */     float f4 = (float)(f2 + victim.field_70163_u + victim.func_70047_e() - sourceY);
/*  46 */     float f5 = (float)(victim.field_70161_v - sourceZ);
/*  47 */     float f6 = MathHelper.func_76129_c(f3 * f3 + f5 * f5);
/*  48 */     float f7 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5);
/*  49 */     GlStateManager.func_179094_E();
/*  50 */     GlStateManager.func_179137_b((float)x + 0.5D, (float)y + 1.9D, (float)z + 0.5D);
/*  51 */     GlStateManager.func_179114_b((float)-Math.atan2(f5, f3) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
/*  52 */     GlStateManager.func_179114_b((float)-Math.atan2(f6, f4) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
/*  53 */     Tessellator tessellator = Tessellator.func_178181_a();
/*  54 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/*     */     
/*  56 */     GlStateManager.func_179129_p();
/*  57 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(TEXTURE1);
/*  58 */     GlStateManager.func_179103_j(7425);
/*  59 */     float f8 = 0.0F - (ticksExisted + partialTicks) * 0.01F;
/*  60 */     float f9 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5) / 32.0F - (ticksExisted + partialTicks) * 0.01F;
/*  61 */     worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181709_i);
/*  62 */     byte b0 = 8;
/*     */     
/*  64 */     for (int i = 0; i <= b0; i++) {
/*  65 */       float f10 = MathHelper.func_76126_a(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/*  66 */       float f11 = MathHelper.func_76134_b(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/*  67 */       float f12 = i % b0 * 1.0F / b0;
/*  68 */       worldrenderer.func_181662_b(f10 * 0.2F, f11 * 0.2F, 0.0D)
/*  69 */         .func_181673_a(f12, f9)
/*  70 */         .func_181669_b(255, 50, 50, 255)
/*  71 */         .func_181675_d();
/*  72 */       worldrenderer.func_181662_b(f10, f11, f7)
/*  73 */         .func_181673_a(f12, f8)
/*  74 */         .func_181669_b(255, 50, 50, 255)
/*  75 */         .func_181675_d();
/*     */     }
/*     */     
/*  78 */     tessellator.func_78381_a();
/*  79 */     GlStateManager.func_179089_o();
/*  80 */     GlStateManager.func_179103_j(7424);
/*     */     
/*  82 */     GlStateManager.func_179084_k();
/*     */     
/*     */ 
/*     */ 
/*  86 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   public static void draw(Entity source, double renderX, double renderY, double renderZ, float partialTicks, Entity target, int color) {
/*  90 */     GlStateManager.func_179147_l();
/*  91 */     GlStateManager.func_179112_b(770, 1);
/*  92 */     GlStateManager.func_179092_a(516, 0.003921569F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  97 */     float f1 = target.field_70177_z + partialTicks;
/*  98 */     float f2 = MathHelper.func_76126_a(f1 * 0.2F) / 2.0F + 0.5F;
/*  99 */     f2 = (f2 * f2 + f2) * 0.2F;
/* 100 */     double sourceY = source.field_70163_u + source.func_70047_e();
/* 101 */     float f3 = (float)(target.field_70165_t - source.field_70165_t - (source.field_70169_q - source.field_70165_t) * (1.0F - partialTicks));
/* 102 */     float f4 = (float)(f2 + target.field_70163_u - 1.0D - sourceY - (source.field_70167_r - source.field_70163_u) * (1.0F - partialTicks));
/* 103 */     float f5 = (float)(target.field_70161_v - source.field_70161_v - (source.field_70166_s - source.field_70161_v) * (1.0F - partialTicks));
/* 104 */     float f6 = MathHelper.func_76129_c(f3 * f3 + f5 * f5);
/* 105 */     float f7 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5);
/* 106 */     GlStateManager.func_179094_E();
/* 107 */     GlStateManager.func_179109_b((float)renderX, (float)renderY + source.func_70047_e(), (float)renderZ);
/* 108 */     GlStateManager.func_179114_b((float)-Math.atan2(f5, f3) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
/* 109 */     GlStateManager.func_179114_b((float)-Math.atan2(f6, f4) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
/* 110 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 111 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 112 */     RenderHelper.func_74518_a();
/* 113 */     GlStateManager.func_179129_p();
/* 114 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(TEXTURE1);
/* 115 */     GlStateManager.func_179103_j(7425);
/* 116 */     float f8 = 0.0F - (source.field_70173_aa + partialTicks) * 0.01F;
/* 117 */     float f9 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5) / 32.0F - (source.field_70173_aa + partialTicks) * 0.01F;
/* 118 */     worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181709_i);
/* 119 */     byte b0 = 8;
/*     */     
/* 121 */     float a = (color >> 24 & 0xFF) / 256.0F;
/* 122 */     if (a == 0.0F) {
/* 123 */       a = 255.0F;
/*     */     }
/* 125 */     float r = (color >> 16 & 0xFF) / 256.0F;
/* 126 */     float g = (color >> 8 & 0xFF) / 256.0F;
/* 127 */     float b = (color & 0xFF) / 256.0F;
/*     */     
/* 129 */     for (int i = 0; i <= b0; i++) {
/* 130 */       float f10 = MathHelper.func_76126_a(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/* 131 */       float f11 = MathHelper.func_76134_b(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/* 132 */       float f12 = i % b0 * 1.0F / b0;
/*     */       
/* 134 */       worldrenderer.func_181662_b(f10 * 0.2F, f11 * 0.2F, 0.0D)
/* 135 */         .func_181673_a(f12, f9)
/* 136 */         .func_181669_b(0, 0, 0, 255)
/* 137 */         .func_181675_d();
/*     */       
/* 139 */       worldrenderer.func_181662_b(f10, f11, f7)
/* 140 */         .func_181673_a(f12, f8)
/* 141 */         .func_181666_a(r, g, b, a)
/* 142 */         .func_181675_d();
/*     */     }
/*     */     
/* 145 */     tessellator.func_78381_a();
/* 146 */     GlStateManager.func_179089_o();
/* 147 */     GlStateManager.func_179103_j(7424);
/* 148 */     GlStateManager.func_179084_k();
/* 149 */     RenderHelper.func_74519_b();
/* 150 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   public static void draw(Entity source, double renderX, double renderY, double renderZ, float partialTicks, Vec3 target, float targetYaw, int color) {
/* 154 */     GlStateManager.func_179147_l();
/* 155 */     GlStateManager.func_179112_b(770, 771);
/* 156 */     GlStateManager.func_179092_a(516, 0.01F);
/*     */     
/* 158 */     float f1 = targetYaw + partialTicks;
/* 159 */     float f2 = MathHelper.func_76126_a(f1 * 0.2F) / 2.0F + 0.5F;
/* 160 */     f2 = (f2 * f2 + f2) * 0.2F;
/* 161 */     double sourceY = source.field_70163_u + source.field_70131_O / 2.0F;
/* 162 */     float f3 = (float)(target.field_72450_a - source.field_70165_t - (source.field_70169_q - source.field_70165_t) * (1.0F - partialTicks));
/* 163 */     float f4 = (float)(f2 + target.field_72448_b - 1.0D - sourceY - (source.field_70167_r - source.field_70163_u) * (1.0F - partialTicks));
/* 164 */     float f5 = (float)(target.field_72449_c - source.field_70161_v - (source.field_70166_s - source.field_70161_v) * (1.0F - partialTicks));
/* 165 */     float f6 = MathHelper.func_76129_c(f3 * f3 + f5 * f5);
/* 166 */     float f7 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5);
/* 167 */     GlStateManager.func_179094_E();
/* 168 */     GlStateManager.func_179109_b((float)renderX, (float)renderY + source.field_70131_O / 2.0F, (float)renderZ);
/* 169 */     GlStateManager.func_179114_b((float)-Math.atan2(f5, f3) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
/* 170 */     GlStateManager.func_179114_b((float)-Math.atan2(f6, f4) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
/* 171 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 172 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 173 */     RenderHelper.func_74518_a();
/* 174 */     GlStateManager.func_179129_p();
/* 175 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(TEXTURE1);
/* 176 */     GlStateManager.func_179103_j(7425);
/*     */     
/* 178 */     float f8 = 0.0F - (source.field_70173_aa + partialTicks) * 0.01F;
/* 179 */     float f9 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5) / 32.0F - (source.field_70173_aa + partialTicks) * 0.01F;
/* 180 */     worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181709_i);
/* 181 */     byte b0 = 8;
/*     */     
/* 183 */     float a = (color >> 24 & 0xFF) / 256.0F;
/* 184 */     if (a == 0.0F) {
/* 185 */       a = 255.0F;
/*     */     }
/* 187 */     float r = (color >> 16 & 0xFF) / 256.0F;
/* 188 */     float g = (color >> 8 & 0xFF) / 256.0F;
/* 189 */     float b = (color & 0xFF) / 256.0F;
/*     */     
/* 191 */     for (int i = 0; i <= b0; i++) {
/* 192 */       float f10 = MathHelper.func_76126_a(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/* 193 */       float f11 = MathHelper.func_76134_b(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/* 194 */       float f12 = i % b0 * 1.0F / b0;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 201 */       worldrenderer.func_181662_b(f10 * 0.2F, f11 * 0.2F, 0.0D)
/* 202 */         .func_181673_a(f12, f9)
/* 203 */         .func_181669_b(0, 0, 0, 255)
/* 204 */         .func_181675_d();
/*     */       
/*     */ 
/* 207 */       worldrenderer.func_181662_b(f10 * 0.10000000149011612D, f11 * 0.10000000149011612D, f7)
/* 208 */         .func_181673_a(f12, f8)
/* 209 */         .func_181666_a(r, g, b, a)
/* 210 */         .func_181675_d();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 215 */     tessellator.func_78381_a();
/* 216 */     GlStateManager.func_179089_o();
/* 217 */     GlStateManager.func_179103_j(7424);
/* 218 */     GlStateManager.func_179084_k();
/* 219 */     RenderHelper.func_74519_b();
/* 220 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   public static void draw(Entity source, Vec3 offsets, double renderX, double renderY, double renderZ, float partialTicks, Vec3 target, float targetYaw, int color) {
/* 224 */     GlStateManager.func_179147_l();
/* 225 */     GlStateManager.func_179112_b(770, 771);
/* 226 */     GlStateManager.func_179092_a(516, 0.01F);
/*     */     
/* 228 */     float f1 = targetYaw + partialTicks;
/* 229 */     float f2 = MathHelper.func_76126_a(f1 * 0.2F) / 2.0F + 0.5F;
/* 230 */     f2 = (f2 * f2 + f2) * 0.2F;
/* 231 */     double sourceY = offsets.field_72448_b + source.field_70163_u + source.field_70131_O / 2.0F;
/* 232 */     float f3 = (float)(offsets.field_72450_a + target.field_72450_a - source.field_70165_t - (source.field_70169_q - source.field_70165_t) * (1.0F - partialTicks));
/* 233 */     float f4 = (float)(f2 + target.field_72448_b - 1.0D - sourceY - (source.field_70167_r - source.field_70163_u) * (1.0F - partialTicks));
/* 234 */     float f5 = (float)(offsets.field_72449_c + target.field_72449_c - source.field_70161_v - (source.field_70166_s - source.field_70161_v) * (1.0F - partialTicks));
/* 235 */     float f6 = MathHelper.func_76129_c(f3 * f3 + f5 * f5);
/* 236 */     float f7 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5);
/* 237 */     GlStateManager.func_179094_E();
/* 238 */     GlStateManager.func_179137_b((float)renderX, (float)renderY + offsets.field_72448_b + source.field_70131_O / 2.0F, (float)renderZ);
/* 239 */     GlStateManager.func_179114_b((float)-Math.atan2(f5, f3) * 180.0F / 3.1415927F - 90.0F, 0.0F, 1.0F, 0.0F);
/* 240 */     GlStateManager.func_179114_b((float)-Math.atan2(f6, f4) * 180.0F / 3.1415927F - 90.0F, 1.0F, 0.0F, 0.0F);
/* 241 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 242 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 243 */     RenderHelper.func_74518_a();
/* 244 */     GlStateManager.func_179129_p();
/* 245 */     Minecraft.func_71410_x().field_71446_o.func_110577_a(TEXTURE1);
/* 246 */     GlStateManager.func_179103_j(7425);
/*     */     
/* 248 */     float f8 = 0.0F - (source.field_70173_aa + partialTicks) * 0.01F;
/* 249 */     float f9 = MathHelper.func_76129_c(f3 * f3 + f4 * f4 + f5 * f5) / 32.0F - (source.field_70173_aa + partialTicks) * 0.01F;
/* 250 */     worldrenderer.func_181668_a(5, DefaultVertexFormats.field_181709_i);
/* 251 */     byte b0 = 8;
/*     */     
/* 253 */     float a = (color >> 24 & 0xFF) / 256.0F;
/* 254 */     if (a == 0.0F) {
/* 255 */       a = 255.0F;
/*     */     }
/* 257 */     float r = (color >> 16 & 0xFF) / 256.0F;
/* 258 */     float g = (color >> 8 & 0xFF) / 256.0F;
/* 259 */     float b = (color & 0xFF) / 256.0F;
/*     */     
/* 261 */     for (int i = 0; i <= b0; i++) {
/* 262 */       float f10 = MathHelper.func_76126_a(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/* 263 */       float f11 = MathHelper.func_76134_b(i % b0 * 3.1415927F * 2.0F / b0) * 0.75F;
/* 264 */       float f12 = i % b0 * 1.0F / b0;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 270 */       worldrenderer.func_181662_b(f10 * 0.2F, f11 * 0.2F, 0.0D)
/* 271 */         .func_181673_a(f12, f9)
/* 272 */         .func_181669_b(0, 0, 0, 255)
/* 273 */         .func_181675_d();
/*     */       
/* 275 */       worldrenderer.func_181662_b(f10 * 0.10000000149011612D, f11 * 0.10000000149011612D, f7)
/* 276 */         .func_181673_a(f12, f8)
/* 277 */         .func_181666_a(r, g, b, a)
/* 278 */         .func_181675_d();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 283 */     tessellator.func_78381_a();
/* 284 */     GlStateManager.func_179089_o();
/* 285 */     GlStateManager.func_179103_j(7424);
/* 286 */     GlStateManager.func_179084_k();
/* 287 */     RenderHelper.func_74519_b();
/* 288 */     GlStateManager.func_179121_F();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/particle/BeamFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */