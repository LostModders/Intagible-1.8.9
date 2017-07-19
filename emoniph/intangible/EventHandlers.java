/*     */ package emoniph.intangible;
/*     */ 
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.entity.EntityHollowIronGolem;
/*     */ import emoniph.intangible.entity.EntityWreckingGolem;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerForm;
/*     */ import emoniph.intangible.souls.ISoulHost;
/*     */ import emoniph.intangible.souls.SoulRegistry;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.boss.EntityWither;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.monster.EntityWitch;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.capabilities.Capability;
/*     */ import net.minecraftforge.event.AttachCapabilitiesEvent.Entity;
/*     */ import net.minecraftforge.event.AttachCapabilitiesEvent.Item;
/*     */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*     */ import net.minecraftforge.event.entity.EntityMountEvent;
/*     */ import net.minecraftforge.event.entity.item.ItemExpireEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingFallEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
/*     */ import net.minecraftforge.event.entity.player.FillBucketEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerUseItemEvent.Finish;
/*     */ import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
/*     */ import net.minecraftforge.event.world.ChunkEvent.Load;
/*     */ import net.minecraftforge.event.world.ChunkEvent.Unload;
/*     */ import net.minecraftforge.event.world.WorldEvent.Load;
/*     */ import net.minecraftforge.fml.common.eventhandler.Event.Result;
/*     */ import net.minecraftforge.fml.common.eventhandler.EventPriority;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedOutEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;
/*     */ 
/*     */ public class EventHandlers
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onPlayerChangedDimension(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerChangedDimensionEvent event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerRespawn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerLoggedOut(PlayerEvent.PlayerLoggedOutEvent event)
/*     */   {
/*  73 */     Get.log().debug("Player logging out: " + event.player);
/*  74 */     if ((!event.player.field_70170_p.field_72995_K) && ((((event.player.field_70154_o instanceof EntityWreckingGolem)) && 
/*  75 */       (((EntityWreckingGolem)event.player.field_70154_o).getSeat() != null)) || ((event.player.field_70154_o instanceof emoniph.intangible.entity.EntitySeat)))) {
/*  76 */       event.player.func_70078_a(null);
/*  77 */       Get.log().debug("Player dismounted: " + event.player);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @SubscribeEvent
/*     */   public void onServerTick(net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onWorldTick(TickEvent.WorldTickEvent event)
/*     */   {
/*  88 */     if (event.phase == net.minecraftforge.fml.common.gameevent.TickEvent.Phase.START) {
/*  89 */       Get.deities().tick(event.world);
/*  90 */       Get.actions().processQueue(event.world, 5);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onWorldLoad(WorldEvent.Load event) {
/*  96 */     Get.deities().initWorld(event.world);
/*  97 */     Get.shrines().initWorld(event.world);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onChunkLoad(ChunkEvent.Load event) {
/* 102 */     Get.relays().loadChunk(event.getChunk());
/* 103 */     Get.wells().loadChunk(event.getChunk());
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onChunkUnload(ChunkEvent.Unload event) {
/* 108 */     Get.relays().unloadChunk(event.getChunk());
/* 109 */     Get.wells().unloadChunk(event.getChunk());
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onAttachCapabilities(AttachCapabilitiesEvent.Entity event) {
/* 114 */     if ((event.getEntity() instanceof EntityLivingBase)) {
/* 115 */       event.addCapability(new net.minecraft.util.ResourceLocation("intangible:killtracker"), new net.minecraftforge.common.capabilities.ICapabilityProvider() {
/* 116 */         private final emoniph.intangible.capabilities.EntityKillTracker tracker = new emoniph.intangible.capabilities.EntityKillTracker();
/*     */         
/*     */         public <T> T getCapability(Capability<T> capability, EnumFacing facing)
/*     */         {
/* 120 */           return capability == emoniph.intangible.capabilities.CapabilityKillTracker.KILL_TRACKER_CAPABILITY ? this.tracker : null;
/*     */         }
/*     */         
/*     */         public boolean hasCapability(Capability<?> capability, EnumFacing facing)
/*     */         {
/* 125 */           return capability == emoniph.intangible.capabilities.CapabilityKillTracker.KILL_TRACKER_CAPABILITY;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onAttachCapabilities(AttachCapabilitiesEvent.Item event) {
/* 133 */     if ((event.getItemStack() != null) && (event.getItem() != null)) {
/* 134 */       emoniph.intangible.items.ItemBoneSpear.tryAttachCapability(event);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent(priority=EventPriority.HIGH)
/*     */   public void onEntityJoinWorld(EntityJoinWorldEvent event) {
/* 140 */     for (IDeity deity : Get.deities().forWorld(event.world)) {
/* 141 */       if (!deity.getMajorEffect().onEntityJoinWorld(event.world, deity, event.entity)) {
/* 142 */         event.setCanceled(true);
/*     */       }
/*     */       
/* 145 */       if ((!event.isCanceled()) && 
/* 146 */         (!deity.getMinorEffect().onEntityJoinWorld(event.world, deity, event.entity))) {
/* 147 */         event.setCanceled(true);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 152 */     if ((event.entity instanceof EntityLiving)) {
/* 153 */       EntityLiving living = (EntityLiving)event.entity;
/* 154 */       Get.souls().syncSoulInEntity(living);
/* 155 */       emoniph.intangible.spells.grenades.SpellPacify.initPacified(living);
/*     */     }
/*     */     
/* 158 */     if ((event.entity instanceof EntityItem)) {
/* 159 */       EntityItem entity = (EntityItem)event.entity;
/* 160 */       if ((Get.config().REPLACE_DROPPED_GLASS) && 
/* 161 */         (entity.func_92059_d() != null) && (entity.func_92059_d().func_77973_b() == Item.func_150898_a(Blocks.field_150359_w))) {
/* 162 */         entity.lifespan = 1;
/*     */       }
/*     */       
/*     */ 
/* 166 */       if ((!event.entity.field_70170_p.field_72995_K) && 
/* 167 */         (entity.func_92059_d() != null) && (((entity.func_92059_d().func_77973_b() instanceof emoniph.intangible.items.IMeltableItem)) || 
/* 168 */         (entity.func_92059_d().func_77973_b() == Item.func_150898_a(Blocks.field_150359_w)))) {
/* 169 */         entity.field_83001_bt = true;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingUpdate(LivingEvent.LivingUpdateEvent event)
/*     */   {
/* 177 */     if ((event.entityLiving instanceof EntityPlayer)) {
/* 178 */       EntityPlayer player = (EntityPlayer)event.entityLiving;
/* 179 */       PlayerEx playerEx = PlayerEx.get(player);
/* 180 */       playerEx.getPlayerForm().onLivingUpdate(playerEx);
/*     */       
/* 182 */       if ((player.field_70170_p.field_72995_K) && (player.field_71075_bZ.field_75101_c) && (player.field_71075_bZ.field_75100_b))
/*     */       {
/*     */ 
/* 185 */         if ((player.func_70644_a(net.minecraft.potion.Potion.field_76421_d)) && (!player.field_71075_bZ.field_75098_d))
/*     */         {
/* 187 */           if (player.func_70660_b(net.minecraft.potion.Potion.field_76421_d).func_76458_c() >= 6)
/* 188 */             player.field_70181_x = -0.20000000298023224D; }
/*     */       }
/* 190 */     } else if ((event.entityLiving instanceof EntityWither)) {
/* 191 */       if (!event.entity.field_70170_p.field_72995_K) {
/* 192 */         EntityWither entity = (EntityWither)event.entity;
/* 193 */         for (int i = 0; i < 3; i++) {
/* 194 */           int targetId = entity.func_82203_t(i);
/* 195 */           if (targetId > 0) {
/* 196 */             Entity target = entity.field_70170_p.func_73045_a(targetId);
/* 197 */             if ((target instanceof EntityPlayer)) {
/* 198 */               PlayerEx playerEx = PlayerEx.get((EntityPlayer)target);
/* 199 */               playerEx.getPlayerForm().onTargetedByWither(playerEx, entity, i);
/* 200 */             } else if ((target instanceof ISoulHost)) {
/* 201 */               if (entity.func_70638_az() == target) {
/* 202 */                 entity.func_70624_b(null);
/*     */               }
/* 204 */               ISoulHost shell = (ISoulHost)target;
/* 205 */               if ((!shell.isTrappableInBoneCage()) && (!(target instanceof EntityWreckingGolem))) {
/* 206 */                 entity.func_82211_c(i, 0);
/* 207 */                 entity.func_70624_b(null);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/* 213 */     } else if (((event.entityLiving instanceof EntityWitch)) && 
/* 214 */       (!event.entity.field_70170_p.field_72995_K) && (!Get.souls().isSoulPresent(event.entityLiving, false))) {
/* 215 */       EntityWitch witch = (EntityWitch)event.entity;
/* 216 */       witch.func_70062_b(0, null);
/* 217 */       witch.func_82197_f(false);
/*     */     }
/*     */     
/*     */ 
/* 221 */     Get.souls().updateLivingSoul(event.entityLiving);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onEntityInteract(net.minecraftforge.event.entity.player.EntityInteractEvent event) {
/* 226 */     PlayerEx playerEx = PlayerEx.get(event.entityPlayer);
/* 227 */     playerEx.getPlayerForm().onInteractWithEntity(playerEx, event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerInteract(PlayerInteractEvent event) {
/* 232 */     PlayerEx playerEx = PlayerEx.get(event.entityPlayer);
/* 233 */     playerEx.getPlayerForm().onInteract(playerEx, event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingFall(LivingFallEvent event) {
/* 238 */     if ((event.entityLiving instanceof EntityPlayer)) {
/* 239 */       EntityPlayer player = (EntityPlayer)event.entityLiving;
/* 240 */       PlayerEx playerEx = PlayerEx.get(player);
/* 241 */       playerEx.getPlayerForm().onFall(playerEx, event);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingJump(LivingEvent.LivingJumpEvent event) {
/* 247 */     if ((event.entityLiving instanceof EntityPlayer)) {
/* 248 */       EntityPlayer player = (EntityPlayer)event.entityLiving;
/* 249 */       PlayerEx playerEx = PlayerEx.get(player);
/* 250 */       playerEx.getPlayerForm().onJump(playerEx, event);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingHurt(LivingHurtEvent event)
/*     */   {
/* 257 */     if ((event.source.func_76346_g() instanceof EntityPlayer)) {
/* 258 */       EntityPlayer player = (EntityPlayer)event.source.func_76346_g();
/* 259 */       PlayerEx playerEx = PlayerEx.get(player);
/* 260 */       playerEx.getPlayerForm().onAttacking(playerEx, event);
/*     */     }
/*     */     
/* 263 */     if ((event.source.func_76346_g() instanceof EntityPlayer)) {
/* 264 */       PlayerEx.get((EntityPlayer)event.source.func_76346_g()).onWorshipAttack(event.entityLiving, false);
/*     */     }
/*     */     
/* 267 */     if ((event.entity instanceof EntityPlayer)) {
/* 268 */       EntityPlayer player = (EntityPlayer)event.entity;
/* 269 */       PlayerEx playerEx = PlayerEx.get(player);
/* 270 */       playerEx.getPlayerForm().onHurtBy(playerEx, event);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SubscribeEvent
/*     */   public void onEntityMount(EntityMountEvent event)
/*     */   {
/* 282 */     if ((event.entityMounting instanceof EntityPlayer)) {
/* 283 */       EntityPlayer player = (EntityPlayer)event.entityMounting;
/* 284 */       PlayerEx playerEx = PlayerEx.get(player);
/* 285 */       playerEx.getPlayerForm().onMountEntity(playerEx, event);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent(priority=EventPriority.LOWEST)
/*     */   public void onLivingDeath(LivingDeathEvent event)
/*     */   {
/* 292 */     if (!event.isCanceled()) {
/* 293 */       if ((!event.entityLiving.field_70170_p.field_72995_K) && ((event.source.func_76346_g() instanceof EntityLivingBase))) {
/* 294 */         emoniph.intangible.capabilities.IKillTracker killTracker = (emoniph.intangible.capabilities.IKillTracker)event.source.func_76346_g().getCapability(emoniph.intangible.capabilities.CapabilityKillTracker.KILL_TRACKER_CAPABILITY, EnumFacing.UP);
/* 295 */         if (killTracker != null) {
/* 296 */           killTracker.addKill(event.source.func_76346_g(), event.entityLiving);
/*     */         }
/*     */       }
/*     */       
/* 300 */       if ((event.entityLiving instanceof EntityPlayer)) {
/* 301 */         EntityPlayer player = (EntityPlayer)event.entityLiving;
/* 302 */         PlayerEx playerEx = PlayerEx.get(player);
/* 303 */         playerEx.getPlayerForm().onDeath(playerEx, event);
/*     */       }
/*     */       
/* 306 */       if ((event.source.func_76346_g() instanceof EntityPlayer)) {
/* 307 */         PlayerEx.get((EntityPlayer)event.source.func_76346_g()).onWorshipAttack(event.entityLiving, true);
/*     */       }
/*     */       
/*     */ 
/* 311 */       SoulType soulType = Get.souls().getSoulFor(event.entityLiving.getClass());
/* 312 */       if ((soulType != null) && (Get.souls().isSoulPresent(event.entityLiving, true)) && 
/* 313 */         (event.source.func_76364_f() != null) && ((event.source.func_76364_f() instanceof EntityLivingBase))) {
/* 314 */         EntityLivingBase attacker = (EntityLivingBase)event.source.func_76364_f();
/* 315 */         if (!event.entityLiving.field_70170_p.field_72995_K) {
/* 316 */           ItemStack stack = attacker.func_70694_bm();
/* 317 */           if ((stack != null) && (stack.func_77973_b() == net.minecraft.init.Items.field_151103_aS)) {
/* 318 */             Sound.MOD_RANDOM_SLURP.playToAllNear(attacker);
/* 319 */             ItemStack soulbone = new ItemStack(Get.items().SOUL_BONE);
/* 320 */             if (stack.field_77994_a > 1) {
/* 321 */               stack.field_77994_a -= 1;
/* 322 */               if ((attacker instanceof EntityPlayer)) {
/* 323 */                 EntityPlayer playerAttacker = (EntityPlayer)attacker;
/* 324 */                 PlayerEx.addItemStackToInventory(playerAttacker, soulbone);
/*     */               } else {
/* 326 */                 attacker.field_70170_p.func_72838_d(new EntityItem(attacker.field_70170_p, attacker.field_70165_t, attacker.field_70163_u + attacker.field_70131_O * 0.5D, attacker.field_70161_v, soulbone));
/*     */               }
/*     */             }
/*     */             else
/*     */             {
/* 331 */               attacker.func_70062_b(0, soulbone);
/*     */             }
/*     */             
/* 334 */             if ((attacker instanceof EntityPlayer)) {
/* 335 */               PlayerEx playerEx = PlayerEx.get((EntityPlayer)attacker);
/* 336 */               if (!playerEx.isKnowledgeLearnt(new emoniph.intangible.api.IKnol[] { Get.knowledge().MAT_SOULBONE })) {
/* 337 */                 playerEx.learnKnowledge(new net.minecraft.util.Vec3(event.entity.field_70165_t, event.entity.field_70163_u + event.entity.field_70131_O * 0.5D, event.entity.field_70161_v), new emoniph.intangible.api.IKnol[] {
/* 338 */                   Get.knowledge().MAT_SOULBONE });
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 347 */       if (((event.entity instanceof EntityLiving)) && (Get.souls().getSoulFor(event.entityLiving.getClass()) == SoulType.DOOMED)) {
/* 348 */         World world = event.entity.field_70170_p;
/* 349 */         if (!world.field_72995_K) {
/* 350 */           java.util.List<EntityHollowIronGolem> shells = world.func_72872_a(EntityHollowIronGolem.class, event.entity.func_174813_aQ().func_72314_b(32.0D, 32.0D, 32.0D));
/*     */           
/* 352 */           EntityHollowIronGolem closest = null;
/* 353 */           double closestDistSq = Double.MAX_VALUE;
/* 354 */           for (EntityHollowIronGolem entity : shells) {
/* 355 */             double distSq = event.entity.func_70068_e(entity);
/* 356 */             if (((closest == null) || (distSq < closestDistSq)) && (entity.getTrappedSoul() == null) && (entity.isUpgraded())) {
/* 357 */               closestDistSq = distSq;
/* 358 */               closest = entity;
/*     */             }
/*     */           }
/*     */           
/* 362 */           if (closest != null) {
/* 363 */             closest.setTrappedSoul(SoulType.DOOMED, (String)net.minecraft.entity.EntityList.field_75626_c.get(event.entity.getClass()), event.entity.field_70130_N, event.entity.field_70131_O);
/* 364 */             Get.fx().GLOW.sendToAllNear(event.entity, 0.25F, 10, 61547, new net.minecraft.util.Vec3(closest.field_70165_t, closest.field_70163_u + closest.func_70047_e(), closest.field_70161_v), 0.3F);
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 371 */       if (Get.souls().isSoulPresent(event.entityLiving, true)) {}
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SubscribeEvent
/*     */   public void onLivingSetAttackTarget(LivingSetAttackTargetEvent event)
/*     */   {
/* 380 */     if (event.target != null) {
/* 381 */       if ((event.target instanceof EntityPlayer))
/*     */       {
/* 383 */         EntityPlayer player = (EntityPlayer)event.target;
/* 384 */         PlayerEx playerEx = PlayerEx.get(player);
/* 385 */         playerEx.getPlayerForm().onTargeted(playerEx, event);
/* 386 */       } else if (((event.target instanceof ISoulHost)) && ((event.entity instanceof EntityLiving))) {
/* 387 */         ISoulHost shell = (ISoulHost)event.target;
/* 388 */         if ((!shell.isTrappableInBoneCage()) && (!(event.target instanceof EntityWreckingGolem))) {
/* 389 */           EntityLiving entity = (EntityLiving)event.entity;
/* 390 */           entity.func_70624_b(null);
/* 391 */           if ((entity instanceof EntityCreature)) {
/* 392 */             EntityCreature creature = (EntityCreature)entity;
/* 393 */             if (creature.func_70643_av() == event.target) {
/* 394 */               creature.func_70604_c(null);
/*     */             }
/*     */           }
/*     */         }
/* 398 */       } else if (((event.target instanceof EntityHollowIronGolem)) && ((event.entity instanceof net.minecraft.entity.monster.EntityZombie))) {
/* 399 */         EntityLiving entity = (EntityLiving)event.entity;
/* 400 */         entity.func_70624_b(null);
/* 401 */         if ((entity instanceof EntityCreature)) {
/* 402 */           EntityCreature creature = (EntityCreature)entity;
/* 403 */           if (creature.func_70643_av() == event.target) {
/* 404 */             creature.func_70604_c(null);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingAttack(LivingAttackEvent event)
/*     */   {
/* 414 */     if ((event.source.func_76346_g() instanceof EntityPlayer)) {
/* 415 */       EntityPlayer player = (EntityPlayer)event.source.func_76346_g();
/* 416 */       PlayerEx playerEx = PlayerEx.get(player);
/* 417 */       playerEx.getPlayerForm().onLivingAttack(playerEx, event);
/*     */     }
/*     */     
/* 420 */     if ((event.entity instanceof EntityPlayer)) {
/* 421 */       EntityPlayer player = (EntityPlayer)event.entity;
/* 422 */       PlayerEx playerEx = PlayerEx.get(player);
/* 423 */       playerEx.getPlayerForm().onAttackedBy(playerEx, event);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @SubscribeEvent
/*     */   public void onPlayerWakeUpEvent(net.minecraftforge.event.entity.player.PlayerWakeUpEvent event) {}
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onLivingDrops(LivingDropsEvent event)
/*     */   {
/* 434 */     if ((event.source != null) && ((event.source.func_76346_g() instanceof EntityPlayer))) {
/* 435 */       EntityPlayer player = (EntityPlayer)event.source.func_76346_g();
/* 436 */       if ((player.func_70694_bm() != null) && ((player.func_70694_bm().func_77973_b() instanceof emoniph.intangible.items.IItemAttackHandler))) {
/* 437 */         ((emoniph.intangible.items.IItemAttackHandler)player.func_70694_bm().func_77973_b()).onLivingDrops(player.func_70694_bm(), player, event);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SubscribeEvent(priority=EventPriority.HIGH)
/*     */   public void onItemExpire(ItemExpireEvent event)
/*     */   {
/* 449 */     if ((event.entityItem.func_92059_d() != null) && (event.entityItem.func_92059_d().func_77973_b() == Item.func_150898_a(Blocks.field_150359_w)) && 
/* 450 */       (event.entityItem.field_70292_b < 6000)) {
/* 451 */       emoniph.intangible.items.MeltHandler.handleItemTick(event.entityItem, Get.items().GLASS);
/* 452 */       if (!event.entityItem.field_70128_L) {
/* 453 */         event.extraLife = 1;
/* 454 */         event.setCanceled(true);
/*     */       }
/*     */     }
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
/*     */   @SubscribeEvent
/*     */   public void onHarvestDrops(BlockEvent.HarvestDropsEvent event)
/*     */   {
/* 473 */     if ((event.world != null) && (event.harvester != null) && (event.harvester.field_70170_p != null) && (!(event.harvester instanceof net.minecraftforge.common.util.FakePlayer))) {
/* 474 */       PlayerEx playerEx = PlayerEx.get(event.harvester);
/* 475 */       playerEx.getPlayerForm().onHarvestDrops(playerEx, event);
/*     */     }
/*     */     
/* 478 */     if (event.world != null) {
/* 479 */       Get.deities().onHarvest(event);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onItemPickup(EntityItemPickupEvent event) {
/* 485 */     if ((event.item != null) && (event.item.func_92059_d() != null) && (event.item.func_92059_d().func_77973_b() == Get.items().GLASS)) {
/* 486 */       event.item.func_92059_d().func_150996_a(Item.func_150898_a(Blocks.field_150359_w));
/*     */     }
/* 488 */     PlayerEx playerEx = PlayerEx.get(event.entityPlayer);
/* 489 */     playerEx.getPlayerForm().onEntityItemPickup(playerEx, event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerUseItemFinish(PlayerUseItemEvent.Finish event) {
/* 494 */     if ((event.entityLiving != null) && (event.entity.field_70170_p != null) && ((event.entityLiving instanceof EntityPlayer))) {
/* 495 */       Get.deities().onPlayerUseItemFinish(event);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onFillBucket(FillBucketEvent event) {
/* 501 */     if (event.current.func_77973_b() != net.minecraft.init.Items.field_151133_ar)
/* 502 */       return;
/* 503 */     if (event.target.field_72313_a != net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK)
/* 504 */       return;
/* 505 */     if (!event.world.func_175660_a(event.entityPlayer, event.target.func_178782_a()))
/* 506 */       return;
/* 507 */     if (!event.entityPlayer.func_175151_a(event.target.func_178782_a().func_177972_a(event.target.field_178784_b), event.target.field_178784_b, event.current)) {
/* 508 */       return;
/*     */     }
/* 510 */     IBlockState state = event.world.func_180495_p(event.target.func_178782_a());
/* 511 */     if (state.func_177230_c() == Get.blocks().MOLTEN_CRYSTAL_BLUE) {
/* 512 */       if (((Integer)state.func_177229_b(net.minecraftforge.fluids.BlockFluidBase.LEVEL)).intValue() == 0) {
/* 513 */         event.setResult(Event.Result.ALLOW);
/* 514 */         event.result = new ItemStack(Get.items().BUCKET_MOLTEN_CRYSTAL_BLUE);
/* 515 */         event.world.func_175698_g(event.target.func_178782_a());
/*     */       }
/* 517 */     } else if (state.func_177230_c() == Get.blocks().MOLTEN_CRYSTAL_YELLOW) {
/* 518 */       if (((Integer)state.func_177229_b(net.minecraftforge.fluids.BlockFluidBase.LEVEL)).intValue() == 0) {
/* 519 */         event.setResult(Event.Result.ALLOW);
/* 520 */         event.result = new ItemStack(Get.items().BUCKET_MOLTEN_CRYSTAL_YELLOW);
/* 521 */         event.world.func_175698_g(event.target.func_178782_a());
/*     */       }
/* 523 */     } else if ((state.func_177230_c() == Get.blocks().MOLTEN_GLASS) && 
/* 524 */       (((Integer)state.func_177229_b(net.minecraftforge.fluids.BlockFluidBase.LEVEL)).intValue() == 0)) {
/* 525 */       event.setResult(Event.Result.ALLOW);
/* 526 */       event.result = new ItemStack(Get.items().BUCKET_MOLTEN_GLASS);
/* 527 */       event.world.func_175698_g(event.target.func_178782_a());
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/EventHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */