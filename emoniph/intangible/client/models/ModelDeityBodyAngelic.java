/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelDeityBodyAngelic
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer armRight;
/*     */   public ModelRenderer legRight;
/*     */   public ModelRenderer body;
/*     */   public ModelRenderer armLeft;
/*     */   public ModelRenderer legLeft;
/*     */   public ModelRenderer kiltFront;
/*     */   public ModelRenderer wingRight;
/*     */   public ModelRenderer wingLeft;
/*     */   public ModelRenderer kiltBack;
/*     */   public ModelRenderer kiltSides1;
/*     */   public ModelRenderer kiltSides2;
/*     */   public ModelRenderer wingRightFeathersTop;
/*     */   public ModelRenderer wingRight2;
/*     */   public ModelRenderer wingRightFeathersBottom;
/*     */   public ModelRenderer wingRightFeathersBottomAlt;
/*     */   public ModelRenderer wingLeftFeathersTop;
/*     */   public ModelRenderer wingLeft2;
/*     */   public ModelRenderer wingLeftFeathersBottom;
/*     */   public ModelRenderer wingLeftFeathersBottomAlt;
/*     */   public ModelRenderer halo;
/*     */   public ModelRenderer halo2;
/*     */   public ModelRenderer halo3;
/*     */   public ModelRenderer halo4;
/*     */   
/*     */   public ModelDeityBodyAngelic()
/*     */   {
/*  47 */     this.field_78090_t = 64;
/*  48 */     this.field_78089_u = 64;
/*  49 */     this.wingRightFeathersBottom = new ModelRenderer(this, 44, 0);
/*  50 */     this.wingRightFeathersBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.wingRightFeathersBottom.func_78790_a(0.5F, 0.0F, 0.0F, 8, 27, 0, 0.0F);
/*  52 */     this.armLeft = new ModelRenderer(this, 28, 15);
/*  53 */     this.armLeft.field_78809_i = true;
/*  54 */     this.armLeft.func_78793_a(4.0F, 2.0F, 0.0F);
/*  55 */     this.armLeft.func_78790_a(0.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/*  56 */     setRotateAngle(this.armLeft, 0.0F, 0.0F, -0.10000736F);
/*  57 */     this.wingRightFeathersTop = new ModelRenderer(this, 28, 0);
/*  58 */     this.wingRightFeathersTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.wingRightFeathersTop.func_78790_a(-8.5F, -15.0F, 0.0F, 8, 15, 0, 0.0F);
/*  60 */     this.legLeft = new ModelRenderer(this, 32, 31);
/*  61 */     this.legLeft.field_78809_i = true;
/*  62 */     this.legLeft.func_78793_a(1.9F, 12.0F, 0.1F);
/*  63 */     this.legLeft.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  64 */     this.kiltBack = new ModelRenderer(this, 0, 34);
/*  65 */     this.kiltBack.func_78793_a(0.0F, 11.5F, 0.0F);
/*  66 */     this.kiltBack.func_78790_a(-4.5F, 0.0F, -2.5F, 9, 12, 5, 0.0F);
/*  67 */     setRotateAngle(this.kiltBack, 1.0471976F, 0.0F, 0.0F);
/*  68 */     this.wingLeftFeathersTop = new ModelRenderer(this, 28, 0);
/*  69 */     this.wingLeftFeathersTop.field_78809_i = true;
/*  70 */     this.wingLeftFeathersTop.func_78793_a(0.0F, 0.0F, 0.0F);
/*  71 */     this.wingLeftFeathersTop.func_78790_a(0.5F, -15.0F, 0.0F, 8, 15, 0, 0.0F);
/*  72 */     this.wingLeftFeathersBottomAlt = new ModelRenderer(this, 48, 37);
/*  73 */     this.wingLeftFeathersBottomAlt.field_78809_i = true;
/*  74 */     this.wingLeftFeathersBottomAlt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  75 */     this.wingLeftFeathersBottomAlt.func_78790_a(-8.5F, 0.0F, 0.0F, 8, 27, 0, 0.0F);
/*  76 */     this.body = new ModelRenderer(this, 24, 48);
/*  77 */     this.body.func_78793_a(0.0F, 0.0F, 0.0F);
/*  78 */     this.body.func_78790_a(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
/*  79 */     this.wingRightFeathersBottomAlt = new ModelRenderer(this, 48, 37);
/*  80 */     this.wingRightFeathersBottomAlt.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.wingRightFeathersBottomAlt.func_78790_a(0.5F, 0.0F, 0.0F, 8, 27, 0, 0.0F);
/*  82 */     this.kiltFront = new ModelRenderer(this, 0, 0);
/*  83 */     this.kiltFront.func_78793_a(0.0F, 11.5F, 0.1F);
/*  84 */     this.kiltFront.func_78790_a(-4.5F, 0.0F, -2.5F, 9, 12, 5, 0.0F);
/*  85 */     setRotateAngle(this.kiltFront, -0.5462881F, 0.0F, 0.0F);
/*  86 */     this.legRight = new ModelRenderer(this, 32, 31);
/*  87 */     this.legRight.func_78793_a(-1.9F, 12.0F, 0.1F);
/*  88 */     this.legRight.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
/*  89 */     this.wingLeft2 = new ModelRenderer(this, 60, 0);
/*  90 */     this.wingLeft2.field_78809_i = true;
/*  91 */     this.wingLeft2.func_78793_a(0.0F, -15.0F, 0.0F);
/*  92 */     this.wingLeft2.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 27, 1, 0.0F);
/*  93 */     setRotateAngle(this.wingLeft2, 0.0F, 0.0F, -0.5462881F);
/*  94 */     this.wingLeftFeathersBottom = new ModelRenderer(this, 44, 0);
/*  95 */     this.wingLeftFeathersBottom.field_78809_i = true;
/*  96 */     this.wingLeftFeathersBottom.func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */     this.wingLeftFeathersBottom.func_78790_a(-8.5F, 0.0F, 0.0F, 8, 27, 0, 0.0F);
/*  98 */     this.armRight = new ModelRenderer(this, 28, 15);
/*  99 */     this.armRight.func_78793_a(-5.0F, 2.0F, 0.0F);
/* 100 */     this.armRight.func_78790_a(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
/* 101 */     setRotateAngle(this.armRight, 0.0F, 0.0F, 0.10000736F);
/* 102 */     this.wingRight = new ModelRenderer(this, 60, 0);
/* 103 */     this.wingRight.func_78793_a(-1.5F, 1.0F, 2.5F);
/* 104 */     this.wingRight.func_78790_a(-0.5F, -15.0F, -0.5F, 1, 15, 1, 0.0F);
/* 105 */     setRotateAngle(this.wingRight, -0.13665928F, 0.22759093F, -1.1838568F);
/* 106 */     this.kiltSides1 = new ModelRenderer(this, 0, 17);
/* 107 */     this.kiltSides1.func_78793_a(0.0F, 11.5F, 0.0F);
/* 108 */     this.kiltSides1.func_78790_a(-4.5F, 0.0F, -2.5F, 9, 12, 5, 0.0F);
/* 109 */     setRotateAngle(this.kiltSides1, 0.5462881F, 0.0F, 0.0F);
/*     */     
/* 111 */     this.kiltSides2 = new ModelRenderer(this, 0, 17);
/* 112 */     this.kiltSides2.func_78793_a(0.0F, 11.5F, 0.0F);
/* 113 */     this.kiltSides2.func_78790_a(-4.5F, 0.0F, -2.5F, 9, 12, 5, 0.0F);
/* 114 */     setRotateAngle(this.kiltSides2, 0.5462881F, 0.0F, 0.0F);
/*     */     
/* 116 */     this.wingLeft = new ModelRenderer(this, 60, 0);
/* 117 */     this.wingLeft.field_78809_i = true;
/* 118 */     this.wingLeft.func_78793_a(1.5F, 1.0F, 2.5F);
/* 119 */     this.wingLeft.func_78790_a(-0.5F, -15.0F, -0.5F, 1, 15, 1, 0.0F);
/* 120 */     setRotateAngle(this.wingLeft, -0.13665928F, -0.22759093F, 0.3642502F);
/* 121 */     this.wingRight2 = new ModelRenderer(this, 60, 0);
/* 122 */     this.wingRight2.func_78793_a(0.0F, -15.0F, 0.0F);
/* 123 */     this.wingRight2.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 27, 1, 0.0F);
/* 124 */     setRotateAngle(this.wingRight2, 0.0F, 0.0F, 2.5041983F);
/*     */     
/* 126 */     this.halo = new ModelRenderer(this, 0, 55);
/* 127 */     this.halo.func_78793_a(0.0F, -12.0F, 0.0F);
/* 128 */     this.halo.func_78790_a(-5.0F, -0.5F, -4.0F, 1, 1, 8, 0.0F);
/*     */     
/* 130 */     this.halo2 = new ModelRenderer(this, 0, 55);
/* 131 */     this.halo2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 132 */     this.halo2.func_78790_a(-5.0F, -0.5F, -4.0F, 1, 1, 8, 0.0F);
/* 133 */     setRotateAngle(this.halo2, 0.0F, 1.5707964F, 0.0F);
/*     */     
/* 135 */     this.halo3 = new ModelRenderer(this, 0, 55);
/* 136 */     this.halo3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 137 */     this.halo3.func_78790_a(-5.0F, -0.5F, -4.0F, 1, 1, 8, 0.0F);
/* 138 */     setRotateAngle(this.halo3, 0.0F, 3.1415927F, 0.0F);
/*     */     
/* 140 */     this.halo4 = new ModelRenderer(this, 0, 55);
/* 141 */     this.halo4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 142 */     this.halo4.func_78790_a(-5.0F, -0.5F, -4.0F, 1, 1, 8, 0.0F);
/* 143 */     setRotateAngle(this.halo4, 0.0F, -1.5707964F, 0.0F);
/*     */     
/* 145 */     this.halo.func_78792_a(this.halo2);
/* 146 */     this.halo.func_78792_a(this.halo3);
/* 147 */     this.halo.func_78792_a(this.halo4);
/*     */     
/* 149 */     this.wingRight2.func_78792_a(this.wingRightFeathersBottom);
/* 150 */     this.wingRight.func_78792_a(this.wingRightFeathersTop);
/*     */     
/* 152 */     this.wingLeft.func_78792_a(this.wingLeftFeathersTop);
/* 153 */     this.wingLeft2.func_78792_a(this.wingLeftFeathersBottomAlt);
/* 154 */     this.wingRight2.func_78792_a(this.wingRightFeathersBottomAlt);
/* 155 */     this.wingLeft.func_78792_a(this.wingLeft2);
/* 156 */     this.wingLeft2.func_78792_a(this.wingLeftFeathersBottom);
/*     */     
/* 158 */     this.wingRight.func_78792_a(this.wingRight2);
/*     */   }
/*     */   
/*     */   private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 162 */     modelRenderer.field_78795_f = x;
/* 163 */     modelRenderer.field_78796_g = y;
/* 164 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
/*     */   {
/* 169 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, entity);
/*     */     
/* 171 */     GlStateManager.func_179094_E();
/* 172 */     EntityAvatar avatar = (EntityAvatar)entity;
/* 173 */     IDeityAvatarBody avatarBody = avatar.getBody();
/*     */     
/* 175 */     if ((avatarBody != null) && (avatar.getDefenseTimerActivation() > 0)) {
/* 176 */       this.halo.func_78785_a(p_78088_7_);
/*     */     }
/*     */     
/* 179 */     this.armLeft.func_78785_a(p_78088_7_);
/* 180 */     this.legLeft.func_78785_a(p_78088_7_);
/* 181 */     this.body.func_78785_a(p_78088_7_);
/* 182 */     this.kiltFront.func_78785_a(p_78088_7_);
/* 183 */     float kiltScale = 1.001F;
/* 184 */     GlStateManager.func_179152_a(kiltScale, kiltScale, kiltScale);
/* 185 */     this.kiltSides1.func_78785_a(p_78088_7_);
/* 186 */     GlStateManager.func_179152_a(kiltScale, kiltScale, kiltScale);
/* 187 */     this.kiltSides2.func_78785_a(p_78088_7_);
/* 188 */     GlStateManager.func_179152_a(kiltScale, kiltScale, kiltScale);
/* 189 */     this.kiltBack.func_78785_a(p_78088_7_);
/* 190 */     float kiltDecale = 1.0F / (kiltScale * kiltScale * kiltScale);
/* 191 */     GlStateManager.func_179152_a(kiltDecale, kiltDecale, kiltDecale);
/*     */     
/* 193 */     this.legRight.func_78785_a(p_78088_7_);
/* 194 */     this.armRight.func_78785_a(p_78088_7_);
/*     */     
/* 196 */     GlStateManager.func_179089_o();
/*     */     
/* 198 */     this.wingRight.func_78785_a(p_78088_7_);
/* 199 */     this.wingLeft.func_78785_a(p_78088_7_);
/* 200 */     GlStateManager.func_179107_e(1029);
/* 201 */     GlStateManager.func_179129_p();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 206 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity)
/*     */   {
/* 211 */     EntityAvatar avatar = (EntityAvatar)entity;
/*     */     
/* 213 */     this.armRight.field_78795_f = (MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 2.0F * p_78087_2_ * 0.5F);
/* 214 */     this.armLeft.field_78795_f = (MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 2.0F * p_78087_2_ * 0.5F);
/* 215 */     this.armRight.field_78808_h = 0.0F;
/* 216 */     this.armLeft.field_78808_h = 0.0F;
/* 217 */     this.legRight.field_78795_f = (MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_);
/* 218 */     this.legLeft.field_78795_f = (MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_);
/* 219 */     this.legRight.field_78796_g = 0.0F;
/* 220 */     this.legLeft.field_78796_g = 0.0F;
/*     */     
/* 222 */     this.armRight.field_78796_g = 0.0F;
/* 223 */     this.armRight.field_78808_h = 0.0F;
/*     */     
/* 225 */     this.armLeft.field_78796_g = 0.0F;
/*     */     
/* 227 */     this.body.field_78795_f = 0.0F;
/* 228 */     this.legRight.field_78798_e = 0.1F;
/* 229 */     this.legLeft.field_78798_e = 0.1F;
/* 230 */     this.legRight.field_78797_d = 12.0F;
/* 231 */     this.legLeft.field_78797_d = 12.0F;
/*     */     
/*     */ 
/* 234 */     this.armRight.field_78808_h += MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 235 */     this.armLeft.field_78808_h -= MathHelper.func_76134_b(p_78087_3_ * 0.09F) * 0.05F + 0.05F;
/* 236 */     this.armRight.field_78795_f += MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/* 237 */     this.armLeft.field_78795_f -= MathHelper.func_76126_a(p_78087_3_ * 0.067F) * 0.05F;
/*     */     
/* 239 */     int i = avatar.getAttackTimerStandardRight();
/* 240 */     if (i > 0) {
/* 241 */       this.armRight.field_78795_f = (-1.0F + 1.5F * func_78172_a(i - p_78087_6_, 10.0F));
/*     */     }
/*     */     
/* 244 */     i = avatar.getAttackTimerStandardLeft();
/* 245 */     if (i > 0) {
/* 246 */       this.armLeft.field_78795_f = (-1.0F + 1.5F * func_78172_a(i - p_78087_6_, 10.0F));
/*     */     }
/*     */     
/* 249 */     this.kiltBack.field_78795_f = Math.max(this.legRight.field_78795_f, this.legLeft.field_78795_f);
/* 250 */     this.kiltSides1.field_78795_f = (Math.max(this.legRight.field_78795_f, this.legLeft.field_78795_f) * 0.35F);
/*     */     
/* 252 */     this.kiltFront.field_78795_f = Math.min(this.legRight.field_78795_f, this.legLeft.field_78795_f);
/* 253 */     this.kiltSides2.field_78795_f = (Math.min(this.legRight.field_78795_f, this.legLeft.field_78795_f) * 0.35F);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 258 */     float attackTicks = 0.0F;
/* 259 */     float maxAttackTicks = 0.0F;
/* 260 */     IDeityAvatarBody body = avatar.getBody();
/* 261 */     if (body != null) {
/* 262 */       attackTicks = avatar.getAttackTimerAOE();
/* 263 */       maxAttackTicks = body.getAttackAnimationTicksAOE(avatar);
/* 264 */       if (attackTicks == 0.0F) {
/* 265 */         attackTicks = avatar.getAttackTimerProjectile();
/* 266 */         maxAttackTicks = body.getAttackAnimationTicksProjectile(avatar);
/*     */       }
/*     */     }
/*     */     
/* 270 */     float max = 10.0F;
/*     */     
/* 272 */     float wingExtend = attackTicks > maxAttackTicks - 10.0F ? (maxAttackTicks - attackTicks) / 10.0F : attackTicks < 10.0F ? attackTicks / 10.0F : 1.0F;
/*     */     
/* 274 */     if (wingExtend > 0.25D) {
/* 275 */       this.wingLeftFeathersTop.field_78806_j = (this.wingRightFeathersTop.field_78806_j = 1);
/* 276 */       this.wingLeftFeathersBottom.field_78806_j = (this.wingRightFeathersBottom.field_78806_j = 1);
/* 277 */       this.wingLeftFeathersBottomAlt.field_78806_j = (this.wingRightFeathersBottomAlt.field_78806_j = 0);
/*     */     } else {
/* 279 */       this.wingLeftFeathersTop.field_78806_j = (this.wingRightFeathersTop.field_78806_j = 0);
/* 280 */       this.wingLeftFeathersBottom.field_78806_j = (this.wingRightFeathersBottom.field_78806_j = 0);
/* 281 */       this.wingLeftFeathersBottomAlt.field_78806_j = (this.wingRightFeathersBottomAlt.field_78806_j = 1);
/*     */     }
/*     */     
/* 284 */     this.wingLeftFeathersTop.field_78798_e = 0.001F;
/* 285 */     this.wingRightFeathersTop.field_78798_e = 0.001F;
/* 286 */     if (wingExtend == 0.0F) {
/* 287 */       setRotateAngle(this.wingLeft, -0.13665928F, -0.22759093F, 0.3642502F);
/* 288 */       setRotateAngle(this.wingLeft2, 0.0F, 0.0F, -0.5462881F);
/*     */       
/*     */ 
/* 291 */       setRotateAngle(this.wingRight, -0.13665928F, 0.22759093F, -0.3642502F);
/* 292 */       setRotateAngle(this.wingRight2, 0.0F, 0.0F, 0.5462881F);
/*     */     } else {
/* 294 */       this.wingLeft.field_78808_h = (0.3642502F + 1.0F * wingExtend);
/* 295 */       this.wingLeft2.field_78808_h = (-0.5462881F - 2.0F * wingExtend);
/*     */       
/* 297 */       this.wingRight.field_78808_h = (-1.0F * this.wingLeft.field_78808_h);
/* 298 */       this.wingRight2.field_78808_h = (-1.0F * this.wingLeft2.field_78808_h);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_78086_a(EntityLivingBase p_78086_1_, float p_78086_2_, float p_78086_3_, float p_78086_4_) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private float func_78172_a(float p_78172_1_, float p_78172_2_)
/*     */   {
/* 314 */     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDeityBodyAngelic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */