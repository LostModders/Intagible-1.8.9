/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.entity.EntitySkyBeam;
/*     */ import emoniph.intangible.entity.EntitySkyBeam.BeamSegment;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderSkyBeam extends Render
/*     */ {
/*     */   public RenderSkyBeam(RenderManager renderManager)
/*     */   {
/*  24 */     super(renderManager);
/*     */   }
/*     */   
/*     */ 
/*  28 */   private static final ResourceLocation BEAM = new ResourceLocation("textures/entity/beacon_beam.png");
/*     */   
/*     */   public void doRender(EntitySkyBeam entity, double x, double y, double z, float p_76986_8_, float partialTicks)
/*     */   {
/*  32 */     Minecraft mc = Minecraft.func_71410_x();
/*     */     
/*  34 */     float f1 = entity.shouldBeamRender();
/*  35 */     GlStateManager.func_179092_a(516, 0.1F);
/*     */     
/*  37 */     if (f1 > 0.0F) {
/*  38 */       Tessellator tessellator = Tessellator.func_178181_a();
/*  39 */       WorldRenderer worldrenderer = tessellator.func_178180_c();
/*  40 */       List list = entity.getBeamSegmentsUp();
/*  41 */       int j = -(int)entity.field_70163_u;
/*     */       
/*     */ 
/*  44 */       for (int k = 0; k < list.size(); k++) {
/*  45 */         EntitySkyBeam.BeamSegment beamsegment = (EntitySkyBeam.BeamSegment)list.get(k);
/*  46 */         int l = j + beamsegment.func_177264_c();
/*  47 */         func_110776_a(BEAM);
/*  48 */         GL11.glTexParameterf(3553, 10242, 10497.0F);
/*  49 */         GL11.glTexParameterf(3553, 10243, 10497.0F);
/*  50 */         GlStateManager.func_179140_f();
/*  51 */         GlStateManager.func_179129_p();
/*  52 */         GlStateManager.func_179084_k();
/*  53 */         GlStateManager.func_179132_a(true);
/*  54 */         GlStateManager.func_179120_a(770, 1, 1, 0);
/*  55 */         float f2 = (float)mc.field_71441_e.func_82737_E() + partialTicks;
/*  56 */         float f3 = -f2 * 0.2F - net.minecraft.util.MathHelper.func_76141_d(-f2 * 0.1F);
/*  57 */         double d3 = f2 * 0.025D * -1.5D;
/*     */         
/*  59 */         worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */         
/*  61 */         double radius = 0.2D;
/*     */         
/*  63 */         double d5 = 0.5D + Math.cos(d3 + 2.356194490192345D) * radius;
/*  64 */         double d6 = 0.5D + Math.sin(d3 + 2.356194490192345D) * radius;
/*  65 */         double d7 = 0.5D + Math.cos(d3 + 0.7853981633974483D) * radius;
/*  66 */         double d8 = 0.5D + Math.sin(d3 + 0.7853981633974483D) * radius;
/*  67 */         double d9 = 0.5D + Math.cos(d3 + 3.9269908169872414D) * radius;
/*  68 */         double d10 = 0.5D + Math.sin(d3 + 3.9269908169872414D) * radius;
/*  69 */         double d11 = 0.5D + Math.cos(d3 + 5.497787143782138D) * radius;
/*  70 */         double d12 = 0.5D + Math.sin(d3 + 5.497787143782138D) * radius;
/*  71 */         double d13 = 0.0D;
/*  72 */         double d14 = 1.0D;
/*  73 */         double d15 = -1.0F + f3;
/*  74 */         double d16 = beamsegment.func_177264_c() * f1 * (0.5D / radius) + d15;
/*     */         
/*  76 */         double yOffset = 0.0D;
/*     */         
/*  78 */         worldrenderer.func_181662_b(x + d5, y + l + yOffset, z + d6).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  79 */         worldrenderer.func_181662_b(x + d5, y + j + yOffset, z + d6).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  80 */         worldrenderer.func_181662_b(x + d7, y + j + yOffset, z + d8).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  81 */         worldrenderer.func_181662_b(x + d7, y + l + yOffset, z + d8).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  82 */         worldrenderer.func_181662_b(x + d11, y + l + yOffset, z + d12).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  83 */         worldrenderer.func_181662_b(x + d11, y + j + yOffset, z + d12).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  84 */         worldrenderer.func_181662_b(x + d9, y + j + yOffset, z + d10).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  85 */         worldrenderer.func_181662_b(x + d9, y + l + yOffset, z + d10).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  86 */         worldrenderer.func_181662_b(x + d7, y + l + yOffset, z + d8).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  87 */         worldrenderer.func_181662_b(x + d7, y + j + yOffset, z + d8).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  88 */         worldrenderer.func_181662_b(x + d11, y + j + yOffset, z + d12).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  89 */         worldrenderer.func_181662_b(x + d11, y + l + yOffset, z + d12).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  90 */         worldrenderer.func_181662_b(x + d9, y + l + yOffset, z + d10).func_181673_a(d14, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  91 */         worldrenderer.func_181662_b(x + d9, y + j + yOffset, z + d10).func_181673_a(d14, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  92 */         worldrenderer.func_181662_b(x + d5, y + j + yOffset, z + d6).func_181673_a(d13, d15).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  93 */         worldrenderer.func_181662_b(x + d5, y + l + yOffset, z + d6).func_181673_a(d13, d16).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/*  94 */         tessellator.func_78381_a();
/*  95 */         GlStateManager.func_179147_l();
/*  96 */         GlStateManager.func_179120_a(770, 771, 1, 0);
/*  97 */         GlStateManager.func_179132_a(false);
/*  98 */         worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*  99 */         d3 = 0.2D;
/* 100 */         radius = 0.2D;
/* 101 */         d5 = 0.8D;
/* 102 */         d6 = 0.2D;
/* 103 */         d7 = 0.2D;
/* 104 */         d8 = 0.8D;
/* 105 */         d9 = 0.8D;
/* 106 */         d10 = 0.8D;
/* 107 */         d11 = 0.0D;
/* 108 */         d12 = 1.0D;
/* 109 */         d13 = -1.0F + f3;
/* 110 */         d14 = beamsegment.func_177264_c() * f1 + d13;
/* 111 */         worldrenderer.func_181662_b(x + d3, y + l, z + radius).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 112 */         worldrenderer.func_181662_b(x + d3, y + j, z + radius).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 113 */         worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 114 */         worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 115 */         worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 116 */         worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 117 */         worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 118 */         worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 119 */         worldrenderer.func_181662_b(x + d5, y + l, z + d6).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 120 */         worldrenderer.func_181662_b(x + d5, y + j, z + d6).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 121 */         worldrenderer.func_181662_b(x + d9, y + j, z + d10).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 122 */         worldrenderer.func_181662_b(x + d9, y + l, z + d10).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 123 */         worldrenderer.func_181662_b(x + d7, y + l, z + d8).func_181673_a(d12, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 124 */         worldrenderer.func_181662_b(x + d7, y + j, z + d8).func_181673_a(d12, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 125 */         worldrenderer.func_181662_b(x + d3, y + j, z + radius).func_181673_a(d11, d13).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 126 */         worldrenderer.func_181662_b(x + d3, y + l, z + radius).func_181673_a(d11, d14).func_181666_a(beamsegment.func_177263_b()[0], beamsegment.func_177263_b()[1], beamsegment.func_177263_b()[2], 0.125F).func_181675_d();
/* 127 */         tessellator.func_78381_a();
/* 128 */         GlStateManager.func_179145_e();
/* 129 */         GlStateManager.func_179098_w();
/* 130 */         GlStateManager.func_179132_a(true);
/* 131 */         j = l;
/*     */       }
/*     */     }
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
/* 163 */     super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
/*     */   }
/*     */   
/*     */   private ResourceLocation getEntityTexture(EntitySkyBeam entity) {
/* 167 */     return BEAM;
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity) {
/* 171 */     return getEntityTexture((EntitySkyBeam)entity);
/*     */   }
/*     */   
/*     */   public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
/* 175 */     doRender((EntitySkyBeam)entity, x, y, z, p_76986_8_, partialTicks);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSkyBeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */