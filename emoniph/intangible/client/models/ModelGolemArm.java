/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public abstract class ModelGolemArm extends ModelBase
/*    */ {
/*    */   public ModelRenderer arm;
/*    */   protected final BodySide side;
/*    */   
/*    */   public ModelGolemArm(BodySide side)
/*    */   {
/* 17 */     this.side = side;
/* 18 */     this.field_78090_t = 128;
/* 19 */     this.field_78089_u = 64;
/*    */   }
/*    */   
/*    */   protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
/* 23 */     modelRenderer.field_78795_f = x;
/* 24 */     modelRenderer.field_78796_g = y;
/* 25 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */   
/*    */ 
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side) {}
/*    */   
/*    */   protected float func_78172_a(float p_78172_1_, float p_78172_2_)
/*    */   {
/* 33 */     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemArm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */