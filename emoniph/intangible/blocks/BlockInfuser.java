/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.entity.EntitySoul;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.properties.PropertyBool;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockInfuser extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*  46 */   public static final PropertyBool NO_DROP = PropertyBool.func_177716_a("nodrop");
/*  47 */   public static final PropertyBool POWERED = PropertyBool.func_177716_a("powered");
/*     */   
/*     */   protected BlockInfuser() {
/*  50 */     super(net.minecraft.block.material.Material.field_151576_e);
/*  51 */     func_149711_c(5.0F);
/*  52 */     func_149672_a(field_149769_e);
/*  53 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(NO_DROP, Boolean.valueOf(false)).func_177226_a(POWERED, Boolean.valueOf(false)));
/*  54 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  59 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   public int func_176211_b(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/*  64 */     return super.func_180656_a(worldIn, pos, state, side);
/*     */   }
/*     */   
/*     */   public int func_180656_a(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/*  69 */     return (side == EnumFacing.DOWN) && (((Boolean)state.func_177229_b(POWERED)).booleanValue()) ? 1 : 0;
/*     */   }
/*     */   
/*     */   public boolean func_149744_f()
/*     */   {
/*  74 */     return true;
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  79 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/*  95 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
/*     */   {
/* 100 */     return func_176223_P().func_177226_a(NO_DROP, Boolean.valueOf(false));
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/* 105 */     return new TileEntityInfuser();
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
/*     */   {
/* 110 */     if (player.field_71075_bZ.field_75098_d) {
/* 111 */       state = state.func_177226_a(NO_DROP, Boolean.valueOf(true));
/* 112 */       worldIn.func_180501_a(pos, state, 4);
/*     */     }
/* 114 */     func_176226_b(worldIn, pos, state, 0);
/*     */     
/* 116 */     super.func_176208_a(worldIn, pos, state, player);
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 121 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/* 122 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune)
/*     */   {
/* 127 */     List<ItemStack> ret = new ArrayList();
/* 128 */     if (!((Boolean)state.func_177229_b(NO_DROP)).booleanValue()) {
/* 129 */       TileEntityInfuser tile = (TileEntityInfuser)BlockUtil.getTileEntity(worldIn, pos, TileEntityInfuser.class);
/* 130 */       if (tile != null) {
/* 131 */         ItemStack itemstack = new ItemStack(this);
/* 132 */         if (!itemstack.func_77942_o()) {
/* 133 */           itemstack.func_77982_d(new NBTTagCompound());
/*     */         }
/*     */         
/* 136 */         tile.writeItemToNBT(itemstack.func_77978_p());
/*     */         
/* 138 */         ret.add(itemstack);
/*     */       }
/*     */     }
/*     */     
/* 142 */     return ret;
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 147 */     return func_176223_P().func_177226_a(NO_DROP, Boolean.valueOf((meta & 0x8) > 0)).func_177226_a(POWERED, Boolean.valueOf((meta & 0x1) > 0));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 152 */     byte b0 = 0;
/* 153 */     int i = b0;
/*     */     
/* 155 */     if (((Boolean)state.func_177229_b(NO_DROP)).booleanValue()) {
/* 156 */       i |= 0x8;
/*     */     }
/*     */     
/* 159 */     if (((Boolean)state.func_177229_b(POWERED)).booleanValue()) {
/* 160 */       i |= 0x1;
/*     */     }
/*     */     
/* 163 */     return i;
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 168 */     updateState(worldIn, pos, state);
/* 169 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 174 */     updateState(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private void updateState(World worldIn, BlockPos pos, IBlockState state) {
/* 178 */     if (!worldIn.field_72995_K) {
/* 179 */       boolean currentPower = ((Boolean)state.func_177229_b(POWERED)).booleanValue();
/* 180 */       if (worldIn.func_175640_z(pos)) {
/* 181 */         worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(true)));
/*     */       } else {
/* 183 */         worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(false)));
/*     */       }
/* 185 */       if (currentPower != ((Boolean)state.func_177229_b(POWERED)).booleanValue()) {
/* 186 */         worldIn.func_175685_c(pos, this);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack getPickBlock(MovingObjectPosition target, World worldIn, BlockPos pos, EntityPlayer player)
/*     */   {
/* 193 */     ItemStack stack = new ItemStack(this);
/*     */     
/* 195 */     TileEntityInfuser tile = (TileEntityInfuser)BlockUtil.getTileEntity(worldIn, pos, TileEntityInfuser.class);
/* 196 */     if (tile != null) {
/* 197 */       if (!stack.func_77942_o()) {
/* 198 */         stack.func_77982_d(new NBTTagCompound());
/*     */       }
/*     */       
/* 201 */       tile.writeItemToNBT(stack.func_77978_p());
/*     */     }
/*     */     
/* 204 */     return stack;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/* 209 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { POWERED, NO_DROP });
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 214 */     if (side.func_176736_b() == -1) {
/* 215 */       return false;
/*     */     }
/*     */     
/* 218 */     TileEntityInfuser tile = (TileEntityInfuser)BlockUtil.getTileEntity(worldIn, pos, TileEntityInfuser.class);
/* 219 */     if (tile != null) {
/* 220 */       float vy = hitY;
/* 221 */       float vx = 0.0F;
/* 222 */       switch (side) {
/*     */       case NORTH: 
/* 224 */         vx = 1.0F - hitX;
/* 225 */         break;
/*     */       case SOUTH: 
/* 227 */         vx = hitX;
/* 228 */         break;
/*     */       case EAST: 
/* 230 */         vx = 1.0F - hitZ;
/* 231 */         break;
/*     */       case WEST: 
/* 233 */         vx = hitZ;
/*     */       }
/*     */       
/*     */       
/*     */ 
/*     */ 
/* 239 */       if ((vy > 0.3D) && (vy < 0.7D) && 
/* 240 */         (vx > 0.2D) && (vy < 0.8D)) {
/* 241 */         if (!worldIn.field_72995_K) {
/* 242 */           BlockInfuser.TileEntityInfuser.FaceData face = tile.getFace(side);
/* 243 */           if (face != null) {
/* 244 */             if (vx < 0.5D) {
/* 245 */               if (vy >= 0.4D) {
/* 246 */                 face.nextSoul();
/*     */               } else {
/* 248 */                 face.prevSoul();
/*     */               }
/*     */             }
/* 251 */             else if (vy >= 0.4D) {
/* 252 */               face.increaseQuantity();
/*     */             } else {
/* 254 */               face.decreaseQuantity();
/*     */             }
/*     */             
/* 257 */             worldIn.func_175689_h(pos);
/*     */           }
/*     */         }
/* 260 */         playerIn.func_85030_a("gui.button.press", 0.2F, 1.0F);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 265 */     return true;
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 270 */     return 59;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class TileEntityInfuser
/*     */     extends TileEntity
/*     */     implements net.minecraft.util.ITickable
/*     */   {
/*     */     private long counter;
/*     */     
/*     */     private int progress;
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 284 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 285 */       if (state.func_177230_c() != Get.blocks().INFUSER) {
/* 286 */         return;
/*     */       }
/*     */       
/* 289 */       this.counter += 1L;
/*     */       
/* 291 */       if (this.counter % 20L == 0L) {
/* 292 */         if ((state.func_177230_c() == Get.blocks().INFUSER) && (state.func_177229_b(BlockInfuser.POWERED) == Boolean.TRUE) && (this.field_145850_b.func_175623_d(this.field_174879_c.func_177984_a()))) {
/* 293 */           List<EntityPlayer> players = this.field_145850_b.func_72872_a(EntityPlayer.class, new AxisAlignedBB(this.field_174879_c, this.field_174879_c.func_177982_a(1, 2, 1)));
/* 294 */           if ((players.size() == 1) && (!Get.effects().isIncorporeal((EntityLivingBase)players.get(0)))) {
/* 295 */             this.progress += 1;
/* 296 */             if ((this.field_145850_b.field_72995_K) && 
/* 297 */               (this.progress >= 5) && (this.progress < 20)) {
/* 298 */               for (int i = 0; i < 20 + this.progress * 2; i++)
/*     */               {
/*     */ 
/*     */ 
/* 302 */                 emoniph.intangible.Intangible.PROXY.glow(this.field_145850_b, this.field_174879_c.func_177984_a(), 0.25D + this.progress * 0.01D).motion(0.0D, 0.1D, 0.0D).duration(15).color(13192, 64);
/*     */               }
/*     */               
/* 305 */               Sound.MOD_RANDOM_MACHINE.playToAllNear(this, 0.5F, 1.0F);
/*     */             }
/*     */             
/* 308 */             if (this.progress == 20) {
/* 309 */               if (!this.field_145850_b.field_72995_K) {
/* 310 */                 double MAX_WELL_RANGE = 16.0D;
/* 311 */                 SoulSet needed = getRequiredSouls();
/* 312 */                 EntityPlayer player = (EntityPlayer)players.get(0);
/* 313 */                 PlayerEx playerEx = PlayerEx.get(player);
/*     */                 
/* 315 */                 if (needed.equalTo(playerEx.getAllSouls())) {
/* 316 */                   Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(player, 1.0F, 0.8F);
/* 317 */                   Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.8F, 40, 39168, BlockUtil.midBlockToVec3(this.field_174879_c.func_177981_b(3)), 0.1F);
/* 318 */                 } else if (!playerEx.canAbsorbSoulSet(needed)) {
/* 319 */                   Sound.MOD_RANDOM_SPELLFAIL.playToAllNear(player, 1.0F, 0.8F);
/* 320 */                   Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.8F, 40, 10027008, BlockUtil.midBlockToVec3(this.field_174879_c.func_177981_b(3)), 0.1F);
/*     */                 }
/*     */                 else {
/* 323 */                   SoulSet removedSouls = playerEx.clearSoulsAndSpells(false);
/* 324 */                   if ((!removedSouls.isEmpty()) && 
/* 325 */                     (!Get.wells().addSoulsToClosestWell(this.field_145850_b, this.field_174879_c, 16.0D, removedSouls, new Vec3(player.field_70165_t, player.field_70163_u + player.field_70131_O * 0.5D, player.field_70161_v))))
/*     */                   {
/* 327 */                     for (SoulType soulType : removedSouls) {
/* 328 */                       EntitySoul soul = new EntitySoul(this.field_145850_b);
/* 329 */                       emoniph.intangible.util.EntityUtil.trySetRandomNearbyPosition(soul, this.field_145850_b, new Vec3(player.field_70165_t, player.field_70163_u, player.field_70161_v), org.apache.commons.lang3.Range.between(Double.valueOf(2.0D), Double.valueOf(8.0D)), 5);
/* 330 */                       soul.setEntityTypeBySoul(soulType);
/* 331 */                       this.field_145850_b.func_72838_d(soul);
/* 332 */                       Get.fx().GLOW.sendToAllNear(this.field_145850_b, player.field_70165_t, player.field_70163_u + player.field_70131_O * 0.5D, player.field_70161_v, 2.0F, 50, 6710818, 1, new Vec3(soul.field_70165_t, soul.field_70163_u, soul.field_70161_v), 0.5F, 32.0D);
/*     */                     }
/*     */                   }
/*     */                   
/*     */ 
/*     */ 
/*     */ 
/* 339 */                   if (needed.isEmpty()) {
/* 340 */                     if (!removedSouls.isEmpty()) {
/* 341 */                       playerEx.syncToClient();
/* 342 */                       Sound.MOD_RANDOM_POWER_DOWN.playToAllNear(player, 1.0F, 0.8F);
/*     */                     }
/* 344 */                   } else if (Get.wells().consumeSouls(this.field_145850_b, this.field_174879_c, 16.0D, needed, new Vec3(player.field_70165_t, player.field_70163_u + player
/* 345 */                     .func_70047_e(), player.field_70161_v))) {
/* 346 */                     playerEx.infuseSouls(needed, true);
/* 347 */                     Sound.MOD_RANDOM_POWER_UP.playToAllNear(player, 1.0F, 0.8F);
/*     */                   } else {
/* 349 */                     playerEx.syncToClient();
/* 350 */                     Sound.MOD_RANDOM_POWER_DOWN.playToAllNear(player, 1.0F, 0.8F);
/*     */                   }
/*     */                 }
/*     */               }
/* 354 */             } else if (this.progress >= 40) {
/* 355 */               this.progress = 0;
/*     */             }
/*     */           } else {
/* 358 */             this.progress = 0;
/*     */           }
/*     */         } else {
/* 361 */           this.progress = 0;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private SoulSet getRequiredSouls() {
/* 367 */       SoulSet souls = new SoulSet();
/* 368 */       for (int i = 0; i < 5; i++) {
/* 369 */         BlockPos testPos = this.field_174879_c.func_177982_a(0, -i, 0);
/* 370 */         IBlockState state = this.field_145850_b.func_180495_p(testPos);
/* 371 */         if ((state.func_177230_c() != Get.blocks().INFUSER) || (state.func_177229_b(BlockInfuser.POWERED) != Boolean.TRUE)) break;
/* 372 */         TileEntityInfuser tile = (TileEntityInfuser)BlockUtil.getTileEntity(this.field_145850_b, testPos, TileEntityInfuser.class);
/* 373 */         if (tile != null) {
/* 374 */           for (FaceData face : tile.faces.values()) {
/* 375 */             face.addSoulsTo(souls);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 382 */       return souls;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public int getProgress()
/*     */     {
/* 433 */       return this.progress;
/*     */     }
/*     */     
/*     */     public long getCounter() {
/* 437 */       return this.counter;
/*     */     }
/*     */     
/*     */     public static class FaceData {
/*     */       private final EnumFacing facing;
/*     */       private SoulType soul;
/*     */       private int quantity;
/*     */       
/*     */       private FaceData(EnumFacing facing, SoulType soul, int quantity) {
/* 446 */         this.facing = facing;
/* 447 */         this.soul = soul;
/* 448 */         this.quantity = quantity;
/*     */       }
/*     */       
/*     */       public NBTTagCompound toTagCompound() {
/* 452 */         NBTTagCompound compound = new NBTTagCompound();
/* 453 */         compound.func_74768_a("facing", this.facing.func_176745_a());
/* 454 */         compound.func_74768_a("soul", EnumSoulType.fromSoulType(this.soul).getMetadata());
/* 455 */         compound.func_74768_a("quantity", this.quantity);
/* 456 */         return compound;
/*     */       }
/*     */       
/*     */       public static FaceData fromTagCompound(NBTTagCompound compound) {
/* 460 */         if ((compound != null) && 
/* 461 */           (compound.func_150297_b("facing", 3)) && 
/* 462 */           (compound.func_150297_b("soul", 3)) && 
/* 463 */           (compound.func_150297_b("quantity", 3)))
/*     */         {
/*     */ 
/*     */ 
/* 467 */           FaceData faceData = new FaceData(EnumFacing.func_82600_a(compound.func_74762_e("facing")), EnumSoulType.byMetadata(compound.func_74762_e("soul")).toSoulType(), compound.func_74762_e("quantity"));
/* 468 */           return faceData;
/*     */         }
/* 470 */         return null;
/*     */       }
/*     */       
/*     */       public void nextSoul()
/*     */       {
/* 475 */         this.soul = EnumSoulType.fromSoulType(this.soul).forward().toSoulType();
/*     */       }
/*     */       
/*     */       public void prevSoul() {
/* 479 */         this.soul = EnumSoulType.fromSoulType(this.soul).backwards().toSoulType();
/*     */       }
/*     */       
/*     */       public void increaseQuantity() {
/* 483 */         if (++this.quantity > 9) {
/* 484 */           this.quantity = 0;
/*     */         }
/*     */       }
/*     */       
/*     */       public void decreaseQuantity() {
/* 489 */         if (--this.quantity < 0) {
/* 490 */           this.quantity = 9;
/*     */         }
/*     */       }
/*     */       
/*     */       public SoulType getSoul() {
/* 495 */         return this.soul;
/*     */       }
/*     */       
/*     */       public static Map<EnumFacing, FaceData> createHorizontals() {
/* 499 */         Map<EnumFacing, FaceData> faces = new java.util.HashMap();
/* 500 */         for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 501 */           faces.put(facing, new FaceData(facing, SoulType.BENIGN, 0));
/*     */         }
/* 503 */         return faces;
/*     */       }
/*     */       
/*     */       public int getQuantity() {
/* 507 */         return this.quantity;
/*     */       }
/*     */       
/*     */       public void addSoulsTo(SoulSet souls) {
/* 511 */         if (this.quantity > 0) {
/* 512 */           souls.add(this.soul, this.quantity);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 517 */     private final Map<EnumFacing, FaceData> faces = FaceData.createHorizontals();
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 521 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 526 */       super.func_145841_b(compound);
/* 527 */       writeItemToNBT(compound);
/* 528 */       compound.func_74768_a("progress", this.progress);
/* 529 */       compound.func_74772_a("counter", this.counter);
/*     */     }
/*     */     
/*     */     public void writeItemToNBT(NBTTagCompound compound) {
/* 533 */       if (compound != null) {
/* 534 */         NBTTagList list = new NBTTagList();
/* 535 */         for (FaceData face : this.faces.values()) {
/* 536 */           list.func_74742_a(face.toTagCompound());
/*     */         }
/* 538 */         compound.func_74782_a("faces", list);
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 544 */       super.func_145839_a(compound);
/* 545 */       readItemFromNBT(compound);
/* 546 */       this.progress = compound.func_74762_e("progress");
/* 547 */       this.counter = compound.func_74763_f("counter");
/*     */     }
/*     */     
/*     */     public void readItemFromNBT(NBTTagCompound compound) {
/* 551 */       if (compound != null) {
/* 552 */         this.faces.clear();
/* 553 */         NBTTagList list = compound.func_150295_c("faces", 10);
/* 554 */         int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 555 */           FaceData face = FaceData.fromTagCompound(list.func_150305_b(i));
/* 556 */           if (face != null) {
/* 557 */             this.faces.put(face.facing, face);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 565 */       NBTTagCompound compound = new NBTTagCompound();
/* 566 */       func_145841_b(compound);
/* 567 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 572 */       super.onDataPacket(net, packet);
/* 573 */       NBTTagCompound compound = packet.func_148857_g();
/* 574 */       func_145839_a(compound);
/* 575 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 581 */       return new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(1, 3, 1));
/*     */     }
/*     */     
/*     */     public FaceData getFace(EnumFacing facing) {
/* 585 */       return (FaceData)this.faces.get(facing);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockInfuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */