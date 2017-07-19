/*    */ package emoniph.intangible.spells;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.api.IPassiveEffect;
/*    */ import emoniph.intangible.effects.EffectRegistry;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.util.EnumArmorSlot;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class SpellPassive extends Spell
/*    */ {
/*    */   private final IPassiveEffect passiveEffect;
/*    */   
/*    */   public SpellPassive(IPassiveEffect passiveEffect)
/*    */   {
/* 17 */     super(emoniph.intangible.api.CastingStyle.INSTANT);
/* 18 */     this.passiveEffect = passiveEffect;
/*    */   }
/*    */   
/*    */   public void invoke(EntityPlayer player)
/*    */   {
/* 23 */     PlayerEx playerEx = PlayerEx.get(player);
/* 24 */     if (playerEx.tryToggleEffect(this.passiveEffect)) {
/* 25 */       if (Get.effects().isActiveFor(this.passiveEffect, player)) {
/* 26 */         Sound.MOD_RANDOM_POWER_UP.playToAllNear(player, 1.0F, 1.0F);
/*    */       } else {
/* 28 */         Sound.MOD_RANDOM_POWER_DOWN.playToAllNear(player, 1.0F, 1.0F);
/*    */       }
/*    */     } else {
/* 31 */       Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(player, 1.0F, 1.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   public emoniph.intangible.api.ISoulSet getMaintainCost()
/*    */   {
/* 37 */     return Get.effects().getCostsFor(this.passiveEffect);
/*    */   }
/*    */   
/*    */   public int getInitialRebellionCost()
/*    */   {
/* 42 */     return Get.effects().getInitialRebellionCostsFor(this.passiveEffect);
/*    */   }
/*    */   
/*    */   public boolean arePrerequisitesMet(EntityPlayer player)
/*    */   {
/* 47 */     return (super.arePrerequisitesMet(player)) && (this.passiveEffect.isPrerequisitesMet(player, player
/* 48 */       .func_71124_b(EnumArmorSlot.HEAD.equipmentSlot), player
/* 49 */       .func_71124_b(EnumArmorSlot.CHEST.equipmentSlot), player
/* 50 */       .func_71124_b(EnumArmorSlot.LEGS.equipmentSlot), player
/* 51 */       .func_71124_b(EnumArmorSlot.FEET.equipmentSlot)));
/*    */   }
/*    */   
/*    */   public boolean isActive(EntityPlayer player)
/*    */   {
/* 56 */     return Get.effects().isActiveFor(this.passiveEffect, player);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/SpellPassive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */