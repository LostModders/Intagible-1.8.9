/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelSpiderBlock
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer legR4;
/*     */   public ModelRenderer legR2;
/*     */   public ModelRenderer legR1;
/*     */   public ModelRenderer legL4;
/*     */   public ModelRenderer legL3;
/*     */   public ModelRenderer legL2;
/*     */   public ModelRenderer legL1;
/*     */   public ModelRenderer legR3;
/*     */   public ModelRenderer legR4b;
/*     */   public ModelRenderer legR2b;
/*     */   public ModelRenderer legR1b;
/*     */   public ModelRenderer legL4b;
/*     */   public ModelRenderer legL3b;
/*     */   public ModelRenderer legL2b;
/*     */   public ModelRenderer legL1b;
/*     */   public ModelRenderer legR3b;
/*     */   
/*     */   public ModelSpiderBlock()
/*     */   {
/*  34 */     this.field_78090_t = 64;
/*  35 */     this.field_78089_u = 64;
/*     */     
/*  37 */     this.legL4 = new ModelRenderer(this, 0, 0);
/*  38 */     this.legL4.func_78793_a(4.0F, 15.0F, 2.0F);
/*  39 */     this.legL4.func_78790_a(-2.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/*  40 */     setRotateAngle(this.legL4, 0.34906584F, -0.7853982F, -0.61086524F);
/*  41 */     this.legL3b = new ModelRenderer(this, 28, 4);
/*  42 */     this.legL3b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.legL3b.func_78790_a(-1.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  44 */     setRotateAngle(this.legL3b, 0.0F, 0.0F, 1.5707964F);
/*  45 */     this.legL1b = new ModelRenderer(this, 28, 4);
/*  46 */     this.legL1b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.legL1b.func_78790_a(-1.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  48 */     setRotateAngle(this.legL1b, 0.0F, 0.0F, 1.5707964F);
/*  49 */     this.legL2 = new ModelRenderer(this, 0, 0);
/*  50 */     this.legL2.func_78793_a(4.0F, 15.0F, 0.0F);
/*  51 */     this.legL2.func_78790_a(-2.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/*  52 */     setRotateAngle(this.legL2, 0.0F, 0.3926991F, -0.58119464F);
/*  53 */     this.legR4b = new ModelRenderer(this, 28, 4);
/*  54 */     this.legR4b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.legR4b.func_78790_a(-15.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  56 */     setRotateAngle(this.legR4b, 0.0F, 0.0F, -1.5707964F);
/*  57 */     this.legR1 = new ModelRenderer(this, 0, 0);
/*  58 */     this.legR1.func_78793_a(-4.0F, 15.0F, -1.0F);
/*  59 */     this.legR1.func_78790_a(-13.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/*  60 */     setRotateAngle(this.legR1, -0.3630285F, -0.7853982F, 0.61086524F);
/*  61 */     this.legL3 = new ModelRenderer(this, 0, 0);
/*  62 */     this.legL3.func_78793_a(4.0F, 15.0F, 1.0F);
/*  63 */     this.legL3.func_78790_a(-2.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/*  64 */     setRotateAngle(this.legL3, 0.0F, -0.3926991F, -0.58119464F);
/*  65 */     this.legL4b = new ModelRenderer(this, 28, 4);
/*  66 */     this.legL4b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.legL4b.func_78790_a(-1.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  68 */     setRotateAngle(this.legL4b, 0.0F, 0.0F, 1.5707964F);
/*  69 */     this.legR2 = new ModelRenderer(this, 0, 0);
/*  70 */     this.legR2.func_78793_a(-4.0F, 15.0F, 0.0F);
/*  71 */     this.legR2.func_78790_a(-13.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/*  72 */     setRotateAngle(this.legR2, 0.0F, -0.3926991F, 0.58119464F);
/*  73 */     this.legR4 = new ModelRenderer(this, 0, 0);
/*  74 */     this.legR4.func_78793_a(-4.0F, 15.0F, 2.0F);
/*  75 */     this.legR4.func_78790_a(-13.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/*  76 */     setRotateAngle(this.legR4, 0.34906584F, 0.7853982F, 0.61086524F);
/*  77 */     this.legL2b = new ModelRenderer(this, 28, 4);
/*  78 */     this.legL2b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.legL2b.func_78790_a(-1.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  80 */     setRotateAngle(this.legL2b, 0.0F, 0.0F, 1.5707964F);
/*  81 */     this.legL1 = new ModelRenderer(this, 0, 0);
/*  82 */     this.legL1.func_78793_a(4.0F, 15.0F, -1.0F);
/*  83 */     this.legL1.func_78790_a(-2.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/*  84 */     setRotateAngle(this.legL1, -0.34906584F, 0.7853982F, -0.61086524F);
/*     */     
/*  86 */     this.legR1b = new ModelRenderer(this, 28, 4);
/*  87 */     this.legR1b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.legR1b.func_78790_a(-15.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  89 */     setRotateAngle(this.legR1b, 0.0F, 0.0F, -1.5707964F);
/*  90 */     this.legR2b = new ModelRenderer(this, 28, 4);
/*  91 */     this.legR2b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.legR2b.func_78790_a(-15.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  93 */     setRotateAngle(this.legR2b, 0.0F, 0.0F, -1.5707964F);
/*  94 */     this.legR3b = new ModelRenderer(this, 28, 4);
/*  95 */     this.legR3b.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.legR3b.func_78790_a(-15.0F, -15.0F, -1.0F, 16, 2, 2, 0.0F);
/*  97 */     setRotateAngle(this.legR3b, 0.0F, 0.0F, -1.5707964F);
/*  98 */     this.legR3 = new ModelRenderer(this, 0, 0);
/*  99 */     this.legR3.func_78793_a(-4.0F, 15.0F, 1.0F);
/* 100 */     this.legR3.func_78790_a(-13.0F, -1.0F, -1.0F, 15, 2, 2, 0.0F);
/* 101 */     setRotateAngle(this.legR3, 0.0F, 0.3926991F, 0.58119464F);
/*     */     
/* 103 */     this.legL3.func_78792_a(this.legL3b);
/* 104 */     this.legL1.func_78792_a(this.legL1b);
/* 105 */     this.legR4.func_78792_a(this.legR4b);
/* 106 */     this.legL4.func_78792_a(this.legL4b);
/* 107 */     this.legL2.func_78792_a(this.legL2b);
/* 108 */     this.legR1.func_78792_a(this.legR1b);
/* 109 */     this.legR2.func_78792_a(this.legR2b);
/* 110 */     this.legR3.func_78792_a(this.legR3b);
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 114 */     modelRenderer.field_78795_f = x;
/* 115 */     modelRenderer.field_78796_g = y;
/* 116 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float f5)
/*     */   {
/* 121 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, f5, entity);
/*     */     
/* 123 */     if (entity.field_70173_aa > 20) {
/* 124 */       this.legL4.func_78785_a(f5);
/* 125 */       this.legL2.func_78785_a(f5);
/* 126 */       this.legR1.func_78785_a(f5);
/* 127 */       this.legL3.func_78785_a(f5);
/* 128 */       this.legR2.func_78785_a(f5);
/* 129 */       this.legR4.func_78785_a(f5);
/* 130 */       this.legL1.func_78785_a(f5);
/* 131 */       this.legR3.func_78785_a(f5);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
/*     */   {
/* 137 */     float f6 = -0.55850536F;
/* 138 */     this.legR4.field_78808_h = (-f6);
/* 139 */     this.legL4.field_78808_h = f6;
/* 140 */     this.legR3.field_78808_h = (-f6 * 0.74F);
/* 141 */     this.legL3.field_78808_h = (f6 * 0.74F);
/* 142 */     this.legR2.field_78808_h = (-f6 * 0.74F);
/* 143 */     this.legL2.field_78808_h = (f6 * 0.74F);
/* 144 */     this.legR1.field_78808_h = (-f6);
/* 145 */     this.legL1.field_78808_h = f6;
/* 146 */     float f7 = -0.0F;
/* 147 */     float f8 = 0.3926991F;
/* 148 */     this.legR4.field_78796_g = (f8 * 2.0F + f7);
/* 149 */     this.legL4.field_78796_g = (-f8 * 2.0F - f7);
/* 150 */     this.legR3.field_78796_g = (f8 * 1.0F + f7);
/* 151 */     this.legL3.field_78796_g = (-f8 * 1.0F - f7);
/* 152 */     this.legR2.field_78796_g = (-f8 * 1.0F + f7);
/* 153 */     this.legL2.field_78796_g = (f8 * 1.0F - f7);
/* 154 */     this.legR1.field_78796_g = (-f8 * 2.0F + f7);
/* 155 */     this.legL1.field_78796_g = (f8 * 2.0F - f7);
/* 156 */     float f9 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 0.0F) * 0.4F) * p_78087_2_;
/* 157 */     float f10 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 3.1415927F) * 0.4F) * p_78087_2_;
/* 158 */     float f11 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 1.5707964F) * 0.4F) * p_78087_2_;
/* 159 */     float f12 = -(MathHelper.func_76134_b(p_78087_1_ * 0.6662F * 2.0F + 4.712389F) * 0.4F) * p_78087_2_;
/* 160 */     float f13 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 0.0F) * 0.4F) * p_78087_2_;
/* 161 */     float f14 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 3.1415927F) * 0.4F) * p_78087_2_;
/* 162 */     float f15 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 1.5707964F) * 0.4F) * p_78087_2_;
/* 163 */     float f16 = Math.abs(MathHelper.func_76126_a(p_78087_1_ * 0.6662F + 4.712389F) * 0.4F) * p_78087_2_;
/* 164 */     this.legR4.field_78796_g += f9;
/* 165 */     this.legL4.field_78796_g += -f9;
/* 166 */     this.legR3.field_78796_g += f10;
/* 167 */     this.legL3.field_78796_g += -f10;
/* 168 */     this.legR2.field_78796_g += f11;
/* 169 */     this.legL2.field_78796_g += -f11;
/* 170 */     this.legR1.field_78796_g += f12;
/* 171 */     this.legL1.field_78796_g += -f12;
/* 172 */     this.legR4.field_78808_h += f13;
/* 173 */     this.legL4.field_78808_h += -f13;
/* 174 */     this.legR3.field_78808_h += f14;
/* 175 */     this.legL3.field_78808_h += -f14;
/* 176 */     this.legR2.field_78808_h += f15;
/* 177 */     this.legL2.field_78808_h += -f15;
/* 178 */     this.legR1.field_78808_h += f16;
/* 179 */     this.legL1.field_78808_h += -f16;
/*     */     
/* 181 */     this.legL1.field_78795_f = (this.legR1.field_78795_f = -0.5235988F);
/* 182 */     this.legL4.field_78795_f = (this.legR4.field_78795_f = 0.5235988F);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelSpiderBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */