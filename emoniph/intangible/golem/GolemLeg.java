/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import emoniph.intangible.client.models.ModelGolemLeg;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemLeg implements emoniph.intangible.api.golem.IGolemLeg
/*    */ {
/*    */   private final ResourceLocation texture;
/*    */   private final double speedBoost;
/*    */   private final int bonusThrusts;
/*    */   @SideOnly(Side.CLIENT)
/*    */   private ModelGolemLeg modelLeft;
/*    */   @SideOnly(Side.CLIENT)
/*    */   private ModelGolemLeg modelRight;
/*    */   
/*    */   public GolemLeg(double speedBoost, int bonusThrusts, ResourceLocation texture)
/*    */   {
/* 21 */     this.texture = texture;
/* 22 */     this.speedBoost = speedBoost;
/* 23 */     this.bonusThrusts = bonusThrusts;
/*    */   }
/*    */   
/*    */   public double getSpeedBonus()
/*    */   {
/* 28 */     return this.speedBoost;
/*    */   }
/*    */   
/*    */   public double getThrustBonus()
/*    */   {
/* 33 */     return this.bonusThrusts;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onUpdate(emoniph.intangible.api.golem.IGolem golem, net.minecraft.util.BlockPos prevBlockPos) {}
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ResourceLocation getTexture(BodySide side)
/*    */   {
/* 44 */     return this.texture;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   private ModelGolemLeg getModelForSide(BodySide side)
/*    */   {
/* 55 */     switch (side) {
/*    */     case RIGHT: 
/* 57 */       if (this.modelRight == null) {
/* 58 */         this.modelRight = createModel(side);
/*    */       }
/* 60 */       return this.modelRight;
/*    */     }
/*    */     
/* 63 */     if (this.modelLeft == null) {
/* 64 */       this.modelLeft = createModel(side);
/*    */     }
/* 66 */     return this.modelLeft;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected ModelGolemLeg createModel(BodySide side)
/*    */   {
/* 72 */     return new emoniph.intangible.client.models.ModelGolemLegJump(side);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public net.minecraft.client.model.ModelRenderer getModel(BodySide side)
/*    */   {
/* 78 */     return getModelForSide(side).leg;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void updateModelRotation(net.minecraft.entity.EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side)
/*    */   {
/* 84 */     getModelForSide(side).updateModelRotation(entity, limbSwing, prevLimbSwingAmount, partialTicks, attackTicks, side);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemLeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */