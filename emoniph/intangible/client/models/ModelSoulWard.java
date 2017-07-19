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
/*    */ public class ModelSoulWard
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer base;
/*    */   public ModelRenderer mid1;
/*    */   public ModelRenderer mid2;
/*    */   public ModelRenderer mid3;
/*    */   public ModelRenderer mid4;
/*    */   public ModelRenderer top;
/*    */   
/*    */   public ModelSoulWard()
/*    */   {
/* 23 */     this.field_78090_t = 64;
/* 24 */     this.field_78089_u = 32;
/* 25 */     this.top = new ModelRenderer(this, 51, 11);
/* 26 */     this.top.func_78793_a(0.0F, 0.0F, 0.0F);
/* 27 */     this.top.func_78790_a(-1.0F, -26.1F, 6.7F, 2, 5, 2, 0.0F);
/* 28 */     setRotateAngle(this.top, 0.15707964F, 0.0F, 0.0F);
/* 29 */     this.mid4 = new ModelRenderer(this, 38, 9);
/* 30 */     this.mid4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 31 */     this.mid4.func_78790_a(-1.5F, -22.2F, 2.8F, 3, 6, 3, 0.0F);
/* 32 */     setRotateAngle(this.mid4, 0.13962634F, 0.0F, 0.0F);
/* 33 */     this.base = new ModelRenderer(this, 0, 19);
/* 34 */     this.base.func_78793_a(0.0F, 19.0F, 2.5F);
/* 35 */     this.base.func_78790_a(-3.5F, 0.0F, -4.0F, 7, 5, 8, 0.0F);
/* 36 */     this.mid2 = new ModelRenderer(this, 0, 7);
/* 37 */     this.mid2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 38 */     this.mid2.func_78790_a(-2.5F, -11.4F, -1.9F, 5, 6, 5, 0.0F);
/* 39 */     setRotateAngle(this.mid2, 0.10471976F, 0.0F, 0.0F);
/* 40 */     this.mid1 = new ModelRenderer(this, 31, 20);
/* 41 */     this.mid1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 42 */     this.mid1.func_78790_a(-3.0F, -5.7F, -3.0F, 6, 6, 6, 0.0F);
/* 43 */     setRotateAngle(this.mid1, 0.08726646F, 0.0F, 0.0F);
/* 44 */     this.mid3 = new ModelRenderer(this, 21, 8);
/* 45 */     this.mid3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 46 */     this.mid3.func_78790_a(-2.0F, -16.9F, 0.0F, 4, 6, 4, 0.0F);
/* 47 */     setRotateAngle(this.mid3, 0.12217305F, 0.0F, 0.0F);
/* 48 */     this.mid4.func_78792_a(this.top);
/* 49 */     this.mid3.func_78792_a(this.mid4);
/* 50 */     this.mid1.func_78792_a(this.mid2);
/* 51 */     this.base.func_78792_a(this.mid1);
/* 52 */     this.mid2.func_78792_a(this.mid3);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 57 */     this.base.func_78785_a(f5);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 64 */     modelRenderer.field_78795_f = x;
/* 65 */     modelRenderer.field_78796_g = y;
/* 66 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelSoulWard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */