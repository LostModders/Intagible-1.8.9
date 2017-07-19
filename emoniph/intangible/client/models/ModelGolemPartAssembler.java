/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelGolemPartAssembler
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer core;
/*     */   public ModelRenderer base1F;
/*     */   public ModelRenderer leg1;
/*     */   public ModelRenderer leg2;
/*     */   public ModelRenderer leg3;
/*     */   public ModelRenderer leg4;
/*     */   public ModelRenderer armR;
/*     */   public ModelRenderer base;
/*     */   public ModelRenderer base1R;
/*     */   public ModelRenderer base1B;
/*     */   public ModelRenderer base1L;
/*     */   public ModelRenderer armL;
/*     */   public ModelRenderer armB;
/*     */   public ModelRenderer armF;
/*     */   public ModelRenderer armStrut1R;
/*     */   public ModelRenderer armStrut2R;
/*     */   public ModelRenderer armPlateR;
/*     */   public ModelRenderer armStrut1L;
/*     */   public ModelRenderer armStrut2L;
/*     */   public ModelRenderer armPlateL;
/*     */   public ModelRenderer armStrut1B;
/*     */   public ModelRenderer armStrut2B;
/*     */   public ModelRenderer armPlateB;
/*     */   public ModelRenderer armStrut1F;
/*     */   public ModelRenderer armStrut2F;
/*     */   public ModelRenderer armPlateF;
/*     */   
/*     */   public ModelGolemPartAssembler()
/*     */   {
/*  43 */     this.field_78090_t = 64;
/*  44 */     this.field_78089_u = 64;
/*  45 */     this.armPlateL = new ModelRenderer(this, 34, 13);
/*  46 */     this.armPlateL.func_78793_a(-0.5F, -11.0F, 0.0F);
/*  47 */     this.armPlateL.func_78790_a(-1.5F, -2.5F, -2.5F, 1, 5, 5, 0.0F);
/*  48 */     setRotateAngle(this.armPlateL, 0.0F, 0.0F, 0.18203785F);
/*  49 */     this.leg4 = new ModelRenderer(this, 0, 14);
/*  50 */     this.leg4.func_78793_a(2.9F, 14.0F, -2.9F);
/*  51 */     this.leg4.func_78790_a(-1.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
/*  52 */     setRotateAngle(this.leg4, 0.18203785F, 0.0F, 0.18203785F);
/*  53 */     this.armStrut1L = new ModelRenderer(this, 28, 13);
/*  54 */     this.armStrut1L.func_78793_a(-0.5F, -11.1F, -4.5F);
/*  55 */     this.armStrut1L.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/*  56 */     setRotateAngle(this.armStrut1L, 0.18203785F, 0.0F, 0.0F);
/*  57 */     this.armR = new ModelRenderer(this, 5, 14);
/*  58 */     this.armR.func_78793_a(-4.0F, 23.3F, 0.0F);
/*  59 */     this.armR.func_78790_a(-1.0F, -12.0F, -5.0F, 1, 1, 10, 0.0F);
/*  60 */     setRotateAngle(this.armR, 0.0F, 0.0F, -0.18203785F);
/*  61 */     this.armStrut2F = new ModelRenderer(this, 28, 13);
/*  62 */     this.armStrut2F.func_78793_a(4.5F, -11.1F, -0.5F);
/*  63 */     this.armStrut2F.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/*  64 */     setRotateAngle(this.armStrut2F, 0.0F, 0.0F, 0.18203785F);
/*  65 */     this.leg1 = new ModelRenderer(this, 0, 14);
/*  66 */     this.leg1.func_78793_a(2.9F, 14.0F, 2.9F);
/*  67 */     this.leg1.func_78790_a(-1.0F, 0.0F, -1.0F, 1, 10, 1, 0.0F);
/*  68 */     setRotateAngle(this.leg1, -0.18203785F, 0.0F, 0.18203785F);
/*  69 */     this.armStrut1F = new ModelRenderer(this, 28, 13);
/*  70 */     this.armStrut1F.func_78793_a(-4.5F, -11.1F, -0.5F);
/*  71 */     this.armStrut1F.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/*  72 */     setRotateAngle(this.armStrut1F, 0.0F, 0.0F, -0.18203785F);
/*  73 */     this.armStrut1R = new ModelRenderer(this, 28, 13);
/*  74 */     this.armStrut1R.func_78793_a(-0.5F, -11.1F, -4.5F);
/*  75 */     this.armStrut1R.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/*  76 */     setRotateAngle(this.armStrut1R, 0.18203785F, 0.0F, 0.0F);
/*  77 */     this.armStrut1B = new ModelRenderer(this, 28, 13);
/*  78 */     this.armStrut1B.func_78793_a(-4.5F, -11.1F, -0.5F);
/*  79 */     this.armStrut1B.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/*  80 */     setRotateAngle(this.armStrut1B, 0.0F, 0.0F, -0.18203785F);
/*  81 */     this.armPlateR = new ModelRenderer(this, 34, 13);
/*  82 */     this.armPlateR.func_78793_a(-0.5F, -11.0F, 0.0F);
/*  83 */     this.armPlateR.func_78790_a(-1.5F, -2.5F, -2.5F, 1, 5, 5, 0.0F);
/*  84 */     setRotateAngle(this.armPlateR, 0.0F, 0.0F, 0.18203785F);
/*  85 */     this.armPlateF = new ModelRenderer(this, 34, 24);
/*  86 */     this.armPlateF.func_78793_a(-1.0F, -11.0F, -0.5F);
/*  87 */     this.armPlateF.func_78790_a(-1.5F, -2.5F, -1.5F, 5, 5, 1, 0.0F);
/*  88 */     setRotateAngle(this.armPlateF, -0.18203785F, 0.0F, 0.0F);
/*  89 */     this.base = new ModelRenderer(this, 24, 0);
/*  90 */     this.base.func_78793_a(0.0F, 23.0F, 0.0F);
/*  91 */     this.base.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 1, 10, 0.0F);
/*  92 */     this.leg3 = new ModelRenderer(this, 0, 14);
/*  93 */     this.leg3.func_78793_a(-2.9F, 14.0F, -2.9F);
/*  94 */     this.leg3.func_78790_a(0.0F, 0.0F, 0.0F, 1, 10, 1, 0.0F);
/*  95 */     setRotateAngle(this.leg3, 0.18203785F, 0.0F, -0.18203785F);
/*  96 */     this.armL = new ModelRenderer(this, 5, 14);
/*  97 */     this.armL.func_78793_a(4.0F, 23.3F, 0.0F);
/*  98 */     this.armL.func_78790_a(-1.0F, -12.0F, -5.0F, 1, 1, 10, 0.0F);
/*  99 */     setRotateAngle(this.armL, 0.0F, 3.1415927F, 0.18203785F);
/* 100 */     this.armF = new ModelRenderer(this, 5, 26);
/* 101 */     this.armF.func_78793_a(0.0F, 23.3F, -4.0F);
/* 102 */     this.armF.func_78790_a(-5.0F, -12.0F, -1.0F, 10, 1, 1, 0.0F);
/* 103 */     setRotateAngle(this.armF, 0.18203785F, 0.0F, 0.0F);
/* 104 */     this.armB = new ModelRenderer(this, 5, 26);
/* 105 */     this.armB.func_78793_a(0.0F, 23.3F, 4.0F);
/* 106 */     this.armB.func_78790_a(-5.0F, -12.0F, -1.0F, 10, 1, 1, 0.0F);
/* 107 */     setRotateAngle(this.armB, 0.18203785F, 3.1415927F, 0.0F);
/* 108 */     this.core = new ModelRenderer(this, 0, 0);
/* 109 */     this.core.func_78793_a(0.0F, 9.0F, 0.0F);
/* 110 */     this.core.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 6, 6, 0.0F);
/* 111 */     this.base1R = new ModelRenderer(this, 46, 16);
/* 112 */     this.base1R.func_78793_a(0.0F, 22.5F, 0.0F);
/* 113 */     this.base1R.func_78790_a(-5.5F, 0.0F, -3.5F, 2, 1, 7, 0.0F);
/* 114 */     this.armStrut2L = new ModelRenderer(this, 28, 13);
/* 115 */     this.armStrut2L.func_78793_a(-0.5F, -11.1F, 4.5F);
/* 116 */     this.armStrut2L.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/* 117 */     setRotateAngle(this.armStrut2L, -0.18203785F, 0.0F, 0.0F);
/* 118 */     this.armStrut2B = new ModelRenderer(this, 28, 13);
/* 119 */     this.armStrut2B.func_78793_a(4.5F, -11.1F, -0.5F);
/* 120 */     this.armStrut2B.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/* 121 */     setRotateAngle(this.armStrut2B, 0.0F, 0.0F, 0.18203785F);
/* 122 */     this.base1L = new ModelRenderer(this, 46, 16);
/* 123 */     this.base1L.func_78793_a(0.0F, 22.5F, 0.0F);
/* 124 */     this.base1L.func_78790_a(-5.5F, 0.0F, -3.5F, 2, 1, 7, 0.0F);
/* 125 */     setRotateAngle(this.base1L, 0.0F, -3.1415927F, 0.0F);
/* 126 */     this.base1F = new ModelRenderer(this, 46, 16);
/* 127 */     this.base1F.func_78793_a(0.0F, 22.5F, 0.0F);
/* 128 */     this.base1F.func_78790_a(-5.5F, 0.0F, -3.5F, 2, 1, 7, 0.0F);
/* 129 */     setRotateAngle(this.base1F, 0.0F, -1.5707964F, 0.0F);
/* 130 */     this.base1B = new ModelRenderer(this, 46, 16);
/* 131 */     this.base1B.func_78793_a(0.0F, 22.5F, 0.0F);
/* 132 */     this.base1B.func_78790_a(-5.5F, 0.0F, -3.5F, 2, 1, 7, 0.0F);
/* 133 */     setRotateAngle(this.base1B, 0.0F, 1.5707964F, 0.0F);
/* 134 */     this.leg2 = new ModelRenderer(this, 0, 14);
/* 135 */     this.leg2.func_78793_a(-2.9F, 14.0F, 2.9F);
/* 136 */     this.leg2.func_78790_a(0.0F, 0.0F, -1.0F, 1, 10, 1, 0.0F);
/* 137 */     setRotateAngle(this.leg2, -0.18203785F, 0.0F, -0.18203785F);
/* 138 */     this.armStrut2R = new ModelRenderer(this, 28, 13);
/* 139 */     this.armStrut2R.func_78793_a(-0.5F, -11.1F, 4.5F);
/* 140 */     this.armStrut2R.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F);
/* 141 */     setRotateAngle(this.armStrut2R, -0.18203785F, 0.0F, 0.0F);
/* 142 */     this.armPlateB = new ModelRenderer(this, 34, 24);
/* 143 */     this.armPlateB.func_78793_a(-1.0F, -11.0F, -0.5F);
/* 144 */     this.armPlateB.func_78790_a(-1.5F, -2.5F, -1.5F, 5, 5, 1, 0.0F);
/* 145 */     setRotateAngle(this.armPlateB, -0.18203785F, 0.0F, 0.0F);
/* 146 */     this.armL.func_78792_a(this.armPlateL);
/* 147 */     this.armL.func_78792_a(this.armStrut1L);
/* 148 */     this.armF.func_78792_a(this.armStrut2F);
/* 149 */     this.armF.func_78792_a(this.armStrut1F);
/* 150 */     this.armR.func_78792_a(this.armStrut1R);
/* 151 */     this.armB.func_78792_a(this.armStrut1B);
/* 152 */     this.armR.func_78792_a(this.armPlateR);
/* 153 */     this.armF.func_78792_a(this.armPlateF);
/* 154 */     this.armL.func_78792_a(this.armStrut2L);
/* 155 */     this.armB.func_78792_a(this.armStrut2B);
/* 156 */     this.armR.func_78792_a(this.armStrut2R);
/* 157 */     this.armB.func_78792_a(this.armPlateB);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 162 */     this.leg4.func_78785_a(f5);
/* 163 */     this.armR.func_78785_a(f5);
/* 164 */     this.leg1.func_78785_a(f5);
/* 165 */     this.base.func_78785_a(f5);
/* 166 */     this.leg3.func_78785_a(f5);
/* 167 */     this.armL.func_78785_a(f5);
/* 168 */     this.armF.func_78785_a(f5);
/* 169 */     this.armB.func_78785_a(f5);
/* 170 */     this.core.func_78785_a(f5);
/* 171 */     this.base1R.func_78785_a(f5);
/* 172 */     this.base1L.func_78785_a(f5);
/* 173 */     this.base1F.func_78785_a(f5);
/* 174 */     this.base1B.func_78785_a(f5);
/* 175 */     this.leg2.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 182 */     modelRenderer.field_78795_f = x;
/* 183 */     modelRenderer.field_78796_g = y;
/* 184 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemPartAssembler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */