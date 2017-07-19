/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelCrystal
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer pillar3;
/*     */   public ModelRenderer pillar5;
/*     */   public ModelRenderer pillar4;
/*     */   public ModelRenderer pillar2;
/*     */   public ModelRenderer pillar1;
/*     */   public ModelRenderer base1;
/*     */   public ModelRenderer base2;
/*     */   public ModelRenderer base3;
/*     */   public ModelRenderer base4;
/*     */   public ModelRenderer shoot1;
/*     */   public ModelRenderer base5;
/*     */   public ModelRenderer base6;
/*     */   public ModelRenderer base7;
/*     */   public ModelRenderer base8;
/*     */   public ModelRenderer base9;
/*     */   public ModelRenderer pillar3top;
/*     */   public ModelRenderer pillar5top;
/*     */   public ModelRenderer pillar4top;
/*     */   public ModelRenderer pillar2top;
/*     */   public ModelRenderer pillar1top;
/*     */   public int rarePillar;
/*     */   public int rarePillarColor;
/*     */   public int pillarColor;
/*     */   public float lastPillarScale;
/*     */   private ModelRenderer[] pillars;
/*     */   
/*     */   public ModelCrystal()
/*     */   {
/*  45 */     float TOP_SCALE = -0.01F;
/*  46 */     this.field_78090_t = 32;
/*  47 */     this.field_78089_u = 32;
/*  48 */     this.pillar2 = new ModelRenderer(this, 0, 0);
/*  49 */     this.pillar2.func_78793_a(0.0F, 28.4F, 0.0F);
/*  50 */     this.pillar2.func_78790_a(-1.5F, -16.0F, -1.5F, 3, 11, 3, 0.0F);
/*  51 */     setRotateAngle(this.pillar2, 0.5462881F, -2.003289F, -0.4553564F);
/*  52 */     this.shoot1 = new ModelRenderer(this, 13, 5);
/*  53 */     this.shoot1.func_78793_a(1.3F, 19.5F, -0.4F);
/*  54 */     this.shoot1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 5, 2, 0.0F);
/*  55 */     setRotateAngle(this.shoot1, 0.045553092F, 0.045553092F, 0.4098033F);
/*  56 */     this.pillar3top = new ModelRenderer(this, 12, 0);
/*  57 */     this.pillar3top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.pillar3top.func_78790_a(-1.5F, -12.3F, 10.3F, 3, 2, 2, -0.01F);
/*  59 */     setRotateAngle(this.pillar3top, 0.7853982F, 0.0F, 0.0F);
/*  60 */     this.base6 = new ModelRenderer(this, 13, 5);
/*  61 */     this.base6.func_78793_a(-1.6F, 23.1F, 3.0F);
/*  62 */     this.base6.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  63 */     setRotateAngle(this.base6, -0.3642502F, 0.0F, -0.4553564F);
/*  64 */     this.base3 = new ModelRenderer(this, 13, 5);
/*  65 */     this.base3.func_78793_a(1.4F, 23.1F, -1.2F);
/*  66 */     this.base3.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  67 */     setRotateAngle(this.base3, -1.0016445F, 0.5462881F, -0.4553564F);
/*  68 */     this.pillar5 = new ModelRenderer(this, 0, 0);
/*  69 */     this.pillar5.func_78793_a(0.0F, 24.0F, 0.0F);
/*  70 */     this.pillar5.func_78790_a(-1.5F, -16.0F, -1.5F, 3, 16, 3, 0.0F);
/*  71 */     setRotateAngle(this.pillar5, 0.13665928F, -0.4098033F, 0.22759093F);
/*  72 */     this.base4 = new ModelRenderer(this, 13, 5);
/*  73 */     this.base4.func_78793_a(2.3F, 23.1F, 0.3F);
/*  74 */     this.base4.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  75 */     setRotateAngle(this.base4, -0.91053826F, 1.1838568F, -0.4553564F);
/*  76 */     this.pillar5top = new ModelRenderer(this, 12, 0);
/*  77 */     this.pillar5top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.pillar5top.func_78790_a(-1.5F, -12.3F, 10.3F, 3, 2, 2, -0.01F);
/*  79 */     setRotateAngle(this.pillar5top, 0.7853982F, 0.0F, 0.0F);
/*  80 */     this.pillar2top = new ModelRenderer(this, 12, 0);
/*  81 */     this.pillar2top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.pillar2top.func_78790_a(-1.5F, -12.3F, 10.3F, 3, 2, 2, -0.01F);
/*  83 */     setRotateAngle(this.pillar2top, 0.7853982F, 0.0F, 0.0F);
/*  84 */     this.base8 = new ModelRenderer(this, 13, 5);
/*  85 */     this.base8.func_78793_a(-0.1F, 21.2F, 1.4F);
/*  86 */     this.base8.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F);
/*  87 */     setRotateAngle(this.base8, -0.18203785F, 0.18203785F, -0.18203785F);
/*  88 */     this.pillar3 = new ModelRenderer(this, 0, 0);
/*  89 */     this.pillar3.func_78793_a(0.0F, 25.8F, 0.0F);
/*  90 */     this.pillar3.func_78790_a(-1.5F, -16.0F, -1.5F, 3, 14, 3, 0.0F);
/*  91 */     setRotateAngle(this.pillar3, -0.31869712F, 0.31869712F, -0.3642502F);
/*  92 */     this.base2 = new ModelRenderer(this, 13, 5);
/*  93 */     this.base2.func_78793_a(-0.8F, 23.1F, -2.4F);
/*  94 */     this.base2.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  95 */     setRotateAngle(this.base2, -0.4098033F, 0.5462881F, -0.4553564F);
/*  96 */     this.pillar1top = new ModelRenderer(this, 12, 0);
/*  97 */     this.pillar1top.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.pillar1top.func_78790_a(-1.5F, -12.3F, 10.3F, 3, 2, 2, -0.01F);
/*  99 */     setRotateAngle(this.pillar1top, 0.7853982F, 0.0F, 0.0F);
/* 100 */     this.base1 = new ModelRenderer(this, 13, 5);
/* 101 */     this.base1.func_78793_a(-2.1F, 22.6F, -2.4F);
/* 102 */     this.base1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 103 */     setRotateAngle(this.base1, -1.1838568F, 1.0471976F, -0.4553564F);
/* 104 */     this.base5 = new ModelRenderer(this, 13, 5);
/* 105 */     this.base5.func_78793_a(-0.3F, 23.1F, 3.1F);
/* 106 */     this.base5.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 107 */     setRotateAngle(this.base5, -0.3642502F, 0.7740535F, -0.4553564F);
/* 108 */     this.pillar4 = new ModelRenderer(this, 0, 0);
/* 109 */     this.pillar4.func_78793_a(0.0F, 30.2F, 0.0F);
/* 110 */     this.pillar4.func_78790_a(-1.5F, -16.0F, -1.5F, 3, 9, 3, 0.0F);
/* 111 */     setRotateAngle(this.pillar4, 0.045553092F, -0.27314404F, -0.3642502F);
/* 112 */     this.pillar1 = new ModelRenderer(this, 0, 0);
/* 113 */     this.pillar1.func_78793_a(0.0F, 25.8F, 0.0F);
/* 114 */     this.pillar1.func_78790_a(-1.5F, -16.0F, -1.5F, 3, 14, 3, 0.0F);
/* 115 */     setRotateAngle(this.pillar1, 0.045553092F, -0.091106184F, -0.091106184F);
/* 116 */     this.base7 = new ModelRenderer(this, 13, 5);
/* 117 */     this.base7.func_78793_a(-2.8F, 23.1F, 1.4F);
/* 118 */     this.base7.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 119 */     setRotateAngle(this.base7, -0.63739425F, -0.68294734F, 0.95609134F);
/* 120 */     this.base9 = new ModelRenderer(this, 13, 5);
/* 121 */     this.base9.func_78793_a(-1.4F, 22.7F, -0.9F);
/* 122 */     this.base9.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F);
/* 123 */     setRotateAngle(this.base9, 1.1838568F, 0.31869712F, 0.7740535F);
/* 124 */     this.pillar4top = new ModelRenderer(this, 12, 0);
/* 125 */     this.pillar4top.func_78793_a(0.0F, 0.0F, 0.0F);
/* 126 */     this.pillar4top.func_78790_a(-1.5F, -12.3F, 10.3F, 3, 2, 2, -0.01F);
/* 127 */     setRotateAngle(this.pillar4top, 0.7853982F, 0.0F, 0.0F);
/* 128 */     this.pillar3.func_78792_a(this.pillar3top);
/* 129 */     this.pillar5.func_78792_a(this.pillar5top);
/* 130 */     this.pillar2.func_78792_a(this.pillar2top);
/* 131 */     this.pillar1.func_78792_a(this.pillar1top);
/* 132 */     this.pillar4.func_78792_a(this.pillar4top);
/*     */     
/* 134 */     this.pillars = new ModelRenderer[] { this.pillar1, this.pillar2, this.pillar3, this.pillar4, this.pillar5 };
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 139 */     RenderUtil.color(this.pillarColor);
/* 140 */     this.base6.func_78785_a(f5);
/* 141 */     this.base3.func_78785_a(f5);
/* 142 */     this.base4.func_78785_a(f5);
/* 143 */     this.base8.func_78785_a(f5);
/* 144 */     this.base2.func_78785_a(f5);
/* 145 */     this.base1.func_78785_a(f5);
/* 146 */     this.base5.func_78785_a(f5);
/* 147 */     this.base7.func_78785_a(f5);
/* 148 */     this.base9.func_78785_a(f5);
/* 149 */     this.shoot1.func_78785_a(f5);
/*     */     
/* 151 */     boolean lastFound = false;
/*     */     
/* 153 */     float[] ROT_PT_Y = { 25.8F, 28.4F, 25.8F, 30.2F, 24.0F };
/*     */     
/* 155 */     for (int i = this.pillars.length - 1; i >= 0; i--)
/*     */     {
/* 157 */       if ((!lastFound) && (this.pillars[i].field_78806_j))
/*     */       {
/* 159 */         if ((this.rarePillar > 0) && (((this.rarePillar == 5) && (i == 3)) || (i == 4))) {
/* 160 */           RenderUtil.color(this.rarePillarColor);
/*     */         } else {
/* 162 */           RenderUtil.color(this.pillarColor);
/*     */         }
/*     */         
/* 165 */         this.pillars[i].field_78797_d = (ROT_PT_Y[i] + (8.0F - 8.0F * this.lastPillarScale));
/* 166 */         this.pillars[i].func_78785_a(f5);
/* 167 */         lastFound = true;
/*     */       } else {
/* 169 */         RenderUtil.color(this.pillarColor);
/* 170 */         this.pillars[i].field_78797_d = ROT_PT_Y[i];
/* 171 */         this.pillars[i].func_78785_a(f5);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 181 */     modelRenderer.field_78795_f = x;
/* 182 */     modelRenderer.field_78796_g = y;
/* 183 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */