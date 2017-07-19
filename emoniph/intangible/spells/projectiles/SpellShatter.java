/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.effects.EffectRegistry;
/*    */ import emoniph.intangible.entity.EntityClone;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import emoniph.intangible.fx.ParticleFactory;
/*    */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellShatter extends SpellProjectile
/*    */ {
/*    */   public SpellShatter()
/*    */   {
/* 20 */     super(13141, 3342591);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 26 */     if ((!spellEntity.field_70170_p.field_72995_K) && ((caster instanceof EntityPlayerMP))) {
/* 27 */       EntityPlayerMP player = (EntityPlayerMP)caster;
/*    */       
/* 29 */       boolean overclocked = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player);
/* 30 */       boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, player);
/*    */       
/* 32 */       List<EntityClone> fuel = new java.util.ArrayList();
/*    */       
/* 34 */       double radius = overclocked ? 16.0D : 8.0D;
/* 35 */       List<EntityLivingBase> list = spellEntity.field_70170_p.func_72872_a(EntityLivingBase.class, spellEntity.func_174813_aQ().func_72314_b(radius, radius * 0.5D, radius));
/* 36 */       for (Iterator<EntityLivingBase> itr = list.iterator(); itr.hasNext();) {
/* 37 */         EntityLivingBase entity = (EntityLivingBase)itr.next();
/* 38 */         if ((entity instanceof EntityClone)) {
/* 39 */           EntityClone clone = (EntityClone)entity;
/* 40 */           if (clone.func_70902_q() == player) {
/* 41 */             fuel.add(clone);
/* 42 */             itr.remove();
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 47 */       if (fuel.size() > 0) {
/* 48 */         float baseDamage = 6.0F;
/* 49 */         float damageRadius = overclocked ? 8.0F : 4.0F;
/* 50 */         float damageRadiusSq = damageRadius * damageRadius;
/* 51 */         for (Iterator localIterator = list.iterator(); localIterator.hasNext();) { entity = (EntityLivingBase)localIterator.next();
/* 52 */           if ((entity != caster) && (entity.func_70068_e(spellEntity) < damageRadiusSq)) {
/* 53 */             entity.func_70097_a(net.minecraft.util.DamageSource.func_76354_b(spellEntity, caster), baseDamage * fuel.size());
/*    */           }
/*    */         }
/*    */         EntityLivingBase entity;
/* 57 */         net.minecraft.util.Vec3 mid = emoniph.intangible.util.EntityUtil.vecFromMidOf(spellEntity);
/*    */         
/* 59 */         for (EntityClone clone : fuel) {
/* 60 */           Get.fx().GLOW.sendToAllNear(clone, 0.5F, 30, 10066227, 1, mid, 0.5F, 16.0D);
/* 61 */           clone.func_70106_y();
/*    */         }
/*    */         
/* 64 */         Get.fx().GLOW.sendToAllNear(spellEntity, 0.5F, 30, 10066227, 3, mid, 0.1F, 16.0D);
/*    */       }
/*    */       
/*    */ 
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellShatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */