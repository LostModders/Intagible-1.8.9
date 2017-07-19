/*     */ package emoniph.intangible;
/*     */ 
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.config.Config;
/*     */ import emoniph.intangible.config.Log;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.deity.ModDeityEffects;
/*     */ import emoniph.intangible.deity.ModPriestSpells;
/*     */ import emoniph.intangible.deity.ShrineManager;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.golem.GolemPartRegistry;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.knowledge.Book;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import emoniph.intangible.player.PlayerForms;
/*     */ import emoniph.intangible.potions.ModPotions;
/*     */ import emoniph.intangible.recipes.ModRecipes;
/*     */ import emoniph.intangible.souls.RelayNetwork;
/*     */ import emoniph.intangible.souls.SoulRegistry;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import net.minecraft.item.Item.ToolMaterial;
/*     */ import net.minecraft.item.ItemArmor.ArmorMaterial;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Get
/*     */ {
/*     */   public static final String MOD_ID = "intangible";
/*     */   public static final String VERSION = "0.0.25";
/*     */   public static final String NBT_ENTITY_PERSIST = "intangiblePersist";
/*     */   
/*     */   public static Config config()
/*     */   {
/*  36 */     return Intangible.PROXY.config;
/*     */   }
/*     */   
/*     */   public static Log log() {
/*  40 */     return Intangible.PROXY.log;
/*     */   }
/*     */   
/*     */   public static PacketPipeline pipeline() {
/*  44 */     return Intangible.PROXY.packetPipeline;
/*     */   }
/*     */   
/*     */   public static ModBlocks blocks() {
/*  48 */     return Intangible.PROXY.blocks;
/*     */   }
/*     */   
/*  51 */   public static ModItems items() { return Intangible.PROXY.items; }
/*     */   
/*  53 */   public static PlayerForms forms() { return Intangible.PROXY.forms; }
/*     */   
/*  55 */   public static EffectRegistry effects() { return Intangible.PROXY.effects; }
/*     */   
/*  57 */   public static ModDeityEffects deityEffects() { return Intangible.PROXY.deityEffects; }
/*     */   
/*  59 */   public static DeityManager deities() { return Intangible.PROXY.deities; }
/*     */   
/*  61 */   public static ItemArmor.ArmorMaterial armorBoneMaterial() { return Intangible.PROXY.armorBoneMaterial; }
/*     */   
/*  63 */   public static Item.ToolMaterial toolBoneMaterial() { return Intangible.PROXY.toolBoneMaterial; }
/*     */   
/*  65 */   public static ItemArmor.ArmorMaterial armorBlueCrystalMaterial() { return Intangible.PROXY.armorBlueCrystalMaterial; }
/*     */   
/*  67 */   public static ItemArmor.ArmorMaterial armorYellowCrystalMaterial() { return Intangible.PROXY.armorYellowCrystalMaterial; }
/*     */   
/*  69 */   public static IGlow glow(World world, double x, double y, double z) { return Intangible.PROXY.glow(world, x, y, z); }
/*     */   
/*     */   public static ActionQueue actions() {
/*  72 */     return Intangible.PROXY.actionQueue;
/*     */   }
/*     */   
/*  75 */   public static SoulRegistry souls() { return Intangible.PROXY.souls; }
/*     */   
/*  77 */   public static Knowledge knowledge() { return Intangible.PROXY.knowledge; }
/*     */   
/*  79 */   public static Book book() { return Intangible.PROXY.book; }
/*     */   
/*  81 */   public static ModRecipes recipes() { return Intangible.PROXY.recipes; }
/*     */   
/*  83 */   public static ParticleFactory fx() { return Intangible.PROXY.particleFactory; }
/*     */   
/*     */   public static emoniph.intangible.fluids.ModFluids fluids() {
/*  86 */     return Intangible.PROXY.fluids;
/*     */   }
/*     */   
/*  89 */   public static RelayNetwork relays() { return Intangible.PROXY.relays; }
/*     */   
/*  91 */   public static WellNetwork wells() { return Intangible.PROXY.wells; }
/*     */   
/*  93 */   public static ModSpells spells() { return Intangible.PROXY.spells; }
/*     */   
/*  95 */   public static ModPriestSpells priest() { return Intangible.PROXY.priestSpells; }
/*     */   
/*  97 */   public static GolemPartRegistry golems() { return Intangible.PROXY.golems; }
/*     */   
/*  99 */   public static ModPotions potions() { return Intangible.PROXY.potions; }
/*     */   
/* 101 */   public static ShrineManager shrines() { return Intangible.PROXY.shrines; }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/Get.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */