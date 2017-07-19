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
/*     */ public class ModelGolemFactory
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer floorUpper;
/*     */   public ModelRenderer floorLower;
/*     */   public ModelRenderer strutRight;
/*     */   public ModelRenderer strutLeft;
/*     */   public ModelRenderer strutMid;
/*     */   public ModelRenderer boxBack;
/*     */   public ModelRenderer roofRight;
/*     */   public ModelRenderer roofLeft;
/*     */   public ModelRenderer roofMid;
/*     */   public ModelRenderer shape37;
/*     */   public ModelRenderer shape37_1;
/*     */   public ModelRenderer shape37_2;
/*     */   public ModelRenderer shape37_3;
/*     */   
/*     */   public ModelGolemFactory()
/*     */   {
/*  30 */     this.field_78090_t = 64;
/*  31 */     this.field_78089_u = 64;
/*  32 */     this.strutRight = new ModelRenderer(this, 0, 0);
/*  33 */     this.strutRight.func_78793_a(0.0F, 0.0F, 0.0F);
/*  34 */     this.strutRight.func_78790_a(-7.5F, -26.0F, 5.0F, 2, 49, 2, 0.0F);
/*  35 */     this.shape37_3 = new ModelRenderer(this, 12, 0);
/*  36 */     this.shape37_3.func_78793_a(0.0F, 2.7F, 0.0F);
/*  37 */     this.shape37_3.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
/*  38 */     setRotateAngle(this.shape37_3, -0.34906584F, 0.0F, 0.7853982F);
/*  39 */     this.shape37_1 = new ModelRenderer(this, 12, 0);
/*  40 */     this.shape37_1.func_78793_a(3.5F, -4.0F, 6.0F);
/*  41 */     this.shape37_1.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
/*  42 */     setRotateAngle(this.shape37_1, 0.0F, -0.7853982F, 0.0F);
/*  43 */     this.floorLower = new ModelRenderer(this, 0, 47);
/*  44 */     this.floorLower.func_78793_a(0.0F, 0.0F, 0.0F);
/*  45 */     this.floorLower.func_78790_a(-8.0F, 23.0F, -8.0F, 16, 1, 16, 0.0F);
/*  46 */     this.strutMid = new ModelRenderer(this, 0, 0);
/*  47 */     this.strutMid.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.strutMid.func_78790_a(-1.0F, -26.0F, 5.5F, 2, 49, 2, 0.0F);
/*  49 */     this.roofMid = new ModelRenderer(this, 12, 0);
/*  50 */     this.roofMid.func_78793_a(0.0F, 0.0F, 0.0F);
/*  51 */     this.roofMid.func_78790_a(-5.0F, -28.0F, -8.0F, 10, 2, 16, 0.0F);
/*  52 */     this.boxBack = new ModelRenderer(this, 32, 19);
/*  53 */     this.boxBack.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.boxBack.func_78790_a(-6.0F, -11.0F, 4.0F, 12, 7, 4, 0.0F);
/*  55 */     this.floorUpper = new ModelRenderer(this, 8, 31);
/*  56 */     this.floorUpper.func_78793_a(0.0F, 0.0F, 0.0F);
/*  57 */     this.floorUpper.func_78790_a(-7.0F, 22.0F, -6.6F, 14, 1, 14, 0.0F);
/*  58 */     this.roofRight = new ModelRenderer(this, 12, 0);
/*  59 */     this.roofRight.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.roofRight.func_78790_a(-4.7F, -27.9F, -7.95F, 10, 2, 16, 0.0F);
/*  61 */     setRotateAngle(this.roofRight, 0.0F, 0.0F, -0.3642502F);
/*  62 */     this.roofLeft = new ModelRenderer(this, 12, 0);
/*  63 */     this.roofLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/*  64 */     this.roofLeft.func_78790_a(-5.3F, -27.9F, -7.95F, 10, 2, 16, 0.0F);
/*  65 */     setRotateAngle(this.roofLeft, 0.0F, 0.0F, 0.3642502F);
/*  66 */     this.shape37_2 = new ModelRenderer(this, 12, 0);
/*  67 */     this.shape37_2.func_78793_a(0.0F, 2.7F, 0.0F);
/*  68 */     this.shape37_2.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
/*  69 */     setRotateAngle(this.shape37_2, -0.34906584F, 0.0F, -0.7853982F);
/*  70 */     this.shape37 = new ModelRenderer(this, 12, 0);
/*  71 */     this.shape37.func_78793_a(-3.5F, -4.0F, 6.0F);
/*  72 */     this.shape37.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F);
/*  73 */     setRotateAngle(this.shape37, 0.0F, 0.7853982F, 0.0F);
/*  74 */     this.strutLeft = new ModelRenderer(this, 0, 0);
/*  75 */     this.strutLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.strutLeft.func_78790_a(5.5F, -26.0F, 5.0F, 2, 49, 2, 0.0F);
/*  77 */     this.shape37_1.func_78792_a(this.shape37_3);
/*  78 */     this.shape37.func_78792_a(this.shape37_2);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  83 */     this.strutRight.func_78785_a(f5);
/*  84 */     this.shape37_1.func_78785_a(f5);
/*  85 */     this.floorLower.func_78785_a(f5);
/*  86 */     this.strutMid.func_78785_a(f5);
/*  87 */     this.roofMid.func_78785_a(f5);
/*  88 */     this.boxBack.func_78785_a(f5);
/*  89 */     this.floorUpper.func_78785_a(f5);
/*  90 */     this.roofRight.func_78785_a(f5);
/*  91 */     this.roofLeft.func_78785_a(f5);
/*  92 */     this.shape37.func_78785_a(f5);
/*  93 */     this.strutLeft.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 100 */     modelRenderer.field_78795_f = x;
/* 101 */     modelRenderer.field_78796_g = y;
/* 102 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */