/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySeeker extends EntitySpell
/*     */ {
/*     */   int ticksAlive;
/*     */   int ticksBeforeSeek;
/*     */   EntityLivingBase target;
/*     */   UUID targetId;
/*     */   
/*     */   public EntitySeeker(World worldIn)
/*     */   {
/*  20 */     super(worldIn);
/*     */   }
/*     */   
/*     */   public EntitySeeker(World worldIn, EntityLivingBase shooter, EntityLivingBase target, emoniph.intangible.spells.projectiles.SpellSeeker spell) {
/*  24 */     super(worldIn, shooter, spell, 0.1D);
/*  25 */     func_70105_a(0.25F, 0.25F);
/*  26 */     this.target = target;
/*  27 */     this.ticksBeforeSeek = 20;
/*     */   }
/*     */   
/*     */   private static Vec3 getTargetVector(World world, Vec3 source, EntityLivingBase target, double minDist) {
/*  31 */     double dir_x = target.field_70165_t - source.field_72450_a;
/*  32 */     double dir_y = target.field_70163_u + target.func_70047_e() - 0.1D - source.field_72448_b;
/*  33 */     double dir_z = target.field_70161_v - source.field_72449_c;
/*  34 */     double distance = Math.sqrt(dir_x * dir_x + dir_y * dir_y + dir_z * dir_z);
/*  35 */     if ((minDist > 0.0D) && (distance < minDist))
/*  36 */       return null;
/*  37 */     if (distance < 0.1D) {
/*  38 */       distance = 0.1D;
/*  39 */       dir_x = 0.15D + world.field_73012_v.nextDouble() * 0.2D;
/*  40 */       dir_y = 0.15D + world.field_73012_v.nextDouble() * 0.2D;
/*  41 */       dir_z = 0.15D + world.field_73012_v.nextDouble() * 0.2D;
/*     */     }
/*  43 */     double speed = 0.3D;
/*  44 */     double factor = speed / Math.max(distance, 0.01D);
/*  45 */     double vel_x = dir_x * factor;
/*  46 */     double vel_y = dir_y * factor;
/*  47 */     double vel_z = dir_z * factor;
/*     */     
/*  49 */     Vec3 dir = new Vec3(vel_x, vel_y, vel_z);
/*  50 */     return dir;
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/*  55 */     if ((!this.field_70170_p.field_72995_K) && (this.shooterId != null)) {
/*  56 */       double range = 128.0D;
/*  57 */       java.util.List<EntityLivingBase> list = this.field_70170_p.func_72872_a(EntityLivingBase.class, func_174813_aQ().func_72314_b(128.0D, 128.0D, 128.0D));
/*  58 */       for (EntityLivingBase entity : list) {
/*  59 */         if (entity.func_110124_au().equals(this.targetId)) {
/*  60 */           this.target = entity;
/*  61 */           break;
/*     */         }
/*     */       }
/*  64 */       this.targetId = null;
/*     */     }
/*     */     
/*  67 */     this.field_70173_aa += 1;
/*     */     
/*  69 */     if (this.field_70173_aa >= this.ticksBeforeSeek) {
/*  70 */       if (this.target != null) {
/*  71 */         if ((this.target.func_70089_S()) && (this.target.field_71093_bK == this.field_71093_bK)) {
/*  72 */           Vec3 speed = getTargetVector(this.field_70170_p, new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v), this.target, 0.0D);
/*     */           
/*  74 */           if (speed == null) {
/*  75 */             func_70106_y();
/*  76 */             return;
/*     */           }
/*  78 */           this.field_70159_w = (speed.field_72450_a + this.accelerationX);
/*  79 */           this.field_70181_x = (speed.field_72448_b + this.accelerationY);
/*  80 */           this.field_70179_y = (speed.field_72449_c + this.accelerationZ);
/*     */         } else {
/*  82 */           func_70106_y();
/*     */         }
/*     */       }
/*  85 */       else if (this.field_70173_aa % 20 == 0) {
/*  86 */         double range = 16.0D;
/*  87 */         java.util.List<EntityLivingBase> list = this.field_70170_p.func_72872_a(EntityLivingBase.class, func_174813_aQ().func_72314_b(16.0D, 16.0D, 16.0D));
/*  88 */         EntityLivingBase closest = null;
/*  89 */         double closestSq = 0.0D;
/*  90 */         for (EntityLivingBase entity : list) {
/*  91 */           double distSq = entity.func_70068_e(this);
/*  92 */           if ((closest == null) || (distSq < closestSq)) {
/*  93 */             closest = entity;
/*  94 */             closestSq = distSq;
/*     */           }
/*     */         }
/*  97 */         this.target = closest;
/*     */       }
/*     */     }
/*     */     
/* 101 */     super.func_70071_h_();
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 106 */     super.func_70014_b(compound);
/* 107 */     compound.func_74768_a("ticksAlive", this.ticksAlive);
/* 108 */     compound.func_74768_a("ticksBeforeSeek", this.ticksBeforeSeek);
/* 109 */     if (this.target != null) {
/* 110 */       compound.func_74772_a("targetLeast", this.target.func_110124_au().getLeastSignificantBits());
/* 111 */       compound.func_74772_a("targetMost", this.target.func_110124_au().getMostSignificantBits());
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 117 */     super.func_70037_a(compound);
/* 118 */     this.ticksAlive = compound.func_74762_e("ticksAlive");
/* 119 */     this.ticksBeforeSeek = compound.func_74762_e("ticksBeforeSeek");
/* 120 */     if ((compound.func_150297_b("targetLeast", 4)) && (compound.func_150297_b("targetMost", 4))) {
/* 121 */       this.targetId = new UUID(compound.func_74763_f("targetMost"), compound.func_74763_f("targetLeast"));
/*     */     } else {
/* 123 */       this.target = null;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySeeker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */