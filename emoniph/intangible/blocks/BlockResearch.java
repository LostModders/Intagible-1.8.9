/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntitySoul;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.souls.SoulRegistry;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.PropertyBool;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class BlockResearch extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*  42 */   public static final PropertyBool POWERED = PropertyBool.func_177716_a("powered");
/*     */   
/*     */   private final int equipmentCode;
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  48 */     return 57;
/*     */   }
/*     */   
/*     */   protected BlockResearch(Material materialIn, int equipmentCode) {
/*  52 */     super(materialIn);
/*     */     
/*  54 */     this.equipmentCode = equipmentCode;
/*     */     
/*  56 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(POWERED, Boolean.valueOf(false)));
/*     */     
/*  58 */     func_149676_a(0.2F, 0.0F, 0.2F, 0.8F, 0.9F, 0.8F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  63 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public boolean isInputFace(EnumFacing face, TileEntityResearchBlock tile)
/*     */   {
/*  68 */     return tile.inputFace == face;
/*     */   }
/*     */   
/*     */   public boolean isOutputFace(EnumFacing face, TileEntityResearchBlock tile) {
/*  72 */     if (tile.inputFace == null)
/*  73 */       return false;
/*  74 */     if (tile.inputFace.func_176736_b() >= 0) {
/*  75 */       return face != tile.inputFace;
/*     */     }
/*  77 */     return tile.inputFace != face;
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_149645_b()
/*     */   {
/*  83 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/*  98 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { POWERED });
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 103 */     return func_176223_P().func_177226_a(POWERED, Boolean.valueOf((meta & 0x1) == 1));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 108 */     return ((Boolean)state.func_177229_b(POWERED)).booleanValue() ? 1 : 0;
/*     */   }
/*     */   
/*     */   public int func_176211_b(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/* 113 */     return super.func_180656_a(worldIn, pos, state, side);
/*     */   }
/*     */   
/*     */   public int func_180656_a(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/* 118 */     TileEntityResearchBlock tile = (TileEntityResearchBlock)BlockUtil.getTileEntity(worldIn, pos, TileEntityResearchBlock.class);
/* 119 */     if (tile != null) {
/* 120 */       return (((Boolean)state.func_177229_b(POWERED)).booleanValue()) && (!isInputFace(side.func_176734_d(), tile)) ? 15 : 0;
/*     */     }
/* 122 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_149744_f()
/*     */   {
/* 128 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {}
/*     */   
/*     */ 
/*     */   public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, net.minecraft.item.ItemStack stack)
/*     */   {
/* 138 */     updateState(worldIn, pos, state);
/* 139 */     worldIn.func_175685_c(pos, this);
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 144 */     worldIn.func_175685_c(pos, this);
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 149 */     updateState(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/* 155 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   private void updateState(World worldIn, BlockPos pos, IBlockState state) {
/* 159 */     if (!worldIn.field_72995_K) {
/* 160 */       boolean currentPower = ((Boolean)state.func_177229_b(POWERED)).booleanValue();
/* 161 */       if (worldIn.func_175640_z(pos)) {
/* 162 */         worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(true)));
/*     */       } else {
/* 164 */         worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(false)));
/*     */       }
/*     */       
/* 167 */       state = worldIn.func_180495_p(pos);
/*     */       
/* 169 */       updateLinks(worldIn, pos, state);
/*     */       
/* 171 */       if (currentPower != ((Boolean)state.func_177229_b(POWERED)).booleanValue()) {
/* 172 */         onPowerChanged(worldIn, pos, state, ((Boolean)state.func_177229_b(POWERED)).booleanValue());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   protected void onPowerChanged(World worldIn, BlockPos pos, IBlockState state, boolean powered) {
/* 178 */     worldIn.func_175685_c(pos, this);
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand)
/*     */   {
/* 184 */     TileEntityResearchBlock tile = (TileEntityResearchBlock)BlockUtil.getTileEntity(worldIn, pos, TileEntityResearchBlock.class);
/* 185 */     if ((tile != null) && 
/* 186 */       (tile.soulType != null) && 
/* 187 */       (tile.valid) && 
/* 188 */       (worldIn.field_73012_v.nextInt(2) == 0))
/*     */     {
/* 190 */       emoniph.intangible.Intangible.PROXY.glow(worldIn, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 1, pos.func_177952_p() + 0.5D).color(worldIn.field_73012_v.nextInt()).scale(0.7F).durationScale(0.75F).motion(-0.003D + rand.nextDouble() * 0.006D, 0.03D, -0.003D + rand.nextDouble() * 0.006D);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand)
/*     */   {
/* 199 */     if (!worldIn.field_72995_K) {
/* 200 */       TileEntityResearchBlock tile = (TileEntityResearchBlock)BlockUtil.getTileEntity(worldIn, pos, TileEntityResearchBlock.class);
/* 201 */       if (tile != null) {
/* 202 */         tile.processUpdate();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isOutputFace(World worldIn, BlockPos pos, EnumFacing face) {
/* 208 */     IBlockState otherState = worldIn.func_180495_p(pos);
/* 209 */     if ((otherState.func_177230_c() instanceof BlockResearch)) {
/* 210 */       return isOutputFace(face, (TileEntityResearchBlock)BlockUtil.getTileEntity(worldIn, pos, TileEntityResearchBlock.class));
/*     */     }
/* 212 */     return false;
/*     */   }
/*     */   
/*     */   private void updateLinks(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 217 */     if (!worldIn.field_72995_K) {
/* 218 */       boolean changed = false;
/* 219 */       TileEntityResearchBlock tile = (TileEntityResearchBlock)BlockUtil.getTileEntity(worldIn, pos, TileEntityResearchBlock.class);
/* 220 */       if (tile != null)
/*     */       {
/* 222 */         EnumFacing inputFace = tile.getInputFace();
/* 223 */         if ((inputFace != null) && 
/* 224 */           (!isOutputFace(worldIn, pos.func_177972_a(inputFace), inputFace.func_176734_d()))) {
/* 225 */           tile.setInputFace(null);
/* 226 */           inputFace = null;
/* 227 */           changed = true;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 232 */         EnumFacing[] facingChecks = { EnumFacing.NORTH, EnumFacing.EAST, EnumFacing.SOUTH, EnumFacing.WEST, EnumFacing.UP, EnumFacing.DOWN };
/* 233 */         if (inputFace == null) {
/* 234 */           for (EnumFacing facing : facingChecks) {
/* 235 */             BlockPos otherPos = pos.func_177972_a(facing);
/* 236 */             IBlockState otherState = worldIn.func_180495_p(otherPos);
/* 237 */             if (((otherState.func_177230_c() instanceof BlockResearch)) && (state.func_177230_c() != Get.blocks().FUNNEL)) {
/* 238 */               BlockResearch otherBlock = (BlockResearch)otherState.func_177230_c();
/* 239 */               if (otherBlock.isOutputFace(facing.func_176734_d(), (TileEntityResearchBlock)BlockUtil.getTileEntity(worldIn, otherPos, TileEntityResearchBlock.class))) {
/* 240 */                 tile.setInputFace(facing);
/* 241 */                 changed = true;
/* 242 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 249 */       if (changed) {
/* 250 */         worldIn.func_175685_c(pos, this);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static int getCodeForSoulAtIndex(World world, SoulType soul, int index)
/*     */   {
/* 257 */     List<Integer> codes = getSoulCodesForWorld(world);
/* 258 */     int code = ((Integer)codes.get(soul.ordinal())).intValue();
/* 259 */     int digit = 0;
/* 260 */     while ((code > 0) && (index-- >= 0)) {
/* 261 */       int d = code / 10;
/* 262 */       digit = code - d * 10;
/* 263 */       code = d;
/*     */     }
/* 265 */     return digit;
/*     */   }
/*     */   
/*     */   private static List<Integer> getSoulCodesForWorld(World world) {
/* 269 */     long seed = world.field_73011_w.getSeed();
/* 270 */     Random rand = new Random(seed);
/* 271 */     List<Integer> codes = new java.util.ArrayList();
/* 272 */     while (codes.size() < 8) {
/* 273 */       int code = 0;
/* 274 */       code += 1000 * (rand.nextInt(4) + 1);
/* 275 */       code += 100 * (rand.nextInt(4) + 1);
/* 276 */       code += 10 * (rand.nextInt(4) + 1);
/* 277 */       code += 1 * (rand.nextInt(4) + 1);
/* 278 */       if (!codes.contains(Integer.valueOf(code))) {
/* 279 */         codes.add(Integer.valueOf(code));
/*     */       }
/*     */     }
/* 282 */     return codes;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 287 */     return false;
/*     */   }
/*     */   
/*     */   public static abstract class TileEntityResearchBlock extends TileEntity
/*     */   {
/*     */     private EnumFacing inputFace;
/*     */     private Class<? extends EntityLiving> soulType;
/*     */     private int soulStage;
/*     */     private boolean valid;
/*     */     private boolean pending;
/*     */     private BlockBoneCage.RelayField unstable;
/*     */     private BlockPos sourcePos;
/*     */     
/*     */     protected void setInputFace(EnumFacing facing) {
/* 301 */       this.inputFace = facing;
/* 302 */       if (this.field_145850_b != null) {
/* 303 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public EnumFacing getInputFace() {
/* 308 */       return this.inputFace;
/*     */     }
/*     */     
/*     */     void triggerUpdate(Class<? extends EntityLiving> soulType, BlockBoneCage.RelayField unstable, BlockPos sourcePos, int soulStage, boolean priorValid, IBlockState state) {
/* 312 */       this.soulType = soulType;
/* 313 */       this.soulStage = (soulType == null ? 0 : soulStage);
/* 314 */       if (!priorValid) {
/* 315 */         this.soulStage = -1;
/*     */       }
/* 317 */       this.pending = true;
/* 318 */       this.unstable = unstable;
/* 319 */       this.sourcePos = sourcePos;
/* 320 */       this.field_145850_b.func_175684_a(this.field_174879_c, state.func_177230_c(), 20);
/*     */     }
/*     */     
/*     */     void processUpdate() {
/* 324 */       setSoulType(this.soulType, this.unstable, this.sourcePos, this.soulStage, this.soulStage != -1);
/*     */     }
/*     */     
/*     */ 
/*     */     void setSoulType(Class<? extends EntityLiving> soulType, BlockBoneCage.RelayField unstable, BlockPos sourcePos)
/*     */     {
/* 330 */       setSoulType(soulType, unstable, sourcePos, 0, true);
/*     */     }
/*     */     
/*     */     void setSoulType(Class<? extends EntityLiving> soulType, BlockBoneCage.RelayField unstable, BlockPos sourcePos, int soulStage, boolean priorValid) {
/* 334 */       this.pending = false;
/* 335 */       this.soulType = soulType;
/* 336 */       this.unstable = unstable;
/* 337 */       this.sourcePos = sourcePos;
/* 338 */       if (soulType == null) {
/* 339 */         this.soulStage = 0;
/* 340 */         this.valid = true;
/* 341 */       } else if (priorValid) {
/* 342 */         this.soulStage = soulStage;
/* 343 */         soul = Get.souls().getSoulFor(soulType);
/* 344 */         if (soul != null) {
/* 345 */           block = (BlockResearch)this.field_145850_b.func_180495_p(this.field_174879_c).func_177230_c();
/* 346 */           if (block.equipmentCode > 0) {
/* 347 */             this.valid = (BlockResearch.getCodeForSoulAtIndex(this.field_145850_b, soul, soulStage) == block.equipmentCode);
/*     */             
/* 349 */             if ((this.valid) && (soulStage == 4)) {
/* 350 */               completeResearch(soul, unstable);
/*     */             }
/*     */           }
/*     */           else {
/* 354 */             this.valid = true;
/*     */           }
/*     */         } else {
/* 357 */           this.valid = false;
/*     */         }
/*     */       } else {
/* 360 */         this.soulStage = soulStage;
/* 361 */         this.valid = false;
/*     */       }
/* 363 */       this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       
/* 365 */       SoulType soul = EnumFacing.field_82609_l;BlockResearch block = soul.length; for (BlockResearch localBlockResearch1 = 0; localBlockResearch1 < block; localBlockResearch1++) { EnumFacing facing = soul[localBlockResearch1];
/* 366 */         BlockPos otherPos = this.field_174879_c.func_177972_a(facing);
/* 367 */         IBlockState otherState = this.field_145850_b.func_180495_p(otherPos);
/* 368 */         if ((otherState.func_177230_c() instanceof BlockResearch)) {
/* 369 */           TileEntityResearchBlock otherTile = (TileEntityResearchBlock)BlockUtil.getTileEntity(this.field_145850_b, otherPos, TileEntityResearchBlock.class);
/* 370 */           if ((otherTile != null) && 
/* 371 */             (otherTile.inputFace == facing.func_176734_d())) {
/* 372 */             if (soulType == null) {
/* 373 */               otherTile.setSoulType(soulType, unstable, sourcePos, soulStage + 1, this.valid);
/*     */             } else {
/* 375 */               otherTile.triggerUpdate(soulType, unstable, sourcePos, soulStage + 1, this.valid, otherState);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private void completeResearch(SoulType soul, BlockBoneCage.RelayField unstable)
/*     */     {
/* 384 */       IKnol knol = Get.knowledge().getKnolForSoul(soul);
/* 385 */       if ((knol != null) && 
/* 386 */         (!this.field_145850_b.field_72995_K)) {
/* 387 */         double RADIUS = 5.0D;
/* 388 */         AxisAlignedBB bb = new AxisAlignedBB(func_174877_v().func_177963_a(-5.0D, -2.0D, -5.0D), func_174877_v().func_177963_a(6.0D, 3.0D, 6.0D));
/* 389 */         List<EntityPlayer> players = this.field_145850_b.func_72872_a(EntityPlayer.class, bb);
/* 390 */         PlayerEx closest = null;
/* 391 */         double bestDistance = Double.MAX_VALUE;
/* 392 */         for (EntityPlayer player : players) {
/* 393 */           PlayerEx playerEx = PlayerEx.get(player);
/* 394 */           double distance = player.func_174818_b(this.field_174879_c);
/* 395 */           if (distance <= 25.0D) { if ((!playerEx.isKnowledgeLearnt(new IKnol[] { knol })) && (
/* 396 */               (closest == null) || (distance < bestDistance))) {
/* 397 */               closest = playerEx;
/* 398 */               bestDistance = distance;
/*     */             }
/*     */           }
/*     */         }
/* 402 */         if (closest != null) {
/* 403 */           Vec3 source = new Vec3(0.5D + this.field_174879_c.func_177958_n(), 0.5D + this.field_174879_c.func_177956_o(), 0.5D + this.field_174879_c.func_177952_p());
/* 404 */           if (!closest.isKnowledgeLearnt(new IKnol[] { Get.knowledge().SOULS })) {
/* 405 */             closest.learnKnowledge(source, new IKnol[] { Get.knowledge().SOULS, knol });
/*     */           } else {
/* 407 */             closest.learnKnowledge(source, new IKnol[] { knol });
/*     */           }
/*     */         }
/*     */         
/* 411 */         if ((this.sourcePos != null) && (unstable != BlockBoneCage.RelayField.NONE)) {
/* 412 */           IBlockState state = this.field_145850_b.func_180495_p(this.sourcePos);
/* 413 */           if ((state.func_177230_c() instanceof BlockBoneCage)) {
/* 414 */             BlockBoneCage.TileEntityBoneCage tile = (BlockBoneCage.TileEntityBoneCage)BlockUtil.getTileEntity(this.field_145850_b, this.sourcePos, BlockBoneCage.TileEntityBoneCage.class, state);
/* 415 */             if (tile != null) {
/* 416 */               EntityLiving entity = tile.getTrappedEntity();
/* 417 */               if ((entity != null) && (Get.souls().isSoulPresent(entity, true))) {
/* 418 */                 if ((Get.souls().isStrongSoul(entity)) && (unstable != BlockBoneCage.RelayField.ENHANCED)) {
/* 419 */                   Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.5F, 30, 16711680);
/* 420 */                   emoniph.intangible.Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(this, 0.5F, 1.0F);
/* 421 */                   return;
/*     */                 }
/* 423 */                 EntitySoul soulEntity = EntitySoul.removeSoulAsEntity(entity);
/* 424 */                 if (soulEntity != null) {
/* 425 */                   EntityLiving soulessEntity = Get.souls().createSoullessEntityFor(this.field_145850_b, entity);
/* 426 */                   if (soulessEntity != null) {
/* 427 */                     tile.setTrappedEntity(soulessEntity, true);
/*     */                   }
/* 429 */                   BlockPos ot = this.field_174879_c.func_177972_a(this.inputFace.func_176734_d());
/* 430 */                   BlockPos o = this.field_174879_c;
/* 431 */                   if (isValidDeployPos(ot)) {
/* 432 */                     o = ot;
/*     */                   } else {
/* 434 */                     ot = ot.func_177977_b();
/* 435 */                     if (isValidDeployPos(ot)) {
/* 436 */                       o = ot;
/*     */                     } else {
/* 438 */                       for (EnumFacing facing : EnumFacing.field_82609_l) {
/* 439 */                         ot = this.field_174879_c.func_177972_a(facing);
/* 440 */                         if (isValidDeployPos(ot)) {
/* 441 */                           o = ot;
/* 442 */                           break;
/*     */                         }
/* 444 */                         ot = ot.func_177977_b();
/* 445 */                         if (isValidDeployPos(ot)) {
/* 446 */                           o = ot;
/* 447 */                           break;
/*     */                         }
/*     */                       }
/*     */                     }
/*     */                   }
/*     */                   
/*     */ 
/*     */ 
/*     */ 
/* 456 */                   soulEntity.func_70080_a(o.func_177958_n() + 0.5D, o.func_177956_o(), o.func_177952_p() + 0.5D, 0.0F, 0.0F);
/* 457 */                   this.field_145850_b.func_72838_d(soulEntity);
/* 458 */                   Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.5F, 30, 61547);
/* 459 */                   Get.fx().GLOW.sendToAllNear(soulEntity, 0.5F, 30, 61547);
/*     */                   
/* 461 */                   this.field_145850_b.func_175685_c(this.sourcePos, state.func_177230_c());
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private boolean isValidDeployPos(BlockPos pos)
/*     */     {
/* 475 */       return (this.field_145850_b.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) && (this.field_145850_b.func_180495_p(pos.func_177984_a()).func_177230_c().func_149688_o().func_76222_j());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 480 */       super.func_145839_a(compound);
/* 481 */       if (compound.func_150297_b("inputFace", 3)) {
/* 482 */         this.inputFace = EnumFacing.func_82600_a(compound.func_74762_e("inputFace"));
/*     */       } else {
/* 484 */         this.inputFace = null;
/*     */       }
/*     */       
/* 487 */       if (compound.func_150297_b("soul", 8)) {
/* 488 */         String classString = compound.func_74779_i("soul");
/* 489 */         this.soulType = ((Class)EntityList.field_75625_b.get(classString));
/* 490 */         this.soulStage = compound.func_74762_e("soulStage");
/* 491 */         this.valid = compound.func_74767_n("validSoul");
/* 492 */         this.pending = compound.func_74767_n("pending");
/* 493 */         this.unstable = BlockBoneCage.RelayField.fromMeta(compound.func_74762_e("unstable"));
/* 494 */         if (compound.func_150297_b("sourcePos", 4)) {
/* 495 */           this.sourcePos = BlockPos.func_177969_a(compound.func_74763_f("sourcePos"));
/*     */         } else {
/* 497 */           this.sourcePos = null;
/*     */         }
/*     */       } else {
/* 500 */         this.soulType = null;
/* 501 */         this.soulStage = 0;
/* 502 */         this.valid = false;
/* 503 */         this.pending = false;
/* 504 */         this.unstable = BlockBoneCage.RelayField.NONE;
/* 505 */         this.sourcePos = null;
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 511 */       super.func_145841_b(compound);
/* 512 */       if (this.inputFace != null) {
/* 513 */         compound.func_74768_a("inputFace", this.inputFace.func_176745_a());
/*     */       }
/*     */       
/* 516 */       if (this.soulType != null) {
/* 517 */         String classString = (String)EntityList.field_75626_c.get(this.soulType);
/* 518 */         if (classString != null) {
/* 519 */           compound.func_74778_a("soul", classString);
/* 520 */           compound.func_74768_a("soulStage", this.soulStage);
/* 521 */           compound.func_74757_a("validSoul", this.valid);
/* 522 */           compound.func_74757_a("pending", this.pending);
/* 523 */           compound.func_74768_a("unstable", this.unstable != null ? this.unstable.getMeta() : BlockBoneCage.RelayField.NONE.getMeta());
/* 524 */           if (this.sourcePos != null) {
/* 525 */             compound.func_74772_a("sourcePos", this.sourcePos.func_177986_g());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 533 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 534 */       func_145841_b(nbtTag);
/* 535 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 540 */       super.onDataPacket(net, packet);
/* 541 */       func_145839_a(packet.func_148857_g());
/* 542 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 547 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public Class<? extends EntityLiving> getSoulType() {
/* 551 */       return (this.soulStage != -1) && (!this.pending) ? this.soulType : null;
/*     */     }
/*     */     
/*     */     public boolean isValid() {
/* 555 */       return this.valid;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockResearch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */