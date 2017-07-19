/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelPantheon
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer base;
/*     */   public ModelRenderer mid;
/*     */   public ModelRenderer top;
/*     */   public ModelRenderer cubeA;
/*     */   public ModelRenderer cubeB;
/*     */   public ModelRenderer prong1;
/*     */   public ModelRenderer prong2;
/*     */   public ModelRenderer prong3;
/*     */   public ModelRenderer prong4;
/*     */   public ModelRenderer prong5;
/*     */   public ModelRenderer prong6;
/*     */   public ModelRenderer prong7;
/*     */   public ModelRenderer prong8;
/*     */   
/*     */   public ModelPantheon()
/*     */   {
/*  31 */     this.field_78090_t = 64;
/*  32 */     this.field_78089_u = 64;
/*  33 */     this.base = new ModelRenderer(this, 0, 44);
/*  34 */     this.base.func_78793_a(0.0F, 20.0F, 0.0F);
/*  35 */     this.base.func_78790_a(-8.0F, 0.0F, -8.0F, 16, 4, 16, 0.0F);
/*  36 */     this.cubeB = new ModelRenderer(this, 17, 0);
/*  37 */     this.cubeB.func_78793_a(0.0F, 10.0F, 0.0F);
/*  38 */     this.cubeB.func_78790_a(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
/*  39 */     this.prong4 = new ModelRenderer(this, 0, 16);
/*  40 */     this.prong4.func_78793_a(0.0F, 16.5F, 0.0F);
/*  41 */     this.prong4.func_78790_a(5.5F, 0.0F, 5.5F, 1, 4, 1, 0.0F);
/*  42 */     this.prong6 = new ModelRenderer(this, 0, 16);
/*  43 */     this.prong6.func_78793_a(0.0F, 13.5F, 0.0F);
/*  44 */     this.prong6.func_78790_a(3.5F, 0.0F, -4.5F, 1, 4, 1, 0.0F);
/*  45 */     this.prong3 = new ModelRenderer(this, 0, 16);
/*  46 */     this.prong3.func_78793_a(0.0F, 16.5F, 0.0F);
/*  47 */     this.prong3.func_78790_a(5.5F, 0.0F, -6.5F, 1, 4, 1, 0.0F);
/*  48 */     this.prong2 = new ModelRenderer(this, 0, 16);
/*  49 */     this.prong2.func_78793_a(0.0F, 16.5F, 0.0F);
/*  50 */     this.prong2.func_78790_a(-6.5F, 0.0F, 5.5F, 1, 4, 1, 0.0F);
/*  51 */     this.prong1 = new ModelRenderer(this, 0, 16);
/*  52 */     this.prong1.func_78793_a(0.0F, 16.5F, 0.0F);
/*  53 */     this.prong1.func_78790_a(-6.5F, 0.0F, -6.5F, 1, 4, 1, 0.0F);
/*  54 */     this.mid = new ModelRenderer(this, 0, 28);
/*  55 */     this.mid.func_78793_a(0.0F, 17.0F, 0.0F);
/*  56 */     this.mid.func_78790_a(-6.0F, 0.0F, -6.0F, 12, 3, 12, 0.0F);
/*  57 */     this.top = new ModelRenderer(this, 0, 16);
/*  58 */     this.top.func_78793_a(0.0F, 14.0F, 0.0F);
/*  59 */     this.top.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 3, 8, 0.0F);
/*  60 */     this.cubeA = new ModelRenderer(this, 0, 0);
/*  61 */     this.cubeA.func_78793_a(0.0F, 10.0F, 0.0F);
/*  62 */     this.cubeA.func_78790_a(-2.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F);
/*  63 */     this.prong5 = new ModelRenderer(this, 0, 16);
/*  64 */     this.prong5.func_78793_a(0.0F, 13.5F, 0.0F);
/*  65 */     this.prong5.func_78790_a(-4.5F, 0.0F, -4.5F, 1, 4, 1, 0.0F);
/*  66 */     this.prong7 = new ModelRenderer(this, 0, 16);
/*  67 */     this.prong7.func_78793_a(0.0F, 13.5F, 0.0F);
/*  68 */     this.prong7.func_78790_a(3.5F, 0.0F, 3.5F, 1, 4, 1, 0.0F);
/*  69 */     this.prong8 = new ModelRenderer(this, 0, 16);
/*  70 */     this.prong8.func_78793_a(0.0F, 13.5F, 0.0F);
/*  71 */     this.prong8.func_78790_a(-4.5F, 0.0F, 3.5F, 1, 4, 1, 0.0F);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  76 */     this.base.func_78785_a(f5);
/*     */     
/*  78 */     this.prong4.func_78785_a(f5);
/*  79 */     this.prong6.func_78785_a(f5);
/*  80 */     this.prong3.func_78785_a(f5);
/*  81 */     this.prong2.func_78785_a(f5);
/*  82 */     this.prong1.func_78785_a(f5);
/*  83 */     this.mid.func_78785_a(f5);
/*  84 */     this.top.func_78785_a(f5);
/*     */     
/*  86 */     this.prong5.func_78785_a(f5);
/*  87 */     this.prong7.func_78785_a(f5);
/*  88 */     this.prong8.func_78785_a(f5);
/*     */     
/*  90 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.6F);
/*  91 */     this.cubeA.func_78785_a(f5);
/*  92 */     this.cubeB.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/*  99 */     modelRenderer.field_78795_f = x;
/* 100 */     modelRenderer.field_78796_g = y;
/* 101 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelPantheon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */