/*    */ package emoniph.intangible.entity.ai;
/*    */ 
/*    */ import emoniph.intangible.api.ISoulRelay;
/*    */ import emoniph.intangible.entity.EntitySoul;
/*    */ import net.minecraft.pathfinding.PathNavigate;
/*    */ import net.minecraft.util.BlockPos;
/*    */ 
/*    */ public class EntityAIFollowRelays extends net.minecraft.entity.ai.EntityAIBase
/*    */ {
/*    */   private EntitySoul creature;
/*    */   private BlockPos targetBlock;
/*    */   private double movementSpeed;
/*    */   private net.minecraft.world.World world;
/*    */   
/*    */   public EntityAIFollowRelays(EntitySoul creature, double speed)
/*    */   {
/* 17 */     this.creature = creature;
/* 18 */     this.movementSpeed = speed;
/* 19 */     this.world = creature.field_70170_p;
/*    */     
/* 21 */     func_75248_a(1);
/*    */   }
/*    */   
/*    */   public boolean func_75250_a() {
/* 25 */     if (this.world.field_73012_v.nextInt(10) != 1) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     ISoulRelay relay = emoniph.intangible.Get.relays().findClosest(this.world, new BlockPos(this.creature), this.creature.getVisitedRelays(), 32.0D);
/* 30 */     if (relay == null) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     this.targetBlock = relay.getRelayPos();
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_75251_c()
/*    */   {
/* 41 */     if (this.creature.func_174818_b(this.targetBlock) <= 4.0D) {
/* 42 */       this.creature.visited(this.targetBlock);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean func_75253_b() {
/* 47 */     return !this.creature.func_70661_as().func_75500_f();
/*    */   }
/*    */   
/*    */   public void func_75249_e() {
/* 51 */     this.creature.func_70661_as().func_75492_a(this.targetBlock.func_177958_n(), this.targetBlock.func_177956_o() + 1, this.targetBlock.func_177952_p(), this.movementSpeed);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/ai/EntityAIFollowRelays.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */