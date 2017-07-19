/*     */ package emoniph.intangible.entity.ai;
/*     */ 
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IRangedAttackMob;
/*     */ 
/*     */ public class EntityAIAvatarArrowAttack extends net.minecraft.entity.ai.EntityAIBase
/*     */ {
/*     */   private final EntityLiving entityHost;
/*     */   private final IRangedAttackMob rangedAttackEntityHost;
/*     */   private EntityLivingBase attackTarget;
/*     */   private int rangedAttackTime;
/*     */   private double entityMoveSpeed;
/*     */   private int field_75318_f;
/*     */   private int field_96561_g;
/*     */   private int maxRangedAttackTime;
/*     */   private float field_96562_i;
/*     */   private float maxAttackDistance;
/*     */   
/*     */   public EntityAIAvatarArrowAttack(IRangedAttackMob p_i1649_1_, double p_i1649_2_, int p_i1649_4_, float p_i1649_5_)
/*     */   {
/*  22 */     this(p_i1649_1_, p_i1649_2_, p_i1649_4_, p_i1649_4_, p_i1649_5_);
/*     */   }
/*     */   
/*     */   public EntityAIAvatarArrowAttack(IRangedAttackMob p_i1650_1_, double p_i1650_2_, int p_i1650_4_, int p_i1650_5_, float p_i1650_6_) {
/*  26 */     this.rangedAttackTime = -1;
/*     */     
/*  28 */     if (!(p_i1650_1_ instanceof EntityLivingBase)) {
/*  29 */       throw new IllegalArgumentException("AvatarArrowAttackGoal requires Mob implements RangedAttackMob");
/*     */     }
/*  31 */     this.rangedAttackEntityHost = p_i1650_1_;
/*  32 */     this.entityHost = ((EntityLiving)p_i1650_1_);
/*  33 */     this.entityMoveSpeed = p_i1650_2_;
/*  34 */     this.field_96561_g = p_i1650_4_;
/*  35 */     this.maxRangedAttackTime = p_i1650_5_;
/*  36 */     this.field_96562_i = p_i1650_6_;
/*  37 */     this.maxAttackDistance = (p_i1650_6_ * p_i1650_6_);
/*  38 */     func_75248_a(3);
/*     */   }
/*     */   
/*     */   protected int getMaxRangedAttackTime()
/*     */   {
/*  43 */     return this.maxRangedAttackTime;
/*     */   }
/*     */   
/*     */   protected int getRangedAttackTime() {
/*  47 */     return this.field_96561_g;
/*     */   }
/*     */   
/*     */   public boolean func_75250_a() {
/*  51 */     EntityLivingBase entitylivingbase = this.entityHost.func_70638_az();
/*     */     
/*  53 */     if (entitylivingbase == null) {
/*  54 */       return false;
/*     */     }
/*  56 */     this.attackTarget = entitylivingbase;
/*  57 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_75253_b()
/*     */   {
/*  62 */     return (func_75250_a()) || (!this.entityHost.func_70661_as().func_75500_f());
/*     */   }
/*     */   
/*     */   public void func_75251_c() {
/*  66 */     this.attackTarget = null;
/*  67 */     this.field_75318_f = 0;
/*  68 */     this.rangedAttackTime = -1;
/*     */   }
/*     */   
/*     */   public void func_75246_d() {
/*  72 */     double d0 = this.entityHost.func_70092_e(this.attackTarget.field_70165_t, this.attackTarget.func_174813_aQ().field_72338_b, this.attackTarget.field_70161_v);
/*  73 */     boolean flag = this.entityHost.func_70635_at().func_75522_a(this.attackTarget);
/*     */     
/*  75 */     if (flag) {
/*  76 */       this.field_75318_f += 1;
/*     */     } else {
/*  78 */       this.field_75318_f = 0;
/*     */     }
/*     */     
/*  81 */     if ((d0 <= this.maxAttackDistance) && (this.field_75318_f >= 20)) {
/*  82 */       this.entityHost.func_70661_as().func_75499_g();
/*     */     } else {
/*  84 */       this.entityHost.func_70661_as().func_75497_a(this.attackTarget, this.entityMoveSpeed);
/*     */     }
/*     */     
/*  87 */     this.entityHost.func_70671_ap().func_75651_a(this.attackTarget, 30.0F, 30.0F);
/*     */     
/*     */ 
/*  90 */     if (--this.rangedAttackTime == 0) {
/*  91 */       if ((d0 > this.maxAttackDistance) || (!flag)) {
/*  92 */         return;
/*     */       }
/*     */       
/*  95 */       float f = net.minecraft.util.MathHelper.func_76133_a(d0) / this.field_96562_i;
/*  96 */       float f1 = net.minecraft.util.MathHelper.func_76131_a(f, 0.1F, 1.0F);
/*  97 */       this.rangedAttackEntityHost.func_82196_d(this.attackTarget, f1);
/*  98 */       this.rangedAttackTime = net.minecraft.util.MathHelper.func_76141_d(f * (getMaxRangedAttackTime() - getRangedAttackTime()) + getRangedAttackTime());
/*  99 */     } else if (this.rangedAttackTime < 0) {
/* 100 */       float f = net.minecraft.util.MathHelper.func_76133_a(d0) / this.field_96562_i;
/* 101 */       this.rangedAttackTime = net.minecraft.util.MathHelper.func_76141_d(f * (getMaxRangedAttackTime() - getRangedAttackTime()) + getRangedAttackTime());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/ai/EntityAIAvatarArrowAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */