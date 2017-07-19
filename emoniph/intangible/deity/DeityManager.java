/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.api.deity.IDeityMajorWorldEffect;
/*     */ import emoniph.intangible.network.IPacketRegister;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.storage.MapStorage;
/*     */ import net.minecraftforge.event.entity.player.PlayerUseItemEvent.Finish;
/*     */ import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class DeityManager implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModPreInit, emoniph.intangible.init.IModInit, emoniph.intangible.network.IRegisterPackets
/*     */ {
/*  31 */   private Map<Integer, DeityList> deitiesByWorld = new HashMap();
/*     */   private IDeityMajorWorldEffect clientEffect;
/*     */   private UUID clientDeity;
/*     */   
/*  35 */   public void registerPackets(IPacketRegister packetRegister) { packetRegister.registerPacket(DeityManager.PacketSyncHeadToClient.Handler.class, PacketSyncHeadToClient.class, Side.CLIENT);
/*  36 */     packetRegister.registerPacket(DeityManager.PacketEffectsToClient.Handler.class, PacketEffectsToClient.class, Side.CLIENT);
/*     */   }
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  41 */     Get.pipeline().registerPacketProvider(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public void init(FMLInitializationEvent event) {}
/*     */   
/*     */ 
/*     */   public void initWorld(World world)
/*     */   {
/*  50 */     if (!world.field_72995_K) {
/*  51 */       String key = DeityList.fileNameForProvider(world.field_73011_w);
/*  52 */       net.minecraft.world.WorldSavedData data = world.getPerWorldStorage().func_75742_a(DeityList.class, key);
/*  53 */       if (data == null) {
/*  54 */         data = new DeityList(world);
/*  55 */         world.getPerWorldStorage().func_75745_a(key, data);
/*     */       }
/*     */       
/*  58 */       this.deitiesByWorld.put(Integer.valueOf(world.field_73011_w.func_177502_q()), (DeityList)data);
/*     */     } else {
/*  60 */       this.clientHeads.remove(Integer.valueOf(world.field_73011_w.func_177502_q()));
/*     */     }
/*     */   }
/*     */   
/*     */   public void tick(World world) {
/*  65 */     forWorld(world).tick(world);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void clientTick(World world)
/*     */   {
/*  72 */     if ((this.clientEffect != null) && (world != null) && (this.clientDeity != null)) {
/*  73 */       DeityList deities = Get.deities().forWorld(world);
/*  74 */       if (deities != null) {
/*  75 */         this.clientEffect.onWorldTick(world, deities.getDeityById(this.clientDeity));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public DeityList forWorld(World world) {
/*  81 */     DeityList list = (DeityList)this.deitiesByWorld.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/*  82 */     if (list == null) {
/*  83 */       list = new DeityList(world);
/*  84 */       this.deitiesByWorld.put(Integer.valueOf(world.field_73011_w.func_177502_q()), list);
/*     */     }
/*  86 */     return list;
/*     */   }
/*     */   
/*     */   public void onHarvest(BlockEvent.HarvestDropsEvent event) {
/*  90 */     forWorld(event.world).onHarvest(event);
/*     */   }
/*     */   
/*     */   public void onPlayerUseItemFinish(PlayerUseItemEvent.Finish event) {
/*  94 */     forWorld(event.entity.field_70170_p).onPlayerUseItemFinish(event);
/*     */   }
/*     */   
/*     */   public Deity createDeity(World world, Deity deity)
/*     */   {
/*  99 */     if (!world.field_72995_K) {
/* 100 */       forWorld(world).createNewDeity(deity);
/* 101 */       deity.syncHeadTo(world);
/*     */     }
/* 103 */     return deity;
/*     */   }
/*     */   
/* 106 */   private Map<Integer, WorldHeads> clientHeads = new HashMap();
/*     */   
/*     */   public void killDeity(World world, Deity deity) {
/* 109 */     forWorld(world).killDeity(deity);
/*     */   }
/*     */   
/*     */   public UUID createUniqueId(World world) {
/* 113 */     DeityList deities = forWorld(world);
/* 114 */     return deities.createUniqueId(world);
/*     */   }
/*     */   
/*     */   public void rename(World world, UUID deityId) {
/* 118 */     rename(world, deityId, Deity.generateRandomDeityName(world.field_73012_v));
/*     */   }
/*     */   
/*     */   public void rename(World world, UUID deityId, String name) {
/* 122 */     if (!world.field_72995_K) {
/* 123 */       DeityList deities = forWorld(world);
/* 124 */       Deity deity = deities.getDeityById(deityId);
/* 125 */       if (deity != null) {
/* 126 */         deity.rename(world, name);
/* 127 */         deities.func_76185_a();
/* 128 */         deity.syncHeadTo(world);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class WorldHeads
/*     */   {
/* 136 */     private Map<UUID, HeadSpec> idToHead = new HashMap();
/* 137 */     private List<HeadSpec> heads = new java.util.ArrayList();
/* 138 */     private Map<HeadSpec, UUID> headToId = new HashMap();
/*     */     
/*     */     HeadSpec get(UUID deityId) {
/* 141 */       return (HeadSpec)this.idToHead.get(deityId);
/*     */     }
/*     */     
/*     */     List<HeadSpec> getAllHeads() {
/* 145 */       return this.heads;
/*     */     }
/*     */     
/*     */     void add(UUID deityId, HeadSpec head) {
/* 149 */       if (!this.idToHead.containsKey(deityId)) {
/* 150 */         this.idToHead.put(deityId, head);
/* 151 */         this.heads.add(head);
/* 152 */         this.headToId.put(head, deityId);
/*     */       }
/*     */     }
/*     */     
/*     */     public UUID get(HeadSpec head) {
/* 157 */       return (UUID)this.headToId.get(head);
/*     */     }
/*     */     
/*     */     public void remove(UUID deityId) {
/* 161 */       if (this.idToHead.containsKey(deityId)) {
/* 162 */         HeadSpec spec = (HeadSpec)this.idToHead.get(deityId);
/* 163 */         this.idToHead.remove(deityId);
/* 164 */         this.heads.remove(spec);
/* 165 */         this.headToId.remove(spec);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public emoniph.intangible.client.models.ModelDeityHead getHeadFor(World world, UUID deityId)
/*     */   {
/* 173 */     WorldHeads registry = (WorldHeads)this.clientHeads.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/* 174 */     if (registry != null) {
/* 175 */       HeadSpec head = registry.get(deityId);
/* 176 */       if (head != null) {
/* 177 */         return head.createModel();
/*     */       }
/*     */     }
/*     */     
/* 181 */     return null;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public UUID getIdForHead(World world, HeadSpec head) {
/* 186 */     WorldHeads registry = (WorldHeads)this.clientHeads.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/* 187 */     if (registry != null) {
/* 188 */       UUID deityId = registry.get(head);
/* 189 */       if (deityId != null) {
/* 190 */         return deityId;
/*     */       }
/*     */     }
/* 193 */     return null;
/*     */   }
/*     */   
/*     */   public void syncAllToPlayer(World world, EntityPlayer player) {
/* 197 */     DeityList list = forWorld(world);
/* 198 */     list.syncHeadsTo(world, player);
/* 199 */     list.syncEffectsTo(world, player);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List<HeadSpec> getAllHeadsFor(World world) {
/* 204 */     WorldHeads registry = (WorldHeads)this.clientHeads.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/* 205 */     if (registry != null) {
/* 206 */       return registry.getAllHeads();
/*     */     }
/* 208 */     return null;
/*     */   }
/*     */   
/*     */   public HeadSpec getClientDeityFor(World world, UUID deityId)
/*     */   {
/* 213 */     WorldHeads registry = (WorldHeads)this.clientHeads.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/* 214 */     if (registry != null) {
/* 215 */       return registry.get(deityId);
/*     */     }
/* 217 */     return null;
/*     */   }
/*     */   
/*     */   public static class PacketSyncHeadToClient implements IMessage
/*     */   {
/*     */     int dimension;
/*     */     ItemStack itemA;
/*     */     ItemStack itemB;
/*     */     ItemStack itemC;
/*     */     String name;
/*     */     HeadSpec head;
/*     */     UUID deityId;
/*     */     
/*     */     public PacketSyncHeadToClient() {}
/*     */     
/*     */     public PacketSyncHeadToClient(World world, Deity deity, HeadSpec head)
/*     */     {
/* 234 */       this.dimension = world.field_73011_w.func_177502_q();
/* 235 */       this.head = head;
/* 236 */       this.deityId = deity.getId();
/* 237 */       this.itemA = deity.getSacredItemA();
/* 238 */       this.itemB = deity.getSacredItemB();
/* 239 */       this.itemC = deity.getSacredItemC();
/* 240 */       this.name = deity.getName();
/*     */     }
/*     */     
/*     */     public void fromBytes(ByteBuf buf)
/*     */     {
/* 245 */       this.dimension = buf.readInt();
/*     */       
/* 247 */       long most = buf.readLong();
/* 248 */       long least = buf.readLong();
/*     */       
/* 250 */       this.deityId = new UUID(most, least);
/* 251 */       this.itemA = ByteBufUtils.readItemStack(buf);
/* 252 */       this.itemB = ByteBufUtils.readItemStack(buf);
/* 253 */       this.itemC = ByteBufUtils.readItemStack(buf);
/* 254 */       this.name = ByteBufUtils.readUTF8String(buf);
/* 255 */       boolean headPresent = buf.readBoolean();
/* 256 */       this.head = (headPresent ? HeadSpec.readFrom(buf) : null);
/*     */     }
/*     */     
/*     */     public void toBytes(ByteBuf buf)
/*     */     {
/* 261 */       buf.writeInt(this.dimension);
/* 262 */       buf.writeLong(this.deityId.getMostSignificantBits());
/* 263 */       buf.writeLong(this.deityId.getLeastSignificantBits());
/* 264 */       ByteBufUtils.writeItemStack(buf, this.itemA);
/* 265 */       ByteBufUtils.writeItemStack(buf, this.itemB);
/* 266 */       ByteBufUtils.writeItemStack(buf, this.itemC);
/* 267 */       ByteBufUtils.writeUTF8String(buf, this.name);
/* 268 */       buf.writeBoolean(this.head != null);
/* 269 */       if (this.head != null) {
/* 270 */         this.head.writeTo(buf);
/*     */       }
/*     */     }
/*     */     
/*     */     public static class Handler implements IMessageHandler<DeityManager.PacketSyncHeadToClient, IMessage>
/*     */     {
/*     */       public IMessage onMessage(final DeityManager.PacketSyncHeadToClient message, final MessageContext ctx) {
/* 277 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*     */           public void run() {
/* 279 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/*     */             
/* 281 */             DeityManager.WorldHeads registry = (DeityManager.WorldHeads)Get.deities().clientHeads.get(Integer.valueOf(message.dimension));
/* 282 */             if (registry == null) {
/* 283 */               registry = new DeityManager.WorldHeads(null);
/* 284 */               Get.deities().clientHeads.put(Integer.valueOf(message.dimension), registry);
/*     */             }
/*     */             
/* 287 */             if (message.head != null) {
/* 288 */               message.head.setClientInfo(message.itemA, message.itemB, message.itemC, message.name);
/* 289 */               registry.add(message.deityId, message.head);
/*     */             } else {
/* 291 */               registry.remove(message.deityId);
/*     */             }
/*     */             
/*     */           }
/* 295 */         });
/* 296 */         return null;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PacketEffectsToClient implements IMessage
/*     */   {
/*     */     private int effectIndex;
/*     */     private UUID deityId;
/*     */     
/*     */     public PacketEffectsToClient() {}
/*     */     
/*     */     public PacketEffectsToClient(World world) {
/* 309 */       this.effectIndex = -1;
/* 310 */       this.deityId = null;
/*     */     }
/*     */     
/*     */     public PacketEffectsToClient(World world, UUID deityId, IDeityMajorWorldEffect majorEffect) {
/* 314 */       this.effectIndex = Get.deityEffects().worldMajorEffectRegistry.getIndexFromEffect(majorEffect);
/* 315 */       this.deityId = deityId;
/*     */     }
/*     */     
/*     */     public void fromBytes(ByteBuf buf)
/*     */     {
/* 320 */       this.effectIndex = buf.readInt();
/* 321 */       if (this.effectIndex == -1) {
/* 322 */         this.deityId = null;
/*     */       } else {
/* 324 */         this.deityId = new UUID(buf.readLong(), buf.readLong());
/*     */       }
/*     */     }
/*     */     
/*     */     public void toBytes(ByteBuf buf)
/*     */     {
/* 330 */       buf.writeInt(this.effectIndex);
/* 331 */       if (this.effectIndex != -1) {
/* 332 */         buf.writeLong(this.deityId.getMostSignificantBits());
/* 333 */         buf.writeLong(this.deityId.getLeastSignificantBits());
/*     */       }
/*     */     }
/*     */     
/*     */     public static class Handler implements IMessageHandler<DeityManager.PacketEffectsToClient, IMessage>
/*     */     {
/*     */       public IMessage onMessage(final DeityManager.PacketEffectsToClient message, final MessageContext ctx) {
/* 340 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*     */           public void run() {
/* 342 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/*     */             
/* 344 */             Get.deities().clientEffect = ((IDeityMajorWorldEffect)Get.deityEffects().worldMajorEffectRegistry.getEffectFromIndex(message.effectIndex));
/* 345 */             Get.deities().clientDeity = message.deityId;
/*     */           }
/*     */           
/*     */ 
/* 349 */         });
/* 350 */         return null;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/DeityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */