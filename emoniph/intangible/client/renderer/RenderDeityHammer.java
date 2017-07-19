/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockDeityHammer.EnumPart;
/*     */ import emoniph.intangible.blocks.BlockDeityHammer.TileEntityDeityHammer;
/*     */ import emoniph.intangible.blocks.BlockDeityHammer.TileEntityDeityHammer.BeamSegment;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelDeityHammer;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderDeityHammer extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  26 */   private ModelDeityHammer model = new ModelDeityHammer();
/*     */   
/*  28 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/deityhammer.png");
/*  29 */   private static final ResourceLocation BEAM = new ResourceLocation("textures/entity/beacon_beam.png");
/*     */   
/*  31 */   final float HALF_PI = 1.5707964F;
/*  32 */   final float TWO_PI = 6.2831855F;
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  36 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  37 */     if ((state.func_177230_c() == Get.blocks().DEITY_HAMMER) && (state.func_177229_b(emoniph.intangible.blocks.BlockDeityHammer.PART) == BlockDeityHammer.EnumPart.BASE) && ((tile instanceof BlockDeityHammer.TileEntityDeityHammer))) {
/*  38 */       Minecraft mc = Minecraft.func_71410_x();
/*  39 */       BlockDeityHammer.TileEntityDeityHammer hammer = (BlockDeityHammer.TileEntityDeityHammer)tile;
/*     */       
/*  41 */       GlStateManager.func_179094_E();
/*  42 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*  43 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  44 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*  46 */       double activeTicks = hammer.getStartTicks();
/*     */       
/*  48 */       double extendTicks = 75.0D;
/*     */       
/*  50 */       double extendProgress = 1.0D;
/*  51 */       if (activeTicks <= 75.0D) {
/*  52 */         extendProgress = activeTicks / 75.0D;
/*     */       }
/*     */       
/*  55 */       double spinProgress = activeTicks > 75.0D ? (activeTicks - 75.0D) / (150.0D - 75.0D) : 0.0D;
/*     */       
/*  57 */       double fireProgress = 0.0D;
/*  58 */       if (hammer.getFiringTicks() >= 1) {
/*  59 */         double maxFiring = '' - 1;
/*  60 */         double firing = Math.min(hammer.getFiringTicks(), 150) - 1;
/*  61 */         fireProgress = firing / maxFiring;
/*     */       }
/*     */       
/*  64 */       double fireRemainder = 0.0D;
/*  65 */       if (hammer.getFiringTicks() >= 150) {
/*  66 */         double maxFiring = 'ú' - '';
/*  67 */         double firing = Math.min(hammer.getFiringTicks(), 250) - 150;
/*  68 */         fireRemainder = firing / maxFiring;
/*     */       }
/*     */       
/*     */ 
/*  72 */       double angle = activeTicks + hammer.getFiringTicks();
/*     */       
/*  74 */       double pullbackTicksMax = 20.0D;
/*  75 */       double pullbackPoint = 150.0D - pullbackTicksMax * 0.5D;
/*  76 */       double pullbackProgress = 0.0D;
/*  77 */       if (hammer.getFiringTicks() >= pullbackPoint) {
/*  78 */         double pullbackTicks = Math.min(hammer.getFiringTicks() - pullbackPoint, pullbackTicksMax);
/*  79 */         pullbackProgress = pullbackTicks / pullbackTicksMax;
/*     */       }
/*     */       
/*  82 */       double pullback = (pullbackProgress - pullbackProgress * pullbackProgress) * 4.0D;
/*     */       
/*     */ 
/*  85 */       for (int i = 0; i < 4; i++) {
/*  86 */         this.model.wings[0][i].field_78797_d = 8.0F;
/*  87 */         this.model.wings[1][i].field_78797_d = ((float)(8.0D + extendProgress * -16.0D));
/*  88 */         this.model.wings[2][i].field_78797_d = ((float)(8.0D + extendProgress * -32.0D + 4.0D * pullback));
/*  89 */         this.model.wings[3][i].field_78797_d = ((float)(8.0D + extendProgress * -48.0D + 8.0D * pullback));
/*     */         
/*  91 */         if (extendProgress == 1.0D) {
/*  92 */           this.model.wings[0][i].field_78796_g = ((float)Math.toRadians((angle * (1.0D + 1.0D * fireProgress) + 90.0D * i) % 360.0D));
/*  93 */           this.model.wings[1][i].field_78796_g = ((float)Math.toRadians((angle * (1.5D + 2.0D * fireProgress) + 90.0D * i) % 360.0D));
/*  94 */           this.model.wings[2][i].field_78796_g = ((float)Math.toRadians((angle * (2.0D + 2.0D * fireProgress) + 90.0D * i) % 360.0D));
/*  95 */           this.model.wings[3][i].field_78796_g = ((float)Math.toRadians((angle * (2.5D + 3.0D * fireProgress) + 90.0D * i) % 360.0D));
/*     */         } else {
/*  97 */           this.model.wings[0][i].field_78796_g = (1.5707964F * i);
/*  98 */           this.model.wings[1][i].field_78796_g = (1.5707964F * i);
/*  99 */           this.model.wings[2][i].field_78796_g = (1.5707964F * i);
/* 100 */           this.model.wings[3][i].field_78796_g = (1.5707964F * i);
/*     */         }
/*     */       }
/*     */       
/* 104 */       this.model.setLateralShift(0, (float)(spinProgress * -0.06D + extendProgress * 0.0D));
/* 105 */       this.model.setLateralShift(1, (float)(spinProgress * 0.05D + extendProgress * 0.03D));
/* 106 */       this.model.setLateralShift(2, (float)(spinProgress * 0.1D + extendProgress * 0.02D));
/* 107 */       this.model.setLateralShift(3, (float)(spinProgress * 0.15D + extendProgress * 0.0D));
/*     */       
/* 109 */       this.model.top.field_78796_g = this.model.wings[0][0].field_78796_g;
/*     */       
/* 111 */       this.model.top.field_78797_d = 7.8F;
/*     */       
/*     */ 
/* 114 */       float up = 49.7F * (1.0F - (float)((extendProgress + fireProgress) / 2.0D));
/*     */       
/* 116 */       float ticksForBounce = (float)mc.field_71441_e.func_82737_E();
/*     */       
/*     */ 
/* 119 */       this.model.crystal1.field_78800_c = ((float)Math.sin(ticksForBounce / 10.0F) * 2.0F * (1.0F - (float)extendProgress));
/* 120 */       this.model.crystal2.field_78800_c = this.model.crystal1.field_78800_c;
/* 121 */       this.model.crystal1.field_78798_e = this.model.crystal1.field_78800_c;
/* 122 */       this.model.crystal2.field_78798_e = this.model.crystal1.field_78798_e;
/*     */       
/* 124 */       this.model.crystal3.field_78800_c = this.model.crystal1.field_78800_c;
/* 125 */       this.model.crystal4.field_78800_c = this.model.crystal3.field_78800_c;
/* 126 */       this.model.crystal3.field_78798_e = this.model.crystal3.field_78800_c;
/* 127 */       this.model.crystal4.field_78798_e = this.model.crystal3.field_78798_e;
/*     */       
/* 129 */       this.model.crystal1.field_78797_d = (9.7F - (float)Math.abs(Math.sin(ticksForBounce / 20.0F) * up));
/* 130 */       this.model.crystal2.field_78797_d = this.model.crystal1.field_78797_d;
/* 131 */       this.model.crystal3.field_78797_d = (9.7F - (float)Math.abs(Math.sin(ticksForBounce / 20.0F + 1.5707964F) * up));
/* 132 */       this.model.crystal4.field_78797_d = this.model.crystal3.field_78797_d;
/*     */       
/* 134 */       if (spinProgress == 0.0D)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 141 */         this.model.top.field_78796_g = 0.0F;
/*     */       }
/*     */       
/* 144 */       GlStateManager.func_179147_l();
/* 145 */       GlStateManager.func_179112_b(770, 771);
/* 146 */       func_147499_a(TEXTURE);
/* 147 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/* 149 */       GlStateManager.func_179121_F();
/*     */       
/* 151 */       float f1 = hammer.shouldBeamRender();
/* 152 */       GlStateManager.func_179092_a(516, 0.1F);
/*     */       
/* 154 */       if (f1 > 0.0F) {
/* 155 */         Tessellator tessellator = Tessellator.func_178181_a();
/* 156 */         WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 157 */         List list = hammer.getBeamSegmentsUp();
/* 158 */         int j = 4;
/*     */         
/*     */ 
/* 161 */         for (int k = 0; k < list.size(); k++) {
/* 162 */           BlockDeityHammer.TileEntityDeityHammer.BeamSegment beamsegment = (BlockDeityHammer.TileEntityDeityHammer.BeamSegment)list.get(k);
/* 163 */           int l = j + beamsegment.func_177264_c();
/* 164 */           func_147499_a(BEAM);
/* 165 */           GL11.glTexParameterf(3553, 10242, 10497.0F);
/* 166 */           GL11.glTexParameterf(3553, 10243, 10497.0F);
/* 167 */           GlStateManager.func_179140_f();
/* 168 */           GlStateManager.func_179129_p();
/* 169 */           GlStateManager.func_179084_k();
/* 170 */           GlStateManager.func_179132_a(true);
/* 171 */           GlStateManager.func_179120_a(770, 1, 1, 0);
/* 172 */           float f2 = (float)mc.field_71441_e.func_82737_E() + partialTicks;
/* 173 */           float f3 = -f2 * 0.2F - MathHelper.func_76141_d(-f2 * 0.1F);
/* 174 */           double d3 = f2 * 0.025D * -1.5D;
/* 175 */           worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */           
/* 177 */           double radius = 0.1D + 0.1D * fireRemainder;
/*     */           
/* 179 */           double d5 = 0.5D + Math.cos(d3 + 2.356194490192345D) * radius;
/* 180 */           double d6 = 0.5D + Math.sin(d3 + 2.356194490192345D) * radius;
/* 181 */           double d7 = 0.5D + Math.cos(d3 + 0.7853981633974483D) * radius;
/* 182 */           double d8 = 0.5D + Math.sin(d3 + 0.7853981633974483D) * radius;
/* 183 */           double d9 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * radius;
/* 184 */           double d10 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * radius;
/* 185 */           double d11 = 0.5D + Math.cos(d3 + 5.497787143782138D) * radius;
/* 186 */           double d12 = 0.5D + Math.sin(d3 + 5.497787143782138D) * radius;
/* 187 */           double d13 = 0.0D;
/* 188 */           double d14 = 1.0D;
/* 189 */           double d15 = -1.0F + f3;
/* 190 */           double d16 = beamsegment.func_177264_c() * f1 * (0.5D / radius) + d15;
/*     */           
/* 192 */           double yOffset = -2.75D;
/*     */           
/* 194 */           worldrenderer.func_181662_b(x + d5, y + l + yOffset, z + d6).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 195 */           worldrenderer.func_181662_b(x + d5, y + j + yOffset, z + d6).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 196 */           worldrenderer.func_181662_b(x + d7, y + j + yOffset, z + d8).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 197 */           worldrenderer.func_181662_b(x + d7, y + l + yOffset, z + d8).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 198 */           worldrenderer.func_181662_b(x + d11, y + l + yOffset, z + d12).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 199 */           worldrenderer.func_181662_b(x + d11, y + j + yOffset, z + d12).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 200 */           worldrenderer.func_181662_b(x + d9, y + j + yOffset, z + d10).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 201 */           worldrenderer.func_181662_b(x + d9, y + l + yOffset, z + d10).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 202 */           worldrenderer.func_181662_b(x + d7, y + l + yOffset, z + d8).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 203 */           worldrenderer.func_181662_b(x + d7, y + j + yOffset, z + d8).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 204 */           worldrenderer.func_181662_b(x + d11, y + j + yOffset, z + d12).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 205 */           worldrenderer.func_181662_b(x + d11, y + l + yOffset, z + d12).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 206 */           worldrenderer.func_181662_b(x + d9, y + l + yOffset, z + d10).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 207 */           worldrenderer.func_181662_b(x + d9, y + j + yOffset, z + d10).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 208 */           worldrenderer.func_181662_b(x + d5, y + j + yOffset, z + d6).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 209 */           worldrenderer.func_181662_b(x + d5, y + l + yOffset, z + d6).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 210 */           tessellator.func_78381_a();
/* 211 */           GlStateManager.func_179147_l();
/* 212 */           GlStateManager.func_179120_a(770, 771, 1, 0);
/* 213 */           GlStateManager.func_179132_a(false);
/* 214 */           worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */           
/* 216 */           d3 = 0.2D;
/* 217 */           radius = 0.2D;
/* 218 */           d5 = 0.8D;
/* 219 */           d6 = 0.2D;
/* 220 */           d7 = 0.2D;
/* 221 */           d8 = 0.8D;
/* 222 */           d9 = 0.8D;
/* 223 */           d10 = 0.8D;
/* 224 */           d11 = 0.0D;
/* 225 */           d12 = 1.0D;
/* 226 */           d13 = -1.0F + f3;
/* 227 */           d14 = beamsegment.func_177264_c() * f1 + d13;
/* 228 */           worldrenderer.func_181662_b(x + d3, y + l, z + radius).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 229 */           worldrenderer.func_181662_b(x + d3, y + j, z + radius).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 230 */           worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 231 */           worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 232 */           worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 233 */           worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 234 */           worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 235 */           worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 236 */           worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 237 */           worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 238 */           worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 239 */           worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 240 */           worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 241 */           worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 242 */           worldrenderer.func_181662_b(x + d3, y + j, z + radius).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 243 */           worldrenderer.func_181662_b(x + d3, y + l, z + radius).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 244 */           tessellator.func_78381_a();
/* 245 */           GlStateManager.func_179145_e();
/* 246 */           GlStateManager.func_179098_w();
/* 247 */           GlStateManager.func_179132_a(true);
/* 248 */           j = l;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderDeityHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */