/*     */ package emoniph.intangible.souls;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.ISoulWell;
/*     */ import emoniph.intangible.config.Log;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ 
/*     */ public class WellNetwork extends SoulNetworkBase implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModServerStarting, emoniph.intangible.init.IModServerStopping
/*     */ {
/*  23 */   private final Set<ISoulWell> wells = new java.util.HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */   public void serverStarting(net.minecraftforge.fml.common.event.FMLServerStartingEvent event) {}
/*     */   
/*     */ 
/*     */   public void serverStopping(net.minecraftforge.fml.common.event.FMLServerStoppingEvent event)
/*     */   {
/*  32 */     this.wells.clear();
/*     */   }
/*     */   
/*     */   public void loadChunk(Chunk chunk) {
/*  36 */     java.util.Collection loadedTiles = chunk.func_177434_r().values();
/*  37 */     for (Iterator it = loadedTiles.iterator(); it.hasNext();) {
/*  38 */       TileEntity tile = (TileEntity)it.next();
/*  39 */       if ((tile instanceof ISoulWell)) {
/*  40 */         addWell((ISoulWell)tile, ((ISoulWell)tile).getWellWorld());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void unloadChunk(Chunk chunk) {
/*  46 */     java.util.Collection loadedTiles = chunk.func_177434_r().values();
/*  47 */     for (Iterator it = loadedTiles.iterator(); it.hasNext();) {
/*  48 */       TileEntity tile = (TileEntity)it.next();
/*  49 */       if ((tile instanceof ISoulWell)) {
/*  50 */         removeWell((ISoulWell)tile);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void addWell(ISoulWell well, World worldIn) {
/*  56 */     if (worldIn.field_72995_K) {
/*  57 */       return;
/*     */     }
/*     */     
/*  60 */     if (well == null) {
/*  61 */       Get.log().debug("addWell: NULL passed as argument");
/*  62 */       return;
/*     */     }
/*     */     
/*  65 */     if (!this.wells.contains(well)) {
/*     */       try {
/*  67 */         Iterator<ISoulWell> it = this.wells.iterator();
/*  68 */         while (it.hasNext()) {
/*  69 */           ISoulWell existing = (ISoulWell)it.next();
/*     */           
/*  71 */           if ((existing == null) || (existing.isWellInvalid())) {
/*  72 */             Get.log().debug(String.format("addWell: About to remove null or invalid well entry from well network.", new Object[0]));
/*  73 */             it.remove();
/*  74 */           } else if (existing.getWellPos().equals(well.getWellPos())) {
/*  75 */             Get.log().debug(String.format("addWell: About to remove conflicting well entry with same coords in well network. Found %s at %s.", new Object[] { existing, existing.getWellPos() }));
/*  76 */             it.remove();
/*     */           }
/*     */         }
/*     */       } catch (Throwable ex) {
/*  80 */         Get.log().warning(ex, "addWell: Exception occurred validating existing well entries.");
/*     */       }
/*  82 */       this.wells.add(well);
/*  83 */       Get.log().debug(String.format("addWell: Added well at %s [%d].", new Object[] { well.getWellPos(), Integer.valueOf(this.wells.size()) }));
/*     */     }
/*     */   }
/*     */   
/*     */   public void removeWell(ISoulWell well) {
/*  88 */     if (well.getWellWorld().field_72995_K) {
/*  89 */       return;
/*     */     }
/*     */     
/*  92 */     if (well == null) {
/*  93 */       Get.log().debug("removeWell: NULL passed as argument");
/*     */     }
/*     */     
/*  96 */     if ((well != null) && (this.wells.remove(well))) {
/*  97 */       Get.log().debug(String.format("removeWell: Removed well at %s [%d].", new Object[] { well.getWellPos(), Integer.valueOf(this.wells.size()) }));
/*     */     }
/*     */     try
/*     */     {
/* 101 */       Iterator<ISoulWell> it = this.wells.iterator();
/* 102 */       while (it.hasNext()) {
/* 103 */         ISoulWell existing = (ISoulWell)it.next();
/*     */         
/* 105 */         if ((existing == null) || (existing.isWellInvalid())) {
/* 106 */           Get.log().debug(String.format("removeWell: About to remove additional null or invalid well entry from relay network.", new Object[0]));
/* 107 */           it.remove();
/*     */         } else {
/* 109 */           TileEntity tile = getLoadedTileEntityAt(existing.getWellWorld(), existing.getWellPos());
/* 110 */           if ((tile != null) && (tile != existing)) {
/* 111 */             Get.log().debug(String.format("removeWell: About to remove conflicting well entry from well network. Found %s at %s.", new Object[] { tile, existing.getWellPos() }));
/* 112 */             it.remove();
/*     */           }
/*     */         }
/*     */       }
/*     */     } catch (Throwable ex) {
/* 117 */       Get.log().warning(ex, "removeWell: Exception occurred removing existing invalid well entries.");
/*     */     }
/*     */   }
/*     */   
/*     */   private ISoulWell findClosest(World world, BlockPos pos) {
/* 122 */     return findClosest(world, pos, Double.MAX_VALUE);
/*     */   }
/*     */   
/*     */   private ISoulWell findClosest(World world, BlockPos pos, double maxRange) {
/* 126 */     double limit = maxRange * maxRange;
/* 127 */     ISoulWell closest = null;
/* 128 */     double closestDistance = Double.MAX_VALUE;
/*     */     
/* 130 */     for (ISoulWell well : this.wells) {
/* 131 */       if (world == well.getWellWorld()) {
/* 132 */         double distance = well.getWellPos().func_177954_c(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
/* 133 */         if (((closest == null) || (distance < closestDistance)) && 
/* 134 */           (!well.isWellInvalid()) && 
/* 135 */           (well.isWellActive()) && (distance <= limit))
/*     */         {
/* 137 */           closestDistance = distance;
/* 138 */           closest = well;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 143 */     return closest;
/*     */   }
/*     */   
/*     */   private List<ISoulWell> findNearbyWells(World world, BlockPos pos, double maxRange) {
/* 147 */     double limit = maxRange * maxRange;
/*     */     
/* 149 */     List<ISoulWell> results = new ArrayList();
/* 150 */     final Map<ISoulWell, Double> distances = new java.util.HashMap();
/* 151 */     for (ISoulWell well : this.wells) {
/* 152 */       if (world == well.getWellWorld()) {
/* 153 */         double distance = well.getWellPos().func_177954_c(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
/* 154 */         if ((distance <= limit) && (!well.isWellInvalid()) && (well.isWellActive())) {
/* 155 */           distances.put(well, Double.valueOf(distance));
/* 156 */           results.add(well);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 161 */     java.util.Collections.sort(results, new java.util.Comparator()
/*     */     {
/*     */       public int compare(ISoulWell a, ISoulWell b) {
/* 164 */         return ((Double)distances.get(a)).compareTo((Double)distances.get(b));
/*     */       }
/*     */       
/* 167 */     });
/* 168 */     return results;
/*     */   }
/*     */   
/*     */   public boolean addSoulsToClosestWell(World worldIn, BlockPos pos, double range, ISoulSet souls, Vec3 sourcePos) {
/* 172 */     ISoulWell closest = Get.wells().findClosest(worldIn, pos, range);
/* 173 */     if (closest != null) {
/* 174 */       closest.add(souls);
/* 175 */       Get.fx().GLOW.sendToAllNear(worldIn, sourcePos.field_72450_a, sourcePos.field_72448_b, sourcePos.field_72449_c, 2.0F, 50, 6710818, 1, BlockUtil.midBlockToVec3(closest.getWellPos()), 0.5F, 32.0D);
/* 176 */       return true;
/*     */     }
/* 178 */     return false;
/*     */   }
/*     */   
/*     */   public boolean requestSoulsForWork(World world, BlockPos pos, double range, ISoulSet souls, int cooldownTicks, Vec3 target)
/*     */   {
/* 183 */     if (world.field_72995_K) {
/* 184 */       return true;
/*     */     }
/*     */     
/* 187 */     List<BlockPos> sequence = new ArrayList();
/*     */     
/* 189 */     List<ISoulWell> wells = Get.wells().findNearbyWells(world, pos, range);
/* 190 */     boolean search; if (wells.size() == 0) {
/* 191 */       BlockPos currentPos = pos;
/* 192 */       Set<Long> visited = new java.util.HashSet();
/*     */       
/* 194 */       search = true;
/* 195 */       while (search) {
/* 196 */         visited.add(Long.valueOf(currentPos.func_177986_g()));
/* 197 */         emoniph.intangible.api.ISoulRelay relay = Get.relays().findClosest(world, currentPos, visited, 16.0D);
/* 198 */         if (relay != null) {
/* 199 */           wells = Get.wells().findNearbyWells(world, currentPos, range);
/* 200 */           if (wells.size() == 0) {
/* 201 */             currentPos = relay.getRelayPos();
/* 202 */             sequence.add(currentPos);
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 208 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 213 */     SoulSet workingSouls = new SoulSet(souls);
/* 214 */     List<ISoulSet> partialRequest = new ArrayList();
/*     */     
/* 216 */     for (ISoulWell well : wells) {
/* 217 */       ISoulSet partialSouls = well.reportAvailableSoulsFrom(workingSouls);
/* 218 */       workingSouls.trySubtract(partialSouls);
/* 219 */       partialRequest.add(partialSouls);
/*     */     }
/*     */     
/* 222 */     if (workingSouls.isEmpty())
/*     */     {
/* 224 */       for (int i = 0; i < wells.size(); i++) {
/* 225 */         if ((partialRequest.get(i) != null) && (!((ISoulSet)partialRequest.get(i)).isEmpty())) {
/* 226 */           ((ISoulWell)wells.get(i)).tryUseSouls((ISoulSet)partialRequest.get(i), cooldownTicks);
/* 227 */           if (sequence.size() > 0) {
/* 228 */             Get.fx().GLOW.sendToAllNear(world, ((ISoulWell)wells.get(i)).getWellPos(), 2.0F, 50, 6710818, 1, BlockUtil.midBlockToVec3((BlockPos)sequence.get(sequence.size() - 1)), 0.5F, 32.0D);
/*     */           } else {
/* 230 */             Get.fx().GLOW.sendToAllNear(world, ((ISoulWell)wells.get(i)).getWellPos(), 2.0F, 50, 6710818, 1, target, 0.5F, 32.0D);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 235 */       for (int i = 0; i < sequence.size() - 2; i++) {
/* 236 */         Get.fx().GLOW.sendToAllNear(world, (BlockPos)sequence.get(i + 1), 2.0F, 50, 6710818, 1, BlockUtil.midBlockToVec3((BlockPos)sequence.get(i)), 0.5F, 32.0D);
/*     */       }
/* 238 */       if (sequence.size() > 0) {
/* 239 */         Get.fx().GLOW.sendToAllNear(world, (BlockPos)sequence.get(0), 2.0F, 50, 6710818, 1, target, 0.5F, 32.0D);
/*     */       }
/*     */       
/* 242 */       return true;
/*     */     }
/* 244 */     return false;
/*     */   }
/*     */   
/*     */   public boolean consumeSouls(World world, BlockPos pos, double range, ISoulSet souls, Vec3 target)
/*     */   {
/* 249 */     if (world.field_72995_K) {
/* 250 */       return true;
/*     */     }
/* 252 */     List<BlockPos> sequence = new ArrayList();
/*     */     
/* 254 */     List<ISoulWell> wells = Get.wells().findNearbyWells(world, pos, range);
/* 255 */     boolean search; if (wells.size() == 0) {
/* 256 */       BlockPos currentPos = pos;
/* 257 */       Set<Long> visited = new java.util.HashSet();
/*     */       
/* 259 */       search = true;
/* 260 */       while (search) {
/* 261 */         visited.add(Long.valueOf(currentPos.func_177986_g()));
/* 262 */         emoniph.intangible.api.ISoulRelay relay = Get.relays().findClosest(world, currentPos, visited, 16.0D);
/* 263 */         if (relay != null) {
/* 264 */           wells = Get.wells().findNearbyWells(world, currentPos, range);
/* 265 */           if (wells.size() == 0) {
/* 266 */             currentPos = relay.getRelayPos();
/* 267 */             sequence.add(currentPos);
/*     */           }
/*     */           
/*     */         }
/*     */         else
/*     */         {
/* 273 */           return false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 278 */     SoulSet workingSouls = new SoulSet(souls);
/* 279 */     List<ISoulSet> partialRequest = new ArrayList();
/*     */     
/* 281 */     for (ISoulWell well : wells) {
/* 282 */       ISoulSet partialSouls = well.reportAvailableSoulsFrom(workingSouls);
/* 283 */       workingSouls.trySubtract(partialSouls);
/* 284 */       partialRequest.add(partialSouls);
/*     */     }
/*     */     
/* 287 */     if (workingSouls.isEmpty())
/*     */     {
/* 289 */       for (int i = 0; i < wells.size(); i++) {
/* 290 */         if ((partialRequest.get(i) != null) && (!((ISoulSet)partialRequest.get(i)).isEmpty())) {
/* 291 */           ((ISoulWell)wells.get(i)).tryTakeSouls((ISoulSet)partialRequest.get(i));
/*     */           
/* 293 */           if (sequence.size() > 0) {
/* 294 */             Get.fx().GLOW.sendToAllNear(world, ((ISoulWell)wells.get(i)).getWellPos(), 2.0F, 50, 6710818, 1, BlockUtil.midBlockToVec3((BlockPos)sequence.get(sequence.size() - 1)), 0.5F, 32.0D);
/*     */           } else {
/* 296 */             Get.fx().GLOW.sendToAllNear(world, ((ISoulWell)wells.get(i)).getWellPos(), 2.0F, 50, 6710818, 1, target, 0.5F, 32.0D);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 301 */       for (int i = 0; i < sequence.size() - 2; i++) {
/* 302 */         Get.fx().GLOW.sendToAllNear(world, (BlockPos)sequence.get(i + 1), 2.0F, 50, 6710818, 1, BlockUtil.midBlockToVec3((BlockPos)sequence.get(i)), 0.5F, 32.0D);
/*     */       }
/* 304 */       if (sequence.size() > 0) {
/* 305 */         Get.fx().GLOW.sendToAllNear(world, (BlockPos)sequence.get(0), 2.0F, 50, 6710818, 1, target, 0.5F, 32.0D);
/*     */       }
/*     */       
/*     */ 
/* 309 */       return true;
/*     */     }
/* 311 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/WellNetwork.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */