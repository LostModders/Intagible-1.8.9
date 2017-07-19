/*    */ package emoniph.intangible.entity.ai;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAITarget;
/*    */ 
/*    */ public class EntityAIDefendedHurtByTarget extends EntityAITarget
/*    */ {
/*    */   private final IDefender theDefender;
/*    */   private EntityLivingBase theOwnerAttacker;
/*    */   private int revengeTimer;
/*    */   private int startRevengeTimer;
/*    */   
/*    */   public EntityAIDefendedHurtByTarget(IDefender defender)
/*    */   {
/* 15 */     super(defender.getDefenderCreature(), false);
/* 16 */     this.theDefender = defender;
/* 17 */     func_75248_a(1);
/*    */   }
/*    */   
/*    */   public boolean func_75250_a() {
/* 21 */     if (!this.theDefender.hasOwner()) {
/* 22 */       return false;
/*    */     }
/* 24 */     java.util.List<EntityLivingBase> ownerEntities = this.theDefender.getOwnerEntities();
/*    */     
/* 26 */     if ((ownerEntities == null) || (ownerEntities.isEmpty()) || (ownerEntities.get(0) == null)) {
/* 27 */       return false;
/*    */     }
/* 29 */     for (EntityLivingBase ownerEntity : ownerEntities) {
/* 30 */       if (ownerEntity != null) {
/* 31 */         this.theOwnerAttacker = ownerEntity.func_70643_av();
/* 32 */         int i = ownerEntity.func_142015_aE();
/* 33 */         this.startRevengeTimer = i;
/* 34 */         if ((i != this.revengeTimer) && (func_75296_a(this.theOwnerAttacker, false)) && 
/* 35 */           (this.theDefender.func_142018_a(this.theOwnerAttacker, ownerEntity))) {
/* 36 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public void func_75249_e() {
/* 46 */     this.field_75299_d.func_70624_b(this.theOwnerAttacker);
/* 47 */     this.revengeTimer = this.startRevengeTimer;
/*    */     
/*    */ 
/* 50 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/ai/EntityAIDefendedHurtByTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */