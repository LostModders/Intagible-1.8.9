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
/*    */ public class ModelShrine
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer base1;
/*    */   public ModelRenderer base2;
/*    */   
/*    */   public ModelShrine()
/*    */   {
/* 19 */     this.field_78090_t = 32;
/* 20 */     this.field_78089_u = 32;
/* 21 */     this.base1 = new ModelRenderer(this, 0, 11);
/* 22 */     this.base1.func_78793_a(0.0F, 20.0F, 0.0F);
/* 23 */     this.base1.func_78790_a(-3.0F, 0.0F, -3.0F, 6, 2, 6, 0.0F);
/* 24 */     this.base2 = new ModelRenderer(this, 0, 0);
/* 25 */     this.base2.func_78793_a(0.0F, 22.0F, 0.0F);
/* 26 */     this.base2.func_78790_a(-4.0F, 0.0F, -4.0F, 8, 2, 8, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 31 */     this.base1.func_78785_a(f5);
/* 32 */     this.base2.func_78785_a(f5);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 39 */     modelRenderer.field_78795_f = x;
/* 40 */     modelRenderer.field_78796_g = y;
/* 41 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelShrine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */