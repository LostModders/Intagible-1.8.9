/*     */ package emoniph.intangible.deity.avatar;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarPower;
/*     */ import emoniph.intangible.deity.IPlayerWorship;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AvatarPowerHealer
/*     */   implements IDeityAvatarPower
/*     */ {
/*     */   public void onAttacking(IAvatar avatar, IAttack attack, Entity target) {}
/*     */   
/*     */   public void onHurtBy(IAvatar avatar, IAttack attack) {}
/*     */   
/*     */   public void onTick(IAvatar avatar)
/*     */   {
/*  37 */     World world = avatar.getAvatarWorld();
/*  38 */     UUID deity; if ((!world.field_72995_K) && (avatar.getAvatarEntity().field_70173_aa % 20 == 2)) {
/*  39 */       deity = avatar.getDeityId();
/*  40 */       if (deity != null) {
/*  41 */         float HEAL_AMOUNT = 2.0F;
/*  42 */         float RADIUS_W = 8.0F;
/*  43 */         float RADIUS_W_SQ = 16.0F;
/*  44 */         float RADIUS_H = 2.0F;
/*  45 */         List<EntityPlayer> players = world.func_72872_a(EntityPlayer.class, avatar
/*  46 */           .getAvatarEntity().func_174813_aQ().func_72314_b(8.0D, 2.0D, 8.0D));
/*  47 */         for (EntityPlayer player : players) {
/*  48 */           if ((avatar.getAvatarEntity().func_70092_e(player.field_70165_t, avatar.getAvatarEntity().field_70163_u, player.field_70161_v) < 16.0D) && 
/*  49 */             (PlayerEx.get(player).getWorship().isDevoutFollowerOf(world, deity))) {
/*  50 */             player.func_70691_i(2.0F);
/*  51 */             if (world.field_73012_v.nextInt(10) == 0) {
/*  52 */               int idToRemove = 0;
/*  53 */               for (Object effectObj : player.func_70651_bq()) {
/*  54 */                 PotionEffect effect = (PotionEffect)effectObj;
/*  55 */                 if ((effect.func_76456_a() > 0) && (effect.func_76456_a() < Potion.field_76425_a.length)) {
/*  56 */                   Potion potion = Potion.field_76425_a[effect.func_76456_a()];
/*  57 */                   if ((potion != null) && (potion.field_76418_K)) {
/*  58 */                     idToRemove = potion.func_76396_c();
/*  59 */                     break;
/*     */                   }
/*     */                 }
/*     */               }
/*  63 */               if (idToRemove > 0) {
/*  64 */                 player.func_82170_o(idToRemove);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDeath(IAvatar avatar, DamageSource cause)
/*     */   {
/*  76 */     World world = avatar.getAvatarWorld();
/*  77 */     UUID deity; if (!world.field_72995_K) {
/*  78 */       deity = avatar.getDeityId();
/*  79 */       if (deity != null) {
/*  80 */         for (Object playerObj : world.field_73010_i) {
/*  81 */           EntityPlayer player = (EntityPlayer)playerObj;
/*  82 */           if (PlayerEx.get(player).getWorship().isDevoutFollowerOf(world, deity)) {
/*  83 */             player.func_70691_i(player.func_110138_aP());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*  90 */   private static final ItemStack[] GIFTS = { new ItemStack(Items.field_151068_bn, 1, 8225), new ItemStack(Items.field_151068_bn, 1, 8225), new ItemStack(Items.field_151068_bn, 1, 8225), new ItemStack(Items.field_151068_bn, 1, 8229), new ItemStack(Items.field_151068_bn, 1, 8229), new ItemStack(Items.field_151068_bn, 1, 8229), new ItemStack(Items.field_151068_bn, 1, 8259), new ItemStack(Items.field_151068_bn, 1, 8259), new ItemStack(Items.field_151068_bn, 1, 8259), new ItemStack(Items.field_151153_ao, 1, 0), new ItemStack(Items.field_151153_ao, 1, 0), new ItemStack(Items.field_151153_ao, 1, 1) };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onGive(IAvatar avatar, EntityPlayer player)
/*     */   {
/* 107 */     PlayerEx playerEx = PlayerEx.get(player);
/* 108 */     int PRESENT_COOLDOWN = 6000;
/* 109 */     if ((playerEx.getWorship().isDevoutFollowerOf(avatar.getAvatarWorld(), avatar.getDeityId())) && 
/* 110 */       (playerEx.getWorship().getLastGiftTime(avatar.getAvatarWorld(), avatar.getDeityId()) + 6000L < avatar.getAvatarWorld().func_82737_E())) {
/* 111 */       ItemStack heldStack = player.func_70694_bm();
/* 112 */       if ((heldStack != null) && (heldStack.func_77973_b() == Items.field_151068_bn) && (heldStack.func_77952_i() == 0)) {
/* 113 */         playerEx.getWorship().setLastGiftTime(avatar.getAvatarWorld(), avatar.getDeityId(), avatar.getAvatarWorld().func_82737_E());
/* 114 */         player.func_70062_b(0, GIFTS[avatar.getAvatarWorld().field_73012_v.nextInt(GIFTS.length)].func_77946_l());
/* 115 */         Sound.MOD_RANDOM_CHOIR1.playToAllNear(player, 0.5F, 0.8F);
/* 116 */         Get.fx().sendToAllNear(EnumParticleTypes.SPELL_INSTANT, avatar.getAvatarEntity(), 0.5F, 30, 16.0D);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/avatar/AvatarPowerHealer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */