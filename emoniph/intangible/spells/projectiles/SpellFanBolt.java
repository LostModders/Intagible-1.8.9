/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.MovingObjectPosition.MovingObjectType;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellFanBolt
/*    */   extends SpellProjectile
/*    */ {
/*    */   private final float damageBase;
/*    */   private final float damageVariable;
/*    */   
/*    */   public SpellFanBolt(float damageBase, float damageVariable)
/*    */   {
/* 20 */     super(13107, 3368550);
/* 21 */     this.damageBase = damageBase;
/* 22 */     this.damageVariable = damageVariable;
/*    */   }
/*    */   
/*    */   protected int getRebellionIncrease(EntityPlayer player, boolean unexpected, boolean overclocked)
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */   public int getMaxAirTicks()
/*    */   {
/* 32 */     return 6;
/*    */   }
/*    */   
/*    */   public EntitySpell launchProjectile(EntityLivingBase source) {
/* 36 */     World world = source.func_130014_f_();
/* 37 */     EntitySpell projectile = new EntitySpell(world, source, this, 0.3D);
/* 38 */     projectile.setColor(this.colorInner, this.colorOuter, 1.0F);
/* 39 */     world.func_72838_d(projectile);
/*    */     
/*    */ 
/* 42 */     projectile = new EntitySpell(world, source, this, 0.3D, -30.0F);
/* 43 */     projectile.setColor(this.colorInner, this.colorOuter, 1.0F);
/* 44 */     world.func_72838_d(projectile);
/*    */     
/* 46 */     projectile = new EntitySpell(world, source, this, 0.3D, -60.0F);
/* 47 */     projectile.setColor(this.colorInner, this.colorOuter, 1.0F);
/* 48 */     world.func_72838_d(projectile);
/*    */     
/* 50 */     projectile = new EntitySpell(world, source, this, 0.3D, 30.0F);
/* 51 */     projectile.setColor(this.colorInner, this.colorOuter, 1.0F);
/* 52 */     world.func_72838_d(projectile);
/*    */     
/*    */ 
/* 55 */     projectile = new EntitySpell(world, source, this, 0.3D, 60.0F);
/* 56 */     projectile.setColor(this.colorInner, this.colorOuter, 1.0F);
/* 57 */     world.func_72838_d(projectile);
/*    */     
/* 59 */     return projectile;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 65 */     if (movingObject.field_72313_a == MovingObjectPosition.MovingObjectType.ENTITY) {
/* 66 */       if ((movingObject.field_72308_g instanceof EntityLivingBase)) {
/* 67 */         EntityLivingBase target = (EntityLivingBase)movingObject.field_72308_g;
/*    */         
/* 69 */         float damage = this.damageBase + Math.round(spellEntity.field_70170_p.field_73012_v.nextFloat() * this.damageVariable);
/* 70 */         if (spellEntity.isBehaviourOverclocked()) {
/* 71 */           damage += 2.0F;
/*    */         }
/* 73 */         target.func_70097_a(DamageSource.func_76354_b(spellEntity, caster), damage);
/*    */       }
/*    */       
/* 76 */       return true;
/*    */     }
/* 78 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellFanBolt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */