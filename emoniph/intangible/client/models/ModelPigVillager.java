/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelPigVillager
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer head;
/*     */   public ModelRenderer villagerArms;
/*     */   public ModelRenderer legLeft;
/*     */   public ModelRenderer body;
/*     */   public ModelRenderer coat;
/*     */   public ModelRenderer legRight;
/*     */   public ModelRenderer snout;
/*     */   public ModelRenderer earTopRight;
/*     */   public ModelRenderer earTopLeft;
/*     */   public ModelRenderer earBottomRight;
/*     */   public ModelRenderer earBottomLeft;
/*     */   
/*     */   public ModelPigVillager(float scale)
/*     */   {
/*  33 */     this(scale, 0.0F, 64, 64);
/*     */   }
/*     */   
/*     */   public ModelPigVillager(float scale, float offsetY, int textureWidth, int textureHeight) {
/*  37 */     this.field_78090_t = textureWidth;
/*  38 */     this.field_78089_u = textureHeight;
/*     */     
/*  40 */     this.earTopRight = new ModelRenderer(this, 54, 58);
/*  41 */     this.earTopRight.func_78793_a(0.0F, 0.0F + offsetY, 0.0F);
/*  42 */     this.earTopRight.func_78790_a(-10.0F, -6.0F, -1.0F, 4, 2, 1, scale);
/*  43 */     setRotateAngle(this.earTopRight, 0.0F, 0.0F, 0.5235988F);
/*  44 */     this.legLeft = new ModelRenderer(this, 0, 22);
/*  45 */     this.legLeft.field_78809_i = true;
/*  46 */     this.legLeft.func_78793_a(2.0F, 12.0F + offsetY, 0.0F);
/*  47 */     this.legLeft.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
/*  48 */     this.snout = new ModelRenderer(this, 24, 0);
/*  49 */     this.snout.func_78793_a(0.0F, -2.0F + offsetY, 0.0F);
/*  50 */     this.snout.func_78790_a(-2.0F, -2.0F, -5.0F, 4, 3, 1, scale);
/*  51 */     this.body = new ModelRenderer(this, 16, 20);
/*  52 */     this.body.func_78793_a(0.0F, 0.0F + offsetY, 0.0F);
/*  53 */     this.body.func_78790_a(-4.0F, 0.0F, -3.0F, 8, 12, 6, scale);
/*  54 */     this.coat = new ModelRenderer(this, 0, 38);
/*  55 */     this.coat.func_78793_a(0.0F, 0.0F + offsetY, 0.0F);
/*  56 */     this.coat.func_78790_a(-4.0F, 0.0F, -3.0F, 8, 18, 6, scale + 0.5F);
/*  57 */     this.earTopLeft = new ModelRenderer(this, 54, 58);
/*  58 */     this.earTopLeft.field_78809_i = true;
/*  59 */     this.earTopLeft.func_78793_a(0.0F, 0.0F + offsetY, 0.0F);
/*  60 */     this.earTopLeft.func_78790_a(6.0F, -6.0F, -1.0F, 4, 2, 1, scale);
/*  61 */     setRotateAngle(this.earTopLeft, 0.0F, 0.0F, -0.5235988F);
/*  62 */     this.legRight = new ModelRenderer(this, 0, 22);
/*  63 */     this.legRight.func_78793_a(-2.0F, 12.0F + offsetY, 0.0F);
/*  64 */     this.legRight.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale);
/*  65 */     this.head = new ModelRenderer(this, 0, 0);
/*  66 */     this.head.func_78793_a(0.0F, 0.0F + offsetY, 0.0F);
/*  67 */     this.head.func_78790_a(-4.0F, -8.0F, -4.0F, 8, 8, 8, scale);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  72 */     this.earBottomRight = new ModelRenderer(this, 54, 61);
/*  73 */     this.earBottomRight.func_78793_a(0.0F, 0.0F + offsetY, 0.0F);
/*  74 */     this.earBottomRight.func_78790_a(-9.0F, -4.0F, -1.0F, 4, 2, 1, scale);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */     this.villagerArms = new ModelRenderer(this).func_78787_b(textureWidth, textureHeight);
/*  85 */     this.villagerArms.func_78793_a(0.0F, 0.0F + offsetY + 2.0F, 0.0F);
/*  86 */     this.villagerArms.func_78784_a(44, 22).func_78790_a(-8.0F, -2.0F, -2.0F, 4, 8, 4, scale);
/*  87 */     this.villagerArms.func_78784_a(44, 22).func_78790_a(4.0F, -2.0F, -2.0F, 4, 8, 4, scale);
/*  88 */     this.villagerArms.func_78784_a(40, 38).func_78790_a(-4.0F, 2.0F, -2.0F, 8, 4, 4, scale);
/*     */     
/*  90 */     this.earBottomLeft = new ModelRenderer(this, 54, 61);
/*  91 */     this.earBottomLeft.field_78809_i = true;
/*  92 */     this.earBottomLeft.func_78793_a(0.0F, 0.0F + offsetY, 0.0F);
/*  93 */     this.earBottomLeft.func_78790_a(5.0F, -4.0F, -1.0F, 4, 2, 1, scale);
/*  94 */     this.head.func_78792_a(this.earTopRight);
/*  95 */     this.head.func_78792_a(this.snout);
/*  96 */     this.head.func_78792_a(this.earTopLeft);
/*  97 */     this.earTopRight.func_78792_a(this.earBottomRight);
/*  98 */     this.earTopLeft.func_78792_a(this.earBottomLeft);
/*     */   }
/*     */   
/*     */   private void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 102 */     modelRenderer.field_78795_f = x;
/* 103 */     modelRenderer.field_78796_g = y;
/* 104 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
/*     */   {
/* 109 */     func_78087_a(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, entity);
/* 110 */     this.legLeft.func_78785_a(p_78088_7_);
/* 111 */     this.body.func_78785_a(p_78088_7_);
/* 112 */     this.coat.func_78785_a(p_78088_7_);
/* 113 */     this.legRight.func_78785_a(p_78088_7_);
/* 114 */     this.head.func_78785_a(p_78088_7_);
/* 115 */     this.villagerArms.func_78785_a(p_78088_7_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entity)
/*     */   {
/* 123 */     this.head.field_78796_g = (p_78087_4_ / 57.295776F);
/* 124 */     this.head.field_78795_f = (p_78087_5_ / 57.295776F);
/* 125 */     this.villagerArms.field_78797_d = 3.0F;
/* 126 */     this.villagerArms.field_78798_e = -1.0F;
/* 127 */     this.villagerArms.field_78795_f = -0.75F;
/* 128 */     this.legRight.field_78795_f = (MathHelper.func_76134_b(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_ * 0.5F);
/* 129 */     this.legLeft.field_78795_f = (MathHelper.func_76134_b(p_78087_1_ * 0.6662F + 3.1415927F) * 1.4F * p_78087_2_ * 0.5F);
/* 130 */     this.legRight.field_78796_g = 0.0F;
/* 131 */     this.legLeft.field_78796_g = 0.0F;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelPigVillager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */