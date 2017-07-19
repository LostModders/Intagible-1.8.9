/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem;
/*     */ import emoniph.intangible.knowledge.Book;
/*     */ import emoniph.intangible.util.Point2d;
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.event.RenderWorldLastEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderKnowledgeGem
/*     */   extends Render
/*     */ {
/*     */   public RenderKnowledgeGem(RenderManager renderManager)
/*     */   {
/*  28 */     super(renderManager);
/*     */   }
/*     */   
/*  31 */   private static List<RenderTask> tasks = new ArrayList();
/*     */   
/*     */   public static void render(RenderWorldLastEvent event) {
/*  34 */     Minecraft mc = Minecraft.func_71410_x();
/*  35 */     EntityPlayer thePlayer = mc.field_71439_g;
/*     */     
/*  37 */     double playerX = thePlayer.field_70169_q + (thePlayer.field_70165_t - thePlayer.field_70169_q) * event.partialTicks;
/*  38 */     double playerY = thePlayer.field_70167_r + (thePlayer.field_70163_u - thePlayer.field_70167_r) * event.partialTicks;
/*  39 */     double playerZ = thePlayer.field_70166_s + (thePlayer.field_70161_v - thePlayer.field_70166_s) * event.partialTicks;
/*     */     
/*  41 */     for (RenderTask t : tasks) {
/*  42 */       t.setPlayerPosition(playerX, playerY, playerZ);
/*     */     }
/*     */     
/*  45 */     Collections.sort(tasks);
/*     */     
/*  47 */     for (RenderTask t : tasks) {
/*  48 */       t.renderer.doRealRender(t.entity, t.x, t.y, t.z, t.pp, t.partialTicks);
/*     */     }
/*  50 */     tasks.clear();
/*     */   }
/*     */   
/*     */   private static class RenderTask implements Comparable<RenderTask> {
/*     */     final Entity entity;
/*     */     final double x;
/*     */     final double y;
/*     */     final double z;
/*     */     
/*     */     public RenderTask(RenderKnowledgeGem renderer, Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
/*  60 */       this.entity = entity;
/*  61 */       this.x = x;
/*  62 */       this.y = y;
/*  63 */       this.z = z;
/*  64 */       this.pp = p_76986_8_;
/*  65 */       this.partialTicks = partialTicks;
/*  66 */       this.renderer = renderer;
/*     */     }
/*     */     
/*     */     final float pp;
/*     */     final float partialTicks;
/*     */     final RenderKnowledgeGem renderer;
/*     */     double distSq;
/*     */     public void setPlayerPosition(double playerX, double playerY, double playerZ) {
/*  74 */       this.distSq = this.entity.func_70092_e(playerX, playerY, playerZ);
/*     */     }
/*     */     
/*     */ 
/*     */     public int compareTo(RenderTask o)
/*     */     {
/*  80 */       return this.distSq < o.distSq ? 1 : this.distSq == o.distSq ? 0 : -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
/*  85 */     tasks.add(new RenderTask(this, entity, x, y, z, p_76986_8_, partialTicks));
/*     */   }
/*     */   
/*     */   public void doRealRender(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks)
/*     */   {
/*  90 */     EntityKnowledgeGem gem = (EntityKnowledgeGem)entity;
/*  91 */     if (!gem.impacted) {
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     GlStateManager.func_179094_E();
/*     */     
/*  97 */     GlStateManager.func_179109_b((float)x, (float)y + entity.field_70131_O, (float)z);
/*  98 */     GlStateManager.func_179091_B();
/*     */     
/* 100 */     GlStateManager.func_179140_f();
/* 101 */     GlStateManager.func_179147_l();
/* 102 */     GlStateManager.func_179141_d();
/* 103 */     GlStateManager.func_179132_a(true);
/* 104 */     GlStateManager.func_179098_w();
/*     */     
/* 106 */     GlStateManager.func_179112_b(770, 771);
/* 107 */     GlStateManager.func_179092_a(516, 0.1F);
/*     */     
/* 109 */     GlStateManager.func_179114_b(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/*     */     
/* 111 */     GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
/*     */     
/* 113 */     float width = entity.field_70130_N;
/* 114 */     float height = entity.field_70131_O;
/* 115 */     GlStateManager.func_179137_b(-width / 2.0D, 0.0D, 0.0D);
/*     */     
/* 117 */     Minecraft mc = Minecraft.func_71410_x();
/*     */     
/*     */ 
/* 120 */     int backWidth = 222;
/* 121 */     int backHeight = 221;
/* 122 */     float halfWidth = width / 2.0F;
/* 123 */     float halfHeight = height / 2.0F;
/*     */     
/* 125 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.9F);
/*     */     
/* 127 */     GlStateManager.func_179137_b(width, 0.0D, 0.01D);
/* 128 */     GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
/* 129 */     func_110776_a(BACKGROUND);
/* 130 */     RenderUtil.drawScaledCustomSizeModalRect(0.0F, 0.0F, 0, 0, backWidth, 222, width, height, 256.0F, 256.0F);
/* 131 */     GlStateManager.func_179114_b(-180.0F, 0.0F, 1.0F, 0.0F);
/* 132 */     GlStateManager.func_179137_b(-width, 0.0D, -0.01D);
/*     */     
/*     */ 
/* 135 */     GlStateManager.func_179109_b(halfWidth, halfHeight, 0.0F);
/*     */     
/*     */ 
/* 138 */     float rotation = gem.field_70173_aa % 360.0F;
/* 139 */     GlStateManager.func_179114_b(-rotation, 0.0F, 0.0F, 1.0F);
/*     */     
/* 141 */     int dissolveTicks = gem.getDisolveTicks();
/* 142 */     float maxScale = 10.0F;
/* 143 */     float scale = Math.min(maxScale, dissolveTicks == -1 ? gem.field_70173_aa : dissolveTicks) / maxScale;
/* 144 */     if (scale < 1.0F) {
/* 145 */       GlStateManager.func_179152_a(scale, scale, scale);
/*     */     }
/*     */     
/* 148 */     GlStateManager.func_179109_b(-halfWidth, -halfHeight, 0.0F);
/*     */     
/*     */ 
/* 151 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.9F);
/*     */     
/* 153 */     RenderUtil.drawScaledCustomSizeModalRect(0.0F, 0.0F, 0, 0, backWidth, 222, width, height, 256.0F, 256.0F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/* 161 */     GlStateManager.func_179109_b(halfWidth, halfHeight, 0.0F);
/* 162 */     GlStateManager.func_179114_b(rotation, 0.0F, 0.0F, 1.0F);
/* 163 */     GlStateManager.func_179109_b(-halfWidth, -halfHeight, 0.0F);
/*     */     
/*     */ 
/* 166 */     if (scale == 1.0F) {
/* 167 */       GlStateManager.func_179137_b(0.0D, 0.0D, -0.01D);
/* 168 */       float hScale = width / backWidth;
/* 169 */       float vScale = height / backHeight;
/* 170 */       GlStateManager.func_179152_a(hScale, vScale, 1.0F);
/* 171 */       Point2d pointer = gem.getPointer(mc.field_71439_g);
/* 172 */       Get.book().render(gem, mc.field_71439_g, pointer, partialTicks, mc.func_175598_ae());
/*     */     }
/* 174 */     GlStateManager.func_179101_C();
/* 175 */     GlStateManager.func_179084_k();
/* 176 */     GlStateManager.func_179145_e();
/* 177 */     GlStateManager.func_179121_F();
/*     */     
/* 179 */     super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
/*     */   }
/*     */   
/* 182 */   public static final ResourceLocation BACKGROUND = new ResourceLocation("intangible", "textures/gui/knowledge_back.png");
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity) {
/* 185 */     return BACKGROUND;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderKnowledgeGem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */