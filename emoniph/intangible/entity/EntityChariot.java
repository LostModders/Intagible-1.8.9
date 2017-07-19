/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.Block.SoundType;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityHorse;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.EnumDyeColor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntityChariot extends Entity
/*     */ {
/*     */   private double speedMultiplier;
/*     */   private int chariotPosRotationIncrements;
/*     */   private double chariotX;
/*     */   private double chariotY;
/*     */   private double chariotZ;
/*     */   private double chariotYaw;
/*     */   private double chariotPitch;
/*     */   private double velocityX;
/*     */   private double velocityY;
/*     */   private double velocityZ;
/*     */   private int gallopTime;
/*     */   
/*     */   public EntityChariot(World worldIn)
/*     */   {
/*  45 */     super(worldIn);
/*     */     
/*  47 */     this.speedMultiplier = 0.07D;
/*  48 */     this.field_70156_m = true;
/*  49 */     this.field_70138_W = 1.0F;
/*  50 */     func_70105_a(2.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public EntityChariot(World worldIn, double posX, double posY, double posZ) {
/*  54 */     this(worldIn);
/*  55 */     func_70107_b(posX, posY, posZ);
/*  56 */     this.field_70159_w = 0.0D;
/*  57 */     this.field_70181_x = 0.0D;
/*  58 */     this.field_70179_y = 0.0D;
/*  59 */     this.field_70169_q = posX;
/*  60 */     this.field_70167_r = posY;
/*  61 */     this.field_70166_s = posZ;
/*     */   }
/*     */   
/*     */   protected boolean func_70041_e_()
/*     */   {
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/*  71 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  72 */     this.field_70180_af.func_75682_a(18, new Integer(EnumDyeColor.RED.func_176767_b()));
/*  73 */     this.field_70180_af.func_75682_a(19, new Integer(3));
/*     */   }
/*     */   
/*     */   private int getVariant() {
/*  77 */     return this.field_70180_af.func_75679_c(19);
/*     */   }
/*     */   
/*     */   private void setVariant(int variant) {
/*  81 */     this.field_70180_af.func_75692_b(19, Integer.valueOf(variant));
/*     */   }
/*     */   
/*     */   public EnumDyeColor getColor() {
/*  85 */     return EnumDyeColor.func_176766_a(this.field_70180_af.func_75679_c(18));
/*     */   }
/*     */   
/*     */   private void setColor(EnumDyeColor color) {
/*  89 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(color.func_176767_b()));
/*     */   }
/*     */   
/*     */   public void setHits(int ticksSinceHit) {
/*  93 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(ticksSinceHit));
/*     */   }
/*     */   
/*     */   public int getHits() {
/*  97 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity entityIn)
/*     */   {
/* 102 */     return entityIn.func_174813_aQ();
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E()
/*     */   {
/* 107 */     return func_174813_aQ();
/*     */   }
/*     */   
/*     */   public boolean func_70104_M()
/*     */   {
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public double func_70042_X()
/*     */   {
/* 117 */     return 0.8D;
/*     */   }
/*     */   
/*     */   public boolean func_70115_ae()
/*     */   {
/* 122 */     return this.field_70154_o != null;
/*     */   }
/*     */   
/*     */   public boolean shouldRiderSit()
/*     */   {
/* 127 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource source, float amount)
/*     */   {
/* 132 */     if (func_180431_b(source))
/* 133 */       return false;
/* 134 */     if ((!this.field_70170_p.field_72995_K) && (!this.field_70128_L)) {
/* 135 */       return false;
/*     */     }
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
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_70067_L()
/*     */   {
/* 165 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   public void func_70043_V() {
/* 169 */     if (this.field_70153_n != null) {
/* 170 */       double shift = 1.7999999523162842D;
/* 171 */       double d0 = Math.cos(this.field_70177_z * 3.141592653589793D / 180.0D) * shift;
/* 172 */       double d1 = Math.sin(this.field_70177_z * 3.141592653589793D / 180.0D) * shift;
/* 173 */       this.field_70153_n.func_70107_b(this.field_70165_t + d0, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + d1);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound compound) {
/* 178 */     compound.func_74768_a("hits", getHits());
/* 179 */     compound.func_74768_a("color", getColor().func_176767_b());
/* 180 */     compound.func_74768_a("variant", getVariant());
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound compound) {
/* 184 */     if (compound.func_74764_b("hits")) {
/* 185 */       setHits(compound.func_74762_e("hits"));
/*     */     }
/*     */     
/* 188 */     if (compound.func_150297_b("color", 3)) {
/* 189 */       setColor(EnumDyeColor.func_176766_a(compound.func_74762_e("color")));
/*     */     } else {
/* 191 */       setColor(EnumDyeColor.RED);
/*     */     }
/*     */     
/* 194 */     if (compound.func_150297_b("variant", 3)) {
/* 195 */       setVariant(compound.func_74762_e("variant"));
/*     */     } else {
/* 197 */       setVariant(3);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer playerIn) {
/* 202 */     if ((this.field_70153_n != null) && ((this.field_70153_n instanceof EntityPlayer)) && (this.field_70153_n != playerIn)) {
/* 203 */       return true;
/*     */     }
/* 205 */     ItemStack stack = playerIn.func_70694_bm();
/* 206 */     if (stack != null) {
/* 207 */       if ((stack.func_77973_b() instanceof net.minecraft.item.ItemDye)) {
/* 208 */         if (!this.field_70170_p.field_72995_K) {
/* 209 */           setColor(EnumDyeColor.func_176766_a(stack.func_77952_i()));
/* 210 */           if (!playerIn.field_71075_bZ.field_75098_d) if (--stack.field_77994_a == 0) {
/* 211 */               playerIn.func_70062_b(0, null);
/*     */             }
/*     */         }
/* 214 */         return true; }
/* 215 */       if (stack.func_77973_b() == Items.field_151166_bC) {
/* 216 */         setVariantByHand(playerIn, 5);
/* 217 */         return true; }
/* 218 */       if (stack.func_77973_b() == Items.field_151103_aS) {
/* 219 */         setVariantByHand(playerIn, 4);
/* 220 */         return true; }
/* 221 */       if (stack.func_77973_b() == Items.field_151078_bh) {
/* 222 */         setVariantByHand(playerIn, 3);
/* 223 */         return true; }
/* 224 */       if (stack.func_77973_b() == Items.field_151034_e) {
/* 225 */         setVariantByHand(playerIn, 0);
/* 226 */         return true; }
/* 227 */       if (stack.func_77973_b() == Items.field_151172_bF) {
/* 228 */         setVariantByHand(playerIn, 1);
/* 229 */         return true; }
/* 230 */       if (stack.func_77973_b() == Items.field_151174_bG) {
/* 231 */         setVariantByHand(playerIn, 2);
/* 232 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 236 */     if (!this.field_70170_p.field_72995_K) {
/* 237 */       playerIn.func_70078_a(this);
/*     */     }
/*     */     
/* 240 */     return true;
/*     */   }
/*     */   
/*     */   private void setVariantByHand(EntityPlayer playerIn, int variant)
/*     */   {
/* 245 */     if (!this.field_70170_p.field_72995_K) {
/* 246 */       setVariant(variant);
/* 247 */       if (!playerIn.field_71075_bZ.field_75098_d) if (--playerIn.func_70694_bm().field_77994_a == 0) {
/* 248 */           playerIn.func_70062_b(0, null);
/*     */         }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_180426_a(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean p_180426_10_) {
/* 255 */     if ((p_180426_10_) && (this.field_70153_n != null)) {
/* 256 */       this.field_70169_q = (this.field_70165_t = x);
/* 257 */       this.field_70167_r = (this.field_70163_u = y);
/* 258 */       this.field_70166_s = (this.field_70161_v = z);
/*     */       
/* 260 */       this.field_70126_B = (this.field_70177_z = yaw);
/* 261 */       this.field_70127_C = (this.field_70125_A = pitch);
/*     */       
/*     */ 
/* 264 */       this.chariotPosRotationIncrements = 0;
/* 265 */       func_70107_b(x, y, z);
/*     */       
/* 267 */       this.field_70159_w = this.velocityX;
/* 268 */       this.field_70181_x = this.velocityY;
/* 269 */       this.field_70179_y = this.velocityZ;
/*     */     }
/*     */     else
/*     */     {
/* 273 */       if (this.field_70153_n == null) {
/* 274 */         this.chariotPosRotationIncrements = (posRotationIncrements + 5);
/*     */       } else {
/* 276 */         double d0 = x - this.field_70165_t;
/* 277 */         double d1 = y - this.field_70163_u;
/* 278 */         double d2 = z - this.field_70161_v;
/* 279 */         double d3 = d0 * d0 + d1 * d1 + d2 * d2;
/*     */         
/* 281 */         if (d3 <= 1.0D) {
/* 282 */           return;
/*     */         }
/*     */         
/* 285 */         this.chariotPosRotationIncrements = 3;
/*     */       }
/*     */       
/* 288 */       this.chariotX = x;
/* 289 */       this.chariotY = y;
/* 290 */       this.chariotZ = z;
/* 291 */       this.chariotYaw = yaw;
/* 292 */       this.chariotPitch = pitch;
/* 293 */       this.field_70159_w = this.velocityX;
/* 294 */       this.field_70181_x = this.velocityY;
/* 295 */       this.field_70179_y = this.velocityZ;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70108_f(Entity entityIn)
/*     */   {
/* 301 */     this.field_70144_Y = 1.0F;
/* 302 */     super.func_70108_f(entityIn);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double x, double y, double z)
/*     */   {
/* 308 */     this.velocityX = (this.field_70159_w = x);
/* 309 */     this.velocityY = (this.field_70181_x = y);
/* 310 */     this.velocityZ = (this.field_70179_y = z);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void func_180429_a(BlockPos pos, Block blockIn) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void playMoveSound(Block blockIn)
/*     */   {
/* 323 */     Block.SoundType block$soundtype = blockIn.field_149762_H;
/* 324 */     this.gallopTime += 1;
/*     */     
/* 326 */     if ((this.gallopTime > 5) && (this.gallopTime % 3 == 0)) {
/* 327 */       if (getVariant() != 5) {
/* 328 */         func_85030_a("mob.horse.gallop", block$soundtype.func_150497_c() * 0.15F, block$soundtype.func_150494_d());
/*     */       }
/*     */       
/* 331 */       if (this.field_70146_Z.nextInt(10) == 0) {
/* 332 */         if (getVariant() == 5) {
/* 333 */           func_85030_a("mob.villager.idle", block$soundtype.func_150497_c() * 0.6F, block$soundtype.func_150494_d());
/*     */         } else {
/* 335 */           func_85030_a("mob.horse.breathe", block$soundtype.func_150497_c() * 0.6F, block$soundtype.func_150494_d());
/*     */         }
/*     */       }
/* 338 */     } else if (this.gallopTime <= 5) {
/* 339 */       func_85030_a("mob.horse.wood", block$soundtype.func_150497_c() * 0.15F, block$soundtype.func_150494_d());
/*     */     }
/* 341 */     func_85030_a("intangible:random.trundle", block$soundtype.func_150497_c() * 0.15F, block$soundtype.func_150494_d());
/*     */   }
/*     */   
/* 344 */   public float rotX = 0.0F;
/*     */   public float limbSwingAmount;
/*     */   public float prevLimbSwingAmount;
/*     */   public float limbSwing;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private EntityLiving proxyHorse;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private int lastVariant;
/*     */   public static final int MAX_HITS = 40;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EntityLiving getProxyLeadEntity()
/*     */   {
/* 357 */     if ((this.proxyHorse == null) || (this.proxyHorse.field_70170_p != this.field_70170_p) || (this.lastVariant != getVariant())) {
/* 358 */       this.lastVariant = getVariant();
/* 359 */       switch (getVariant()) {
/*     */       case 0: 
/*     */       case 1: 
/*     */       case 2: 
/*     */       case 3: 
/*     */       case 4: 
/* 365 */         EntityHorse horse = new EntityHorse(this.field_70170_p);
/* 366 */         horse.func_110214_p(getVariant());
/* 367 */         this.proxyHorse = horse;
/* 368 */         break;
/*     */       case 5: 
/* 370 */         this.proxyHorse = new net.minecraft.entity.passive.EntityVillager(this.field_70170_p);
/* 371 */         break;
/*     */       default: 
/* 373 */         EntityHorse defaultHorse = new EntityHorse(this.field_70170_p);
/* 374 */         defaultHorse.func_110214_p(3);
/* 375 */         this.proxyHorse = defaultHorse;
/*     */       }
/*     */       
/*     */     }
/*     */     
/* 380 */     return this.proxyHorse;
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
/*     */   protected void func_180433_a(double y, boolean onGroundIn, Block blockIn, BlockPos pos) {}
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
/*     */   public void func_70071_h_()
/*     */   {
/* 405 */     super.func_70071_h_();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 413 */     this.field_70169_q = this.field_70165_t;
/* 414 */     this.field_70167_r = this.field_70163_u;
/* 415 */     this.field_70166_s = this.field_70161_v;
/*     */     
/* 417 */     double d9 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */     IBlockState iblockstate;
/* 419 */     double d24; if (d9 > 0.2975D) {
/* 420 */       double d2 = Math.cos(this.field_70177_z * 3.141592653589793D / 180.0D);
/* 421 */       double d4 = Math.sin(this.field_70177_z * 3.141592653589793D / 180.0D);
/*     */       
/* 423 */       for (int k = 0; k < 1.0D + d9 * 60.0D; k++) {
/* 424 */         double d5 = this.field_70146_Z.nextFloat() * 2.0F - 1.0F;
/* 425 */         double d6 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
/*     */         
/* 427 */         iblockstate = this.field_70170_p.func_180495_p(new BlockPos(this).func_177977_b());
/* 428 */         if (this.field_70146_Z.nextBoolean()) {
/* 429 */           double d7 = this.field_70165_t - d2 * d5 * 0.8D + d4 * d6;
/* 430 */           double d8 = this.field_70161_v - d4 * d5 * 0.8D - d2 * d6;
/* 431 */           this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_DUST, d7, this.field_70163_u - 0.125D, d8, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[] { Block.func_176210_f(iblockstate) });
/*     */         } else {
/* 433 */           d24 = this.field_70165_t + d2 + d4 * d5 * 0.7D;
/* 434 */           double d25 = this.field_70161_v + d4 - d2 * d5 * 0.7D;
/* 435 */           this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_DUST, d24, this.field_70163_u - 0.125D, d25, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[] { Block.func_176210_f(iblockstate) });
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 440 */     if ((d9 < 0.1D) && (this.field_70153_n == null)) {
/* 441 */       this.velocityX = (this.field_70159_w = 0.0D);
/* 442 */       this.velocityY = (this.field_70181_x = 0.0D);
/* 443 */       this.velocityZ = (this.field_70179_y = 0.0D);
/* 444 */       this.gallopTime = 0;
/*     */     }
/*     */     
/*     */ 
/* 448 */     if ((this.field_70170_p.field_72995_K) && (this.field_70153_n == null)) {
/* 449 */       if (this.chariotPosRotationIncrements > 0) {
/* 450 */         double d12 = this.field_70165_t + (this.chariotX - this.field_70165_t) / this.chariotPosRotationIncrements;
/* 451 */         double d16 = this.field_70163_u + (this.chariotY - this.field_70163_u) / this.chariotPosRotationIncrements;
/* 452 */         double d19 = this.field_70161_v + (this.chariotZ - this.field_70161_v) / this.chariotPosRotationIncrements;
/* 453 */         double d22 = MathHelper.func_76138_g(this.chariotYaw - this.field_70177_z);
/* 454 */         this.field_70177_z = ((float)(this.field_70177_z + d22 / this.chariotPosRotationIncrements));
/* 455 */         this.field_70125_A = ((float)(this.field_70125_A + (this.chariotPitch - this.field_70125_A) / this.chariotPosRotationIncrements));
/* 456 */         this.chariotPosRotationIncrements -= 1;
/* 457 */         func_70107_b(d12, d16, d19);
/* 458 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       } else {
/* 460 */         double d13 = this.field_70165_t + this.field_70159_w;
/* 461 */         double d17 = this.field_70163_u + this.field_70181_x;
/* 462 */         double d20 = this.field_70161_v + this.field_70179_y;
/* 463 */         func_70107_b(d13, d17, d20);
/*     */         
/* 465 */         this.field_70159_w *= 0.9500000095367432D;
/* 466 */         this.field_70181_x *= 0.949999988079071D;
/* 467 */         this.field_70179_y *= 0.9500000095367432D;
/*     */       }
/*     */       
/* 470 */       setClientAnimations();
/*     */     } else {
/* 472 */       this.field_70181_x += -0.03999999910593033D;
/*     */       
/* 474 */       if ((this.field_70153_n instanceof EntityLivingBase)) {
/* 475 */         EntityLivingBase entitylivingbase = (EntityLivingBase)this.field_70153_n;
/* 476 */         float f = this.field_70153_n.field_70177_z + -entitylivingbase.field_70702_br * 90.0F;
/* 477 */         this.field_70159_w += -Math.sin(f * 3.1415927F / 180.0F) * this.speedMultiplier * entitylivingbase.field_70701_bs * 0.05000000074505806D;
/* 478 */         this.field_70179_y += Math.cos(f * 3.1415927F / 180.0F) * this.speedMultiplier * entitylivingbase.field_70701_bs * 0.05000000074505806D;
/*     */       }
/*     */       
/* 481 */       double currentSpeed = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 482 */       boolean bonusActive = getHits() < 40;
/*     */       
/* 484 */       double topSpeed = bonusActive ? 0.6499999761581421D : 0.5D;
/*     */       
/* 486 */       if (currentSpeed > topSpeed) {
/* 487 */         double d14 = topSpeed / currentSpeed;
/* 488 */         this.field_70159_w *= d14;
/* 489 */         this.field_70179_y *= d14;
/* 490 */         currentSpeed = topSpeed;
/*     */       }
/*     */       
/* 493 */       double scaledTopSpeed = topSpeed * 100.0D;
/* 494 */       if ((currentSpeed > d9) && (this.speedMultiplier < topSpeed)) {
/* 495 */         this.speedMultiplier += (topSpeed - this.speedMultiplier) / scaledTopSpeed;
/*     */         
/* 497 */         if (this.speedMultiplier > topSpeed) {
/* 498 */           this.speedMultiplier = topSpeed;
/*     */         }
/*     */       } else {
/* 501 */         double fifthOfTopSpeed = topSpeed / 5.0D;
/* 502 */         this.speedMultiplier -= (this.speedMultiplier - fifthOfTopSpeed) / scaledTopSpeed;
/*     */         
/* 504 */         if (this.speedMultiplier < fifthOfTopSpeed) {
/* 505 */           this.speedMultiplier = fifthOfTopSpeed;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 510 */       int[][] scans = { { 0, 0 }, { 1, 0 }, { 0, 1 }, { 1, 1 }, { -1, 0 }, { 0, -1 }, { -1, -1 }, { -1, 1 }, { 1, -1 } };
/*     */       
/* 512 */       int[][] arrayOfInt1 = scans;iblockstate = arrayOfInt1.length; for (d24 = 0; d24 < iblockstate; d24++) { int[] scan = arrayOfInt1[d24];
/* 513 */         for (int dy = 0; dy < 3; dy++) {
/* 514 */           BlockPos blockpos = new BlockPos(this.field_70165_t + scan[0], MathHelper.func_76128_c(this.field_70163_u) + dy, this.field_70161_v + scan[1]);
/* 515 */           Block block = this.field_70170_p.func_180495_p(blockpos).func_177230_c();
/*     */           
/* 517 */           if (block == net.minecraft.init.Blocks.field_150434_aF) {
/* 518 */             this.field_70170_p.func_175655_b(blockpos, true);
/* 519 */             this.field_70123_F = false;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 524 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       
/* 526 */       setClientAnimations();
/*     */       
/* 528 */       this.field_70159_w *= 0.9900000095367432D;
/* 529 */       this.field_70181_x *= 0.949999988079071D;
/* 530 */       this.field_70179_y *= 0.9900000095367432D;
/*     */       
/* 532 */       this.field_70125_A = 0.0F;
/* 533 */       double d15 = this.field_70177_z;
/* 534 */       double d18 = this.field_70169_q - this.field_70165_t;
/* 535 */       double d21 = this.field_70166_s - this.field_70161_v;
/*     */       
/* 537 */       if (d18 * d18 + d21 * d21 > 0.001D) {
/* 538 */         d15 = (float)(MathHelper.func_181159_b(d21, d18) * 180.0D / 3.141592653589793D);
/*     */       }
/*     */       
/* 541 */       double d23 = MathHelper.func_76138_g(d15 - this.field_70177_z);
/*     */       
/* 543 */       if (d23 > 20.0D) {
/* 544 */         d23 = 20.0D;
/*     */       }
/*     */       
/* 547 */       if (d23 < -20.0D) {
/* 548 */         d23 = -20.0D;
/*     */       }
/*     */       
/* 551 */       this.field_70177_z = ((float)(this.field_70177_z + d23));
/* 552 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       
/* 554 */       if (!this.field_70170_p.field_72995_K)
/*     */       {
/*     */ 
/* 557 */         if (currentSpeed > topSpeed * 0.5D) {
/* 558 */           List<Entity> list = this.field_70170_p.func_72839_b(this, func_174813_aQ().func_72314_b(0.20000000298023224D, 0.03D, 0.20000000298023224D));
/*     */           
/* 560 */           if ((list != null) && (!list.isEmpty())) {
/* 561 */             for (int k2 = 0; k2 < list.size(); k2++) {
/* 562 */               Entity entity = (Entity)list.get(k2);
/* 563 */               if ((entity != this.field_70153_n) && (entity.func_70104_M()) && ((entity instanceof EntityLivingBase))) {
/* 564 */                 EntityLivingBase target = (EntityLivingBase)entity;
/* 565 */                 float MAX_DAMAGE = 16.0F;
/* 566 */                 float MIN_DAMAGE = 4.0F;
/*     */                 
/* 568 */                 float damage = bonusActive ? 16.0F : 4.0F;
/* 569 */                 float scaledSpeed = (float)(currentSpeed / topSpeed);
/* 570 */                 if (target.func_70097_a(new ChariotDamageSource(this, this.field_70153_n), damage * scaledSpeed)) {
/* 571 */                   float speed = 1.6F;
/* 572 */                   float lift = 0.5F;
/* 573 */                   Vec3 vec = new Vec3(target.field_70165_t - this.field_70165_t, target.field_70163_u - this.field_70163_u, target.field_70161_v - this.field_70161_v).func_72432_b();
/* 574 */                   double dx = vec.field_72450_a * speed;
/* 575 */                   double dy = lift;
/* 576 */                   double dz = vec.field_72449_c * speed;
/* 577 */                   if ((target instanceof EntityPlayer)) {
/* 578 */                     EntityPlayer otherPlayer = (EntityPlayer)target;
/* 579 */                     emoniph.intangible.Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(otherPlayer, dx, dy, dz), otherPlayer);
/*     */                   } else {
/* 581 */                     target.field_70159_w = dx;
/* 582 */                     target.field_70181_x = dy;
/* 583 */                     target.field_70179_y = dz;
/*     */                   }
/* 585 */                   if (bonusActive) {
/* 586 */                     setHits(getHits() + 1);
/*     */                   }
/*     */                   
/* 589 */                   if (!(target instanceof net.minecraft.entity.monster.EntitySkeleton))
/*     */                   {
/* 591 */                     emoniph.intangible.Sound.MOD_RANDOM_SQUELCH.playToAllNear(target, 0.5F, 1.0F);
/*     */                     
/* 593 */                     emoniph.intangible.Get.fx().sendToAllNear(EnumParticleTypes.REDSTONE, target, 0.25F, 20, 16.0D);
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 601 */         if ((this.field_70153_n != null) && (this.field_70153_n.field_70128_L)) {
/* 602 */           this.field_70153_n = null;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void setClientAnimations() {
/* 609 */     double dx = this.field_70159_w;
/* 610 */     double dz = this.field_70179_y;
/*     */     
/* 612 */     float dist = (float)Math.sqrt(dx * dx + dz * dz);
/*     */     
/* 614 */     if (dist > 0.0F) {
/* 615 */       float newVal = this.rotX + dist / 0.75F;
/* 616 */       this.rotX = (newVal % 6.2831855F);
/* 617 */       if (newVal > 6.2831855F) {
/* 618 */         playMoveSound(this.field_70170_p.func_180495_p(new BlockPos(this)).func_177230_c());
/*     */       }
/*     */     }
/*     */     
/* 622 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/* 624 */       this.prevLimbSwingAmount = this.limbSwingAmount;
/*     */       
/* 626 */       float f2 = MathHelper.func_76133_a(dx * dx + dz * dz) * 4.0F;
/*     */       
/* 628 */       if (f2 > 1.0F) {
/* 629 */         f2 = 1.0F;
/*     */       }
/*     */       
/* 632 */       this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
/* 633 */       this.limbSwing += this.limbSwingAmount;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ChariotDamageSource extends net.minecraft.util.EntityDamageSourceIndirect {
/*     */     public ChariotDamageSource(Entity damageSourceEntityIn, Entity rider) {
/* 639 */       super(damageSourceEntityIn, rider);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public net.minecraft.util.IChatComponent func_151519_b(EntityLivingBase victim)
/*     */     {
/* 646 */       return new net.minecraft.util.ChatComponentTranslation("death.intangible.attack.chariot", new Object[] {victim.func_145748_c_(), func_76346_g().func_145748_c_() });
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityChariot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */