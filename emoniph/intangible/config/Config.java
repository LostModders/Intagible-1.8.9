/*     */ package emoniph.intangible.config;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISpell;
/*     */ import emoniph.intangible.init.IModPreInit;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import emoniph.intangible.spells.SpellIcon;
/*     */ import java.io.File;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.common.config.ConfigElement;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ import net.minecraftforge.fml.client.config.IConfigElement;
/*     */ import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.EventBus;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ 
/*     */ public class Config implements emoniph.intangible.init.IModService, IModPreInit
/*     */ {
/*     */   public boolean MOD_HOOKS_ENABLED;
/*     */   public boolean DEBUG_ENABLED;
/*     */   public boolean REPLACE_DROPPED_GLASS;
/*     */   public boolean REDUCE_OVERCLOCKED_ARMOR_IF_ENCHANTED;
/*     */   public boolean CHECK_FOR_BLOCK_BREAK_PERMISSION;
/*     */   public boolean ALLOW_PLAYER_POSSESSION_ON_PVE_SERVERS;
/*     */   public float CURSE_CHANCE_SHRINE_THEFT;
/*     */   public float CURSE_CHANCE_PRIEST_ATTACKED;
/*     */   public HudOffset HUD_ANCHOR;
/*     */   public int HUD_OFFSET_X;
/*     */   public int HUD_OFFSET_Y;
/*  35 */   public boolean RENDER_ARM_ARMOR = true;
/*     */   public int FAST_TIME_NIGHT_START_OFFSET_TICKS;
/*     */   public int FAST_TIME_DAY_START_OFFSET_TICKS;
/*     */   private Configuration configuration;
/*     */   
/*  40 */   public static enum HudOffset { TOP_LEFT("topleft"), 
/*  41 */     TOP_RIGHT("topright"), 
/*  42 */     BOTTOM_LEFT("bottemleft"), 
/*  43 */     BOTTOM_RIGHT("bottomright");
/*     */     
/*     */ 
/*     */     final String key;
/*     */     
/*  48 */     private HudOffset(String key) { this.key = key; }
/*     */     
/*     */     static {
/*  51 */       BY_KEY = new HashMap();
/*     */       
/*     */ 
/*     */ 
/*  55 */       KEYS = new String[values().length];
/*  56 */       HudOffset[] items = values();
/*  57 */       for (int i = 0; i < items.length; i++) {
/*  58 */         BY_KEY.put(items[i].key, items[i]);
/*  59 */         KEYS[i] = items[i].key;
/*     */       } }
/*     */     
/*     */     private static final Map<String, HudOffset> BY_KEY;
/*     */     static final String[] KEYS;
/*  64 */     static HudOffset fromKey(String key) { HudOffset result = (HudOffset)BY_KEY.get(key);
/*  65 */       if (result == null) {
/*  66 */         result = TOP_LEFT;
/*     */       }
/*  68 */       return result;
/*     */     }
/*     */   }
/*     */   
/*     */   void sync() {
/*  73 */     this.MOD_HOOKS_ENABLED = getBoolean("ModHooksEnabled", true);
/*  74 */     this.DEBUG_ENABLED = getBoolean("DebugEnabled", false);
/*  75 */     this.REPLACE_DROPPED_GLASS = getBoolean("ReplaceDroppedGlass", true);
/*  76 */     this.REDUCE_OVERCLOCKED_ARMOR_IF_ENCHANTED = getBoolean("reduceOverclockedArmorIfEnchanted", false);
/*  77 */     this.CHECK_FOR_BLOCK_BREAK_PERMISSION = getBoolean("CheckForBlockBreakPermission", false);
/*  78 */     this.ALLOW_PLAYER_POSSESSION_ON_PVE_SERVERS = getBoolean("AllowPlayerPossessionOnPVEServers", true);
/*  79 */     this.CURSE_CHANCE_SHRINE_THEFT = getFloat("ShrineTheftCurseChance", 0.2F);
/*  80 */     this.CURSE_CHANCE_PRIEST_ATTACKED = getFloat("PriestHarmedCurseChance", 0.1F);
/*     */     
/*  82 */     this.HUD_ANCHOR = HudOffset.fromKey(getString("HudAnchor", HudOffset.TOP_LEFT.key, HudOffset.KEYS));
/*  83 */     this.HUD_OFFSET_X = getInt("HudAnchorOffsetX", 0, 0, 1000);
/*  84 */     this.HUD_OFFSET_Y = getInt("HudAnchorOffsetY", 0, 0, 1000);
/*     */     
/*  86 */     this.FAST_TIME_NIGHT_START_OFFSET_TICKS = getInt("FastTimeNightStartOffsetTicks", 0, 0, 100);
/*  87 */     this.FAST_TIME_DAY_START_OFFSET_TICKS = getInt("FastTimeDayStartOffsetTicks", 0, 0, 100);
/*     */     
/*     */ 
/*     */ 
/*  91 */     saveIfChanged();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  98 */     this.configuration = new Configuration(new File(String.format("%s/%s.cfg", new Object[] { event.getModConfigurationDirectory(), "intangible" })));
/*  99 */     this.configuration.load();
/* 100 */     sync();
/* 101 */     MinecraftForge.EVENT_BUS.register(this);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
/* 106 */     if (event.modID.equals("intangible")) {
/* 107 */       sync();
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean getBoolean(String key, boolean defaultValue) {
/* 112 */     return this.configuration.getBoolean(key, "general", defaultValue, StatCollector.func_74838_a("config.intangible:" + key.toLowerCase() + ".name"));
/*     */   }
/*     */   
/*     */   private String getString(String key, String defaultValue, String[] validValues) {
/* 116 */     return this.configuration.getString(key, "general", defaultValue, 
/*     */     
/*     */ 
/* 119 */       StatCollector.func_74838_a("config.intangible:" + key.toLowerCase() + ".name"), validValues);
/*     */   }
/*     */   
/*     */   private float getFloat(String key, float defaultValue)
/*     */   {
/* 124 */     return getFloat(key, defaultValue, 0.0F, 1.0F);
/*     */   }
/*     */   
/*     */   private float getFloat(String key, float defaultValue, float min, float max) {
/* 128 */     return this.configuration.getFloat(key, "general", defaultValue, min, max, StatCollector.func_74838_a("config.intangible:" + key.toLowerCase() + ".name"));
/*     */   }
/*     */   
/*     */   private int getInt(String key, int defaultValue, int min, int max) {
/* 132 */     return this.configuration.getInt(key, "general", defaultValue, min, max, StatCollector.func_74838_a("config.intangible:" + key.toLowerCase() + ".name"));
/*     */   }
/*     */   
/*     */   public SpellIcon getSpellIcon(ISpell spell) {
/* 136 */     Property prop = this.configuration.get("general", "Spell" + Get.spells().getIdForSpell(spell), Get.spells().defaultConfigString(spell), StatCollector.func_74838_a("config.intangible:spellicon.name"));
/* 137 */     return Get.spells().createSpellIcon(spell, prop.getString());
/*     */   }
/*     */   
/*     */   public void setSpellIcon(SpellIcon icon) {
/* 141 */     Property prop = this.configuration.get("general", "Spell" + Get.spells().getIdForSpell(icon.getSpell()), Get.spells().defaultConfigString(icon.getSpell()), StatCollector.func_74838_a("config.intangible:spellicon.name"));
/* 142 */     prop.set(icon.toString());
/* 143 */     saveIfChanged();
/*     */   }
/*     */   
/*     */   public void setSpellShortcut(int hotbarkey, ISpell spell) {
/* 147 */     Property prop = this.configuration.get("general", String.format("SpellShortcut%d", new Object[] { Integer.valueOf(hotbarkey) }), "", StatCollector.func_74838_a("config.intangible:spellshortcut.name"));
/* 148 */     prop.set(Get.spells().getIdForSpell(spell));
/* 149 */     saveIfChanged();
/*     */   }
/*     */   
/*     */   public ISpell getSpellShortcut(int hotbarkey) {
/* 153 */     Property prop = this.configuration.get("general", String.format("SpellShortcut%d", new Object[] { Integer.valueOf(hotbarkey) }), "", StatCollector.func_74838_a("config.intangible:spellshortcut.name"));
/* 154 */     return Get.spells().getSpellForId(prop.getString());
/*     */   }
/*     */   
/*     */   private void saveIfChanged() {
/* 158 */     if (this.configuration.hasChanged()) {
/* 159 */       this.configuration.save();
/*     */     }
/*     */   }
/*     */   
/*     */   String getPath() {
/* 164 */     return this.configuration.toString();
/*     */   }
/*     */   
/*     */   java.util.List<IConfigElement> getConfigElements() {
/* 168 */     return new ConfigElement(this.configuration.getCategory("general")).getChildElements();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/config/Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */