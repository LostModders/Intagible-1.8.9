/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemLegJump extends ModelGolemLeg
/*    */ {
/*    */   public ModelRenderer leg1;
/*    */   
/*    */   public ModelGolemLegJump(BodySide side)
/*    */   {
/* 15 */     super(side);
/* 16 */     this.field_78090_t = 128;
/* 17 */     this.field_78089_u = 64;
/*    */     
/* 19 */     if (side == BodySide.LEFT) {
/* 20 */       this.leg = new ModelRenderer(this, 83, 37);
/* 21 */       this.leg.field_78809_i = true;
/* 22 */       this.leg.func_78793_a(5.0F, 11.0F, 1.0F);
/* 23 */       this.leg.func_78790_a(-3.5F, -3.0F, -3.0F, 6, 9, 5, 0.0F);
/* 24 */       setRotateAngle(this.leg, -0.68294734F, 0.0F, 0.0F);
/*    */       
/* 26 */       this.leg1 = new ModelRenderer(this, 66, 50);
/* 27 */       this.leg1.field_78809_i = true;
/* 28 */       this.leg1.func_78793_a(0.0F, 11.0F, 0.0F);
/* 29 */       this.leg1.func_78790_a(-3.5F, -8.4F, 2.0F, 6, 9, 5, 0.0F);
/*    */       
/* 31 */       this.leg.func_78792_a(this.leg1);
/*    */     } else {
/* 33 */       this.leg = new ModelRenderer(this, 83, 37);
/* 34 */       this.leg.func_78793_a(-4.0F, 11.0F, 1.0F);
/* 35 */       this.leg.func_78790_a(-3.5F, -3.0F, -3.0F, 6, 9, 5, 0.0F);
/* 36 */       setRotateAngle(this.leg, -0.68294734F, 0.0F, 0.0F);
/*    */       
/* 38 */       this.leg1 = new ModelRenderer(this, 66, 50);
/* 39 */       this.leg1.func_78793_a(0.0F, 11.0F, 0.0F);
/* 40 */       this.leg1.func_78790_a(-3.5F, -8.4F, 2.0F, 6, 9, 5, 0.0F);
/*    */       
/* 42 */       this.leg.func_78792_a(this.leg1);
/*    */     }
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side) {
/* 47 */     if (entity.field_70122_E) {
/* 48 */       if (side == BodySide.LEFT) {
/* 49 */         this.leg.field_78795_f = (-0.5F + -1.5F * func_78172_a(limbSwing, 13.0F) * prevLimbSwingAmount);
/*    */       } else {
/* 51 */         this.leg.field_78795_f = (-0.5F + 1.5F * func_78172_a(limbSwing, 13.0F) * prevLimbSwingAmount);
/*    */       }
/* 53 */       this.leg.field_78796_g = 0.0F;
/*    */     } else {
/* 55 */       this.leg.field_78795_f = -0.2F;
/* 56 */       this.leg.field_78796_g = 0.0F;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemLegJump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */