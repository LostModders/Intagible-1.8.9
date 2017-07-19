/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.items.ItemPart.EnumPart;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.ISoulHost;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.EntityUtil;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockDefense extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*  49 */   public static final net.minecraft.block.properties.PropertyBool NO_DROP = net.minecraft.block.properties.PropertyBool.func_177716_a("nodrop");
/*     */   
/*     */   protected BlockDefense() {
/*  52 */     super(Material.field_151576_e);
/*  53 */     func_149711_c(3.0F);
/*  54 */     func_180632_j(func_176223_P().func_177226_a(NO_DROP, Boolean.valueOf(false)));
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, net.minecraft.entity.Entity entity)
/*     */   {
/*  59 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/*  65 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/*  69 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
/*  77 */     return func_176223_P();
/*     */   }
/*     */   
/*     */   public void func_180633_a(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
/*     */   {
/*  82 */     TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/*  83 */     if ((tile != null) && (placer != null) && ((placer instanceof EntityPlayer)) && (!worldIn.field_72995_K)) {
/*  84 */       tile.placer = placer.getPersistentID();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  90 */     TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/*  91 */     float radiusSq; if (tile != null) {
/*  92 */       int radius = 4;
/*  93 */       radiusSq = radius * radius;
/*  94 */       List<EntityLivingBase> list = worldIn.func_72872_a(EntityLivingBase.class, new AxisAlignedBB(pos.func_177982_a(-radius, 0, -radius), pos.func_177982_a(radius + 1, 2, radius + 1)));
/*  95 */       for (EntityLivingBase entity : list) {
/*  96 */         if (entity.func_70092_e(pos.func_177958_n() + 0.5D, entity.field_70163_u, pos.func_177952_p() + 0.5D) < radiusSq) {
/*  97 */           tile.registerKnownEntity(entity);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_180649_a(World worldIn, BlockPos pos, EntityPlayer playerIn)
/*     */   {
/* 105 */     if (!worldIn.field_72995_K) {
/* 106 */       TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/* 107 */       if (tile != null) {
/* 108 */         if ((tile.ignorables.contains(playerIn.getPersistentID())) || ((tile.placer != null) && (tile.placer.equals(playerIn.getPersistentID())))) {
/* 109 */           return;
/*     */         }
/*     */         
/* 112 */         tile.triggerEffectOn(playerIn);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 118 */     if (player.field_71075_bZ.field_75098_d) {
/* 119 */       state = state.func_177226_a(NO_DROP, Boolean.valueOf(true));
/* 120 */       worldIn.func_180501_a(pos, state, 4);
/*     */     }
/* 122 */     func_176226_b(worldIn, pos, state, 0);
/*     */     
/* 124 */     super.func_176208_a(worldIn, pos, state, player);
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 129 */     if (!worldIn.field_72995_K) {
/* 130 */       TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/* 131 */       if ((tile != null) && (tile.placer != null) && 
/* 132 */         (tile.placer.equals(playerIn.getPersistentID()))) {
/* 133 */         ItemStack held = playerIn.func_70694_bm();
/* 134 */         if (held == null) {
/* 135 */           if (tile.ignorables.contains(tile.placer)) {
/* 136 */             tile.ignorables.remove(tile.placer);
/* 137 */             Get.fx().GLOW.sendToAllNear(worldIn, pos, 0.25F, 10, 16711680);
/* 138 */             Sound.MOD_RANDOM_CLINK.playToAllNear(playerIn, 0.5F, 0.7F);
/*     */           } else {
/* 140 */             tile.ignorables.add(tile.placer);
/* 141 */             Get.fx().GLOW.sendToAllNear(worldIn, pos, 0.25F, 10, 65280);
/* 142 */             Sound.MOD_RANDOM_CLINK.playToAllNear(playerIn, 0.5F, 1.0F);
/*     */           }
/*     */         }
/* 145 */         else if (ItemStack.func_179545_c(held, ItemPart.EnumPart.BLUE_GEM.getRefStack())) {
/* 146 */           if (tile.detectRadius < 6) {
/* 147 */             TileEntityDefense.access$204(tile);
/* 148 */             if (!playerIn.field_71075_bZ.field_75098_d) if (--held.field_77994_a <= 0) {
/* 149 */                 playerIn.func_70062_b(0, null);
/*     */               }
/* 151 */             worldIn.func_175689_h(pos);
/*     */           }
/* 153 */         } else if ((ItemStack.func_179545_c(held, ItemPart.EnumPart.YELLOW_GEM.getRefStack())) && 
/* 154 */           (tile.effectRadius < 6)) {
/* 155 */           TileEntityDefense.access$304(tile);
/* 156 */           if (!playerIn.field_71075_bZ.field_75098_d) if (--held.field_77994_a <= 0) {
/* 157 */               playerIn.func_70062_b(0, null);
/*     */             }
/* 159 */           worldIn.func_175689_h(pos);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 166 */     return true;
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state) {
/* 170 */     TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/* 171 */     if (tile != null) {
/* 172 */       if (tile.detectRadius > 0) {
/* 173 */         spawnItemStack(worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), ItemPart.EnumPart.BLUE_GEM.stackOf(tile.detectRadius));
/*     */       }
/* 175 */       if (tile.effectRadius > 0) {
/* 176 */         spawnItemStack(worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), ItemPart.EnumPart.YELLOW_GEM.stackOf(tile.effectRadius));
/*     */       }
/*     */     }
/* 179 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private static void spawnItemStack(World worldIn, double p_180173_1_, double p_180173_3_, double p_180173_5_, ItemStack p_180173_7_) {
/* 183 */     float f = RANDOM.nextFloat() * 0.8F + 0.1F;
/* 184 */     float f1 = RANDOM.nextFloat() * 0.8F + 0.1F;
/* 185 */     float f2 = RANDOM.nextFloat() * 0.8F + 0.1F;
/*     */     
/* 187 */     while (p_180173_7_.field_77994_a > 0) {
/* 188 */       int i = RANDOM.nextInt(21) + 10;
/*     */       
/* 190 */       if (i > p_180173_7_.field_77994_a) {
/* 191 */         i = p_180173_7_.field_77994_a;
/*     */       }
/*     */       
/* 194 */       p_180173_7_.field_77994_a -= i;
/* 195 */       EntityItem entityitem = new EntityItem(worldIn, p_180173_1_ + f, p_180173_3_ + f1, p_180173_5_ + f2, new ItemStack(p_180173_7_.func_77973_b(), i, p_180173_7_.func_77960_j()));
/*     */       
/* 197 */       if (p_180173_7_.func_77942_o()) {
/* 198 */         entityitem.func_92059_d().func_77982_d((NBTTagCompound)p_180173_7_.func_77978_p().func_74737_b());
/*     */       }
/*     */       
/* 201 */       float f3 = 0.05F;
/* 202 */       entityitem.field_70159_w = (RANDOM.nextGaussian() * f3);
/* 203 */       entityitem.field_70181_x = (RANDOM.nextGaussian() * f3 + 0.20000000298023224D);
/* 204 */       entityitem.field_70179_y = (RANDOM.nextGaussian() * f3);
/* 205 */       worldIn.func_72838_d(entityitem);
/*     */     }
/*     */   }
/*     */   
/*     */   public List<ItemStack> getDrops(IBlockAccess worldIn, BlockPos pos, IBlockState state, int fortune) {
/* 210 */     List<ItemStack> ret = new java.util.ArrayList();
/*     */     
/* 212 */     if (!((Boolean)state.func_177229_b(NO_DROP)).booleanValue()) {
/* 213 */       TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/* 214 */       if (tile != null) {
/* 215 */         ItemStack itemstack = new ItemStack(this);
/* 216 */         if (!itemstack.func_77942_o()) {
/* 217 */           itemstack.func_77982_d(new NBTTagCompound());
/*     */         }
/*     */         
/* 220 */         tile.writeItemToNBT(itemstack.func_77978_p());
/*     */         
/* 222 */         ret.add(itemstack);
/*     */       }
/*     */     }
/*     */     
/* 226 */     return ret;
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta) {
/* 230 */     return func_176223_P().func_177226_a(NO_DROP, Boolean.valueOf((meta & 0x8) > 0));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state) {
/* 234 */     byte b0 = 0;
/* 235 */     int i = b0;
/*     */     
/* 237 */     if (((Boolean)state.func_177229_b(NO_DROP)).booleanValue()) {
/* 238 */       i |= 0x8;
/*     */     }
/*     */     
/* 241 */     return i;
/*     */   }
/*     */   
/*     */   public ItemStack getPickBlock(net.minecraft.util.MovingObjectPosition target, World worldIn, BlockPos pos, EntityPlayer player)
/*     */   {
/* 246 */     ItemStack stack = new ItemStack(this);
/*     */     
/* 248 */     TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/* 249 */     if (tile != null) {
/* 250 */       if (!stack.func_77942_o()) {
/* 251 */         stack.func_77982_d(new NBTTagCompound());
/*     */       }
/*     */       
/* 254 */       tile.writeItemToNBT(stack.func_77978_p());
/*     */     }
/*     */     
/* 257 */     return stack;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e() {
/* 261 */     return new BlockState(this, new net.minecraft.block.properties.IProperty[] { NO_DROP });
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/* 266 */     return new TileEntityDefense();
/*     */   }
/*     */   
/*     */   public static ItemStack setSoulType(ItemStack stack, EnumSoulType soulType) {
/* 270 */     if (!stack.func_77942_o()) {
/* 271 */       stack.func_77982_d(new NBTTagCompound());
/*     */     }
/*     */     
/* 274 */     setSoulType(stack.func_77978_p(), soulType);
/* 275 */     return stack;
/*     */   }
/*     */   
/*     */   public static void setSoulType(NBTTagCompound compound, EnumSoulType soulType) {
/* 279 */     if (soulType != null) {
/* 280 */       compound.func_74768_a("soulType", soulType.getMetadata());
/* 281 */     } else if (compound.func_74764_b("soulType")) {
/* 282 */       compound.func_82580_o("soulType");
/*     */     }
/*     */   }
/*     */   
/*     */   public static EnumSoulType getSoulType(ItemStack stack) {
/* 287 */     return getSoulType(stack.func_77978_p());
/*     */   }
/*     */   
/*     */   public static EnumSoulType getSoulType(NBTTagCompound compound) {
/* 291 */     if ((compound != null) && (compound.func_150297_b("soulType", 3))) {
/* 292 */       return EnumSoulType.byMetadata(compound.func_74762_e("soulType"));
/*     */     }
/* 294 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_149744_f()
/*     */   {
/* 300 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_176211_b(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/* 306 */     return super.func_180656_a(worldIn, pos, state, side);
/*     */   }
/*     */   
/*     */   public int func_180656_a(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/* 311 */     TileEntityDefense tile = (TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, TileEntityDefense.class);
/* 312 */     if (tile != null) {
/* 313 */       return tile.poweredTicks > 0 ? 15 : 0;
/*     */     }
/* 315 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149666_a(Item itemIn, net.minecraft.creativetab.CreativeTabs tab, List list)
/*     */   {
/* 322 */     list.add(new ItemStack(this));
/* 323 */     for (EnumSoulType soulType : EnumSoulType.values()) {
/* 324 */       list.add(setSoulType(new ItemStack(this), soulType));
/*     */     }
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 330 */     return 190;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class TileEntityDefense
/*     */     extends TileEntity
/*     */     implements net.minecraft.util.ITickable
/*     */   {
/* 338 */     private EnumSoulType soulType = null;
/* 339 */     private UUID placer = null;
/* 340 */     private Set<UUID> ignorables = new java.util.HashSet();
/* 341 */     private int detectRadius = 0;
/* 342 */     private int effectRadius = 0;
/*     */     
/*     */     private long ticks;
/*     */     
/* 346 */     private int activeTicks = 0;
/*     */     
/* 348 */     private int poweredTicks = 0;
/*     */     
/* 350 */     private int cooldownTicks = 0;
/*     */     
/*     */     public void triggerEffectOn(EntityPlayer extraVictim) {
/* 353 */       int baseRadius = 2;
/* 354 */       int radius = baseRadius + this.detectRadius;
/* 355 */       float radiusSq = radius * radius;
/* 356 */       List<EntityLivingBase> list = this.field_145850_b.func_72872_a(EntityLivingBase.class, new AxisAlignedBB(this.field_174879_c.func_177982_a(-radius, -radius, -radius), this.field_174879_c.func_177982_a(radius + 1, radius, radius + 1)));
/* 357 */       for (Iterator<EntityLivingBase> itr = list.iterator(); itr.hasNext();) {
/* 358 */         EntityLivingBase entity = (EntityLivingBase)itr.next();
/* 359 */         if ((entity.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, entity.field_70163_u, this.field_174879_c.func_177952_p() + 0.5D) > radiusSq) || 
/* 360 */           (this.ignorables.contains(entity.getPersistentID())) || (((entity instanceof ISoulHost)) && 
/* 361 */           (!((ISoulHost)entity).isTrappableInBoneCage())) || (((entity instanceof EntityPlayer)) && 
/* 362 */           (Get.effects().isActiveFor(Get.effects().INCORPOREAL, entity)))) {
/* 363 */           itr.remove();
/*     */         }
/*     */       }
/*     */       
/* 367 */       if (extraVictim != null) {
/* 368 */         list.add(extraVictim);
/*     */       }
/*     */       int posX;
/* 371 */       if (list.size() > 0) {
/* 372 */         if (this.activeTicks == 0) {
/* 373 */           int POWERED_DURATION = 600;
/* 374 */           if (Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet().add(this.soulType.toSoulType(), 1), 600, BlockUtil.midBlockToVec3(this.field_174879_c))) {
/* 375 */             this.activeTicks = 600;
/*     */           }
/*     */         }
/* 378 */         if (this.activeTicks > 0) {
/* 379 */           Vec3 mid = BlockUtil.midBlockToVec3(this.field_174879_c);
/* 380 */           float speed; float lift; int z; int distance; EntityLivingBase target2; switch (BlockDefense.1.$SwitchMap$emoniph$intangible$souls$EnumSoulType[this.soulType.ordinal()]) {
/*     */           case 1: 
/* 382 */             speed = 1.8F + 0.1F * this.effectRadius;
/* 383 */             lift = 0.8F + 0.5F * this.effectRadius;
/* 384 */             for (EntityLivingBase target : list) {
/* 385 */               Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.5F, 40, this.soulType.getColor(), 1, EntityUtil.vecFromMidOf(target), 0.3F, 32.0D);
/* 386 */               Vec3 vec = new Vec3(target.field_70165_t - mid.field_72450_a, target.field_70163_u - mid.field_72448_b, target.field_70161_v - mid.field_72449_c).func_72432_b();
/* 387 */               double dx = vec.field_72450_a * speed;
/* 388 */               double dy = lift;
/* 389 */               double dz = vec.field_72449_c * speed;
/* 390 */               if ((target instanceof EntityPlayer)) {
/* 391 */                 EntityPlayer player = (EntityPlayer)target;
/* 392 */                 if (!player.field_71075_bZ.field_75098_d) {
/* 393 */                   Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(player, dx, dy, dz), player);
/*     */                 }
/*     */               } else {
/* 396 */                 target.field_70159_w = dx;
/* 397 */                 target.field_70181_x = dy;
/* 398 */                 target.field_70179_y = dz;
/*     */               }
/*     */             }
/* 401 */             break;
/*     */           
/*     */           case 2: 
/* 404 */             for (EntityLivingBase target : list) {
/* 405 */               if ((!(target instanceof EntityPlayer)) || (!((EntityPlayer)target).field_71075_bZ.field_75098_d))
/*     */               {
/* 407 */                 if (this.effectRadius < 3) {
/* 408 */                   target.func_70690_d(new PotionEffect(Potion.field_76419_f.field_76415_H, emoniph.intangible.util.TickUtil.fromSeconds(5 + this.effectRadius), 6, true, false));
/*     */                 } else {
/* 410 */                   target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 80, Math.min(this.effectRadius + 1, 6), true, false));
/* 411 */                   target.func_70690_d(new PotionEffect(Potion.field_76419_f.field_76415_H, 80, 6, true, false));
/* 412 */                   target.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 80, 4, true, false));
/*     */                 }
/*     */               }
/*     */             }
/* 416 */             break;
/*     */           case 3: 
/* 418 */             for (EntityLivingBase target : list) {
/* 419 */               if ((!(target instanceof EntityPlayer)) || (!((EntityPlayer)target).field_71075_bZ.field_75098_d)) {
/* 420 */                 Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.5F, 40, this.soulType.getColor(), 1, EntityUtil.vecFromMidOf(target), 0.3F, 32.0D);
/* 421 */                 float damage = 1.0F;
/* 422 */                 switch (this.effectRadius) {
/*     */                 case 0: 
/* 424 */                   damage = 1.0F;
/* 425 */                   break;
/*     */                 case 1: 
/*     */                 case 2: 
/*     */                 case 3: 
/*     */                 case 4: 
/*     */                 case 5: 
/* 431 */                   damage = 2.0F;
/* 432 */                   break;
/*     */                 case 6: 
/* 434 */                   damage = 3.0F;
/*     */                 }
/*     */                 
/* 437 */                 target.func_70097_a(emoniph.intangible.util.DamageSourceSoul.SOULLESS, damage);
/*     */               }
/*     */             }
/* 440 */             break;
/*     */           case 4: 
/* 442 */             int radius3 = baseRadius + this.effectRadius + 1;
/* 443 */             int activationTicks = 80;
/* 444 */             for (int x = this.field_174879_c.func_177958_n() - radius3; x <= this.field_174879_c.func_177958_n() + radius3; x++) {
/* 445 */               for (z = this.field_174879_c.func_177952_p() - radius3; z <= this.field_174879_c.func_177952_p() + radius3; z++) {
/* 446 */                 for (int dy = this.field_174879_c.func_177956_o(); dy >= this.field_174879_c.func_177956_o() - 1; dy--) {
/* 447 */                   BlockPos doomedPos = new BlockPos(x, dy, z);
/* 448 */                   if (!doomedPos.equals(this.field_174879_c)) {
/* 449 */                     IBlockState doomedState = this.field_145850_b.func_180495_p(doomedPos);
/* 450 */                     if (doomedState.func_177230_c() != Get.blocks().SLURP) {
/* 451 */                       Get.blocks().SLURP.replaceBlockAt(this.field_145850_b, doomedPos, activationTicks);
/*     */                     } else {
/* 453 */                       Get.blocks().SLURP.extendSlurp(this.field_145850_b, doomedPos, activationTicks);
/*     */                     }
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/* 459 */             this.cooldownTicks = (activationTicks - 20);
/*     */             
/* 461 */             break;
/*     */           case 5: 
/* 463 */             distance = 32 + 6 * this.effectRadius;
/* 464 */             for (EntityLivingBase target : list) {
/* 465 */               if ((!(target instanceof EntityPlayer)) || (!((EntityPlayer)target).field_71075_bZ.field_75098_d)) {
/* 466 */                 for (int attempt = 0; attempt < 10; attempt++)
/*     */                 {
/* 468 */                   posX = this.field_174879_c.func_177958_n() + this.field_145850_b.field_73012_v.nextInt(distance * 2) - distance;
/* 469 */                   int posZ = this.field_174879_c.func_177952_p() + this.field_145850_b.field_73012_v.nextInt(distance * 2) - distance;
/* 470 */                   int maxY = Math.min(this.field_174879_c.func_177956_o() + 64, this.field_145850_b.field_73011_w.getActualHeight());
/* 471 */                   int posY = this.field_174879_c.func_177956_o();
/* 472 */                   while ((this.field_145850_b.func_180495_p(new BlockPos(posX, posY, posZ)).func_177230_c().func_149688_o().func_76222_j()) && (posY >= 0)) {
/* 473 */                     posY--;
/*     */                   }
/* 475 */                   BlockPos pos = new BlockPos(posX, posY, posZ);
/* 476 */                   while (((this.field_145850_b.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) || 
/* 477 */                     (!this.field_145850_b.func_180495_p(pos.func_177984_a()).func_177230_c().func_149688_o().func_76222_j()) || 
/* 478 */                     (!this.field_145850_b.func_180495_p(pos.func_177981_b(2)).func_177230_c().func_149688_o().func_76222_j()) || 
/* 479 */                     (!this.field_145850_b.func_180495_p(pos.func_177981_b(3)).func_177230_c().func_149688_o().func_76222_j())) && (posY < maxY))
/*     */                   {
/* 481 */                     pos = pos.func_177984_a();
/*     */                   }
/*     */                   
/* 484 */                   if ((pos.func_177956_o() > 0) && (pos.func_177956_o() < maxY)) {
/* 485 */                     Get.fx().GLOW.sendToAllNear(this.field_145850_b, pos, 0.5F, 40, this.soulType.getColor(), 1, EntityUtil.vecFromMidOf(target), 0.3F, 32.0D);
/* 486 */                     Get.fx().sendToAllNear(EnumParticleTypes.PORTAL, target, 0.5F, 20, 16.0D);
/* 487 */                     if ((target instanceof EntityPlayer)) {
/* 488 */                       target.func_70634_a(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 1, pos.func_177952_p() + 0.5D);
/*     */                     } else {
/* 490 */                       target.func_70012_b(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 1, pos.func_177952_p() + 0.5D, 0.0F, 0.0F);
/*     */                     }
/* 492 */                     Get.fx().sendToAllNear(EnumParticleTypes.PORTAL, target, 0.5F, 20, 16.0D);
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */             
/* 498 */             break;
/*     */           case 6: 
/* 500 */             int radius2 = 48 + this.effectRadius * 3;
/* 501 */             List<EntityCreature> list2 = this.field_145850_b.func_72872_a(EntityCreature.class, new AxisAlignedBB(this.field_174879_c.func_177982_a(-radius2, -radius2, -radius2), this.field_174879_c.func_177982_a(radius2 + 1, radius2, radius2 + 1)));
/* 502 */             target2 = (EntityLivingBase)list.get(this.field_145850_b.field_73012_v.nextInt(list.size()));
/*     */             
/* 504 */             Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.5F, 40, this.soulType.getColor(), 1, EntityUtil.vecFromMidOf(target2), 0.5F, 32.0D);
/* 505 */             for (EntityCreature entity : list2) {
/* 506 */               entity.func_70624_b(target2);
/* 507 */               entity.func_70604_c(target2);
/*     */             }
/*     */             
/* 510 */             break;
/*     */           
/*     */           case 7: 
/* 513 */             if (this.poweredTicks == 0) {
/* 514 */               this.poweredTicks = 25;
/* 515 */               this.field_145850_b.func_175685_c(this.field_174879_c, func_145838_q());
/*     */             } else {
/* 517 */               this.poweredTicks = 25;
/*     */             }
/* 519 */             break;
/*     */           case 8: 
/* 521 */             for (EntityLivingBase target : list) {
/* 522 */               if ((!(target instanceof EntityPlayer)) || (!((EntityPlayer)target).field_71075_bZ.field_75098_d)) {
/* 523 */                 int launchDistance = 10 + this.effectRadius;
/* 524 */                 for (int dy = launchDistance; dy >= 0; dy--) {
/* 525 */                   BlockPos newPos = this.field_174879_c.func_177981_b(dy);
/* 526 */                   if ((target.field_70163_u <= this.field_174879_c.func_177956_o()) && 
/* 527 */                     (this.field_145850_b.func_180495_p(newPos).func_177230_c().func_149688_o().func_76222_j()) && 
/* 528 */                     (this.field_145850_b.func_180495_p(newPos.func_177981_b(1)).func_177230_c().func_149688_o().func_76222_j()) && 
/* 529 */                     (this.field_145850_b.func_180495_p(newPos.func_177981_b(2)).func_177230_c().func_149688_o().func_76222_j()) && 
/* 530 */                     (newPos.func_177956_o() < this.field_145850_b.field_73011_w.getActualHeight())) {
/* 531 */                     Get.fx().GLOW.sendToAllNear(this.field_145850_b, this.field_174879_c, 0.5F, 40, this.soulType.getColor(), 1, EntityUtil.vecFromMidOf(target), 0.5F, 32.0D);
/* 532 */                     Get.fx().sendToAllNear(EnumParticleTypes.PORTAL, target, 0.5F, 20, 16.0D);
/* 533 */                     if ((target instanceof EntityPlayer)) {
/* 534 */                       target.func_70634_a(target.field_70165_t, newPos.func_177956_o(), target.field_70161_v);
/*     */                     } else {
/* 536 */                       target.func_70012_b(target.field_70165_t, newPos.func_177956_o(), target.field_70161_v, 0.0F, 0.0F);
/*     */                     }
/* 538 */                     Get.fx().sendToAllNear(EnumParticleTypes.PORTAL, target, 0.5F, 20, 16.0D);
/* 539 */                     break;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_73660_a()
/*     */     {
/* 554 */       if (this.ticks >= Long.MAX_VALUE) {
/* 555 */         this.ticks = 1L;
/*     */       } else {
/* 557 */         this.ticks += 1L;
/*     */       }
/*     */       
/* 560 */       if (this.activeTicks > 0) {
/* 561 */         this.activeTicks -= 1;
/*     */       }
/*     */       
/* 564 */       if (this.poweredTicks > 0) {
/* 565 */         this.poweredTicks -= 1;
/* 566 */         if (this.poweredTicks == 0) {
/* 567 */           this.field_145850_b.func_175685_c(this.field_174879_c, func_145838_q());
/*     */         }
/*     */       }
/*     */       
/* 571 */       if (this.cooldownTicks > 0) {
/* 572 */         this.cooldownTicks -= 1;
/*     */       }
/*     */       
/* 575 */       if ((this.soulType != null) && (!this.field_145850_b.field_72995_K) && (this.ticks % 20L == 0L) && (this.cooldownTicks == 0)) {
/* 576 */         triggerEffectOn(null);
/*     */       }
/*     */     }
/*     */     
/*     */     public int getDetectRadius() {
/* 581 */       return this.detectRadius;
/*     */     }
/*     */     
/*     */     public int getEffectRadius() {
/* 585 */       return this.effectRadius;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public int getColor()
/*     */     {
/* 591 */       return this.soulType != null ? this.soulType.getColor() : 16777215;
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 596 */       super.func_145841_b(compound);
/*     */       
/* 598 */       if (this.placer != null) {
/* 599 */         NBTTagCompound tag = new NBTTagCompound();
/* 600 */         tag.func_74772_a("msb", this.placer.getMostSignificantBits());
/* 601 */         tag.func_74772_a("lsb", this.placer.getLeastSignificantBits());
/* 602 */         compound.func_74782_a("placer", tag);
/*     */       }
/*     */       
/* 605 */       NBTTagList list = new NBTTagList();
/* 606 */       for (UUID uuid : this.ignorables) {
/* 607 */         NBTTagCompound tag = new NBTTagCompound();
/* 608 */         tag.func_74772_a("msb", uuid.getMostSignificantBits());
/* 609 */         tag.func_74772_a("lsb", uuid.getLeastSignificantBits());
/* 610 */         list.func_74742_a(tag);
/*     */       }
/* 612 */       compound.func_74782_a("ignorables", list);
/*     */       
/* 614 */       compound.func_74768_a("activeTicks", this.activeTicks);
/* 615 */       compound.func_74768_a("poweredTicks", this.poweredTicks);
/* 616 */       compound.func_74768_a("cooldownTicks", this.cooldownTicks);
/* 617 */       compound.func_74768_a("detectRadius", this.detectRadius);
/* 618 */       compound.func_74768_a("effectRadius", this.effectRadius);
/*     */       
/* 620 */       writeItemToNBT(compound);
/*     */     }
/*     */     
/*     */     public void writeItemToNBT(NBTTagCompound compound) {
/* 624 */       if (compound != null) {
/* 625 */         BlockDefense.setSoulType(compound, this.soulType);
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 631 */       super.func_145839_a(compound);
/*     */       
/* 633 */       if (compound.func_150297_b("placer", 10)) {
/* 634 */         NBTTagCompound tag = compound.func_74775_l("placer");
/* 635 */         this.placer = new UUID(tag.func_74763_f("msb"), tag.func_74763_f("lsb"));
/*     */       } else {
/* 637 */         this.placer = null;
/*     */       }
/*     */       
/* 640 */       this.ignorables = new java.util.HashSet();
/* 641 */       if (compound.func_150297_b("ignorables", 9)) {
/* 642 */         NBTTagList list = compound.func_150295_c("ignorables", 10);
/* 643 */         int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 644 */           NBTTagCompound tag = list.func_150305_b(i);
/* 645 */           UUID uuid = new UUID(tag.func_74763_f("msb"), tag.func_74763_f("lsb"));
/* 646 */           this.ignorables.add(uuid);
/*     */         }
/*     */       }
/*     */       
/* 650 */       this.activeTicks = compound.func_74762_e("activeTicks");
/* 651 */       this.poweredTicks = compound.func_74762_e("poweredTicks");
/* 652 */       this.cooldownTicks = compound.func_74762_e("cooldownTicks");
/* 653 */       this.detectRadius = compound.func_74762_e("detectRadius");
/* 654 */       this.effectRadius = compound.func_74762_e("effectRadius");
/*     */       
/* 656 */       readItemFromNBT(compound);
/*     */     }
/*     */     
/*     */     public void readItemFromNBT(NBTTagCompound compound) {
/* 660 */       if (compound != null) {
/* 661 */         this.soulType = BlockDefense.getSoulType(compound);
/*     */       }
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 667 */       NBTTagCompound compound = new NBTTagCompound();
/* 668 */       func_145841_b(compound);
/* 669 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(net.minecraft.network.NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 674 */       super.onDataPacket(net, packet);
/* 675 */       NBTTagCompound compound = packet.func_148857_g();
/* 676 */       func_145839_a(compound);
/* 677 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 682 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public void registerKnownEntity(EntityLivingBase entity) {
/* 686 */       if (((entity instanceof ISoulHost)) && (!((ISoulHost)entity).isTrappableInBoneCage())) {
/* 687 */         return;
/*     */       }
/*     */       
/* 690 */       this.ignorables.add(entity.func_110124_au());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockDefense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */