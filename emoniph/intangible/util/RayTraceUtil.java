/*     */ package emoniph.intangible.util;
/*     */ 
/*     */ import com.google.common.base.Predicate;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.MovingObjectPosition.MovingObjectType;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ public enum RayTraceUtil
/*     */ {
/*     */   private RayTraceUtil() {}
/*     */   
/*     */   public static MovingObjectPosition traceAny(EntityLivingBase entity, boolean collisionFlag, double reachDistance)
/*     */   {
/*  20 */     Vec3 entityPosition = getPosition(entity);
/*  21 */     Vec3 entityViewOffset = getViewOffset(entity, entityPosition, reachDistance);
/*     */     
/*  23 */     MovingObjectPosition hitBlock = traceBlock(entity, collisionFlag, entityPosition, entityViewOffset);
/*  24 */     MovingObjectPosition hitEntity = traceEntity(entity, reachDistance, entityPosition, entityViewOffset, false, null);
/*     */     
/*  26 */     if ((hitEntity == null) || (hitEntity.field_72313_a == MovingObjectPosition.MovingObjectType.MISS)) {
/*  27 */       return (hitBlock != null) && (hitBlock.field_72313_a != MovingObjectPosition.MovingObjectType.MISS) ? hitBlock : null;
/*     */     }
/*     */     
/*  30 */     if ((hitBlock == null) || (hitBlock.field_72313_a == MovingObjectPosition.MovingObjectType.MISS)) {
/*  31 */       return (hitEntity != null) && (hitEntity.field_72313_a != MovingObjectPosition.MovingObjectType.MISS) ? hitEntity : null;
/*     */     }
/*     */     
/*  34 */     if (hitEntity.field_72307_f.func_72436_e(entityPosition) < hitBlock.field_72307_f.func_72436_e(entityPosition)) {
/*  35 */       return hitEntity;
/*     */     }
/*  37 */     return hitBlock;
/*     */   }
/*     */   
/*     */   public static MovingObjectPosition traceEntity(EntityLivingBase entity, double reachDistance, boolean livingOnly, EntityLivingBase[] exclusions)
/*     */   {
/*  42 */     Vec3 entityPosition = getPosition(entity);
/*  43 */     Vec3 entityViewOffset = getViewOffset(entity, entityPosition, reachDistance);
/*  44 */     MovingObjectPosition hitEntity = traceEntity(entity, reachDistance, entityPosition, entityViewOffset, livingOnly, exclusions);
/*  45 */     return (hitEntity != null) && (hitEntity.field_72313_a != MovingObjectPosition.MovingObjectType.MISS) ? hitEntity : null;
/*     */   }
/*     */   
/*     */   public static MovingObjectPosition traceBlock(EntityLivingBase entity, boolean collisionFlag, double reachDistance) {
/*  49 */     Vec3 entityPosition = getPosition(entity);
/*  50 */     Vec3 entityViewOffset = getViewOffset(entity, entityPosition, reachDistance);
/*  51 */     MovingObjectPosition hitBlock = traceBlock(entity, collisionFlag, entityPosition, entityViewOffset);
/*  52 */     return (hitBlock != null) && (hitBlock.field_72313_a != MovingObjectPosition.MovingObjectType.MISS) ? hitBlock : null;
/*     */   }
/*     */   
/*     */   public static Vec3 getPosition(EntityLivingBase entity) {
/*  56 */     return new Vec3(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v);
/*     */   }
/*     */   
/*     */   public static Vec3 getViewOffset(EntityLivingBase entity, Vec3 entityPosition, double reachDistance) {
/*  60 */     Vec3 playerLook = entity.func_70040_Z();
/*  61 */     Vec3 viewOffset = new Vec3(entityPosition.field_72450_a + playerLook.field_72450_a * reachDistance, entityPosition.field_72448_b + playerLook.field_72448_b * reachDistance, entityPosition.field_72449_c + playerLook.field_72449_c * reachDistance);
/*     */     
/*     */ 
/*     */ 
/*  65 */     return viewOffset;
/*     */   }
/*     */   
/*  68 */   private static final Predicate LIVING_ONLY = new Predicate() {
/*     */     public boolean apply(Entity entityIn) {
/*  70 */       if (!(entityIn instanceof EntityLivingBase)) {
/*  71 */         return false;
/*     */       }
/*     */       
/*  74 */       if (!(entityIn instanceof EntityPlayer)) {
/*  75 */         return true;
/*     */       }
/*     */       
/*  78 */       EntityPlayer player = (EntityPlayer)entityIn;
/*  79 */       if (player.func_175149_v()) {
/*  80 */         return false;
/*     */       }
/*     */       
/*  83 */       if (Get.effects().isActiveFor(Get.effects().INCORPOREAL, player)) {
/*  84 */         return false;
/*     */       }
/*     */       
/*  87 */       return true;
/*     */     }
/*     */     
/*     */     public boolean apply(Object p_apply_1_) {
/*  91 */       return apply((Entity)p_apply_1_);
/*     */     }
/*     */   };
/*     */   
/*     */   private static MovingObjectPosition traceEntity(EntityLivingBase entity, double reachDistance, Vec3 entityPosition, Vec3 entityViewOffset, boolean onlyLiving, EntityLivingBase[] exclusions) {
/*  96 */     MovingObjectPosition mopTarget = null;
/*  97 */     double playerBorder = 1.1D * reachDistance;
/*     */     
/*  99 */     AxisAlignedBB scanBounds = entity.func_174813_aQ().func_72314_b(playerBorder, playerBorder, playerBorder);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 136 */     java.util.List hitEntityList = onlyLiving ? entity.func_130014_f_().func_175674_a(entity, scanBounds, new Predicate() {
/*     */       public boolean apply(Entity entityIn) {
/* 102 */         if (!(entityIn instanceof EntityLivingBase)) {
/* 103 */           return false;
/*     */         }
/*     */         
/* 106 */         if (this.val$exclusions != null) {
/* 107 */           for (int i = 0; i < this.val$exclusions.length; i++) {
/* 108 */             if (entityIn == this.val$exclusions[i]) {
/* 109 */               return false;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 114 */         if (!(entityIn instanceof EntityPlayer)) {
/* 115 */           return true;
/*     */         }
/*     */         
/* 118 */         EntityPlayer player = (EntityPlayer)entityIn;
/* 119 */         if (player.func_175149_v()) {
/* 120 */           return false;
/*     */         }
/*     */         
/* 123 */         if (Get.effects().isActiveFor(Get.effects().INCORPOREAL, player)) {
/* 124 */           return false;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 129 */         return true;
/*     */       }
/*     */       
/*     */       public boolean apply(Object p_apply_1_) {
/* 133 */         return apply((Entity)p_apply_1_);
/*     */       }
/*     */       
/* 136 */     }) : entity.func_130014_f_().func_72839_b(entity, scanBounds);
/* 137 */     if (hitEntityList.isEmpty()) {
/* 138 */       return null;
/*     */     }
/*     */     
/* 141 */     double closestEntity = reachDistance;
/* 142 */     for (Entity hitEntity : hitEntityList) {
/* 143 */       if ((hitEntity != null) && (hitEntity.func_70067_L()) && (hitEntity.func_174813_aQ() != null)) {
/* 144 */         float collideBorder = hitEntity.func_70111_Y();
/* 145 */         AxisAlignedBB entityBounds = hitEntity.func_174813_aQ().func_72314_b(collideBorder, collideBorder, collideBorder);
/* 146 */         MovingObjectPosition mop = entityBounds.func_72327_a(entityPosition, entityViewOffset);
/* 147 */         if (mop != null) {
/* 148 */           if (entityBounds.func_72318_a(entityPosition)) {
/* 149 */             if ((0.0D < closestEntity) || (closestEntity == 0.0D)) {
/* 150 */               mopTarget = new MovingObjectPosition(hitEntity);
/* 151 */               if (mopTarget != null) {
/* 152 */                 mopTarget.field_72307_f = mop.field_72307_f;
/* 153 */                 closestEntity = 0.0D;
/*     */               }
/*     */             }
/*     */           } else {
/* 157 */             double distance = entityPosition.func_72438_d(mop.field_72307_f);
/* 158 */             if ((distance < closestEntity) || (closestEntity == 0.0D)) {
/* 159 */               mopTarget = new MovingObjectPosition(hitEntity);
/* 160 */               mopTarget.field_72307_f = mop.field_72307_f;
/* 161 */               closestEntity = distance;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 168 */     return mopTarget;
/*     */   }
/*     */   
/*     */   private static MovingObjectPosition traceBlock(EntityLivingBase entity, boolean collisionFlag, Vec3 playerPosition, Vec3 playerViewOffset) {
/* 172 */     return entity.func_130014_f_().func_147447_a(playerPosition, playerViewOffset, collisionFlag, !collisionFlag, false);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/RayTraceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */