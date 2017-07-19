/*     */ package emoniph.intangible.deity.avatar;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.client.models.ModelDeityBodyBiped;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class DeityAvatarBodyBiped implements emoniph.intangible.api.deity.IDeityAvatarBody
/*     */ {
/*  29 */   private static final ResourceLocation TEXTURE_URL = new ResourceLocation("intangible", "textures/entity/bodybiped.png");
/*  30 */   private static final float[] HEAD_OFFSET = { 0.0F, 0.0F, 0.0F };
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelDeityBodyBiped model;
/*     */   
/*  34 */   public float getHealthRegenPerTick(IAvatar avatar) { return 0.1F; }
/*     */   
/*     */ 
/*     */   public int getTeleportCooldownTicks(IAvatar avatar)
/*     */   {
/*  39 */     return 200;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ResourceLocation getTexture(IAvatar avatar)
/*     */   {
/*  48 */     return TEXTURE_URL;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public net.minecraft.client.model.ModelBase getModel(IAvatar avatar)
/*     */   {
/*  55 */     if (this.model == null) {
/*  56 */       this.model = new ModelDeityBodyBiped();
/*     */     }
/*  58 */     EntityLiving entity = avatar.getAvatarEntity();
/*     */     
/*  60 */     this.model.field_78091_s = entity.func_70631_g_();
/*  61 */     this.model.field_78117_n = entity.func_70093_af();
/*  62 */     this.model.field_78093_q = entity.func_70115_ae();
/*  63 */     return this.model;
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
/*  74 */     return HEAD_OFFSET;
/*     */   }
/*     */   
/*     */   public float getRenderAlpha(IAvatar avatar)
/*     */   {
/*  79 */     return 0.8F;
/*     */   }
/*     */   
/*     */   public float getGlintAlpha(IAvatar avatar)
/*     */   {
/*  84 */     return 0.5F;
/*     */   }
/*     */   
/*     */   public void applyRenderTransforms(IAvatar avatar)
/*     */   {
/*  89 */     float heavy = avatar.getDefenseTimerActivation();
/*  90 */     if (heavy > 0.0F) {
/*  91 */       double liftHeight = 2.0D;
/*  92 */       float progress = heavy / getDefenseActivationTicks(avatar);
/*  93 */       GlStateManager.func_179137_b(0.0D, -2.0D * (progress - progress * progress), 0.0D);
/*  94 */       GlStateManager.func_179114_b(1440.0F * progress, 0.0F, 1.0F, 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public float getDamageFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 100 */     return 4.0F;
/*     */   }
/*     */   
/*     */   public int getKnockbackModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 105 */     return 2;
/*     */   }
/*     */   
/*     */   public float getLaunchSpeedFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 110 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public int getFireAspectModifierFor(IAvatar avatar, Entity targetEntity)
/*     */   {
/* 115 */     return 0;
/*     */   }
/*     */   
/*     */   public double getAttackRangeAOE(IAvatar avatar)
/*     */   {
/* 120 */     return 4.0D;
/*     */   }
/*     */   
/*     */   public void performAttackAOE(IAvatar avatar)
/*     */   {
/* 125 */     World world = avatar.getAvatarWorld();
/* 126 */     if (!world.field_72995_K)
/*     */     {
/* 128 */       AxisAlignedBB bounds = avatar.getAvatarBounds();
/* 129 */       EntityLiving us = avatar.getAvatarEntity();
/* 130 */       double range = getAttackRangeAOE(avatar);
/* 131 */       java.util.List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, bounds.func_72314_b(range, 0.0D, range));
/*     */       
/* 133 */       float speed = 2.0F;
/* 134 */       float lift = 1.3F;
/* 135 */       for (EntityLivingBase target : list) {
/* 136 */         if ((avatar != target) && (target.func_70068_e(avatar.getAvatarEntity()) <= range * range)) {
/* 137 */           Vec3 vec = new Vec3(target.field_70165_t - us.field_70165_t, target.field_70163_u - us.field_70163_u, target.field_70161_v - us.field_70161_v).func_72432_b();
/* 138 */           double dx = vec.field_72450_a * speed;
/* 139 */           double dy = lift;
/* 140 */           double dz = vec.field_72449_c * speed;
/* 141 */           if ((target instanceof EntityPlayer)) {
/* 142 */             EntityPlayer player = (EntityPlayer)target;
/* 143 */             Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(player, dx, dy, dz), player);
/*     */           } else {
/* 145 */             target.field_70159_w = dx;
/* 146 */             target.field_70181_x = dy;
/* 147 */             target.field_70179_y = dz;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 152 */       Sound.MOD_RANDOM_BELLOW_OUT.playToAllNear(avatar.getAvatarEntity(), 0.5F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void performAttackProjectile(IAvatar avatar, EntityLivingBase targetEntity, float rangeAsPctOfMax)
/*     */   {
/* 158 */     Get.spells().MINI_BOLT.launchProjectile(avatar.getAvatarEntity(), targetEntity, 16777215, 204, 2.0F);
/* 159 */     Sound.MOD_RANDOM_SPELL1.playToAllNear(avatar.getAvatarEntity(), 0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public float getProjectileMinRangeSq(IAvatar avatar)
/*     */   {
/* 164 */     return 16.0F;
/*     */   }
/*     */   
/*     */   public int getProjectileCooldownTicks(IAvatar avatar)
/*     */   {
/* 169 */     return 10;
/*     */   }
/*     */   
/*     */   public int getAttackAnimationTicksAOE(IAvatar avatar)
/*     */   {
/* 174 */     return 20;
/*     */   }
/*     */   
/*     */   public int getAttackAnimationTicksProjectile(IAvatar avatar)
/*     */   {
/* 179 */     return 5;
/*     */   }
/*     */   
/*     */   public boolean shouldDefenseCountdownActivate(IAvatar avatar)
/*     */   {
/* 184 */     EntityLiving entity = avatar.getAvatarEntity();
/* 185 */     if ((entity.func_70089_S()) && (entity.func_70643_av() != null) && (entity.func_70643_av().func_70089_S()) && 
/* 186 */       (entity.func_110143_aJ() < entity.func_110138_aP() * 0.75F) && (entity.field_70170_p.field_73012_v.nextDouble() < 0.2D)) {
/* 187 */       Sound.MOD_RANDOM_BELLOW_IN.playToAllNear(entity, 0.5F, 0.9F);
/* 188 */       return true;
/*     */     }
/* 190 */     return false;
/*     */   }
/*     */   
/*     */   public int getDefenseActivationTicks(IAvatar avatar)
/*     */   {
/* 195 */     return 40;
/*     */   }
/*     */   
/*     */   public int getDefenseDurationTicks(IAvatar avatar)
/*     */   {
/* 200 */     return 120;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onDefenseStart(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */   public void onDefenseTick(IAvatar avatar)
/*     */   {
/* 210 */     if ((!avatar.getAvatarWorld().field_72995_K) && 
/* 211 */       (avatar.getDefenseTimer() % 20 == 0)) {
/* 212 */       EntityAvatar avatarEntity = (EntityAvatar)avatar.getAvatarEntity();
/*     */       
/*     */ 
/* 215 */       EntityLivingBase centerEntity = (avatarEntity.func_70643_av() != null) && (avatarEntity.func_70643_av().func_70089_S()) ? avatarEntity.func_70643_av() : (avatarEntity.func_70638_az() != null) && (avatarEntity.func_70638_az().func_70089_S()) ? avatarEntity.func_70638_az() : avatarEntity;
/*     */       
/*     */ 
/* 218 */       double range = 16.0D;
/* 219 */       java.util.List<EntityLivingBase> list = avatarEntity.field_70170_p.func_72872_a(EntityLivingBase.class, centerEntity
/* 220 */         .func_174813_aQ().func_72314_b(range, 5.0D, range));
/* 221 */       java.util.Collections.shuffle(list, avatar.getAvatarWorld().field_73012_v);
/* 222 */       boolean found = false;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 230 */       if (!found) {
/* 231 */         for (int i = 0; (i < 10) && (!found); i++) {
/* 232 */           double x = centerEntity.field_70165_t + centerEntity.field_70170_p.field_73012_v.nextInt(32) - 16.0D;
/* 233 */           double y = (int)centerEntity.field_70163_u;
/* 234 */           double z = centerEntity.field_70161_v + centerEntity.field_70170_p.field_73012_v.nextInt(32) - 16.0D;
/* 235 */           BlockPos pos = new BlockPos(x, y, z);
/* 236 */           for (int dy = 0; (dy < 5) && (!found); dy++) {
/* 237 */             if ((avatarEntity.field_70170_p.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) && 
/* 238 */               (avatarEntity.field_70170_p.func_180495_p(pos.func_177984_a()).func_177230_c().func_149688_o().func_76222_j()) && 
/* 239 */               (avatarEntity.field_70170_p.func_180495_p(pos.func_177981_b(2)).func_177230_c().func_149688_o().func_76222_j())) {
/* 240 */               if (!avatarEntity.teleportTo(x + 0.5D, centerEntity.field_70163_u + 6.0D, z + 0.5D)) break;
/* 241 */               found = true;
/*     */             }
/*     */             
/*     */ 
/*     */ 
/* 246 */             pos = pos.func_177984_a();
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 251 */       int bolts = 12;
/* 252 */       double increment = 30.0D;
/* 253 */       double speed = 0.05D;
/* 254 */       double start = avatarEntity.field_70170_p.field_73012_v.nextDouble() * increment;
/* 255 */       for (int i = 0; i < 12; i++)
/*     */       {
/* 257 */         double mx = Math.sin(Math.toRadians(i * increment + start)) * speed;
/* 258 */         double mz = Math.cos(Math.toRadians(i * increment + start)) * speed;
/* 259 */         Get.spells().DOOM_BOLT.launchProjectile(avatar.getAvatarEntity(), 52224, 204, 4.0F, mx, 0.0D, mz);
/*     */       }
/* 261 */       Sound.MOD_RANDOM_SPELL1.playToAllNear(avatar.getAvatarEntity(), 0.6F, 0.75F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDefenseHurtBy(IAvatar avatar, IAttack attack)
/*     */   {
/* 268 */     attack.setDamage(attack.getDamage() * 0.25F);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onDefenseStop(IAvatar avatar) {}
/*     */   
/*     */ 
/*     */   public int getTotalArmorValue()
/*     */   {
/* 278 */     return 9;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/avatar/DeityAvatarBodyBiped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */