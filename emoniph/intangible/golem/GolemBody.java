/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.api.golem.IGolem;
/*    */ import emoniph.intangible.api.golem.IGolemBody;
/*    */ import emoniph.intangible.client.models.ModelGolemBody;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemBody implements IGolemBody
/*    */ {
/*    */   private final float healthBoost;
/*    */   private final int armorBonus;
/*    */   
/*    */   public GolemBody(float healthBoost, int armorBonus, ResourceLocation resourceLocation)
/*    */   {
/* 21 */     this.healthBoost = healthBoost;
/* 22 */     this.armorBonus = armorBonus;
/*    */   }
/*    */   
/*    */   public float getHealthBonus()
/*    */   {
/* 27 */     return this.healthBoost;
/*    */   }
/*    */   
/*    */   public int getArmorBonus()
/*    */   {
/* 32 */     return this.armorBonus;
/*    */   }
/*    */   
/*    */   public boolean seatRiderInteract(EntityLiving entity, EntityPlayer player)
/*    */   {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   public boolean requiresSeat()
/*    */   {
/* 42 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 50 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/wreckinggolem.png");
/*    */   
/*    */   public void onUpdate(IGolem golem, BlockPos prevBlockPos) {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/* 55 */   public ResourceLocation getTexture() { return TEXTURE; }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected ModelGolemBody model;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ModelRenderer getModel()
/*    */   {
/* 64 */     if (this.model == null) {
/* 65 */       this.model = new emoniph.intangible.client.models.ModelGolemBodyTank();
/*    */     }
/* 67 */     return this.model.body;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */