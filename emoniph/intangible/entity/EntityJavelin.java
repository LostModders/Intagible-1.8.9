/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EntityDamageSourceIndirect;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityJavelin extends Entity implements net.minecraft.entity.IProjectile
/*     */ {
/*  25 */   private int xTile = -1;
/*  26 */   private int yTile = -1;
/*  27 */   private int zTile = -1;
/*     */   
/*     */   private Block inTile;
/*     */   
/*     */   private int inData;
/*     */   
/*     */   private boolean inGround;
/*     */   
/*     */   public int canBePickedUp;
/*     */   
/*     */   public int arrowShake;
/*     */   
/*     */   public Entity shootingEntity;
/*     */   
/*     */   private int ticksInGround;
/*     */   
/*     */   private int ticksInAir;
/*     */   
/*  45 */   private double damage = 2.0D;
/*     */   
/*     */   private int knockbackStrength;
/*     */   
/*     */ 
/*     */   public EntityJavelin(World worldIn)
/*     */   {
/*  52 */     super(worldIn);
/*  53 */     this.field_70155_l = 10.0D;
/*  54 */     func_70105_a(0.5F, 0.5F);
/*     */   }
/*     */   
/*     */   public EntityJavelin(World worldIn, double x, double y, double z) {
/*  58 */     super(worldIn);
/*  59 */     this.field_70155_l = 10.0D;
/*  60 */     func_70105_a(0.5F, 0.5F);
/*  61 */     func_70107_b(x, y, z);
/*     */   }
/*     */   
/*     */   public EntityJavelin(World worldIn, EntityLivingBase shooter, EntityLivingBase p_i1755_3_, float p_i1755_4_, float p_i1755_5_) {
/*  65 */     super(worldIn);
/*  66 */     this.field_70155_l = 10.0D;
/*  67 */     this.shootingEntity = shooter;
/*     */     
/*  69 */     if ((shooter instanceof EntityPlayer)) {
/*  70 */       this.canBePickedUp = 1;
/*  71 */       setShooter(shooter);
/*     */     }
/*     */     
/*  74 */     this.field_70163_u = (shooter.field_70163_u + shooter.func_70047_e() - 0.10000000149011612D);
/*  75 */     double d0 = p_i1755_3_.field_70165_t - shooter.field_70165_t;
/*  76 */     double d1 = p_i1755_3_.func_174813_aQ().field_72338_b + p_i1755_3_.field_70131_O / 3.0F - this.field_70163_u;
/*  77 */     double d2 = p_i1755_3_.field_70161_v - shooter.field_70161_v;
/*  78 */     double d3 = MathHelper.func_76133_a(d0 * d0 + d2 * d2);
/*     */     
/*  80 */     if (d3 >= 1.0E-7D) {
/*  81 */       float f = (float)(MathHelper.func_181159_b(d2, d0) * 180.0D / 3.141592653589793D) - 90.0F;
/*  82 */       float f1 = (float)-(MathHelper.func_181159_b(d1, d3) * 180.0D / 3.141592653589793D);
/*  83 */       double d4 = d0 / d3;
/*  84 */       double d5 = d2 / d3;
/*  85 */       func_70012_b(shooter.field_70165_t + d4, this.field_70163_u, shooter.field_70161_v + d5, f, f1);
/*  86 */       float f2 = (float)(d3 * 0.20000000298023224D);
/*  87 */       func_70186_c(d0, d1 + f2, d2, p_i1755_4_, p_i1755_5_);
/*     */     }
/*     */   }
/*     */   
/*     */   public EntityJavelin(World worldIn, EntityLivingBase shooter, float velocity) {
/*  92 */     super(worldIn);
/*  93 */     this.field_70155_l = 10.0D;
/*  94 */     this.shootingEntity = shooter;
/*     */     
/*  96 */     if ((shooter instanceof EntityPlayer)) {
/*  97 */       this.canBePickedUp = 1;
/*  98 */       setShooter(shooter);
/*     */     }
/*     */     
/* 101 */     func_70105_a(0.5F, 0.5F);
/* 102 */     func_70012_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
/* 103 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 104 */     this.field_70163_u -= 0.10000000149011612D;
/* 105 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/* 106 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 107 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 108 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F));
/* 109 */     this.field_70181_x = (-MathHelper.func_76126_a(this.field_70125_A / 180.0F * 3.1415927F));
/* 110 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, velocity * 1.5F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/* 114 */     this.field_70180_af.func_75682_a(16, Byte.valueOf((byte)0));
/* 115 */     this.field_70180_af.func_75682_a(17, "");
/*     */   }
/*     */   
/*     */   public void setShooter(EntityLivingBase entity) {
/* 119 */     if ((!this.field_70170_p.field_72995_K) && ((entity instanceof EntityPlayer))) {
/* 120 */       this.field_70180_af.func_75692_b(17, entity.func_70005_c_());
/*     */     }
/*     */   }
/*     */   
/*     */   public String getShooter() {
/* 125 */     String username = this.field_70180_af.func_75681_e(17);
/* 126 */     if (username == null) {
/* 127 */       return "";
/*     */     }
/* 129 */     return username;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70186_c(double x, double y, double z, float velocity, float inaccuracy)
/*     */   {
/* 136 */     float f = MathHelper.func_76133_a(x * x + y * y + z * z);
/* 137 */     x /= f;
/* 138 */     y /= f;
/* 139 */     z /= f;
/* 140 */     x += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : 1) * 0.007499999832361937D * inaccuracy;
/* 141 */     y += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : 1) * 0.007499999832361937D * inaccuracy;
/* 142 */     z += this.field_70146_Z.nextGaussian() * (this.field_70146_Z.nextBoolean() ? -1 : 1) * 0.007499999832361937D * inaccuracy;
/* 143 */     x *= velocity;
/* 144 */     y *= velocity;
/* 145 */     z *= velocity;
/* 146 */     this.field_70159_w = x;
/* 147 */     this.field_70181_x = y;
/* 148 */     this.field_70179_y = z;
/* 149 */     float f1 = MathHelper.func_76133_a(x * x + z * z);
/* 150 */     this.field_70126_B = (this.field_70177_z = (float)(MathHelper.func_181159_b(x, z) * 180.0D / 3.141592653589793D));
/* 151 */     this.field_70127_C = (this.field_70125_A = (float)(MathHelper.func_181159_b(y, f1) * 180.0D / 3.141592653589793D));
/* 152 */     this.ticksInGround = 0;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void func_180426_a(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
/* 157 */     func_70107_b(x, y, z);
/* 158 */     func_70101_b(yaw, pitch);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void func_70016_h(double x, double y, double z)
/*     */   {
/* 166 */     this.field_70159_w = x;
/* 167 */     this.field_70181_x = y;
/* 168 */     this.field_70179_y = z;
/*     */     
/* 170 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 171 */       float f = MathHelper.func_76133_a(x * x + z * z);
/* 172 */       this.field_70126_B = (this.field_70177_z = (float)(MathHelper.func_181159_b(x, z) * 180.0D / 3.141592653589793D));
/* 173 */       this.field_70127_C = (this.field_70125_A = (float)(MathHelper.func_181159_b(y, f) * 180.0D / 3.141592653589793D));
/* 174 */       this.field_70127_C = this.field_70125_A;
/* 175 */       this.field_70126_B = this.field_70177_z;
/* 176 */       func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/* 177 */       this.ticksInGround = 0;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 185 */     super.func_70071_h_();
/*     */     
/* 187 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 188 */       float f = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 189 */       this.field_70126_B = (this.field_70177_z = (float)(MathHelper.func_181159_b(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/* 190 */       this.field_70127_C = (this.field_70125_A = (float)(MathHelper.func_181159_b(this.field_70181_x, f) * 180.0D / 3.141592653589793D));
/*     */     }
/*     */     
/* 193 */     BlockPos blockpos = new BlockPos(this.xTile, this.yTile, this.zTile);
/* 194 */     IBlockState iblockstate = this.field_70170_p.func_180495_p(blockpos);
/* 195 */     Block block = iblockstate.func_177230_c();
/*     */     
/* 197 */     if (block.func_149688_o() != net.minecraft.block.material.Material.field_151579_a) {
/* 198 */       block.func_180654_a(this.field_70170_p, blockpos);
/* 199 */       AxisAlignedBB axisalignedbb = block.func_180640_a(this.field_70170_p, blockpos, iblockstate);
/*     */       
/* 201 */       if ((axisalignedbb != null) && (axisalignedbb.func_72318_a(new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v)))) {
/* 202 */         this.inGround = true;
/*     */       }
/*     */     }
/*     */     
/* 206 */     if (this.arrowShake > 0) {
/* 207 */       this.arrowShake -= 1;
/*     */     }
/*     */     
/* 210 */     if (this.inGround) {
/* 211 */       int j = block.func_176201_c(iblockstate);
/*     */       
/* 213 */       if ((block == this.inTile) && (j == this.inData)) {
/* 214 */         this.ticksInGround += 1;
/*     */         
/* 216 */         if (this.ticksInGround >= 1200) {
/* 217 */           func_70106_y();
/*     */         }
/*     */       } else {
/* 220 */         this.inGround = false;
/* 221 */         this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 222 */         this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 223 */         this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 224 */         this.ticksInGround = 0;
/* 225 */         this.ticksInAir = 0;
/*     */       }
/*     */     } else {
/* 228 */       this.ticksInAir += 1;
/* 229 */       Vec3 vec31 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 230 */       Vec3 vec3 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 231 */       MovingObjectPosition movingobjectposition = this.field_70170_p.func_147447_a(vec31, vec3, false, true, false);
/* 232 */       vec31 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 233 */       vec3 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*     */       
/* 235 */       if (movingobjectposition != null) {
/* 236 */         vec3 = new Vec3(movingobjectposition.field_72307_f.field_72450_a, movingobjectposition.field_72307_f.field_72448_b, movingobjectposition.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 239 */       Entity entity = null;
/* 240 */       List<Entity> list = this.field_70170_p.func_72839_b(this, func_174813_aQ().func_72321_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72314_b(1.0D, 1.0D, 1.0D));
/* 241 */       double d0 = 0.0D;
/*     */       
/* 243 */       for (int i = 0; i < list.size(); i++) {
/* 244 */         Entity entity1 = (Entity)list.get(i);
/*     */         
/*     */ 
/* 247 */         if ((entity1.func_70067_L()) && ((this.ticksInAir >= 5) || ((entity1 != this.shootingEntity) && ((!(entity1 instanceof EntityPlayer)) || (!entity1.func_70005_c_().equals(getShooter())))))) {
/* 248 */           float f1 = 0.3F;
/* 249 */           AxisAlignedBB axisalignedbb1 = entity1.func_174813_aQ().func_72314_b(f1, f1, f1);
/* 250 */           MovingObjectPosition movingobjectposition1 = axisalignedbb1.func_72327_a(vec31, vec3);
/*     */           
/* 252 */           if (movingobjectposition1 != null) {
/* 253 */             double d1 = vec31.func_72436_e(movingobjectposition1.field_72307_f);
/*     */             
/* 255 */             if ((d1 < d0) || (d0 == 0.0D)) {
/* 256 */               entity = entity1;
/* 257 */               d0 = d1;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 263 */       if (entity != null) {
/* 264 */         movingobjectposition = new MovingObjectPosition(entity);
/*     */       }
/*     */       
/* 267 */       if ((movingobjectposition != null) && (movingobjectposition.field_72308_g != null) && ((movingobjectposition.field_72308_g instanceof EntityPlayer))) {
/* 268 */         EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.field_72308_g;
/*     */         
/* 270 */         if ((entityplayer.field_71075_bZ.field_75102_a) || (((this.shootingEntity instanceof EntityPlayer)) && (!((EntityPlayer)this.shootingEntity).func_96122_a(entityplayer)))) {
/* 271 */           movingobjectposition = null;
/*     */         }
/*     */       }
/*     */       
/* 275 */       if (movingobjectposition != null) {
/* 276 */         if (movingobjectposition.field_72308_g != null) {
/* 277 */           float f2 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 278 */           int l = MathHelper.func_76143_f(f2 * this.damage);
/*     */           
/* 280 */           if (getIsCritical()) {
/* 281 */             l += this.field_70146_Z.nextInt(l / 2 + 2);
/*     */           }
/*     */           
/*     */           net.minecraft.util.DamageSource damagesource;
/*     */           net.minecraft.util.DamageSource damagesource;
/* 286 */           if (this.shootingEntity == null) {
/* 287 */             damagesource = new EntityDamageSourceIndirect("arrow", this, this).func_76349_b();
/*     */           } else {
/* 289 */             damagesource = new EntityDamageSourceIndirect("arrow", this, this.shootingEntity).func_76349_b();
/*     */           }
/*     */           
/* 292 */           if ((func_70027_ad()) && (!(movingobjectposition.field_72308_g instanceof net.minecraft.entity.monster.EntityEnderman))) {
/* 293 */             movingobjectposition.field_72308_g.func_70015_d(5);
/*     */           }
/*     */           
/* 296 */           if (movingobjectposition.field_72308_g.func_70097_a(damagesource, l)) {
/* 297 */             if ((movingobjectposition.field_72308_g instanceof EntityLivingBase)) {
/* 298 */               EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.field_72308_g;
/*     */               
/* 300 */               if ((this.field_70170_p.field_72995_K) || 
/*     */               
/*     */ 
/*     */ 
/* 304 */                 (this.knockbackStrength > 0)) {
/* 305 */                 float f7 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */                 
/* 307 */                 if (f7 > 0.0F) {
/* 308 */                   movingobjectposition.field_72308_g.func_70024_g(this.field_70159_w * this.knockbackStrength * 0.6000000238418579D / f7, 0.1D, this.field_70179_y * this.knockbackStrength * 0.6000000238418579D / f7);
/*     */                 }
/*     */               }
/*     */               
/* 312 */               if ((this.shootingEntity instanceof EntityLivingBase)) {
/* 313 */                 net.minecraft.enchantment.EnchantmentHelper.func_151384_a(entitylivingbase, this.shootingEntity);
/* 314 */                 net.minecraft.enchantment.EnchantmentHelper.func_151385_b((EntityLivingBase)this.shootingEntity, entitylivingbase);
/*     */               }
/*     */               
/* 317 */               if ((this.shootingEntity != null) && (movingobjectposition.field_72308_g != this.shootingEntity) && ((movingobjectposition.field_72308_g instanceof EntityPlayer)) && ((this.shootingEntity instanceof EntityPlayerMP))) {
/* 318 */                 ((EntityPlayerMP)this.shootingEntity).field_71135_a.func_147359_a(new net.minecraft.network.play.server.S2BPacketChangeGameState(6, 0.0F));
/*     */               }
/*     */               
/* 321 */               if ((!this.field_70170_p.field_72995_K) && (entitylivingbase.func_110143_aJ() == 0.0F) && (this.shootingEntity != null) && ((this.shootingEntity instanceof EntityPlayer))) {
/* 322 */                 EntityPlayer shooter = (EntityPlayer)this.shootingEntity;
/* 323 */                 shooter.field_71071_by.func_70441_a(new net.minecraft.item.ItemStack(emoniph.intangible.Get.items().JAVELIN));
/*     */               }
/*     */             }
/*     */             
/* 327 */             func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/*     */             
/* 329 */             if (!(movingobjectposition.field_72308_g instanceof net.minecraft.entity.monster.EntityEnderman)) {
/* 330 */               func_70106_y();
/*     */             }
/*     */           }
/*     */           else {
/* 334 */             this.field_70159_w *= -0.10000000149011612D;
/* 335 */             this.field_70181_x *= -0.10000000149011612D;
/* 336 */             this.field_70179_y *= -0.10000000149011612D;
/* 337 */             this.field_70177_z += 180.0F;
/* 338 */             this.field_70126_B += 180.0F;
/* 339 */             this.ticksInAir = 0;
/*     */           }
/*     */         } else {
/* 342 */           BlockPos blockpos1 = movingobjectposition.func_178782_a();
/* 343 */           this.xTile = blockpos1.func_177958_n();
/* 344 */           this.yTile = blockpos1.func_177956_o();
/* 345 */           this.zTile = blockpos1.func_177952_p();
/* 346 */           IBlockState iblockstate1 = this.field_70170_p.func_180495_p(blockpos1);
/* 347 */           this.inTile = iblockstate1.func_177230_c();
/* 348 */           this.inData = this.inTile.func_176201_c(iblockstate1);
/* 349 */           this.field_70159_w = ((float)(movingobjectposition.field_72307_f.field_72450_a - this.field_70165_t));
/* 350 */           this.field_70181_x = ((float)(movingobjectposition.field_72307_f.field_72448_b - this.field_70163_u));
/* 351 */           this.field_70179_y = ((float)(movingobjectposition.field_72307_f.field_72449_c - this.field_70161_v));
/* 352 */           float f5 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/* 353 */           this.field_70165_t -= this.field_70159_w / f5 * 0.05000000074505806D;
/* 354 */           this.field_70163_u -= this.field_70181_x / f5 * 0.05000000074505806D;
/* 355 */           this.field_70161_v -= this.field_70179_y / f5 * 0.05000000074505806D;
/* 356 */           func_85030_a("random.bowhit", 1.0F, 1.2F / (this.field_70146_Z.nextFloat() * 0.2F + 0.9F));
/* 357 */           this.inGround = true;
/* 358 */           this.arrowShake = 7;
/* 359 */           setIsCritical(false);
/*     */           
/* 361 */           if (this.inTile.func_149688_o() != net.minecraft.block.material.Material.field_151579_a) {
/* 362 */             this.inTile.func_180634_a(this.field_70170_p, blockpos1, iblockstate1, this);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 367 */       if (getIsCritical()) {
/* 368 */         for (int k = 0; k < 4; k++) {
/* 369 */           this.field_70170_p.func_175688_a(net.minecraft.util.EnumParticleTypes.CRIT, this.field_70165_t + this.field_70159_w * k / 4.0D, this.field_70163_u + this.field_70181_x * k / 4.0D, this.field_70161_v + this.field_70179_y * k / 4.0D, -this.field_70159_w, -this.field_70181_x + 0.2D, -this.field_70179_y, new int[0]);
/*     */         }
/*     */       }
/*     */       
/* 373 */       this.field_70165_t += this.field_70159_w;
/* 374 */       this.field_70163_u += this.field_70181_x;
/* 375 */       this.field_70161_v += this.field_70179_y;
/* 376 */       float f3 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 377 */       this.field_70177_z = ((float)(MathHelper.func_181159_b(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */       
/* 379 */       for (this.field_70125_A = ((float)(MathHelper.func_181159_b(this.field_70181_x, f3) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */       
/*     */ 
/*     */ 
/* 383 */       while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 384 */         this.field_70127_C += 360.0F;
/*     */       }
/*     */       
/* 387 */       while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 388 */         this.field_70126_B -= 360.0F;
/*     */       }
/*     */       
/* 391 */       while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 392 */         this.field_70126_B += 360.0F;
/*     */       }
/*     */       
/* 395 */       this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 396 */       this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 397 */       float f4 = 0.99F;
/* 398 */       float f6 = 0.05F;
/*     */       
/* 400 */       if (func_70090_H()) {
/* 401 */         for (int i1 = 0; i1 < 4; i1++) {
/* 402 */           float f8 = 0.25F;
/* 403 */           this.field_70170_p.func_175688_a(net.minecraft.util.EnumParticleTypes.WATER_BUBBLE, this.field_70165_t - this.field_70159_w * f8, this.field_70163_u - this.field_70181_x * f8, this.field_70161_v - this.field_70179_y * f8, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[0]);
/*     */         }
/*     */         
/* 406 */         f4 = 0.6F;
/*     */       }
/*     */       
/* 409 */       if (func_70026_G()) {
/* 410 */         func_70066_B();
/*     */       }
/*     */       
/* 413 */       this.field_70159_w *= f4;
/* 414 */       this.field_70181_x *= f4;
/* 415 */       this.field_70179_y *= f4;
/* 416 */       this.field_70181_x -= f6;
/* 417 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 418 */       func_145775_I();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound tagCompound)
/*     */   {
/* 426 */     tagCompound.func_74777_a("xTile", (short)this.xTile);
/* 427 */     tagCompound.func_74777_a("yTile", (short)this.yTile);
/* 428 */     tagCompound.func_74777_a("zTile", (short)this.zTile);
/* 429 */     tagCompound.func_74777_a("life", (short)this.ticksInGround);
/* 430 */     ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.func_177774_c(this.inTile);
/* 431 */     tagCompound.func_74778_a("inTile", resourcelocation == null ? "" : resourcelocation.toString());
/* 432 */     tagCompound.func_74774_a("inData", (byte)this.inData);
/* 433 */     tagCompound.func_74774_a("shake", (byte)this.arrowShake);
/* 434 */     tagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/* 435 */     tagCompound.func_74774_a("pickup", (byte)this.canBePickedUp);
/* 436 */     tagCompound.func_74780_a("damage", this.damage);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound tagCompund)
/*     */   {
/* 443 */     this.xTile = tagCompund.func_74765_d("xTile");
/* 444 */     this.yTile = tagCompund.func_74765_d("yTile");
/* 445 */     this.zTile = tagCompund.func_74765_d("zTile");
/* 446 */     this.ticksInGround = tagCompund.func_74765_d("life");
/*     */     
/* 448 */     if (tagCompund.func_150297_b("inTile", 8)) {
/* 449 */       this.inTile = Block.func_149684_b(tagCompund.func_74779_i("inTile"));
/*     */     } else {
/* 451 */       this.inTile = Block.func_149729_e(tagCompund.func_74771_c("inTile") & 0xFF);
/*     */     }
/*     */     
/* 454 */     this.inData = (tagCompund.func_74771_c("inData") & 0xFF);
/* 455 */     this.arrowShake = (tagCompund.func_74771_c("shake") & 0xFF);
/* 456 */     this.inGround = (tagCompund.func_74771_c("inGround") == 1);
/*     */     
/* 458 */     if (tagCompund.func_150297_b("damage", 99)) {
/* 459 */       this.damage = tagCompund.func_74769_h("damage");
/*     */     }
/*     */     
/* 462 */     if (tagCompund.func_150297_b("pickup", 99)) {
/* 463 */       this.canBePickedUp = tagCompund.func_74771_c("pickup");
/* 464 */     } else if (tagCompund.func_150297_b("player", 99)) {
/* 465 */       this.canBePickedUp = (tagCompund.func_74767_n("player") ? 1 : 0);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70100_b_(EntityPlayer entityIn)
/*     */   {
/* 473 */     if ((!this.field_70170_p.field_72995_K) && (this.inGround) && (this.arrowShake <= 0)) {
/* 474 */       boolean flag = (this.canBePickedUp == 1) || ((this.canBePickedUp == 2) && (entityIn.field_71075_bZ.field_75098_d));
/*     */       
/* 476 */       if ((this.canBePickedUp == 1) && (!entityIn.field_71071_by.func_70441_a(new net.minecraft.item.ItemStack(emoniph.intangible.Get.items().JAVELIN, 1)))) {
/* 477 */         flag = false;
/*     */       }
/*     */       
/* 480 */       if (flag) {
/* 481 */         func_85030_a("random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/* 482 */         entityIn.func_71001_a(this, 1);
/* 483 */         func_70106_y();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected boolean func_70041_e_()
/*     */   {
/* 493 */     return false;
/*     */   }
/*     */   
/*     */   public void setDamage(double damageIn) {
/* 497 */     this.damage = damageIn;
/*     */   }
/*     */   
/*     */   public double getDamage() {
/* 501 */     return this.damage;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setKnockbackStrength(int knockbackStrengthIn)
/*     */   {
/* 508 */     this.knockbackStrength = knockbackStrengthIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_70075_an()
/*     */   {
/* 515 */     return false;
/*     */   }
/*     */   
/*     */   public float func_70047_e() {
/* 519 */     return 0.0F;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsCritical(boolean critical)
/*     */   {
/* 526 */     byte b0 = this.field_70180_af.func_75683_a(16);
/*     */     
/* 528 */     if (critical) {
/* 529 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 | 0x1)));
/*     */     } else {
/* 531 */       this.field_70180_af.func_75692_b(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsCritical()
/*     */   {
/* 539 */     byte b0 = this.field_70180_af.func_75683_a(16);
/* 540 */     return (b0 & 0x1) != 0;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityJavelin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */