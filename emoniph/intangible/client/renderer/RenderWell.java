/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.blocks.BlockWellOfSoulsCore.TileEntityWellOfSoulsCore;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.ActiveRenderInfo;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.GlStateManager.TexGen;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderWell extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  23 */   private static final ResourceLocation SKY_TEXTURE = new ResourceLocation("textures/environment/end_sky.png");
/*  24 */   private static final ResourceLocation PORTAL_TEXTURE = new ResourceLocation("intangible", "textures/blocks/wellofsoulsfield.png");
/*     */   
/*  26 */   private static final Random random = new Random(31100L);
/*     */   
/*  28 */   FloatBuffer buffer = net.minecraft.client.renderer.GLAllocation.func_74529_h(16);
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double renderX, double renderY, double renderZ, float partialTicks, int partialBlockDamage)
/*     */   {
/*  32 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  33 */     if ((state.func_177230_c() != emoniph.intangible.Get.blocks().WELL_OF_SOULS) && (state.func_177230_c() != emoniph.intangible.Get.blocks().WELL_OF_SOULS_CORE)) {
/*  34 */       return;
/*     */     }
/*     */     
/*  37 */     float f = (float)this.field_147501_a.field_147560_j;
/*  38 */     float f1 = (float)this.field_147501_a.field_147561_k;
/*  39 */     float f2 = (float)this.field_147501_a.field_147558_l;
/*  40 */     GlStateManager.func_179140_f();
/*  41 */     random.setSeed(31100L);
/*  42 */     float f3 = 0.75F;
/*     */     
/*  44 */     for (int i = 0; i < 16; i++) {
/*  45 */       GlStateManager.func_179094_E();
/*  46 */       float f4 = 16 - i;
/*  47 */       float f5 = 0.0625F;
/*  48 */       float f6 = 1.0F / (f4 + 1.0F);
/*     */       
/*  50 */       if (i == 0) {
/*  51 */         func_147499_a(SKY_TEXTURE);
/*  52 */         f6 = 0.1F;
/*  53 */         f4 = 65.0F;
/*  54 */         f5 = 0.125F;
/*  55 */         GlStateManager.func_179147_l();
/*  56 */         GlStateManager.func_179112_b(770, 771);
/*     */       }
/*     */       
/*  59 */       if (i >= 1) {
/*  60 */         func_147499_a(PORTAL_TEXTURE);
/*     */       }
/*     */       
/*  63 */       if (i == 1) {
/*  64 */         GlStateManager.func_179147_l();
/*  65 */         GlStateManager.func_179112_b(1, 1);
/*  66 */         f5 = 0.5F;
/*     */       }
/*     */       
/*  69 */       float f7 = (float)-(renderY + f3);
/*  70 */       float f8 = f7 + (float)ActiveRenderInfo.func_178804_a().field_72448_b;
/*  71 */       float f9 = f7 + f4 + (float)ActiveRenderInfo.func_178804_a().field_72448_b;
/*  72 */       float f10 = f8 / f9;
/*  73 */       f10 = (float)(renderY + f3) + f10;
/*  74 */       GlStateManager.func_179109_b(f, f10, f2);
/*  75 */       GlStateManager.func_179149_a(GlStateManager.TexGen.S, 9217);
/*  76 */       GlStateManager.func_179149_a(GlStateManager.TexGen.T, 9217);
/*  77 */       GlStateManager.func_179149_a(GlStateManager.TexGen.R, 9217);
/*  78 */       GlStateManager.func_179149_a(GlStateManager.TexGen.Q, 9216);
/*  79 */       GlStateManager.func_179105_a(GlStateManager.TexGen.S, 9473, func_147525_a(1.0F, 0.0F, 0.0F, 0.0F));
/*  80 */       GlStateManager.func_179105_a(GlStateManager.TexGen.T, 9473, func_147525_a(0.0F, 0.0F, 1.0F, 0.0F));
/*  81 */       GlStateManager.func_179105_a(GlStateManager.TexGen.R, 9473, func_147525_a(0.0F, 0.0F, 0.0F, 1.0F));
/*  82 */       GlStateManager.func_179105_a(GlStateManager.TexGen.Q, 9474, func_147525_a(0.0F, 1.0F, 0.0F, 0.0F));
/*  83 */       GlStateManager.func_179087_a(GlStateManager.TexGen.S);
/*  84 */       GlStateManager.func_179087_a(GlStateManager.TexGen.T);
/*  85 */       GlStateManager.func_179087_a(GlStateManager.TexGen.R);
/*  86 */       GlStateManager.func_179087_a(GlStateManager.TexGen.Q);
/*  87 */       GlStateManager.func_179121_F();
/*  88 */       GlStateManager.func_179128_n(5890);
/*  89 */       GlStateManager.func_179094_E();
/*  90 */       GlStateManager.func_179096_D();
/*  91 */       GlStateManager.func_179109_b(0.0F, (float)(Minecraft.func_71386_F() % 700000L) / 700000.0F, 0.0F);
/*  92 */       GlStateManager.func_179152_a(f5, f5, f5);
/*  93 */       GlStateManager.func_179109_b(0.5F, 0.5F, 0.0F);
/*  94 */       GlStateManager.func_179114_b((i * i * 4321 + i * 9) * 2.0F, 0.0F, 0.0F, 1.0F);
/*  95 */       GlStateManager.func_179109_b(-0.5F, -0.5F, 0.0F);
/*  96 */       GlStateManager.func_179109_b(-f, -f2, -f1);
/*  97 */       f8 = f7 + (float)ActiveRenderInfo.func_178804_a().field_72448_b;
/*  98 */       GlStateManager.func_179109_b((float)ActiveRenderInfo.func_178804_a().field_72450_a * f4 / f8, (float)ActiveRenderInfo.func_178804_a().field_72449_c * f4 / f8, -f1);
/*  99 */       Tessellator tessellator = Tessellator.func_178181_a();
/* 100 */       WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 101 */       worldrenderer.func_181668_a(7, net.minecraft.client.renderer.vertex.DefaultVertexFormats.field_181706_f);
/* 102 */       float f11 = (random.nextFloat() * 0.5F + 0.1F) * f6;
/* 103 */       float f12 = (random.nextFloat() * 0.5F + 0.4F) * f6;
/* 104 */       float f13 = (random.nextFloat() * 0.5F + 0.5F) * f6;
/*     */       
/* 106 */       if (i == 0) {
/* 107 */         f11 = f12 = f13 = 1.0F * f6;
/*     */       }
/*     */       
/* 110 */       worldrenderer.func_181662_b(renderX, renderY + f3, renderZ).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 111 */       worldrenderer.func_181662_b(renderX, renderY + f3, renderZ + 1.0D).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 112 */       worldrenderer.func_181662_b(renderX + 1.0D, renderY + f3, renderZ + 1.0D).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 113 */       worldrenderer.func_181662_b(renderX + 1.0D, renderY + f3, renderZ).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 114 */       tessellator.func_78381_a();
/*     */       
/* 116 */       worldrenderer.func_181668_a(7, net.minecraft.client.renderer.vertex.DefaultVertexFormats.field_181706_f);
/* 117 */       worldrenderer.func_181662_b(renderX + 1.0D, renderY + f3 - 0.1D, renderZ).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 118 */       worldrenderer.func_181662_b(renderX + 1.0D, renderY + f3 - 0.1D, renderZ + 1.0D).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 119 */       worldrenderer.func_181662_b(renderX, renderY + f3 - 0.1D, renderZ + 1.0D).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 120 */       worldrenderer.func_181662_b(renderX, renderY + f3 - 0.1D, renderZ).func_181666_a(f11, f12, f13, 1.0F).func_181675_d();
/* 121 */       tessellator.func_78381_a();
/*     */       
/* 123 */       GlStateManager.func_179121_F();
/* 124 */       GlStateManager.func_179128_n(5888);
/* 125 */       func_147499_a(SKY_TEXTURE);
/*     */     }
/*     */     
/* 128 */     GlStateManager.func_179084_k();
/* 129 */     GlStateManager.func_179100_b(GlStateManager.TexGen.S);
/* 130 */     GlStateManager.func_179100_b(GlStateManager.TexGen.T);
/* 131 */     GlStateManager.func_179100_b(GlStateManager.TexGen.R);
/* 132 */     GlStateManager.func_179100_b(GlStateManager.TexGen.Q);
/* 133 */     GlStateManager.func_179145_e();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 252 */     if ((tile instanceof BlockWellOfSoulsCore.TileEntityWellOfSoulsCore)) {
/* 253 */       BlockWellOfSoulsCore.TileEntityWellOfSoulsCore well = (BlockWellOfSoulsCore.TileEntityWellOfSoulsCore)tile;
/*     */       
/*     */ 
/* 256 */       Minecraft mc = Minecraft.func_71410_x();
/* 257 */       double dsq = mc.field_71439_g.func_174818_b(tile.func_174877_v());
/* 258 */       double maxRangeSq = 36.0D;
/* 259 */       if (dsq < maxRangeSq) {
/* 260 */         GlStateManager.func_179094_E();
/* 261 */         GlStateManager.func_179137_b(renderX + 0.5D, renderY + 2.0D, renderZ + 0.5D);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 266 */         GlStateManager.func_179114_b(-mc.func_175598_ae().field_78735_i, 0.0F, 1.0F, 0.0F);
/* 267 */         GlStateManager.func_179114_b(mc.func_175598_ae().field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 273 */         double scale = 0.02D * (0.8D - dsq / maxRangeSq + 0.2D);
/* 274 */         GlStateManager.func_179139_a(-scale, -scale, scale);
/*     */         
/* 276 */         GlStateManager.func_179140_f();
/*     */         
/*     */ 
/*     */ 
/* 280 */         FontRenderer fontRenderer = mc.func_175598_ae().func_78716_a();
/*     */         
/* 282 */         String text = well.formatSouls();
/* 283 */         if ((text != null) && (!text.isEmpty())) {
/* 284 */           int wrapWidth = 200;
/* 285 */           List lines = fontRenderer.func_78271_c(text, wrapWidth);
/* 286 */           int maxWidth = 0;
/* 287 */           int[] widths = new int[lines.size()];
/* 288 */           int i = 0; for (int count = lines.size(); i < count; i++) {
/* 289 */             widths[i] = fontRenderer.func_78256_a((String)lines.get(i));
/* 290 */             maxWidth = Math.max(widths[i], maxWidth);
/*     */           }
/* 292 */           int height = fontRenderer.field_78288_b * lines.size();
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 306 */           int textX = -maxWidth / 2;
/* 307 */           int textY = 0;
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 313 */           textY = -1;
/* 314 */           int i = 0; for (int count = lines.size(); i < count; textY += fontRenderer.field_78288_b) {
/* 315 */             fontRenderer.func_175065_a((String)lines.get(i), textX + (maxWidth - widths[i]) / 2, textY, -1862270977, false);i++;
/*     */           }
/*     */         }
/* 318 */         GlStateManager.func_179145_e();
/* 319 */         GlStateManager.func_179121_F();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private FloatBuffer func_147525_a(float p_147525_1_, float p_147525_2_, float p_147525_3_, float p_147525_4_)
/*     */   {
/* 326 */     this.buffer.clear();
/* 327 */     this.buffer.put(p_147525_1_).put(p_147525_2_).put(p_147525_3_).put(p_147525_4_);
/* 328 */     this.buffer.flip();
/* 329 */     return this.buffer;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderWell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */