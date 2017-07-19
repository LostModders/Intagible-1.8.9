/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.api.golem.IGolem;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemHeadEars extends GolemHead
/*    */ {
/*    */   private final int ticksPerHealth;
/*    */   
/*    */   public GolemHeadEars(int healthBonus, int armorBonus, int ticksPerHealth, ResourceLocation texture)
/*    */   {
/* 15 */     super(healthBonus, armorBonus, texture);
/* 16 */     this.ticksPerHealth = ticksPerHealth;
/*    */   }
/*    */   
/*    */   public void onUpdate(IGolem golem, BlockPos prevBlockPos)
/*    */   {
/* 21 */     if (golem.getGolemTicksExisted() % this.ticksPerHealth == 1) {
/* 22 */       golem.healGolem(1.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */   public ModelRenderer getModel()
/*    */   {
/* 29 */     if (this.model == null) {
/* 30 */       this.model = new emoniph.intangible.client.models.ModelGolemHeadEars();
/*    */     }
/* 32 */     return this.model.head;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemHeadEars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */