/*     */ package emoniph.intangible.client;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.client.baked.ModelRod;
/*     */ import emoniph.intangible.client.baked.ModelSpear;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerForm;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.client.event.ModelBakeEvent;
/*     */ import net.minecraftforge.client.event.MouseEvent;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent.Post;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent.Pre;
/*     */ import net.minecraftforge.client.model.IFlexibleBakedModel;
/*     */ import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
/*     */ import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class EventHandlers
/*     */ {
/*     */   @SubscribeEvent
/*     */   public void onModelBakeEvent(ModelBakeEvent event)
/*     */   {
/*  30 */     Object object = event.modelRegistry.func_82594_a(ModelRod.RESOURCE_LOCATION);
/*  31 */     if ((object instanceof IFlexibleBakedModel)) {
/*  32 */       IFlexibleBakedModel existingModel = (IFlexibleBakedModel)object;
/*  33 */       ModelRod customModel = new ModelRod(existingModel);
/*  34 */       event.modelRegistry.func_82595_a(ModelRod.RESOURCE_LOCATION, customModel);
/*     */     }
/*     */     
/*  37 */     object = event.modelRegistry.func_82594_a(ModelSpear.RESOURCE_LOCATION);
/*  38 */     if ((object instanceof IFlexibleBakedModel)) {
/*  39 */       IFlexibleBakedModel existingModel = (IFlexibleBakedModel)object;
/*  40 */       ModelSpear customModel = new ModelSpear(existingModel);
/*  41 */       event.modelRegistry.func_82595_a(ModelSpear.RESOURCE_LOCATION, customModel);
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderWorldLast(net.minecraftforge.client.event.RenderWorldLastEvent event) {
/*  47 */     Minecraft mc = Minecraft.func_71410_x();
/*  48 */     EntityPlayer player = mc.field_71439_g;
/*  49 */     if (player != null) {
/*  50 */       PlayerEx playerEx = PlayerEx.get(player);
/*  51 */       PlayerForm form = playerEx.getPlayerForm();
/*  52 */       form.renderWorldLast(playerEx);
/*     */     }
/*     */     
/*  55 */     emoniph.intangible.client.particle.ParticleRenderQueue.render();
/*  56 */     emoniph.intangible.client.renderer.RenderKnowledgeGem.render(event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderTick(net.minecraftforge.fml.common.gameevent.TickEvent.RenderTickEvent event) {
/*  61 */     Minecraft mc = Minecraft.func_71410_x();
/*  62 */     EntityPlayer player = mc.field_71439_g;
/*  63 */     if (player != null) {
/*  64 */       PlayerEx playerEx = PlayerEx.get(player);
/*  65 */       PlayerForm form = playerEx.getPlayerForm();
/*     */       
/*  67 */       if (event.phase == net.minecraftforge.fml.common.gameevent.TickEvent.Phase.START) {
/*  68 */         form.renderTickStart(playerEx);
/*     */       } else {
/*  70 */         form.renderTickEnd(playerEx);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onClientTick(TickEvent.ClientTickEvent event) {
/*  77 */     if (event.side == net.minecraftforge.fml.relauncher.Side.CLIENT) {
/*  78 */       Minecraft mc = Minecraft.func_71410_x();
/*  79 */       EntityPlayer player = mc.field_71439_g;
/*     */       PlayerEx playerEx;
/*  81 */       if (event.phase == net.minecraftforge.fml.common.gameevent.TickEvent.Phase.START) {
/*  82 */         Get.deities().clientTick(mc.field_71441_e);
/*  83 */         if (player != null) {
/*  84 */           playerEx = PlayerEx.get(player);
/*  85 */           if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/*  86 */             for (emoniph.intangible.api.IPassiveEffect effect : playerEx.getActiveEffects()) {
/*  87 */               effect.onPreClientTick(player, playerEx);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  93 */       if (player != null) {
/*  94 */         KeyboardHandler.INSTANCE.onTick(mc, player, event.phase);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onMouseEventPre(MouseEvent event)
/*     */   {
/* 102 */     Minecraft mc = Minecraft.func_71410_x();
/* 103 */     EntityPlayer player = mc.field_71439_g;
/* 104 */     if (player != null) {
/* 105 */       PlayerEx playerEx = PlayerEx.get(player);
/* 106 */       updateMouseOver(mc, playerEx, 1.0F);
/* 107 */       if (event.dwheel != 0) {
/* 108 */         ItemStack stack = player.func_71011_bu();
/* 109 */         if ((stack != null) && (stack.func_77973_b() == Get.items().FOCI)) {
/* 110 */           event.setCanceled(true);
/*     */         }
/*     */       }
/* 113 */       if (!event.isCanceled()) {
/* 114 */         playerEx.getPlayerForm().onMouseEvent(playerEx, event);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateMouseOver(Minecraft mc, PlayerEx player, float a) {
/* 120 */     if (((mc.field_71476_x != null) && (mc.field_71476_x.field_72308_g != null)) || (mc.field_71439_g.func_70093_af())) {
/* 121 */       return;
/*     */     }
/*     */     
/* 124 */     if (player.getActiveEffects().contains(Get.effects().PLACE)) {
/* 125 */       net.minecraft.entity.Entity entity = mc.func_175606_aa();
/* 126 */       if ((entity != null) && (mc.field_71441_e != null)) {
/* 127 */         mc.field_147125_j = null;
/* 128 */         double d0 = 20.0D;
/* 129 */         mc.field_71476_x = entity.func_174822_a(d0, a);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onMouseEventPost(net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent event) {
/* 136 */     Minecraft mc = Minecraft.func_71410_x();
/* 137 */     EntityPlayer player = mc.field_71439_g;
/* 138 */     if (player != null) {
/* 139 */       PlayerEx playerEx = PlayerEx.get(player);
/* 140 */       if (!event.isCanceled()) {
/* 141 */         playerEx.getPlayerForm().onMouseEventPost(playerEx, event);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onKeyInputEvent(net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent event) {
/* 148 */     Minecraft mc = Minecraft.func_71410_x();
/* 149 */     EntityPlayer player = mc.field_71439_g;
/* 150 */     if (player != null) {
/* 151 */       ItemStack stack = player.func_71011_bu();
/*     */       
/* 153 */       if ((stack != null) && (stack.func_77973_b() == Get.items().FOCI)) {
/* 154 */         int i = 0; for (int count = Minecraft.func_71410_x().field_71474_y.field_151456_ac.length; i < count; i++) {
/* 155 */           if (Minecraft.func_71410_x().field_71474_y.field_151456_ac[i].func_151468_f()) {
/* 156 */             Minecraft.func_71410_x().field_71474_y.field_151456_ac[i].func_74505_d();
/*     */           }
/*     */         }
/*     */         
/* 160 */         if (Minecraft.func_71410_x().field_71474_y.field_151445_Q.func_151468_f()) {
/* 161 */           Minecraft.func_71410_x().field_71474_y.field_151445_Q.func_74505_d();
/*     */         }
/*     */         
/* 164 */         if (Minecraft.func_71410_x().field_71474_y.field_74316_C.func_151468_f()) {
/* 165 */           Minecraft.func_71410_x().field_71474_y.field_74316_C.func_74505_d();
/*     */         }
/*     */       }
/*     */       
/* 169 */       PlayerEx playerEx = PlayerEx.get(player);
/* 170 */       playerEx.getPlayerForm().onKeyInputEvent(playerEx, event);
/*     */     }
/*     */   }
/*     */   
/* 174 */   private SoulHudRenderer soulHudRenderer = new SoulHudRenderer(Minecraft.func_71410_x());
/* 175 */   private MessageHudRenderer messageHudRenderer = new MessageHudRenderer(Minecraft.func_71410_x());
/* 176 */   private SpellScreen spellScreen = new SpellScreen();
/* 177 */   private PriestScreen priestScreen = new PriestScreen();
/* 178 */   private ShellRenderer shellRenderer = new ShellRenderer(Minecraft.func_71410_x());
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderGameOverlay(RenderGameOverlayEvent.Pre event) {
/* 182 */     net.minecraft.client.entity.EntityPlayerSP player = Minecraft.func_71410_x().field_71439_g;
/*     */     
/* 184 */     if (player == null) {
/* 185 */       return;
/*     */     }
/*     */     
/* 188 */     PlayerEx playerEx = PlayerEx.get(player);
/*     */     
/* 190 */     switch (event.type) {
/*     */     case TEXT: 
/* 192 */       this.soulHudRenderer.renderHud(player, event.resolution.func_78326_a(), event.resolution.func_78328_b());
/* 193 */       this.messageHudRenderer.renderHud(player, event.resolution.func_78326_a(), event.resolution.func_78328_b());
/*     */       
/* 195 */       ItemStack stack = player.func_71011_bu();
/* 196 */       if ((stack != null) && (stack.func_77973_b() == Get.items().FOCI)) {
/* 197 */         this.spellScreen.drawScreen(event.resolution, event.partialTicks);
/*     */       }
/*     */       
/* 200 */       if ((stack != null) && (stack.func_77973_b() == Get.items().ROD)) {
/* 201 */         this.priestScreen.drawScreen(event.resolution, event.partialTicks);
/*     */       }
/*     */       
/* 204 */       playerEx.getPlayerForm().renderScreenOverlays(playerEx, event);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SubscribeEvent
/*     */   public void onRenderGameOverlay(net.minecraftforge.client.event.RenderGameOverlayEvent.Post event) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SubscribeEvent
/*     */   public void onLivingJump(net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent event) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SubscribeEvent
/*     */   public void onPlayerLoggedIn(net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent event)
/*     */   {
/* 227 */     ModelRod.resetCache();
/* 228 */     ModelSpear.resetCache();
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerPreRender(RenderLivingEvent.Pre event)
/*     */   {
/* 234 */     EntityPlayer ourPlayer = Minecraft.func_71410_x().field_71439_g;
/* 235 */     PlayerEx ourPlayerEx = PlayerEx.get(ourPlayer);
/*     */     
/* 237 */     if ((event.entity instanceof EntityPlayer)) {
/* 238 */       PlayerEx playerEx = event.entity == ourPlayer ? ourPlayerEx : PlayerEx.get((EntityPlayer)event.entity);
/* 239 */       playerEx.getPlayerForm().onRenderPlayerStart(playerEx, event);
/*     */     }
/*     */     
/* 242 */     PlayerForm form = ourPlayerEx.getPlayerForm();
/* 243 */     form.onRenderLivingBaseStart(ourPlayerEx, event.entity, event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onPlayerPostRender(RenderLivingEvent.Post event) {
/* 248 */     EntityPlayer ourPlayer = Minecraft.func_71410_x().field_71439_g;
/* 249 */     PlayerEx ourPlayerEx = PlayerEx.get(ourPlayer);
/*     */     
/* 251 */     if ((event.entity instanceof EntityPlayer)) {
/* 252 */       PlayerEx playerEx = event.entity == ourPlayer ? ourPlayerEx : PlayerEx.get((EntityPlayer)event.entity);
/* 253 */       playerEx.getPlayerForm().onRenderPlayerEnd(playerEx, event);
/*     */     }
/*     */     
/* 256 */     PlayerForm form = ourPlayerEx.getPlayerForm();
/* 257 */     form.onRenderLivingBaseEnd(ourPlayerEx, event.entity, event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderHand(net.minecraftforge.client.event.RenderHandEvent event) {
/* 262 */     Minecraft mc = Minecraft.func_71410_x();
/* 263 */     EntityPlayer player = mc.field_71439_g;
/* 264 */     PlayerEx playerEx = PlayerEx.get(player);
/* 265 */     PlayerForm form = playerEx.getPlayerForm();
/* 266 */     form.onRenderHand(playerEx, event);
/*     */   }
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onRenderNameplate(net.minecraftforge.client.event.RenderLivingEvent.Specials.Pre event) {
/* 271 */     if ((event.entity instanceof EntityPlayer)) {
/* 272 */       EntityPlayer player = (EntityPlayer)event.entity;
/* 273 */       PlayerEx playerEx = PlayerEx.get(player);
/* 274 */       PlayerForm form = playerEx.getPlayerForm();
/* 275 */       form.renderNameplate(playerEx, event);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/EventHandlers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */