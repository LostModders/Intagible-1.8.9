/*     */ package emoniph.intangible.recipes;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.entity.EntityPigVillager;
/*     */ import emoniph.intangible.init.IModPreInit;
/*     */ import emoniph.intangible.init.IModService;
/*     */ import emoniph.intangible.items.ItemPart.EnumPart;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.monster.EntityPigZombie;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraftforge.fml.common.Loader;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*     */ import net.minecraftforge.oredict.RecipeSorter;
/*     */ import net.minecraftforge.oredict.RecipeSorter.Category;
/*     */ import net.minecraftforge.oredict.ShapedOreRecipe;
/*     */ 
/*     */ public class ModRecipes implements IModService, IModPreInit
/*     */ {
/*  31 */   public static final StampingRecipeManager stamping = new StampingRecipeManager();
/*  32 */   public static final SoulRecipeManager souls = new SoulRecipeManager();
/*  33 */   public static final CreateRecipeManager creatures = new CreateRecipeManager();
/*  34 */   public static final GolemPartRecipeManager golemParts = new GolemPartRecipeManager();
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  38 */     RecipeSorter.register("intangible:dyeableitemrecipe", RecipesDyeableItem.class, RecipeSorter.Category.SHAPELESS, "after:minecraft:shapeless");
/*     */     
/*  40 */     addShapedCrafting();
/*  41 */     addStamping();
/*  42 */     addSoul();
/*  43 */     addGolemParts();
/*     */     
/*  45 */     creatures.add(new CreatureRecipe(EntityPigVillager.class, EntityPigZombie.class, SoulType.WISE, "intangible:transfusezombiepigman"));
/*  46 */     creatures.add(new CreatureRecipe(EntityVillager.class, EntityZombie.class, SoulType.WISE, "intangible:transfusezombie"));
/*     */   }
/*     */   
/*     */   private void addGolemParts() {
/*  50 */     ItemStack STONE = new ItemStack(Blocks.field_150348_b);
/*  51 */     ItemStack IRON = new ItemStack(Items.field_151042_j);
/*  52 */     ItemStack PISTON = new ItemStack(Blocks.field_150331_J);
/*  53 */     ItemStack FURNACE = new ItemStack(Blocks.field_150460_al);
/*  54 */     ItemStack CHEST = new ItemStack(Blocks.field_150486_ae);
/*     */     
/*  56 */     ItemStack DIAMOND_SHOVEL = new ItemStack(Items.field_151047_v);
/*  57 */     ItemStack DIAMOND_PICK = new ItemStack(Items.field_151046_w);
/*  58 */     ItemStack DIAMOND_AXE = new ItemStack(Items.field_151056_x);
/*     */     
/*  60 */     ItemStack PLATE = ItemPart.EnumPart.GOLEM_CONDENSED_STONE_PLATE.stackOf(1);
/*  61 */     ItemStack ARMOR = ItemPart.EnumPart.GOLEM_ARMORED_PLATE.stackOf(1);
/*  62 */     ItemStack SHOULDER = ItemPart.EnumPart.GOLEM_SHOULDER_JOINT.stackOf(1);
/*  63 */     ItemStack JOINT = ItemPart.EnumPart.GOLEM_JOINT.stackOf(1);
/*  64 */     ItemStack CORE = ItemPart.EnumPart.GOLEM_CONTROL_CORE.stackOf(1);
/*  65 */     ItemStack OCULUS = ItemPart.EnumPart.GOLEM_OCULUS.stackOf(1);
/*  66 */     ItemStack THRUSTER = ItemPart.EnumPart.GOLEM_THRUSTER.stackOf(1);
/*  67 */     ItemStack GEM = ItemPart.EnumPart.YELLOW_GEM.stackOf(1);
/*  68 */     ItemStack CONTROL_CIRCUIT = ItemPart.EnumPart.CONTROL_CIRCUIT.stackOf(1);
/*  69 */     ItemStack QUANTIFIER = ItemPart.EnumPart.QUANTIFIER.stackOf(1);
/*  70 */     ItemStack RELAY = new ItemStack(Get.blocks().SOUL_RELAY);
/*  71 */     ItemStack EMITTER = ItemPart.EnumPart.EMITTER.stackOf(1);
/*  72 */     ItemStack YELLOW_SHARD = new ItemStack(Get.items().SHARD);
/*     */     
/*  74 */     golemParts.add(new GolemPartRecipe(PLATE, STONE, STONE, STONE, STONE));
/*  75 */     golemParts.add(new GolemPartRecipe(ARMOR, PLATE, PLATE, IRON, IRON));
/*  76 */     golemParts.add(new GolemPartRecipe(JOINT, PISTON, PLATE, PLATE, PLATE));
/*  77 */     golemParts.add(new GolemPartRecipe(SHOULDER, JOINT, PISTON, ARMOR, ARMOR));
/*  78 */     golemParts.add(new GolemPartRecipe(OCULUS, GEM, GEM, PLATE, CONTROL_CIRCUIT));
/*  79 */     golemParts.add(new GolemPartRecipe(THRUSTER, FURNACE, CONTROL_CIRCUIT, FURNACE, ARMOR));
/*  80 */     golemParts.add(new GolemPartRecipe(CORE, THRUSTER, QUANTIFIER, CHEST, PLATE));
/*     */     
/*  82 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_BODY.stackOf(1), CORE, ARMOR, ARMOR, ARMOR));
/*     */     
/*     */ 
/*  85 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_BODY_TURRET.stackOf(1), CORE, ARMOR, ItemPart.EnumPart.GOLEM_ARM_BURST
/*  86 */       .stackOf(1), ARMOR));
/*     */     
/*  88 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_LEG_JUMP.stackOf(1), JOINT, ARMOR, JOINT, ARMOR));
/*     */     
/*     */ 
/*  91 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_LEG_CANDLE.stackOf(1), JOINT, ARMOR, new ItemStack(Blocks.field_150478_aa), ARMOR));
/*     */     
/*     */ 
/*  94 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_LEG_FAST.stackOf(1), JOINT, ARMOR, PLATE, ARMOR));
/*     */     
/*     */ 
/*  97 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_HEAD_ARMORED.stackOf(1), OCULUS, ARMOR, new ItemStack(Blocks.field_150467_bQ), ARMOR));
/*     */     
/*     */ 
/* 100 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_HEAD_REGEN.stackOf(1), OCULUS, PLATE, new ItemStack(Blocks.field_150381_bn), PLATE));
/*     */     
/*     */ 
/* 103 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_HEAD_HOOVER.stackOf(1), OCULUS, PLATE, new ItemStack(Blocks.field_150477_bB), PLATE));
/*     */     
/*     */ 
/* 106 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_ARM_AXE.stackOf(1), SHOULDER, ARMOR, DIAMOND_AXE, ARMOR));
/*     */     
/*     */ 
/* 109 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_ARM_CLAW.stackOf(1), SHOULDER, ARMOR, DIAMOND_SHOVEL, ARMOR));
/*     */     
/*     */ 
/* 112 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_ARM_HAMMER.stackOf(1), SHOULDER, ARMOR, DIAMOND_PICK, ARMOR));
/*     */     
/*     */ 
/* 115 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_ARM_BURST.stackOf(1), SHOULDER, ARMOR, RELAY, YELLOW_SHARD));
/*     */     
/*     */ 
/* 118 */     golemParts.add(new GolemPartRecipe(ItemPart.EnumPart.GOLEM_ARM_SWARM.stackOf(1), SHOULDER, ARMOR, RELAY, EMITTER));
/*     */   }
/*     */   
/*     */   private void addShapedCrafting()
/*     */   {
/* 123 */     ItemStack IRON_CASING_STACK = ItemPart.EnumPart.IRON_CASE.getRefStack();
/* 124 */     ItemStack SOUL_BONE_STACK = new ItemStack(Get.items().SOUL_BONE);
/* 125 */     ItemStack IRON_INGOT_STACK = new ItemStack(Items.field_151042_j);
/*     */     
/* 127 */     CraftingManager.func_77594_a().func_180302_a(new RecipesDyeableItem());
/*     */     
/*     */ 
/*     */ 
/* 131 */     GameRegistry.addShapedRecipe(IRON_CASING_STACK, new Object[] { " # ", "#  ", "###", 
/*     */     
/*     */ 
/*     */ 
/* 135 */       Character.valueOf('#'), IRON_INGOT_STACK });
/*     */     
/*     */ 
/* 138 */     GameRegistry.addShapedRecipe(new ItemStack(Get.blocks().CIRCUIT_STAMPER), new Object[] { "rcr", " p ", "   ", 
/*     */     
/*     */ 
/*     */ 
/* 142 */       Character.valueOf('p'), new ItemStack(Blocks.field_150331_J), 
/* 143 */       Character.valueOf('c'), IRON_CASING_STACK, 
/* 144 */       Character.valueOf('r'), new ItemStack(Items.field_151137_ax) });
/*     */     
/*     */ 
/* 147 */     GameRegistry.addShapedRecipe(new ItemStack(Get.blocks().BONE_CAGE), new Object[] { "###", "# #", "###", 
/*     */     
/*     */ 
/*     */ 
/* 151 */       Character.valueOf('#'), SOUL_BONE_STACK });
/*     */     
/*     */ 
/* 154 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().BELLOWS), new Object[] { "cll", "www", "   ", 
/*     */     
/*     */ 
/*     */ 
/* 158 */       Character.valueOf('l'), new ItemStack(Items.field_151116_aA), 
/* 159 */       Character.valueOf('w'), "plankWood", 
/* 160 */       Character.valueOf('c'), IRON_CASING_STACK }));
/*     */     
/*     */ 
/* 163 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().BLOW_MOLD), new Object[] { "sds", "sss", " s ", 
/*     */     
/*     */ 
/*     */ 
/* 167 */       Character.valueOf('d'), new ItemStack(Blocks.field_150409_cd), 
/* 168 */       Character.valueOf('s'), "stone" }));
/*     */     
/*     */ 
/* 171 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_FUNNEL), new Object[] { "sss", "scs", "sss", 
/*     */     
/*     */ 
/*     */ 
/* 175 */       Character.valueOf('s'), "stone", 
/* 176 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 178 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_DECANTER), new Object[] { "scc", "ssc", "csc", 
/*     */     
/*     */ 
/*     */ 
/* 182 */       Character.valueOf('s'), "stone", 
/* 183 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 185 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_GOURD), new Object[] { "scs", "scs", "scs", 
/*     */     
/*     */ 
/*     */ 
/* 189 */       Character.valueOf('s'), "stone", 
/* 190 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 192 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_SPIRAL), new Object[] { "scs", "sss", "scs", 
/*     */     
/*     */ 
/*     */ 
/* 196 */       Character.valueOf('s'), "stone", 
/* 197 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 199 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_SPITTER), new Object[] { "sss", "csc", "csc", 
/*     */     
/*     */ 
/*     */ 
/* 203 */       Character.valueOf('s'), "stone", 
/* 204 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 206 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_BOTTLE), new Object[] { "csc", "scs", "csc", 
/*     */     
/*     */ 
/*     */ 
/* 210 */       Character.valueOf('s'), "stone", 
/* 211 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 213 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_PANE), new Object[] { "ccc", "csc", "ccc", 
/*     */     
/*     */ 
/*     */ 
/* 217 */       Character.valueOf('s'), "stone", 
/* 218 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 220 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().MOLD_GEMS), new Object[] { "scs", "csc", "scs", 
/*     */     
/*     */ 
/*     */ 
/* 224 */       Character.valueOf('s'), "stone", 
/* 225 */       Character.valueOf('c'), "sand" }));
/*     */     
/* 227 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().YELLOW_CRYSTAL_BLOCK), new Object[] { "ccc", "ccc", "ccc", 
/*     */     
/*     */ 
/*     */ 
/* 231 */       Character.valueOf('c'), new ItemStack(Get.items().SHARD) }));
/*     */     
/* 233 */     GameRegistry.addShapelessRecipe(new ItemStack(Get.items().SHARD, 9), new Object[] { new ItemStack(Get.blocks().YELLOW_CRYSTAL_BLOCK) });
/*     */     
/* 235 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().BLUE_CRYSTAL_BLOCK), new Object[] { "ccc", "ccc", "ccc", 
/*     */     
/*     */ 
/*     */ 
/* 239 */       Character.valueOf('c'), new ItemStack(Get.blocks().CRYSTAL) }));
/*     */     
/* 241 */     GameRegistry.addShapelessRecipe(new ItemStack(Get.blocks().CRYSTAL, 9), new Object[] { new ItemStack(Get.blocks().BLUE_CRYSTAL_BLOCK) });
/*     */     
/* 243 */     ItemStack controlCircuit = new ItemStack(Get.items().PART, 1, ItemPart.EnumPart.CONTROL_CIRCUIT.getMetadata());
/* 244 */     ItemStack stoneRing = new ItemStack(Get.items().PART, 1, ItemPart.EnumPart.STONE_RING.getMetadata());
/* 245 */     ItemStack emitter = ItemPart.EnumPart.EMITTER.stackOf(1);
/* 246 */     ItemStack conduit = ItemPart.EnumPart.BONE_CONDUIT.stackOf(1);
/* 247 */     ItemStack quantifier = ItemPart.EnumPart.QUANTIFIER.stackOf(1);
/* 248 */     ItemStack ponderanceLatice = ItemPart.EnumPart.PONDERANCE_LATTICE.stackOf(1);
/* 249 */     ItemStack chiseledQuartzBlock = new ItemStack(Blocks.field_150371_ca, 1, 1);
/* 250 */     ItemStack blueGem = ItemPart.EnumPart.BLUE_GEM.stackOf(1);
/* 251 */     ItemStack soulRelay = new ItemStack(Get.blocks().SOUL_RELAY);
/* 252 */     ItemStack piston = new ItemStack(Blocks.field_150331_J);
/* 253 */     ItemStack crystalbone = new ItemStack(Get.items().PART, 1, ItemPart.EnumPart.CRYSTALLIZED_SOULBONE.getMetadata());
/*     */     
/* 255 */     GameRegistry.addRecipe(new ShapedOreRecipe(soulRelay, new Object[] { "rcr", "rgr", "rcr", 
/*     */     
/*     */ 
/*     */ 
/* 259 */       Character.valueOf('g'), blueGem, 
/* 260 */       Character.valueOf('c'), controlCircuit, 
/* 261 */       Character.valueOf('r'), stoneRing }));
/*     */     
/* 263 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().INFUSER), new Object[] { "ses", "sps", "sqs", 
/*     */     
/*     */ 
/*     */ 
/* 267 */       Character.valueOf('e'), soulRelay, 
/* 268 */       Character.valueOf('p'), ponderanceLatice, 
/* 269 */       Character.valueOf('q'), quantifier, 
/* 270 */       Character.valueOf('s'), chiseledQuartzBlock }));
/*     */     
/* 272 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().SOUL_FORGE), new Object[] { " e ", "cqc", "rrr", 
/*     */     
/*     */ 
/*     */ 
/* 276 */       Character.valueOf('e'), emitter, 
/* 277 */       Character.valueOf('c'), controlCircuit, 
/* 278 */       Character.valueOf('q'), quantifier, 
/* 279 */       Character.valueOf('r'), soulRelay }));
/*     */     
/* 281 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().RECONSTRUCTOR), new Object[] { "beb", "sis", "bcb", 
/*     */     
/*     */ 
/*     */ 
/* 285 */       Character.valueOf('i'), new ItemStack(Get.blocks().INFUSER), 
/* 286 */       Character.valueOf('c'), controlCircuit, 
/* 287 */       Character.valueOf('b'), conduit, 
/* 288 */       Character.valueOf('s'), chiseledQuartzBlock, 
/* 289 */       Character.valueOf('e'), emitter }));
/*     */     
/* 291 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().GOLEM_PART_ASSEMBLER), new Object[] { " p ", "bcb", "iri", 
/*     */     
/*     */ 
/*     */ 
/* 295 */       Character.valueOf('p'), piston, 
/* 296 */       Character.valueOf('i'), IRON_CASING_STACK, 
/* 297 */       Character.valueOf('r'), soulRelay, 
/* 298 */       Character.valueOf('c'), controlCircuit, 
/* 299 */       Character.valueOf('b'), conduit }));
/*     */     
/* 301 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().GOLEM_FACTORY), new Object[] { " i ", "cip", " b ", 
/*     */     
/*     */ 
/*     */ 
/* 305 */       Character.valueOf('i'), new ItemStack(Blocks.field_150339_S), 
/* 306 */       Character.valueOf('b'), new ItemStack(Blocks.field_150486_ae), 
/* 307 */       Character.valueOf('c'), controlCircuit, 
/* 308 */       Character.valueOf('p'), ponderanceLatice }));
/*     */     
/* 310 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().SYNTHETIC_RESONATOR), new Object[] { "ccc", " q ", "iri", 
/*     */     
/*     */ 
/*     */ 
/* 314 */       Character.valueOf('i'), new ItemStack(Items.field_151042_j), 
/* 315 */       Character.valueOf('c'), crystalbone, 
/* 316 */       Character.valueOf('q'), quantifier, 
/* 317 */       Character.valueOf('r'), soulRelay }));
/*     */     
/* 319 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().PLINTH, 3), new Object[] { "sss", " r ", "srs", 
/*     */     
/*     */ 
/*     */ 
/* 323 */       Character.valueOf('r'), stoneRing, 
/* 324 */       Character.valueOf('s'), "stone" }));
/*     */     
/* 326 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().OFFERING_PLATE, 3), new Object[] { "ncn", "cgc", "ncn", 
/*     */     
/*     */ 
/*     */ 
/* 330 */       Character.valueOf('n'), "nuggetGold", 
/* 331 */       Character.valueOf('g'), "ingotGold", 
/* 332 */       Character.valueOf('c'), blueGem }));
/*     */     
/* 334 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().LARGE_BUTTON), new Object[] { "b", "s", "b", 
/*     */     
/*     */ 
/*     */ 
/* 338 */       Character.valueOf('b'), new ItemStack(Blocks.field_150430_aB), 
/* 339 */       Character.valueOf('s'), new ItemStack(Items.field_151123_aH) }));
/*     */     
/* 341 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().LARGE_LEVER), new Object[] { "b", "s", "b", 
/*     */     
/*     */ 
/*     */ 
/* 345 */       Character.valueOf('b'), new ItemStack(Blocks.field_150442_at), 
/* 346 */       Character.valueOf('s'), new ItemStack(Items.field_151123_aH) }));
/*     */     
/*     */ 
/* 349 */     ItemStack BLUE_CRYSTAL = new ItemStack(Get.blocks().CRYSTAL);
/* 350 */     ItemStack YELLOW_CRYSTAL = new ItemStack(Get.items().SHARD);
/*     */     
/* 352 */     GameRegistry.addShapedRecipe(new ItemStack(Get.items().BLUE_CRYSTAL_HELMET), new Object[] { "bbb", "b b", 
/*     */     
/*     */ 
/* 355 */       Character.valueOf('b'), BLUE_CRYSTAL });
/*     */     
/* 357 */     GameRegistry.addShapedRecipe(new ItemStack(Get.items().YELLOW_CRYSTAL_HELMET), new Object[] { "bbb", "b b", 
/*     */     
/*     */ 
/* 360 */       Character.valueOf('b'), YELLOW_CRYSTAL });
/*     */     
/* 362 */     GameRegistry.addShapedRecipe(new ItemStack(Get.items().BLUE_CRYSTAL_CHESTPLATE), new Object[] { "b b", "bbb", "bbb", 
/*     */     
/*     */ 
/*     */ 
/* 366 */       Character.valueOf('b'), BLUE_CRYSTAL });
/*     */     
/* 368 */     GameRegistry.addShapedRecipe(new ItemStack(Get.items().BLUE_CRYSTAL_TROUSERS), new Object[] { "bbb", "b b", "b b", 
/*     */     
/*     */ 
/*     */ 
/* 372 */       Character.valueOf('b'), BLUE_CRYSTAL });
/*     */     
/* 374 */     GameRegistry.addShapedRecipe(new ItemStack(Get.items().BLUE_CRYSTAL_BOOTS), new Object[] { "b b", "b b", 
/*     */     
/*     */ 
/* 377 */       Character.valueOf('b'), BLUE_CRYSTAL });
/*     */     
/* 379 */     GameRegistry.addShapedRecipe(new ItemStack(Get.items().SOUL_SPEAR), new Object[] { "  c", " b ", "b  ", 
/*     */     
/*     */ 
/*     */ 
/* 383 */       Character.valueOf('c'), controlCircuit, 
/* 384 */       Character.valueOf('b'), SOUL_BONE_STACK });
/*     */     
/* 386 */     ItemStack THRUSTER = ItemPart.EnumPart.GOLEM_THRUSTER.stackOf(1);
/*     */     
/* 388 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().DEITY_HAMMER), new Object[] { " e ", "ctc", "cqc", 
/*     */     
/*     */ 
/*     */ 
/* 392 */       Character.valueOf('c'), chiseledQuartzBlock, 
/* 393 */       Character.valueOf('e'), emitter, 
/* 394 */       Character.valueOf('t'), THRUSTER, 
/* 395 */       Character.valueOf('q'), quantifier }));
/*     */     
/* 397 */     ItemStack yellowCrystal = new ItemStack(Get.items().SHARD);
/*     */     
/* 399 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().PANTHEON), new Object[] { "cgc", "cec", "cpc", 
/*     */     
/*     */ 
/*     */ 
/* 403 */       Character.valueOf('e'), emitter, 
/* 404 */       Character.valueOf('p'), ponderanceLatice, 
/* 405 */       Character.valueOf('c'), chiseledQuartzBlock, 
/* 406 */       Character.valueOf('g'), yellowCrystal }));
/*     */     
/* 408 */     ItemStack blueCrystal = new ItemStack(Get.blocks().CRYSTAL);
/* 409 */     ItemStack OCULUS = ItemPart.EnumPart.GOLEM_OCULUS.stackOf(1);
/*     */     
/* 411 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().SOUL_WRENCH), new Object[] { "byb", "coc", "cqc", 
/*     */     
/*     */ 
/*     */ 
/* 415 */       Character.valueOf('b'), blueCrystal, 
/* 416 */       Character.valueOf('y'), yellowCrystal, 
/* 417 */       Character.valueOf('q'), quantifier, 
/* 418 */       Character.valueOf('c'), chiseledQuartzBlock, 
/* 419 */       Character.valueOf('o'), OCULUS, 
/* 420 */       Character.valueOf('c'), blueGem }));
/*     */     
/*     */ 
/* 423 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.blocks().SHRINE), new Object[] { " q ", "qgq", 
/*     */     
/*     */ 
/* 426 */       Character.valueOf('q'), chiseledQuartzBlock, 
/* 427 */       Character.valueOf('g'), blueGem }));
/*     */     
/*     */ 
/* 430 */     GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Get.items().ROD), new Object[] { "  b", " s ", "s  ", 
/*     */     
/*     */ 
/*     */ 
/* 434 */       Character.valueOf('s'), "stickWood", 
/* 435 */       Character.valueOf('b'), ItemPart.EnumPart.BONE_SPLINTERS.getRefStack() }));
/*     */   }
/*     */   
/*     */   private void addStamping() {
/* 439 */     ItemStack soulbone = new ItemStack(Get.items().SOUL_BONE);
/* 440 */     ItemStack blueCrystal = new ItemStack(Get.blocks().CRYSTAL);
/* 441 */     ItemStack knowledgeGem = new ItemStack(Get.items().KNOWLEDGE_GEM);
/* 442 */     ItemStack yellowCrystal = new ItemStack(Get.items().SHARD);
/* 443 */     ItemStack redstone = new ItemStack(Items.field_151137_ax);
/* 444 */     ItemStack boneSplinters = ItemPart.EnumPart.BONE_SPLINTERS.stackOf(1);
/* 445 */     ItemStack boneConduit = ItemPart.EnumPart.BONE_CONDUIT.stackOf(1);
/* 446 */     ItemStack controlCircuit = ItemPart.EnumPart.CONTROL_CIRCUIT.stackOf(1);
/* 447 */     ItemStack stoneRing = ItemPart.EnumPart.STONE_RING.stackOf(1);
/* 448 */     ItemStack stone = new ItemStack(Blocks.field_150348_b);
/* 449 */     ItemStack blueGem = ItemPart.EnumPart.BLUE_GEM.stackOf(1);
/* 450 */     ItemStack yellowGem = ItemPart.EnumPart.YELLOW_GEM.stackOf(1);
/* 451 */     ItemStack emitter = ItemPart.EnumPart.EMITTER.stackOf(1);
/* 452 */     ItemStack quantifier = ItemPart.EnumPart.QUANTIFIER.stackOf(1);
/* 453 */     ItemStack ponderanceLatice = ItemPart.EnumPart.PONDERANCE_LATTICE.stackOf(1);
/* 454 */     ItemStack foci = new ItemStack(Get.items().FOCI);
/*     */     
/* 456 */     stamping.add(new StampingRecipe(knowledgeGem, blueCrystal, soulbone, soulbone, redstone));
/*     */     
/* 458 */     stamping.add(new StampingRecipe(ItemPart.EnumPart.STONE_RING.stackOf(4), stone, stone, stone, stone));
/*     */     
/* 460 */     stamping.add(new StampingRecipe(ItemPart.EnumPart.BONE_SPLINTERS.stackOf(6), soulbone, null, null, null));
/*     */     
/* 462 */     stamping.add(new StampingRecipe(ItemPart.EnumPart.BONE_CONDUIT.stackOf(3), redstone, boneSplinters, boneSplinters, boneSplinters));
/*     */     
/* 464 */     stamping.add(new StampingRecipe(controlCircuit, blueGem, boneConduit, boneConduit, boneConduit));
/*     */     
/* 466 */     stamping.add(new StampingRecipe(emitter, blueCrystal, controlCircuit, redstone, controlCircuit));
/*     */     
/* 468 */     stamping.add(new StampingRecipe(quantifier, emitter, yellowCrystal, emitter, controlCircuit));
/*     */     
/* 470 */     stamping.add(new StampingRecipe(ponderanceLatice, controlCircuit, blueGem, controlCircuit, yellowGem));
/*     */     
/* 472 */     stamping.add(new StampingRecipe(foci, yellowCrystal, boneConduit, controlCircuit, controlCircuit));
/*     */     
/*     */ 
/* 475 */     stamping.add(new StampingRecipe(new ItemStack(Get.items().VILLAGE_FINDER), ponderanceLatice, boneConduit, controlCircuit, boneConduit));
/*     */   }
/*     */   
/*     */   private void addSoul()
/*     */   {
/* 480 */     ItemStack blueCrystal = new ItemStack(Get.blocks().CRYSTAL);
/* 481 */     ItemStack yellowCrystal = new ItemStack(Get.items().SHARD);
/* 482 */     ItemStack controlCircuit = new ItemStack(Get.items().PART, 1, ItemPart.EnumPart.CONTROL_CIRCUIT.getMetadata());
/* 483 */     ItemStack boneConduit = new ItemStack(Get.items().PART, 1, ItemPart.EnumPart.BONE_CONDUIT.getMetadata());
/* 484 */     ItemStack soulbone = new ItemStack(Get.items().SOUL_BONE);
/* 485 */     ItemStack crystalbone = new ItemStack(Get.items().PART, 1, ItemPart.EnumPart.CRYSTALLIZED_SOULBONE.getMetadata());
/*     */     
/* 487 */     ItemStack iron = new ItemStack(Items.field_151042_j);
/* 488 */     ItemStack obsidian = new ItemStack(Blocks.field_150343_Z);
/* 489 */     ItemStack gold = new ItemStack(Items.field_151043_k);
/* 490 */     ItemStack book = new ItemStack(Items.field_151122_aG);
/* 491 */     ItemStack enderPearl = new ItemStack(Items.field_151079_bi);
/* 492 */     ItemStack spiderEye = new ItemStack(Items.field_151070_bp);
/* 493 */     ItemStack diamond = new ItemStack(Items.field_151045_i);
/* 494 */     ItemStack ghastTear = new ItemStack(Items.field_151073_bk);
/* 495 */     ItemStack witherSkull = new ItemStack(Items.field_151144_bL, 1, 1);
/* 496 */     ItemStack salmon = new ItemStack(Items.field_151115_aP, 1, 1);
/* 497 */     ItemStack fish = new ItemStack(Items.field_151115_aP, 1, 0);
/*     */     
/* 499 */     souls.add(new SoulRecipe(new ItemStack(Get.items().PART, 4, ItemPart.EnumPart.CRYSTALLIZED_SOULBONE.getMetadata()), new ItemStack[] { blueCrystal, soulbone, blueCrystal, soulbone, blueCrystal, soulbone, blueCrystal, soulbone }, new SoulSet()));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 504 */     souls.add(new SoulRecipe(new ItemStack(Get.items().SOUL_HELMET), new ItemStack[] { blueCrystal, crystalbone, boneConduit, crystalbone, controlCircuit, crystalbone, boneConduit, crystalbone }, new SoulSet()
/*     */     
/* 506 */       .add(SoulType.WISE, 1).add(SoulType.UNHINGED, 1)));
/*     */     
/*     */ 
/* 509 */     souls.add(new SoulRecipe(new ItemStack(Get.items().SOUL_CHESTPLATE), new ItemStack[] { boneConduit, crystalbone, crystalbone, crystalbone, controlCircuit, crystalbone, crystalbone, crystalbone }, new SoulSet()
/*     */     
/* 511 */       .add(SoulType.IMMUTABLE, 1).add(SoulType.BENIGN, 2)));
/*     */     
/*     */ 
/* 514 */     souls.add(new SoulRecipe(new ItemStack(Get.items().SOUL_TROUSERS), new ItemStack[] { boneConduit, crystalbone, boneConduit, crystalbone, controlCircuit, crystalbone, boneConduit, crystalbone }, new SoulSet()
/*     */     
/* 516 */       .add(SoulType.PREDATORY, 2).add(SoulType.BENIGN, 1)));
/*     */     
/*     */ 
/* 519 */     souls.add(new SoulRecipe(new ItemStack(Get.items().SOUL_BOOTS), new ItemStack[] { crystalbone, boneConduit, boneConduit, crystalbone, controlCircuit, crystalbone, boneConduit, boneConduit }, new SoulSet()
/*     */     
/* 521 */       .add(SoulType.BENIGN, 2)));
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 527 */     ItemStack[] armorPieces = { new ItemStack(Get.items().SOUL_HELMET), new ItemStack(Get.items().SOUL_CHESTPLATE), new ItemStack(Get.items().SOUL_TROUSERS), new ItemStack(Get.items().SOUL_BOOTS) };
/*     */     
/* 529 */     for (ItemStack armor : armorPieces) {
/* 530 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.NOBLE, new ItemStack[] { armor, null, gold, null, diamond, null, gold, null }, new SoulSet()
/*     */       
/* 532 */         .add(SoulType.NOBLE, 1)));
/*     */       
/* 534 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.BENIGN, new ItemStack[] { armor, null, fish, null, salmon, null, fish, null }, new SoulSet()
/*     */       
/* 536 */         .add(SoulType.BENIGN, 1)));
/*     */       
/* 538 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.IMMUTABLE, new ItemStack[] { armor, null, obsidian, null, obsidian, null, obsidian, null }, new SoulSet()
/*     */       
/* 540 */         .add(SoulType.IMMUTABLE, 1)));
/*     */       
/* 542 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.PREDATORY, new ItemStack[] { armor, null, spiderEye, null, spiderEye, null, spiderEye, null }, new SoulSet()
/*     */       
/* 544 */         .add(SoulType.PREDATORY, 1)));
/*     */       
/* 546 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.DOOMED, new ItemStack[] { armor, null, ghastTear, null, witherSkull, null, ghastTear, null }, new SoulSet()
/*     */       
/* 548 */         .add(SoulType.DOOMED, 1)));
/*     */       
/* 550 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.UNHINGED, new ItemStack[] { armor, null, enderPearl, null, enderPearl, null, enderPearl, null }, new SoulSet()
/*     */       
/* 552 */         .add(SoulType.UNHINGED, 1)));
/*     */       
/* 554 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.MALLEABLE, new ItemStack[] { armor, null, iron, null, iron, null, iron, null }, new SoulSet()
/*     */       
/* 556 */         .add(SoulType.MALLEABLE, 1)));
/*     */       
/* 558 */       souls.add(new ArmorInfuseSoulRecipe(SoulType.WISE, new ItemStack[] { armor, null, book, null, book, null, book, null }, new SoulSet()
/*     */       
/* 560 */         .add(SoulType.WISE, 1)));
/*     */     }
/*     */     
/* 563 */     ItemStack DEFENSE = new ItemStack(Get.blocks().DEFENSE);
/*     */     
/* 565 */     souls.add(new SoulRecipe(DEFENSE, new ItemStack[] { yellowCrystal, null, ItemPart.EnumPart.YELLOW_GEM
/*     */     
/*     */ 
/*     */ 
/* 569 */       .getRefStack(), null, ItemPart.EnumPart.BLUE_GEM
/*     */       
/* 571 */       .getRefStack(), null, ItemPart.EnumPart.YELLOW_GEM
/*     */       
/* 573 */       .getRefStack(), null }, new SoulSet()
/*     */       
/*     */ 
/* 576 */       .add(SoulType.BENIGN, 1).add(SoulType.PREDATORY, 1).add(SoulType.UNHINGED, 1).add(SoulType.WISE, 1)));
/*     */     
/* 578 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.NOBLE, new ItemStack[] { DEFENSE, null, gold, null, diamond, null, gold, null }, new SoulSet()
/*     */     
/* 580 */       .add(SoulType.NOBLE, 1)));
/*     */     
/* 582 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.BENIGN, new ItemStack[] { DEFENSE, null, fish, null, salmon, null, fish, null }, new SoulSet()
/*     */     
/* 584 */       .add(SoulType.BENIGN, 1)));
/*     */     
/* 586 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.IMMUTABLE, new ItemStack[] { DEFENSE, null, obsidian, null, obsidian, null, obsidian, null }, new SoulSet()
/*     */     
/* 588 */       .add(SoulType.IMMUTABLE, 1)));
/*     */     
/* 590 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.PREDATORY, new ItemStack[] { DEFENSE, null, spiderEye, null, spiderEye, null, spiderEye, null }, new SoulSet()
/*     */     
/* 592 */       .add(SoulType.PREDATORY, 1)));
/*     */     
/* 594 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.DOOMED, new ItemStack[] { DEFENSE, null, ghastTear, null, witherSkull, null, ghastTear, null }, new SoulSet()
/*     */     
/* 596 */       .add(SoulType.DOOMED, 1)));
/*     */     
/* 598 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.UNHINGED, new ItemStack[] { DEFENSE, null, enderPearl, null, enderPearl, null, enderPearl, null }, new SoulSet()
/*     */     
/* 600 */       .add(SoulType.UNHINGED, 1)));
/*     */     
/* 602 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.MALLEABLE, new ItemStack[] { DEFENSE, null, iron, null, iron, null, iron, null }, new SoulSet()
/*     */     
/* 604 */       .add(SoulType.MALLEABLE, 1)));
/*     */     
/* 606 */     souls.add(new CrystalInfuseSoulRecipe(SoulType.WISE, new ItemStack[] { DEFENSE, null, book, null, book, null, book, null }, new SoulSet()
/*     */     
/* 608 */       .add(SoulType.WISE, 1)));
/*     */     
/*     */ 
/* 611 */     ItemStack spear = new ItemStack(Get.items().SOUL_SPEAR);
/*     */     
/* 613 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.NOBLE, new ItemStack[] { spear, null, gold, null, diamond, null, gold, null }, new SoulSet()
/*     */     
/* 615 */       .add(SoulType.NOBLE, 1)));
/*     */     
/* 617 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.BENIGN, new ItemStack[] { spear, null, fish, null, salmon, null, fish, null }, new SoulSet()
/*     */     
/* 619 */       .add(SoulType.BENIGN, 1)));
/*     */     
/* 621 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.IMMUTABLE, new ItemStack[] { spear, null, obsidian, null, obsidian, null, obsidian, null }, new SoulSet()
/*     */     
/* 623 */       .add(SoulType.IMMUTABLE, 1)));
/*     */     
/* 625 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.PREDATORY, new ItemStack[] { spear, null, spiderEye, null, spiderEye, null, spiderEye, null }, new SoulSet()
/*     */     
/* 627 */       .add(SoulType.PREDATORY, 1)));
/*     */     
/* 629 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.DOOMED, new ItemStack[] { spear, null, ghastTear, null, witherSkull, null, ghastTear, null }, new SoulSet()
/*     */     
/* 631 */       .add(SoulType.DOOMED, 1)));
/*     */     
/* 633 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.UNHINGED, new ItemStack[] { spear, null, enderPearl, null, enderPearl, null, enderPearl, null }, new SoulSet()
/*     */     
/* 635 */       .add(SoulType.UNHINGED, 1)));
/*     */     
/* 637 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.MALLEABLE, new ItemStack[] { spear, null, iron, null, iron, null, iron, null }, new SoulSet()
/*     */     
/* 639 */       .add(SoulType.MALLEABLE, 1)));
/*     */     
/* 641 */     souls.add(new WeaponInfuseSoulRecipe(SoulType.WISE, new ItemStack[] { spear, null, book, null, book, null, book, null }, new SoulSet()
/*     */     
/* 643 */       .add(SoulType.WISE, 1)));
/*     */     
/*     */ 
/* 646 */     Object baubles = new ArrayList();
/*     */     
/*     */     ItemStack goldNugget;
/* 649 */     if (Loader.isModLoaded("Baubles")) {
/* 650 */       goldNugget = new ItemStack(Items.field_151074_bl);
/* 651 */       souls.add(new SoulRecipe(new ItemStack(Get.items().SOULBOUND_RING), new ItemStack[] { diamond, goldNugget, goldNugget, goldNugget, goldNugget, goldNugget, goldNugget, goldNugget }, new SoulSet()));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 656 */       ((List)baubles).add(new ItemStack(Get.items().SOULBOUND_RING));
/*     */     }
/*     */     
/* 659 */     for (ItemStack bauble : (List)baubles) {
/* 660 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.NOBLE, new ItemStack[] { bauble, null, gold, null, diamond, null, gold, null }, new SoulSet()
/*     */       
/* 662 */         .add(SoulType.NOBLE, 1)));
/*     */       
/* 664 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.BENIGN, new ItemStack[] { bauble, null, fish, null, salmon, null, fish, null }, new SoulSet()
/*     */       
/* 666 */         .add(SoulType.BENIGN, 1)));
/*     */       
/* 668 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.IMMUTABLE, new ItemStack[] { bauble, null, obsidian, null, obsidian, null, obsidian, null }, new SoulSet()
/*     */       
/* 670 */         .add(SoulType.IMMUTABLE, 1)));
/*     */       
/* 672 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.PREDATORY, new ItemStack[] { bauble, null, spiderEye, null, spiderEye, null, spiderEye, null }, new SoulSet()
/*     */       
/* 674 */         .add(SoulType.PREDATORY, 1)));
/*     */       
/* 676 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.DOOMED, new ItemStack[] { bauble, null, ghastTear, null, witherSkull, null, ghastTear, null }, new SoulSet()
/*     */       
/* 678 */         .add(SoulType.DOOMED, 1)));
/*     */       
/* 680 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.UNHINGED, new ItemStack[] { bauble, null, enderPearl, null, enderPearl, null, enderPearl, null }, new SoulSet()
/*     */       
/* 682 */         .add(SoulType.UNHINGED, 1)));
/*     */       
/* 684 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.MALLEABLE, new ItemStack[] { bauble, null, iron, null, iron, null, iron, null }, new SoulSet()
/*     */       
/* 686 */         .add(SoulType.MALLEABLE, 1)));
/*     */       
/* 688 */       souls.add(new BaubleInfuseSoulRecipe(SoulType.WISE, new ItemStack[] { bauble, null, book, null, book, null, book, null }, new SoulSet()
/*     */       
/* 690 */         .add(SoulType.WISE, 1)));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/ModRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */