/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.client.renderer.RenderBellows;
/*     */ import emoniph.intangible.client.renderer.RenderForge;
/*     */ import emoniph.intangible.client.renderer.RenderResearchSplitter;
/*     */ import emoniph.intangible.client.renderer.RenderSyntheticResonator;
/*     */ import emoniph.intangible.client.renderer.RenderWell;
/*     */ import emoniph.intangible.fluids.ModFluids;
/*     */ import emoniph.intangible.items.ItemSoulForge;
/*     */ import java.util.EnumSet;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ModBlocks implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModPreInit, emoniph.intangible.init.IModPreInitClient, emoniph.intangible.init.IModInitClient
/*     */ {
/*  24 */   private final Registry registry = new Registry();
/*     */   
/*  26 */   public final Block SOUL_RELAY = this.registry.add("soulrelay", new BlockSoulRelay(), new TileEntityHandler(BlockSoulRelay.TileEntitySoulRelay.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  28 */       rendererList.add(new emoniph.intangible.client.renderer.RenderRelay());
/*     */     }
/*  26 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  32 */   public final Block PLINTH = this.registry.add("plinth", new BlockPlinth(), new TileEntityHandler(BlockPlinth.TileEntityPlinth.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  34 */       rendererList.add(new emoniph.intangible.client.renderer.RenderPlinth());
/*     */     }
/*  32 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  38 */   public final Block SOUL_CAGE = this.registry.add("soulcage", new BlockSoulCage(), emoniph.intangible.items.ItemBlockWithVariants.class);
/*     */   
/*  40 */   public final Block SOUL_WARD = this.registry.add("soulward", new BlockSoulWard(), new TileEntityHandler(BlockSoulWard.TileEntitySoulWard.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  42 */       rendererList.add(new emoniph.intangible.client.renderer.RenderWard());
/*     */     }
/*  40 */   }, emoniph.intangible.items.ItemSoulWard.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  46 */   public final Block SOUL_WRENCH = this.registry.add("soulwrench", new BlockSoulWrench(), new TileEntityHandler(BlockSoulWrench.TileEntitySoulWrench.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  48 */       rendererList.add(new emoniph.intangible.client.renderer.RenderWrench());
/*     */     }
/*  46 */   }, emoniph.intangible.items.ItemSoulWrench.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  52 */   public final Block SOUL_FORGE = this.registry.add("soulforge", new BlockSoulForge(), new TileEntityHandler(BlockSoulForge.TileEntitySoulForge.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  54 */       rendererList.add(new RenderForge());
/*     */     }
/*  52 */   }, ItemSoulForge.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  58 */   public final Block DEITY_BUILDER = this.registry.add("deitybuilder", new BlockDeityBuilder(), new TileEntityHandler(BlockDeityBuilder.TileEntityDeityBuilder.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  60 */       rendererList.add(new emoniph.intangible.client.renderer.RenderDeityBuilder());
/*     */     }
/*  58 */   }, 
/*     */   
/*     */ 
/*     */ 
/*  62 */     EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE));
/*     */   
/*  64 */   public final Block WELL_OF_SOULS = this.registry.add("wellofsouls", new BlockWellOfSouls(), new TileEntityHandler(BlockWellOfSouls.TileEntityWellOfSouls.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  66 */       rendererList.add(new RenderWell());
/*     */     }
/*  64 */   }, 
/*     */   
/*     */ 
/*     */ 
/*  68 */     EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE, RegistryFlags.NO_INVENTORY_MODEL));
/*     */   
/*  70 */   public final Block WELL_OF_SOULS_CORE = this.registry.add("wellofsoulscore", new BlockWellOfSoulsCore(), new TileEntityHandler(BlockWellOfSoulsCore.TileEntityWellOfSoulsCore.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  72 */       rendererList.add(new RenderWell());
/*     */     }
/*  70 */   }, 
/*     */   
/*     */ 
/*     */ 
/*  74 */     EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE, RegistryFlags.NO_INVENTORY_MODEL));
/*     */   
/*  76 */   public final Block INFINITE_SOUL_WELL = this.registry.add("infinitesoulwell", new BlockInfiniteSoulWell(), new TileEntityHandler(BlockInfiniteSoulWell.TileEntityInfiniteSoulWell.class));
/*     */   
/*  78 */   public final Block PANTHEON = this.registry.add("pantheon", new BlockPantheon(), new TileEntityHandler(BlockPantheon.TileEntityPantheon.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  80 */       rendererList.add(new emoniph.intangible.client.renderer.RenderPantheon());
/*     */     }
/*  78 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */   public final Block OFFERING_PLATE = this.registry.add("offeringplate", new BlockOfferingPlate(), new TileEntityHandler(BlockOfferingPlate.TileEntityOfferingPlate.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  86 */       rendererList.add(new emoniph.intangible.client.renderer.RenderPlate());
/*     */     }
/*  84 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  90 */   public final Block SHRINE = this.registry.add("shrine", new BlockShrine(), new TileEntityHandler(BlockShrine.TileEntityShrine.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  92 */       rendererList.add(new emoniph.intangible.client.renderer.RenderShrine());
/*     */     }
/*  90 */   }, emoniph.intangible.items.ItemShrine.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  96 */   public final Block FUNNEL = this.registry.add("funnel", new BlockResearchFunnel(), new TileEntityHandler(BlockResearchFunnel.TileEntityResearchFunnel.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/*  98 */       rendererList.add(new emoniph.intangible.client.renderer.RenderResearchFunnel());
/*     */     }
/*  96 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 102 */   public final Block SPIRAL = this.registry.add("spiral", new BlockResearchSpiral(), new TileEntityHandler(BlockResearchSpiral.TileEntityResearchSpiral.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 104 */       rendererList.add(new emoniph.intangible.client.renderer.RenderResearchSpiral());
/*     */     }
/* 102 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 108 */   public final Block DECANTER = this.registry.add("decanter", new BlockResearchDecanter(), new TileEntityHandler(BlockResearchDecanter.TileEntityResearchDecanter.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 110 */       rendererList.add(new emoniph.intangible.client.renderer.RenderResearchDecanter());
/*     */     }
/* 108 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */   public final Block GOARD = this.registry.add("gourd", new BlockResearchGourd(), new TileEntityHandler(BlockResearchGourd.TileEntityResearchGourd.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 116 */       rendererList.add(new emoniph.intangible.client.renderer.RenderResearchGourd());
/*     */     }
/* 114 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 120 */   public final Block SPLITER = this.registry.add("splitter", new BlockResearchSplitter(), new TileEntityHandler(BlockResearchSplitter.TileEntityResearchSplitter.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 122 */       rendererList.add(new RenderResearchSplitter());
/*     */     }
/* 120 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 126 */   public final Block BONE_CAGE = this.registry.add("bonecage", new BlockBoneCage(), new TileEntityHandler(BlockBoneCage.TileEntityBoneCage.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 128 */       rendererList.add(new emoniph.intangible.client.renderer.RenderBoneCage());
/*     */     }
/* 126 */   }, emoniph.intangible.items.ItemBoneCage.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 132 */   public final Block CIRCUIT_STAMPER = this.registry.add("stamper", new BlockStamper(), new TileEntityHandler(BlockStamper.TileEntityStamper.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 134 */       rendererList.add(new emoniph.intangible.client.renderer.RenderStamper());
/*     */     }
/* 132 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 138 */   public final Block CRYSTAL = this.registry.add("crystal", new BlockCrystal(), new TileEntityHandler(BlockCrystal.TileEntityCrystal.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 140 */       rendererList.add(new emoniph.intangible.client.renderer.RenderCrystal());
/*     */     }
/* 138 */   }, emoniph.intangible.items.ItemCrystal.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 144 */   public final BlockMoltenCrystal MOLTEN_CRYSTAL_BLUE = (BlockMoltenCrystal)this.registry.add("moltencrystalblue", new BlockMoltenCrystal(
/* 145 */     Get.fluids().MOLTEN_CRYSTAL_BLUE), EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE));
/*     */   
/* 147 */   public final BlockMoltenCrystal MOLTEN_CRYSTAL_YELLOW = (BlockMoltenCrystal)this.registry.add("moltencrystalyellow", new BlockMoltenCrystal(
/* 148 */     Get.fluids().MOLTEN_CRYSTAL_YELLOW), EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE));
/*     */   
/* 150 */   public final BlockMoltenCrystal MOLTEN_GLASS = (BlockMoltenCrystal)this.registry.add("moltenglass", new BlockMoltenCrystal(
/* 151 */     Get.fluids().MOLTEN_GLASS), EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE));
/*     */   
/* 153 */   public final Block BLOW_MOLD = this.registry.add("blowmold", new BlockBlowMold(), new TileEntityHandler(BlockBlowMold.TileEntityBlowMold.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 155 */       rendererList.add(new emoniph.intangible.client.renderer.RenderBlowMold());
/*     */     }
/* 153 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 159 */   public final Block BELLOWS = this.registry.add("bellows", new BlockBellows(), new TileEntityHandler(BlockBellows.TileEntityBellows.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 161 */       rendererList.add(new RenderBellows());
/*     */     }
/* 159 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 165 */   public final Block INFUSER = this.registry.add("infuser", new BlockInfuser(), new TileEntityHandler(BlockInfuser.TileEntityInfuser.class)
/*     */   {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 168 */       rendererList.add(new emoniph.intangible.client.renderer.RenderInfuser());
/*     */     }
/* 165 */   }, emoniph.intangible.items.ItemInfuser.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 172 */   public final BlockShell PLAYER_SHELL = (BlockShell)this.registry.add("shell", new BlockShell(), new TileEntityHandler(BlockShell.TileEntityShell.class)
/*     */   {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 175 */       rendererList.add(new emoniph.intangible.client.renderer.RenderShell());
/*     */     }
/* 172 */   }, 
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 177 */     EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE, RegistryFlags.NO_INVENTORY_MODEL));
/*     */   
/* 179 */   public final Block RECONSTRUCTOR = this.registry.add("reconstructor", new BlockReconstructor(), new TileEntityHandler(BlockReconstructor.TileEntityReconstructor.class)
/*     */   {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 182 */       rendererList.add(new emoniph.intangible.client.renderer.RenderReconstructor());
/*     */     }
/* 179 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 186 */   public final BlockGolemFactory GOLEM_FACTORY = (BlockGolemFactory)this.registry.add("golemfactory", new BlockGolemFactory(), new TileEntityHandler(BlockGolemFactory.TileEntityGolemFactory.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 188 */       rendererList.add(new emoniph.intangible.client.renderer.RenderGolemFactory());
/*     */     }
/* 186 */   }, emoniph.intangible.items.ItemGolemFactory.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 192 */   public final Block SYNTHETIC_RESONATOR = this.registry.add("syntheticresonator", new BlockSyntheticResonator(), new TileEntityHandler(BlockSyntheticResonator.TileEntitySyntheticResonator.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 194 */       rendererList.add(new RenderSyntheticResonator());
/*     */     }
/* 192 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 198 */   public final Block LARGE_BUTTON = this.registry.add("largebutton", new BlockLargeButton());
/*     */   
/* 200 */   public final Block GOLEM_PART_ASSEMBLER = this.registry.add("golempartassembler", new BlockGolemPartAssembler(), new TileEntityHandler(BlockGolemPartAssembler.TileEntityGolemPartAssembler.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 202 */       rendererList.add(new emoniph.intangible.client.renderer.RenderGolemPartAssembler());
/*     */     }
/* 200 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 206 */   public final Block DEITY_HAMMER = this.registry.add("deityhammer", new BlockDeityHammer(), new TileEntityHandler(BlockDeityHammer.TileEntityDeityHammer.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 208 */       rendererList.add(new emoniph.intangible.client.renderer.RenderDeityHammer());
/*     */     }
/* 206 */   }, emoniph.intangible.items.ItemDeityHammer.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 212 */   public final BlockTrigger TRIGGER = (BlockTrigger)this.registry.add("trigger", new BlockTrigger(true), new TileEntityHandler(BlockTrigger.TileEntityTrigger.class), 
/* 213 */     EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE, RegistryFlags.NO_INVENTORY_MODEL));
/*     */   
/* 215 */   public final Block LIGHT = this.registry.add("light", new BlockLight(), EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE));
/*     */   
/* 217 */   public final Block DEFENSE = this.registry.add("defense", new BlockDefense(), new TileEntityHandler(BlockDefense.TileEntityDefense.class) {
/*     */     void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> rendererList) {
/* 219 */       rendererList.add(new emoniph.intangible.client.renderer.RenderDefense());
/*     */     }
/* 217 */   }, emoniph.intangible.items.ItemDefense.class);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 223 */   public final BlockSlurp SLURP = (BlockSlurp)this.registry.add("slurp", new BlockSlurp(), new TileEntityHandler(BlockSlurp.TileEntitySlurp.class), 
/* 224 */     EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE, RegistryFlags.NO_INVENTORY_MODEL));
/*     */   
/* 226 */   public final Block CLOUD = this.registry.add("cloud", new BlockCloud(), EnumSet.of(RegistryFlags.HIDE_IN_CREATIVE, RegistryFlags.NO_INVENTORY_MODEL));
/*     */   
/* 228 */   public final Block BLUE_CRYSTAL_BLOCK = this.registry.add("blue_crystal_block", new BlockCrystalBlock());
/*     */   
/* 230 */   public final Block YELLOW_CRYSTAL_BLOCK = this.registry.add("yellow_crystal_block", new BlockCrystalBlock());
/*     */   
/* 232 */   public final Block LARGE_LEVER = this.registry.add("largelever", new BlockLargeLever());
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void preInit(Minecraft mc)
/*     */   {
/* 237 */     this.registry.preInit(mc);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void init(Minecraft mc, RenderItem renderItem)
/*     */   {
/* 243 */     this.registry.init(mc, renderItem);
/* 244 */     net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVoid.class, new emoniph.intangible.client.renderer.RenderVoid());
/*     */   }
/*     */   
/*     */   public void foreach(IBlockVisitor visitor) {
/* 248 */     this.registry.foreach(visitor);
/*     */   }
/*     */   
/*     */ 
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/* 254 */     net.minecraftforge.fml.common.registry.GameRegistry.registerTileEntity(TileEntityVoid.class, "intangible:void");
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/ModBlocks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */