/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ 
/*    */ public class SpellSwarm extends SpellSeeker
/*    */ {
/*    */   public SpellSwarm()
/*    */   {
/* 11 */     super(16777215, 65280, 8);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 17 */     if (movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.ENTITY) {
/* 18 */       if ((movingObject.field_72308_g instanceof EntityLivingBase)) {
/* 19 */         EntityLivingBase target = (EntityLivingBase)movingObject.field_72308_g;
/* 20 */         if (target == caster) {
/* 21 */           return target.func_70097_a(net.minecraft.util.DamageSource.func_76354_b(spellEntity, null), 1.0F);
/*    */         }
/* 23 */         return target.func_70097_a(net.minecraft.util.DamageSource.func_76354_b(spellEntity, caster), 1.0F);
/*    */       }
/*    */       
/* 26 */       return true;
/*    */     }
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellSwarm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */