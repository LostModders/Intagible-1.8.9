/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelResearchFunnel
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer inputTube;
/*     */   public ModelRenderer bodyMid;
/*     */   public ModelRenderer bodyBottom;
/*     */   public ModelRenderer bodyUpper;
/*     */   public ModelRenderer neckLower;
/*     */   public ModelRenderer neck;
/*     */   public ModelRenderer output;
/*     */   public ModelRenderer input;
/*     */   public ModelRenderer output1;
/*     */   public ModelRenderer output2;
/*     */   public ModelRenderer output3;
/*     */   public ModelRenderer outputConnect;
/*     */   private int augmentedColor;
/*     */   
/*     */   public ModelResearchFunnel()
/*     */   {
/*  32 */     this.field_78090_t = 64;
/*  33 */     this.field_78089_u = 32;
/*  34 */     this.input = new ModelRenderer(this, 0, 0);
/*  35 */     this.input.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.input.func_78790_a(-2.5F, -0.5F, 6.0F, 5, 5, 2, 0.0F);
/*  37 */     this.inputTube = new ModelRenderer(this, 13, 5);
/*  38 */     this.inputTube.func_78793_a(0.0F, 17.5F, 0.0F);
/*  39 */     this.inputTube.func_78790_a(-1.0F, 1.0F, 3.0F, 2, 2, 3, 0.0F);
/*  40 */     this.neckLower = new ModelRenderer(this, 0, 11);
/*  41 */     this.neckLower.func_78793_a(0.0F, 15.0F, 0.0F);
/*  42 */     this.neckLower.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 2, 5, 0.0F);
/*  43 */     this.neck = new ModelRenderer(this, 21, 12);
/*  44 */     this.neck.func_78793_a(0.0F, 12.0F, 0.0F);
/*  45 */     this.neck.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 3, 3, 0.0F);
/*  46 */     this.output3 = new ModelRenderer(this, 34, 0);
/*  47 */     this.output3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  48 */     this.output3.func_78790_a(-0.5F, 7.0F, 5.5F, 1, 1, 3, 0.0F);
/*  49 */     this.bodyBottom = new ModelRenderer(this, 33, 24);
/*  50 */     this.bodyBottom.func_78793_a(0.0F, 23.0F, 0.0F);
/*  51 */     this.bodyBottom.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 1, 7, 0.0F);
/*  52 */     this.output2 = new ModelRenderer(this, 43, 0);
/*  53 */     this.output2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  54 */     this.output2.func_78790_a(-0.5F, 0.0F, 4.5F, 1, 8, 1, 0.0F);
/*  55 */     this.bodyUpper = new ModelRenderer(this, 33, 15);
/*  56 */     this.bodyUpper.func_78793_a(0.0F, 17.0F, 0.0F);
/*  57 */     this.bodyUpper.func_78790_a(-3.5F, 0.0F, -3.5F, 7, 1, 7, 0.0F);
/*  58 */     this.output = new ModelRenderer(this, 43, 0);
/*  59 */     this.output.func_78793_a(0.0F, 9.0F, 0.0F);
/*  60 */     this.output.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 4, 1, 0.0F);
/*  61 */     this.output1 = new ModelRenderer(this, 24, 0);
/*  62 */     this.output1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  63 */     this.output1.func_78790_a(-0.5F, 0.0F, 0.5F, 1, 1, 4, 0.0F);
/*  64 */     this.bodyMid = new ModelRenderer(this, 0, 19);
/*  65 */     this.bodyMid.func_78793_a(0.0F, 18.0F, 0.0F);
/*  66 */     this.bodyMid.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 5, 8, 0.0F);
/*  67 */     this.outputConnect = new ModelRenderer(this, 50, 3);
/*  68 */     this.outputConnect.func_78793_a(0.0F, 0.0F, 0.0F);
/*  69 */     this.outputConnect.func_78790_a(-1.0F, 6.5F, 7.5F, 2, 2, 1, 0.0F);
/*  70 */     this.output.func_78792_a(this.outputConnect);
/*  71 */     this.inputTube.func_78792_a(this.input);
/*  72 */     this.output.func_78792_a(this.output3);
/*  73 */     this.output.func_78792_a(this.output2);
/*  74 */     this.output.func_78792_a(this.output1);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/*  80 */     RenderUtil.color(this.augmentedColor);
/*  81 */     this.neckLower.func_78785_a(f5);
/*  82 */     this.neck.func_78785_a(f5);
/*  83 */     this.bodyUpper.func_78785_a(f5);
/*  84 */     this.bodyMid.func_78785_a(f5);
/*  85 */     this.bodyBottom.func_78785_a(f5);
/*     */     
/*  87 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  88 */     this.inputTube.func_78785_a(f5);
/*  89 */     this.output.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/*  97 */     modelRenderer.field_78795_f = x;
/*  98 */     modelRenderer.field_78796_g = y;
/*  99 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */   
/*     */ 
/*     */   public void setColorAugment(int color)
/*     */   {
/* 105 */     this.augmentedColor = color;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelResearchFunnel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */