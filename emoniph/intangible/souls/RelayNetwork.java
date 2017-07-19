/*     */ package emoniph.intangible.souls;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISoulRelay;
/*     */ import emoniph.intangible.config.Log;
/*     */ import emoniph.intangible.init.IModServerStarting;
/*     */ import emoniph.intangible.init.IModServerStopping;
/*     */ import emoniph.intangible.init.IModService;
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
/*     */ 
/*     */ public class RelayNetwork extends SoulNetworkBase implements IModService, IModServerStarting, IModServerStopping
/*     */ {
/*  22 */   private final Set<ISoulRelay> relays = new java.util.HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */   public void serverStarting(FMLServerStartingEvent event) {}
/*     */   
/*     */ 
/*     */   public void serverStopping(FMLServerStoppingEvent event)
/*     */   {
/*  31 */     this.relays.clear();
/*     */   }
/*     */   
/*     */   public void loadChunk(Chunk chunk)
/*     */   {
/*  36 */     Collection loadedTiles = chunk.func_177434_r().values();
/*  37 */     for (Iterator it = loadedTiles.iterator(); it.hasNext();) {
/*  38 */       TileEntity tile = (TileEntity)it.next();
/*  39 */       if ((tile instanceof ISoulRelay)) {
/*  40 */         addRelay((ISoulRelay)tile, ((ISoulRelay)tile).getRelayWorld());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void unloadChunk(Chunk chunk) {
/*  46 */     Collection loadedTiles = chunk.func_177434_r().values();
/*  47 */     for (Iterator it = loadedTiles.iterator(); it.hasNext();) {
/*  48 */       TileEntity tile = (TileEntity)it.next();
/*  49 */       if ((tile instanceof ISoulRelay)) {
/*  50 */         removeRelay((ISoulRelay)tile);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void addRelay(ISoulRelay relay, World worldIn) {
/*  56 */     if (worldIn.field_72995_K) {
/*  57 */       return;
/*     */     }
/*     */     
/*  60 */     if (relay == null) {
/*  61 */       Get.log().debug("addRelay: NULL passed as argument");
/*  62 */       return;
/*     */     }
/*     */     
/*  65 */     if (!this.relays.contains(relay)) {
/*     */       try {
/*  67 */         Iterator<ISoulRelay> it = this.relays.iterator();
/*  68 */         while (it.hasNext()) {
/*  69 */           ISoulRelay existing = (ISoulRelay)it.next();
/*     */           
/*  71 */           if ((existing == null) || (existing.isRelayInvalid())) {
/*  72 */             Get.log().debug(String.format("addRelay: About to remove additional null or invalid relay entry from relay network.", new Object[0]));
/*  73 */             it.remove();
/*  74 */           } else if (existing.getRelayPos().equals(relay.getRelayPos())) {
/*  75 */             Get.log().debug(String.format("addRelay: About to remove conflicting relay entry with same coords in relay network. Found %s at %s.", new Object[] { existing, existing.getRelayPos() }));
/*  76 */             it.remove();
/*     */           }
/*     */         }
/*     */       } catch (Throwable ex) {
/*  80 */         Get.log().warning(ex, "addRelay: Exception occurred validating existing relay entries.");
/*     */       }
/*     */       
/*  83 */       this.relays.add(relay);
/*  84 */       Get.log().debug(String.format("addRelay: Added relay at %s [%d].", new Object[] { relay.getRelayPos(), Integer.valueOf(this.relays.size()) }));
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeRelay(ISoulRelay relay) {
/*  89 */     if (relay.getRelayWorld().field_72995_K) {
/*  90 */       return;
/*     */     }
/*     */     
/*  93 */     if (relay == null) {
/*  94 */       Get.log().debug("removeRelay: NULL passed as argument");
/*  95 */       return;
/*     */     }
/*     */     
/*  98 */     if ((relay != null) && (this.relays.remove(relay))) {
/*  99 */       Get.log().debug(String.format("removeRelay: Removed relay at %s [%d].", new Object[] { relay.getRelayPos(), Integer.valueOf(this.relays.size()) }));
/*     */     }
/*     */     try
/*     */     {
/* 103 */       Iterator<ISoulRelay> it = this.relays.iterator();
/* 104 */       while (it.hasNext()) {
/* 105 */         ISoulRelay existing = (ISoulRelay)it.next();
/*     */         
/* 107 */         if ((existing == null) || (existing.isRelayInvalid())) {
/* 108 */           Get.log().debug(String.format("removeRelay: About to remove additional null or invalid relay entry from relay network.", new Object[0]));
/* 109 */           it.remove();
/*     */         } else {
/* 111 */           TileEntity tile = getLoadedTileEntityAt(existing.getRelayWorld(), existing.getRelayPos());
/* 112 */           if ((tile != null) && (tile != existing)) {
/* 113 */             Get.log().debug(String.format("removeRelay: About to remove conflicting relay entry from relay network. Found %s at %s.", new Object[] { tile, existing.getRelayPos() }));
/* 114 */             it.remove();
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Throwable ex) {
/* 119 */       Get.log().warning(ex, "removeRelay: Exception occurred removing existing invalid relay entries.");
/*     */     }
/*     */   }
/*     */   
/*     */   public ISoulRelay findClosest(World world, BlockPos pos) {
/* 124 */     return findClosest(world, pos, null, Double.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public ISoulRelay findClosest(World world, BlockPos pos, Set<Long> exclusions) {
/* 128 */     return findClosest(world, pos, exclusions, Double.MAX_VALUE);
/*     */   }
/*     */   
/*     */   public ISoulRelay findClosest(World world, BlockPos pos, double maxRange) {
/* 132 */     return findClosest(world, pos, null, maxRange);
/*     */   }
/*     */   
/*     */   public ISoulRelay findClosest(World world, BlockPos pos, Set<Long> exclusions, double maxRange) {
/* 136 */     double limit = maxRange * maxRange;
/* 137 */     ISoulRelay closest = null;
/* 138 */     double closestDistance = Double.MAX_VALUE;
/*     */     
/* 140 */     for (ISoulRelay relay : this.relays) {
/* 141 */       if (world == relay.getRelayWorld()) {
/* 142 */         double distance = relay.getRelayPos().func_177954_c(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
/* 143 */         if ((!relay.isRelayInvalid()) && ((closest == null) || (distance < closestDistance)))
/*     */         {
/* 145 */           if ((relay.isRelayActive()) && (distance <= limit) && ((exclusions == null) || 
/*     */           
/* 147 */             (!exclusions.contains(Long.valueOf(relay.getRelayPos().func_177986_g()))))) {
/* 148 */             closestDistance = distance;
/* 149 */             closest = relay;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 154 */     return closest;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/RelayNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */