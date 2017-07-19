/*     */ package emoniph.intangible.client.models;
/*     */ 
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
/*     */ public class ModelDeityHammer
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer baseTop;
/*     */   public ModelRenderer baseBottom;
/*     */   public ModelRenderer top;
/*     */   public ModelRenderer crystal2;
/*     */   public ModelRenderer crystal1;
/*     */   public ModelRenderer baseTop2;
/*     */   public ModelRenderer baseBottom2;
/*     */   public ModelRenderer crystal3;
/*     */   public ModelRenderer crystal4;
/*  27 */   private final float HALF_PI = 1.5707964F;
/*     */   public static final int WING_COUNT = 4;
/*     */   public static final int LAYER_COUNT = 4;
/*  30 */   public ModelRenderer[][] wings = new ModelRenderer[4][4];
/*     */   
/*     */   public ModelDeityHammer()
/*     */   {
/*  34 */     this.field_78090_t = 64;
/*  35 */     this.field_78089_u = 32;
/*  36 */     this.crystal1 = new ModelRenderer(this, 56, 0);
/*  37 */     this.crystal1.func_78793_a(0.0F, 8.9F, 0.0F);
/*  38 */     this.crystal1.func_78790_a(-2.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
/*  39 */     setRotateAngle(this.crystal1, 0.0F, 0.0F, 0.7853982F);
/*  40 */     this.crystal2 = new ModelRenderer(this, 56, 0);
/*  41 */     this.crystal2.func_78793_a(0.0F, 8.9F, 0.0F);
/*  42 */     this.crystal2.func_78790_a(-1.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F);
/*  43 */     setRotateAngle(this.crystal2, 0.7853982F, 0.0F, 0.0F);
/*     */     
/*  45 */     this.crystal3 = new ModelRenderer(this, 56, 0);
/*  46 */     this.crystal3.func_78793_a(0.0F, 40.0F, 0.0F);
/*  47 */     this.crystal3.func_78790_a(-2.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
/*  48 */     setRotateAngle(this.crystal3, 0.0F, 0.0F, 0.7853982F);
/*  49 */     this.crystal4 = new ModelRenderer(this, 56, 0);
/*  50 */     this.crystal4.func_78793_a(0.0F, 40.0F, 0.0F);
/*  51 */     this.crystal4.func_78790_a(-1.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F);
/*  52 */     setRotateAngle(this.crystal4, 0.7853982F, 0.0F, 0.0F);
/*     */     
/*     */ 
/*  55 */     this.baseTop = new ModelRenderer(this, 24, 0);
/*  56 */     this.baseTop.func_78793_a(0.0F, 16.0F, 0.0F);
/*  57 */     this.baseTop.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 3, 10, 0.0F);
/*     */     
/*     */ 
/*  60 */     for (int i = 0; i < 4; i++) {
/*  61 */       this.wings[0][i] = new ModelRenderer(this, 6, 19);
/*  62 */       this.wings[0][i].func_78793_a(0.0F, 8.0F, 0.0F);
/*  63 */       this.wings[0][i].func_78790_a(-3.5F, 0.0F, -2.5F, 1, 8, 5, 0.0F);
/*  64 */       setRotateAngle(this.wings[0][i], 0.0F, 1.5707964F * i, 0.0F);
/*     */       
/*  66 */       for (int layer = 1; layer < 4; layer++) {
/*  67 */         this.wings[layer][i] = new ModelRenderer(this, 0, 0);
/*  68 */         this.wings[layer][i].func_78793_a(0.0F, 8.0F, 0.0F);
/*  69 */         this.wings[layer][i].func_78790_a(-2.5F, 0.0F, -2.0F, 1, 16, 4, 0.0F);
/*  70 */         setRotateAngle(this.wings[layer][i], 0.0F, 1.5707964F * i, 0.0F);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  75 */     this.top = new ModelRenderer(this, 11, 0);
/*  76 */     this.top.func_78793_a(0.0F, 7.0F, 0.0F);
/*  77 */     this.top.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 1, 5, 0.0F);
/*  78 */     this.baseBottom2 = new ModelRenderer(this, 20, 17);
/*  79 */     this.baseBottom2.func_78793_a(0.0F, -0.001F, 0.0F);
/*  80 */     this.baseBottom2.func_78790_a(-5.5F, 0.0F, -5.5F, 11, 4, 11, 0.0F);
/*  81 */     setRotateAngle(this.baseBottom2, 0.0F, 0.7853982F, 0.0F);
/*  82 */     this.baseBottom = new ModelRenderer(this, 20, 17);
/*  83 */     this.baseBottom.func_78793_a(0.0F, 20.0F, 0.0F);
/*  84 */     this.baseBottom.func_78790_a(-5.5F, 0.0F, -5.5F, 11, 4, 11, 0.0F);
/*  85 */     this.baseTop2 = new ModelRenderer(this, 24, 0);
/*  86 */     this.baseTop2.func_78793_a(0.0F, -0.001F, 0.0F);
/*  87 */     this.baseTop2.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 3, 10, 0.0F);
/*  88 */     setRotateAngle(this.baseTop2, 0.0F, 0.7853982F, 0.0F);
/*  89 */     this.baseBottom.func_78792_a(this.baseBottom2);
/*  90 */     this.baseTop.func_78792_a(this.baseTop2);
/*     */   }
/*     */   
/*     */   private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/*  94 */     modelRenderer.field_78795_f = x;
/*  95 */     modelRenderer.field_78796_g = y;
/*  96 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*  99 */   private float[] lateralShift = new float[this.wings.length];
/*     */   
/*     */   public float getLateralShift(int layer) {
/* 102 */     return this.lateralShift[layer];
/*     */   }
/*     */   
/*     */   public void setLateralShift(int layer, float shift) {
/* 106 */     this.lateralShift[layer] = shift;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 111 */     this.baseBottom.func_78785_a(f5);
/* 112 */     this.baseTop.func_78785_a(f5);
/*     */     
/* 114 */     for (int i = 0; i < 4; i++) {
/* 115 */       for (int layer = 0; layer < this.wings.length; layer++) {
/* 116 */         float z = this.lateralShift[layer] * (float)Math.sin(this.wings[layer][i].field_78796_g);
/* 117 */         float x = this.lateralShift[layer] * -(float)Math.cos(this.wings[layer][i].field_78796_g);
/* 118 */         GlStateManager.func_179109_b(x, 0.0F, z);
/* 119 */         this.wings[layer][i].func_78785_a(f5);
/* 120 */         GlStateManager.func_179109_b(-x, 0.0F, -z);
/*     */       }
/*     */     }
/*     */     
/* 124 */     this.top.func_78785_a(f5);
/* 125 */     this.crystal1.func_78785_a(f5);
/* 126 */     this.crystal2.func_78785_a(f5);
/*     */     
/* 128 */     this.crystal3.func_78785_a(f5);
/* 129 */     this.crystal4.func_78785_a(f5);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDeityHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */