/*     */ package emoniph.intangible.client.particle;
/*     */ 
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class EntityKnowledgeFX extends EntityFX
/*     */ {
/*     */   private float field_70565_a;
/*     */   private double field_70568_aq;
/*     */   private double field_70567_ar;
/*     */   private double field_70566_as;
/*     */   private EntityLivingBase target;
/*     */   
/*     */   public EntityKnowledgeFX(World worldIn, Vec3 pos, EntityLivingBase target)
/*     */   {
/*  19 */     this(worldIn, pos, getTargetVector(worldIn, pos, target, 0.0D));
/*  20 */     this.target = target;
/*     */   }
/*     */   
/*     */   private static Vec3 getTargetVector(World world, Vec3 source, EntityLivingBase target, double minDist) {
/*  24 */     double dir_x = target.field_70165_t - source.field_72450_a;
/*  25 */     double dir_y = target.field_70163_u + target.func_70047_e() - 0.1D - source.field_72448_b;
/*  26 */     double dir_z = target.field_70161_v - source.field_72449_c;
/*  27 */     double distance = Math.sqrt(dir_x * dir_x + dir_y * dir_y + dir_z * dir_z);
/*  28 */     if ((minDist > 0.0D) && (distance < minDist)) {
/*  29 */       return null;
/*     */     }
/*  31 */     double speed = 0.1D + world.field_73012_v.nextDouble() * 0.05D;
/*  32 */     double factor = speed / distance;
/*  33 */     double vel_x = dir_x * factor;
/*  34 */     double vel_y = dir_y * factor;
/*  35 */     double vel_z = dir_z * factor;
/*     */     
/*  37 */     Vec3 dir = new Vec3(vel_x, vel_y, vel_z);
/*  38 */     return dir;
/*     */   }
/*     */   
/*     */   public EntityKnowledgeFX(World worldIn, Vec3 pos, Vec3 speed) {
/*  42 */     super(worldIn, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c, speed.field_72450_a, speed.field_72448_b, speed.field_72449_c);
/*  43 */     this.field_70159_w = speed.field_72450_a;
/*  44 */     this.field_70181_x = speed.field_72448_b;
/*  45 */     this.field_70179_y = speed.field_72449_c;
/*  46 */     this.field_70568_aq = pos.field_72450_a;
/*  47 */     this.field_70567_ar = pos.field_72448_b;
/*  48 */     this.field_70566_as = pos.field_72449_c;
/*  49 */     this.field_70165_t = (this.field_70169_q = pos.field_72450_a + speed.field_72450_a);
/*  50 */     this.field_70163_u = (this.field_70167_r = pos.field_72448_b + speed.field_72448_b);
/*  51 */     this.field_70161_v = (this.field_70166_s = pos.field_72449_c + speed.field_72449_c);
/*     */     
/*  53 */     this.field_70565_a = (this.field_70544_f = this.field_70146_Z.nextFloat() * 0.5F + 0.2F);
/*  54 */     this.field_70552_h = (this.field_70146_Z.nextFloat() * 0.6F + 0.4F);
/*  55 */     this.field_70553_i = (this.field_70146_Z.nextFloat() * 0.6F + 0.4F);
/*  56 */     this.field_70551_j = (this.field_70146_Z.nextFloat() * 0.6F + 0.4F);
/*  57 */     this.field_70553_i *= 0.9F;
/*  58 */     this.field_70552_h *= 0.9F;
/*  59 */     this.field_70547_e = ((int)(Math.random() * 10.0D) + 50);
/*  60 */     this.field_70145_X = true;
/*  61 */     func_70536_a((int)(Math.random() * 26.0D + 1.0D + 224.0D));
/*     */   }
/*     */   
/*     */   public int func_70537_b()
/*     */   {
/*  66 */     return 0;
/*     */   }
/*     */   
/*     */   public int func_70070_b(float p_70070_1_) {
/*  70 */     int i = super.func_70070_b(p_70070_1_);
/*  71 */     float f1 = this.field_70546_d / this.field_70547_e;
/*  72 */     f1 *= f1;
/*  73 */     f1 *= f1;
/*  74 */     int j = i & 0xFF;
/*  75 */     int k = i >> 16 & 0xFF;
/*  76 */     k += (int)(f1 * 15.0F * 16.0F);
/*     */     
/*  78 */     if (k > 240) {
/*  79 */       k = 240;
/*     */     }
/*     */     
/*  82 */     return j | k << 16;
/*     */   }
/*     */   
/*     */   public float func_70013_c(float p_70013_1_) {
/*  86 */     float f1 = super.func_70013_c(p_70013_1_);
/*  87 */     float f2 = this.field_70546_d / this.field_70547_e;
/*  88 */     f2 *= f2;
/*  89 */     f2 *= f2;
/*  90 */     return f1 * (1.0F - f2) + f2;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  94 */     if ((this.target != null) && (this.target.func_70089_S()) && (this.target.field_71093_bK == this.field_71093_bK)) {
/*  95 */       Vec3 speed = getTargetVector(this.field_70170_p, new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v), this.target, 0.25D);
/*     */       
/*  97 */       if (speed == null)
/*     */       {
/*  99 */         func_70106_y();
/* 100 */         return;
/*     */       }
/* 102 */       this.field_70159_w = speed.field_72450_a;
/* 103 */       this.field_70181_x = speed.field_72448_b;
/* 104 */       this.field_70179_y = speed.field_72449_c;
/*     */     }
/* 106 */     super.func_70071_h_();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/particle/EntityKnowledgeFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */