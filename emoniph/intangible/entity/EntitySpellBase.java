/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.souls.ISoulHost;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntitySpellBase extends Entity
/*     */ {
/*  22 */   private int xTile = -1;
/*  23 */   private int yTile = -1;
/*  24 */   private int zTile = -1;
/*     */   private Block inTile;
/*     */   private boolean inGround;
/*     */   public EntityLivingBase shootingEntity;
/*     */   private int ticksAlive;
/*     */   private int ticksInAir;
/*     */   public double accelerationX;
/*     */   public double accelerationY;
/*     */   public double accelerationZ;
/*     */   protected UUID shooterId;
/*     */   protected boolean unexpected;
/*     */   protected boolean overclocked;
/*     */   
/*     */   protected EntitySpellBase(World worldIn) {
/*  38 */     super(worldIn);
/*  39 */     func_70105_a(1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {}
/*     */   
/*     */   public EntitySpellBase setBehaviourPowerUps(boolean unexpected, boolean overclocked)
/*     */   {
/*  46 */     this.unexpected = unexpected;
/*  47 */     this.overclocked = overclocked;
/*  48 */     return this;
/*     */   }
/*     */   
/*     */   public boolean isBehaviourUnexpected() {
/*  52 */     return this.unexpected;
/*     */   }
/*     */   
/*     */   public boolean isBehaviourOverclocked() {
/*  56 */     return this.overclocked;
/*     */   }
/*     */   
/*     */   protected EntitySpellBase(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ) {
/*  60 */     super(worldIn);
/*  61 */     func_70105_a(1.0F, 1.0F);
/*  62 */     func_70012_b(x, y, z, this.field_70177_z, this.field_70125_A);
/*  63 */     func_70107_b(x, y, z);
/*  64 */     double d6 = MathHelper.func_76133_a(accelX * accelX + accelY * accelY + accelZ * accelZ);
/*  65 */     this.accelerationX = (accelX / d6 * 0.1D);
/*  66 */     this.accelerationY = (accelY / d6 * 0.1D);
/*  67 */     this.accelerationZ = (accelZ / d6 * 0.1D);
/*     */   }
/*     */   
/*     */   protected EntitySpellBase(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ, double speed) {
/*  71 */     this(worldIn, shooter, accelX, accelY, accelZ, speed, 0.0F);
/*     */   }
/*     */   
/*     */   protected EntitySpellBase(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ, double speed, float angleOffset) {
/*  75 */     super(worldIn);
/*  76 */     this.shootingEntity = shooter;
/*  77 */     func_70105_a(1.0F, 1.0F);
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
/*  90 */     float f = 1.0F;
/*  91 */     double motionX = -MathHelper.func_76126_a(shooter.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(shooter.field_70125_A / 180.0F * 3.1415927F) * f;
/*  92 */     double motionZ = MathHelper.func_76134_b(shooter.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(shooter.field_70125_A / 180.0F * 3.1415927F) * f;
/*  93 */     double motionY = -MathHelper.func_76126_a(shooter.field_70125_A / 180.0F * 3.1415927F) * f;
/*  94 */     func_70012_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
/*  95 */     func_70107_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v);
/*  96 */     double d6 = MathHelper.func_76133_a(motionX * motionX + motionY * motionY + motionZ * motionZ);
/*  97 */     this.accelerationX = (motionX / d6 * speed);
/*  98 */     this.accelerationY = (motionY / d6 * speed);
/*  99 */     this.accelerationZ = (motionZ / d6 * speed);
/* 100 */     double d8 = 1.5D;
/* 101 */     Vec3 vec3 = shooter.func_70676_i(1.0F);
/* 102 */     if (angleOffset != 0.0F) {
/* 103 */       vec3 = vec3.func_178785_b(angleOffset);
/*     */     }
/*     */     
/* 106 */     this.field_70165_t = (shooter.field_70165_t + vec3.field_72450_a * 1.5D);
/* 107 */     this.field_70163_u = (shooter.field_70163_u + shooter.func_70047_e() - 0.10000000149011612D + vec3.field_72448_b * 1.5D);
/* 108 */     this.field_70161_v = (shooter.field_70161_v + vec3.field_72449_c * 1.5D);
/*     */   }
/*     */   
/*     */   protected EntitySpellBase(World worldIn, EntityLivingBase shooter, Entity proxySource, EntityLivingBase target, double accelX, double accelY, double accelZ, double speed) {
/* 112 */     super(worldIn);
/* 113 */     this.shootingEntity = shooter;
/* 114 */     func_70105_a(1.0F, 1.0F);
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
/* 127 */     double dx = target.field_70165_t - proxySource.field_70165_t;
/* 128 */     double dy = target.field_70163_u + target.func_70047_e() - (proxySource.field_70163_u + proxySource.func_70047_e());
/* 129 */     double dz = target.field_70161_v - proxySource.field_70161_v;
/* 130 */     double dist = Math.max(Math.sqrt(dx * dx + dy * dy + dz * dz), 1.0E-4D);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 137 */     double motionX = dx / dist;
/* 138 */     double motionY = dy / dist;
/* 139 */     double motionZ = dz / dist;
/*     */     
/*     */ 
/* 142 */     func_70012_b(proxySource.field_70165_t, proxySource.field_70163_u + proxySource.func_70047_e(), proxySource.field_70161_v, proxySource.field_70177_z, proxySource.field_70125_A);
/* 143 */     func_70107_b(proxySource.field_70165_t, proxySource.field_70163_u + proxySource.func_70047_e(), proxySource.field_70161_v);
/*     */     
/* 145 */     this.accelerationX = (motionX * speed);
/* 146 */     this.accelerationY = (motionY * speed);
/* 147 */     this.accelerationZ = (motionZ * speed);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 156 */     if ((!this.field_70170_p.field_72995_K) && (this.shooterId != null)) {
/* 157 */       double range = 128.0D;
/* 158 */       List<EntityLivingBase> list = this.field_70170_p.func_72872_a(EntityLivingBase.class, func_174813_aQ().func_72314_b(128.0D, 128.0D, 128.0D));
/* 159 */       for (EntityLivingBase entity : list) {
/* 160 */         if (entity.func_110124_au().equals(this.shooterId)) {
/* 161 */           this.shootingEntity = entity;
/* 162 */           break;
/*     */         }
/*     */       }
/* 165 */       this.shooterId = null;
/*     */     }
/*     */     
/* 168 */     if ((!this.field_70170_p.field_72995_K) && (((this.shootingEntity != null) && (this.shootingEntity.field_70128_L)) || (!this.field_70170_p.func_175667_e(new net.minecraft.util.BlockPos(this))))) {
/* 169 */       func_70106_y();
/*     */     } else {
/* 171 */       super.func_70071_h_();
/*     */       
/*     */ 
/* 174 */       if (this.inGround) {
/* 175 */         if (this.field_70170_p.func_180495_p(new net.minecraft.util.BlockPos(this.xTile, this.yTile, this.zTile)).func_177230_c() == this.inTile) {
/* 176 */           this.ticksAlive += 1;
/*     */           
/* 178 */           if (this.ticksAlive == getMaxTicksInGround()) {
/* 179 */             func_70106_y();
/*     */           }
/*     */           
/* 182 */           return;
/*     */         }
/*     */         
/* 185 */         this.inGround = false;
/* 186 */         this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 187 */         this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 188 */         this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 189 */         this.ticksAlive = 0;
/* 190 */         this.ticksInAir = 0;
/*     */       } else {
/* 192 */         this.ticksInAir += 1;
/*     */         
/* 194 */         if (this.ticksInAir == getMaxTicksInAir()) {
/* 195 */           func_70106_y();
/*     */         }
/*     */       }
/*     */       
/* 199 */       Vec3 vec3 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 200 */       Vec3 vec31 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 201 */       MovingObjectPosition movingobjectposition = this.field_70170_p.func_72933_a(vec3, vec31);
/* 202 */       vec3 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 203 */       vec31 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 205 */       if (movingobjectposition != null) {
/* 206 */         vec31 = new Vec3(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 209 */       Entity entity = null;
/* 210 */       List list = this.field_70170_p.func_72839_b(this, func_174813_aQ().func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 211 */       double d0 = 0.0D;
/*     */       
/* 213 */       for (int i = 0; i < list.size(); i++) {
/* 214 */         Entity entity1 = (Entity)list.get(i);
/*     */         
/* 216 */         if ((entity1.func_70067_L()) && ((this.ticksInAir >= 25) || (
/*     */         
/* 218 */           (!entity1.func_70028_i(this.shootingEntity)) && (!canIgnoreEntity(entity1)) && (!isRiddenByShooter(entity1)))))
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 224 */           float f = 0.3F;
/* 225 */           AxisAlignedBB axisalignedbb = entity1.func_174813_aQ().func_72314_b(f, f, f);
/* 226 */           MovingObjectPosition movingobjectposition1 = axisalignedbb.func_72327_a(vec3, vec31);
/*     */           
/* 228 */           if (movingobjectposition1 != null) {
/* 229 */             double d1 = vec3.func_72438_d(movingobjectposition1.field_72307_f);
/*     */             
/* 231 */             if ((d1 < d0) || (d0 == 0.0D)) {
/* 232 */               entity = entity1;
/* 233 */               d0 = d1;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 239 */       if (entity != null) {
/* 240 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 243 */       if (movingobjectposition != null) {
/* 244 */         onImpact(movingobjectposition);
/*     */       }
/*     */       
/* 247 */       this.field_70165_t += this.field_70159_w;
/* 248 */       this.field_70163_u += this.field_70181_x;
/* 249 */       this.field_70161_v += this.field_70179_y;
/* 250 */       float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 251 */       this.field_70177_z = ((float)(Math.atan2(this.field_70179_y, this.field_70159_w) * 180.0D / 3.141592653589793D) + 90.0F);
/*     */       
/* 253 */       for (this.field_70125_A = ((float)(Math.atan2(f1, this.field_70181_x) * 180.0D / 3.141592653589793D) - 90.0F); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */       
/*     */ 
/*     */ 
/* 257 */       while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 258 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 261 */       while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 262 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 265 */       while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 266 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 269 */       this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 270 */       this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 271 */       float f2 = getMotionFactor();
/*     */       
/* 273 */       if (func_70090_H()) {
/* 274 */         for (int j = 0; j < 4; j++) {
/* 275 */           float f3 = 0.25F;
/* 276 */           this.field_70170_p.func_175688_a(net.minecraft.util.EnumParticleTypes.WATER_BUBBLE, this.field_70165_t - this.field_70159_w * f3, this.field_70163_u - this.field_70181_x * f3, this.field_70161_v - this.field_70179_y * f3, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[0]);
/*     */         }
/*     */         
/* 279 */         f2 = 0.8F;
/*     */       }
/*     */       
/* 282 */       this.accelerationX *= getAccelerationModifier();
/* 283 */       this.accelerationY *= getAccelerationModifier();
/* 284 */       this.accelerationZ *= getAccelerationModifier();
/*     */       
/* 286 */       this.field_70159_w += this.accelerationX;
/* 287 */       this.field_70181_x += this.accelerationY;
/* 288 */       this.field_70179_y += this.accelerationZ;
/*     */       
/* 290 */       this.field_70159_w *= f2;
/* 291 */       this.field_70181_x *= f2;
/* 292 */       this.field_70179_y *= f2;
/* 293 */       this.field_70181_x -= getGravityVelocity();
/* 294 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected int getMaxTicksInAir()
/*     */   {
/* 301 */     return 200;
/*     */   }
/*     */   
/*     */   protected int getMaxTicksInGround() {
/* 305 */     return 600;
/*     */   }
/*     */   
/*     */   protected float getAccelerationModifier() {
/* 309 */     return 1.0F;
/*     */   }
/*     */   
/*     */   protected boolean isRiddenByShooter(Entity entity1) {
/* 313 */     if (this.shootingEntity == null) {
/* 314 */       return false;
/*     */     }
/* 316 */     if ((entity1.field_70153_n != null) && (entity1.field_70153_n.func_70028_i(this.shootingEntity))) {
/* 317 */       return true;
/*     */     }
/*     */     
/* 320 */     if ((entity1 instanceof EntityWreckingGolem)) {
/* 321 */       EntityWreckingGolem golem = (EntityWreckingGolem)entity1;
/* 322 */       if ((golem.getSeat() != null) && (golem.getSeat().field_70153_n != null) && 
/* 323 */         (golem.getSeat().field_70153_n.func_70028_i(this.shootingEntity))) {
/* 324 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 328 */     return false;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public boolean func_70112_a(double distance) {
/* 333 */     double d1 = func_174813_aQ().func_72320_b() * 4.0D;
/* 334 */     d1 *= 64.0D;
/* 335 */     return distance < d1 * d1;
/*     */   }
/*     */   
/*     */   protected float getMotionFactor() {
/* 339 */     return 0.95F;
/*     */   }
/*     */   
/*     */   protected float getGravityVelocity() {
/* 343 */     return 0.0F;
/*     */   }
/*     */   
/*     */   protected abstract void onImpact(MovingObjectPosition paramMovingObjectPosition);
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound) {
/* 349 */     compound.func_74777_a("xTile", (short)this.xTile);
/* 350 */     compound.func_74777_a("yTile", (short)this.yTile);
/* 351 */     compound.func_74777_a("zTile", (short)this.zTile);
/* 352 */     ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.func_177774_c(this.inTile);
/* 353 */     compound.func_74778_a("inTile", resourcelocation == null ? "" : resourcelocation.toString());
/* 354 */     compound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 355 */     compound.func_74782_a("direction", func_70087_a(new double[] { this.field_70159_w, this.field_70181_x, this.field_70179_y }));
/* 356 */     if ((this.shootingEntity != null) && (this.shootingEntity.func_70089_S())) {
/* 357 */       String uuid = this.shootingEntity.func_110124_au().toString();
/* 358 */       if ((uuid == null) || (uuid.isEmpty())) {
/* 359 */         emoniph.intangible.Get.log().warning("Trying to save a spell entity with an empty shooter id!");
/*     */       }
/* 361 */       compound.func_74778_a("shooter", uuid);
/*     */     }
/* 363 */     compound.func_74757_a("unexpected", this.unexpected);
/* 364 */     compound.func_74757_a("overclocked", this.overclocked);
/*     */     
/* 366 */     NBTTagList list = new NBTTagList();
/* 367 */     for (UUID entry : this.ignoreList) {
/* 368 */       list.func_74742_a(new net.minecraft.nbt.NBTTagString(entry.toString()));
/*     */     }
/*     */     
/* 371 */     compound.func_74782_a("ignoreList", list);
/*     */     
/* 373 */     compound.func_74768_a("bounces", this.bounces);
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound) {
/* 377 */     this.xTile = compound.func_74765_d("xTile");
/* 378 */     this.yTile = compound.func_74765_d("yTile");
/* 379 */     this.zTile = compound.func_74765_d("zTile");
/*     */     
/* 381 */     if (compound.func_150297_b("inTile", 8)) {
/* 382 */       this.inTile = Block.func_149684_b(compound.func_74779_i("inTile"));
/*     */     } else {
/* 384 */       this.inTile = Block.func_149729_e(compound.func_74771_c("inTile") & 0xFF);
/*     */     }
/*     */     
/* 387 */     this.inGround = (compound.func_74771_c("inGround") == 1);
/*     */     
/* 389 */     if (compound.func_150297_b("shooter", 8)) {
/* 390 */       this.shooterId = UUID.fromString(compound.func_74779_i("shooter"));
/*     */     }
/*     */     
/* 393 */     if (compound.func_150297_b("direction", 9)) {
/* 394 */       NBTTagList nbttaglist = compound.func_150295_c("direction", 6);
/* 395 */       this.field_70159_w = nbttaglist.func_150309_d(0);
/* 396 */       this.field_70181_x = nbttaglist.func_150309_d(1);
/* 397 */       this.field_70179_y = nbttaglist.func_150309_d(2);
/*     */     } else {
/* 399 */       func_70106_y();
/*     */     }
/* 401 */     this.unexpected = compound.func_74767_n("unexpected");
/* 402 */     this.overclocked = compound.func_74767_n("overclocked");
/*     */     
/* 404 */     this.ignoreList.clear();
/* 405 */     if (compound.func_150297_b("ignoreList", 9)) {
/* 406 */       NBTTagList list = compound.func_150295_c("ignoreList", 8);
/* 407 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 408 */         String id = list.func_150307_f(i);
/* 409 */         this.ignoreList.add(UUID.fromString(id));
/*     */       }
/*     */     }
/*     */     
/* 413 */     this.bounces = compound.func_74762_e("bounces");
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/* 417 */     return true;
/*     */   }
/*     */   
/*     */   public float func_70111_Y() {
/* 421 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(net.minecraft.util.DamageSource source, float amount) {
/* 425 */     return false;
/*     */   }
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
/*     */   public float func_70013_c(float p_70013_1_)
/*     */   {
/* 455 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/* 460 */     return 15728880;
/*     */   }
/*     */   
/* 463 */   private Set<UUID> ignoreList = new java.util.HashSet();
/*     */   
/*     */   private int bounces;
/*     */   
/*     */   public boolean canIgnoreEntity(Entity input)
/*     */   {
/* 469 */     return (input == null) || (!input.func_70089_S()) || (this.ignoreList.contains(input.func_110124_au())) || (((input instanceof ISoulHost)) && (ignoreIncorporeal()) && (!((ISoulHost)input).isCorporeal()));
/*     */   }
/*     */   
/*     */   protected boolean ignoreIncorporeal() {
/* 473 */     return true;
/*     */   }
/*     */   
/*     */   public void ignoreEntity(EntityLivingBase input) {
/* 477 */     if (input != null) {
/* 478 */       this.ignoreList.add(input.func_110124_au());
/*     */     }
/*     */   }
/*     */   
/*     */   public EntitySpellBase copyBehaviourFrom(EntitySpellBase other) {
/* 483 */     if (other != null) {
/* 484 */       this.ignoreList.addAll(other.ignoreList);
/* 485 */       this.unexpected = other.unexpected;
/* 486 */       this.overclocked = other.overclocked;
/* 487 */       this.bounces = other.bounces;
/*     */     }
/*     */     
/* 490 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public EntitySpellBase increaseBounces()
/*     */   {
/* 496 */     this.bounces += 1;
/* 497 */     return this;
/*     */   }
/*     */   
/*     */   public int getBounces() {
/* 501 */     return this.bounces;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySpellBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */