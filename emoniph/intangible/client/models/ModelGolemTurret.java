/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelGolemTurret
/*    */   extends ModelGolemBody
/*    */ {
/*    */   public ModelRenderer pack;
/*    */   public ModelRenderer top;
/*    */   public ModelRenderer waistUpper;
/*    */   public ModelRenderer waistLower;
/*    */   public ModelRenderer gun;
/*    */   public ModelRenderer tip1;
/*    */   public ModelRenderer tip2;
/*    */   public ModelRenderer tip3;
/*    */   public ModelRenderer tip4;
/*    */   public ModelRenderer tip5;
/*    */   public ModelRenderer arm;
/*    */   
/*    */   public ModelGolemTurret()
/*    */   {
/* 28 */     this.field_78090_t = 128;
/* 29 */     this.field_78089_u = 64;
/*    */     
/* 31 */     this.pack = new ModelRenderer(this, 0, 0);
/* 32 */     this.pack.func_78793_a(0.0F, -3.0F, 10.0F);
/* 33 */     this.pack.func_78790_a(-8.0F, 0.0F, -8.0F, 16, 13, 16, 0.0F);
/*    */     
/* 35 */     this.arm = new ModelRenderer(this, 51, 2);
/* 36 */     this.arm.func_78793_a(0.0F, 0.0F, 0.0F);
/* 37 */     this.arm.func_78790_a(-8.5F, -1.5F, -2.0F, 1, 7, 4, 0.0F);
/* 38 */     this.tip3 = new ModelRenderer(this, 0, 0);
/* 39 */     this.tip3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 40 */     this.tip3.func_78790_a(-10.5F, -5.0F, -12.0F, 3, 3, 1, 0.0F);
/*    */     
/* 42 */     this.tip2 = new ModelRenderer(this, 0, 0);
/* 43 */     this.tip2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 44 */     this.tip2.func_78790_a(-10.5F, -5.0F, -10.0F, 3, 3, 1, 0.0F);
/*    */     
/* 46 */     this.tip1 = new ModelRenderer(this, 0, 0);
/* 47 */     this.tip1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 48 */     this.tip1.func_78790_a(-10.5F, -5.0F, -8.0F, 3, 3, 1, 0.0F);
/* 49 */     this.tip4 = new ModelRenderer(this, 0, 0);
/* 50 */     this.tip4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 51 */     this.tip4.func_78790_a(-10.5F, -5.0F, -14.0F, 3, 3, 1, 0.0F);
/* 52 */     this.gun = new ModelRenderer(this, 0, 48);
/* 53 */     this.gun.func_78793_a(0.0F, -2.5F, 0.0F);
/* 54 */     this.gun.func_78790_a(-11.0F, -5.5F, -6.0F, 4, 4, 12, 0.0F);
/* 55 */     this.top = new ModelRenderer(this, 0, 30);
/* 56 */     this.top.func_78793_a(0.0F, -4.0F, 9.5F);
/* 57 */     this.top.func_78790_a(-7.5F, 0.0F, -7.5F, 15, 1, 15, 0.0F);
/* 58 */     this.tip5 = new ModelRenderer(this, 0, 0);
/* 59 */     this.tip5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 60 */     this.tip5.func_78790_a(-10.5F, -5.0F, -16.0F, 3, 3, 1, 0.0F);
/*    */     
/* 62 */     this.body = new ModelRenderer(this, 62, 39);
/* 63 */     this.body.func_78793_a(0.0F, -12.0F, 0.0F);
/* 64 */     this.body.func_78790_a(-11.0F, -2.0F, -6.0F, 22, 14, 11, 0.0F);
/*    */     
/* 66 */     this.waistUpper = new ModelRenderer(this, 88, 18);
/* 67 */     this.waistUpper.func_78793_a(0.0F, 12.0F, 0.0F);
/* 68 */     this.waistUpper.func_78790_a(-6.0F, 0.0F, -4.0F, 12, 3, 8, 0.5F);
/*    */     
/* 70 */     this.waistLower = new ModelRenderer(this, 98, 29);
/* 71 */     this.waistLower.func_78793_a(0.0F, 16.0F, 0.0F);
/* 72 */     this.waistLower.func_78790_a(-4.5F, 0.0F, -3.0F, 9, 3, 6, 0.5F);
/*    */     
/*    */ 
/* 75 */     this.body.func_78792_a(this.pack);
/* 76 */     this.gun.func_78792_a(this.arm);
/* 77 */     this.gun.func_78792_a(this.tip3);
/* 78 */     this.body.func_78792_a(this.waistLower);
/* 79 */     this.gun.func_78792_a(this.tip2);
/* 80 */     this.body.func_78792_a(this.waistUpper);
/* 81 */     this.gun.func_78792_a(this.tip1);
/* 82 */     this.gun.func_78792_a(this.tip4);
/* 83 */     this.top.func_78792_a(this.gun);
/* 84 */     this.body.func_78792_a(this.top);
/* 85 */     this.gun.func_78792_a(this.tip5);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 90 */     super.func_78088_a(entity, f, f2, f2, f3, f4, f5);
/*    */   }
/*    */   
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 94 */     modelRenderer.field_78795_f = x;
/* 95 */     modelRenderer.field_78796_g = y;
/* 96 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemTurret.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */