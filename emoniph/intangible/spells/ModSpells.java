/*     */ package emoniph.intangible.spells;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.ILearning;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.api.ISpell;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.knowledge.Learning;
/*     */ import emoniph.intangible.network.IPacketRegister;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.spells.anchors.SpellAnchor;
/*     */ import emoniph.intangible.spells.grenades.SpellGrenade;
/*     */ import emoniph.intangible.spells.projectiles.SpellDoomBolt;
/*     */ import emoniph.intangible.spells.projectiles.SpellFanBolt;
/*     */ import emoniph.intangible.spells.projectiles.SpellProjectile;
/*     */ import emoniph.intangible.spells.projectiles.SpellSeeker;
/*     */ import emoniph.intangible.spells.projectiles.SpellVenom;
/*     */ import emoniph.intangible.util.TickUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ 
/*     */ public class ModSpells implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModPreInit, emoniph.intangible.network.IRegisterPackets, Iterable<SpellEntry>
/*     */ {
/*  43 */   private final Map<String, SpellEntry> spellsById = new HashMap();
/*  44 */   private final Map<ISpell, SpellEntry> spellsByInterface = new HashMap();
/*  45 */   private final List<ISpell> spells = new ArrayList();
/*  46 */   private final List<SpellEntry> entries = new ArrayList();
/*     */   
/*  48 */   private final Map<ISpell, Integer> spellToIndex = new HashMap();
/*     */   
/*  50 */   public final ISpell ARMOR = registerSpell(Get.effects().ARMOR, Learning.of(new IKnol[] { Get.knowledge().SOUL_IMMUTABLE }), new Spelling(), new GridCoord(0, 1));
/*  51 */   public final ISpell CLAWS = registerSpell(Get.effects().CLAWS, Learning.of(new IKnol[] { Get.knowledge().SOUL_PREDATORY }), new Spelling(), new GridCoord(0, -1));
/*  52 */   public final ISpell DIG = registerSpell(Get.effects().DIG, Learning.of(new IKnol[] { Get.knowledge().SOUL_MALLEABLE }), new Spelling(), new GridCoord(1, 0));
/*  53 */   public final ISpell MOMENTUM = registerSpell(Get.effects().MOMENTUM, Learning.of(new IKnol[] { Get.knowledge().SOUL_DOOMED, Get.knowledge().SOUL_IMMUTABLE }), new Spelling(20, new SoulSet().add(SoulType.DOOMED, 1)), new GridCoord(-1, 0));
/*  54 */   public final ISpell PLACE = registerSpell(Get.effects().PLACE, Learning.of(new IKnol[] { Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_WISE }), new Spelling(), new GridCoord(-1, -1));
/*  55 */   public final ISpell TENDRILS = registerSpell(Get.effects().TENDRILS, Learning.of(new IKnol[] { Get.knowledge().SOUL_WISE }), new Spelling(), new GridCoord(-3, -1));
/*  56 */   public final ISpell PROC_BURN = registerSpell(Get.effects().PROC_BURN, Learning.of(new IKnol[] { Get.knowledge().SOUL_UNHINGED }), new Spelling(), new GridCoord(1, 1));
/*  57 */   public final ISpell PROC_LAUNCH = registerSpell(Get.effects().PROC_LAUNCH, Learning.of(new IKnol[] { Get.knowledge().SOUL_NOBLE }), new Spelling(), new GridCoord(-1, 1));
/*  58 */   public final ISpell REPAIR = registerSpell(Get.effects().REPAIR, Learning.of(new IKnol[] { Get.knowledge().SOUL_BENIGN }), new Spelling(), new GridCoord(1, -1));
/*  59 */   public final ISpell SHIELD = registerSpell(Get.effects().SHIELD, Learning.of(new IKnol[] { Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SOUL_MALLEABLE }), new Spelling(), new GridCoord(2, 0));
/*  60 */   public final ISpell SONIC_SWIPE = registerSpell(Get.effects().SWIPE, Learning.of(new IKnol[] { Get.knowledge().SOUL_DOOMED }), new Spelling(), new GridCoord(-2, 0));
/*  61 */   public final ISpell VISION = registerSpell(Get.effects().VISION, Learning.of(new IKnol[] { Get.knowledge().SOUL_WISE }), new Spelling(), new GridCoord(0, 2));
/*  62 */   public final ISpell WINGS = registerSpell(Get.effects().WINGS, Learning.of(new IKnol[] { Get.knowledge().SOUL_NOBLE }), new Spelling(), new GridCoord(0, -2));
/*  63 */   public final ISpell OVERCLOCK = registerSpell(Get.effects().OVERCLOCK, Learning.of(new IKnol[] { Get.knowledge().SOUL_MALLEABLE }), new Spelling(), new GridCoord(1, 2));
/*  64 */   public final ISpell UNEXPECTED = registerSpell(Get.effects().UNEXPECTED, Learning.of(new IKnol[] { Get.knowledge().SOUL_UNHINGED }), new Spelling(), new GridCoord(-1, 2));
/*  65 */   public final ISpell PUSH = registerSpell(Get.effects().PUSH, Learning.of(new IKnol[] { Get.knowledge().SOUL_BENIGN }), new Spelling(), new GridCoord(-2, 2));
/*  66 */   public final ISpell STRENGTH = registerSpell(Get.effects().STRENGTH, Learning.of(new IKnol[] { Get.knowledge().SOUL_PREDATORY }), new Spelling(), new GridCoord(-3, 2));
/*  67 */   public final ISpell PROC_HEAL = registerSpell(Get.effects().PROC_HEAL, Learning.of(new IKnol[] { Get.knowledge().SOUL_BENIGN, Get.knowledge().SOUL_MALLEABLE }), new Spelling(), new GridCoord(-3, -2));
/*  68 */   public final ISpell PROC_DODGE = registerSpell(Get.effects().PROC_DODGE, Learning.of(new IKnol[] { Get.knowledge().SOUL_PREDATORY, Get.knowledge().SOUL_MALLEABLE }), new Spelling(), new GridCoord(-1, -3));
/*     */   
/*  70 */   public final ISpell PROC_CLONE = registerSpell(Get.effects().PROC_CLONE, Learning.of(new IKnol[] { Get.knowledge().SOUL_MALLEABLE }), new Spelling(), new GridCoord(-3, -3));
/*     */   
/*  72 */   public final ISpell CHARGED = registerSpell(Get.effects().CHARGED, Learning.of(new IKnol[] { Get.knowledge().SOUL_DOOMED }), new Spelling(), new GridCoord(-4, -4));
/*     */   
/*  74 */   public final ISpell CLOUD_WALK = registerSpell(Get.effects().CLOUD_WALK, Learning.of(new IKnol[] { Get.knowledge().SOUL_NOBLE }), new Spelling(), new GridCoord(-3, -4));
/*     */   
/*  76 */   public final ISpell PROC_REAPER = registerSpell(Get.effects().PROC_REAPER, Learning.of(new IKnol[] { Get.knowledge().SOUL_DOOMED }), new Spelling(), new GridCoord(-1, -2));
/*     */   
/*  78 */   public final ISpell INCORPOREAL = registerSpell(Get.effects().INCORPOREAL, Learning.of(new IKnol[] { Get.knowledge().SOUL_MALLEABLE }), new Spelling(
/*  79 */     TickUtil.fromSeconds(5), new SoulSet().add(SoulType.MALLEABLE, 3)), new GridCoord(-2, -2));
/*     */   
/*  81 */   public final SpellProjectile DOOM_BOLT = (SpellProjectile)registerSpell("doombolt", new SpellDoomBolt(10.0F, 0.0F), Learning.of(new IKnol[] { Get.knowledge().SOUL_DOOMED }), new Spelling(
/*  82 */     TickUtil.fromSeconds(2), new SoulSet().add(SoulType.DOOMED, 3)), 
/*  83 */     StatCollector.func_74838_a("spell.intangible:doombolt"), new GridCoord(0, -3), new ResourceLocation("intangible:textures/gui/spell_doombolt.png"));
/*     */   
/*     */ 
/*  86 */   public final ISpell SOUL_LEASH = registerSpell("soulleash", new emoniph.intangible.spells.projectiles.SpellSoulLeash(), Learning.of(new IKnol[] { Get.knowledge().SOUL_BENIGN }), new Spelling(
/*  87 */     TickUtil.fromSeconds(4), new SoulSet().add(SoulType.BENIGN, 1)), 
/*  88 */     StatCollector.func_74838_a("spell.intangible:soulleash"), new GridCoord(4, -1), new ResourceLocation("intangible:textures/gui/spell_soulleash.png"));
/*     */   
/*     */ 
/*  91 */   public final ISpell ANIMATE_GOLEM = registerSpell("animategolem", new emoniph.intangible.spells.projectiles.SpellAnimateGolem(), Learning.of(new IKnol[] { Get.knowledge().SOUL_IMMUTABLE }), new Spelling(
/*  92 */     TickUtil.fromSeconds(10), new SoulSet().add(SoulType.IMMUTABLE, 1)), 
/*  93 */     StatCollector.func_74838_a("spell.intangible:animategolem"), new GridCoord(0, -4), new ResourceLocation("intangible:textures/gui/spell_animategolem.png"));
/*     */   
/*     */ 
/*  96 */   public final ISpell ANIMATE_SPIDER = registerSpell("animatespider", new emoniph.intangible.spells.projectiles.SpellAnimateSpider(), Learning.of(new IKnol[] { Get.knowledge().SOUL_PREDATORY }), new Spelling(
/*  97 */     TickUtil.fromSeconds(10), new SoulSet().add(SoulType.PREDATORY, 1)), 
/*  98 */     StatCollector.func_74838_a("spell.intangible:animatespider"), new GridCoord(2, -3), new ResourceLocation("intangible:textures/gui/spell_animatespider.png"));
/*     */   
/*     */ 
/* 101 */   public final SpellSeeker SWARM = (SpellSeeker)registerSpell("swarm", new emoniph.intangible.spells.projectiles.SpellSwarm(), Learning.of(new IKnol[] { Get.knowledge().SOUL_PREDATORY }), new Spelling(
/* 102 */     TickUtil.fromSeconds(2), new SoulSet().add(SoulType.PREDATORY, 2)), 
/* 103 */     StatCollector.func_74838_a("spell.intangible:swarm"), new GridCoord(1, -3), new ResourceLocation("intangible:textures/gui/spell_swarm.png"));
/*     */   
/*     */ 
/* 106 */   public final SpellProjectile VENOM = (SpellProjectile)registerSpell("venom", new SpellVenom(), Learning.of(new IKnol[0]), new Spelling(
/* 107 */     TickUtil.fromSeconds(2), new SoulSet().add(SoulType.PREDATORY, 1)), false, 
/*     */     
/* 109 */     StatCollector.func_74838_a("spell.intangible:venom"), new GridCoord(0, 0), new ResourceLocation("intangible:textures/gui/spell_venom.png"));
/*     */   
/*     */ 
/* 112 */   public final SpellGrenade EXPLODE = (SpellGrenade)registerSpell("explode", new emoniph.intangible.spells.grenades.SpellExplode(), Learning.of(new IKnol[0]), new Spelling(
/* 113 */     TickUtil.fromSeconds(2), new SoulSet().add(SoulType.PREDATORY, 1)), false, 
/*     */     
/* 115 */     StatCollector.func_74838_a("spell.intangible:explode"), new GridCoord(0, 0), new ResourceLocation("intangible:textures/gui/spell_explode.png"));
/*     */   
/*     */ 
/* 118 */   public final SpellProjectile MINI_BOLT = (SpellProjectile)registerSpell("minibolt", new SpellDoomBolt(2.0F, 2.0F), Learning.of(new IKnol[0]), new Spelling(
/* 119 */     TickUtil.fromSeconds(1), new SoulSet().add(SoulType.DOOMED, 1)), false, 
/*     */     
/* 121 */     StatCollector.func_74838_a("spell.intangible:minibolt"), new GridCoord(0, 0), new ResourceLocation("intangible:textures/gui/spell_minibolt.png"));
/*     */   
/*     */ 
/* 124 */   public final SpellProjectile FAN_BOLT = (SpellProjectile)registerSpell("fanbolt", new SpellFanBolt(2.0F, 2.0F), Learning.of(new IKnol[0]), new Spelling(
/* 125 */     TickUtil.fromSeconds(1), new SoulSet()), false, 
/*     */     
/* 127 */     StatCollector.func_74838_a("spell.intangible:fanbolt"), new GridCoord(0, 0), new ResourceLocation("intangible:textures/gui/spell_fanbolt.png"));
/*     */   
/*     */ 
/* 130 */   public final SpellProjectile TRIGGER = (SpellProjectile)registerSpell("trigger", new emoniph.intangible.spells.projectiles.SpellTrigger(), Learning.of(new IKnol[] { Get.knowledge().SOUL_MALLEABLE }), new Spelling(
/* 131 */     TickUtil.fromSeconds(1), new SoulSet().add(SoulType.MALLEABLE, 1)), 
/* 132 */     StatCollector.func_74838_a("spell.intangible:trigger"), new GridCoord(4, -3), new ResourceLocation("intangible:textures/gui/spell_trigger.png"));
/*     */   
/*     */ 
/*     */ 
/* 136 */   public final SpellAnchor SLINGSHOT = (SpellAnchor)registerSpell("slingshot", new emoniph.intangible.spells.anchors.SpellSlingshot(), Learning.of(new IKnol[] { Get.knowledge().SOUL_UNHINGED }), new Spelling(
/* 137 */     TickUtil.fromSeconds(5), new SoulSet().add(SoulType.UNHINGED, 1)), 
/* 138 */     StatCollector.func_74838_a("spell.intangible:slingshot"), new GridCoord(3, -2), new ResourceLocation("intangible:textures/gui/spell_slingshot.png"));
/*     */   
/*     */ 
/* 141 */   public final SpellAnchor GRAVITYWELL = (SpellAnchor)registerSpell("gravitywell", new emoniph.intangible.spells.anchors.SpellGravityWell(), Learning.of(new IKnol[] { Get.knowledge().SOUL_IMMUTABLE }), new Spelling(
/* 142 */     TickUtil.fromSeconds(5), new SoulSet().add(SoulType.IMMUTABLE, 3)), 
/* 143 */     StatCollector.func_74838_a("spell.intangible:gravitywell"), new GridCoord(2, -2), new ResourceLocation("intangible:textures/gui/spell_gravitywell.png"));
/*     */   
/*     */ 
/* 146 */   public final SpellProjectile MIRROR_IMAGE = (SpellProjectile)registerSpell("mirrorimage", new emoniph.intangible.spells.projectiles.SpellMirrorImage(), Learning.of(new IKnol[] { Get.knowledge().SOUL_MALLEABLE }), new Spelling(
/* 147 */     TickUtil.fromSeconds(10), new SoulSet().add(SoulType.MALLEABLE, 3)), 
/* 148 */     StatCollector.func_74838_a("spell.intangible:mirrorimage"), new GridCoord(3, -3), new ResourceLocation("intangible:textures/gui/spell_mirrorimage.png"));
/*     */   
/*     */ 
/* 151 */   public final SpellProjectile SHATTER = (SpellProjectile)registerSpell("shatter", new emoniph.intangible.spells.projectiles.SpellShatter(), Learning.of(new IKnol[] { Get.knowledge().SOUL_DOOMED }), new Spelling(
/* 152 */     TickUtil.fromSeconds(2), new SoulSet().add(SoulType.DOOMED, 1)), 
/* 153 */     StatCollector.func_74838_a("spell.intangible:shatter"), new GridCoord(3, -4), new ResourceLocation("intangible:textures/gui/spell_shatter.png"));
/*     */   
/*     */ 
/* 156 */   public final SpellGrenade PACIFY = (SpellGrenade)registerSpell("pacify", new emoniph.intangible.spells.grenades.SpellPacify(), Learning.of(new IKnol[] { Get.knowledge().SOUL_NOBLE }), new Spelling(
/* 157 */     TickUtil.fromSeconds(2), new SoulSet().add(SoulType.NOBLE, 1)), 
/* 158 */     StatCollector.func_74838_a("spell.intangible:pacify"), new GridCoord(4, -4), new ResourceLocation("intangible:textures/gui/effect_pacified.png"));
/*     */   
/*     */ 
/* 161 */   public final SpellProjectile ANIMATE_TOOL = (SpellProjectile)registerSpell("animatetool", new emoniph.intangible.spells.projectiles.SpellAnimateTool(), Learning.of(new IKnol[] { Get.knowledge().SOUL_WISE, Get.knowledge().SOUL_MALLEABLE }), new Spelling(
/* 162 */     TickUtil.fromSeconds(60), new SoulSet().add(SoulType.WISE, 1)), 
/* 163 */     StatCollector.func_74838_a("spell.intangible:animatetool"), new GridCoord(-2, -3), new ResourceLocation("intangible:textures/gui/spell_animatetool.png"));
/*     */   
/*     */ 
/* 166 */   public final SpellGrenade WILT = (SpellGrenade)registerSpell("wilt", new emoniph.intangible.spells.grenades.SpellWilt(), Learning.of(new IKnol[0]), new Spelling(
/* 167 */     TickUtil.fromSeconds(2), new SoulSet()), false, 
/*     */     
/* 169 */     StatCollector.func_74838_a("spell.intangible:wilt"), new GridCoord(0, 0), new ResourceLocation("intangible:textures/gui/spell_explode.png"));
/*     */   
/*     */   public <T extends ISpell> T registerSpell(String id, T spell, ILearning knowledge, Spelling cost, String localizedName, GridCoord coord, ResourceLocation iconTexture)
/*     */   {
/* 173 */     return registerSpell(id, spell, knowledge, cost, true, localizedName, coord, iconTexture);
/*     */   }
/*     */   
/*     */   public <T extends ISpell> T registerSpell(String id, T spell, ILearning knowledge, Spelling cost, boolean playerCastable, String localizedName, GridCoord coord, ResourceLocation iconTexture) {
/* 177 */     id = emoniph.intangible.util.ModUtil.withPrefix(id);
/*     */     
/* 179 */     if (!this.spellsById.containsKey(id)) {
/* 180 */       int index = this.spells.size();
/* 181 */       this.spells.add(spell);
/* 182 */       SpellEntry entry = new SpellEntry(id, spell, knowledge, cost, localizedName, coord, iconTexture, index, playerCastable);
/* 183 */       this.spellsById.put(entry.id, entry);
/* 184 */       this.spellsByInterface.put(entry.spell, entry);
/* 185 */       this.entries.add(entry);
/*     */     }
/* 187 */     return spell;
/*     */   }
/*     */   
/*     */   public SpellPassive registerSpell(IPassiveEffect effect, ILearning knowledge, Spelling cost, GridCoord coord) {
/* 191 */     return (SpellPassive)registerSpell(Get.effects().getIdForEffect(effect), new SpellPassive(effect), knowledge, cost, effect.getLocalizedName(), coord, effect
/* 192 */       .getHudGlyph());
/*     */   }
/*     */   
/*     */   public ISpell getSpellFromIndex(int index) {
/* 196 */     return (index >= 0) && (index < this.spells.size()) ? (ISpell)this.spells.get(index) : null;
/*     */   }
/*     */   
/*     */   public int getIndexFromSpell(ISpell spell) {
/* 200 */     SpellEntry entry = (SpellEntry)this.spellsByInterface.get(spell);
/* 201 */     return entry != null ? entry.index : -1;
/*     */   }
/*     */   
/*     */   public String getIdForSpell(ISpell spell) {
/* 205 */     SpellEntry entry = (SpellEntry)this.spellsByInterface.get(spell);
/* 206 */     return entry != null ? entry.id : null;
/*     */   }
/*     */   
/*     */   public ISpell getSpellForId(String effectId) {
/* 210 */     SpellEntry entry = (SpellEntry)this.spellsById.get(effectId);
/* 211 */     return entry != null ? entry.spell : null;
/*     */   }
/*     */   
/*     */   public Spelling getCastingCost(ISpell spell) {
/* 215 */     return ((SpellEntry)this.spellsByInterface.get(spell)).cost;
/*     */   }
/*     */   
/*     */   public java.util.Iterator<SpellEntry> iterator()
/*     */   {
/* 220 */     return this.entries.iterator();
/*     */   }
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/* 225 */     Get.pipeline().registerPacketProvider(this);
/*     */   }
/*     */   
/*     */   public void registerPackets(IPacketRegister packetRegister)
/*     */   {
/* 230 */     packetRegister.registerPacket(ModSpells.PacketCastSpell.Handler.class, PacketCastSpell.class, Side.SERVER);
/*     */   }
/*     */   
/*     */   private void castSpell(EntityPlayer player, ISpell spell) {
/* 234 */     if (!player.field_70170_p.field_72995_K) {
/* 235 */       switch (spell.getCastingStyle(player, false)) {
/*     */       case INSTANT: 
/* 237 */         tryInvokeSpell(player, spell);
/* 238 */         break;
/*     */       case PREPARED: 
/* 240 */         if (canInvokeSpell(player, spell)) {
/* 241 */           PlayerEx playerEx = PlayerEx.get(player);
/* 242 */           if (playerEx != null) {
/* 243 */             playerEx.setReadySpell(spell);
/*     */           }
/*     */         }
/*     */         break;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void tryInvokeSpell(EntityPlayer player, ISpell spell) {
/* 252 */     if (!player.field_70170_p.field_72995_K) {
/* 253 */       SpellEntry entry = (SpellEntry)this.spellsByInterface.get(spell);
/* 254 */       if (entry != null) {
/* 255 */         PlayerEx playerEx = PlayerEx.get(player);
/* 256 */         if (playerEx != null) {
/* 257 */           if ((entry.getRequiredKnowledge().containedBy(playerEx.getLearning())) && 
/* 258 */             (entry.spell.arePrerequisitesMet(player)) && 
/* 259 */             (entry.cost.tryConsumeFrom(playerEx))) {
/* 260 */             spell.invoke(player);
/*     */           } else {
/* 262 */             Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(player, 1.0F, 1.0F);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean canInvokeSpell(EntityPlayer player, ISpell spell) {
/* 270 */     if (!player.field_70170_p.field_72995_K) {
/* 271 */       SpellEntry entry = (SpellEntry)this.spellsByInterface.get(spell);
/* 272 */       if (entry != null) {
/* 273 */         PlayerEx playerEx = PlayerEx.get(player);
/* 274 */         if (playerEx != null) {
/* 275 */           if ((entry.getRequiredKnowledge().containedBy(playerEx.getLearning())) && 
/* 276 */             (entry.cost.canConsumeFrom(playerEx))) {
/* 277 */             return true;
/*     */           }
/* 279 */           Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(player, 1.0F, 1.0F);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 284 */     return false;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(Side.CLIENT)
/*     */   public void bindTextureFor(ISpell spell) {
/* 289 */     SpellEntry entry = (SpellEntry)this.spellsByInterface.get(spell);
/* 290 */     if (entry != null) {
/* 291 */       entry.bindTexture();
/*     */     }
/*     */   }
/*     */   
/*     */   public String defaultConfigString(ISpell spell) {
/* 296 */     SpellEntry entry = (SpellEntry)this.spellsByInterface.get(spell);
/* 297 */     if (entry != null) {
/* 298 */       return entry.iconAsString();
/*     */     }
/* 300 */     return "";
/*     */   }
/*     */   
/*     */   public SpellIcon createSpellIcon(ISpell spell, String serialized)
/*     */   {
/* 305 */     SpellEntry entry = (SpellEntry)this.spellsByInterface.get(spell);
/* 306 */     if (entry != null) {
/* 307 */       return entry.createSpellIcon(serialized);
/*     */     }
/* 309 */     return null;
/*     */   }
/*     */   
/*     */   public static class SpellEntry
/*     */   {
/*     */     private final String id;
/*     */     private final ISpell spell;
/*     */     private final ILearning knowledge;
/*     */     private final int index;
/*     */     private final Spelling cost;
/*     */     private final String localizedName;
/*     */     private final String localizedText;
/*     */     private final GridCoord iconCoord;
/*     */     private final ResourceLocation iconTexture;
/*     */     private final boolean playerCastable;
/*     */     
/*     */     SpellEntry(String id, ISpell spell, ILearning knowledge, Spelling cost, String localizedName, GridCoord iconCoord, ResourceLocation texture, int index, boolean playerCastable) {
/* 326 */       this.id = id;
/* 327 */       this.spell = spell;
/* 328 */       this.knowledge = knowledge;
/* 329 */       this.index = index;
/* 330 */       this.cost = cost;
/* 331 */       this.localizedName = localizedName;
/* 332 */       this.localizedText = emoniph.intangible.util.TextUtil.parse(StatCollector.func_74838_a("spell." + id + ".details"));
/* 333 */       this.iconCoord = iconCoord;
/* 334 */       this.iconTexture = texture;
/* 335 */       this.playerCastable = playerCastable;
/*     */     }
/*     */     
/*     */     public void bindTexture() {
/* 339 */       Minecraft.func_71410_x().func_110434_K().func_110577_a(this.iconTexture);
/*     */     }
/*     */     
/*     */     public String iconAsString() {
/* 343 */       return String.format("%s:%s", new Object[] { Double.toString(Math.round(10.0F * (this.iconCoord.x * 24.0F - 8.0F)) / 10), Double.toString(Math.round(10.0F * (this.iconCoord.y * 24.0F - 8.0F)) / 10) });
/*     */     }
/*     */     
/*     */     public SpellIcon createSpellIcon(String serialized) {
/* 347 */       return new SpellIcon(this.spell, serialized, this.localizedName, this.localizedText, this.iconTexture);
/*     */     }
/*     */     
/*     */     public ISpell getSpell() {
/* 351 */       return this.spell;
/*     */     }
/*     */     
/*     */     public ILearning getRequiredKnowledge() {
/* 355 */       return this.knowledge;
/*     */     }
/*     */     
/*     */     public Spelling getCastingCost() {
/* 359 */       return this.cost;
/*     */     }
/*     */     
/*     */     public boolean canPlayerCast(EntityPlayer player) {
/* 363 */       return this.playerCastable;
/*     */     }
/*     */     
/*     */     public boolean isActive(EntityPlayer player) {
/* 367 */       return this.spell.isActive(player);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PacketCastSpell implements IMessage
/*     */   {
/*     */     private ISpell spell;
/*     */     private boolean reset;
/*     */     
/*     */     public PacketCastSpell() {}
/*     */     
/*     */     public PacketCastSpell(ISpell spell, boolean reset) {
/* 379 */       this.spell = spell;
/* 380 */       this.reset = reset;
/*     */     }
/*     */     
/*     */     public void fromBytes(ByteBuf buf)
/*     */     {
/* 385 */       this.spell = Get.spells().getSpellFromIndex(buf.readInt());
/* 386 */       this.reset = buf.readBoolean();
/*     */     }
/*     */     
/*     */     public void toBytes(ByteBuf buf)
/*     */     {
/* 391 */       buf.writeInt(Get.spells().getIndexFromSpell(this.spell));
/* 392 */       buf.writeBoolean(this.reset);
/*     */     }
/*     */     
/*     */     public static class Handler implements net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<ModSpells.PacketCastSpell, IMessage>
/*     */     {
/*     */       public IMessage onMessage(final ModSpells.PacketCastSpell message, final MessageContext ctx)
/*     */       {
/* 399 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*     */           public void run() {
/* 401 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 402 */             if ((player != null) && (message.spell != null)) {
/* 403 */               if (message.reset) {
/* 404 */                 PlayerEx playerEx = PlayerEx.get(player);
/* 405 */                 playerEx.CACHE.clearRadialMenuData();
/*     */               }
/* 407 */               Get.spells().castSpell(player, message.spell);
/*     */             }
/*     */             
/*     */           }
/* 411 */         });
/* 412 */         return null;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/ModSpells.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */