/*     */ package emoniph.intangible.deity.avatar;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*     */ import emoniph.intangible.client.models.ModelDeityBodyTentacle;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class DeityAvatarBodyTentacle implements IDeityAvatarBody
/*     */ {
/*  26 */   private static final ResourceLocation TEXTURE_URL = new ResourceLocation("intangible", "textures/entity/bodytentacle.png");
/*  27 */   private static final float[] HEAD_OFFSET = { 0.0F, 1.0F, 0.0F };
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelDeityBodyTentacle model;
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
/*     */   public float getRenderAlpha(IAvatar avatar)
/*     */   {
/*  50 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public float getGlintAlpha(IAvatar avatar)
/*     */   {
/*  55 */     return 0.5F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelBase getModel(IAvatar avatar)
/*     */   {
/*  61 */     if (this.model == null) {
/*  62 */       this.model = new ModelDeityBodyTentacle();
/*     */     }
/*  64 */     return this.model;
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
/*  75 */     return HEAD_OFFSET;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void applyRenderTransforms(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public float getDamageFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/*  86 */     if ((targetEntity instanceof EntityLivingBase)) {
/*  87 */       EntityLivingBase target = (EntityLivingBase)targetEntity;
/*  88 */       if (target.func_70644_a(Potion.field_76421_d)) {
/*  89 */         if (target.func_70644_a(Potion.field_82731_v)) {
/*  90 */           return 12.0F;
/*     */         }
/*  92 */         return 8.0F;
/*     */       }
/*     */     }
/*  95 */     return 6.0F;
/*     */   }
/*     */   
/*     */   public int getKnockbackModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 100 */     return 2;
/*     */   }
/*     */   
/*     */   public float getLaunchSpeedFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 105 */     return 0.4F;
/*     */   }
/*     */   
/*     */   public int getFireAspectModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 110 */     return 0;
/*     */   }
/*     */   
/*     */   public float getProjectileMinRangeSq(IAvatar avatar)
/*     */   {
/* 115 */     return 25.0F;
/*     */   }
/*     */   
/*     */   public int getProjectileCooldownTicks(IAvatar avatar)
/*     */   {
/* 120 */     return 40;
/*     */   }
/*     */   
/*     */   public double getAttackRangeAOE(IAvatar avatar)
/*     */   {
/* 125 */     return 4.0D;
/*     */   }
/*     */   
/*     */   public void performAttackAOE(IAvatar avatar)
/*     */   {
/* 130 */     World world = avatar.getAvatarWorld();
/* 131 */     AxisAlignedBB bounds = avatar.getAvatarBounds();
/* 132 */     double range = getAttackRangeAOE(avatar);
/* 133 */     List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, bounds.func_72314_b(range, 0.0D, range));
/* 134 */     for (EntityLivingBase target : list) {
/* 135 */       if ((avatar != target) && (target.func_70068_e(avatar.getAvatarEntity()) <= range * range) && 
/* 136 */         (avatar.attackEntityAsAvatarBasic(target, 6.0F))) {
/* 137 */         target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 200, 1));
/* 138 */         target.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 40, 0));
/*     */       }
/*     */     }
/*     */     
/* 142 */     if (!world.field_72995_K) {
/* 143 */       Sound.MOD_RANDOM_SQUELCH.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void performAttackProjectile(IAvatar avatar, EntityLivingBase targetEntity, float rangeAsPctOfMax)
/*     */   {
/* 149 */     World world = avatar.getAvatarWorld();
/* 150 */     if (!world.field_72995_K) {
/* 151 */       Get.spells().VENOM.launchProjectile(avatar.getAvatarEntity(), targetEntity, 8138277, 32526, 4.0F);
/* 152 */       Sound.MOD_RANDOM_SPELL2.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getAttackAnimationTicksAOE(IAvatar avatar)
/*     */   {
/* 158 */     return 50;
/*     */   }
/*     */   
/*     */   public int getAttackAnimationTicksProjectile(IAvatar avatar)
/*     */   {
/* 163 */     return 10;
/*     */   }
/*     */   
/*     */   public boolean shouldDefenseCountdownActivate(IAvatar avatar)
/*     */   {
/* 168 */     EntityLiving entity = avatar.getAvatarEntity();
/* 169 */     if ((entity.func_70089_S()) && (entity.func_70643_av() != null) && (entity.func_70643_av().func_70089_S()) && 
/* 170 */       (entity.func_110143_aJ() < entity.func_110138_aP() * 0.75F) && (entity.field_70170_p.field_73012_v.nextDouble() < 0.2D)) {
/* 171 */       Sound.MOD_RANDOM_SLURP.playToAllNear(entity, 0.5F, 0.9F);
/* 172 */       return true;
/*     */     }
/* 174 */     return false;
/*     */   }
/*     */   
/*     */   public int getDefenseActivationTicks(IAvatar avatar)
/*     */   {
/* 179 */     return 60;
/*     */   }
/*     */   
/*     */   public int getDefenseDurationTicks(IAvatar avatar)
/*     */   {
/* 184 */     return 160;
/*     */   }
/*     */   
/*     */   public void onDefenseStart(IAvatar avatar)
/*     */   {
/* 189 */     World world = avatar.getAvatarWorld();
/* 190 */     EntityLiving entity = avatar.getAvatarEntity();
/* 191 */     AxisAlignedBB bounds = avatar.getAvatarBounds();
/* 192 */     double range = 10.0D;
/* 193 */     List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, bounds.func_72314_b(range, 0.0D, range));
/* 194 */     for (EntityLivingBase target : list) {
/* 195 */       if ((avatar != target) && (target.func_70068_e(entity) <= range * range) && 
/* 196 */         (avatar.attackEntityAsAvatarBasic(target, 2.0F))) {
/* 197 */         target.func_70690_d(new PotionEffect(Potion.field_76440_q.field_76415_H, 600, 0));
/* 198 */         target.func_70690_d(new PotionEffect(Potion.field_76438_s.field_76415_H, 400, 1));
/* 199 */         target.func_70634_a(entity.field_70165_t + world.field_73012_v.nextDouble() * 2.0D - 1.0D, entity.field_70163_u, entity.field_70161_v + world.field_73012_v
/*     */         
/* 201 */           .nextDouble() * 2.0D - 1.0D);
/*     */       }
/*     */     }
/*     */     
/* 205 */     if (!world.field_72995_K) {
/* 206 */       Sound.MOD_RANDOM_SQUELCH.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onDefenseTick(IAvatar avatar)
/*     */   {
/* 212 */     avatar.getAvatarEntity().field_70159_w = 0.0D;
/* 213 */     avatar.getAvatarEntity().field_70179_y = 0.0D;
/*     */     EntityLiving entity;
/* 215 */     double range; if (avatar.getAvatarEntity().field_70173_aa % 20 == 0) {
/* 216 */       World world = avatar.getAvatarWorld();
/* 217 */       entity = avatar.getAvatarEntity();
/* 218 */       AxisAlignedBB bounds = avatar.getAvatarBounds();
/* 219 */       range = 4.0D;
/* 220 */       List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, bounds.func_72314_b(range, 0.0D, range));
/* 221 */       for (EntityLivingBase target : list) {
/* 222 */         if ((avatar == target) || (target.func_70068_e(entity) > range * range) || 
/* 223 */           (!avatar.attackEntityAsAvatarBasic(target, 2.0F))) {}
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onDefenseHurtBy(IAvatar avatar, IAttack attack)
/*     */   {
/* 233 */     attack.setDamage(0.0F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onDefenseStop(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */   public int getTotalArmorValue()
/*     */   {
/* 243 */     return 11;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/avatar/DeityAvatarBodyTentacle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */