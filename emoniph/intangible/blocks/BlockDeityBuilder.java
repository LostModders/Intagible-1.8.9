/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarPower;
/*     */ import emoniph.intangible.api.deity.IDeityConstraint;
/*     */ import emoniph.intangible.api.deity.IDeityMajorWorldEffect;
/*     */ import emoniph.intangible.api.deity.IDeityMinorWorldEffect;
/*     */ import emoniph.intangible.api.deity.IDeityShrineEffect;
/*     */ import emoniph.intangible.api.deity.IDeityVoice;
/*     */ import emoniph.intangible.api.deity.IDeityWorshipEffect;
/*     */ import emoniph.intangible.api.deity.IDeityWorshipRestriction;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.deity.DeityEffectTypeRegistry;
/*     */ import emoniph.intangible.deity.HeadSpec;
/*     */ import emoniph.intangible.deity.ModDeityEffects;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.EnumDiagonalFacing;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.item.EnumDyeColor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockDeityBuilder extends BlockContainer implements IBlock
/*     */ {
/*  48 */   public static final net.minecraft.block.properties.PropertyBool CORE = net.minecraft.block.properties.PropertyBool.func_177716_a("core");
/*     */   private boolean suspend;
/*     */   
/*  51 */   BlockDeityBuilder() { super(net.minecraft.block.material.Material.field_151576_e);
/*  52 */     func_149711_c(5.0F);
/*  53 */     func_149672_a(field_149769_e);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  58 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  79 */     if (((Boolean)func_176203_a(meta).func_177229_b(CORE)).booleanValue()) {
/*  80 */       return new TileEntityDeityBuilder();
/*     */     }
/*  82 */     return new TileEntityVoid();
/*     */   }
/*     */   
/*     */ 
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/*  88 */     return func_176223_P().func_177226_a(CORE, Boolean.valueOf((meta & 0x1) == 1));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/*  93 */     return ((Boolean)state.func_177229_b(CORE)).booleanValue() ? 1 : 0;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/*  98 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { CORE });
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 103 */     if (((Boolean)state.func_177229_b(CORE)).booleanValue()) {
/* 104 */       namePlinths(worldIn, pos);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void namePlinths(World worldIn, BlockPos pos) {
/* 109 */     if (worldIn.field_72995_K) {
/* 110 */       namePlinth(worldIn, pos.func_177982_a(-4, 0, -4), "intangible:container.plinth.sacreditem1");
/* 111 */       namePlinth(worldIn, pos.func_177982_a(-4, 0, -3), "intangible:container.plinth.sacreditem2");
/* 112 */       namePlinth(worldIn, pos.func_177982_a(-3, 0, -4), "intangible:container.plinth.sacreditem3");
/*     */       
/* 114 */       namePlinth(worldIn, pos.func_177982_a(0, 0, 4), "intangible:container.plinth.voice");
/*     */       
/* 116 */       namePlinth(worldIn, pos.func_177982_a(4, 0, -4), "intangible:container.plinth.color");
/* 117 */       namePlinth(worldIn, pos.func_177982_a(4, 0, -3), "intangible:container.plinth.worship1");
/* 118 */       namePlinth(worldIn, pos.func_177982_a(3, 0, -4), "intangible:container.plinth.worship2");
/*     */       
/* 120 */       namePlinth(worldIn, pos.func_177982_a(-4, 0, 0), "intangible:container.plinth.avatarbody");
/* 121 */       namePlinth(worldIn, pos.func_177982_a(4, 0, 0), "intangible:container.plinth.avatarpower");
/*     */       
/* 123 */       namePlinth(worldIn, pos.func_177982_a(-4, 0, 4), "intangible:container.plinth.minoreffect");
/* 124 */       namePlinth(worldIn, pos.func_177982_a(-4, 0, 3), "intangible:container.plinth.majoreffect");
/*     */       
/* 126 */       namePlinth(worldIn, pos.func_177982_a(-3, 0, 4), "intangible:container.plinth.constraint");
/*     */       
/* 128 */       namePlinth(worldIn, pos.func_177982_a(4, 0, 4), "intangible:container.plinth.templeeffect");
/* 129 */       namePlinth(worldIn, pos.func_177982_a(4, 0, 3), "intangible:container.plinth.blessingeffect");
/* 130 */       namePlinth(worldIn, pos.func_177982_a(3, 0, 4), "intangible:container.plinth.curseeffect");
/*     */     }
/*     */   }
/*     */   
/*     */   private static void clearPlinths(World worldIn, BlockPos pos) {
/* 135 */     namePlinth(worldIn, pos.func_177982_a(-4, 0, -4), null);
/* 136 */     namePlinth(worldIn, pos.func_177982_a(-4, 0, -3), null);
/* 137 */     namePlinth(worldIn, pos.func_177982_a(-3, 0, -4), null);
/*     */     
/* 139 */     namePlinth(worldIn, pos.func_177982_a(0, 0, 4), null);
/*     */     
/* 141 */     namePlinth(worldIn, pos.func_177982_a(4, 0, -4), null);
/* 142 */     namePlinth(worldIn, pos.func_177982_a(4, 0, -3), null);
/* 143 */     namePlinth(worldIn, pos.func_177982_a(3, 0, -4), null);
/*     */     
/* 145 */     namePlinth(worldIn, pos.func_177982_a(-4, 0, 0), null);
/* 146 */     namePlinth(worldIn, pos.func_177982_a(4, 0, 0), null);
/*     */     
/* 148 */     namePlinth(worldIn, pos.func_177982_a(-4, 0, 4), null);
/* 149 */     namePlinth(worldIn, pos.func_177982_a(-4, 0, 3), null);
/*     */     
/* 151 */     namePlinth(worldIn, pos.func_177982_a(-3, 0, 4), null);
/*     */     
/* 153 */     namePlinth(worldIn, pos.func_177982_a(4, 0, 4), null);
/* 154 */     namePlinth(worldIn, pos.func_177982_a(4, 0, 3), null);
/* 155 */     namePlinth(worldIn, pos.func_177982_a(3, 0, 4), null);
/*     */   }
/*     */   
/*     */   private static void namePlinth(World worldIn, BlockPos plinthPos, String unlocalizedName) {
/* 159 */     IBlockState state = worldIn.func_180495_p(plinthPos);
/* 160 */     if ((state != null) && (state.func_177230_c() == Get.blocks().PLINTH)) {
/* 161 */       BlockPlinth.TileEntityPlinth plinth = (BlockPlinth.TileEntityPlinth)BlockUtil.getTileEntity(worldIn, plinthPos, BlockPlinth.TileEntityPlinth.class);
/* 162 */       if (plinth != null) {
/* 163 */         plinth.setCustomName(unlocalizedName != null ? net.minecraft.util.StatCollector.func_74838_a(unlocalizedName) : "");
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void consumeItemInPlinth(World worldIn, BlockPos pos, BlockPos plinthPos) {
/* 169 */     IBlockState state = worldIn.func_180495_p(plinthPos);
/* 170 */     if ((state != null) && (state.func_177230_c() == Get.blocks().PLINTH)) {
/* 171 */       BlockPlinth.TileEntityPlinth plinth = (BlockPlinth.TileEntityPlinth)BlockUtil.getTileEntity(worldIn, plinthPos, BlockPlinth.TileEntityPlinth.class);
/* 172 */       int slot = 0;
/* 173 */       if ((plinth != null) && (plinth.func_70301_a(slot) != null)) {
/* 174 */         plinth.func_70298_a(slot, 1);
/* 175 */         if (!worldIn.field_72995_K) {
/* 176 */           Get.fx().GLOW.sendToAllNear(worldIn, plinthPos.func_177984_a(), 0.5F, 40, 39168, 1, emoniph.intangible.util.BlockPosUtil.centerOf(pos), 0.2F, 32.0D);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void consumeItemsInPlinths(World worldIn, BlockPos pos) {
/* 183 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(-4, 0, -4));
/* 184 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(-4, 0, -3));
/* 185 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(-3, 0, -4));
/*     */     
/* 187 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(0, 0, 4));
/*     */     
/* 189 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(4, 0, -4));
/* 190 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(4, 0, -3));
/* 191 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(3, 0, -4));
/*     */     
/* 193 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(-4, 0, 0));
/* 194 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(4, 0, 0));
/*     */     
/* 196 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(-4, 0, 4));
/* 197 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(-4, 0, 3));
/*     */     
/* 199 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(-3, 0, 4));
/*     */     
/* 201 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(4, 0, 4));
/* 202 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(4, 0, 3));
/* 203 */     consumeItemInPlinth(worldIn, pos, pos.func_177982_a(3, 0, 4));
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {}
/*     */   
/*     */ 
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 212 */     if (!worldIn.field_72995_K) {
/* 213 */       if (((Boolean)state.func_177229_b(CORE)).booleanValue()) {
/* 214 */         TileEntityDeityBuilder core = (TileEntityDeityBuilder)BlockUtil.getTileEntity(worldIn, pos, TileEntityDeityBuilder.class);
/* 215 */         if (core != null) {
/* 216 */           tryDissolveFabricatorStructure(worldIn, pos, pos, state);
/*     */         }
/*     */       }
/*     */       else {
/* 220 */         TileEntityVoid tile = (TileEntityVoid)BlockUtil.getTileEntity(worldIn, pos, TileEntityVoid.class);
/* 221 */         if (tile != null) {
/* 222 */           BlockPos corePos = tile.getOwnerPos();
/* 223 */           if ((corePos != null) && 
/* 224 */             (worldIn.func_180495_p(corePos).func_177230_c() == this)) {
/* 225 */             TileEntityDeityBuilder core = (TileEntityDeityBuilder)BlockUtil.getTileEntity(worldIn, corePos, TileEntityDeityBuilder.class);
/* 226 */             if (core != null) {
/* 227 */               tryDissolveFabricatorStructure(worldIn, corePos, pos, state);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 235 */       clearPlinths(worldIn, pos);
/*     */     }
/* 237 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */ 
/*     */   private void tryDissolveFabricatorStructure(World worldIn, BlockPos pos, BlockPos removePos, IBlockState state)
/*     */   {
/* 243 */     if (this.suspend) {
/* 244 */       return;
/*     */     }
/*     */     
/* 247 */     this.suspend = true;
/*     */     
/* 249 */     for (int i = 0; i <= 4; i++) {
/* 250 */       worldIn.func_175698_g(pos.func_177981_b(i));
/*     */     }
/*     */     
/* 253 */     for (EnumFacing face : EnumFacing.field_176754_o) {
/* 254 */       BlockPos tPos = pos.func_177972_a(face);
/* 255 */       for (int i = 0; i <= 4; i++) {
/* 256 */         BlockPos newPos = tPos.func_177981_b(i);
/* 257 */         if (!newPos.equals(removePos)) {
/* 258 */           worldIn.func_180501_a(newPos, 
/* 259 */             Get.blocks().SOUL_CAGE.func_176223_P().func_177226_a(BlockSoulCage.VARIANT, EnumSoulType.MALLEABLE), 2);
/*     */         }
/*     */         else {
/* 262 */           worldIn.func_72838_d(new EntityItem(worldIn, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, new ItemStack(
/* 263 */             Get.blocks().SOUL_CAGE, 1, EnumSoulType.MALLEABLE.getMetadata())));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 268 */     for (EnumDiagonalFacing face : EnumDiagonalFacing.DIAGONALS) {
/* 269 */       BlockPos tPos = face.offset(pos);
/* 270 */       for (int i = 0; i <= 2; i++) {
/* 271 */         BlockPos newPos = tPos.func_177981_b(i);
/* 272 */         if (!newPos.equals(removePos)) {
/* 273 */           worldIn.func_180501_a(newPos, 
/* 274 */             Get.blocks().SOUL_CAGE.func_176223_P().func_177226_a(BlockSoulCage.VARIANT, EnumSoulType.IMMUTABLE), 2);
/*     */         } else {
/* 276 */           worldIn.func_72838_d(new EntityItem(worldIn, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, new ItemStack(
/* 277 */             Get.blocks().SOUL_CAGE, 1, EnumSoulType.IMMUTABLE.getMetadata())));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 282 */     if (pos.equals(removePos)) {
/* 283 */       worldIn.func_72838_d(new EntityItem(worldIn, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, new ItemStack(
/* 284 */         Get.blocks().SOUL_FORGE)));
/*     */     } else {
/* 286 */       emoniph.intangible.items.ItemSoulForge.place(worldIn, pos, EnumFacing.UP);
/*     */     }
/*     */     
/* 289 */     this.suspend = false;
/*     */   }
/*     */   
/*     */   public static class TileEntityDeityBuilder extends TileEntity implements net.minecraft.util.ITickable
/*     */   {
/*     */     public static final int MAX_START_TICKS = 100;
/*     */     public int startTicks;
/*     */     public int counter;
/*     */     private boolean failed;
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState) {
/* 300 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound) {
/* 304 */       super.func_145839_a(compound);
/* 305 */       this.failed = compound.func_74767_n("failed");
/* 306 */       this.startTicks = compound.func_74762_e("startTicks");
/* 307 */       this.counter = compound.func_74762_e("counter");
/* 308 */       this.color = EnumDyeColor.func_176766_a(compound.func_74762_e("color"));
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound) {
/* 312 */       super.func_145841_b(compound);
/* 313 */       compound.func_74757_a("failed", this.failed);
/* 314 */       compound.func_74768_a("startTicks", this.startTicks);
/* 315 */       compound.func_74768_a("counter", this.counter);
/* 316 */       compound.func_74768_a("color", this.color.func_176767_b());
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 321 */       NBTTagCompound compound = new NBTTagCompound();
/* 322 */       func_145841_b(compound);
/* 323 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(net.minecraft.network.NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 328 */       super.onDataPacket(net, packet);
/* 329 */       func_145839_a(packet.func_148857_g());
/* 330 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 337 */     private EnumDyeColor color = EnumDyeColor.PURPLE;
/*     */     
/*     */     private static final int COUNTER_GET_WORKERS = 1;
/*     */     private static final int COUNTER_CONSUME_SOULS = 200;
/*     */     private static final int COUNTER_CREATE_DEITY = 500;
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 345 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 346 */       if (state.func_177230_c() != Get.blocks().DEITY_BUILDER) {
/* 347 */         return;
/*     */       }
/*     */       
/*     */ 
/* 351 */       if (this.field_145850_b.func_82737_E() % 200L == 3L) {
/* 352 */         BlockDeityBuilder.namePlinths(this.field_145850_b, this.field_174879_c);
/*     */       }
/*     */       
/* 355 */       boolean active = isActive();
/* 356 */       boolean server = !this.field_145850_b.field_72995_K;
/* 357 */       if ((active) && (!this.failed) && (checkMultiBlock())) {
/* 358 */         this.startTicks = Math.min(this.startTicks + 1, 100);
/* 359 */         if ((this.startTicks == 2) && (server)) {
/* 360 */           Sound.MOD_RANDOM_GOLEM_POWERUP.playToAllNear(this);
/*     */         }
/* 362 */       } else if (this.startTicks > 0) {
/* 363 */         this.startTicks -= 1;
/* 364 */         this.counter = 0;
/* 365 */         if (this.startTicks == 0) {
/* 366 */           this.failed = false;
/* 367 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/* 368 */           this.color = EnumDyeColor.PURPLE;
/*     */         }
/*     */       }
/*     */       
/* 372 */       if (this.startTicks == 100) {
/* 373 */         if (this.counter <= 500) {
/* 374 */           this.counter += 1;
/*     */         }
/*     */         
/* 377 */         if ((this.field_145850_b.func_82737_E() % 5L == 0L) && 
/* 378 */           (!server))
/*     */         {
/* 380 */           emoniph.intangible.Intangible.PROXY.glow(func_145831_w(), func_174877_v().func_177958_n() + 0.5D, func_174877_v().func_177956_o() + 1.2F, func_174877_v().func_177952_p() + 0.5D).motion(0.0D, 0.03D, 0.0D).scale(4.0F).color(16776960).duration(120);
/*     */         }
/*     */         
/*     */ 
/* 384 */         if ((!server) && (this.field_145850_b.func_82737_E() % 80L == 0L)) {
/* 385 */           func_174908_m();
/*     */         }
/*     */         
/* 388 */         if ((this.counter == 1) || (this.counter == 200) || (this.counter == 500)) {
/* 389 */           ItemStack itemA = getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, -4));
/* 390 */           ItemStack itemB = getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, -3));
/* 391 */           ItemStack itemC = getStackFromPlinth(this.field_174879_c.func_177982_a(-3, 0, -4));
/*     */           
/*     */ 
/* 394 */           boolean itemsDiffer = (!ItemStack.func_179545_c(itemA, itemB)) && (!ItemStack.func_179545_c(itemB, itemC)) && (!ItemStack.func_179545_c(itemA, itemC));
/*     */           
/* 396 */           Deity existing = Get.deities().forWorld(this.field_145850_b).getDeityForOfferings(java.util.Arrays.asList(new ItemStack[] { itemA, itemB, itemC }));
/*     */           
/*     */ 
/* 399 */           ItemStack dye = getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, -4));
/* 400 */           IDeityWorshipRestriction restrictionA = (IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, -3)));
/* 401 */           IDeityWorshipRestriction restrictionB = (IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(3, 0, -4)));
/* 402 */           IDeityVoice voice = (IDeityVoice)Get.deityEffects().voiceRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(0, 0, 4)));
/* 403 */           IDeityAvatarBody avatarBody = (IDeityAvatarBody)Get.deityEffects().bodyRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, 0)));
/* 404 */           IDeityAvatarPower avatarPower = (IDeityAvatarPower)Get.deityEffects().avatarPowerRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, 0)));
/* 405 */           IDeityMinorWorldEffect minor = (IDeityMinorWorldEffect)Get.deityEffects().worldMinorEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, 4)));
/* 406 */           IDeityMajorWorldEffect major = (IDeityMajorWorldEffect)Get.deityEffects().worldMajorEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, 3)));
/* 407 */           IDeityConstraint constraint = (IDeityConstraint)Get.deityEffects().constraintRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-3, 0, 4)));
/* 408 */           IDeityShrineEffect temple = (IDeityShrineEffect)Get.deityEffects().shrineEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, 4)));
/* 409 */           IDeityWorshipEffect blessing = (IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, 3)));
/* 410 */           IDeityWorshipEffect curse = (IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(3, 0, 4)));
/*     */           
/* 412 */           boolean restrictionsDiffer = (restrictionA != null) && (restrictionA != restrictionB);
/* 413 */           boolean blessingsDiffer = (blessing != null) && (blessing != curse);
/*     */           
/* 415 */           if ((itemA != null) && (itemB != null) && (itemC != null) && (dye != null) && (dye.func_77973_b() == net.minecraft.init.Items.field_151100_aR) && (voice != null) && (restrictionA != null) && (restrictionB != null) && (avatarBody != null) && (avatarPower != null) && (minor != null) && (major != null) && (temple != null) && (blessing != null) && (curse != null) && (constraint != null) && (restrictionsDiffer) && (blessingsDiffer) && (existing == null) && (itemsDiffer))
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 422 */             if (this.counter == 1) {
/* 423 */               if (server)
/*     */               {
/*     */ 
/*     */ 
/* 427 */                 ISoulSet souls = new SoulSet().add(SoulType.MALLEABLE, 2).add(SoulType.BENIGN, 2).add(SoulType.WISE, 1);
/*     */                 
/* 429 */                 if (Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 32.0D, souls, 500, BlockUtil.midBlockToVec3(this.field_174879_c))) {
/* 430 */                   generateProgressEvent(this.counter, 20);
/* 431 */                   this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */                 } else {
/* 433 */                   setFailed();
/*     */                 }
/*     */               }
/* 436 */             } else if (this.counter == 200) {
/* 437 */               if (server)
/*     */               {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 444 */                 ISoulSet souls = new SoulSet().add(SoulType.MALLEABLE, 1).add(SoulType.PREDATORY, 1).add(SoulType.UNHINGED, 1).add(SoulType.BENIGN, 1).add(SoulType.IMMUTABLE, 1).add(SoulType.WISE, 1);
/*     */                 
/* 446 */                 Get.deityEffects().addCostsFor(voice, souls);
/* 447 */                 Get.deityEffects().addCostsFor(avatarBody, souls);
/* 448 */                 Get.deityEffects().addCostsFor(avatarPower, souls);
/* 449 */                 Get.deityEffects().addCostsFor(restrictionA, souls);
/* 450 */                 Get.deityEffects().addCostsFor(restrictionB, souls);
/* 451 */                 Get.deityEffects().addCostsFor(minor, souls);
/* 452 */                 Get.deityEffects().addCostsFor(major, souls);
/* 453 */                 Get.deityEffects().addCostsFor(temple, souls);
/* 454 */                 Get.deityEffects().addCostsFor(blessing, souls);
/* 455 */                 Get.deityEffects().addCostsFor(curse, souls);
/* 456 */                 Get.deityEffects().addCostsFor(constraint, souls);
/*     */                 
/* 458 */                 if ((HeadSpec.isHeadValid(this.field_145850_b, this.field_174879_c)) && (Get.wells().consumeSouls(this.field_145850_b, this.field_174879_c, 32.0D, souls, BlockUtil.midBlockToVec3(this.field_174879_c.func_177981_b(4))))) {
/* 459 */                   generateProgressEvent(this.counter, 25);
/* 460 */                   this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */                 } else {
/* 462 */                   setFailed();
/*     */                 }
/*     */               }
/* 465 */             } else if ((this.counter == 500) && 
/* 466 */               (server)) {
/* 467 */               generateProgressEvent(this.counter, 30);
/* 468 */               this.color = EnumDyeColor.func_176766_a(dye.func_77952_i());
/* 469 */               int myColor = net.minecraft.item.ItemDye.field_150922_c[net.minecraft.util.MathHelper.func_76125_a(dye.func_77952_i(), 0, net.minecraft.item.ItemDye.field_150922_c.length - 1)];
/* 470 */               HeadSpec spec = HeadSpec.digitizeHead(this.field_145850_b, this.field_174879_c, myColor, true);
/*     */               
/* 472 */               Deity deity = new Deity(this.field_145850_b, spec, myColor, voice, itemA, itemB, itemC, restrictionA, restrictionB, avatarBody, avatarPower, minor, major, temple, blessing, curse, constraint);
/*     */               
/*     */ 
/* 475 */               Get.deities().createDeity(this.field_145850_b, deity);
/* 476 */               deity.talkToWorld(this.field_145850_b, "entity.intangible.deity.awakened");
/* 477 */               this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */               
/* 479 */               BlockDeityBuilder.consumeItemsInPlinths(this.field_145850_b, this.field_174879_c);
/*     */               
/* 481 */               Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c.func_177979_c(5), 3.0F, 200, 10040166, 32.0D);
/*     */             }
/*     */             
/*     */           }
/*     */           else {
/* 486 */             setFailed();
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public ISoulSet getClientSoulCosts() {
/* 494 */       ItemStack itemA = getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, -4));
/* 495 */       ItemStack itemB = getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, -3));
/* 496 */       ItemStack itemC = getStackFromPlinth(this.field_174879_c.func_177982_a(-3, 0, -4));
/* 497 */       ItemStack dye = getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, -4));
/*     */       
/* 499 */       IDeityWorshipRestriction restrictionA = (IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, -3)));
/* 500 */       IDeityWorshipRestriction restrictionB = (IDeityWorshipRestriction)Get.deityEffects().worshipRestrictionRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(3, 0, -4)));
/* 501 */       IDeityVoice voice = (IDeityVoice)Get.deityEffects().voiceRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(0, 0, 4)));
/* 502 */       IDeityAvatarBody avatarBody = (IDeityAvatarBody)Get.deityEffects().bodyRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, 0)));
/* 503 */       IDeityAvatarPower avatarPower = (IDeityAvatarPower)Get.deityEffects().avatarPowerRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, 0)));
/* 504 */       IDeityMinorWorldEffect minor = (IDeityMinorWorldEffect)Get.deityEffects().worldMinorEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, 4)));
/* 505 */       IDeityMajorWorldEffect major = (IDeityMajorWorldEffect)Get.deityEffects().worldMajorEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-4, 0, 3)));
/* 506 */       IDeityConstraint constraint = (IDeityConstraint)Get.deityEffects().constraintRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(-3, 0, 4)));
/* 507 */       IDeityShrineEffect temple = (IDeityShrineEffect)Get.deityEffects().shrineEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, 4)));
/* 508 */       IDeityWorshipEffect blessing = (IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(4, 0, 3)));
/* 509 */       IDeityWorshipEffect curse = (IDeityWorshipEffect)Get.deityEffects().worshipEffectRegistry.getEffectForSelector(getStackFromPlinth(this.field_174879_c.func_177982_a(3, 0, 4)));
/*     */       
/* 511 */       if ((restrictionA != null) || (restrictionB != null) || (voice != null) || (avatarBody != null) || (avatarPower != null) || (minor != null) || (major != null) || (constraint != null) || (temple != null) || (blessing != null) || (curse != null) || (itemA != null) || (itemB != null) || (itemC != null) || (dye != null))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 520 */         ISoulSet souls = new SoulSet().add(SoulType.MALLEABLE, 1).add(SoulType.PREDATORY, 1).add(SoulType.UNHINGED, 1).add(SoulType.BENIGN, 1).add(SoulType.IMMUTABLE, 1).add(SoulType.WISE, 1);
/*     */         
/* 522 */         Get.deityEffects().addCostsFor(voice, souls);
/* 523 */         Get.deityEffects().addCostsFor(avatarBody, souls);
/* 524 */         Get.deityEffects().addCostsFor(avatarPower, souls);
/* 525 */         Get.deityEffects().addCostsFor(restrictionA, souls);
/* 526 */         Get.deityEffects().addCostsFor(restrictionB, souls);
/* 527 */         Get.deityEffects().addCostsFor(minor, souls);
/* 528 */         Get.deityEffects().addCostsFor(major, souls);
/* 529 */         Get.deityEffects().addCostsFor(temple, souls);
/* 530 */         Get.deityEffects().addCostsFor(blessing, souls);
/* 531 */         Get.deityEffects().addCostsFor(curse, souls);
/* 532 */         Get.deityEffects().addCostsFor(constraint, souls);
/*     */         
/* 534 */         return souls;
/*     */       }
/* 536 */       return null;
/*     */     }
/*     */     
/*     */     private void generateProgressEvent(int counter, int density)
/*     */     {
/* 541 */       if (!this.field_145850_b.field_72995_K) {
/* 542 */         Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c.func_177981_b(5), 0.5F, density, 10027263, 3, new net.minecraft.util.Vec3(this.field_174879_c.func_177958_n(), this.field_174879_c.func_177956_o(), this.field_174879_c.func_177952_p()), 0.2F, 32.0D);
/* 543 */         if (counter != 500) {
/* 544 */           Sound.MOD_RANDOM_DISCOVERY.playToAllNear(this, 1.0F, 0.8F);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private void setFailed() {
/* 550 */       this.failed = true;
/* 551 */       if (this.field_145850_b.field_72995_K) {
/* 552 */         Sound.MOD_RANDOM_GOLEM_POWERDOWN.playToAllNear(this);
/* 553 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     private ItemStack getStackFromPlinth(BlockPos plinthPos)
/*     */     {
/* 559 */       IBlockState state = this.field_145850_b.func_180495_p(plinthPos);
/* 560 */       if ((state != null) && (state.func_177230_c() == Get.blocks().PLINTH)) {
/* 561 */         BlockPlinth.TileEntityPlinth plinth = (BlockPlinth.TileEntityPlinth)BlockUtil.getTileEntity(this.field_145850_b, plinthPos, BlockPlinth.TileEntityPlinth.class);
/* 562 */         if (plinth != null) {
/* 563 */           ItemStack stack = plinth.func_70301_a(0);
/* 564 */           if (stack != null) {
/* 565 */             return stack;
/*     */           }
/*     */         }
/*     */       }
/* 569 */       return null;
/*     */     }
/*     */     
/* 572 */     private static final int[][] PATTERN = { { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1, 1 } };
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
/*     */     private boolean checkMultiBlock()
/*     */     {
/* 585 */       BlockPos center = this.field_174879_c.func_177977_b();
/* 586 */       IBlockState benign = Get.blocks().SOUL_CAGE.func_176223_P().func_177226_a(BlockSoulCage.VARIANT, EnumSoulType.BENIGN);
/* 587 */       for (int dz = 0; dz < PATTERN.length; dz++) {
/* 588 */         for (dx = 0; dx < PATTERN[dz].length; dx++) {
/* 589 */           testPos = center.func_177982_a(-PATTERN[dz].length / 2 + dx, 0, -PATTERN.length / 2 + dz);
/* 590 */           IBlockState test = this.field_145850_b.func_180495_p(testPos);
/* 591 */           if ((PATTERN[dx][dz] == 1) && (test != benign)) {
/* 592 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 597 */       dz = EnumDiagonalFacing.DIAGONALS;int dx = dz.length; for (BlockPos testPos = 0; testPos < dx; testPos++) { EnumDiagonalFacing facing = dz[testPos];
/* 598 */         BlockPos testPosTop = facing.offset(this.field_174879_c, 4);
/* 599 */         for (int y = 1; y < 8; y++) {
/* 600 */           BlockPos testPos = testPosTop.func_177979_c(y);
/* 601 */           if (this.field_145850_b.func_180495_p(testPos) != benign) {
/* 602 */             return false;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 607 */       return true;
/*     */     }
/*     */     
/*     */     public boolean isActive()
/*     */     {
/* 612 */       return (this.field_145850_b.func_175640_z(this.field_174879_c.func_177978_c())) || (this.field_145850_b.func_175640_z(this.field_174879_c.func_177968_d())) || (this.field_145850_b.func_175640_z(this.field_174879_c.func_177974_f())) || (this.field_145850_b.func_175640_z(this.field_174879_c.func_177976_e()));
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public double func_145833_n() {
/* 617 */       return 65536.0D;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/*     */     public net.minecraft.util.AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 625 */       return INFINITE_EXTENT_AABB;
/*     */     }
/*     */     
/* 628 */     private final List beamSegmentList = com.google.common.collect.Lists.newArrayList();
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
/* 641 */         this.field_177266_a = p_i45669_1_;
/* 642 */         this.field_177265_b = 1;
/*     */       }
/*     */       
/*     */       protected void func_177262_a() {
/* 646 */         this.field_177265_b += 1;
/*     */       }
/*     */       
/*     */       public float[] func_177263_b() {
/* 650 */         return this.field_177266_a;
/*     */       }
/*     */       
/*     */       @SideOnly(Side.CLIENT)
/*     */       public int func_177264_c() {
/* 655 */         return this.field_177265_b;
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public List func_174907_n() {
/* 661 */       return this.beamSegmentList;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public float shouldBeamRender() {
/* 666 */       if ((this.startTicks == 0) || (this.counter < 500)) {
/* 667 */         return 0.0F;
/*     */       }
/* 669 */       int i = (int)(this.field_145850_b.func_82737_E() - this.field_146016_i);
/* 670 */       this.field_146016_i = this.field_145850_b.func_82737_E();
/*     */       
/* 672 */       if (i > 1) {
/* 673 */         this.field_146014_j -= i / 40.0F;
/*     */         
/* 675 */         if (this.field_146014_j < 0.0F) {
/* 676 */           this.field_146014_j = 0.0F;
/*     */         }
/*     */       }
/*     */       
/* 680 */       this.field_146014_j += 0.025F;
/*     */       
/* 682 */       if (this.field_146014_j > 1.0F) {
/* 683 */         this.field_146014_j = 1.0F;
/*     */       }
/*     */       
/* 686 */       return this.field_146014_j;
/*     */     }
/*     */     
/*     */ 
/*     */     private void func_174908_m()
/*     */     {
/* 692 */       int posY = this.field_174879_c.func_177956_o() + 5;
/*     */       
/* 694 */       this.beamSegmentList.clear();
/* 695 */       BeamSegment beamsegment = new BeamSegment(net.minecraft.entity.passive.EntitySheep.func_175513_a(this.color));
/* 696 */       this.beamSegmentList.add(beamsegment);
/*     */       
/*     */ 
/*     */ 
/* 700 */       for (int i1 = posY + 1; i1 < this.field_145850_b.func_72940_L(); i1++) {
/* 701 */         beamsegment.func_177262_a();
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockDeityBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */