/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockShell;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.MovingObjectPosition.MovingObjectType;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellDoomBolt extends SpellProjectile
/*    */ {
/*    */   private final float damageBase;
/*    */   private final float damageVariable;
/*    */   
/*    */   public SpellDoomBolt(float damageBase, float damageVariable)
/*    */   {
/* 21 */     super(13056, 16711935);
/* 22 */     this.damageBase = damageBase;
/* 23 */     this.damageVariable = damageVariable;
/*    */   }
/*    */   
/*    */   protected int getRebellionIncrease(EntityPlayer player, boolean unexpected, boolean overclocked)
/*    */   {
/* 28 */     return unexpected ? 1 : overclocked ? 3 : 0;
/*    */   }
/*    */   
/*    */   public boolean canTargetIncorporealEntities()
/*    */   {
/* 33 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(final EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 39 */     if (movingObject.field_72313_a == MovingObjectPosition.MovingObjectType.ENTITY) {
/* 40 */       if ((movingObject.field_72308_g instanceof EntityLivingBase)) {
/* 41 */         EntityLivingBase target = (EntityLivingBase)movingObject.field_72308_g;
/* 42 */         target.func_70097_a(net.minecraft.util.DamageSource.func_76354_b(spellEntity, caster), this.damageBase + 
/* 43 */           Math.round(spellEntity.field_70170_p.field_73012_v.nextFloat() * this.damageVariable));
/* 44 */         if (spellEntity.isBehaviourUnexpected()) {
/* 45 */           spellEntity.ignoreEntity(target);
/* 46 */           spellEntity.ignoreEntity(caster);
/* 47 */           double r = 32.0D;
/* 48 */           java.util.List<EntityLivingBase> nearbyEntities = spellEntity.field_70170_p.func_175647_a(EntityLivingBase.class, spellEntity.func_174813_aQ().func_72314_b(r, r * 0.5D, r), new com.google.common.base.Predicate() {
/*    */             public boolean apply(@javax.annotation.Nullable EntityLivingBase input) {
/* 50 */               return !spellEntity.canIgnoreEntity(input);
/*    */             }
/*    */           });
/*    */           
/* 54 */           if ((spellEntity.isBehaviourOverclocked()) && (spellEntity.getBounces() < 2)) {
/* 55 */             for (EntityLivingBase nextEntity : nearbyEntities) {
/* 56 */               if ((nextEntity != null) && (nextEntity.func_70089_S())) {
/* 57 */                 launchProjectile(caster, spellEntity, nextEntity, this.colorInner, this.colorOuter, 1.0F).copyBehaviourFrom(spellEntity).increaseBounces();
/*    */               }
/*    */             }
/* 60 */           } else if (spellEntity.getBounces() < 4) {
/* 61 */             EntityLivingBase closest = null;
/* 62 */             double closestDistSq = Double.MAX_VALUE;
/* 63 */             for (EntityLivingBase nextEntity : nearbyEntities) {
/* 64 */               if ((nextEntity != null) && (nextEntity.func_70089_S())) {
/* 65 */                 double distSq = spellEntity.func_70068_e(nextEntity);
/* 66 */                 if ((closest == null) || (distSq < closestDistSq)) {
/* 67 */                   closest = nextEntity;
/* 68 */                   closestDistSq = distSq;
/*    */                 }
/*    */               }
/*    */             }
/* 72 */             if (closest != null) {
/* 73 */               launchProjectile(caster, spellEntity, closest, this.colorInner, this.colorOuter, 1.0F).copyBehaviourFrom(spellEntity).increaseBounces();
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/* 78 */       return true; }
/* 79 */     if ((movingObject.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) && ((caster instanceof EntityPlayer)) && 
/* 80 */       (!spellEntity.isBehaviourUnexpected()) && (spellEntity.isBehaviourOverclocked())) {
/* 81 */       IBlockState state = spellEntity.field_70170_p.func_180495_p(movingObject.func_178782_a());
/* 82 */       if ((state.func_177230_c() == Get.blocks().PLAYER_SHELL) && 
/* 83 */         (Get.blocks().PLAYER_SHELL.isOwner(spellEntity.field_70170_p, movingObject.func_178782_a(), state, (EntityPlayer)caster))) {
/* 84 */         Get.blocks().PLAYER_SHELL.removeBody(spellEntity.field_70170_p, movingObject.func_178782_a(), state, (EntityPlayer)caster);
/* 85 */         return true;
/*    */       }
/*    */     }
/* 88 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellDoomBolt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */