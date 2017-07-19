/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
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
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import net.minecraft.block.BlockDoublePlant.EnumPlantType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class ModDeityEffects implements emoniph.intangible.init.IModService
/*     */ {
/*  23 */   public final DeityEffectTypeRegistry<IDeityMajorWorldEffect> worldMajorEffectRegistry = new DeityEffectTypeRegistry();
/*     */   
/*  25 */   public final IDeityMajorWorldEffect SHORT_NIGHT = register("shortnight", new emoniph.intangible.deity.effects.MajorEffectFastTime(1, 12001, 0), new ItemStack(Blocks.field_150398_cm, 1, BlockDoublePlant.EnumPlantType.SUNFLOWER
/*  26 */     .func_176936_a()), new SoulSet()
/*  27 */     .add(SoulType.PREDATORY, 3));
/*     */   
/*  29 */   public final IDeityMajorWorldEffect SHORT_DAY = register("shortday", new emoniph.intangible.deity.effects.MajorEffectFastTime(1, 1, 12000), new ItemStack(Blocks.field_150402_ci), new SoulSet()
/*     */   
/*  31 */     .add(SoulType.BENIGN, 3));
/*     */   
/*  33 */   public final IDeityMajorWorldEffect DAYTIME_MONSTERS = register("daytimemonsters", new emoniph.intangible.deity.effects.MajorEffectDaytimeMonsters(), new ItemStack(Blocks.field_150425_aM), new SoulSet()
/*     */   
/*  35 */     .add(SoulType.DOOMED, 1));
/*     */   
/*  37 */   public final IDeityMajorWorldEffect BUMPER_HARVEST = register("bumperharvest", new emoniph.intangible.deity.effects.MajorEffectBumperHarvest(), new ItemStack(Blocks.field_150423_aK), new SoulSet()
/*     */   
/*  39 */     .add(SoulType.BENIGN, 4));
/*     */   
/*     */ 
/*     */ 
/*  43 */   public final DeityEffectTypeRegistry<IDeityMinorWorldEffect> worldMinorEffectRegistry = new DeityEffectTypeRegistry();
/*     */   
/*  45 */   public final IDeityMinorWorldEffect RESISTANT = register("resistant", new emoniph.intangible.deity.effects.MinorEffectResistant(), new ItemStack(Blocks.field_150343_Z), new SoulSet().add(SoulType.IMMUTABLE, 2));
/*     */   
/*  47 */   public final IDeityMinorWorldEffect MORE_LIGHTNING = register("morelightning", new emoniph.intangible.deity.effects.MinorMoreLightning(), new ItemStack(Items.field_151033_d), new SoulSet().add(SoulType.UNHINGED, 2));
/*     */   
/*  49 */   public final IDeityMinorWorldEffect INDUCE_VIOLENCE = register("induceviolence", new emoniph.intangible.deity.effects.MinorEffectInduceViolence(), new ItemStack(Items.field_151072_bj), new SoulSet().add(SoulType.PREDATORY, 2));
/*     */   
/*  51 */   public final IDeityMinorWorldEffect NATURES_BOUNTY = register("naturesbounty", new emoniph.intangible.deity.effects.MinorEffectNaturesBounty(), new ItemStack(Items.field_151034_e), new SoulSet().add(SoulType.BENIGN, 2));
/*     */   
/*     */ 
/*     */ 
/*  55 */   public final DeityEffectTypeRegistry<IDeityWorshipEffect> worshipEffectRegistry = new DeityEffectTypeRegistry();
/*     */   
/*  57 */   public final IDeityWorshipEffect STONE_WALL_WORSHIP = register("stonewall", new emoniph.intangible.deity.effects.WorshipEffectStoneWall(), new ItemStack(Blocks.field_150348_b), new SoulSet().add(SoulType.IMMUTABLE, 2));
/*     */   
/*  59 */   public final IDeityWorshipEffect CHAINS_WORSHIP = register("chains", new emoniph.intangible.deity.effects.WorshipEffectChains(), new ItemStack(Blocks.field_150411_aY), new SoulSet().add(SoulType.IMMUTABLE, 1).add(SoulType.WISE, 1));
/*     */   
/*  61 */   public final IDeityWorshipEffect WARMACHINE_WORSHIP = register("warmachine", new emoniph.intangible.deity.effects.WorshipEffectChariot(), new ItemStack(Items.field_151143_au), new SoulSet().add(SoulType.PREDATORY, 1).add(SoulType.IMMUTABLE, 1));
/*     */   
/*  63 */   public final IDeityWorshipEffect COWARDICE_WORSHIP = register("cowardice", new emoniph.intangible.deity.effects.WorshipEffectCowardice(), new ItemStack(Items.field_179555_bs), new SoulSet().add(SoulType.BENIGN, 1).add(SoulType.IMMUTABLE, 1));
/*     */   
/*  65 */   public final IDeityWorshipEffect FEAST_WORSHIP = register("feast", new emoniph.intangible.deity.effects.WorshipEffectFeast(), new ItemStack(Items.field_151083_be), new SoulSet().add(SoulType.MALLEABLE, 2).add(SoulType.IMMUTABLE, 1));
/*     */   
/*  67 */   public final IDeityWorshipEffect STARVE_WORSHIP = register("starve", new emoniph.intangible.deity.effects.WorshipEffectStarve(), new ItemStack(Items.field_151078_bh), new SoulSet().add(SoulType.DOOMED, 1).add(SoulType.BENIGN, 1));
/*     */   
/*     */ 
/*     */ 
/*  71 */   public final DeityEffectTypeRegistry<IDeityShrineEffect> shrineEffectRegistry = new DeityEffectTypeRegistry();
/*     */   
/*  73 */   public final IDeityShrineEffect FERTILITY_SHRINE = register("fertility", new emoniph.intangible.deity.effects.ShrineEffectFertility(), new ItemStack(Items.field_151014_N), new SoulSet().add(SoulType.BENIGN, 2));
/*     */   
/*  75 */   public final IDeityShrineEffect INTIIMIDATE_SHRINE = register("intimidate", new emoniph.intangible.deity.effects.ShrineEffectIntimidate(), new ItemStack(Items.field_151036_c), new SoulSet().add(SoulType.PREDATORY, 2));
/*     */   
/*  77 */   public final IDeityShrineEffect TRAVEL_SHRINE = register("travel", new emoniph.intangible.deity.effects.ShrineEffectTravel(), new ItemStack(Items.field_151021_T), new SoulSet().add(SoulType.MALLEABLE, 2));
/*     */   
/*     */ 
/*     */ 
/*  81 */   public final DeityEffectTypeRegistry<IDeityWorshipRestriction> worshipRestrictionRegistry = new DeityEffectTypeRegistry();
/*     */   
/*  83 */   public final IDeityWorshipRestriction WORSHIP_STONE_BUILDING = register("stonebuilding", new emoniph.intangible.deity.restrictions.WorshipInStoneBuildings(), new ItemStack(Blocks.field_150417_aV), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/*  87 */   public final IDeityWorshipRestriction WORSHIP_TREES = register("trees", new emoniph.intangible.deity.restrictions.WorshipInTrees(), new ItemStack(Blocks.field_150345_g), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/*  91 */   public final IDeityWorshipRestriction WORSHIP_DAY = register("day", new emoniph.intangible.deity.restrictions.WorshipInDaytime(), new ItemStack(Blocks.field_150340_R), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/*  95 */   public final IDeityWorshipRestriction WORSHIP_NIGHT = register("night", new emoniph.intangible.deity.restrictions.WorshipInNightTime(), new ItemStack(Blocks.field_150478_aa), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/*  99 */   public final IDeityWorshipRestriction WORSHIP_DESERT = register("desert", new emoniph.intangible.deity.restrictions.WorshipInDesert(), new ItemStack(Blocks.field_150354_m), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 103 */   public final IDeityWorshipRestriction WORSHIP_RAIN = register("raining", new emoniph.intangible.deity.restrictions.WorshipInRain(), new ItemStack(Items.field_151068_bn), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 107 */   public final IDeityWorshipRestriction WORSHIP_COLD = register("cold", new emoniph.intangible.deity.restrictions.WorshipInCold(), new ItemStack(Items.field_151126_ay), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 111 */   public final IDeityWorshipRestriction WORSHIP_HIGH = register("high", new emoniph.intangible.deity.restrictions.WorshipHighUp(), new ItemStack(Items.field_151008_G), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 115 */   public final IDeityWorshipRestriction WORSHIP_UNDERWATER = register("underwater", new emoniph.intangible.deity.restrictions.WorshipUnderwater(), new ItemStack(Items.field_151100_aR, 1, net.minecraft.item.EnumDyeColor.BLACK
/* 116 */     .func_176767_b()), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 120 */   public final DeityEffectTypeRegistry<IDeityAvatarBody> bodyRegistry = new DeityEffectTypeRegistry();
/*     */   
/* 122 */   public final IDeityAvatarBody BODY_BIPED = register("biped", new emoniph.intangible.deity.avatar.DeityAvatarBodyBiped(), new ItemStack(Items.field_151103_aS), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 126 */   public final IDeityAvatarBody BODY_TENTACLE = register("tentacle", new emoniph.intangible.deity.avatar.DeityAvatarBodyTentacle(), new ItemStack(Items.field_151123_aH), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 130 */   public final IDeityAvatarBody BODY_NONE = register("none", new emoniph.intangible.deity.avatar.DeityAvatarBodyNone(), new ItemStack(Blocks.field_150428_aP), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 134 */   public final IDeityAvatarBody BODY_ANGELIC = register("angelic", new emoniph.intangible.deity.avatar.DeityAvatarBodyAngelic(), new ItemStack(Items.field_151008_G), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 139 */   public final DeityEffectTypeRegistry<IDeityVoice> voiceRegistry = new DeityEffectTypeRegistry();
/*     */   
/* 141 */   public final IDeityVoice VOICE_CHOIR = register("choir", new DeityVoice("intangible:random.deity1"), new ItemStack(Items.field_151110_aK), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 145 */   public final IDeityVoice VOICE_LAMENT = register("lament", new DeityVoice("intangible:random.deity2"), new ItemStack(Items.field_151025_P), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 149 */   public final IDeityVoice VOICE_ANGELIC = register("angelic", new DeityVoice("intangible:random.deity3"), new ItemStack(Items.field_151106_aX), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/* 153 */   public final IDeityVoice VOICE_BESTIAL = register("beastial", new DeityVoice("intangible:random.deity4"), new ItemStack(Items.field_151082_bd), new SoulSet());
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 158 */   public final DeityEffectTypeRegistry<IDeityAvatarPower> avatarPowerRegistry = new DeityEffectTypeRegistry();
/*     */   
/* 160 */   public final IDeityAvatarPower AVATAR_HEALER = register("healer", new emoniph.intangible.deity.avatar.AvatarPowerHealer(), new ItemStack(Items.field_151073_bk), new SoulSet()
/* 161 */     .add(SoulType.BENIGN, 3));
/*     */   
/* 163 */   public final IDeityAvatarPower AVATAR_WARRIOR = register("warrior", new emoniph.intangible.deity.avatar.AvatarPowerWarrior(), new ItemStack(Items.field_151048_u), new SoulSet()
/* 164 */     .add(SoulType.PREDATORY, 3));
/*     */   
/* 166 */   public final IDeityAvatarPower AVATAR_HARVESTER = register("harvester", new emoniph.intangible.deity.avatar.AvatarPowerHarvester(), new ItemStack(Items.field_151019_K), new SoulSet()
/* 167 */     .add(SoulType.MALLEABLE, 1));
/*     */   
/*     */ 
/* 170 */   public final DeityEffectTypeRegistry<IDeityConstraint> constraintRegistry = new DeityEffectTypeRegistry();
/*     */   
/* 172 */   public final IDeityConstraint CONSTRAINT_REGULAR_WORSHIP = register("regularworship", new emoniph.intangible.deity.restrictions.ConstraintRegularWorship(), new ItemStack(Items.field_151122_aG), new SoulSet());
/*     */   
/* 174 */   public final IDeityConstraint CONSTRAINT_MUST_KILL = register("mustkill", new emoniph.intangible.deity.restrictions.ConstraintMustKill(), new ItemStack(Items.field_151065_br), new SoulSet());
/*     */   
/* 176 */   public final IDeityConstraint CONSTRAINT_NO_KILLING = register("nokilling", new emoniph.intangible.deity.restrictions.ConstraintNoKilling(), new ItemStack(Blocks.field_150328_O, 1, net.minecraft.block.BlockFlower.EnumFlowerType.OXEYE_DAISY.func_176968_b()), new SoulSet());
/*     */   
/* 178 */   public final IDeityConstraint CONSTRAINT_EXCLUSIVE_WORSHIP = register("exclusive", new emoniph.intangible.deity.restrictions.ConstraintExclusiveWorship(), new ItemStack(Items.field_151105_aU), new SoulSet());
/*     */   
/* 180 */   public final IDeityConstraint CONSTRAINT_REGULAR_HARVEST = register("regularharvest", new emoniph.intangible.deity.restrictions.ConstraintRegularHarvest(), new ItemStack(Items.field_151015_O), new SoulSet());
/*     */   
/*     */   public void addCostsFor(IDeityVoice voice, ISoulSet souls)
/*     */   {
/* 184 */     this.voiceRegistry.addCostsFor(voice, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityShrineEffect effect, ISoulSet souls) {
/* 188 */     this.shrineEffectRegistry.addCostsFor(effect, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityMajorWorldEffect effect, ISoulSet souls) {
/* 192 */     this.worldMajorEffectRegistry.addCostsFor(effect, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityMinorWorldEffect effect, ISoulSet souls) {
/* 196 */     this.worldMinorEffectRegistry.addCostsFor(effect, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityWorshipEffect effect, ISoulSet souls) {
/* 200 */     this.worshipEffectRegistry.addCostsFor(effect, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityConstraint effect, ISoulSet souls) {
/* 204 */     this.constraintRegistry.addCostsFor(effect, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityAvatarBody body, ISoulSet souls) {
/* 208 */     this.bodyRegistry.addCostsFor(body, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityWorshipRestriction restriction, ISoulSet souls) {
/* 212 */     this.worshipRestrictionRegistry.addCostsFor(restriction, souls);
/*     */   }
/*     */   
/*     */   public void addCostsFor(IDeityAvatarPower power, ISoulSet souls) {
/* 216 */     this.avatarPowerRegistry.addCostsFor(power, souls);
/*     */   }
/*     */   
/*     */   public <T extends IDeityMajorWorldEffect> T register(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 220 */     this.worldMajorEffectRegistry.registerEffect(id, effect, selector, cost);
/* 221 */     return effect;
/*     */   }
/*     */   
/*     */   public <T extends IDeityMinorWorldEffect> T register(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 225 */     this.worldMinorEffectRegistry.registerEffect(id, effect, selector, cost);
/* 226 */     return effect;
/*     */   }
/*     */   
/*     */   public <T extends IDeityWorshipEffect> T register(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 230 */     this.worshipEffectRegistry.registerEffect(id, effect, selector, cost);
/* 231 */     return effect;
/*     */   }
/*     */   
/*     */   public <T extends IDeityShrineEffect> T register(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 235 */     this.shrineEffectRegistry.registerEffect(id, effect, selector, cost);
/* 236 */     return effect;
/*     */   }
/*     */   
/*     */   public <T extends IDeityAvatarBody> T register(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 240 */     this.bodyRegistry.registerEffect(id, effect, selector, cost);
/* 241 */     return effect;
/*     */   }
/*     */   
/*     */   public <T extends IDeityWorshipRestriction> T register(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 245 */     this.worshipRestrictionRegistry.registerEffect(id, effect, selector, cost);
/* 246 */     return effect;
/*     */   }
/*     */   
/*     */   public <T extends IDeityAvatarPower> T register(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 250 */     this.avatarPowerRegistry.registerEffect(id, effect, selector, cost);
/* 251 */     return effect;
/*     */   }
/*     */   
/*     */   public <T extends IDeityVoice> T register(String id, T voice, ItemStack selector, ISoulSet cost) {
/* 255 */     this.voiceRegistry.registerEffect(id, voice, selector, cost);
/* 256 */     return voice;
/*     */   }
/*     */   
/*     */   public <T extends IDeityConstraint> T register(String id, T constraint, ItemStack selector, ISoulSet cost) {
/* 260 */     this.constraintRegistry.registerEffect(id, constraint, selector, cost);
/* 261 */     return constraint;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public IDeityAvatarBody getAvatarBody(EntityAvatar entity) {
/* 266 */     return (IDeityAvatarBody)this.bodyRegistry.getEffectFromIndex(entity.getDeityBodyIndex());
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/ModDeityEffects.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */