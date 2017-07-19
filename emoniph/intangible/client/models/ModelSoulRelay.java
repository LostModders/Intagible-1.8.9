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
/*    */ public class ModelSoulRelay
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer layer7;
/*    */   public ModelRenderer layer6;
/*    */   public ModelRenderer layer5;
/*    */   public ModelRenderer layer4;
/*    */   public ModelRenderer layer3;
/*    */   public ModelRenderer layer2;
/*    */   public ModelRenderer layer1;
/*    */   public ModelRenderer base;
/*    */   
/*    */   public ModelSoulRelay()
/*    */   {
/* 25 */     this.field_78090_t = 64;
/* 26 */     this.field_78089_u = 32;
/* 27 */     this.base = new ModelRenderer(this, 32, 0);
/* 28 */     this.base.func_78793_a(0.0F, 23.0F, 0.0F);
/* 29 */     this.base.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
/* 30 */     this.layer2 = new ModelRenderer(this, 32, 0);
/* 31 */     this.layer2.func_78793_a(0.0F, 20.0F, 0.0F);
/* 32 */     this.layer2.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 2, 8, 0.0F);
/* 33 */     this.layer7 = new ModelRenderer(this, 0, 15);
/* 34 */     this.layer7.func_78793_a(0.0F, 8.0F, 0.0F);
/* 35 */     this.layer7.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
/* 36 */     this.layer6 = new ModelRenderer(this, 32, 0);
/* 37 */     this.layer6.func_78793_a(0.0F, 9.0F, 0.0F);
/* 38 */     this.layer6.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 2, 8, 0.0F);
/* 39 */     this.layer1 = new ModelRenderer(this, 0, 15);
/* 40 */     this.layer1.func_78793_a(0.0F, 22.0F, 0.0F);
/* 41 */     this.layer1.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 1, 6, 0.0F);
/* 42 */     this.layer5 = new ModelRenderer(this, 0, 1);
/* 43 */     this.layer5.func_78793_a(0.0F, 11.0F, 0.0F);
/* 44 */     this.layer5.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 3, 10, 0.0F);
/* 45 */     this.layer3 = new ModelRenderer(this, 0, 1);
/* 46 */     this.layer3.func_78793_a(0.0F, 17.0F, 0.0F);
/* 47 */     this.layer3.func_78790_a(-5.0F, 0.0F, -5.0F, 10, 3, 10, 0.0F);
/* 48 */     this.layer4 = new ModelRenderer(this, 16, 17);
/* 49 */     this.layer4.func_78793_a(0.0F, 14.0F, 0.0F);
/* 50 */     this.layer4.func_78790_a(-6.0F, 0.0F, -6.0F, 12, 3, 12, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 55 */     this.base.func_78785_a(f5);
/* 56 */     this.layer2.func_78785_a(f5);
/* 57 */     this.layer7.func_78785_a(f5);
/* 58 */     this.layer6.func_78785_a(f5);
/* 59 */     this.layer1.func_78785_a(f5);
/* 60 */     this.layer5.func_78785_a(f5);
/* 61 */     this.layer3.func_78785_a(f5);
/* 62 */     this.layer4.func_78785_a(f5);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 69 */     modelRenderer.field_78795_f = x;
/* 70 */     modelRenderer.field_78796_g = y;
/* 71 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelSoulRelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */