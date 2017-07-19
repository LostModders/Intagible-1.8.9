/*    */ package emoniph.intangible.entity.ai;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityCreature;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.pathfinding.PathNavigate;
/*    */ import net.minecraft.pathfinding.PathNavigateGround;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityAIFollowDefended extends net.minecraft.entity.ai.EntityAIBase
/*    */ {
/*    */   private final IDefender theDefender;
/*    */   private final EntityCreature theCreature;
/*    */   private final World theWorld;
/*    */   private final PathNavigate petPathfinder;
/*    */   private final double maxDistSq;
/*    */   private final double minDistSq;
/*    */   private final double field_75336_f;
/*    */   private EntityLivingBase theOwner;
/*    */   private int field_75343_h;
/*    */   private boolean field_75344_i;
/*    */   
/*    */   public EntityAIFollowDefended(IDefender defender, double p_i1625_2_, float minDist, float maxDist)
/*    */   {
/* 28 */     this.theDefender = defender;
/* 29 */     this.theCreature = defender.getDefenderCreature();
/* 30 */     this.theWorld = defender.getDefenderCreature().field_70170_p;
/* 31 */     this.field_75336_f = p_i1625_2_;
/* 32 */     this.petPathfinder = defender.getDefenderCreature().func_70661_as();
/* 33 */     this.minDistSq = (minDist * minDist);
/* 34 */     this.maxDistSq = (maxDist * maxDist);
/* 35 */     func_75248_a(3);
/*    */     
/* 37 */     if (!(defender.getDefenderCreature().func_70661_as() instanceof PathNavigateGround)) {
/* 38 */       throw new IllegalArgumentException("Unsupported mob type for FollowOwnerGoal");
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean func_75250_a() {
/* 43 */     List<EntityLivingBase> owners = this.theDefender.getOwnerEntities();
/* 44 */     if ((owners == null) || (owners.isEmpty()) || (owners.get(0) == null))
/* 45 */       return false;
/* 46 */     if (this.theDefender.isSitting())
/* 47 */       return false;
/* 48 */     if (this.theCreature.func_70068_e((net.minecraft.entity.Entity)owners.get(0)) < this.minDistSq) {
/* 49 */       return false;
/*    */     }
/* 51 */     this.theOwner = ((EntityLivingBase)owners.get(0));
/* 52 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean func_75253_b()
/*    */   {
/* 59 */     return (!this.petPathfinder.func_75500_f()) && (this.theCreature.func_70068_e(this.theOwner) > this.maxDistSq) && (!this.theDefender.isSitting());
/*    */   }
/*    */   
/*    */   public void func_75249_e() {
/* 63 */     this.field_75343_h = 0;
/* 64 */     PathNavigateGround nav = (PathNavigateGround)this.theCreature.func_70661_as();
/* 65 */     this.field_75344_i = nav.func_179689_e();
/* 66 */     nav.func_179690_a(false);
/*    */   }
/*    */   
/*    */   public void func_75251_c() {
/* 70 */     this.theOwner = null;
/* 71 */     this.petPathfinder.func_75499_g();
/* 72 */     ((PathNavigateGround)this.theCreature.func_70661_as()).func_179690_a(true);
/*    */   }
/*    */   
/*    */   public void func_75246_d() {
/* 76 */     this.theCreature.func_70671_ap().func_75651_a(this.theOwner, 10.0F, this.theCreature.func_70646_bf());
/*    */     
/* 78 */     if ((!this.theDefender.isSitting()) && 
/* 79 */       (--this.field_75343_h <= 0)) {
/* 80 */       this.field_75343_h = 10;
/*    */       
/* 82 */       if ((!this.petPathfinder.func_75497_a(this.theOwner, this.field_75336_f)) && 
/* 83 */         (!this.theCreature.func_110167_bD()) && 
/* 84 */         (this.theCreature.func_70068_e(this.theOwner) >= 144.0D)) {
/* 85 */         int i = MathHelper.func_76128_c(this.theOwner.field_70165_t) - 2;
/* 86 */         int j = MathHelper.func_76128_c(this.theOwner.field_70161_v) - 2;
/* 87 */         int k = MathHelper.func_76128_c(this.theOwner.func_174813_aQ().field_72338_b);
/*    */         
/* 89 */         for (int l = 0; l <= 4; l++) {
/* 90 */           for (int i1 = 0; i1 <= 4; i1++) {
/* 91 */             if (((l < 1) || (i1 < 1) || (l > 3) || (i1 > 3)) && 
/* 92 */               (World.func_175683_a(this.theWorld, new BlockPos(i + l, k - 1, j + i1))) && 
/* 93 */               (!this.theWorld.func_180495_p(new BlockPos(i + l, k, j + i1)).func_177230_c().func_149686_d()) && 
/* 94 */               (!this.theWorld.func_180495_p(new BlockPos(i + l, k + 1, j + i1)).func_177230_c().func_149686_d())) {
/* 95 */               this.theCreature.func_70012_b(i + l + 0.5F, k, j + i1 + 0.5F, this.theCreature.field_70177_z, this.theCreature.field_70125_A);
/* 96 */               this.petPathfinder.func_75499_g();
/* 97 */               return;
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/ai/EntityAIFollowDefended.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */