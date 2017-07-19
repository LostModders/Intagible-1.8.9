/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarPower;
/*     */ import emoniph.intangible.api.deity.IDeityConstraint;
/*     */ import emoniph.intangible.api.deity.IDeityMajorWorldEffect;
/*     */ import emoniph.intangible.api.deity.IDeityMinorWorldEffect;
/*     */ import emoniph.intangible.api.deity.IDeityShrineEffect;
/*     */ import emoniph.intangible.api.deity.IDeityVoice;
/*     */ import emoniph.intangible.api.deity.IDeityWorshipEffect;
/*     */ import emoniph.intangible.api.deity.IDeityWorshipRestriction;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import emoniph.intangible.util.TickUtil;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumDyeColor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.play.server.S29PacketSoundEffect;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ 
/*     */ public class Deity implements IDeity
/*     */ {
/*     */   private final UUID id;
/*     */   private final int dimension;
/*     */   private String name;
/*     */   private HeadSpec head;
/*     */   private ItemStack sacredItemA;
/*     */   private ItemStack sacredItemB;
/*     */   private ItemStack sacredItemC;
/*     */   private int color;
/*     */   private IDeityVoice voice;
/*     */   private IDeityConstraint constraint;
/*     */   private IDeityWorshipRestriction worshipRestrictionA;
/*     */   private IDeityWorshipRestriction worshipRestrictionB;
/*     */   private IDeityAvatarBody body;
/*     */   private IDeityAvatarPower avatarPower;
/*     */   private IDeityMinorWorldEffect minorEffect;
/*     */   private IDeityMajorWorldEffect majorEffect;
/*     */   private IDeityShrineEffect templeEffect;
/*     */   private IDeityWorshipEffect blessingEffect;
/*     */   private IDeityWorshipEffect curseEffect;
/*     */   private int worship;
/*     */   private int damage;
/*     */   private int immuneTicks;
/*     */   private int avatarCooldownTicks;
/*     */   private static final int MAX_HEALTH = 4;
/*     */   private static final int IMMUNE_TICKS_AFTER_DAMAGE = 60;
/*     */   private static final int MAX_AVATAR_COOLDOWN_TICKS = 2400;
/*     */   public static final int MINIMUM_MINOR_WORSHIP = 3;
/*     */   private static final long WORSHIP_THRESHOLD = 24000L;
/*     */   
/*     */   public static Deity createRandom(World world, BlockPos pos, ItemStack a, ItemStack b, ItemStack c)
/*     */   {
/*  62 */     Random r = world.field_73012_v;
/*  63 */     EnumDyeColor dye = EnumDyeColor.values()[r.nextInt(EnumDyeColor.values().length)];
/*  64 */     int myColor = net.minecraft.item.ItemDye.field_150922_c[net.minecraft.util.MathHelper.func_76125_a(dye.func_176767_b(), 0, net.minecraft.item.ItemDye.field_150922_c.length - 1)];
/*  65 */     HeadSpec head = HeadSpec.digitizeHead(world, pos, myColor, false);
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
/*  78 */     Deity deity = new Deity(world, head, myColor, (IDeityVoice)Get.deityEffects().voiceRegistry.getRandom(r), a, b, c, (IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getRandom(r), (IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getRandom(r), (IDeityAvatarBody)Get.deityEffects().bodyRegistry.getRandom(r), (IDeityAvatarPower)Get.deityEffects().avatarPowerRegistry.getRandom(r), (IDeityMinorWorldEffect)Get.deityEffects().worldMinorEffectRegistry.getRandom(r), (IDeityMajorWorldEffect)Get.deityEffects().worldMajorEffectRegistry.getRandom(r), (IDeityShrineEffect)Get.deityEffects().shrineEffectRegistry.getRandom(r), (IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getRandom(r), (IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getRandom(r), (IDeityConstraint)Get.deityEffects().constraintRegistry.getRandom(r));
/*     */     
/*  80 */     return deity;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Deity(World world, HeadSpec head, int color, IDeityVoice voice, ItemStack sacredItemA, ItemStack sacredItemB, ItemStack sacredItemC, IDeityWorshipRestriction worshipRestrictionA, IDeityWorshipRestriction worshipRestrictionB, IDeityAvatarBody avatarBody, IDeityAvatarPower avatarPower, IDeityMinorWorldEffect minorEffect, IDeityMajorWorldEffect majorEffect, IDeityShrineEffect templeEffect, IDeityWorshipEffect blessingEffect, IDeityWorshipEffect curseEffect, IDeityConstraint constraint)
/*     */   {
/*  90 */     this.id = Get.deities().createUniqueId(world);
/*  91 */     this.dimension = world.field_73011_w.func_177502_q();
/*  92 */     this.name = generateRandomDeityName(world.field_73012_v);
/*  93 */     this.voice = voice;
/*  94 */     this.color = color;
/*  95 */     this.body = Get.deityEffects().BODY_BIPED;
/*  96 */     this.head = head;
/*  97 */     this.constraint = constraint;
/*     */     
/*  99 */     this.sacredItemA = sacredItemA.func_77946_l();
/* 100 */     this.sacredItemA.field_77994_a = 1;
/* 101 */     this.sacredItemB = sacredItemB.func_77946_l();
/* 102 */     this.sacredItemB.field_77994_a = 1;
/* 103 */     this.sacredItemC = sacredItemC.func_77946_l();
/* 104 */     this.sacredItemC.field_77994_a = 1;
/*     */     
/* 106 */     this.worshipRestrictionA = worshipRestrictionA;
/* 107 */     this.worshipRestrictionB = worshipRestrictionB;
/*     */     
/* 109 */     this.avatarPower = avatarPower;
/* 110 */     this.body = avatarBody;
/*     */     
/* 112 */     this.minorEffect = minorEffect;
/* 113 */     this.majorEffect = majorEffect;
/*     */     
/* 115 */     this.templeEffect = templeEffect;
/*     */     
/* 117 */     this.blessingEffect = blessingEffect;
/* 118 */     this.curseEffect = curseEffect;
/*     */     
/* 120 */     this.worship = 3;
/* 121 */     this.damage = 0;
/* 122 */     this.immuneTicks = 0;
/* 123 */     this.avatarCooldownTicks = 0;
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
/*     */   public String toString()
/*     */   {
/* 142 */     return this.id.toString() + " " + this.name + " [" + this.sacredItemA.toString() + " " + this.sacredItemB.toString() + " " + this.sacredItemC.toString() + " " + Get.deityEffects().voiceRegistry.getIdForEffect(this.voice) + " " + Get.deityEffects().worshipRestrictionRegistry.getIdForEffect(this.worshipRestrictionA) + " " + Get.deityEffects().worshipRestrictionRegistry.getIdForEffect(this.worshipRestrictionB) + " " + Get.deityEffects().bodyRegistry.getIdForEffect(this.body) + " " + Get.deityEffects().avatarPowerRegistry.getIdForEffect(this.avatarPower) + " " + Get.deityEffects().worldMinorEffectRegistry.getIdForEffect(this.minorEffect) + " " + Get.deityEffects().worldMajorEffectRegistry.getIdForEffect(this.majorEffect) + " " + Get.deityEffects().shrineEffectRegistry.getIdForEffect(this.templeEffect) + " " + Get.deityEffects().worshipEffectRegistry.getIdForEffect(this.blessingEffect) + " " + Get.deityEffects().worshipEffectRegistry.getIdForEffect(this.curseEffect) + " " + Get.deityEffects().constraintRegistry.getIdForEffect(this.constraint) + "]";
/*     */   }
/*     */   
/*     */   private Deity(UUID id, int dimension, String name) {
/* 146 */     this.id = id;
/* 147 */     this.dimension = dimension;
/* 148 */     this.name = name;
/*     */   }
/*     */   
/*     */   NBTTagCompound toTagCompound() {
/* 152 */     NBTTagCompound compound = new NBTTagCompound();
/* 153 */     compound.func_74778_a("id", this.id.toString());
/* 154 */     compound.func_74768_a("dimension", this.dimension);
/* 155 */     compound.func_74778_a("name", this.name);
/*     */     
/* 157 */     compound.func_74768_a("color", this.color);
/* 158 */     compound.func_74782_a("head", this.head.toTagCompound());
/* 159 */     compound.func_74778_a("body", Get.deityEffects().bodyRegistry.getIdForEffect(this.body));
/* 160 */     compound.func_74768_a("worship", this.worship);
/* 161 */     compound.func_74768_a("damage", this.damage);
/* 162 */     compound.func_74768_a("immuneTicks", this.immuneTicks);
/* 163 */     compound.func_74768_a("avatarCooldownTicks", this.avatarCooldownTicks);
/*     */     
/* 165 */     compound.func_74778_a("voice", Get.deityEffects().voiceRegistry.getIdForEffect(this.voice));
/*     */     
/* 167 */     compound.func_74778_a("majorEffect", Get.deityEffects().worldMajorEffectRegistry.getIdForEffect(this.majorEffect));
/* 168 */     compound.func_74778_a("minorEffect", Get.deityEffects().worldMinorEffectRegistry.getIdForEffect(this.minorEffect));
/* 169 */     compound.func_74778_a("templeEffect", Get.deityEffects().shrineEffectRegistry.getIdForEffect(this.templeEffect));
/* 170 */     compound.func_74778_a("blessingEffect", Get.deityEffects().worshipEffectRegistry.getIdForEffect(this.blessingEffect));
/* 171 */     compound.func_74778_a("curseEffect", Get.deityEffects().worshipEffectRegistry.getIdForEffect(this.curseEffect));
/*     */     
/* 173 */     compound.func_74778_a("avatarPower", Get.deityEffects().avatarPowerRegistry.getIdForEffect(this.avatarPower));
/* 174 */     compound.func_74778_a("worshipRestrictionA", Get.deityEffects().worshipRestrictionRegistry.getIdForEffect(this.worshipRestrictionA));
/* 175 */     compound.func_74778_a("worshipRestrictionB", Get.deityEffects().worshipRestrictionRegistry.getIdForEffect(this.worshipRestrictionB));
/*     */     
/* 177 */     compound.func_74782_a("sacredItemA", this.sacredItemA.func_77955_b(new NBTTagCompound()));
/* 178 */     compound.func_74782_a("sacredItemB", this.sacredItemB.func_77955_b(new NBTTagCompound()));
/* 179 */     compound.func_74782_a("sacredItemC", this.sacredItemC.func_77955_b(new NBTTagCompound()));
/* 180 */     compound.func_74778_a("constraint", Get.deityEffects().constraintRegistry.getIdForEffect(this.constraint));
/*     */     
/* 182 */     compound.func_74772_a("lastWorshipTime", this.lastWorshipTime);
/*     */     
/* 184 */     return compound;
/*     */   }
/*     */   
/*     */   static Deity fromTagCompound(NBTTagCompound compound) {
/* 188 */     if ((compound.func_150297_b("id", 8)) && 
/* 189 */       (compound.func_150297_b("dimension", 3)) && 
/* 190 */       (compound.func_150297_b("name", 8)))
/*     */     {
/*     */ 
/*     */ 
/* 194 */       Deity deity = new Deity(UUID.fromString(compound.func_74779_i("id")), compound.func_74762_e("dimension"), compound.func_74779_i("name"));
/*     */       
/* 196 */       deity.worship = compound.func_74762_e("worship");
/* 197 */       deity.damage = compound.func_74762_e("damage");
/* 198 */       deity.immuneTicks = compound.func_74762_e("immuneTicks");
/* 199 */       deity.avatarCooldownTicks = compound.func_74762_e("avatarCooldownTicks");
/*     */       
/* 201 */       deity.color = compound.func_74762_e("color");
/*     */       
/* 203 */       deity.voice = ((IDeityVoice)Get.deityEffects().voiceRegistry.getEffectForId(compound.func_74779_i("voice")));
/*     */       
/*     */ 
/* 206 */       deity.head = HeadSpec.fromTagCompound(compound.func_74775_l("head"));
/* 207 */       deity.body = ((IDeityAvatarBody)Get.deityEffects().bodyRegistry.getEffectForId(compound.func_74779_i("body")));
/*     */       
/* 209 */       if (compound.func_74764_b("majorEffect")) {
/* 210 */         deity.majorEffect = ((IDeityMajorWorldEffect)Get.deityEffects().worldMajorEffectRegistry.getEffectForId(compound.func_74779_i("majorEffect")));
/*     */       } else {
/* 212 */         deity.majorEffect = ((IDeityMajorWorldEffect)Get.deityEffects().worldMajorEffectRegistry.getEffectForId(compound.func_74779_i("majorEffectA")));
/*     */       }
/*     */       
/*     */ 
/* 216 */       deity.minorEffect = ((IDeityMinorWorldEffect)Get.deityEffects().worldMinorEffectRegistry.getEffectForId(compound.func_74779_i("minorEffect")));
/*     */       
/*     */ 
/* 219 */       deity.blessingEffect = ((IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getEffectForId(compound.func_74779_i("blessingEffect")));
/*     */       
/*     */ 
/* 222 */       deity.curseEffect = ((IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getEffectForId(compound.func_74779_i("curseEffect")));
/*     */       
/*     */ 
/* 225 */       deity.templeEffect = ((IDeityShrineEffect)Get.deityEffects().shrineEffectRegistry.getEffectForId(compound.func_74779_i("templeEffect")));
/*     */       
/*     */ 
/* 228 */       deity.avatarPower = ((IDeityAvatarPower)Get.deityEffects().avatarPowerRegistry.getEffectForId(compound.func_74779_i("avatarPower")));
/*     */       
/*     */ 
/* 231 */       deity.worshipRestrictionA = ((IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getEffectForId(compound.func_74779_i("worshipRestrictionA")));
/* 232 */       deity.worshipRestrictionB = ((IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getEffectForId(compound.func_74779_i("worshipRestrictionB")));
/*     */       
/* 234 */       deity.sacredItemA = ItemStack.func_77949_a(compound.func_74775_l("sacredItemA"));
/* 235 */       deity.sacredItemB = ItemStack.func_77949_a(compound.func_74775_l("sacredItemB"));
/* 236 */       deity.sacredItemC = ItemStack.func_77949_a(compound.func_74775_l("sacredItemC"));
/*     */       
/* 238 */       if (compound.func_74764_b("constraint")) {
/* 239 */         deity.constraint = ((IDeityConstraint)Get.deityEffects().constraintRegistry.getEffectForId(compound.func_74779_i("constraint")));
/*     */       } else {
/* 241 */         deity.constraint = Get.deityEffects().CONSTRAINT_REGULAR_WORSHIP;
/*     */       }
/*     */       
/* 244 */       if (compound.func_150297_b("lastWorshipTime", 4)) {
/* 245 */         deity.lastWorshipTime = compound.func_74763_f("lastWorshipTime");
/*     */       } else {
/* 247 */         deity.lastWorshipTime = 0L;
/*     */       }
/*     */       
/* 250 */       return deity;
/*     */     }
/*     */     
/* 253 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public UUID getId()
/*     */   {
/* 259 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getName()
/*     */   {
/* 264 */     return this.name;
/*     */   }
/*     */   
/*     */   public World getWorld()
/*     */   {
/* 269 */     return net.minecraft.server.MinecraftServer.func_71276_C().field_71305_c[this.dimension];
/*     */   }
/*     */   
/*     */   public int getCurrentWorship()
/*     */   {
/* 274 */     return this.worship;
/*     */   }
/*     */   
/*     */   public int getColor() {
/* 278 */     return this.color;
/*     */   }
/*     */   
/*     */   public ItemStack getSacredItemA()
/*     */   {
/* 283 */     return this.sacredItemA;
/*     */   }
/*     */   
/*     */   public ItemStack getSacredItemB()
/*     */   {
/* 288 */     return this.sacredItemB;
/*     */   }
/*     */   
/*     */   public ItemStack getSacredItemC()
/*     */   {
/* 293 */     return this.sacredItemC;
/*     */   }
/*     */   
/*     */   public IDeityMajorWorldEffect getMajorEffect()
/*     */   {
/* 298 */     return this.majorEffect;
/*     */   }
/*     */   
/*     */   public IDeityShrineEffect getShrineEffect() {
/* 302 */     return this.templeEffect;
/*     */   }
/*     */   
/*     */   public IDeityWorshipEffect getBlessingEffect() {
/* 306 */     return this.blessingEffect;
/*     */   }
/*     */   
/*     */   public IDeityWorshipEffect getCurseEffect() {
/* 310 */     return this.curseEffect;
/*     */   }
/*     */   
/* 313 */   public IDeityConstraint getConstraint() { return this.constraint; }
/*     */   
/*     */   public void talkToWorld(World world, String messageId)
/*     */   {
/* 317 */     if ((world != null) && (!world.field_72995_K)) {
/* 318 */       for (Object playerObj : world.field_73010_i) {
/* 319 */         EntityPlayer player = (EntityPlayer)playerObj;
/* 320 */         Get.pipeline().sendTo(new S29PacketSoundEffect(this.voice.getSound(), player.field_70165_t, player.field_70163_u + player
/* 321 */           .func_70047_e(), player.field_70161_v, 0.7F, 1.0F), player);
/* 322 */         emoniph.intangible.util.ChatUtil.send(player, messageId, new Object[] { this.name });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void talkAt(EntityPlayer player) {
/* 328 */     if ((player != null) && (!player.field_70170_p.field_72995_K)) {
/* 329 */       player.field_70170_p.func_72956_a(player, this.voice.getSound(), 0.7F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void manifest(World world, double x, double y, double z, double rotation, double pitch) {}
/*     */   
/*     */ 
/*     */   public emoniph.intangible.api.deity.IAvatar summonAvatarAtPos(World world, double x, double y, double z)
/*     */   {
/* 340 */     if ((!world.field_72995_K) && 
/* 341 */       (this.avatarCooldownTicks == 0)) {
/* 342 */       EntityAvatar avatar = createAvatar(world);
/* 343 */       avatar.func_70012_b(x, y, z, 0.0F, 0.0F);
/* 344 */       avatar.func_180482_a(null, null);
/* 345 */       world.func_72838_d(avatar);
/* 346 */       return avatar;
/*     */     }
/*     */     
/*     */ 
/* 350 */     return null;
/*     */   }
/*     */   
/*     */   public EntityAvatar createAvatar(World world) {
/* 354 */     if (this.avatarCooldownTicks == 0) {
/* 355 */       EntityAvatar avatar = new EntityAvatar(world);
/* 356 */       avatar.setDeityId(this.id);
/* 357 */       avatar.setDeityColor(this.color);
/* 358 */       avatar.setDeityBodyIndex(Get.deityEffects().bodyRegistry.getIndexFromEffect(this.body));
/* 359 */       avatar.setAvatarPowerIndex(Get.deityEffects().avatarPowerRegistry.getIndexFromEffect(this.avatarPower));
/* 360 */       this.avatarCooldownTicks = 2400;
/* 361 */       return avatar;
/*     */     }
/* 363 */     return null;
/*     */   }
/*     */   
/*     */   public boolean attackDeity(World world, int damage)
/*     */   {
/* 368 */     if (this.immuneTicks > 20) {
/* 369 */       return false;
/*     */     }
/* 371 */     if (damage > 0) {
/* 372 */       talkToWorld(world, "entity.intangible.deity.damaged");
/* 373 */       this.damage += damage;
/*     */     }
/* 375 */     this.immuneTicks = 60;
/* 376 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void tick(World world, boolean majorPower)
/*     */   {
/* 386 */     if ((this.immuneTicks > 0) && 
/* 387 */       (--this.immuneTicks == 0)) {
/* 388 */       this.damage = 0;
/*     */     }
/*     */     
/*     */ 
/* 392 */     if (this.avatarCooldownTicks > 0) {
/* 393 */       this.avatarCooldownTicks -= 1;
/*     */     }
/*     */     
/* 396 */     boolean toDie = false;
/* 397 */     if ((world.func_82737_E() % 20L == 3L) && 
/* 398 */       (this.damage > 4) && 
/* 399 */       (!Get.shrines().isShrinesActiveFor(world, this))) {
/* 400 */       talkToWorld(world, "entity.intangible.deity.death");
/* 401 */       Get.deities().killDeity(world, this);
/* 402 */       toDie = true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 407 */     if (!toDie) {
/* 408 */       if (this.worship > 3) {
/* 409 */         this.minorEffect.onWorldTick(world, this);
/*     */       }
/*     */       
/* 412 */       if (majorPower) {
/* 413 */         this.majorEffect.onWorldTick(world, this);
/*     */       }
/*     */       
/* 416 */       if ((this.worship > 0) && (world.func_82737_E() > this.lastWorshipTime + 24000L) && 
/* 417 */         (world.func_82737_E() % TickUtil.fromSeconds(60) == 0L)) {
/* 418 */         this.worship = Math.max(this.worship - 1, 0);
/* 419 */         Get.deities().forWorld(world).func_76185_a();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void tickTempleEffect(World world, BlockPos pos, long worship)
/*     */   {
/* 428 */     this.templeEffect.onTick(world, pos, worship, this);
/*     */   }
/*     */   
/*     */   void rename(World world, String newName) {
/* 432 */     this.name = newName;
/*     */   }
/*     */   
/*     */   static String generateRandomDeityName(Random rand) {
/* 436 */     String[] DICT_A = { "b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 437 */     String[] DICT_B = { "a", "e", "u", "i", "o", "y" };
/* 438 */     String[] DICT_C = { "b", "c", "d", "f", "g", "h", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "" };
/* 439 */     String[] DICT_FEMALE = { "ra", "ara", "ella", "elia", "nja", "yja", "ulla", "na", "ana", "neas", "phine", "tris", "gyn", "syn", "dite", "ena", "hena", "tia", "anke", "mera", "nera", "soi", "heia", "mis", "thys", "asis", "one", "dione", "dona", "ona", "phion", "trix", "tix", "lene", "lena", "phy", "tune", "va", "una", "tuna", "arae", "aris", "ris", "tia", "rena", "raura", "dea", "enta", "dia", "ta" };
/* 440 */     String[] DICT_MALE = { "agi", "aldir", "aos", "arus", "borh", "bris", "bum", "bus", "dall", "dar", "darr", "des", "dis", "dite", "dohr", "don", "dos", "dros", "dum", "dur", "emis", "enar", "esis", "eus", "eyar", "eyr", "her", "ion", "ione", "ius", "jun", "ldir", "lios", "lo", "lous", "mes", "mir", "mjir", "mos", "mus", "nia", "nir", "nos", "nus", "ohr", "orr", "rasil", "reus", "ros", "ruer", "rus", "ses", "stus", "tar", "tarr", "teus", "thar", "ther", "tia", "ton", "tos", "tyx" };
/*     */     
/* 442 */     boolean female = rand.nextBoolean();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 447 */     StringBuilder s = new StringBuilder().append(DICT_A[rand.nextInt(DICT_A.length)]).append(DICT_B[rand.nextInt(DICT_B.length)]).append(DICT_C[rand.nextInt(DICT_C.length)]).append(female ? DICT_FEMALE[rand.nextInt(DICT_FEMALE.length)] : DICT_MALE[rand.nextInt(DICT_MALE.length)]);
/*     */     
/* 449 */     if (rand.nextInt(3) == 0)
/*     */     {
/*     */ 
/*     */ 
/* 453 */       s.append(DICT_A[rand.nextInt(DICT_A.length)]).append(DICT_B[rand.nextInt(DICT_B.length)]).append(DICT_C[rand.nextInt(DICT_C.length)]).append(female ? DICT_FEMALE[rand.nextInt(DICT_FEMALE.length)] : DICT_MALE[rand.nextInt(DICT_MALE.length)]);
/*     */     }
/*     */     
/* 456 */     s.setCharAt(0, Character.toUpperCase(s.charAt(0)));
/* 457 */     return s.toString();
/*     */   }
/*     */   
/*     */   void syncHeadTo(World world, EntityPlayer player) {
/* 461 */     Get.pipeline().sendTo(new DeityManager.PacketSyncHeadToClient(world, this, this.head), player);
/*     */   }
/*     */   
/*     */   public void syncHeadTo(World world) {
/* 465 */     Get.pipeline().sendToDimension(new DeityManager.PacketSyncHeadToClient(world, this, this.head), world.field_73011_w.func_177502_q());
/*     */   }
/*     */   
/*     */   public void syncEffectsTo(World world, EntityPlayer player) {
/* 469 */     Get.pipeline().sendTo(new DeityManager.PacketEffectsToClient(world, getId(), getMajorEffect()), player);
/*     */   }
/*     */   
/*     */   public void syncEffectsTo(World world) {
/* 473 */     Get.pipeline().sendToDimension(new DeityManager.PacketEffectsToClient(world, getId(), getMajorEffect()), world.field_73011_w.func_177502_q());
/*     */   }
/*     */   
/*     */   public boolean isFullOffering(List<ItemStack> offerings) {
/* 477 */     boolean a = false;boolean b = false;boolean c = false;
/* 478 */     for (ItemStack stack : offerings) {
/* 479 */       if (stack != null) {
/* 480 */         if (areItemsEqual(stack, this.sacredItemA)) {
/* 481 */           a = true;
/* 482 */         } else if (areItemsEqual(stack, this.sacredItemB)) {
/* 483 */           b = true;
/* 484 */         } else if (areItemsEqual(stack, this.sacredItemC)) {
/* 485 */           c = true;
/*     */         }
/*     */       }
/*     */     }
/* 489 */     return (a) && (b) && (c);
/*     */   }
/*     */   
/*     */   private boolean areItemsEqual(ItemStack a, ItemStack b) {
/* 493 */     if ((a == null) || (b == null)) {
/* 494 */       return false;
/*     */     }
/*     */     
/* 497 */     if (a.func_77973_b() != b.func_77973_b()) {
/* 498 */       return false;
/*     */     }
/*     */     
/* 501 */     if ((a.func_77981_g()) && (a.func_77952_i() != b.func_77952_i())) {
/* 502 */       return false;
/*     */     }
/*     */     
/* 505 */     if (!ItemStack.func_77970_a(a, b)) {
/* 506 */       return false;
/*     */     }
/*     */     
/* 509 */     return true;
/*     */   }
/*     */   
/*     */   public boolean areWorshipRequirementsMet(World world, BlockPos pos, EntityPlayer playerIn) {
/* 513 */     if ((this.worshipRestrictionA != null) && (!this.worshipRestrictionA.isWorshipAllowed(world, pos, playerIn))) {
/* 514 */       return false;
/*     */     }
/*     */     
/* 517 */     if ((this.worshipRestrictionB != null) && (!this.worshipRestrictionB.isWorshipAllowed(world, pos, playerIn))) {
/* 518 */       return false;
/*     */     }
/*     */     
/* 521 */     return true;
/*     */   }
/*     */   
/* 524 */   private static int WORSHIP_INCREASE = 4;
/*     */   private long lastWorshipTime;
/*     */   
/* 527 */   public void worshipBy(World world, EntityPlayer player, boolean devout, long shrineWorshipLevel) { this.worship += WORSHIP_INCREASE;
/* 528 */     if (devout) {
/* 529 */       this.worship += WORSHIP_INCREASE;
/*     */     }
/* 531 */     if (shrineWorshipLevel > 30L) {
/* 532 */       this.worship += WORSHIP_INCREASE;
/*     */     }
/*     */     
/* 535 */     if (shrineWorshipLevel > 400L) {
/* 536 */       this.worship += WORSHIP_INCREASE;
/*     */     }
/*     */     
/* 539 */     this.lastWorshipTime = world.func_82737_E();
/*     */     
/* 541 */     Get.deities().forWorld(world).func_76185_a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 548 */     if ((obj == null) || (obj.getClass() != getClass())) {
/* 549 */       return false;
/*     */     }
/*     */     
/* 552 */     if (obj == this) {
/* 553 */       return true;
/*     */     }
/*     */     
/* 556 */     Deity other = (Deity)obj;
/*     */     
/* 558 */     return other.id.equals(this.id);
/*     */   }
/*     */   
/*     */   public boolean canReflectDamage(World world) {
/* 562 */     boolean canReflect = this.minorEffect.isResistant(world, this);
/* 563 */     if ((canReflect) && (this.damage == 0) && (this.immuneTicks == 0)) {
/* 564 */       return true;
/*     */     }
/* 566 */     return false;
/*     */   }
/*     */   
/*     */   public IDeityMinorWorldEffect getMinorEffect()
/*     */   {
/* 571 */     return this.minorEffect;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/Deity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */