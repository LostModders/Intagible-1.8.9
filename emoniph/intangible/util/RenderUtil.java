/*     */ package emoniph.intangible.util;
/*     */ 
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.ItemModelMesher;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureAtlasSprite;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public enum RenderUtil
/*     */ {
/*     */   private RenderUtil() {}
/*     */   
/*     */   public static float[] toHsv(int color)
/*     */   {
/*  23 */     float r = (color >> 16 & 0xFF) / 256.0F;
/*  24 */     float g = (color >> 8 & 0xFF) / 256.0F;
/*  25 */     float b = (color & 0xFF) / 256.0F;
/*  26 */     return toHsv(r, g, b);
/*     */   }
/*     */   
/*     */   public static float[] toHsv(float[] rgb) {
/*  30 */     return toHsv(rgb[0], rgb[1], rgb[2]);
/*     */   }
/*     */   
/*     */ 
/*     */   public static float[] toHsv(float r, float g, float b)
/*     */   {
/*  36 */     float max = Math.max(r, Math.max(g, b));
/*  37 */     float min = Math.min(r, Math.max(g, b));
/*  38 */     float h = 0.0F;
/*  39 */     float v = max;
/*  40 */     float d = max - min;
/*  41 */     float s = max == 0.0F ? 0.0F : d / max;
/*     */     
/*  43 */     if (max == min) {
/*  44 */       h = 0.0F;
/*     */     } else {
/*  46 */       if (max == r) {
/*  47 */         h = (g - b) / d + (g < b ? 6 : 0);
/*  48 */       } else if (max == g) {
/*  49 */         h = (b - r) / d + 2.0F;
/*  50 */       } else if (max == b) {
/*  51 */         h = (r - g) / d + 4.0F;
/*     */       }
/*     */       
/*  54 */       h /= 6.0F;
/*     */     }
/*     */     
/*  57 */     return new float[] { h, s, v };
/*     */   }
/*     */   
/*     */   public static float[] toRgb(float[] hsv) {
/*  61 */     float r = 0.0F;float g = 0.0F;float b = 0.0F;
/*  62 */     float h = hsv[0];
/*  63 */     float s = hsv[1];
/*  64 */     float v = hsv[2];
/*     */     
/*  66 */     int i = (int)Math.floor(h * 6.0F);
/*  67 */     float f = h * 6.0F - i;
/*  68 */     float p = v * (1.0F - s);
/*  69 */     float q = v * (1.0F - f * s);
/*  70 */     float t = v * (1.0F - (1.0F - f) * s);
/*     */     
/*  72 */     switch (i % 6) {
/*  73 */     case 0:  r = v;g = t;b = p; break;
/*  74 */     case 1:  r = q;g = v;b = p; break;
/*  75 */     case 2:  r = p;g = v;b = t; break;
/*  76 */     case 3:  r = p;g = q;b = v; break;
/*  77 */     case 4:  r = t;g = p;b = v; break;
/*  78 */     case 5:  r = v;g = p;b = q;
/*     */     }
/*     */     
/*  81 */     return new float[] { r, g, b };
/*     */   }
/*     */   
/*     */   public static void color(int color, float alpha) {
/*  85 */     float r = (color >> 16 & 0xFF) / 256.0F;
/*  86 */     float g = (color >> 8 & 0xFF) / 256.0F;
/*  87 */     float b = (color & 0xFF) / 256.0F;
/*     */     
/*  89 */     GlStateManager.func_179131_c(r, g, b, alpha);
/*     */   }
/*     */   
/*     */   public static void color(int color) {
/*  93 */     float alpha = (color >> 24 & 0xFF) / 256.0F;
/*  94 */     if (alpha == 0.0F) {
/*  95 */       alpha = 1.0F;
/*     */     }
/*  97 */     color(color, alpha);
/*     */   }
/*     */   
/*     */   public static void color(WorldRenderer renderer, int color) {
/* 101 */     float alpha = (color >> 24 & 0xFF) / 256.0F;
/* 102 */     if (alpha == 0.0F) {
/* 103 */       alpha = 1.0F;
/*     */     }
/* 105 */     color(renderer, color, alpha);
/*     */   }
/*     */   
/*     */   public static void color(WorldRenderer renderer, int color, float alpha) {
/* 109 */     float r = (color >> 16 & 0xFF) / 256.0F;
/* 110 */     float g = (color >> 8 & 0xFF) / 256.0F;
/* 111 */     float b = (color & 0xFF) / 256.0F;
/*     */     
/* 113 */     renderer.func_181666_a(r, g, b, alpha);
/*     */   }
/*     */   
/*     */   public static void resetColor() {
/* 117 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static int makeColor(int r, int g, int b) {
/* 121 */     return (r << 16) + (g << 8) + b;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void drawTexturedModelRectFromIconInverted(int par1, int par2, TextureAtlasSprite par3Icon, int par4, int par5, float zLevel) {
/* 126 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 127 */     WorldRenderer worldRenderer = tessellator.func_178180_c();
/* 128 */     worldRenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/*     */     
/* 130 */     worldRenderer.func_181662_b(par1 + 0, par2 + 0, zLevel).func_181673_a(par3Icon.func_94209_e(), par3Icon.func_94210_h()).func_181675_d();
/* 131 */     worldRenderer.func_181662_b(par1 + par4, par2 + 0, zLevel).func_181673_a(par3Icon.func_94212_f(), par3Icon.func_94210_h()).func_181675_d();
/* 132 */     worldRenderer.func_181662_b(par1 + par4, par2 - par5, zLevel).func_181673_a(par3Icon.func_94212_f(), par3Icon.func_94206_g()).func_181675_d();
/* 133 */     worldRenderer.func_181662_b(par1 + 0, par2 - par5, zLevel).func_181673_a(par3Icon.func_94209_e(), par3Icon.func_94206_g()).func_181675_d();
/* 134 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void drawTexturedModalRect(int x, int y, int textureX, int textureY, int width, int height, float zLevel) {
/* 139 */     float f = 0.00390625F;
/* 140 */     float f1 = 0.00390625F;
/* 141 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 142 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 143 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 144 */     worldrenderer.func_181662_b(x + 0, y + height, zLevel).func_181673_a((textureX + 0) * f, (textureY + height) * f1).func_181675_d();
/* 145 */     worldrenderer.func_181662_b(x + width, y + height, zLevel).func_181673_a((textureX + width) * f, (textureY + height) * f1).func_181675_d();
/* 146 */     worldrenderer.func_181662_b(x + width, y + 0, zLevel).func_181673_a((textureX + width) * f, (textureY + 0) * f1).func_181675_d();
/* 147 */     worldrenderer.func_181662_b(x + 0, y + 0, zLevel).func_181673_a((textureX + 0) * f, (textureY + 0) * f1).func_181675_d();
/* 148 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV, float zLevel) {
/* 153 */     float f2 = 0.00390625F;
/* 154 */     float f3 = 0.00390625F;
/* 155 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 156 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 157 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 158 */     worldrenderer.func_181662_b(xCoord + 0.0F, yCoord + maxV, zLevel).func_181673_a((minU + 0) * f2, (minV + maxV) * f3).func_181675_d();
/* 159 */     worldrenderer.func_181662_b(xCoord + maxU, yCoord + maxV, zLevel).func_181673_a((minU + maxU) * f2, (minV + maxV) * f3).func_181675_d();
/* 160 */     worldrenderer.func_181662_b(xCoord + maxU, yCoord + 0.0F, zLevel).func_181673_a((minU + maxU) * f2, (minV + 0) * f3).func_181675_d();
/* 161 */     worldrenderer.func_181662_b(xCoord + 0.0F, yCoord + 0.0F, zLevel).func_181673_a((minU + 0) * f2, (minV + 0) * f3).func_181675_d();
/* 162 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void drawTexturedModalRect(int xCoord, int yCoord, TextureAtlasSprite textureSprite, int p_175175_4_, int p_175175_5_, float zLevel) {
/* 167 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 168 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 169 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 170 */     worldrenderer.func_181662_b(xCoord + 0, yCoord + p_175175_5_, zLevel).func_181673_a(textureSprite.func_94209_e(), textureSprite.func_94210_h()).func_181675_d();
/* 171 */     worldrenderer.func_181662_b(xCoord + p_175175_4_, yCoord + p_175175_5_, zLevel).func_181673_a(textureSprite.func_94212_f(), textureSprite.func_94210_h()).func_181675_d();
/* 172 */     worldrenderer.func_181662_b(xCoord + p_175175_4_, yCoord + 0, zLevel).func_181673_a(textureSprite.func_94212_f(), textureSprite.func_94206_g()).func_181675_d();
/* 173 */     worldrenderer.func_181662_b(xCoord + 0, yCoord + 0, zLevel).func_181673_a(textureSprite.func_94209_e(), textureSprite.func_94206_g()).func_181675_d();
/* 174 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void drawModalRectWithCustomSizedTexture(int x, int y, float u, float v, int width, int height, float textureWidth, float textureHeight) {
/* 179 */     float f4 = 1.0F / textureWidth;
/* 180 */     float f5 = 1.0F / textureHeight;
/* 181 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 182 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 183 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 184 */     worldrenderer.func_181662_b(x, y + height, 0.0D).func_181673_a(u * f4, (v + height) * f5).func_181675_d();
/* 185 */     worldrenderer.func_181662_b(x + width, y + height, 0.0D).func_181673_a((u + width) * f4, (v + height) * f5).func_181675_d();
/* 186 */     worldrenderer.func_181662_b(x + width, y, 0.0D).func_181673_a((u + width) * f4, v * f5).func_181675_d();
/* 187 */     worldrenderer.func_181662_b(x, y, 0.0D).func_181673_a(u * f4, v * f5).func_181675_d();
/* 188 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void drawModalRectWithCustomSizedTexture(float x, float y, float u, float v, int width, int height, float textureWidth, float textureHeight) {
/* 193 */     float f4 = 1.0F / textureWidth;
/* 194 */     float f5 = 1.0F / textureHeight;
/* 195 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 196 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 197 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 198 */     worldrenderer.func_181662_b(x, y + height, 0.0D).func_181673_a(u * f4, (v + height) * f5).func_181675_d();
/* 199 */     worldrenderer.func_181662_b(x + width, y + height, 0.0D).func_181673_a((u + width) * f4, (v + height) * f5).func_181675_d();
/* 200 */     worldrenderer.func_181662_b(x + width, y, 0.0D).func_181673_a((u + width) * f4, v * f5).func_181675_d();
/* 201 */     worldrenderer.func_181662_b(x, y, 0.0D).func_181673_a(u * f4, v * f5).func_181675_d();
/* 202 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void drawScaledCustomSizeModalRect(float x, float y, int u, int v, int uWidth, int vHeight, float width, float height, float tileWidth, float tileHeight) {
/* 207 */     float f4 = 1.0F / tileWidth;
/* 208 */     float f5 = 1.0F / tileHeight;
/*     */     
/* 210 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 211 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 212 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181707_g);
/* 213 */     worldrenderer.func_181662_b(x, y + height, 0.0D).func_181673_a(u * f4, (v + vHeight) * f5).func_181675_d();
/* 214 */     worldrenderer.func_181662_b(x + width, y + height, 0.0D).func_181673_a((u + uWidth) * f4, (v + vHeight) * f5).func_181675_d();
/* 215 */     worldrenderer.func_181662_b(x + width, y, 0.0D).func_181673_a((u + uWidth) * f4, v * f5).func_181675_d();
/* 216 */     worldrenderer.func_181662_b(x, y, 0.0D).func_181673_a(u * f4, v * f5).func_181675_d();
/* 217 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static void drawStack(ItemStack stack, float x, float y, RenderItem renderItem, FontRenderer font) {
/* 222 */     if (stack != null) {
/* 223 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*     */       
/* 225 */       GlStateManager.func_179140_f();
/* 226 */       GlStateManager.func_179091_B();
/* 227 */       GlStateManager.func_179141_d();
/* 228 */       GlStateManager.func_179092_a(516, 0.1F);
/* 229 */       GlStateManager.func_179147_l();
/* 230 */       GlStateManager.func_179112_b(770, 771);
/* 231 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 232 */       GlStateManager.func_179109_b(x, y, 0.0F);
/* 233 */       GlStateManager.func_179152_a(32.0F, 32.0F, 0.0F);
/* 234 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*     */       
/* 236 */       renderItem.func_180454_a(stack, renderItem.func_175037_a().func_178089_a(stack.func_77952_i() == 32767 ? new ItemStack(stack.func_77973_b()) : stack));
/*     */       
/* 238 */       GlStateManager.func_179152_a(0.03125F, 0.03125F, 0.0F);
/* 239 */       GlStateManager.func_179114_b(-180.0F, 0.0F, 0.0F, 1.0F);
/* 240 */       GlStateManager.func_179109_b(-x, -y, 0.0F);
/*     */       
/* 242 */       if (stack.field_77994_a > 1) {
/* 243 */         GlStateManager.func_179097_i();
/*     */         
/* 245 */         String sz = Integer.valueOf(stack.field_77994_a).toString();
/* 246 */         font.func_175063_a(sz, x + 12.0F - font.func_78256_a(sz), y + 4.0F, 16777215);
/*     */         
/* 248 */         GlStateManager.func_179126_j();
/*     */       }
/*     */       
/* 251 */       GlStateManager.func_179126_j();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/RenderUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */