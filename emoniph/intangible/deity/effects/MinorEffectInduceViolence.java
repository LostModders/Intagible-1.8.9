/*     */ package emoniph.intangible.deity.effects;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.entity.ai.IDefender;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.potions.ModPotions;
/*     */ import emoniph.intangible.potions.PotionBloodlust;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityLookHelper;
/*     */ import net.minecraft.entity.ai.EntitySenses;
/*     */ import net.minecraft.entity.monster.EntityMob;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.pathfinding.PathEntity;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.pathfinding.PathPoint;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MinorEffectInduceViolence implements emoniph.intangible.api.deity.IDeityMinorWorldEffect
/*     */ {
/*     */   public void onWorldTick(World world, IDeity deity) {}
/*     */   
/*     */   public boolean onEntityJoinWorld(World world, IDeity deity, Entity entity)
/*     */   {
/*  41 */     if ((!world.field_72995_K) && ((entity instanceof EntityCreature))) {
/*  42 */       EntityCreature creature = (EntityCreature)entity;
/*  43 */       if ((creature.func_110148_a(net.minecraft.entity.SharedMonsterAttributes.field_111264_e) == null) && (!(creature instanceof EntityMob))) {
/*  44 */         creature.field_70714_bg.func_75776_a(3, new EntityAIPassiveAttackOnCollide(creature, EntityPlayer.class, 1.2D, false));
/*  45 */         creature.field_70715_bh.func_75776_a(1, new net.minecraft.entity.ai.EntityAIHurtByTarget(creature, true, new Class[0]));
/*  46 */         if (world.field_73012_v.nextInt(10) == 0) {
/*  47 */           creature.field_70715_bh.func_75776_a(5, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(creature, EntityPlayer.class, false));
/*     */         }
/*     */       }
/*     */     }
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isResistant(World world, IDeity deity)
/*     */   {
/*  56 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void performPriestEffect(World world, IDeity deity, EntityPlayer player)
/*     */   {
/*  62 */     float radius = 8.0F;
/*  63 */     float radiusSq = 64.0F;
/*  64 */     float radiusY = 4.0F;
/*     */     
/*  66 */     List<EntityLivingBase> targets = world.func_72872_a(EntityLivingBase.class, player
/*  67 */       .func_174813_aQ().func_72314_b(8.0D, 4.0D, 8.0D));
/*     */     
/*  69 */     for (EntityLivingBase target : targets) {
/*  70 */       if (player.func_70092_e(target.field_70165_t, player.field_70163_u, target.field_70161_v) < 64.0D) {
/*  71 */         if ((target instanceof EntityPlayer)) {
/*  72 */           if (PlayerEx.get((EntityPlayer)target).getWorship().isFollowerOf(world, deity)) {
/*  73 */             doPriestEffectOn(target, player);
/*     */           }
/*  75 */         } else if ((target instanceof EntityTameable)) {
/*  76 */           EntityTameable tameable = (EntityTameable)target;
/*  77 */           if (tameable.func_70902_q() == player) {
/*  78 */             doPriestEffectOn(tameable, player);
/*     */           }
/*  80 */         } else if ((target instanceof IDefender)) {
/*  81 */           IDefender defender = (IDefender)target;
/*  82 */           if (defender.getOwnerEntities().contains(player)) {
/*  83 */             doPriestEffectOn(target, player);
/*     */           }
/*  85 */         } else if ((target instanceof IAvatar)) {
/*  86 */           IAvatar avatar = (IAvatar)target;
/*  87 */           if (!avatar.getDeityId().equals(deity.getId())) {}
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onHarvest(World world, BlockPos pos, List<ItemStack> drops, EntityPlayer harvester, Deity deity) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPlayerUseItemFinish(World worldObj, EntityPlayer entityPlayer, ItemStack item, Deity deity) {}
/*     */   
/*     */ 
/*     */ 
/*     */   private void doPriestEffectOn(EntityLivingBase target, EntityPlayer player)
/*     */   {
/* 107 */     Get.fx().GLOW.sendToAllNear(player, 0.7F, 20, 16711680, new net.minecraft.util.Vec3(player.field_70165_t, player.field_70163_u + 3.0D, player.field_70161_v), 0.1F);
/* 108 */     Get.potions();target.func_70690_d(new net.minecraft.potion.PotionEffect(ModPotions.BLOODLUST.field_76415_H, PotionBloodlust.DEFAULT_DURATION, 0, false, false));
/*     */   }
/*     */   
/*     */   private static class EntityAIPassiveAttackOnCollide extends net.minecraft.entity.ai.EntityAIBase {
/*     */     World worldObj;
/*     */     protected EntityCreature attacker;
/*     */     int attackTick;
/*     */     double speedTowardsTarget;
/*     */     boolean longMemory;
/*     */     PathEntity entityPathEntity;
/*     */     Class<? extends Entity> classTarget;
/*     */     private int delayCounter;
/*     */     private double targetX;
/*     */     private double targetY;
/*     */     private double targetZ;
/* 123 */     private int failedPathFindingPenalty = 0;
/* 124 */     private boolean canPenalize = false;
/*     */     
/*     */     public EntityAIPassiveAttackOnCollide(EntityCreature creature, Class<? extends Entity> targetClass, double speedIn, boolean useLongMemory) {
/* 127 */       this(creature, speedIn, useLongMemory);
/* 128 */       this.classTarget = targetClass;
/*     */     }
/*     */     
/*     */     public EntityAIPassiveAttackOnCollide(EntityCreature creature, double speedIn, boolean useLongMemory) {
/* 132 */       this.attacker = creature;
/* 133 */       this.worldObj = creature.field_70170_p;
/* 134 */       this.speedTowardsTarget = speedIn;
/* 135 */       this.longMemory = useLongMemory;
/* 136 */       func_75248_a(3);
/*     */     }
/*     */     
/*     */     public boolean func_75250_a() {
/* 140 */       EntityLivingBase entitylivingbase = this.attacker.func_70638_az();
/*     */       
/* 142 */       if (entitylivingbase == null)
/* 143 */         return false;
/* 144 */       if (!entitylivingbase.func_70089_S())
/* 145 */         return false;
/* 146 */       if ((this.classTarget != null) && (!this.classTarget.isAssignableFrom(entitylivingbase.getClass()))) {
/* 147 */         return false;
/*     */       }
/* 149 */       if (this.canPenalize) {
/* 150 */         if (--this.delayCounter <= 0) {
/* 151 */           this.entityPathEntity = this.attacker.func_70661_as().func_75494_a(entitylivingbase);
/* 152 */           this.targetX = (4 + this.attacker.func_70681_au().nextInt(7));
/* 153 */           return this.entityPathEntity != null;
/*     */         }
/* 155 */         return true;
/*     */       }
/*     */       
/* 158 */       this.entityPathEntity = this.attacker.func_70661_as().func_75494_a(entitylivingbase);
/* 159 */       return this.entityPathEntity != null;
/*     */     }
/*     */     
/*     */     public boolean func_75253_b()
/*     */     {
/* 164 */       EntityLivingBase entitylivingbase = this.attacker.func_70638_az();
/* 165 */       return !this.longMemory ? false : !this.attacker.func_70661_as().func_75500_f() ? true : !entitylivingbase.func_70089_S() ? false : entitylivingbase == null ? false : this.attacker.func_180485_d(new BlockPos(entitylivingbase));
/*     */     }
/*     */     
/*     */     public void func_75249_e() {
/* 169 */       this.attacker.func_70661_as().func_75484_a(this.entityPathEntity, this.speedTowardsTarget);
/* 170 */       this.delayCounter = 0;
/*     */     }
/*     */     
/*     */     public void func_75251_c() {
/* 174 */       this.attacker.func_70661_as().func_75499_g();
/*     */     }
/*     */     
/*     */     public void func_75246_d() {
/* 178 */       EntityLivingBase entitylivingbase = this.attacker.func_70638_az();
/* 179 */       this.attacker.func_70671_ap().func_75651_a(entitylivingbase, 30.0F, 30.0F);
/* 180 */       double d0 = this.attacker.func_70092_e(entitylivingbase.field_70165_t, entitylivingbase.func_174813_aQ().field_72338_b, entitylivingbase.field_70161_v);
/* 181 */       double d1 = func_179512_a(entitylivingbase);
/* 182 */       this.delayCounter -= 1;
/*     */       
/* 184 */       if (((this.longMemory) || (this.attacker.func_70635_at().func_75522_a(entitylivingbase))) && (this.delayCounter <= 0) && (((this.targetX == 0.0D) && (this.targetY == 0.0D) && (this.targetZ == 0.0D)) || (entitylivingbase.func_70092_e(this.targetX, this.targetY, this.targetZ) >= 1.0D) || (this.attacker.func_70681_au().nextFloat() < 0.05F))) {
/* 185 */         this.targetX = entitylivingbase.field_70165_t;
/* 186 */         this.targetY = entitylivingbase.func_174813_aQ().field_72338_b;
/* 187 */         this.targetZ = entitylivingbase.field_70161_v;
/* 188 */         this.delayCounter = (4 + this.attacker.func_70681_au().nextInt(7));
/*     */         
/* 190 */         if (this.canPenalize) {
/* 191 */           this.targetX += this.failedPathFindingPenalty;
/* 192 */           if (this.attacker.func_70661_as().func_75505_d() != null) {
/* 193 */             PathPoint finalPathPoint = this.attacker.func_70661_as().func_75505_d().func_75870_c();
/* 194 */             if ((finalPathPoint != null) && (entitylivingbase.func_70092_e(finalPathPoint.field_75839_a, finalPathPoint.field_75837_b, finalPathPoint.field_75838_c) < 1.0D)) {
/* 195 */               this.failedPathFindingPenalty = 0;
/*     */             } else
/* 197 */               this.failedPathFindingPenalty += 10;
/*     */           } else {
/* 199 */             this.failedPathFindingPenalty += 10;
/*     */           }
/*     */         }
/*     */         
/* 203 */         if (d0 > 1024.0D) {
/* 204 */           this.delayCounter += 10;
/* 205 */         } else if (d0 > 256.0D) {
/* 206 */           this.delayCounter += 5;
/*     */         }
/*     */         
/* 209 */         if (!this.attacker.func_70661_as().func_75497_a(entitylivingbase, this.speedTowardsTarget)) {
/* 210 */           this.delayCounter += 15;
/*     */         }
/*     */       }
/*     */       
/* 214 */       this.attackTick = Math.max(this.attackTick - 1, 0);
/*     */       
/* 216 */       if ((d0 <= d1) && (this.attackTick <= 0)) {
/* 217 */         this.attackTick = 20;
/*     */         
/* 219 */         if (this.attacker.func_70694_bm() != null) {
/* 220 */           this.attacker.func_71038_i();
/*     */         }
/*     */         
/* 223 */         this.attacker.func_130011_c(entitylivingbase);
/* 224 */         attackEntityAsMob(entitylivingbase);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     protected double func_179512_a(EntityLivingBase attackTarget)
/*     */     {
/* 231 */       return this.attacker.field_70130_N * 2.0F * this.attacker.field_70130_N * 2.0F + attackTarget.field_70130_N;
/*     */     }
/*     */     
/*     */     public boolean attackEntityAsMob(Entity entityIn) {
/* 235 */       float f = 0.3F;
/* 236 */       int i = 0;
/*     */       
/* 238 */       if ((entityIn instanceof EntityLivingBase)) {
/* 239 */         f += EnchantmentHelper.func_152377_a(this.attacker.func_70694_bm(), ((EntityLivingBase)entityIn).func_70668_bt());
/* 240 */         i += EnchantmentHelper.func_77501_a(this.attacker);
/*     */       }
/*     */       
/* 243 */       boolean flag = entityIn.func_70097_a(DamageSource.func_76358_a(this.attacker), f);
/*     */       
/* 245 */       if (flag) {
/* 246 */         if (i > 0) {
/* 247 */           entityIn.func_70024_g(-MathHelper.func_76126_a(this.attacker.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F, 0.1D, MathHelper.func_76134_b(this.attacker.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F);
/* 248 */           this.attacker.field_70159_w *= 0.6D;
/* 249 */           this.attacker.field_70179_y *= 0.6D;
/*     */         }
/*     */         
/* 252 */         int j = EnchantmentHelper.func_90036_a(this.attacker);
/*     */         
/* 254 */         if (j > 0) {
/* 255 */           entityIn.func_70015_d(j * 4);
/*     */         }
/*     */       }
/*     */       
/* 259 */       return flag;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/MinorEffectInduceViolence.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */