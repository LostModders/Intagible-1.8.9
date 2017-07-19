/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import emoniph.intangible.player.PlayerEx.PacketAttach;
/*     */ import emoniph.intangible.souls.SoulRegistry;
/*     */ import emoniph.intangible.util.EnumDiagonalFacing;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntitySlime;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.nbt.NBTTagLong;
/*     */ import net.minecraft.pathfinding.PathNavigateGround;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class EntitySoul extends EntityCreature implements emoniph.intangible.api.IPossessable, emoniph.intangible.souls.ISoulHost
/*     */ {
/*     */   private boolean isSoulLeashed;
/*     */   private Entity leashedSoulToEntity;
/*     */   private NBTTagCompound leashSoulNBTTag;
/*     */   private net.minecraft.entity.ai.EntityAIBase aiBase;
/*     */   
/*     */   public static EntitySoul removeSoulAsEntity(EntityLiving entity)
/*     */   {
/*  55 */     if ((entity.field_70170_p.field_72995_K) || (!Get.souls().isSoulPresent(entity, true))) {
/*  56 */       return null;
/*     */     }
/*  58 */     EntitySoul soul = new EntitySoul(entity.func_130014_f_());
/*  59 */     if ((entity instanceof EntityHollowIronGolem)) {
/*  60 */       EntityHollowIronGolem golem = (EntityHollowIronGolem)entity;
/*  61 */       golem.syncToSoul(soul);
/*  62 */       golem.setTrappedSoul(null, null, 0.0F, 0.0F);
/*     */     } else {
/*  64 */       String entityString = EntityList.func_75621_b(entity);
/*  65 */       soul.setEntityType(entityString);
/*  66 */       soul.func_70105_a(Math.min(entity.field_70130_N, 0.5F), entity.field_70131_O);
/*  67 */       Get.souls().setSoulInEntity(entity, false);
/*  68 */       if ((entity instanceof EntitySlime)) {
/*  69 */         ((EntitySlime)entity).func_70799_a(1);
/*     */       }
/*     */     }
/*  72 */     return soul;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_145773_az()
/*     */   {
/*  78 */     return true;
/*     */   }
/*     */   
/*     */   public EntitySoul(World worldIn) {
/*  82 */     super(worldIn);
/*     */     
/*  84 */     func_70105_a(0.9F, 0.9F);
/*     */     
/*  86 */     this.aiBase = new net.minecraft.entity.ai.EntityAIMoveTowardsRestriction(this, 1.0D);
/*     */     
/*  88 */     ((PathNavigateGround)func_70661_as()).func_179693_d(true);
/*  89 */     ((PathNavigateGround)func_70661_as()).func_179690_a(true);
/*  90 */     this.field_70714_bg.func_75776_a(0, new net.minecraft.entity.ai.EntityAISwimming(this));
/*  91 */     this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAIPanic(this, 1.25D));
/*  92 */     this.field_70714_bg.func_75776_a(2, new emoniph.intangible.entity.ai.EntityAIFollowRelays(this, 1.0D));
/*     */     
/*     */ 
/*     */ 
/*  96 */     this.field_70714_bg.func_75776_a(6, new net.minecraft.entity.ai.EntityAIWander(this, 1.0D));
/*  97 */     this.field_70714_bg.func_75776_a(7, new net.minecraft.entity.ai.EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
/*  98 */     this.field_70714_bg.func_75776_a(8, new net.minecraft.entity.ai.EntityAILookIdle(this));
/*     */     
/* 100 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */   public boolean func_70067_L()
/*     */   {
/* 105 */     return super.func_70067_L();
/*     */   }
/*     */   
/*     */   public boolean func_70104_M()
/*     */   {
/* 110 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/* 114 */     super.func_110147_ax();
/* 115 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(10.0D);
/* 116 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.25D);
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/* 120 */     super.func_70088_a();
/* 121 */     this.field_70180_af.func_75682_a(16, "");
/*     */   }
/*     */   
/*     */   public boolean shouldRenderInPass(int pass)
/*     */   {
/* 126 */     return pass == 1;
/*     */   }
/*     */   
/*     */   public void setEntityTypeBySoul(SoulType soulType) {
/* 130 */     String defaultType = Get.souls().getDefaultEntityFor(soulType);
/* 131 */     if (defaultType != null) {
/* 132 */       setEntityType(defaultType);
/*     */     } else {
/* 134 */       setEntityType("");
/*     */     }
/* 136 */     EntityLiving proxy = getProxyEntity();
/* 137 */     if (proxy != null) {
/* 138 */       func_70105_a(Math.min(proxy.field_70130_N, 0.5F), proxy.field_70131_O);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setEntityType(String entityType) {
/* 143 */     this.field_70180_af.func_75692_b(16, entityType);
/*     */   }
/*     */   
/*     */   public String getEntityType() {
/* 147 */     return this.field_70180_af.func_75681_e(16);
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource source, float amount) {
/* 151 */     if (func_180431_b(source))
/* 152 */       return false;
/* 153 */     if ((source == DamageSource.field_76368_d) || (source == DamageSource.field_76380_i)) {
/* 154 */       return super.func_70097_a(source, amount);
/*     */     }
/* 156 */     boolean attackCanDamageSouls = (source.func_76346_g() != null) && ((source.func_76364_f() instanceof EntitySpell));
/* 157 */     if (attackCanDamageSouls) {
/* 158 */       return super.func_70097_a(source, amount);
/*     */     }
/* 160 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 165 */   int ticksSinceRelayUpdate = 0;
/* 166 */   int destablizationTicks = 0;
/*     */   private boolean field_110180_bt;
/*     */   private EntityLiving proxyEntity;
/*     */   
/* 170 */   public void func_70071_h_() { if ((this.destablizationTicks > 0) && (!func_70644_a(Potion.field_76421_d))) {
/* 171 */       func_70690_d(new net.minecraft.potion.PotionEffect(Potion.field_76421_d.field_76415_H, 30, 6));
/*     */     }
/*     */     
/* 174 */     super.func_70071_h_();
/*     */     
/* 176 */     if (!this.field_70170_p.field_72995_K)
/*     */     {
/* 178 */       if (this.field_70173_aa > 20) {
/* 179 */         updateSoulLeashState();
/*     */       }
/*     */       
/* 182 */       int count = 0;
/* 183 */       List<EntityItem> items = this.field_70170_p.func_72872_a(EntityItem.class, func_174813_aQ().func_72314_b(0.5D, 0.0D, 0.5D));
/* 184 */       for (EntityItem item : items) {
/* 185 */         if ((item.func_92059_d() != null) && (item.func_92059_d().func_77973_b() == net.minecraft.init.Items.field_151103_aS)) {
/* 186 */           item.func_92059_d().func_150996_a(Get.items().SOUL_BONE);
/* 187 */           count++;
/*     */         }
/*     */       }
/*     */       
/* 191 */       if (this.ticksSinceRelayUpdate > 0) {
/* 192 */         this.ticksSinceRelayUpdate -= 1;
/* 193 */         if (this.ticksSinceRelayUpdate == 0) {
/* 194 */           this.visitedRelays.clear();
/*     */         }
/*     */       }
/*     */       
/* 198 */       if (count > 0) {
/* 199 */         emoniph.intangible.Sound.MOD_RANDOM_SLURP.playToAllNear(this, 0.5F, 1.0F);
/*     */       }
/*     */       
/* 202 */       if ((this.field_70173_aa % 20 == 0) && (getEntityType() != null) && (!getEntityType().isEmpty())) {
/* 203 */         BlockPos pos = new BlockPos(this);
/* 204 */         int relays = 0;
/* 205 */         EnumDiagonalFacing facing; BlockPos relayPos; for (facing : EnumDiagonalFacing.DIAGONALS) {
/* 206 */           relayPos = facing.offset(pos);
/* 207 */           IBlockState state = this.field_70170_p.func_180495_p(relayPos);
/* 208 */           if ((state.func_177230_c() == Get.blocks().SOUL_RELAY) && (((Boolean)state.func_177229_b(emoniph.intangible.blocks.BlockSoulRelay.POWERED)).booleanValue()) && 
/* 209 */             (this.field_70170_p.func_180495_p(relayPos.func_177984_a()).func_177230_c() == Get.blocks().SOUL_RELAY)) {
/* 210 */             relays++;
/*     */           }
/*     */         }
/*     */         
/* 214 */         int MAX_DESTABALIZE_PULSES = 10;
/*     */         
/* 216 */         if (relays == EnumDiagonalFacing.DIAGONALS.length) {
/* 217 */           this.destablizationTicks += 1;
/* 218 */           int conversions = 0;
/* 219 */           EnumFacing[] arrayOfEnumFacing = EnumFacing.field_176754_o;facing = arrayOfEnumFacing.length; for (relayPos = 0; relayPos < facing; relayPos++) { EnumFacing facing = arrayOfEnumFacing[relayPos];
/* 220 */             BlockPos stonePos = pos.func_177977_b().func_177972_a(facing);
/* 221 */             IBlockState state = this.field_70170_p.func_180495_p(stonePos);
/* 222 */             if ((state.func_177230_c() == net.minecraft.init.Blocks.field_150348_b) && (state.func_177229_b(net.minecraft.block.BlockStone.field_176247_a) == net.minecraft.block.BlockStone.EnumType.STONE)) {
/* 223 */               Get.fx().GLOW.sendToAllNear(this.field_70170_p, this.field_70165_t, this.field_70163_u + this.field_70131_O * 0.5D, this.field_70161_v, 0.5F, 5, 65280, 0, new net.minecraft.util.Vec3(0.5D + stonePos
/* 224 */                 .func_177958_n(), 1 + stonePos.func_177956_o(), 0.5D + stonePos.func_177952_p()), 0.1F, 16.0D);
/* 225 */               conversions++;
/* 226 */               if (this.destablizationTicks >= 10) {
/* 227 */                 this.field_70170_p.func_175656_a(stonePos, 
/* 228 */                   Get.blocks().SOUL_CAGE.func_176223_P().func_177226_a(emoniph.intangible.blocks.BlockSoulCage.VARIANT, 
/* 229 */                   emoniph.intangible.souls.EnumSoulType.fromSoulType(Get.souls().getSoulForSoul(this))));
/* 230 */                 Get.fx().GLOW.sendToAllNear(this.field_70170_p, stonePos.func_177984_a(), 0.5F, 5, -1);
/*     */               }
/*     */             }
/*     */           }
/* 234 */           if (conversions == 0) {
/* 235 */             this.destablizationTicks = 1;
/* 236 */           } else if (this.destablizationTicks >= 10) {
/* 237 */             this.field_70170_p.func_72900_e(this);
/*     */           }
/*     */         } else {
/* 240 */           this.destablizationTicks = 0;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70106_y()
/*     */   {
/* 248 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource cause)
/*     */   {
/* 253 */     super.func_70645_a(cause);
/*     */   }
/*     */   
/*     */   protected boolean func_70085_c(EntityPlayer playerIn)
/*     */   {
/* 258 */     if ((getSoulLeashed()) && (getSoulLeashedToEntity() == playerIn)) {
/* 259 */       clearSoulLeashed(true, false);
/* 260 */       return true;
/*     */     }
/* 262 */     ItemStack itemstack = playerIn.field_71071_by.func_70448_g();
/*     */     
/* 264 */     if ((itemstack != null) && (itemstack.func_77973_b() == Get.items().SOUL_LEASH)) {
/* 265 */       setSoulLeashedToEntity(playerIn, true);
/* 266 */       itemstack.field_77994_a -= 1;
/* 267 */       return true;
/*     */     }
/*     */     
/* 270 */     return super.func_70085_c(playerIn);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void updateSoulLeashState()
/*     */   {
/* 278 */     if (this.leashSoulNBTTag != null) {
/* 279 */       recreateSoulLeash();
/*     */     }
/*     */     
/* 282 */     if (this.isSoulLeashed) {
/* 283 */       if (!func_70089_S()) {
/* 284 */         clearSoulLeashed(true, false);
/*     */       }
/*     */       
/* 287 */       if ((this.leashedSoulToEntity == null) || (this.leashedSoulToEntity.field_70128_L)) {
/* 288 */         clearSoulLeashed(true, false);
/*     */       }
/*     */     }
/*     */     
/* 292 */     if ((getSoulLeashed()) && (getSoulLeashedToEntity() != null) && (getSoulLeashedToEntity().field_70170_p == this.field_70170_p)) {
/* 293 */       Entity entity = getSoulLeashedToEntity();
/*     */       
/* 295 */       func_175449_a(new BlockPos((int)entity.field_70165_t, (int)entity.field_70163_u, (int)entity.field_70161_v), 5);
/* 296 */       float f = func_70032_d(entity);
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
/* 308 */       if (!this.field_110180_bt) {
/* 309 */         this.field_70714_bg.func_75776_a(2, this.aiBase);
/*     */         
/* 311 */         if ((func_70661_as() instanceof PathNavigateGround)) {
/* 312 */           ((PathNavigateGround)func_70661_as()).func_179690_a(false);
/*     */         }
/*     */         
/* 315 */         this.field_110180_bt = true;
/*     */       }
/*     */       
/* 318 */       func_142017_o(f);
/*     */       
/* 320 */       if (f > 4.0F) {
/* 321 */         func_70661_as().func_75497_a(entity, 1.0D);
/*     */       }
/*     */       
/* 324 */       if (f > 6.0F) {
/* 325 */         double d0 = (entity.field_70165_t - this.field_70165_t) / f;
/* 326 */         double d1 = (entity.field_70163_u - this.field_70163_u) / f;
/* 327 */         double d2 = (entity.field_70161_v - this.field_70161_v) / f;
/* 328 */         this.field_70159_w += d0 * Math.abs(d0) * 0.4D;
/* 329 */         this.field_70181_x += d1 * Math.abs(d1) * 0.4D;
/* 330 */         this.field_70179_y += d2 * Math.abs(d2) * 0.4D;
/*     */       }
/*     */       
/* 333 */       if (f > 10.0F) {
/* 334 */         clearSoulLeashed(true, false);
/*     */       }
/* 336 */     } else if ((!getSoulLeashed()) && (this.field_110180_bt)) {
/* 337 */       this.field_110180_bt = false;
/* 338 */       this.field_70714_bg.func_85156_a(this.aiBase);
/*     */       
/* 340 */       if ((func_70661_as() instanceof PathNavigateGround)) {
/* 341 */         ((PathNavigateGround)func_70661_as()).func_179690_a(true);
/*     */       }
/*     */       
/* 344 */       func_110177_bN();
/*     */     }
/*     */   }
/*     */   
/*     */   public void clearSoulLeashed(boolean p_110160_1_, boolean p_110160_2_) {
/* 349 */     if (this.isSoulLeashed) {
/* 350 */       this.isSoulLeashed = false;
/* 351 */       this.leashedSoulToEntity = null;
/*     */       
/* 353 */       if ((!this.field_70170_p.field_72995_K) && (p_110160_2_)) {
/* 354 */         func_145779_a(Get.items().SOUL_LEASH, 1);
/*     */       }
/*     */       
/* 357 */       if ((!this.field_70170_p.field_72995_K) && (p_110160_1_) && ((this.field_70170_p instanceof WorldServer)))
/*     */       {
/* 359 */         Get.pipeline().sendToAll(new PlayerEx.PacketAttach(1, this, (Entity)null));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean getSoulLeashed()
/*     */   {
/* 366 */     return this.isSoulLeashed;
/*     */   }
/*     */   
/*     */   public Entity getSoulLeashedToEntity() {
/* 370 */     return this.leashedSoulToEntity;
/*     */   }
/*     */   
/*     */   public void setSoulLeashedToEntity(Entity entityIn, boolean sendAttachNotification) {
/* 374 */     this.isSoulLeashed = true;
/* 375 */     this.leashedSoulToEntity = entityIn;
/*     */     
/* 377 */     if ((!this.field_70170_p.field_72995_K) && (sendAttachNotification) && ((this.field_70170_p instanceof WorldServer)))
/*     */     {
/*     */ 
/* 380 */       Get.pipeline().sendToAll(new PlayerEx.PacketAttach(1, this, this.leashedSoulToEntity));
/*     */     }
/*     */   }
/*     */   
/*     */   private void recreateSoulLeash() {
/* 385 */     if ((this.isSoulLeashed) && (this.leashSoulNBTTag != null)) {
/* 386 */       if ((this.leashSoulNBTTag.func_150297_b("UUIDMost", 4)) && (this.leashSoulNBTTag.func_150297_b("UUIDLeast", 4))) {
/* 387 */         UUID uuid = new UUID(this.leashSoulNBTTag.func_74763_f("UUIDMost"), this.leashSoulNBTTag.func_74763_f("UUIDLeast"));
/* 388 */         List list = this.field_70170_p.func_72872_a(EntityLivingBase.class, func_174813_aQ().func_72314_b(10.0D, 10.0D, 10.0D));
/* 389 */         Iterator iterator = list.iterator();
/*     */         
/* 391 */         while (iterator.hasNext()) {
/* 392 */           EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
/*     */           
/* 394 */           if (entitylivingbase.func_110124_au().equals(uuid)) {
/* 395 */             this.leashedSoulToEntity = entitylivingbase;
/* 396 */             Get.pipeline().sendToAll(new PlayerEx.PacketAttach(1, this, this.leashedSoulToEntity));
/* 397 */             break;
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/*     */ 
/* 414 */         clearSoulLeashed(false, false);
/*     */       }
/*     */     }
/*     */     
/* 418 */     this.leashSoulNBTTag = null;
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 423 */     super.func_70014_b(compound);
/* 424 */     compound.func_74778_a("entityType", getEntityType());
/* 425 */     compound.func_74776_a("proxyWidth", this.field_70130_N);
/* 426 */     compound.func_74776_a("proxyHeight", this.field_70131_O);
/*     */     
/* 428 */     compound.func_74757_a("SoulLeashed", this.isSoulLeashed);
/*     */     
/* 430 */     if (this.leashedSoulToEntity != null) {
/* 431 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */       
/* 433 */       if ((this.leashedSoulToEntity instanceof EntityLivingBase)) {
/* 434 */         nbttagcompound1.func_74772_a("UUIDMost", this.leashedSoulToEntity.func_110124_au().getMostSignificantBits());
/* 435 */         nbttagcompound1.func_74772_a("UUIDLeast", this.leashedSoulToEntity.func_110124_au().getLeastSignificantBits());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 445 */       compound.func_74782_a("SoulLeash", nbttagcompound1);
/*     */     }
/*     */     
/* 448 */     NBTTagList list = new NBTTagList();
/* 449 */     for (Long relay : this.visitedRelays) {
/* 450 */       list.func_74742_a(new NBTTagLong(relay.longValue()));
/*     */     }
/* 452 */     compound.func_74782_a("relays", list);
/*     */     
/* 454 */     compound.func_74768_a("ticksSinceRelayUpdate", this.ticksSinceRelayUpdate);
/* 455 */     compound.func_74768_a("destablizationTicks", this.destablizationTicks);
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound) {
/* 459 */     super.func_70037_a(compound);
/* 460 */     if (compound.func_150297_b("entityType", 8)) {
/* 461 */       setEntityType(compound.func_74779_i("entityType"));
/*     */     }
/*     */     
/* 464 */     if ((compound.func_150297_b("proxyWidth", 5)) && (compound.func_150297_b("proxyHeight", 5))) {
/* 465 */       func_70105_a(compound.func_74760_g("proxyWidth"), compound.func_74760_g("proxyHeight"));
/*     */     }
/*     */     
/* 468 */     this.isSoulLeashed = compound.func_74767_n("SoulLeashed");
/*     */     
/* 470 */     if ((this.isSoulLeashed) && (compound.func_150297_b("SoulLeash", 10))) {
/* 471 */       this.leashSoulNBTTag = compound.func_74775_l("SoulLeash");
/*     */     }
/*     */     
/* 474 */     this.visitedRelays.clear();
/* 475 */     if (compound.func_150297_b("relays", 9)) {
/* 476 */       NBTTagList list = compound.func_150295_c("relays", 4);
/* 477 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 478 */         long value = ((NBTTagLong)list.func_179238_g(i)).func_150291_c();
/* 479 */         this.visitedRelays.add(Long.valueOf(value));
/*     */       }
/*     */     }
/*     */     
/* 483 */     this.ticksSinceRelayUpdate = compound.func_74762_e("ticksSinceRelayUpdate");
/* 484 */     this.destablizationTicks = compound.func_74762_e("destablizationTicks");
/*     */   }
/*     */   
/*     */   public int func_70627_aG() {
/* 488 */     return getProxyEntity().func_70627_aG();
/*     */   }
/*     */   
/*     */   protected boolean func_70692_ba() {
/* 492 */     return false;
/*     */   }
/*     */   
/*     */   protected String func_70639_aQ() {
/* 496 */     return null;
/*     */   }
/*     */   
/*     */   public void func_70642_aH()
/*     */   {
/* 501 */     getProxyEntity().func_70642_aH();
/*     */   }
/*     */   
/*     */   protected String func_70621_aR() {
/* 505 */     return null;
/*     */   }
/*     */   
/*     */   protected String func_70673_aS() {
/* 509 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_180429_a(BlockPos p_180429_1_, Block p_180429_2_) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_180430_e(float distance, float damageMultiplier) {}
/*     */   
/*     */ 
/*     */   public void func_70110_aj() {}
/*     */   
/*     */ 
/*     */   protected int func_70682_h(int air)
/*     */   {
/* 526 */     return air;
/*     */   }
/*     */   
/*     */ 
/*     */   private EntityLiving getProxyEntity()
/*     */   {
/* 532 */     if ((this.proxyEntity == null) || (this.proxyEntity.field_70170_p != this.field_70170_p)) {
/* 533 */       if (getEntityType().isEmpty()) {
/* 534 */         this.proxyEntity = ((EntityLiving)EntityList.func_75620_a("Squid", this.field_70170_p));
/* 535 */       } else if ((!Get.souls().isEntityRegistered((Class)EntityList.field_75625_b.get(getEntityType()))) && (EntityVillager.class.isAssignableFrom((Class)EntityList.field_75625_b.get(getEntityType())))) {
/* 536 */         this.proxyEntity = new EntityVillager(this.field_70170_p);
/*     */       } else {
/* 538 */         this.proxyEntity = ((EntityLiving)EntityList.func_75620_a(getEntityType(), this.field_70170_p));
/*     */       }
/*     */     }
/* 541 */     return this.proxyEntity;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public EntityLiving getProxyEntityWithSync() {
/* 546 */     EntityLiving proxyEntity = getProxyEntity();
/*     */     
/* 548 */     proxyEntity.func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     
/* 550 */     proxyEntity.field_70142_S = this.field_70142_S;
/* 551 */     proxyEntity.field_70137_T = this.field_70137_T;
/* 552 */     proxyEntity.field_70136_U = this.field_70136_U;
/*     */     
/* 554 */     proxyEntity.field_70159_w = this.field_70159_w;
/* 555 */     proxyEntity.field_70181_x = this.field_70181_x;
/* 556 */     proxyEntity.field_70179_y = this.field_70179_y;
/*     */     
/* 558 */     proxyEntity.field_70122_E = this.field_70122_E;
/*     */     
/* 560 */     proxyEntity.field_70169_q = this.field_70169_q;
/* 561 */     proxyEntity.field_70167_r = this.field_70167_r;
/* 562 */     proxyEntity.field_70166_s = this.field_70166_s;
/*     */     
/* 564 */     proxyEntity.field_70125_A = this.field_70125_A;
/* 565 */     proxyEntity.field_70177_z = this.field_70177_z;
/* 566 */     proxyEntity.field_70759_as = this.field_70759_as;
/*     */     
/* 568 */     proxyEntity.field_70127_C = this.field_70127_C;
/* 569 */     proxyEntity.field_70126_B = this.field_70126_B;
/* 570 */     proxyEntity.field_70758_at = this.field_70758_at;
/*     */     
/* 572 */     proxyEntity.field_70754_ba = this.field_70754_ba;
/*     */     
/* 574 */     proxyEntity.field_70721_aZ = this.field_70721_aZ;
/* 575 */     proxyEntity.field_70722_aY = this.field_70722_aY;
/* 576 */     proxyEntity.field_82175_bq = this.field_82175_bq;
/*     */     
/* 578 */     proxyEntity.field_70733_aJ = this.field_70733_aJ;
/* 579 */     proxyEntity.field_70732_aI = this.field_70732_aI;
/*     */     
/* 581 */     proxyEntity.field_70761_aq = this.field_70761_aq;
/* 582 */     proxyEntity.field_70760_ar = this.field_70760_ar;
/*     */     
/* 584 */     proxyEntity.field_70173_aa = this.field_70173_aa;
/* 585 */     proxyEntity.field_70128_L = false;
/* 586 */     proxyEntity.field_70160_al = this.field_70160_al;
/*     */     
/* 588 */     proxyEntity.func_70095_a(func_70093_af());
/* 589 */     proxyEntity.func_70031_b(func_70051_ag());
/* 590 */     proxyEntity.func_82142_c(func_82150_aj());
/*     */     
/* 592 */     return proxyEntity;
/*     */   }
/*     */   
/*     */ 
/* 596 */   private final Set<Long> visitedRelays = new java.util.HashSet();
/*     */   
/*     */   public void visited(BlockPos pos) {
/* 599 */     this.visitedRelays.add(Long.valueOf(pos.func_177986_g()));
/* 600 */     this.ticksSinceRelayUpdate = 600;
/*     */   }
/*     */   
/*     */   public boolean isVisited(BlockPos pos) {
/* 604 */     return this.visitedRelays.contains(Long.valueOf(pos.func_177986_g()));
/*     */   }
/*     */   
/*     */   public Set<Long> getVisitedRelays() {
/* 608 */     return this.visitedRelays;
/*     */   }
/*     */   
/*     */   public boolean canBePossessedBy(EntityPlayer player)
/*     */   {
/* 613 */     return false;
/*     */   }
/*     */   
/*     */   public boolean onAttackAction(EntityPlayer player, BlockPos targetPos)
/*     */   {
/* 618 */     return false;
/*     */   }
/*     */   
/*     */   public boolean onUseAction(EntityPlayer player, BlockPos targetPos)
/*     */   {
/* 623 */     return false;
/*     */   }
/*     */   
/*     */   public boolean allowFirstPersonRender()
/*     */   {
/* 628 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onJumpKey(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void possessBy(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */   public static boolean isSoul(EntityLivingBase entity)
/*     */   {
/* 642 */     return (entity != null) && (entity.getClass() == EntitySoul.class);
/*     */   }
/*     */   
/*     */   public SoulType getSoulType()
/*     */   {
/* 647 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isTrappableInBoneCage()
/*     */   {
/* 652 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorporeal()
/*     */   {
/* 657 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySoul.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */