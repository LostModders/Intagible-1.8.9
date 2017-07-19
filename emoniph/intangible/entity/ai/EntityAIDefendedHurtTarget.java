/*    */ package emoniph.intangible.entity.ai;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class EntityAIDefendedHurtTarget extends net.minecraft.entity.ai.EntityAITarget
/*    */ {
/*    */   private final IDefender theDefender;
/*    */   private EntityLivingBase theTarget;
/*    */   private int lastAttackerTime;
/*    */   private int startAttackerTime;
/*    */   
/*    */   public EntityAIDefendedHurtTarget(IDefender defender)
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
/* 24 */     List<EntityLivingBase> ownerEntities = this.theDefender.getOwnerEntities();
/*    */     
/* 26 */     if ((ownerEntities == null) || (ownerEntities.isEmpty())) {
/* 27 */       return false;
/*    */     }
/* 29 */     if (ownerEntities.get(0) != null) {
/* 30 */       this.theTarget = ((EntityLivingBase)ownerEntities.get(0)).func_110144_aD();
/* 31 */       int i = ((EntityLivingBase)ownerEntities.get(0)).func_142013_aG();
/* 32 */       this.startAttackerTime = i;
/*    */       
/* 34 */       return (i != this.lastAttackerTime) && (func_75296_a(this.theTarget, false)) && (this.theDefender.func_142018_a(this.theTarget, (EntityLivingBase)ownerEntities.get(0)));
/*    */     }
/* 36 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_75249_e()
/*    */   {
/* 43 */     this.field_75299_d.func_70624_b(this.theTarget);
/* 44 */     this.lastAttackerTime = this.startAttackerTime;
/*    */     
/* 46 */     super.func_75249_e();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/ai/EntityAIDefendedHurtTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */