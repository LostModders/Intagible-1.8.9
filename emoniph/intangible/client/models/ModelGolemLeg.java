/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public abstract class ModelGolemLeg extends ModelBase
/*    */ {
/*    */   public ModelRenderer leg;
/*    */   protected final BodySide side;
/*    */   
/*    */   public ModelGolemLeg(BodySide side)
/*    */   {
/* 17 */     this.side = side;
/*    */   }
/*    */   
/*    */   protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 21 */     modelRenderer.field_78795_f = x;
/* 22 */     modelRenderer.field_78796_g = y;
/* 23 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side) {
/* 27 */     if (entity.field_70122_E) {
/* 28 */       if (side == BodySide.LEFT) {
/* 29 */         this.leg.field_78795_f = (-0.5F + -1.5F * func_78172_a(limbSwing, 13.0F) * prevLimbSwingAmount);
/*    */       } else {
/* 31 */         this.leg.field_78795_f = (-0.5F + 1.5F * func_78172_a(limbSwing, 13.0F) * prevLimbSwingAmount);
/*    */       }
/* 33 */       this.leg.field_78796_g = 0.0F;
/*    */     } else {
/* 35 */       this.leg.field_78795_f = -0.2F;
/* 36 */       this.leg.field_78796_g = 0.0F;
/*    */     }
/*    */   }
/*    */   
/*    */   protected float func_78172_a(float p_78172_1_, float p_78172_2_) {
/* 41 */     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemLeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */