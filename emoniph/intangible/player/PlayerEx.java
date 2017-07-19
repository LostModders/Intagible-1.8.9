/*      */ package emoniph.intangible.player;
/*      */ 
/*      */ import emoniph.intangible.CommonProxy;
/*      */ import emoniph.intangible.Get;
/*      */ import emoniph.intangible.Intangible;
/*      */ import emoniph.intangible.Sound;
/*      */ import emoniph.intangible.api.IKnol;
/*      */ import emoniph.intangible.api.IPassiveEffect;
/*      */ import emoniph.intangible.api.IPossessable;
/*      */ import emoniph.intangible.api.ISoulArmor;
/*      */ import emoniph.intangible.api.ISoulSet;
/*      */ import emoniph.intangible.api.ISpell;
/*      */ import emoniph.intangible.capabilities.IKillTracker;
/*      */ import emoniph.intangible.config.Config;
/*      */ import emoniph.intangible.deity.ModPriestSpells.PriestSpell;
/*      */ import emoniph.intangible.deity.PlayerWorshipTracker;
/*      */ import emoniph.intangible.deity.PriestCooldownManager;
/*      */ import emoniph.intangible.effects.EffectCooldownManager;
/*      */ import emoniph.intangible.effects.EffectRegistry;
/*      */ import emoniph.intangible.effects.EffectSet;
/*      */ import emoniph.intangible.effects.EffectTimer;
/*      */ import emoniph.intangible.entity.EntitySoul;
/*      */ import emoniph.intangible.knowledge.BookNavigator;
/*      */ import emoniph.intangible.knowledge.Knowledge;
/*      */ import emoniph.intangible.knowledge.Learning;
/*      */ import emoniph.intangible.network.IPacketRegister;
/*      */ import emoniph.intangible.network.PacketPipeline;
/*      */ import emoniph.intangible.souls.BusySoulSet;
/*      */ import emoniph.intangible.souls.ShellRegistry;
/*      */ import emoniph.intangible.souls.SoulSet;
/*      */ import emoniph.intangible.spells.ModSpells;
/*      */ import emoniph.intangible.spells.SpellIcon;
/*      */ import emoniph.intangible.util.EnumArmorSlot;
/*      */ import emoniph.intangible.util.WorldPos;
/*      */ import io.netty.buffer.ByteBuf;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Queue;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.block.state.IBlockState;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.passive.EntityHorse;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.player.EntityPlayerMP;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.BlockPos;
/*      */ import net.minecraft.util.EnumFacing;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
/*      */ import net.minecraftforge.event.entity.player.PlayerEvent.Clone;
/*      */ import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
/*      */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*      */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*      */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*      */ import net.minecraftforge.fml.relauncher.Side;
/*      */ 
/*      */ public class PlayerEx implements net.minecraftforge.common.IExtendedEntityProperties, emoniph.intangible.api.IPlayerProperties, emoniph.intangible.api.ICooldownManager
/*      */ {
/*      */   private static final String PLAYER_PROPS_ID = "intangibleExtendedPlayer";
/*      */   public EntityPlayer PLAYER;
/*      */   public final PlayerTempCache CACHE;
/*      */   private boolean incorporeal;
/*      */   private PlayerForm playerForm;
/*      */   private long totalTicks;
/*      */   private int lastHit;
/*      */   
/*      */   public static void addItemStackToInventory(EntityPlayer player, ItemStack stack)
/*      */   {
/*   74 */     if (!player.field_70170_p.field_72995_K) {
/*   75 */       if (!player.field_71071_by.func_70441_a(stack)) {
/*   76 */         player.field_70170_p.func_72838_d(new net.minecraft.entity.item.EntityItem(player.field_70170_p, player.field_70165_t, player.field_70163_u + player.field_70131_O * 0.5D, player.field_70161_v, stack));
/*      */ 
/*      */       }
/*   79 */       else if ((player instanceof EntityPlayerMP)) {
/*   80 */         ((EntityPlayerMP)player).func_71120_a(player.field_71069_bz);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class Service implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModPreInit, emoniph.intangible.init.IModInit, emoniph.intangible.network.IRegisterPackets
/*      */   {
/*      */     public void preInit(net.minecraftforge.fml.common.event.FMLPreInitializationEvent event)
/*      */     {
/*   89 */       Get.pipeline().registerPacketProvider(this);
/*      */     }
/*      */     
/*      */     public void init(net.minecraftforge.fml.common.event.FMLInitializationEvent event)
/*      */     {
/*   94 */       net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public void registerPackets(IPacketRegister packetRegister)
/*      */     {
/*  100 */       packetRegister.registerPacket(PlayerEx.PacketSyncToClient.Handler.class, PlayerEx.PacketSyncToClient.class, Side.CLIENT);
/*  101 */       packetRegister.registerPacket(PlayerEx.PacketSyncToServer.Handler.class, PlayerEx.PacketSyncToServer.class, Side.SERVER);
/*  102 */       packetRegister.registerPacket(PlayerEx.PacketMotion.Handler.class, PlayerEx.PacketMotion.class, Side.CLIENT);
/*  103 */       packetRegister.registerPacket(PlayerEx.PacketRequestSync.Handler.class, PlayerEx.PacketRequestSync.class, Side.SERVER);
/*  104 */       packetRegister.registerPacket(PlayerEx.PacketEntityLivingAction.Handler.class, PlayerEx.PacketEntityLivingAction.class, Side.SERVER);
/*  105 */       packetRegister.registerPacket(PlayerEx.PacketAttach.Handler.class, PlayerEx.PacketAttach.class, Side.CLIENT);
/*  106 */       packetRegister.registerPacket(PlayerEx.PacketDiscovery.Handler.class, PlayerEx.PacketDiscovery.class, Side.CLIENT);
/*  107 */       packetRegister.registerPacket(PlayerEx.PacketTryPossess.Handler.class, PlayerEx.PacketTryPossess.class, Side.SERVER);
/*  108 */       packetRegister.registerPacket(PlayerEx.PacketLiteSyncToClient.Handler.class, PlayerEx.PacketLiteSyncToClient.class, Side.CLIENT);
/*  109 */       packetRegister.registerPacket(PlayerEx.PacketSelectShell.Handler.class, PlayerEx.PacketSelectShell.class, Side.SERVER);
/*  110 */       packetRegister.registerPacket(PlayerEx.PacketPlayerTeleport.Handler.class, PlayerEx.PacketPlayerTeleport.class, Side.SERVER);
/*  111 */       packetRegister.registerPacket(PlayerEx.PacketTravelDestinations.Handler.class, PlayerEx.PacketTravelDestinations.class, Side.CLIENT);
/*      */     }
/*      */     
/*      */     @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
/*      */     public void onEntityConstructing(EntityEvent.EntityConstructing event) {
/*  116 */       if ((event.entity != null) && ((event.entity instanceof EntityPlayer))) {
/*  117 */         EntityPlayer player = (EntityPlayer)event.entity;
/*  118 */         if (PlayerEx.get(player) == null) {
/*  119 */           player.registerExtendedProperties("intangibleExtendedPlayer", new PlayerEx(player, null));
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*      */     @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
/*      */     public void onEntityJoinWorld(net.minecraftforge.event.entity.EntityJoinWorldEvent event) {
/*  126 */       if ((event.entity instanceof EntityPlayer)) {
/*  127 */         EntityPlayer player = (EntityPlayer)event.entity;
/*  128 */         PlayerEx playerEx = PlayerEx.get(player);
/*  129 */         playerEx.playerJoinedWorld(event.world, false);
/*      */       }
/*      */     }
/*      */     
/*      */     @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
/*      */     public void onPlayerCloneEvent(PlayerEvent.Clone event)
/*      */     {
/*  136 */       PlayerEx originalPlayerEx = PlayerEx.get(event.original);
/*  137 */       NBTTagCompound originalPlayerNBT = new NBTTagCompound();
/*  138 */       originalPlayerEx.saveNBTData(originalPlayerNBT);
/*  139 */       PlayerEx.get(event.entityPlayer).loadNBTData(originalPlayerNBT);
/*      */       
/*  141 */       IKillTracker origTracker = (IKillTracker)event.original.getCapability(emoniph.intangible.capabilities.CapabilityKillTracker.KILL_TRACKER_CAPABILITY, EnumFacing.UP);
/*  142 */       IKillTracker newTracker = (IKillTracker)event.entityPlayer.getCapability(emoniph.intangible.capabilities.CapabilityKillTracker.KILL_TRACKER_CAPABILITY, EnumFacing.UP);
/*  143 */       if ((origTracker != null) && (newTracker != null) && ((newTracker instanceof emoniph.intangible.capabilities.IKillTrackerSetter))) {
/*  144 */         emoniph.intangible.capabilities.IKillTrackerSetter setter = (emoniph.intangible.capabilities.IKillTrackerSetter)newTracker;
/*  145 */         setter.setLastKillServerTime(origTracker.getLastKillServerTime());
/*      */       }
/*  147 */       event.entityPlayer.field_71075_bZ.field_75101_c = event.original.field_71075_bZ.field_75101_c;
/*  148 */       event.entityPlayer.field_71075_bZ.field_75100_b = event.original.field_71075_bZ.field_75100_b;
/*  149 */       PlayerEx.get(event.entityPlayer).PLAYER = event.entityPlayer;
/*  150 */       PlayerEx.get(event.entityPlayer).syncToClient();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */     @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
/*      */     public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event)
/*      */     {
/*  159 */       PlayerEx playerEx = PlayerEx.get(event.player);
/*  160 */       playerEx.playerJoinedWorld(event.player.field_70170_p, true);
/*  161 */       if (!event.player.field_70170_p.field_72995_K) {
/*  162 */         for (IPassiveEffect effect : playerEx.currentEffects) {
/*  163 */           effect.startEffectOn(playerEx.PLAYER, false);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static PlayerEx get(EntityPlayer player)
/*      */   {
/*  172 */     net.minecraftforge.common.IExtendedEntityProperties props = player.getExtendedProperties("intangibleExtendedPlayer");
/*  173 */     if (props == null) {
/*  174 */       return null;
/*      */     }
/*      */     
/*  177 */     return (PlayerEx)props;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void setLastHit()
/*      */   {
/*  192 */     this.lastHit = emoniph.intangible.util.TickUtil.fromSeconds(10);
/*      */   }
/*      */   
/*      */   public boolean isRecentlyHit()
/*      */   {
/*  197 */     return this.lastHit > 0;
/*      */   }
/*      */   
/*      */   private PlayerEx(EntityPlayer player) {
/*  201 */     this.PLAYER = player;
/*  202 */     this.CACHE = new PlayerTempCache(player);
/*  203 */     this.playerForm = Get.forms().DEFAULT;
/*      */   }
/*      */   
/*      */ 
/*      */   public void init(Entity entity, World world) {}
/*      */   
/*      */ 
/*      */   public long getTotalTicks()
/*      */   {
/*  212 */     return this.totalTicks;
/*      */   }
/*      */   
/*      */ 
/*  216 */   private BookNavigator bookNavigator = new BookNavigator();
/*      */   
/*      */   public BookNavigator getBookNavigator() {
/*  219 */     return this.bookNavigator;
/*      */   }
/*      */   
/*  222 */   private Learning learning = new Learning();
/*      */   
/*      */   public Learning getLearning() {
/*  225 */     return this.learning;
/*      */   }
/*      */   
/*      */   public void learnKnowledge(Vec3 source, IKnol... knols)
/*      */   {
/*  230 */     if (isServerWorld()) {
/*  231 */       List<IKnol> newKnowledge = new java.util.ArrayList();
/*  232 */       for (IKnol knol : knols) {
/*  233 */         if (!this.learning.contains(knol)) {
/*  234 */           this.learning.add(knol);
/*  235 */           newKnowledge.add(knol);
/*      */         }
/*      */       }
/*  238 */       if (!newKnowledge.isEmpty()) {
/*  239 */         syncToClient();
/*  240 */         Get.pipeline().sendTo(new PacketDiscovery(source, (IKnol[])newKnowledge.toArray(new IKnol[newKnowledge.size()])), this.PLAYER);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeKnowledge(IKnol knol) {
/*  246 */     if (isServerWorld()) {
/*  247 */       this.learning.remove(knol);
/*  248 */       syncToClient();
/*      */     }
/*      */   }
/*      */   
/*      */   public void removeKnowledgeAll() {
/*  253 */     if (isServerWorld()) {
/*  254 */       this.learning.removeAll();
/*  255 */       syncToClient();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean isKnowledgeLearnt(IKnol... knols)
/*      */   {
/*  262 */     return this.learning.contains(knols);
/*      */   }
/*      */   
/*      */   public boolean isKnowledgeLearnt(ISoulSet souls) {
/*  266 */     for (emoniph.intangible.api.SoulType soulType : ) {
/*  267 */       if (souls.quantityOf(soulType) > 0) if (!isKnowledgeLearnt(new IKnol[] { Get.knowledge().getKnolForSoul(soulType) })) {
/*  268 */           return false;
/*      */         }
/*      */     }
/*  271 */     return true;
/*      */   }
/*      */   
/*  274 */   private EffectCooldownManager effectCooldownManager = new EffectCooldownManager();
/*      */   
/*      */   public void setCooldown(IPassiveEffect effect, int ticks)
/*      */   {
/*  278 */     this.effectCooldownManager.setCooldown(effect, ticks);
/*  279 */     syncToClient();
/*      */   }
/*      */   
/*      */   public boolean isCooldownActive(IPassiveEffect effect)
/*      */   {
/*  284 */     return this.effectCooldownManager.isCooldownActive(effect);
/*      */   }
/*      */   
/*      */   public SoulSet getCurrentSouls() {
/*  288 */     return this.currentSouls;
/*      */   }
/*      */   
/*      */   public EffectSet getActiveEffects() {
/*  292 */     return this.currentEffects;
/*      */   }
/*      */   
/*  295 */   private SoulSet currentSouls = new SoulSet();
/*  296 */   private EffectSet currentEffects = new EffectSet();
/*  297 */   private BusySoulSet busySouls = new BusySoulSet();
/*  298 */   private java.util.HashMap<IPassiveEffect, EffectTimer> clientEffectTimers = new java.util.HashMap();
/*      */   
/*      */   public boolean hasSouls() {
/*  301 */     boolean noSouls = (this.currentSouls.isEmpty()) && (this.busySouls.isEmpty()) && (this.currentEffects.isEmpty());
/*  302 */     return !noSouls;
/*      */   }
/*      */   
/*      */   @net.minecraftforge.fml.relauncher.SideOnly(Side.CLIENT)
/*      */   public ISoulSet getBusySouls() {
/*  307 */     SoulSet souls = new SoulSet();
/*  308 */     this.busySouls.addTo(souls);
/*  309 */     this.currentEffects.addTo(souls);
/*  310 */     return souls;
/*      */   }
/*      */   
/*      */   public void infuseSouls(ISoulSet souls, boolean sync) {
/*  314 */     this.currentSouls.add(souls);
/*  315 */     if (sync) {
/*  316 */       syncToAllClients();
/*      */     }
/*      */   }
/*      */   
/*      */   public java.util.HashMap<IPassiveEffect, EffectTimer> getClientEffectTimers() {
/*  321 */     return this.clientEffectTimers;
/*      */   }
/*      */   
/*      */   public boolean tryConsumeSouls(ISoulSet souls, int cooldownTicks) {
/*  325 */     if ((this.currentRebellion < getMaxRebellion()) && (this.currentSouls.trySubtract(souls))) {
/*  326 */       this.busySouls.add(new emoniph.intangible.souls.BusySouls(souls, cooldownTicks));
/*  327 */       syncToClient();
/*  328 */       return true;
/*      */     }
/*  330 */     return false;
/*      */   }
/*      */   
/*      */   public boolean canConsumeSouls(ISoulSet souls) {
/*  334 */     if ((this.currentRebellion < getMaxRebellion()) && (this.currentSouls.contains(souls))) {
/*  335 */       return true;
/*      */     }
/*  337 */     return false;
/*      */   }
/*      */   
/*      */   public SoulSet clearSoulsAndSpells(boolean sync) {
/*  341 */     clearSpells(false);
/*  342 */     SoulSet freedSouls = getAllSouls();
/*  343 */     this.currentSouls = new SoulSet();
/*  344 */     this.busySouls = new BusySoulSet();
/*  345 */     if (sync) {
/*  346 */       syncToClient();
/*      */     }
/*  348 */     return freedSouls;
/*      */   }
/*      */   
/*      */   public void clearSpells(boolean sync) {
/*  352 */     List<IPassiveEffect> bin = new java.util.ArrayList();
/*  353 */     for (IPassiveEffect effect : getActiveEffects()) {
/*  354 */       bin.add(effect);
/*      */     }
/*  356 */     for (IPassiveEffect effect : bin) {
/*  357 */       tryToggleEffect(effect);
/*      */     }
/*      */     
/*  360 */     if (sync) {
/*  361 */       syncToClient();
/*      */     }
/*      */   }
/*      */   
/*      */   public SoulSet getAllSouls() {
/*  366 */     SoulSet allSouls = new SoulSet();
/*  367 */     this.currentSouls.addTo(allSouls);
/*  368 */     this.busySouls.addTo(allSouls);
/*  369 */     this.currentEffects.addTo(allSouls);
/*  370 */     return allSouls;
/*      */   }
/*      */   
/*      */   public boolean canAbsorbSoulSet(SoulSet souls) {
/*  374 */     if (this.PLAYER.field_71075_bZ.field_75098_d) {
/*  375 */       return true;
/*      */     }
/*      */     
/*  378 */     int maxSouls = 0;
/*  379 */     for (emoniph.intangible.api.SoulType soulType : emoniph.intangible.api.SoulType.values()) {
/*  380 */       if (isKnowledgeLearnt(new IKnol[] { Get.knowledge().getKnolForSoul(soulType) })) {
/*  381 */         maxSouls += 2;
/*      */       }
/*      */     }
/*      */     
/*  385 */     return souls.size() <= maxSouls;
/*      */   }
/*      */   
/*      */   public void onPlayerTick() {
/*  389 */     boolean sync = false;
/*  390 */     this.totalTicks += 1L;
/*  391 */     if (this.lastHit > 0) {
/*  392 */       this.lastHit -= 1;
/*      */     }
/*  394 */     if (isServerWorld()) {
/*  395 */       if (this.busySouls.tickAndTryReleaseSouls(this.currentSouls)) {
/*  396 */         sync = true;
/*      */       }
/*      */       
/*  399 */       if ((this.CACHE.armorCache[0] != this.PLAYER.field_71071_by.field_70460_b[0]) || (this.CACHE.armorCache[1] != this.PLAYER.field_71071_by.field_70460_b[1]) || (this.CACHE.armorCache[2] != this.PLAYER.field_71071_by.field_70460_b[2]) || (this.CACHE.armorCache[3] != this.PLAYER.field_71071_by.field_70460_b[3]))
/*      */       {
/*      */ 
/*      */ 
/*  403 */         this.CACHE.armorCache[0] = this.PLAYER.field_71071_by.field_70460_b[0];
/*  404 */         this.CACHE.armorCache[1] = this.PLAYER.field_71071_by.field_70460_b[1];
/*  405 */         this.CACHE.armorCache[2] = this.PLAYER.field_71071_by.field_70460_b[2];
/*  406 */         this.CACHE.armorCache[3] = this.PLAYER.field_71071_by.field_70460_b[3];
/*  407 */         recalcArmorCapacity();
/*      */       }
/*      */       
/*  410 */       if ((this.currentRebellion > 0) && (this.PLAYER.field_70173_aa % 40 == 0)) {
/*  411 */         int max = getMaxRebellion();
/*  412 */         if (this.currentRebellion > max) {
/*  413 */           this.currentRebellion = max;
/*      */         }
/*  415 */         this.currentRebellion -= 1;
/*  416 */         if ((this.currentRebellion > 0) && (this.PLAYER.func_70093_af()) && (this.PLAYER.field_70122_E) && (!this.PLAYER.field_71075_bZ.field_75100_b)) {
/*  417 */           this.currentRebellion -= 1;
/*      */         }
/*  419 */         if (!sync) {
/*  420 */           syncLiteToClient();
/*      */         }
/*      */       }
/*      */       
/*  424 */       if (this.futureActions.processQueue(this, 10)) {
/*  425 */         sync = true;
/*      */       }
/*      */     }
/*      */     else
/*      */     {
/*  430 */       Iterator<java.util.Map.Entry<IPassiveEffect, EffectTimer>> itr = this.clientEffectTimers.entrySet().iterator();
/*  431 */       while (itr.hasNext()) {
/*  432 */         java.util.Map.Entry<IPassiveEffect, EffectTimer> entry = (java.util.Map.Entry)itr.next();
/*  433 */         if (((EffectTimer)entry.getValue()).increment()) {
/*  434 */           itr.remove();
/*      */         }
/*      */       }
/*      */       
/*  438 */       if ((this.travelPlanner != null) && (this.travelPlanner.isMovedTooFar(this.PLAYER))) {
/*  439 */         clearTravelDestinations();
/*      */       }
/*      */     }
/*      */     
/*  443 */     if ((this.effectCooldownManager.tick()) || (this.priestCooldownManager.tick())) {
/*  444 */       sync = true;
/*      */     }
/*      */     
/*  447 */     if (this.worshipTracker.onWorshipTick(this.PLAYER, this.totalTicks)) {
/*  448 */       sync = true;
/*      */     }
/*      */     
/*  451 */     if (sync) {
/*  452 */       syncToClient();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   public static class ActionQueue
/*      */   {
/*  461 */     private Queue<IAction> actions = new java.util.ArrayDeque();
/*      */     
/*      */     public void queue(IAction action) {
/*  464 */       this.actions.offer(action);
/*      */     }
/*      */     
/*      */     public boolean processQueue(PlayerEx playerEx, int maxItems)
/*      */     {
/*  469 */       boolean sync = false;
/*  470 */       IAction action; while (((action = (IAction)this.actions.poll()) != null) && (maxItems-- > 0)) {
/*  471 */         if (action.doAction(playerEx)) {
/*  472 */           sync = true;
/*      */         }
/*      */       }
/*  475 */       return sync; }
/*      */     
/*      */     public static abstract interface IAction { public abstract boolean doAction(PlayerEx paramPlayerEx); } }
/*      */   
/*  479 */   private ActionQueue futureActions = new ActionQueue();
/*      */   
/*      */   public ActionQueue getActionQueue() {
/*  482 */     return this.futureActions;
/*      */   }
/*      */   
/*  485 */   private int currentRebellion = 0;
/*  486 */   private int maxRebellion = 100;
/*      */   private long lastHarvestTicks;
/*      */   
/*  489 */   public float getRebellionPct() { return this.currentRebellion / getMaxRebellion(); }
/*      */   
/*      */   private int getMaxRebellion()
/*      */   {
/*  493 */     return this.maxRebellion;
/*      */   }
/*      */   
/*      */   public boolean isRebellionAvailable(int quantityRequired) {
/*  497 */     return this.currentRebellion + quantityRequired <= getMaxRebellion();
/*      */   }
/*      */   
/*      */   public void increaseRebellion(IPassiveEffect effect) {
/*  501 */     if (getActiveEffects().contains(effect)) {
/*  502 */       increaseRebellion(1, true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public long getLastHarvestTicks()
/*      */   {
/*  509 */     return this.lastHarvestTicks;
/*      */   }
/*      */   
/*      */   public void setLastHarvestTicks() {
/*  513 */     this.lastHarvestTicks = this.totalTicks;
/*      */   }
/*      */   
/*      */   public boolean increaseRebellion() {
/*  517 */     return increaseRebellion(1, true);
/*      */   }
/*      */   
/*      */   public boolean increaseRebellion(int quantity, boolean sync) {
/*  521 */     int max = getMaxRebellion();
/*  522 */     if (!Get.effects().isIncorporeal(this.PLAYER)) {
/*  523 */       if (this.currentRebellion < max) {
/*  524 */         int inc = Math.min(quantity, max - this.currentRebellion);
/*  525 */         this.currentRebellion += inc;
/*  526 */         if (this.currentRebellion == max) {
/*  527 */           if (isServerWorld()) {
/*  528 */             Sound.MOD_RANDOM_POWER_DOWN.playOnlyTo(this.PLAYER, 0.8F, 1.0F);
/*  529 */             this.futureActions.queue(new PlayerEx.ActionQueue.IAction()
/*      */             {
/*      */               public boolean doAction(PlayerEx playerEx) {
/*  532 */                 PlayerEx.this.clearSpells(false);
/*  533 */                 return true;
/*      */               }
/*      */             });
/*      */           }
/*  537 */           return false; }
/*  538 */         if (sync) {
/*  539 */           syncLiteToClient();
/*      */         }
/*  541 */       } else if (this.currentRebellion > max) {
/*  542 */         this.currentRebellion = max;
/*  543 */         if (sync) {
/*  544 */           syncLiteToClient();
/*      */         }
/*  546 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  550 */     return true;
/*      */   }
/*      */   
/*      */   public void decreaseRebellion() {
/*  554 */     this.currentRebellion -= 1;
/*  555 */     syncLiteToClient();
/*      */   }
/*      */   
/*  558 */   ShellRegistry shellRegistry = new ShellRegistry();
/*      */   private long ticksAsIncorporeal;
/*      */   
/*  561 */   public boolean createPlayerShell(World world, BlockPos pos, boolean fromEffectStart) { if (isServerWorld()) {
/*  562 */       if (!Get.blocks().PLAYER_SHELL.place(world, pos, this.PLAYER)) {
/*  563 */         return false;
/*      */       }
/*  565 */       this.shellRegistry.add(world, pos);
/*  566 */       syncToClient();
/*      */     }
/*  568 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public void initIncorporeal()
/*      */   {
/*  574 */     this.ticksAsIncorporeal = 0L;
/*      */   }
/*      */   
/*      */   public void tickIncorporeal() {
/*  578 */     this.ticksAsIncorporeal += 1L;
/*      */   }
/*      */   
/*      */   public boolean isActionPossible() {
/*  582 */     return this.ticksAsIncorporeal > 20L;
/*      */   }
/*      */   
/*      */   public void enterPlayerShell(World world, BlockPos pos, IBlockState state) {
/*  586 */     if ((isServerWorld()) && 
/*  587 */       (Get.effects().isActiveFor(Get.effects().INCORPOREAL, this.PLAYER)) && (isActionPossible())) {
/*  588 */       if (this.PLAYER.field_70154_o != null) {
/*  589 */         this.PLAYER.func_70078_a(null);
/*      */       }
/*  591 */       this.shellRegistry.remove(world, pos);
/*  592 */       world.func_175698_g(pos);
/*  593 */       tryToggleEffect(Get.effects().INCORPOREAL);
/*  594 */       Sound.MOD_RANDOM_POWER_DOWN.playToAllNear(this.PLAYER, 0.5F, 1.0F);
/*  595 */       syncToClient();
/*  596 */       float yaw = this.PLAYER.func_70079_am();
/*  597 */       if (state.func_177230_c() == Get.blocks().PLAYER_SHELL) {
/*  598 */         EnumFacing facing = (EnumFacing)state.func_177229_b(net.minecraft.block.BlockDirectional.field_176387_N);
/*  599 */         yaw = facing.func_176734_d().func_176736_b() * 90;
/*      */       }
/*  601 */       ((EntityPlayerMP)this.PLAYER).field_71135_a.func_147364_a(pos.func_177958_n() + 0.5D, pos.func_177956_o(), pos.func_177952_p() + 0.5D, yaw, (float)Math.toRadians(180.0D));
/*      */     }
/*      */   }
/*      */   
/*      */   public void removePlayerShell(World world, BlockPos pos)
/*      */   {
/*  607 */     if (isServerWorld()) {
/*  608 */       this.shellRegistry.remove(world, pos);
/*  609 */       world.func_175698_g(pos);
/*  610 */       Get.fx().sendToAllNear(net.minecraft.util.EnumParticleTypes.SMOKE_NORMAL, world, pos, 0.5F, 30);
/*      */     }
/*      */   }
/*      */   
/*      */   public ShellRegistry getShells() {
/*  615 */     return this.shellRegistry;
/*      */   }
/*      */   
/*  618 */   private final java.util.Map<ISpell, SpellIcon> spellIcons = new java.util.HashMap();
/*      */   private SpellIcon lastSpellIcon;
/*      */   
/*  621 */   public SpellIcon getSpellIconFor(ISpell spell) { SpellIcon icon = (SpellIcon)this.spellIcons.get(spell);
/*  622 */     if (icon == null) {
/*  623 */       icon = Get.config().getSpellIcon(spell);
/*  624 */       this.spellIcons.put(spell, icon);
/*      */     }
/*  626 */     return icon;
/*      */   }
/*      */   
/*      */   public ISpell getReadySpell() {
/*  630 */     return this.readySpell;
/*      */   }
/*      */   
/*      */   private ISpell[] spellShortcuts;
/*      */   public SpellIcon getLastSpellIcon()
/*      */   {
/*  636 */     return this.lastSpellIcon;
/*      */   }
/*      */   
/*      */   public void setLastSpellIcon(SpellIcon lastSpellIcon) {
/*  640 */     if ((lastSpellIcon == null) && (this.lastSpellIcon != null)) {
/*  641 */       Get.config().setSpellIcon(this.lastSpellIcon);
/*      */     }
/*  643 */     this.lastSpellIcon = lastSpellIcon;
/*      */   }
/*      */   
/*      */ 
/*      */   public void setSpellShortcut(int hotbarkey, ISpell spell)
/*      */   {
/*  649 */     initShortcuts();
/*  650 */     for (int i = 0; i < this.spellShortcuts.length; i++) {
/*  651 */       if (this.spellShortcuts[i] == spell) {
/*  652 */         this.spellShortcuts[i] = null;
/*      */       }
/*      */     }
/*  655 */     this.spellShortcuts[hotbarkey] = spell;
/*  656 */     Get.config().setSpellShortcut(hotbarkey, spell);
/*      */   }
/*      */   
/*      */   public ISpell getSpellShortcut(int hotbarkey) {
/*  660 */     initShortcuts();
/*  661 */     return this.spellShortcuts[hotbarkey];
/*      */   }
/*      */   
/*      */   private void initShortcuts() {
/*  665 */     if (this.spellShortcuts == null) {
/*  666 */       this.spellShortcuts = new ISpell[9];
/*  667 */       for (int i = 0; i < this.spellShortcuts.length; i++) {
/*  668 */         this.spellShortcuts[i] = Get.config().getSpellShortcut(i);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public int getShortcutKey(ISpell spell) {
/*  674 */     initShortcuts();
/*  675 */     for (int i = 0; i < this.spellShortcuts.length; i++) {
/*  676 */       if (this.spellShortcuts[i] == spell) {
/*  677 */         return i;
/*      */       }
/*      */     }
/*  680 */     return -1;
/*      */   }
/*      */   
/*      */   public void recalculateArmorCapacity() {
/*  684 */     recalcArmorCapacity();
/*      */   }
/*      */   
/*      */   private emoniph.intangible.souls.SoulCapacity recalcArmorCapacity() {
/*  688 */     Get.log().debug("Recalculating armor capacity after armor change");
/*  689 */     SoulSet armorCapacity = new SoulSet();
/*  690 */     calcArmorCapacityFor(EnumArmorSlot.HEAD, armorCapacity);
/*  691 */     calcArmorCapacityFor(EnumArmorSlot.CHEST, armorCapacity);
/*  692 */     calcArmorCapacityFor(EnumArmorSlot.LEGS, armorCapacity);
/*  693 */     calcArmorCapacityFor(EnumArmorSlot.FEET, armorCapacity);
/*  694 */     tryBaublesCapacity(armorCapacity);
/*      */     
/*  696 */     emoniph.intangible.souls.SoulCapacity capacity = new emoniph.intangible.souls.SoulCapacity(armorCapacity);
/*      */     
/*  698 */     boolean sync = false;
/*  699 */     Iterator<IPassiveEffect> itr = this.currentEffects.iterator();
/*  700 */     while (itr.hasNext()) {
/*  701 */       IPassiveEffect effect = (IPassiveEffect)itr.next();
/*  702 */       if (!Get.effects().tryDeductCostsFor(effect, capacity)) {
/*  703 */         itr.remove();
/*  704 */         effect.stopEffectOn(this.PLAYER);
/*  705 */         Get.effects().tryReplenishCostsFor(effect, this.currentSouls);
/*  706 */         sync = true;
/*      */       }
/*      */     }
/*      */     
/*  710 */     if (sync) {
/*  711 */       syncToAllClients();
/*      */     }
/*      */     
/*  714 */     return capacity;
/*      */   }
/*      */   
/*      */   private void calcArmorCapacityFor(EnumArmorSlot armorSlot, SoulSet capacity) {
/*  718 */     ItemStack armorPiece = this.PLAYER.func_71124_b(armorSlot.equipmentSlot);
/*  719 */     if ((armorPiece != null) && ((armorPiece.func_77973_b() instanceof ISoulArmor))) {
/*  720 */       ((ISoulArmor)armorPiece.func_77973_b()).augmentCapacity(armorPiece, capacity);
/*      */     }
/*      */   }
/*      */   
/*      */   private void tryBaublesCapacity(SoulSet capacity) {
/*  725 */     if (net.minecraftforge.fml.common.Loader.isModLoaded("Baubles")) {
/*  726 */       tryBaublesCapacityInner(capacity);
/*      */     }
/*      */   }
/*      */   
/*      */   @net.minecraftforge.fml.common.Optional.Method(modid="Baubles")
/*      */   private void tryBaublesCapacityInner(SoulSet capacity) {
/*  732 */     net.minecraft.inventory.IInventory inv = baubles.api.BaublesApi.getBaubles(this.PLAYER);
/*  733 */     int slot = 0; for (int count = inv.func_70302_i_(); slot < count; slot++) {
/*  734 */       ItemStack stack = inv.func_70301_a(slot);
/*  735 */       if ((stack != null) && ((stack.func_77973_b() instanceof ISoulArmor))) {
/*  736 */         ((ISoulArmor)stack.func_77973_b()).augmentCapacity(stack, capacity);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean enableEffectWithCooldown(IPassiveEffect newEffect, int cooldownTicks) {
/*  742 */     if ((this.currentEffects.contains(newEffect)) && (this.effectCooldownManager.isCooldownActive(newEffect))) {
/*  743 */       this.effectCooldownManager.setCooldown(newEffect, cooldownTicks);
/*  744 */       return true;
/*      */     }
/*  746 */     if (enableEffect(newEffect)) {
/*  747 */       this.effectCooldownManager.setCooldown(newEffect, cooldownTicks);
/*  748 */       return true;
/*      */     }
/*  750 */     return false;
/*      */   }
/*      */   
/*      */ 
/*      */   public boolean enableEffect(IPassiveEffect newEffect)
/*      */   {
/*  756 */     if (this.currentEffects.contains(newEffect)) {
/*  757 */       return true;
/*      */     }
/*      */     
/*  760 */     emoniph.intangible.souls.SoulCapacity remainingCapacity = recalcArmorCapacity();
/*      */     
/*  762 */     if (!newEffect.isPrerequisitesMet(this.PLAYER, this.PLAYER.func_71124_b(EnumArmorSlot.HEAD.equipmentSlot), this.PLAYER
/*  763 */       .func_71124_b(EnumArmorSlot.CHEST.equipmentSlot), this.PLAYER
/*  764 */       .func_71124_b(EnumArmorSlot.LEGS.equipmentSlot), this.PLAYER
/*  765 */       .func_71124_b(EnumArmorSlot.FEET.equipmentSlot)))
/*      */     {
/*  767 */       return false;
/*      */     }
/*      */     
/*  770 */     if (!Get.effects().tryDeductCostsFor(newEffect, remainingCapacity)) {
/*  771 */       return false;
/*      */     }
/*      */     
/*  774 */     if (!Get.effects().tryDeductCostsFor(newEffect, this.currentSouls)) {
/*  775 */       return false;
/*      */     }
/*      */     
/*  778 */     newEffect.startEffectOn(this.PLAYER, true);
/*      */     
/*  780 */     this.currentEffects.add(newEffect);
/*      */     
/*  782 */     syncToAllClients();
/*      */     
/*  784 */     return true;
/*      */   }
/*      */   
/*      */   public void disableEffectFuture(final IPassiveEffect effectToRemove) {
/*  788 */     this.futureActions.queue(new PlayerEx.ActionQueue.IAction()
/*      */     {
/*      */       public boolean doAction(PlayerEx playerEx) {
/*  791 */         PlayerEx.this.disableEffect(effectToRemove);
/*  792 */         return false;
/*      */       }
/*      */     });
/*      */   }
/*      */   
/*      */   public void disableEffect(IPassiveEffect effectToRemove) {
/*  798 */     if (!this.currentEffects.contains(effectToRemove)) {
/*  799 */       return;
/*      */     }
/*      */     
/*  802 */     this.currentEffects.remove(effectToRemove);
/*      */     
/*  804 */     effectToRemove.stopEffectOn(this.PLAYER);
/*      */     
/*  806 */     Get.effects().tryReplenishCostsFor(effectToRemove, this.currentSouls);
/*      */     
/*  808 */     syncToAllClients();
/*      */   }
/*      */   
/*      */   public boolean tryToggleEffect(IPassiveEffect effect) {
/*  812 */     if (this.currentEffects.contains(effect)) {
/*  813 */       disableEffect(effect);
/*  814 */       return true;
/*      */     }
/*  816 */     return enableEffect(effect);
/*      */   }
/*      */   
/*      */ 
/*  820 */   final FocusedTarget focusedTarget = new FocusedTarget();
/*      */   
/*      */   public void setPlayerForm(PlayerForm playerForm) {
/*  823 */     if ((this.playerForm != playerForm) && 
/*  824 */       (isServerWorld()))
/*      */     {
/*  826 */       boolean needsInit = ((this.playerForm != null) && (this.playerForm != playerForm)) || ((this.playerForm == null) && (playerForm != Get.forms().DEFAULT));
/*  827 */       this.playerForm = playerForm;
/*  828 */       if (needsInit) {
/*  829 */         playerForm.initializeOn(this);
/*      */       }
/*  831 */       syncToAllClients();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public PlayerForm getPlayerForm()
/*      */   {
/*  846 */     return this.playerForm;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  870 */   private PriestCooldownManager priestCooldownManager = new PriestCooldownManager();
/*      */   
/*      */   public void setCooldown(ModPriestSpells.PriestSpell spell) {
/*  873 */     this.priestCooldownManager.setCooldown(spell, spell.getCooldown());
/*  874 */     syncToClient();
/*      */   }
/*      */   
/*      */   public boolean isCooldownActive(ModPriestSpells.PriestSpell spell) {
/*  878 */     return this.priestCooldownManager.isCooldownActive(spell);
/*      */   }
/*      */   
/*      */   public int getRemainingCooldown(ModPriestSpells.PriestSpell spell) {
/*  882 */     return this.priestCooldownManager.getRemainingCooldown(spell);
/*      */   }
/*      */   
/*  885 */   private PlayerWorshipTracker worshipTracker = new PlayerWorshipTracker(this);
/*      */   private WorldPos triggerPos;
/*      */   
/*  888 */   public emoniph.intangible.deity.IPlayerWorship getWorship() { return this.worshipTracker; }
/*      */   
/*      */   public boolean tryWorship(emoniph.intangible.deity.Deity deity, long worship)
/*      */   {
/*  892 */     emoniph.intangible.deity.PlayerWorshipTracker.WorshipResult result = this.worshipTracker.tryWorship(this.PLAYER.field_70170_p, deity, this.PLAYER, this.totalTicks, worship);
/*  893 */     if (result == emoniph.intangible.deity.PlayerWorshipTracker.WorshipResult.FAIL) {
/*  894 */       return false;
/*      */     }
/*  896 */     this.worshipTracker.onWorship(this.PLAYER, deity, this.totalTicks);
/*  897 */     syncToClient();
/*  898 */     return true;
/*      */   }
/*      */   
/*      */   public boolean tryReduceWorship(World world, emoniph.intangible.api.deity.IDeity deity, long quantity)
/*      */   {
/*  903 */     return tryReduceWorship(world, deity.getId(), quantity, false);
/*      */   }
/*      */   
/*      */   public boolean tryReduceWorship(World world, java.util.UUID deityId, long quantity, boolean loseDevoutStatus) {
/*  907 */     if ((isServerWorld()) && (world != null) && (deityId != null)) {
/*  908 */       boolean success = this.worshipTracker.tryReduceWorship(world, deityId, quantity, loseDevoutStatus);
/*  909 */       if (success) {
/*  910 */         syncToClient();
/*      */       }
/*  912 */       return success;
/*      */     }
/*  914 */     return false;
/*      */   }
/*      */   
/*      */   public void onWorshipAttack(EntityLivingBase entity, boolean isDead) {
/*  918 */     if ((isServerWorld()) && 
/*  919 */       (this.worshipTracker.onAttack(this.PLAYER.field_70170_p, this.PLAYER, entity, isDead, this.totalTicks))) {
/*  920 */       syncToClient();
/*      */     }
/*      */   }
/*      */   
/*      */   public void onWorshipHarvest(World world, BlockPos pos, IBlockState state, List<ItemStack> drops)
/*      */   {
/*  926 */     if ((isServerWorld()) && 
/*  927 */       (this.worshipTracker.onHarvest(world, pos, state, drops, this.PLAYER, this.totalTicks))) {
/*  928 */       syncToClient();
/*      */     }
/*      */   }
/*      */   
/*      */   private ISpell readySpell;
/*      */   private TravelPlanner travelPlanner;
/*      */   public WorldPos getTriggerPos()
/*      */   {
/*  936 */     return this.triggerPos;
/*      */   }
/*      */   
/*      */   public void setTriggerPos(WorldPos pos) {
/*  940 */     if ((pos == null) || (this.triggerPos != null))
/*      */     {
/*  942 */       if ((pos != null) || (this.triggerPos == null)) {}
/*      */     }
/*      */     
/*  945 */     this.triggerPos = pos;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReadySpell(ISpell readySpell)
/*      */   {
/*  952 */     this.readySpell = readySpell;
/*  953 */     syncToClient();
/*      */   }
/*      */   
/*      */   public boolean hasReadySpell() {
/*  957 */     return this.readySpell != null;
/*      */   }
/*      */   
/*      */   public void triggerReadySpell(boolean clear) {
/*  961 */     if (this.readySpell != null) {
/*  962 */       Get.spells().tryInvokeSpell(this.PLAYER, this.readySpell);
/*  963 */       if (clear) {
/*  964 */         this.readySpell = null;
/*  965 */         syncToClient();
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public void syncToClient() {
/*  971 */     if (isServerWorld()) {
/*  972 */       Get.pipeline().sendTo(new PacketSyncToClient(this), this.PLAYER);
/*      */     }
/*      */   }
/*      */   
/*      */   private void syncLiteToClient() {
/*  977 */     if (isServerWorld()) {
/*  978 */       Get.pipeline().sendTo(new PacketLiteSyncToClient(this), this.PLAYER);
/*      */     }
/*      */   }
/*      */   
/*      */   private void syncToAllClients() {
/*  983 */     if (isServerWorld()) {
/*  984 */       Get.pipeline().sendToDimension(new PacketSyncToClient(this), this.PLAYER.field_71093_bK);
/*      */     }
/*      */   }
/*      */   
/*      */   public void playerJoinedWorld(World world, boolean first) {
/*  989 */     if (isClientWorld()) {
/*  990 */       Get.pipeline().sendToServer(new PacketRequestSync(this, first));
/*      */     } else {
/*  992 */       syncToClient();
/*  993 */       Get.deities().syncAllToPlayer(world, this.PLAYER);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isServerWorld() {
/*  998 */     return !this.PLAYER.field_70170_p.field_72995_K;
/*      */   }
/*      */   
/*      */   public boolean isClientWorld() {
/* 1002 */     return this.PLAYER.field_70170_p.field_72995_K;
/*      */   }
/*      */   
/*      */   public void saveNBTData(NBTTagCompound compound)
/*      */   {
/* 1007 */     NBTTagCompound props = new NBTTagCompound();
/* 1008 */     compound.func_74782_a("intangibleExtendedPlayer", props);
/*      */     
/* 1010 */     props.func_74757_a("intangible", this.incorporeal);
/* 1011 */     props.func_74782_a("currentSouls", this.currentSouls.toTagCompound());
/* 1012 */     props.func_74782_a("busySouls", this.busySouls.toTagCompound());
/* 1013 */     props.func_74782_a("currentEffects", this.currentEffects.toTagCompound());
/*      */     
/* 1015 */     props.func_74782_a("effectCooldowns", this.effectCooldownManager.toTagCompound());
/* 1016 */     props.func_74782_a("priestCooldowns", this.priestCooldownManager.toTagCompound());
/*      */     
/* 1018 */     props.func_74782_a("worship", this.worshipTracker.getTagCompound());
/*      */     
/* 1020 */     props.func_74782_a("book", this.bookNavigator.getTagCompound());
/*      */     
/* 1022 */     props.func_74782_a("learning", this.learning.toTagCompound());
/*      */     
/* 1024 */     if (this.readySpell != null) {
/* 1025 */       props.func_74778_a("readySpell", Get.spells().getIdForSpell(this.readySpell));
/*      */     }
/*      */     
/* 1028 */     props.func_74778_a("form", Get.forms().getIdForForm(getPlayerForm()));
/*      */     
/* 1030 */     props.func_74782_a("shells", this.shellRegistry.toTagCompound());
/*      */     
/* 1032 */     if (this.triggerPos != null) {
/* 1033 */       props.func_74782_a("triggerPos", this.triggerPos.toTagCompound());
/*      */     }
/*      */     
/* 1036 */     props.func_74768_a("rebellion", this.currentRebellion);
/*      */     
/* 1038 */     props.func_74772_a("totalTicks", this.totalTicks);
/* 1039 */     props.func_74772_a("lastHarvestTicks", this.lastHarvestTicks);
/*      */   }
/*      */   
/*      */   public void loadNBTData(NBTTagCompound compound)
/*      */   {
/* 1044 */     if (compound.func_150297_b("intangibleExtendedPlayer", 10)) {
/* 1045 */       NBTTagCompound props = compound.func_74775_l("intangibleExtendedPlayer");
/*      */       
/* 1047 */       this.incorporeal = props.func_74767_n("intangible");
/*      */       
/* 1049 */       if (props.func_150297_b("currentSouls", 10)) {
/* 1050 */         this.currentSouls = SoulSet.fromTagCompound(props.func_74775_l("currentSouls"));
/*      */       }
/*      */       
/* 1053 */       if (props.func_150297_b("busySouls", 10)) {
/* 1054 */         this.busySouls = BusySoulSet.fromTagCompound(props.func_74775_l("busySouls"));
/*      */       }
/*      */       
/* 1057 */       if (props.func_150297_b("currentEffects", 10)) {
/* 1058 */         this.currentEffects = EffectSet.fromTagCompound(props.func_74775_l("currentEffects"));
/*      */       }
/*      */       
/* 1061 */       if (props.func_150297_b("effectCooldowns", 10)) {
/* 1062 */         this.effectCooldownManager = EffectCooldownManager.fromTagCompound(props.func_74775_l("effectCooldowns"));
/*      */       }
/*      */       
/* 1065 */       if (props.func_150297_b("priestCooldowns", 10)) {
/* 1066 */         this.priestCooldownManager = PriestCooldownManager.fromTagCompound(props.func_74775_l("priestCooldowns"));
/*      */       }
/*      */       
/* 1069 */       if (props.func_150297_b("worship", 10)) {
/* 1070 */         this.worshipTracker = PlayerWorshipTracker.fromTagCompound(props.func_74775_l("worship"), this);
/*      */       }
/*      */       
/* 1073 */       if (props.func_150297_b("book", 10)) {
/* 1074 */         BookNavigator nav = BookNavigator.fromTagCompound(props.func_74775_l("book"));
/* 1075 */         if (nav != null) {
/* 1076 */           this.bookNavigator = nav;
/*      */         }
/*      */       }
/*      */       
/* 1080 */       if (props.func_150297_b("learning", 10)) {
/* 1081 */         Learning learn = Learning.fromTagCompound(props.func_74775_l("learning"));
/* 1082 */         if (learn != null) {
/* 1083 */           this.learning = learn;
/*      */         }
/*      */       }
/*      */       
/* 1087 */       if (props.func_150297_b("readySpell", 8)) {
/* 1088 */         this.readySpell = Get.spells().getSpellForId(props.func_74779_i("readySpell"));
/*      */       } else {
/* 1090 */         this.readySpell = null;
/*      */       }
/*      */       
/* 1093 */       if (props.func_150297_b("form", 8)) {
/* 1094 */         this.playerForm = Get.forms().getFormForId(props.func_74779_i("form"));
/*      */       }
/*      */       
/* 1097 */       if (props.func_150297_b("shells", 10)) {
/* 1098 */         this.shellRegistry = ShellRegistry.fromTagCompound(props.func_74775_l("shells"));
/*      */       }
/*      */       
/* 1101 */       if (props.func_150297_b("triggerPos", 10)) {
/* 1102 */         this.triggerPos = WorldPos.fromTagCompound(props.func_74775_l("triggerPos"));
/*      */       } else {
/* 1104 */         this.triggerPos = null;
/*      */       }
/*      */       
/* 1107 */       this.currentRebellion = props.func_74762_e("rebellion");
/*      */       
/* 1109 */       this.totalTicks = props.func_74763_f("totalTicks");
/* 1110 */       this.lastHarvestTicks = props.func_74763_f("lastHarvestTicks");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static class PacketLiteSyncToClient
/*      */     implements IMessage
/*      */   {
/*      */     private int rebellionMax;
/*      */     
/*      */     private int rebellionCurrent;
/*      */     
/*      */     public PacketLiteSyncToClient() {}
/*      */     
/*      */     public PacketLiteSyncToClient(PlayerEx playerEx)
/*      */     {
/* 1126 */       this.rebellionCurrent = playerEx.currentRebellion;
/* 1127 */       this.rebellionMax = playerEx.getMaxRebellion();
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1132 */       this.rebellionMax = buf.readShort();
/* 1133 */       this.rebellionCurrent = buf.readShort();
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1138 */       buf.writeShort((short)this.rebellionMax);
/* 1139 */       buf.writeShort((short)this.rebellionCurrent);
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketLiteSyncToClient, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketLiteSyncToClient message, final MessageContext ctx) {
/* 1145 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1147 */             EntityPlayer clientPlayer = Intangible.PROXY.getPlayer(ctx);
/* 1148 */             if (clientPlayer != null) {
/* 1149 */               PlayerEx playerEx = PlayerEx.get(clientPlayer);
/* 1150 */               playerEx.currentRebellion = message.rebellionCurrent;
/* 1151 */               playerEx.maxRebellion = message.rebellionMax;
/*      */             }
/*      */           }
/* 1154 */         });
/* 1155 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PacketSyncToClient
/*      */     implements IMessage
/*      */   {
/*      */     private int entityId;
/*      */     private SoulSet souls;
/*      */     private BusySoulSet busy;
/*      */     private EffectSet passiveEffects;
/*      */     private EffectCooldownManager cooldownManager;
/*      */     private PriestCooldownManager priestCooldowns;
/*      */     private BookNavigator book;
/*      */     private Learning learning;
/*      */     private ISpell readySpell;
/*      */     private PlayerForm form;
/*      */     private ShellRegistry shells;
/*      */     private PlayerWorshipTracker worship;
/*      */     private int rebellionMax;
/*      */     private int rebellionCurrent;
/*      */     
/*      */     public PacketSyncToClient() {}
/*      */     
/*      */     public PacketSyncToClient(PlayerEx playerEx)
/*      */     {
/* 1182 */       this.entityId = playerEx.PLAYER.func_145782_y();
/*      */       
/* 1184 */       this.busy = playerEx.busySouls;
/* 1185 */       this.souls = playerEx.currentSouls;
/* 1186 */       this.passiveEffects = playerEx.currentEffects;
/* 1187 */       this.cooldownManager = playerEx.effectCooldownManager;
/* 1188 */       this.priestCooldowns = playerEx.priestCooldownManager;
/* 1189 */       this.book = playerEx.bookNavigator;
/* 1190 */       this.learning = playerEx.learning;
/* 1191 */       this.readySpell = playerEx.readySpell;
/* 1192 */       this.form = playerEx.getPlayerForm();
/* 1193 */       this.shells = playerEx.shellRegistry;
/* 1194 */       this.worship = playerEx.worshipTracker;
/* 1195 */       this.rebellionCurrent = playerEx.currentRebellion;
/* 1196 */       this.rebellionMax = playerEx.getMaxRebellion();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1203 */       this.entityId = buf.readInt();
/*      */       
/* 1205 */       this.souls = SoulSet.fromBytes(buf);
/* 1206 */       this.busy = BusySoulSet.fromBytes(buf);
/* 1207 */       this.passiveEffects = EffectSet.fromBytes(buf);
/* 1208 */       this.cooldownManager = EffectCooldownManager.fromBytes(buf);
/* 1209 */       this.book = BookNavigator.fromBytes(buf);
/* 1210 */       this.learning = Learning.fromBytes(buf);
/* 1211 */       this.readySpell = Get.spells().getSpellFromIndex(buf.readInt());
/* 1212 */       this.form = Get.forms().getFormForIndex(buf.readInt());
/* 1213 */       this.shells = ShellRegistry.readFrom(buf);
/* 1214 */       this.worship = PlayerWorshipTracker.readFrom(buf);
/* 1215 */       this.priestCooldowns = PriestCooldownManager.fromBytes(buf);
/* 1216 */       this.rebellionMax = buf.readShort();
/* 1217 */       this.rebellionCurrent = buf.readShort();
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1222 */       buf.writeInt(this.entityId);
/*      */       
/* 1224 */       this.souls.writeTo(buf);
/* 1225 */       this.busy.writeTo(buf);
/* 1226 */       this.passiveEffects.writeTo(buf);
/* 1227 */       this.cooldownManager.writeTo(buf);
/* 1228 */       this.book.writeTo(buf);
/* 1229 */       this.learning.writeTo(buf);
/* 1230 */       buf.writeInt(Get.spells().getIndexFromSpell(this.readySpell));
/* 1231 */       buf.writeInt(Get.forms().getIndexForForm(this.form));
/* 1232 */       this.shells.writeTo(buf);
/* 1233 */       this.worship.writeTo(buf);
/* 1234 */       this.priestCooldowns.writeTo(buf);
/* 1235 */       buf.writeShort((short)this.rebellionMax);
/* 1236 */       buf.writeShort((short)this.rebellionCurrent);
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketSyncToClient, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketSyncToClient message, final MessageContext ctx) {
/* 1242 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1244 */             EntityPlayer clientPlayer = Intangible.PROXY.getPlayer(ctx);
/* 1245 */             if (clientPlayer != null) {
/* 1246 */               Entity entity = clientPlayer.field_70170_p.func_73045_a(message.entityId);
/* 1247 */               if ((entity != null) && ((entity instanceof EntityPlayer))) {
/* 1248 */                 EntityPlayer player = (EntityPlayer)entity;
/* 1249 */                 Get.log().debug(String.format("Client sync for player <%s>", new Object[] { player.getDisplayNameString() }));
/* 1250 */                 PlayerEx playerEx = PlayerEx.get(player);
/*      */                 
/* 1252 */                 playerEx.currentRebellion = message.rebellionCurrent;
/* 1253 */                 playerEx.maxRebellion = message.rebellionMax;
/*      */                 
/*      */ 
/* 1256 */                 playerEx.currentSouls = message.souls;
/* 1257 */                 playerEx.busySouls = message.busy;
/*      */                 
/* 1259 */                 message.passiveEffects.updateClientTimers(playerEx.clientEffectTimers, playerEx.currentEffects);
/* 1260 */                 for (IPassiveEffect effect : playerEx.currentEffects) {
/* 1261 */                   if (!message.passiveEffects.contains(effect)) {
/* 1262 */                     effect.stopEffectOn(player);
/*      */                   }
/*      */                 }
/*      */                 
/* 1266 */                 for (IPassiveEffect effect : message.passiveEffects) {
/* 1267 */                   if (!playerEx.currentEffects.contains(effect)) {
/* 1268 */                     effect.startEffectOn(player, false);
/*      */                   }
/*      */                 }
/*      */                 
/* 1272 */                 playerEx.currentEffects = message.passiveEffects;
/* 1273 */                 playerEx.effectCooldownManager = message.cooldownManager;
/* 1274 */                 playerEx.priestCooldownManager = message.priestCooldowns;
/* 1275 */                 if (message.book != null) {
/* 1276 */                   playerEx.bookNavigator = message.book;
/*      */                 }
/* 1278 */                 if (message.learning != null) {
/* 1279 */                   playerEx.learning = message.learning;
/*      */                 }
/* 1281 */                 message.worship.setPlayer(playerEx);
/* 1282 */                 playerEx.worshipTracker = message.worship;
/* 1283 */                 playerEx.readySpell = message.readySpell;
/* 1284 */                 playerEx.shellRegistry = message.shells;
/* 1285 */                 if (((playerEx.playerForm != null) && (playerEx.playerForm != message.form)) || ((playerEx.playerForm == null) && (message.form != Get.forms().DEFAULT))) {
/* 1286 */                   playerEx.playerForm = message.form;
/* 1287 */                   playerEx.playerForm.initializeOn(playerEx);
/*      */                 }
/*      */               }
/*      */             }
/*      */           }
/* 1292 */         });
/* 1293 */         return null; } } }
/*      */   
/*      */   public static class PacketSyncToServer implements IMessage { private SyncProp property;
/*      */     private Object value;
/*      */     public PacketSyncToServer() {}
/*      */     
/* 1299 */     public static enum SyncProp { book;
/*      */       
/*      */ 
/*      */       private SyncProp() {}
/*      */     }
/*      */     
/*      */ 
/*      */     public PacketSyncToServer(PlayerEx playerEx, SyncProp property)
/*      */     {
/* 1308 */       this.property = property;
/* 1309 */       switch (PlayerEx.3.$SwitchMap$emoniph$intangible$player$PlayerEx$PacketSyncToServer$SyncProp[property.ordinal()]) {
/*      */       case 1: 
/* 1311 */         this.value = playerEx.bookNavigator;
/*      */       }
/*      */       
/*      */     }
/*      */     
/*      */ 
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1319 */       this.property = SyncProp.values()[buf.readInt()];
/* 1320 */       switch (PlayerEx.3.$SwitchMap$emoniph$intangible$player$PlayerEx$PacketSyncToServer$SyncProp[this.property.ordinal()]) {
/*      */       case 1: 
/* 1322 */         this.value = BookNavigator.fromBytes(buf);
/*      */       }
/*      */       
/*      */     }
/*      */     
/*      */ 
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1330 */       buf.writeInt(this.property.ordinal());
/* 1331 */       switch (PlayerEx.3.$SwitchMap$emoniph$intangible$player$PlayerEx$PacketSyncToServer$SyncProp[this.property.ordinal()]) {
/*      */       case 1: 
/* 1333 */         ((BookNavigator)this.value).writeTo(buf);
/*      */       }
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketSyncToServer, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketSyncToServer message, final MessageContext ctx) {
/* 1340 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1342 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 1343 */             PlayerEx playerEx = PlayerEx.get(player);
/*      */             
/* 1345 */             switch (PlayerEx.3.$SwitchMap$emoniph$intangible$player$PlayerEx$PacketSyncToServer$SyncProp[message.property.ordinal()]) {
/*      */             case 1: 
/* 1347 */               playerEx.bookNavigator = ((BookNavigator)message.value);
/*      */             }
/*      */           }
/* 1350 */         });
/* 1351 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PacketRequestSync implements IMessage
/*      */   {
/*      */     private int entityId;
/*      */     private boolean first;
/*      */     
/*      */     public PacketRequestSync() {}
/*      */     
/*      */     public PacketRequestSync(PlayerEx playerEx, boolean first) {
/* 1364 */       this.entityId = playerEx.PLAYER.func_145782_y();
/* 1365 */       this.first = first;
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1370 */       this.entityId = buf.readInt();
/* 1371 */       this.first = buf.readBoolean();
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1376 */       buf.writeInt(this.entityId);
/* 1377 */       buf.writeBoolean(this.first);
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketRequestSync, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketRequestSync message, final MessageContext ctx) {
/* 1383 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1385 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 1386 */             World world = player.field_70170_p;
/* 1387 */             Entity entity = world.func_73045_a(message.entityId);
/* 1388 */             if ((entity instanceof EntityPlayer)) {
/* 1389 */               Get.deities().syncAllToPlayer(world, player);
/* 1390 */               Get.pipeline().sendTo(new PlayerEx.PacketSyncToClient(PlayerEx.get((EntityPlayer)entity)), player);
/*      */             }
/*      */           }
/* 1393 */         });
/* 1394 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PacketTravelDestinations implements IMessage
/*      */   {
/*      */     private List<BlockPos> destinations;
/*      */     private boolean free;
/*      */     
/*      */     public PacketTravelDestinations() {}
/*      */     
/*      */     public PacketTravelDestinations(List<BlockPos> destinations, boolean free)
/*      */     {
/* 1408 */       this.destinations = destinations;
/* 1409 */       this.free = free;
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1414 */       buf.writeInt(this.destinations == null ? 0 : this.destinations.size());
/* 1415 */       for (BlockPos pos : this.destinations) {
/* 1416 */         buf.writeLong(pos.func_177986_g());
/*      */       }
/* 1418 */       buf.writeBoolean(this.free);
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1423 */       int count = buf.readInt();
/* 1424 */       this.destinations = new java.util.ArrayList();
/* 1425 */       for (int i = 0; i < count; i++) {
/* 1426 */         this.destinations.add(BlockPos.func_177969_a(buf.readLong()));
/*      */       }
/* 1428 */       this.free = buf.readBoolean();
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketTravelDestinations, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketTravelDestinations message, final MessageContext ctx) {
/* 1434 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1436 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 1437 */             PlayerEx playerEx = PlayerEx.get(player);
/* 1438 */             playerEx.setTravelDestinations(message.destinations, message.free);
/*      */           }
/*      */           
/* 1441 */         });
/* 1442 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void setTravelDestinations(List<BlockPos> destinations, boolean free)
/*      */   {
/* 1450 */     this.travelPlanner = new TravelPlanner(this.PLAYER, new BlockPos(this.PLAYER), destinations, free);
/*      */   }
/*      */   
/*      */   public void clearTravelDestinations() {
/* 1454 */     this.travelPlanner = null;
/*      */   }
/*      */   
/*      */   public void travelToDestination(BlockPos pos) {
/* 1458 */     if (this.travelPlanner != null) {
/* 1459 */       Get.pipeline().sendToServer(new PacketPlayerTeleport(pos, this.travelPlanner.isFree()));
/* 1460 */       this.travelPlanner = null;
/*      */     }
/*      */   }
/*      */   
/*      */   public List<BlockPos> getTravelDestinations() {
/* 1465 */     return this.travelPlanner != null ? this.travelPlanner.getDestinations() : null;
/*      */   }
/*      */   
/*      */   public static class PacketPlayerTeleport implements IMessage
/*      */   {
/*      */     private BlockPos targetPos;
/*      */     private boolean free;
/*      */     
/*      */     public PacketPlayerTeleport() {}
/*      */     
/*      */     public PacketPlayerTeleport(BlockPos pos, boolean free) {
/* 1476 */       this.targetPos = pos;
/* 1477 */       this.free = free;
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1482 */       this.targetPos = BlockPos.func_177969_a(buf.readLong());
/* 1483 */       this.free = buf.readBoolean();
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1488 */       buf.writeLong(this.targetPos.func_177986_g());
/* 1489 */       buf.writeBoolean(this.free);
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketPlayerTeleport, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketPlayerTeleport message, final MessageContext ctx) {
/* 1495 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1497 */             EntityPlayerMP player = (EntityPlayerMP)Intangible.PROXY.getPlayer(ctx);
/* 1498 */             PlayerEx playerEx = PlayerEx.get(player);
/* 1499 */             World w = player.field_70170_p;
/* 1500 */             if ((message.free) || (playerEx.tryReduceWorship(w, playerEx.getWorship().getDevoutDeityId(w), 1L, false))) {
/* 1501 */               BlockPos pos = PlayerEx.PacketPlayerTeleport.Handler.getTargetLocation(w, message.targetPos);
/*      */               
/* 1503 */               double x = pos.func_177958_n() + 0.5D;
/* 1504 */               double y = pos.func_177956_o();
/* 1505 */               double z = pos.func_177952_p() + 0.5D;
/* 1506 */               Get.fx().GLOW.sendToAllNear(player, 0.5F, 30, 16776960);
/* 1507 */               Sound.MOD_RANDOM_SPELL1.playToAllNear(player, 0.5F, 1.5F);
/* 1508 */               player.field_71135_a.func_147364_a(x, y, z, player.field_70177_z, player.field_70125_A);
/* 1509 */               Get.fx().GLOW.sendToAllNear(player, 0.5F, 30, 16776960);
/* 1510 */               Sound.MOD_RANDOM_SPELL1.playToAllNear(player, 0.5F, 1.5F);
/*      */             }
/*      */             
/*      */           }
/* 1514 */         });
/* 1515 */         return null;
/*      */       }
/*      */       
/*      */       private static BlockPos getTargetLocation(World w, BlockPos targetPos) {
/* 1519 */         if (!w.func_180495_p(targetPos).func_177230_c().func_149688_o().func_76222_j()) {
/* 1520 */           for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 1521 */             if ((w.func_180495_p(targetPos.func_177972_a(facing).func_177977_b()).func_177230_c().func_149688_o().func_76222_j()) && 
/* 1522 */               (w.func_180495_p(targetPos.func_177972_a(facing).func_177977_b()).func_177230_c().func_149688_o().func_76222_j())) {
/* 1523 */               return targetPos.func_177972_a(facing).func_177977_b();
/*      */             }
/* 1525 */             if ((w.func_180495_p(targetPos.func_177972_a(facing)).func_177230_c().func_149688_o().func_76222_j()) && 
/* 1526 */               (w.func_180495_p(targetPos.func_177972_a(facing).func_177984_a()).func_177230_c().func_149688_o().func_76222_j())) {
/* 1527 */               return targetPos.func_177972_a(facing);
/*      */             }
/*      */           }
/*      */           
/* 1531 */           for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 1532 */             if ((w.func_180495_p(targetPos.func_177967_a(facing, 2).func_177977_b()).func_177230_c().func_149688_o().func_76222_j()) && 
/* 1533 */               (w.func_180495_p(targetPos.func_177967_a(facing, 2).func_177977_b()).func_177230_c().func_149688_o().func_76222_j())) {
/* 1534 */               return targetPos.func_177967_a(facing, 2).func_177977_b();
/*      */             }
/* 1536 */             if ((w.func_180495_p(targetPos.func_177967_a(facing, 2)).func_177230_c().func_149688_o().func_76222_j()) && 
/* 1537 */               (w.func_180495_p(targetPos.func_177967_a(facing, 2).func_177984_a()).func_177230_c().func_149688_o().func_76222_j())) {
/* 1538 */               return targetPos.func_177967_a(facing, 2);
/*      */             }
/*      */           }
/*      */         }
/* 1542 */         return targetPos; } } }
/*      */   
/*      */   public static class PacketTryPossess implements IMessage { private int entityId;
/*      */     private Command command;
/*      */     private BlockPos targetPos;
/*      */     public PacketTryPossess() {}
/*      */     
/* 1549 */     public static enum Command { POSSESS(0),  SET_TARGET(1),  ATTACK(2),  USE(3);
/*      */       
/*      */       private final int meta;
/*      */       
/* 1553 */       private Command(int meta) { this.meta = meta; }
/*      */       
/*      */       public static Command fromMeta(int meta)
/*      */       {
/* 1557 */         return values()[meta];
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     public PacketTryPossess(EntityLivingBase targetEntity, Command command, BlockPos pos)
/*      */     {
/* 1569 */       this.entityId = targetEntity.func_145782_y();
/* 1570 */       this.command = command;
/* 1571 */       this.targetPos = pos;
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1576 */       this.entityId = buf.readInt();
/* 1577 */       this.command = Command.fromMeta(buf.readInt());
/* 1578 */       if (buf.readBoolean()) {
/* 1579 */         this.targetPos = BlockPos.func_177969_a(buf.readLong());
/*      */       } else {
/* 1581 */         this.targetPos = null;
/*      */       }
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1587 */       buf.writeInt(this.entityId);
/* 1588 */       buf.writeInt(this.command.meta);
/* 1589 */       if (this.targetPos == null) {
/* 1590 */         buf.writeBoolean(false);
/*      */       } else {
/* 1592 */         buf.writeBoolean(true);
/* 1593 */         buf.writeLong(this.targetPos.func_177986_g());
/*      */       }
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketTryPossess, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketTryPossess message, final MessageContext ctx)
/*      */       {
/* 1601 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1603 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 1604 */             World world = player.field_70170_p;
/* 1605 */             Entity entity = world.func_73045_a(message.entityId);
/*      */             
/* 1607 */             switch (PlayerEx.3.$SwitchMap$emoniph$intangible$player$PlayerEx$PacketTryPossess$Command[message.command.ordinal()]) {
/*      */             case 1: 
/* 1609 */               if ((entity instanceof EntityPlayer)) {
/* 1610 */                 EntityPlayer targetEntity = (EntityPlayer)entity;
/* 1611 */                 PlayerEx targetPlayerEx = PlayerEx.get(targetEntity);
/*      */                 
/* 1613 */                 boolean allowPlayerPossession = true;
/*      */                 
/*      */ 
/* 1616 */                 if (((!(world instanceof net.minecraft.world.WorldServer)) || (net.minecraft.server.MinecraftServer.func_71276_C().func_71219_W()) || (!Get.config().ALLOW_PLAYER_POSSESSION_ON_PVE_SERVERS)) || 
/*      */                 
/*      */ 
/*      */ 
/* 1620 */                   (!Get.items().YELLOW_CRYSTAL_HELMET.isEquipped(targetEntity))) {
/* 1621 */                   if ((!targetPlayerEx.isKnowledgeLearnt(new IKnol[] {Get.knowledge().SKILL_SOUL_TRANSFUSION })) || 
/* 1622 */                     (targetPlayerEx.getAllSouls().isEmpty())) {}
/* 1623 */                 } else { allowPlayerPossession = false;
/*      */                 }
/*      */                 
/* 1626 */                 if (allowPlayerPossession) {
/* 1627 */                   player.func_70078_a(entity);
/*      */                 }
/* 1629 */               } else if (((entity instanceof EntityLiving)) && 
/* 1630 */                 (Get.souls().isSoulPresent((EntityLiving)entity, false)) && ((!(entity instanceof emoniph.intangible.souls.ISoulHost)) || (((entity instanceof IPossessable)) && 
/*      */                 
/* 1632 */                 (((IPossessable)entity).canBePossessedBy(player))) || 
/* 1633 */                 (((emoniph.intangible.souls.ISoulHost)entity).getSoulType() != null)))
/*      */               {
/* 1635 */                 EntityLiving targetEntity = (EntityLiving)entity;
/* 1636 */                 if ((!Get.items().YELLOW_CRYSTAL_HELMET.isEquipped(targetEntity)) && 
/* 1637 */                   (!Get.effects().isActiveFor(Get.effects().ARMOR, targetEntity)))
/* 1638 */                   if ((entity instanceof IPossessable)) {
/* 1639 */                     IPossessable possessable = (IPossessable)entity;
/* 1640 */                     if (possessable.canBePossessedBy(player)) {
/* 1641 */                       possessable.possessBy(player);
/* 1642 */                       player.func_70078_a(entity);
/*      */                     }
/* 1644 */                   } else if ((entity instanceof EntityHorse)) {
/* 1645 */                     EntityHorse horse = (EntityHorse)entity;
/* 1646 */                     net.minecraft.entity.ai.EntityAIBase task = null;
/* 1647 */                     for (net.minecraft.entity.ai.EntityAITasks.EntityAITaskEntry taskEntity : horse.field_70714_bg.field_75782_a) {
/* 1648 */                       if ((taskEntity.field_75733_a instanceof net.minecraft.entity.ai.EntityAIRunAroundLikeCrazy)) {
/* 1649 */                         task = taskEntity.field_75733_a;
/* 1650 */                         break;
/*      */                       }
/*      */                     }
/* 1653 */                     if (task != null) {
/* 1654 */                       horse.field_70714_bg.func_85156_a(task);
/*      */                     }
/*      */                     
/* 1657 */                     player.func_70078_a(horse);
/* 1658 */                   } else if (!(entity instanceof net.minecraft.entity.boss.IBossDisplayData)) {
/* 1659 */                     player.func_70078_a(entity);
/*      */                   }
/*      */               }
/* 1662 */               break;
/*      */             
/*      */             case 2: 
/* 1665 */               if ((player.field_70154_o != null) && ((player.field_70154_o instanceof EntityLiving)) && ((entity instanceof EntityLivingBase))) {
/* 1666 */                 EntityLiving possessed = (EntityLiving)player.field_70154_o;
/* 1667 */                 EntityLivingBase target = (EntityLivingBase)entity;
/* 1668 */                 possessed.func_70624_b(target);
/* 1669 */                 possessed.func_70604_c(target); }
/* 1670 */               break;
/*      */             
/*      */             case 3: 
/* 1673 */               if ((player.field_70154_o != null) && ((player.field_70154_o instanceof EntityLiving))) {
/* 1674 */                 EntityLivingBase possessed = (EntityLivingBase)player.field_70154_o;
/* 1675 */                 if ((possessed != null) && ((possessed instanceof IPossessable))) {
/* 1676 */                   IPossessable possessable = (IPossessable)possessed;
/* 1677 */                   if (!possessable.onAttackAction(player, message.targetPos)) {}
/*      */                 }
/*      */               }
/*      */               
/* 1681 */               break;
/*      */             
/*      */ 
/*      */             case 4: 
/* 1685 */               if ((player.field_70154_o != null) && ((player.field_70154_o instanceof EntityLiving))) {
/* 1686 */                 EntityLivingBase possessed = (EntityLivingBase)player.field_70154_o;
/* 1687 */                 if ((possessed != null) && ((possessed instanceof IPossessable))) {
/* 1688 */                   IPossessable possessable = (IPossessable)possessed;
/* 1689 */                   if (!possessable.onUseAction(player, message.targetPos)) {
/*      */                     break;
/*      */                   }
/*      */                 }
/*      */               }
/*      */               
/*      */ 
/*      */               break;
/*      */             }
/*      */             
/*      */           }
/* 1700 */         });
/* 1701 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PacketMotion implements IMessage
/*      */   {
/*      */     float rotationPitch;
/*      */     float rotationYaw;
/*      */     float rotationYawHead;
/*      */     double motionX;
/*      */     double motionY;
/*      */     double motionZ;
/*      */     boolean syncFacing;
/*      */     boolean replace;
/*      */     
/*      */     public PacketMotion() {}
/*      */     
/*      */     public PacketMotion(EntityPlayer player) {
/* 1720 */       this.rotationPitch = player.field_70125_A;
/* 1721 */       this.rotationYaw = player.field_70177_z;
/* 1722 */       this.rotationYawHead = player.field_70759_as;
/* 1723 */       this.motionX = player.field_70159_w;
/* 1724 */       this.motionY = player.field_70181_x;
/* 1725 */       this.motionZ = player.field_70179_y;
/* 1726 */       this.syncFacing = true;
/* 1727 */       this.replace = true;
/*      */     }
/*      */     
/*      */     public PacketMotion(EntityPlayer player, double x, double y, double z) {
/* 1731 */       this(player, x, y, z, true);
/*      */     }
/*      */     
/*      */     public PacketMotion(EntityPlayer player, double x, double y, double z, boolean replace) {
/* 1735 */       this.rotationPitch = player.field_70125_A;
/* 1736 */       this.rotationYaw = player.field_70177_z;
/* 1737 */       this.rotationYawHead = player.field_70759_as;
/* 1738 */       this.motionX = x;
/* 1739 */       this.motionY = y;
/* 1740 */       this.motionZ = z;
/* 1741 */       this.syncFacing = false;
/* 1742 */       this.replace = replace;
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1747 */       this.rotationPitch = buf.readFloat();
/* 1748 */       this.rotationYaw = buf.readFloat();
/* 1749 */       this.rotationYawHead = buf.readFloat();
/* 1750 */       this.motionX = buf.readDouble();
/* 1751 */       this.motionY = buf.readDouble();
/* 1752 */       this.motionZ = buf.readDouble();
/* 1753 */       this.syncFacing = buf.readBoolean();
/* 1754 */       this.replace = buf.readBoolean();
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1759 */       buf.writeFloat(this.rotationPitch);
/* 1760 */       buf.writeFloat(this.rotationYaw);
/* 1761 */       buf.writeFloat(this.rotationYawHead);
/* 1762 */       buf.writeDouble(this.motionX);
/* 1763 */       buf.writeDouble(this.motionY);
/* 1764 */       buf.writeDouble(this.motionZ);
/* 1765 */       buf.writeBoolean(this.syncFacing);
/* 1766 */       buf.writeBoolean(this.replace);
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketMotion, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketMotion message, final MessageContext ctx) {
/* 1772 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1774 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/*      */             
/* 1776 */             if (message.syncFacing) {
/* 1777 */               player.field_70177_z = (message.rotationYaw % 360.0F);
/* 1778 */               player.field_70759_as = (message.rotationYawHead % 360.0F);
/* 1779 */               player.field_70125_A = (message.rotationPitch % 360.0F);
/*      */             }
/* 1781 */             if (message.replace) {
/* 1782 */               player.field_70159_w = message.motionX;
/* 1783 */               player.field_70181_x = message.motionY;
/* 1784 */               player.field_70179_y = message.motionZ;
/*      */             } else {
/* 1786 */               player.field_70159_w += message.motionX;
/* 1787 */               player.field_70181_x += message.motionY;
/* 1788 */               player.field_70179_y += message.motionZ;
/*      */             }
/*      */             
/*      */           }
/* 1792 */         });
/* 1793 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PacketDiscovery implements IMessage
/*      */   {
/*      */     private Vec3 posSource;
/*      */     private IKnol[] knols;
/*      */     
/*      */     public PacketDiscovery() {}
/*      */     
/*      */     public PacketDiscovery(Vec3 posSource, IKnol[] knols)
/*      */     {
/* 1807 */       this.posSource = posSource;
/* 1808 */       this.knols = knols;
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1813 */       double x = buf.readDouble();
/* 1814 */       double y = buf.readDouble();
/* 1815 */       double z = buf.readDouble();
/* 1816 */       this.posSource = new Vec3(x, y, z);
/* 1817 */       int knolCount = buf.readInt();
/* 1818 */       this.knols = new IKnol[knolCount];
/* 1819 */       for (int i = 0; i < knolCount; i++) {
/* 1820 */         int index = buf.readInt();
/* 1821 */         this.knols[i] = Get.knowledge().getKnolFromIndex(index);
/*      */       }
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1827 */       buf.writeDouble(this.posSource.field_72450_a);
/* 1828 */       buf.writeDouble(this.posSource.field_72448_b);
/* 1829 */       buf.writeDouble(this.posSource.field_72449_c);
/* 1830 */       buf.writeInt(this.knols.length);
/* 1831 */       for (IKnol knol : this.knols) {
/* 1832 */         int index = Get.knowledge().getIndexFromKnol(knol);
/* 1833 */         buf.writeInt(index);
/*      */       }
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketDiscovery, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketDiscovery message, final MessageContext ctx) {
/* 1840 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1842 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 1843 */             PlayerEx playerEx = PlayerEx.get(player);
/*      */             
/* 1845 */             if ((message.posSource != null) && (message.knols != null)) {
/* 1846 */               Sound.MOD_RANDOM_DISCOVERY.playOnlyTo(player, 1.0F, 1.0F);
/* 1847 */               for (IKnol knol : message.knols) {
/* 1848 */                 String s = String.format(emoniph.intangible.util.TextUtil.parse(net.minecraft.util.StatCollector.func_74838_a("knol.intangible:learned")), new Object[] {
/* 1849 */                   emoniph.intangible.util.TextUtil.parse(net.minecraft.util.StatCollector.func_74838_a("knol." + knol.getId())) });
/* 1850 */                 playerEx.enqueueHudMessage(new PlayerEx.HudMessage(s, 40, 100));
/*      */               }
/* 1852 */               World w = player.field_70170_p;
/*      */               
/*      */ 
/* 1855 */               double r = 0.4D;
/* 1856 */               for (int i = 0; i < 20; i++) {
/* 1857 */                 Vec3 start = message.posSource.func_72441_c(w.field_73012_v.nextDouble() * 2.0D * r - r, w.field_73012_v.nextDouble() * 2.0D * r - r, w.field_73012_v.nextDouble() * 2.0D * r - r);
/* 1858 */                 Intangible.PROXY.knolFX(player.field_70170_p, start, player);
/*      */               }
/*      */               
/*      */             }
/*      */           }
/* 1863 */         });
/* 1864 */         return null;
/*      */       } } }
/*      */   
/*      */   public static class HudMessage { private int delay;
/*      */     private int duration;
/*      */     
/* 1870 */     public static enum DisplayAction { WAIT,  SHOW,  REMOVE;
/*      */       
/*      */       private DisplayAction() {}
/*      */     }
/*      */     
/*      */     private final int maxDuration;
/*      */     private final String text;
/*      */     public HudMessage(String text, int delay, int duration) {
/* 1878 */       this.delay = delay;
/* 1879 */       this.duration = duration;
/* 1880 */       this.text = text;
/* 1881 */       this.maxDuration = duration;
/*      */     }
/*      */     
/*      */     public DisplayAction tick() {
/* 1885 */       if (this.delay > 0) {
/* 1886 */         this.delay -= 1;
/* 1887 */         return DisplayAction.WAIT; }
/* 1888 */       if (this.duration > 0) {
/* 1889 */         this.duration -= 1;
/* 1890 */         return DisplayAction.SHOW;
/*      */       }
/* 1892 */       return DisplayAction.REMOVE;
/*      */     }
/*      */     
/*      */     public int getDuration()
/*      */     {
/* 1897 */       return this.duration;
/*      */     }
/*      */     
/*      */     public int getMaxDuration() {
/* 1901 */       return this.maxDuration;
/*      */     }
/*      */     
/*      */     public String toString()
/*      */     {
/* 1906 */       return this.text;
/*      */     }
/*      */   }
/*      */   
/* 1910 */   private Queue<HudMessage> hudMessages = new java.util.ArrayDeque();
/*      */   
/*      */   private void enqueueHudMessage(HudMessage message) {
/* 1913 */     this.hudMessages.offer(message);
/*      */   }
/*      */   
/*      */   public HudMessage peekMessage() {
/* 1917 */     return (HudMessage)this.hudMessages.peek();
/*      */   }
/*      */   
/*      */ 
/* 1921 */   public HudMessage pollMessage() { return (HudMessage)this.hudMessages.poll(); }
/*      */   
/*      */   public static class PacketEntityLivingAction implements IMessage { private int entityId;
/*      */     
/* 1925 */     public static enum Action { JUMP,  RIGHT_CLICK_AIR,  LEFT_CLICK,  DISSOLVE,  RIGHT_CLICK_BLOCK;
/*      */       
/*      */       private Action() {}
/*      */     }
/*      */     
/*      */     private Action action;
/*      */     public PacketEntityLivingAction() {}
/*      */     
/*      */     public PacketEntityLivingAction(EntityLivingBase entity, Action action) {
/* 1934 */       this.entityId = entity.func_145782_y();
/* 1935 */       this.action = action;
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 1940 */       this.entityId = buf.readInt();
/* 1941 */       this.action = Action.values()[buf.readInt()];
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 1946 */       buf.writeInt(this.entityId);
/* 1947 */       buf.writeInt(this.action.ordinal());
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketEntityLivingAction, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketEntityLivingAction message, final MessageContext ctx) {
/* 1953 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 1955 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 1956 */             if (player != null) {
/* 1957 */               Entity entity = player.field_70170_p.func_73045_a(message.entityId);
/* 1958 */               if ((entity != null) && ((entity instanceof EntityLivingBase))) {
/* 1959 */                 EntityLivingBase entityLiving = (EntityLivingBase)entity;
/* 1960 */                 switch (PlayerEx.3.$SwitchMap$emoniph$intangible$player$PlayerEx$PacketEntityLivingAction$Action[message.action.ordinal()]) {
/*      */                 case 1: 
/* 1962 */                   entityLiving.func_70664_aZ();
/* 1963 */                   break;
/*      */                 case 2: 
/*      */                 case 3: 
/*      */                 case 4: 
/* 1967 */                   PlayerEx playerEx = PlayerEx.get(player);
/* 1968 */                   playerEx.getPlayerForm().onClientAction(playerEx, message.action);
/* 1969 */                   break;
/*      */                 case 5: 
/* 1971 */                   if ((entity instanceof emoniph.intangible.entity.IDissolve)) {
/* 1972 */                     ((emoniph.intangible.entity.IDissolve)entity).dissolve();
/*      */                   }
/*      */                   break;
/*      */                 }
/*      */                 
/*      */               }
/*      */             }
/*      */           }
/* 1980 */         });
/* 1981 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PacketAttach implements IMessage
/*      */   {
/*      */     private int field_149408_a;
/*      */     private int field_149406_b;
/*      */     private int field_149407_c;
/*      */     
/*      */     public PacketAttach() {}
/*      */     
/*      */     public PacketAttach(int p_i45218_1_, Entity p_i45218_2_, Entity p_i45218_3_) {
/* 1995 */       this.field_149408_a = p_i45218_1_;
/* 1996 */       this.field_149406_b = p_i45218_2_.func_145782_y();
/* 1997 */       this.field_149407_c = (p_i45218_3_ != null ? p_i45218_3_.func_145782_y() : -1);
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 2002 */       this.field_149406_b = buf.readInt();
/* 2003 */       this.field_149407_c = buf.readInt();
/* 2004 */       this.field_149408_a = buf.readUnsignedByte();
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 2009 */       buf.writeInt(this.field_149406_b);
/* 2010 */       buf.writeInt(this.field_149407_c);
/* 2011 */       buf.writeByte(this.field_149408_a);
/*      */     }
/*      */     
/*      */     public int func_149403_d()
/*      */     {
/* 2016 */       return this.field_149406_b;
/*      */     }
/*      */     
/*      */     public int func_149402_e()
/*      */     {
/* 2021 */       return this.field_149407_c;
/*      */     }
/*      */     
/*      */     public int func_149404_c() {
/* 2025 */       return this.field_149408_a;
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketAttach, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketAttach message, final MessageContext ctx) {
/* 2031 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 2033 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 2034 */             if (player != null) {
/* 2035 */               Object object = player.field_70170_p.func_73045_a(message.func_149403_d());
/* 2036 */               Entity entity = player.field_70170_p.func_73045_a(message.func_149402_e());
/*      */               
/* 2038 */               if ((message.func_149404_c() == 1) && ((object instanceof EntitySoul))) {
/* 2039 */                 if (entity != null) {
/* 2040 */                   ((EntitySoul)object).setSoulLeashedToEntity(entity, false);
/*      */                 } else {
/* 2042 */                   ((EntitySoul)object).clearSoulLeashed(false, false);
/*      */                 }
/*      */                 
/*      */               }
/*      */             }
/*      */           }
/* 2048 */         });
/* 2049 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public static class PacketSelectShell implements IMessage
/*      */   {
/*      */     private int pos;
/*      */     
/*      */     public PacketSelectShell() {}
/*      */     
/*      */     public PacketSelectShell(int shell) {
/* 2061 */       this.pos = shell;
/*      */     }
/*      */     
/*      */     public void fromBytes(ByteBuf buf)
/*      */     {
/* 2066 */       this.pos = buf.readInt();
/*      */     }
/*      */     
/*      */     public void toBytes(ByteBuf buf)
/*      */     {
/* 2071 */       buf.writeInt(this.pos);
/*      */     }
/*      */     
/*      */     public static class Handler implements IMessageHandler<PlayerEx.PacketSelectShell, IMessage>
/*      */     {
/*      */       public IMessage onMessage(final PlayerEx.PacketSelectShell message, final MessageContext ctx)
/*      */       {
/* 2078 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*      */           public void run() {
/* 2080 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 2081 */             if (player != null) {
/* 2082 */               PlayerEx.get(player).getShells().setSelectedShell(message.pos);
/*      */             }
/*      */             
/*      */           }
/* 2086 */         });
/* 2087 */         return null;
/*      */       }
/*      */     }
/*      */   }
/*      */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/PlayerEx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */