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
/*     */ public class ModelBlowMold
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer stand1;
/*     */   public ModelRenderer stand2;
/*     */   public ModelRenderer stand3;
/*     */   public ModelRenderer stand4;
/*     */   public ModelRenderer bottom;
/*     */   public ModelRenderer side1;
/*     */   public ModelRenderer side2;
/*     */   public ModelRenderer side3;
/*     */   public ModelRenderer side4;
/*     */   public ModelRenderer lip1;
/*     */   public ModelRenderer lip2;
/*     */   public ModelRenderer lip3;
/*     */   public ModelRenderer lip4;
/*     */   public ModelRenderer top;
/*     */   public ModelRenderer top1;
/*     */   public ModelRenderer top2;
/*     */   public ModelRenderer top3;
/*     */   
/*     */   public ModelBlowMold()
/*     */   {
/*  34 */     this.field_78090_t = 64;
/*  35 */     this.field_78089_u = 32;
/*  36 */     this.lip1 = new ModelRenderer(this, 0, 0);
/*  37 */     this.lip1.func_78793_a(0.0F, 19.0F, 0.0F);
/*  38 */     this.lip1.func_78790_a(-5.0F, -10.0F, -6.0F, 11, 1, 1, 0.0F);
/*  39 */     this.top = new ModelRenderer(this, 0, 19);
/*  40 */     this.top.func_78793_a(0.0F, 11.0F, 0.0F);
/*  41 */     this.top.func_78790_a(0.5F, 0.0F, -0.5F, 5, 1, 1, 0.0F);
/*  42 */     this.bottom = new ModelRenderer(this, 0, 19);
/*  43 */     this.bottom.func_78793_a(0.0F, 19.0F, 0.0F);
/*  44 */     this.bottom.func_78790_a(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
/*  45 */     this.top2 = new ModelRenderer(this, 0, 19);
/*  46 */     this.top2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.top2.func_78790_a(-5.5F, 0.0F, -6.0F, 5, 1, 12, 0.0F);
/*  48 */     setRotateAngle(this.top2, 0.0F, -1.5707964F, 0.0F);
/*  49 */     this.lip4 = new ModelRenderer(this, 0, 0);
/*  50 */     this.lip4.func_78793_a(0.0F, 19.0F, 0.0F);
/*  51 */     this.lip4.func_78790_a(-5.0F, -10.0F, -6.0F, 11, 1, 1, 0.0F);
/*  52 */     setRotateAngle(this.lip4, 0.0F, -1.5707964F, 0.0F);
/*  53 */     this.stand1 = new ModelRenderer(this, 32, 0);
/*  54 */     this.stand1.func_78793_a(0.0F, 23.0F, 0.0F);
/*  55 */     this.stand1.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
/*  56 */     this.side1 = new ModelRenderer(this, 0, 3);
/*  57 */     this.side1.func_78793_a(0.0F, 19.0F, 0.0F);
/*  58 */     this.side1.func_78790_a(-6.0F, -9.0F, -7.0F, 12, 9, 2, 0.0F);
/*  59 */     this.side3 = new ModelRenderer(this, 0, 3);
/*  60 */     this.side3.func_78793_a(0.0F, 19.0F, 0.0F);
/*  61 */     this.side3.func_78790_a(-6.0F, -9.0F, -7.0F, 12, 9, 2, 0.0F);
/*  62 */     setRotateAngle(this.side3, 0.0F, 3.1415927F, 0.0F);
/*  63 */     this.stand2 = new ModelRenderer(this, 32, 8);
/*  64 */     this.stand2.func_78793_a(0.0F, 22.0F, 0.0F);
/*  65 */     this.stand2.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
/*  66 */     setRotateAngle(this.stand2, 0.0F, 0.7853982F, 0.0F);
/*  67 */     this.side4 = new ModelRenderer(this, 0, 3);
/*  68 */     this.side4.func_78793_a(0.0F, 19.0F, 0.0F);
/*  69 */     this.side4.func_78790_a(-6.0F, -9.0F, -7.0F, 12, 9, 2, 0.0F);
/*  70 */     setRotateAngle(this.side4, 0.0F, -1.5707964F, 0.0F);
/*  71 */     this.side2 = new ModelRenderer(this, 0, 3);
/*  72 */     this.side2.func_78793_a(0.0F, 19.0F, 0.0F);
/*  73 */     this.side2.func_78790_a(-6.0F, -9.0F, -7.0F, 12, 9, 2, 0.0F);
/*  74 */     setRotateAngle(this.side2, 0.0F, 1.5707964F, 0.0F);
/*  75 */     this.lip3 = new ModelRenderer(this, 0, 0);
/*  76 */     this.lip3.func_78793_a(0.0F, 19.0F, 0.0F);
/*  77 */     this.lip3.func_78790_a(-5.0F, -10.0F, -6.0F, 11, 1, 1, 0.0F);
/*  78 */     setRotateAngle(this.lip3, 0.0F, 3.1415927F, 0.0F);
/*  79 */     this.top1 = new ModelRenderer(this, 0, 19);
/*  80 */     this.top1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.top1.func_78790_a(-5.5F, 0.0F, -0.5F, 5, 1, 1, 0.0F);
/*  82 */     this.top3 = new ModelRenderer(this, 0, 19);
/*  83 */     this.top3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */     this.top3.func_78790_a(-5.5F, 0.0F, -6.0F, 5, 1, 12, 0.0F);
/*  85 */     setRotateAngle(this.top3, 0.0F, 1.5707964F, 0.0F);
/*  86 */     this.stand3 = new ModelRenderer(this, 38, 17);
/*  87 */     this.stand3.func_78793_a(0.0F, 20.0F, 0.0F);
/*  88 */     this.stand3.func_78790_a(-2.0F, 0.0F, -2.0F, 4, 2, 4, 0.0F);
/*  89 */     setRotateAngle(this.stand3, 0.0F, 0.7853982F, 0.0F);
/*  90 */     this.lip2 = new ModelRenderer(this, 0, 0);
/*  91 */     this.lip2.func_78793_a(0.0F, 19.0F, 0.0F);
/*  92 */     this.lip2.func_78790_a(-5.0F, -10.0F, -6.0F, 11, 1, 1, 0.0F);
/*  93 */     setRotateAngle(this.lip2, 0.0F, 1.5707964F, 0.0F);
/*  94 */     this.stand4 = new ModelRenderer(this, 42, 24);
/*  95 */     this.stand4.func_78793_a(0.0F, 20.0F, 0.0F);
/*  96 */     this.stand4.func_78790_a(-1.9F, 0.0F, -2.0F, 4, 1, 4, 0.0F);
/*  97 */     this.top.func_78792_a(this.top2);
/*  98 */     this.top.func_78792_a(this.top1);
/*  99 */     this.top.func_78792_a(this.top3);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 104 */     this.lip1.func_78785_a(f5);
/* 105 */     this.top.func_78785_a(f5);
/* 106 */     this.bottom.func_78785_a(f5);
/* 107 */     this.lip4.func_78785_a(f5);
/* 108 */     this.stand1.func_78785_a(f5);
/* 109 */     this.side1.func_78785_a(f5);
/* 110 */     this.side3.func_78785_a(f5);
/* 111 */     this.stand2.func_78785_a(f5);
/* 112 */     this.side4.func_78785_a(f5);
/* 113 */     this.side2.func_78785_a(f5);
/* 114 */     this.lip3.func_78785_a(f5);
/* 115 */     this.stand3.func_78785_a(f5);
/* 116 */     this.lip2.func_78785_a(f5);
/* 117 */     this.stand4.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 124 */     modelRenderer.field_78795_f = x;
/* 125 */     modelRenderer.field_78796_g = y;
/* 126 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelBlowMold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */