/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.api.IInventoryItem;
/*     */ import emoniph.intangible.api.ISoulForgeClient;
/*     */ import emoniph.intangible.api.ISoulForgeInventory;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Queue;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.nbt.NBTTagLong;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockSoulForge extends BlockContainer implements IBlock, IMultiBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  41 */     return 65;
/*     */   }
/*     */   
/*     */   public static enum EnumPart implements net.minecraft.util.IStringSerializable {
/*  45 */     BOTTOM("bottom", 0), 
/*  46 */     MIDDLE("middle", 1), 
/*  47 */     TOP("top", 2);
/*     */     
/*     */     private final String name;
/*     */     private final int metadata;
/*     */     private static final Map<Integer, EnumPart> META_TO_PART;
/*     */     
/*  53 */     private EnumPart(String name, int metadata) { this.name = name;
/*  54 */       this.metadata = metadata;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  58 */       return this.name;
/*     */     }
/*     */     
/*     */     public String func_176610_l() {
/*  62 */       return this.name;
/*     */     }
/*     */     
/*     */ 
/*  66 */     public int toMetadata() { return this.metadata; }
/*     */     
/*     */     static {
/*  69 */       META_TO_PART = new java.util.HashMap();
/*     */       
/*     */ 
/*  72 */       for (EnumPart part : values()) {
/*  73 */         META_TO_PART.put(Integer.valueOf(part.metadata), part);
/*     */       }
/*     */     }
/*     */     
/*     */     public static EnumPart fromMetadata(int metadata) {
/*  78 */       return (EnumPart)META_TO_PART.get(Integer.valueOf(metadata));
/*     */     }
/*     */   }
/*     */   
/*  82 */   public static final net.minecraft.block.properties.PropertyEnum PART = net.minecraft.block.properties.PropertyEnum.func_177709_a("part", EnumPart.class);
/*     */   
/*     */   BlockSoulForge() {
/*  85 */     super(net.minecraft.block.material.Material.field_151576_e);
/*  86 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(PART, EnumPart.BOTTOM));
/*  87 */     func_149711_c(3.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, net.minecraft.entity.Entity entity)
/*     */   {
/*  92 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  97 */     if (func_176203_a(meta).func_177229_b(PART) == EnumPart.BOTTOM) {
/*  98 */       return new TileEntitySoulForge();
/*     */     }
/* 100 */     return new TileEntityVoid();
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_149645_b()
/*     */   {
/* 106 */     return 3;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k() {
/* 111 */     return EnumWorldBlockLayer.SOLID;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/* 116 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, net.minecraft.util.EnumFacing side)
/*     */   {
/* 126 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {}
/*     */   
/*     */ 
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 136 */     Object part = state.func_177229_b(PART);
/* 137 */     if (part == EnumPart.TOP) {
/* 138 */       if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) {
/* 139 */         worldIn.func_175698_g(pos);
/*     */       }
/* 141 */     } else if (part == EnumPart.MIDDLE) {
/* 142 */       if ((worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) || (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this)) {
/* 143 */         worldIn.func_175698_g(pos);
/*     */       }
/* 145 */     } else if (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this) {
/* 146 */       worldIn.func_175698_g(pos);
/* 147 */       if (!worldIn.field_72995_K) {
/* 148 */         func_176226_b(worldIn, pos, state, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public net.minecraft.item.Item func_180660_a(IBlockState state, Random rand, int fortune) {
/* 154 */     return state.func_177229_b(PART) == EnumPart.BOTTOM ? super.func_180660_a(state, rand, fortune) : null;
/*     */   }
/*     */   
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
/* 158 */     if (state.func_177229_b(PART) == EnumPart.BOTTOM) {
/* 159 */       super.func_180653_a(worldIn, pos, state, chance, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 164 */     if (player.field_71075_bZ.field_75098_d) {
/* 165 */       Object part = state.func_177229_b(PART);
/* 166 */       if (part == EnumPart.TOP) {
/* 167 */         BlockPos blockpos1 = pos.func_177977_b();
/* 168 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 169 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 172 */         blockpos1 = blockpos1.func_177977_b();
/* 173 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 174 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/* 176 */       } else if (part == EnumPart.MIDDLE) {
/* 177 */         BlockPos blockpos1 = pos.func_177977_b();
/* 178 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 179 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 182 */         blockpos1 = pos.func_177984_a();
/* 183 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 184 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/* 191 */     return func_176223_P().func_177226_a(PART, EnumPart.fromMetadata(meta & 0x3));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/* 195 */     EnumPart part = (EnumPart)state.func_177229_b(PART);
/* 196 */     return part.toMetadata();
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e() {
/* 200 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { PART });
/*     */   }
/*     */   
/*     */   public BlockPos getMultiBlockCorePos(IBlockAccess worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 205 */     switch ((EnumPart)state.func_177229_b(PART)) {
/*     */     case TOP: 
/* 207 */       return pos.func_177979_c(2);
/*     */     case MIDDLE: 
/* 209 */       return pos.func_177977_b();
/*     */     }
/* 211 */     return pos;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 217 */     if ((!worldIn.field_72995_K) && 
/* 218 */       (state.func_177229_b(PART) == EnumPart.BOTTOM)) {
/* 219 */       TileEntitySoulForge tile = (TileEntitySoulForge)emoniph.intangible.util.BlockUtil.getTileEntity(worldIn, pos, TileEntitySoulForge.class);
/* 220 */       if (tile != null) {
/* 221 */         for (BlockSoulForge.TileEntitySoulForge.ItemSpawnJob job : tile.itemSpawnJobs) {
/* 222 */           job.dropItems(worldIn);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 228 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public static class TileEntitySoulForge extends TileEntity implements net.minecraft.util.ITickable, emoniph.intangible.api.ISoulForge
/*     */   {
/*     */     public static final int MAX_TICKS = 100;
/*     */     public int activeTicks;
/*     */     public int counter;
/*     */     private static final double MAX_WELL_RANGE = 32.0D;
/*     */     private static final int PARTICLES_PER_BEAM = 30;
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 241 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public boolean isActive() {
/* 245 */       return this.field_145850_b.func_175640_z(this.field_174879_c);
/*     */     }
/*     */     
/*     */     public IInventoryItem requestItemFromInventory(ItemStack request)
/*     */     {
/* 250 */       Iterator<BlockPos> itr = this.inventoryPositions.iterator();
/* 251 */       while (itr.hasNext()) {
/* 252 */         BlockPos clientPos = (BlockPos)itr.next();
/* 253 */         IBlockState state = this.field_145850_b.func_180495_p(clientPos);
/* 254 */         ISoulForgeInventory client = getSoulForgeInventory(clientPos, state);
/* 255 */         if (client != null) {
/* 256 */           IInventoryItem item = client.requestItemFromInventory(this.field_145850_b, clientPos, state, request, this);
/* 257 */           if (item.getStackInSlot() != null) {
/* 258 */             return item;
/*     */           }
/*     */         } else {
/* 261 */           itr.remove();
/* 262 */           this.inventoryPositionSet.remove(clientPos);
/*     */         }
/*     */       }
/* 265 */       return new emoniph.intangible.util.InventoryItem.Empty();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public boolean requestSoulsForWork(ISoulSet souls, int cooldownTicks, World clientWorld, BlockPos clientPos)
/*     */     {
/* 273 */       BlockPos targetPos = this.field_174879_c.func_177981_b(2);
/* 274 */       return Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, souls, cooldownTicks, new Vec3(targetPos.func_177958_n() + 0.5D, targetPos.func_177956_o() + 0.9D, targetPos.func_177952_p() + 0.5D));
/*     */     }
/*     */     
/*     */     public boolean requestSoulsForConsumption(ISoulSet souls, World clientWorld, BlockPos clientPos)
/*     */     {
/* 279 */       BlockPos targetPos = clientPos;
/* 280 */       return Get.wells().consumeSouls(this.field_145850_b, this.field_174879_c, 16.0D, souls, new Vec3(targetPos.func_177958_n() + 0.5D, targetPos.func_177956_o() + 0.9D, targetPos.func_177952_p() + 0.5D));
/*     */     }
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
/*     */     private static class ItemSpawnJob
/*     */     {
/*     */       private final ItemStack stack;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       private final BlockPos pos;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       private final BlockPos spawnPos;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       private final BlockPos[] grid;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       private int counter;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       private final int beamTicks;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       public ItemSpawnJob(ItemStack stack, BlockPos pos, BlockPos spawnPos, BlockPos[] grid, int beamTicks)
/*     */       {
/* 354 */         this.stack = stack;
/* 355 */         this.pos = pos;
/* 356 */         this.spawnPos = spawnPos;
/* 357 */         this.grid = grid;
/* 358 */         this.beamTicks = beamTicks;
/*     */       }
/*     */       
/*     */       public void dropItems(World world) {
/* 362 */         if (!world.field_72995_K) {
/* 363 */           if (world.func_180495_p(this.spawnPos).func_177230_c() == Get.blocks().PLINTH) {
/* 364 */             BlockPlinth.TileEntityPlinth tile = (BlockPlinth.TileEntityPlinth)emoniph.intangible.util.BlockUtil.getTileEntity(world, this.spawnPos, BlockPlinth.TileEntityPlinth.class);
/* 365 */             if (tile != null) {
/* 366 */               ItemStack existing = tile.func_70301_a(0);
/* 367 */               if (existing == null) {
/* 368 */                 tile.func_70299_a(0, this.stack);
/* 369 */                 return; }
/* 370 */               if ((ItemStack.func_179545_c(this.stack, existing)) && 
/* 371 */                 (ItemStack.func_77970_a(this.stack, existing)) && 
/* 372 */                 (existing.field_77994_a + this.stack.field_77994_a <= this.stack.func_77976_d())) {
/* 373 */                 existing.field_77994_a += this.stack.field_77994_a;
/* 374 */                 world.func_175689_h(this.spawnPos);
/* 375 */                 return;
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 380 */           EntityItem entity = new EntityItem(world, this.spawnPos.func_177958_n() + 0.5D, this.spawnPos.func_177956_o() + 0.5D, this.spawnPos.func_177952_p() + 0.5D, this.stack);
/* 381 */           entity.field_70159_w = (entity.field_70179_y = 0.0D);
/* 382 */           entity.field_70181_x = 0.25D;
/* 383 */           world.func_72838_d(entity);
/*     */         }
/*     */       }
/*     */       
/*     */       public boolean tick(World world) {
/* 388 */         this.counter += 1;
/*     */         
/* 390 */         Vec3 target = new Vec3(this.spawnPos.func_177958_n() + 0.5D, this.spawnPos.func_177956_o() + 0.5D, this.spawnPos.func_177952_p() + 0.5D);
/*     */         
/* 392 */         if (this.counter == 18) {
/* 393 */           for (BlockPos source : this.grid) {
/* 394 */             if (source != null) {
/* 395 */               Get.fx().GLOW.sendToAllNear(world, source, 1.5F, 30, -4513127, 1, target, 0.05F, 16.0D);
/*     */             }
/*     */           }
/* 398 */         } else if ((this.counter % 3 == 0) && (this.counter < 18))
/*     */         {
/* 400 */           for (BlockPos source : this.grid) {
/* 401 */             if (source != null) {
/* 402 */               Get.fx().GLOW.sendToAllNear(world, source, 0.5F, 3, -6750055, 2, target, 0.2F, 16.0D);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 407 */         if (this.counter == 17 + this.beamTicks) {
/* 408 */           Get.fx().GLOW.sendToAllNear(world, this.spawnPos, 0.6F, 30, -6741402, 32, null, 0.0F, 16.0D);
/*     */           
/* 410 */           dropItems(world);
/* 411 */           return true;
/*     */         }
/*     */         
/* 414 */         return false;
/*     */       }
/*     */       
/*     */       public boolean isClientPos(BlockPos pos) {
/* 418 */         return this.pos.equals(pos);
/*     */       }
/*     */       
/*     */       public NBTTagCompound toTagCompound() {
/* 422 */         NBTTagCompound compound = new NBTTagCompound();
/* 423 */         compound.func_74782_a("item", this.stack.func_77955_b(new NBTTagCompound()));
/* 424 */         compound.func_74772_a("pos", this.pos.func_177986_g());
/* 425 */         compound.func_74772_a("spawnPos", this.spawnPos.func_177986_g());
/* 426 */         compound.func_74768_a("counter", this.counter);
/* 427 */         compound.func_74768_a("beam", this.beamTicks);
/* 428 */         NBTTagList list = new NBTTagList();
/* 429 */         for (BlockPos gridPos : this.grid) {
/* 430 */           if (gridPos != null) {
/* 431 */             list.func_74742_a(new NBTTagLong(gridPos.func_177986_g()));
/*     */           }
/*     */         }
/* 434 */         compound.func_74782_a("grid", list);
/* 435 */         return compound;
/*     */       }
/*     */       
/*     */       public static ItemSpawnJob fromTagCompound(NBTTagCompound compound) {
/* 439 */         if ((compound.func_150297_b("item", 10)) && 
/* 440 */           (compound.func_150297_b("pos", 4)) && 
/* 441 */           (compound.func_150297_b("spawnPos", 4)) && 
/* 442 */           (compound.func_150297_b("grid", 9)) && 
/* 443 */           (compound.func_150297_b("beam", 3)) && 
/* 444 */           (compound.func_150297_b("counter", 3))) {
/* 445 */           ItemStack stack = ItemStack.func_77949_a(compound.func_74775_l("item"));
/* 446 */           BlockPos pos = BlockPos.func_177969_a(compound.func_74763_f("pos"));
/* 447 */           BlockPos spawnPos = BlockPos.func_177969_a(compound.func_74763_f("spawnPos"));
/* 448 */           NBTTagList list = compound.func_150295_c("grid", 4);
/* 449 */           List<BlockPos> positions = new ArrayList();
/* 450 */           int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 451 */             positions.add(BlockPos.func_177969_a(((NBTTagLong)list.func_179238_g(i)).func_150291_c()));
/*     */           }
/*     */           
/* 454 */           int beamTicks = compound.func_74762_e("beam");
/* 455 */           ItemSpawnJob job = new ItemSpawnJob(stack, pos, spawnPos, (BlockPos[])positions.toArray(new BlockPos[positions.size()]), beamTicks);
/* 456 */           job.counter = compound.func_74762_e("counter");
/* 457 */           return job;
/*     */         }
/* 459 */         return null;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 466 */     Queue<ItemSpawnJob> itemSpawnJobs = new java.util.ArrayDeque();
/*     */     int workerIndex;
/*     */     
/*     */     public void spawnItemDramatically(ItemStack stack, BlockPos spawnPos, BlockPos[] sourceGrid, World clientWorld, BlockPos clientPos, int beamTicks) {
/* 470 */       this.itemSpawnJobs.add(new ItemSpawnJob(stack, clientPos, spawnPos, sourceGrid, beamTicks));
/*     */     }
/*     */     
/*     */     private ISoulForgeClient getSoulForgeClient(BlockPos clientPos, IBlockState state) {
/* 474 */       Block testBlock = state.func_177230_c();
/* 475 */       if ((testBlock instanceof ISoulForgeClient)) {
/* 476 */         ISoulForgeClient forgeClient = (ISoulForgeClient)testBlock;
/* 477 */         if (forgeClient.isForgeClientValid(this.field_145850_b, clientPos, state, this)) {
/* 478 */           return forgeClient;
/*     */         }
/*     */       }
/* 481 */       return null;
/*     */     }
/*     */     
/*     */     private ISoulForgeInventory getSoulForgeInventory(BlockPos clientPos, IBlockState state) {
/* 485 */       Block testBlock = state.func_177230_c();
/* 486 */       if ((testBlock instanceof ISoulForgeInventory)) {
/* 487 */         ISoulForgeInventory forgeClient = (ISoulForgeInventory)testBlock;
/* 488 */         if (forgeClient.isForgeInventoryValid(this.field_145850_b, clientPos, state, this)) {
/* 489 */           return forgeClient;
/*     */         }
/*     */       }
/* 492 */       return null;
/*     */     }
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 497 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 498 */       if (state.func_177230_c() != Get.blocks().SOUL_FORGE) {
/* 499 */         return;
/*     */       }
/*     */       
/*     */ 
/* 503 */       if (isActive()) {
/* 504 */         if (this.activeTicks == 100)
/*     */         {
/*     */ 
/* 507 */           if (!this.field_145850_b.field_72995_K) {
/* 508 */             int RANGE = 16;
/* 509 */             for (int i = 0; i < 50; i++) {
/* 510 */               BlockPos testPos = this.field_174879_c.func_177982_a(this.field_145850_b.field_73012_v
/* 511 */                 .nextInt(33) - 16, this.field_145850_b.field_73012_v
/* 512 */                 .nextInt(33) - 16, this.field_145850_b.field_73012_v
/* 513 */                 .nextInt(33) - 16);
/* 514 */               ISoulForgeClient forgeClient = getSoulForgeClient(testPos, this.field_145850_b.func_180495_p(testPos));
/* 515 */               if ((forgeClient != null) && (!this.clientPositionSet.contains(testPos))) {
/* 516 */                 this.clientPositions.add(testPos);
/* 517 */                 this.clientPositionSet.add(testPos);
/*     */               }
/*     */               
/* 520 */               ISoulForgeInventory forgeInventory = getSoulForgeInventory(testPos, this.field_145850_b.func_180495_p(testPos));
/* 521 */               if ((forgeInventory != null) && (!this.inventoryPositionSet.contains(testPos))) {
/* 522 */                 this.inventoryPositions.add(testPos);
/* 523 */                 this.inventoryPositionSet.add(testPos);
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 528 */           this.counter += 1;
/* 529 */           if (this.counter % 20 == 0)
/*     */           {
/* 531 */             if (this.field_145850_b.field_72995_K)
/*     */             {
/* 533 */               emoniph.intangible.Intangible.PROXY.glow(func_145831_w(), func_174877_v().func_177958_n() + 0.5D, func_174877_v().func_177956_o() + 1.2F, func_174877_v().func_177952_p() + 0.5D).motion(0.0D, 0.02D, 0.0D).scale(3.0F).color(10027263).durationScale(3.3F);
/*     */             }
/*     */           }
/*     */           
/* 537 */           if (this.counter % 10 == 0)
/*     */           {
/* 539 */             if ((!this.field_145850_b.field_72995_K) && (this.clientPositions.size() > 0)) {
/* 540 */               if (++this.workerIndex >= this.clientPositions.size()) {
/* 541 */                 this.workerIndex = 0;
/*     */               }
/* 543 */               BlockPos clientPos = (BlockPos)this.clientPositions.get(this.workerIndex);
/* 544 */               IBlockState clientState = this.field_145850_b.func_180495_p(clientPos);
/* 545 */               ISoulForgeClient forgeClient = getSoulForgeClient(clientPos, clientState);
/* 546 */               if (forgeClient != null) {
/* 547 */                 if ((forgeClient.isForgeClientActive(this.field_145850_b, clientPos, clientState, this)) && (!isClientBusy(clientPos)) && 
/* 548 */                   (forgeClient.forgeClientTick(this.field_145850_b, clientPos, clientState, this))) {
/* 549 */                   Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c.func_177981_b(2), 2.0F, 30, 4465254, 1, new Vec3(clientPos.func_177958_n() + 0.5D, clientPos.func_177956_o() + 1, clientPos.func_177952_p() + 0.5D), 0.5F, 32.0D);
/*     */                 }
/*     */               }
/*     */               else {
/* 553 */                 removeClientAtWorkerIndex();
/*     */               }
/*     */             }
/*     */             
/* 557 */             if ((!this.itemSpawnJobs.isEmpty()) && 
/* 558 */               (((ItemSpawnJob)this.itemSpawnJobs.element()).tick(this.field_145850_b))) {
/* 559 */               this.itemSpawnJobs.remove();
/*     */             }
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 565 */           this.activeTicks = Math.min(this.activeTicks + 1, 100);
/*     */         }
/* 567 */       } else if (this.activeTicks > 0) {
/* 568 */         this.activeTicks -= 1;
/*     */       }
/*     */     }
/*     */     
/*     */     private void removeClientAtWorkerIndex()
/*     */     {
/* 574 */       if ((this.workerIndex >= 0) && (this.workerIndex < this.clientPositions.size())) {
/* 575 */         BlockPos pos = (BlockPos)this.clientPositions.get(this.workerIndex);
/* 576 */         this.clientPositions.remove(this.workerIndex);
/* 577 */         this.clientPositionSet.remove(pos);
/* 578 */         if (--this.workerIndex < 0) {
/* 579 */           this.workerIndex = 0;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private boolean isClientBusy(BlockPos clientPos) {
/* 585 */       for (ItemSpawnJob job : this.itemSpawnJobs) {
/* 586 */         if (job.isClientPos(clientPos)) {
/* 587 */           return true;
/*     */         }
/*     */       }
/* 590 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 594 */     private final List<BlockPos> clientPositions = new ArrayList();
/* 595 */     private final Set<BlockPos> clientPositionSet = new java.util.HashSet();
/* 596 */     private final List<BlockPos> inventoryPositions = new ArrayList();
/* 597 */     private final Set<BlockPos> inventoryPositionSet = new java.util.HashSet();
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 601 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 602 */       writeCommonFromNBT(nbtTag);
/* 603 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(net.minecraft.network.NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 608 */       super.onDataPacket(net, packet);
/* 609 */       readCommonFromNBT(packet.func_148857_g());
/* 610 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 615 */       super.func_145839_a(compound);
/* 616 */       readCommonFromNBT(compound);
/* 617 */       this.clientPositions.clear();
/* 618 */       this.clientPositionSet.clear();
/* 619 */       if (compound.func_150297_b("clients", 9)) {
/* 620 */         NBTTagList list = compound.func_150295_c("clients", 4);
/* 621 */         int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 622 */           BlockPos clientPos = BlockPos.func_177969_a(((NBTTagLong)list.func_179238_g(i)).func_150291_c());
/* 623 */           this.clientPositions.add(clientPos);
/* 624 */           this.clientPositionSet.add(clientPos);
/*     */         }
/*     */       }
/*     */       
/* 628 */       this.inventoryPositions.clear();
/* 629 */       this.inventoryPositionSet.clear();
/* 630 */       if (compound.func_150297_b("inventories", 9)) {
/* 631 */         NBTTagList list = compound.func_150295_c("inventories", 4);
/* 632 */         int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 633 */           BlockPos clientPos = BlockPos.func_177969_a(((NBTTagLong)list.func_179238_g(i)).func_150291_c());
/* 634 */           this.inventoryPositions.add(clientPos);
/* 635 */           this.inventoryPositionSet.add(clientPos);
/*     */         }
/*     */       }
/*     */       
/* 639 */       this.itemSpawnJobs.clear();
/* 640 */       if (compound.func_150297_b("itemSpawns", 9)) {
/* 641 */         NBTTagList list = compound.func_150295_c("itemSpawns", 10);
/* 642 */         int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 643 */           ItemSpawnJob job = ItemSpawnJob.fromTagCompound(list.func_150305_b(i));
/* 644 */           if (job != null) {
/* 645 */             this.itemSpawnJobs.offer(job);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private void readCommonFromNBT(NBTTagCompound compound) {
/* 652 */       this.activeTicks = compound.func_74762_e("startTicks");
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 657 */       super.func_145841_b(compound);
/* 658 */       writeCommonFromNBT(compound);
/* 659 */       NBTTagList list = new NBTTagList();
/* 660 */       for (BlockPos clientPos : this.clientPositions) {
/* 661 */         list.func_74742_a(new NBTTagLong(clientPos.func_177986_g()));
/*     */       }
/* 663 */       compound.func_74782_a("clients", list);
/*     */       
/* 665 */       list = new NBTTagList();
/* 666 */       for (BlockPos clientPos : this.inventoryPositions) {
/* 667 */         list.func_74742_a(new NBTTagLong(clientPos.func_177986_g()));
/*     */       }
/* 669 */       compound.func_74782_a("inventories", list);
/*     */       
/* 671 */       list = new NBTTagList();
/* 672 */       for (ItemSpawnJob itemSpawn : this.itemSpawnJobs) {
/* 673 */         list.func_74742_a(itemSpawn.toTagCompound());
/*     */       }
/* 675 */       compound.func_74782_a("itemSpawns", list);
/*     */     }
/*     */     
/*     */     private void writeCommonFromNBT(NBTTagCompound compound) {
/* 679 */       compound.func_74768_a("startTicks", this.activeTicks);
/*     */     }
/*     */     
/*     */     @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 685 */       return new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(2, 3, 2));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockSoulForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */