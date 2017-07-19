/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.deity.ModDeityEffects;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelDeityAvatar extends ModelBase
/*     */ {
/*  23 */   private static final ResourceLocation GLINT_TEXTURE_LOCATION = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  27 */     GlStateManager.func_179094_E();
/*  28 */     GlStateManager.func_179147_l();
/*     */     
/*  30 */     float modelScale = entity.field_70131_O / 1.8F;
/*     */     
/*  32 */     GlStateManager.func_179152_a(modelScale, modelScale, modelScale);
/*  33 */     GlStateManager.func_179109_b(0.0F, -(entity.field_70131_O - 1.8F) / 2.0F, 0.0F);
/*     */     
/*  35 */     float headOffsetX = 0.0F;
/*  36 */     float headOffsetY = 0.0F;
/*  37 */     float headOffsetZ = 0.0F;
/*     */     
/*  39 */     EntityAvatar avatar = (EntityAvatar)entity;
/*  40 */     java.util.UUID id = avatar.getDeityId();
/*  41 */     if (id != null)
/*     */     {
/*     */ 
/*  44 */       int color = avatar.getDeityColor();
/*     */       
/*  46 */       float r = (color >> 16 & 0xFF) / 256.0F;
/*  47 */       float g = (color >> 8 & 0xFF) / 256.0F;
/*  48 */       float b = (color & 0xFF) / 256.0F;
/*     */       
/*  50 */       boolean isDead = avatar.isIncorporeal();
/*  51 */       float deadAlpha = 0.4F;
/*     */       
/*  53 */       float bodyAlpha = 1.0F;
/*  54 */       float glintAlpha = 0.5F;
/*     */       
/*  56 */       IDeityAvatarBody body = Get.deityEffects().getAvatarBody(avatar);
/*  57 */       if (body != null) {
/*  58 */         body.applyRenderTransforms(avatar);
/*     */         
/*  60 */         ModelBase bodyModel = body.getModel(avatar);
/*  61 */         if (bodyModel != null) {
/*  62 */           bodyAlpha = body.getRenderAlpha(avatar);
/*  63 */           glintAlpha = body.getGlintAlpha(avatar);
/*     */           
/*  65 */           if (isDead) {
/*  66 */             GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, deadAlpha);
/*     */           } else {
/*  68 */             GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, bodyAlpha);
/*     */           }
/*  70 */           GlStateManager.func_179147_l();
/*  71 */           GlStateManager.func_179112_b(770, 771);
/*     */           
/*  73 */           bodyModel.func_78088_a(avatar, f, f1, f2, f3, f4, f5);
/*     */           
/*  75 */           float f9 = entity.field_70173_aa;
/*     */           
/*  77 */           if (!isDead) {
/*  78 */             Minecraft.func_71410_x().field_71446_o.func_110577_a(GLINT_TEXTURE_LOCATION);
/*     */             
/*  80 */             float f10 = 0.5F;
/*  81 */             GlStateManager.func_179131_c(f10, f10, f10, 1.0F);
/*  82 */             GlStateManager.func_179143_c(514);
/*  83 */             GlStateManager.func_179132_a(false);
/*     */             
/*  85 */             for (int k = 0; k < 1; k++) {
/*  86 */               GlStateManager.func_179140_f();
/*  87 */               float f11 = 1.0F;
/*     */               
/*  89 */               GlStateManager.func_179131_c(r * f11, g * f11, b * f11, glintAlpha);
/*     */               
/*     */ 
/*  92 */               GlStateManager.func_179112_b(770, 771);
/*  93 */               GlStateManager.func_179128_n(5890);
/*  94 */               GlStateManager.func_179096_D();
/*  95 */               float f12 = f9 * (0.001F + k * 0.003F) * 20.0F;
/*  96 */               float f13 = 0.33333334F;
/*  97 */               GlStateManager.func_179152_a(f13, f13, f13);
/*  98 */               GlStateManager.func_179114_b(30.0F - k * 60.0F, 0.0F, 0.0F, 1.0F);
/*  99 */               GlStateManager.func_179109_b(0.0F, f12, 0.0F);
/* 100 */               GlStateManager.func_179128_n(5888);
/*     */               
/* 102 */               bodyModel.func_78088_a(avatar, f, f1, f2, f3, f4, f5);
/*     */             }
/*     */             
/* 105 */             GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 106 */             GlStateManager.func_179128_n(5890);
/* 107 */             GlStateManager.func_179132_a(true);
/* 108 */             GlStateManager.func_179096_D();
/* 109 */             GlStateManager.func_179128_n(5888);
/* 110 */             GlStateManager.func_179145_e();
/* 111 */             GlStateManager.func_179084_k();
/* 112 */             GlStateManager.func_179143_c(515);
/*     */           }
/*     */         }
/* 115 */         float[] headOffset = body.getHeadOffset(avatar);
/* 116 */         if ((headOffset != null) && (headOffset.length == 3)) {
/* 117 */           headOffsetX = headOffset[0];
/* 118 */           headOffsetY = headOffset[1];
/* 119 */           headOffsetZ = headOffset[2];
/*     */         }
/*     */       }
/*     */       
/* 123 */       ModelDeityHead headModel = Get.deities().getHeadFor(avatar.field_70170_p, avatar.getDeityId());
/* 124 */       if (headModel != null) {
/* 125 */         GlStateManager.func_179140_f();
/* 126 */         GlStateManager.func_179147_l();
/* 127 */         GlStateManager.func_179112_b(770, 771);
/* 128 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/* 129 */         float scale = 1.2F;
/* 130 */         GlStateManager.func_179152_a(scale, scale, scale);
/*     */         
/* 132 */         headModel.root.field_78800_c = headOffsetX;
/* 133 */         headModel.root.field_78797_d = headOffsetY;
/* 134 */         headModel.root.field_78798_e = headOffsetZ;
/*     */         
/* 136 */         headModel.root.field_78795_f = this.headRotationX;
/* 137 */         headModel.root.field_78796_g = this.headRotationY;
/*     */         
/*     */ 
/* 140 */         if (isDead) {
/* 141 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, deadAlpha);
/*     */         } else {
/* 143 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, bodyAlpha);
/*     */         }
/* 145 */         headModel.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*     */         
/* 147 */         float f9 = entity.field_70173_aa;
/*     */         
/* 149 */         if (!isDead) {
/* 150 */           Minecraft.func_71410_x().field_71446_o.func_110577_a(new ResourceLocation("textures/misc/enchanted_item_glint.png"));
/*     */           
/* 152 */           float f10 = 0.5F;
/* 153 */           GlStateManager.func_179131_c(f10, f10, f10, 1.0F);
/* 154 */           GlStateManager.func_179143_c(514);
/* 155 */           GlStateManager.func_179132_a(false);
/*     */           
/* 157 */           for (int k = 0; k < 1; k++) {
/* 158 */             GlStateManager.func_179140_f();
/* 159 */             float f11 = 1.0F;
/*     */             
/* 161 */             GlStateManager.func_179131_c(r * f11, g * f11, b * f11, glintAlpha);
/*     */             
/* 163 */             GlStateManager.func_179112_b(768, 1);
/*     */             
/* 165 */             GlStateManager.func_179128_n(5890);
/* 166 */             GlStateManager.func_179096_D();
/* 167 */             float f12 = f9 * (0.001F + k * 0.003F) * 20.0F;
/* 168 */             float f13 = 0.33333334F;
/* 169 */             GlStateManager.func_179152_a(f13, f13, f13);
/* 170 */             GlStateManager.func_179114_b(30.0F - k * 60.0F, 0.0F, 0.0F, 1.0F);
/* 171 */             GlStateManager.func_179109_b(0.0F, f12, 0.0F);
/* 172 */             GlStateManager.func_179128_n(5888);
/*     */             
/* 174 */             headModel.func_78088_a(avatar, f, f1, f2, f3, f4, f5);
/*     */           }
/*     */           
/* 177 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 178 */           GlStateManager.func_179128_n(5890);
/* 179 */           GlStateManager.func_179132_a(true);
/* 180 */           GlStateManager.func_179096_D();
/* 181 */           GlStateManager.func_179128_n(5888);
/* 182 */           GlStateManager.func_179145_e();
/* 183 */           GlStateManager.func_179084_k();
/* 184 */           GlStateManager.func_179143_c(515);
/*     */         }
/*     */       }
/*     */     } else {
/* 188 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(new ResourceLocation("textures/misc/enchanted_item_glint.png"));
/* 189 */       this.biped.field_78091_s = false;
/* 190 */       this.biped.func_78088_a(avatar, f, f1, f2, f3, f4, f5);
/*     */     }
/*     */     
/* 193 */     GlStateManager.func_179112_b(770, 771);
/* 194 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/* 197 */   private ModelBiped biped = new ModelBiped();
/*     */   
/*     */   float headRotationX;
/*     */   float headRotationY;
/*     */   
/*     */   public void func_78087_a(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
/*     */   {
/* 204 */     super.func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */     
/* 206 */     EntityAvatar avatar = (EntityAvatar)entity;
/* 207 */     IDeityAvatarBody body = Get.deityEffects().getAvatarBody(avatar);
/* 208 */     if (body != null) {
/* 209 */       ModelBase bodyModel = body.getModel(avatar);
/* 210 */       if (bodyModel != null) {
/* 211 */         bodyModel.func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*     */       }
/*     */     }
/*     */     
/* 215 */     this.headRotationY = (f3 / 57.295776F);
/* 216 */     this.headRotationX = (f4 / 57.295776F);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_78086_a(EntityLivingBase entity, float f8, float f7, float partialTicks)
/*     */   {
/* 222 */     super.func_78086_a(entity, f8, f7, partialTicks);
/*     */     
/* 224 */     EntityAvatar avatar = (EntityAvatar)entity;
/* 225 */     IDeityAvatarBody body = Get.deityEffects().getAvatarBody(avatar);
/* 226 */     if (body != null) {
/* 227 */       ModelBase bodyModel = body.getModel(avatar);
/* 228 */       if (bodyModel != null) {
/* 229 */         bodyModel.func_78086_a(avatar, f8, f7, partialTicks);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDeityAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */