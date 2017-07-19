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
/*     */ public class ModelResearchDecanter
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
/*     */   public ModelRenderer shape11_7;
/*     */   public ModelRenderer shape11_8;
/*     */   public ModelRenderer shape11_9;
/*     */   public ModelRenderer shape11_10;
/*     */   public ModelRenderer shape11_11;
/*     */   public ModelRenderer outputConnect;
/*     */   
/*     */   public ModelResearchDecanter()
/*     */   {
/*  42 */     this.field_78090_t = 64;
/*  43 */     this.field_78089_u = 32;
/*  44 */     this.shape11_5 = new ModelRenderer(this, 9, 1);
/*  45 */     this.shape11_5.func_78793_a(0.0F, 0.0F, 0.0F);
/*  46 */     this.shape11_5.func_78790_a(-1.5F, -7.0F, -1.5F, 3, 3, 3, 0.0F);
/*  47 */     this.outputBottom = new ModelRenderer(this, 43, 0);
/*  48 */     this.outputBottom.func_78793_a(0.0F, 23.0F, 0.0F);
/*  49 */     this.outputBottom.func_78790_a(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
/*  50 */     this.outputTop = new ModelRenderer(this, 43, 0);
/*  51 */     this.outputTop.func_78793_a(0.0F, 9.0F, 0.0F);
/*  52 */     this.outputTop.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
/*  53 */     this.shape11 = new ModelRenderer(this, 0, 21);
/*  54 */     this.shape11.func_78793_a(0.0F, 17.0F, 0.0F);
/*  55 */     this.shape11.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 4, 6, 0.0F);
/*  56 */     this.shape11_1 = new ModelRenderer(this, 24, 6);
/*  57 */     this.shape11_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.shape11_1.func_78790_a(-2.5F, -1.0F, -2.5F, 5, 1, 5, 0.0F);
/*  59 */     this.shape11_3 = new ModelRenderer(this, 0, 9);
/*  60 */     this.shape11_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  61 */     this.shape11_3.func_78790_a(-2.0F, -2.0F, -2.0F, 4, 1, 4, 0.0F);
/*  62 */     this.outputBottomSide = new ModelRenderer(this, 24, 0);
/*  63 */     this.outputBottomSide.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.outputBottomSide.func_78790_a(-0.5F, -1.0F, 0.5F, 1, 1, 4, 0.0F);
/*  65 */     this.shape11_8 = new ModelRenderer(this, 23, 20);
/*  66 */     this.shape11_8.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.shape11_8.func_78790_a(4.0F, 2.0F, -2.0F, 4, 2, 4, 0.0F);
/*  68 */     this.shape11_7 = new ModelRenderer(this, 25, 14);
/*  69 */     this.shape11_7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.shape11_7.func_78790_a(4.5F, 4.0F, -1.5F, 3, 1, 3, 0.0F);
/*  71 */     this.output3 = new ModelRenderer(this, 34, 0);
/*  72 */     this.output3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.output3.func_78790_a(-0.5F, 7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  74 */     this.shape11_2 = new ModelRenderer(this, 0, 14);
/*  75 */     this.shape11_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.shape11_2.func_78790_a(-2.5F, 4.0F, -2.5F, 5, 1, 5, 0.0F);
/*  77 */     this.shape11_9 = new ModelRenderer(this, 41, 14);
/*  78 */     this.shape11_9.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.shape11_9.func_78790_a(4.5F, 1.0F, -1.5F, 3, 1, 3, 0.0F);
/*  80 */     this.outputTopTop = new ModelRenderer(this, 43, 0);
/*  81 */     this.outputTopTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.outputTopTop.func_78790_a(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
/*  83 */     this.output3_1 = new ModelRenderer(this, 34, 0);
/*  84 */     this.output3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.output3_1.func_78790_a(-0.5F, -7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  86 */     this.shape11_10 = new ModelRenderer(this, 31, 28);
/*  87 */     this.shape11_10.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.shape11_10.func_78790_a(5.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F);
/*  89 */     this.outputBottomBottom = new ModelRenderer(this, 43, 0);
/*  90 */     this.outputBottomBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.outputBottomBottom.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
/*  92 */     this.shape11_6 = new ModelRenderer(this, 0, 0);
/*  93 */     this.shape11_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.shape11_6.func_78790_a(3.8F, -4.0F, -1.0F, 2, 5, 2, 0.0F);
/*  95 */     setRotateAngle(this.shape11_6, 0.0F, 0.0F, -0.7740535F);
/*  96 */     this.outputTopSide = new ModelRenderer(this, 24, 0);
/*  97 */     this.outputTopSide.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.outputTopSide.func_78790_a(-0.5F, 0.0F, 0.5F, 1, 1, 4, 0.0F);
/*  99 */     this.output2_1 = new ModelRenderer(this, 43, 0);
/* 100 */     this.output2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.output2_1.func_78790_a(-0.5F, -7.0F, 4.5F, 1, 7, 1, 0.0F);
/* 102 */     this.output2 = new ModelRenderer(this, 43, 0);
/* 103 */     this.output2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     this.output2.func_78790_a(-0.5F, 0.0F, 4.5F, 1, 8, 1, 0.0F);
/* 105 */     this.shape11_11 = new ModelRenderer(this, 0, 7);
/* 106 */     this.shape11_11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.shape11_11.func_78790_a(4.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
/* 108 */     setRotateAngle(this.shape11_11, 0.0F, 0.0F, -0.59184116F);
/* 109 */     this.shape11_4 = new ModelRenderer(this, 13, 8);
/* 110 */     this.shape11_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 111 */     this.shape11_4.func_78790_a(-1.0F, -4.0F, -1.0F, 2, 2, 2, 0.0F);
/*     */     
/* 113 */     this.outputConnect = new ModelRenderer(this, 50, 3);
/* 114 */     this.outputConnect.func_78793_a(0.0F, 0.0F, 0.0F);
/* 115 */     this.outputConnect.func_78790_a(-1.0F, -7.5F, 7.5F, 2, 2, 1, 0.0F);
/*     */     
/* 117 */     this.outputBottomSide.func_78792_a(this.outputConnect);
/*     */     
/* 119 */     this.shape11.func_78792_a(this.shape11_5);
/* 120 */     this.shape11.func_78792_a(this.shape11_1);
/* 121 */     this.shape11.func_78792_a(this.shape11_3);
/* 122 */     this.outputBottom.func_78792_a(this.outputBottomSide);
/* 123 */     this.shape11.func_78792_a(this.shape11_8);
/* 124 */     this.shape11.func_78792_a(this.shape11_7);
/* 125 */     this.outputTopSide.func_78792_a(this.output3);
/* 126 */     this.shape11.func_78792_a(this.shape11_2);
/* 127 */     this.shape11.func_78792_a(this.shape11_9);
/* 128 */     this.outputTop.func_78792_a(this.outputTopTop);
/* 129 */     this.outputBottomSide.func_78792_a(this.output3_1);
/* 130 */     this.shape11.func_78792_a(this.shape11_10);
/* 131 */     this.outputBottom.func_78792_a(this.outputBottomBottom);
/* 132 */     this.shape11.func_78792_a(this.shape11_6);
/* 133 */     this.outputTop.func_78792_a(this.outputTopSide);
/* 134 */     this.outputBottomSide.func_78792_a(this.output2_1);
/* 135 */     this.outputTopSide.func_78792_a(this.output2);
/* 136 */     this.shape11.func_78792_a(this.shape11_11);
/* 137 */     this.shape11.func_78792_a(this.shape11_4);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 142 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 143 */     this.shape11.field_78796_g = (this.outputBottom.field_78796_g + 0.7853982F);
/* 144 */     this.outputBottom.func_78785_a(f5);
/* 145 */     this.outputTop.func_78785_a(f5);
/*     */     
/* 147 */     RenderUtil.color(this.augmentedColor);
/* 148 */     this.shape11.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 155 */     modelRenderer.field_78795_f = x;
/* 156 */     modelRenderer.field_78796_g = y;
/* 157 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTop()
/*     */   {
/* 162 */     return this.outputTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottom()
/*     */   {
/* 167 */     return this.outputBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopTop()
/*     */   {
/* 172 */     return this.outputTopTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomBottom()
/*     */   {
/* 177 */     return this.outputBottomBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopSide()
/*     */   {
/* 182 */     return this.outputTopSide;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomSide()
/*     */   {
/* 187 */     return this.outputBottomSide;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelResearchDecanter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */