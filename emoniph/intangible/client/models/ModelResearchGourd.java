/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelResearchGourd
/*     */   extends ModelResearchBlock
/*     */ {
/*     */   public ModelRenderer outputTop;
/*     */   public ModelRenderer outputBottom;
/*     */   public ModelRenderer shape11;
/*     */   public ModelRenderer outputTopSide;
/*     */   public ModelRenderer outputTopTop;
/*     */   public ModelRenderer output2;
/*     */   public ModelRenderer output3;
/*     */   public ModelRenderer outputBottomSide;
/*     */   public ModelRenderer outputBottomBottom;
/*     */   public ModelRenderer output2_1;
/*     */   public ModelRenderer output3_1;
/*     */   public ModelRenderer shape11_1;
/*     */   public ModelRenderer shape11_2;
/*     */   public ModelRenderer shape11_3;
/*     */   public ModelRenderer shape11_4;
/*     */   public ModelRenderer shape11_5;
/*     */   public ModelRenderer shape11_6;
/*     */   public ModelRenderer outputConnect;
/*     */   
/*     */   public ModelResearchGourd()
/*     */   {
/*  37 */     this.field_78090_t = 64;
/*  38 */     this.field_78089_u = 32;
/*  39 */     this.shape11 = new ModelRenderer(this, 20, 19);
/*  40 */     this.shape11.func_78793_a(0.0F, 17.5F, 0.0F);
/*  41 */     this.shape11.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 3, 6, 0.0F);
/*  42 */     this.outputTopSide = new ModelRenderer(this, 24, 0);
/*  43 */     this.outputTopSide.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.outputTopSide.func_78790_a(-0.5F, 0.0F, 0.5F, 1, 1, 4, 0.0F);
/*  45 */     this.outputBottom = new ModelRenderer(this, 43, 0);
/*  46 */     this.outputBottom.func_78793_a(0.0F, 23.0F, 0.0F);
/*  47 */     this.outputBottom.func_78790_a(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
/*  48 */     this.shape11_3 = new ModelRenderer(this, 0, 17);
/*  49 */     this.shape11_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.shape11_3.func_78790_a(-1.5F, -3.0F, -1.5F, 3, 2, 3, 0.0F);
/*  51 */     this.output2_1 = new ModelRenderer(this, 43, 0);
/*  52 */     this.output2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.output2_1.func_78790_a(-0.5F, -7.0F, 4.5F, 1, 7, 1, 0.0F);
/*  54 */     this.output3_1 = new ModelRenderer(this, 34, 0);
/*  55 */     this.output3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  56 */     this.output3_1.func_78790_a(-0.5F, -7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  57 */     this.output2 = new ModelRenderer(this, 43, 0);
/*  58 */     this.output2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.output2.func_78790_a(-0.5F, 0.0F, 4.5F, 1, 8, 1, 0.0F);
/*  60 */     this.shape11_5 = new ModelRenderer(this, 0, 5);
/*  61 */     this.shape11_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  62 */     this.shape11_5.func_78790_a(-2.5F, -6.0F, -2.5F, 5, 2, 5, 0.0F);
/*  63 */     this.outputTop = new ModelRenderer(this, 43, 0);
/*  64 */     this.outputTop.func_78793_a(0.0F, 9.0F, 0.0F);
/*  65 */     this.outputTop.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 2, 1, 0.0F);
/*  66 */     this.shape11_2 = new ModelRenderer(this, 44, 23);
/*  67 */     this.shape11_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  68 */     this.shape11_2.func_78790_a(-2.0F, 3.0F, -2.0F, 4, 1, 4, 0.0F);
/*  69 */     this.shape11_4 = new ModelRenderer(this, 0, 12);
/*  70 */     this.shape11_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.shape11_4.func_78790_a(-2.0F, -4.0F, -2.0F, 4, 1, 4, 0.0F);
/*  72 */     this.shape11_6 = new ModelRenderer(this, 0, 0);
/*  73 */     this.shape11_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.shape11_6.func_78790_a(-2.0F, -7.0F, -2.0F, 4, 1, 4, 0.0F);
/*  75 */     this.outputBottomSide = new ModelRenderer(this, 24, 0);
/*  76 */     this.outputBottomSide.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.outputBottomSide.func_78790_a(-0.5F, -1.0F, 0.5F, 1, 1, 4, 0.0F);
/*  78 */     this.shape11_1 = new ModelRenderer(this, 0, 22);
/*  79 */     this.shape11_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */     this.shape11_1.func_78790_a(-2.5F, -1.0F, -2.5F, 5, 1, 5, 0.0F);
/*  81 */     this.outputBottomBottom = new ModelRenderer(this, 43, 0);
/*  82 */     this.outputBottomBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  83 */     this.outputBottomBottom.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
/*  84 */     this.outputTopTop = new ModelRenderer(this, 43, 0);
/*  85 */     this.outputTopTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  86 */     this.outputTopTop.func_78790_a(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
/*  87 */     this.output3 = new ModelRenderer(this, 34, 0);
/*  88 */     this.output3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  89 */     this.output3.func_78790_a(-0.5F, 7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  90 */     this.outputConnect = new ModelRenderer(this, 50, 3);
/*  91 */     this.outputConnect.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.outputConnect.func_78790_a(-1.0F, -7.5F, 7.5F, 2, 2, 1, 0.0F);
/*     */     
/*  94 */     this.outputBottomSide.func_78792_a(this.outputConnect);
/*  95 */     this.outputTop.func_78792_a(this.outputTopSide);
/*  96 */     this.shape11.func_78792_a(this.shape11_3);
/*  97 */     this.outputBottomSide.func_78792_a(this.output2_1);
/*  98 */     this.outputBottomSide.func_78792_a(this.output3_1);
/*  99 */     this.outputTopSide.func_78792_a(this.output2);
/* 100 */     this.shape11.func_78792_a(this.shape11_5);
/* 101 */     this.shape11.func_78792_a(this.shape11_2);
/* 102 */     this.shape11.func_78792_a(this.shape11_4);
/* 103 */     this.shape11.func_78792_a(this.shape11_6);
/* 104 */     this.outputBottom.func_78792_a(this.outputBottomSide);
/* 105 */     this.shape11.func_78792_a(this.shape11_1);
/* 106 */     this.outputBottom.func_78792_a(this.outputBottomBottom);
/* 107 */     this.outputTop.func_78792_a(this.outputTopTop);
/* 108 */     this.outputTopSide.func_78792_a(this.output3);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 113 */     RenderUtil.color(this.augmentedColor);
/* 114 */     this.shape11.func_78785_a(f5);
/* 115 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 116 */     this.outputBottom.func_78785_a(f5);
/* 117 */     this.outputTop.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 124 */     modelRenderer.field_78795_f = x;
/* 125 */     modelRenderer.field_78796_g = y;
/* 126 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTop()
/*     */   {
/* 131 */     return this.outputTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottom()
/*     */   {
/* 136 */     return this.outputBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopTop()
/*     */   {
/* 141 */     return this.outputTopTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomBottom()
/*     */   {
/* 146 */     return this.outputBottomBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopSide()
/*     */   {
/* 151 */     return this.outputTopSide;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomSide()
/*     */   {
/* 156 */     return this.outputBottomSide;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelResearchGourd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */