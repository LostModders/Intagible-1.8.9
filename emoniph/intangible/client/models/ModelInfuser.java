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
/*     */ public class ModelInfuser
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer coreUpper;
/*     */   public ModelRenderer core;
/*     */   public ModelRenderer top;
/*     */   public ModelRenderer coreLower;
/*     */   public ModelRenderer display;
/*     */   public ModelRenderer display2;
/*     */   public ModelRenderer display3;
/*     */   public ModelRenderer display4;
/*     */   public ModelRenderer shieldOuter;
/*     */   public ModelRenderer shieldInner;
/*     */   public ModelRenderer displayTop;
/*     */   public ModelRenderer displayBottom;
/*     */   public ModelRenderer displayRight;
/*     */   public ModelRenderer displayLeft;
/*     */   public ModelRenderer displayMid;
/*     */   public ModelRenderer displayTop2;
/*     */   public ModelRenderer displayBottom2;
/*     */   public ModelRenderer displayRight2;
/*     */   public ModelRenderer displayLeft2;
/*     */   public ModelRenderer displayMid2;
/*     */   public ModelRenderer displayTop3;
/*     */   public ModelRenderer displayBottom3;
/*     */   public ModelRenderer displayRight3;
/*     */   public ModelRenderer displayLeft3;
/*     */   public ModelRenderer displayMid3;
/*     */   public ModelRenderer displayTop4;
/*     */   public ModelRenderer displayBottom4;
/*     */   public ModelRenderer displayRight4;
/*     */   public ModelRenderer displayLeft4;
/*     */   public ModelRenderer displayMid4;
/*     */   public ModelRenderer shieldOuter1;
/*     */   public ModelRenderer shieldOuter2;
/*     */   public ModelRenderer shieldInner1;
/*     */   public ModelRenderer shieldInner2;
/*     */   
/*     */   public ModelInfuser()
/*     */   {
/*  51 */     this.field_78090_t = 64;
/*  52 */     this.field_78089_u = 64;
/*  53 */     this.coreLower = new ModelRenderer(this, 24, 49);
/*  54 */     this.coreLower.func_78793_a(0.0F, 19.0F, 0.0F);
/*  55 */     this.coreLower.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 5, 10, 0.0F);
/*  56 */     setRotateAngle(this.coreLower, 0.0F, -0.7853982F, 0.0F);
/*  57 */     this.displayBottom3 = new ModelRenderer(this, 43, 25);
/*  58 */     this.displayBottom3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.displayBottom3.func_78790_a(-4.5F, 4.0F, -7.5F, 9, 1, 1, 0.0F);
/*  60 */     this.display = new ModelRenderer(this, 42, 39);
/*  61 */     this.display.func_78793_a(0.0F, 14.0F, 0.0F);
/*  62 */     this.display.func_78790_a(-4.5F, 0.0F, -6.5F, 9, 5, 2, 0.0F);
/*  63 */     this.displayMid4 = new ModelRenderer(this, 43, 18);
/*  64 */     this.displayMid4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  65 */     this.displayMid4.func_78790_a(-0.5F, 1.0F, -7.0F, 1, 3, 1, 0.0F);
/*     */     
/*  67 */     this.displayLeft4 = new ModelRenderer(this, 43, 18);
/*  68 */     this.displayLeft4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.displayLeft4.func_78790_a(3.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/*  70 */     this.displayRight3 = new ModelRenderer(this, 43, 18);
/*  71 */     this.displayRight3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  72 */     this.displayRight3.func_78790_a(-4.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/*  73 */     this.displayBottom2 = new ModelRenderer(this, 43, 25);
/*  74 */     this.displayBottom2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.displayBottom2.func_78790_a(-4.5F, 4.0F, -7.5F, 9, 1, 1, 0.0F);
/*  76 */     this.display3 = new ModelRenderer(this, 42, 39);
/*  77 */     this.display3.func_78793_a(0.0F, 14.0F, 0.0F);
/*  78 */     this.display3.func_78790_a(-4.5F, 0.0F, -6.5F, 9, 5, 2, 0.0F);
/*  79 */     setRotateAngle(this.display3, 0.0F, 1.5707964F, 0.0F);
/*  80 */     this.displayTop3 = new ModelRenderer(this, 43, 25);
/*  81 */     this.displayTop3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  82 */     this.displayTop3.func_78790_a(-4.5F, 0.0F, -7.5F, 9, 1, 1, 0.0F);
/*     */     
/*  84 */     this.display4 = new ModelRenderer(this, 42, 39);
/*  85 */     this.display4.func_78793_a(0.0F, 14.0F, 0.0F);
/*  86 */     this.display4.func_78790_a(-4.5F, 0.0F, -6.5F, 9, 5, 2, 0.0F);
/*  87 */     setRotateAngle(this.display4, 0.0F, 3.1415927F, 0.0F);
/*     */     
/*  89 */     this.displayTop2 = new ModelRenderer(this, 43, 25);
/*  90 */     this.displayTop2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.displayTop2.func_78790_a(-4.5F, 0.0F, -7.5F, 9, 1, 1, 0.0F);
/*  92 */     this.display2 = new ModelRenderer(this, 42, 39);
/*  93 */     this.display2.func_78793_a(0.0F, 14.0F, 0.0F);
/*  94 */     this.display2.func_78790_a(-4.5F, 0.0F, -6.5F, 9, 5, 2, 0.0F);
/*  95 */     setRotateAngle(this.display2, 0.0F, -1.5707964F, 0.0F);
/*  96 */     this.displayTop4 = new ModelRenderer(this, 43, 25);
/*  97 */     this.displayTop4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  98 */     this.displayTop4.func_78790_a(-4.5F, 0.0F, -7.5F, 9, 1, 1, 0.0F);
/*  99 */     this.displayTop = new ModelRenderer(this, 43, 25);
/* 100 */     this.displayTop.func_78793_a(0.0F, 0.0F, 0.0F);
/* 101 */     this.displayTop.func_78790_a(-4.5F, 0.0F, -7.5F, 9, 1, 1, 0.0F);
/* 102 */     this.displayLeft = new ModelRenderer(this, 43, 18);
/* 103 */     this.displayLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/* 104 */     this.displayLeft.func_78790_a(3.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/* 105 */     this.displayLeft3 = new ModelRenderer(this, 43, 18);
/* 106 */     this.displayLeft3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 107 */     this.displayLeft3.func_78790_a(3.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/* 108 */     this.displayRight2 = new ModelRenderer(this, 43, 18);
/* 109 */     this.displayRight2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.displayRight2.func_78790_a(-4.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/* 111 */     this.displayBottom4 = new ModelRenderer(this, 43, 25);
/* 112 */     this.displayBottom4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.displayBottom4.func_78790_a(-4.5F, 4.0F, -7.5F, 9, 1, 1, 0.0F);
/* 114 */     this.coreUpper = new ModelRenderer(this, 24, 49);
/* 115 */     this.coreUpper.func_78793_a(0.0F, 9.0F, 0.0F);
/* 116 */     this.coreUpper.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 5, 10, 0.0F);
/* 117 */     setRotateAngle(this.coreUpper, 0.0F, -0.7853982F, 0.0F);
/* 118 */     this.displayMid2 = new ModelRenderer(this, 43, 18);
/* 119 */     this.displayMid2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 120 */     this.displayMid2.func_78790_a(-0.5F, 1.0F, -7.0F, 1, 3, 1, 0.0F);
/*     */     
/* 122 */     float offsetInner = -12.0F;
/* 123 */     this.shieldInner = new ModelRenderer(this, 48, 0);
/* 124 */     this.shieldInner.func_78793_a(0.0F, 8.0F, 0.0F);
/* 125 */     this.shieldInner.func_78790_a(-3.5F, 0.0F, offsetInner, 7, 14, 1, 0.0F);
/* 126 */     this.shieldInner1 = new ModelRenderer(this, 48, 0);
/* 127 */     this.shieldInner1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 128 */     this.shieldInner1.func_78790_a(-3.5F, 0.01F, offsetInner, 7, 14, 1, 0.0F);
/* 129 */     setRotateAngle(this.shieldInner1, 0.0F, -0.8F, 0.0F);
/* 130 */     this.shieldInner2 = new ModelRenderer(this, 48, 0);
/* 131 */     this.shieldInner2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.shieldInner2.func_78790_a(-3.5F, 0.01F, offsetInner, 7, 14, 1, 0.0F);
/* 133 */     setRotateAngle(this.shieldInner2, 0.0F, 0.8F, 0.0F);
/*     */     
/*     */ 
/* 136 */     float offsetOuter = -16.0F;
/* 137 */     this.shieldOuter = new ModelRenderer(this, 0, 53);
/* 138 */     this.shieldOuter.func_78793_a(0.0F, 8.0F, 0.0F);
/* 139 */     this.shieldOuter.func_78790_a(-4.5F, 1.0F, offsetOuter, 9, 10, 1, 0.0F);
/* 140 */     this.shieldOuter1 = new ModelRenderer(this, 0, 53);
/* 141 */     this.shieldOuter1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 142 */     this.shieldOuter1.func_78790_a(-4.5F, 1.01F, offsetOuter, 9, 10, 1, 0.0F);
/* 143 */     setRotateAngle(this.shieldOuter1, 0.0F, 0.8F, 0.0F);
/* 144 */     this.shieldOuter2 = new ModelRenderer(this, 0, 53);
/* 145 */     this.shieldOuter2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 146 */     this.shieldOuter2.func_78790_a(-4.5F, 1.01F, offsetOuter, 9, 10, 1, 0.0F);
/* 147 */     setRotateAngle(this.shieldOuter2, 0.0F, -0.8F, 0.0F);
/*     */     
/* 149 */     this.displayBottom = new ModelRenderer(this, 43, 25);
/* 150 */     this.displayBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.displayBottom.func_78790_a(-4.5F, 4.0F, -7.5F, 9, 1, 1, 0.0F);
/*     */     
/* 153 */     this.displayMid3 = new ModelRenderer(this, 43, 18);
/* 154 */     this.displayMid3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 155 */     this.displayMid3.func_78790_a(-0.5F, 1.0F, -7.0F, 1, 3, 1, 0.0F);
/* 156 */     this.displayRight = new ModelRenderer(this, 43, 18);
/* 157 */     this.displayRight.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.displayRight.func_78790_a(-4.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/* 159 */     this.displayLeft2 = new ModelRenderer(this, 43, 18);
/* 160 */     this.displayLeft2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 161 */     this.displayLeft2.func_78790_a(3.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/* 162 */     this.top = new ModelRenderer(this, 0, 0);
/* 163 */     this.top.func_78793_a(0.0F, 8.0F, 0.0F);
/* 164 */     this.top.func_78790_a(-7.5F, 0.0F, -7.5F, 15, 1, 15, 0.0F);
/* 165 */     this.displayMid = new ModelRenderer(this, 43, 18);
/* 166 */     this.displayMid.func_78793_a(0.0F, 0.0F, 0.0F);
/* 167 */     this.displayMid.func_78790_a(-0.5F, 1.0F, -7.0F, 1, 3, 1, 0.0F);
/* 168 */     this.core = new ModelRenderer(this, 0, 24);
/* 169 */     this.core.func_78793_a(0.0F, 9.0F, 0.0F);
/* 170 */     this.core.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 15, 10, 0.0F);
/* 171 */     this.displayRight4 = new ModelRenderer(this, 43, 18);
/* 172 */     this.displayRight4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 173 */     this.displayRight4.func_78790_a(-4.5F, 1.0F, -7.5F, 1, 3, 1, 0.0F);
/* 174 */     this.display3.func_78792_a(this.displayBottom3);
/* 175 */     this.display4.func_78792_a(this.displayMid4);
/* 176 */     this.shieldInner.func_78792_a(this.shieldInner1);
/* 177 */     this.display4.func_78792_a(this.displayLeft4);
/* 178 */     this.display3.func_78792_a(this.displayRight3);
/* 179 */     this.display2.func_78792_a(this.displayBottom2);
/* 180 */     this.display3.func_78792_a(this.displayTop3);
/* 181 */     this.shieldOuter.func_78792_a(this.shieldOuter2);
/* 182 */     this.display2.func_78792_a(this.displayTop2);
/* 183 */     this.shieldInner.func_78792_a(this.shieldInner2);
/* 184 */     this.display4.func_78792_a(this.displayTop4);
/* 185 */     this.display.func_78792_a(this.displayTop);
/* 186 */     this.display.func_78792_a(this.displayLeft);
/* 187 */     this.display3.func_78792_a(this.displayLeft3);
/* 188 */     this.display2.func_78792_a(this.displayRight2);
/* 189 */     this.display4.func_78792_a(this.displayBottom4);
/* 190 */     this.display2.func_78792_a(this.displayMid2);
/* 191 */     this.display.func_78792_a(this.displayBottom);
/* 192 */     this.shieldOuter.func_78792_a(this.shieldOuter1);
/* 193 */     this.display3.func_78792_a(this.displayMid3);
/* 194 */     this.display.func_78792_a(this.displayRight);
/* 195 */     this.display2.func_78792_a(this.displayLeft2);
/* 196 */     this.display.func_78792_a(this.displayMid);
/* 197 */     this.display4.func_78792_a(this.displayRight4);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 202 */     this.coreLower.func_78785_a(f5);
/* 203 */     this.coreUpper.func_78785_a(f5);
/* 204 */     this.core.func_78785_a(f5);
/* 205 */     this.top.func_78785_a(f5);
/* 206 */     this.display.func_78785_a(f5);
/* 207 */     this.display3.func_78785_a(f5);
/* 208 */     this.display4.func_78785_a(f5);
/* 209 */     this.display2.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 216 */     modelRenderer.field_78795_f = x;
/* 217 */     modelRenderer.field_78796_g = y;
/* 218 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelInfuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */