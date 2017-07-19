/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class ModelDeityBodyTentacle extends ModelBase
/*     */ {
/*     */   public ModelRenderer tendrils;
/*  16 */   public ModelRenderer[][] tendrilParts = new ModelRenderer[8][20];
/*     */   private float partialTicks;
/*     */   
/*  19 */   public ModelDeityBodyTentacle() { this.field_78090_t = 32;
/*  20 */     this.field_78089_u = 32;
/*     */     
/*  22 */     this.tendrils = new ModelRenderer(this, 0, 0);
/*  23 */     this.tendrils.func_78793_a(0.0F, 2.0F, 4.2F);
/*  24 */     this.tendrils.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
/*     */     
/*  26 */     for (int tendril = 0; tendril < this.tendrilParts.length; tendril++) {
/*  27 */       ModelRenderer lastPart = this.tendrils;
/*  28 */       for (int part = 0; part < this.tendrilParts[tendril].length; part++) {
/*  29 */         ModelRenderer partRenderer = new ModelRenderer(this, 0, 4);
/*  30 */         partRenderer.func_78793_a(0.0F, part > 0 ? 2.0F : 0.0F, 0.0F);
/*  31 */         partRenderer.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 2, 0.0F);
/*  32 */         lastPart.func_78792_a(partRenderer);
/*  33 */         lastPart = partRenderer;
/*  34 */         this.tendrilParts[tendril][part] = partRenderer;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  41 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  42 */     EntityAvatar avatar = (EntityAvatar)entity;
/*  43 */     RenderUtil.color(avatar.getDeityColor(), 0.5F);
/*  44 */     this.tendrils.func_78785_a(f5);
/*     */     
/*  46 */     int aoe = avatar.getAttackTimerAOE();
/*  47 */     int def = avatar.getDefenseTimer();
/*  48 */     if ((aoe > 0) || (def > 0)) {
/*  49 */       for (int i = 0; i < 3; i++) {
/*  50 */         ModelRenderer tmp77_74 = this.tendrils;tmp77_74.field_78808_h = ((float)(tmp77_74.field_78808_h + 1.5707963267948966D));
/*  51 */         this.tendrils.func_78785_a(f5);
/*     */       }
/*     */     }
/*  54 */     if (def > 0) {
/*  55 */       this.tendrils.field_78808_h = 0.0F;
/*  56 */       for (int i = 0; i < 3; i++) {
/*  57 */         ModelRenderer tmp131_128 = this.tendrils;tmp131_128.field_78795_f = ((float)(tmp131_128.field_78795_f + 1.5707963267948966D));
/*  58 */         this.tendrils.func_78785_a(f5);
/*     */       }
/*     */     }
/*     */     
/*  62 */     net.minecraft.client.renderer.GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_78086_a(EntityLivingBase ebtity, float p_78086_2_, float p_78086_3_, float partialTicks) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_78087_a(float timePart, float legExtentPart, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity)
/*     */   {
/*  74 */     super.func_78087_a(timePart, legExtentPart, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, entity);
/*     */     
/*  76 */     EntityAvatar avatar = (EntityAvatar)entity;
/*     */     
/*  78 */     float sx = 0.0F;
/*  79 */     float sy = 0.0F;
/*  80 */     float sz = 0.0F;
/*     */     
/*  82 */     this.tendrils.field_78797_d = 6.0F;
/*  83 */     this.tendrils.field_78795_f = 0.0F;
/*  84 */     this.tendrils.field_78808_h = 0.0F;
/*  85 */     this.tendrils.func_78793_a(0.0F, 0.0F, -1.0F);
/*     */     
/*  87 */     int i = avatar.getAttackTimerStandardRight();
/*  88 */     int j = avatar.getAttackTimerStandardLeft();
/*     */     
/*  90 */     int defStart = avatar.getDefenseTimerActivation();
/*  91 */     int def = avatar.getDefenseTimer();
/*     */     
/*     */ 
/*  94 */     float outerAngle = 0.6F;
/*  95 */     setTendril(0, 1.0F, 1.0F, -0.6F, 0.6F);
/*  96 */     setTendril(1, 1.0F, -1.0F, -0.6F, -0.6F);
/*  97 */     setTendril(2, -1.0F, 1.0F, 0.6F, 0.6F);
/*  98 */     setTendril(3, -1.0F, -1.0F, 0.6F, -0.6F);
/*     */     
/* 100 */     float innerAngle = 0.15F;
/* 101 */     setTendril(4, 1.0F, 1.0F, -0.15F, 0.15F);
/* 102 */     setTendril(5, 1.0F, -1.0F, -0.15F, -0.15F);
/* 103 */     setTendril(6, -1.0F, 1.0F, 0.15F, 0.15F);
/* 104 */     setTendril(7, -1.0F, -1.0F, 0.15F, -0.15F);
/*     */     
/* 106 */     float defNorm = def / (avatar.getBody() != null ? avatar.getBody().getDefenseDurationTicks(avatar) : 60.0F);
/* 107 */     float factor = defNorm - defNorm * defNorm;
/*     */     
/* 109 */     for (int tendril = 0; tendril < this.tendrilParts.length; tendril++) {
/* 110 */       for (int part = 0; part < this.tendrilParts[tendril].length; part++) {
/* 111 */         ModelRenderer m = this.tendrilParts[tendril][part];
/* 112 */         m.field_78797_d = 2.0F;
/* 113 */         m.field_78797_d = (0.25F * (factor * def) + 1.0F + (tendril >= 2 ? sx / 2.0F : -sx / 2.0F));
/*     */         
/* 115 */         if (part > 1) {
/* 116 */           m.field_78798_e = ((float)Math.sin((entity.field_70173_aa + part + 6 * tendril) * 0.2D) * 0.05F * part - sz * part * 0.08F);
/* 117 */           m.field_78800_c = ((float)Math.sin((entity.field_70173_aa + part + 6 * tendril) * 0.4D) * 0.05F * part + (tendril >= 2 ? sy : -sy));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 123 */     this.tendrilParts[0][0].field_78806_j = (defStart == 0);
/* 124 */     this.tendrilParts[1][0].field_78806_j = (defStart == 0);
/* 125 */     this.tendrilParts[2][0].field_78806_j = (defStart == 0);
/* 126 */     this.tendrilParts[3][0].field_78806_j = (defStart == 0);
/* 127 */     this.tendrilParts[4][0].field_78806_j = (defStart == 0);
/* 128 */     this.tendrilParts[5][0].field_78806_j = (defStart == 0);
/* 129 */     this.tendrilParts[6][0].field_78806_j = (defStart == 0);
/* 130 */     this.tendrilParts[7][0].field_78806_j = (defStart == 0);
/*     */     
/* 132 */     if (i > 0) {
/* 133 */       this.tendrilParts[3][0].field_78795_f = (-1.2F + 1.0F * func_78172_a(i - p_78087_6_, 10.0F));
/* 134 */       this.tendrilParts[3][0].field_78806_j = true;
/*     */     }
/*     */     
/*     */ 
/* 138 */     if (j > 0) {
/* 139 */       this.tendrilParts[1][0].field_78795_f = (-1.2F + 1.0F * func_78172_a(j - p_78087_6_, 10.0F));
/* 140 */       this.tendrilParts[1][0].field_78806_j = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private void setTendril(int tendril, float rotPointX, float rotPointZ, float rotAngleZ, float rotAngleX)
/*     */   {
/* 146 */     this.tendrilParts[tendril][0].field_78800_c = rotPointX;
/* 147 */     this.tendrilParts[tendril][0].field_78798_e = rotPointZ;
/* 148 */     this.tendrilParts[tendril][0].field_78808_h = rotAngleZ;
/* 149 */     this.tendrilParts[tendril][0].field_78795_f = rotAngleX;
/*     */   }
/*     */   
/*     */   private float func_78172_a(float p_78172_1_, float p_78172_2_) {
/* 153 */     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDeityBodyTentacle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */