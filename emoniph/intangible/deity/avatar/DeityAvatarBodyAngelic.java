/*     */ package emoniph.intangible.deity.avatar;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.client.models.ModelDeityBodyAngelic;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import emoniph.intangible.spells.projectiles.SpellProjectile;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class DeityAvatarBodyAngelic implements emoniph.intangible.api.deity.IDeityAvatarBody
/*     */ {
/*  26 */   private static final ResourceLocation TEXTURE_URL = new ResourceLocation("intangible", "textures/entity/bodyangelic.png");
/*  27 */   private static final float[] HEAD_OFFSET = { 0.0F, 0.0F, 0.0F };
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelDeityBodyAngelic model;
/*     */   
/*  31 */   public float getHealthRegenPerTick(IAvatar avatar) { return 0.05F; }
/*     */   
/*     */ 
/*     */   public int getTeleportCooldownTicks(IAvatar avatar)
/*     */   {
/*  36 */     return 200;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ResourceLocation getTexture(IAvatar avatar)
/*     */   {
/*  45 */     return TEXTURE_URL;
/*     */   }
/*     */   
/*     */ 
/*     */   public float getRenderAlpha(IAvatar avatar)
/*     */   {
/*  51 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float getGlintAlpha(IAvatar avatar)
/*     */   {
/*  56 */     return 0.5F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBase getModel(IAvatar avatar)
/*     */   {
/*  62 */     if (this.model == null) {
/*  63 */       this.model = new ModelDeityBodyAngelic();
/*     */     }
/*     */     
/*  66 */     this.model.field_78091_s = avatar.getAvatarEntity().func_70631_g_();
/*  67 */     this.model.field_78093_q = avatar.getAvatarEntity().func_70115_ae();
/*  68 */     return this.model;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void spawnParticles(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float[] getHeadOffset(IAvatar avatar)
/*     */   {
/*  79 */     return HEAD_OFFSET;
/*     */   }
/*     */   
/*     */ 
/*     */   public void applyRenderTransforms(IAvatar avatar)
/*     */   {
/*  85 */     float heavy = avatar.getAttackTimerAOE();
/*  86 */     if (heavy > 0.0F) {
/*  87 */       double liftHeight = 2.0D;
/*  88 */       float progress = heavy / getAttackAnimationTicksAOE(avatar);
/*  89 */       GlStateManager.func_179137_b(0.0D, -2.0D * (progress - progress * progress), 0.0D);
/*  90 */       GlStateManager.func_179114_b(1440.0F * progress, 0.0F, 1.0F, 0.0F);
/*     */     }
/*  92 */     float projectile = avatar.getAttackTimerProjectile();
/*  93 */     if (projectile > 0.0F) {
/*  94 */       double liftHeight = 4.0D;
/*  95 */       float progress = projectile / getAttackAnimationTicksProjectile(avatar);
/*  96 */       GlStateManager.func_179137_b(0.0D, -4.0D * (progress - progress * progress), 0.0D);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public float getDamageFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 104 */     return 5 + avatar.getAvatarWorld().field_73012_v.nextInt(5);
/*     */   }
/*     */   
/*     */   public int getKnockbackModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 109 */     return 1;
/*     */   }
/*     */   
/*     */   public float getLaunchSpeedFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 114 */     return 0.2F;
/*     */   }
/*     */   
/*     */   public int getFireAspectModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 119 */     return 1;
/*     */   }
/*     */   
/*     */   public double getAttackRangeAOE(IAvatar avatar)
/*     */   {
/* 124 */     return 4.0D;
/*     */   }
/*     */   
/*     */   public void performAttackAOE(IAvatar avatar)
/*     */   {
/* 129 */     World world = avatar.getAvatarWorld();
/* 130 */     AxisAlignedBB bounds = avatar.getAvatarBounds();
/* 131 */     double range = getAttackRangeAOE(avatar);
/* 132 */     java.util.List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, bounds.func_72314_b(range, 0.0D, range));
/* 133 */     for (EntityLivingBase target : list) {
/* 134 */       if ((avatar != target) && (target.func_70068_e(avatar.getAvatarEntity()) <= range * range)) {
/* 135 */         avatar.attackEntityAsAvatarNormally(target);
/*     */       }
/*     */     }
/* 138 */     if (!world.field_72995_K) {
/* 139 */       Sound.MOD_RANDOM_SWOOSH.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public float getProjectileMinRangeSq(IAvatar avatar)
/*     */   {
/* 145 */     return 25.0F;
/*     */   }
/*     */   
/*     */   public int getProjectileCooldownTicks(IAvatar avatar)
/*     */   {
/* 150 */     return 40;
/*     */   }
/*     */   
/*     */   public void performAttackProjectile(IAvatar avatar, EntityLivingBase targetEntity, float rangeAsPctOfMax)
/*     */   {
/* 155 */     World world = avatar.getAvatarWorld();
/* 156 */     if (!world.field_72995_K) {
/* 157 */       if (world.field_73012_v.nextInt(4) == 1) {
/* 158 */         for (int i = 0; i < 4; i++) {
/* 159 */           if (i > 0) {
/* 160 */             Get.spells().DOOM_BOLT.launchProjectile(avatar.getAvatarEntity(), targetEntity, 16777215, 10079232, 2.0F, world.field_73012_v
/* 161 */               .nextDouble() * 0.1D - 0.05D, world.field_73012_v
/* 162 */               .nextDouble() * 0.1D - 0.05D, world.field_73012_v
/* 163 */               .nextDouble() * 0.1D - 0.05D);
/*     */           } else {
/* 165 */             Get.spells().DOOM_BOLT.launchProjectile(avatar.getAvatarEntity(), targetEntity, 16777215, 10079232, 2.0F);
/*     */           }
/*     */         }
/* 168 */         EntityLivingBase entity = avatar.getAvatarEntity();
/* 169 */         Get.fx().GLOW.sendToAllNear(world, entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v, 15.0F, 1, 16777215);
/* 170 */         Sound.MOD_RANDOM_SPELL1.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */       } else {
/* 172 */         Get.spells().DOOM_BOLT.launchProjectile(avatar.getAvatarEntity(), targetEntity, 16777215, 13421568, 3.0F);
/* 173 */         Sound.MOD_RANDOM_SPELL1.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int getAttackAnimationTicksAOE(IAvatar avatar)
/*     */   {
/* 180 */     return 50;
/*     */   }
/*     */   
/*     */   public int getAttackAnimationTicksProjectile(IAvatar avatar)
/*     */   {
/* 185 */     return 20;
/*     */   }
/*     */   
/*     */   public boolean shouldDefenseCountdownActivate(IAvatar avatar)
/*     */   {
/* 190 */     EntityLiving entity = avatar.getAvatarEntity();
/* 191 */     if ((entity.func_70089_S()) && 
/* 192 */       (entity.func_110143_aJ() < entity.func_110138_aP() * 0.5F) && (entity.field_70170_p.field_73012_v.nextDouble() < 0.1D)) {
/* 193 */       Sound.MOD_RANDOM_CHOIR1.playToAllNear(entity, 0.5F, 0.9F);
/* 194 */       Get.fx().GLOW.sendToAllNear(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u + entity.field_70131_O + 0.2D, entity.field_70161_v, 1.0F, 8, 16776960, 3, new net.minecraft.util.Vec3(entity.field_70165_t, entity.field_70163_u + entity.field_70131_O + 0.2D, entity.field_70161_v), 0.1F, 16.0D);
/* 195 */       return true;
/*     */     }
/* 197 */     return false;
/*     */   }
/*     */   
/*     */   public int getDefenseActivationTicks(IAvatar avatar)
/*     */   {
/* 202 */     return 80;
/*     */   }
/*     */   
/*     */   public int getDefenseDurationTicks(IAvatar avatar)
/*     */   {
/* 207 */     return 5;
/*     */   }
/*     */   
/*     */   public void onDefenseStart(IAvatar avatar)
/*     */   {
/* 212 */     if (!avatar.getAvatarWorld().field_72995_K) {
/* 213 */       avatar.getAvatarEntity().func_70691_i(avatar.getAvatarEntity().func_110138_aP() * 0.66F);
/* 214 */       Sound.MOD_RANDOM_CHOIR1.playToAllNear(avatar.getAvatarEntity(), 0.5F, 0.9F);
/* 215 */       Get.fx().GLOW.sendToAllNear(avatar.getAvatarEntity(), 1.0F, 40, 16776960, 16.0D);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onDefenseTick(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onDefenseHurtBy(IAvatar avatar, IAttack attack) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onDefenseStop(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTotalArmorValue()
/*     */   {
/* 236 */     return 10;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/avatar/DeityAvatarBodyAngelic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */