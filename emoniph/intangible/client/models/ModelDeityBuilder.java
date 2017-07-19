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
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelDeityBuilder
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer core5;
/*     */   public ModelRenderer core4;
/*     */   public ModelRenderer core3;
/*     */   public ModelRenderer core2;
/*     */   public ModelRenderer core1;
/*     */   public ModelRenderer base;
/*     */   public ModelRenderer base2;
/*  24 */   public ModelRenderer[][] tier = new ModelRenderer[12][8];
/*     */   
/*  26 */   public static final float[] TIER_START_Y = { 23.0F, 21.0F, 18.0F, 14.0F, 10.0F, 6.0F, 1.0F, -15.0F, -25.0F, -34.0F, -42.0F, -49.0F };
/*     */   
/*     */   public ModelDeityBuilder() {
/*  29 */     this.field_78090_t = 128;
/*  30 */     this.field_78089_u = 128;
/*     */     
/*  32 */     float QUARTER_PI = 0.7853982F;
/*     */     
/*  34 */     float[] yShift = { 0.01F, 0.0F };
/*  35 */     for (int i = 0; i < this.tier[0].length; i++) {
/*  36 */       int a = i % 2;
/*  37 */       int b = (i + 1) % 2;
/*  38 */       float rotation = i * 0.7853982F;
/*     */       
/*  40 */       this.tier[0][i] = new ModelRenderer(this, 43, 3);
/*  41 */       this.tier[0][i].func_78793_a(0.0F, TIER_START_Y[0], 0.0F);
/*  42 */       this.tier[0][i].func_78790_a(-8.0F, -2.0F + yShift[a], -3.5F, 2, 2, 7, 0.0F);
/*  43 */       this.tier[0][i].field_78796_g = rotation;
/*     */       
/*  45 */       this.tier[1][i] = new ModelRenderer(this, 23, 4);
/*  46 */       this.tier[1][i].func_78793_a(0.0F, TIER_START_Y[1], 0.0F);
/*  47 */       this.tier[1][i].func_78790_a(-12.0F, -3.0F + yShift[b], -5.0F, 4, 3, 10, 0.0F);
/*  48 */       this.tier[1][i].field_78796_g = rotation;
/*     */       
/*  50 */       this.tier[2][i] = new ModelRenderer(this, 49, 5);
/*  51 */       this.tier[2][i].func_78793_a(0.0F, TIER_START_Y[2], 0.0F);
/*  52 */       this.tier[2][i].func_78790_a(-16.0F, -4.0F + yShift[a], -7.0F, 4, 4, 14, 0.0F);
/*  53 */       this.tier[2][i].field_78796_g = rotation;
/*     */       
/*  55 */       this.tier[3][i] = new ModelRenderer(this, 90, 0);
/*  56 */       this.tier[3][i].func_78793_a(0.0F, TIER_START_Y[3], 0.0F);
/*  57 */       this.tier[3][i].func_78790_a(-19.0F, -4.0F + yShift[b], -8.0F, 3, 4, 16, 0.0F);
/*  58 */       this.tier[3][i].field_78796_g = rotation;
/*     */       
/*  60 */       this.tier[4][i] = new ModelRenderer(this, 0, 2);
/*  61 */       this.tier[4][i].func_78793_a(0.0F, TIER_START_Y[4], 0.0F);
/*  62 */       this.tier[4][i].func_78790_a(-21.0F, -4.0F + yShift[a], -9.0F, 2, 4, 18, 0.0F);
/*  63 */       this.tier[4][i].field_78796_g = rotation;
/*     */       
/*  65 */       this.tier[5][i] = new ModelRenderer(this, 66, 6);
/*  66 */       this.tier[5][i].func_78793_a(0.0F, TIER_START_Y[5], 0.0F);
/*  67 */       this.tier[5][i].func_78790_a(-23.0F, -5.0F + yShift[b], -10.0F, 2, 5, 20, 0.0F);
/*  68 */       this.tier[5][i].field_78796_g = rotation;
/*     */       
/*  70 */       this.tier[6][i] = new ModelRenderer(this, 0, 27);
/*  71 */       this.tier[6][i].func_78793_a(0.0F, TIER_START_Y[6], 0.0F);
/*  72 */       this.tier[6][i].func_78790_a(-24.0F, -16.0F + yShift[a], -10.5F, 2, 16, 21, 0.0F);
/*  73 */       this.tier[6][i].field_78796_g = rotation;
/*     */       
/*  75 */       this.tier[7][i] = new ModelRenderer(this, 26, 19);
/*  76 */       this.tier[7][i].func_78793_a(0.0F, TIER_START_Y[7], 0.0F);
/*  77 */       this.tier[7][i].func_78790_a(-22.0F, -10.0F + yShift[b], -9.5F, 2, 10, 19, 0.0F);
/*  78 */       this.tier[7][i].field_78796_g = rotation;
/*     */       
/*  80 */       this.tier[8][i] = new ModelRenderer(this, 51, 38);
/*  81 */       this.tier[8][i].func_78793_a(0.0F, TIER_START_Y[8], 0.0F);
/*  82 */       this.tier[8][i].func_78790_a(-20.0F, -9.0F + yShift[a], -8.5F, 2, 9, 17, 0.0F);
/*  83 */       this.tier[8][i].field_78796_g = rotation;
/*     */       
/*  85 */       this.tier[9][i] = new ModelRenderer(this, 75, 55);
/*  86 */       this.tier[9][i].func_78793_a(0.0F, TIER_START_Y[9], 0.0F);
/*  87 */       this.tier[9][i].func_78790_a(-18.0F, -8.0F + yShift[b], -8.0F, 2, 8, 16, 0.0F);
/*  88 */       this.tier[9][i].field_78796_g = rotation;
/*     */       
/*  90 */       this.tier[10][i] = new ModelRenderer(this, 96, 25);
/*  91 */       this.tier[10][i].func_78793_a(0.0F, TIER_START_Y[10], 0.0F);
/*  92 */       this.tier[10][i].func_78790_a(-16.0F, -7.0F + yShift[a], -7.0F, 2, 7, 14, 0.0F);
/*  93 */       this.tier[10][i].field_78796_g = rotation;
/*     */       
/*  95 */       this.tier[11][i] = new ModelRenderer(this, 96, 46);
/*  96 */       this.tier[11][i].func_78793_a(0.0F, TIER_START_Y[11], 0.0F);
/*  97 */       this.tier[11][i].func_78790_a(-14.0F, -6.0F + yShift[b], -5.9F, 4, 6, 12, 0.0F);
/*  98 */       this.tier[11][i].field_78796_g = rotation;
/*     */     }
/*     */     
/* 101 */     this.base = new ModelRenderer(this, 0, 65);
/* 102 */     this.base.func_78793_a(0.0F, 23.0F, 0.0F);
/* 103 */     this.base.func_78790_a(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
/*     */     
/* 105 */     this.core1 = new ModelRenderer(this, 0, 28);
/* 106 */     this.core1.func_78793_a(0.0F, 8.0F, 0.0F);
/* 107 */     this.core1.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 15, 4, 0.0F);
/*     */     
/* 109 */     this.core2 = new ModelRenderer(this, 0, 28);
/* 110 */     this.core2.func_78793_a(0.0F, -8.0F, 0.0F);
/* 111 */     this.core2.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
/*     */     
/* 113 */     this.core3 = new ModelRenderer(this, 0, 28);
/* 114 */     this.core3.func_78793_a(0.0F, -24.0F, 0.0F);
/* 115 */     this.core3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
/*     */     
/* 117 */     this.core4 = new ModelRenderer(this, 0, 28);
/* 118 */     this.core4.func_78793_a(0.0F, -40.0F, 0.0F);
/* 119 */     this.core4.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
/*     */     
/* 121 */     this.core5 = new ModelRenderer(this, 0, 28);
/* 122 */     this.core5.func_78793_a(0.0F, -56.0F, 0.0F);
/* 123 */     this.core5.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 16, 4, 0.0F);
/*     */     
/* 125 */     this.base2 = new ModelRenderer(this, 13, 83);
/* 126 */     this.base2.func_78793_a(0.0F, 11.0F, 0.0F);
/* 127 */     this.base2.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 12, 10, 0.0F);
/* 128 */     setRotateAngle(this.base2, 0.0F, 0.7853982F, 0.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 135 */     for (int i = 0; i < this.tier.length; i++) {
/* 136 */       for (int j = 0; j < this.tier[i].length; j++) {
/* 137 */         this.tier[i][j].func_78785_a(f5);
/*     */       }
/*     */     }
/*     */     
/* 141 */     this.base.func_78785_a(f5);
/* 142 */     this.base2.func_78785_a(f5);
/*     */     
/* 144 */     GlStateManager.func_179112_b(770, 771);
/* 145 */     GlStateManager.func_179092_a(516, 0.01F);
/* 146 */     GlStateManager.func_179147_l();
/* 147 */     this.core1.func_78785_a(f5);
/* 148 */     this.core2.func_78785_a(f5);
/* 149 */     this.core3.func_78785_a(f5);
/* 150 */     this.core4.func_78785_a(f5);
/* 151 */     this.core5.func_78785_a(f5);
/* 152 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 159 */     modelRenderer.field_78795_f = x;
/* 160 */     modelRenderer.field_78796_g = y;
/* 161 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDeityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */