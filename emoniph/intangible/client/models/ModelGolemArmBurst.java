/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelGolemArmBurst extends ModelGolemArm
/*    */ {
/*    */   public ModelRenderer armLeft1;
/*    */   public ModelRenderer armLeft2_1;
/*    */   public ModelRenderer armLeft3;
/*    */   public ModelRenderer armLeft4;
/*    */   public ModelRenderer armLeft5;
/*    */   public ModelRenderer armLeft6;
/*    */   
/*    */   public ModelGolemArmBurst(BodySide side)
/*    */   {
/* 21 */     super(side);
/*    */     
/* 23 */     float offset = -2.5F;
/*    */     
/* 25 */     this.arm = new ModelRenderer(this, 80, 18);
/* 26 */     this.arm.func_78793_a(11.0F - offset, -8.5F, 0.0F);
/* 27 */     this.arm.func_78790_a(0.0F + offset, -2.5F, -3.0F, 1, 12, 6, 0.0F);
/* 28 */     setRotateAngle(this.arm, -1.5707964F, 0.0F, 0.0F);
/*    */     
/* 30 */     this.armLeft5 = new ModelRenderer(this, 68, 38);
/* 31 */     this.armLeft5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 32 */     this.armLeft5.func_78790_a(-0.5F, -0.5F, 1.0F + offset, 1, 3, 4, 0.0F);
/* 33 */     setRotateAngle(this.armLeft5, 0.0F, 1.5707964F, 0.0F);
/*    */     
/* 35 */     this.armLeft6 = new ModelRenderer(this, 68, 38);
/* 36 */     this.armLeft6.func_78793_a(0.0F, 0.0F, 0.0F);
/* 37 */     this.armLeft6.func_78790_a(2.5F + offset, -0.5F, -2.0F, 1, 3, 4, 0.0F);
/*    */     
/* 39 */     this.armLeft2_1 = new ModelRenderer(this, 69, 18);
/* 40 */     this.armLeft2_1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 41 */     this.armLeft2_1.func_78790_a(2.0F, -2.5F, 1.0F + offset, 1, 12, 4, 0.0F);
/* 42 */     setRotateAngle(this.armLeft2_1, 0.0F, 1.5707964F, 0.0F);
/*    */     
/* 44 */     this.armLeft3 = new ModelRenderer(this, 69, 18);
/* 45 */     this.armLeft3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 46 */     this.armLeft3.func_78790_a(-3.0F, -2.5F, 1.0F + offset, 1, 12, 4, 0.0F);
/* 47 */     setRotateAngle(this.armLeft3, 0.0F, 1.5707964F, 0.0F);
/*    */     
/* 49 */     this.armLeft4 = new ModelRenderer(this, 56, 38);
/* 50 */     this.armLeft4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 51 */     this.armLeft4.func_78790_a(2.0F + offset, -1.5F, -1.0F, 2, 9, 2, 0.0F);
/*    */     
/* 53 */     this.armLeft1 = new ModelRenderer(this, 80, 18);
/* 54 */     this.armLeft1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 55 */     this.armLeft1.func_78790_a(5.0F + offset, -2.5F, -3.0F, 1, 12, 6, 0.0F);
/*    */     
/* 57 */     this.arm.func_78792_a(this.armLeft6);
/* 58 */     this.arm.func_78792_a(this.armLeft2_1);
/* 59 */     this.arm.func_78792_a(this.armLeft3);
/* 60 */     this.arm.func_78792_a(this.armLeft5);
/* 61 */     this.arm.func_78792_a(this.armLeft4);
/* 62 */     this.arm.func_78792_a(this.armLeft1);
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side)
/*    */   {
/* 67 */     this.arm.field_78795_f += -1.5707964F; ModelRenderer 
/* 68 */       tmp18_15 = this.arm;tmp18_15.field_78800_c = ((float)(tmp18_15.field_78800_c + (side == BodySide.RIGHT ? -14.5D : 13.5D)));
/* 69 */     this.arm.field_78798_e = -1.0F;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemArmBurst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */