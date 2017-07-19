/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.BodySide;
/*     */ import emoniph.intangible.api.golem.IGolemArm;
/*     */ import emoniph.intangible.api.golem.IGolemBody;
/*     */ import emoniph.intangible.api.golem.IGolemHead;
/*     */ import emoniph.intangible.api.golem.IGolemLeg;
/*     */ import emoniph.intangible.api.golem.IGolemStartable;
/*     */ import emoniph.intangible.blocks.BlockGolemFactory.TileEntityGolemFactory;
/*     */ import emoniph.intangible.blocks.BlockShell.TileEntityShell;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.golem.GolemPartRegistry;
/*     */ import emoniph.intangible.golem.GolemPartRegistry.Part;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.ByteBufUtil;
/*     */ import emoniph.intangible.util.InventoryUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityPigZombie;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.AnimalChest;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.InventoryBasic;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntityWreckingGolem extends EntityLiving implements emoniph.intangible.api.IPossessable, emoniph.intangible.api.IFakePlayerProvider, net.minecraft.inventory.IInvBasic, emoniph.intangible.api.golem.IGolem, emoniph.intangible.souls.ISoulHost, net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData
/*     */ {
/*     */   protected int attackTimerRight;
/*     */   protected int attackTimerLeft;
/*     */   protected int weaponCooldownRight;
/*     */   protected int weaponCooldownLeft;
/*     */   private AnimalChest entityChest;
/*     */   private EntitySeat seat;
/*     */   BlockPos prevPos;
/*     */   public UUID seatId;
/*     */   private EntityPlayer fakePlayer;
/*     */   
/*     */   public EntityWreckingGolem(World worldIn)
/*     */   {
/*  67 */     super(worldIn);
/*  68 */     func_70105_a(1.6F, 3.1F);
/*  69 */     func_110163_bv();
/*  70 */     this.field_70138_W = 1.0F;
/*  71 */     func_110226_cD();
/*     */     
/*  73 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */   public UUID getSeatId() {
/*  77 */     return this.seatId;
/*     */   }
/*     */   
/*     */   public void preSpawn() {
/*  81 */     GolemPartRegistry.Part<IGolemBody> body = Get.golems().getBodyByIndex(getBodyIndex());
/*  82 */     if ((body != null) && (((IGolemBody)body.getItem()).requiresSeat())) {
/*  83 */       this.seat = new EntitySeat(this.field_70170_p, this);
/*  84 */       this.seatId = this.seat.func_110124_au();
/*     */     }
/*     */   }
/*     */   
/*     */   public void postSpawn() {
/*  89 */     if ((!this.field_70170_p.field_72995_K) && (this.seat != null) && (this.seatId != null)) {
/*  90 */       this.seat.func_70012_b(this.field_70165_t, this.field_70163_u + 3.0D, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/*  91 */       this.field_70170_p.func_72838_d(this.seat);
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf buf)
/*     */   {
/*  97 */     buf.writeBoolean(this.seatId != null);
/*  98 */     if (this.seatId != null) {
/*  99 */       ByteBufUtil.writeUuid(buf, this.seatId);
/*     */     }
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf buf)
/*     */   {
/* 105 */     if (buf.readBoolean()) {
/* 106 */       this.seatId = ByteBufUtil.readUuid(buf);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_76316_a(InventoryBasic p_76316_1_) {}
/*     */   
/*     */ 
/*     */   private void func_110226_cD()
/*     */   {
/* 116 */     AnimalChest animalchest = this.entityChest;
/* 117 */     this.entityChest = new AnimalChest("HorseChest", 27);
/* 118 */     this.entityChest.func_110133_a(func_70005_c_());
/*     */     
/* 120 */     if (animalchest != null) {
/* 121 */       animalchest.func_110132_b(this);
/* 122 */       int i = Math.min(animalchest.func_70302_i_(), this.entityChest.func_70302_i_());
/*     */       
/* 124 */       for (int j = 0; j < i; j++) {
/* 125 */         ItemStack itemstack = animalchest.func_70301_a(j);
/*     */         
/* 127 */         if (itemstack != null) {
/* 128 */           this.entityChest.func_70299_a(j, itemstack.func_77946_l());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 133 */     this.entityChest.func_110134_a(this);
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/* 138 */     super.func_70088_a();
/* 139 */     func_70096_w().func_75682_a(16, Integer.valueOf(-1));
/* 140 */     func_70096_w().func_75682_a(17, Integer.valueOf(-1));
/* 141 */     func_70096_w().func_75682_a(18, Integer.valueOf(-1));
/* 142 */     func_70096_w().func_75682_a(19, Integer.valueOf(-1));
/* 143 */     func_70096_w().func_75682_a(20, Integer.valueOf(-1));
/* 144 */     func_70096_w().func_75682_a(21, Integer.valueOf(-1));
/*     */   }
/*     */   
/*     */   public int getRightArmIndex()
/*     */   {
/* 149 */     return func_70096_w().func_75679_c(16);
/*     */   }
/*     */   
/*     */   public void setRightArmIndex(int index) {
/* 153 */     func_70096_w().func_75692_b(16, Integer.valueOf(index));
/*     */   }
/*     */   
/*     */   public int getLeftArmIndex() {
/* 157 */     return func_70096_w().func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void setLeftArmIndex(int index) {
/* 161 */     func_70096_w().func_75692_b(17, Integer.valueOf(index));
/*     */   }
/*     */   
/*     */   public int getHeadIndex() {
/* 165 */     return func_70096_w().func_75679_c(18);
/*     */   }
/*     */   
/*     */   public void setHeadIndex(int index) {
/* 169 */     func_70096_w().func_75692_b(18, Integer.valueOf(index));
/* 170 */     recalculateStatistics();
/*     */   }
/*     */   
/*     */   public int getRightLegIndex() {
/* 174 */     return func_70096_w().func_75679_c(19);
/*     */   }
/*     */   
/*     */   public void setRightLegIndex(int index) {
/* 178 */     func_70096_w().func_75692_b(19, Integer.valueOf(index));
/* 179 */     recalculateStatistics();
/*     */   }
/*     */   
/*     */   public int getLeftLegIndex() {
/* 183 */     return func_70096_w().func_75679_c(20);
/*     */   }
/*     */   
/*     */   public void setLeftLegIndex(int index) {
/* 187 */     func_70096_w().func_75692_b(20, Integer.valueOf(index));
/* 188 */     recalculateStatistics();
/*     */   }
/*     */   
/*     */   public int getBodyIndex() {
/* 192 */     return func_70096_w().func_75679_c(21);
/*     */   }
/*     */   
/*     */   public void setBodyIndex(int index) {
/* 196 */     func_70096_w().func_75692_b(21, Integer.valueOf(index));
/* 197 */     recalculateStatistics();
/*     */   }
/*     */   
/*     */ 
/*     */   protected void func_110147_ax()
/*     */   {
/* 203 */     super.func_110147_ax();
/* 204 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0D);
/* 205 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */   
/*     */   private void recalculateStatistics() {
/* 209 */     GolemPartRegistry.Part<IGolemHead> head = Get.golems().getHeadByIndex(getHeadIndex());
/* 210 */     GolemPartRegistry.Part<IGolemBody> body = Get.golems().getBodyByIndex(getBodyIndex());
/*     */     
/* 212 */     float healthBoost = 0.0F;
/* 213 */     if (head != null) {
/* 214 */       healthBoost += ((IGolemHead)head.getItem()).getHealthBonus();
/*     */     }
/*     */     
/* 217 */     if (body != null) {
/* 218 */       healthBoost += ((IGolemBody)body.getItem()).getHealthBonus();
/*     */     }
/*     */     
/* 221 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(100.0D + healthBoost);
/*     */     
/* 223 */     GolemPartRegistry.Part<IGolemLeg> leftLeg = Get.golems().getLegByIndex(getLeftLegIndex());
/* 224 */     GolemPartRegistry.Part<IGolemLeg> rightLeg = Get.golems().getLegByIndex(getRightLegIndex());
/*     */     
/* 226 */     double speedBoost = 0.0D;
/* 227 */     if (leftLeg != null) {
/* 228 */       speedBoost += ((IGolemLeg)leftLeg.getItem()).getSpeedBonus();
/*     */     }
/*     */     
/* 231 */     if (rightLeg != null) {
/* 232 */       speedBoost += ((IGolemLeg)rightLeg.getItem()).getSpeedBonus();
/*     */     }
/*     */     
/* 235 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.05D + speedBoost);
/*     */   }
/*     */   
/*     */   protected int func_70682_h(int air) {
/* 239 */     return air;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 247 */     super.func_70071_h_();
/* 248 */     if (this.seat == null)
/*     */     {
/*     */ 
/* 251 */       if ((this.seatId != null) && (this.field_70173_aa > 1)) {
/* 252 */         final EntityWreckingGolem us = this;
/* 253 */         List<EntitySeat> seats = this.field_70170_p.func_175647_a(EntitySeat.class, func_174813_aQ().func_72314_b(8.0D, 8.0D, 8.0D), new com.google.common.base.Predicate()
/*     */         {
/*     */           public boolean apply(@javax.annotation.Nullable EntitySeat input) {
/* 256 */             return input.isOwnedBy(us);
/*     */           }
/*     */         });
/*     */         
/*     */ 
/* 261 */         for (EntitySeat foundSeat : seats) {
/* 262 */           if (this.seat == null) {
/* 263 */             this.seat = foundSeat;
/*     */           } else {
/* 265 */             this.seat.func_70106_y();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/* 273 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70024_g(double x, double y, double z)
/*     */   {
/* 278 */     if ((this.seat == null) || (this.seat.field_70153_n == null)) {
/* 279 */       super.func_70024_g(x, y, z);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70108_f(Entity entityIn)
/*     */   {
/* 285 */     if ((entityIn != this.seat) || (this.seat == null) || ((this.seat != null) && (this.seat.field_70153_n != entityIn))) {
/* 286 */       super.func_70108_f(entityIn);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70636_d() {
/* 291 */     super.func_70636_d();
/*     */     
/*     */ 
/* 294 */     if (this.attackTimerRight > 0) {
/* 295 */       this.attackTimerRight -= 1;
/*     */     }
/*     */     
/* 298 */     if (this.attackTimerLeft > 0) {
/* 299 */       this.attackTimerLeft -= 1;
/*     */     }
/*     */     
/* 302 */     if (this.weaponCooldownRight > 0) {
/* 303 */       this.weaponCooldownRight -= 1;
/*     */     }
/*     */     
/* 306 */     if (this.weaponCooldownLeft > 0) {
/* 307 */       this.weaponCooldownLeft -= 1;
/*     */     }
/*     */     
/* 310 */     if (func_70089_S()) {
/* 311 */       GolemPartRegistry.Part<IGolemHead> head = Get.golems().getHeadByIndex(getHeadIndex());
/* 312 */       if (head != null) {
/* 313 */         ((IGolemHead)head.getItem()).onUpdate(this, this.prevPos);
/*     */       }
/*     */       
/* 316 */       GolemPartRegistry.Part<IGolemBody> body = Get.golems().getBodyByIndex(getBodyIndex());
/* 317 */       if (body != null) {
/* 318 */         ((IGolemBody)body.getItem()).onUpdate(this, this.prevPos);
/*     */       }
/*     */       
/* 321 */       GolemPartRegistry.Part<IGolemLeg> legLeft = Get.golems().getLegByIndex(getLeftLegIndex());
/* 322 */       if (legLeft != null) {
/* 323 */         ((IGolemLeg)legLeft.getItem()).onUpdate(this, this.prevPos);
/*     */       }
/*     */       
/* 326 */       GolemPartRegistry.Part<IGolemLeg> legRight = Get.golems().getLegByIndex(getRightLegIndex());
/* 327 */       if (legRight != null) {
/* 328 */         ((IGolemLeg)legRight.getItem()).onUpdate(this, this.prevPos);
/*     */       }
/*     */       
/* 331 */       int x = MathHelper.func_76128_c(this.field_70165_t);
/* 332 */       int y = MathHelper.func_76128_c(this.field_70163_u);
/* 333 */       int z = MathHelper.func_76128_c(this.field_70161_v);
/* 334 */       if ((this.prevPos == null) || (x != this.prevPos.func_177958_n()) || (y != this.prevPos.func_177956_o()) || (z != this.prevPos.func_177952_p())) {
/* 335 */         this.prevPos = new BlockPos(x, y, z);
/*     */       }
/*     */     }
/*     */     
/* 339 */     if ((this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y > 2.500000277905201E-7D) && (this.field_70146_Z.nextInt(5) == 0)) {
/* 340 */       int i = MathHelper.func_76128_c(this.field_70165_t);
/* 341 */       int j = MathHelper.func_76128_c(this.field_70163_u - 0.20000000298023224D);
/* 342 */       int k = MathHelper.func_76128_c(this.field_70161_v);
/* 343 */       IBlockState iblockstate = this.field_70170_p.func_180495_p(new BlockPos(i, j, k));
/* 344 */       Block block = iblockstate.func_177230_c();
/*     */       
/* 346 */       if (block.func_149688_o() != net.minecraft.block.material.Material.field_151579_a) {
/* 347 */         this.field_70170_p.func_175688_a(EnumParticleTypes.BLOCK_CRACK, this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, func_174813_aQ().field_72338_b + 0.1D, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, 4.0D * (this.field_70146_Z.nextFloat() - 0.5D), 0.5D, (this.field_70146_Z.nextFloat() - 0.5D) * 4.0D, new int[] { Block.func_176210_f(iblockstate) });
/*     */       }
/*     */     }
/*     */     
/* 351 */     if (this.seat != null) {
/* 352 */       this.seat.func_70071_h_();
/* 353 */       double seatOffsetY = 0.0D;
/*     */       
/*     */ 
/* 356 */       double yaw = emoniph.intangible.util.EntityUtil.interpolateRotation(this.field_70760_ar, this.field_70761_aq, 0.0F);
/*     */       
/* 358 */       double shift = 0.6000000238418579D;
/* 359 */       double d0 = Math.cos(yaw * 3.141592653589793D / 180.0D) * shift;
/* 360 */       double d1 = Math.sin(yaw * 3.141592653589793D / 180.0D) * shift;
/*     */       
/*     */ 
/* 363 */       double x = this.field_70165_t + d1;
/* 364 */       double y = this.field_70163_u + seatOffsetY;
/* 365 */       double z = this.field_70161_v - d0;
/*     */       
/* 367 */       this.seat.field_70169_q = x;
/* 368 */       this.seat.field_70167_r = y;
/* 369 */       this.seat.field_70166_s = z;
/* 370 */       this.seat.field_70142_S = x;
/* 371 */       this.seat.field_70137_T = y;
/* 372 */       this.seat.field_70136_U = z;
/* 373 */       this.seat.func_70107_b(x, y, z);
/*     */       
/*     */ 
/* 376 */       this.seat.field_70177_z = this.field_70177_z;
/* 377 */       this.seat.field_70125_A = this.field_70125_A;
/* 378 */       this.seat.field_70126_B = this.field_70126_B;
/* 379 */       this.seat.field_70127_C = this.field_70127_C;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean shouldDismountInWater(Entity rider)
/*     */   {
/* 386 */     return (!(rider instanceof EntityPlayer)) || (!Get.effects().isActiveFor(Get.effects().INCORPOREAL, (EntityPlayer)rider));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70103_a(byte p_70103_1_) {
/* 391 */     if (p_70103_1_ == 4) {
/* 392 */       this.attackTimerRight = 10;
/* 393 */       func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
/* 394 */     } else if (p_70103_1_ == 5) {
/* 395 */       this.attackTimerLeft = 10;
/* 396 */       func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
/*     */     } else {
/* 398 */       super.func_70103_a(p_70103_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getAttackTimerRight() {
/* 404 */     return this.attackTimerRight;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int getAttackTimerLeft() {
/* 409 */     return this.attackTimerLeft;
/*     */   }
/*     */   
/*     */   protected String func_70621_aR() {
/* 413 */     return Sound.MOD_RANDOM_ROCK_HIT.LOCATION;
/*     */   }
/*     */   
/*     */   protected String func_70673_aS() {
/* 417 */     return Sound.MOD_RANDOM_GOLEM_BROKEN.LOCATION;
/*     */   }
/*     */   
/*     */   protected void func_180429_a(BlockPos p_180429_1_, Block p_180429_2_) {
/* 421 */     func_85030_a("mob.irongolem.walk", 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_) {
/* 425 */     if (!this.field_70170_p.field_72995_K) {
/* 426 */       float yOffset = 0.0F;
/* 427 */       for (int i = 0; i < this.entityChest.func_70302_i_(); i++) {
/* 428 */         ItemStack itemstack = this.entityChest.func_70301_a(i);
/* 429 */         if (itemstack != null) {
/* 430 */           func_70099_a(itemstack, yOffset);
/*     */         }
/*     */       }
/* 433 */       dropBodyPart(Get.golems().getBodyByIndex(getBodyIndex()), true);
/*     */       
/* 435 */       int lost = this.field_70170_p.field_73012_v.nextInt(20);
/* 436 */       dropBodyPart(Get.golems().getArmByIndex(getRightArmIndex()), lost != 0);
/* 437 */       dropBodyPart(Get.golems().getArmByIndex(getLeftArmIndex()), lost != 2);
/* 438 */       dropBodyPart(Get.golems().getLegByIndex(getLeftLegIndex()), lost != 3);
/* 439 */       dropBodyPart(Get.golems().getLegByIndex(getRightLegIndex()), lost != 4);
/* 440 */       dropBodyPart(Get.golems().getHeadByIndex(getHeadIndex()), lost != 5);
/*     */     }
/*     */   }
/*     */   
/*     */   private <T> void dropBodyPart(GolemPartRegistry.Part<T> part, boolean drop)
/*     */   {
/* 446 */     if ((part != null) && (drop)) {
/* 447 */       ItemStack stack = part.getStack().func_77946_l();
/* 448 */       func_70099_a(stack, 0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean tryAddEntityItemToGolemInventory(EntityItem item)
/*     */   {
/* 454 */     ItemStack stack = item.func_92059_d();
/* 455 */     if (stack == null) {
/* 456 */       return false;
/*     */     }
/*     */     
/* 459 */     int i = stack.field_77994_a;
/* 460 */     if (((item.func_145798_i() == null) || (item.lifespan - item.field_70292_b <= 200) || 
/*     */     
/* 462 */       (item.func_145798_i().equals(func_70005_c_()))) && ((i <= 0) || 
/* 463 */       (InventoryUtil.addItemStackToInventory(stack, this.entityChest)))) {
/* 464 */       if (!item.func_174814_R()) {
/* 465 */         this.field_70170_p.func_72956_a(this, "random.pop", 0.2F, ((this.field_70146_Z.nextFloat() - this.field_70146_Z.nextFloat()) * 0.7F + 1.0F) * 2.0F);
/*     */       }
/*     */       
/* 468 */       func_71001_a(this, i);
/*     */       
/* 470 */       if (stack.field_77994_a <= 0) {
/* 471 */         item.func_70106_y();
/*     */       }
/* 473 */       return true;
/*     */     }
/*     */     
/* 476 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70106_y()
/*     */   {
/* 481 */     super.func_70106_y();
/* 482 */     if (this.seat != null) {
/* 483 */       this.seat.func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   public void moveInventoryTo(IInventory inv) {
/* 488 */     if (!this.field_70170_p.field_72995_K) {
/* 489 */       for (int slot = 0; slot < this.entityChest.func_70302_i_(); slot++) {
/* 490 */         ItemStack stack = this.entityChest.func_70301_a(slot);
/* 491 */         if (stack != null) {
/* 492 */           InventoryUtil.addItemStackToInventory(stack, inv);
/* 493 */           if (stack.field_77994_a > 0) {
/* 494 */             func_70099_a(stack, 0.0F);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean tryRemoveItemFromInventory(ItemStack sampleStack)
/*     */   {
/* 503 */     if (!this.field_70170_p.field_72995_K) {
/* 504 */       for (int slot = 0; slot < this.entityChest.func_70302_i_(); slot++) {
/* 505 */         ItemStack stack = this.entityChest.func_70301_a(slot);
/* 506 */         if ((stack != null) && 
/* 507 */           (ItemStack.func_179545_c(stack, sampleStack)) && (ItemStack.func_77970_a(stack, sampleStack)) && 
/* 508 */           (stack.field_77994_a >= sampleStack.field_77994_a)) {
/* 509 */           stack.func_77979_a(sampleStack.field_77994_a);
/* 510 */           if (stack.field_77994_a <= 0) {
/* 511 */             this.entityChest.func_70299_a(slot, null);
/*     */           }
/* 513 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 519 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_70039_c(NBTTagCompound compound)
/*     */   {
/* 524 */     String s = func_70022_Q();
/*     */     
/* 526 */     if ((!this.field_70128_L) && (s != null) && ((getSeat() != null) || (this.field_70153_n == null))) {
/* 527 */       compound.func_74778_a("id", s);
/* 528 */       func_70109_d(compound);
/* 529 */       return true;
/*     */     }
/* 531 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 537 */     super.func_70014_b(compound);
/*     */     
/* 539 */     compound.func_74768_a("armLeft", getLeftArmIndex());
/* 540 */     compound.func_74768_a("armRight", getRightArmIndex());
/* 541 */     compound.func_74768_a("head", getHeadIndex());
/* 542 */     compound.func_74768_a("legLeft", getLeftLegIndex());
/* 543 */     compound.func_74768_a("legRight", getRightLegIndex());
/* 544 */     compound.func_74768_a("body", getBodyIndex());
/*     */     
/* 546 */     NBTTagList nbttaglist = new NBTTagList();
/*     */     
/* 548 */     for (int i = 0; i < this.entityChest.func_70302_i_(); i++) {
/* 549 */       ItemStack itemstack = this.entityChest.func_70301_a(i);
/*     */       
/* 551 */       if (itemstack != null) {
/* 552 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 553 */         nbttagcompound1.func_74774_a("Slot", (byte)i);
/* 554 */         itemstack.func_77955_b(nbttagcompound1);
/* 555 */         nbttaglist.func_74742_a(nbttagcompound1);
/*     */       }
/*     */     }
/*     */     
/* 559 */     compound.func_74782_a("Items", nbttaglist);
/*     */     
/* 561 */     if (this.seatId != null) {
/* 562 */       compound.func_74772_a("seatMsb", this.seatId.getMostSignificantBits());
/* 563 */       compound.func_74772_a("seatLsb", this.seatId.getLeastSignificantBits());
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_70658_aO()
/*     */   {
/* 569 */     int armor = 0;
/* 570 */     GolemPartRegistry.Part<IGolemHead> head = Get.golems().getHeadByIndex(getHeadIndex());
/* 571 */     GolemPartRegistry.Part<IGolemBody> body = Get.golems().getBodyByIndex(getBodyIndex());
/* 572 */     if (head != null) {
/* 573 */       armor += ((IGolemHead)head.getItem()).getArmorBonus();
/*     */     }
/*     */     
/* 576 */     if (body != null) {
/* 577 */       armor += ((IGolemBody)body.getItem()).getArmorBonus();
/*     */     }
/*     */     
/* 580 */     return armor;
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 585 */     super.func_70037_a(compound);
/* 586 */     setLeftArmIndex(compound.func_74762_e("armLeft"));
/* 587 */     setRightArmIndex(compound.func_74762_e("armRight"));
/* 588 */     setHeadIndex(compound.func_74762_e("head"));
/* 589 */     setLeftLegIndex(compound.func_74762_e("legLeft"));
/* 590 */     setRightLegIndex(compound.func_74762_e("legRight"));
/* 591 */     setBodyIndex(compound.func_74762_e("body"));
/*     */     
/* 593 */     NBTTagList nbttaglist = compound.func_150295_c("Items", 10);
/* 594 */     func_110226_cD();
/*     */     
/* 596 */     for (int i = 0; i < nbttaglist.func_74745_c(); i++) {
/* 597 */       NBTTagCompound nbttagcompound1 = nbttaglist.func_150305_b(i);
/* 598 */       int j = nbttagcompound1.func_74771_c("Slot") & 0xFF;
/* 599 */       this.entityChest.func_70299_a(j, ItemStack.func_77949_a(nbttagcompound1));
/*     */     }
/*     */     
/* 602 */     if ((compound.func_74764_b("seatMsb")) && (compound.func_74764_b("seatLsb"))) {
/* 603 */       this.seatId = new UUID(compound.func_74763_f("seatMsb"), compound.func_74763_f("seatLsb"));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean canBePossessedBy(EntityPlayer player)
/*     */   {
/* 611 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 616 */   private static final GameProfile FAKE_PLAYER_PROFILE = new GameProfile(UUID.fromString("717017e9-b701-410b-8a3a-8b714f7d5f56"), "[wreckinggolem]");
/*     */   private int jumps;
/*     */   
/* 619 */   public EntityPlayer getFakePlayer() { if ((!this.field_70170_p.field_72995_K) && ((this.fakePlayer == null) || (this.fakePlayer.field_70170_p != this.field_70170_p))) {
/* 620 */       this.fakePlayer = net.minecraftforge.common.util.FakePlayerFactory.get((net.minecraft.world.WorldServer)this.field_70170_p, FAKE_PLAYER_PROFILE);
/*     */     }
/* 622 */     return this.fakePlayer;
/*     */   }
/*     */   
/*     */   public boolean onAttackAction(EntityPlayer player, BlockPos targetPos)
/*     */   {
/* 627 */     if (targetPos != null) {
/* 628 */       IBlockState state = this.field_70170_p.func_180495_p(targetPos);
/* 629 */       if ((state.func_177230_c() instanceof IGolemStartable)) {
/* 630 */         GolemPartRegistry.Part<IGolemArm> arm = Get.golems().getArmByIndex(getLeftArmIndex());
/* 631 */         if (((IGolemArm)arm.getItem()).canStartBlocks()) {
/* 632 */           IGolemStartable startable = (IGolemStartable)state.func_177230_c();
/* 633 */           startable.startWithGolem(this.field_70170_p, targetPos, player);
/* 634 */           if (((IGolemArm)arm.getItem()).canSwing()) {
/* 635 */             this.attackTimerLeft = 10;
/* 636 */             this.field_70170_p.func_72960_a(this, (byte)5);
/*     */           }
/* 638 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 643 */     if (this.attackTimerLeft == 0) {
/* 644 */       if (this.weaponCooldownLeft == 0) {
/* 645 */         GolemPartRegistry.Part<IGolemArm> arm = Get.golems().getArmByIndex(getLeftArmIndex());
/* 646 */         if (((IGolemArm)arm.getItem()).onUseAction(this.field_70170_p, player, this, this, targetPos, BodySide.LEFT)) {
/* 647 */           if (((IGolemArm)arm.getItem()).canSwing()) {
/* 648 */             this.attackTimerLeft = 10;
/* 649 */             this.field_70170_p.func_72960_a(this, (byte)5);
/*     */           }
/* 651 */           this.weaponCooldownLeft = ((IGolemArm)arm.getItem()).getCooldownTicks();
/*     */         }
/*     */       } else {
/* 654 */         Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(player);
/*     */       }
/*     */     }
/*     */     
/* 658 */     return true;
/*     */   }
/*     */   
/*     */   public boolean onUseAction(EntityPlayer player, BlockPos targetPos)
/*     */   {
/* 663 */     if (targetPos != null) {
/* 664 */       IBlockState state = this.field_70170_p.func_180495_p(targetPos);
/* 665 */       if (state.func_177230_c() == Get.blocks().GOLEM_FACTORY) {
/* 666 */         BlockPos controllerPos = Get.blocks().GOLEM_FACTORY.getMultiBlockCorePos(this.field_70170_p, targetPos, state);
/* 667 */         BlockGolemFactory.TileEntityGolemFactory tile = (BlockGolemFactory.TileEntityGolemFactory)BlockUtil.getTileEntity(this.field_70170_p, controllerPos, BlockGolemFactory.TileEntityGolemFactory.class);
/* 668 */         tile.attachGolem(this);
/* 669 */         return true; }
/* 670 */       if (state.func_177230_c() == Get.blocks().PLAYER_SHELL) {
/* 671 */         BlockPos shellPos = targetPos;
/* 672 */         if (state.func_177229_b(net.minecraft.block.BlockBed.field_176472_a) == net.minecraft.block.BlockBed.EnumPartType.HEAD) {
/* 673 */           shellPos = shellPos.func_177977_b();
/*     */         }
/* 675 */         BlockShell.TileEntityShell tile = (BlockShell.TileEntityShell)BlockUtil.getTileEntity(this.field_70170_p, shellPos, BlockShell.TileEntityShell.class);
/* 676 */         if ((tile != null) && (tile.isOwner(player))) {
/* 677 */           PlayerEx playerEx = PlayerEx.get(player);
/* 678 */           playerEx.enterPlayerShell(player.field_70170_p, shellPos, state);
/* 679 */           return true;
/*     */         }
/* 681 */       } else if ((state.func_177230_c() instanceof IGolemStartable)) {
/* 682 */         GolemPartRegistry.Part<IGolemArm> arm = Get.golems().getArmByIndex(getRightArmIndex());
/* 683 */         if (((IGolemArm)arm.getItem()).canStartBlocks()) {
/* 684 */           IGolemStartable startable = (IGolemStartable)state.func_177230_c();
/* 685 */           startable.startWithGolem(this.field_70170_p, targetPos, player);
/* 686 */           if (((IGolemArm)arm.getItem()).canSwing()) {
/* 687 */             this.attackTimerRight = 10;
/* 688 */             this.field_70170_p.func_72960_a(this, (byte)4);
/*     */           }
/* 690 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 695 */     if (this.attackTimerRight == 0) {
/* 696 */       if (this.weaponCooldownRight == 0) {
/* 697 */         GolemPartRegistry.Part<IGolemArm> arm = Get.golems().getArmByIndex(getRightArmIndex());
/* 698 */         if (((IGolemArm)arm.getItem()).onUseAction(this.field_70170_p, player, this, this, targetPos, BodySide.RIGHT)) {
/* 699 */           if (((IGolemArm)arm.getItem()).canSwing()) {
/* 700 */             this.attackTimerRight = 10;
/* 701 */             this.field_70170_p.func_72960_a(this, (byte)4);
/*     */           }
/* 703 */           this.weaponCooldownRight = ((IGolemArm)arm.getItem()).getCooldownTicks();
/*     */         }
/*     */       } else {
/* 706 */         Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(player);
/*     */       }
/*     */     }
/*     */     
/* 710 */     return true;
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity p_70652_1_)
/*     */   {
/* 715 */     boolean flag = p_70652_1_.func_70097_a(net.minecraft.util.DamageSource.func_76358_a(this), 7 + this.field_70146_Z.nextInt(10));
/*     */     
/* 717 */     if (flag) {
/* 718 */       p_70652_1_.field_70181_x += 0.4000000059604645D;
/* 719 */       func_174815_a(this, p_70652_1_);
/*     */     }
/*     */     
/* 722 */     func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
/* 723 */     return flag;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean allowFirstPersonRender()
/*     */   {
/* 729 */     return true;
/*     */   }
/*     */   
/*     */   public void func_180430_e(float distance, float damageMultiplier)
/*     */   {
/* 734 */     if (distance > 10.0F) {
/* 735 */       super.func_180430_e(distance, damageMultiplier);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onJumpKey(EntityPlayer player)
/*     */   {
/* 743 */     if (this.field_70122_E) {
/* 744 */       this.jumps = 0;
/*     */     }
/* 746 */     GolemPartRegistry.Part<IGolemLeg> leftLeg = Get.golems().getLegByIndex(getLeftLegIndex());
/* 747 */     GolemPartRegistry.Part<IGolemLeg> rightLeg = Get.golems().getLegByIndex(getRightLegIndex());
/*     */     
/* 749 */     int maxJumps = 2;
/* 750 */     if (leftLeg != null) {
/* 751 */       maxJumps = (int)(maxJumps + ((IGolemLeg)leftLeg.getItem()).getThrustBonus());
/*     */     }
/*     */     
/* 754 */     if (rightLeg != null) {
/* 755 */       maxJumps = (int)(maxJumps + ((IGolemLeg)rightLeg.getItem()).getThrustBonus());
/*     */     }
/* 757 */     if (this.jumps < maxJumps) {
/* 758 */       if (this.jumps > 0) {
/* 759 */         Sound.MOD_RANDOM_JETPACK.playToAllNear(this, 0.5F, 1.0F);
/* 760 */         double size = 0.4D;
/* 761 */         for (int i = 0; i < 20; i++) {
/* 762 */           double x = this.field_70165_t + size - 2.0D * size * this.field_70146_Z.nextDouble();
/* 763 */           double y = this.field_70163_u + this.field_70131_O * 0.4D + size - 2.0D * size * this.field_70146_Z.nextDouble();
/* 764 */           double z = this.field_70161_v + size - 2.0D * size * this.field_70146_Z.nextDouble();
/* 765 */           Minecraft.func_71410_x().field_71452_i.func_178927_a(EnumParticleTypes.SMOKE_NORMAL.func_179348_c(), x, y, z, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */         }
/*     */       }
/* 768 */       Get.pipeline().sendToServer(new emoniph.intangible.player.PlayerEx.PacketEntityLivingAction(this, emoniph.intangible.player.PlayerEx.PacketEntityLivingAction.Action.JUMP));
/* 769 */       this.jumps += 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public void possessBy(EntityPlayer player)
/*     */   {
/* 775 */     if (!this.field_70170_p.field_72995_K) {
/* 776 */       Sound.MOD_RANDOM_GOLEM_POWERUP.playToAllNear(this, 0.5F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public IEntityLivingData func_180482_a(DifficultyInstance difficulty, IEntityLivingData livingData)
/*     */   {
/* 782 */     setRightArmIndex(this.field_70170_p.field_73012_v.nextInt(Get.golems().arms.size()));
/* 783 */     setLeftArmIndex(this.field_70170_p.field_73012_v.nextInt(Get.golems().arms.size()));
/* 784 */     setHeadIndex(this.field_70170_p.field_73012_v.nextInt(Get.golems().heads.size()));
/*     */     
/* 786 */     if (this.seat != null) {
/* 787 */       this.seat.func_70012_b(this.field_70165_t, this.field_70163_u + 2.0D, this.field_70161_v, 0.0F, 0.0F);
/*     */     }
/*     */     
/* 790 */     return super.func_180482_a(difficulty, livingData);
/*     */   }
/*     */   
/*     */   public EntitySeat getSeat() {
/* 794 */     return this.seat;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean func_70085_c(EntityPlayer player)
/*     */   {
/* 800 */     GolemPartRegistry.Part<IGolemBody> body = Get.golems().getBodyByIndex(getBodyIndex());
/* 801 */     if (body != null) {
/* 802 */       if (((IGolemBody)body.getItem()).requiresSeat()) {
/* 803 */         if ((!this.field_70170_p.field_72995_K) && 
/* 804 */           (this.seat != null)) {
/* 805 */           if ((player.func_70694_bm() != null) && (player.func_70694_bm().func_77973_b() == net.minecraft.init.Items.field_151063_bx)) {
/* 806 */             if (this.seat.field_70153_n == null) {
/* 807 */               EntityPigZombie skeleton = new EntityPigZombie(this.field_70170_p);
/* 808 */               skeleton.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0F, 0.0F);
/* 809 */               this.field_70170_p.func_72838_d(skeleton);
/* 810 */               skeleton.func_70078_a(this.seat);
/* 811 */             } else if (!(this.seat.field_70153_n instanceof EntityPlayer)) {
/* 812 */               this.seat.field_70153_n.func_70106_y();
/*     */             }
/*     */           }
/* 815 */           else if (this.seat.field_70153_n != player) {
/* 816 */             player.func_70078_a(this.seat);
/*     */           } else {
/* 818 */             ((IGolemBody)body.getItem()).seatRiderInteract(this, player);
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       else {
/* 824 */         player.func_71007_a(this.entityChest);
/*     */       }
/*     */     }
/*     */     
/* 828 */     return true;
/*     */   }
/*     */   
/*     */   public World getGolemWorld()
/*     */   {
/* 833 */     return this.field_70170_p;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB getGolemBoundingBox()
/*     */   {
/* 838 */     return func_174813_aQ();
/*     */   }
/*     */   
/*     */   public int getGolemTicksExisted()
/*     */   {
/* 843 */     return this.field_70173_aa;
/*     */   }
/*     */   
/*     */   public void healGolem(float health)
/*     */   {
/* 848 */     func_70691_i(health);
/*     */   }
/*     */   
/*     */   public double getGolemX()
/*     */   {
/* 853 */     return this.field_70165_t;
/*     */   }
/*     */   
/*     */   public double getGolemY()
/*     */   {
/* 858 */     return this.field_70163_u;
/*     */   }
/*     */   
/*     */   public double getGolemZ()
/*     */   {
/* 863 */     return this.field_70161_v;
/*     */   }
/*     */   
/*     */ 
/*     */   public emoniph.intangible.api.SoulType getSoulType()
/*     */   {
/* 869 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isTrappableInBoneCage()
/*     */   {
/* 874 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorporeal()
/*     */   {
/* 879 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityWreckingGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */