/*     */ package emoniph.intangible.deity.effects;
/*     */ 
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.util.EnumArmorSlot;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class MajorEffectDaytimeMonsters implements emoniph.intangible.api.deity.IDeityMajorWorldEffect
/*     */ {
/*     */   private class SpawnerAnimals
/*     */   {
/*     */     private SpawnerAnimals() {}
/*     */     
/*  26 */     private final int MOB_COUNT_DIV = (int)Math.pow(17.0D, 2.0D);
/*  27 */     private final Set<ChunkCoordIntPair> eligibleChunksForSpawning = com.google.common.collect.Sets.newHashSet();
/*     */     
/*     */     public int findChunksForSpawning(WorldServer worldServerIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs, boolean p_77192_4_) {
/*  30 */       if ((!spawnHostileMobs) && (!spawnPeacefulMobs)) {
/*  31 */         return 0;
/*     */       }
/*  33 */       this.eligibleChunksForSpawning.clear();
/*  34 */       int i = 0;
/*     */       
/*  36 */       for (EntityPlayer entityplayer : worldServerIn.field_73010_i) {
/*  37 */         if (!entityplayer.func_175149_v()) {
/*  38 */           j = MathHelper.func_76128_c(entityplayer.field_70165_t / 16.0D);
/*  39 */           k = MathHelper.func_76128_c(entityplayer.field_70161_v / 16.0D);
/*  40 */           l = 8;
/*     */           
/*  42 */           for (int i1 = -l; i1 <= l; i1++)
/*  43 */             for (int j1 = -l; j1 <= l; j1++) {
/*  44 */               boolean flag = (i1 == -l) || (i1 == l) || (j1 == -l) || (j1 == l);
/*  45 */               ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(i1 + j, j1 + k);
/*     */               
/*  47 */               if (!this.eligibleChunksForSpawning.contains(chunkcoordintpair)) {
/*  48 */                 i++;
/*     */                 
/*  50 */                 if ((!flag) && (worldServerIn.func_175723_af().func_177730_a(chunkcoordintpair)))
/*  51 */                   this.eligibleChunksForSpawning.add(chunkcoordintpair);
/*     */               }
/*     */             }
/*     */         }
/*     */       }
/*     */       int j;
/*     */       int k;
/*     */       int l;
/*  59 */       int i4 = 0;
/*  60 */       BlockPos blockpos2 = worldServerIn.func_175694_M();
/*     */       EnumCreatureType enumcreaturetype;
/*  62 */       label935: label941: for (enumcreaturetype : EnumCreatureType.values()) {
/*  63 */         if (((!enumcreaturetype.func_75599_d()) || (spawnPeacefulMobs)) && ((enumcreaturetype.func_75599_d()) || (spawnHostileMobs)) && ((!enumcreaturetype.func_82705_e()) || (p_77192_4_))) {
/*  64 */           int j4 = worldServerIn.countEntities(enumcreaturetype, true);
/*  65 */           int k4 = enumcreaturetype.func_75601_b() * i / this.MOB_COUNT_DIV;
/*     */           
/*  67 */           if (j4 <= k4) {
/*  68 */             java.util.ArrayList<ChunkCoordIntPair> shuffled = com.google.common.collect.Lists.newArrayList(this.eligibleChunksForSpawning);
/*  69 */             java.util.Collections.shuffle(shuffled);
/*     */             
/*  71 */             for (ChunkCoordIntPair chunkcoordintpair1 : shuffled) {
/*  72 */               BlockPos blockpos = getRandomChunkPosition(worldServerIn, chunkcoordintpair1.field_77276_a, chunkcoordintpair1.field_77275_b);
/*  73 */               int k1 = blockpos.func_177958_n();
/*  74 */               int l1 = blockpos.func_177956_o();
/*  75 */               int i2 = blockpos.func_177952_p();
/*  76 */               Block block = worldServerIn.func_180495_p(blockpos).func_177230_c();
/*     */               
/*  78 */               if (!block.func_149721_r()) {
/*  79 */                 int j2 = 0;
/*     */                 
/*  81 */                 for (int k2 = 0;; k2++) { if (k2 >= 3) break label941;
/*  82 */                   int l2 = k1;
/*  83 */                   int i3 = l1;
/*  84 */                   int j3 = i2;
/*  85 */                   int k3 = 6;
/*  86 */                   net.minecraft.world.biome.BiomeGenBase.SpawnListEntry biomegenbase$spawnlistentry = null;
/*  87 */                   net.minecraft.entity.IEntityLivingData ientitylivingdata = null;
/*     */                   
/*  89 */                   for (int l3 = 0;; l3++) { if (l3 >= 4) break label935;
/*  90 */                     l2 += worldServerIn.field_73012_v.nextInt(k3) - worldServerIn.field_73012_v.nextInt(k3);
/*  91 */                     i3 += worldServerIn.field_73012_v.nextInt(1) - worldServerIn.field_73012_v.nextInt(1);
/*  92 */                     j3 += worldServerIn.field_73012_v.nextInt(k3) - worldServerIn.field_73012_v.nextInt(k3);
/*  93 */                     BlockPos blockpos1 = new BlockPos(l2, i3, j3);
/*  94 */                     float f = l2 + 0.5F;
/*  95 */                     float f1 = j3 + 0.5F;
/*     */                     
/*  97 */                     if ((!worldServerIn.func_175636_b(f, i3, f1, 24.0D)) && (blockpos2.func_177954_c(f, i3, f1) >= 576.0D)) {
/*  98 */                       if (biomegenbase$spawnlistentry == null) {
/*  99 */                         biomegenbase$spawnlistentry = worldServerIn.func_175734_a(enumcreaturetype, blockpos1);
/*     */                         
/* 101 */                         if (biomegenbase$spawnlistentry == null) {
/*     */                           break label935;
/*     */                         }
/*     */                       }
/*     */                       
/* 106 */                       if ((worldServerIn.func_175732_a(enumcreaturetype, biomegenbase$spawnlistentry, blockpos1)) && (canCreatureTypeSpawnAtLocation(net.minecraft.entity.EntitySpawnPlacementRegistry.func_180109_a(biomegenbase$spawnlistentry.field_76300_b), worldServerIn, blockpos1)))
/*     */                       {
/*     */                         try
/*     */                         {
/* 110 */                           entityliving = (EntityLiving)biomegenbase$spawnlistentry.field_76300_b.getConstructor(new Class[] { World.class }).newInstance(new Object[] { worldServerIn });
/*     */                         } catch (Exception exception) { EntityLiving entityliving;
/* 112 */                           exception.printStackTrace();
/* 113 */                           return i4;
/*     */                         }
/*     */                         EntityLiving entityliving;
/* 116 */                         entityliving.func_70012_b(f, i3, f1, worldServerIn.field_73012_v.nextFloat() * 360.0F, 0.0F);
/*     */                         
/* 118 */                         net.minecraftforge.fml.common.eventhandler.Event.Result canSpawn = net.minecraftforge.event.ForgeEventFactory.canEntitySpawn(entityliving, worldServerIn, f, l2, f1);
/* 119 */                         if ((canSpawn == net.minecraftforge.fml.common.eventhandler.Event.Result.ALLOW) || ((canSpawn == net.minecraftforge.fml.common.eventhandler.Event.Result.DEFAULT) && (canSpawnHere(worldServerIn, entityliving)) && (entityliving.func_70058_J()))) {
/* 120 */                           if (!net.minecraftforge.event.ForgeEventFactory.doSpecialSpawn(entityliving, worldServerIn, f1, l2, f1))
/* 121 */                             ientitylivingdata = entityliving.func_180482_a(worldServerIn.func_175649_E(new BlockPos(entityliving)), ientitylivingdata);
/* 122 */                           if ((entityliving.func_70662_br()) && (!entityliving.func_70631_g_()) && (entityliving.func_71124_b(EnumArmorSlot.HEAD.equipmentSlot) == null)) {
/* 123 */                             entityliving.func_70062_b(EnumArmorSlot.HEAD.equipmentSlot, new ItemStack(net.minecraft.init.Items.field_151024_Q));
/*     */                           }
/*     */                           
/*     */ 
/* 127 */                           if (entityliving.func_70058_J()) {
/* 128 */                             j2++;
/* 129 */                             worldServerIn.func_72838_d(entityliving);
/*     */                           }
/*     */                           
/* 132 */                           if (i2 >= net.minecraftforge.event.ForgeEventFactory.getMaxSpawnPackSize(entityliving)) {
/*     */                             break;
/*     */                           }
/*     */                         }
/*     */                         
/* 137 */                         i4 += j2;
/*     */                       }
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 148 */       return i4;
/*     */     }
/*     */     
/*     */     private boolean canSpawnHere(World world, EntityLiving entityliving)
/*     */     {
/* 153 */       return world.func_175659_aa() != net.minecraft.world.EnumDifficulty.PEACEFUL;
/*     */     }
/*     */     
/*     */     protected BlockPos getRandomChunkPosition(World worldIn, int x, int z)
/*     */     {
/* 158 */       net.minecraft.world.chunk.Chunk chunk = worldIn.func_72964_e(x, z);
/* 159 */       int i = x * 16 + worldIn.field_73012_v.nextInt(16);
/* 160 */       int j = z * 16 + worldIn.field_73012_v.nextInt(16);
/* 161 */       int k = MathHelper.func_154354_b(chunk.func_177433_f(new BlockPos(i, 0, j)) + 1, 16);
/* 162 */       int l = worldIn.field_73012_v.nextInt(k > 0 ? k : chunk.func_76625_h() + 16 - 1);
/* 163 */       return new BlockPos(i, l, j);
/*     */     }
/*     */     
/*     */     public boolean canCreatureTypeSpawnAtLocation(net.minecraft.entity.EntityLiving.SpawnPlacementType spawnPlacementTypeIn, World worldIn, BlockPos pos)
/*     */     {
/* 168 */       if (!worldIn.func_175723_af().func_177746_a(pos))
/*     */       {
/* 170 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 174 */       Block block = worldIn.func_180495_p(pos).func_177230_c();
/*     */       
/* 176 */       if (spawnPlacementTypeIn == net.minecraft.entity.EntityLiving.SpawnPlacementType.IN_WATER)
/*     */       {
/* 178 */         return (block.func_149688_o().func_76224_d()) && (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c().func_149688_o().func_76224_d()) && (!worldIn.func_180495_p(pos.func_177984_a()).func_177230_c().func_149721_r());
/*     */       }
/*     */       
/*     */ 
/* 182 */       BlockPos blockpos = pos.func_177977_b();
/*     */       
/* 184 */       if (!worldIn.func_180495_p(blockpos).func_177230_c().canCreatureSpawn(worldIn, blockpos, spawnPlacementTypeIn))
/*     */       {
/* 186 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 190 */       Block block1 = worldIn.func_180495_p(blockpos).func_177230_c();
/* 191 */       boolean flag = (block1 != net.minecraft.init.Blocks.field_150357_h) && (block1 != net.minecraft.init.Blocks.field_180401_cv);
/* 192 */       return (flag) && (!block.func_149721_r()) && (!block.func_149688_o().func_76224_d()) && (!worldIn.func_180495_p(pos.func_177984_a()).func_177230_c().func_149721_r());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 199 */   SpawnerAnimals spawner = new SpawnerAnimals(null);
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onWorldTick(World world, IDeity deity)
/*     */   {
/* 206 */     if ((world != null) && (!world.field_72995_K) && 
/* 207 */       (world.func_82736_K().func_82766_b("doMobSpawning")) && (world.func_72935_r())) {
/* 208 */       boolean spawnHostile = true;
/* 209 */       boolean spawnPeaceful = false;
/* 210 */       this.spawner.findChunksForSpawning((WorldServer)world, spawnHostile, spawnPeaceful, world.func_82737_E() % 400L == 0L);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onEntityJoinWorld(World world, IDeity deity, net.minecraft.entity.Entity entity)
/*     */   {
/* 217 */     return true;
/*     */   }
/*     */   
/*     */   public void onHarvest(World world, BlockPos pos, java.util.List<ItemStack> drops, EntityPlayer harvester, Deity deity) {}
/*     */   
/*     */   public void onPlayerUseItemFinish(World worldObj, EntityPlayer entityPlayer, ItemStack item, Deity topDeity) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/MajorEffectDaytimeMonsters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */