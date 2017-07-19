/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipEffectCowardice implements emoniph.intangible.api.deity.IDeityWorshipEffect
/*    */ {
/*    */   public void performWorshipEffect(World world, BlockPos pos, EntityLivingBase target, IDeity deity)
/*    */   {
/* 17 */     if ((target instanceof EntityPlayer)) {
/* 18 */       PlayerEx.get((EntityPlayer)target).enableEffectWithCooldown(Get.effects().COWARD, TickUtil.fromSeconds(600));
/*    */     }
/*    */   }
/*    */   
/*    */   public void performPriestEffect(EntityPlayer player, EntityLivingBase target, IDeity deity)
/*    */   {
/* 24 */     Get.potions();target.func_70690_d(new PotionEffect(emoniph.intangible.potions.ModPotions.COWARDLY.field_76415_H, TickUtil.fromSeconds(60), 1));
/*    */   }
/*    */   
/*    */   public boolean customTargetting()
/*    */   {
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/WorshipEffectCowardice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */