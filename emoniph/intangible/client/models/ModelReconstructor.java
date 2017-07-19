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
/*    */ public class ModelReconstructor
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer coreUpper;
/*    */   public ModelRenderer core;
/*    */   public ModelRenderer top;
/*    */   public ModelRenderer shieldOuter;
/*    */   public ModelRenderer shieldInner;
/*    */   public ModelRenderer shieldOuter1;
/*    */   public ModelRenderer shieldOuter2;
/*    */   public ModelRenderer shieldInner1;
/*    */   public ModelRenderer shieldInner2;
/*    */   
/*    */   public ModelReconstructor()
/*    */   {
/* 26 */     this.field_78090_t = 64;
/* 27 */     this.field_78089_u = 64;
/* 28 */     this.top = new ModelRenderer(this, 0, 0);
/* 29 */     this.top.func_78793_a(0.0F, 8.0F, 0.0F);
/* 30 */     this.top.func_78790_a(-7.5F, 0.0F, -7.5F, 15, 1, 15, 0.0F);
/* 31 */     this.shieldOuter2 = new ModelRenderer(this, 0, 53);
/* 32 */     this.shieldOuter2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 33 */     this.shieldOuter2.func_78790_a(-4.5F, 1.01F, -16.0F, 9, 10, 1, 0.0F);
/* 34 */     setRotateAngle(this.shieldOuter2, 0.0F, -0.7853982F, 0.0F);
/* 35 */     this.shieldInner2 = new ModelRenderer(this, 48, 0);
/* 36 */     this.shieldInner2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 37 */     this.shieldInner2.func_78790_a(-3.5F, 0.01F, -12.0F, 7, 14, 1, 0.0F);
/* 38 */     setRotateAngle(this.shieldInner2, 0.0F, 0.7853982F, 0.0F);
/* 39 */     this.shieldInner = new ModelRenderer(this, 48, 0);
/* 40 */     this.shieldInner.func_78793_a(0.0F, 8.0F, 0.0F);
/* 41 */     this.shieldInner.func_78790_a(-3.5F, 0.0F, -12.0F, 7, 14, 1, 0.0F);
/* 42 */     this.coreUpper = new ModelRenderer(this, 24, 39);
/* 43 */     this.coreUpper.func_78793_a(0.0F, 8.99F, 0.0F);
/* 44 */     this.coreUpper.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 15, 10, 0.0F);
/* 45 */     setRotateAngle(this.coreUpper, 0.0F, -0.7853982F, 0.0F);
/* 46 */     this.core = new ModelRenderer(this, 24, 39);
/* 47 */     this.core.func_78793_a(0.0F, 9.0F, 0.0F);
/* 48 */     this.core.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 15, 10, 0.0F);
/* 49 */     this.shieldOuter = new ModelRenderer(this, 0, 53);
/* 50 */     this.shieldOuter.func_78793_a(0.0F, 8.0F, 0.0F);
/* 51 */     this.shieldOuter.func_78790_a(-4.5F, 1.0F, -16.0F, 9, 10, 1, 0.0F);
/* 52 */     this.shieldOuter1 = new ModelRenderer(this, 0, 53);
/* 53 */     this.shieldOuter1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 54 */     this.shieldOuter1.func_78790_a(-4.5F, 1.01F, -16.0F, 9, 10, 1, 0.0F);
/* 55 */     setRotateAngle(this.shieldOuter1, 0.0F, 0.7853982F, 0.0F);
/* 56 */     this.shieldInner1 = new ModelRenderer(this, 48, 0);
/* 57 */     this.shieldInner1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 58 */     this.shieldInner1.func_78790_a(-3.5F, 0.01F, -12.0F, 7, 14, 1, 0.0F);
/* 59 */     setRotateAngle(this.shieldInner1, 0.0F, -0.7853982F, 0.0F);
/* 60 */     this.shieldOuter.func_78792_a(this.shieldOuter2);
/* 61 */     this.shieldInner.func_78792_a(this.shieldInner2);
/* 62 */     this.shieldOuter.func_78792_a(this.shieldOuter1);
/* 63 */     this.shieldInner.func_78792_a(this.shieldInner1);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 68 */     this.top.func_78785_a(f5);
/*    */     
/* 70 */     this.coreUpper.func_78785_a(f5);
/* 71 */     this.core.func_78785_a(f5);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 78 */     modelRenderer.field_78795_f = x;
/* 79 */     modelRenderer.field_78796_g = y;
/* 80 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelReconstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */