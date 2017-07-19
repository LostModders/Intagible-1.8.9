/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.api.CastingStyle;
/*    */ import emoniph.intangible.entity.EntitySoul;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellSoulLeash extends SpellProjectile
/*    */ {
/*    */   public SpellSoulLeash()
/*    */   {
/* 15 */     super(13056, 13209);
/*    */   }
/*    */   
/*    */   public CastingStyle getCastingStyle(EntityPlayer player, boolean defaultIcon)
/*    */   {
/* 20 */     if (!defaultIcon) {
/* 21 */       java.util.List<EntitySoul> souls = player.field_70170_p.func_72872_a(EntitySoul.class, player
/* 22 */         .func_174813_aQ().func_72314_b(10.0D, 10.0D, 10.0D));
/* 23 */       for (EntitySoul soul : souls) {
/* 24 */         if ((soul.getSoulLeashed()) && (soul.getSoulLeashedToEntity() == player)) {
/* 25 */           return CastingStyle.INSTANT;
/*    */         }
/*    */       }
/*    */     }
/* 29 */     return super.getCastingStyle(player, defaultIcon);
/*    */   }
/*    */   
/*    */   public void invoke(EntityPlayer player)
/*    */   {
/* 34 */     boolean cast = true;
/* 35 */     java.util.List<EntitySoul> souls = player.field_70170_p.func_72872_a(EntitySoul.class, player
/* 36 */       .func_174813_aQ().func_72314_b(10.0D, 10.0D, 10.0D));
/* 37 */     for (EntitySoul soul : souls) {
/* 38 */       if ((soul.getSoulLeashed()) && (soul.getSoulLeashedToEntity() == player)) {
/* 39 */         soul.clearSoulLeashed(true, false);
/* 40 */         Sound.MOD_RANDOM_POWER_DOWN.playToAllNear(soul, 0.5F, 1.2F);
/* 41 */         cast = false;
/*    */       }
/*    */     }
/* 44 */     if (cast) {
/* 45 */       super.invoke(player);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(emoniph.intangible.entity.EntitySpell spellEntity, MovingObjectPosition movingObject, net.minecraft.entity.EntityLivingBase caster)
/*    */   {
/* 52 */     if (movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.ENTITY) {
/* 53 */       if (((movingObject.field_72308_g instanceof EntitySoul)) && (caster != null)) {
/* 54 */         EntitySoul target = (EntitySoul)movingObject.field_72308_g;
/* 55 */         target.setSoulLeashedToEntity(caster, true);
/* 56 */         Sound.MOD_RANDOM_POWER_UP.playToAllNear(target, 0.5F, 1.2F);
/*    */       }
/* 58 */       return true;
/*    */     }
/* 60 */     return false;
/*    */   }
/*    */   
/*    */   public boolean canTargetIncorporealEntities()
/*    */   {
/* 65 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellSoulLeash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */