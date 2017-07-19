/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.BodySide;
/*     */ import emoniph.intangible.api.golem.IGolemArm;
/*     */ import emoniph.intangible.api.golem.IGolemBody;
/*     */ import emoniph.intangible.api.golem.IGolemHead;
/*     */ import emoniph.intangible.api.golem.IGolemLeg;
/*     */ import emoniph.intangible.entity.EntityWreckingGolem;
/*     */ import emoniph.intangible.golem.GolemPartRegistry;
/*     */ import emoniph.intangible.golem.GolemPartRegistry.Part;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.multiplayer.PlayerControllerMP;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.Timer;
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
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelWreckingGolem
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer chest;
/*     */   public ModelRenderer waistLower;
/*     */   public ModelRenderer armLeft;
/*     */   public ModelRenderer legRight;
/*     */   public ModelRenderer head;
/*     */   public ModelRenderer waistUpper;
/*     */   public ModelRenderer legLeft;
/*     */   public ModelRenderer armRight;
/*     */   public ModelRenderer legRight1;
/*     */   public ModelRenderer legLeft1;
/*     */   
/*     */   public ModelWreckingGolem()
/*     */   {
/*  50 */     this.field_78090_t = 128;
/*  51 */     this.field_78089_u = 64;
/*  52 */     this.legRight = new ModelRenderer(this, 106, 0);
/*  53 */     this.legRight.func_78793_a(-4.0F, 11.0F, 1.0F);
/*  54 */     this.legRight.func_78790_a(-3.5F, -3.0F, -3.0F, 6, 9, 5, 0.0F);
/*  55 */     setRotateAngle(this.legRight, -0.68294734F, 0.0F, 0.0F);
/*  56 */     this.head = new ModelRenderer(this, 0, 0);
/*  57 */     this.head.func_78793_a(0.0F, -12.0F, -1.0F);
/*  58 */     this.head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 6, 8, 0.0F);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  77 */     this.legLeft = new ModelRenderer(this, 106, 0);
/*  78 */     this.legLeft.field_78809_i = true;
/*  79 */     this.legLeft.func_78793_a(5.0F, 11.0F, 1.0F);
/*  80 */     this.legLeft.func_78790_a(-3.5F, -3.0F, -3.0F, 6, 9, 5, 0.0F);
/*  81 */     setRotateAngle(this.legLeft, -0.68294734F, 0.0F, 0.0F);
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
/*  92 */     this.armLeft = new ModelRenderer(this, 80, 18);
/*  93 */     this.armLeft.func_78793_a(11.0F, -8.5F, 0.0F);
/*  94 */     this.armLeft.func_78790_a(0.0F, -2.5F, -3.0F, 1, 12, 6, 0.0F);
/*  95 */     setRotateAngle(this.armLeft, -1.5707964F, 0.0F, 0.0F);
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
/*     */ 
/* 117 */     this.legLeft1 = new ModelRenderer(this, 106, 14);
/* 118 */     this.legLeft1.field_78809_i = true;
/* 119 */     this.legLeft1.func_78793_a(0.0F, 11.0F, 0.0F);
/* 120 */     this.legLeft1.func_78790_a(-3.5F, -8.4F, 2.0F, 6, 9, 5, 0.0F);
/* 121 */     this.chest = new ModelRenderer(this, 0, 39);
/* 122 */     this.chest.func_78793_a(0.0F, -12.0F, 0.0F);
/* 123 */     this.chest.func_78790_a(-11.0F, -2.0F, -6.0F, 22, 14, 11, 0.0F);
/* 124 */     this.waistUpper = new ModelRenderer(this, 88, 44);
/* 125 */     this.waistUpper.func_78793_a(0.0F, -8.0F, 0.0F);
/* 126 */     this.waistUpper.func_78790_a(-6.0F, 8.5F, -4.0F, 12, 3, 8, 0.5F);
/* 127 */     this.legRight1 = new ModelRenderer(this, 106, 14);
/* 128 */     this.legRight1.func_78793_a(0.0F, 11.0F, 0.0F);
/* 129 */     this.legRight1.func_78790_a(-3.5F, -8.4F, 2.0F, 6, 9, 5, 0.0F);
/*     */     
/*     */ 
/*     */ 
/* 133 */     this.waistLower = new ModelRenderer(this, 98, 55);
/* 134 */     this.waistLower.func_78793_a(0.0F, -7.0F, 0.0F);
/* 135 */     this.waistLower.func_78790_a(-4.5F, 11.5F, -3.0F, 9, 3, 6, 0.5F);
/* 136 */     this.armRight = new ModelRenderer(this, 36, 0);
/* 137 */     this.armRight.func_78793_a(0.0F, -10.0F, 0.0F);
/* 138 */     this.armRight.func_78790_a(-15.0F, -2.5F, -2.5F, 4, 17, 5, 0.0F);
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
/*     */ 
/* 150 */     this.legLeft.func_78792_a(this.legLeft1);
/* 151 */     this.legRight.func_78792_a(this.legRight1);
/*     */   }
/*     */   
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 156 */     modelRenderer.field_78795_f = x;
/* 157 */     modelRenderer.field_78796_g = y;
/* 158 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 163 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/*     */ 
/* 166 */     EntityWreckingGolem golem = (EntityWreckingGolem)entity;
/* 167 */     Minecraft mc = Minecraft.func_71410_x();
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
/*     */ 
/*     */ 
/*     */ 
/* 181 */     if (golem.getBodyIndex() >= 0) {
/* 182 */       GolemPartRegistry.Part<IGolemBody> part = Get.golems().getBodyByIndex(golem.getBodyIndex());
/* 183 */       if (part != null) {
/* 184 */         ModelRenderer model = ((IGolemBody)part.getItem()).getModel();
/* 185 */         Minecraft.func_71410_x().func_110434_K().func_110577_a(((IGolemBody)part.getItem()).getTexture());
/* 186 */         ((IGolemBody)part.getItem()).updateModelRotation(golem, f, f1, mc.field_71428_T.field_74281_c, 0);
/* 187 */         model.func_78785_a(f5);
/*     */       }
/*     */     }
/*     */     
/* 191 */     if (((golem.field_70153_n != mc.field_71439_g) || (mc.field_71474_y.field_74320_O != 0) || (mc.field_71474_y.field_74319_N) || 
/* 192 */       (mc.field_71442_b.func_78747_a())) && 
/* 193 */       (golem.getHeadIndex() >= 0)) {
/* 194 */       GolemPartRegistry.Part<IGolemHead> part = Get.golems().getHeadByIndex(golem.getHeadIndex());
/* 195 */       if (part != null) {
/* 196 */         ModelRenderer model = ((IGolemHead)part.getItem()).getModel();
/* 197 */         model.field_78795_f = this.head.field_78795_f;
/* 198 */         model.field_78796_g = this.head.field_78796_g;
/* 199 */         Minecraft.func_71410_x().func_110434_K().func_110577_a(((IGolemHead)part.getItem()).getTexture());
/* 200 */         model.func_78785_a(f5);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 205 */     if (golem.getLeftLegIndex() >= 0) {
/* 206 */       GolemPartRegistry.Part<IGolemLeg> part = Get.golems().getLegByIndex(golem.getLeftLegIndex());
/* 207 */       if (part != null) {
/* 208 */         ModelRenderer model = ((IGolemLeg)part.getItem()).getModel(BodySide.LEFT);
/* 209 */         int attackTicks = golem.getAttackTimerLeft();
/* 210 */         mc.func_110434_K().func_110577_a(((IGolemLeg)part.getItem()).getTexture(BodySide.LEFT));
/* 211 */         ((IGolemLeg)part.getItem()).updateModelRotation(golem, f, f1, mc.field_71428_T.field_74281_c, attackTicks, BodySide.LEFT);
/* 212 */         model.func_78785_a(f5);
/*     */       }
/*     */     }
/*     */     
/* 216 */     if (golem.getRightLegIndex() >= 0) {
/* 217 */       GolemPartRegistry.Part<IGolemLeg> part = Get.golems().getLegByIndex(golem.getRightLegIndex());
/* 218 */       if (part != null) {
/* 219 */         ModelRenderer model = ((IGolemLeg)part.getItem()).getModel(BodySide.RIGHT);
/* 220 */         int attackTicks = golem.getAttackTimerRight();
/* 221 */         mc.func_110434_K().func_110577_a(((IGolemLeg)part.getItem()).getTexture(BodySide.RIGHT));
/* 222 */         ((IGolemLeg)part.getItem()).updateModelRotation(golem, f, f1, mc.field_71428_T.field_74281_c, attackTicks, BodySide.RIGHT);
/* 223 */         model.func_78785_a(f5);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 228 */     if (golem.getLeftArmIndex() >= 0) {
/* 229 */       GolemPartRegistry.Part<IGolemArm> part = Get.golems().getArmByIndex(golem.getLeftArmIndex());
/* 230 */       if (part != null) {
/* 231 */         ModelRenderer model = ((IGolemArm)part.getItem()).getModel(BodySide.LEFT);
/* 232 */         model.field_78800_c = 0.0F;
/* 233 */         int attackTicks = golem.getAttackTimerLeft();
/* 234 */         if (((IGolemArm)part.getItem()).canPoint()) {
/* 235 */           model.field_78795_f = this.head.field_78795_f;
/*     */           
/* 237 */           model.field_78796_g = this.head.field_78796_g;
/*     */         }
/*     */         
/* 240 */         mc.func_110434_K().func_110577_a(((IGolemArm)part.getItem()).getTexture(BodySide.LEFT));
/* 241 */         ((IGolemArm)part.getItem()).updateModelRotation(golem, f, f1, mc.field_71428_T.field_74281_c, attackTicks, BodySide.LEFT);
/* 242 */         model.func_78785_a(f5);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 247 */     if (golem.getRightArmIndex() >= 0) {
/* 248 */       GolemPartRegistry.Part<IGolemArm> part = Get.golems().getArmByIndex(golem.getRightArmIndex());
/* 249 */       if (part != null) {
/* 250 */         ModelRenderer model = ((IGolemArm)part.getItem()).getModel(BodySide.RIGHT);
/* 251 */         model.field_78800_c = 0.0F;
/* 252 */         int attackTicks = golem.getAttackTimerRight();
/* 253 */         if (((IGolemArm)part.getItem()).canPoint()) {
/* 254 */           model.field_78795_f = this.head.field_78795_f;
/*     */           
/* 256 */           model.field_78796_g = this.head.field_78796_g;
/*     */         }
/* 258 */         mc.func_110434_K().func_110577_a(((IGolemArm)part.getItem()).getTexture(BodySide.RIGHT));
/* 259 */         ((IGolemArm)part.getItem()).updateModelRotation(golem, f, f1, mc.field_71428_T.field_74281_c, attackTicks, BodySide.RIGHT);
/*     */         
/* 261 */         model.func_78785_a(f5);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity)
/*     */   {
/* 268 */     this.head.field_78796_g = (p_78087_4_ / 57.295776F);
/* 269 */     this.head.field_78795_f = (p_78087_5_ / 57.295776F);
/*     */   }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected float func_78172_a(float p_78172_1_, float p_78172_2_)
/*     */   {
/* 309 */     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelWreckingGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */