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
/*     */ public class ModelResearchSplitter
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
/*     */   public ModelRenderer shape11_12;
/*     */   public ModelRenderer shape11_13;
/*     */   public ModelRenderer shape11_14;
/*     */   public ModelRenderer shape11_15;
/*     */   public ModelRenderer shape11_16;
/*     */   public ModelRenderer shape11_17;
/*     */   public ModelRenderer outputConnect;
/*     */   
/*     */   public ModelResearchSplitter()
/*     */   {
/*  48 */     this.field_78090_t = 64;
/*  49 */     this.field_78089_u = 32;
/*  50 */     this.outputTop = new ModelRenderer(this, 43, 0);
/*  51 */     this.outputTop.func_78793_a(0.0F, 9.0F, 0.0F);
/*  52 */     this.outputTop.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 5, 1, 0.0F);
/*  53 */     this.shape11_1 = new ModelRenderer(this, 0, 7);
/*  54 */     this.shape11_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.shape11_1.func_78790_a(1.0F, -1.0F, -5.0F, 4, 8, 4, 0.0F);
/*  56 */     this.output2 = new ModelRenderer(this, 43, 0);
/*  57 */     this.output2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  58 */     this.output2.func_78790_a(-0.5F, 0.0F, 4.5F, 1, 8, 1, 0.0F);
/*  59 */     this.outputBottom = new ModelRenderer(this, 43, 0);
/*  60 */     this.outputBottom.func_78793_a(0.0F, 23.0F, 0.0F);
/*  61 */     this.outputBottom.func_78790_a(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
/*  62 */     this.shape11_7 = new ModelRenderer(this, 0, 0);
/*  63 */     this.shape11_7.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.shape11_7.func_78790_a(2.0F, -3.0F, -4.0F, 2, 1, 2, 0.0F);
/*  65 */     this.shape11_3 = new ModelRenderer(this, 0, 7);
/*  66 */     this.shape11_3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  67 */     this.shape11_3.func_78790_a(-5.0F, -1.0F, -5.0F, 4, 8, 4, 0.0F);
/*  68 */     this.shape11_6 = new ModelRenderer(this, 0, 3);
/*  69 */     this.shape11_6.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.shape11_6.func_78790_a(1.5F, -2.0F, -4.5F, 3, 1, 3, 0.0F);
/*  71 */     this.output3_1 = new ModelRenderer(this, 34, 0);
/*  72 */     this.output3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  73 */     this.output3_1.func_78790_a(-0.5F, -7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  74 */     this.shape11_10 = new ModelRenderer(this, 0, 0);
/*  75 */     this.shape11_10.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.shape11_10.func_78790_a(-4.0F, -3.0F, -4.0F, 2, 1, 2, 0.0F);
/*  77 */     this.outputTopSide = new ModelRenderer(this, 24, 0);
/*  78 */     this.outputTopSide.func_78793_a(0.0F, 0.0F, 0.0F);
/*  79 */     this.outputTopSide.func_78790_a(-0.5F, 0.0F, 0.5F, 1, 1, 4, 0.0F);
/*  80 */     this.shape11_13 = new ModelRenderer(this, 0, 0);
/*  81 */     this.shape11_13.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.shape11_13.func_78790_a(-4.0F, -3.0F, 2.0F, 2, 1, 2, 0.0F);
/*  83 */     this.shape11_4 = new ModelRenderer(this, 0, 7);
/*  84 */     this.shape11_4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  85 */     this.shape11_4.func_78790_a(-5.0F, -1.0F, 1.0F, 4, 8, 4, 0.0F);
/*  86 */     this.output3 = new ModelRenderer(this, 34, 0);
/*  87 */     this.output3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.output3.func_78790_a(-0.5F, 7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  89 */     this.shape11_2 = new ModelRenderer(this, 11, 0);
/*  90 */     this.shape11_2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.shape11_2.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 1, 3, 0.0F);
/*  92 */     this.shape11_15 = new ModelRenderer(this, 0, 3);
/*  93 */     this.shape11_15.func_78793_a(0.0F, 0.0F, 0.0F);
/*  94 */     this.shape11_15.func_78790_a(1.5F, -2.0F, 1.5F, 3, 1, 3, 0.0F);
/*  95 */     this.shape11_16 = new ModelRenderer(this, 0, 0);
/*  96 */     this.shape11_16.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.shape11_16.func_78790_a(2.0F, -3.0F, 2.0F, 2, 1, 2, 0.0F);
/*  98 */     this.output2_1 = new ModelRenderer(this, 43, 0);
/*  99 */     this.output2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 100 */     this.output2_1.func_78790_a(-0.5F, -7.0F, 4.5F, 1, 7, 1, 0.0F);
/* 101 */     this.shape11_5 = new ModelRenderer(this, 0, 7);
/* 102 */     this.shape11_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 103 */     this.shape11_5.func_78790_a(1.0F, -1.0F, 1.0F, 4, 8, 4, 0.0F);
/* 104 */     this.shape11 = new ModelRenderer(this, 13, 5);
/* 105 */     this.shape11.func_78793_a(0.0F, 14.0F, 0.0F);
/* 106 */     this.shape11.func_78790_a(-1.5F, 5.0F, -1.5F, 3, 1, 3, 0.0F);
/* 107 */     this.shape11_11 = new ModelRenderer(this, 0, 19);
/* 108 */     this.shape11_11.func_78793_a(0.0F, 0.0F, 0.0F);
/* 109 */     this.shape11_11.func_78790_a(-4.5F, 7.0F, -4.5F, 3, 1, 3, 0.0F);
/* 110 */     this.shape11_8 = new ModelRenderer(this, 0, 19);
/* 111 */     this.shape11_8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 112 */     this.shape11_8.func_78790_a(1.5F, 7.0F, -4.5F, 3, 1, 3, 0.0F);
/* 113 */     this.shape11_9 = new ModelRenderer(this, 0, 3);
/* 114 */     this.shape11_9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 115 */     this.shape11_9.func_78790_a(-4.5F, -2.0F, -4.5F, 3, 1, 3, 0.0F);
/* 116 */     this.outputBottomBottom = new ModelRenderer(this, 43, 0);
/* 117 */     this.outputBottomBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 118 */     this.outputBottomBottom.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
/* 119 */     this.shape11_14 = new ModelRenderer(this, 0, 19);
/* 120 */     this.shape11_14.func_78793_a(0.0F, 0.0F, 0.0F);
/* 121 */     this.shape11_14.func_78790_a(-4.5F, 7.0F, 1.5F, 3, 1, 3, 0.0F);
/* 122 */     this.shape11_12 = new ModelRenderer(this, 0, 3);
/* 123 */     this.shape11_12.func_78793_a(0.0F, 0.0F, 0.0F);
/* 124 */     this.shape11_12.func_78790_a(-4.5F, -2.0F, 1.5F, 3, 1, 3, 0.0F);
/* 125 */     this.outputBottomSide = new ModelRenderer(this, 24, 0);
/* 126 */     this.outputBottomSide.func_78793_a(0.0F, 0.0F, 0.0F);
/* 127 */     this.outputBottomSide.func_78790_a(-0.5F, -1.0F, 0.5F, 1, 1, 4, 0.0F);
/* 128 */     this.shape11_17 = new ModelRenderer(this, 0, 19);
/* 129 */     this.shape11_17.func_78793_a(0.0F, 0.0F, 0.0F);
/* 130 */     this.shape11_17.func_78790_a(1.5F, 7.0F, 1.5F, 3, 1, 3, 0.0F);
/* 131 */     this.outputTopTop = new ModelRenderer(this, 43, 0);
/* 132 */     this.outputTopTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 133 */     this.outputTopTop.func_78790_a(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
/* 134 */     this.outputConnect = new ModelRenderer(this, 50, 3);
/* 135 */     this.outputConnect.func_78793_a(0.0F, 0.0F, 0.0F);
/* 136 */     this.outputConnect.func_78790_a(-1.0F, -7.5F, 7.5F, 2, 2, 1, 0.0F);
/* 137 */     this.outputBottomSide.func_78792_a(this.outputConnect);
/* 138 */     this.shape11.func_78792_a(this.shape11_1);
/* 139 */     this.outputTopSide.func_78792_a(this.output2);
/* 140 */     this.shape11_1.func_78792_a(this.shape11_7);
/* 141 */     this.shape11.func_78792_a(this.shape11_3);
/* 142 */     this.shape11_1.func_78792_a(this.shape11_6);
/* 143 */     this.outputBottomSide.func_78792_a(this.output3_1);
/* 144 */     this.shape11_3.func_78792_a(this.shape11_10);
/* 145 */     this.outputTop.func_78792_a(this.outputTopSide);
/* 146 */     this.shape11_4.func_78792_a(this.shape11_13);
/* 147 */     this.shape11.func_78792_a(this.shape11_4);
/* 148 */     this.outputTopSide.func_78792_a(this.output3);
/* 149 */     this.shape11.func_78792_a(this.shape11_2);
/* 150 */     this.shape11_5.func_78792_a(this.shape11_15);
/* 151 */     this.shape11_5.func_78792_a(this.shape11_16);
/* 152 */     this.outputBottomSide.func_78792_a(this.output2_1);
/* 153 */     this.shape11.func_78792_a(this.shape11_5);
/* 154 */     this.shape11_3.func_78792_a(this.shape11_11);
/* 155 */     this.shape11_1.func_78792_a(this.shape11_8);
/* 156 */     this.shape11_3.func_78792_a(this.shape11_9);
/* 157 */     this.outputBottom.func_78792_a(this.outputBottomBottom);
/* 158 */     this.shape11_4.func_78792_a(this.shape11_14);
/* 159 */     this.shape11_4.func_78792_a(this.shape11_12);
/* 160 */     this.outputBottom.func_78792_a(this.outputBottomSide);
/* 161 */     this.shape11_5.func_78792_a(this.shape11_17);
/* 162 */     this.outputTop.func_78792_a(this.outputTopTop);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 167 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 168 */     this.outputTop.func_78785_a(f5);
/* 169 */     this.outputBottom.func_78785_a(f5);
/* 170 */     RenderUtil.color(this.augmentedColor);
/* 171 */     this.shape11.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 178 */     modelRenderer.field_78795_f = x;
/* 179 */     modelRenderer.field_78796_g = y;
/* 180 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTop()
/*     */   {
/* 185 */     return this.outputTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottom()
/*     */   {
/* 190 */     return this.outputBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopTop()
/*     */   {
/* 195 */     return this.outputTopTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomBottom()
/*     */   {
/* 200 */     return this.outputBottomBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopSide()
/*     */   {
/* 205 */     return this.outputTopSide;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomSide()
/*     */   {
/* 210 */     return this.outputBottomSide;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelResearchSplitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */