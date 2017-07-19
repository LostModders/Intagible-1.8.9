/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.effects.EffectTimer;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityArmorStand;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Rotations;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelSoulArmor extends ModelBiped
/*     */ {
/*     */   public ModelRenderer belt;
/*     */   public ModelRenderer chest;
/*     */   public ModelRenderer shoeLeft;
/*     */   public ModelRenderer shoeLeft2;
/*     */   public ModelRenderer shoulderRight;
/*     */   public ModelRenderer gauntletRight;
/*     */   public ModelRenderer shoulderRightLower;
/*     */   public ModelRenderer shoulderRightUpper2;
/*     */   public ModelRenderer shoulderRightUpper1;
/*     */   public ModelRenderer shoulderRightUpper3;
/*     */   public ModelRenderer gauntletRight2;
/*     */   public ModelRenderer gauntletRightSkull1;
/*     */   public ModelRenderer gauntletRightSkull2;
/*     */   public ModelRenderer gauntletRight1;
/*     */   public ModelRenderer gauntletRight3;
/*     */   public ModelRenderer gauntletRight4;
/*     */   public ModelRenderer shoulderLeft;
/*     */   public ModelRenderer gauntletLeft;
/*     */   public ModelRenderer shoulderLeftLower;
/*     */   public ModelRenderer shoulderLeftUpper2;
/*     */   public ModelRenderer shoulderLeftUpper1;
/*     */   public ModelRenderer shoulderLeftUpper3;
/*     */   public ModelRenderer gauntletLeft2;
/*     */   public ModelRenderer gauntletLeftSkull1;
/*     */   public ModelRenderer gauntletLeftSkull2;
/*     */   public ModelRenderer gauntletLeft1;
/*     */   public ModelRenderer gauntletLeft3;
/*     */   public ModelRenderer gauntletLeft4;
/*     */   public ModelRenderer shoeRight;
/*     */   public ModelRenderer shoeRight2;
/*     */   public ModelRenderer helmet;
/*     */   public ModelRenderer helmetMouth;
/*     */   public ModelRenderer helmetForehead;
/*     */   public ModelRenderer helmetSpike1;
/*     */   public ModelRenderer helmetSpike2;
/*     */   public ModelRenderer helmetSpike3;
/*     */   public ModelRenderer helmetSpike4;
/*     */   public ModelRenderer helmetSpike5;
/*     */   public ModelRenderer helmetSpike6;
/*     */   public ModelRenderer helmetSpike7;
/*     */   public ModelRenderer helmetSpike8;
/*     */   public ModelRenderer helmetSpike9;
/*     */   public ModelRenderer beltSkull1;
/*     */   public ModelRenderer beltSkull2;
/*     */   public ModelRenderer beltDrapeFront1;
/*     */   public ModelRenderer beltDrapeLeftFront;
/*     */   public ModelRenderer beltDrapeRightFront;
/*     */   public ModelRenderer beltDrapeRightBack;
/*     */   public ModelRenderer beltDrapeLeftBack;
/*     */   public ModelRenderer beltDrapeBack1;
/*     */   public ModelRenderer beltDrapeRight1;
/*     */   public ModelRenderer beltDrapeLeft1;
/*     */   public ModelRenderer beltDrapeFront2;
/*     */   public ModelRenderer beltDrapeBack2;
/*     */   public ModelRenderer beltDrapeRight2;
/*     */   public ModelRenderer beltDrapeLeft2;
/*     */   public ModelRenderer chestRibFront1;
/*     */   public ModelRenderer chestRibFront2;
/*     */   public ModelRenderer chestRibFront3;
/*     */   public ModelRenderer chestRibFront4;
/*     */   public ModelRenderer chestRibFront8;
/*     */   public ModelRenderer chestRibFront7;
/*     */   public ModelRenderer chestRibFront6;
/*     */   public ModelRenderer chestRibFront5;
/*     */   public ModelRenderer chestSpine;
/*     */   public ModelRenderer chestSpine2;
/*     */   public ModelRenderer chestSBladeLeft;
/*     */   public ModelRenderer chestSBladeRight;
/*     */   public ModelRenderer chestRibBack3;
/*     */   public ModelRenderer chestRibBack4;
/*     */   public ModelRenderer chestRibBack2;
/*     */   public ModelRenderer chestRibBack1;
/*     */   public ModelRenderer chestRibLeft1;
/*     */   public ModelRenderer chestRibRight1;
/*     */   public ModelRenderer chestRibRight2;
/*     */   public ModelRenderer chestRibLeft2;
/*     */   public ModelRenderer clawRight;
/*     */   public ModelRenderer clawRight1;
/*     */   public ModelRenderer clawRight3;
/*     */   public ModelRenderer clawRight2;
/*     */   public ModelRenderer clawRight4;
/*     */   public ModelRenderer clawLeft;
/*     */   public ModelRenderer clawLeft1;
/*     */   public ModelRenderer clawLeft3;
/*     */   public ModelRenderer clawLeft2;
/*     */   public ModelRenderer clawLeft4;
/*     */   public ModelRenderer tendrils;
/* 114 */   public ModelRenderer[][] tendrilParts = new ModelRenderer[4][20];
/*     */   public ModelRenderer wing;
/*     */   public ModelRenderer wingTip;
/*     */   public ModelRenderer wingSkin;
/*     */   public ModelRenderer wingTipSkin;
/*     */   private float partialTicks;
/*     */   
/*     */   public ModelSoulArmor(float scale) {
/* 122 */     super(scale, 0.0F, 128, 128);
/*     */     
/* 124 */     float gauntletExtraScale = 0.3F;
/* 125 */     this.chestRibBack3 = new ModelRenderer(this, 108, 14);
/* 126 */     this.chestRibBack3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 127 */     this.chestRibBack3.func_78790_a(-3.5F, 4.5F, 2.5F, 4, 1, 1, 0.0F);
/* 128 */     setRotateAngle(this.chestRibBack3, 0.0F, 0.0F, 0.13665928F);
/* 129 */     this.shoeLeft = new ModelRenderer(this, 108, 41);
/* 130 */     this.shoeLeft.field_78809_i = true;
/* 131 */     this.shoeLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.shoeLeft.func_78790_a(-2.5F, 8.1F, -2.5F, 5, 4, 5, 0.0F);
/* 133 */     this.shoulderRightUpper3 = new ModelRenderer(this, 80, 25);
/* 134 */     this.shoulderRightUpper3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 135 */     this.shoulderRightUpper3.func_78790_a(-7.4F, -2.0F, -1.5F, 5, 1, 3, 0.0F);
/* 136 */     setRotateAngle(this.shoulderRightUpper3, 0.0F, 0.0F, 1.0471976F);
/* 137 */     this.shoulderLeftUpper1 = new ModelRenderer(this, 64, 18);
/* 138 */     this.shoulderLeftUpper1.field_78809_i = true;
/* 139 */     this.shoulderLeftUpper1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 140 */     this.shoulderLeftUpper1.func_78790_a(2.6F, -2.0F, -2.5F, 4, 1, 5, 0.0F);
/* 141 */     setRotateAngle(this.shoulderLeftUpper1, 0.0F, 0.0F, -0.5009095F);
/* 142 */     this.chestSpine = new ModelRenderer(this, 96, 16);
/* 143 */     this.chestSpine.func_78793_a(0.0F, 0.0F, 0.0F);
/* 144 */     this.chestSpine.func_78790_a(-1.0F, 1.0F, 3.0F, 2, 10, 1, 0.0F);
/* 145 */     this.chestSpine2 = new ModelRenderer(this, 96, 28);
/* 146 */     this.chestSpine2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 147 */     this.chestSpine2.func_78790_a(-0.5F, 11.0F, 1.5F, 1, 4, 1, 0.0F);
/* 148 */     setRotateAngle(this.chestSpine2, 0.13665928F, 0.0F, 0.0F);
/* 149 */     this.gauntletRightSkull2 = new ModelRenderer(this, 97, 0);
/* 150 */     this.gauntletRightSkull2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 151 */     this.gauntletRightSkull2.func_78790_a(-4.9F, 6.4F, -1.0F, 1, 1, 2, 0.0F);
/*     */     
/*     */ 
/*     */ 
/* 155 */     this.beltDrapeRightBack = new ModelRenderer(this, 94, 45);
/* 156 */     this.beltDrapeRightBack.field_78809_i = true;
/* 157 */     this.beltDrapeRightBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 158 */     this.beltDrapeRightBack.func_78790_a(-4.0F, -1.0F, 1.7F, 2, 5, 1, 0.0F);
/* 159 */     setRotateAngle(this.beltDrapeRightBack, 0.22759093F, 0.0F, 0.0F);
/* 160 */     this.gauntletRight2 = new ModelRenderer(this, 118, 0);
/* 161 */     this.gauntletRight2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 162 */     this.gauntletRight2.func_78790_a(-4.0F, 3.0F, 1.0F, 3, 8, 2, 0.0F);
/* 163 */     this.beltDrapeLeft1 = new ModelRenderer(this, 98, 53);
/* 164 */     this.beltDrapeLeft1.field_78809_i = true;
/* 165 */     this.beltDrapeLeft1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 166 */     this.beltDrapeLeft1.func_78790_a(3.5F, 0.0F, -2.0F, 1, 7, 4, 0.0F);
/* 167 */     setRotateAngle(this.beltDrapeLeft1, 0.0F, 0.0F, -0.18029252F);
/* 168 */     this.shoulderLeftUpper2 = new ModelRenderer(this, 64, 24);
/* 169 */     this.shoulderLeftUpper2.field_78809_i = true;
/* 170 */     this.shoulderLeftUpper2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.shoulderLeftUpper2.func_78790_a(3.0F, -2.0F, -2.0F, 4, 1, 4, 0.0F);
/* 172 */     setRotateAngle(this.shoulderLeftUpper2, 0.0F, 0.0F, -0.7853982F);
/*     */     
/*     */ 
/*     */ 
/* 176 */     this.chestRibRight1 = new ModelRenderer(this, 109, 17);
/* 177 */     this.chestRibRight1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 178 */     this.chestRibRight1.func_78790_a(-3.5F, 4.5F, -2.5F, 1, 1, 5, 0.0F);
/* 179 */     setRotateAngle(this.chestRibRight1, 0.0F, 0.0F, 0.13665928F);
/* 180 */     this.chestRibFront1 = new ModelRenderer(this, 108, 14);
/* 181 */     this.chestRibFront1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 182 */     this.chestRibFront1.func_78790_a(-3.9F, 1.2F, -3.4F, 4, 1, 1, 0.0F);
/* 183 */     setRotateAngle(this.chestRibFront1, 0.0F, 0.0F, 0.13665928F);
/* 184 */     this.gauntletLeft3 = new ModelRenderer(this, 86, 0);
/* 185 */     this.gauntletLeft3.field_78809_i = true;
/* 186 */     this.gauntletLeft3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 187 */     this.gauntletLeft3.func_78790_a(2.8F, 8.2F, -2.0F, 1, 1, 4, 0.0F);
/* 188 */     this.helmet = new ModelRenderer(this, 64, 32);
/* 189 */     this.helmet.func_78793_a(0.0F, 0.0F, 0.0F);
/* 190 */     this.helmet.func_78790_a(-5.0F, -2.5F, -5.0F, 10, 3, 10, 0.0F);
/* 191 */     this.helmetSpike4 = new ModelRenderer(this, 64, 30);
/* 192 */     this.helmetSpike4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 193 */     this.helmetSpike4.func_78790_a(1.5F, -11.5F, 3.4F, 1, 9, 1, 0.0F);
/* 194 */     setRotateAngle(this.helmetSpike4, -0.18203785F, 0.0F, 0.091106184F);
/* 195 */     this.beltDrapeBack1 = new ModelRenderer(this, 118, 56);
/* 196 */     this.beltDrapeBack1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 197 */     this.beltDrapeBack1.func_78790_a(-2.0F, 0.0F, 1.5F, 4, 7, 1, 0.0F);
/* 198 */     setRotateAngle(this.beltDrapeBack1, 0.18029252F, 0.0F, 0.0F);
/* 199 */     this.chestRibFront6 = new ModelRenderer(this, 108, 14);
/* 200 */     this.chestRibFront6.field_78809_i = true;
/* 201 */     this.chestRibFront6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 202 */     this.chestRibFront6.func_78790_a(-0.3F, 2.8F, -3.5F, 4, 1, 1, 0.0F);
/* 203 */     setRotateAngle(this.chestRibFront6, 0.0F, 0.0F, -0.13665928F);
/* 204 */     this.chestRibFront5 = new ModelRenderer(this, 108, 14);
/* 205 */     this.chestRibFront5.field_78809_i = true;
/* 206 */     this.chestRibFront5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 207 */     this.chestRibFront5.func_78790_a(-0.1F, 1.2F, -3.4F, 4, 1, 1, 0.0F);
/* 208 */     setRotateAngle(this.chestRibFront5, 0.0F, 0.0F, -0.13665928F);
/* 209 */     this.helmetSpike5 = new ModelRenderer(this, 64, 30);
/* 210 */     this.helmetSpike5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 211 */     this.helmetSpike5.func_78790_a(-0.5F, -12.5F, 3.4F, 1, 10, 1, 0.0F);
/* 212 */     setRotateAngle(this.helmetSpike5, -0.18203785F, 0.0F, 0.0F);
/* 213 */     this.chestRibFront4 = new ModelRenderer(this, 108, 14);
/* 214 */     this.chestRibFront4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 215 */     this.chestRibFront4.func_78790_a(-3.3F, 6.2F, -3.5F, 4, 1, 1, 0.0F);
/* 216 */     setRotateAngle(this.chestRibFront4, 0.0F, 0.0F, 0.13665928F);
/* 217 */     this.beltDrapeLeftFront = new ModelRenderer(this, 94, 45);
/* 218 */     this.beltDrapeLeftFront.field_78809_i = true;
/* 219 */     this.beltDrapeLeftFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 220 */     this.beltDrapeLeftFront.func_78790_a(2.0F, -1.0F, -2.7F, 2, 5, 1, 0.0F);
/* 221 */     setRotateAngle(this.beltDrapeLeftFront, -0.22759093F, 0.0F, 0.0F);
/* 222 */     this.chestRibLeft1 = new ModelRenderer(this, 109, 17);
/* 223 */     this.chestRibLeft1.field_78809_i = true;
/* 224 */     this.chestRibLeft1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 225 */     this.chestRibLeft1.func_78790_a(2.5F, 4.5F, -2.5F, 1, 1, 5, 0.0F);
/* 226 */     setRotateAngle(this.chestRibLeft1, 0.0F, 0.0F, -0.13665928F);
/* 227 */     this.helmetSpike9 = new ModelRenderer(this, 64, 30);
/* 228 */     this.helmetSpike9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 229 */     this.helmetSpike9.func_78790_a(-4.4F, -10.5F, -3.0F, 1, 8, 1, 0.0F);
/* 230 */     setRotateAngle(this.helmetSpike9, 0.091106184F, 0.0F, -0.18203785F);
/* 231 */     this.shoulderRight = new ModelRenderer(this, 64, 10);
/* 232 */     this.shoulderRight.func_78793_a(0.0F, 0.0F, 0.0F);
/* 233 */     this.shoulderRight.func_78790_a(-6.0F, -3.0F, -3.0F, 7, 2, 6, 0.0F);
/* 234 */     this.shoulderRightUpper2 = new ModelRenderer(this, 64, 24);
/* 235 */     this.shoulderRightUpper2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 236 */     this.shoulderRightUpper2.func_78790_a(-7.0F, -2.0F, -2.0F, 4, 1, 4, 0.0F);
/* 237 */     setRotateAngle(this.shoulderRightUpper2, 0.0F, 0.0F, 0.7853982F);
/* 238 */     this.gauntletLeft4 = new ModelRenderer(this, 86, 0);
/* 239 */     this.gauntletLeft4.field_78809_i = true;
/* 240 */     this.gauntletLeft4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 241 */     this.gauntletLeft4.func_78790_a(1.7F, 9.7F, -2.0F, 1, 1, 4, 0.0F);
/* 242 */     this.chestRibBack1 = new ModelRenderer(this, 108, 14);
/* 243 */     this.chestRibBack1.field_78809_i = true;
/* 244 */     this.chestRibBack1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 245 */     this.chestRibBack1.func_78790_a(-0.5F, 4.5F, 2.5F, 4, 1, 1, 0.0F);
/* 246 */     setRotateAngle(this.chestRibBack1, 0.0F, 0.0F, -0.13665928F);
/* 247 */     this.gauntletLeft1 = new ModelRenderer(this, 118, 0);
/* 248 */     this.gauntletLeft1.field_78809_i = true;
/* 249 */     this.gauntletLeft1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 250 */     this.gauntletLeft1.func_78790_a(1.0F, 3.0F, -3.0F, 3, 8, 2, 0.0F);
/* 251 */     this.chestRibFront2 = new ModelRenderer(this, 108, 14);
/* 252 */     this.chestRibFront2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 253 */     this.chestRibFront2.func_78790_a(-3.7F, 2.8F, -3.5F, 4, 1, 1, 0.0F);
/* 254 */     setRotateAngle(this.chestRibFront2, 0.0F, 0.0F, 0.13665928F);
/* 255 */     this.helmetSpike1 = new ModelRenderer(this, 64, 30);
/* 256 */     this.helmetSpike1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 257 */     this.helmetSpike1.func_78790_a(3.4F, -10.5F, -3.0F, 1, 8, 1, 0.0F);
/* 258 */     setRotateAngle(this.helmetSpike1, 0.091106184F, 0.0F, 0.18203785F);
/* 259 */     this.beltSkull2 = new ModelRenderer(this, 86, 51);
/* 260 */     this.beltSkull2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 261 */     this.beltSkull2.func_78790_a(-1.0F, -1.1F, -3.4F, 2, 1, 1, 0.0F);
/* 262 */     this.gauntletLeftSkull1 = new ModelRenderer(this, 92, 5);
/* 263 */     this.gauntletLeftSkull1.field_78809_i = true;
/* 264 */     this.gauntletLeftSkull1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 265 */     this.gauntletLeftSkull1.func_78790_a(4.0F, 3.5F, -1.5F, 1, 3, 3, 0.0F);
/* 266 */     this.helmetMouth = new ModelRenderer(this, 64, 45);
/* 267 */     this.helmetMouth.func_78793_a(0.0F, 0.0F, 0.0F);
/* 268 */     this.helmetMouth.func_78790_a(-2.5F, -3.0F, -5.5F, 5, 4, 9, 0.0F);
/* 269 */     this.shoeLeft2 = new ModelRenderer(this, 95, 46);
/* 270 */     this.shoeLeft2.field_78809_i = true;
/* 271 */     this.shoeLeft2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 272 */     this.shoeLeft2.func_78790_a(-2.0F, 10.0F, -3.5F, 4, 2, 5, 0.0F);
/* 273 */     this.shoulderLeftUpper3 = new ModelRenderer(this, 80, 25);
/* 274 */     this.shoulderLeftUpper3.field_78809_i = true;
/* 275 */     this.shoulderLeftUpper3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 276 */     this.shoulderLeftUpper3.func_78790_a(2.4F, -2.0F, -1.4F, 5, 1, 3, 0.0F);
/* 277 */     setRotateAngle(this.shoulderLeftUpper3, 0.0F, 0.0F, -1.0471976F);
/* 278 */     this.chestRibBack2 = new ModelRenderer(this, 108, 14);
/* 279 */     this.chestRibBack2.field_78809_i = true;
/* 280 */     this.chestRibBack2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 281 */     this.chestRibBack2.func_78790_a(-0.7F, 6.2F, 2.5F, 4, 1, 1, 0.0F);
/* 282 */     setRotateAngle(this.chestRibBack2, 0.0F, 0.0F, -0.13665928F);
/* 283 */     this.chestRibLeft2 = new ModelRenderer(this, 109, 17);
/* 284 */     this.chestRibLeft2.field_78809_i = true;
/* 285 */     this.chestRibLeft2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 286 */     this.chestRibLeft2.func_78790_a(2.3F, 6.2F, -2.5F, 1, 1, 5, 0.0F);
/* 287 */     setRotateAngle(this.chestRibLeft2, 0.0F, 0.0F, -0.13665928F);
/* 288 */     this.helmetForehead = new ModelRenderer(this, 64, 49);
/* 289 */     this.helmetForehead.func_78793_a(0.0F, -7.6F, 0.0F);
/* 290 */     this.helmetForehead.func_78790_a(-1.5F, -1.7F, -5.5F, 3, 3, 1, 0.0F);
/* 291 */     this.chestRibFront8 = new ModelRenderer(this, 108, 14);
/* 292 */     this.chestRibFront8.field_78809_i = true;
/* 293 */     this.chestRibFront8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 294 */     this.chestRibFront8.func_78790_a(-0.7F, 6.2F, -3.5F, 4, 1, 1, 0.0F);
/* 295 */     setRotateAngle(this.chestRibFront8, 0.0F, 0.0F, -0.13665928F);
/* 296 */     this.gauntletLeftSkull2 = new ModelRenderer(this, 97, 0);
/* 297 */     this.gauntletLeftSkull2.field_78809_i = true;
/* 298 */     this.gauntletLeftSkull2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 299 */     this.gauntletLeftSkull2.func_78790_a(3.9F, 6.4F, -1.0F, 1, 1, 2, 0.0F);
/* 300 */     this.chest = new ModelRenderer(this, 102, 16);
/* 301 */     this.chest.func_78793_a(0.0F, 0.0F, 0.0F);
/* 302 */     this.chest.func_78790_a(-1.0F, 1.2F, -4.0F, 2, 6, 1, 0.0F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 307 */     this.gauntletLeft = new ModelRenderer(this, 100, 0);
/* 308 */     this.gauntletLeft.field_78809_i = true;
/* 309 */     this.gauntletLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/* 310 */     this.gauntletLeft.func_78790_a(-1.1F, 4.5F, -2.5F, 4, 4, 5, gauntletExtraScale);
/* 311 */     this.helmetSpike6 = new ModelRenderer(this, 64, 30);
/* 312 */     this.helmetSpike6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 313 */     this.helmetSpike6.func_78790_a(-2.5F, -11.5F, 3.4F, 1, 9, 1, 0.0F);
/* 314 */     setRotateAngle(this.helmetSpike6, -0.18203785F, 0.0F, -0.091106184F);
/* 315 */     this.gauntletRight1 = new ModelRenderer(this, 118, 0);
/* 316 */     this.gauntletRight1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 317 */     this.gauntletRight1.func_78790_a(-4.0F, 3.0F, -3.0F, 3, 8, 2, 0.0F);
/* 318 */     this.chestRibFront7 = new ModelRenderer(this, 108, 14);
/* 319 */     this.chestRibFront7.field_78809_i = true;
/* 320 */     this.chestRibFront7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 321 */     this.chestRibFront7.func_78790_a(-0.5F, 4.5F, -3.5F, 4, 1, 1, 0.0F);
/* 322 */     setRotateAngle(this.chestRibFront7, 0.0F, 0.0F, -0.13665928F);
/* 323 */     this.shoulderRightUpper1 = new ModelRenderer(this, 64, 18);
/* 324 */     this.shoulderRightUpper1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 325 */     this.shoulderRightUpper1.func_78790_a(-6.6F, -2.0F, -2.5F, 4, 1, 5, 0.0F);
/* 326 */     setRotateAngle(this.shoulderRightUpper1, 0.0F, 0.0F, 0.5009095F);
/* 327 */     this.beltDrapeFront1 = new ModelRenderer(this, 118, 56);
/* 328 */     this.beltDrapeFront1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 329 */     this.beltDrapeFront1.func_78790_a(-2.0F, 0.0F, -2.5F, 4, 7, 1, 0.0F);
/* 330 */     setRotateAngle(this.beltDrapeFront1, -0.18029252F, 0.0F, 0.0F);
/*     */     
/*     */ 
/*     */ 
/* 334 */     this.beltDrapeLeft2 = new ModelRenderer(this, 88, 56);
/* 335 */     this.beltDrapeLeft2.field_78809_i = true;
/* 336 */     this.beltDrapeLeft2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 337 */     this.beltDrapeLeft2.func_78790_a(2.9F, 7.2F, -2.0F, 1, 4, 4, 0.0F);
/* 338 */     setRotateAngle(this.beltDrapeLeft2, 0.0F, 0.0F, -0.091106184F);
/* 339 */     this.helmetSpike7 = new ModelRenderer(this, 64, 30);
/* 340 */     this.helmetSpike7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 341 */     this.helmetSpike7.func_78790_a(-4.4F, -10.5F, 1.0F, 1, 8, 1, 0.0F);
/* 342 */     setRotateAngle(this.helmetSpike7, -0.091106184F, 0.0F, -0.18203785F);
/*     */     
/*     */ 
/*     */ 
/* 346 */     this.beltDrapeBack2 = new ModelRenderer(this, 108, 59);
/* 347 */     this.beltDrapeBack2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 348 */     this.beltDrapeBack2.func_78790_a(-2.0F, 7.0F, 0.9F, 4, 4, 1, 0.0F);
/* 349 */     setRotateAngle(this.beltDrapeBack2, 0.091106184F, 0.0F, 0.0F);
/* 350 */     this.chestRibRight2 = new ModelRenderer(this, 109, 17);
/* 351 */     this.chestRibRight2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 352 */     this.chestRibRight2.func_78790_a(-3.3F, 6.2F, -2.5F, 1, 1, 5, 0.0F);
/* 353 */     setRotateAngle(this.chestRibRight2, 0.0F, 0.0F, 0.13665928F);
/* 354 */     this.beltDrapeRight1 = new ModelRenderer(this, 98, 53);
/* 355 */     this.beltDrapeRight1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 356 */     this.beltDrapeRight1.func_78790_a(-4.5F, 0.0F, -2.0F, 1, 7, 4, 0.0F);
/* 357 */     setRotateAngle(this.beltDrapeRight1, 0.0F, 0.0F, 0.18203785F);
/* 358 */     this.chestRibFront3 = new ModelRenderer(this, 108, 14);
/* 359 */     this.chestRibFront3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 360 */     this.chestRibFront3.func_78790_a(-3.5F, 4.5F, -3.5F, 4, 1, 1, 0.0F);
/* 361 */     setRotateAngle(this.chestRibFront3, 0.0F, 0.0F, 0.13665928F);
/* 362 */     this.gauntletRight = new ModelRenderer(this, 100, 0);
/* 363 */     this.gauntletRight.func_78793_a(0.0F, 0.0F, 0.0F);
/* 364 */     this.gauntletRight.func_78790_a(-2.9F, 4.5F, -2.5F, 4, 4, 5, gauntletExtraScale);
/* 365 */     this.shoulderLeftLower = new ModelRenderer(this, 64, 0);
/* 366 */     this.shoulderLeftLower.field_78809_i = true;
/* 367 */     this.shoulderLeftLower.func_78793_a(0.0F, 0.0F, 0.0F);
/* 368 */     this.shoulderLeftLower.func_78790_a(-2.0F, -3.5F, -3.5F, 7, 3, 7, 0.0F);
/* 369 */     setRotateAngle(this.shoulderLeftLower, 0.0F, 0.0F, 0.5235988F);
/* 370 */     this.shoeRight2 = new ModelRenderer(this, 95, 46);
/* 371 */     this.shoeRight2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 372 */     this.shoeRight2.func_78790_a(-2.0F, 10.0F, -3.5F, 4, 2, 5, 0.0F);
/* 373 */     this.beltDrapeRightFront = new ModelRenderer(this, 94, 45);
/* 374 */     this.beltDrapeRightFront.func_78793_a(0.0F, 0.0F, 0.0F);
/* 375 */     this.beltDrapeRightFront.func_78790_a(-4.0F, -1.0F, -2.7F, 2, 5, 1, 0.0F);
/* 376 */     setRotateAngle(this.beltDrapeRightFront, -0.22759093F, 0.0F, 0.0F);
/* 377 */     this.beltDrapeFront2 = new ModelRenderer(this, 108, 59);
/* 378 */     this.beltDrapeFront2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 379 */     this.beltDrapeFront2.func_78790_a(-2.0F, 7.0F, -1.9F, 4, 4, 1, 0.0F);
/* 380 */     setRotateAngle(this.beltDrapeFront2, -0.091106184F, 0.0F, 0.0F);
/* 381 */     this.chestSBladeLeft = new ModelRenderer(this, 96, 12);
/* 382 */     this.chestSBladeLeft.field_78809_i = true;
/* 383 */     this.chestSBladeLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/* 384 */     this.chestSBladeLeft.func_78790_a(0.5F, 0.6F, 2.4F, 4, 3, 1, 0.0F);
/* 385 */     setRotateAngle(this.chestSBladeLeft, 0.0F, 0.0F, -0.18203785F);
/* 386 */     this.shoulderLeft = new ModelRenderer(this, 64, 10);
/* 387 */     this.shoulderLeft.field_78809_i = true;
/* 388 */     this.shoulderLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/* 389 */     this.shoulderLeft.func_78790_a(-1.0F, -3.0F, -3.0F, 7, 2, 6, 0.0F);
/* 390 */     this.gauntletRightSkull1 = new ModelRenderer(this, 92, 5);
/* 391 */     this.gauntletRightSkull1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 392 */     this.gauntletRightSkull1.func_78790_a(-5.0F, 3.5F, -1.5F, 1, 3, 3, 0.0F);
/* 393 */     this.gauntletRight3 = new ModelRenderer(this, 86, 0);
/* 394 */     this.gauntletRight3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 395 */     this.gauntletRight3.func_78790_a(-3.8F, 8.2F, -2.0F, 1, 1, 4, 0.0F);
/* 396 */     this.beltSkull1 = new ModelRenderer(this, 85, 46);
/* 397 */     this.beltSkull1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 398 */     this.beltSkull1.func_78790_a(-1.5F, -4.0F, -3.5F, 3, 3, 1, 0.0F);
/* 399 */     this.helmetSpike8 = new ModelRenderer(this, 64, 30);
/* 400 */     this.helmetSpike8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 401 */     this.helmetSpike8.func_78790_a(-4.4F, -11.5F, -1.0F, 1, 9, 1, 0.0F);
/* 402 */     setRotateAngle(this.helmetSpike8, 0.0F, 0.0F, -0.18203785F);
/* 403 */     this.chestRibBack4 = new ModelRenderer(this, 108, 14);
/* 404 */     this.chestRibBack4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 405 */     this.chestRibBack4.func_78790_a(-3.3F, 6.2F, 2.5F, 4, 1, 1, 0.0F);
/* 406 */     setRotateAngle(this.chestRibBack4, 0.0F, 0.0F, 0.13665928F);
/* 407 */     this.chestSBladeRight = new ModelRenderer(this, 96, 12);
/* 408 */     this.chestSBladeRight.func_78793_a(0.0F, 0.0F, 0.0F);
/* 409 */     this.chestSBladeRight.func_78790_a(-4.5F, 0.6F, 2.4F, 4, 3, 1, 0.0F);
/* 410 */     setRotateAngle(this.chestSBladeRight, 0.0F, 0.0F, 0.18203785F);
/* 411 */     this.gauntletRight4 = new ModelRenderer(this, 86, 0);
/* 412 */     this.gauntletRight4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 413 */     this.gauntletRight4.func_78790_a(-2.7F, 9.7F, -2.0F, 1, 1, 4, 0.0F);
/* 414 */     this.beltDrapeLeftBack = new ModelRenderer(this, 94, 45);
/* 415 */     this.beltDrapeLeftBack.func_78793_a(0.0F, 0.0F, 0.0F);
/* 416 */     this.beltDrapeLeftBack.func_78790_a(2.0F, -1.0F, 1.7F, 2, 5, 1, 0.0F);
/* 417 */     setRotateAngle(this.beltDrapeLeftBack, 0.22759093F, 0.0F, 0.0F);
/* 418 */     this.shoeRight = new ModelRenderer(this, 108, 41);
/* 419 */     this.shoeRight.func_78793_a(0.0F, 0.0F, 0.0F);
/* 420 */     this.shoeRight.func_78790_a(-2.5F, 8.1F, -2.5F, 5, 4, 5, 0.0F);
/* 421 */     this.helmetSpike3 = new ModelRenderer(this, 64, 30);
/* 422 */     this.helmetSpike3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 423 */     this.helmetSpike3.func_78790_a(3.4F, -10.5F, 1.0F, 1, 8, 1, 0.0F);
/* 424 */     setRotateAngle(this.helmetSpike3, -0.091106184F, 0.0F, 0.18203785F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 429 */     this.beltDrapeRight2 = new ModelRenderer(this, 88, 56);
/* 430 */     this.beltDrapeRight2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 431 */     this.beltDrapeRight2.func_78790_a(-3.9F, 7.2F, -2.0F, 1, 4, 4, 0.0F);
/* 432 */     setRotateAngle(this.beltDrapeRight2, 0.0F, 0.0F, 0.091106184F);
/* 433 */     this.shoulderRightLower = new ModelRenderer(this, 64, 0);
/* 434 */     this.shoulderRightLower.func_78793_a(0.0F, 0.0F, 0.0F);
/* 435 */     this.shoulderRightLower.func_78790_a(-5.0F, -3.5F, -3.5F, 7, 3, 7, 0.0F);
/* 436 */     setRotateAngle(this.shoulderRightLower, 0.0F, 0.0F, -0.5235988F);
/* 437 */     this.belt = new ModelRenderer(this, 96, 32);
/* 438 */     this.belt.func_78793_a(0.0F, 12.0F, 0.0F);
/* 439 */     this.belt.func_78790_a(-4.5F, -3.5F, -2.5F, 9, 4, 5, 0.0F);
/* 440 */     this.helmetSpike2 = new ModelRenderer(this, 64, 30);
/* 441 */     this.helmetSpike2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 442 */     this.helmetSpike2.func_78790_a(3.4F, -11.5F, -1.0F, 1, 9, 1, 0.0F);
/* 443 */     setRotateAngle(this.helmetSpike2, 0.0F, 0.0F, 0.18203785F);
/* 444 */     this.gauntletLeft2 = new ModelRenderer(this, 118, 0);
/* 445 */     this.gauntletLeft2.field_78809_i = true;
/* 446 */     this.gauntletLeft2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 447 */     this.gauntletLeft2.func_78790_a(1.0F, 3.0F, 1.0F, 3, 8, 2, 0.0F);
/*     */     
/* 449 */     this.clawLeft = new ModelRenderer(this, 118, 0);
/* 450 */     this.clawLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/* 451 */     this.clawLeft.func_78790_a(1.7F, 9.5F, -2.5F, 1, 1, 1, 0.0F);
/* 452 */     this.clawRight1 = new ModelRenderer(this, 107, 9);
/* 453 */     this.clawRight1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 454 */     this.clawRight1.func_78790_a(-4.8F, 9.9F, -2.5F, 2, 3, 1, 0.0F);
/* 455 */     setRotateAngle(this.clawRight1, 0.0F, 0.0F, -0.13665928F);
/* 456 */     this.clawLeft2 = new ModelRenderer(this, 114, 9);
/* 457 */     this.clawLeft2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 458 */     this.clawLeft2.func_78790_a(4.6F, 12.0F, -2.5F, 1, 3, 1, 0.0F);
/* 459 */     setRotateAngle(this.clawLeft2, 0.0F, 0.0F, 0.1436406F);
/* 460 */     this.clawRight = new ModelRenderer(this, 118, 0);
/* 461 */     this.clawRight.func_78793_a(0.0F, 0.0F, 0.0F);
/* 462 */     this.clawRight.func_78790_a(-2.7F, 9.5F, -2.5F, 1, 1, 1, 0.0F);
/* 463 */     this.clawLeft1 = new ModelRenderer(this, 107, 9);
/* 464 */     this.clawLeft1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 465 */     this.clawLeft1.func_78790_a(2.8F, 9.9F, -2.5F, 2, 3, 1, 0.0F);
/* 466 */     setRotateAngle(this.clawLeft1, 0.0F, 0.0F, 0.13665928F);
/* 467 */     this.clawLeft4 = new ModelRenderer(this, 114, 9);
/* 468 */     this.clawLeft4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 469 */     this.clawLeft4.func_78790_a(4.6F, 12.0F, 1.5F, 1, 3, 1, 0.0F);
/* 470 */     setRotateAngle(this.clawLeft4, 0.0F, 0.0F, 0.1436406F);
/* 471 */     this.clawRight2 = new ModelRenderer(this, 114, 9);
/* 472 */     this.clawRight2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 473 */     this.clawRight2.func_78790_a(-5.6F, 12.0F, -2.5F, 1, 3, 1, 0.0F);
/* 474 */     setRotateAngle(this.clawRight2, 0.0F, 0.0F, -0.1436406F);
/* 475 */     this.clawRight3 = new ModelRenderer(this, 107, 9);
/* 476 */     this.clawRight3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 477 */     this.clawRight3.func_78790_a(-4.8F, 9.9F, 1.5F, 2, 3, 1, 0.0F);
/* 478 */     setRotateAngle(this.clawRight3, 0.0F, 0.0F, -0.13665928F);
/* 479 */     this.clawRight4 = new ModelRenderer(this, 114, 9);
/* 480 */     this.clawRight4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 481 */     this.clawRight4.func_78790_a(-5.6F, 12.0F, 1.5F, 1, 3, 1, 0.0F);
/* 482 */     setRotateAngle(this.clawRight4, 0.0F, 0.0F, -0.1436406F);
/* 483 */     this.clawLeft3 = new ModelRenderer(this, 107, 9);
/* 484 */     this.clawLeft3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 485 */     this.clawLeft3.func_78790_a(2.8F, 9.9F, 1.5F, 2, 3, 1, 0.0F);
/* 486 */     setRotateAngle(this.clawLeft3, 0.0F, 0.0F, 0.13665928F);
/* 487 */     this.gauntletLeft.func_78792_a(this.clawLeft);
/* 488 */     this.clawRight.func_78792_a(this.clawRight1);
/* 489 */     this.clawLeft1.func_78792_a(this.clawLeft2);
/* 490 */     this.gauntletRight.func_78792_a(this.clawRight);
/* 491 */     this.clawLeft.func_78792_a(this.clawLeft1);
/* 492 */     this.clawLeft3.func_78792_a(this.clawLeft4);
/* 493 */     this.clawRight1.func_78792_a(this.clawRight2);
/* 494 */     this.clawRight.func_78792_a(this.clawRight3);
/* 495 */     this.clawRight3.func_78792_a(this.clawRight4);
/* 496 */     this.clawLeft.func_78792_a(this.clawLeft3);
/*     */     
/* 498 */     this.tendrils = new ModelRenderer(this, 85, 12);
/* 499 */     this.tendrils.func_78793_a(0.0F, 2.0F, 4.2F);
/* 500 */     this.tendrils.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
/*     */     
/* 502 */     for (int tendril = 0; tendril < this.tendrilParts.length; tendril++) {
/* 503 */       ModelRenderer lastPart = this.tendrils;
/* 504 */       for (int part = 0; part < this.tendrilParts[tendril].length; part++) {
/* 505 */         ModelRenderer partRenderer = new ModelRenderer(this, 85, 12);
/* 506 */         partRenderer.func_78793_a(0.0F, part > 0 ? 2.0F : 0.0F, 0.0F);
/* 507 */         partRenderer.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
/* 508 */         lastPart.func_78792_a(partRenderer);
/* 509 */         lastPart = partRenderer;
/* 510 */         this.tendrilParts[tendril][part] = partRenderer;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 515 */     this.wing = new ModelRenderer(this, 64, 64);
/* 516 */     this.wing.func_78793_a(-2.4F, 3.0F, 2.8F);
/* 517 */     this.wing.func_78790_a(-20.0F, -1.0F, -1.0F, 20, 2, 2, 0.0F);
/*     */     
/* 519 */     this.wingTip = new ModelRenderer(this, 64, 68);
/* 520 */     this.wingTip.func_78793_a(-20.0F, 0.0F, 0.0F);
/* 521 */     this.wingTip.func_78790_a(-20.0F, -0.5F, -0.5F, 20, 1, 1, 0.0F);
/* 522 */     setRotateAngle(this.wingTip, 0.0F, 0.0F, -1.0569714F);
/*     */     
/* 524 */     this.wingSkin = new ModelRenderer(this, 44, 70);
/* 525 */     this.wingSkin.func_78793_a(0.0F, 0.0F, 0.0F);
/* 526 */     this.wingSkin.func_78790_a(-20.0F, 0.0F, 1.0F, 20, 0, 20, 0.0F);
/*     */     
/* 528 */     this.wingTipSkin = new ModelRenderer(this, 44, 90);
/* 529 */     this.wingTipSkin.func_78793_a(0.0F, 0.0F, 0.0F);
/* 530 */     this.wingTipSkin.func_78790_a(-20.0F, 0.0F, 0.5F, 20, 0, 20, 0.0F);
/*     */     
/* 532 */     this.wing.func_78792_a(this.wingTip);
/* 533 */     this.wing.func_78792_a(this.wingSkin);
/* 534 */     this.wingTip.func_78792_a(this.wingTipSkin);
/*     */     
/*     */ 
/* 537 */     this.chest.func_78792_a(this.tendrils);
/*     */     
/* 539 */     this.chest.func_78792_a(this.chestRibBack3);
/* 540 */     this.field_178722_k.func_78792_a(this.shoeLeft);
/* 541 */     this.shoulderRight.func_78792_a(this.shoulderRightUpper3);
/* 542 */     this.shoulderLeft.func_78792_a(this.shoulderLeftUpper1);
/* 543 */     this.chest.func_78792_a(this.chestSpine);
/* 544 */     this.chest.func_78792_a(this.chestSpine2);
/* 545 */     this.gauntletRight.func_78792_a(this.gauntletRightSkull2);
/* 546 */     this.belt.func_78792_a(this.beltDrapeRightBack);
/* 547 */     this.gauntletRight.func_78792_a(this.gauntletRight2);
/* 548 */     this.belt.func_78792_a(this.beltDrapeLeft1);
/* 549 */     this.shoulderLeft.func_78792_a(this.shoulderLeftUpper2);
/* 550 */     this.chest.func_78792_a(this.chestRibRight1);
/* 551 */     this.chest.func_78792_a(this.chestRibFront1);
/* 552 */     this.gauntletLeft.func_78792_a(this.gauntletLeft3);
/* 553 */     this.field_78116_c.func_78792_a(this.helmet);
/* 554 */     this.helmet.func_78792_a(this.helmetSpike4);
/* 555 */     this.belt.func_78792_a(this.beltDrapeBack1);
/* 556 */     this.chest.func_78792_a(this.chestRibFront6);
/* 557 */     this.chest.func_78792_a(this.chestRibFront5);
/* 558 */     this.helmet.func_78792_a(this.helmetSpike5);
/* 559 */     this.chest.func_78792_a(this.chestRibFront4);
/* 560 */     this.belt.func_78792_a(this.beltDrapeLeftFront);
/* 561 */     this.chest.func_78792_a(this.chestRibLeft1);
/* 562 */     this.helmet.func_78792_a(this.helmetSpike9);
/* 563 */     this.field_178723_h.func_78792_a(this.shoulderRight);
/* 564 */     this.shoulderRight.func_78792_a(this.shoulderRightUpper2);
/* 565 */     this.gauntletLeft.func_78792_a(this.gauntletLeft4);
/* 566 */     this.chest.func_78792_a(this.chestRibBack1);
/* 567 */     this.gauntletLeft.func_78792_a(this.gauntletLeft1);
/* 568 */     this.chest.func_78792_a(this.chestRibFront2);
/* 569 */     this.helmet.func_78792_a(this.helmetSpike1);
/* 570 */     this.belt.func_78792_a(this.beltSkull2);
/* 571 */     this.gauntletLeft.func_78792_a(this.gauntletLeftSkull1);
/* 572 */     this.helmet.func_78792_a(this.helmetMouth);
/* 573 */     this.shoeLeft.func_78792_a(this.shoeLeft2);
/* 574 */     this.shoulderLeft.func_78792_a(this.shoulderLeftUpper3);
/* 575 */     this.chest.func_78792_a(this.chestRibBack2);
/* 576 */     this.chest.func_78792_a(this.chestRibLeft2);
/* 577 */     this.helmet.func_78792_a(this.helmetForehead);
/* 578 */     this.chest.func_78792_a(this.chestRibFront8);
/* 579 */     this.gauntletLeft.func_78792_a(this.gauntletLeftSkull2);
/* 580 */     this.field_78115_e.func_78792_a(this.chest);
/* 581 */     this.field_178724_i.func_78792_a(this.gauntletLeft);
/* 582 */     this.helmet.func_78792_a(this.helmetSpike6);
/* 583 */     this.gauntletRight.func_78792_a(this.gauntletRight1);
/* 584 */     this.chest.func_78792_a(this.chestRibFront7);
/* 585 */     this.shoulderRight.func_78792_a(this.shoulderRightUpper1);
/* 586 */     this.belt.func_78792_a(this.beltDrapeFront1);
/* 587 */     this.beltDrapeLeft1.func_78792_a(this.beltDrapeLeft2);
/* 588 */     this.helmet.func_78792_a(this.helmetSpike7);
/* 589 */     this.beltDrapeBack1.func_78792_a(this.beltDrapeBack2);
/* 590 */     this.chest.func_78792_a(this.chestRibRight2);
/* 591 */     this.belt.func_78792_a(this.beltDrapeRight1);
/* 592 */     this.chest.func_78792_a(this.chestRibFront3);
/* 593 */     this.field_178723_h.func_78792_a(this.gauntletRight);
/* 594 */     this.shoulderLeft.func_78792_a(this.shoulderLeftLower);
/* 595 */     this.shoeRight.func_78792_a(this.shoeRight2);
/* 596 */     this.belt.func_78792_a(this.beltDrapeRightFront);
/* 597 */     this.beltDrapeFront1.func_78792_a(this.beltDrapeFront2);
/* 598 */     this.chest.func_78792_a(this.chestSBladeLeft);
/* 599 */     this.field_178724_i.func_78792_a(this.shoulderLeft);
/* 600 */     this.gauntletRight.func_78792_a(this.gauntletRightSkull1);
/* 601 */     this.gauntletRight.func_78792_a(this.gauntletRight3);
/* 602 */     this.belt.func_78792_a(this.beltSkull1);
/* 603 */     this.helmet.func_78792_a(this.helmetSpike8);
/* 604 */     this.chest.func_78792_a(this.chestRibBack4);
/* 605 */     this.chest.func_78792_a(this.chestSBladeRight);
/* 606 */     this.gauntletRight.func_78792_a(this.gauntletRight4);
/* 607 */     this.belt.func_78792_a(this.beltDrapeLeftBack);
/* 608 */     this.field_178721_j.func_78792_a(this.shoeRight);
/* 609 */     this.helmet.func_78792_a(this.helmetSpike3);
/* 610 */     this.beltDrapeRight1.func_78792_a(this.beltDrapeRight2);
/* 611 */     this.shoulderRight.func_78792_a(this.shoulderRightLower);
/* 612 */     this.field_78115_e.func_78792_a(this.belt);
/* 613 */     this.helmet.func_78792_a(this.helmetSpike2);
/* 614 */     this.gauntletLeft.func_78792_a(this.gauntletLeft2);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 626 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*     */     
/*     */ 
/*     */ 
/* 630 */     if (this.wing.field_78806_j)
/*     */     {
/* 632 */       double motionFactor = entity.field_70159_w * entity.field_70159_w + entity.field_70179_y * entity.field_70179_y;
/* 633 */       double fullSpeed = 0.16000000000000003D;
/* 634 */       float scale = (float)(Math.min(motionFactor, fullSpeed) / fullSpeed);
/* 635 */       int forward = new Vec3(entity.field_70159_w, 0.0D, entity.field_70179_y).func_72430_b(entity.func_70040_Z()) > 0.0D ? 1 : -1;
/*     */       
/* 637 */       float f6 = entity.field_70173_aa / 4.0F;
/* 638 */       GlStateManager.func_179089_o();
/* 639 */       for (int j = 0; j < 2; j++) {
/* 640 */         this.wing.field_78795_f = (0.125F - (float)Math.cos(f6) * 0.2F - scale * 0.75F);
/* 641 */         this.wing.field_78796_g = 0.25F;
/* 642 */         this.wing.field_78808_h = ((float)(Math.sin(f6) + 0.125D) * 0.8F);
/* 643 */         this.wingTip.field_78808_h = (-((float)Math.sin(f6 + 2.0D) + 0.5F) * 0.75F);
/* 644 */         this.wing.func_78785_a(f5);
/* 645 */         GlStateManager.func_179152_a(-1.0F, 1.0F, 1.0F);
/*     */         
/* 647 */         if (j == 0)
/*     */         {
/* 649 */           GlStateManager.func_179107_e(1028);
/*     */         }
/*     */       }
/* 652 */       GlStateManager.func_179107_e(1029);
/* 653 */       GlStateManager.func_179129_p();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private float updateRotations(double rotation)
/*     */   {
/* 660 */     while (rotation >= 180.0D) {
/* 661 */       rotation -= 360.0D;
/*     */     }
/*     */     
/* 664 */     while (rotation < -180.0D) {
/* 665 */       rotation += 360.0D;
/*     */     }
/*     */     
/* 668 */     return (float)rotation;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 675 */     modelRenderer.field_78795_f = x;
/* 676 */     modelRenderer.field_78796_g = y;
/* 677 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_78086_a(EntityLivingBase ebtity, float p_78086_2_, float p_78086_3_, float partialTicks)
/*     */   {
/* 684 */     this.partialTicks = partialTicks;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_78087_a(float timePart, float legExtentPart, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity)
/*     */   {
/* 691 */     if ((entity instanceof EntityArmorStand)) {
/* 692 */       EntityArmorStand entityarmorstand = (EntityArmorStand)entity;
/* 693 */       this.field_78116_c.field_78795_f = (0.017453292F * entityarmorstand.func_175418_s().func_179415_b());
/* 694 */       this.field_78116_c.field_78796_g = (0.017453292F * entityarmorstand.func_175418_s().func_179416_c());
/* 695 */       this.field_78116_c.field_78808_h = (0.017453292F * entityarmorstand.func_175418_s().func_179413_d());
/* 696 */       this.field_78116_c.func_78793_a(0.0F, -1.0F, 0.0F);
/* 697 */       super.func_78087_a(timePart, legExtentPart, 0.0F, 0.0F, p_78087_5_, p_78087_6_, entity);
/*     */     } else {
/* 699 */       this.field_78116_c.field_78795_f = 0.0F;
/* 700 */       this.field_78116_c.field_78796_g = 0.0F;
/* 701 */       this.field_78116_c.field_78808_h = 0.0F;
/* 702 */       this.field_78116_c.func_78793_a(0.0F, 0.0F, 0.0F);
/* 703 */       super.func_78087_a(timePart, legExtentPart, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, entity);
/*     */     }
/*     */     
/* 706 */     this.beltDrapeBack1.field_78795_f = (Math.max(this.field_178721_j.field_78795_f, this.field_178722_k.field_78795_f) + 0.18029252F);
/* 707 */     this.beltDrapeFront1.field_78795_f = (Math.min(this.field_178721_j.field_78795_f, this.field_178722_k.field_78795_f) - 0.18029252F);
/*     */     
/* 709 */     this.beltDrapeLeftBack.field_78795_f = (Math.max(this.field_178722_k.field_78795_f, 0.0F) + 0.22759093F);
/* 710 */     this.beltDrapeRightBack.field_78795_f = (Math.max(this.field_178721_j.field_78795_f, 0.0F) + 0.22759093F);
/*     */     
/* 712 */     this.beltDrapeLeftFront.field_78795_f = (Math.min(this.field_178722_k.field_78795_f, 0.0F) - 0.22759093F);
/* 713 */     this.beltDrapeRightFront.field_78795_f = (Math.min(this.field_178721_j.field_78795_f, 0.0F) - 0.22759093F);
/*     */     
/* 715 */     if (this.field_78117_n) {
/* 716 */       this.belt.field_78795_f = -0.5F;
/* 717 */       this.belt.field_78798_e = 0.0F;
/* 718 */       this.belt.field_78797_d = 10.0F;
/* 719 */       this.beltDrapeLeftFront.field_78795_f -= 0.3F;
/* 720 */       this.beltDrapeRightFront.field_78795_f -= 0.3F;
/* 721 */       this.beltDrapeFront1.field_78795_f -= 0.2F;
/*     */       
/* 723 */       this.beltDrapeLeftBack.field_78795_f += 0.3F;
/* 724 */       this.beltDrapeRightBack.field_78795_f += 0.3F;
/* 725 */       this.beltDrapeBack1.field_78795_f += 0.2F;
/*     */       
/* 727 */       this.wing.func_78793_a(-2.4F, 4.0F, 3.8F);
/*     */     } else {
/* 729 */       this.belt.field_78795_f = 0.0F;
/* 730 */       this.belt.field_78798_e = 0.0F;
/* 731 */       this.belt.field_78797_d = 12.0F;
/* 732 */       this.beltDrapeLeft1.field_78795_f = 0.0F;
/* 733 */       this.beltDrapeLeft1.field_78808_h = -0.18203785F;
/* 734 */       this.beltDrapeRight1.field_78795_f = 0.0F;
/* 735 */       this.beltDrapeRight1.field_78808_h = 0.18203785F; ModelRenderer 
/*     */       
/* 737 */         tmp490_487 = this.beltDrapeLeft1;tmp490_487.field_78795_f = ((float)(tmp490_487.field_78795_f + legExtentPart * 0.2D)); ModelRenderer 
/* 738 */         tmp510_507 = this.beltDrapeRight1;tmp510_507.field_78795_f = ((float)(tmp510_507.field_78795_f + legExtentPart * 0.2D));
/* 739 */       this.beltDrapeRight1.field_78808_h = ((0.05F + (float)Math.sin(timePart) * 0.05F) * legExtentPart + 0.18203785F);
/* 740 */       this.beltDrapeLeft1.field_78808_h = ((-0.05F - (float)Math.sin(timePart) * 0.05F) * legExtentPart - 0.18203785F);
/*     */       
/* 742 */       this.wing.func_78793_a(-2.4F, 2.0F, 2.8F);
/*     */     }
/*     */     
/* 745 */     boolean climbing = false;
/* 746 */     if ((entity instanceof EntityPlayer)) {
/* 747 */       EntityPlayer player = (EntityPlayer)entity;
/* 748 */       PlayerEx playerEx = PlayerEx.get(player);
/* 749 */       if (this.clawLeft.field_78806_j) {
/* 750 */         EffectTimer ticksLeft = (EffectTimer)playerEx.getClientEffectTimers().get(Get.effects().CLAWS);
/* 751 */         float MAX_TICKS = 30.0F;
/*     */         
/*     */ 
/* 754 */         if ((ticksLeft != null) && (ticksLeft.getTicks() > 0)) {
/* 755 */           float point = -6.0F + 6.0F * (MAX_TICKS - ticksLeft.getTicks()) / MAX_TICKS;
/* 756 */           this.clawLeft.field_78797_d = point;
/* 757 */           this.clawRight.field_78797_d = point;
/*     */         }
/*     */       }
/*     */       
/* 761 */       if (this.helmetSpike1.field_78806_j) {
/* 762 */         EffectTimer ticksLeft = (EffectTimer)playerEx.getClientEffectTimers().get(Get.effects().ARMOR);
/* 763 */         float MAX_TICKS = 30.0F;
/* 764 */         if ((ticksLeft != null) && (ticksLeft.getTicks() > 0)) {
/* 765 */           float progress = (MAX_TICKS - ticksLeft.getTicks()) / MAX_TICKS;
/*     */           
/* 767 */           float point = 6.0F - 6.0F * progress;
/*     */           
/* 769 */           float scale = 1.0F;
/* 770 */           this.helmetSpike1.field_78797_d = point;
/* 771 */           this.helmetSpike1.field_78800_c = (-point / scale);
/* 772 */           this.helmetSpike2.field_78797_d = point;
/* 773 */           this.helmetSpike2.field_78800_c = (-point / scale);
/* 774 */           this.helmetSpike3.field_78797_d = point;
/* 775 */           this.helmetSpike3.field_78800_c = (-point / scale);
/*     */           
/*     */ 
/* 778 */           this.helmetSpike4.field_78797_d = point;
/* 779 */           this.helmetSpike4.field_78798_e = (-point / scale);
/* 780 */           this.helmetSpike5.field_78797_d = point;
/* 781 */           this.helmetSpike5.field_78798_e = (-point / scale);
/* 782 */           this.helmetSpike6.field_78797_d = point;
/* 783 */           this.helmetSpike6.field_78798_e = (-point / scale);
/*     */           
/* 785 */           this.helmetSpike7.field_78797_d = point;
/* 786 */           this.helmetSpike7.field_78800_c = (point / scale);
/* 787 */           this.helmetSpike8.field_78797_d = point;
/* 788 */           this.helmetSpike8.field_78800_c = (point / scale);
/* 789 */           this.helmetSpike9.field_78797_d = point;
/* 790 */           this.helmetSpike9.field_78800_c = (point / scale);
/*     */           
/* 792 */           this.shoulderLeftUpper1.field_78808_h = (-0.5009095F * progress);
/* 793 */           this.shoulderLeftUpper2.field_78808_h = (-0.7853982F * progress);
/* 794 */           this.shoulderLeftUpper3.field_78808_h = (-1.0471976F * progress);
/*     */           
/* 796 */           this.shoulderRightUpper1.field_78808_h = (0.5009095F * progress);
/* 797 */           this.shoulderRightUpper2.field_78808_h = (0.7853982F * progress);
/* 798 */           this.shoulderRightUpper3.field_78808_h = (1.0471976F * progress);
/*     */           
/* 800 */           this.chestRibFront4.field_78798_e = (point / 4.0F);
/* 801 */           this.chestRibFront8.field_78798_e = (point / 4.0F);
/*     */           
/* 803 */           this.chestRibBack2.field_78798_e = (-point / 4.0F);
/* 804 */           this.chestRibBack4.field_78798_e = (-point / 4.0F);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 816 */       climbing = (Get.effects().isActiveFor(Get.effects().UNEXPECTED, player)) && (player.field_70123_F);
/*     */     }
/*     */     
/*     */ 
/* 820 */     if (this.tendrils.field_78806_j) {
/* 821 */       float DEGREES_22_5 = 0.3926991F;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 829 */       List<Entity> list = entity.field_70170_p.func_72839_b(entity, entity.func_174813_aQ().func_72314_b(3.0D, 2.0D, 3.0D));
/*     */       
/* 831 */       float sx = 0.0F;
/* 832 */       float sy = 0.0F;
/* 833 */       float sz = 0.0F;
/*     */       
/* 835 */       Vec3 thing = null;
/* 836 */       double distSq; if (list.size() > 0) {
/* 837 */         distSq = Double.MAX_VALUE;
/* 838 */         for (Entity other : list) {
/* 839 */           double newDistSq = other.func_70068_e(entity);
/* 840 */           if (newDistSq < distSq) {
/* 841 */             thing = new Vec3(other.field_70165_t, other.field_70163_u, other.field_70161_v);
/* 842 */             distSq = newDistSq;
/*     */           }
/*     */         }
/* 845 */       } else if (climbing)
/*     */       {
/*     */ 
/* 848 */         EntityPlayer player = (EntityPlayer)entity;
/* 849 */         Vec3 lookVec = player.func_70040_Z();
/* 850 */         float maxSpeed = 1.0F;
/* 851 */         float total = Math.abs(player.field_70701_bs) + Math.abs(player.field_70702_br);
/* 852 */         float speedF = maxSpeed * (player.field_70701_bs != 0.0F ? player.field_70701_bs / total : 0.0F);
/* 853 */         float speedS = maxSpeed * (player.field_70702_br != 0.0F ? player.field_70702_br / total : 0.0F);
/* 854 */         float speedScale = 1.0F;
/* 855 */         Vec3 strafeVec = lookVec.func_178785_b(1.5707964F);
/* 856 */         double dx = (float)(lookVec.field_72450_a * speedF * speedScale + strafeVec.field_72450_a * speedS * speedScale);
/* 857 */         double dz = (float)(lookVec.field_72449_c * speedF * speedScale + strafeVec.field_72449_c * speedS * speedScale);
/* 858 */         thing = new Vec3(dx + player.field_70165_t, player.field_70163_u, dz + player.field_70161_v);
/*     */       }
/*     */       
/* 861 */       if (thing != null) {
/* 862 */         double dx = thing.field_72450_a - entity.field_70165_t;
/* 863 */         double dy = thing.field_72448_b - entity.field_70163_u;
/* 864 */         double dz = thing.field_72449_c - entity.field_70161_v;
/* 865 */         double d0 = MathHelper.func_76133_a(dx * dx + dy * dy + dz * dz);
/* 866 */         float scale = 1.5F;
/* 867 */         sx = (float)(dx / d0) * scale;
/* 868 */         sy = (float)(dy / d0) * scale;
/* 869 */         sz = (float)(dz / d0) * scale;
/*     */         
/* 871 */         Vec3 vec = new Vec3(sx, sy, sz);
/*     */         
/*     */ 
/*     */ 
/* 875 */         vec = vec.func_178785_b((float)Math.toRadians(entity.field_70177_z));
/* 876 */         sx = (float)vec.field_72450_a;
/* 877 */         sz = (float)vec.field_72449_c;
/* 878 */         sy = (float)vec.field_72448_b;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 886 */       this.tendrils.field_78797_d = 6.0F;
/*     */       
/* 888 */       this.tendrilParts[0][0].field_78808_h = 1.1780972F;
/* 889 */       this.tendrilParts[1][0].field_78808_h = 1.9634955F;
/* 890 */       this.tendrilParts[2][0].field_78808_h = -1.1780972F;
/* 891 */       this.tendrilParts[3][0].field_78808_h = -1.9634955F;
/*     */       
/* 893 */       for (int tendril = 0; tendril < this.tendrilParts.length; tendril++) {
/* 894 */         for (int part = 0; part < this.tendrilParts[tendril].length; part++) {
/* 895 */           ModelRenderer m = this.tendrilParts[tendril][part];
/* 896 */           m.field_78798_e = 0.0F;
/* 897 */           m.field_78797_d = 2.0F;
/* 898 */           m.field_78800_c = 0.0F;
/* 899 */           m.field_78797_d = (1.0F + (tendril >= 2 ? sx / 2.0F : -sx / 2.0F));
/*     */           
/* 901 */           if (part > 1) {
/* 902 */             m.field_78798_e = ((float)Math.sin((entity.field_70173_aa + part + 6 * tendril) * 0.2D) * 0.05F * part - sz * part * 0.08F);
/* 903 */             m.field_78800_c = ((float)Math.sin((entity.field_70173_aa + part + 6 * tendril) * 0.4D) * 0.05F * part + (tendril >= 2 ? sy : -sy));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelSoulArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */