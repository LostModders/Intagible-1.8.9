/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityArmorStand;
/*     */ import net.minecraft.util.Rotations;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelCrystalArmor
/*     */   extends ModelBiped
/*     */ {
/*     */   public ModelRenderer shape15;
/*     */   public ModelRenderer shape15_1;
/*     */   public ModelRenderer shape15_2;
/*     */   public ModelRenderer shape15_3;
/*     */   public ModelRenderer shape15_4;
/*     */   public ModelRenderer shape15_5;
/*     */   public ModelRenderer shape15_6;
/*     */   public ModelRenderer shape15_7;
/*     */   public ModelRenderer shape15_8;
/*     */   public ModelRenderer shape15_9;
/*     */   public ModelRenderer shape15_10;
/*     */   public ModelRenderer shape15_11;
/*     */   public ModelRenderer shape15_12;
/*     */   public ModelRenderer shape15_13;
/*     */   public ModelRenderer shape15_14;
/*     */   public ModelRenderer shape15_15;
/*     */   public ModelRenderer shape15_16;
/*     */   public ModelRenderer shape15_17;
/*     */   public ModelRenderer shape15_18;
/*     */   public ModelRenderer shape15_19;
/*     */   public ModelRenderer shape15_20;
/*     */   public ModelRenderer shape15_21;
/*     */   public ModelRenderer shape15_22;
/*     */   public ModelRenderer shape15_23;
/*     */   public ModelRenderer shape15_24;
/*     */   public ModelRenderer shape15_25;
/*     */   public ModelRenderer shape15_26;
/*     */   public ModelRenderer shape15_27;
/*     */   public ModelRenderer shape15_28;
/*     */   public ModelRenderer shape15_29;
/*     */   public ModelRenderer shape15_30;
/*     */   public ModelRenderer shape15_31;
/*     */   public ModelRenderer shape15_32;
/*     */   public ModelRenderer shape15_33;
/*     */   public ModelRenderer shape15_34;
/*     */   public ModelRenderer shape15_35;
/*     */   public ModelRenderer shape15_36;
/*     */   public ModelRenderer shape15_37;
/*     */   public ModelRenderer shape15_38;
/*     */   public ModelRenderer shape15_39;
/*     */   public ModelRenderer shape15_40;
/*     */   public ModelRenderer shape15_41;
/*     */   public ModelRenderer shape15_42;
/*     */   public ModelRenderer shape15_43;
/*     */   public ModelRenderer toeRight;
/*     */   public ModelRenderer kneeRight;
/*     */   public ModelRenderer shape15_44;
/*     */   public ModelRenderer shape15_45;
/*     */   public ModelRenderer toeLeft;
/*     */   public ModelRenderer kneeLeft;
/*     */   public ModelRenderer shape15_46;
/*     */   public ModelRenderer shape15_47;
/*     */   public ModelRenderer n2;
/*     */   public ModelRenderer n1;
/*     */   public ModelRenderer a1;
/*     */   public ModelRenderer a2;
/*     */   public ModelRenderer a3;
/*     */   public ModelRenderer a4;
/*     */   public ModelRenderer b3;
/*     */   public ModelRenderer b2;
/*     */   public ModelRenderer b1;
/*     */   public ModelRenderer b4;
/*     */   
/*     */   public ModelCrystalArmor(float scale)
/*     */   {
/*  90 */     super(scale, 0.0F, 128, 64);
/*     */     
/*  92 */     this.shape15_9 = new ModelRenderer(this, 64, 0);
/*  93 */     this.shape15_9.func_78793_a(-1.3F, -9.0F, -2.9F);
/*  94 */     this.shape15_9.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 6, 0.0F);
/*  95 */     setRotateAngle(this.shape15_9, 0.045553092F, -0.5009095F, 0.22759093F);
/*  96 */     this.shape15_18 = new ModelRenderer(this, 64, 0);
/*  97 */     this.shape15_18.func_78793_a(-2.9F, -5.4F, 1.9F);
/*  98 */     this.shape15_18.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 4, 3, 0.0F);
/*  99 */     setRotateAngle(this.shape15_18, 0.5462881F, -2.048842F, 0.5462881F);
/* 100 */     this.shape15_25 = new ModelRenderer(this, 64, 0);
/* 101 */     this.shape15_25.func_78793_a(-0.3F, -2.7F, -2.5F);
/* 102 */     this.shape15_25.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 103 */     setRotateAngle(this.shape15_25, -0.18203785F, -0.4553564F, 2.003289F);
/* 104 */     this.shape15_35 = new ModelRenderer(this, 64, 0);
/* 105 */     this.shape15_35.func_78793_a(-0.2F, 1.3F, 1.7F);
/* 106 */     this.shape15_35.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 107 */     setRotateAngle(this.shape15_35, -0.13665928F, -0.8196066F, 0.22759093F);
/* 108 */     this.shape15_5 = new ModelRenderer(this, 64, 0);
/* 109 */     this.shape15_5.func_78793_a(-2.9F, -9.0F, 1.9F);
/* 110 */     this.shape15_5.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 111 */     setRotateAngle(this.shape15_5, 0.13665928F, -1.3203416F, 0.5462881F);
/* 112 */     this.shape15_19 = new ModelRenderer(this, 64, 0);
/* 113 */     this.shape15_19.func_78793_a(1.4F, -9.7F, 3.8F);
/* 114 */     this.shape15_19.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 115 */     setRotateAngle(this.shape15_19, -0.5009095F, -0.5009095F, 0.22759093F);
/* 116 */     this.shape15_23 = new ModelRenderer(this, 64, 0);
/* 117 */     this.shape15_23.func_78793_a(1.5F, -2.6F, 1.6F);
/* 118 */     this.shape15_23.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 119 */     setRotateAngle(this.shape15_23, 0.59184116F, -0.63739425F, 0.22759093F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 124 */     this.shape15_3 = new ModelRenderer(this, 64, 0);
/* 125 */     this.shape15_3.func_78793_a(2.0F, -9.0F, -2.6F);
/* 126 */     this.shape15_3.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 127 */     setRotateAngle(this.shape15_3, -0.5009095F, -0.5009095F, 0.22759093F);
/* 128 */     this.shape15_22 = new ModelRenderer(this, 64, 0);
/* 129 */     this.shape15_22.func_78793_a(2.9F, -2.6F, 0.4F);
/* 130 */     this.shape15_22.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 131 */     setRotateAngle(this.shape15_22, -0.5462881F, -0.63739425F, 0.22759093F);
/* 132 */     this.toeRight = new ModelRenderer(this, 64, 0);
/* 133 */     this.toeRight.func_78793_a(-1.4F, 10.4F, -2.2F);
/* 134 */     this.toeRight.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 135 */     setRotateAngle(this.toeRight, 2.4586453F, 0.5009095F, -2.003289F);
/*     */     
/*     */ 
/*     */ 
/* 139 */     this.shape15_8 = new ModelRenderer(this, 64, 0);
/* 140 */     this.shape15_8.func_78793_a(4.6F, -9.0F, 1.9F);
/* 141 */     this.shape15_8.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 142 */     setRotateAngle(this.shape15_8, -0.5009095F, -0.5009095F, 0.8196066F);
/* 143 */     this.shape15_39 = new ModelRenderer(this, 64, 0);
/* 144 */     this.shape15_39.func_78793_a(0.0F, 5.9F, -2.1F);
/* 145 */     this.shape15_39.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 146 */     setRotateAngle(this.shape15_39, 0.59184116F, -0.63739425F, 0.91053826F);
/* 147 */     this.kneeLeft = new ModelRenderer(this, 64, 0);
/* 148 */     this.kneeLeft.func_78793_a(0.2F, 5.3F, -1.5F);
/* 149 */     this.kneeLeft.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 150 */     setRotateAngle(this.kneeLeft, 0.63739425F, 0.7740535F, -0.4098033F);
/* 151 */     this.shape15_42 = new ModelRenderer(this, 64, 0);
/* 152 */     this.shape15_42.func_78793_a(-2.5F, 1.3F, -1.8F);
/* 153 */     this.shape15_42.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 154 */     setRotateAngle(this.shape15_42, -0.13665928F, -0.8196066F, 0.22759093F);
/* 155 */     this.shape15_6 = new ModelRenderer(this, 64, 0);
/* 156 */     this.shape15_6.func_78793_a(3.9F, -6.5F, 2.5F);
/* 157 */     this.shape15_6.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 4, 4, 0.0F);
/* 158 */     setRotateAngle(this.shape15_6, -0.5009095F, -1.1383038F, 0.22759093F);
/*     */     
/*     */ 
/*     */ 
/* 162 */     this.shape15 = new ModelRenderer(this, 64, 0);
/* 163 */     this.shape15.func_78793_a(0.0F, -9.7F, 0.0F);
/* 164 */     this.shape15.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 165 */     setRotateAngle(this.shape15, -0.5009095F, -0.5009095F, 0.22759093F);
/* 166 */     this.shape15_2 = new ModelRenderer(this, 64, 0);
/* 167 */     this.shape15_2.func_78793_a(1.9F, -9.0F, 0.0F);
/* 168 */     this.shape15_2.func_78790_a(-1.0F, -1.0F, -1.0F, 4, 2, 4, 0.0F);
/* 169 */     setRotateAngle(this.shape15_2, 0.18203785F, -0.5009095F, 0.22759093F);
/* 170 */     this.shape15_37 = new ModelRenderer(this, 64, 0);
/* 171 */     this.shape15_37.func_78793_a(-1.8F, 2.8F, -1.6F);
/* 172 */     this.shape15_37.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 173 */     setRotateAngle(this.shape15_37, -0.4553564F, -1.0016445F, 0.22759093F);
/* 174 */     this.shape15_11 = new ModelRenderer(this, 64, 0);
/* 175 */     this.shape15_11.func_78793_a(-3.9F, -8.2F, -4.7F);
/* 176 */     this.shape15_11.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 177 */     setRotateAngle(this.shape15_11, 0.045553092F, -0.5009095F, 0.22759093F);
/* 178 */     this.shape15_33 = new ModelRenderer(this, 64, 0);
/* 179 */     this.shape15_33.func_78793_a(-0.1F, 8.2F, 1.7F);
/* 180 */     this.shape15_33.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 181 */     setRotateAngle(this.shape15_33, 2.1399481F, 0.0F, -0.4098033F);
/* 182 */     this.shape15_17 = new ModelRenderer(this, 64, 0);
/* 183 */     this.shape15_17.func_78793_a(-5.6F, -7.1F, -0.4F);
/* 184 */     this.shape15_17.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 5, 3, 0.0F);
/* 185 */     setRotateAngle(this.shape15_17, 0.5009095F, 1.3658947F, -0.091106184F);
/* 186 */     this.shape15_47 = new ModelRenderer(this, 64, 0);
/* 187 */     this.shape15_47.func_78793_a(0.6F, -1.0F, -1.7F);
/* 188 */     this.shape15_47.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 189 */     setRotateAngle(this.shape15_47, 1.3203416F, 1.0927507F, -0.4098033F);
/* 190 */     this.shape15_16 = new ModelRenderer(this, 64, 0);
/* 191 */     this.shape15_16.func_78793_a(-4.0F, -9.0F, -1.0F);
/* 192 */     this.shape15_16.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 193 */     setRotateAngle(this.shape15_16, 0.045553092F, 0.3642502F, 0.22759093F);
/* 194 */     this.shape15_12 = new ModelRenderer(this, 64, 0);
/* 195 */     this.shape15_12.func_78793_a(-1.5F, -7.9F, -3.8F);
/* 196 */     this.shape15_12.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 3, 0.0F);
/* 197 */     setRotateAngle(this.shape15_12, 0.5462881F, -0.95609134F, 0.22759093F);
/* 198 */     this.shape15_7 = new ModelRenderer(this, 64, 0);
/* 199 */     this.shape15_7.func_78793_a(-0.7F, -7.9F, 3.0F);
/* 200 */     this.shape15_7.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 5, 3, 0.0F);
/* 201 */     setRotateAngle(this.shape15_7, 0.091106184F, -1.0927507F, 0.22759093F);
/* 202 */     this.shape15_41 = new ModelRenderer(this, 64, 0);
/* 203 */     this.shape15_41.func_78793_a(0.1F, 9.7F, -2.1F);
/* 204 */     this.shape15_41.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 205 */     setRotateAngle(this.shape15_41, 0.91053826F, -0.95609134F, 0.22759093F);
/* 206 */     this.shape15_1 = new ModelRenderer(this, 64, 0);
/* 207 */     this.shape15_1.func_78793_a(-1.0F, -9.0F, -1.2F);
/* 208 */     this.shape15_1.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 209 */     setRotateAngle(this.shape15_1, 0.4553564F, -1.0927507F, 0.22759093F);
/* 210 */     this.shape15_14 = new ModelRenderer(this, 64, 0);
/* 211 */     this.shape15_14.func_78793_a(3.1F, -7.3F, -4.0F);
/* 212 */     this.shape15_14.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 213 */     setRotateAngle(this.shape15_14, 0.95609134F, 0.13665928F, 0.63739425F);
/*     */     
/*     */ 
/*     */ 
/* 217 */     this.shape15_13 = new ModelRenderer(this, 64, 0);
/* 218 */     this.shape15_13.func_78793_a(0.6F, -8.1F, -4.0F);
/* 219 */     this.shape15_13.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 5, 0.0F);
/* 220 */     setRotateAngle(this.shape15_13, 1.0927507F, -0.5009095F, 0.22759093F);
/* 221 */     this.shape15_29 = new ModelRenderer(this, 64, 0);
/* 222 */     this.shape15_29.func_78793_a(-0.3F, 10.9F, 1.7F);
/* 223 */     this.shape15_29.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 224 */     setRotateAngle(this.shape15_29, 1.3203416F, 0.68294734F, -0.8196066F);
/* 225 */     this.shape15_30 = new ModelRenderer(this, 64, 0);
/* 226 */     this.shape15_30.func_78793_a(-0.6F, 2.8F, 1.8F);
/* 227 */     this.shape15_30.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 228 */     setRotateAngle(this.shape15_30, -0.4553564F, -1.0016445F, 0.22759093F);
/* 229 */     this.shape15_45 = new ModelRenderer(this, 64, 0);
/* 230 */     this.shape15_45.func_78793_a(-0.7F, -1.7F, -0.5F);
/* 231 */     this.shape15_45.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 232 */     setRotateAngle(this.shape15_45, 2.7773426F, 1.2747885F, -0.4098033F);
/* 233 */     this.toeLeft = new ModelRenderer(this, 64, 0);
/* 234 */     this.toeLeft.func_78793_a(1.3F, 10.4F, -2.2F);
/* 235 */     this.toeLeft.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 236 */     setRotateAngle(this.toeLeft, 2.4586453F, 0.5009095F, 2.003289F);
/* 237 */     this.shape15_40 = new ModelRenderer(this, 64, 0);
/* 238 */     this.shape15_40.func_78793_a(-0.1F, 8.2F, -2.0F);
/* 239 */     this.shape15_40.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 240 */     setRotateAngle(this.shape15_40, 2.1399481F, 0.0F, -0.4098033F);
/* 241 */     this.shape15_21 = new ModelRenderer(this, 64, 0);
/* 242 */     this.shape15_21.func_78793_a(2.4F, -2.6F, -1.0F);
/* 243 */     this.shape15_21.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 244 */     setRotateAngle(this.shape15_21, -0.5462881F, 0.95609134F, 0.22759093F);
/* 245 */     this.kneeRight = new ModelRenderer(this, 64, 0);
/* 246 */     this.kneeRight.func_78793_a(0.2F, 5.3F, -1.8F);
/* 247 */     this.kneeRight.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 248 */     setRotateAngle(this.kneeRight, 1.3203416F, 0.68294734F, -0.8196066F);
/* 249 */     this.shape15_10 = new ModelRenderer(this, 64, 0);
/* 250 */     this.shape15_10.func_78793_a(-4.5F, -7.1F, -3.8F);
/* 251 */     this.shape15_10.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 252 */     setRotateAngle(this.shape15_10, -0.5462881F, 0.95609134F, 0.22759093F);
/* 253 */     this.shape15_31 = new ModelRenderer(this, 64, 0);
/* 254 */     this.shape15_31.func_78793_a(-0.1F, 4.4F, 1.7F);
/* 255 */     this.shape15_31.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 256 */     setRotateAngle(this.shape15_31, 0.22759093F, -0.63739425F, 0.22759093F);
/* 257 */     this.shape15_46 = new ModelRenderer(this, 64, 0);
/* 258 */     this.shape15_46.func_78793_a(0.2F, -0.5F, -0.8F);
/* 259 */     this.shape15_46.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 260 */     setRotateAngle(this.shape15_46, 3.0049334F, 0.5009095F, -0.63739425F);
/* 261 */     this.shape15_43 = new ModelRenderer(this, 64, 0);
/* 262 */     this.shape15_43.func_78793_a(-0.2F, 1.3F, 1.7F);
/* 263 */     this.shape15_43.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 264 */     setRotateAngle(this.shape15_43, -0.13665928F, -0.8196066F, 0.22759093F);
/* 265 */     this.shape15_28 = new ModelRenderer(this, 64, 0);
/* 266 */     this.shape15_28.func_78793_a(-2.2F, -2.6F, 2.0F);
/* 267 */     this.shape15_28.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 268 */     setRotateAngle(this.shape15_28, 0.59184116F, 0.63739425F, -0.22759093F);
/* 269 */     this.shape15_34 = new ModelRenderer(this, 64, 0);
/* 270 */     this.shape15_34.func_78793_a(0.1F, 9.7F, 1.7F);
/* 271 */     this.shape15_34.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 272 */     setRotateAngle(this.shape15_34, 0.59184116F, -0.63739425F, 0.22759093F);
/*     */     
/*     */ 
/*     */ 
/* 276 */     this.shape15_4 = new ModelRenderer(this, 64, 0);
/* 277 */     this.shape15_4.func_78793_a(4.6F, -8.1F, -1.0F);
/* 278 */     this.shape15_4.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 5, 3, 0.0F);
/* 279 */     setRotateAngle(this.shape15_4, -0.5009095F, -0.5009095F, 0.22759093F);
/* 280 */     this.shape15_38 = new ModelRenderer(this, 64, 0);
/* 281 */     this.shape15_38.func_78793_a(-0.1F, 4.4F, -1.9F);
/* 282 */     this.shape15_38.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 283 */     setRotateAngle(this.shape15_38, 0.22759093F, -0.63739425F, 0.22759093F);
/* 284 */     this.shape15_44 = new ModelRenderer(this, 64, 0);
/* 285 */     this.shape15_44.func_78793_a(-0.7F, -0.7F, -0.4F);
/* 286 */     this.shape15_44.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 287 */     setRotateAngle(this.shape15_44, 2.4586453F, 0.63739425F, -0.4098033F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 292 */     this.shape15_32 = new ModelRenderer(this, 64, 0);
/* 293 */     this.shape15_32.func_78793_a(0.0F, 5.9F, 1.7F);
/* 294 */     this.shape15_32.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 295 */     setRotateAngle(this.shape15_32, 0.59184116F, -0.63739425F, 0.91053826F);
/* 296 */     this.shape15_15 = new ModelRenderer(this, 64, 0);
/* 297 */     this.shape15_15.func_78793_a(-1.8F, -4.3F, 4.0F);
/* 298 */     this.shape15_15.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 5, 3, 0.0F);
/* 299 */     setRotateAngle(this.shape15_15, 0.7285004F, -1.8668041F, 1.548107F);
/* 300 */     this.shape15_20 = new ModelRenderer(this, 64, 0);
/* 301 */     this.shape15_20.func_78793_a(1.8F, -7.5F, 3.8F);
/* 302 */     this.shape15_20.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 5, 3, 0.0F);
/* 303 */     setRotateAngle(this.shape15_20, 0.0F, 0.4098033F, 0.22759093F);
/* 304 */     this.shape15_24 = new ModelRenderer(this, 64, 0);
/* 305 */     this.shape15_24.func_78793_a(0.7F, -1.9F, -2.2F);
/* 306 */     this.shape15_24.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 307 */     setRotateAngle(this.shape15_24, -0.18203785F, 0.4553564F, -2.003289F);
/* 308 */     this.shape15_27 = new ModelRenderer(this, 64, 0);
/* 309 */     this.shape15_27.func_78793_a(-3.5F, -2.6F, 1.0F);
/* 310 */     this.shape15_27.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 311 */     setRotateAngle(this.shape15_27, -0.5462881F, 0.63739425F, -0.22759093F);
/* 312 */     this.shape15_36 = new ModelRenderer(this, 64, 0);
/* 313 */     this.shape15_36.func_78793_a(0.2F, 10.9F, -1.8F);
/* 314 */     this.shape15_36.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 315 */     setRotateAngle(this.shape15_36, 1.3203416F, 0.68294734F, -0.8196066F);
/* 316 */     this.shape15_26 = new ModelRenderer(this, 64, 0);
/* 317 */     this.shape15_26.func_78793_a(-2.7F, -2.6F, -1.6F);
/* 318 */     this.shape15_26.func_78790_a(-1.0F, -1.0F, -1.0F, 3, 3, 3, 0.0F);
/* 319 */     setRotateAngle(this.shape15_26, -0.5462881F, -0.95609134F, -0.22759093F);
/* 320 */     this.n1 = new ModelRenderer(this, 64, 0);
/* 321 */     this.n1.func_78793_a(2.6F, 1.5F, -1.8F);
/* 322 */     this.n1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 323 */     setRotateAngle(this.n1, -0.68294734F, -1.2292354F, 0.22759093F);
/* 324 */     this.n2 = new ModelRenderer(this, 64, 0);
/* 325 */     this.n2.func_78793_a(2.0F, 2.8F, -1.6F);
/* 326 */     this.n2.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 327 */     setRotateAngle(this.n2, -0.4553564F, -1.0016445F, 0.22759093F);
/*     */     
/* 329 */     this.b2 = new ModelRenderer(this, 64, 0);
/* 330 */     this.b2.func_78793_a(0.2F, 13.2F, -1.8F);
/* 331 */     this.b2.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 332 */     setRotateAngle(this.b2, 0.91053826F, 0.68294734F, -0.8196066F);
/* 333 */     this.a4 = new ModelRenderer(this, 64, 0);
/* 334 */     this.a4.func_78793_a(-1.9F, 1.3F, 1.7F);
/* 335 */     this.a4.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 336 */     setRotateAngle(this.a4, 1.0016445F, -0.8196066F, 0.22759093F);
/* 337 */     this.a1 = new ModelRenderer(this, 64, 0);
/* 338 */     this.a1.func_78793_a(2.6F, 1.3F, 1.7F);
/* 339 */     this.a1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 340 */     setRotateAngle(this.a1, -0.13665928F, -0.8196066F, 0.22759093F);
/* 341 */     this.a3 = new ModelRenderer(this, 64, 0);
/* 342 */     this.a3.func_78793_a(1.3F, 1.3F, 1.7F);
/* 343 */     this.a3.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 344 */     setRotateAngle(this.a3, 1.1383038F, -0.8196066F, 0.22759093F);
/* 345 */     this.a2 = new ModelRenderer(this, 64, 0);
/* 346 */     this.a2.func_78793_a(-2.8F, 1.3F, 1.7F);
/* 347 */     this.a2.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 348 */     setRotateAngle(this.a2, 0.3642502F, -0.8196066F, 0.22759093F);
/* 349 */     this.b3 = new ModelRenderer(this, 64, 0);
/* 350 */     this.b3.func_78793_a(1.6F, 12.0F, -1.8F);
/* 351 */     this.b3.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 352 */     setRotateAngle(this.b3, 0.31869712F, -0.59184116F, -0.8196066F);
/* 353 */     this.b1 = new ModelRenderer(this, 64, 0);
/* 354 */     this.b1.func_78793_a(0.2F, 12.0F, -1.8F);
/* 355 */     this.b1.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 356 */     setRotateAngle(this.b1, 1.3203416F, 0.68294734F, -0.8196066F);
/* 357 */     this.b4 = new ModelRenderer(this, 64, 0);
/* 358 */     this.b4.func_78793_a(-1.1F, 12.0F, -1.8F);
/* 359 */     this.b4.func_78790_a(-1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/* 360 */     setRotateAngle(this.b4, 0.31869712F, 0.68294734F, -0.8196066F);
/*     */     
/* 362 */     this.field_78116_c.func_78792_a(this.shape15_9);
/* 363 */     this.field_78116_c.func_78792_a(this.shape15_18);
/* 364 */     this.field_178723_h.func_78792_a(this.shape15_25);
/* 365 */     this.field_78116_c.func_78792_a(this.shape15_5);
/* 366 */     this.field_78116_c.func_78792_a(this.shape15_19);
/* 367 */     this.field_178724_i.func_78792_a(this.shape15_23);
/* 368 */     this.field_78116_c.func_78792_a(this.shape15_3);
/* 369 */     this.field_178724_i.func_78792_a(this.shape15_22);
/* 370 */     this.field_178721_j.func_78792_a(this.toeRight);
/* 371 */     this.field_78116_c.func_78792_a(this.shape15_8);
/* 372 */     this.field_178722_k.func_78792_a(this.kneeLeft);
/* 373 */     this.field_78116_c.func_78792_a(this.shape15_6);
/* 374 */     this.field_78116_c.func_78792_a(this.shape15);
/* 375 */     this.field_78116_c.func_78792_a(this.shape15_2);
/* 376 */     this.field_78116_c.func_78792_a(this.shape15_11);
/* 377 */     this.field_78116_c.func_78792_a(this.shape15_17);
/* 378 */     this.toeLeft.func_78792_a(this.shape15_47);
/* 379 */     this.field_78116_c.func_78792_a(this.shape15_16);
/* 380 */     this.field_78116_c.func_78792_a(this.shape15_12);
/* 381 */     this.field_78116_c.func_78792_a(this.shape15_7);
/* 382 */     this.field_78116_c.func_78792_a(this.shape15_1);
/* 383 */     this.field_78116_c.func_78792_a(this.shape15_14);
/* 384 */     this.field_78116_c.func_78792_a(this.shape15_13);
/* 385 */     this.toeRight.func_78792_a(this.shape15_45);
/* 386 */     this.field_178722_k.func_78792_a(this.toeLeft);
/* 387 */     this.field_178724_i.func_78792_a(this.shape15_21);
/* 388 */     this.field_178721_j.func_78792_a(this.kneeRight);
/* 389 */     this.field_78116_c.func_78792_a(this.shape15_10);
/* 390 */     this.toeLeft.func_78792_a(this.shape15_46);
/* 391 */     this.field_178723_h.func_78792_a(this.shape15_28);
/* 392 */     this.field_78116_c.func_78792_a(this.shape15_4);
/* 393 */     this.toeRight.func_78792_a(this.shape15_44);
/* 394 */     this.field_78116_c.func_78792_a(this.shape15_15);
/* 395 */     this.field_78116_c.func_78792_a(this.shape15_20);
/* 396 */     this.field_178724_i.func_78792_a(this.shape15_24);
/* 397 */     this.field_178723_h.func_78792_a(this.shape15_27);
/* 398 */     this.field_178723_h.func_78792_a(this.shape15_26);
/*     */     
/* 400 */     this.field_78115_e.func_78792_a(this.n1);
/* 401 */     this.field_78115_e.func_78792_a(this.n2);
/* 402 */     this.field_78115_e.func_78792_a(this.shape15_36);
/* 403 */     this.field_78115_e.func_78792_a(this.shape15_32);
/* 404 */     this.field_78115_e.func_78792_a(this.shape15_38);
/* 405 */     this.field_78115_e.func_78792_a(this.shape15_34);
/* 406 */     this.field_78115_e.func_78792_a(this.shape15_43);
/* 407 */     this.field_78115_e.func_78792_a(this.shape15_31);
/* 408 */     this.field_78115_e.func_78792_a(this.shape15_40);
/* 409 */     this.field_78115_e.func_78792_a(this.shape15_29);
/* 410 */     this.field_78115_e.func_78792_a(this.shape15_30);
/* 411 */     this.field_78115_e.func_78792_a(this.shape15_41);
/* 412 */     this.field_78115_e.func_78792_a(this.shape15_33);
/* 413 */     this.field_78115_e.func_78792_a(this.shape15_37);
/* 414 */     this.field_78115_e.func_78792_a(this.shape15_35);
/* 415 */     this.field_78115_e.func_78792_a(this.shape15_39);
/* 416 */     this.field_78115_e.func_78792_a(this.shape15_42);
/*     */     
/* 418 */     this.field_78115_e.func_78792_a(this.a1);
/* 419 */     this.field_78115_e.func_78792_a(this.a2);
/* 420 */     this.field_78115_e.func_78792_a(this.a3);
/* 421 */     this.field_78115_e.func_78792_a(this.a4);
/*     */     
/* 423 */     this.field_78115_e.func_78792_a(this.b1);
/* 424 */     this.field_78115_e.func_78792_a(this.b2);
/* 425 */     this.field_78115_e.func_78792_a(this.b3);
/* 426 */     this.field_78115_e.func_78792_a(this.b4);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 432 */     GlStateManager.func_179147_l();
/* 433 */     GlStateManager.func_179112_b(770, 1);
/* 434 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/* 435 */     GlStateManager.func_179084_k();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 442 */     modelRenderer.field_78795_f = x;
/* 443 */     modelRenderer.field_78796_g = y;
/* 444 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
/*     */   {
/* 449 */     if ((p_78087_7_ instanceof EntityArmorStand)) {
/* 450 */       EntityArmorStand entityarmorstand = (EntityArmorStand)p_78087_7_;
/* 451 */       this.field_78116_c.field_78795_f = (0.017453292F * entityarmorstand.func_175418_s().func_179415_b());
/* 452 */       this.field_78116_c.field_78796_g = (0.017453292F * entityarmorstand.func_175418_s().func_179416_c());
/* 453 */       this.field_78116_c.field_78808_h = (0.017453292F * entityarmorstand.func_175418_s().func_179413_d());
/* 454 */       this.field_78116_c.func_78793_a(0.0F, -1.0F, 0.0F);
/* 455 */       super.func_78087_a(p_78087_1_, p_78087_2_, 0.0F, 0.0F, p_78087_5_, p_78087_6_, p_78087_7_);
/*     */     } else {
/* 457 */       super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelCrystalArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */