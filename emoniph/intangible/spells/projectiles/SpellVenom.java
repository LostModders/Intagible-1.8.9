/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ 
/*    */ public class SpellVenom extends SpellProjectile
/*    */ {
/*    */   public SpellVenom()
/*    */   {
/* 13 */     super(8138277, 32526);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(emoniph.intangible.entity.EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 19 */     if (movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.ENTITY) {
/* 20 */       if ((movingObject.field_72308_g instanceof EntityLivingBase)) {
/* 21 */         EntityLivingBase target = (EntityLivingBase)movingObject.field_72308_g;
/*    */         
/* 23 */         if (!target.func_70644_a(Potion.field_76421_d)) {
/* 24 */           target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 200, 1));
/* 25 */           target.func_70097_a(DamageSource.func_76354_b(spellEntity, caster), 2.0F);
/* 26 */         } else if (!target.func_70644_a(Potion.field_82731_v)) {
/* 27 */           target.func_70690_d(new PotionEffect(Potion.field_82731_v.field_76415_H, 120, 0));
/* 28 */           target.func_70097_a(DamageSource.func_76354_b(spellEntity, caster), 4.0F);
/*    */         } else {
/* 30 */           target.func_70097_a(DamageSource.func_76354_b(spellEntity, caster), 14.0F);
/*    */         }
/*    */       }
/* 33 */       return true;
/*    */     }
/* 35 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellVenom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */