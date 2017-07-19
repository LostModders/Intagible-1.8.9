/*     */ package emoniph.intangible.network;
/*     */ 
/*     */ import emoniph.intangible.init.IModInit;
/*     */ import emoniph.intangible.init.IModPreInit;
/*     */ import emoniph.intangible.init.IModService;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*     */ import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ 
/*     */ public class PacketPipeline implements IModService, IModPreInit, IModInit
/*     */ {
/*     */   private SimpleNetworkWrapper channel;
/*  27 */   private final List<IRegisterPackets> registeredPacketProviders = new ArrayList();
/*     */   
/*     */   public void registerPacketProvider(IRegisterPackets packetProvider) {
/*  30 */     this.registeredPacketProviders.add(packetProvider);
/*     */   }
/*     */   
/*     */   private static class PacketRegister implements IPacketRegister {
/*     */     private final PacketPipeline pipeline;
/*  35 */     private int nextDiscriminator = 0;
/*     */     
/*     */     private int getNextDiscriminator() {
/*  38 */       return this.nextDiscriminator++;
/*     */     }
/*     */     
/*     */     private PacketRegister(PacketPipeline pipeline) {
/*  42 */       this.pipeline = pipeline;
/*     */     }
/*     */     
/*     */     public <REQ extends IMessage, REPLY extends IMessage> void registerPacket(Class<? extends IMessageHandler<REQ, REPLY>> handler, Class<REQ> message, Side side)
/*     */     {
/*  47 */       this.pipeline.channel.registerMessage(handler, message, getNextDiscriminator(), side);
/*     */     }
/*     */   }
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  53 */     this.channel = NetworkRegistry.INSTANCE.newSimpleChannel("intangible".toLowerCase());
/*     */   }
/*     */   
/*     */   public void init(FMLInitializationEvent event)
/*     */   {
/*  58 */     PacketRegister register = new PacketRegister(this, null);
/*  59 */     for (IRegisterPackets messageProvider : this.registeredPacketProviders) {
/*  60 */       messageProvider.registerPackets(register);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendTo(IMessage message, EntityPlayer player) {
/*  65 */     if ((player instanceof EntityPlayerMP)) {
/*  66 */       this.channel.sendTo(message, (EntityPlayerMP)player);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendTo(IMessage message, EntityPlayerMP player) {
/*  71 */     this.channel.sendTo(message, player);
/*     */   }
/*     */   
/*     */   public void sendToServer(IMessage message) {
/*  75 */     this.channel.sendToServer(message);
/*     */   }
/*     */   
/*     */   public void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint targetPoint) {
/*  79 */     this.channel.sendToAllAround(message, targetPoint);
/*     */   }
/*     */   
/*     */   public void sendToAll(IMessage message) {
/*  83 */     this.channel.sendToAll(message);
/*     */   }
/*     */   
/*     */   public void sendToDimension(IMessage message, int dimensionId) {
/*  87 */     this.channel.sendToDimension(message, dimensionId);
/*     */   }
/*     */   
/*     */   public void sendTo(Packet packet, EntityPlayer player) {
/*  91 */     if ((player instanceof EntityPlayerMP)) {
/*  92 */       EntityPlayerMP mp = (EntityPlayerMP)player;
/*  93 */       mp.field_71135_a.func_147359_a(packet);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendToDimension(Packet packet, World world) {
/*  98 */     for (Object obj : world.field_73010_i) {
/*  99 */       if ((obj instanceof EntityPlayerMP)) {
/* 100 */         EntityPlayerMP mp = (EntityPlayerMP)obj;
/* 101 */         mp.field_71135_a.func_147359_a(packet);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendToAll(Packet packet) {
/* 107 */     for (WorldServer world : MinecraftServer.func_71276_C().field_71305_c) {
/* 108 */       sendToDimension(packet, world);
/*     */     }
/*     */   }
/*     */   
/*     */   public void sendToAllAround(Packet packet, World world, NetworkRegistry.TargetPoint point) {
/* 113 */     double RANGE_SQ = point.range * point.range;
/* 114 */     for (Object obj : world.field_73010_i) {
/* 115 */       if ((obj instanceof EntityPlayerMP)) {
/* 116 */         EntityPlayerMP mp = (EntityPlayerMP)obj;
/* 117 */         if (mp.func_70092_e(point.x, point.y, point.z) <= RANGE_SQ) {
/* 118 */           mp.field_71135_a.func_147359_a(packet);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/network/PacketPipeline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */