/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemArmAxe extends ModelGolemArm
/*    */ {
/*    */   public ModelRenderer armAxeHead;
/*    */   public ModelRenderer armAxePole;
/*    */   public ModelRenderer armAxeBladeF1;
/*    */   public ModelRenderer armAxeBladeF2;
/*    */   public ModelRenderer armAxeBladeF3;
/*    */   public ModelRenderer armAxeBladeB1;
/*    */   public ModelRenderer armAxeBladeB2;
/*    */   public ModelRenderer armAxeBladeB3;
/*    */   
/*    */   public ModelGolemArmAxe(BodySide side)
/*    */   {
/* 22 */     super(side);
/*    */     
/* 24 */     this.arm = new ModelRenderer(this, 36, 0);
/* 25 */     this.arm.field_78809_i = (side == BodySide.LEFT);
/* 26 */     this.arm.func_78793_a(-13.0F, -10.0F, 0.0F);
/* 27 */     this.arm.func_78790_a(-2.0F, -2.5F, -2.5F, 4, 11, 5, 0.0F);
/*    */     
/* 29 */     this.armAxePole = new ModelRenderer(this, 94, 0);
/* 30 */     this.armAxePole.field_78809_i = (side == BodySide.LEFT);
/* 31 */     this.armAxePole.func_78793_a(0.0F, 0.0F, 0.0F);
/* 32 */     this.armAxePole.func_78790_a(-1.0F, 8.5F, -1.5F, 2, 12, 3, 0.0F);
/*    */     
/* 34 */     this.armAxeHead = new ModelRenderer(this, 110, 33);
/* 35 */     this.armAxeHead.field_78809_i = (side == BodySide.LEFT);
/* 36 */     this.armAxeHead.func_78793_a(0.0F, 0.0F, 0.0F);
/* 37 */     this.armAxeHead.func_78790_a(-1.5F, 14.0F, -3.0F, 3, 5, 6, 0.0F);
/*    */     
/* 39 */     this.armAxeBladeB1 = new ModelRenderer(this, 94, 15);
/* 40 */     this.armAxeBladeB1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 41 */     this.armAxeBladeB1.func_78790_a(-0.5F, 13.0F, 3.0F, 1, 7, 2, 0.0F);
/* 42 */     this.armAxeBladeB2 = new ModelRenderer(this, 100, 15);
/* 43 */     this.armAxeBladeB2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 44 */     this.armAxeBladeB2.func_78790_a(-0.5F, 12.0F, 5.0F, 1, 9, 2, 0.0F);
/* 45 */     this.armAxeBladeB3 = new ModelRenderer(this, 90, 16);
/* 46 */     this.armAxeBladeB3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 47 */     this.armAxeBladeB3.func_78790_a(-0.5F, 13.5F, 7.0F, 1, 6, 1, 0.0F);
/*    */     
/* 49 */     this.armAxeBladeF1 = new ModelRenderer(this, 94, 15);
/* 50 */     this.armAxeBladeF1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 51 */     this.armAxeBladeF1.func_78790_a(-0.5F, 13.0F, -5.0F, 1, 7, 2, 0.0F);
/* 52 */     this.armAxeBladeF2 = new ModelRenderer(this, 100, 15);
/* 53 */     this.armAxeBladeF2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 54 */     this.armAxeBladeF2.func_78790_a(-0.5F, 12.0F, -7.0F, 1, 9, 2, 0.0F);
/* 55 */     this.armAxeBladeF3 = new ModelRenderer(this, 90, 16);
/* 56 */     this.armAxeBladeF3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 57 */     this.armAxeBladeF3.func_78790_a(-0.5F, 13.5F, -8.0F, 1, 6, 1, 0.0F);
/*    */     
/* 59 */     this.arm.func_78792_a(this.armAxeBladeB3);
/* 60 */     this.arm.func_78792_a(this.armAxeHead);
/* 61 */     this.arm.func_78792_a(this.armAxeBladeB2);
/* 62 */     this.arm.func_78792_a(this.armAxeBladeF2);
/* 63 */     this.arm.func_78792_a(this.armAxePole);
/* 64 */     this.arm.func_78792_a(this.armAxeBladeF1);
/* 65 */     this.arm.func_78792_a(this.armAxeBladeF3);
/* 66 */     this.arm.func_78792_a(this.armAxeBladeB1);
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side)
/*    */   {
/* 71 */     this.arm.field_78800_c += (side == BodySide.RIGHT ? -13.0F : 13.0F);
/* 72 */     if (attackTicks > 0) {
/* 73 */       this.arm.field_78795_f = (-2.0F + 1.5F * -func_78172_a(attackTicks - partialTicks, 10.0F));
/* 74 */     } else if (entity.field_70122_E) {
/* 75 */       int direction = side == BodySide.RIGHT ? 1 : -1;
/* 76 */       this.arm.field_78795_f = ((-0.2F - direction * func_78172_a(limbSwing, 13.0F)) * prevLimbSwingAmount);
/*    */     } else {
/* 78 */       this.arm.field_78795_f = 0.0F;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemArmAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */