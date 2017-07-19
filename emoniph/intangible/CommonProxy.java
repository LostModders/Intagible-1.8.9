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
/*     */ import emoniph.intangible.entity.ModEntities;
/*     */ import emoniph.intangible.fluids.ModFluids;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.golem.GolemPartRegistry;
/*     */ import emoniph.intangible.init.IModHandleIMC;
/*     */ import emoniph.intangible.init.IModInit;
/*     */ import emoniph.intangible.init.IModPostInit;
/*     */ import emoniph.intangible.init.IModPreInit;
/*     */ import emoniph.intangible.init.IModServerStarting;
/*     */ import emoniph.intangible.init.IModServerStopping;
/*     */ import emoniph.intangible.init.IModService;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.knowledge.Book;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.mods.HookManager;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import emoniph.intangible.player.PlayerEx.Service;
/*     */ import emoniph.intangible.player.PlayerForms;
/*     */ import emoniph.intangible.potions.ModPotions;
/*     */ import emoniph.intangible.recipes.ModRecipes;
/*     */ import emoniph.intangible.souls.RelayNetwork;
/*     */ import emoniph.intangible.souls.SoulRegistry;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemArmor.ArmorMaterial;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.common.util.EnumHelper;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
/*     */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ 
/*     */ public class CommonProxy
/*     */ {
/*  58 */   protected final List<IModService> services = new ArrayList();
/*     */   
/*     */   Config config;
/*     */   
/*     */   Log log;
/*     */   
/*     */   PacketPipeline packetPipeline;
/*     */   ModFluids fluids;
/*     */   ModBlocks blocks;
/*     */   ModItems items;
/*     */   PlayerForms forms;
/*     */   EffectRegistry effects;
/*     */   ModDeityEffects deityEffects;
/*     */   DeityManager deities;
/*     */   ActionQueue actionQueue;
/*     */   SoulRegistry souls;
/*     */   Knowledge knowledge;
/*     */   Book book;
/*     */   ModRecipes recipes;
/*     */   RelayNetwork relays;
/*     */   WellNetwork wells;
/*     */   GolemPartRegistry golems;
/*     */   ModPotions potions;
/*     */   ShrineManager shrines;
/*     */   ItemArmor.ArmorMaterial armorBoneMaterial;
/*     */   ItemArmor.ArmorMaterial armorYellowCrystalMaterial;
/*     */   ItemArmor.ArmorMaterial armorBlueCrystalMaterial;
/*     */   net.minecraft.item.Item.ToolMaterial toolBoneMaterial;
/*     */   ParticleFactory particleFactory;
/*     */   ModSpells spells;
/*     */   ModPriestSpells priestSpells;
/*     */   
/*     */   protected void registerService(IModService service)
/*     */   {
/*  92 */     this.services.add(service);
/*     */   }
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  97 */     emoniph.intangible.capabilities.CapabilityKillTracker.register();
/*  98 */     emoniph.intangible.items.ItemBoneSpear.registerCapabilities();
/*     */     
/* 100 */     this.armorBoneMaterial = EnumHelper.addArmorMaterial("SOULBONE", "diamond", 33, new int[] { 2, 6, 5, 2 }, 10);
/* 101 */     this.armorYellowCrystalMaterial = EnumHelper.addArmorMaterial("YELLOW_CRYSTAL", "diamond", 1, new int[] { 4, 9, 7, 4 }, 25);
/* 102 */     this.armorBlueCrystalMaterial = EnumHelper.addArmorMaterial("BLUE_CRYSTAL", "diamond", 1, new int[] { 4, 9, 7, 4 }, 15);
/* 103 */     this.toolBoneMaterial = EnumHelper.addToolMaterial("SOULBONE", 2, 1561, 4.0F, 2.0F, 10);
/*     */     
/* 105 */     registerService(this.config = new Config());
/* 106 */     registerService(this.log = new Log());
/* 107 */     registerService(this.packetPipeline = new PacketPipeline());
/* 108 */     registerService(this.relays = new RelayNetwork());
/* 109 */     registerService(this.wells = new WellNetwork());
/* 110 */     registerService(this.fluids = new ModFluids());
/* 111 */     registerService(this.blocks = new ModBlocks());
/* 112 */     registerService(this.items = new ModItems());
/* 113 */     registerService(new ModEntities());
/* 114 */     registerService(this.forms = new PlayerForms());
/* 115 */     registerService(new PlayerEx.Service());
/* 116 */     registerService(new HookManager());
/* 117 */     registerService(new ApiManager());
/* 118 */     registerService(this.effects = new EffectRegistry());
/* 119 */     registerService(this.souls = new SoulRegistry());
/* 120 */     registerService(this.deityEffects = new ModDeityEffects());
/* 121 */     registerService(this.deities = new DeityManager());
/* 122 */     registerService(this.actionQueue = new ActionQueue());
/* 123 */     registerService(this.particleFactory = new ParticleFactory());
/*     */     
/* 125 */     registerService(this.potions = new ModPotions());
/*     */     
/* 127 */     registerService(this.golems = new GolemPartRegistry());
/*     */     
/* 129 */     registerService(this.recipes = new ModRecipes());
/* 130 */     registerService(this.knowledge = new Knowledge());
/* 131 */     registerService(this.book = new Book());
/* 132 */     registerService(this.spells = new ModSpells());
/* 133 */     registerService(this.priestSpells = new ModPriestSpells());
/* 134 */     registerService(this.shrines = new ShrineManager());
/*     */     
/* 136 */     for (IModService service : this.services) {
/* 137 */       if ((service instanceof IModPreInit)) {
/* 138 */         ((IModPreInit)service).preInit(event);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void init(FMLInitializationEvent event) {
/* 144 */     for (IModService service : this.services) {
/* 145 */       if ((service instanceof IModInit)) {
/* 146 */         ((IModInit)service).init(event);
/*     */       }
/*     */     }
/*     */     
/* 150 */     NetworkRegistry.INSTANCE.registerGuiHandler(Intangible.INSTANCE, new GuiHandler());
/*     */     
/* 152 */     EventHandlers eventHandler = new EventHandlers();
/* 153 */     MinecraftForge.EVENT_BUS.register(eventHandler);
/*     */   }
/*     */   
/*     */   public int getSphereInnerID() {
/* 157 */     return 0;
/*     */   }
/*     */   
/*     */   public int getSphereOuterID() {
/* 161 */     return 0;
/*     */   }
/*     */   
/*     */   void postInit(FMLPostInitializationEvent event) {
/* 165 */     for (IModService service : this.services) {
/* 166 */       if ((service instanceof IModPostInit)) {
/* 167 */         ((IModPostInit)service).postInit(event);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void serverStarting(FMLServerStartingEvent event) {
/* 173 */     for (IModService service : this.services) {
/* 174 */       if ((service instanceof IModServerStarting)) {
/* 175 */         ((IModServerStarting)service).serverStarting(event);
/*     */       }
/*     */     }
/*     */     
/* 179 */     event.registerServerCommand(new emoniph.intangible.commands.PlayerCommands());
/* 180 */     event.registerServerCommand(new emoniph.intangible.commands.DeityCommands());
/*     */   }
/*     */   
/*     */   void serverStopping(FMLServerStoppingEvent event) {
/* 184 */     for (IModService service : this.services) {
/* 185 */       if ((service instanceof IModServerStopping)) {
/* 186 */         ((IModServerStopping)service).serverStopping(event);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void handleIMC(FMLInterModComms.IMCEvent event) {
/* 192 */     for (IModService service : this.services) {
/* 193 */       if ((service instanceof IModHandleIMC)) {
/* 194 */         ((IModHandleIMC)service).handleIMC(event);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public EntityPlayer getPlayer(MessageContext ctx) {
/* 200 */     return ctx.side == net.minecraftforge.fml.relauncher.Side.SERVER ? ctx.getServerHandler().field_147369_b : null;
/*     */   }
/*     */   
/*     */   public IGlow glow(World world, double x, double y, double z) {
/* 204 */     return GlowServer.INSTANCE;
/*     */   }
/*     */   
/*     */   public IGlow glow(World world, double x, double y, double z, double offset) {
/* 208 */     return GlowServer.INSTANCE;
/*     */   }
/*     */   
/*     */   public IGlow glow(World world, BlockPos pos) {
/* 212 */     return GlowServer.INSTANCE;
/*     */   }
/*     */   
/*     */   public IGlow glow(World world, BlockPos pos, double offset) {
/* 216 */     return GlowServer.INSTANCE;
/*     */   }
/*     */   
/*     */ 
/*     */   public void knolFX(World world, Vec3 start, EntityPlayer player) {}
/*     */   
/*     */   public float getPartialTicks()
/*     */   {
/* 224 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void queue(MessageContext ctx, Runnable runnable) {
/* 228 */     ctx.getServerHandler().field_147369_b.func_71121_q().func_152344_a(runnable);
/*     */   }
/*     */   
/*     */   public World getWorldForDimension(int dimensionId) {
/* 232 */     return MinecraftServer.func_71276_C().func_71218_a(dimensionId);
/*     */   }
/*     */   
/*     */   public void highlightPlayerSoul(EntityPlayer playerToHighlight) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/CommonProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */