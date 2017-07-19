/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.blocks.BlockDeityBuilder.TileEntityDeityBuilder;
/*     */ import emoniph.intangible.blocks.BlockDeityBuilder.TileEntityDeityBuilder.BeamSegment;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelDeityBuilder;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.util.TextUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderDeityBuilder extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  30 */   private ModelDeityBuilder model = new ModelDeityBuilder();
/*     */   
/*     */ 
/*  33 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/deitybuilder.png");
/*     */   
/*  35 */   private static final ResourceLocation beaconBeam = new ResourceLocation("textures/entity/beacon_beam.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  39 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  40 */     if ((state.func_177230_c() == emoniph.intangible.Get.blocks().DEITY_BUILDER) && ((tile instanceof BlockDeityBuilder.TileEntityDeityBuilder))) {
/*  41 */       GlStateManager.func_179094_E();
/*     */       
/*  43 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*     */       
/*  45 */       BlockDeityBuilder.TileEntityDeityBuilder builder = (BlockDeityBuilder.TileEntityDeityBuilder)tile;
/*     */       
/*  47 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  48 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*  50 */       func_147499_a(TEXTURE);
/*  51 */       Minecraft mc = Minecraft.func_71410_x();
/*     */       
/*  53 */       float QUARTER_PI = 0.7853982F;
/*     */       
/*  55 */       float progress = builder.startTicks / 100.0F;
/*     */       
/*     */ 
/*  58 */       int minExpand = 6;
/*  59 */       if (builder.isActive()) {
/*  60 */         double angle = mc.field_71441_e.func_72820_D() % 360L;
/*  61 */         for (int i = 0; i < this.model.tier[0].length; i++) {
/*  62 */           for (int j = 0; j < this.model.tier.length; j++) {
/*  63 */             int dir = j == 6 ? -1 : 1;
/*  64 */             this.model.tier[j][i].field_78796_g = (dir * (float)Math.toRadians(angle * (j % 5 + 3)) + 0.7853982F * i);
/*     */             
/*  66 */             if (j > minExpand) {
/*  67 */               float scale = (j - minExpand) * (j - minExpand);
/*  68 */               this.model.tier[j][i].field_78797_d = (ModelDeityBuilder.TIER_START_Y[j] - progress * 0.4F * scale * 0.7F);
/*     */             }
/*     */           }
/*     */         }
/*     */       } else {
/*  73 */         for (int i = 0; i < this.model.tier[0].length; i++) {
/*  74 */           for (int j = 0; j < this.model.tier.length; j++) {
/*  75 */             this.model.tier[j][i].field_78796_g = (0.7853982F * i);
/*  76 */             if (j > minExpand) {
/*  77 */               float scale = (j - minExpand) * (j - minExpand);
/*  78 */               this.model.tier[j][i].field_78797_d = (ModelDeityBuilder.TIER_START_Y[j] - progress * 0.4F * scale * 0.7F);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  84 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/*  86 */       GlStateManager.func_179121_F();
/*     */       
/*     */ 
/*  89 */       float f1 = builder.shouldBeamRender();
/*  90 */       GlStateManager.func_179092_a(516, 0.1F);
/*     */       double d4;
/*  92 */       if (f1 > 0.0F) {
/*  93 */         Tessellator tessellator = Tessellator.func_178181_a();
/*  94 */         WorldRenderer worldrenderer = tessellator.func_178180_c();
/*  95 */         List list = builder.func_174907_n();
/*  96 */         int j = 0;
/*     */         
/*     */ 
/*  99 */         for (int k = 0; k < list.size(); k++) {
/* 100 */           BlockDeityBuilder.TileEntityDeityBuilder.BeamSegment beamsegment = (BlockDeityBuilder.TileEntityDeityBuilder.BeamSegment)list.get(k);
/* 101 */           int l = j + beamsegment.func_177264_c();
/* 102 */           func_147499_a(beaconBeam);
/* 103 */           GL11.glTexParameterf(3553, 10242, 10497.0F);
/* 104 */           GL11.glTexParameterf(3553, 10243, 10497.0F);
/* 105 */           GlStateManager.func_179140_f();
/* 106 */           GlStateManager.func_179129_p();
/* 107 */           GlStateManager.func_179084_k();
/* 108 */           GlStateManager.func_179132_a(true);
/* 109 */           GlStateManager.func_179120_a(770, 1, 1, 0);
/* 110 */           float f2 = (float)builder.func_145831_w().func_82737_E() + partialTicks;
/* 111 */           float f3 = -f2 * 0.2F - MathHelper.func_76141_d(-f2 * 0.1F);
/* 112 */           double d3 = f2 * 0.025D * -1.5D;
/*     */           
/* 114 */           worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/* 115 */           d4 = 0.3D;
/* 116 */           double d5 = 0.5D + Math.cos(d3 + 2.356194490192345D) * d4;
/* 117 */           double d6 = 0.5D + Math.sin(d3 + 2.356194490192345D) * d4;
/* 118 */           double d7 = 0.5D + Math.cos(d3 + 0.7853981633974483D) * d4;
/* 119 */           double d8 = 0.5D + Math.sin(d3 + 0.7853981633974483D) * d4;
/* 120 */           double d9 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * d4;
/* 121 */           double d10 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * d4;
/* 122 */           double d11 = 0.5D + Math.cos(d3 + 5.497787143782138D) * d4;
/* 123 */           double d12 = 0.5D + Math.sin(d3 + 5.497787143782138D) * d4;
/* 124 */           double d13 = 0.0D;
/* 125 */           double d14 = 1.0D;
/* 126 */           double d15 = -1.0F + f3;
/* 127 */           double d16 = beamsegment.func_177264_c() * f1 * (0.5D / d4) + d15;
/*     */           
/* 129 */           worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 130 */           worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 131 */           worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 132 */           worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 133 */           worldrenderer.func_181662_b(x + d11, y + l, z + d12).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 134 */           worldrenderer.func_181662_b(x + d11, y + j, z + d12).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 135 */           worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 136 */           worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 137 */           worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 138 */           worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 139 */           worldrenderer.func_181662_b(x + d11, y + j, z + d12).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 140 */           worldrenderer.func_181662_b(x + d11, y + l, z + d12).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 141 */           worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 142 */           worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 143 */           worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 144 */           worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 145 */           tessellator.func_78381_a();
/* 146 */           GlStateManager.func_179147_l();
/* 147 */           GlStateManager.func_179120_a(770, 771, 1, 0);
/* 148 */           GlStateManager.func_179132_a(false);
/* 149 */           worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */           
/* 151 */           d3 = 0.2D;
/* 152 */           d4 = 0.2D;
/* 153 */           d5 = 0.8D;
/* 154 */           d6 = 0.2D;
/* 155 */           d7 = 0.2D;
/* 156 */           d8 = 0.8D;
/* 157 */           d9 = 0.8D;
/* 158 */           d10 = 0.8D;
/* 159 */           d11 = 0.0D;
/* 160 */           d12 = 1.0D;
/* 161 */           d13 = -1.0F + f3;
/* 162 */           d14 = beamsegment.func_177264_c() * f1 + d13;
/* 163 */           worldrenderer.func_181662_b(x + d3, y + l, z + d4).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 164 */           worldrenderer.func_181662_b(x + d3, y + j, z + d4).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 165 */           worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 166 */           worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 167 */           worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 168 */           worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 169 */           worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 170 */           worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 171 */           worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 172 */           worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 173 */           worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 174 */           worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 175 */           worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 176 */           worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 177 */           worldrenderer.func_181662_b(x + d3, y + j, z + d4).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 178 */           worldrenderer.func_181662_b(x + d3, y + l, z + d4).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 179 */           tessellator.func_78381_a();
/* 180 */           GlStateManager.func_179145_e();
/* 181 */           GlStateManager.func_179098_w();
/* 182 */           GlStateManager.func_179132_a(true);
/* 183 */           j = l;
/*     */         }
/*     */       } else {
/* 186 */         double dsq = mc.field_71439_g.func_174818_b(tile.func_174877_v());
/* 187 */         double maxRangeSq = 36.0D;
/* 188 */         if (dsq < maxRangeSq) {
/* 189 */           ISoulSet all = builder.getClientSoulCosts();
/* 190 */           if (all != null) {
/* 191 */             GlStateManager.func_179094_E();
/* 192 */             GlStateManager.func_179137_b(x + 0.5D, y + 2.5D, z - 1.5D);
/*     */             
/* 194 */             GlStateManager.func_179114_b(-mc.func_175598_ae().field_78735_i, 0.0F, 1.0F, 0.0F);
/* 195 */             GlStateManager.func_179114_b(mc.func_175598_ae().field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */             
/* 197 */             double scale = 0.02D * (0.8D - dsq / maxRangeSq + 0.2D);
/* 198 */             GlStateManager.func_179139_a(-scale, -scale, scale);
/*     */             
/* 200 */             GlStateManager.func_179140_f();
/* 201 */             FontRenderer fontRenderer = mc.func_175598_ae().func_78716_a();
/*     */             
/* 203 */             StringBuilder sb = new StringBuilder();
/* 204 */             sb.append(StatCollector.func_74838_a("tile.intangible:deitybuilder.report.title"));
/*     */             
/* 206 */             String format = TextUtil.parse(StatCollector.func_74838_a("tile.intangible:deitybuilder.report.row"));
/* 207 */             SoulType[] arrayOfSoulType = SoulType.values();d4 = arrayOfSoulType.length; for (double d1 = 0; d1 < d4; d1++) { SoulType soulType = arrayOfSoulType[d1];
/* 208 */               int total = all.quantityOf(soulType);
/* 209 */               if (total > 0) {
/* 210 */                 sb.append(String.format(format, new Object[] { EnumSoulType.fromSoulType(soulType).getLocalizedName(), Integer.valueOf(total) }));
/*     */               }
/*     */             }
/* 213 */             String text = TextUtil.parse(sb.toString());
/*     */             
/* 215 */             if ((text != null) && (!text.isEmpty())) {
/* 216 */               int wrapWidth = 200;
/* 217 */               List lines = fontRenderer.func_78271_c(text, wrapWidth);
/* 218 */               int maxWidth = 0;
/* 219 */               int[] widths = new int[lines.size()];
/* 220 */               int i = 0; for (int count = lines.size(); i < count; i++) {
/* 221 */                 widths[i] = fontRenderer.func_78256_a((String)lines.get(i));
/* 222 */                 maxWidth = Math.max(widths[i], maxWidth);
/*     */               }
/*     */               
/* 225 */               int textX = -maxWidth / 2;
/* 226 */               int textY = 0;
/* 227 */               textY = -1;
/* 228 */               int i = 0; for (int count = lines.size(); i < count; textY += fontRenderer.field_78288_b) {
/* 229 */                 fontRenderer.func_175065_a((String)lines.get(i), textX + (maxWidth - widths[i]) / 2, textY, -1862270977, false);i++;
/*     */               }
/*     */             }
/* 232 */             GlStateManager.func_179145_e();
/* 233 */             GlStateManager.func_179121_F();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderDeityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */