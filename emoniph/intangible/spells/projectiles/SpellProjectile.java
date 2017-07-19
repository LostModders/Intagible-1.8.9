/*     */ package emoniph.intangible.spells.projectiles;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.CastingStyle;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.entity.EntitySpell;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.spells.Spell;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SpellProjectile
/*     */   extends Spell
/*     */ {
/*     */   protected int colorInner;
/*     */   protected int colorOuter;
/*     */   
/*     */   public SpellProjectile(int colorInner, int colorOuter)
/*     */   {
/*  27 */     super(CastingStyle.PREPARED);
/*  28 */     this.colorInner = colorInner;
/*  29 */     this.colorOuter = colorOuter;
/*     */   }
/*     */   
/*     */   public void invoke(EntityPlayer player)
/*     */   {
/*  34 */     boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, player);
/*  35 */     boolean overclock = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player);
/*  36 */     launchProjectile(player).setBehaviourPowerUps(unexpected, overclock);
/*  37 */     Sound.RANDOM_FIZZ.playToAllNear(player);
/*  38 */     if (!player.field_70170_p.field_72995_K) {
/*  39 */       int rebellion = getRebellionIncrease(player, unexpected, overclock);
/*  40 */       if (rebellion > 0) {
/*  41 */         PlayerEx.get(player).increaseRebellion(rebellion, true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected int getRebellionIncrease(EntityPlayer player, boolean unexpected, boolean overclocked) {
/*  47 */     return 0;
/*     */   }
/*     */   
/*     */   public int getMaxAirTicks() {
/*  51 */     return 200;
/*     */   }
/*     */   
/*     */   public int getMaxGroundTicks() {
/*  55 */     return 600;
/*     */   }
/*     */   
/*     */   public EntitySpell launchProjectile(EntityLivingBase source) {
/*  59 */     if ((source != null) && (source.func_70089_S())) {
/*  60 */       World world = source.func_130014_f_();
/*  61 */       if ((world != null) && (!world.field_72995_K)) {
/*  62 */         EntitySpell projectile = new EntitySpell(world, source, this, 0.3D);
/*  63 */         projectile.setColor(this.colorInner, this.colorOuter, 1.0F);
/*  64 */         world.func_72838_d(projectile);
/*  65 */         return projectile;
/*     */       }
/*     */     }
/*  68 */     return null;
/*     */   }
/*     */   
/*     */   public EntitySpell launchProjectile(EntityLivingBase source, int colorIn, int colorOut, float scale, double motionX, double motionY, double motionZ) {
/*  72 */     if ((source != null) && (source.func_70089_S())) {
/*  73 */       World world = source.func_130014_f_();
/*  74 */       if ((world != null) && (!world.field_72995_K)) {
/*  75 */         EntitySpell projectile = new EntitySpell(world, source, this, 0.3D);
/*  76 */         projectile.setAcceleration(motionX, motionY, motionZ);
/*  77 */         projectile.field_70165_t = source.field_70165_t;
/*  78 */         projectile.field_70163_u = (source.field_70163_u + source.func_70047_e());
/*  79 */         projectile.field_70161_v = source.field_70161_v;
/*  80 */         projectile.setColor(colorIn, colorOut, scale);
/*  81 */         world.func_72838_d(projectile);
/*  82 */         return projectile;
/*     */       }
/*     */     }
/*     */     
/*  86 */     return null;
/*     */   }
/*     */   
/*     */   public EntitySpell launchProjectile(EntityLivingBase source, double motionX, double motionY, double motionZ) {
/*  90 */     return launchProjectile(source, this.colorInner, this.colorOuter, 1.0F, motionX, motionY, motionZ);
/*     */   }
/*     */   
/*     */   public EntitySpell launchProjectile(EntityLivingBase source, EntityLivingBase target, int colorInner, int colorOuter, float scale) {
/*  94 */     if ((source != null) && (source.func_70089_S())) {
/*  95 */       World world = source.func_130014_f_();
/*  96 */       if ((world != null) && (!world.field_72995_K)) {
/*  97 */         EntitySpell projectile = new EntitySpell(world, source, target, this, 0.3D);
/*  98 */         projectile.setColor(colorInner, colorOuter, scale);
/*  99 */         world.func_72838_d(projectile);
/* 100 */         return projectile;
/*     */       }
/*     */     }
/* 103 */     return null;
/*     */   }
/*     */   
/*     */   public EntitySpell launchProjectile(EntityLivingBase source, Entity proxySource, EntityLivingBase target, int colorInner, int colorOuter, float scale) {
/* 107 */     if ((proxySource != null) && (proxySource.func_70089_S())) {
/* 108 */       World world = proxySource.func_130014_f_();
/* 109 */       if ((world != null) && (!world.field_72995_K)) {
/* 110 */         EntitySpell projectile = new EntitySpell(world, source, proxySource, target, this, 0.3D);
/* 111 */         projectile.setColor(colorInner, colorOuter, scale);
/* 112 */         world.func_72838_d(projectile);
/* 113 */         return projectile;
/*     */       }
/*     */     }
/* 116 */     return null;
/*     */   }
/*     */   
/*     */   public EntitySpell launchProjectile(EntityLivingBase source, EntityLivingBase target, int colorInner, int colorOuter, float scale, double accX, double accY, double accZ) {
/* 120 */     if ((source != null) && (source.func_70089_S())) {
/* 121 */       World world = source.func_130014_f_();
/* 122 */       if ((world != null) && (!world.field_72995_K)) {
/* 123 */         EntitySpell projectile = new EntitySpell(world, source, target, this, 0.3D);
/* 124 */         projectile.setColor(colorInner, colorOuter, scale);
/* 125 */         projectile.increaseAcceleration(accX, accY, accZ);
/* 126 */         world.func_72838_d(projectile);
/*     */         
/* 128 */         return projectile;
/*     */       }
/*     */     }
/* 131 */     return null;
/*     */   }
/*     */   
/*     */   public abstract boolean impact(EntitySpell paramEntitySpell, MovingObjectPosition paramMovingObjectPosition, EntityLivingBase paramEntityLivingBase);
/*     */   
/*     */   public boolean canTargetIncorporealEntities()
/*     */   {
/* 138 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellProjectile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */