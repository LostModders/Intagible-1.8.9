/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IBookPage;
/*     */ import emoniph.intangible.api.IBookPageResources;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.ISoulForgeClient;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.PageType;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.deity.DeityEffectTypeRegistry;
/*     */ import emoniph.intangible.deity.DeityEffectTypeRegistry.EffectEntry;
/*     */ import emoniph.intangible.deity.ModDeityEffects;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem;
/*     */ import emoniph.intangible.items.ItemPart.EnumPart;
/*     */ import emoniph.intangible.items.ItemPart.PartGroup;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.recipes.CreatureRecipe;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.Point2d;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class Book implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModInitClient
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Page index;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Page extensions;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private boolean hasExtensions;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private Map<String, Page> pages;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void init(Minecraft mc, RenderItem renderItem)
/*     */   {
/*  49 */     this.pages = new java.util.HashMap();
/*  50 */     this.index = new Page("index", this);
/*  51 */     this.index.title("book.intangible:index.title")
/*  52 */       .image("intangible:textures/gui/soulwheel.png", 64, 64);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  57 */     IBookPage souls = this.index.createPage("souls", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().MAT_SOULBONE }).para("book.intangible:souls.p1", true);
/*     */     
/*  59 */     souls.createPage("detectingsouls", PageType.CHILD)
/*  60 */       .knowledge(new IKnol[] {Get.knowledge().MAT_SOULBONE, Get.knowledge().MAT_CRYSTAL })
/*  61 */       .image("intangible:textures/gui/soulresearch.png", 64, 64)
/*  62 */       .para("book.intangible:detectingsouls.p1", true);
/*     */     
/*  64 */     souls.createPage("extractingsouls", PageType.CHILD)
/*  65 */       .knowledge(new IKnol[] {Get.knowledge().SOULS })
/*  66 */       .para("book.intangible:extractingsouls.p1", true);
/*     */     
/*  68 */     souls.createPage("movingsouls", PageType.CHILD)
/*  69 */       .knowledge(new IKnol[] {Get.knowledge().SOULS })
/*  70 */       .para("book.intangible:movingsouls.p1", true);
/*     */     
/*  72 */     souls.createPage("storingsouls", PageType.CHILD)
/*  73 */       .knowledge(new IKnol[] {Get.knowledge().SOULS })
/*  74 */       .para("book.intangible:storingsouls.p1", true);
/*     */     
/*  76 */     souls.createPage("absorbingsouls", PageType.CHILD)
/*  77 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION })
/*  78 */       .para("book.intangible:absorbingsouls.p1", true);
/*     */     
/*     */ 
/*     */ 
/*  82 */     IBookPage casting = souls.createPage("spellcasting", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book.intangible:spellcasting.p1");
/*     */     
/*  84 */     casting.createPage("spellcastingfoci", PageType.CHILD)
/*  85 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION })
/*  86 */       .para("book.intangible:spellcastingfoci.p1", true);
/*     */     
/*     */ 
/*     */ 
/*  90 */     IBookPage spellTypes = casting.createPage("spellcastingspelltypes", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book.intangible:spellcastingspelltypes.p1");
/*     */     
/*  92 */     spellTypes.createPage("spellcastingprepared", PageType.CHILD)
/*  93 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION })
/*  94 */       .para("book.intangible:spellcastingprepared.p1", true);
/*     */     
/*  96 */     spellTypes.createPage("spellcastingpassive", PageType.CHILD)
/*  97 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION })
/*  98 */       .para("book.intangible:spellcastingpassive.p1", true);
/*     */     
/* 100 */     spellTypes.createPage("spellcastingfocused", PageType.CHILD)
/* 101 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 102 */       .para("book.intangible:spellcastingfocused.p1", true);
/*     */     
/* 104 */     casting.createPage("spellcastingrebellion", PageType.CHILD)
/* 105 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 106 */       .para("book.intangible:spellcastingrebellion.p1", true);
/*     */     
/*     */ 
/* 109 */     IBookPage transfusion = souls.createPage("soultransfusion", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     
/* 111 */     transfusion.createPage("soultransfusionprocess", PageType.CHILD)
/* 112 */       .image("intangible:textures/gui/reconstructor.png", 128, 64)
/* 113 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 114 */       .para("book.intangible:soultransfusionprocess.p1", true);
/*     */     
/* 116 */     transfusion.createPage("soultransfusionstructure", PageType.CHILD, new MultiBlockPlanSoulTransfuser())
/* 117 */       .knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     
/*     */ 
/* 120 */     IBookPage transfusionRecipes = transfusion.createPage("soultransfusionrecipes", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOULS, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     
/* 122 */     int i = -1;
/* 123 */     int subPage = 1;
/* 124 */     int BULLETS_PER_PAGE = 9;
/*     */     
/* 126 */     ISoulSet transfusionCost = new SoulSet().add(SoulType.BENIGN, 1).add(SoulType.PREDATORY, 1).add(SoulType.UNHINGED, 1);
/* 127 */     Get.recipes(); for (CreatureRecipe recipe : emoniph.intangible.recipes.ModRecipes.creatures) {
/* 128 */       i++; if ((i % 9 == 0) && (i > 0))
/*     */       {
/* 130 */         transfusionRecipes = transfusionRecipes.createPage("soultransfusionrecipes" + ++subPage, PageType.SIBLING).title("book.intangible:soultransfusionrecipes.title").knowledge(new IKnol[] { Get.knowledge().SOULS, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 136 */       transfusionRecipes.createPage(recipe.getBookKey(), PageType.CHILD).knowledge(new IKnol[] { Get.knowledge().SOULS, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book." + recipe.getBookKey() + ".p1").usedSouls(transfusionCost).consumedSouls(recipe.getSoulSet());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 142 */     souls.createPage("intangibility", PageType.CHILD).knowledge(new IKnol[] { Get.knowledge().SOULS, Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book.intangible:intangibility.p1", true);
/*     */     
/*     */ 
/* 145 */     IBookPage soultypes = souls.createPage("soultypes", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOULS });
/*     */     
/* 147 */     soultypes.createPage("benign", PageType.CHILD)
/* 148 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_BENIGN })
/* 149 */       .para("book.intangible:benign.p1", true);
/*     */     
/* 151 */     soultypes.createPage("immutable", PageType.CHILD)
/* 152 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE })
/* 153 */       .para("book.intangible:immutable.p1", true);
/*     */     
/* 155 */     soultypes.createPage("predatory", PageType.CHILD)
/* 156 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_PREDATORY })
/* 157 */       .para("book.intangible:predatory.p1", true);
/*     */     
/* 159 */     soultypes.createPage("doomed", PageType.CHILD)
/* 160 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_DOOMED })
/* 161 */       .para("book.intangible:doomed.p1", true);
/*     */     
/* 163 */     soultypes.createPage("unhinged", PageType.CHILD)
/* 164 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_UNHINGED })
/* 165 */       .para("book.intangible:unhinged.p1", true);
/*     */     
/* 167 */     soultypes.createPage("malleable", PageType.CHILD)
/* 168 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE })
/* 169 */       .para("book.intangible:malleable.p1", true);
/*     */     
/* 171 */     soultypes.createPage("wise", PageType.CHILD)
/* 172 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_WISE })
/* 173 */       .para("book.intangible:wise.p1", true);
/*     */     
/* 175 */     soultypes.createPage("noble", PageType.CHILD)
/* 176 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_NOBLE })
/* 177 */       .para("book.intangible:noble.p1", true);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 182 */     IBookPage materials = this.index.createPage("materials", PageType.CHILD).title("book.intangible:materials.title");
/*     */     
/* 184 */     materials.createPage("soulbone", PageType.CHILD)
/* 185 */       .knowledge(new IKnol[] {Get.knowledge().MAT_SOULBONE })
/* 186 */       .image("intangible:textures/items/soulbone.png", 16, 16)
/* 187 */       .para("book.intangible:soulbone.p1", true);
/*     */     
/* 189 */     materials.createPage("crystal", PageType.CHILD)
/* 190 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 191 */       .image("intangible:textures/items/crystal.png", 16, 16)
/* 192 */       .para(net.minecraft.util.StatCollector.func_74838_a("book.intangible:crystal.p1"), true);
/*     */     
/*     */ 
/*     */ 
/* 196 */     IBookPage sentientStone = materials.createPage("sentientstone", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOULS }).para("book.intangible:sentientstone.p1");
/*     */     
/* 198 */     sentientStone.createPage("makingsentientstone", PageType.CHILD)
/* 199 */       .knowledge(new IKnol[] {Get.knowledge().SOULS })
/* 200 */       .image("intangible:textures/gui/sentientstone.png", 64, 64)
/* 201 */       .para("book.intangible:makingsentientstone.p1", true);
/*     */     
/*     */ 
/* 204 */     IBookPage stoneTypes = sentientStone.createPage("sentientstonetypes", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOULS });
/*     */     
/* 206 */     stoneTypes.createPage("benignstone", PageType.CHILD)
/* 207 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_BENIGN })
/* 208 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.BENIGN.getMetadata()))
/* 209 */       .para("book.intangible:benignstone.p1", true);
/*     */     
/* 211 */     stoneTypes.createPage("immutablestone", PageType.CHILD)
/* 212 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE })
/* 213 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.IMMUTABLE.getMetadata()))
/* 214 */       .para("book.intangible:immutablestone.p1", true);
/*     */     
/* 216 */     stoneTypes.createPage("predatorystone", PageType.CHILD)
/* 217 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_PREDATORY })
/* 218 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.PREDATORY.getMetadata()))
/* 219 */       .para("book.intangible:predatorystone.p1", true);
/*     */     
/* 221 */     stoneTypes.createPage("doomedstone", PageType.CHILD)
/* 222 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_DOOMED })
/* 223 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.DOOMED.getMetadata()))
/* 224 */       .para("book.intangible:doomedstone.p1", true);
/*     */     
/* 226 */     stoneTypes.createPage("unhingedstone", PageType.CHILD)
/* 227 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_UNHINGED })
/* 228 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.UNHINGED.getMetadata()))
/* 229 */       .para("book.intangible:unhingedstone.p1", true);
/*     */     
/* 231 */     stoneTypes.createPage("malleablestone", PageType.CHILD)
/* 232 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE })
/* 233 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.MALLEABLE.getMetadata()))
/* 234 */       .para("book.intangible:malleablestone.p1", true);
/*     */     
/* 236 */     stoneTypes.createPage("wisestone", PageType.CHILD)
/* 237 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_WISE })
/* 238 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.WISE.getMetadata()))
/* 239 */       .para("book.intangible:wisestone.p1", true);
/*     */     
/* 241 */     stoneTypes.createPage("noblestone", PageType.CHILD)
/* 242 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_NOBLE })
/* 243 */       .image(new ItemStack(Get.blocks().SOUL_CAGE, 1, EnumSoulType.NOBLE.getMetadata()))
/* 244 */       .para("book.intangible:noblestone.p1", true);
/*     */     
/* 246 */     i = -1;
/* 247 */     subPage = 1;
/*     */     
/* 249 */     for (ItemPart.EnumPart part : ItemPart.EnumPart.values()) {
/* 250 */       if (part.getGroup() == ItemPart.PartGroup.FORGE_MATERIAL) {
/* 251 */         i++; if ((i % 9 == 0) && (i > 0))
/*     */         {
/*     */ 
/* 254 */           materials = materials.createPage("parts" + ++subPage, PageType.SIBLING).knowledge(new IKnol[] { Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE }).title("book.intangible:parts.title");
/*     */         }
/*     */         
/*     */ 
/* 258 */         materials.createPage("part_" + part.getUnlocalizedName(), PageType.CHILD, new ItemStack(Get.items().PART, 1, part.getMetadata())).knowledge(new IKnol[] { Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE }).title("item.intangible:part_" + part.getUnlocalizedName() + ".name");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 265 */     IBookPage devices = this.index.createPage("devices", PageType.CHILD).title("book.intangible:devices.title");
/*     */     
/* 267 */     devices.createPage("circuitstamper", PageType.CHILD, new ItemStack(Get.blocks().CIRCUIT_STAMPER))
/* 268 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL, Get.knowledge().MAT_SOULBONE })
/* 269 */       .para("book.intangible:circuitstamper.p1", true);
/*     */     
/* 271 */     devices.createPage("knowledgegem", PageType.CHILD, new ItemStack(Get.items().KNOWLEDGE_GEM))
/* 272 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL, Get.knowledge().MAT_SOULBONE })
/* 273 */       .para("book.intangible:knowledgegem.p1", true);
/*     */     
/* 275 */     devices.createPage("bonespear", PageType.CHILD, new ItemStack(Get.items().SOUL_SPEAR))
/* 276 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL, Get.knowledge().MAT_SOULBONE })
/* 277 */       .para("book.intangible:bonespear.p1", true);
/*     */     
/*     */ 
/*     */ 
/* 281 */     IBookPage crystalarmor = devices.createPage("crystalarmor", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL }).para("book.intangible:crystalarmor.p1");
/*     */     
/* 283 */     crystalarmor.createPage("bluecrystalhelmet", PageType.CHILD, new ItemStack(Get.items().BLUE_CRYSTAL_HELMET))
/* 284 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 285 */       .para("book.intangible:bluecrystalhelmet.p1");
/*     */     
/* 287 */     crystalarmor.createPage("yellowcrystalhelmet", PageType.CHILD, new ItemStack(Get.items().YELLOW_CRYSTAL_HELMET))
/* 288 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 289 */       .para("book.intangible:yellowcrystalhelmet.p1");
/*     */     
/* 291 */     crystalarmor.createPage("bluecrystalchestplate", PageType.CHILD, new ItemStack(Get.items().BLUE_CRYSTAL_CHESTPLATE))
/* 292 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 293 */       .para("book.intangible:bluecrystalchestplate.p1");
/*     */     
/* 295 */     crystalarmor.createPage("bluecrystalleggings", PageType.CHILD, new ItemStack(Get.items().BLUE_CRYSTAL_TROUSERS))
/* 296 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 297 */       .para("book.intangible:bluecrystalleggings.p1");
/*     */     
/* 299 */     crystalarmor.createPage("bluecrystalboots", PageType.CHILD, new ItemStack(Get.items().BLUE_CRYSTAL_BOOTS))
/* 300 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 301 */       .para("book.intangible:bluecrystalboots.p1");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 306 */     IBookPage crystalblocks = devices.createPage("crystalblocks", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL }).para("book.intangible:crystalblocks.p1");
/*     */     
/* 308 */     crystalblocks.createPage("bluecrystalblock", PageType.CHILD, new ItemStack(Get.blocks().BLUE_CRYSTAL_BLOCK))
/* 309 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 310 */       .para("book.intangible:bluecrystalblock.p1", true);
/*     */     
/* 312 */     crystalblocks.createPage("yellowcrystalblock", PageType.CHILD, new ItemStack(Get.blocks().YELLOW_CRYSTAL_BLOCK))
/* 313 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 314 */       .para("book.intangible:yellowcrystalblock.p1", true);
/*     */     
/* 316 */     devices.createPage("bellows", PageType.CHILD, new ItemStack(Get.blocks().BELLOWS))
/* 317 */       .para("book.intangible:bellows.p1", true);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 323 */     IBookPage blowmold = devices.createPage("blowmold", PageType.CHILD, new ItemStack(Get.blocks().BLOW_MOLD)).knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL }).para("book.intangible:blowmold.p1", true).createPage("molds", PageType.SIBLING).title("book.intangible:molds.title");
/*     */     
/* 325 */     i = -1;
/* 326 */     subPage = 1;
/* 327 */     Iterator iterator = Item.field_150901_e.iterator();
/* 328 */     while (iterator.hasNext()) {
/* 329 */       Item item = (Item)iterator.next();
/* 330 */       if ((item instanceof emoniph.intangible.api.IMold)) {
/* 331 */         i++; if ((i % 9 == 0) && (i > 0)) {
/* 332 */           blowmold = blowmold.createPage("molds" + ++subPage, PageType.SIBLING).title("book.intangible:molds.title");
/*     */         }
/*     */         
/* 335 */         blowmold.createPage(item.func_77658_a().substring(5), PageType.CHILD, new ItemStack(item)).title(item.func_77658_a() + ".name");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 341 */     devices.createPage("soulrelay", PageType.CHILD, new ItemStack(Get.blocks().SOUL_RELAY)).knowledge(new IKnol[] { Get.knowledge().SOULS }).para("book.intangible:soulrelay.p1", true);
/*     */     
/* 343 */     devices.createPage("bonecage", PageType.CHILD, new ItemStack(Get.blocks().BONE_CAGE))
/* 344 */       .knowledge(new IKnol[] {Get.knowledge().MAT_SOULBONE })
/* 345 */       .para("book.intangible:bonecage.p1", true);
/*     */     
/*     */ 
/*     */ 
/* 349 */     IBookPage glassware = devices.createPage("glassware", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL }).para("book.intangible:glassware.p1");
/*     */     
/* 351 */     glassware.createPage("funnel", PageType.CHILD, new ItemStack(Get.blocks().FUNNEL))
/* 352 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 353 */       .para("book.intangible:funnel.p1", true);
/*     */     
/* 355 */     glassware.createPage("decanter", PageType.CHILD, new ItemStack(Get.blocks().DECANTER))
/* 356 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 357 */       .para("book.intangible:decanter.p1");
/*     */     
/* 359 */     glassware.createPage("gourd", PageType.CHILD, new ItemStack(Get.blocks().GOARD))
/* 360 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 361 */       .para("book.intangible:gourd.p1", true);
/*     */     
/* 363 */     glassware.createPage("spiral", PageType.CHILD, new ItemStack(Get.blocks().SPIRAL))
/* 364 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 365 */       .para("book.intangible:spiral.p1", true);
/*     */     
/* 367 */     glassware.createPage("splitter", PageType.CHILD, new ItemStack(Get.blocks().SPLITER))
/* 368 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 369 */       .para("book.intangible:splitter.p1", true);
/*     */     
/* 371 */     devices.createPage("wellofsouls", PageType.CHILD)
/* 372 */       .knowledge(new IKnol[] {Get.knowledge().SOULS })
/* 373 */       .image("intangible:textures/gui/wellofsouls.png", 128, 64)
/* 374 */       .para("book.intangible:wellofsouls.p1", true);
/*     */     
/* 376 */     devices.createPage("infuser", PageType.CHILD, new ItemStack(Get.blocks().INFUSER))
/* 377 */       .knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 378 */       .para("book.intangible:infuser.p1", true);
/*     */     
/*     */ 
/* 381 */     IBookPage devices2 = devices.createPage("devices2", PageType.SIBLING).title("book.intangible:devices.title");
/*     */     
/* 383 */     devices2.createPage("foci", PageType.CHILD, new ItemStack(Get.items().FOCI))
/* 384 */       .knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 385 */       .para("book.intangible:foci.p1", true);
/*     */     
/*     */ 
/* 388 */     IBookPage defense = devices2.createPage("defense", PageType.CHILD, new ItemStack(Get.blocks().DEFENSE)).knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_BENIGN, Get.knowledge().SOUL_PREDATORY, 
/* 389 */       Get.knowledge().SOUL_UNHINGED, Get.knowledge().SOUL_WISE });
/*     */     
/* 391 */     defense.createPage("defenseoverview", PageType.CHILD)
/* 392 */       .knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_BENIGN, Get.knowledge().SOUL_PREDATORY, 
/* 393 */       Get.knowledge().SOUL_UNHINGED, Get.knowledge().SOUL_WISE })
/* 394 */       .para("book.intangible:defenseoverview.p1", true);
/*     */     
/* 396 */     defense.createPage("defense_tempering", PageType.CHILD, new ItemStack(Get.blocks().DEFENSE))
/* 397 */       .knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_BENIGN, Get.knowledge().SOUL_PREDATORY, 
/* 398 */       Get.knowledge().SOUL_UNHINGED, Get.knowledge().SOUL_WISE })
/* 399 */       .para("book.intangible:defense_tempering.p1", true);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 404 */     IBookPage defenseBlocks = defense.createPage("defenseblocks", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_BENIGN, Get.knowledge().SOUL_PREDATORY, Get.knowledge().SOUL_UNHINGED, Get.knowledge().SOUL_WISE }).para("book.intangible:defenseblocks.p1");
/*     */     
/* 406 */     for (EnumSoulType soulType : EnumSoulType.values())
/*     */     {
/*     */ 
/* 409 */       defenseBlocks.createPage("defense" + soulType.getUnlocalizedName(), PageType.CHILD).knowledge(new IKnol[] { Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().getKnolForSoul(soulType.toSoulType()) }).para("book.intangible:defense" + soulType.getUnlocalizedName() + ".p1");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 418 */     devices2.createPage("villagefinder", PageType.CHILD, new ItemStack(Get.items().VILLAGE_FINDER)).knowledge(new IKnol[] { Get.knowledge().MAT_SOULBONE, Get.knowledge().MAT_CRYSTAL }).para("book.intangible:villagefinder.p1");
/*     */     
/*     */ 
/*     */ 
/* 422 */     IBookPage reconstructor = devices2.createPage("reconstructor", PageType.CHILD, new ItemStack(Get.blocks().RECONSTRUCTOR)).knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_WISE }).para("book.intangible:reconstructor.p1");
/*     */     
/* 424 */     reconstructor.createPage("reconstructor2", PageType.CHILD)
/* 425 */       .image("intangible:textures/gui/reconstructor.png", 128, 64)
/* 426 */       .title("book.intangible:reconstructor2.title")
/* 427 */       .para("book.intangible:reconstructor2.p1", true);
/*     */     
/* 429 */     reconstructor.createPage("reconstructor3", PageType.CHILD)
/* 430 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE })
/* 431 */       .usedSouls(new SoulSet().add(SoulType.BENIGN, 1).add(SoulType.MALLEABLE, 2).add(SoulType.IMMUTABLE, 2))
/* 432 */       .consumedSouls(new SoulSet().add(SoulType.UNHINGED, 1).add(SoulType.IMMUTABLE, 1))
/* 433 */       .title("book.intangible:reconstructor3.title")
/* 434 */       .para("book.intangible:reconstructor3.p1", true);
/*     */     
/*     */ 
/* 437 */     IBookPage soulforge = devices2.createPage("soulforge", PageType.CHILD, new ItemStack(Get.blocks().SOUL_FORGE)).knowledge(new IKnol[] {Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE });
/*     */     
/* 439 */     soulforge.createPage("soulforging", PageType.CHILD)
/* 440 */       .para("book.intangible:soulforging.p1", true);
/*     */     
/* 442 */     i = 6;
/* 443 */     subPage = 1;
/* 444 */     for (Object blockObj : net.minecraftforge.fml.common.registry.GameData.getBlockRegistry()) {
/* 445 */       if ((blockObj instanceof ISoulForgeClient)) {
/* 446 */         client = (ISoulForgeClient)blockObj;
/* 447 */         for (localIterator3 = client.getBookResourcePageIds().iterator(); localIterator3.hasNext();) { pageInfo = (IBookPageResources)localIterator3.next();
/* 448 */           i++; if ((i % 9 == 0) && (i > 0))
/*     */           {
/*     */ 
/* 451 */             soulforge = soulforge.createPage("soulforge" + ++subPage, PageType.SIBLING).knowledge(new IKnol[] { Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE }).title("book.intangible:soulforge.title");
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 458 */           soulforge.createPage("soulforging_" + pageInfo.getTitleId(), PageType.CHILD).knowledge(pageInfo.getKnowledge()).usedSouls(pageInfo.getUsedSouls()).consumedSouls(pageInfo.getConsumedSouls()).title(pageInfo.getTitleId()).para(pageInfo.getContentResourceId(), true);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     Iterator localIterator3;
/*     */     
/* 465 */     devices2.createPage("plinth", PageType.CHILD, new ItemStack(Get.blocks().PLINTH)).para("book.intangible:plinth.p1", true);
/*     */     
/* 467 */     devices2.createPage("offeringplate", PageType.CHILD, new ItemStack(Get.blocks().OFFERING_PLATE))
/* 468 */       .knowledge(new IKnol[] {Get.knowledge().MAT_CRYSTAL })
/* 469 */       .para("book.intangible:offeringplate.p1", true);
/*     */     
/* 471 */     devices2.createPage("resonator", PageType.CHILD, new ItemStack(Get.blocks().SYNTHETIC_RESONATOR))
/* 472 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE })
/* 473 */       .para("book.intangible:resonator.p1", true);
/*     */     
/* 475 */     devices2.createPage("soulwrench", PageType.CHILD, new ItemStack(Get.blocks().SOUL_WRENCH))
/* 476 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_DOOMED, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 477 */       .para("book.intangible:soulwrench.p1")
/* 478 */       .createPage("soulwrench2", PageType.SIBLING)
/* 479 */       .title("book.intangible:soulwrench.title")
/* 480 */       .image("intangible:textures/gui/soulwrench.png", 64, 64)
/* 481 */       .para("book.intangible:soulwrench.p2", true);
/*     */     
/*     */ 
/*     */ 
/* 485 */     IBookPage armor = devices2.createPage("soulbonearmor", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book.intangible:soulbonearmor.p1");
/*     */     
/* 487 */     armor.createPage("soulbonearmorconstruction", PageType.CHILD)
/* 488 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 489 */       .image("intangible:textures/gui/soularmor.png", 128, 64)
/* 490 */       .para("book.intangible:soulbonearmorconstruction.p1", true);
/*     */     
/* 492 */     armor.createPage("soulbonearmortempering", PageType.CHILD)
/* 493 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 494 */       .para("book.intangible:soulbonearmortempering.p1", true);
/*     */     
/* 496 */     armor.createPage("soulbonehelmet", PageType.CHILD, new ItemStack(Get.items().SOUL_HELMET))
/* 497 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 498 */       .para("book.intangible:soulbonehelmet.p1", true)
/* 499 */       .createPage("soulbonehelmet_tempering", PageType.CHILD, new ItemStack(Get.items().SOUL_HELMET))
/* 500 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_WISE, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     
/* 502 */     armor.createPage("soulbonechestplate", PageType.CHILD, new ItemStack(Get.items().SOUL_CHESTPLATE))
/* 503 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 504 */       .para("book.intangible:soulbonechestplate.p1", true)
/* 505 */       .createPage("soulbonechestplate_tempering", PageType.CHILD, new ItemStack(Get.items().SOUL_CHESTPLATE))
/* 506 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     
/* 508 */     armor.createPage("soulboneleggings", PageType.CHILD, new ItemStack(Get.items().SOUL_TROUSERS))
/* 509 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_PREDATORY, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 510 */       .para("book.intangible:soulboneleggings.p1", true)
/* 511 */       .createPage("soulboneleggings_tempering", PageType.CHILD, new ItemStack(Get.items().SOUL_TROUSERS))
/* 512 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_PREDATORY, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     
/* 514 */     armor.createPage("soulboneboots", PageType.CHILD, new ItemStack(Get.items().SOUL_BOOTS))
/* 515 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_BENIGN, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 516 */       .para("book.intangible:soulboneboots.p1", true)
/* 517 */       .createPage("soulboneboots_tempering", PageType.CHILD, new ItemStack(Get.items().SOUL_BOOTS))
/* 518 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SOUL_BENIGN, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     
/*     */ 
/*     */ 
/* 522 */     if (net.minecraftforge.fml.common.Loader.isModLoaded("Baubles"))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/* 527 */       armor.createPage("soulboundring", PageType.CHILD, new ItemStack(Get.items().SOULBOUND_RING)).knowledge(new IKnol[] { Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book.intangible:soulboundring.p1", true).createPage("soulboundring_tempering", PageType.CHILD, new ItemStack(Get.items().SOULBOUND_RING)).knowledge(new IKnol[] { Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */     }
/*     */     
/*     */ 
/* 531 */     IBookPage parts = devices2.createPage("parts", PageType.CHILD).knowledge(new IKnol[] { Get.knowledge().MAT_SOULBONE, Get.knowledge().MAT_CRYSTAL });
/*     */     
/* 533 */     i = -1;
/* 534 */     subPage = 1;
/* 535 */     ISoulForgeClient client = ItemPart.EnumPart.values();IBookPageResources localIBookPageResources1 = client.length; ItemPart.EnumPart part; for (IBookPageResources pageInfo = 0; pageInfo < localIBookPageResources1; pageInfo++) { part = client[pageInfo];
/* 536 */       if (part.getGroup() == ItemPart.PartGroup.GENERIC) {
/* 537 */         i++; if ((i % 9 == 0) && (i > 0))
/*     */         {
/*     */ 
/* 540 */           parts = parts.createPage("parts" + ++subPage, PageType.SIBLING).knowledge(new IKnol[] { Get.knowledge().MAT_SOULBONE, Get.knowledge().MAT_CRYSTAL }).title("book.intangible:parts.title");
/*     */         }
/*     */         
/*     */ 
/* 544 */         parts.createPage("part_" + part.getUnlocalizedName(), PageType.CHILD, new ItemStack(Get.items().PART, 1, part.getMetadata())).knowledge(new IKnol[] { Get.knowledge().MAT_SOULBONE, Get.knowledge().MAT_CRYSTAL }).title("item.intangible:part_" + part.getUnlocalizedName() + ".name");
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 552 */     IBookPage golems = this.index.createPage("golems", PageType.CHILD).knowledge(new IKnol[] { Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book.intangible:golems.p1");
/*     */     
/* 554 */     golems.createPage("golemspiloting", PageType.CHILD)
/* 555 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 556 */       .para("book.intangible:golemspiloting.p1", true);
/*     */     
/* 558 */     golems.createPage("golemfactory", PageType.CHILD, new ItemStack(Get.blocks().GOLEM_FACTORY))
/* 559 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 560 */       .para("book.intangible:golemfactory.p1", true);
/*     */     
/*     */ 
/*     */ 
/* 564 */     IBookPage partAssembler = golems.createPage("partassembler", PageType.CHILD, new ItemStack(Get.blocks().GOLEM_PART_ASSEMBLER)).knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).para("book.intangible:partassembler.p1", true);
/*     */     
/* 566 */     golems.createPage("largebutton", PageType.CHILD, new ItemStack(Get.blocks().LARGE_BUTTON))
/* 567 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 568 */       .para("book.intangible:largebutton.p1", true);
/*     */     
/* 570 */     golems.createPage("largelever", PageType.CHILD, new ItemStack(Get.blocks().LARGE_LEVER))
/* 571 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION })
/* 572 */       .para("book.intangible:largelever.p1", true);
/*     */     
/* 574 */     IBookPage golemParts = partAssembler.createPage("golemparts", PageType.CHILD);
/* 575 */     i = 0;
/* 576 */     subPage = 1;
/*     */     
/* 578 */     for (ItemPart.EnumPart part : ItemPart.EnumPart.values()) {
/* 579 */       if (part.getGroup() == ItemPart.PartGroup.GOLEM_COMPONENT) {
/* 580 */         i++; if ((i % 9 == 0) && (i > 0))
/*     */         {
/*     */ 
/* 583 */           golemParts = golemParts.createPage("golemparts" + ++subPage, PageType.SIBLING).knowledge(new IKnol[] { Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).title("book.intangible:parts.title");
/*     */         }
/*     */         
/*     */ 
/* 587 */         golemParts.createPage("part_" + part.getUnlocalizedName(), PageType.CHILD, new ItemStack(Get.items().PART, 1, part.getMetadata())).knowledge(new IKnol[] { Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).title("item.intangible:part_" + part.getUnlocalizedName() + ".name");
/*     */       }
/*     */     }
/*     */     
/* 591 */     for (IBookPageResources page : Get.golems().getPageResource()) {
/* 592 */       i++; if ((i % 9 == 0) && (i > 0))
/*     */       {
/*     */ 
/* 595 */         golemParts = golemParts.createPage("golemparts" + ++subPage, PageType.SIBLING).knowledge(new IKnol[] { Get.knowledge().SOUL_MALLEABLE, Get.knowledge().SKILL_SOUL_MANIPULATION }).title("book.intangible:parts.title");
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 600 */       golemParts.createPage(page.getPageId(), PageType.CHILD, page.getStack()).knowledge(page.getKnowledge()).title(page.getTitleId()).para(page.getContentResourceId());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 606 */     IBookPage deities = this.index.createPage("deities", PageType.CHILD).knowledge(new IKnol[] { Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION }).para("book.intangible:deities.p1");
/*     */     
/* 608 */     deities.createPage("deitiesoverview", PageType.CHILD)
/* 609 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 610 */       .para("book.intangible:deitiesoverview.p1", true);
/*     */     
/*     */ 
/*     */ 
/* 614 */     IBookPage deityMaking = deities.createPage("deitymanufacture", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION }).para("book.intangible:deitymanufacture.p1");
/*     */     
/*     */ 
/* 617 */     deityMaking.createPage("deitymanufactureoverview", PageType.CHILD)
/* 618 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 619 */       .consumedSouls(new SoulSet()
/* 620 */       .add(SoulType.MALLEABLE, 1)
/* 621 */       .add(SoulType.PREDATORY, 1)
/* 622 */       .add(SoulType.UNHINGED, 1)
/* 623 */       .add(SoulType.BENIGN, 1)
/* 624 */       .add(SoulType.IMMUTABLE, 1)
/* 625 */       .add(SoulType.WISE, 1))
/* 626 */       .usedSouls(new SoulSet()
/* 627 */       .add(SoulType.MALLEABLE, 2)
/* 628 */       .add(SoulType.BENIGN, 2)
/* 629 */       .add(SoulType.WISE, 1))
/* 630 */       .createPage("deitytmanufactureoverview2", PageType.SIBLING)
/* 631 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 632 */       .title("book.intangible:deitymanufactureoverview.title")
/* 633 */       .para("book.intangible:deitymanufactureoverview.p1", true);
/*     */     
/* 635 */     deityMaking.createPage("deitybuilderstructure", PageType.CHILD, new MultiBlockPlanDeityFabricator())
/* 636 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 637 */       .para("book.intangible:deitybuilderstructure.p1");
/*     */     
/* 639 */     deityMaking.createPage("deitybuilder", PageType.CHILD, new MultiBlockPlanDeityBuilder())
/* 640 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 641 */       .para("book.intangible:deitybuilder.p1");
/*     */     
/*     */ 
/* 644 */     IBookPage deityEffects = deityMaking.createPage("deitycomponents", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION });
/*     */     
/* 646 */     addDeityEffectPages("deitymajorpowers", deityEffects, Get.deityEffects().worldMajorEffectRegistry);
/*     */     
/* 648 */     addDeityEffectPages("deityminorpowers", deityEffects, Get.deityEffects().worldMinorEffectRegistry);
/*     */     
/* 650 */     addDeityEffectPages("deityblessings", deityEffects, Get.deityEffects().worshipEffectRegistry);
/*     */     
/* 652 */     addDeityEffectPages("deityshrineeffects", deityEffects, Get.deityEffects().shrineEffectRegistry);
/*     */     
/* 654 */     addDeityEffectPages("avatarpowers", deityEffects, Get.deityEffects().avatarPowerRegistry);
/*     */     
/* 656 */     addDeityEffectPages("avatarbodies", deityEffects, Get.deityEffects().bodyRegistry);
/*     */     
/* 658 */     addDeityEffectPages("deityconstraints", deityEffects, Get.deityEffects().constraintRegistry);
/*     */     
/* 660 */     addDeityEffectPages("deityvoices", deityEffects, Get.deityEffects().voiceRegistry);
/*     */     
/*     */ 
/*     */ 
/* 664 */     IBookPage deityColors = deityEffects.createPage("deitycolors", PageType.CHILD).knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION }).para("book.intangible:deitycolors.p1");
/*     */     
/* 666 */     addDeityEffectPages("worshiprestrictions", deityEffects, Get.deityEffects().worshipRestrictionRegistry);
/*     */     
/* 668 */     deities.createPage("deitiesworship", PageType.CHILD, new ItemStack(Get.blocks().SHRINE))
/* 669 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 670 */       .para("book.intangible:deitiesworship.p1", true);
/*     */     
/* 672 */     deities.createPage("deitiespriesthood", PageType.CHILD)
/* 673 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 674 */       .para("book.intangible:deitiespriesthood.p1", true);
/*     */     
/* 676 */     deities.createPage("rod", PageType.CHILD, new ItemStack(Get.items().ROD))
/* 677 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 678 */       .para("book.intangible:rod.p1", true);
/*     */     
/* 680 */     deities.createPage("deitiesavatars", PageType.CHILD)
/* 681 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 682 */       .para("book.intangible:deitiesavatars.p1", true);
/*     */     
/* 684 */     deities.createPage("pantheon", PageType.CHILD, new ItemStack(Get.blocks().PANTHEON))
/* 685 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 686 */       .para("book.intangible:pantheon.p1", true);
/*     */     
/* 688 */     deities.createPage("deityhammer", PageType.CHILD, new ItemStack(Get.blocks().DEITY_HAMMER))
/* 689 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 690 */       .para("book.intangible:deityhammer.p1")
/* 691 */       .createPage("deityhammer2", PageType.SIBLING)
/* 692 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 693 */       .usedSouls(new SoulSet().add(SoulType.PREDATORY, 3).add(SoulType.MALLEABLE, 1))
/* 694 */       .title("book.intangible:deityhammer.title")
/* 695 */       .consumedSouls(new SoulSet().add(SoulType.PREDATORY, 1))
/* 696 */       .createPage("deityhammer3", PageType.SIBLING)
/* 697 */       .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 698 */       .title("book.intangible:deityhammer.title")
/* 699 */       .image("intangible:textures/gui/deityhammer.png", 64, 64)
/* 700 */       .para("book.intangible:deityhammer.p3", true);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 705 */     this.extensions = new Page("extensions", this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private <T> void addDeityEffectPages(String rootPageName, IBookPage parent, DeityEffectTypeRegistry<T> registry)
/*     */   {
/* 713 */     int i = 0;
/* 714 */     int subPage = 1;
/* 715 */     int BULLETS_PER_PAGE = 7;
/*     */     
/* 717 */     IBookPage index = parent.createPage(rootPageName, PageType.CHILD);
/*     */     
/* 719 */     String title = "book.intangible:" + rootPageName + ".title";
/*     */     
/* 721 */     for (DeityEffectTypeRegistry<T>.EffectEntry item : registry)
/*     */     {
/* 723 */       i++; if ((i % 7 == 0) && (i > 0)) {
/* 724 */         index = index.createPage(rootPageName + ++subPage, PageType.SIBLING).title(title);
/*     */       }
/*     */       
/* 727 */       String id = rootPageName + "." + item.getId();
/*     */       
/* 729 */       index.createPage(id, PageType.CHILD)
/* 730 */         .knowledge(new IKnol[] {Get.knowledge().SOUL_IMMUTABLE, Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SKILL_SOUL_TRANSFUSION })
/* 731 */         .title("book." + id + ".title")
/* 732 */         .image(item.getSelector())
/* 733 */         .para("book." + id + ".p1")
/* 734 */         .consumedSouls(item.getCost());
/*     */     }
/*     */   }
/*     */   
/*     */   public IBookPage createExtensionIndex(String id) {
/* 739 */     if (!this.hasExtensions) {
/* 740 */       this.hasExtensions = true;
/* 741 */       this.index.addPage(this.extensions, PageType.CHILD);
/*     */     }
/*     */     
/* 744 */     return this.extensions.createPage(id, PageType.CHILD);
/*     */   }
/*     */   
/*     */   public void addToBook(Page chapter) {
/* 748 */     this.pages.put(chapter.getId(), chapter);
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
/*     */   public Page getPageForId(String id)
/*     */   {
/* 781 */     Page page = (Page)this.pages.get(id);
/* 782 */     return page != null ? page : this.index;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void render(EntityKnowledgeGem gem, EntityPlayerSP player, Point2d pointer, float partialTicks, RenderManager renderManager) {
/* 787 */     PlayerEx playerEx = PlayerEx.get(player);
/* 788 */     BookNavigator nav = playerEx.getBookNavigator();
/* 789 */     String id = nav.getCurrentPage();
/* 790 */     Page page = getPageForId(id);
/* 791 */     if (page != null) {
/* 792 */       page.render(gem, player, nav, playerEx.getLearning(), pointer, partialTicks, renderManager);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean exists(String pageName) {
/* 797 */     return this.pages.containsKey(pageName);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/Book.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */