/*     */ package emoniph.intangible.util;
/*     */ 
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityTracker;
/*     */ import net.minecraft.entity.EntityTrackerEntry;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import org.apache.commons.lang3.Range;
/*     */ 
/*     */ public enum EntityUtil
/*     */ {
/*     */   private EntityUtil() {}
/*     */   
/*  30 */   private static Field fieldTrackedEntities = null;
/*     */   
/*  32 */   public static void correctProjectileTrackerSync(World world, Entity projectile) { if ((!world.field_72995_K) && ((world instanceof WorldServer))) {
/*     */       try {
/*  34 */         if (fieldTrackedEntities == null) {
/*  35 */           fieldTrackedEntities = net.minecraftforge.fml.relauncher.ReflectionHelper.findField(EntityTracker.class, new String[] { "trackedEntities", "field_72793_b" });
/*     */         }
/*     */         
/*  38 */         if (fieldTrackedEntities != null) {
/*  39 */           EntityTracker tracker = ((WorldServer)world).func_73039_n();
/*  40 */           Set trackedEntities = (Set)fieldTrackedEntities.get(tracker);
/*  41 */           Iterator iterator = trackedEntities.iterator();
/*  42 */           while (iterator.hasNext()) {
/*  43 */             EntityTrackerEntry next = (EntityTrackerEntry)iterator.next();
/*  44 */             if (next.field_73132_a == projectile) {
/*  45 */               next.field_73136_m = 1;
/*  46 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       catch (IllegalAccessException localIllegalAccessException) {}catch (Exception localException) {}
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean trySetRandomNearbyPosition(EntityLiving entity, World world, Vec3 center, Range<Double> range, int yRadius)
/*     */   {
/*  57 */     int SPAWN_ATTEMPTS = 5;
/*     */     
/*  59 */     double width = ((Double)range.getMaximum()).doubleValue() - ((Double)range.getMinimum()).doubleValue();
/*  60 */     for (int attempt = 0; attempt < 5; attempt++) {
/*  61 */       double d = world.field_73012_v.nextDouble() * width * 2.0D - width;
/*  62 */       double x = center.field_72450_a + d + (d < 0.0D ? -((Double)range.getMinimum()).doubleValue() : ((Double)range.getMinimum()).doubleValue());
/*  63 */       d = world.field_73012_v.nextDouble() * width * 2.0D - width;
/*  64 */       double z = center.field_72449_c + d + (d < 0.0D ? -((Double)range.getMinimum()).doubleValue() : ((Double)range.getMinimum()).doubleValue());
/*     */       
/*  66 */       double y = center.field_72448_b;
/*  67 */       int sign = 1;
/*  68 */       int dy = 0; for (int yRange = yRadius * 2; dy < yRange; dy++) {
/*  69 */         sign *= -1;
/*  70 */         y += dy * sign;
/*  71 */         BlockPos pos = new BlockPos(x, y, z);
/*  72 */         IBlockState state = world.func_180495_p(pos);
/*  73 */         if ((!state.func_177230_c().func_149688_o().func_76222_j()) && (areBlocksAboveReplaceable(world, pos, entity.field_70131_O))) {
/*  74 */           entity.func_70080_a(x + 0.5D, y + 1.0D, z + 0.5D, 0.0F, 0.0F);
/*  75 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   private static boolean areBlocksAboveReplaceable(World world, BlockPos basePos, double height) {
/*  84 */     int blockCount = MathHelper.func_76143_f(height);
/*  85 */     for (int i = 1; i <= blockCount; i++) {
/*  86 */       if (!world.func_180495_p(basePos.func_177981_b(i)).func_177230_c().func_149688_o().func_76222_j()) {
/*  87 */         return false;
/*     */       }
/*     */     }
/*  90 */     return true;
/*     */   }
/*     */   
/*     */   public static <T extends Entity> T getClosestFrom(List<T> entityList, Entity sourceEntity) {
/*  94 */     T closest = null;
/*  95 */     double closestDistSq = Double.MAX_VALUE;
/*  96 */     for (T entity : entityList) {
/*  97 */       if ((entity != null) && (entity != sourceEntity) && (entity.func_70089_S())) {
/*  98 */         double distSq = sourceEntity.func_70068_e(entity);
/*  99 */         if ((closest == null) || (distSq < closestDistSq)) {
/* 100 */           closestDistSq = distSq;
/* 101 */           closest = entity;
/*     */         }
/*     */       }
/*     */     }
/* 105 */     return closest;
/*     */   }
/*     */   
/*     */   public static void clearTasks(EntityLiving entity, EntityAITasks tasks) {
/* 109 */     List<EntityAITasks.EntityAITaskEntry> tasksCopy = new java.util.ArrayList(tasks.field_75782_a);
/* 110 */     for (EntityAITasks.EntityAITaskEntry task : tasksCopy) {
/* 111 */       tasks.func_85156_a(task.field_75733_a);
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean canEntityBeSeen(EntityPlayer player, Entity target) {
/* 116 */     return player.field_70170_p.func_72933_a(new Vec3(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v), new Vec3(target.field_70165_t, target.field_70163_u + target.func_70047_e(), target.field_70161_v)) == null;
/*     */   }
/*     */   
/*     */   public static Vec3 vecFromMidOf(Entity entity) {
/* 120 */     return new Vec3(entity.field_70165_t, entity.field_70163_u + entity.field_70131_O * 0.5D, entity.field_70161_v);
/*     */   }
/*     */   
/*     */   public static Vec3 vecFromMidOf(Entity entity, double dx, double dy, double dz) {
/* 124 */     return new Vec3(entity.field_70165_t + dx, entity.field_70163_u + dy + entity.field_70131_O * 0.5D, entity.field_70161_v + dz);
/*     */   }
/*     */   
/*     */   public static void pullTowards(World world, Entity entity, Vec3 target, double dy, double yy) {
/* 128 */     if ((entity instanceof net.minecraft.entity.boss.IBossDisplayData)) {
/* 129 */       return;
/*     */     }
/*     */     
/* 132 */     double d = target.field_72450_a - entity.field_70165_t;
/* 133 */     double d1 = target.field_72448_b - entity.field_70163_u;
/* 134 */     double d2 = target.field_72449_c - entity.field_70161_v;
/*     */     
/*     */ 
/* 137 */     float distance = MathHelper.func_76133_a(d * d + d1 * d1 + d2 * d2);
/* 138 */     if (distance < 0.01D) {
/* 139 */       return;
/*     */     }
/* 141 */     float f2 = 0.1F + (float)dy;
/*     */     
/* 143 */     double mx = d / distance * f2 * distance;
/*     */     
/* 145 */     double my = yy == 0.0D ? 0.4D : d1 / distance * distance * 0.2D + 0.2D + yy;
/* 146 */     double mz = d2 / distance * f2 * distance;
/*     */     
/*     */ 
/* 149 */     if ((entity instanceof EntityPlayer)) {
/* 150 */       EntityPlayer player = (EntityPlayer)entity;
/* 151 */       emoniph.intangible.Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(player, mx, my, mz), player);
/*     */     } else {
/* 153 */       entity.field_70159_w = mx;
/* 154 */       entity.field_70181_x = my;
/* 155 */       entity.field_70179_y = mz;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static float interpolateRotation(float par1, float par2, float par3)
/*     */   {
/* 162 */     for (float f = par2 - par1; f < -180.0F; f += 360.0F) {}
/*     */     
/*     */ 
/*     */ 
/* 166 */     while (f >= 180.0F) {
/* 167 */       f -= 360.0F;
/*     */     }
/*     */     
/* 170 */     return par1 + par3 * f;
/*     */   }
/*     */   
/*     */   public static boolean isInAir(EntityPlayer player, boolean isLoggedInPlayer) {
/* 174 */     if ((player.field_71075_bZ.field_75100_b) || (player.field_70143_R > 2.0F)) {
/* 175 */       return true;
/*     */     }
/*     */     
/* 178 */     if (!isLoggedInPlayer) {
/* 179 */       int blocks = 0;
/*     */       
/* 181 */       for (int i = 0; i < 4; i++) {
/* 182 */         int j = MathHelper.func_76128_c(player.field_70165_t + (i % 2 * 2 - 1) * 0.5F);
/* 183 */         int l = MathHelper.func_76128_c(player.field_70161_v + (i / 2 % 2 * 2 - 1) * 0.5F);
/*     */         
/* 185 */         BlockPos pos = new BlockPos(j, player.field_70163_u - 1.0D, l);
/* 186 */         if (player.field_70170_p.func_175623_d(pos)) {
/* 187 */           blocks++;
/*     */         }
/*     */       }
/* 190 */       return blocks == 4;
/*     */     }
/*     */     
/* 193 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/EntityUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */