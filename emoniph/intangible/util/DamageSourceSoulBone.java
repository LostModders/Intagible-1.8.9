/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class DamageSourceSoulBone extends net.minecraft.util.EntityDamageSource
/*    */ {
/*    */   public DamageSourceSoulBone(Entity damageSourceEntityIn, boolean bypassArmor) {
/*  8 */     super("player", damageSourceEntityIn);
/*  9 */     if (bypassArmor) {
/* 10 */       func_76348_h();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/DamageSourceSoulBone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */