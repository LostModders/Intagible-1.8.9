/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.api.golem.IGolem;
/*    */ import emoniph.intangible.client.models.ModelGolemHead;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemHead implements emoniph.intangible.api.golem.IGolemHead
/*    */ {
/*    */   private final int healthBonus;
/*    */   private final int armorBonus;
/*    */   private final ResourceLocation texture;
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected ModelGolemHead model;
/*    */   
/*    */   public GolemHead(int healthBonus, int armorBonus, ResourceLocation texture)
/*    */   {
/* 20 */     this.healthBonus = healthBonus;
/* 21 */     this.texture = texture;
/* 22 */     this.armorBonus = armorBonus;
/*    */   }
/*    */   
/*    */   public float getHealthBonus() {
/* 26 */     return this.healthBonus;
/*    */   }
/*    */   
/*    */ 
/*    */   public void onUpdate(IGolem golem, BlockPos prevBlockPos) {}
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ResourceLocation getTexture()
/*    */   {
/* 36 */     return this.texture;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public net.minecraft.client.model.ModelRenderer getModel()
/*    */   {
/* 45 */     if (this.model == null) {
/* 46 */       this.model = new emoniph.intangible.client.models.ModelGolemHeadArmored();
/*    */     }
/* 48 */     return this.model.head;
/*    */   }
/*    */   
/*    */   public int getArmorBonus()
/*    */   {
/* 53 */     return this.armorBonus;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */