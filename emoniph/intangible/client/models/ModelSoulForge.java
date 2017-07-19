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
/*     */ public class ModelSoulForge
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer coreMiddle;
/*     */   public ModelRenderer coreUpper;
/*     */   public ModelRenderer coreLower;
/*  20 */   public ModelRenderer[] wingUpper = new ModelRenderer[4];
/*  21 */   public ModelRenderer[] wingInner = new ModelRenderer[4];
/*  22 */   public ModelRenderer[] wingOuter = new ModelRenderer[4];
/*     */   
/*     */   public ModelRenderer crystalA;
/*     */   public ModelRenderer crystalB;
/*  26 */   public ModelRenderer[] supportLower = new ModelRenderer[4];
/*     */   public float innerWingShift;
/*     */   
/*  29 */   public ModelSoulForge() { this.field_78090_t = 64;
/*  30 */     this.field_78089_u = 32;
/*     */     
/*  32 */     float HALF_PI = 1.5707964F;
/*     */     
/*  34 */     for (int i = 0; i < this.wingUpper.length; i++) {
/*  35 */       this.wingUpper[i] = new ModelRenderer(this, 29, 10);
/*  36 */       this.wingUpper[i].func_78793_a(0.0F, -24.0F, 0.0F);
/*  37 */       this.wingUpper[i].func_78790_a(-4.0F, 0.0F, -3.0F, 1, 16, 6, 0.0F);
/*  38 */       setRotateAngle(this.wingUpper[i], 0.0F, 1.5707964F * i, 0.0F);
/*     */       
/*  40 */       ModelRenderer wingUpperTop = new ModelRenderer(this, 29, 10);
/*  41 */       wingUpperTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  42 */       wingUpperTop.func_78790_a(-2.5F, -2.0F, -3.0F, 1, 5, 6, 0.0F);
/*  43 */       setRotateAngle(wingUpperTop, 0.0F, 0.0F, 0.7853982F);
/*  44 */       this.wingUpper[i].func_78792_a(wingUpperTop);
/*     */       
/*  46 */       this.wingInner[i] = new ModelRenderer(this, 9, 21);
/*  47 */       this.wingInner[i].func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */       this.wingInner[i].func_78790_a(-2.0F, -4.0F, -1.5F, 1, 8, 3, 0.0F);
/*  49 */       setRotateAngle(this.wingInner[i], 0.0F, 1.5707964F * i, 0.0F);
/*     */       
/*  51 */       this.wingOuter[i] = new ModelRenderer(this, 18, 12);
/*  52 */       this.wingOuter[i].func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */       this.wingOuter[i].func_78790_a(-3.0F, -8.0F, -2.0F, 1, 16, 4, 0.0F);
/*  54 */       setRotateAngle(this.wingOuter[i], 0.0F, 1.5707964F * i, 0.0F);
/*     */     }
/*     */     
/*  57 */     for (int i = 0; i < this.supportLower.length; i++)
/*     */     {
/*  59 */       ModelRenderer supportUpper = new ModelRenderer(this, 52, 0);
/*  60 */       supportUpper.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */       supportUpper.func_78790_a(-3.4F, 2.2F, -2.0F, 2, 5, 4, 0.0F);
/*  62 */       setRotateAngle(supportUpper, 0.0F, 0.0F, 0.22759093F);
/*     */       
/*  64 */       ModelRenderer supportMiddle = new ModelRenderer(this, 48, 9);
/*  65 */       supportMiddle.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */       supportMiddle.func_78790_a(-5.4F, 6.2F, -2.5F, 3, 6, 5, 0.0F);
/*  67 */       setRotateAngle(supportMiddle, 0.0F, 0.0F, 0.18203785F);
/*     */       
/*     */ 
/*  70 */       this.supportLower[i] = new ModelRenderer(this, 44, 21);
/*  71 */       this.supportLower[i].func_78793_a(0.0F, 8.0F, 0.0F);
/*  72 */       this.supportLower[i].func_78790_a(-8.0F, 11.0F, -3.0F, 4, 5, 6, 0.0F);
/*  73 */       setRotateAngle(this.supportLower[i], 0.0F, 1.5707964F * i + 0.7853982F, 0.0F);
/*     */       
/*  75 */       supportMiddle.func_78792_a(supportUpper);
/*  76 */       this.supportLower[i].func_78792_a(supportMiddle);
/*     */     }
/*     */     
/*     */ 
/*  80 */     this.coreUpper = new ModelRenderer(this, 0, 0);
/*  81 */     this.coreUpper.func_78793_a(0.0F, -20.0F, 0.0F);
/*  82 */     this.coreUpper.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 12, 2, 0.0F);
/*     */     
/*  84 */     this.coreMiddle = new ModelRenderer(this, 0, 0);
/*  85 */     this.coreMiddle.func_78793_a(0.0F, -8.0F, 0.0F);
/*  86 */     this.coreMiddle.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 16, 2, 0.0F);
/*     */     
/*  88 */     this.crystalB = new ModelRenderer(this, 26, 0);
/*  89 */     this.crystalB.func_78793_a(0.0F, -21.0F, 0.0F);
/*  90 */     this.crystalB.func_78790_a(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
/*  91 */     setRotateAngle(this.crystalB, -0.7740535F, 0.0F, -0.8196066F);
/*     */     
/*  93 */     this.crystalA = new ModelRenderer(this, 9, 0);
/*  94 */     this.crystalA.func_78793_a(0.0F, -21.0F, 0.0F);
/*  95 */     this.crystalA.func_78790_a(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
/*  96 */     setRotateAngle(this.crystalA, 0.7853982F, 0.0F, 0.7853982F);
/*     */     
/*  98 */     this.coreLower = new ModelRenderer(this, 0, 0);
/*  99 */     this.coreLower.func_78793_a(0.0F, 8.0F, 0.0F);
/* 100 */     this.coreLower.func_78790_a(-1.0F, 0.0F, -1.0F, 2, 16, 2, 0.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float outerWingShift;
/*     */   
/*     */ 
/*     */   public float upperWingShift;
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 112 */     for (int i = 0; i < this.wingUpper.length; i++) {
/* 113 */       float z = this.innerWingShift * (float)Math.sin(this.wingInner[i].field_78796_g);
/* 114 */       float x = this.innerWingShift * -(float)Math.cos(this.wingInner[i].field_78796_g);
/* 115 */       GlStateManager.func_179109_b(x, 0.0F, z);
/* 116 */       this.wingInner[i].func_78785_a(f5);
/* 117 */       GlStateManager.func_179109_b(-x, 0.0F, -z);
/*     */       
/* 119 */       z = this.outerWingShift * (float)Math.sin(this.wingOuter[i].field_78796_g);
/* 120 */       x = this.outerWingShift * -(float)Math.cos(this.wingOuter[i].field_78796_g);
/* 121 */       GlStateManager.func_179109_b(x, 0.0F, z);
/* 122 */       this.wingOuter[i].func_78785_a(f5);
/* 123 */       GlStateManager.func_179109_b(-x, 0.0F, -z);
/*     */       
/* 125 */       z = this.upperWingShift * (float)Math.sin(this.wingUpper[i].field_78796_g);
/* 126 */       x = this.upperWingShift * -(float)Math.cos(this.wingUpper[i].field_78796_g);
/* 127 */       GlStateManager.func_179109_b(x, 0.0F, z);
/* 128 */       this.wingUpper[i].func_78785_a(f5);
/* 129 */       GlStateManager.func_179109_b(-x, 0.0F, -z);
/*     */     }
/*     */     
/* 132 */     for (int i = 0; i < this.supportLower.length; i++) {
/* 133 */       this.supportLower[i].func_78785_a(f5);
/*     */     }
/*     */     
/* 136 */     this.coreUpper.func_78785_a(f5);
/* 137 */     this.coreMiddle.func_78785_a(f5);
/* 138 */     this.crystalB.func_78785_a(f5);
/* 139 */     this.crystalA.func_78785_a(f5);
/* 140 */     this.coreLower.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 147 */     modelRenderer.field_78795_f = x;
/* 148 */     modelRenderer.field_78796_g = y;
/* 149 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelSoulForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */