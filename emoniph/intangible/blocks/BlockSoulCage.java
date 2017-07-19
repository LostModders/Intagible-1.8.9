/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IBookPageResources;
/*     */ import emoniph.intangible.api.IInventoryItem;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.ISoulForge;
/*     */ import emoniph.intangible.api.ISoulForgeClient;
/*     */ import emoniph.intangible.api.ISoulForgeItemSource;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntityRaisingBlock;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.knowledge.PageResources;
/*     */ import emoniph.intangible.recipes.ModRecipes;
/*     */ import emoniph.intangible.recipes.SoulRecipe;
/*     */ import emoniph.intangible.recipes.SoulRecipeManager;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.EnumDiagonalFacing;
/*     */ import emoniph.intangible.util.InventoryItem;
/*     */ import emoniph.intangible.util.InventoryItem.Empty;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.IGrowable;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.PropertyEnum;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityFallingBlock;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.ISidedInventory;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.CraftingManager;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.common.util.FakePlayerFactory;
/*     */ 
/*     */ public class BlockSoulCage extends Block implements IBlock, IBlockWithVariants, ISoulForgeClient, emoniph.intangible.api.ISoulForgeInventory, emoniph.intangible.items.ICreativeSort
/*     */ {
/*  52 */   private static final VariantBlockData[] VARIANTS = { new VariantBlockData(EnumSoulType.NOBLE
/*  53 */     .getUnlocalizedName(), EnumSoulType.NOBLE.getMetadata()), new VariantBlockData(EnumSoulType.BENIGN
/*  54 */     .getUnlocalizedName(), EnumSoulType.BENIGN.getMetadata()), new VariantBlockData(EnumSoulType.IMMUTABLE
/*  55 */     .getUnlocalizedName(), EnumSoulType.IMMUTABLE.getMetadata()), new VariantBlockData(EnumSoulType.PREDATORY
/*  56 */     .getUnlocalizedName(), EnumSoulType.PREDATORY.getMetadata()), new VariantBlockData(EnumSoulType.DOOMED
/*  57 */     .getUnlocalizedName(), EnumSoulType.DOOMED.getMetadata()), new VariantBlockData(EnumSoulType.UNHINGED
/*  58 */     .getUnlocalizedName(), EnumSoulType.UNHINGED.getMetadata()), new VariantBlockData(EnumSoulType.MALLEABLE
/*  59 */     .getUnlocalizedName(), EnumSoulType.MALLEABLE.getMetadata()), new VariantBlockData(EnumSoulType.WISE
/*  60 */     .getUnlocalizedName(), EnumSoulType.WISE.getMetadata()) };
/*     */   
/*     */ 
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  65 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   public VariantBlockData[] getVariants()
/*     */   {
/*  70 */     return VARIANTS;
/*     */   }
/*     */   
/*     */   public String getUnlocalizedName(ItemStack stack)
/*     */   {
/*  75 */     return super.func_149739_a() + "_" + EnumSoulType.byMetadata(stack.func_77960_j()).getUnlocalizedName();
/*     */   }
/*     */   
/*  78 */   public static final PropertyEnum VARIANT = PropertyEnum.func_177709_a("variant", EnumSoulType.class);
/*     */   
/*     */   BlockSoulCage() {
/*  81 */     super(Material.field_151576_e);
/*  82 */     func_149711_c(3.0F);
/*  83 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(VARIANT, EnumSoulType.BENIGN));
/*     */   }
/*     */   
/*     */   public int func_180651_a(IBlockState state)
/*     */   {
/*  88 */     return ((EnumSoulType)state.func_177229_b(VARIANT)).getMetadata();
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/*  93 */     return ((EnumSoulType)state.func_177229_b(VARIANT)).getMetadata();
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/*  98 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { VARIANT });
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 103 */     return func_176223_P().func_177226_a(VARIANT, EnumSoulType.byMetadata(meta));
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 108 */     switch ((EnumSoulType)state.func_177229_b(VARIANT)) {
/*     */     case BENIGN: 
/* 110 */       tryFormWellStructure(worldIn, findWellStructure(worldIn, pos, state, null, false), state);
/* 111 */       break;
/*     */     case IMMUTABLE: 
/*     */     case MALLEABLE: 
/* 114 */       tryFormFabricatorStructure(worldIn, findFabricatorStructure(worldIn, pos, state), state);
/*     */     }
/*     */   }
/*     */   
/*     */   private BlockPos findFabricatorStructure(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 120 */     EnumSoulType soul = (EnumSoulType)state.func_177229_b(VARIANT);
/* 121 */     BlockPos forgePos = null;
/* 122 */     Object localObject1; int i; if (soul == EnumSoulType.MALLEABLE) {
/* 123 */       localObject1 = EnumFacing.field_176754_o;i = localObject1.length; for (localObject2 = 0; localObject2 < i; localObject2++) { EnumFacing face = localObject1[localObject2];
/* 124 */         BlockPos tPos = pos.func_177972_a(face);
/* 125 */         for (int i = 0; (i <= 2) && (forgePos == null); i++) {
/* 126 */           if (worldIn.func_180495_p(tPos.func_177979_c(i)).func_177230_c() == Get.blocks().SOUL_FORGE) {
/* 127 */             BlockSoulForge.TileEntitySoulForge tile = (BlockSoulForge.TileEntitySoulForge)BlockUtil.getTileEntity(worldIn, tPos.func_177979_c(i), BlockSoulForge.TileEntitySoulForge.class);
/* 128 */             forgePos = tile != null ? tile.func_174877_v() : null;
/*     */           }
/*     */         }
/* 131 */         if (forgePos != null) {
/*     */           break;
/*     */         }
/*     */       }
/* 135 */     } else if (soul == EnumSoulType.IMMUTABLE) {
/* 136 */       localObject1 = EnumDiagonalFacing.DIAGONALS;i = localObject1.length; for (localObject2 = 0; localObject2 < i; localObject2++) { face = localObject1[localObject2];
/* 137 */         BlockPos tPos = face.offset(pos);
/* 138 */         if (worldIn.func_180495_p(tPos).func_177230_c() == Get.blocks().SOUL_FORGE) {
/* 139 */           BlockSoulForge.TileEntitySoulForge tile = (BlockSoulForge.TileEntitySoulForge)BlockUtil.getTileEntity(worldIn, tPos, BlockSoulForge.TileEntitySoulForge.class);
/* 140 */           forgePos = tile != null ? tile.func_174877_v() : null;
/* 141 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 146 */     if (forgePos == null) {
/* 147 */       return null;
/*     */     }
/*     */     
/* 150 */     IBlockState malleable = func_176223_P().func_177226_a(VARIANT, EnumSoulType.MALLEABLE);
/* 151 */     EnumFacing[] arrayOfEnumFacing = EnumFacing.field_176754_o;Object localObject2 = arrayOfEnumFacing.length; for (EnumDiagonalFacing face = 0; face < localObject2; face++) { face = arrayOfEnumFacing[face];
/* 152 */       BlockPos tPos = forgePos.func_177972_a(face);
/* 153 */       for (int i = 0; i <= 4; i++) {
/* 154 */         if (worldIn.func_180495_p(tPos.func_177981_b(i)) != malleable) {
/* 155 */           return null;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 160 */     IBlockState immutable = func_176223_P().func_177226_a(VARIANT, EnumSoulType.IMMUTABLE);
/* 161 */     localObject2 = EnumDiagonalFacing.DIAGONALS;face = localObject2.length; for (EnumFacing face = 0; face < face; face++) { EnumDiagonalFacing face = localObject2[face];
/* 162 */       BlockPos tPos = face.offset(forgePos);
/* 163 */       for (int i = 0; i <= 2; i++) {
/* 164 */         if (worldIn.func_180495_p(tPos.func_177981_b(i)) != immutable) {
/* 165 */           return null;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 170 */     return forgePos;
/*     */   }
/*     */   
/*     */   private void tryFormFabricatorStructure(World worldIn, BlockPos pos, IBlockState state) {
/* 174 */     if ((pos != null) && (!worldIn.field_72995_K)) {
/* 175 */       for (int i = 0; i <= 4; i++) {
/* 176 */         worldIn.func_175698_g(pos.func_177981_b(i));
/*     */       }
/*     */       
/* 179 */       worldIn.func_180501_a(pos, Get.blocks().DEITY_BUILDER.func_176223_P().func_177226_a(BlockDeityBuilder.CORE, Boolean.valueOf(true)), 3);
/* 180 */       BlockDeityBuilder.TileEntityDeityBuilder tile = (BlockDeityBuilder.TileEntityDeityBuilder)BlockUtil.getTileEntity(worldIn, pos, BlockDeityBuilder.TileEntityDeityBuilder.class);
/*     */       
/* 182 */       if (tile != null) {
/* 183 */         for (EnumFacing face : EnumFacing.field_176754_o) {
/* 184 */           BlockPos tPos = pos.func_177972_a(face);
/* 185 */           for (int i = 0; i <= 4; i++) {
/* 186 */             BlockPos newPos = tPos.func_177981_b(i);
/* 187 */             worldIn.func_180501_a(newPos, Get.blocks().DEITY_BUILDER.func_176223_P().func_177226_a(BlockDeityBuilder.CORE, Boolean.valueOf(false)), 3);
/* 188 */             TileEntityVoid newTile = (TileEntityVoid)BlockUtil.getTileEntity(worldIn, newPos, TileEntityVoid.class);
/* 189 */             if (newTile != null) {
/* 190 */               newTile.setOwner(tile);
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 195 */         for (EnumDiagonalFacing face : EnumDiagonalFacing.DIAGONALS) {
/* 196 */           BlockPos tPos = face.offset(pos);
/* 197 */           for (int i = 0; i <= 2; i++) {
/* 198 */             BlockPos newPos = tPos.func_177981_b(i);
/* 199 */             worldIn.func_180501_a(newPos, Get.blocks().DEITY_BUILDER.func_176223_P().func_177226_a(BlockDeityBuilder.CORE, Boolean.valueOf(false)), 3);
/* 200 */             TileEntityVoid newTile = (TileEntityVoid)BlockUtil.getTileEntity(worldIn, newPos, TileEntityVoid.class);
/* 201 */             if (newTile != null) {
/* 202 */               newTile.setOwner(tile);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 213 */     if (!worldIn.field_72995_K) {
/* 214 */       switch ((EnumSoulType)state.func_177229_b(VARIANT)) {
/*     */       case BENIGN: 
/* 216 */         tryDissolveWellStructure(worldIn, findWellStructure(worldIn, pos, state, pos, true), state);
/* 217 */         break;
/*     */       }
/*     */       
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 224 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private void tryFormWellStructure(World worldIn, BlockPos pos, IBlockState state) {
/* 228 */     if (pos != null) {
/* 229 */       BlockPos wellPos = pos.func_177982_a(1, 0, 1);
/* 230 */       IBlockState well = Get.blocks().WELL_OF_SOULS.func_176223_P();
/* 231 */       for (int x = 0; x < 9; x++) {
/* 232 */         BlockPos newPos = wellPos.func_177982_a(x % 3, 0, x / 3);
/* 233 */         if (x != 4) {
/* 234 */           worldIn.func_175656_a(newPos, well);
/*     */         } else {
/* 236 */           worldIn.func_175656_a(newPos, Get.blocks().WELL_OF_SOULS_CORE.func_176223_P());
/*     */         }
/*     */       }
/*     */       
/* 240 */       BlockPos corePos = pos.func_177982_a(2, 0, 2);
/* 241 */       BlockWellOfSoulsCore.TileEntityWellOfSoulsCore tile = (BlockWellOfSoulsCore.TileEntityWellOfSoulsCore)BlockUtil.getTileEntity(worldIn, corePos, BlockWellOfSoulsCore.TileEntityWellOfSoulsCore.class);
/* 242 */       if (tile != null) {
/* 243 */         placeWard(worldIn, pos.func_177982_a(1, 1, 0), EnumFacing.NORTH, tile);
/* 244 */         placeWard(worldIn, pos.func_177982_a(3, 1, 0), EnumFacing.NORTH, tile);
/* 245 */         placeWard(worldIn, pos.func_177982_a(0, 1, 1), EnumFacing.WEST, tile);
/* 246 */         placeWard(worldIn, pos.func_177982_a(0, 1, 3), EnumFacing.WEST, tile);
/* 247 */         placeWard(worldIn, pos.func_177982_a(4, 1, 1), EnumFacing.EAST, tile);
/* 248 */         placeWard(worldIn, pos.func_177982_a(4, 1, 3), EnumFacing.EAST, tile);
/* 249 */         placeWard(worldIn, pos.func_177982_a(1, 1, 4), EnumFacing.SOUTH, tile);
/* 250 */         placeWard(worldIn, pos.func_177982_a(3, 1, 4), EnumFacing.SOUTH, tile);
/*     */         
/* 252 */         Get.knowledge().giveKnolsToNearestPlayer(worldIn, pos, 8, new IKnol[] { Get.knowledge().SKILL_SOUL_MANIPULATION });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void placeWard(World worldIn, BlockPos pos, EnumFacing facing, IMultiBlockController controller) {
/* 258 */     BlockPos up = pos.func_177984_a();
/* 259 */     if ((worldIn.func_180495_p(pos).func_177230_c().func_176200_f(worldIn, pos)) && (worldIn.func_180495_p(up).func_177230_c().func_176200_f(worldIn, up))) {
/* 260 */       emoniph.intangible.items.ItemSoulWard.place(worldIn, pos, facing, true);
/* 261 */       BlockSoulWard.TileEntitySoulWard tile = (BlockSoulWard.TileEntitySoulWard)BlockUtil.getTileEntity(worldIn, pos, BlockSoulWard.TileEntitySoulWard.class);
/* 262 */       if (tile != null) {
/* 263 */         tile.setMultiBlockController(controller);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void tryDissolveWellStructure(World worldIn, BlockPos pos, IBlockState state) {
/* 269 */     if (pos != null) {
/* 270 */       BlockPos wellPos = pos.func_177982_a(1, 0, 1);
/* 271 */       for (int x = 0; x < 9; x++) {
/* 272 */         worldIn.func_175698_g(wellPos.func_177982_a(x % 3, 0, x / 3));
/*     */       }
/*     */       
/* 275 */       removeWard(worldIn, pos.func_177982_a(1, 1, 0));
/* 276 */       removeWard(worldIn, pos.func_177982_a(3, 1, 0));
/* 277 */       removeWard(worldIn, pos.func_177982_a(0, 1, 1));
/* 278 */       removeWard(worldIn, pos.func_177982_a(0, 1, 3));
/* 279 */       removeWard(worldIn, pos.func_177982_a(4, 1, 1));
/* 280 */       removeWard(worldIn, pos.func_177982_a(4, 1, 3));
/* 281 */       removeWard(worldIn, pos.func_177982_a(1, 1, 4));
/* 282 */       removeWard(worldIn, pos.func_177982_a(3, 1, 4));
/*     */     }
/*     */   }
/*     */   
/*     */   private void removeWard(World worldIn, BlockPos pos) {
/* 287 */     BlockPos up = pos.func_177984_a();
/* 288 */     if ((worldIn.func_180495_p(pos).func_177230_c() == Get.blocks().SOUL_WARD) && 
/* 289 */       (worldIn.func_180495_p(up).func_177230_c() == Get.blocks().SOUL_WARD)) {
/* 290 */       worldIn.func_175698_g(pos);
/* 291 */       worldIn.func_175698_g(up);
/*     */     }
/*     */   }
/*     */   
/*     */   private BlockPos findWellStructure(World worldIn, BlockPos pos, IBlockState state, BlockPos requiredMissingBlockPos, boolean isFilled) {
/* 296 */     if ((worldIn.func_180495_p(pos.func_177974_f()) == state) || (worldIn.func_180495_p(pos.func_177976_e()) == state))
/*     */     {
/* 298 */       while (worldIn.func_180495_p(pos.func_177976_e()) == state) {
/* 299 */         pos = pos.func_177976_e();
/*     */       }
/* 301 */       pos = pos.func_177976_e();
/*     */       
/*     */ 
/* 304 */       if (isStructure(worldIn, pos, state, requiredMissingBlockPos, isFilled)) {
/* 305 */         return pos;
/*     */       }
/*     */       
/*     */ 
/* 309 */       pos = pos.func_177964_d(STRUCTURE.length - 1);
/* 310 */       if (isStructure(worldIn, pos, state, requiredMissingBlockPos, isFilled)) {
/* 311 */         return pos;
/*     */       }
/* 313 */     } else if ((worldIn.func_180495_p(pos.func_177978_c()) == state) || (worldIn.func_180495_p(pos.func_177968_d()) == state))
/*     */     {
/* 315 */       while (worldIn.func_180495_p(pos.func_177978_c()) == state) {
/* 316 */         pos = pos.func_177978_c();
/*     */       }
/* 318 */       pos = pos.func_177978_c();
/*     */       
/*     */ 
/* 321 */       if (isStructure(worldIn, pos, state, requiredMissingBlockPos, isFilled)) {
/* 322 */         return pos;
/*     */       }
/*     */       
/*     */ 
/* 326 */       pos = pos.func_177985_f(STRUCTURE[0].length - 1);
/* 327 */       if (isStructure(worldIn, pos, state, requiredMissingBlockPos, isFilled)) {
/* 328 */         return pos;
/*     */       }
/*     */     }
/* 331 */     return null;
/*     */   }
/*     */   
/*     */ 
/* 335 */   private static final int[][] STRUCTURE = { { 2, 1, 1, 1, 2 }, { 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1 }, { 2, 1, 1, 1, 2 } };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isStructure(World worldIn, BlockPos pos, IBlockState state, BlockPos requiredMissingPos, boolean isFilled)
/*     */   {
/* 344 */     boolean missingPosFound = false;
/* 345 */     for (int z = 0; z < STRUCTURE.length; z++) {
/* 346 */       for (int x = 0; x < STRUCTURE[z].length; x++) {
/* 347 */         BlockPos current = pos.func_177982_a(x, 0, z);
/* 348 */         int t = STRUCTURE[z][x];
/* 349 */         if (t != 2) {
/* 350 */           IBlockState s = worldIn.func_180495_p(current);
/* 351 */           if (((t == 0) && (!isFilled) && (!s.func_177230_c().func_149688_o().func_76222_j())) || ((t == 1) && (s != state))) {
/* 352 */             if ((requiredMissingPos != null) && (current.equals(requiredMissingPos))) {
/* 353 */               missingPosFound = true;
/*     */             } else {
/* 355 */               return false;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 363 */     return (requiredMissingPos == null) || (missingPosFound);
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void func_149666_a(Item itemIn, CreativeTabs tab, List list)
/*     */   {
/* 369 */     for (EnumSoulType soulType : ) {
/* 370 */       list.add(new ItemStack(itemIn, 1, soulType.getMetadata()));
/*     */     }
/*     */   }
/*     */   
/*     */   public List<IBookPageResources> getBookResourcePageIds()
/*     */   {
/* 376 */     List<IBookPageResources> list = new java.util.ArrayList();
/* 377 */     for (EnumSoulType soulType : EnumSoulType.values()) {
/* 378 */       if (soulType != EnumSoulType.BENIGN) {
/* 379 */         list.add(new PageResources(func_149739_a().substring(5) + "_" + soulType.getUnlocalizedName(), func_149739_a() + "_" + soulType.getUnlocalizedName() + ".name", func_149739_a() + "_" + soulType.getUnlocalizedName() + ".soulforge", null, new IKnol[] { Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().getKnolForSoul(soulType.toSoulType()) }).setUsedSouls(new SoulSet().add(soulType.toSoulType(), 1)));
/*     */       }
/*     */     }
/* 382 */     return list;
/*     */   }
/*     */   
/*     */   public boolean isForgeClientValid(World world, BlockPos pos, IBlockState state, ISoulForge forge)
/*     */   {
/* 387 */     return (state.func_177229_b(VARIANT) != EnumSoulType.BENIGN) && (state.func_177229_b(VARIANT) != EnumSoulType.IMMUTABLE);
/*     */   }
/*     */   
/*     */   public boolean isForgeClientActive(World world, BlockPos pos, IBlockState state, ISoulForge forge)
/*     */   {
/* 392 */     if (state.func_177229_b(VARIANT) == EnumSoulType.MALLEABLE) {
/* 393 */       boolean powered = world.func_175640_z(pos);
/* 394 */       return powered;
/*     */     }
/* 396 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isForgeInventoryValid(World world, BlockPos pos, IBlockState state, ISoulForge forge)
/*     */   {
/* 402 */     return state.func_177229_b(VARIANT) == EnumSoulType.IMMUTABLE;
/*     */   }
/*     */   
/*     */   public IInventoryItem requestItemFromInventory(World world, BlockPos pos, IBlockState state, ItemStack request, ISoulForge forge)
/*     */   {
/* 407 */     for (EnumFacing facing : EnumFacing.field_82609_l) {
/* 408 */       BlockPos testPos = pos.func_177972_a(facing);
/* 409 */       IBlockState testState = world.func_180495_p(testPos);
/* 410 */       if ((testState.func_177230_c() instanceof net.minecraft.block.BlockContainer)) {
/* 411 */         net.minecraft.tileentity.TileEntity tile = world.func_175625_s(testPos);
/* 412 */         if (tile != null) {
/* 413 */           if ((tile instanceof ISidedInventory)) {
/* 414 */             ISidedInventory inv = (ISidedInventory)tile;
/* 415 */             EnumFacing tileSide = facing.func_176734_d();
/* 416 */             int[] slots = inv.func_180463_a(tileSide);
/* 417 */             for (int slot : slots) {
/* 418 */               if (inv.func_180461_b(slot, null, tileSide)) {
/* 419 */                 ItemStack stackInSlot = inv.func_70301_a(slot);
/* 420 */                 if ((ItemStack.func_179545_c(stackInSlot, request)) && (ItemStack.func_77970_a(stackInSlot, request))) {
/* 421 */                   return new InventoryItem(inv, slot);
/*     */                 }
/*     */               }
/*     */             }
/* 425 */           } else if ((tile instanceof IInventory)) {
/* 426 */             IInventory inv = (IInventory)tile;
/* 427 */             for (int slot = 0; slot < inv.func_70302_i_(); slot++) {
/* 428 */               ItemStack stackInSlot = inv.func_70301_a(slot);
/* 429 */               if ((ItemStack.func_179545_c(stackInSlot, request)) && (ItemStack.func_77970_a(stackInSlot, request))) {
/* 430 */                 return new InventoryItem(inv, slot);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 438 */     return new InventoryItem.Empty();
/*     */   }
/*     */   
/*     */   public boolean forgeClientTick(World world, BlockPos pos, IBlockState state, ISoulForge forge)
/*     */   {
/* 443 */     EnumSoulType soul = (EnumSoulType)state.func_177229_b(VARIANT);
/* 444 */     switch (soul) {
/*     */     case PREDATORY: 
/* 446 */       return breakNearbyBlocks(world, pos, state, forge, new SoulSet().add(SoulType.PREDATORY, 1), 40);
/*     */     case WISE: 
/* 448 */       return placeBlocks(world, pos, state, forge, Gravity.DOWN, new SoulSet().add(SoulType.WISE, 1), 40);
/*     */     case UNHINGED: 
/* 450 */       return placeBlocks(world, pos, state, forge, Gravity.UP, new SoulSet().add(SoulType.UNHINGED, 1), 40);
/*     */     case MALLEABLE: 
/* 452 */       return craftItem(world, pos, state, forge, new SoulSet().add(SoulType.MALLEABLE, 1), 200);
/*     */     case NOBLE: 
/* 454 */       return floatItems(world, pos, state, forge, new SoulSet().add(SoulType.NOBLE, 1), 50);
/*     */     case DOOMED: 
/* 456 */       return breakBlocks(world, pos, state, forge, new SoulSet().add(SoulType.DOOMED, 1), 50);
/*     */     }
/* 458 */     return false;
/*     */   }
/*     */   
/*     */   private boolean breakBlocks(World world, BlockPos pos, IBlockState state, ISoulForge forge, ISoulSet cost, int cooldown) {
/* 462 */     boolean result = false;
/* 463 */     if (!world.field_72995_K) {
/* 464 */       IBlockState upState = world.func_180495_p(pos.func_177984_a());
/* 465 */       ItemStack filter = null;
/* 466 */       if (upState.func_177230_c() == Get.blocks().OFFERING_PLATE) {
/* 467 */         BlockOfferingPlate.TileEntityOfferingPlate tile = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(world, pos.func_177984_a(), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 468 */         if (tile != null) {
/* 469 */           filter = tile.func_70301_a(0);
/*     */         }
/*     */       } else {
/* 472 */         IBlockState downState = world.func_180495_p(pos.func_177977_b());
/* 473 */         if (downState.func_177230_c() == Get.blocks().OFFERING_PLATE) {
/* 474 */           BlockOfferingPlate.TileEntityOfferingPlate tile = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(world, pos.func_177977_b(), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 475 */           if (tile != null) {
/* 476 */             filter = tile.func_70301_a(0);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 481 */       if (filter != null) {
/* 482 */         RequestStatus status = RequestStatus.PENDING;
/* 483 */         int y = world.field_73012_v.nextInt(pos.func_177956_o() - 1);
/* 484 */         for (int[] offset : SPAWN_OFFSETS) {
/* 485 */           BlockPos targetPos = pos.func_177982_a(offset[0], -y, offset[1]);
/* 486 */           IBlockState targetState = world.func_180495_p(targetPos);
/* 487 */           if (targetState.func_177230_c() != Blocks.field_150350_a)
/*     */           {
/* 489 */             if (((filter.func_77973_b() == Item.func_150898_a(targetState.func_177230_c())) && (filter.func_77952_i() == targetState.func_177230_c().func_176222_j(world, targetPos))) || (
/* 490 */               (filter.func_77973_b() == targetState.func_177230_c().func_180660_a(targetState, world.field_73012_v, 0)) && (filter.func_77952_i() == targetState.func_177230_c().func_180651_a(targetState)) && 
/* 491 */               (canBlockBeBroken(world, targetPos, targetState)))) {
/* 492 */               if (status == RequestStatus.PENDING) {
/* 493 */                 status = forge.requestSoulsForWork(cost, cooldown, world, pos) ? RequestStatus.ALLOWED : RequestStatus.REJECTED;
/*     */               }
/*     */               
/* 496 */               if (status == RequestStatus.ALLOWED) {
/* 497 */                 BlockUtil.tryHarvestBlock(world, targetPos, FakePlayerFactory.getMinecraft((WorldServer)world), null);
/* 498 */                 result = true;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 505 */     return result;
/*     */   }
/*     */   
/* 508 */   private static final int[][] SPAWN_OFFSETS = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 0 } };
/*     */   
/*     */   private boolean floatItems(World world, BlockPos pos, IBlockState state, ISoulForge forge, ISoulSet cost, int cooldown) {
/* 511 */     boolean result = false;
/* 512 */     ItemStack filter; if (!world.field_72995_K) {
/* 513 */       IBlockState upState = world.func_180495_p(pos.func_177984_a());
/* 514 */       filter = null;
/* 515 */       if (upState.func_177230_c() == Get.blocks().OFFERING_PLATE) {
/* 516 */         BlockOfferingPlate.TileEntityOfferingPlate tile = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(world, pos.func_177984_a(), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 517 */         if (tile != null) {
/* 518 */           filter = tile.func_70301_a(0);
/*     */         }
/*     */       }
/*     */       
/* 522 */       List<EntityItem> items = world.func_72872_a(EntityItem.class, new net.minecraft.util.AxisAlignedBB(pos.func_177982_a(-1, -pos.func_177956_o(), -1), pos.func_177982_a(2, -1, 2)));
/* 523 */       if (items.size() > 0)
/*     */       {
/* 525 */         for (EntityItem item : items) {
/* 526 */           if ((item != null) && (item.func_92059_d() != null) && 
/* 527 */             ((filter == null) || (ItemStack.func_179545_c(item.func_92059_d(), filter))) && (
/* 528 */             (result) || (forge.requestSoulsForWork(cost, cooldown, world, pos)))) {
/* 529 */             int[] offset = SPAWN_OFFSETS[world.field_73012_v.nextInt(SPAWN_OFFSETS.length - 1)];
/* 530 */             BlockPos newPos = pos.func_177982_a(offset[0], 0, offset[1]);
/* 531 */             item.func_70634_a(newPos.func_177958_n() + 0.5D, newPos.func_177956_o() + 0.5D, newPos.func_177952_p() + 0.5D);
/* 532 */             Get.fx().GLOW.sendToAllNear(item, 0.25F, 5, 4495650, 16.0D);
/* 533 */             result = true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 540 */     return result;
/*     */   }
/*     */   
/*     */   private boolean isKnownCraftingLayout(World world, BlockPos[] grid) {
/* 544 */     for (BlockPos testPos : grid) {
/* 545 */       IBlockState testState = world.func_180495_p(testPos);
/* 546 */       if ((testState.func_177230_c() != this) || (testState.func_177229_b(VARIANT) != EnumSoulType.BENIGN)) {
/* 547 */         return false;
/*     */       }
/*     */     }
/* 550 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean craftItem(World world, BlockPos pos, IBlockState state, ISoulForge forge, ISoulSet cost, int cooldown)
/*     */   {
/* 557 */     BlockPos[] soulCraftingGrid = { pos.func_177982_a(0, 0, -3), pos.func_177982_a(2, 0, -2), pos.func_177982_a(3, 0, 0), pos.func_177982_a(2, 0, 2), pos.func_177982_a(0, 0, 3), pos.func_177982_a(-2, 0, 2), pos.func_177982_a(-3, 0, 0), pos.func_177982_a(-2, 0, -2) };
/*     */     
/* 559 */     if (isKnownCraftingLayout(world, soulCraftingGrid)) {
/* 560 */       return craftSoulRecipe(world, pos, forge, soulCraftingGrid, cost, cooldown);
/*     */     }
/*     */     
/* 563 */     for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 564 */       BlockPos midPos = pos.func_177967_a(facing, 4);
/* 565 */       BlockPos lPos = midPos.func_177967_a(facing, 2);
/* 566 */       BlockPos rPos = midPos.func_177967_a(facing.func_176734_d(), 2);
/* 567 */       EnumFacing up = facing.func_176746_e();
/* 568 */       EnumFacing down = facing.func_176735_f();
/*     */       
/*     */ 
/*     */ 
/* 572 */       BlockPos[] shapedCraftingGrid = {lPos.func_177967_a(up, 2), midPos.func_177967_a(up, 2), rPos.func_177967_a(up, 2), lPos, midPos, rPos, lPos.func_177967_a(down, 2), midPos.func_177967_a(down, 2), rPos.func_177967_a(down, 2) };
/*     */       
/* 574 */       if (isKnownCraftingLayout(world, shapedCraftingGrid)) {
/* 575 */         return craftShapedRecipe(world, pos, forge, shapedCraftingGrid, cost, cooldown);
/*     */       }
/*     */     }
/* 578 */     return false;
/*     */   }
/*     */   
/*     */   private boolean craftSoulRecipe(World world, BlockPos pos, ISoulForge forge, BlockPos[] grid, ISoulSet cost, int cooldown) {
/* 582 */     IInventoryItem[] invItems = new IInventoryItem[grid.length];
/* 583 */     ItemStack[] stacks = new ItemStack[grid.length];
/* 584 */     for (int i = 0; i < grid.length; i++) {
/* 585 */       BlockPos sourcePos = grid[i].func_177984_a();
/* 586 */       IInventoryItem item = getStackAtPos(world, sourcePos, this, pos, forge, false);
/* 587 */       invItems[i] = item;
/* 588 */       stacks[i] = item.getStackInSlot();
/*     */     }
/*     */     
/* 591 */     Get.recipes();SoulRecipe recipe = ModRecipes.souls.getOutputFor(stacks);
/* 592 */     if (recipe != null)
/*     */     {
/* 594 */       BlockPos[] itemSources = BlockUtil.offset(grid, EnumFacing.UP);
/* 595 */       for (int i = 0; i < grid.length; i++) {
/* 596 */         BlockPos sourcePos = grid[i].func_177984_a();
/* 597 */         IInventoryItem item = getStackAtPos(world, sourcePos, this, pos, forge, true);
/* 598 */         item.reserve();
/* 599 */         invItems[i] = item;
/* 600 */         stacks[i] = item.getStackInSlot();
/* 601 */         if (stacks[i] == null) {
/* 602 */           itemSources[i] = null;
/*     */         }
/*     */       }
/*     */       
/* 606 */       Get.recipes();recipe = ModRecipes.souls.getOutputFor(stacks);
/* 607 */       if ((recipe != null) && 
/* 608 */         (forge.requestSoulsForWork(cost, cooldown, world, pos)) && 
/* 609 */         (forge.requestSoulsForConsumption(recipe.getRequiredSouls(), world, pos))) {
/* 610 */         BlockPos deployPos = getDeployPos(world, pos);
/* 611 */         forge.spawnItemDramatically(recipe.getOutput(stacks), deployPos, itemSources, world, pos, 7);
/* 612 */         return true;
/*     */       }
/* 614 */       for (int i = 0; i < grid.length; i++) {
/* 615 */         invItems[i].rollback(world, pos);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 620 */     return false;
/*     */   }
/*     */   
/*     */   private boolean craftShapedRecipe(World world, BlockPos pos, ISoulForge forge, BlockPos[] grid, ISoulSet cost, int cooldown) {
/* 624 */     IInventoryItem[] invItems = new IInventoryItem[grid.length];
/*     */     
/* 626 */     InventoryCrafting inv = new InventoryCrafting(new net.minecraft.inventory.Container()
/*     */     {
/* 628 */       public boolean func_75145_c(EntityPlayer playerIn) { return false; } }, 3, 3);
/*     */     
/*     */ 
/*     */ 
/* 632 */     for (int i = 0; i < grid.length; i++) {
/* 633 */       BlockPos sourcePos = grid[i].func_177984_a();
/* 634 */       IInventoryItem item = getStackAtPos(world, sourcePos, this, pos, forge, false);
/* 635 */       invItems[i] = item;
/* 636 */       inv.func_70299_a(i, item.getStackInSlot());
/*     */     }
/*     */     
/* 639 */     ItemStack resultItem = CraftingManager.func_77594_a().func_82787_a(inv, world);
/*     */     
/* 641 */     if (resultItem != null)
/*     */     {
/* 643 */       BlockPos[] itemSources = BlockUtil.offset(grid, EnumFacing.UP);
/* 644 */       for (int i = 0; i < grid.length; i++) {
/* 645 */         BlockPos sourcePos = grid[i].func_177984_a();
/* 646 */         IInventoryItem item = getStackAtPos(world, sourcePos, this, pos, forge, true);
/* 647 */         item.reserve();
/* 648 */         invItems[i] = item;
/* 649 */         ItemStack stack = item.getStackInSlot();
/* 650 */         inv.func_70299_a(i, stack);
/* 651 */         if (stack == null) {
/* 652 */           itemSources[i] = null;
/*     */         }
/*     */       }
/*     */       
/* 656 */       resultItem = CraftingManager.func_77594_a().func_82787_a(inv, world);
/* 657 */       if ((resultItem != null) && (forge.requestSoulsForWork(cost, cooldown, world, pos))) {
/* 658 */         BlockPos deployPos = getDeployPos(world, pos);
/*     */         
/* 660 */         ItemStack[] remainingItems = CraftingManager.func_77594_a().func_180303_b(inv, world);
/* 661 */         for (int i = 0; i < remainingItems.length; i++) {
/* 662 */           ItemStack itemstack1 = inv.func_70301_a(i);
/* 663 */           ItemStack itemstack2 = remainingItems[i];
/*     */           
/* 665 */           if (itemstack1 != null) {
/* 666 */             invItems[i].commit();
/*     */           }
/*     */           
/* 669 */           if (itemstack2 != null) {
/* 670 */             EntityItem entity = new EntityItem(world, deployPos.func_177958_n() + 0.5D, deployPos.func_177956_o() + 0.5D, deployPos.func_177952_p() + 0.5D, itemstack2);
/* 671 */             entity.field_70159_w = (entity.field_70179_y = 0.0D);
/* 672 */             world.func_72838_d(entity);
/*     */           }
/*     */         }
/*     */         
/* 676 */         forge.spawnItemDramatically(resultItem.func_77946_l(), deployPos, itemSources, world, pos, 0);
/* 677 */         return true;
/*     */       }
/* 679 */       for (int i = 0; i < grid.length; i++) {
/* 680 */         invItems[i].rollback(world, pos);
/*     */       }
/*     */     }
/*     */     
/* 684 */     return false;
/*     */   }
/*     */   
/*     */   private BlockPos getDeployPos(World world, BlockPos pos) {
/* 688 */     for (EnumFacing facing : ) {
/* 689 */       BlockPos testPos = pos.func_177972_a(facing);
/* 690 */       if (world.func_180495_p(testPos).func_177230_c().func_149688_o().func_76222_j()) {
/* 691 */         return testPos;
/*     */       }
/*     */     }
/* 694 */     return pos.func_177984_a();
/*     */   }
/*     */   
/*     */   private IInventoryItem getStackAtPos(World world, BlockPos pos, ISoulForgeClient forgeClient, BlockPos forgeClientPos, ISoulForge forge, boolean remove) {
/* 698 */     IBlockState state = world.func_180495_p(pos);
/* 699 */     if ((state.func_177230_c() instanceof ISoulForgeItemSource)) {
/* 700 */       ISoulForgeItemSource itemSource = (ISoulForgeItemSource)state.func_177230_c();
/* 701 */       return itemSource.getSoulForgeItemStack(world, pos, forgeClient, forgeClientPos, forge, remove);
/*     */     }
/* 703 */     return new InventoryItem.Empty();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/* 709 */   public int getCreativeSortIndex() { return 58; }
/*     */   
/*     */   private static enum Gravity {
/* 712 */     NONE,  DOWN,  UP;
/*     */     
/*     */     private Gravity() {} }
/* 715 */   private boolean placeBlocks(World world, BlockPos pos, IBlockState state, ISoulForge forge, Gravity gravity, ISoulSet requiredSouls, int cooldown) { boolean result = false;
/*     */     
/* 717 */     RequestStatus status = RequestStatus.PENDING;
/*     */     
/* 719 */     for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 720 */       BlockPos targetPos = pos.func_177972_a(facing);
/* 721 */       IBlockState targetState = world.func_180495_p(targetPos);
/* 722 */       if (targetState.func_177230_c().func_149688_o().func_76222_j()) {
/* 723 */         IInventoryItem invItem = getStackAtPos(world, pos.func_177984_a(), this, pos, forge, true);
/* 724 */         if (invItem.getStackInSlot() == null) {
/* 725 */           invItem = getStackAtPos(world, pos.func_177977_b(), this, pos, forge, true);
/*     */         }
/* 727 */         ItemStack stack = invItem.getStackInSlot();
/*     */         
/* 729 */         if ((stack != null) && (stack.field_77994_a > 0)) {
/* 730 */           if (status == RequestStatus.PENDING) {
/* 731 */             status = forge.requestSoulsForWork(requiredSouls, cooldown, world, pos) ? RequestStatus.ALLOWED : RequestStatus.REJECTED;
/*     */           }
/*     */           
/* 734 */           if (status == RequestStatus.ALLOWED) {
/* 735 */             stack = invItem.decrStackInSlot(1);
/* 736 */             if (BlockUtil.tryPlaceItemBlock(world, targetPos, FakePlayerFactory.getMinecraft((WorldServer)world), stack)) {
/* 737 */               IBlockState newState = world.func_180495_p(targetPos);
/* 738 */               if (!newState.equals(targetState)) {
/* 739 */                 if (gravity == Gravity.DOWN) {
/* 740 */                   if (world.func_175623_d(targetPos.func_177977_b())) {
/* 741 */                     EntityFallingBlock fallingBlock = new EntityFallingBlock(world, targetPos.func_177958_n() + 0.5D, targetPos.func_177956_o(), targetPos.func_177952_p() + 0.5D, newState);
/* 742 */                     world.func_72838_d(fallingBlock);
/*     */                   }
/*     */                   
/*     */                 }
/* 746 */                 else if ((gravity == Gravity.UP) && 
/* 747 */                   (world.func_175623_d(targetPos.func_177984_a()))) {
/* 748 */                   EntityRaisingBlock fallingBlock = new EntityRaisingBlock(world, targetPos.func_177958_n() + 0.5D, targetPos.func_177956_o(), targetPos.func_177952_p() + 0.5D, newState);
/* 749 */                   world.func_72838_d(fallingBlock);
/*     */                 }
/*     */               }
/*     */               
/* 753 */               world.func_175689_h(pos.func_177984_a());
/* 754 */               result = true;
/*     */             } else {
/* 756 */               if (world.func_175623_d(pos.func_177984_a())) {
/* 757 */                 world.func_72838_d(new EntityItem(world, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 1.5D, pos.func_177958_n() + 0.5D, stack));
/*     */               } else {
/* 759 */                 world.func_72838_d(new EntityItem(world, pos.func_177958_n() + 0.5D, pos.func_177956_o() - 0.5D, pos.func_177958_n() + 0.5D, stack));
/*     */               }
/* 761 */               result = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 768 */     return result;
/*     */   }
/*     */   
/* 771 */   private static enum RequestStatus { PENDING,  ALLOWED,  REJECTED;
/*     */     
/*     */     private RequestStatus() {} }
/* 774 */   private boolean breakNearbyBlocks(World world, BlockPos pos, IBlockState state, ISoulForge forge, ISoulSet cost, int cooldown) { boolean result = false;
/* 775 */     if (!world.field_72995_K) {
/* 776 */       IBlockState upState = world.func_180495_p(pos.func_177984_a());
/* 777 */       ItemStack filter = null;
/* 778 */       BlockOfferingPlate.TileEntityOfferingPlate tile; if (upState.func_177230_c() == Get.blocks().OFFERING_PLATE) {
/* 779 */         BlockOfferingPlate.TileEntityOfferingPlate tile = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(world, pos.func_177984_a(), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 780 */         if (tile != null) {
/* 781 */           filter = tile.func_70301_a(0);
/*     */         }
/*     */       } else {
/* 784 */         IBlockState downState = world.func_180495_p(pos.func_177977_b());
/* 785 */         if (downState.func_177230_c() == Get.blocks().OFFERING_PLATE) {
/* 786 */           tile = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(world, pos.func_177977_b(), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 787 */           if (tile != null) {
/* 788 */             filter = tile.func_70301_a(0);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 793 */       RequestStatus status = RequestStatus.PENDING;
/* 794 */       for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 795 */         if (facing != EnumFacing.UP) {
/* 796 */           BlockPos targetPos = pos.func_177972_a(facing);
/* 797 */           IBlockState targetState = world.func_180495_p(targetPos);
/* 798 */           if ((targetState.func_177230_c() != Blocks.field_150350_a) && 
/* 799 */             ((filter == null) || ((filter.func_77973_b() == Item.func_150898_a(targetState.func_177230_c())) && (filter.func_77952_i() == targetState.func_177230_c().func_176222_j(world, targetPos)))) && (canBlockBeBroken(world, targetPos, targetState))) {
/* 800 */             if ((filter != null) && ((targetState.func_177230_c() instanceof IGrowable))) {
/* 801 */               IGrowable growable = (IGrowable)targetState.func_177230_c();
/* 802 */               if (growable.func_176473_a(world, targetPos, targetState, world.field_72995_K)) {
/* 803 */                 status = RequestStatus.REJECTED;
/*     */               }
/*     */             }
/* 806 */             if (status == RequestStatus.PENDING) {
/* 807 */               status = forge.requestSoulsForWork(cost, cooldown, world, pos) ? RequestStatus.ALLOWED : RequestStatus.REJECTED;
/*     */             }
/*     */             
/* 810 */             if (status == RequestStatus.ALLOWED) {
/* 811 */               BlockUtil.tryHarvestBlock(world, targetPos, FakePlayerFactory.getMinecraft((WorldServer)world), null);
/* 812 */               result = true;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 819 */     return result;
/*     */   }
/*     */   
/*     */   private boolean canBlockBeBroken(World world, BlockPos pos, IBlockState state) {
/* 823 */     return ((!state.func_177230_c().hasTileEntity(state)) || (state.func_177230_c() == Get.blocks().CRYSTAL)) && (state.func_177230_c() != Blocks.field_150325_L) && (state.func_177230_c().func_176195_g(world, pos) != -1.0F);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockSoulCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */