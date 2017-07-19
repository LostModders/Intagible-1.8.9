/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemArmHammer extends ModelGolemArm
/*    */ {
/*    */   public ModelRenderer armRight1;
/*    */   
/*    */   public ModelGolemArmHammer(BodySide side)
/*    */   {
/* 15 */     super(side);
/* 16 */     this.arm = new ModelRenderer(this, 36, 0);
/* 17 */     this.arm.func_78793_a(9.0F, -10.0F, 0.0F);
/* 18 */     this.arm.field_78809_i = (side == BodySide.LEFT);
/* 19 */     this.arm.func_78790_a(-2.0F, -2.5F, -2.5F, 4, 17, 5, 0.0F);
/*    */     
/* 21 */     this.armRight1 = new ModelRenderer(this, 55, 0);
/* 22 */     this.armRight1.func_78793_a(-0.5F, 0.0F, 0.0F);
/* 23 */     this.armRight1.field_78809_i = (side == BodySide.LEFT);
/* 24 */     this.armRight1.func_78790_a(-2.0F, 14.5F, -5.0F, 5, 6, 10, 0.0F);
/*    */     
/* 26 */     this.arm.func_78792_a(this.armRight1);
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side)
/*    */   {
/* 31 */     this.arm.field_78800_c += (side == BodySide.RIGHT ? -13.0F : 13.0F);
/* 32 */     if (attackTicks > 0) {
/* 33 */       this.arm.field_78795_f = (-2.0F + 1.5F * -func_78172_a(attackTicks - partialTicks, 10.0F));
/* 34 */     } else if (entity.field_70122_E) {
/* 35 */       int direction = side == BodySide.RIGHT ? 1 : -1;
/* 36 */       this.arm.field_78795_f = ((-0.2F - direction * func_78172_a(limbSwing, 13.0F)) * prevLimbSwingAmount);
/*    */     } else {
/* 38 */       this.arm.field_78795_f = 0.0F;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemArmHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */