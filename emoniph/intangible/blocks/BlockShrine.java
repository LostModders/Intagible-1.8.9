/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.deity.IDeityWorshipEffect;
/*     */ import emoniph.intangible.config.Config;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.deity.DeityList;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.deity.IPlayerWorship;
/*     */ import emoniph.intangible.deity.ShrineManager;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockShrine extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*  39 */   public static final net.minecraft.block.properties.PropertyBool NO_DROP = net.minecraft.block.properties.PropertyBool.func_177716_a("nodrop");
/*     */   
/*     */   protected BlockShrine() {
/*  42 */     super(net.minecraft.block.material.Material.field_151576_e);
/*  43 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(NO_DROP, Boolean.valueOf(false)));
/*  44 */     func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 0.26F, 0.75F);
/*  45 */     func_149711_c(5.0F);
/*  46 */     func_149752_b(9999.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, net.minecraft.entity.Entity entity)
/*     */   {
/*  51 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state) {
/*  63 */     func_180654_a(worldIn, pos);
/*  64 */     return super.func_180640_a(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, net.minecraft.entity.EntityLivingBase placer) {
/*  68 */     return func_176223_P().func_177226_a(NO_DROP, Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta) {
/*  72 */     return new TileEntityShrine();
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
/*  76 */     if (player.field_71075_bZ.field_75098_d) {
/*  77 */       state = state.func_177226_a(NO_DROP, Boolean.valueOf(true));
/*  78 */       worldIn.func_180501_a(pos, state, 4);
/*     */     } else {
/*  80 */       TileEntityShrine tile = (TileEntityShrine)BlockUtil.getTileEntity(worldIn, pos, TileEntityShrine.class);
/*  81 */       if ((tile != null) && 
/*  82 */         (tile.deity != null) && (!PlayerEx.get(player).getWorship().isDevoutFollowerOf(worldIn, tile.deityId))) {
/*  83 */         tile.deity.getCurseEffect().performWorshipEffect(worldIn, pos, player, tile.deity);
/*     */       }
/*     */     }
/*     */     
/*  87 */     func_176226_b(worldIn, pos, state, 0);
/*     */     
/*  89 */     super.func_176208_a(worldIn, pos, state, player);
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state) {
/*  93 */     Get.shrines().removeDedicatedShrine(worldIn, pos);
/*  94 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
/*  98 */     List<ItemStack> ret = new ArrayList();
/*     */     
/* 100 */     if (!((Boolean)state.func_177229_b(NO_DROP)).booleanValue()) {
/* 101 */       TileEntityShrine tile = (TileEntityShrine)BlockUtil.getTileEntity(worldIn, pos, TileEntityShrine.class);
/* 102 */       if (tile != null) {
/* 103 */         ItemStack itemstack = new ItemStack(this);
/* 104 */         if (!itemstack.func_77942_o()) {
/* 105 */           itemstack.func_77982_d(new NBTTagCompound());
/*     */         }
/*     */         
/* 108 */         tile.writeItemToNBT(itemstack.func_77978_p());
/* 109 */         if (tile.deityId != null) {
/* 110 */           itemstack.func_151001_c(net.minecraft.util.StatCollector.func_74837_a("tile.intangible:shrine.dedicated", new Object[] { tile.name }));
/*     */         }
/*     */         
/* 113 */         ret.add(itemstack);
/*     */       }
/*     */     }
/*     */     
/* 117 */     return ret;
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/* 121 */     return func_176223_P().func_177226_a(NO_DROP, Boolean.valueOf((meta & 0x8) > 0));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/* 125 */     byte b0 = 0;
/* 126 */     int i = b0;
/*     */     
/* 128 */     if (((Boolean)state.func_177229_b(NO_DROP)).booleanValue()) {
/* 129 */       i |= 0x8;
/*     */     }
/*     */     
/* 132 */     return i;
/*     */   }
/*     */   
/*     */   public ItemStack getPickBlock(net.minecraft.util.MovingObjectPosition target, World worldIn, BlockPos pos, EntityPlayer player)
/*     */   {
/* 137 */     ItemStack stack = new ItemStack(this);
/*     */     
/* 139 */     TileEntityShrine tile = (TileEntityShrine)BlockUtil.getTileEntity(worldIn, pos, TileEntityShrine.class);
/* 140 */     if (tile != null) {
/* 141 */       if (!stack.func_77942_o()) {
/* 142 */         stack.func_77982_d(new NBTTagCompound());
/*     */       }
/*     */       
/* 145 */       tile.writeItemToNBT(stack.func_77978_p());
/* 146 */       if (tile.deityId != null) {
/* 147 */         stack.func_151001_c(net.minecraft.util.StatCollector.func_74837_a("tile.intangible:shrine.dedicated", new Object[] { tile.name }));
/*     */       }
/*     */     }
/*     */     
/* 151 */     return stack;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e() {
/* 155 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { NO_DROP });
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 160 */     if (worldIn.field_72995_K) {
/* 161 */       return true;
/*     */     }
/* 163 */     TileEntityShrine tile = (TileEntityShrine)BlockUtil.getTileEntity(worldIn, pos, TileEntityShrine.class);
/* 164 */     if (tile != null) {
/* 165 */       if (tile.deityId == null) {
/* 166 */         tile.dedicate(playerIn);
/*     */       } else {
/* 168 */         ItemStack held = playerIn.func_70694_bm();
/* 169 */         if ((held != null) && (held.func_77973_b() == Get.items().ROD)) {
/* 170 */           Deity deity = Get.deities().forWorld(worldIn).getDeityById(tile.deityId);
/* 171 */           if (Get.items().ROD.dedicate(worldIn, held, playerIn, deity.getId())) {
/* 172 */             Get.fx().GLOW.sendToAllNear(worldIn, pos, 0.25F, 20, deity.getColor());
/* 173 */             Sound.RANDOM_ORB.playToAllNear(tile, 0.5F);
/*     */           } else {
/* 175 */             Sound.NOTE_SNARE.playToAllNear(tile, 0.5F);
/*     */           }
/*     */         } else {
/* 178 */           tile.worship(playerIn);
/*     */         }
/*     */       }
/*     */     }
/* 182 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 188 */     return 81;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class TileEntityShrine
/*     */     extends TileEntity
/*     */     implements net.minecraft.util.ITickable
/*     */   {
/*     */     private UUID deityId;
/*     */     private int color;
/*     */     private ItemStack itemA;
/*     */     private ItemStack itemB;
/*     */     private ItemStack itemC;
/*     */     private String name;
/*     */     private int skullRotation;
/*     */     private boolean spawn;
/*     */     private long worship;
/*     */     private long lastWorshipTime;
/*     */     private Deity deity;
/*     */     private static final long WORSHIP_DRAIN_FREQUENCY = 12000L;
/*     */     private static final long WORSHIP_DRAIN_THRESHOLD = 24000L;
/*     */     private static final long MIN_WORSHIP_THRESHOLD = 3L;
/*     */     private static final long MAJOR_WORSHIP_THRESHOLD = 10L;
/*     */     private static final long MAX_WORSHIP = 1000L;
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 215 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 216 */       if (state.func_177230_c() != Get.blocks().SHRINE) {
/* 217 */         return;
/*     */       }
/*     */       
/* 220 */       if ((!this.field_145850_b.field_72995_K) && (this.deityId != null)) {
/* 221 */         if (this.deity == null) {
/* 222 */           if (this.field_145850_b.func_82737_E() % 100L == 4L) {
/* 223 */             this.deity = Get.deities().forWorld(this.field_145850_b).getDeityById(this.deityId);
/*     */           }
/*     */         }
/* 226 */         else if (this.worship > 0L) {
/* 227 */           long time = this.field_145850_b.func_82737_E();
/*     */           
/* 229 */           if ((this.worship > 0L) && (time > this.lastWorshipTime + 24000L) && (time % 12000L == 2L)) {
/* 230 */             this.worship -= 1L;
/* 231 */             if (this.worship < 3L) {
/* 232 */               Get.shrines().removeDedicatedShrine(this.field_145850_b, this.field_174879_c);
/*     */             }
/*     */           }
/*     */           
/* 236 */           if (this.worship >= 3L) {
/* 237 */             this.deity.tickTempleEffect(this.field_145850_b, this.field_174879_c, this.worship);
/*     */           }
/*     */           
/* 240 */           if (time % 15L == 5L) {
/* 241 */             List<EntityPlayer> players = this.field_145850_b.func_72872_a(EntityPlayer.class, new AxisAlignedBB(this.field_174879_c.func_177982_a(-3, -2, -3), this.field_174879_c.func_177982_a(4, 3, 4)));
/* 242 */             for (EntityPlayer player : players) {
/* 243 */               if (PlayerEx.get(player).getWorship().isDevoutFollowerOf(this.field_145850_b, this.deity.getId())) {
/* 244 */                 Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 2.0F, 1, this.deity.getColor(), 16.0D);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void worship(EntityPlayer playerIn)
/*     */     {
/* 254 */       if ((!this.field_145850_b.field_72995_K) && (this.deityId != null)) {
/* 255 */         PlayerEx playerEx = PlayerEx.get(playerIn);
/* 256 */         Deity deity = Get.deities().forWorld(this.field_145850_b).getDeityById(this.deityId);
/* 257 */         if (deity != null) {
/* 258 */           if (deity.areWorshipRequirementsMet(this.field_145850_b, this.field_174879_c, playerIn)) {
/* 259 */             if (playerEx.tryWorship(Get.deities().forWorld(this.field_145850_b).getDeityById(this.deityId), this.worship)) {
/* 260 */               Sound.MOD_RANDOM_CHOIR1.playToAllNear(playerIn, 1.0F, 1.0F);
/* 261 */               if (this.worship < 1000L) {
/* 262 */                 this.worship += 1L;
/*     */               }
/* 264 */               Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.5F, 100, this.color, 16.0D);
/* 265 */               this.lastWorshipTime = this.field_145850_b.func_82737_E();
/* 266 */               this.spawn = true;
/* 267 */               boolean desiredItemFound = consumeDesiredItem();
/* 268 */               boolean devout = playerEx.getWorship().isDevoutFollowerOf(this.field_145850_b, deity);
/*     */               
/* 270 */               if (this.worship >= 3L) {
/* 271 */                 if (this.worship == 3L) {
/* 272 */                   Get.shrines().addDedicatedShrine(this.field_145850_b, this.field_174879_c, deity);
/*     */                 }
/*     */                 
/* 275 */                 double blessingChance = 0.01D;
/* 276 */                 blessingChance += (desiredItemFound ? 0.05D : 0.0D);
/* 277 */                 blessingChance += (devout ? 0.04D : 0.0D);
/* 278 */                 blessingChance += ((devout) && (this.worship > 10L) ? 0.1D : 0.0D);
/*     */                 
/* 280 */                 if (this.field_145850_b.field_73012_v.nextDouble() < blessingChance) {
/* 281 */                   deity.getBlessingEffect().performWorshipEffect(this.field_145850_b, this.field_174879_c, playerIn, deity);
/* 282 */                   Get.fx().GLOW.sendToAllNear(this.field_145850_b, playerIn.field_70165_t, playerIn.field_70163_u + playerIn.field_70131_O + 1.0D, playerIn.field_70161_v, 0.7F, 20, deity
/* 283 */                     .getColor(), 0, new net.minecraft.util.Vec3(playerIn.field_70165_t, playerIn.field_70163_u + playerIn
/* 284 */                     .func_70047_e(), playerIn.field_70161_v), 0.1F, 16.0D);
/*     */                 }
/*     */                 
/* 287 */                 deity.getShrineEffect().afterWorship(this.field_145850_b, this.field_174879_c, playerIn, this.worship, true, deity);
/*     */               }
/* 289 */               this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */             } else {
/* 291 */               Sound.MOD_RANDOM_SPELLFAIL2.playOnlyTo(playerIn, 1.0F, 1.0F);
/* 292 */               if (playerEx.getWorship().isDevoutFollowerOf(this.field_145850_b, deity)) {
/* 293 */                 deity.getShrineEffect().afterWorship(this.field_145850_b, this.field_174879_c, playerIn, this.worship, false, deity);
/*     */               }
/*     */             }
/*     */           } else {
/* 297 */             Sound.MOD_RANDOM_SPELLFAIL.playOnlyTo(playerIn, 1.0F, 1.0F);
/*     */           }
/*     */         }
/*     */         else {
/* 301 */           Sound.MOD_RANDOM_SPELLFAIL.playOnlyTo(playerIn, 1.0F, 1.0F);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 307 */     private static final ItemStack[] OFFERINGS = { new ItemStack(Items.field_151043_k), new ItemStack(Items.field_151074_bl), new ItemStack(Items.field_151045_i), new ItemStack(Items.field_151166_bC) };
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean consumeDesiredItem()
/*     */     {
/* 315 */       List<ItemStack> desiredItems = new ArrayList();
/* 316 */       desiredItems.addAll(Arrays.asList(OFFERINGS));
/* 317 */       desiredItems.addAll(Arrays.asList(new ItemStack[] { this.itemA, this.itemB, this.itemC }));
/* 318 */       ItemStack desiredItem = (ItemStack)desiredItems.get(this.field_145850_b.field_73012_v.nextInt(desiredItems.size()));
/* 319 */       for (EnumFacing facing : EnumFacing.field_176754_o)
/*     */       {
/* 321 */         BlockOfferingPlate.TileEntityOfferingPlate plate = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(this.field_145850_b, this.field_174879_c.func_177972_a(facing), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 322 */         if (plate != null) {
/* 323 */           ItemStack stack = plate.func_70301_a(0);
/* 324 */           if ((stack != null) && 
/* 325 */             (ItemStack.func_77989_b(stack, desiredItem))) {
/* 326 */             plate.func_70299_a(0, null);
/* 327 */             Get.fx().sendToAllNear(net.minecraft.util.EnumParticleTypes.SMOKE_NORMAL, this.field_145850_b, this.field_174879_c.func_177972_a(facing), 0.3F, 20);
/* 328 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 333 */       return false;
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 338 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 343 */       super.func_145841_b(compound);
/* 344 */       compound.func_74774_a("Rot", (byte)(this.skullRotation & 0xFF));
/* 345 */       compound.func_74772_a("worship", this.worship);
/* 346 */       compound.func_74772_a("lastWorshipTime", this.lastWorshipTime);
/* 347 */       writeItemToNBT(compound);
/*     */     }
/*     */     
/*     */     public void writeItemToNBT(NBTTagCompound compound) {
/* 351 */       if ((compound != null) && (this.deityId != null)) {
/* 352 */         compound.func_74778_a("deityId", this.deityId.toString());
/* 353 */         compound.func_74768_a("color", this.color);
/* 354 */         compound.func_74782_a("itemA", this.itemA.func_77955_b(new NBTTagCompound()));
/* 355 */         compound.func_74782_a("itemB", this.itemB.func_77955_b(new NBTTagCompound()));
/* 356 */         compound.func_74782_a("itemC", this.itemC.func_77955_b(new NBTTagCompound()));
/* 357 */         compound.func_74778_a("name", this.name);
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 363 */       super.func_145839_a(compound);
/* 364 */       this.skullRotation = compound.func_74771_c("Rot");
/* 365 */       this.worship = compound.func_74763_f("worship");
/* 366 */       this.lastWorshipTime = compound.func_74763_f("lastWorshipTime");
/* 367 */       readItemFromNBT(compound);
/*     */     }
/*     */     
/*     */     public void readItemFromNBT(NBTTagCompound compound) {
/* 371 */       if ((compound != null) && (compound.func_150297_b("deityId", 8))) {
/* 372 */         this.deityId = UUID.fromString(compound.func_74779_i("deityId"));
/* 373 */         this.color = compound.func_74762_e("color");
/* 374 */         this.name = compound.func_74779_i("name");
/* 375 */         this.itemA = ItemStack.func_77949_a(compound.func_74775_l("itemA"));
/* 376 */         this.itemB = ItemStack.func_77949_a(compound.func_74775_l("itemB"));
/* 377 */         this.itemC = ItemStack.func_77949_a(compound.func_74775_l("itemC"));
/*     */       }
/*     */     }
/*     */     
/*     */     @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */     public int getRotation() {
/* 383 */       return this.skullRotation;
/*     */     }
/*     */     
/*     */     public void setRotation(int rotation) {
/* 387 */       this.skullRotation = rotation;
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 392 */       NBTTagCompound compound = new NBTTagCompound();
/* 393 */       func_145841_b(compound);
/* 394 */       if (this.spawn) {
/* 395 */         this.spawn = false;
/* 396 */         compound.func_74757_a("spawn", true);
/*     */       }
/* 398 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(net.minecraft.network.NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 403 */       super.onDataPacket(net, packet);
/* 404 */       NBTTagCompound compound = packet.func_148857_g();
/* 405 */       func_145839_a(compound);
/* 406 */       this.field_145850_b.func_175689_h(func_174877_v());
/* 407 */       if (compound.func_74767_n("spawn"))
/*     */       {
/*     */ 
/* 410 */         this.spawn = false;
/*     */       }
/*     */     }
/*     */     
/*     */     public void dedicate(EntityPlayer playerIn)
/*     */     {
/* 416 */       if ((!this.field_145850_b.field_72995_K) && (this.deityId == null)) {
/* 417 */         boolean genericFound = false;
/* 418 */         List<ItemStack> offerings = new ArrayList();
/* 419 */         EnumFacing[] arrayOfEnumFacing1 = EnumFacing.field_176754_o;int i = arrayOfEnumFacing1.length; EnumFacing facing; for (EnumFacing localEnumFacing1 = 0; localEnumFacing1 < i; localEnumFacing1++) { facing = arrayOfEnumFacing1[localEnumFacing1];
/* 420 */           BlockOfferingPlate.TileEntityOfferingPlate plate = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(this.field_145850_b, this.field_174879_c.func_177972_a(facing), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 421 */           if (plate != null) {
/* 422 */             ItemStack stack = plate.func_70301_a(0);
/* 423 */             if (stack != null) {
/* 424 */               if ((!genericFound) && (stack.func_77973_b() == Items.field_151043_k)) {
/* 425 */                 genericFound = true;
/*     */               } else {
/* 427 */                 offerings.add(stack);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 433 */         if (genericFound) {
/* 434 */           Deity deity = Get.deities().forWorld(this.field_145850_b).getDeityForOfferings(offerings);
/* 435 */           if (deity != null)
/*     */           {
/* 437 */             if (deity.areWorshipRequirementsMet(this.field_145850_b, this.field_174879_c, playerIn)) {
/* 438 */               this.name = deity.getName();
/* 439 */               this.deityId = deity.getId();
/* 440 */               this.color = deity.getColor();
/* 441 */               this.itemA = deity.getSacredItemA();
/* 442 */               this.itemB = deity.getSacredItemB();
/* 443 */               this.itemC = deity.getSacredItemC();
/*     */               
/* 445 */               this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */               
/* 447 */               EnumFacing[] arrayOfEnumFacing2 = EnumFacing.field_176754_o;localEnumFacing1 = arrayOfEnumFacing2.length; for (facing = 0; facing < localEnumFacing1; facing++) { EnumFacing facing = arrayOfEnumFacing2[facing];
/* 448 */                 BlockPos platePos = this.field_174879_c.func_177972_a(facing);
/* 449 */                 BlockOfferingPlate.TileEntityOfferingPlate plate = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(this.field_145850_b, platePos, BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 450 */                 if (plate != null) {
/* 451 */                   plate.func_70299_a(0, null);
/* 452 */                   Get.fx().sendToAllNear(net.minecraft.util.EnumParticleTypes.SMOKE_NORMAL, this.field_145850_b, platePos, 0.3F, 20);
/*     */                 }
/*     */               }
/*     */               
/* 456 */               return;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack getItemA()
/*     */     {
/* 466 */       return this.itemA;
/*     */     }
/*     */     
/*     */     public ItemStack getItemB() {
/* 470 */       return this.itemB;
/*     */     }
/*     */     
/*     */     public ItemStack getItemC() {
/* 474 */       return this.itemC;
/*     */     }
/*     */     
/*     */     public int getColor() {
/* 478 */       return this.color;
/*     */     }
/*     */     
/*     */     public void processTheftFrom(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, ItemStack stack) {
/* 482 */       if ((this.deity != null) && (!PlayerEx.get(player).getWorship().isDevoutFollowerOf(this.field_145850_b, this.deityId)) && 
/* 483 */         (this.field_145850_b.field_73012_v.nextFloat() < Get.config().CURSE_CHANCE_SHRINE_THEFT)) {
/* 484 */         this.deity.getCurseEffect().performWorshipEffect(worldIn, pos, player, this.deity);
/*     */       }
/*     */     }
/*     */     
/*     */     public void checkPlayerAttack(EntityPlayer attacker, EntityPlayer defender)
/*     */     {
/* 490 */       if ((this.deity != null) && (PlayerEx.get(defender).getWorship().isDevoutFollowerOf(this.field_145850_b, this.deity)) && 
/* 491 */         (attacker.field_70170_p.field_73012_v.nextFloat() < Get.config().CURSE_CHANCE_PRIEST_ATTACKED)) {
/* 492 */         this.deity.getCurseEffect().performWorshipEffect(defender.field_70170_p, new BlockPos(defender), attacker, this.deity);
/* 493 */         PlayerEx attackerEx = PlayerEx.get(attacker);
/* 494 */         long worship = attackerEx.getWorship().getWorshipFor(this.field_145850_b, this.deity);
/* 495 */         attackerEx.tryReduceWorship(this.field_145850_b, this.deity.getId(), Math.max(worship - 3L, 1L), true);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockShrine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */