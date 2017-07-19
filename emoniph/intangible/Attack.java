/*    */ package emoniph.intangible;
/*    */ 
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*    */ 
/*    */ public class Attack implements emoniph.intangible.api.IAttack
/*    */ {
/*    */   private final DamageSource originalSource;
/*    */   private final float originalDamage;
/*    */   private DamageSource source;
/*    */   private float damage;
/*    */   
/*    */   public Attack(net.minecraftforge.event.entity.living.LivingAttackEvent attackEvent)
/*    */   {
/* 15 */     this(attackEvent.source, attackEvent.ammount);
/*    */   }
/*    */   
/*    */   public Attack(LivingHurtEvent attackEvent) {
/* 19 */     this(attackEvent.source, attackEvent.ammount);
/*    */   }
/*    */   
/*    */   public Attack(DamageSource source, float damage) {
/* 23 */     this.originalSource = (this.source = source);
/* 24 */     this.originalDamage = (this.damage = damage);
/*    */   }
/*    */   
/*    */   public DamageSource getOriginalDamageSource()
/*    */   {
/* 29 */     return this.originalSource;
/*    */   }
/*    */   
/*    */   public float getOriginalDamage()
/*    */   {
/* 34 */     return this.originalDamage;
/*    */   }
/*    */   
/*    */   public DamageSource getDamageSource()
/*    */   {
/* 39 */     return this.source;
/*    */   }
/*    */   
/*    */   public void setDamageSource(DamageSource source)
/*    */   {
/* 44 */     this.source = source;
/*    */   }
/*    */   
/*    */   public float getDamage()
/*    */   {
/* 49 */     return this.damage;
/*    */   }
/*    */   
/*    */   public void setDamage(float damage)
/*    */   {
/* 54 */     this.damage = damage;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/Attack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */