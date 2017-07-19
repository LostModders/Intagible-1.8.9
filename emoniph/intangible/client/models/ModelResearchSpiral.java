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
/*     */ public class ModelResearchSpiral
/*     */   extends ModelResearchBlock
/*     */ {
/*     */   public ModelRenderer outputTop;
/*     */   public ModelRenderer outputBottom;
/*     */   public ModelRenderer spiralA;
/*     */   public ModelRenderer spiralA_1;
/*     */   public ModelRenderer spiralC;
/*     */   public ModelRenderer spiralB;
/*     */   public ModelRenderer spiralD;
/*     */   public ModelRenderer spiralB_1;
/*     */   public ModelRenderer spiralB_2;
/*     */   public ModelRenderer spiralB_3;
/*     */   public ModelRenderer spiralB_4;
/*     */   public ModelRenderer spiralB_5;
/*     */   public ModelRenderer spiralA_2;
/*     */   public ModelRenderer spiralA_3;
/*     */   public ModelRenderer spiralA_4;
/*     */   public ModelRenderer spiralD_1;
/*     */   public ModelRenderer spiralD_2;
/*     */   public ModelRenderer spiralD_3;
/*     */   public ModelRenderer spiralC_1;
/*     */   public ModelRenderer spiralC_2;
/*     */   public ModelRenderer spiralC_3;
/*     */   public ModelRenderer spiralA_5;
/*     */   public ModelRenderer outputTopSide;
/*     */   public ModelRenderer outputTopTop;
/*     */   public ModelRenderer output2;
/*     */   public ModelRenderer output3;
/*     */   public ModelRenderer outputBottomSide;
/*     */   public ModelRenderer outputBottomBottom;
/*     */   public ModelRenderer output2_1;
/*     */   public ModelRenderer output3_1;
/*     */   public ModelRenderer outputConnect;
/*     */   
/*     */   public ModelResearchSpiral()
/*     */   {
/*  50 */     this.field_78090_t = 64;
/*  51 */     this.field_78089_u = 32;
/*  52 */     this.outputTopSide = new ModelRenderer(this, 24, 0);
/*  53 */     this.outputTopSide.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.outputTopSide.func_78790_a(-0.5F, 0.0F, 0.5F, 1, 1, 4, 0.0F);
/*  55 */     this.outputTopTop = new ModelRenderer(this, 43, 0);
/*  56 */     this.outputTopTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.outputTopTop.func_78790_a(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
/*  58 */     this.outputTop = new ModelRenderer(this, 43, 0);
/*  59 */     this.outputTop.func_78793_a(0.0F, 9.0F, 0.0F);
/*  60 */     this.outputTop.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
/*  61 */     this.spiralC = new ModelRenderer(this, 0, 0);
/*  62 */     this.spiralC.func_78793_a(0.0F, 19.0F, 0.0F);
/*  63 */     this.spiralC.func_78790_a(-3.0F, -0.5F, 2.5F, 6, 1, 1, 0.0F);
/*  64 */     setRotateAngle(this.spiralC, 0.0F, 0.0F, -0.091106184F);
/*  65 */     this.spiralB_5 = new ModelRenderer(this, 0, 3);
/*  66 */     this.spiralB_5.func_78793_a(0.0F, 18.5F, 0.0F);
/*  67 */     this.spiralB_5.func_78790_a(2.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/*  68 */     setRotateAngle(this.spiralB_5, -0.091106184F, 0.0F, 0.0F);
/*  69 */     this.output3_1 = new ModelRenderer(this, 34, 0);
/*  70 */     this.output3_1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.output3_1.func_78790_a(-0.5F, -7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  72 */     this.output3 = new ModelRenderer(this, 34, 0);
/*  73 */     this.output3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  74 */     this.output3.func_78790_a(-0.5F, 7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  75 */     this.spiralA_3 = new ModelRenderer(this, 0, 0);
/*  76 */     this.spiralA_3.func_78793_a(0.0F, 15.6F, 0.0F);
/*  77 */     this.spiralA_3.func_78790_a(-3.0F, -0.5F, -3.5F, 6, 1, 1, 0.0F);
/*  78 */     setRotateAngle(this.spiralA_3, 0.0F, 0.0F, 0.091106184F);
/*  79 */     this.outputBottom = new ModelRenderer(this, 43, 0);
/*  80 */     this.outputBottom.func_78793_a(0.0F, 23.0F, 0.0F);
/*  81 */     this.outputBottom.func_78790_a(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
/*  82 */     this.output2 = new ModelRenderer(this, 43, 0);
/*  83 */     this.output2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.output2.func_78790_a(-0.5F, 0.0F, 4.5F, 1, 8, 1, 0.0F);
/*  85 */     this.spiralA_1 = new ModelRenderer(this, 16, 0);
/*  86 */     this.spiralA_1.func_78793_a(0.0F, 20.8F, 0.0F);
/*  87 */     this.spiralA_1.func_78790_a(0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
/*  88 */     this.spiralB_1 = new ModelRenderer(this, 0, 3);
/*  89 */     this.spiralB_1.func_78793_a(0.0F, 11.0F, 0.0F);
/*  90 */     this.spiralB_1.func_78790_a(-0.5F, -0.5F, -2.5F, 1, 1, 2, 0.0F);
/*  91 */     this.spiralC_3 = new ModelRenderer(this, 0, 0);
/*  92 */     this.spiralC_3.func_78793_a(0.0F, 16.7F, 0.0F);
/*  93 */     this.spiralC_3.func_78790_a(-3.0F, -0.5F, 2.5F, 6, 1, 1, 0.0F);
/*  94 */     setRotateAngle(this.spiralC_3, 0.0F, 0.0F, -0.091106184F);
/*  95 */     this.spiralD_3 = new ModelRenderer(this, 0, 3);
/*  96 */     this.spiralD_3.func_78793_a(0.0F, 17.3F, 0.0F);
/*  97 */     this.spiralD_3.func_78790_a(-3.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/*  98 */     setRotateAngle(this.spiralD_3, 0.091106184F, 0.0F, 0.0F);
/*  99 */     this.spiralB_2 = new ModelRenderer(this, 0, 3);
/* 100 */     this.spiralB_2.func_78793_a(0.0F, 11.6F, 0.0F);
/* 101 */     this.spiralB_2.func_78790_a(2.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/* 102 */     setRotateAngle(this.spiralB_2, -0.091106184F, 0.0F, 0.0F);
/* 103 */     this.spiralD_2 = new ModelRenderer(this, 0, 3);
/* 104 */     this.spiralD_2.func_78793_a(0.0F, 15.0F, 0.0F);
/* 105 */     this.spiralD_2.func_78790_a(-3.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/* 106 */     setRotateAngle(this.spiralD_2, 0.091106184F, 0.0F, 0.0F);
/* 107 */     this.spiralA_4 = new ModelRenderer(this, 0, 0);
/* 108 */     this.spiralA_4.func_78793_a(0.0F, 17.9F, 0.0F);
/* 109 */     this.spiralA_4.func_78790_a(-3.0F, -0.5F, -3.5F, 6, 1, 1, 0.0F);
/* 110 */     setRotateAngle(this.spiralA_4, 0.0F, 0.0F, 0.091106184F);
/* 111 */     this.spiralC_2 = new ModelRenderer(this, 0, 0);
/* 112 */     this.spiralC_2.func_78793_a(0.0F, 14.4F, 0.0F);
/* 113 */     this.spiralC_2.func_78790_a(-3.0F, -0.5F, 2.5F, 6, 1, 1, 0.0F);
/* 114 */     setRotateAngle(this.spiralC_2, 0.0F, 0.0F, -0.091106184F);
/* 115 */     this.spiralB_3 = new ModelRenderer(this, 9, 3);
/* 116 */     this.spiralB_3.func_78793_a(0.0F, 20.8F, 0.0F);
/* 117 */     this.spiralB_3.func_78790_a(2.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
/* 118 */     setRotateAngle(this.spiralB_3, -0.091106184F, 0.0F, 0.0F);
/* 119 */     this.spiralA_5 = new ModelRenderer(this, 0, 0);
/* 120 */     this.spiralA_5.func_78793_a(0.0F, 20.2F, 0.0F);
/* 121 */     this.spiralA_5.func_78790_a(-3.0F, -0.5F, -3.5F, 6, 1, 1, 0.0F);
/* 122 */     setRotateAngle(this.spiralA_5, 0.0F, 0.0F, 0.091106184F);
/* 123 */     this.output2_1 = new ModelRenderer(this, 43, 0);
/* 124 */     this.output2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 125 */     this.output2_1.func_78790_a(-0.5F, -7.0F, 4.5F, 1, 7, 1, 0.0F);
/* 126 */     this.spiralD_1 = new ModelRenderer(this, 0, 3);
/* 127 */     this.spiralD_1.func_78793_a(0.0F, 12.7F, 0.0F);
/* 128 */     this.spiralD_1.func_78790_a(-3.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/* 129 */     setRotateAngle(this.spiralD_1, 0.091106184F, 0.0F, 0.0F);
/* 130 */     this.spiralC_1 = new ModelRenderer(this, 0, 0);
/* 131 */     this.spiralC_1.func_78793_a(0.0F, 12.1F, 0.0F);
/* 132 */     this.spiralC_1.func_78790_a(-3.0F, -0.5F, 2.5F, 6, 1, 1, 0.0F);
/* 133 */     setRotateAngle(this.spiralC_1, 0.0F, 0.0F, -0.091106184F);
/* 134 */     this.spiralA_2 = new ModelRenderer(this, 0, 0);
/* 135 */     this.spiralA_2.func_78793_a(0.0F, 13.3F, 0.0F);
/* 136 */     this.spiralA_2.func_78790_a(-3.0F, -0.5F, -3.5F, 6, 1, 1, 0.0F);
/* 137 */     setRotateAngle(this.spiralA_2, 0.0F, 0.0F, 0.091106184F);
/* 138 */     this.outputBottomSide = new ModelRenderer(this, 24, 0);
/* 139 */     this.outputBottomSide.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.outputBottomSide.func_78790_a(-0.5F, -1.0F, 0.5F, 1, 1, 4, 0.0F);
/* 141 */     this.spiralB = new ModelRenderer(this, 0, 3);
/* 142 */     this.spiralB.func_78793_a(0.0F, 13.9F, 0.0F);
/* 143 */     this.spiralB.func_78790_a(2.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/* 144 */     setRotateAngle(this.spiralB, -0.091106184F, 0.0F, 0.0F);
/* 145 */     this.spiralA = new ModelRenderer(this, 15, 3);
/* 146 */     this.spiralA.func_78793_a(0.0F, 11.0F, 0.0F);
/* 147 */     this.spiralA.func_78790_a(0.0F, -0.5F, -3.5F, 3, 1, 1, 0.0F);
/* 148 */     setRotateAngle(this.spiralA, 0.0F, 0.0F, 0.091106184F);
/* 149 */     this.spiralB_4 = new ModelRenderer(this, 0, 3);
/* 150 */     this.spiralB_4.func_78793_a(0.0F, 16.2F, 0.0F);
/* 151 */     this.spiralB_4.func_78790_a(2.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/* 152 */     setRotateAngle(this.spiralB_4, -0.091106184F, 0.0F, 0.0F);
/* 153 */     this.outputBottomBottom = new ModelRenderer(this, 43, 0);
/* 154 */     this.outputBottomBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.outputBottomBottom.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 1, 1, 0.0F);
/* 156 */     this.spiralD = new ModelRenderer(this, 0, 3);
/* 157 */     this.spiralD.func_78793_a(0.0F, 19.6F, 0.0F);
/* 158 */     this.spiralD.func_78790_a(-3.5F, -0.5F, -3.0F, 1, 1, 6, 0.0F);
/* 159 */     setRotateAngle(this.spiralD, 0.091106184F, 0.0F, 0.0F);
/* 160 */     this.outputConnect = new ModelRenderer(this, 50, 3);
/* 161 */     this.outputConnect.func_78793_a(0.0F, 0.0F, 0.0F);
/* 162 */     this.outputConnect.func_78790_a(-1.0F, -7.5F, 7.5F, 2, 2, 1, 0.0F);
/* 163 */     this.outputBottomSide.func_78792_a(this.outputConnect);
/* 164 */     this.outputTop.func_78792_a(this.outputTopSide);
/* 165 */     this.outputTop.func_78792_a(this.outputTopTop);
/* 166 */     this.outputBottomSide.func_78792_a(this.output3_1);
/* 167 */     this.outputTopSide.func_78792_a(this.output3);
/* 168 */     this.outputTopSide.func_78792_a(this.output2);
/* 169 */     this.outputBottomSide.func_78792_a(this.output2_1);
/* 170 */     this.outputBottom.func_78792_a(this.outputBottomSide);
/* 171 */     this.outputBottom.func_78792_a(this.outputBottomBottom);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 177 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 178 */     this.outputTop.func_78785_a(f5);
/* 179 */     this.outputBottom.func_78785_a(f5);
/*     */     
/* 181 */     RenderUtil.color(this.augmentedColor);
/* 182 */     this.spiralC.func_78785_a(f5);
/* 183 */     this.spiralB_5.func_78785_a(f5);
/* 184 */     this.spiralA_3.func_78785_a(f5);
/*     */     
/* 186 */     this.spiralA_1.func_78785_a(f5);
/* 187 */     this.spiralB_1.func_78785_a(f5);
/* 188 */     this.spiralC_3.func_78785_a(f5);
/* 189 */     this.spiralD_3.func_78785_a(f5);
/* 190 */     this.spiralB_2.func_78785_a(f5);
/* 191 */     this.spiralD_2.func_78785_a(f5);
/* 192 */     this.spiralA_4.func_78785_a(f5);
/* 193 */     this.spiralC_2.func_78785_a(f5);
/* 194 */     this.spiralB_3.func_78785_a(f5);
/* 195 */     this.spiralA_5.func_78785_a(f5);
/* 196 */     this.spiralD_1.func_78785_a(f5);
/* 197 */     this.spiralC_1.func_78785_a(f5);
/* 198 */     this.spiralA_2.func_78785_a(f5);
/* 199 */     this.spiralB.func_78785_a(f5);
/* 200 */     this.spiralA.func_78785_a(f5);
/* 201 */     this.spiralB_4.func_78785_a(f5);
/* 202 */     this.spiralD.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 209 */     modelRenderer.field_78795_f = x;
/* 210 */     modelRenderer.field_78796_g = y;
/* 211 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTop()
/*     */   {
/* 216 */     return this.outputTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottom()
/*     */   {
/* 221 */     return this.outputBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopTop()
/*     */   {
/* 226 */     return this.outputTopTop;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomBottom()
/*     */   {
/* 231 */     return this.outputBottomBottom;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputTopSide()
/*     */   {
/* 236 */     return this.outputTopSide;
/*     */   }
/*     */   
/*     */   public ModelRenderer getOutputBottomSide()
/*     */   {
/* 241 */     return this.outputBottomSide;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelResearchSpiral.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */