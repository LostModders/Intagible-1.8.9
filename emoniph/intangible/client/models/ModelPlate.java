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
/*    */ public class ModelPlate
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer base;
/*    */   public ModelRenderer edge1;
/*    */   public ModelRenderer edge2;
/*    */   public ModelRenderer edge3;
/*    */   public ModelRenderer edge4;
/*    */   public ModelRenderer edge5;
/*    */   public ModelRenderer edge6;
/*    */   public ModelRenderer edge7;
/*    */   public ModelRenderer edge8;
/*    */   
/*    */   public ModelPlate()
/*    */   {
/* 26 */     this.field_78090_t = 32;
/* 27 */     this.field_78089_u = 32;
/* 28 */     this.base = new ModelRenderer(this, 0, 5);
/* 29 */     this.base.func_78793_a(0.0F, 23.0F, 0.0F);
/* 30 */     this.base.func_78790_a(-2.5F, 0.0F, -2.5F, 5, 1, 5, 0.0F);
/* 31 */     this.edge7 = new ModelRenderer(this, 0, 0);
/* 32 */     this.edge7.func_78793_a(0.0F, 22.55F, 0.0F);
/* 33 */     this.edge7.func_78790_a(-3.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 34 */     setRotateAngle(this.edge7, 0.0F, -1.5707964F, 0.0F);
/* 35 */     this.edge2 = new ModelRenderer(this, 0, 0);
/* 36 */     this.edge2.func_78793_a(0.0F, 22.55F, 0.0F);
/* 37 */     this.edge2.func_78790_a(-3.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 38 */     setRotateAngle(this.edge2, 0.0F, 1.5707964F, 0.0F);
/* 39 */     this.edge3 = new ModelRenderer(this, 0, 0);
/* 40 */     this.edge3.func_78793_a(0.0F, 22.55F, 0.0F);
/* 41 */     this.edge3.func_78790_a(-3.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 42 */     this.edge6 = new ModelRenderer(this, 0, 0);
/* 43 */     this.edge6.func_78793_a(0.0F, 22.5F, 0.0F);
/* 44 */     this.edge6.func_78790_a(-3.6F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 45 */     setRotateAngle(this.edge6, 0.0F, 2.3561945F, 0.0F);
/* 46 */     this.edge4 = new ModelRenderer(this, 0, 0);
/* 47 */     this.edge4.func_78793_a(0.0F, 22.5F, 0.0F);
/* 48 */     this.edge4.func_78790_a(-3.6F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 49 */     setRotateAngle(this.edge4, 0.0F, -0.7853982F, 0.0F);
/* 50 */     this.edge5 = new ModelRenderer(this, 0, 0);
/* 51 */     this.edge5.func_78793_a(0.0F, 22.5F, 0.0F);
/* 52 */     this.edge5.func_78790_a(-3.6F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 53 */     setRotateAngle(this.edge5, 0.0F, -2.3561945F, 0.0F);
/* 54 */     this.edge1 = new ModelRenderer(this, 0, 0);
/* 55 */     this.edge1.func_78793_a(0.0F, 22.5F, 0.0F);
/* 56 */     this.edge1.func_78790_a(-3.6F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 57 */     setRotateAngle(this.edge1, 0.0F, 0.7853982F, 0.0F);
/* 58 */     this.edge8 = new ModelRenderer(this, 0, 0);
/* 59 */     this.edge8.func_78793_a(0.0F, 22.55F, 0.0F);
/* 60 */     this.edge8.func_78790_a(-3.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F);
/* 61 */     setRotateAngle(this.edge8, 0.0F, 3.1415927F, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 66 */     this.base.func_78785_a(f5);
/* 67 */     this.edge7.func_78785_a(f5);
/* 68 */     this.edge2.func_78785_a(f5);
/* 69 */     this.edge3.func_78785_a(f5);
/* 70 */     this.edge6.func_78785_a(f5);
/* 71 */     this.edge4.func_78785_a(f5);
/* 72 */     this.edge5.func_78785_a(f5);
/* 73 */     this.edge1.func_78785_a(f5);
/* 74 */     this.edge8.func_78785_a(f5);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 81 */     modelRenderer.field_78795_f = x;
/* 82 */     modelRenderer.field_78796_g = y;
/* 83 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelPlate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */