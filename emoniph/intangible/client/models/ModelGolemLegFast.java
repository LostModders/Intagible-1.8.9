/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemLegFast extends ModelGolemLeg
/*    */ {
/*    */   public ModelGolemLegFast(BodySide side)
/*    */   {
/* 13 */     super(side);
/* 14 */     this.field_78090_t = 128;
/* 15 */     this.field_78089_u = 64;
/*    */     
/* 17 */     if (side == BodySide.LEFT) {
/* 18 */       this.leg = new ModelRenderer(this, 106, 0);
/* 19 */       this.leg.field_78809_i = true;
/* 20 */       this.leg.func_78793_a(5.0F, 11.0F, 1.0F);
/* 21 */       this.leg.func_78790_a(-3.5F, -3.0F, -3.0F, 6, 15, 5, 0.0F);
/*    */     } else {
/* 23 */       this.leg = new ModelRenderer(this, 106, 0);
/* 24 */       this.leg.func_78793_a(-4.0F, 11.0F, 1.0F);
/* 25 */       this.leg.func_78790_a(-3.5F, -3.0F, -3.0F, 6, 15, 5, 0.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side) {
/* 30 */     if (entity.field_70122_E) {
/* 31 */       if (side == BodySide.LEFT) {
/* 32 */         this.leg.field_78795_f = (-0.0F + -1.5F * func_78172_a(limbSwing, 13.0F) * prevLimbSwingAmount);
/*    */       } else {
/* 34 */         this.leg.field_78795_f = (-0.0F + 1.5F * func_78172_a(limbSwing, 13.0F) * prevLimbSwingAmount);
/*    */       }
/* 36 */       this.leg.field_78796_g = 0.0F;
/*    */     } else {
/* 38 */       this.leg.field_78795_f = 0.5F;
/* 39 */       this.leg.field_78796_g = 0.0F;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemLegFast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */