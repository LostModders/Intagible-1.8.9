/*     */ package emoniph.intangible.player;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.blocks.BlockShrine.TileEntityShrine;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.items.IItemAttackHandler;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.util.EntityUtil;
/*     */ import emoniph.intangible.util.MathUtil;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Timer;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
/*     */ import net.minecraftforge.client.event.RenderHandEvent;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent.Post;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent.Pre;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
/*     */ import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public abstract class PlayerForm
/*     */ {
/*     */   private static final double VISION_RANGE = 32.0D;
/*     */   private static final double VISION_RANGE_SQ = 1024.0D;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderTickStart(PlayerEx playerEx) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderTickEnd(PlayerEx playerEx) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderLivingBaseStart(PlayerEx ourPlayer, EntityLivingBase target, RenderLivingEvent.Pre event)
/*     */   {
/*  55 */     if ((target.func_70068_e(ourPlayer.PLAYER) < 1024.0D) && (target != ourPlayer.PLAYER) && 
/*  56 */       (Get.effects().isActiveFor(Get.effects().VISION, ourPlayer.PLAYER)) && (!EntityUtil.canEntityBeSeen(ourPlayer.PLAYER, target))) {
/*  57 */       GlStateManager.func_179097_i();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderLivingBaseEnd(PlayerEx ourPlayer, EntityLivingBase target, RenderLivingEvent.Post event) {}
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderPlayerStart(PlayerEx playerEx, RenderLivingEvent.Pre event)
/*     */   {
/*  69 */     if (Get.effects().isActiveFor(Get.effects().WINGS, playerEx.PLAYER)) if (EntityUtil.isInAir(playerEx.PLAYER, Minecraft.func_71410_x().field_71439_g == playerEx.PLAYER)) {
/*  70 */         double motionFactor = playerEx.PLAYER.field_70159_w * playerEx.PLAYER.field_70159_w + playerEx.PLAYER.field_70179_y * playerEx.PLAYER.field_70179_y;
/*  71 */         double fullSpeed = 0.16000000000000003D;
/*  72 */         double scale = Math.min(motionFactor, fullSpeed) / fullSpeed;
/*  73 */         int forward = new Vec3(playerEx.PLAYER.field_70159_w, 0.0D, playerEx.PLAYER.field_70179_y).func_72430_b(playerEx.PLAYER.func_70040_Z()) > 0.0D ? 1 : -1;
/*  74 */         if (scale > 0.0D) {
/*  75 */           GlStateManager.func_179114_b(-playerEx.PLAYER.field_70177_z, 0.0F, 1.0F, 0.0F);
/*  76 */           GlStateManager.func_179114_b((float)(forward * 40 * scale), 1.0F, 0.0F, 0.0F);
/*  77 */           GlStateManager.func_179114_b(playerEx.PLAYER.field_70177_z, 0.0F, 1.0F, 0.0F);
/*     */         }
/*  79 */         playerEx.PLAYER.field_70754_ba = 0.0F;
/*  80 */         playerEx.PLAYER.field_70721_aZ = 0.0F;
/*  81 */         playerEx.PLAYER.field_70722_aY = 0.0F;
/*     */       }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderPlayerEnd(PlayerEx playerEx, RenderLivingEvent.Post event) {
/*  87 */     if (Get.effects().isActiveFor(Get.effects().WINGS, playerEx.PLAYER)) { if (EntityUtil.isInAir(playerEx.PLAYER, Minecraft.func_71410_x().field_71439_g == playerEx.PLAYER)) {
/*  88 */         double motionFactor = playerEx.PLAYER.field_70159_w * playerEx.PLAYER.field_70159_w + playerEx.PLAYER.field_70179_y * playerEx.PLAYER.field_70179_y;
/*  89 */         double fullSpeed = 0.16000000000000003D;
/*  90 */         double scale = Math.min(motionFactor, fullSpeed) / fullSpeed;
/*  91 */         int forward = new Vec3(playerEx.PLAYER.field_70159_w, 0.0D, playerEx.PLAYER.field_70179_y).func_72430_b(playerEx.PLAYER.func_70040_Z()) > 0.0D ? -1 : 1;
/*  92 */         if (scale > 0.0D) {
/*  93 */           GlStateManager.func_179114_b(-playerEx.PLAYER.field_70177_z, 0.0F, 1.0F, 0.0F);
/*  94 */           GlStateManager.func_179114_b((float)(forward * 40 * scale), 1.0F, 0.0F, 0.0F);
/*  95 */           GlStateManager.func_179114_b(playerEx.PLAYER.field_70177_z, 0.0F, 1.0F, 0.0F);
/*     */         }
/*     */       }
/*     */     }
/*  99 */     Minecraft mc = Minecraft.func_71410_x();
/* 100 */     ItemStack stack = playerEx.PLAYER.func_70694_bm();
/* 101 */     float partialTicks = mc.field_71428_T.field_74281_c;
/* 102 */     EntityPlayer entityIn; if ((stack == null) || (stack.func_77973_b() == Get.items().FOCI))
/*     */     {
/* 104 */       entityIn = playerEx.PLAYER;
/* 105 */       EntityPlayer pl = playerEx.PLAYER;
/* 106 */       if ((entityIn.func_70678_g(1.0F) == 0.0F) && (!playerEx.PLAYER.func_71039_bw()) && (!mc.func_147113_T()) && (playerEx.hasSouls()))
/*     */       {
/* 108 */         float fa = MathUtil.interpolateRotation(entityIn.field_70760_ar, entityIn.field_70761_aq, partialTicks);
/* 109 */         float yaw = MathHelper.func_76142_g(fa - 110.0F);
/* 110 */         float length = 0.4F;
/*     */         
/* 112 */         float f2 = MathHelper.func_76134_b(-yaw * 0.017453292F - 3.1415927F) * length;
/* 113 */         float f3 = MathHelper.func_76126_a(-yaw * 0.017453292F - 3.1415927F) * length;
/*     */         
/* 115 */         boolean overclock = Get.effects().isActiveFor(Get.effects().OVERCLOCK, playerEx.PLAYER);
/* 116 */         boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, playerEx.PLAYER);
/*     */         
/* 118 */         Intangible.PROXY.glow(entityIn.field_70170_p, entityIn.field_70165_t + f3, entityIn.field_70163_u + entityIn.field_70131_O * 0.45D, entityIn.field_70161_v + f2)
/*     */         
/*     */ 
/*     */ 
/* 122 */           .motion(pl.field_70159_w + -0.005D + pl.field_70170_p.field_73012_v.nextDouble() * 0.01D, pl.field_70170_p.field_73012_v
/* 123 */           .nextDouble() * 0.01D, pl.field_70179_y + -0.005D + pl.field_70170_p.field_73012_v
/* 124 */           .nextDouble() * 0.01D)
/* 125 */           .scale(1.5F)
/* 126 */           .color(pl.field_70170_p.field_73012_v.nextFloat() * (overclock ? 0.8F : 0.5F), pl.field_70170_p.field_73012_v.nextFloat() * (unexpected ? 0.6F : 0.2F), pl.field_70170_p.field_73012_v.nextFloat() * 0.5F)
/* 127 */           .durationScale(0.1F);
/*     */       }
/*     */     }
/*     */     
/* 131 */     if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/* 132 */       for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 133 */         effect.onPostRender(playerEx.PLAYER, event.x, event.y, event.z, playerEx, false);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderHand(PlayerEx playerEx, RenderHandEvent event)
/*     */   {
/* 141 */     Minecraft mc = Minecraft.func_71410_x();
/* 142 */     if ((mc.field_71474_y.field_74320_O == 0) && (!mc.field_71474_y.field_74319_N) && (!mc.field_71442_b.func_78747_a()) && 
/* 143 */       (!Get.effects().isIncorporeal(playerEx.PLAYER))) {
/* 144 */       for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 145 */         effect.onPostRender(playerEx.PLAYER, 0.0D, 0.0D, 0.0D, playerEx, true);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 150 */     mc.field_71446_o.func_110577_a(net.minecraft.client.renderer.texture.TextureMap.field_110575_b);
/*     */     
/* 152 */     ItemStack stack = playerEx.PLAYER.func_70694_bm();
/* 153 */     if ((stack == null) || (stack.func_77973_b() == Get.items().FOCI))
/*     */     {
/* 155 */       if (Get.config().RENDER_ARM_ARMOR) {
/* 156 */         GlStateManager.func_179086_m(256);
/* 157 */         emoniph.intangible.client.renderer.RenderPlayerArm.render(event.partialTicks, event.renderPass, mc);
/* 158 */         mc.field_71460_t.func_175067_i(event.partialTicks);
/* 159 */         event.setCanceled(true);
/*     */       }
/*     */       
/*     */ 
/* 163 */       if ((mc.field_71474_y.field_74320_O == 0) && (!mc.field_71474_y.field_74319_N) && (!mc.field_71442_b.func_78747_a()) && 
/* 164 */         (playerEx.PLAYER.func_70678_g(1.0F) == 0.0F) && (!mc.func_147113_T()) && (playerEx.hasSouls())) {
/* 165 */         EntityPlayer pl = playerEx.PLAYER;
/* 166 */         float pitch = pl.field_70127_C + (pl.field_70125_A - pl.field_70127_C) * mc.field_71428_T.field_74281_c;
/* 167 */         float yaw = pl.field_70758_at + (pl.field_70759_as - pl.field_70758_at) * mc.field_71428_T.field_74281_c;
/*     */         
/* 169 */         float handOffsetY = stack == null ? 2.0F : 0.0F;
/* 170 */         float handOffsetX = stack == null ? 0.15F : 0.0F;
/* 171 */         if (playerEx.PLAYER.func_71039_bw()) {
/* 172 */           handOffsetX = -0.4F;
/* 173 */           handOffsetY = 3.0F;
/*     */         }
/*     */         
/* 176 */         Vec3 look = MathUtil.getVectorForRotation(pitch + 25.0F + handOffsetY, yaw, 1.0F);
/* 177 */         Vec3 scaled = MathUtil.getVectorForRotation(0.0F, yaw + 90.0F, 0.55F + handOffsetX);
/*     */         
/* 179 */         boolean overclock = Get.effects().isActiveFor(Get.effects().OVERCLOCK, playerEx.PLAYER);
/* 180 */         boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, playerEx.PLAYER);
/* 181 */         Intangible.PROXY.glow(playerEx.PLAYER.field_70170_p, pl.field_70165_t + look.field_72450_a + scaled.field_72450_a, pl.field_70163_u + look.field_72448_b + scaled.field_72448_b + pl
/*     */         
/* 183 */           .func_70047_e(), pl.field_70161_v + look.field_72449_c + scaled.field_72449_c)
/*     */           
/* 185 */           .motion(pl.field_70159_w + -0.005D + pl.field_70170_p.field_73012_v.nextDouble() * 0.01D, pl.field_70170_p.field_73012_v
/* 186 */           .nextDouble() * 0.01D, pl.field_70179_y + -0.005D + pl.field_70170_p.field_73012_v
/* 187 */           .nextDouble() * 0.01D)
/* 188 */           .scale(1.75F)
/* 189 */           .color(pl.field_70170_p.field_73012_v.nextFloat() * (overclock ? 0.8F : 0.5F), pl.field_70170_p.field_73012_v.nextFloat() * (unexpected ? 0.6F : 0.2F), pl.field_70170_p.field_73012_v.nextFloat() * 0.5F)
/* 190 */           .durationScale(0.1F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderNameplate(PlayerEx playerEx, net.minecraftforge.client.event.RenderLivingEvent.Specials.Pre event) {}
/*     */   
/*     */   public void onLivingUpdate(PlayerEx playerEx)
/*     */   {
/* 201 */     playerEx.onPlayerTick();
/*     */     
/*     */ 
/* 204 */     List<net.minecraft.entity.Entity> nearbyEntities = playerEx.PLAYER.field_70170_p.func_72839_b(playerEx.PLAYER, playerEx.PLAYER.func_174813_aQ().func_72314_b(3.0D, 2.0D, 3.0D));
/*     */     
/* 206 */     if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/* 207 */       for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 208 */         effect.onUpdate(playerEx.PLAYER, playerEx);
/* 209 */         effect.onApplyToNearbyEntities(playerEx.PLAYER, nearbyEntities, playerEx);
/*     */       }
/*     */     }
/*     */     
/* 213 */     playerEx.CACHE.prevX = playerEx.PLAYER.field_70165_t;
/* 214 */     playerEx.CACHE.prevY = playerEx.PLAYER.field_70163_u;
/* 215 */     playerEx.CACHE.prevZ = playerEx.PLAYER.field_70161_v;
/*     */   }
/*     */   
/*     */   public void onInteractWithEntity(PlayerEx playerEx, net.minecraftforge.event.entity.player.EntityInteractEvent event) {
/* 219 */     Get.potions();emoniph.intangible.potions.ModPotions.PICKPOCKET.onInteractWithEntity(playerEx, event);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onInteract(PlayerEx playerEx, net.minecraftforge.event.entity.player.PlayerInteractEvent event) {}
/*     */   
/*     */   public void onClientAction(PlayerEx playerEx, PlayerEx.PacketEntityLivingAction.Action command)
/*     */   {
/* 227 */     switch (command) {
/*     */     case RIGHT_CLICK_AIR: 
/* 229 */       if (!Get.effects().isIncorporeal(playerEx.PLAYER))
/* 230 */         for (IPassiveEffect effect : playerEx.getActiveEffects())
/* 231 */           effect.onRightClickAir(playerEx.PLAYER);
/* 232 */       break;
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
/*     */     case LEFT_CLICK: 
/* 246 */       if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/* 247 */         for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 248 */           effect.onSwing(playerEx.PLAYER, playerEx);
/*     */         }
/*     */       }
/*     */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public void onFall(PlayerEx playerEx, net.minecraftforge.event.entity.living.LivingFallEvent event) {}
/*     */   
/*     */   public void onHurtBy(PlayerEx playerEx, LivingHurtEvent event)
/*     */   {
/* 260 */     Attack attack = new Attack(event);
/* 261 */     if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/* 262 */       for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 263 */         effect.onHurtBy(playerEx.PLAYER, playerEx.focusedTarget, attack, playerEx);
/*     */       }
/*     */     }
/*     */     
/* 267 */     playerEx.setLastHit();
/*     */     
/*     */ 
/* 270 */     Get.potions();emoniph.intangible.potions.ModPotions.TANK.onHurtBy(playerEx, event, attack);
/*     */     
/* 272 */     if ((playerEx.PLAYER.func_70694_bm() != null) && ((playerEx.PLAYER.func_70694_bm().func_77973_b() instanceof IItemAttackHandler))) {
/* 273 */       ((IItemAttackHandler)playerEx.PLAYER.func_70694_bm().func_77973_b()).onHurtBy(playerEx.PLAYER.func_70694_bm(), playerEx, event, attack);
/*     */     }
/*     */     
/* 276 */     event.ammount = attack.getDamage();
/*     */     
/* 278 */     double rangeSq = 64.0D;
/*     */     
/* 280 */     if ((!playerEx.PLAYER.field_70170_p.field_72995_K) && (playerEx.PLAYER.func_70089_S()) && (event.source.func_76346_g() != null) && 
/* 281 */       ((event.source.func_76346_g() instanceof EntityPlayer))) {
/* 282 */       Iterator itr = playerEx.PLAYER.field_70170_p.field_147482_g.iterator();
/* 283 */       while (itr.hasNext()) {
/* 284 */         Object tile = itr.next();
/* 285 */         if ((tile instanceof BlockShrine.TileEntityShrine)) {
/* 286 */           BlockShrine.TileEntityShrine shrine = (BlockShrine.TileEntityShrine)tile;
/* 287 */           if (playerEx.PLAYER.func_174818_b(shrine.func_174877_v()) < rangeSq) {
/* 288 */             shrine.checkPlayerAttack((EntityPlayer)event.source.func_76346_g(), playerEx.PLAYER);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDeath(PlayerEx playerEx, net.minecraftforge.event.entity.living.LivingDeathEvent event) {}
/*     */   
/*     */   public void onTargeted(PlayerEx playerEx, LivingSetAttackTargetEvent event) {}
/*     */   
/*     */   public void onLivingAttack(PlayerEx playerEx, LivingAttackEvent event)
/*     */   {
/* 302 */     if ((playerEx.PLAYER.func_70694_bm() != null) && ((playerEx.PLAYER.func_70694_bm().func_77973_b() instanceof IItemAttackHandler))) {
/* 303 */       ((IItemAttackHandler)playerEx.PLAYER.func_70694_bm().func_77973_b()).onLivingAttack(playerEx.PLAYER.func_70694_bm(), playerEx, event);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onAttackedBy(PlayerEx playerEx, LivingAttackEvent event) {
/* 308 */     Attack attack = new Attack(event);
/* 309 */     if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/* 310 */       for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 311 */         effect.onAttackedBy(playerEx.PLAYER, playerEx.focusedTarget, attack, playerEx);
/*     */       }
/*     */     }
/*     */     
/* 315 */     if (attack.getDamage() == 0.0F) {
/* 316 */       event.setCanceled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onAttacking(PlayerEx playerEx, LivingHurtEvent event) {
/* 321 */     Attack attack = new Attack(event);
/* 322 */     playerEx.focusedTarget.targetHit(event.entityLiving);
/* 323 */     if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/* 324 */       for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 325 */         effect.onAttacking(playerEx.PLAYER, playerEx.focusedTarget, attack, playerEx);
/*     */       }
/*     */     }
/*     */     
/* 329 */     if ((playerEx.PLAYER.func_70694_bm() != null) && ((playerEx.PLAYER.func_70694_bm().func_77973_b() instanceof IItemAttackHandler))) {
/* 330 */       ((IItemAttackHandler)playerEx.PLAYER.func_70694_bm().func_77973_b()).onAttacking(playerEx.PLAYER.func_70694_bm(), playerEx, event, attack);
/*     */     }
/*     */     
/* 333 */     event.ammount = attack.getDamage();
/*     */   }
/*     */   
/*     */ 
/*     */   public void onJump(PlayerEx playerEx, net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent event) {}
/*     */   
/*     */ 
/*     */   public void onJumpKey(PlayerEx playerEx) {}
/*     */   
/*     */ 
/*     */   public boolean isVisible()
/*     */   {
/* 345 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public abstract void initializeOn(PlayerEx paramPlayerEx);
/*     */   
/*     */ 
/*     */ 
/*     */   public void renderWorldLast(PlayerEx playerEx) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onTargetedByWither(PlayerEx playerEx, net.minecraft.entity.boss.EntityWither entity, int targetIndex) {}
/*     */   
/*     */ 
/*     */   public void onMouseEvent(PlayerEx playerEx, net.minecraftforge.client.event.MouseEvent event) {}
/*     */   
/*     */ 
/*     */   public void onKeyInputEvent(PlayerEx playerEx, net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent event) {}
/*     */   
/*     */ 
/*     */   public void onMouseEventPost(PlayerEx playerEx, InputEvent.MouseInputEvent event) {}
/*     */   
/*     */ 
/*     */   public void onEntityItemPickup(PlayerEx playerEx, EntityItemPickupEvent event) {}
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderScreenOverlays(PlayerEx playerEx, RenderGameOverlayEvent.Pre event) {}
/*     */   
/*     */ 
/*     */   public void onMountEntity(PlayerEx playerEx, net.minecraftforge.event.entity.EntityMountEvent event) {}
/*     */   
/*     */ 
/*     */   public void onHarvestDrops(PlayerEx playerEx, BlockEvent.HarvestDropsEvent event)
/*     */   {
/* 382 */     playerEx.onWorshipHarvest(event.world, event.pos, event.state, event.drops);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/PlayerForm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */