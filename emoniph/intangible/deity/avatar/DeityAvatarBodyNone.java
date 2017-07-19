/*     */ package emoniph.intangible.deity.avatar;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.client.particle.EntityColoredSmokeFX;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import emoniph.intangible.spells.grenades.SpellGrenade;
/*     */ import emoniph.intangible.spells.projectiles.SpellSeeker;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class DeityAvatarBodyNone implements emoniph.intangible.api.deity.IDeityAvatarBody
/*     */ {
/*  25 */   private static final float[] HEAD_OFFSET = { 0.0F, 0.0F, 0.0F };
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public net.minecraft.util.ResourceLocation getTexture(IAvatar avatar)
/*     */   {
/*  30 */     return TextureMap.field_110575_b;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBase getModel(IAvatar avatar)
/*     */   {
/*  36 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void spawnParticles(IAvatar avatar)
/*     */   {
/*  42 */     World world = avatar.getAvatarWorld();
/*  43 */     EntityLiving entity = avatar.getAvatarEntity();
/*  44 */     float width = entity.field_70130_N + entity.field_70130_N * avatar.getAttackTimerStandardLeft() / 10.0F;
/*  45 */     for (int i = 0; i < 3; i++) {
/*  46 */       double x = entity.field_70165_t + world.field_73012_v.nextDouble() * width - width * 0.5D;
/*  47 */       double y = entity.field_70163_u + world.field_73012_v.nextDouble() * entity.field_70131_O;
/*  48 */       double z = entity.field_70161_v + world.field_73012_v.nextDouble() * width - width * 0.5D;
/*     */       
/*  50 */       Minecraft.func_71410_x().field_71452_i.func_78873_a(new EntityColoredSmokeFX(world, x, y, z, 0.0D, 0.0D, 0.0D).color(avatar.getDeityColor()));
/*     */     }
/*     */     
/*  53 */     if (avatar.getDefenseTimerActivation() > 0) {
/*  54 */       double x = entity.field_70165_t + world.field_73012_v.nextDouble() * entity.field_70130_N - entity.field_70130_N * 0.5D;
/*  55 */       double y = entity.field_70163_u + world.field_73012_v.nextDouble() * entity.field_70131_O;
/*  56 */       double z = entity.field_70161_v + world.field_73012_v.nextDouble() * entity.field_70130_N - entity.field_70130_N * 0.5D;
/*     */       
/*  58 */       Minecraft.func_71410_x().field_71452_i.func_78873_a(new EntityColoredSmokeFX(world, x, y, z, 0.0D, 0.0D, 0.0D).color(0));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float[] getHeadOffset(IAvatar avatar)
/*     */   {
/*  65 */     return HEAD_OFFSET;
/*     */   }
/*     */   
/*     */   public float getRenderAlpha(IAvatar avatar)
/*     */   {
/*  70 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float getGlintAlpha(IAvatar avatar)
/*     */   {
/*  75 */     return 0.5F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void applyRenderTransforms(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */   public float getHealthRegenPerTick(IAvatar avatar)
/*     */   {
/*  85 */     return 0.05F;
/*     */   }
/*     */   
/*     */   public int getTeleportCooldownTicks(IAvatar avatar)
/*     */   {
/*  90 */     return 100;
/*     */   }
/*     */   
/*     */   public float getDamageFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/*  95 */     return 4.0F;
/*     */   }
/*     */   
/*     */   public int getKnockbackModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 100 */     return 1;
/*     */   }
/*     */   
/*     */   public float getLaunchSpeedFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 105 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public int getFireAspectModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 110 */     return 0;
/*     */   }
/*     */   
/*     */   public double getAttackRangeAOE(IAvatar avatar)
/*     */   {
/* 115 */     return 4.0D;
/*     */   }
/*     */   
/*     */   public void performAttackAOE(IAvatar avatar)
/*     */   {
/* 120 */     int bolts = 8;
/* 121 */     double increment = 45.0D;
/* 122 */     double speed = 0.05D;
/* 123 */     for (int i = 0; i < 8; i++)
/*     */     {
/* 125 */       double mx = Math.sin(Math.toRadians(i * increment)) * speed;
/* 126 */       double mz = Math.cos(Math.toRadians(i * increment)) * speed;
/* 127 */       Get.spells().DOOM_BOLT.launchProjectile(avatar.getAvatarEntity(), mx, 0.0D, mz);
/*     */     }
/* 129 */     Sound.MOD_RANDOM_SPELL3.playToAllNear(avatar.getAvatarEntity(), 0.5F, 0.8F);
/*     */   }
/*     */   
/*     */   public float getProjectileMinRangeSq(IAvatar avatar)
/*     */   {
/* 134 */     return 25.0F;
/*     */   }
/*     */   
/*     */   public int getProjectileCooldownTicks(IAvatar avatar)
/*     */   {
/* 139 */     return 40;
/*     */   }
/*     */   
/*     */ 
/*     */   public void performAttackProjectile(IAvatar avatar, EntityLivingBase targetEntity, float rangeAsPctOfMax)
/*     */   {
/* 145 */     switch (avatar.getAvatarWorld().field_73012_v.nextInt(5)) {
/*     */     case 0: 
/*     */     case 2: 
/* 148 */       Get.spells().SWARM.launchSwarm(avatar.getAvatarEntity(), targetEntity);
/* 149 */       Sound.MOD_RANDOM_SPELL3.playToAllNear(avatar.getAvatarEntity(), 0.5F, 0.7F);
/* 150 */       break;
/*     */     case 1: 
/* 152 */       Get.spells().EXPLODE.throwGrenade(avatar.getAvatarEntity(), targetEntity);
/* 153 */       Sound.MOD_RANDOM_SPELL3.playToAllNear(avatar.getAvatarEntity(), 0.5F, 0.7F);
/* 154 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */   public int getAttackAnimationTicksAOE(IAvatar avatar)
/*     */   {
/* 162 */     return 50;
/*     */   }
/*     */   
/*     */   public int getAttackAnimationTicksProjectile(IAvatar avatar)
/*     */   {
/* 167 */     return 10;
/*     */   }
/*     */   
/*     */   public boolean shouldDefenseCountdownActivate(IAvatar avatar)
/*     */   {
/* 172 */     EntityLiving entity = avatar.getAvatarEntity();
/* 173 */     if ((entity.func_70089_S()) && (entity.func_70643_av() != null) && (entity.func_70643_av().func_70089_S()) && 
/* 174 */       (entity.func_110143_aJ() < entity.func_110138_aP() * 0.75F) && (entity.field_70170_p.field_73012_v.nextDouble() < 0.2D)) {
/* 175 */       Sound.MOD_RANDOM_POWER_UP.playToAllNear(entity, 0.5F, 0.9F);
/* 176 */       return true;
/*     */     }
/* 178 */     return false;
/*     */   }
/*     */   
/*     */   public int getDefenseActivationTicks(IAvatar avatar)
/*     */   {
/* 183 */     return 60;
/*     */   }
/*     */   
/*     */   public int getDefenseDurationTicks(IAvatar avatar)
/*     */   {
/* 188 */     return 60;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onDefenseStart(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */   public void onDefenseTick(IAvatar avatar)
/*     */   {
/* 198 */     if (avatar.getAvatarEntity().field_70173_aa % 20 == 0) {
/* 199 */       int bolts = 8;
/* 200 */       double increment = 45.0D;
/* 201 */       double speed = 0.05D;
/* 202 */       for (int i = 0; i < 8; i++) {
/* 203 */         double mx = Math.sin(Math.toRadians(i * increment)) * speed;
/* 204 */         double mz = Math.cos(Math.toRadians(i * increment)) * speed;
/* 205 */         Get.spells().EXPLODE.throwGrenade(avatar.getAvatarEntity(), mx, 0.2D, mz);
/*     */       }
/* 207 */       Sound.MOD_RANDOM_SPELL1.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */     }
/*     */   }
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
/* 223 */     return 9;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/avatar/DeityAvatarBodyNone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */