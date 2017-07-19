/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarPower;
/*     */ import emoniph.intangible.deity.IPlayerWorship;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.entity.ai.EntityAIAvatarArrowAttack;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IRangedAttackMob;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.pathfinding.PathNavigateGround;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityAvatar extends EntityAvatarBase implements IRangedAttackMob, emoniph.intangible.entity.ai.IDefender, net.minecraft.entity.boss.IBossDisplayData
/*     */ {
/*     */   private int attackTimerStandardRight;
/*     */   private int attackTimerStandardLeft;
/*     */   private int attackTimerAOE;
/*     */   private int attackTimerProjectile;
/*     */   private int defenseTimerActivate;
/*     */   private int defenseTimer;
/*     */   private int teleportCooldown;
/*  45 */   private Set<UUID> targets = new java.util.HashSet();
/*     */   
/*     */   public static final int ATTACK_TICKS = 10;
/*     */   
/*  49 */   final int MELEE_ACTIVATE_RANGE_SQ = 25;
/*     */   
/*     */   public EntityAvatar(World worldIn) {
/*  52 */     super(worldIn);
/*     */     
/*  54 */     ((PathNavigateGround)func_70661_as()).func_179690_a(false);
/*  55 */     ((PathNavigateGround)func_70661_as()).func_179693_d(true);
/*     */     
/*  57 */     func_70105_a(0.9F, 2.9F);
/*  58 */     this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAISwimming(this));
/*     */     
/*  60 */     this.field_70714_bg.func_75776_a(3, new EntityAIAttackOnCollide(this, 1.0D, true)
/*     */     {
/*     */       public boolean func_75250_a() {
/*  63 */         if ((EntityAvatar.this.func_70638_az() != null) && (EntityAvatar.this.func_70638_az().func_70089_S()) && (super.func_75250_a())) {} return EntityAvatar.this.func_70068_e(EntityAvatar.this.func_70638_az()) <= (EntityAvatar.this.getBody() != null ? EntityAvatar.this.getBody().getProjectileMinRangeSq(EntityAvatar.this) : 25.0F);
/*     */       }
/*     */       
/*     */       public boolean func_75253_b()
/*     */       {
/*  68 */         if ((EntityAvatar.this.func_70638_az() != null) && (EntityAvatar.this.func_70638_az().func_70089_S()) && (super.func_75253_b())) {} return EntityAvatar.this.func_70068_e(EntityAvatar.this.func_70638_az()) <= 2.0F * (EntityAvatar.this.getBody() != null ? EntityAvatar.this.getBody().getProjectileMinRangeSq(EntityAvatar.this) : 25.0F);
/*     */       }
/*  70 */     });
/*  71 */     this.field_70714_bg.func_75776_a(4, new EntityAIAvatarArrowAttack(this, 1.0D, 40, 40.0F)
/*     */     {
/*     */       public boolean func_75253_b() {
/*  74 */         if ((EntityAvatar.this.func_70638_az() != null) && (EntityAvatar.this.func_70638_az().func_70089_S()) && (super.func_75253_b())) {} return EntityAvatar.this.func_70068_e(EntityAvatar.this.func_70638_az()) >= (EntityAvatar.this.getBody() != null ? EntityAvatar.this.getBody().getProjectileMinRangeSq(EntityAvatar.this) : 25.0F);
/*     */       }
/*     */       
/*     */       protected int getRangedAttackTime()
/*     */       {
/*  79 */         return EntityAvatar.this.getBody() != null ? EntityAvatar.this.getBody().getProjectileCooldownTicks(EntityAvatar.this) : super.getRangedAttackTime();
/*     */       }
/*     */       
/*     */       protected int getMaxRangedAttackTime()
/*     */       {
/*  84 */         return EntityAvatar.this.getBody() != null ? EntityAvatar.this.getBody().getProjectileCooldownTicks(EntityAvatar.this) : super.getRangedAttackTime();
/*     */       }
/*  86 */     });
/*  87 */     this.field_70714_bg.func_75776_a(5, new net.minecraft.entity.ai.EntityAIWander(this, 0.8D));
/*  88 */     this.field_70714_bg.func_75776_a(6, new net.minecraft.entity.ai.EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  89 */     this.field_70714_bg.func_75776_a(6, new net.minecraft.entity.ai.EntityAILookIdle(this));
/*  90 */     this.field_70715_bh.func_75776_a(1, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, false, new Class[0]));
/*  91 */     this.field_70715_bh.func_75776_a(2, new emoniph.intangible.entity.ai.EntityAIDefendedHurtByTarget(this));
/*  92 */     this.field_70715_bh.func_75776_a(3, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(this, EntityLivingBase.class, 10, false, true, new com.google.common.base.Predicate()
/*     */     {
/*     */       public boolean apply(Object entity) {
/*  95 */         return apply((Entity)entity);
/*     */       }
/*     */       
/*     */       public boolean apply(Entity entity) {
/*  99 */         if (((entity instanceof EntityPlayer)) && (!Get.effects().isActiveFor(Get.effects().INCORPOREAL, (EntityPlayer)entity))) {
/* 100 */           EntityPlayer player = (EntityPlayer)entity;
/* 101 */           if (EntityAvatar.this.targets.contains(player.func_146103_bH().getId())) {
/* 102 */             if (player.field_71075_bZ.field_75098_d) {
/* 103 */               EntityAvatar.this.targets.remove(player.func_146103_bH().getId());
/* 104 */               return !PlayerEx.get(player).getWorship().isDevoutFollowerOf(EntityAvatar.this.field_70170_p, EntityAvatar.this.getDeityId());
/*     */             }
/* 106 */             return true; }
/* 107 */           if (PlayerEx.get(player).getWorship().isDevoutFollowerOf(EntityAvatar.this.field_70170_p, EntityAvatar.this.getDeityId())) {
/* 108 */             return false;
/*     */           }
/* 110 */           return true;
/*     */         }
/* 112 */         if ((entity.field_70153_n != null) && ((entity.field_70153_n instanceof EntityPlayer))) {
/* 113 */           EntityPlayer player = (EntityPlayer)entity.field_70153_n;
/* 114 */           if (EntityAvatar.this.targets.contains(player.func_146103_bH().getId())) {
/* 115 */             if (player.field_71075_bZ.field_75098_d) {
/* 116 */               EntityAvatar.this.targets.remove(player.func_146103_bH().getId());
/* 117 */               return !PlayerEx.get(player).getWorship().isDevoutFollowerOf(EntityAvatar.this.field_70170_p, EntityAvatar.this.getDeityId());
/*     */             }
/* 119 */             return true;
/*     */           }
/* 121 */           return false;
/*     */         }
/* 123 */         if ((entity instanceof EntityAvatar)) {
/* 124 */           EntityAvatar other = (EntityAvatar)entity;
/* 125 */           return (other.getDeityId() == null) || (!other.getDeityId().equals(EntityAvatar.this.getDeityId()));
/*     */         }
/* 127 */         return false;
/*     */ 
/*     */       }
/*     */       
/*     */ 
/* 132 */     }));
/* 133 */     this.field_70138_W = 2.0F;
/* 134 */     this.field_70728_aV = 100;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_82196_d(EntityLivingBase target, float targetDistAsPctOfMaxRange)
/*     */   {
/* 140 */     if (!isIncorporeal()) {
/* 141 */       IDeityAvatarBody body = getBody();
/* 142 */       if (body != null) {
/* 143 */         swingArmRight();
/* 144 */         swingArmLeft();
/* 145 */         swingProjectileAttack();
/* 146 */         body.performAttackProjectile(this, target, targetDistAsPctOfMaxRange);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean func_70085_c(EntityPlayer player)
/*     */   {
/* 153 */     PlayerEx playerEx = PlayerEx.get(player);
/* 154 */     if ((playerEx != null) && (!this.field_70170_p.field_72995_K) && 
/* 155 */       (playerEx.getWorship().isDevoutFollowerOf(this.field_70170_p, getDeityId())) && 
/* 156 */       (getPower() != null)) {
/* 157 */       getPower().onGive(this, player);
/* 158 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 162 */     return false;
/*     */   }
/*     */   
/*     */   public net.minecraft.entity.EntityLiving getAvatarEntity()
/*     */   {
/* 167 */     return this;
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/* 172 */     super.func_70088_a();
/*     */   }
/*     */   
/*     */   protected void func_110147_ax()
/*     */   {
/* 177 */     super.func_110147_ax();
/* 178 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(500.0D);
/* 179 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.30000001192092896D);
/* 180 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(64.0D);
/* 181 */     func_110148_a(SharedMonsterAttributes.field_111266_c).func_111128_a(1.0D);
/*     */   }
/*     */   
/*     */   public void addTargetPlayerId(UUID playerId)
/*     */   {
/* 186 */     for (int i = 0; i < this.field_70170_p.field_73010_i.size(); i++) {
/* 187 */       EntityPlayer player = (EntityPlayer)this.field_70170_p.field_73010_i.get(i);
/*     */       
/* 189 */       if ((player.func_146103_bH().getId().equals(player.func_110124_au())) && (player.field_71075_bZ.field_75098_d)) {
/* 190 */         return;
/*     */       }
/*     */     }
/*     */     
/* 194 */     this.targets.add(playerId);
/*     */   }
/*     */   
/*     */   public boolean hasOwner()
/*     */   {
/* 199 */     return !this.defendants.isEmpty();
/*     */   }
/*     */   
/*     */   public EntityCreature getDefenderCreature()
/*     */   {
/* 204 */     return this;
/*     */   }
/*     */   
/*     */   public List<EntityLivingBase> getOwnerEntities()
/*     */   {
/* 209 */     return this.defendants;
/*     */   }
/*     */   
/*     */   public boolean func_142018_a(EntityLivingBase theTarget, EntityLivingBase ownerEntity)
/*     */   {
/* 214 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isSitting()
/*     */   {
/* 219 */     return false;
/*     */   }
/*     */   
/* 222 */   private List<EntityLivingBase> defendants = new java.util.ArrayList();
/*     */   private IDeityAvatarPower power;
/*     */   private IDeityAvatarBody body;
/*     */   
/* 226 */   public void func_70030_z() { super.func_70030_z(); }
/*     */   
/*     */ 
/*     */   public void func_70636_d()
/*     */   {
/* 231 */     super.func_70636_d();
/*     */     
/* 233 */     if ((!this.field_70170_p.field_72995_K) && (this.field_70173_aa % 100 == 0) && (!isIncorporeal())) {
/* 234 */       List<EntityPlayer> players = this.field_70170_p.func_72872_a(EntityPlayer.class, getAvatarBounds().func_72314_b(32.0D, 8.0D, 32.0D));
/* 235 */       this.defendants.clear();
/* 236 */       for (EntityPlayer player : players) {
/* 237 */         if (PlayerEx.get(player).getWorship().isDevoutFollowerOf(this.field_70170_p, getDeityId())) {
/* 238 */           this.defendants.add(player);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 243 */     if (this.attackTimerStandardRight > 0) {
/* 244 */       this.attackTimerStandardRight -= 1;
/*     */     }
/*     */     
/* 247 */     if (this.attackTimerStandardLeft > 0) {
/* 248 */       this.attackTimerStandardLeft -= 1;
/*     */     }
/*     */     
/* 251 */     if (this.attackTimerAOE > 0) {
/* 252 */       this.attackTimerAOE -= 1;
/*     */     }
/*     */     
/* 255 */     if (this.attackTimerProjectile > 0) {
/* 256 */       this.attackTimerProjectile -= 1;
/*     */     }
/*     */     
/* 259 */     if (this.teleportCooldown > 0) {
/* 260 */       this.teleportCooldown -= 1;
/*     */     }
/*     */     
/* 263 */     if (this.defenseTimer > 0) {
/* 264 */       this.defenseTimer -= 1;
/* 265 */       if (this.defenseTimer == 0) {
/* 266 */         IDeityAvatarBody body = getBody();
/* 267 */         if ((!this.field_70170_p.field_72995_K) && (body != null)) {
/* 268 */           body.onDefenseStop(this);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 273 */     if (this.defenseTimerActivate > 0) {
/* 274 */       this.defenseTimerActivate -= 1;
/*     */       
/* 276 */       if ((this.defenseTimerActivate == 0) && (!isIncorporeal())) {
/* 277 */         IDeityAvatarBody body = getBody();
/* 278 */         if ((!this.field_70170_p.field_72995_K) && (body != null)) {
/* 279 */           this.defenseTimer = body.getDefenseDurationTicks(this);
/* 280 */           this.field_70170_p.func_72960_a(this, (byte)9);
/* 281 */           body.onDefenseStart(this);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 286 */     if ((!this.field_70170_p.field_72995_K) && (this.field_70173_aa % 20 == 0) && (this.defenseTimer == 0) && (this.defenseTimerActivate == 0) && (getBody() != null) && (getBody().shouldDefenseCountdownActivate(this)) && (!isIncorporeal())) {
/* 287 */       this.defenseTimerActivate = getBody().getDefenseActivationTicks(this);
/* 288 */       this.field_70170_p.func_72960_a(this, (byte)8);
/*     */     }
/*     */     
/*     */ 
/* 292 */     if ((!this.field_70170_p.field_72995_K) && (this.field_70173_aa % 100 == 0) && (isIncorporeal())) {
/* 293 */       List<EntityHollowIronGolem> shells = this.field_70170_p.func_72872_a(EntityHollowIronGolem.class, getAvatarBounds().func_72314_b(16.0D, 4.0D, 16.0D));
/*     */       
/* 295 */       EntityHollowIronGolem closest = null;
/* 296 */       double closestDistSq = Double.MAX_VALUE;
/* 297 */       for (EntityHollowIronGolem entity : shells) {
/* 298 */         double distSq = func_70068_e(entity);
/* 299 */         if (((closest == null) || (distSq < closestDistSq)) && (entity.getTrappedSoul() == null)) {
/* 300 */           closestDistSq = distSq;
/* 301 */           closest = entity;
/*     */         }
/*     */       }
/*     */       
/* 305 */       if (closest != null) {
/* 306 */         if (closest.func_70068_e(this) < 64.0D) {
/* 307 */           closest.setTrappedSoul(emoniph.intangible.api.SoulType.NOBLE, (String)net.minecraft.entity.EntityList.field_75626_c.get(getClass()), this.field_70130_N, this.field_70131_O);
/* 308 */           Get.fx().GLOW.sendToAllNear(this, 0.25F, 10, 61547, new net.minecraft.util.Vec3(closest.field_70165_t, closest.field_70163_u + closest.func_70047_e(), closest.field_70161_v), 0.3F);
/* 309 */           func_70106_y();
/*     */         } else {
/* 311 */           this.field_70699_by.func_75497_a(closest, 0.4D);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 316 */     if ((!this.field_70170_p.field_72995_K) && (this.field_70173_aa % 20 == 0) && 
/* 317 */       (Get.deities().forWorld(this.field_70170_p).getDeityById(getDeityId()) == null)) {
/* 318 */       func_70106_y();
/* 319 */       Get.fx().sendToAllNear(net.minecraft.util.EnumParticleTypes.EXPLOSION_NORMAL, this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, 40, 16.0D);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 326 */     super.func_70014_b(compound);
/* 327 */     compound.func_74768_a("teleportCooldown", this.teleportCooldown);
/*     */     
/* 329 */     NBTTagList list = new NBTTagList();
/* 330 */     for (UUID entry : this.targets) {
/* 331 */       list.func_74742_a(new net.minecraft.nbt.NBTTagString(entry.toString()));
/*     */     }
/*     */     
/* 334 */     compound.func_74782_a("targets", list);
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 339 */     super.func_70037_a(compound);
/* 340 */     this.teleportCooldown = compound.func_74762_e("teleportCooldown");
/*     */     
/* 342 */     this.targets.clear();
/* 343 */     if (compound.func_150297_b("targets", 9)) {
/* 344 */       NBTTagList list = compound.func_150295_c("targets", 8);
/* 345 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 346 */         String id = list.func_150307_f(i);
/* 347 */         this.targets.add(UUID.fromString(id));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private IDeityAvatarPower getPower()
/*     */   {
/* 355 */     if (this.power == null) {
/* 356 */       this.power = ((IDeityAvatarPower)Get.deityEffects().avatarPowerRegistry.getEffectFromIndex(getAvatarPowerIndex()));
/*     */     }
/*     */     
/* 359 */     return this.power;
/*     */   }
/*     */   
/*     */ 
/*     */   public IDeityAvatarBody getBody()
/*     */   {
/* 365 */     if (this.body == null) {
/* 366 */       this.body = ((IDeityAvatarBody)Get.deityEffects().bodyRegistry.getEffectFromIndex(getDeityBodyIndex()));
/*     */     }
/*     */     
/* 369 */     return this.body;
/*     */   }
/*     */   
/*     */   protected void func_70619_bc()
/*     */   {
/* 374 */     super.func_70619_bc();
/*     */     
/* 376 */     if ((this.field_70173_aa % 20 == 0) && (!isIncorporeal())) {
/* 377 */       IDeityAvatarBody theBody = getBody();
/* 378 */       if (theBody != null) {
/* 379 */         float healRate = theBody.getHealthRegenPerTick(this);
/* 380 */         if (healRate > 0.0F) {
/* 381 */           func_70691_i(healRate * 20.0F);
/*     */         }
/*     */         
/* 384 */         if ((func_70643_av() != null) && (this.attackTimerAOE == 0) && (this.attackTimerProjectile == 0) && (this.attackTimerStandardRight == 0))
/*     */         {
/* 386 */           double rangeSq = Math.pow(this.body.getAttackRangeAOE(this), 2.0D);
/* 387 */           if ((func_70068_e(func_70643_av()) < rangeSq) && (this.field_70146_Z.nextInt(3) == 0)) {
/* 388 */             swingHeavyAttack();
/* 389 */             this.body.performAttackAOE(this);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 395 */     if ((this.defenseTimer > 0) && (getBody() != null) && (!isIncorporeal())) {
/* 396 */       getBody().onDefenseTick(this);
/*     */     }
/*     */     
/* 399 */     if ((!this.field_70170_p.field_72995_K) && (this.defenseTimer == 0) && (this.defenseTimerActivate == 0) && (this.teleportCooldown == 0) && (func_70638_az() != null) && (func_70638_az().func_70089_S()) && (func_70661_as().func_75500_f()) && (this.field_70170_p.field_73012_v.nextDouble() < 0.5D) && (!isIncorporeal())) {
/* 400 */       double distSq = func_70068_e(func_70638_az());
/* 401 */       if ((distSq > 4.0D) && (distSq < 256.0D)) {
/* 402 */         teleportToEntity(func_70638_az());
/* 403 */         this.teleportCooldown = getBody().getTeleportCooldownTicks(this);
/*     */       }
/*     */     }
/*     */     
/* 407 */     if ((getPower() != null) && (!isIncorporeal())) {
/* 408 */       getPower().onTick(this);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean teleportToEntity(Entity targetEntity)
/*     */   {
/* 415 */     double d0 = 16.0D;
/* 416 */     double d1 = targetEntity.field_70165_t;
/* 417 */     double d2 = targetEntity.field_70163_u;
/* 418 */     double d3 = targetEntity.field_70161_v;
/* 419 */     return teleportTo(d1, d2, d3);
/*     */   }
/*     */   
/*     */   public boolean teleportTo(double x, double y, double z) {
/* 423 */     double d3 = this.field_70165_t;
/* 424 */     double d4 = this.field_70163_u;
/* 425 */     double d5 = this.field_70161_v;
/* 426 */     this.field_70165_t = x;
/* 427 */     this.field_70163_u = y;
/* 428 */     this.field_70161_v = z;
/* 429 */     boolean flag = false;
/* 430 */     BlockPos blockpos = new BlockPos(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     
/* 432 */     if (this.field_70170_p.func_175667_e(blockpos)) {
/* 433 */       boolean flag1 = false;
/*     */       
/* 435 */       while ((!flag1) && (blockpos.func_177956_o() > 0)) {
/* 436 */         BlockPos blockpos1 = blockpos.func_177977_b();
/* 437 */         Block block = this.field_70170_p.func_180495_p(blockpos1).func_177230_c();
/*     */         
/* 439 */         if (block.func_149688_o().func_76230_c()) {
/* 440 */           flag1 = true;
/*     */         } else {
/* 442 */           this.field_70163_u -= 1.0D;
/* 443 */           blockpos = blockpos1;
/*     */         }
/*     */       }
/*     */       
/* 447 */       if (flag1) {
/* 448 */         super.func_70634_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */         
/* 450 */         if ((this.field_70170_p.func_72945_a(this, func_174813_aQ()).isEmpty()) && (!this.field_70170_p.func_72953_d(func_174813_aQ()))) {
/* 451 */           flag = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 456 */     if (!flag) {
/* 457 */       func_70107_b(d3, d4, d5);
/* 458 */       return false;
/*     */     }
/* 460 */     short short1 = 128;
/*     */     
/* 462 */     for (int i = 0; i < short1; i++) {
/* 463 */       double d9 = i / (short1 - 1.0D);
/* 464 */       float f = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
/* 465 */       float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
/* 466 */       float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 0.2F;
/* 467 */       double d6 = d3 + (this.field_70165_t - d3) * d9 + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N * 2.0D;
/* 468 */       double d7 = d4 + (this.field_70163_u - d4) * d9 + this.field_70146_Z.nextDouble() * this.field_70131_O;
/* 469 */       double d8 = d5 + (this.field_70161_v - d5) * d9 + (this.field_70146_Z.nextDouble() - 0.5D) * this.field_70130_N * 2.0D;
/* 470 */       this.field_70170_p.func_175688_a(net.minecraft.util.EnumParticleTypes.PORTAL, d6, d7, d8, f, f1, f2, new int[0]);
/*     */     }
/*     */     
/* 473 */     this.field_70170_p.func_72908_a(d3, d4, d5, "mob.endermen.portal", 1.0F, 1.0F);
/* 474 */     func_85030_a("mob.endermen.portal", 1.0F, 1.0F);
/* 475 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onUpdateClient()
/*     */   {
/* 481 */     spawnParticles();
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   private void spawnParticles() {
/* 486 */     if ((getBody() != null) && 
/* 487 */       (!isIncorporeal())) {
/* 488 */       getBody().spawnParticles(this);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void swingArmRight()
/*     */   {
/* 495 */     this.attackTimerStandardRight = 10;
/* 496 */     this.field_70170_p.func_72960_a(this, (byte)4);
/*     */   }
/*     */   
/*     */   private void swingArmLeft()
/*     */   {
/* 501 */     this.attackTimerStandardLeft = 10;
/* 502 */     this.field_70170_p.func_72960_a(this, (byte)7);
/*     */   }
/*     */   
/*     */   private void swingHeavyAttack() {
/* 506 */     IDeityAvatarBody body = getBody();
/* 507 */     if (body != null) {
/* 508 */       this.attackTimerAOE = body.getAttackAnimationTicksAOE(this);
/* 509 */       this.field_70170_p.func_72960_a(this, (byte)5);
/*     */     }
/*     */   }
/*     */   
/*     */   private void swingProjectileAttack() {
/* 514 */     IDeityAvatarBody body = getBody();
/* 515 */     if (body != null) {
/* 516 */       this.attackTimerProjectile = body.getAttackAnimationTicksProjectile(this);
/* 517 */       this.field_70170_p.func_72960_a(this, (byte)6);
/*     */     }
/*     */   }
/*     */   
/* 521 */   private int damageTPTrigger = 0;
/*     */   
/*     */ 
/*     */   public boolean func_70097_a(DamageSource source, float amount)
/*     */   {
/* 526 */     if (isIncorporeal()) {
/* 527 */       return false;
/*     */     }
/*     */     
/* 530 */     amount = Math.min(amount, 12.0F);
/*     */     
/* 532 */     if ((this.defenseTimer > 0) && (getBody() != null)) {
/* 533 */       Attack attack = new Attack(source, amount);
/* 534 */       getBody().onDefenseHurtBy(this, attack);
/* 535 */       if (attack.getDamage() == 0.0F) {
/* 536 */         return false;
/*     */       }
/* 538 */       amount = attack.getDamage();
/*     */     }
/*     */     
/*     */ 
/* 542 */     if (getPower() != null) {
/* 543 */       Attack attack = new Attack(source, amount);
/* 544 */       getPower().onHurtBy(this, attack);
/* 545 */       if (attack.getDamage() == 0.0F) {
/* 546 */         return false;
/*     */       }
/* 548 */       amount = attack.getDamage();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 553 */     boolean damaged = super.func_70097_a(source, amount);
/* 554 */     if ((damaged) && (this.defenseTimerActivate > 0)) {
/* 555 */       this.defenseTimerActivate = 0;
/*     */     }
/* 557 */     if ((damaged) && (amount > 2.0F) && ((source.func_76364_f() instanceof EntityPlayer)) && 
/* 558 */       (!this.field_70170_p.field_72995_K)) {
/* 559 */       EntityPlayer player = (EntityPlayer)source.func_76364_f();
/* 560 */       PlayerEx playerEx = PlayerEx.get(player);
/* 561 */       long worship = playerEx.getWorship().getWorshipFor(this.field_70170_p, getDeityId());
/* 562 */       playerEx.tryReduceWorship(this.field_70170_p, getDeityId(), Math.max(worship - 3L, 1L), true);
/*     */     }
/*     */     
/* 565 */     if ((damaged) && (!this.field_70170_p.field_72995_K) && 
/* 566 */       (++this.damageTPTrigger > 5) && (source.func_76364_f() != null)) {
/* 567 */       this.damageTPTrigger = 0;
/* 568 */       this.teleportCooldown = (getBody() != null ? getBody().getTeleportCooldownTicks(this) : 100);
/* 569 */       teleportToEntity(source.func_76346_g());
/*     */     }
/*     */     
/* 572 */     return damaged;
/*     */   }
/*     */   
/*     */   public boolean attackEntityAsAvatarNormally(EntityLivingBase target)
/*     */   {
/* 577 */     return func_70652_k(target);
/*     */   }
/*     */   
/*     */   public boolean attackEntityAsAvatarBasic(EntityLivingBase target, float damage)
/*     */   {
/* 582 */     if (isIncorporeal()) {
/* 583 */       return false;
/*     */     }
/* 585 */     DamageSource source = DamageSource.func_76358_a(this);
/*     */     
/* 587 */     if (getPower() != null) {
/* 588 */       IAttack attack = new Attack(source, damage);
/* 589 */       getPower().onAttacking(this, attack, target);
/* 590 */       damage = attack.getDamage();
/*     */     }
/*     */     
/* 593 */     return target.func_70097_a(source, damage);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_70652_k(Entity targetEntity)
/*     */   {
/* 599 */     if (isIncorporeal()) {
/* 600 */       return false;
/*     */     }
/*     */     
/* 603 */     boolean flag = false;
/* 604 */     swingArmRight();
/*     */     
/* 606 */     IDeityAvatarBody body = getBody();
/* 607 */     if (body != null) {
/* 608 */       float f = (float)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/* 609 */       int i = 0;
/*     */       
/* 611 */       float up = 0.0F;
/*     */       
/* 613 */       if ((targetEntity instanceof EntityLivingBase)) {
/* 614 */         f += body.getDamageFor(this, targetEntity);
/* 615 */         i += body.getKnockbackModifierFor(this, targetEntity);
/* 616 */         up = body.getLaunchSpeedFor(this, targetEntity);
/*     */       }
/*     */       
/* 619 */       DamageSource source = DamageSource.func_76358_a(this);
/*     */       
/* 621 */       if (getPower() != null) {
/* 622 */         IAttack attack = new Attack(source, f);
/* 623 */         getPower().onAttacking(this, attack, targetEntity);
/* 624 */         f = attack.getDamage();
/*     */       }
/*     */       
/* 627 */       flag = targetEntity.func_70097_a(source, f);
/*     */       
/* 629 */       if (flag) {
/* 630 */         if (i > 0) {
/* 631 */           targetEntity.func_70024_g(-net.minecraft.util.MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F, 0.1D, net.minecraft.util.MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F);
/* 632 */           this.field_70159_w *= 0.6D;
/* 633 */           this.field_70179_y *= 0.6D;
/*     */         }
/*     */         
/* 636 */         targetEntity.field_70181_x += up;
/*     */         
/* 638 */         int j = body.getFireAspectModifierFor(this, targetEntity);
/*     */         
/* 640 */         if (j > 0) {
/* 641 */           targetEntity.func_70015_d(j * 4);
/*     */         }
/*     */         
/* 644 */         func_174815_a(this, targetEntity);
/*     */       }
/*     */     }
/* 647 */     return flag;
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource cause)
/*     */   {
/* 652 */     if (getPower() != null) {
/* 653 */       getPower().onDeath(this, cause);
/*     */     }
/* 655 */     super.func_70645_a(cause);
/*     */   }
/*     */   
/*     */   public int func_70658_aO()
/*     */   {
/* 660 */     return Math.min(getBody() != null ? getBody().getTotalArmorValue() : 0, 24);
/*     */   }
/*     */   
/*     */   public int func_70627_aG()
/*     */   {
/* 665 */     return super.func_70627_aG() * 5;
/*     */   }
/*     */   
/*     */   protected String func_70639_aQ()
/*     */   {
/* 670 */     return "intangible:avatar.talk";
/*     */   }
/*     */   
/*     */   protected String func_70621_aR()
/*     */   {
/* 675 */     return "intangible:avatar.hit";
/*     */   }
/*     */   
/*     */   protected String func_70673_aS()
/*     */   {
/* 680 */     return "intangible:avatar.death";
/*     */   }
/*     */   
/*     */ 
/*     */   protected void func_180429_a(BlockPos p_180429_1_, Block p_180429_2_) {}
/*     */   
/*     */ 
/*     */   protected net.minecraft.item.Item func_146068_u()
/*     */   {
/* 689 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_70687_e(net.minecraft.potion.PotionEffect p_70687_1_) {
/* 693 */     return super.func_70687_e(p_70687_1_);
/*     */   }
/*     */   
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void func_70103_a(byte data)
/*     */   {
/* 700 */     if (data == 4) {
/* 701 */       this.attackTimerStandardRight = 10;
/* 702 */     } else if (data == 5) {
/* 703 */       IDeityAvatarBody body = getBody();
/* 704 */       if (body != null) {
/* 705 */         this.attackTimerAOE = body.getAttackAnimationTicksAOE(this);
/*     */       }
/* 707 */     } else if (data == 6) {
/* 708 */       IDeityAvatarBody body = getBody();
/* 709 */       if (body != null) {
/* 710 */         this.attackTimerProjectile = body.getAttackAnimationTicksProjectile(this);
/*     */       }
/* 712 */     } else if (data == 7) {
/* 713 */       this.attackTimerStandardLeft = 10;
/* 714 */     } else if (data == 8) {
/* 715 */       IDeityAvatarBody body = getBody();
/* 716 */       if (body != null) {
/* 717 */         this.defenseTimerActivate = body.getDefenseActivationTicks(this);
/*     */       }
/* 719 */     } else if (data == 9) {
/* 720 */       IDeityAvatarBody body = getBody();
/* 721 */       if (body != null) {
/* 722 */         this.defenseTimer = body.getDefenseDurationTicks(this);
/*     */       }
/*     */     } else {
/* 725 */       super.func_70103_a(data);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getAttackTimerStandardRight()
/*     */   {
/* 731 */     return this.attackTimerStandardRight;
/*     */   }
/*     */   
/*     */   public int getAttackTimerStandardLeft()
/*     */   {
/* 736 */     return this.attackTimerStandardLeft;
/*     */   }
/*     */   
/*     */   public int getAttackTimerAOE()
/*     */   {
/* 741 */     return this.attackTimerAOE;
/*     */   }
/*     */   
/*     */   public int getAttackTimerProjectile()
/*     */   {
/* 746 */     return this.attackTimerProjectile;
/*     */   }
/*     */   
/*     */   public int getDefenseTimerActivation()
/*     */   {
/* 751 */     return this.defenseTimerActivate;
/*     */   }
/*     */   
/*     */   public int getDefenseTimer() {
/* 755 */     return this.defenseTimer;
/*     */   }
/*     */   
/*     */   public boolean isCorporeal()
/*     */   {
/* 760 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */