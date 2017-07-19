/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import emoniph.intangible.entity.EntityChariot;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class ModelChariot extends ModelBase
/*     */ {
/*     */   public ModelRenderer floor;
/*     */   public ModelRenderer axle;
/*     */   public ModelRenderer shaft1;
/*     */   public ModelRenderer shaft2;
/*     */   public ModelRenderer wallRightFront;
/*     */   public ModelRenderer wallFront;
/*     */   public ModelRenderer wallLeftFront;
/*     */   public ModelRenderer wallRightRear;
/*     */   public ModelRenderer wallLeftRear;
/*     */   public ModelRenderer floorFront;
/*     */   public ModelRenderer[] scythe;
/*     */   public ModelRenderer shaft3;
/*     */   
/*     */   public ModelChariot()
/*     */   {
/*  26 */     this.field_78090_t = 64;
/*  27 */     this.field_78089_u = 64;
/*     */     
/*  29 */     float centerOffset = -30.0F;
/*     */     
/*  31 */     this.shaft1 = new ModelRenderer(this, 40, 11);
/*  32 */     this.shaft1.func_78793_a(0.0F, 18.0F, -1.0F);
/*  33 */     this.shaft1.func_78790_a(-1.0F, -1.0F, -10.0F - centerOffset, 2, 2, 10, 0.0F);
/*  34 */     this.floorFront = new ModelRenderer(this, 23, 48);
/*  35 */     this.floorFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  36 */     this.floorFront.func_78790_a(-6.5F, 0.0F, -7.0F - centerOffset, 13, 1, 4, 0.0F);
/*     */     
/*  38 */     this.floor = new ModelRenderer(this, 16, 53);
/*  39 */     this.floor.func_78793_a(0.0F, 16.0F, 0.0F);
/*  40 */     this.floor.func_78790_a(-7.0F, 0.0F, -3.0F - centerOffset, 14, 1, 10, 0.0F);
/*  41 */     this.wallRightRear = new ModelRenderer(this, 0, 40);
/*  42 */     this.wallRightRear.func_78793_a(0.0F, 0.0F, 0.0F);
/*  43 */     this.wallRightRear.func_78790_a(-8.0F, -11.0F, -3.0F - centerOffset, 1, 12, 10, 0.0F);
/*  44 */     this.wallLeftFront = new ModelRenderer(this, 54, 0);
/*  45 */     this.wallLeftFront.field_78809_i = true;
/*  46 */     this.wallLeftFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  47 */     this.wallLeftFront.func_78790_a(6.5F, -14.0F, -7.0F - centerOffset, 1, 15, 4, 0.0F);
/*  48 */     this.wallRightFront = new ModelRenderer(this, 54, 0);
/*  49 */     this.wallRightFront.func_78793_a(0.0F, 0.0F, 0.0F);
/*  50 */     this.wallRightFront.func_78790_a(-7.5F, -14.0F, -7.0F - centerOffset, 1, 15, 4, 0.0F);
/*     */     
/*  52 */     this.wallLeftRear = new ModelRenderer(this, 0, 40);
/*  53 */     this.wallLeftRear.field_78809_i = true;
/*  54 */     this.wallLeftRear.func_78793_a(0.0F, 0.0F, 0.0F);
/*  55 */     this.wallLeftRear.func_78790_a(7.0F, -11.0F, -3.0F - centerOffset, 1, 12, 10, 0.0F);
/*     */     
/*     */ 
/*     */ 
/*  59 */     this.shaft2 = new ModelRenderer(this, 0, 2);
/*  60 */     this.shaft2.func_78793_a(0.0F, 18.0F, -11.0F - centerOffset);
/*  61 */     this.shaft2.func_78790_a(-1.0F, -1.1F, -29.5F, 2, 2, 30, 0.0F);
/*  62 */     setRotateAngle(this.shaft2, -0.3642502F, 0.0F, 0.0F);
/*     */     
/*  64 */     this.shaft3 = new ModelRenderer(this, 20, 44);
/*  65 */     this.shaft3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  66 */     this.shaft3.func_78790_a(-10.0F, -1.0F, -31.5F, 20, 2, 2, 0.0F);
/*     */     
/*  68 */     this.wallFront = new ModelRenderer(this, 0, 0);
/*  69 */     this.wallFront.func_78793_a(0.0F, 4.0F, 0.0F);
/*  70 */     this.wallFront.func_78790_a(-6.5F, -19.0F, -8.0F - centerOffset, 13, 16, 1, 0.0F);
/*     */     
/*  72 */     this.axle = new ModelRenderer(this, 16, 37);
/*  73 */     this.axle.func_78793_a(0.0F, 18.0F, 0.0F - centerOffset);
/*  74 */     this.axle.func_78790_a(-11.0F, -1.0F, -1.0F, 22, 2, 2, 0.0F);
/*     */     
/*  76 */     for (int q = 0; q < 2; q++) {
/*  77 */       for (int i = 0; i < 8; i++) {
/*  78 */         ModelRenderer tire = new ModelRenderer(this, 12, 18);
/*  79 */         tire.func_78793_a(0.0F, 0.0F, 0.0F);
/*  80 */         tire.func_78790_a(-11.0F + q * 20, -2.5F, -6.0F, 2, 5, 1, 0.0F);
/*     */         
/*  82 */         ModelRenderer spoke = new ModelRenderer(this, 0, 19);
/*  83 */         spoke.func_78793_a(0.0F, 0.0F, 0.0F);
/*  84 */         spoke.func_78790_a(-10.5F + q * 20, -0.5F, -5.0F, 1, 1, 4, 0.0F);
/*  85 */         setRotateAngle(spoke, 0.7853982F * i, 0.0F, 0.0F);
/*     */         
/*  87 */         spoke.func_78792_a(tire);
/*     */         
/*  89 */         this.axle.func_78792_a(spoke);
/*     */       }
/*     */     }
/*     */     
/*  93 */     this.scythe = new ModelRenderer[2];
/*  94 */     for (int q = 0; q < this.scythe.length; q++) {
/*  95 */       this.scythe[q] = new ModelRenderer(this, 9, 30);
/*  96 */       this.scythe[q].func_78793_a(0.0F, 0.0F, 0.0F);
/*  97 */       this.scythe[q].func_78790_a(-18.0F, -0.5F, -0.5F, 7, 1, 1, 0.0F);
/*  98 */       setRotateAngle(this.scythe[q], 0.7853982F, 0.0F, 0.0F + 3.1415927F * q);
/*     */       
/* 100 */       ModelRenderer scythe2 = new ModelRenderer(this, 13, 34);
/* 101 */       scythe2.func_78793_a(-12.0F, 0.0F, 0.0F);
/* 102 */       scythe2.func_78790_a(-3.0F, -1.0F, -0.5F, 3, 1, 1, 0.0F);
/* 103 */       setRotateAngle(scythe2, 0.0F, 0.7853982F, 0.7853982F);
/* 104 */       this.scythe[q].func_78792_a(scythe2);
/*     */       
/* 106 */       ModelRenderer scythe3 = new ModelRenderer(this, 13, 34);
/* 107 */       scythe3.func_78793_a(-12.0F, 0.0F, 0.0F);
/* 108 */       scythe3.func_78790_a(-3.0F, 0.0F, -0.5F, 3, 1, 1, 0.0F);
/* 109 */       setRotateAngle(scythe3, 0.0F, -0.7853982F, -0.7853982F);
/* 110 */       this.scythe[q].func_78792_a(scythe3);
/*     */       
/* 112 */       this.axle.func_78792_a(this.scythe[q]);
/*     */     }
/*     */     
/* 115 */     this.floor.func_78792_a(this.floorFront);
/* 116 */     this.shaft2.func_78792_a(this.shaft3);
/* 117 */     this.floor.func_78792_a(this.wallRightRear);
/* 118 */     this.floor.func_78792_a(this.wallLeftFront);
/* 119 */     this.floor.func_78792_a(this.wallRightFront);
/* 120 */     this.floor.func_78792_a(this.wallLeftRear);
/* 121 */     this.floor.func_78792_a(this.wallFront);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 126 */     super.func_78088_a(entity, f, f1, f2, f3, f4, f5);
/*     */     
/* 128 */     EntityChariot chariot = (EntityChariot)entity;
/* 129 */     this.axle.field_78795_f = chariot.rotX;
/* 130 */     this.axle.field_78808_h = 0.0F;
/*     */     
/* 132 */     this.shaft1.func_78785_a(f5);
/* 133 */     this.floor.func_78785_a(f5);
/* 134 */     this.axle.func_78785_a(f5);
/* 135 */     this.shaft2.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 142 */     modelRenderer.field_78795_f = x;
/* 143 */     modelRenderer.field_78796_g = y;
/* 144 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelChariot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */