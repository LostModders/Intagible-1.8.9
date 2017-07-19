/*     */ package emoniph.intangible.client;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.config.Config;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.Gui;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class SoulHudRenderer extends Gui
/*     */ {
/*     */   private final Minecraft mc;
/*  24 */   private static final ResourceLocation REBELLION = new ResourceLocation("intangible", "textures/gui/rebellion.png");
/*  25 */   private static final ResourceLocation BAR_0 = new ResourceLocation("intangible", "textures/gui/bar_glyph0.png");
/*  26 */   private static final ResourceLocation BAR_1 = new ResourceLocation("intangible", "textures/gui/bar_glyph1.png");
/*  27 */   private static final ResourceLocation PREPARED_GLYPH = new ResourceLocation("intangible", "textures/gui/radial_out.png");
/*     */   
/*     */   public SoulHudRenderer(Minecraft minecraft) {
/*  30 */     this.mc = minecraft;
/*     */   }
/*     */   
/*  33 */   private static final ResourceLocation[] RADIAL_GLYPHS = { new ResourceLocation("intangible", "textures/gui/radial_glyph_0.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_1.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_2.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_3.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_4.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_5.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_6.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_7.png") };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void renderHud(EntityPlayerSP player, int screenWidth, int screenHeight)
/*     */   {
/*  45 */     PlayerEx playerEx = PlayerEx.get(player);
/*  46 */     if (!playerEx.hasSouls()) {
/*  47 */       return;
/*     */     }
/*     */     
/*  50 */     GlStateManager.func_179094_E();
/*     */     
/*  52 */     int TEXTURE_WIDTH = 4;
/*  53 */     int TEXTURE_HEIGHT = 8;
/*     */     
/*  55 */     int height = 98;
/*  56 */     boolean left = true;
/*     */     
/*  58 */     switch (Get.config().HUD_ANCHOR) {
/*     */     case TOP_LEFT: 
/*  60 */       GlStateManager.func_179109_b(Get.config().HUD_OFFSET_X, Get.config().HUD_OFFSET_Y, 0.0F);
/*  61 */       break;
/*     */     case BOTTOM_LEFT: 
/*  63 */       GlStateManager.func_179109_b(Get.config().HUD_OFFSET_X, screenHeight - Get.config().HUD_OFFSET_Y - height, 0.0F);
/*  64 */       break;
/*     */     case TOP_RIGHT: 
/*  66 */       left = false;
/*  67 */       GlStateManager.func_179109_b(screenWidth - Get.config().HUD_OFFSET_X, Get.config().HUD_OFFSET_Y, 0.0F);
/*  68 */       break;
/*     */     case BOTTOM_RIGHT: 
/*  70 */       left = false;
/*  71 */       GlStateManager.func_179109_b(screenWidth - Get.config().HUD_OFFSET_X, screenHeight - Get.config().HUD_OFFSET_Y - height, 0.0F);
/*     */     }
/*     */     
/*     */     
/*  75 */     GlStateManager.func_179147_l();
/*  76 */     GlStateManager.func_179112_b(770, 771);
/*     */     
/*  78 */     float rebellion = playerEx.getRebellionPct();
/*     */     
/*  80 */     if (rebellion > 0.0F) {
/*  81 */       int rebHeightMax = 72;
/*  82 */       int rebHeight = (int)(rebHeightMax * rebellion);
/*  83 */       this.mc.func_110434_K().func_110577_a(REBELLION);
/*  84 */       func_146110_a(left ? 0 : -8, rebHeightMax - rebHeight, 0.0F, rebHeightMax - rebHeight, 8, rebHeight, 8.0F, rebHeightMax);
/*     */     }
/*     */     
/*     */ 
/*  88 */     SoulSet currentSouls = playerEx.getCurrentSouls();
/*  89 */     ISoulSet busySouls = playerEx.getBusySouls();
/*  90 */     int soulY = 0;
/*  91 */     for (SoulType soulType : SoulType.values()) {
/*  92 */       this.mc.func_110434_K().func_110577_a(RADIAL_GLYPHS[soulY]);
/*     */       
/*  94 */       func_146110_a(left ? 0 : -8, soulY * 9, 0.0F, 0.0F, 8, 8, 8.0F, 8.0F);
/*  95 */       int souls = currentSouls.quantityOf(soulType);
/*  96 */       int busy = busySouls.quantityOf(soulType);
/*  97 */       if (souls >= 0) {
/*  98 */         this.mc.func_110434_K().func_110577_a(BAR_0);
/*  99 */         for (int blip = 0; 
/* 100 */             blip < souls; blip++) {
/* 101 */           int xDisplace = (blip + 1) * 5 + 4;
/* 102 */           int x = left ? xDisplace : -4 - xDisplace;
/* 103 */           func_146110_a(x, soulY * 9, 0.0F, 0.0F, 4, 8, 4.0F, 8.0F);
/*     */         }
/* 105 */         this.mc.func_110434_K().func_110577_a(BAR_1);
/* 106 */         for (; blip < souls + busy; blip++) {
/* 107 */           int xDisplace = (blip + 1) * 5 + 4;
/* 108 */           int x = left ? xDisplace : -4 - xDisplace;
/* 109 */           func_146110_a(x, soulY * 9, 0.0F, 0.0F, 4, 8, 4.0F, 8.0F);
/*     */         }
/* 111 */         soulY++;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 116 */     int currentY = soulY * 9;
/* 117 */     int x = 0;
/* 118 */     for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 119 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, playerEx.isCooldownActive(effect) ? 0.25F : 1.0F);
/* 120 */       this.mc.func_110434_K().func_110577_a(effect.getHudGlyph());
/* 121 */       func_146110_a(left ? x + 2 : -x - 2 - 4, currentY, 0.0F, 0.0F, 4, 4, 4.0F, 4.0F);
/* 122 */       x += 5;
/*     */     }
/*     */     
/*     */ 
/* 126 */     currentY += 10;
/* 127 */     if (playerEx.hasReadySpell()) {
/* 128 */       emoniph.intangible.api.ISpell spell = playerEx.getReadySpell();
/* 129 */       this.mc.func_110434_K().func_110577_a(PREPARED_GLYPH);
/* 130 */       func_146110_a(left ? 0 : -16, currentY, 0.0F, 0.0F, 16, 16, 16.0F, 16.0F);
/* 131 */       Get.spells().bindTextureFor(spell);
/* 132 */       func_146110_a(left ? 4 : -12, currentY + 4, 0.0F, 0.0F, 8, 8, 8.0F, 8.0F);
/*     */     }
/*     */     
/* 135 */     GlStateManager.func_179084_k();
/* 136 */     GlStateManager.func_179121_F();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/SoulHudRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */