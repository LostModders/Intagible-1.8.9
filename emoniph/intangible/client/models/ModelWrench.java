/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelWrench
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer core;
/*    */   public ModelRenderer gyro;
/*    */   public ModelRenderer arm1;
/*    */   public ModelRenderer arm2;
/*    */   public ModelRenderer arm3;
/*    */   public ModelRenderer arm4;
/*    */   public ModelRenderer baseUpper;
/*    */   public ModelRenderer baseLower;
/*    */   public ModelRenderer leaf1;
/*    */   public ModelRenderer leaf2;
/*    */   public ModelRenderer leaf3;
/*    */   public ModelRenderer leaf4;
/*    */   
/*    */   public ModelWrench()
/*    */   {
/* 29 */     this.field_78090_t = 64;
/* 30 */     this.field_78089_u = 32;
/* 31 */     this.leaf4 = new ModelRenderer(this, 13, 0);
/* 32 */     this.leaf4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 33 */     this.leaf4.func_78790_a(-3.0F, -26.5F, 12.5F, 6, 9, 1, 0.0F);
/* 34 */     setRotateAngle(this.leaf4, 0.63739425F, 0.0F, 0.0F);
/* 35 */     this.arm4 = new ModelRenderer(this, 0, 0);
/* 36 */     this.arm4.func_78793_a(0.0F, 24.0F, 0.0F);
/* 37 */     this.arm4.func_78790_a(-2.5F, -22.0F, -0.5F, 5, 22, 1, 0.0F);
/* 38 */     setRotateAngle(this.arm4, -0.27314404F, 3.1415927F, 0.0F);
/* 39 */     this.arm3 = new ModelRenderer(this, 0, 0);
/* 40 */     this.arm3.func_78793_a(0.0F, 24.0F, 0.0F);
/* 41 */     this.arm3.func_78790_a(-2.5F, -22.0F, -0.5F, 5, 22, 1, 0.0F);
/* 42 */     setRotateAngle(this.arm3, -0.27314404F, -1.5707964F, 0.0F);
/* 43 */     this.gyro = new ModelRenderer(this, 10, 20);
/* 44 */     this.gyro.func_78793_a(0.0F, 1.6F, 0.0F);
/* 45 */     this.gyro.func_78790_a(-2.5F, -2.0F, -2.5F, 5, 4, 5, 0.0F);
/* 46 */     this.leaf1 = new ModelRenderer(this, 13, 0);
/* 47 */     this.leaf1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 48 */     this.leaf1.func_78790_a(-3.0F, -26.5F, 12.5F, 6, 9, 1, 0.0F);
/* 49 */     setRotateAngle(this.leaf1, 0.63739425F, 0.0F, 0.0F);
/* 50 */     this.arm2 = new ModelRenderer(this, 0, 0);
/* 51 */     this.arm2.func_78793_a(0.0F, 24.0F, 0.0F);
/* 52 */     this.arm2.func_78790_a(-2.5F, -22.0F, -0.5F, 5, 22, 1, 0.0F);
/* 53 */     setRotateAngle(this.arm2, -0.27314404F, 1.5707964F, 0.0F);
/* 54 */     this.arm1 = new ModelRenderer(this, 0, 0);
/* 55 */     this.arm1.func_78793_a(0.0F, 24.0F, 0.0F);
/* 56 */     this.arm1.func_78790_a(-2.5F, -22.0F, -0.5F, 5, 22, 1, 0.0F);
/* 57 */     setRotateAngle(this.arm1, -0.27314404F, 0.0F, 0.0F);
/* 58 */     this.leaf3 = new ModelRenderer(this, 13, 0);
/* 59 */     this.leaf3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 60 */     this.leaf3.func_78790_a(-3.0F, -26.5F, 12.5F, 6, 9, 1, 0.0F);
/* 61 */     setRotateAngle(this.leaf3, 0.63739425F, 0.0F, 0.0F);
/* 62 */     this.baseLower = new ModelRenderer(this, 21, 20);
/* 63 */     this.baseLower.func_78793_a(0.0F, 23.0F, 0.0F);
/* 64 */     this.baseLower.func_78790_a(-5.0F, -1.0F, -5.0F, 10, 2, 10, 0.0F);
/* 65 */     this.leaf2 = new ModelRenderer(this, 13, 0);
/* 66 */     this.leaf2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 67 */     this.leaf2.func_78790_a(-3.0F, -26.5F, 12.5F, 6, 9, 1, 0.0F);
/* 68 */     setRotateAngle(this.leaf2, 0.63739425F, 0.0F, 0.0F);
/* 69 */     this.core = new ModelRenderer(this, 52, 0);
/* 70 */     this.core.func_78793_a(0.0F, -8.0F, 0.0F);
/* 71 */     this.core.func_78790_a(-1.5F, 0.0F, -1.5F, 3, 26, 3, 0.0F);
/* 72 */     this.baseUpper = new ModelRenderer(this, 20, 3);
/* 73 */     this.baseUpper.func_78793_a(0.0F, 19.5F, 0.0F);
/* 74 */     this.baseUpper.func_78790_a(-4.0F, -2.5F, -4.0F, 8, 5, 8, 0.0F);
/* 75 */     this.arm4.func_78792_a(this.leaf4);
/* 76 */     this.arm1.func_78792_a(this.leaf1);
/* 77 */     this.arm3.func_78792_a(this.leaf3);
/* 78 */     this.arm2.func_78792_a(this.leaf2);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 83 */     this.arm4.func_78785_a(f5);
/* 84 */     this.arm3.func_78785_a(f5);
/* 85 */     this.gyro.func_78785_a(f5);
/* 86 */     this.arm2.func_78785_a(f5);
/* 87 */     this.arm1.func_78785_a(f5);
/* 88 */     this.baseLower.func_78785_a(f5);
/* 89 */     this.core.func_78785_a(f5);
/* 90 */     this.baseUpper.func_78785_a(f5);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 97 */     modelRenderer.field_78795_f = x;
/* 98 */     modelRenderer.field_78796_g = y;
/* 99 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelWrench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */