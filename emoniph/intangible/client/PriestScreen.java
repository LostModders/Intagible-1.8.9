/*     */ package emoniph.intangible.client;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.deity.HeadSpec;
/*     */ import emoniph.intangible.deity.IPlayerWorship;
/*     */ import emoniph.intangible.deity.ModPriestSpells.PriestSpell;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import emoniph.intangible.player.PlayerTempCache.RadialMenuData;
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import emoniph.intangible.util.TextUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.ScaledResolution;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class PriestScreen extends net.minecraft.client.gui.Gui
/*     */ {
/*  28 */   private ResourceLocation ICON_BACK = new ResourceLocation("intangible:textures/gui/radial_priest.png");
/*  29 */   private ResourceLocation ICON_COOLDOWN = new ResourceLocation("intangible:textures/gui/radial_priest_cooldown.png");
/*     */   
/*     */   public void drawScreen(ScaledResolution resolution, float partialTicks)
/*     */   {
/*  33 */     Minecraft mc = Minecraft.func_71410_x();
/*  34 */     EntityPlayerSP player = mc.field_71439_g;
/*  35 */     PlayerEx playerEx = PlayerEx.get(player);
/*  36 */     java.util.UUID deityId = playerEx.getWorship().getDevoutDeityId(mc.field_71441_e);
/*  37 */     String deityName = "";
/*  38 */     long remainingWorship = 0L;
/*  39 */     if (deityId != null) {
/*  40 */       HeadSpec data = Get.deities().getClientDeityFor(mc.field_71441_e, deityId);
/*  41 */       if (data != null) {
/*  42 */         deityName = data.getName();
/*     */       }
/*  44 */       remainingWorship = playerEx.getWorship().getWorshipFor(player.field_70170_p, deityId);
/*     */     }
/*     */     
/*  47 */     PlayerTempCache.RadialMenuData menu = playerEx.CACHE.getPriestMenuData();
/*  48 */     if (menu == null) {
/*  49 */       return;
/*     */     }
/*     */     
/*  52 */     TextureManager textureMgr = mc.func_110434_K();
/*     */     
/*  54 */     GlStateManager.func_179094_E();
/*  55 */     GlStateManager.func_179147_l();
/*  56 */     GlStateManager.func_179112_b(770, 771);
/*  57 */     GlStateManager.func_179092_a(516, 0.001F);
/*  58 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */     
/*  60 */     float dy = menu.getPitchDiff(player, partialTicks);
/*  61 */     float dx = menu.getYawDiff(player, partialTicks);
/*     */     
/*  63 */     GlStateManager.func_179137_b(resolution.func_78326_a() * 0.5D + dx, resolution.func_78328_b() * 0.5D + dy, -101.0D);
/*     */     
/*  65 */     for (ModPriestSpells.PriestSpell spell : Get.priest()) {
/*  66 */       int remainingCooldown = playerEx.getRemainingCooldown(spell);
/*  67 */       boolean cooldownActive = remainingCooldown > 0;
/*     */       
/*  69 */       float x = -dx;
/*  70 */       float y = -dy;
/*     */       
/*  72 */       float spellX = spell.getX();
/*  73 */       float spellY = spell.getY();
/*  74 */       int spellW = 16;
/*  75 */       int spellH = 16;
/*     */       
/*  77 */       textureMgr.func_110577_a(this.ICON_BACK);
/*  78 */       if (spell.contains(x, y)) {
/*  79 */         if (!cooldownActive) {
/*  80 */           float rotation = (float)(player.field_70170_p.func_82737_E() * 10L % 360L);
/*  81 */           GlStateManager.func_179109_b(spellX + 8.0F, spellY + 8.0F, 0.0F);
/*  82 */           GlStateManager.func_179114_b(rotation, 0.0F, 0.0F, 1.0F);
/*     */           
/*  84 */           GlStateManager.func_179109_b(-8.0F, -8.0F, 0.0F);
/*  85 */           func_146110_a(0, 0, 0.0F, 0.0F, spellW, spellH, spellW, spellH);
/*  86 */           GlStateManager.func_179109_b(8.0F, 8.0F, 0.0F);
/*  87 */           GlStateManager.func_179114_b(-rotation, 0.0F, 0.0F, 1.0F);
/*  88 */           GlStateManager.func_179109_b(-spellX - 8.0F, -spellY - 8.0F, 0.0F);
/*     */         } else {
/*  90 */           GlStateManager.func_179109_b(spellX, spellY, 0.0F);
/*  91 */           func_146110_a(0, 0, 0.0F, 0.0F, spellW, spellH, spellW, spellH);
/*  92 */           GlStateManager.func_179109_b(-spellX, -spellY, 0.0F);
/*     */         }
/*     */         
/*  95 */         FontRenderer font = mc.func_175598_ae().func_78716_a();
/*  96 */         List<String> list = new ArrayList();
/*     */         
/*  98 */         String text = TextUtil.parse(String.format("[yellow]%s[/]", new Object[] { spell.getTranslatedTitle(deityName) }));
/*     */         
/* 100 */         list.add(text);
/* 101 */         list.addAll(java.util.Arrays.asList(TextUtil.parse(spell.getTranslatedText(deityName)).split("\\n")));
/* 102 */         list.add("");
/* 103 */         if (cooldownActive) {
/* 104 */           list.add(TextUtil.parse(String.format(StatCollector.func_74838_a("priest.intangible:cooldownactive"), new Object[] { Integer.valueOf(spell.getCooldown() / 20), Integer.valueOf(MathHelper.func_76123_f(remainingCooldown / 20.0F)) })));
/*     */         } else {
/* 106 */           list.add(TextUtil.parse(String.format(StatCollector.func_74838_a("priest.intangible:cooldown"), new Object[] { Integer.valueOf(spell.getCooldown() / 20) })));
/*     */         }
/* 108 */         if (spell.getWorshipCost() > 0) {
/* 109 */           list.add(TextUtil.parse(String.format(StatCollector.func_74838_a("priest.intangible:worship"), new Object[] { Integer.valueOf(spell.getWorshipCost()), Long.valueOf(remainingWorship) })));
/*     */         }
/*     */         
/* 112 */         GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
/* 113 */         drawHoveringText(list, (int)spellX, (int)(spellY + spellH + 20.0F), font, resolution);
/* 114 */         GlStateManager.func_179109_b(0.0F, 0.0F, -1.0F);
/*     */       } else {
/* 116 */         RenderUtil.drawModalRectWithCustomSizedTexture(spellX, spellY, 0.0F, 0.0F, spellW, spellH, spellW, spellH);
/*     */       }
/*     */       
/* 119 */       GlStateManager.func_179147_l();
/* 120 */       textureMgr.func_110577_a(spell.getImage());
/*     */       
/* 122 */       RenderUtil.drawModalRectWithCustomSizedTexture(spellX + 4.0F, spellY + 4.0F, 0.0F, 0.0F, 8, 8, 8.0F, 8.0F);
/*     */       
/* 124 */       if (cooldownActive) {
/* 125 */         double pct = remainingCooldown / spell.getCooldown();
/* 126 */         int h = MathHelper.func_76143_f(spellH * pct);
/* 127 */         textureMgr.func_110577_a(this.ICON_COOLDOWN);
/* 128 */         RenderUtil.drawModalRectWithCustomSizedTexture(spellX, spellY + (spellH - h), 0.0F, 0.0F, spellW, h, spellW, h);
/*     */       }
/*     */     }
/*     */     
/* 132 */     String worshipInfo = TextUtil.parse(String.format(StatCollector.func_74838_a("priest.intangible:worship.details"), new Object[] { deityName, Long.valueOf(remainingWorship) }));
/* 133 */     float worshipInfoWidth = mc.field_71466_p.func_78256_a(worshipInfo);
/*     */     
/* 135 */     mc.field_71466_p.func_175065_a(worshipInfo, -worshipInfoWidth / 2.0F, -50.0F, 16777215, false);
/*     */     
/* 137 */     GlStateManager.func_179084_k();
/*     */     
/* 139 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   protected void drawHoveringText(List textLines, int x, int y, FontRenderer font, ScaledResolution resolution) {
/* 143 */     if (!textLines.isEmpty()) {
/* 144 */       GlStateManager.func_179101_C();
/*     */       
/*     */ 
/*     */ 
/* 148 */       int k = 0;
/* 149 */       Iterator iterator = textLines.iterator();
/*     */       
/* 151 */       while (iterator.hasNext()) {
/* 152 */         String s = (String)iterator.next();
/* 153 */         int l = font.func_78256_a(s);
/*     */         
/* 155 */         if (l > k) {
/* 156 */           k = l;
/*     */         }
/*     */       }
/*     */       
/* 160 */       int j2 = x + 12;
/* 161 */       int k2 = y - 12;
/* 162 */       int i1 = 8;
/*     */       
/* 164 */       if (textLines.size() > 1) {
/* 165 */         i1 += 2 + (textLines.size() - 1) * 10;
/*     */       }
/*     */       
/* 168 */       if (j2 + k > resolution.func_78326_a()) {
/* 169 */         j2 -= 28 + k;
/*     */       }
/*     */       
/* 172 */       if (k2 + i1 + 6 > resolution.func_78328_b()) {
/* 173 */         k2 = resolution.func_78328_b() - i1 - 6;
/*     */       }
/*     */       
/* 176 */       this.field_73735_i = 0.0F;
/* 177 */       int j1 = -267386864;
/* 178 */       func_73733_a(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
/* 179 */       func_73733_a(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
/* 180 */       func_73733_a(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
/* 181 */       func_73733_a(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
/* 182 */       func_73733_a(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
/* 183 */       int k1 = 1347420415;
/* 184 */       int l1 = (k1 & 0xFEFEFE) >> 1 | k1 & 0xFF000000;
/* 185 */       func_73733_a(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
/* 186 */       func_73733_a(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
/* 187 */       func_73733_a(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
/* 188 */       func_73733_a(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);
/*     */       
/* 190 */       for (int i2 = 0; i2 < textLines.size(); i2++) {
/* 191 */         String s1 = (String)textLines.get(i2);
/* 192 */         font.func_175063_a(s1, j2, k2, -1);
/*     */         
/* 194 */         if (i2 == 0) {
/* 195 */           k2 += 2;
/*     */         }
/*     */         
/* 198 */         k2 += 10;
/*     */       }
/*     */       
/* 201 */       this.field_73735_i = 0.0F;
/*     */       
/*     */ 
/*     */ 
/* 205 */       GlStateManager.func_179091_B();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/PriestScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */