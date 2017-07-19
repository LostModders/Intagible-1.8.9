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
/*     */ public class ModelSyntheticResonator
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer baseLower;
/*     */   public ModelRenderer baseUpper;
/*     */   public ModelRenderer top;
/*     */   public ModelRenderer core1;
/*     */   public ModelRenderer core2;
/*     */   public ModelRenderer arm1;
/*     */   public ModelRenderer arm2;
/*     */   public ModelRenderer arm3;
/*     */   public ModelRenderer arm4;
/*     */   public ModelRenderer armEnd1;
/*     */   public ModelRenderer armEnd2;
/*     */   public ModelRenderer armEnd3;
/*     */   public ModelRenderer armEnd4;
/*     */   
/*     */   public ModelSyntheticResonator()
/*     */   {
/*  30 */     this.field_78090_t = 32;
/*  31 */     this.field_78089_u = 32;
/*  32 */     this.core2 = new ModelRenderer(this, 0, 12);
/*  33 */     this.core2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.core2.func_78790_a(-1.0F, 1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  35 */     setRotateAngle(this.core2, 0.0F, 0.7853982F, 0.0F);
/*  36 */     this.arm1 = new ModelRenderer(this, 0, 0);
/*  37 */     this.arm1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  38 */     this.arm1.func_78790_a(-4.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
/*  39 */     this.core1 = new ModelRenderer(this, 0, 12);
/*  40 */     this.core1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  41 */     this.core1.func_78790_a(-1.0F, 1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  42 */     this.armEnd3 = new ModelRenderer(this, 9, 0);
/*  43 */     this.armEnd3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  44 */     this.armEnd3.func_78790_a(-6.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  45 */     setRotateAngle(this.armEnd3, 0.7853982F, 0.0F, 0.0F);
/*  46 */     this.armEnd4 = new ModelRenderer(this, 9, 0);
/*  47 */     this.armEnd4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.armEnd4.func_78790_a(-6.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  49 */     setRotateAngle(this.armEnd4, 0.7853982F, 0.0F, 0.0F);
/*  50 */     this.arm3 = new ModelRenderer(this, 0, 0);
/*  51 */     this.arm3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  52 */     this.arm3.func_78790_a(-4.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
/*  53 */     setRotateAngle(this.arm3, 0.0F, 3.1415927F, 0.0F);
/*  54 */     this.top = new ModelRenderer(this, 0, 6);
/*  55 */     this.top.func_78793_a(0.0F, 18.0F, 0.0F);
/*  56 */     this.top.func_78790_a(-1.5F, -1.0F, -1.5F, 3, 2, 3, 0.0F);
/*  57 */     this.armEnd1 = new ModelRenderer(this, 9, 0);
/*  58 */     this.armEnd1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  59 */     this.armEnd1.func_78790_a(-6.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  60 */     setRotateAngle(this.armEnd1, 0.7853982F, 0.0F, 0.0F);
/*  61 */     this.armEnd2 = new ModelRenderer(this, 9, 0);
/*  62 */     this.armEnd2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.armEnd2.func_78790_a(-6.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F);
/*  64 */     setRotateAngle(this.armEnd2, 0.7853982F, 0.0F, 0.0F);
/*  65 */     this.baseLower = new ModelRenderer(this, 0, 24);
/*  66 */     this.baseLower.func_78793_a(0.0F, 22.0F, 0.0F);
/*  67 */     this.baseLower.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
/*  68 */     this.arm2 = new ModelRenderer(this, 0, 0);
/*  69 */     this.arm2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  70 */     this.arm2.func_78790_a(-4.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
/*  71 */     setRotateAngle(this.arm2, 0.0F, 1.5707964F, -0.17453292F);
/*  72 */     this.baseUpper = new ModelRenderer(this, 0, 17);
/*  73 */     this.baseUpper.func_78793_a(0.0F, 22.0F, 0.0F);
/*  74 */     this.baseUpper.func_78790_a(-2.5F, -1.0F, -2.5F, 5, 1, 5, 0.0F);
/*  75 */     this.arm4 = new ModelRenderer(this, 0, 0);
/*  76 */     this.arm4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.arm4.func_78790_a(-4.0F, -0.5F, -0.5F, 3, 1, 1, 0.0F);
/*  78 */     setRotateAngle(this.arm4, 0.0F, -1.5707964F, 0.0F);
/*  79 */     this.top.func_78792_a(this.core2);
/*  80 */     this.top.func_78792_a(this.arm1);
/*  81 */     this.top.func_78792_a(this.core1);
/*  82 */     this.arm3.func_78792_a(this.armEnd3);
/*  83 */     this.arm4.func_78792_a(this.armEnd4);
/*  84 */     this.top.func_78792_a(this.arm3);
/*  85 */     this.arm1.func_78792_a(this.armEnd1);
/*  86 */     this.arm2.func_78792_a(this.armEnd2);
/*  87 */     this.top.func_78792_a(this.arm2);
/*  88 */     this.top.func_78792_a(this.arm4);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  93 */     this.top.func_78785_a(f5);
/*  94 */     this.baseLower.func_78785_a(f5);
/*  95 */     this.baseUpper.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 102 */     modelRenderer.field_78795_f = x;
/* 103 */     modelRenderer.field_78796_g = y;
/* 104 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelSyntheticResonator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */