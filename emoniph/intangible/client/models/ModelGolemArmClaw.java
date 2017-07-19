/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemArmClaw extends ModelGolemArm
/*    */ {
/*    */   public ModelRenderer clawRight;
/*    */   public ModelRenderer clawLeft;
/*    */   public ModelRenderer clawRight2;
/*    */   public ModelRenderer clawLeft2;
/*    */   
/*    */   public ModelGolemArmClaw(BodySide side)
/*    */   {
/* 18 */     super(side);
/* 19 */     this.arm = new ModelRenderer(this, 36, 0);
/* 20 */     this.arm.field_78809_i = (side == BodySide.LEFT);
/* 21 */     this.arm.func_78793_a(11.0F, -10.0F, 0.0F);
/* 22 */     this.arm.func_78790_a(-2.0F, -2.5F, -2.5F, 4, 17, 5, 0.0F);
/*    */     
/* 24 */     this.clawLeft = new ModelRenderer(this, 53, 23);
/* 25 */     this.clawLeft.field_78809_i = (side == BodySide.LEFT);
/* 26 */     this.clawLeft.func_78793_a(1.0F, 14.5F, 0.0F);
/* 27 */     this.clawLeft.func_78790_a(-3.0F, 0.0F, -1.0F, 6, 5, 1, 0.0F);
/* 28 */     setRotateAngle(this.clawLeft, -0.5009095F, -1.5707964F, 0.0F);
/*    */     
/* 30 */     this.clawLeft2 = new ModelRenderer(this, 52, 31);
/* 31 */     this.clawLeft2.field_78809_i = (side == BodySide.LEFT);
/* 32 */     this.clawLeft2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 33 */     this.clawLeft2.func_78790_a(-3.5F, 2.0F, -4.7F, 7, 5, 1, 0.0F);
/* 34 */     setRotateAngle(this.clawLeft2, 0.9599311F, 0.0F, 0.0F);
/*    */     
/* 36 */     this.clawRight = new ModelRenderer(this, 53, 23);
/* 37 */     this.clawRight.field_78809_i = (side == BodySide.LEFT);
/* 38 */     this.clawRight.func_78793_a(-1.0F, 14.5F, 0.0F);
/* 39 */     this.clawRight.func_78790_a(-3.0F, 0.0F, -1.0F, 6, 5, 1, 0.0F);
/* 40 */     setRotateAngle(this.clawRight, -0.5009095F, 1.5707964F, 0.0F);
/*    */     
/* 42 */     this.clawRight2 = new ModelRenderer(this, 52, 31);
/* 43 */     this.clawRight2.field_78809_i = (side == BodySide.LEFT);
/* 44 */     this.clawRight2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 45 */     this.clawRight2.func_78790_a(-3.5F, 2.0F, -4.7F, 7, 5, 1, 0.0F);
/* 46 */     setRotateAngle(this.clawRight2, 0.9599311F, 0.0F, 0.0F);
/*    */     
/* 48 */     this.arm.func_78792_a(this.clawLeft);
/* 49 */     this.clawLeft.func_78792_a(this.clawLeft2);
/* 50 */     this.arm.func_78792_a(this.clawRight);
/* 51 */     this.clawRight.func_78792_a(this.clawRight2);
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side)
/*    */   {
/* 56 */     this.arm.field_78800_c += (side == BodySide.RIGHT ? -13.0F : 13.0F);
/*    */     
/* 58 */     if (attackTicks > 0) {
/* 59 */       this.arm.field_78795_f = (-1.8F + 0.8F * func_78172_a(attackTicks - partialTicks, 10.0F));
/* 60 */       this.clawLeft.field_78795_f = (-0.5F - 0.3F * func_78172_a(attackTicks - partialTicks, 10.0F));
/* 61 */       this.clawRight.field_78795_f = this.clawLeft.field_78795_f;
/* 62 */     } else if (entity.field_70122_E) {
/* 63 */       int direction = side == BodySide.RIGHT ? 1 : -1;
/* 64 */       this.arm.field_78795_f = ((-0.2F - direction * func_78172_a(limbSwing, 13.0F)) * prevLimbSwingAmount);
/*    */       
/* 66 */       this.clawLeft.field_78795_f = -0.5F;
/* 67 */       this.clawRight.field_78795_f = -0.5F;
/*    */     } else {
/* 69 */       this.arm.field_78795_f = 0.0F;
/*    */       
/* 71 */       this.clawLeft.field_78795_f = -0.5F;
/* 72 */       this.clawRight.field_78795_f = -0.5F;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemArmClaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */