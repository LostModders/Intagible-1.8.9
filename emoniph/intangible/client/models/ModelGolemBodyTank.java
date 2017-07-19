/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemBodyTank extends ModelGolemBody
/*    */ {
/*    */   public ModelRenderer waistLower;
/*    */   public ModelRenderer waistUpper;
/*    */   
/*    */   public ModelGolemBodyTank()
/*    */   {
/* 13 */     this.field_78090_t = 128;
/* 14 */     this.field_78089_u = 64;
/*    */     
/* 16 */     this.body = new ModelRenderer(this, 0, 39);
/* 17 */     this.body.func_78793_a(0.0F, -12.0F, 0.0F);
/* 18 */     this.body.func_78790_a(-11.0F, -2.0F, -6.0F, 22, 14, 11, 0.0F);
/*    */     
/* 20 */     this.waistUpper = new ModelRenderer(this, 88, 44);
/* 21 */     this.waistUpper.func_78793_a(0.0F, 12.0F, 0.0F);
/* 22 */     this.waistUpper.func_78790_a(-6.0F, 0.0F, -4.0F, 12, 3, 8, 0.5F);
/*    */     
/* 24 */     this.waistLower = new ModelRenderer(this, 98, 55);
/* 25 */     this.waistLower.func_78793_a(0.0F, 16.0F, 0.0F);
/* 26 */     this.waistLower.func_78790_a(-4.5F, 0.0F, -3.0F, 9, 3, 6, 0.5F);
/*    */     
/* 28 */     this.body.func_78792_a(this.waistUpper);
/* 29 */     this.body.func_78792_a(this.waistLower);
/*    */   }
/*    */   
/*    */   protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 33 */     modelRenderer.field_78795_f = x;
/* 34 */     modelRenderer.field_78796_g = y;
/* 35 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemBodyTank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */