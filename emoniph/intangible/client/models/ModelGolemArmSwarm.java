/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemArmSwarm extends ModelGolemArm
/*    */ {
/*    */   public ModelGolemArmSwarm(BodySide side)
/*    */   {
/* 13 */     super(side);
/*    */     
/* 15 */     this.arm = new ModelRenderer(this, 0, 14);
/* 16 */     this.arm.func_78793_a(0.0F, -10.0F, 0.0F);
/* 17 */     this.arm.func_78790_a(-3.5F, -7.0F, -5.0F, 7, 14, 10, 0.0F);
/*    */     
/* 19 */     ModelRenderer nobbin1 = new ModelRenderer(this, 35, 25);
/* 20 */     nobbin1.func_78793_a(-5.0F, -2.5F, -2.5F);
/* 21 */     nobbin1.func_78790_a(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
/*    */     
/* 23 */     ModelRenderer nobbin2 = new ModelRenderer(this, 35, 25);
/* 24 */     nobbin2.func_78793_a(3.0F, -2.5F, -2.5F);
/* 25 */     nobbin2.func_78790_a(0.0F, 0.0F, 0.0F, 2, 5, 5, 0.0F);
/*    */     
/* 27 */     this.arm.func_78792_a(nobbin1);
/* 28 */     this.arm.func_78792_a(nobbin2);
/*    */   }
/*    */   
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side)
/*    */   {
/* 33 */     ModelRenderer tmp4_1 = this.arm;tmp4_1.field_78800_c = ((float)(tmp4_1.field_78800_c + (side == BodySide.RIGHT ? -15.5D : 15.5D)));
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemArmSwarm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */