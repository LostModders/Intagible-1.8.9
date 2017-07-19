/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.entity.EntitySpikeBall;
/*     */ import emoniph.intangible.util.MathUtil;
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelSpikeBall
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer shape1;
/*     */   public ModelRenderer shape2;
/*     */   public ModelRenderer shape3;
/*     */   public ModelRenderer shape4;
/*     */   public ModelRenderer shape5;
/*     */   public ModelRenderer shape6;
/*     */   public ModelRenderer shape7;
/*     */   public ModelRenderer shape8;
/*     */   public ModelRenderer shape9;
/*     */   
/*     */   public ModelSpikeBall()
/*     */   {
/*  33 */     this.field_78090_t = 32;
/*  34 */     this.field_78089_u = 32;
/*  35 */     this.shape8 = new ModelRenderer(this, 0, 2);
/*  36 */     this.shape8.func_78793_a(0.0F, 20.0F, 0.0F);
/*  37 */     this.shape8.func_78790_a(-3.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/*  38 */     setRotateAngle(this.shape8, 0.0F, 0.0F, 0.7853982F);
/*  39 */     this.shape3 = new ModelRenderer(this, 0, 0);
/*  40 */     this.shape3.func_78793_a(0.0F, 20.0F, 0.0F);
/*  41 */     this.shape3.func_78790_a(-4.0F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
/*  42 */     setRotateAngle(this.shape3, 0.0F, 0.0F, 1.5707964F);
/*  43 */     this.shape5 = new ModelRenderer(this, 0, 2);
/*  44 */     this.shape5.func_78793_a(0.0F, 20.0F, 0.0F);
/*  45 */     this.shape5.func_78790_a(-3.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/*  46 */     setRotateAngle(this.shape5, 0.0F, -0.7853982F, 1.5707964F);
/*  47 */     this.shape7 = new ModelRenderer(this, 0, 2);
/*  48 */     this.shape7.func_78793_a(0.0F, 20.0F, 0.0F);
/*  49 */     this.shape7.func_78790_a(-3.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/*  50 */     setRotateAngle(this.shape7, 0.0F, 0.0F, -0.7853982F);
/*  51 */     this.shape9 = new ModelRenderer(this, 0, 2);
/*  52 */     this.shape9.func_78793_a(0.0F, 20.0F, 0.0F);
/*  53 */     this.shape9.func_78790_a(-3.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/*  54 */     setRotateAngle(this.shape9, 0.0F, 0.7853982F, 1.5707964F);
/*  55 */     this.shape6 = new ModelRenderer(this, 0, 2);
/*  56 */     this.shape6.func_78793_a(0.0F, 20.0F, 0.0F);
/*  57 */     this.shape6.func_78790_a(-3.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/*  58 */     setRotateAngle(this.shape6, 0.0F, -0.7853982F, 0.0F);
/*  59 */     this.shape4 = new ModelRenderer(this, 0, 2);
/*  60 */     this.shape4.func_78793_a(0.0F, 20.0F, 0.0F);
/*  61 */     this.shape4.func_78790_a(-3.5F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/*  62 */     setRotateAngle(this.shape4, 0.0F, 0.7853982F, 0.0F);
/*  63 */     this.shape2 = new ModelRenderer(this, 0, 0);
/*  64 */     this.shape2.func_78793_a(0.0F, 20.0F, 0.0F);
/*  65 */     this.shape2.func_78790_a(-4.0F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
/*  66 */     setRotateAngle(this.shape2, 0.0F, 1.5707964F, 0.0F);
/*  67 */     this.shape1 = new ModelRenderer(this, 0, 0);
/*  68 */     this.shape1.func_78793_a(0.0F, 20.0F, 0.0F);
/*  69 */     this.shape1.func_78790_a(-4.0F, -0.5F, -0.5F, 8, 1, 1, 0.0F);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  75 */     GlStateManager.func_179147_l();
/*  76 */     GlStateManager.func_179112_b(770, 771);
/*     */     
/*  78 */     EntitySpikeBall ball = (EntitySpikeBall)entity;
/*  79 */     RenderUtil.color(ball.getColor());
/*     */     
/*     */ 
/*  82 */     GlStateManager.func_179109_b(0.0F, MathUtil.sixteenth(20), 0.0F);
/*  83 */     GlStateManager.func_179114_b((float)Math.toDegrees(ball.rotX), 1.0F, 0.0F, 0.0F);
/*     */     
/*     */ 
/*  86 */     float growthTime = 30.0F;
/*  87 */     float fuse = ball.ticksRemaining();
/*  88 */     if (fuse <= growthTime) {
/*  89 */       float maxScale = 2.0F;
/*  90 */       float pct = (growthTime - fuse) / growthTime;
/*  91 */       float scale = pct * (maxScale - 1.0F) + 1.0F;
/*     */       
/*  93 */       GlStateManager.func_179152_a(scale, scale, scale);
/*     */     }
/*     */     
/*     */ 
/*  97 */     GlStateManager.func_179109_b(0.0F, -MathUtil.sixteenth(20), 0.0F);
/*     */     
/*     */ 
/*     */ 
/* 101 */     this.shape8.func_78785_a(f5);
/* 102 */     this.shape3.func_78785_a(f5);
/* 103 */     this.shape5.func_78785_a(f5);
/* 104 */     this.shape7.func_78785_a(f5);
/* 105 */     this.shape9.func_78785_a(f5);
/* 106 */     this.shape6.func_78785_a(f5);
/* 107 */     this.shape4.func_78785_a(f5);
/* 108 */     this.shape2.func_78785_a(f5);
/* 109 */     this.shape1.func_78785_a(f5);
/*     */     
/* 111 */     RenderUtil.resetColor();
/* 112 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 119 */     modelRenderer.field_78795_f = x;
/* 120 */     modelRenderer.field_78796_g = y;
/* 121 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelSpikeBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */