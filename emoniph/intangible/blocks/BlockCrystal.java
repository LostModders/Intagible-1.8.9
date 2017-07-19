/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.Block.SoundType;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.PropertyEnum;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.IStringSerializable;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.EnumPlantType;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockCrystal extends BlockContainer implements IBlock, net.minecraft.block.IGrowable, net.minecraftforge.common.IPlantable, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  47 */     return 50;
/*     */   }
/*     */   
/*     */   public static enum Plane implements IStringSerializable {
/*  51 */     FLOOR("floor", 0), 
/*  52 */     WALL("wall", 1), 
/*  53 */     CEILING("ceiling", 2);
/*     */     
/*     */     private final String name;
/*     */     private final int index;
/*     */     
/*     */     private Plane(String name, int index) {
/*  59 */       this.name = name;
/*  60 */       this.index = index;
/*     */     }
/*     */     
/*     */     public String func_176610_l()
/*     */     {
/*  65 */       return this.name;
/*     */     }
/*     */     
/*  68 */     private static Plane[] INDICES = { FLOOR, WALL, CEILING };
/*     */     
/*     */     public static Plane fromIndex(int index) {
/*  71 */       return INDICES[Math.max(Math.min(index, INDICES.length), 0)];
/*     */     }
/*     */   }
/*     */   
/*  75 */   public static final PropertyEnum PLANE = new PropertyEnum("plane", Plane.class, com.google.common.collect.Lists.newArrayList(Plane.values())) {};
/*     */   
/*     */   BlockCrystal()
/*     */   {
/*  79 */     super(Material.field_151576_e);
/*  80 */     func_149711_c(2.0F);
/*  81 */     func_149752_b(10.0F);
/*  82 */     setupBounds();
/*  83 */     func_149649_H();
/*  84 */     func_149675_a(true);
/*  85 */     func_149672_a(SOUND_CRYSTAL);
/*     */   }
/*     */   
/*  88 */   private static final Block.SoundType SOUND_CRYSTAL = new Block.SoundType("intangible:crystal", 1.0F, 1.0F)
/*     */   {
/*     */     public float func_150494_d() {
/*  91 */       return 0.99F + new Random().nextFloat() * 0.15F;
/*     */     }
/*     */     
/*     */     public String func_150495_a()
/*     */     {
/*  96 */       return Sound.MOD_RANDOM_CLINK.LOCATION;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 101 */     public String func_150498_e() { return "step.stone"; }
/*     */   };
/*     */   private static final int MAX_STAGE = 5;
/*     */   
/*     */   public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
/* 106 */     switch (facing) {
/*     */     case UP: 
/* 108 */       return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, placer.func_174811_aO()).func_177226_a(PLANE, Plane.FLOOR);
/*     */     case DOWN: 
/* 110 */       return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, placer.func_174811_aO()).func_177226_a(PLANE, Plane.CEILING);
/*     */     }
/* 112 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, facing.func_176734_d()).func_177226_a(PLANE, Plane.WALL);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 118 */     TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 119 */     if ((crystal != null) && 
/* 120 */       (crystal.variant == 0)) {
/* 121 */       crystal.generateVariant(worldIn, worldIn.field_73012_v);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 129 */     ItemStack stack = playerIn.func_70694_bm();
/* 130 */     if ((stack != null) && (stack.func_77973_b() == net.minecraft.init.Items.field_151100_aR)) {
/* 131 */       TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 132 */       if (crystal != null) {
/* 133 */         int[] aint = new int[3];
/* 134 */         int i = 0;int j = 0;
/* 135 */         int l = crystal.color;
/* 136 */         float f = (l >> 16 & 0xFF) / 255.0F;
/* 137 */         float f1 = (l >> 8 & 0xFF) / 255.0F;
/* 138 */         float f2 = (l & 0xFF) / 255.0F;
/* 139 */         i = (int)(i + Math.max(f, Math.max(f1, f2)) * 255.0F);
/* 140 */         aint[0] = ((int)(aint[0] + f * 255.0F));
/* 141 */         aint[1] = ((int)(aint[1] + f1 * 255.0F));
/* 142 */         aint[2] = ((int)(aint[2] + f2 * 255.0F));
/* 143 */         j++;
/*     */         
/* 145 */         float[] afloat = net.minecraft.entity.passive.EntitySheep.func_175513_a(net.minecraft.item.EnumDyeColor.func_176766_a(stack.func_77960_j()));
/* 146 */         int j1 = (int)(afloat[0] * 255.0F);
/* 147 */         int k1 = (int)(afloat[1] * 255.0F);
/* 148 */         int l1 = (int)(afloat[2] * 255.0F);
/* 149 */         i += Math.max(j1, Math.max(k1, l1));
/* 150 */         aint[0] += j1;
/* 151 */         aint[1] += k1;
/* 152 */         aint[2] += l1;
/* 153 */         j++;
/*     */         
/* 155 */         int k = aint[0] / j;
/* 156 */         int i1 = aint[1] / j;
/* 157 */         l = aint[2] / j;
/* 158 */         f = i / j;
/* 159 */         f1 = Math.max(k, Math.max(i1, l));
/* 160 */         k = (int)(k * f / f1);
/* 161 */         i1 = (int)(i1 * f / f1);
/* 162 */         l = (int)(l * f / f1);
/* 163 */         l1 = (k << 8) + i1;
/* 164 */         l1 = (l1 << 8) + l;
/* 165 */         crystal.color = l1;
/* 166 */         if (!worldIn.field_72995_K) {
/* 167 */           worldIn.func_175689_h(pos);
/*     */         }
/* 169 */         return true;
/*     */       }
/* 171 */     } else { if ((stack != null) && (stack.func_77973_b() == Item.func_150898_a(Get.blocks().CRYSTAL)) && (playerIn.field_71075_bZ.field_75098_d)) {
/* 172 */         if (!worldIn.field_72995_K) {
/* 173 */           if (func_176473_a(worldIn, pos, state, worldIn.field_72995_K)) {
/* 174 */             func_176474_b(worldIn, worldIn.field_73012_v, pos, state);
/*     */           }
/*     */           
/* 177 */           if (!playerIn.field_71075_bZ.field_75098_d) {
/* 178 */             if (--stack.field_77994_a == 0) {
/* 179 */               playerIn.func_70062_b(0, null);
/*     */             }
/*     */           }
/* 182 */           worldIn.func_175689_h(pos);
/*     */         }
/* 184 */         return true;
/*     */       }
/* 186 */       TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 187 */       if ((crystal != null) && (crystal.getGrowthStage() == 5)) {
/* 188 */         if (!worldIn.field_72995_K) {
/* 189 */           Sound.MOD_RANDOM_CLINK.playToAllNear(crystal, 0.5F, 0.99F + worldIn.field_73012_v.nextFloat() * 0.15F);
/*     */         }
/* 191 */         return true;
/*     */       }
/*     */     }
/*     */     
/* 195 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand)
/*     */   {
/* 201 */     if (canPlaceOn(worldIn, below(worldIn, pos, state))) {
/* 202 */       TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 203 */       if (crystal != null) {
/* 204 */         int stage = crystal.getGrowthStage();
/*     */         
/* 206 */         if (stage < 5) {
/* 207 */           EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 208 */           float f = getGrowthChance(worldIn, pos, state);
/*     */           
/* 210 */           if (rand.nextInt((int)(25.0F / f) + 1) == 0) {
/* 211 */             func_176474_b(worldIn, rand, pos, state);
/*     */           }
/*     */         }
/*     */       }
/*     */     } else {
/* 216 */       checkAndDropBlock(worldIn, pos, state);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
/* 221 */     super.func_176204_a(worldIn, pos, state, neighborBlock);
/* 222 */     checkAndDropBlock(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   protected void checkAndDropBlock(World worldIn, BlockPos pos, IBlockState state) {
/* 226 */     if (!canPlaceOn(worldIn, below(worldIn, pos, state))) {
/* 227 */       func_176226_b(worldIn, pos, state, 0);
/* 228 */       worldIn.func_180501_a(pos, net.minecraft.init.Blocks.field_150350_a.func_176223_P(), 3);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 233 */     if (player.field_71075_bZ.field_75098_d) {
/* 234 */       TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 235 */       if (crystal != null) {
/* 236 */         crystal.noHarvest = true;
/*     */       }
/*     */     }
/* 239 */     func_176226_b(worldIn, pos, state, net.minecraft.enchantment.EnchantmentHelper.func_77517_e(player));
/*     */     
/* 241 */     if ((!worldIn.field_72995_K) && (!(player instanceof net.minecraftforge.common.util.FakePlayer))) {
/* 242 */       PlayerEx playerEx = PlayerEx.get(player);
/* 243 */       if (playerEx != null) { if (!playerEx.isKnowledgeLearnt(new IKnol[] { Get.knowledge().MAT_CRYSTAL })) {
/* 244 */           playerEx.learnKnowledge(BlockUtil.midBlockToVec3(pos), new IKnol[] { Get.knowledge().MAT_CRYSTAL });
/*     */         }
/*     */       }
/*     */     }
/* 248 */     super.func_176208_a(worldIn, pos, state, player);
/*     */   }
/*     */   
/*     */   public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
/*     */   {
/* 253 */     List<ItemStack> list = new ArrayList();
/* 254 */     Random rand = new Random();
/* 255 */     if (world.func_180495_p(pos).func_177230_c() == this) {
/* 256 */       boolean noHarvest = false;
/*     */       
/* 258 */       TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(world, pos, TileEntityCrystal.class);
/* 259 */       if (crystal != null) {
/* 260 */         if (crystal.noHarvest) {
/* 261 */           noHarvest = true;
/*     */         } else {
/* 263 */           int growth = crystal.getGrowthStage();
/* 264 */           if (growth == 5) {
/* 265 */             if (crystal.isRare()) {
/* 266 */               list.add(new ItemStack(Get.items().SHARD));
/*     */             } else {
/* 268 */               list.add(new ItemStack(this));
/*     */             }
/* 270 */             if (crystal.fullGrowth) {
/* 271 */               noHarvest = true;
/*     */             }
/* 273 */           } else if (crystal.fullGrowth) {
/* 274 */             noHarvest = true;
/*     */           }
/*     */           
/* 277 */           if (!noHarvest) {
/* 278 */             double baseChance = 0.0D;
/* 279 */             switch (growth) {
/*     */             case 5: 
/* 281 */               baseChance = 0.2D + fortune * 0.1D;
/* 282 */               break;
/*     */             case 4: 
/* 284 */               baseChance = 0.02D + fortune * 0.02D;
/* 285 */               break;
/*     */             case 3: 
/* 287 */               baseChance = 0.005D + fortune * 0.01D;
/*     */             }
/*     */             
/* 290 */             if (rand.nextDouble() < baseChance) {
/* 291 */               list.add(new ItemStack(this));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 296 */       if ((!noHarvest) && (
/* 297 */         (list.size() == 0) || (rand.nextDouble() < 0.75D + fortune * 0.05D))) {
/* 298 */         list.add(new ItemStack(this));
/*     */       }
/*     */     }
/*     */     
/* 302 */     return list;
/*     */   }
/*     */   
/*     */   protected float getGrowthChance(World worldIn, BlockPos pos, IBlockState state) {
/* 306 */     float f = 1.0F;
/* 307 */     BlockPos belowPos = below(worldIn, pos, state);
/* 308 */     boolean diffx = belowPos.func_177958_n() != pos.func_177958_n();
/* 309 */     boolean diffy = belowPos.func_177956_o() != pos.func_177956_o();
/* 310 */     boolean diffz = belowPos.func_177952_p() != pos.func_177952_p();
/*     */     
/* 312 */     IBlockState iblockstate = null;
/* 313 */     for (int i = -1; i <= 1; i++) {
/* 314 */       for (int j = -1; j <= 1; j++) {
/* 315 */         float f1 = 0.0F;
/*     */         
/* 317 */         if (diffx) {
/* 318 */           iblockstate = worldIn.func_180495_p(belowPos.func_177982_a(0, i, j));
/* 319 */         } else if (diffz) {
/* 320 */           iblockstate = worldIn.func_180495_p(belowPos.func_177982_a(i, j, 0));
/*     */         } else {
/* 322 */           iblockstate = worldIn.func_180495_p(belowPos.func_177982_a(i, 0, j));
/*     */         }
/*     */         
/* 325 */         if (iblockstate.func_177230_c().func_149688_o().func_76220_a()) {
/* 326 */           f1 = 1.0F;
/*     */           
/* 328 */           if (iblockstate.func_177230_c().func_149688_o() == Material.field_151576_e) {
/* 329 */             f1 = 3.0F;
/*     */           }
/*     */         }
/*     */         
/* 333 */         if ((i != 0) || (j != 0)) {
/* 334 */           f1 /= 4.0F;
/*     */         }
/*     */         
/* 337 */         f += f1;
/*     */       }
/*     */     }
/*     */     boolean slow;
/*     */     boolean slow;
/* 342 */     if (diffx)
/*     */     {
/*     */ 
/*     */ 
/* 346 */       slow = (worldIn.func_180495_p(pos.func_177982_a(0, 1, 0)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(0, 0, 1)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(0, -1, 0)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(0, 0, -1)).func_177230_c() == this); } else { boolean slow;
/* 347 */       if (diffz)
/*     */       {
/*     */ 
/*     */ 
/* 351 */         slow = (worldIn.func_180495_p(pos.func_177982_a(1, 0, 0)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(0, 1, 0)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(-1, 0, 0)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(0, -1, 0)).func_177230_c() == this);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 357 */         slow = (worldIn.func_180495_p(pos.func_177982_a(1, 0, 0)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(0, 0, 1)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(-1, 0, 0)).func_177230_c() == this) || (worldIn.func_180495_p(pos.func_177982_a(0, 0, -1)).func_177230_c() == this);
/*     */       }
/*     */     }
/* 360 */     if (slow) {
/* 361 */       f /= 2.0F;
/*     */     }
/*     */     
/* 364 */     return f;
/*     */   }
/*     */   
/*     */   public boolean func_176198_a(World worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 369 */     return canPlaceOn(worldIn, pos.func_177972_a(side.func_176734_d()));
/*     */   }
/*     */   
/*     */   private BlockPos below(World worldIn, BlockPos pos, IBlockState state) {
/* 373 */     Plane plane = (Plane)state.func_177229_b(PLANE);
/* 374 */     switch (plane) {
/*     */     case FLOOR: 
/* 376 */       return pos.func_177977_b();
/*     */     case CEILING: 
/* 378 */       return pos.func_177984_a();
/*     */     }
/* 380 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 381 */     return pos.func_177972_a(facing);
/*     */   }
/*     */   
/*     */   private boolean canPlaceOn(World worldIn, BlockPos pos)
/*     */   {
/* 386 */     IBlockState otherState = worldIn.func_180495_p(pos);
/* 387 */     Material material = otherState.func_177230_c().func_149688_o();
/* 388 */     return (material.func_76220_a()) && (otherState.func_177230_c().func_149662_c());
/*     */   }
/*     */   
/*     */   public boolean func_176196_c(World worldIn, BlockPos pos)
/*     */   {
/* 393 */     return canPlaceOn(worldIn, pos);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/* 398 */     return new TileEntityCrystal();
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/* 403 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/* 408 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/* 413 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 419 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_180646_a(World worldIn, BlockPos pos)
/*     */   {
/* 424 */     return getBoundingBox(worldIn, pos, worldIn.func_180495_p(pos));
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 429 */     return getBoundingBox(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private AxisAlignedBB getBoundingBox(World worldIn, BlockPos pos, IBlockState state) {
/* 433 */     Plane plane = (Plane)state.func_177229_b(PLANE);
/* 434 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 435 */     float radius = 0.2F;
/* 436 */     TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 437 */     float height = crystal.getGrowthStage() == 1 ? 0.3F : (crystal == null) || (crystal.getGrowthStage() == 0) ? 0.2F : 1.0F;
/*     */     
/* 439 */     switch (plane) {
/*     */     case CEILING: 
/* 441 */       return getBlockBounds(pos, 0.0F + radius, 1.0F - height, 0.0F + radius, 1.0F - radius, 1.0F, 1.0F - radius);
/*     */     case WALL: 
/* 443 */       switch (facing) {
/*     */       case NORTH: 
/* 445 */         return getBlockBounds(pos, 0.0F + radius, 0.0F + radius, 0.0F, 1.0F - radius, 1.0F - radius, height);
/*     */       case SOUTH: 
/* 447 */         return getBlockBounds(pos, 0.0F + radius, 0.0F + radius, 1.0F - height, 1.0F - radius, 1.0F - radius, 1.0F);
/*     */       case EAST: 
/* 449 */         return getBlockBounds(pos, 1.0F - height, 0.0F + radius, 0.0F + radius, 1.0F, 1.0F - radius, 1.0F - radius);
/*     */       case WEST: 
/* 451 */         return getBlockBounds(pos, 0.0F, 0.0F + radius, 0.0F + radius, height, 1.0F - radius, 1.0F - radius);
/*     */       }
/*     */       break;
/*     */     }
/* 455 */     return getBlockBounds(pos, 0.0F + radius, 0.0F, 0.0F + radius, 1.0F - radius, height, 1.0F - radius);
/*     */   }
/*     */   
/*     */   private AxisAlignedBB getBlockBounds(BlockPos pos, float x1, float y1, float z1, float x2, float y2, float z2)
/*     */   {
/* 460 */     return new AxisAlignedBB(pos.func_177958_n() + x1, pos.func_177956_o() + y1, pos.func_177952_p() + z1, pos.func_177958_n() + x2, pos.func_177956_o() + y2, pos.func_177952_p() + z2);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180654_a(IBlockAccess worldIn, BlockPos pos)
/*     */   {
/* 466 */     super.func_180654_a(worldIn, pos);
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
/*     */ 
/*     */ 
/*     */   private void setupBounds()
/*     */   {
/* 501 */     float radius = 0.2F;
/* 502 */     func_149676_a(0.0F + radius, 0.0F, 0.0F + radius, 1.0F - radius, 0.8F, 1.0F - radius);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/* 508 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 513 */     EnumFacing enumfacing = EnumFacing.func_176731_b(meta & 0x3);
/* 514 */     int index = meta >> 2;
/* 515 */     Plane plane = Plane.fromIndex(index & 0x3);
/* 516 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, enumfacing).func_177226_a(PLANE, plane);
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 521 */     if (state.func_177230_c() == this) {
/* 522 */       int face = ((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N)).func_176736_b();
/* 523 */       int plane = ((Plane)state.func_177229_b(PLANE)).index;
/*     */       
/* 525 */       int meta = plane << 2 | face;
/* 526 */       return meta;
/*     */     }
/* 528 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   protected BlockState func_180661_e()
/*     */   {
/* 534 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { BlockDirectional.field_176387_N, PLANE });
/*     */   }
/*     */   
/*     */   public boolean func_176473_a(World worldIn, BlockPos pos, IBlockState state, boolean isClient)
/*     */   {
/* 539 */     TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 540 */     if (crystal != null) {
/* 541 */       return crystal.getGrowthStage() < 5;
/*     */     }
/* 543 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_180670_a(World worldIn, Random rand, BlockPos pos, IBlockState state)
/*     */   {
/* 550 */     return false;
/*     */   }
/*     */   
/*     */   public void func_176474_b(World worldIn, Random rand, BlockPos pos, IBlockState state)
/*     */   {
/* 555 */     TileEntityCrystal crystal = (TileEntityCrystal)BlockUtil.getTileEntity(worldIn, pos, TileEntityCrystal.class);
/* 556 */     if (crystal != null) {
/* 557 */       crystal.incrementGrowth();
/* 558 */       Sound.MOD_RANDOM_CLINK.playToAllNear(crystal, 0.5F, 0.99F + rand.nextFloat() * 0.15F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos)
/*     */   {
/* 565 */     return EnumPlantType.Cave;
/*     */   }
/*     */   
/*     */   public IBlockState getPlant(IBlockAccess world, BlockPos pos)
/*     */   {
/* 570 */     IBlockState state = world.func_180495_p(pos);
/* 571 */     if (state.func_177230_c() != this) {
/* 572 */       return func_176223_P();
/*     */     }
/* 574 */     return state;
/*     */   }
/*     */   
/*     */   public static class TileEntityCrystal extends TileEntity {
/*     */     private int growthStage;
/*     */     private int color;
/*     */     private int rareColor;
/*     */     private int variant;
/*     */     private boolean rare;
/*     */     public boolean noHarvest;
/*     */     private boolean fullGrowth;
/*     */     private long lastGrowthTime;
/*     */     public static final int MAX_GROWTH_TICKS = 50;
/*     */     
/* 588 */     public TileEntityCrystal() { this.color = 26265; }
/*     */     
/*     */     public void setColor(int color)
/*     */     {
/* 592 */       if (!this.field_145850_b.field_72995_K) {
/* 593 */         this.color = color;
/* 594 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public int getGrowthStage() {
/* 599 */       return this.growthStage;
/*     */     }
/*     */     
/*     */     public int getColor() {
/* 603 */       return this.color;
/*     */     }
/*     */     
/*     */     public int getRareColor() {
/* 607 */       return this.rareColor;
/*     */     }
/*     */     
/*     */     public boolean isRare() {
/* 611 */       return this.rare;
/*     */     }
/*     */     
/*     */     public void incrementGrowth() {
/* 615 */       if ((!this.field_145850_b.field_72995_K) && 
/* 616 */         (this.growthStage < 5)) {
/* 617 */         this.growthStage += 1;
/* 618 */         this.lastGrowthTime = this.field_145850_b.func_82737_E();
/* 619 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getGrowthTicks()
/*     */     {
/* 627 */       return Math.max(Math.min((int)(this.field_145850_b.func_82737_E() - this.lastGrowthTime), 50), 1);
/*     */     }
/*     */     
/*     */     public int getVariant() {
/* 631 */       return this.variant;
/*     */     }
/*     */     
/*     */     public void generateVariant(World worldIn, Random rand) {
/* 635 */       if ((worldIn != null) && (!worldIn.field_72995_K)) {
/* 636 */         this.variant = (rand.nextInt(5) + 1);
/* 637 */         this.rare = (rand.nextDouble() < 0.1D);
/* 638 */         this.color = RenderUtil.makeColor(0 + rand.nextInt(64), 0 + rand.nextInt(64), 153 - rand.nextInt(32));
/* 639 */         this.rareColor = RenderUtil.makeColor(153 - rand.nextInt(32), 80 + rand.nextInt(32), 0 + rand.nextInt(64));
/* 640 */         worldIn.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 646 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 651 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 652 */       func_145841_b(nbtTag);
/* 653 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 658 */       super.onDataPacket(net, packet);
/* 659 */       func_145839_a(packet.func_148857_g());
/* 660 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 665 */       super.func_145839_a(compound);
/* 666 */       this.growthStage = compound.func_74762_e("growth");
/* 667 */       this.color = compound.func_74762_e("color");
/* 668 */       this.variant = compound.func_74762_e("variant");
/* 669 */       this.rareColor = compound.func_74762_e("rareColor");
/* 670 */       this.rare = compound.func_74767_n("rare");
/* 671 */       this.fullGrowth = compound.func_74767_n("fullGrowth");
/* 672 */       this.lastGrowthTime = compound.func_74763_f("lastGrowthTime");
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 677 */       super.func_145841_b(compound);
/* 678 */       compound.func_74768_a("growth", this.growthStage);
/* 679 */       compound.func_74768_a("color", this.color);
/* 680 */       compound.func_74768_a("rareColor", this.rareColor);
/* 681 */       compound.func_74768_a("variant", this.variant);
/* 682 */       compound.func_74757_a("rare", this.rare);
/* 683 */       compound.func_74757_a("fullGrowth", this.fullGrowth);
/* 684 */       compound.func_74772_a("lastGrowthTime", this.lastGrowthTime);
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 690 */       return super.getRenderBoundingBox();
/*     */     }
/*     */     
/*     */     public void requiresFullGrowth() {
/* 694 */       this.fullGrowth = true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */