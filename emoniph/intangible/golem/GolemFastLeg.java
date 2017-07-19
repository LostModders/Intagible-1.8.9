/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import emoniph.intangible.client.models.ModelGolemLeg;
/*    */ import emoniph.intangible.client.models.ModelGolemLegFast;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemFastLeg
/*    */   extends GolemLeg
/*    */ {
/*    */   public GolemFastLeg(double speedBoost, int bonusThrusts, ResourceLocation texture)
/*    */   {
/* 15 */     super(speedBoost, bonusThrusts, texture);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected ModelGolemLeg createModel(BodySide side) {
/* 20 */     return new ModelGolemLegFast(side);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemFastLeg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */