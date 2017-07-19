/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.api.deity.IDeityConstraint;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class PlayerWorshipTracker implements IPlayerWorship
/*     */ {
/*     */   private PlayerEx playerEx;
/*     */   
/*     */   private PlayerWorshipTracker() {}
/*     */   
/*     */   public PlayerWorshipTracker(PlayerEx playerEx)
/*     */   {
/*  29 */     this.playerEx = playerEx;
/*     */   }
/*     */   
/*     */   public void setPlayer(PlayerEx player) {
/*  33 */     this.playerEx = player;
/*     */   }
/*     */   
/*     */   private static class Worship
/*     */   {
/*     */     private final UUID deityId;
/*     */     private long lastWorshipTime;
/*     */     private long lastGiftTime;
/*     */     private long count;
/*     */     
/*     */     private Worship(World world, IDeity deity)
/*     */     {
/*  45 */       this.deityId = deity.getId();
/*     */     }
/*     */     
/*     */     private Worship(UUID deityId) {
/*  49 */       this.deityId = deityId;
/*     */     }
/*     */     
/*     */     private NBTTagCompound getTagCompound() {
/*  53 */       NBTTagCompound compound = new NBTTagCompound();
/*  54 */       compound.func_74778_a("id", this.deityId.toString());
/*  55 */       compound.func_74772_a("lastTime", this.lastWorshipTime);
/*  56 */       compound.func_74772_a("lastGiftTime", this.lastGiftTime);
/*  57 */       compound.func_74772_a("count", this.count);
/*  58 */       return compound;
/*     */     }
/*     */     
/*     */     private static Worship fromTagCompound(NBTTagCompound compound) {
/*  62 */       Worship worship = new Worship(UUID.fromString(compound.func_74779_i("id")));
/*  63 */       worship.lastWorshipTime = compound.func_74763_f("lastTime");
/*  64 */       worship.lastGiftTime = compound.func_74763_f("lastGiftTime");
/*  65 */       worship.count = compound.func_74763_f("count");
/*  66 */       return worship;
/*     */     }
/*     */   }
/*     */   
/*  70 */   private Map<UUID, Worship> worshipMap = new java.util.HashMap();
/*     */   private UUID devoutDeityId;
/*     */   private static final int RECENT_WORSHIP_PERIOD = 96000;
/*     */   private static final int OTHER_RECENT_WORSHIP_PERIOD = 48000;
/*     */   private static final int MIN_DEVOUT_WORSHIPS = 5;
/*     */   
/*     */   public static enum WorshipResult {
/*  77 */     FAIL,  WORSHIP_INCREASE,  WORSHIP_DEVOUT_CHANGED;
/*     */     private WorshipResult() {} }
/*  79 */   final int WORSHIP_COOLDOWN = 12000;
/*     */   
/*  81 */   private final int MAX_WORSHIP = 100;
/*     */   private static final int MIN_WORSHIP_TO_TRIBGGER_CONSTRAINT = 2;
/*     */   
/*     */   public WorshipResult tryWorship(World world, Deity deityToWorship, EntityPlayer player, long totalPlayerTicks, long shrineWorshipLevel)
/*     */   {
/*  86 */     long mostRecentWorshipTime = Long.MIN_VALUE;
/*  87 */     boolean deityWorshippedRecently = false;
/*  88 */     boolean otherDeityWorshippedRecently = false;
/*  89 */     for (IDeity deity : Get.deities().forWorld(world)) {
/*  90 */       Worship worship = (Worship)this.worshipMap.get(deity.getId());
/*  91 */       if (worship != null) {
/*  92 */         if (worship.lastWorshipTime > mostRecentWorshipTime) {
/*  93 */           mostRecentWorshipTime = worship.lastWorshipTime;
/*     */         }
/*     */         
/*  96 */         if ((totalPlayerTicks < worship.lastWorshipTime + 96000L) && 
/*  97 */           (deity.equals(deityToWorship))) {
/*  98 */           deityWorshippedRecently = true;
/*     */         }
/*     */         
/*     */ 
/* 102 */         if ((totalPlayerTicks < worship.lastWorshipTime + 48000L) && 
/* 103 */           (!deity.equals(deityToWorship))) {
/* 104 */           otherDeityWorshippedRecently = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 110 */     WorshipResult result = WorshipResult.FAIL;
/* 111 */     if ((totalPlayerTicks > mostRecentWorshipTime + 12000L) || (player.field_71075_bZ.field_75098_d)) {
/* 112 */       result = WorshipResult.WORSHIP_INCREASE;
/*     */       
/* 114 */       Worship worship = (Worship)this.worshipMap.get(deityToWorship.getId());
/* 115 */       if (worship == null) {
/* 116 */         worship = new Worship(world, deityToWorship, null);
/* 117 */         this.worshipMap.put(deityToWorship.getId(), worship);
/*     */       }
/*     */       
/* 120 */       worship.lastWorshipTime = totalPlayerTicks;
/* 121 */       if (worship.count < 100L) {
/* 122 */         Worship.access$204(worship);
/*     */       }
/*     */       
/* 125 */       boolean devout = (deityWorshippedRecently) && (!otherDeityWorshippedRecently) && ((this.devoutDeityId != null) || (worship.count >= 5L));
/* 126 */       if (devout) {
/* 127 */         if ((this.devoutDeityId == null) || (!this.devoutDeityId.equals(deityToWorship.getId()))) {
/* 128 */           this.devoutDeityId = deityToWorship.getId();
/* 129 */           result = WorshipResult.WORSHIP_DEVOUT_CHANGED;
/*     */         }
/*     */       }
/* 132 */       else if (this.devoutDeityId != null) {
/* 133 */         this.devoutDeityId = null;
/* 134 */         result = WorshipResult.WORSHIP_DEVOUT_CHANGED;
/*     */       }
/*     */       
/* 137 */       deityToWorship.worshipBy(world, player, devout, shrineWorshipLevel);
/*     */     }
/*     */     
/* 140 */     return result;
/*     */   }
/*     */   
/*     */   public boolean isMostWorshippedDeity(World world, IDeity deity)
/*     */   {
/* 145 */     return isMostWorshippedDeity(world, deity.getId());
/*     */   }
/*     */   
/*     */   public boolean isMostWorshippedDeity(World world, UUID deityId)
/*     */   {
/* 150 */     if (deityId == null) {
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     long topWorship = 0L;
/* 155 */     long requiredWorship = 0L;
/* 156 */     for (Worship worship : this.worshipMap.values()) {
/* 157 */       if (isWorshipRecentEnough(world, worship)) {
/* 158 */         if (worship.count > topWorship) {
/* 159 */           topWorship = worship.count;
/*     */         }
/* 161 */         if (deityId.equals(worship.deityId)) {
/* 162 */           requiredWorship = worship.count;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 167 */     return requiredWorship == topWorship;
/*     */   }
/*     */   
/*     */   public boolean tryReduceWorship(World world, UUID deityId, long quantity, boolean loseDevoutStatus) {
/* 171 */     boolean changed = false;
/* 172 */     Worship worship = (Worship)this.worshipMap.get(deityId);
/* 173 */     if ((worship != null) && (worship.count >= quantity)) {
/* 174 */       Worship localWorship1 = worship;localWorship1.count = (localWorship1.count - quantity);
/* 175 */       changed = true;
/*     */     }
/*     */     
/* 178 */     if ((loseDevoutStatus) && (this.devoutDeityId != null) && (this.devoutDeityId.equals(deityId))) {
/* 179 */       this.devoutDeityId = null;
/* 180 */       changed = true;
/*     */     }
/*     */     
/* 183 */     return changed;
/*     */   }
/*     */   
/*     */   private boolean isWorshipRecentEnough(World world, Worship worship) {
/* 187 */     return worship.lastWorshipTime + 96000L > this.playerEx.getTotalTicks();
/*     */   }
/*     */   
/*     */   public boolean isWorshipEqualOrGreaterThan(World world, IDeity deity, int quantity)
/*     */   {
/* 192 */     Worship worship = (Worship)this.worshipMap.get(deity.getId());
/* 193 */     return (worship != null) && (worship.count >= quantity);
/*     */   }
/*     */   
/*     */   public int getFollowerLevelOf(World world, IDeity deity)
/*     */   {
/* 198 */     return getFollowerLevelOf(world, deity.getId());
/*     */   }
/*     */   
/*     */   public int getFollowerLevelOf(World world, UUID deity)
/*     */   {
/* 203 */     if (isDevoutFollowerOf(world, deity))
/* 204 */       return 3;
/* 205 */     if (isFollowerOf(world, deity)) {
/* 206 */       if (isMostWorshippedDeity(world, deity)) {
/* 207 */         return 2;
/*     */       }
/* 209 */       return 1;
/*     */     }
/*     */     
/* 212 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isFollowerOf(World world, IDeity deity)
/*     */   {
/* 218 */     return isFollowerOf(world, deity.getId());
/*     */   }
/*     */   
/*     */   public boolean isFollowerOf(World world, UUID deityId)
/*     */   {
/* 223 */     Worship worship = (Worship)this.worshipMap.get(deityId);
/* 224 */     return (worship != null) && (worship.count > 0L) && (isWorshipRecentEnough(world, worship));
/*     */   }
/*     */   
/*     */   public boolean isDevoutFollowerOf(World world, IDeity deity)
/*     */   {
/* 229 */     return isDevoutFollowerOf(world, deity.getId());
/*     */   }
/*     */   
/*     */   public boolean isDevoutFollowerOf(World world, UUID deityId)
/*     */   {
/* 234 */     return (this.devoutDeityId != null) && (deityId != null) && (deityId.equals(this.devoutDeityId));
/*     */   }
/*     */   
/*     */   public UUID getDevoutDeityId(World world)
/*     */   {
/* 239 */     return this.devoutDeityId;
/*     */   }
/*     */   
/*     */   public long getWorshipFor(World world, IDeity deity)
/*     */   {
/* 244 */     if (deity != null) {
/* 245 */       return getWorshipFor(world, deity.getId());
/*     */     }
/*     */     
/* 248 */     return 0L;
/*     */   }
/*     */   
/*     */   public long getWorshipFor(World world, UUID deityId)
/*     */   {
/* 253 */     if (deityId != null) {
/* 254 */       Worship worship = (Worship)this.worshipMap.get(deityId);
/* 255 */       if (worship != null) {
/* 256 */         return worship.count;
/*     */       }
/*     */     }
/*     */     
/* 260 */     return 0L;
/*     */   }
/*     */   
/*     */   public long getLastGiftTime(World world, UUID deityId)
/*     */   {
/* 265 */     Worship worship = (Worship)this.worshipMap.get(deityId);
/* 266 */     if (worship != null) {
/* 267 */       return worship.lastGiftTime;
/*     */     }
/* 269 */     return 0L;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onWorshipTick(EntityPlayer player, long totalPlayerTicks)
/*     */   {
/* 276 */     boolean changed = false;
/* 277 */     if (player.field_70173_aa % 100 == 0) {
/* 278 */       for (Worship worship : this.worshipMap.values()) {
/* 279 */         boolean devout = (this.devoutDeityId != null) && (this.devoutDeityId.equals(worship.deityId));
/* 280 */         if ((worship.count >= 2L) || (devout)) {
/* 281 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(worship.deityId);
/* 282 */           if (deity != null) {
/* 283 */             long reduction = deity.getConstraint().getWorshipReductionAfterTick(player, deity, totalPlayerTicks, worship.lastWorshipTime);
/* 284 */             if (reduction > 0L) {
/* 285 */               if (worship.count > 0L) {
/* 286 */                 worship.count = Math.max(worship.count - reduction, 0L);
/* 287 */                 changed = true;
/*     */               }
/* 289 */               if (devout) {
/* 290 */                 this.devoutDeityId = null;
/* 291 */                 changed = true;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 298 */     return changed;
/*     */   }
/*     */   
/*     */   public boolean onAttack(World world, EntityPlayer player, EntityLivingBase entity, boolean isDead, long totalPlayerTicks)
/*     */   {
/* 303 */     boolean changed = false;
/* 304 */     for (Worship worship : this.worshipMap.values()) {
/* 305 */       boolean devout = (this.devoutDeityId != null) && (this.devoutDeityId.equals(worship.deityId));
/* 306 */       if ((worship.count >= 2L) || (devout)) {
/* 307 */         Deity deity = Get.deities().forWorld(world).getDeityById(worship.deityId);
/* 308 */         if (deity != null) { long reduction;
/*     */           long reduction;
/* 310 */           if (isDead) {
/* 311 */             reduction = deity.getConstraint().getWorshipReductionAfterKill(player, deity, entity, totalPlayerTicks);
/*     */           } else {
/* 313 */             reduction = deity.getConstraint().getWorshipReductionAfterAttack(player, deity, entity, totalPlayerTicks);
/*     */           }
/* 315 */           if (reduction > 0L) {
/* 316 */             if (worship.count > 0L) {
/* 317 */               worship.count = Math.max(worship.count - reduction, 0L);
/* 318 */               changed = true;
/*     */             }
/* 320 */             if (devout) {
/* 321 */               this.devoutDeityId = null;
/* 322 */               changed = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 328 */     return changed;
/*     */   }
/*     */   
/*     */   public boolean onHarvest(World world, BlockPos pos, IBlockState state, java.util.List<ItemStack> drops, EntityPlayer player, long totalTicks) {
/* 332 */     boolean changed = false;
/* 333 */     for (Worship worship : this.worshipMap.values()) {
/* 334 */       boolean devout = (this.devoutDeityId != null) && (this.devoutDeityId.equals(worship.deityId));
/* 335 */       if ((worship.count >= 2L) || (devout)) {
/* 336 */         Deity deity = Get.deities().forWorld(world).getDeityById(worship.deityId);
/* 337 */         if (deity != null) {
/* 338 */           long reduction = deity.getConstraint().getWorshipReductionAfterHarvest(player, deity, world, pos, state, drops, totalTicks);
/* 339 */           if (reduction > 0L) {
/* 340 */             if (worship.count > 0L) {
/* 341 */               worship.count = Math.max(worship.count - reduction, 0L);
/* 342 */               changed = true;
/*     */             }
/* 344 */             if (devout) {
/* 345 */               this.devoutDeityId = null;
/* 346 */               changed = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 352 */     return changed;
/*     */   }
/*     */   
/*     */   public boolean onWorship(EntityPlayer player, IDeity worshippedDeity, long totalTicks) {
/* 356 */     boolean changed = false;
/* 357 */     for (Worship worship : this.worshipMap.values()) {
/* 358 */       boolean devout = (this.devoutDeityId != null) && (this.devoutDeityId.equals(worship.deityId));
/* 359 */       if ((worship.count >= 2L) || (devout)) {
/* 360 */         Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(worship.deityId);
/* 361 */         if (deity != null) {
/* 362 */           long reduction = deity.getConstraint().getWorshipReductionAfterWorshipping(player, deity, worshippedDeity, totalTicks);
/* 363 */           if (reduction > 0L) {
/* 364 */             if (worship.count > 0L) {
/* 365 */               worship.count = Math.max(worship.count - reduction, 0L);
/* 366 */               changed = true;
/*     */             }
/* 368 */             if (devout) {
/* 369 */               this.devoutDeityId = null;
/* 370 */               changed = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 376 */     return changed;
/*     */   }
/*     */   
/*     */   public void setLastGiftTime(World world, UUID deityId, long worldTimeTicks)
/*     */   {
/* 381 */     Worship worship = (Worship)this.worshipMap.get(deityId);
/* 382 */     if (worship == null) {
/* 383 */       worship = new Worship(deityId, null);
/* 384 */       this.worshipMap.put(deityId, worship);
/*     */     }
/* 386 */     worship.lastGiftTime = worldTimeTicks;
/*     */   }
/*     */   
/*     */   public NBTTagCompound getTagCompound() {
/* 390 */     NBTTagList list = new NBTTagList();
/* 391 */     for (Map.Entry<UUID, Worship> entry : this.worshipMap.entrySet()) {
/* 392 */       list.func_74742_a(((Worship)entry.getValue()).getTagCompound());
/*     */     }
/*     */     
/* 395 */     NBTTagCompound compound = new NBTTagCompound();
/* 396 */     compound.func_74782_a("list", list);
/* 397 */     if (this.devoutDeityId != null) {
/* 398 */       compound.func_74778_a("devout", this.devoutDeityId.toString());
/*     */     }
/* 400 */     return compound;
/*     */   }
/*     */   
/*     */   public static PlayerWorshipTracker fromTagCompound(NBTTagCompound compound, PlayerEx playerEx) {
/* 404 */     PlayerWorshipTracker tracker = new PlayerWorshipTracker(playerEx);
/* 405 */     NBTTagList list = compound.func_150295_c("list", 10);
/* 406 */     int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 407 */       NBTTagCompound item = list.func_150305_b(i);
/* 408 */       Worship worship = Worship.fromTagCompound(item);
/* 409 */       tracker.worshipMap.put(worship.deityId, worship);
/*     */     }
/* 411 */     if (compound.func_150297_b("devout", 8)) {
/* 412 */       tracker.devoutDeityId = UUID.fromString(compound.func_74779_i("devout"));
/*     */     }
/* 414 */     return tracker;
/*     */   }
/*     */   
/*     */   public static PlayerWorshipTracker readFrom(ByteBuf buf) {
/* 418 */     PlayerWorshipTracker tracker = new PlayerWorshipTracker();
/* 419 */     long msb = buf.readLong();
/* 420 */     long lsb = buf.readLong();
/* 421 */     if (lsb != 0L) {
/* 422 */       tracker.devoutDeityId = new UUID(msb, lsb);
/*     */     } else {
/* 424 */       tracker.devoutDeityId = null;
/*     */     }
/*     */     
/* 427 */     int count = buf.readInt();
/* 428 */     for (int i = 0; i < count; i++) {
/* 429 */       long msid = buf.readLong();
/* 430 */       long lsid = buf.readLong();
/* 431 */       Worship worship = new Worship(new UUID(msid, lsid), null);
/* 432 */       worship.count = buf.readLong();
/* 433 */       tracker.worshipMap.put(worship.deityId, worship);
/*     */     }
/*     */     
/* 436 */     return tracker;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf) {
/* 440 */     if (this.devoutDeityId != null) {
/* 441 */       buf.writeLong(this.devoutDeityId.getMostSignificantBits());
/* 442 */       buf.writeLong(this.devoutDeityId.getLeastSignificantBits());
/*     */     } else {
/* 444 */       buf.writeLong(0L);
/* 445 */       buf.writeLong(0L);
/*     */     }
/* 447 */     Set<Map.Entry<UUID, Worship>> entries = this.worshipMap.entrySet();
/* 448 */     buf.writeInt(entries.size());
/* 449 */     for (Map.Entry<UUID, Worship> entry : entries) {
/* 450 */       buf.writeLong(((UUID)entry.getKey()).getMostSignificantBits());
/* 451 */       buf.writeLong(((UUID)entry.getKey()).getLeastSignificantBits());
/* 452 */       buf.writeLong(((Worship)entry.getValue()).count);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/PlayerWorshipTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */