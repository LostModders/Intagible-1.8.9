/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelDefense
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer gem;
/*    */   public ModelRenderer band;
/*    */   
/*    */   public ModelDefense()
/*    */   {
/* 21 */     this.field_78090_t = 32;
/* 22 */     this.field_78089_u = 32;
/* 23 */     this.band = new ModelRenderer(this, 0, 0);
/* 24 */     this.band.func_78793_a(0.0F, 14.0F, 0.0F);
/* 25 */     this.band.func_78790_a(-7.0F, -2.0F, -0.5F, 1, 4, 1, 0.0F);
/* 26 */     this.gem = new ModelRenderer(this, 0, 0);
/* 27 */     this.gem.func_78793_a(0.0F, 24.0F, 0.0F);
/* 28 */     this.gem.func_78790_a(0.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F);
/* 29 */     setRotateAngle(this.gem, 0.7853982F, 1.0471976F, -1.5707964F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 34 */     GlStateManager.func_179094_E();
/* 35 */     GlStateManager.func_179109_b(this.gem.field_82906_o, this.gem.field_82908_p, this.gem.field_82907_q);
/* 36 */     GlStateManager.func_179109_b(this.gem.field_78800_c * f5, this.gem.field_78797_d * f5, this.gem.field_78798_e * f5);
/* 37 */     GlStateManager.func_179139_a(1.0D, 3.0D, 1.0D);
/* 38 */     GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/* 39 */     GlStateManager.func_179109_b(-this.gem.field_82906_o, -this.gem.field_82908_p, -this.gem.field_82907_q);
/* 40 */     GlStateManager.func_179109_b(-this.gem.field_78800_c * f5, -this.gem.field_78797_d * f5, -this.gem.field_78798_e * f5);
/* 41 */     this.gem.func_78785_a(f5);
/* 42 */     GlStateManager.func_179121_F();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 49 */     modelRenderer.field_78795_f = x;
/* 50 */     modelRenderer.field_78796_g = y;
/* 51 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDefense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */