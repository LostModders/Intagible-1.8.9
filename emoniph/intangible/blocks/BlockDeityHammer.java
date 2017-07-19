/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.deity.DeityList;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import emoniph.intangible.entity.EntitySkyBeam;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.WorldPos;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyEnum;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
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
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.apache.commons.lang3.Range;
/*     */ 
/*     */ public class BlockDeityHammer extends BlockContainer implements IBlock, IMultiBlock, emoniph.intangible.api.ITriggerClient, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  52 */     return 85;
/*     */   }
/*     */   
/*     */   public static enum EnumPart implements IStringSerializable {
/*  56 */     BASE("bottom", 0), 
/*  57 */     SHAFT1("shaft1", 1), 
/*  58 */     SHAFT2("shaft2", 2), 
/*  59 */     SHAFT3("shaft3", 3);
/*     */     
/*     */     private final String name;
/*     */     private final int metadata;
/*     */     private static final Map<Integer, EnumPart> META_TO_PART;
/*     */     
/*  65 */     private EnumPart(String name, int metadata) { this.name = name;
/*  66 */       this.metadata = metadata;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  70 */       return this.name;
/*     */     }
/*     */     
/*     */     public String func_176610_l() {
/*  74 */       return this.name;
/*     */     }
/*     */     
/*     */ 
/*  78 */     public int toMetadata() { return this.metadata; }
/*     */     
/*     */     static {
/*  81 */       META_TO_PART = new java.util.HashMap();
/*     */       
/*     */ 
/*  84 */       for (EnumPart part : values()) {
/*  85 */         META_TO_PART.put(Integer.valueOf(part.metadata), part);
/*     */       }
/*     */     }
/*     */     
/*     */     public static EnumPart fromMetadata(int metadata) {
/*  90 */       return (EnumPart)META_TO_PART.get(Integer.valueOf(metadata));
/*     */     }
/*     */   }
/*     */   
/*  94 */   public static final PropertyEnum PART = PropertyEnum.func_177709_a("part", EnumPart.class);
/*     */   
/*     */   BlockDeityHammer() {
/*  97 */     super(Material.field_151576_e);
/*  98 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(PART, EnumPart.BASE));
/*  99 */     func_149711_c(5.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/* 104 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/* 109 */     if (func_176203_a(meta).func_177229_b(PART) == EnumPart.BASE) {
/* 110 */       return new TileEntityDeityHammer();
/*     */     }
/* 112 */     return new TileEntityVoid();
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180654_a(IBlockAccess worldIn, BlockPos pos)
/*     */   {
/* 118 */     super.func_180654_a(worldIn, pos);
/*     */     
/* 120 */     IBlockState state = worldIn.func_180495_p(pos);
/* 121 */     if (state.func_177229_b(PART) == EnumPart.BASE) {
/* 122 */       func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */     } else {
/* 124 */       func_149676_a(0.25F, 0.0F, 0.25F, 0.75F, 1.0F, 0.75F);
/*     */     }
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/* 130 */     return 3;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k() {
/* 135 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/* 140 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/* 145 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 150 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {}
/*     */   
/*     */ 
/*     */   public boolean func_149740_M()
/*     */   {
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/* 165 */     TileEntityDeityHammer tile = (TileEntityDeityHammer)BlockUtil.getTileEntity(worldIn, pos, TileEntityDeityHammer.class);
/* 166 */     return (tile != null) && (tile.getStartTicks() > 0) ? 15 : 0;
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 171 */     Object part = state.func_177229_b(PART);
/* 172 */     if (part == EnumPart.SHAFT3) {
/* 173 */       if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) {
/* 174 */         worldIn.func_175698_g(pos);
/*     */       }
/* 176 */     } else if ((part == EnumPart.SHAFT2) || (part == EnumPart.SHAFT1)) {
/* 177 */       if ((worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) || (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this)) {
/* 178 */         worldIn.func_175698_g(pos);
/*     */       }
/* 180 */     } else if (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this) {
/* 181 */       worldIn.func_175698_g(pos);
/* 182 */       if (!worldIn.field_72995_K) {
/* 183 */         func_176226_b(worldIn, pos, state, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
/*     */   {
/* 190 */     if ((!worldIn.field_72995_K) && (placer != null) && ((placer instanceof EntityPlayer))) {
/* 191 */       EntityPlayer player = (EntityPlayer)placer;
/* 192 */       if (player.func_146103_bH() != null) {
/* 193 */         TileEntityDeityHammer tile = (TileEntityDeityHammer)BlockUtil.getTileEntity(worldIn, pos, TileEntityDeityHammer.class);
/* 194 */         if (tile != null) {
/* 195 */           tile.placer = player.func_146103_bH().getId();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public Item func_180660_a(IBlockState state, Random rand, int fortune) {
/* 202 */     return state.func_177229_b(PART) == EnumPart.BASE ? super.func_180660_a(state, rand, fortune) : null;
/*     */   }
/*     */   
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {
/* 206 */     if (state.func_177229_b(PART) == EnumPart.BASE) {
/* 207 */       super.func_180653_a(worldIn, pos, state, chance, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 212 */     if (player.field_71075_bZ.field_75098_d) {
/* 213 */       Object part = state.func_177229_b(PART);
/* 214 */       if (part == EnumPart.SHAFT3) {
/* 215 */         BlockPos blockpos1 = pos.func_177977_b();
/* 216 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 217 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 220 */         blockpos1 = blockpos1.func_177977_b();
/* 221 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 222 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 225 */         blockpos1 = blockpos1.func_177977_b();
/* 226 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 227 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/* 229 */       } else if (part == EnumPart.SHAFT2) {
/* 230 */         BlockPos blockpos1 = pos.func_177977_b();
/* 231 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 232 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 235 */         blockpos1 = blockpos1.func_177977_b();
/* 236 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 237 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 240 */         blockpos1 = pos.func_177984_a();
/* 241 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 242 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/* 244 */       } else if (part == EnumPart.SHAFT1) {
/* 245 */         BlockPos blockpos1 = pos.func_177977_b();
/* 246 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 247 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 250 */         blockpos1 = pos.func_177984_a();
/* 251 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 252 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */         
/* 255 */         blockpos1 = blockpos1.func_177984_a();
/* 256 */         if (worldIn.func_180495_p(blockpos1).func_177230_c() == this) {
/* 257 */           worldIn.func_175698_g(blockpos1);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/* 264 */     return func_176223_P().func_177226_a(PART, EnumPart.fromMetadata(meta & 0x3));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/* 268 */     EnumPart part = (EnumPart)state.func_177229_b(PART);
/* 269 */     return part.toMetadata();
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e() {
/* 273 */     return new BlockState(this, new IProperty[] { PART });
/*     */   }
/*     */   
/*     */   public BlockPos getMultiBlockCorePos(IBlockAccess worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 278 */     switch ((EnumPart)state.func_177229_b(PART)) {
/*     */     case SHAFT3: 
/* 280 */       return pos.func_177979_c(3);
/*     */     case SHAFT2: 
/* 282 */       return pos.func_177979_c(2);
/*     */     case SHAFT1: 
/* 284 */       return pos.func_177977_b();
/*     */     }
/* 286 */     return pos;
/*     */   }
/*     */   
/*     */ 
/*     */   public void onTriggeredBySpell(World world, BlockPos pos, IBlockState state, World targetWorld, BlockPos targetPos, EntityPlayer caster)
/*     */   {
/* 292 */     TileEntityDeityHammer tile = (TileEntityDeityHammer)BlockUtil.getTileEntity(world, pos, TileEntityDeityHammer.class);
/* 293 */     if (tile != null)
/* 294 */       tile.setAlternateTarget(targetWorld, targetPos, caster); }
/*     */   
/*     */   public static class TileEntityDeityHammer extends TileEntity implements net.minecraft.util.ITickable { private int ticks;
/*     */     private int firing;
/*     */     private UUID placer;
/*     */     private UUID alternateTarget;
/*     */     private WorldPos alternatePos;
/*     */     public static final int MAX_START_TICKS = 150;
/*     */     public static final int MAX_FIRING_TICKS = 250;
/*     */     public static final int FIRING_GET_WORKERS = 1;
/*     */     public static final int FIRING_TAKE_SHOT = 150;
/*     */     boolean failed;
/*     */     
/* 307 */     public void setAlternateTarget(World targetWorld, BlockPos targetPos, EntityPlayer caster) { if (!this.field_145850_b.field_72995_K) {
/* 308 */         this.alternateTarget = caster.func_146103_bH().getId();
/* 309 */         this.alternatePos = new WorldPos(targetWorld, targetPos);
/* 310 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public int getStartTicks()
/*     */     {
/* 317 */       return Math.min(this.ticks, 150);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getFiringTicks()
/*     */     {
/* 325 */       return Math.min(this.firing, 250);
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 330 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public boolean isActive() {
/* 334 */       return this.field_145850_b.func_175640_z(this.field_174879_c);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_73660_a()
/*     */     {
/* 341 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 342 */       if (state.func_177230_c() != Get.blocks().DEITY_HAMMER) {
/* 343 */         return;
/*     */       }
/*     */       
/* 346 */       boolean active = isActive();
/* 347 */       boolean server = !this.field_145850_b.field_72995_K;
/* 348 */       if ((active) && (!this.failed)) {
/* 349 */         this.ticks = Math.min(this.ticks + 1, 150);
/* 350 */         if (this.ticks == 1) {
/* 351 */           this.field_145850_b.func_175685_c(this.field_174879_c, Get.blocks().DEITY_HAMMER);
/*     */         }
/* 353 */       } else if (this.ticks > 0) {
/* 354 */         this.ticks -= 1;
/* 355 */         this.firing = 0;
/* 356 */         if (this.ticks == 0) {
/* 357 */           this.field_145850_b.func_175685_c(this.field_174879_c, Get.blocks().DEITY_HAMMER);
/* 358 */           this.alternatePos = null;
/* 359 */           this.alternateTarget = null;
/* 360 */           if (!active) {
/* 361 */             this.failed = false;
/*     */           }
/* 363 */           if (server) {
/* 364 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/*     */         }
/* 367 */       } else if ((this.ticks == 0) && (!active) && (this.failed)) {
/* 368 */         this.failed = false;
/* 369 */         this.alternatePos = null;
/* 370 */         this.alternateTarget = null;
/* 371 */         if (server) {
/* 372 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 377 */       if ((this.ticks > 0) && (this.ticks < 75)) {
/* 378 */         if ((this.field_145850_b.field_72995_K) && (this.ticks % 5 == 0)) {
/* 379 */           Sound.MOD_RANDOM_CLICK.playToAllNear(this, 1.0F, 1.0F);
/*     */         }
/* 381 */       } else if (this.ticks == 150) {
/* 382 */         if (this.firing <= 250) {
/* 383 */           this.firing += 1;
/*     */         }
/*     */         
/* 386 */         if (!server) {
/* 387 */           if ((this.field_145850_b.func_82737_E() % 5L == 0L) && (this.firing <= 150))
/*     */           {
/* 389 */             float progress = Math.max(this.firing - 1, 0) / 149.0F;
/* 390 */             emoniph.intangible.Intangible.PROXY.glow(func_145831_w(), func_174877_v().func_177958_n() + 0.5D, func_174877_v().func_177956_o() + 5, func_174877_v().func_177952_p() + 0.5D)
/* 391 */               .motion(0.0D, 0.0D, 0.0D).scale(progress * 8.0F).color(4514815).duration(10);
/*     */           }
/*     */           
/* 394 */           if (this.field_145850_b.func_82737_E() % 80L == 0L) {
/* 395 */             func_174908_m();
/*     */           }
/*     */         }
/*     */         
/* 399 */         if ((this.firing == 1) && (server)) {
/* 400 */           Sound.MOD_RANDOM_GOLEM_POWERUP.playToAllNear(this);
/*     */         }
/*     */         
/* 403 */         if (((this.firing == 1) || (this.firing == 150) || (this.firing == 250)) && 
/* 404 */           (server)) {
/* 405 */           Deity deity = getDeity();
/* 406 */           if (deity == null) {
/* 407 */             setFailed();
/*     */           }
/* 409 */           else if (this.firing == 1) {
/* 410 */             if (!Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 32.0D, new SoulSet().add(SoulType.PREDATORY, 3).add(SoulType.MALLEABLE, 1), 149, BlockUtil.midBlockToVec3(this.field_174879_c))) {
/* 411 */               setFailed();
/*     */             }
/* 413 */           } else if (this.firing == 150) {
/* 414 */             if (!Get.wells().consumeSouls(this.field_145850_b, this.field_174879_c, 32.0D, new SoulSet().add(SoulType.PREDATORY, 1), BlockUtil.midBlockToVec3(this.field_174879_c))) {
/* 415 */               setFailed();
/*     */             } else {
/* 417 */               Sound.MOD_RANDOM_BIG_LASER.playToAllNear(this, 1.0F, 1.0F);
/*     */             }
/* 419 */           } else if (this.firing == 250)
/*     */           {
/* 421 */             if (deity.canReflectDamage(this.field_145850_b)) {
/* 422 */               deity.attackDeity(this.field_145850_b, 0);
/* 423 */               if (this.alternatePos != null) {
/* 424 */                 EntitySkyBeam beam = new EntitySkyBeam(this.field_145850_b);
/* 425 */                 beam.func_70012_b(this.alternatePos.getX(), this.alternatePos.getY(), this.alternatePos.getZ(), 0.0F, 0.0F);
/* 426 */                 beam.setTicksToLive(100);
/* 427 */                 this.field_145850_b.func_72838_d(beam);
/* 428 */                 Sound.MOD_RANDOM_BIG_LASER.playToAllNear(beam, 1.0F, 1.0F);
/*     */               }
/* 430 */             } else if (deity.attackDeity(this.field_145850_b, 1)) {
/* 431 */               EntityAvatar avatar = deity.createAvatar(this.field_145850_b);
/* 432 */               if ((avatar != null) && (emoniph.intangible.util.EntityUtil.trySetRandomNearbyPosition(avatar.getAvatarEntity(), this.field_145850_b, 
/* 433 */                 BlockUtil.midBlockToVec3(this.field_174879_c), Range.between(Double.valueOf(1.0D), Double.valueOf(8.0D)), 8)))
/*     */               {
/* 435 */                 if (this.placer != null) {
/* 436 */                   avatar.addTargetPlayerId(this.placer);
/*     */                 }
/*     */                 
/* 439 */                 List<EntityPlayer> players = this.field_145850_b.func_72872_a(EntityPlayer.class, 
/* 440 */                   BlockUtil.getBounds(this.field_174879_c, 16.0D, 8.0D));
/* 441 */                 for (EntityPlayer nearbyPlayer : players) {
/* 442 */                   avatar.addTargetPlayerId(nearbyPlayer.func_146103_bH().getId());
/*     */                 }
/* 444 */                 this.field_145850_b.func_72942_c(new net.minecraft.entity.effect.EntityLightningBolt(this.field_145850_b, avatar.field_70165_t, avatar.field_70163_u, avatar.field_70161_v));
/* 445 */                 this.field_145850_b.func_72838_d(avatar);
/* 446 */                 Get.fx().GLOW.sendToAllNear(this.field_145850_b, new BlockPos(avatar.field_70165_t, avatar.field_70163_u + 2.0D, avatar.field_70161_v), 1.5F, 100, deity
/* 447 */                   .getColor(), 32.0D);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 454 */         if (this.firing == 250) {
/* 455 */           setFailed();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private void setFailed() {
/* 461 */       this.failed = true;
/* 462 */       if (!this.field_145850_b.field_72995_K) {
/* 463 */         Sound.MOD_RANDOM_GOLEM_POWERDOWN.playToAllNear(this);
/* 464 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     private Deity getDeity() {
/* 469 */       List<ItemStack> offerings = new ArrayList();
/* 470 */       for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 471 */         BlockOfferingPlate.TileEntityOfferingPlate plate = (BlockOfferingPlate.TileEntityOfferingPlate)BlockUtil.getTileEntity(this.field_145850_b, this.field_174879_c.func_177972_a(facing), BlockOfferingPlate.TileEntityOfferingPlate.class);
/* 472 */         if (plate != null) {
/* 473 */           ItemStack stack = plate.func_70301_a(0);
/* 474 */           if (stack != null) {
/* 475 */             offerings.add(stack);
/*     */           }
/*     */         }
/*     */       }
/* 479 */       Deity deity = Get.deities().forWorld(this.field_145850_b).getDeityForOfferings(offerings);
/* 480 */       return deity;
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 485 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 486 */       func_145841_b(nbtTag);
/* 487 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 492 */       super.onDataPacket(net, packet);
/* 493 */       func_145839_a(packet.func_148857_g());
/* 494 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 499 */       super.func_145839_a(compound);
/* 500 */       this.ticks = compound.func_74762_e("ticks");
/* 501 */       this.firing = compound.func_74762_e("firing");
/* 502 */       this.failed = compound.func_74767_n("failed");
/* 503 */       if (compound.func_150297_b("placer", 8)) {
/* 504 */         this.placer = UUID.fromString(compound.func_74779_i("placer"));
/*     */       } else {
/* 506 */         this.placer = null;
/*     */       }
/*     */       
/* 509 */       if (compound.func_150297_b("alternateTarget", 8)) {
/* 510 */         this.alternateTarget = UUID.fromString(compound.func_74779_i("alternateTarget"));
/*     */       } else {
/* 512 */         this.alternateTarget = null;
/*     */       }
/*     */       
/* 515 */       if (compound.func_150297_b("alternatePos", 10)) {
/* 516 */         this.alternatePos = WorldPos.fromTagCompound(compound.func_74775_l("alternatePos"));
/*     */       } else {
/* 518 */         this.alternatePos = null;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 525 */       super.func_145841_b(compound);
/* 526 */       compound.func_74768_a("ticks", this.ticks);
/* 527 */       compound.func_74768_a("firing", this.firing);
/* 528 */       compound.func_74757_a("failed", this.failed);
/* 529 */       if (this.placer != null) {
/* 530 */         compound.func_74778_a("placer", this.placer.toString());
/*     */       }
/*     */       
/* 533 */       if (this.alternateTarget != null) {
/* 534 */         compound.func_74778_a("alternateTarget", this.alternateTarget.toString());
/*     */       }
/*     */       
/* 537 */       if (this.alternatePos != null) {
/* 538 */         compound.func_74782_a("alternatePos", this.alternatePos.toTagCompound());
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 547 */       return new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(2, 4, 2));
/*     */     }
/*     */     
/* 550 */     private final List beamSegmentList = com.google.common.collect.Lists.newArrayList();
/*     */     @SideOnly(Side.CLIENT)
/*     */     private long field_146016_i;
/*     */     @SideOnly(Side.CLIENT)
/*     */     private float field_146014_j;
/*     */     
/*     */     public static class BeamSegment
/*     */     {
/*     */       private final float[] field_177266_a;
/*     */       private int field_177265_b;
/*     */       
/*     */       public BeamSegment(float[] p_i45669_1_)
/*     */       {
/* 563 */         this.field_177266_a = p_i45669_1_;
/* 564 */         this.field_177265_b = 1;
/*     */       }
/*     */       
/*     */       protected void func_177262_a() {
/* 568 */         this.field_177265_b += 1;
/*     */       }
/*     */       
/*     */       public float[] func_177263_b() {
/* 572 */         return this.field_177266_a;
/*     */       }
/*     */       
/*     */       @SideOnly(Side.CLIENT)
/*     */       public int func_177264_c() {
/* 577 */         return this.field_177265_b;
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public List getBeamSegmentsUp() {
/* 583 */       return this.beamSegmentList;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public float shouldBeamRender() {
/* 588 */       if ((this.ticks == 0) || (this.firing < 150)) {
/* 589 */         return 0.0F;
/*     */       }
/* 591 */       int i = (int)(this.field_145850_b.func_82737_E() - this.field_146016_i);
/* 592 */       this.field_146016_i = this.field_145850_b.func_82737_E();
/*     */       
/* 594 */       if (i > 1) {
/* 595 */         this.field_146014_j -= i / 40.0F;
/*     */         
/* 597 */         if (this.field_146014_j < 0.0F) {
/* 598 */           this.field_146014_j = 0.0F;
/*     */         }
/*     */       }
/*     */       
/* 602 */       this.field_146014_j += 0.025F;
/*     */       
/* 604 */       if (this.field_146014_j > 1.0F) {
/* 605 */         this.field_146014_j = 1.0F;
/*     */       }
/*     */       
/* 608 */       return this.field_146014_j;
/*     */     }
/*     */     
/*     */     private void func_174908_m()
/*     */     {
/* 613 */       int posY = this.field_174879_c.func_177956_o() + 5;
/* 614 */       this.beamSegmentList.clear();
/* 615 */       BeamSegment beamsegment = new BeamSegment(net.minecraft.entity.passive.EntitySheep.func_175513_a(net.minecraft.item.EnumDyeColor.LIGHT_BLUE));
/* 616 */       this.beamSegmentList.add(beamsegment);
/*     */       
/* 618 */       for (int i1 = posY + 1; i1 < this.field_145850_b.func_72940_L(); i1++) {
/* 619 */         beamsegment.func_177262_a();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockDeityHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */