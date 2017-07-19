/*     */ package emoniph.intangible.deity.effects;
/*     */ 
/*     */ import com.google.common.base.Predicate;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.entity.ai.IDefender;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.effect.EntityLightningBolt;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ 
/*     */ public class MinorMoreLightning implements emoniph.intangible.api.deity.IDeityMinorWorldEffect
/*     */ {
/*     */   public void onWorldTick(World world, IDeity deity)
/*     */   {
/*  31 */     int CHANCE_PER_RAIN_TICK = 100000;
/*  32 */     int CHANCE_PER_TICK = 50000;
/*     */     Iterator iterator;
/*  34 */     if ((world != null) && (!world.field_72995_K)) {
/*  35 */       for (iterator = world.field_72993_I.iterator(); iterator.hasNext();) {
/*  36 */         ChunkCoordIntPair chunkcoordintpair = (ChunkCoordIntPair)iterator.next();
/*  37 */         net.minecraft.world.chunk.Chunk chunk = world.func_72964_e(chunkcoordintpair.field_77276_a, chunkcoordintpair.field_77275_b);
/*  38 */         int k = chunkcoordintpair.field_77276_a * 16;
/*  39 */         int l = chunkcoordintpair.field_77275_b * 16;
/*  40 */         if (((world.field_73011_w.canDoLightning(chunk)) && (world.func_72896_J()) && 
/*  41 */           (world.func_72911_I()) && (world.field_73012_v.nextInt(50000) == 0)) || (
/*  42 */           (!world.func_72911_I()) && (world.field_73012_v.nextInt(100000) == 0))) {
/*  43 */           BlockPos blockpos = func_175736_a(world, new BlockPos(k + world.field_73012_v.nextInt(15), 0, l + world.field_73012_v.nextInt(15)));
/*  44 */           if (world.func_175727_C(blockpos)) {
/*  45 */             world.func_72942_c(new EntityLightningBolt(world, blockpos
/*  46 */               .func_177958_n(), blockpos.func_177956_o(), blockpos.func_177952_p()));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onEntityJoinWorld(World world, IDeity deity, Entity entity)
/*     */   {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   protected BlockPos func_175736_a(final World world, BlockPos pos) {
/*  59 */     BlockPos blockpos1 = world.func_175725_q(pos);
/*  60 */     AxisAlignedBB axisalignedbb = new AxisAlignedBB(blockpos1, new BlockPos(blockpos1.func_177958_n(), world.func_72800_K(), blockpos1.func_177952_p())).func_72314_b(3.0D, 3.0D, 3.0D);
/*  61 */     List list = world.func_175647_a(EntityLivingBase.class, axisalignedbb, new Predicate() {
/*     */       public boolean applyLiving(EntityLivingBase living) {
/*  63 */         return (living != null) && (living.func_70089_S()) && (world.func_175678_i(living.func_180425_c()));
/*     */       }
/*     */       
/*     */       public boolean apply(Object p_apply_1_) {
/*  67 */         return applyLiving((EntityLivingBase)p_apply_1_);
/*     */       }
/*  69 */     });
/*  70 */     return !list.isEmpty() ? ((EntityLivingBase)list.get(world.field_73012_v.nextInt(list.size()))).func_180425_c() : blockpos1;
/*     */   }
/*     */   
/*     */   public boolean isResistant(World world, IDeity deity)
/*     */   {
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public void performPriestEffect(World world, IDeity deity, EntityPlayer player)
/*     */   {
/*  80 */     player.func_70690_d(new net.minecraft.potion.PotionEffect(Potion.field_76426_n.field_76415_H, 6000, 0, false, false));
/*  81 */     if (!world.func_72911_I()) {
/*  82 */       WorldInfo worldinfo = world.func_72912_H();
/*  83 */       int i = (300 + world.field_73012_v.nextInt(600)) * 20;
/*  84 */       worldinfo.func_76080_g(i);
/*  85 */       worldinfo.func_76090_f(i);
/*  86 */       worldinfo.func_76084_b(true);
/*  87 */       worldinfo.func_76069_a(true);
/*     */     }
/*     */     
/*  90 */     float radius = 16.0F;
/*  91 */     float radiusSq = 256.0F;
/*  92 */     float radiusY = 4.0F;
/*     */     
/*  94 */     List<EntityLivingBase> targets = world.func_72872_a(EntityLivingBase.class, player
/*  95 */       .func_174813_aQ().func_72314_b(16.0D, 4.0D, 16.0D));
/*     */     
/*  97 */     for (EntityLivingBase target : targets) {
/*  98 */       if (player.func_70092_e(target.field_70165_t, player.field_70163_u, target.field_70161_v) < 256.0D) {
/*  99 */         if ((target instanceof EntityPlayer)) {
/* 100 */           if (!PlayerEx.get((EntityPlayer)target).getWorship().isDevoutFollowerOf(world, deity)) {}
/*     */ 
/*     */         }
/* 103 */         else if ((target instanceof EntityTameable)) {
/* 104 */           EntityTameable tameable = (EntityTameable)target;
/* 105 */           if (tameable.func_70902_q() == player) {
/*     */             continue;
/*     */           }
/* 108 */         } else if ((target instanceof IDefender)) {
/* 109 */           IDefender defender = (IDefender)target;
/* 110 */           if (defender.getOwnerEntities().contains(player)) {
/*     */             continue;
/*     */           }
/* 113 */         } else if ((target instanceof IAvatar)) {
/* 114 */           IAvatar avatar = (IAvatar)target;
/* 115 */           if (avatar.getDeityId().equals(deity.getId())) {
/*     */             continue;
/*     */           }
/*     */         }
/*     */         
/* 120 */         if (world.field_73012_v.nextInt(10) < 9) {
/* 121 */           world.func_72942_c(new EntityLightningBolt(world, target.field_70165_t, target.field_70163_u, target.field_70161_v));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onHarvest(World world, BlockPos pos, List<ItemStack> drops, EntityPlayer harvester, Deity deity) {}
/*     */   
/*     */   public void onPlayerUseItemFinish(World worldObj, EntityPlayer entityPlayer, ItemStack item, Deity deity) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/MinorMoreLightning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */