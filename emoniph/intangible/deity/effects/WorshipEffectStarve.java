/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.spells.grenades.SpellGrenade;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipEffectStarve implements emoniph.intangible.api.deity.IDeityWorshipEffect
/*    */ {
/*    */   public void performWorshipEffect(World world, BlockPos pos, EntityLivingBase target, IDeity deity)
/*    */   {
/* 16 */     if ((target instanceof EntityPlayer)) {
/* 17 */       PlayerEx.get((EntityPlayer)target).enableEffectWithCooldown(Get.effects().STARVING, emoniph.intangible.util.TickUtil.fromSeconds(600));
/*    */     }
/*    */   }
/*    */   
/*    */   public void performPriestEffect(EntityPlayer player, EntityLivingBase target, IDeity deity)
/*    */   {
/* 23 */     Get.spells().WILT.throwGrenade(player);
/*    */   }
/*    */   
/*    */   public boolean customTargetting()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/WorshipEffectStarve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */