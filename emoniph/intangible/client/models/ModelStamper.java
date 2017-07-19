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
/*     */ public class ModelStamper
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer baseFrontLeft;
/*     */   public ModelRenderer baseBottom;
/*     */   public ModelRenderer baseBack;
/*     */   public ModelRenderer baseFrontRight;
/*     */   public ModelRenderer base;
/*     */   public ModelRenderer traySepLR;
/*     */   public ModelRenderer trayFront;
/*     */   public ModelRenderer trayLeft;
/*     */   public ModelRenderer traySepFB;
/*     */   public ModelRenderer trayRight;
/*     */   public ModelRenderer trayBack;
/*     */   public ModelRenderer lid;
/*     */   public ModelRenderer lidTop1;
/*     */   public ModelRenderer lidTop2;
/*     */   public ModelRenderer lidRimRight;
/*     */   public ModelRenderer lidRimBack;
/*     */   public ModelRenderer lidRimLeft;
/*     */   public ModelRenderer lidRimFront;
/*     */   public ModelRenderer handle;
/*     */   public ModelRenderer stampBR;
/*     */   public ModelRenderer stampBL;
/*     */   public ModelRenderer stampFR;
/*     */   public ModelRenderer stampFL;
/*     */   
/*     */   public ModelStamper()
/*     */   {
/*  40 */     this.field_78090_t = 128;
/*  41 */     this.field_78089_u = 64;
/*  42 */     this.baseBack = new ModelRenderer(this, 0, 16);
/*  43 */     this.baseBack.func_78793_a(0.0F, 21.0F, 0.0F);
/*  44 */     this.baseBack.func_78790_a(-7.0F, 0.0F, -5.0F, 14, 2, 12, 0.0F);
/*  45 */     this.lidRimFront = new ModelRenderer(this, 0, 0);
/*  46 */     this.lidRimFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.lidRimFront.func_78790_a(-16.0F, -1.0F, -8.0F, 1, 1, 15, 0.0F);
/*  48 */     setRotateAngle(this.lidRimFront, 0.0F, -1.5707964F, 0.0F);
/*  49 */     this.lidTop1 = new ModelRenderer(this, 68, 32);
/*  50 */     this.lidTop1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.lidTop1.func_78790_a(-7.0F, -2.5F, -15.0F, 14, 1, 14, 0.0F);
/*  52 */     this.stampBR = new ModelRenderer(this, 22, 0);
/*  53 */     this.stampBR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.stampBR.func_78790_a(-5.5F, -1.2F, -6.5F, 4, 2, 4, 0.0F);
/*  55 */     this.lidRimBack = new ModelRenderer(this, 0, 0);
/*  56 */     this.lidRimBack.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.lidRimBack.func_78790_a(0.0F, -1.0F, -8.0F, 1, 1, 15, 0.0F);
/*  58 */     setRotateAngle(this.lidRimBack, 0.0F, 1.5707964F, 0.0F);
/*  59 */     this.lidTop2 = new ModelRenderer(this, 72, 19);
/*  60 */     this.lidTop2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.lidTop2.func_78790_a(-6.0F, -3.0F, -14.0F, 12, 1, 12, 0.0F);
/*  62 */     this.base = new ModelRenderer(this, 0, 30);
/*  63 */     this.base.func_78793_a(0.0F, 20.0F, 0.0F);
/*  64 */     this.base.func_78790_a(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
/*  65 */     this.lidRimLeft = new ModelRenderer(this, 0, 0);
/*  66 */     this.lidRimLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.lidRimLeft.func_78790_a(-8.0F, -1.0F, 0.0F, 1, 1, 15, 0.0F);
/*  68 */     setRotateAngle(this.lidRimLeft, 0.0F, 3.1415927F, 0.0F);
/*  69 */     this.trayRight = new ModelRenderer(this, 0, 0);
/*  70 */     this.trayRight.func_78793_a(0.0F, 19.0F, 0.0F);
/*  71 */     this.trayRight.func_78790_a(-8.0F, 0.0F, -8.0F, 1, 1, 15, 0.0F);
/*  72 */     this.lidRimRight = new ModelRenderer(this, 0, 0);
/*  73 */     this.lidRimRight.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.lidRimRight.func_78790_a(-8.0F, -1.0F, -16.0F, 1, 1, 15, 0.0F);
/*  75 */     this.traySepFB = new ModelRenderer(this, 36, 0);
/*  76 */     this.traySepFB.func_78793_a(0.0F, 19.0F, 0.0F);
/*  77 */     this.traySepFB.func_78790_a(-0.5F, 0.1F, -7.0F, 1, 1, 14, 0.0F);
/*  78 */     this.baseBottom = new ModelRenderer(this, 0, 47);
/*  79 */     this.baseBottom.func_78793_a(0.0F, 23.0F, 0.0F);
/*  80 */     this.baseBottom.func_78790_a(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
/*  81 */     this.trayBack = new ModelRenderer(this, 0, 0);
/*  82 */     this.trayBack.func_78793_a(0.0F, 19.0F, 0.0F);
/*  83 */     this.trayBack.func_78790_a(-8.0F, 0.0F, -8.0F, 1, 1, 15, 0.0F);
/*  84 */     setRotateAngle(this.trayBack, 0.0F, 1.5707964F, 0.0F);
/*  85 */     this.handle = new ModelRenderer(this, 0, 0);
/*  86 */     this.handle.func_78793_a(0.0F, 0.0F, 0.0F);
/*  87 */     this.handle.func_78790_a(-2.0F, -0.8F, -16.8F, 4, 1, 1, 0.0F);
/*  88 */     this.stampBL = new ModelRenderer(this, 22, 0);
/*  89 */     this.stampBL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  90 */     this.stampBL.func_78790_a(1.5F, -1.2F, -6.5F, 4, 2, 4, 0.0F);
/*  91 */     this.stampFL = new ModelRenderer(this, 22, 0);
/*  92 */     this.stampFL.func_78793_a(0.0F, 0.0F, 0.0F);
/*  93 */     this.stampFL.func_78790_a(1.5F, -1.2F, -13.5F, 4, 2, 4, 0.0F);
/*  94 */     this.stampFR = new ModelRenderer(this, 22, 0);
/*  95 */     this.stampFR.func_78793_a(0.0F, 0.0F, 0.0F);
/*  96 */     this.stampFR.func_78790_a(-5.5F, -1.2F, -13.5F, 4, 2, 4, 0.0F);
/*  97 */     this.baseFrontLeft = new ModelRenderer(this, 0, 40);
/*  98 */     this.baseFrontLeft.field_78809_i = true;
/*  99 */     this.baseFrontLeft.func_78793_a(0.0F, 21.0F, 0.0F);
/* 100 */     this.baseFrontLeft.func_78790_a(3.0F, 0.0F, -7.0F, 4, 2, 2, 0.0F);
/* 101 */     this.trayLeft = new ModelRenderer(this, 0, 0);
/* 102 */     this.trayLeft.func_78793_a(0.0F, 19.0F, 0.0F);
/* 103 */     this.trayLeft.func_78790_a(-8.0F, 0.0F, -8.0F, 1, 1, 15, 0.0F);
/* 104 */     setRotateAngle(this.trayLeft, 0.0F, 3.1415927F, 0.0F);
/* 105 */     this.trayFront = new ModelRenderer(this, 0, 0);
/* 106 */     this.trayFront.func_78793_a(0.0F, 19.0F, 0.0F);
/* 107 */     this.trayFront.func_78790_a(-8.0F, 0.0F, -8.0F, 1, 1, 15, 0.0F);
/* 108 */     setRotateAngle(this.trayFront, 0.0F, -1.5707964F, 0.0F);
/* 109 */     this.traySepLR = new ModelRenderer(this, 36, 0);
/* 110 */     this.traySepLR.func_78793_a(0.0F, 19.0F, 0.0F);
/* 111 */     this.traySepLR.func_78790_a(-0.5F, 0.2F, -7.0F, 1, 1, 14, 0.0F);
/* 112 */     setRotateAngle(this.traySepLR, 0.0F, 1.5707964F, 0.0F);
/* 113 */     this.lid = new ModelRenderer(this, 64, 47);
/* 114 */     this.lid.func_78793_a(0.0F, 19.0F, 8.0F);
/* 115 */     this.lid.func_78790_a(-8.0F, -2.0F, -16.0F, 16, 1, 16, 0.0F);
/* 116 */     setRotateAngle(this.lid, -1.5025539F, 0.0F, 0.0F);
/* 117 */     this.baseFrontRight = new ModelRenderer(this, 0, 40);
/* 118 */     this.baseFrontRight.func_78793_a(0.0F, 21.0F, 0.0F);
/* 119 */     this.baseFrontRight.func_78790_a(-7.0F, 0.0F, -7.0F, 4, 2, 2, 0.0F);
/* 120 */     this.lid.func_78792_a(this.lidRimFront);
/* 121 */     this.lid.func_78792_a(this.lidTop1);
/* 122 */     this.lid.func_78792_a(this.stampBR);
/* 123 */     this.lid.func_78792_a(this.lidRimBack);
/* 124 */     this.lid.func_78792_a(this.lidTop2);
/* 125 */     this.lid.func_78792_a(this.lidRimLeft);
/* 126 */     this.lid.func_78792_a(this.lidRimRight);
/* 127 */     this.lid.func_78792_a(this.handle);
/* 128 */     this.lid.func_78792_a(this.stampBL);
/* 129 */     this.lid.func_78792_a(this.stampFL);
/* 130 */     this.lid.func_78792_a(this.stampFR);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 135 */     this.baseBack.func_78785_a(f5);
/* 136 */     this.base.func_78785_a(f5);
/* 137 */     this.trayRight.func_78785_a(f5);
/* 138 */     this.traySepFB.func_78785_a(f5);
/* 139 */     this.baseBottom.func_78785_a(f5);
/* 140 */     this.trayBack.func_78785_a(f5);
/* 141 */     this.baseFrontLeft.func_78785_a(f5);
/* 142 */     this.trayLeft.func_78785_a(f5);
/* 143 */     this.trayFront.func_78785_a(f5);
/* 144 */     this.traySepLR.func_78785_a(f5);
/* 145 */     this.lid.func_78785_a(f5);
/* 146 */     this.baseFrontRight.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 153 */     modelRenderer.field_78795_f = x;
/* 154 */     modelRenderer.field_78796_g = y;
/* 155 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelStamper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */