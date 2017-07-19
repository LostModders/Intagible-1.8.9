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
/*    */ public class ModelPlinth
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer shape1;
/*    */   public ModelRenderer shape1_1;
/*    */   public ModelRenderer shape1_2;
/*    */   public ModelRenderer shape1_3;
/*    */   public ModelRenderer shape1_4;
/*    */   public ModelRenderer shape1_5;
/*    */   public ModelRenderer shape1_6;
/*    */   public ModelRenderer shape1_7;
/*    */   public ModelRenderer shape1_8;
/*    */   public ModelRenderer shape1_9;
/*    */   
/*    */   public ModelPlinth()
/*    */   {
/* 27 */     this.field_78090_t = 64;
/* 28 */     this.field_78089_u = 64;
/* 29 */     this.shape1_7 = new ModelRenderer(this, 0, 28);
/* 30 */     this.shape1_7.func_78793_a(0.0F, 0.0F, 0.0F);
/* 31 */     this.shape1_7.func_78790_a(-4.5F, 12.0F, -4.5F, 9, 1, 9, 0.0F);
/* 32 */     this.shape1_5 = new ModelRenderer(this, 0, 0);
/* 33 */     this.shape1_5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 34 */     this.shape1_5.func_78790_a(-5.0F, 3.0F, -5.5F, 10, 1, 1, 0.0F);
/* 35 */     this.shape1 = new ModelRenderer(this, 0, 9);
/* 36 */     this.shape1.func_78793_a(0.0F, 8.0F, 0.0F);
/* 37 */     this.shape1.func_78790_a(-4.0F, 6.0F, -4.0F, 8, 6, 8, 0.0F);
/* 38 */     this.shape1_6 = new ModelRenderer(this, 0, 0);
/* 39 */     this.shape1_6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 40 */     this.shape1_6.func_78790_a(-5.0F, 3.0F, 4.5F, 10, 1, 1, 0.0F);
/* 41 */     this.shape1_3 = new ModelRenderer(this, 25, 0);
/* 42 */     this.shape1_3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 43 */     this.shape1_3.func_78790_a(-5.5F, 3.0F, -5.0F, 1, 1, 10, 0.0F);
/* 44 */     this.shape1_8 = new ModelRenderer(this, 0, 39);
/* 45 */     this.shape1_8.func_78793_a(0.0F, 0.0F, 0.0F);
/* 46 */     this.shape1_8.func_78790_a(-5.0F, 13.0F, -5.0F, 10, 1, 10, 0.0F);
/* 47 */     this.shape1_9 = new ModelRenderer(this, 0, 51);
/* 48 */     this.shape1_9.func_78793_a(0.0F, 0.0F, 0.0F);
/* 49 */     this.shape1_9.func_78790_a(-5.5F, 14.0F, -5.5F, 11, 2, 11, 0.0F);
/* 50 */     this.shape1_2 = new ModelRenderer(this, 0, 39);
/* 51 */     this.shape1_2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 52 */     this.shape1_2.func_78790_a(-5.0F, 4.0F, -5.0F, 10, 1, 10, 0.0F);
/* 53 */     this.shape1_1 = new ModelRenderer(this, 0, 28);
/* 54 */     this.shape1_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 55 */     this.shape1_1.func_78790_a(-4.5F, 5.0F, -4.5F, 9, 1, 9, 0.0F);
/* 56 */     this.shape1_4 = new ModelRenderer(this, 25, 0);
/* 57 */     this.shape1_4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 58 */     this.shape1_4.func_78790_a(4.5F, 3.0F, -5.0F, 1, 1, 10, 0.0F);
/* 59 */     this.shape1.func_78792_a(this.shape1_7);
/* 60 */     this.shape1.func_78792_a(this.shape1_5);
/* 61 */     this.shape1.func_78792_a(this.shape1_6);
/* 62 */     this.shape1.func_78792_a(this.shape1_3);
/* 63 */     this.shape1.func_78792_a(this.shape1_8);
/* 64 */     this.shape1.func_78792_a(this.shape1_9);
/* 65 */     this.shape1.func_78792_a(this.shape1_2);
/* 66 */     this.shape1.func_78792_a(this.shape1_1);
/* 67 */     this.shape1.func_78792_a(this.shape1_4);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 72 */     this.shape1.func_78785_a(f5);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 79 */     modelRenderer.field_78795_f = x;
/* 80 */     modelRenderer.field_78796_g = y;
/* 81 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelPlinth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */