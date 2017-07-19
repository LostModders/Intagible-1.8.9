/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class ModelReaper extends ModelBase
/*     */ {
/*     */   ModelRenderer bipedHead;
/*     */   ModelRenderer bipedBody;
/*     */   ModelRenderer bipedRightArm;
/*     */   ModelRenderer bipedLeftArm;
/*     */   ModelRenderer bipedRightLeg;
/*     */   ModelRenderer bipedLeftLeg;
/*     */   ModelRenderer robe;
/*     */   ModelRenderer scythe;
/*     */   
/*     */   public ModelReaper()
/*     */   {
/*  25 */     this.field_78090_t = 64;
/*  26 */     this.field_78089_u = 64;
/*  27 */     func_78085_a("scythe.shaft", 58, 5);
/*  28 */     func_78085_a("scythe.blade", 36, 0);
/*     */     
/*  30 */     this.bipedHead = new ModelRenderer(this, 27, 43);
/*  31 */     this.bipedHead.func_78789_a(-4.0F, -8.0F, -4.0F, 8, 10, 8);
/*  32 */     this.bipedHead.func_78793_a(0.0F, 0.0F, 0.0F);
/*  33 */     this.bipedHead.func_78787_b(64, 64);
/*  34 */     this.bipedHead.field_78809_i = true;
/*  35 */     setRotation(this.bipedHead, 0.0F, 0.0F, 0.0F);
/*  36 */     this.bipedBody = new ModelRenderer(this, 16, 16);
/*  37 */     this.bipedBody.func_78789_a(-4.0F, 0.0F, -2.0F, 8, 12, 4);
/*  38 */     this.bipedBody.func_78793_a(0.0F, 0.0F, 0.0F);
/*  39 */     this.bipedBody.func_78787_b(64, 64);
/*  40 */     this.bipedBody.field_78809_i = true;
/*  41 */     setRotation(this.bipedBody, 0.0F, 0.0F, 0.0F);
/*  42 */     this.bipedRightArm = new ModelRenderer(this, 40, 16);
/*  43 */     this.bipedRightArm.func_78789_a(-3.0F, -2.0F, -2.0F, 4, 12, 4);
/*  44 */     this.bipedRightArm.func_78793_a(-5.0F, 2.0F, 0.0F);
/*  45 */     this.bipedRightArm.func_78787_b(64, 64);
/*  46 */     this.bipedRightArm.field_78809_i = true;
/*  47 */     setRotation(this.bipedRightArm, 0.0F, 0.0F, 0.0F);
/*  48 */     this.bipedLeftArm = new ModelRenderer(this, 40, 16);
/*  49 */     this.bipedLeftArm.func_78789_a(-1.0F, -2.0F, -2.0F, 4, 12, 4);
/*  50 */     this.bipedLeftArm.func_78793_a(5.0F, 2.0F, 0.0F);
/*  51 */     this.bipedLeftArm.func_78787_b(64, 64);
/*  52 */     this.bipedLeftArm.field_78809_i = true;
/*  53 */     setRotation(this.bipedLeftArm, 0.0F, 0.0F, 0.0F);
/*  54 */     this.bipedRightLeg = new ModelRenderer(this, 0, 16);
/*  55 */     this.bipedRightLeg.func_78789_a(-1.0F, 0.0F, -1.0F, 2, 12, 2);
/*  56 */     this.bipedRightLeg.func_78793_a(-2.0F, 12.0F, 0.0F);
/*  57 */     this.bipedRightLeg.func_78787_b(64, 64);
/*  58 */     this.bipedRightLeg.field_78809_i = true;
/*  59 */     setRotation(this.bipedRightLeg, 0.0F, 0.0F, 0.0F);
/*  60 */     this.bipedLeftLeg = new ModelRenderer(this, 0, 16);
/*  61 */     this.bipedLeftLeg.func_78789_a(-1.0F, 0.0F, -1.0F, 2, 12, 2);
/*  62 */     this.bipedLeftLeg.func_78793_a(2.0F, 12.0F, 0.0F);
/*  63 */     this.bipedLeftLeg.func_78787_b(64, 64);
/*  64 */     this.bipedLeftLeg.field_78809_i = true;
/*  65 */     setRotation(this.bipedLeftLeg, 0.0F, 0.0F, 0.0F);
/*  66 */     this.robe = new ModelRenderer(this, 0, 33);
/*  67 */     this.robe.func_78789_a(-4.0F, 0.0F, -2.5F, 8, 23, 5);
/*  68 */     this.robe.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.robe.func_78787_b(64, 64);
/*  70 */     this.robe.field_78809_i = true;
/*  71 */     setRotation(this.robe, 0.0F, 0.0F, 0.0F);
/*  72 */     this.scythe = new ModelRenderer(this, "scythe");
/*  73 */     this.scythe.func_78793_a(-6.0F, 10.0F, 0.0F);
/*  74 */     setRotation(this.scythe, 0.0F, 0.0F, 0.0F);
/*  75 */     this.scythe.field_78809_i = true;
/*  76 */     this.scythe.func_78786_a("shaft", -0.5F, -16.0F, -0.5F, 1, 35, 1);
/*  77 */     this.scythe.func_78786_a("blade", 0.0F, -16.0F, 0.0F, 13, 4, 0);
/*  78 */     this.bipedRightArm.func_78792_a(this.scythe);
/*     */   }
/*     */   
/*     */   private void setRotation(ModelRenderer model, float x, float y, float z) {
/*  82 */     model.field_78795_f = x;
/*  83 */     model.field_78796_g = y;
/*  84 */     model.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  89 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*  90 */     func_78087_a(f, f1, f2, f3, f4, f5, entity);
/*  91 */     GlStateManager.func_179094_E();
/*  92 */     float scale = 0.5F;
/*  93 */     GlStateManager.func_179137_b(0.0D, 1.6D * scale, 0.0D);
/*  94 */     GlStateManager.func_179152_a(scale, scale, scale);
/*     */     
/*  96 */     this.bipedHead.func_78785_a(f5);
/*  97 */     this.bipedBody.func_78785_a(f5);
/*  98 */     this.bipedRightArm.func_78785_a(f5);
/*  99 */     this.bipedLeftArm.func_78785_a(f5);
/* 100 */     this.bipedRightLeg.func_78785_a(f5);
/* 101 */     this.bipedLeftLeg.func_78785_a(f5);
/* 102 */     GL11.glScalef(1.05F, 1.0F, 1.05F);
/* 103 */     this.robe.func_78785_a(f5);
/* 104 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_78087_a(float par1, float par2, float par3, float par4, float par5, float par6, Entity par7Entity)
/*     */   {
/* 111 */     this.scythe.field_78800_c = -0.8F;
/* 112 */     this.scythe.field_78798_e = 0.0F;
/* 113 */     this.scythe.field_78797_d = 8.1F;
/* 114 */     this.scythe.field_78795_f = 1.5707964F;
/*     */     
/* 116 */     this.bipedHead.field_78796_g = (par4 / 57.295776F);
/* 117 */     this.bipedHead.field_78795_f = (par5 / 57.295776F);
/*     */     
/* 119 */     this.bipedRightArm.field_78795_f = (MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 2.0F * par2 * 0.5F - 1.5707964F);
/* 120 */     this.bipedLeftArm.field_78795_f = (MathHelper.func_76134_b(par1 * 0.6662F) * 2.0F * par2 * 0.5F);
/* 121 */     this.bipedRightArm.field_78808_h = 0.0F;
/* 122 */     this.bipedLeftArm.field_78808_h = 0.0F;
/* 123 */     this.bipedRightLeg.field_78795_f = (MathHelper.func_76134_b(par1 * 0.6662F) * 1.4F * par2);
/* 124 */     this.bipedLeftLeg.field_78795_f = (MathHelper.func_76134_b(par1 * 0.6662F + 3.1415927F) * 1.4F * par2);
/* 125 */     this.bipedRightLeg.field_78796_g = 0.0F;
/* 126 */     this.bipedLeftLeg.field_78796_g = 0.0F;
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
/* 144 */     this.bipedRightArm.field_78796_g = 0.0F;
/* 145 */     this.bipedLeftArm.field_78796_g = 0.0F;
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
/* 170 */     this.bipedBody.field_78795_f = 0.0F;
/* 171 */     this.bipedRightLeg.field_78798_e = 0.1F;
/* 172 */     this.bipedLeftLeg.field_78798_e = 0.1F;
/* 173 */     this.bipedRightLeg.field_78797_d = 12.0F;
/* 174 */     this.bipedLeftLeg.field_78797_d = 12.0F;
/* 175 */     this.bipedHead.field_78797_d = 0.0F;
/*     */     
/* 177 */     this.bipedRightArm.field_78808_h += MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 178 */     this.bipedLeftArm.field_78808_h -= MathHelper.func_76134_b(par3 * 0.09F) * 0.05F + 0.05F;
/* 179 */     this.bipedRightArm.field_78795_f += MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/* 180 */     this.bipedLeftArm.field_78795_f -= MathHelper.func_76126_a(par3 * 0.067F) * 0.05F;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelReaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */