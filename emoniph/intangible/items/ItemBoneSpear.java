/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntityThrownWeapon;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.EntityHistory;
/*     */ import emoniph.intangible.util.NbtUtil;
/*     */ import emoniph.intangible.util.RayTraceUtil;
/*     */ import emoniph.intangible.util.TickUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemSword;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.common.capabilities.CapabilityManager;
/*     */ import net.minecraftforge.event.AttachCapabilitiesEvent.Item;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ 
/*     */ public class ItemBoneSpear extends ItemSword implements IItem, IItemWithVariants, IItemAttackHandler, ICreativeSort
/*     */ {
/*     */   @net.minecraftforge.common.capabilities.CapabilityInject(IBoneSpear.class)
/*  48 */   public static Capability<IBoneSpear> BONE_SPEAR_CAPABILITY = null;
/*     */   
/*     */   public static void registerCapabilities() {
/*  51 */     CapabilityManager.INSTANCE.register(IBoneSpear.class, new net.minecraftforge.common.capabilities.Capability.IStorage()
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  56 */       new java.util.concurrent.Callable
/*     */       {
/*     */         public NBTBase writeNBT(Capability<IBoneSpear> capability, IBoneSpear instance, EnumFacing side) {
/*  54 */           NBTTagCompound compound = new NBTTagCompound();
/*     */           
/*  56 */           return compound; } public void readNBT(Capability<IBoneSpear> capability, IBoneSpear instance, EnumFacing side, NBTBase base) {} }, new java.util.concurrent.Callable()
/*     */       {
/*     */ 
/*     */ 
/*     */         public ItemBoneSpear.BoneSpearState call()
/*     */           throws Exception
/*     */         {
/*     */ 
/*     */ 
/*  65 */           return new ItemBoneSpear.BoneSpearState();
/*     */         }
/*     */       });
/*     */   }
/*     */   
/*     */   public static void tryAttachCapability(AttachCapabilitiesEvent.Item event) {
/*  71 */     if (event.getItem() == Get.items().SOUL_SPEAR) {
/*  72 */       event.addCapability(new net.minecraft.util.ResourceLocation("intangible:bonespear"), new net.minecraftforge.common.capabilities.ICapabilityProvider() {
/*  73 */         private final ItemBoneSpear.BoneSpearState state = new ItemBoneSpear.BoneSpearState();
/*     */         
/*     */         public boolean hasCapability(Capability<?> capability, EnumFacing facing)
/*     */         {
/*  77 */           return capability == ItemBoneSpear.BONE_SPEAR_CAPABILITY;
/*     */         }
/*     */         
/*     */         public <T> T getCapability(Capability<T> capability, EnumFacing facing)
/*     */         {
/*  82 */           return capability == ItemBoneSpear.BONE_SPEAR_CAPABILITY ? this.state : null;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  90 */     return 3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class BoneSpearState
/*     */     implements IBoneSpear
/*     */   {
/*     */     boolean extended;
/*     */     
/*     */ 
/*     */     public boolean isExtended()
/*     */     {
/* 103 */       return this.extended;
/*     */     }
/*     */     
/*     */     public void setExtended(boolean extend)
/*     */     {
/* 108 */       this.extended = extend;
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemBoneSpear() {
/* 113 */     super(Get.toolBoneMaterial());
/* 114 */     func_77625_d(1);
/*     */   }
/*     */   
/*     */   public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
/*     */   {
/* 119 */     if ((isSelected) && ((entityIn instanceof EntityPlayer)) && 
/* 120 */       (!worldIn.field_72995_K)) {
/* 121 */       EntityPlayer player = (EntityPlayer)entityIn;
/* 122 */       if ((!player.func_71039_bw()) && (player.field_70173_aa % 4 == 0)) {
/* 123 */         PlayerEx playerEx = PlayerEx.get(player);
/* 124 */         playerEx.CACHE.getPosHistory().push(player);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 129 */     if ((entityIn instanceof EntityPlayer)) {
/* 130 */       EntityPlayer player = (EntityPlayer)entityIn;
/* 131 */       if ((isExtended(stack)) && (!player.field_82175_bq)) {
/* 132 */         setExtended(stack, false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onHurtBy(ItemStack stack, PlayerEx playerEx, LivingHurtEvent event, Attack attack)
/*     */   {
/* 139 */     if (isShield(stack)) {
/* 140 */       if (playerEx.PLAYER.func_71039_bw()) {
/* 141 */         attack.setDamage(attack.getDamage() * 0.75F);
/*     */       } else {
/* 143 */         attack.setDamage(attack.getDamage() * 0.25F);
/*     */       }
/* 145 */     } else if ((playerEx.PLAYER.func_70093_af()) && ((attack.getDamageSource() instanceof net.minecraft.util.EntityDamageSource)) && ((attack.getDamageSource().func_76364_f() instanceof EntityLivingBase)) && (attack.getDamageSource().func_76364_f() != playerEx.PLAYER) && 
/* 146 */       (canActivate(stack, playerEx, SoulType.BENIGN, 5))) {
/* 147 */       EntityLivingBase target = (EntityLivingBase)attack.getDamageSource().func_76364_f();
/* 148 */       EntityPlayer player = playerEx.PLAYER;
/* 149 */       Vec3 vec = new Vec3(target.field_70165_t - player.field_70165_t, target.field_70163_u - player.field_70163_u, target.field_70161_v - player.field_70161_v).func_72432_b();
/*     */       
/* 151 */       boolean overclock = canActivate(stack, playerEx, SoulType.UNHINGED, 5);
/* 152 */       float speed = overclock ? 2.0F : 1.6F;
/* 153 */       float lift = overclock ? 1.0F : 0.5F;
/* 154 */       double dx = vec.field_72450_a * speed;
/* 155 */       double dy = lift;
/* 156 */       double dz = vec.field_72449_c * speed;
/* 157 */       if ((target instanceof EntityPlayer)) {
/* 158 */         EntityPlayer otherPlayer = (EntityPlayer)target;
/* 159 */         Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(otherPlayer, dx, dy, dz), otherPlayer);
/*     */       } else {
/* 161 */         target.field_70159_w = dx;
/* 162 */         target.field_70181_x = dy;
/* 163 */         target.field_70179_y = dz;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onAttacking(ItemStack stack, PlayerEx playerEx, LivingHurtEvent event, Attack attack)
/*     */   {
/* 171 */     if ((!playerEx.PLAYER.field_70170_p.field_72995_K) && 
/* 172 */       (canActivate(stack, playerEx, SoulType.DOOMED, 10))) {
/* 173 */       event.entityLiving.func_70606_j(Math.max(1.0F, event.entityLiving.func_110143_aJ() - (4.0F + func_150931_i())));
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean canActivate(ItemStack stack, EntityPlayer player, SoulType soul, int cooldown)
/*     */   {
/* 179 */     return canActivate(stack, PlayerEx.get(player), soul, cooldown);
/*     */   }
/*     */   
/*     */   private boolean canActivate(ItemStack stack, PlayerEx playerEx, SoulType soul, int cooldownSecs) {
/* 183 */     SoulSet souls = ItemSoulArmor.getCapacity(stack);
/* 184 */     return (souls.quantityOf(soul) > 0) && (playerEx.tryConsumeSouls(new SoulSet().add(soul, 1), TickUtil.fromSeconds(cooldownSecs)));
/*     */   }
/*     */   
/*     */   public void func_150895_a(Item itemIn, net.minecraft.creativetab.CreativeTabs tab, List subItems)
/*     */   {
/* 189 */     super.func_150895_a(itemIn, tab, subItems);
/*     */     
/* 191 */     ItemStack powered = new ItemStack(this, 1, 0);
/* 192 */     SoulSet souls = new SoulSet();
/* 193 */     souls.add(SoulType.BENIGN, 1).add(SoulType.PREDATORY, 1).add(SoulType.UNHINGED, 1).add(SoulType.IMMUTABLE, 1).add(SoulType.DOOMED, 1).add(SoulType.MALLEABLE, 1).add(SoulType.NOBLE, 1).add(SoulType.WISE, 1);
/* 194 */     ItemSoulArmor.setCapacity(powered, souls);
/*     */     
/* 196 */     subItems.add(powered);
/*     */   }
/*     */   
/*     */   public boolean func_179218_a(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
/*     */   {
/* 201 */     return super.func_179218_a(stack, worldIn, blockIn, pos, playerIn);
/*     */   }
/*     */   
/*     */   public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player)
/*     */   {
/* 206 */     World world = player.field_70170_p;
/* 207 */     if ((!world.field_72995_K) && (!isShield(stack))) {
/* 208 */       IBlockState state = world.func_180495_p(pos);
/* 209 */       if ((net.minecraft.block.BlockPistonBase.func_180696_a(state.func_177230_c(), world, pos, EnumFacing.UP, false)) && 
/* 210 */         (emoniph.intangible.util.BlockUtil.canEditBlock(player, world, pos)) && 
/* 211 */         (getThrowable(stack) == null)) {
/* 212 */         List<ItemStack> drops = state.func_177230_c().getDrops(world, pos, state, 0);
/* 213 */         if ((drops.size() == 1) && (canActivate(stack, player, SoulType.IMMUTABLE, 10))) {
/* 214 */           setThrowable(stack, (ItemStack)drops.get(0));
/* 215 */           world.func_175698_g(pos);
/* 216 */           return true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 222 */     return false;
/*     */   }
/*     */   
/*     */   public void onLivingAttack(ItemStack stack, PlayerEx playerEx, LivingAttackEvent event)
/*     */   {
/*     */     boolean paid;
/* 228 */     if (!(event.source instanceof emoniph.intangible.util.DamageSourceSoulBone)) {
/* 229 */       double reach = 5.0D;
/* 230 */       List<MovingObjectPosition> targets = traceEntities(playerEx.PLAYER, reach);
/* 231 */       paid = false;
/* 232 */       for (MovingObjectPosition target : targets) {
/* 233 */         if (target.field_72308_g != event.entityLiving) {
/* 234 */           if (!paid) {
/* 235 */             if ((isShield(stack)) || (!canActivate(stack, playerEx, SoulType.WISE, 3))) break;
/* 236 */             paid = true;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 241 */           if (playerEx.PLAYER.field_70170_p.field_72995_K) {
/* 242 */             setExtended(stack, true);
/*     */           } else {
/* 244 */             target.field_72308_g.func_70097_a(new emoniph.intangible.util.DamageSourceSoulBone(playerEx.PLAYER, false), event.ammount);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onLivingDrops(ItemStack stack, EntityPlayer player, LivingDropsEvent event)
/*     */   {
/* 253 */     for (EntityItem entity : event.drops) {
/* 254 */       if (entity.func_92059_d().func_77973_b() == net.minecraft.init.Items.field_151103_aS) {
/* 255 */         entity.func_92059_d().func_150996_a(Get.items().SOUL_BONE);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static List<MovingObjectPosition> traceEntities(EntityLivingBase entity, double reach) {
/* 261 */     Vec3 entityPosition = RayTraceUtil.getPosition(entity);
/* 262 */     Vec3 entityViewOffset = RayTraceUtil.getViewOffset(entity, entityPosition, reach);
/* 263 */     return traceEntities(entity, reach, entityPosition, entityViewOffset);
/*     */   }
/*     */   
/*     */   private static List<MovingObjectPosition> traceEntities(EntityLivingBase entity, double reachDistance, Vec3 entityPosition, Vec3 entityViewOffset) {
/* 267 */     double playerBorder = 1.1D * reachDistance;
/* 268 */     AxisAlignedBB scanBounds = entity.func_174813_aQ().func_72314_b(playerBorder, playerBorder, playerBorder);
/* 269 */     List hitEntityList = entity.func_130014_f_().func_175674_a(entity, scanBounds, new com.google.common.base.Predicate() {
/*     */       public boolean apply(Entity entityIn) {
/* 271 */         return entityIn instanceof EntityLivingBase;
/*     */       }
/*     */       
/*     */       public boolean apply(Object p_apply_1_) {
/* 275 */         return apply((Entity)p_apply_1_);
/*     */       }
/* 277 */     });
/* 278 */     List<MovingObjectPosition> targets = new java.util.ArrayList();
/* 279 */     if (!hitEntityList.isEmpty()) {
/* 280 */       double closestEntity = reachDistance;
/* 281 */       for (Entity hitEntity : hitEntityList) {
/* 282 */         if ((hitEntity != null) && (hitEntity.func_70067_L()) && (hitEntity.func_174813_aQ() != null)) {
/* 283 */           float collideBorder = hitEntity.func_70111_Y();
/* 284 */           AxisAlignedBB entityBounds = hitEntity.func_174813_aQ().func_72314_b(collideBorder, collideBorder, collideBorder);
/* 285 */           MovingObjectPosition mop = entityBounds.func_72327_a(entityPosition, entityViewOffset);
/* 286 */           if (mop != null) {
/* 287 */             if (entityBounds.func_72318_a(entityPosition)) {
/* 288 */               targets.add(new MovingObjectPosition(hitEntity));
/*     */             } else {
/* 290 */               double distance = entityPosition.func_72438_d(mop.field_72307_f);
/* 291 */               if (distance < reachDistance) {
/* 292 */                 MovingObjectPosition mopTarget = new MovingObjectPosition(hitEntity);
/* 293 */                 mopTarget.field_72307_f = mop.field_72307_f;
/* 294 */                 targets.add(mopTarget);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 302 */     return targets;
/*     */   }
/*     */   
/*     */   public boolean isExtended(ItemStack stack) {
/* 306 */     IBoneSpear spear = (IBoneSpear)stack.getCapability(BONE_SPEAR_CAPABILITY, EnumFacing.UP);
/* 307 */     return (spear != null) && (spear.isExtended());
/*     */   }
/*     */   
/*     */   private void setExtended(ItemStack stack, boolean extended) {
/* 311 */     IBoneSpear spear = (IBoneSpear)stack.getCapability(BONE_SPEAR_CAPABILITY, EnumFacing.UP);
/* 312 */     if (spear != null) {
/* 313 */       spear.setExtended(extended);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isShield(ItemStack stack) {
/* 318 */     return NbtUtil.forStack(stack).func_74767_n("shield");
/*     */   }
/*     */   
/*     */   private void setShield(ItemStack stack, boolean shield) {
/* 322 */     NBTTagCompound compound = NbtUtil.forStack(stack);
/* 323 */     compound.func_74757_a("shield", shield);
/*     */   }
/*     */   
/*     */   private void setThrowable(ItemStack stack, ItemStack itemToThrow) {
/* 327 */     NBTTagCompound compound = NbtUtil.forStack(stack);
/* 328 */     if (itemToThrow == null) {
/* 329 */       if (compound.func_74764_b("throw")) {
/* 330 */         compound.func_82580_o("throw");
/*     */       }
/*     */     } else {
/* 333 */       compound.func_74782_a("throw", itemToThrow.func_77955_b(new NBTTagCompound()));
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack getThrowable(ItemStack stack) {
/* 338 */     NBTTagCompound throwable = (stack.func_77978_p() != null) && (stack.func_77978_p().func_74764_b("throw")) ? stack.func_77978_p().func_74775_l("throw") : null;
/* 339 */     if (throwable != null) {
/* 340 */       return ItemStack.func_77949_a(throwable);
/*     */     }
/*     */     
/* 343 */     return null;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack stack)
/*     */   {
/* 348 */     return TickUtil.fromSeconds(5);
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/* 354 */     return EnumRarity.RARE;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean advancedTooltips)
/*     */   {
/* 360 */     SoulSet souls = ItemSoulArmor.getCapacity(stack);
/* 361 */     for (SoulType soul : souls) {
/* 362 */       list.add(emoniph.intangible.util.TextUtil.parse(EnumSoulType.fromSoulType(soul).getLocalizedName()));
/*     */     }
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack stack, World worldIn, EntityPlayer playerIn)
/*     */   {
/* 368 */     if (!worldIn.field_72995_K) {
/* 369 */       SoulSet capacity = ItemSoulArmor.getCapacity(stack);
/* 370 */       if ((capacity.quantityOf(SoulType.NOBLE) > 0) || (capacity.quantityOf(SoulType.MALLEABLE) > 0)) {
/* 371 */         if (playerIn.func_70093_af()) {
/* 372 */           if (isShield(stack)) {
/* 373 */             setShield(stack, false);
/* 374 */             playerIn.func_71041_bz();
/* 375 */             PlayerEx.get(playerIn).CACHE.getPosHistory().clear();
/* 376 */           } else if (getThrowable(stack) == null) {
/* 377 */             if (canActivate(stack, playerIn, SoulType.MALLEABLE, 15)) {
/* 378 */               setShield(stack, true);
/* 379 */               PlayerEx.get(playerIn).CACHE.getPosHistory().clear();
/*     */             }
/* 381 */             playerIn.func_71008_a(stack, func_77626_a(stack));
/*     */           }
/*     */         }
/* 384 */         else if (!isShield(stack)) {
/* 385 */           if (canActivate(stack, playerIn, SoulType.NOBLE, 10)) {
/* 386 */             playerIn.func_71008_a(stack, func_77626_a(stack));
/*     */           }
/*     */         } else {
/* 389 */           playerIn.func_71008_a(stack, func_77626_a(stack));
/*     */         }
/*     */       }
/*     */     }
/* 393 */     else if (worldIn.field_72995_K) {
/* 394 */       SoulSet capacity = ItemSoulArmor.getCapacity(stack);
/* 395 */       if ((capacity.quantityOf(SoulType.NOBLE) > 0) || (capacity.quantityOf(SoulType.MALLEABLE) > 0)) {
/* 396 */         playerIn.func_71008_a(stack, func_77626_a(stack));
/*     */       }
/*     */     }
/* 399 */     return stack;
/*     */   }
/*     */   
/*     */   public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack)
/*     */   {
/* 404 */     World world = entity.field_70170_p;
/* 405 */     if ((!world.field_72995_K) && ((entity instanceof EntityPlayerMP))) {
/* 406 */       EntityPlayerMP player = (EntityPlayerMP)entity;
/* 407 */       MovingObjectPosition movingPosition = RayTraceUtil.traceAny(player, true, player.field_71134_c.getBlockReachDistance());
/* 408 */       if ((movingPosition == null) || (movingPosition.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.MISS)) {
/* 409 */         ItemStack throwable = getThrowable(stack);
/* 410 */         if (throwable != null) {
/* 411 */           int impact = 0;
/* 412 */           Block block = Block.func_149634_a(throwable.func_77973_b());
/* 413 */           if (block != null) {
/* 414 */             world.func_175718_b(2001, new BlockPos(entity), Block.func_176210_f(block.func_176223_P()));
/* 415 */             impact = (int)Math.min(Math.round(Math.sqrt(Math.max(1.0F, block.func_149638_a(entity) * 5.0F)) / 2.0D), 2L);
/*     */           }
/* 417 */           world.func_72838_d(new EntityThrownWeapon(world, player, throwable, canActivate(stack, player, SoulType.UNHINGED, 10) ? impact : 0));
/* 418 */           setThrowable(stack, null);
/* 419 */         } else if (((player.field_71075_bZ.field_75098_d) || (player.field_71071_by.func_70431_c(ItemPart.EnumPart.BONE_SPLINTERS.getRefStack()))) && 
/* 420 */           (canActivate(stack, player, SoulType.PREDATORY, 6))) {
/* 421 */           if (!player.field_71075_bZ.field_75098_d) {
/* 422 */             emoniph.intangible.util.InventoryUtil.consumeInventoryItem(player.field_71071_by, ItemPart.EnumPart.BONE_SPLINTERS.getRefStack());
/*     */           }
/*     */           
/* 425 */           world.func_72838_d(new EntityThrownWeapon(world, player, ItemPart.EnumPart.BONE_SPLINTERS.getRefStack().func_77946_l(), 0));
/* 426 */           if (canActivate(stack, player, SoulType.UNHINGED, 10)) {
/* 427 */             EntityThrownWeapon thrown = new EntityThrownWeapon(world, player, ItemPart.EnumPart.BONE_SPLINTERS.getRefStack().func_77946_l(), 0);
/* 428 */             thrown.field_70181_x += 0.1D;
/* 429 */             world.func_72838_d(thrown);
/*     */           }
/* 431 */           emoniph.intangible.Sound.MOD_RANDOM_BONECREEK_CLOSE.playToAllNear(player, 0.4F, 2.0F);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 436 */     return false;
/*     */   }
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
/*     */   {
/* 441 */     if ((!player.field_70170_p.field_72995_K) && (!isShield(stack))) {
/* 442 */       PlayerEx playerEx = PlayerEx.get(player);
/* 443 */       playerEx.CACHE.getPosHistory().pop(player);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77615_a(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
/*     */   {
/* 449 */     if (!playerIn.field_70170_p.field_72995_K) {
/* 450 */       PlayerEx playerEx = PlayerEx.get(playerIn);
/* 451 */       playerEx.CACHE.getPosHistory().clear();
/*     */     }
/* 453 */     super.func_77615_a(stack, worldIn, playerIn, timeLeft);
/*     */   }
/*     */   
/*     */   public ItemStack func_77654_b(ItemStack stack, World worldIn, EntityPlayer playerIn)
/*     */   {
/* 458 */     return super.func_77654_b(stack, worldIn, playerIn);
/*     */   }
/*     */   
/* 461 */   private VariantItemData[] VARIANTS = { new VariantItemData("basic", 0), new VariantItemData("extended", 1), new VariantItemData("shield", 2) };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public VariantItemData[] getVariants()
/*     */   {
/* 469 */     return this.VARIANTS;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemBoneSpear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */