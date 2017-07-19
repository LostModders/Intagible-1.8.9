/*     */ package emoniph.intangible.client;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.ILearning;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.ISpell;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import emoniph.intangible.player.PlayerTempCache.RadialMenuData;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.spells.ModSpells.SpellEntry;
/*     */ import emoniph.intangible.spells.SpellIcon;
/*     */ import emoniph.intangible.spells.Spelling;
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
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class SpellScreen extends net.minecraft.client.gui.Gui
/*     */ {
/*  37 */   private ResourceLocation[] castingStyleIcons = { new ResourceLocation("intangible", "textures/gui/radial_mid.png"), new ResourceLocation("intangible", "textures/gui/radial_out.png") };
/*     */   
/*     */ 
/*     */ 
/*     */   public void drawScreen(ScaledResolution resolution, float partialTicks)
/*     */   {
/*  43 */     Minecraft mc = Minecraft.func_71410_x();
/*  44 */     EntityPlayerSP player = mc.field_71439_g;
/*  45 */     PlayerEx playerEx = PlayerEx.get(player);
/*  46 */     if (playerEx.hasReadySpell()) {
/*  47 */       return;
/*     */     }
/*     */     
/*  50 */     PlayerTempCache.RadialMenuData menu = playerEx.CACHE.getRadialMenuData();
/*  51 */     if (menu == null) {
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     GlStateManager.func_179094_E();
/*  56 */     GlStateManager.func_179147_l();
/*  57 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  58 */     GlStateManager.func_179112_b(770, 771);
/*  59 */     GlStateManager.func_179092_a(516, 0.001F);
/*     */     
/*  61 */     TextureManager textureMgr = mc.func_110434_K();
/*     */     
/*  63 */     float dy = menu.getPitchDiff(player, partialTicks);
/*  64 */     float dx = menu.getYawDiff(player, partialTicks);
/*     */     
/*  66 */     GlStateManager.func_179137_b(resolution.func_78326_a() * 0.5D + dx, resolution.func_78328_b() * 0.5D + dy, -101.0D);
/*     */     
/*  68 */     float rotation = (float)(player.field_70170_p.func_82737_E() * 10L % 360L);
/*  69 */     double wobble = Math.sin(player.field_70170_p.func_82737_E() / 1.5D);
/*     */     
/*  71 */     double scale = 1.0D + wobble * 0.05D;
/*  72 */     double invScale = 1.0D / scale;
/*     */     
/*  74 */     for (ModSpells.SpellEntry spellEntry : Get.spells()) {
/*  75 */       if (spellEntry.canPlayerCast(player))
/*     */       {
/*     */ 
/*  78 */         ISpell spell = spellEntry.getSpell();
/*  79 */         SpellIcon icon = playerEx.getSpellIconFor(spell);
/*  80 */         boolean isKnown = spellEntry.getRequiredKnowledge().containedBy(playerEx.getLearning());
/*  81 */         boolean isTop = icon == playerEx.getLastSpellIcon();
/*  82 */         if (isTop) {
/*  83 */           GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
/*     */         }
/*     */         
/*  86 */         float x = -dx;
/*  87 */         float y = -dy;
/*     */         
/*  89 */         float spellX = icon.getX();
/*  90 */         float spellY = icon.getY();
/*  91 */         int spellW = 16;
/*  92 */         int spellH = 16;
/*     */         
/*  94 */         textureMgr.func_110577_a(this.castingStyleIcons[spell.getCastingStyle(player, true).ordinal()]);
/*  95 */         if ((icon.contains(x, y)) && ((isTop) || (playerEx.getLastSpellIcon() == null)))
/*     */         {
/*  97 */           GlStateManager.func_179109_b(spellX + 8.0F, spellY + 8.0F, 0.0F);
/*  98 */           GlStateManager.func_179114_b(rotation, 0.0F, 0.0F, 1.0F);
/*  99 */           GlStateManager.func_179109_b(-8.0F, -8.0F, 0.0F);
/*     */           
/* 101 */           func_146110_a(0, 0, 0.0F, 0.0F, spellW, spellH, spellW, spellH);
/*     */           
/* 103 */           GlStateManager.func_179109_b(8.0F, 8.0F, 0.0F);
/* 104 */           GlStateManager.func_179114_b(-rotation, 0.0F, 0.0F, 1.0F);
/* 105 */           GlStateManager.func_179109_b(-spellX - 8.0F, -spellY - 8.0F, 0.0F);
/*     */           
/* 107 */           FontRenderer font = mc.func_175598_ae().func_78716_a();
/* 108 */           List<String> list = new ArrayList();
/* 109 */           String text; if (isKnown) {
/* 110 */             text = TextUtil.parse(String.format("[yellow]%s[/]", new Object[] { icon.getDisplayName() }));
/*     */             
/*     */ 
/* 113 */             list.add(text);
/*     */             
/* 115 */             list.addAll(java.util.Arrays.asList(icon.getDisplayText().split("\\n")));
/* 116 */             list.add("");
/*     */             
/* 118 */             List<String> maintainList = new ArrayList();
/*     */             
/* 120 */             Spelling castingCost = spellEntry.getCastingCost();
/* 121 */             ISoulSet maintainCost = spell.getMaintainCost();
/*     */             
/* 123 */             int items = 0;
/* 124 */             String castFormat = StatCollector.func_74838_a("spell.intangible:castingcost.item");
/* 125 */             String maintainFormat = StatCollector.func_74838_a("spell.intangible:maintaincost.item");
/*     */             
/* 127 */             for (SoulType soulType : SoulType.values()) {
/* 128 */               int costQuantity = castingCost.getSouls().quantityOf(soulType);
/* 129 */               int maintainQuantity = maintainCost.quantityOf(soulType);
/* 130 */               if ((costQuantity > 0) || (maintainQuantity > 0)) {
/* 131 */                 String name = EnumSoulType.fromSoulType(soulType).getLocalizedName();
/* 132 */                 boolean castable = playerEx.getCurrentSouls().quantityOf(soulType) >= costQuantity + maintainQuantity;
/* 133 */                 if (costQuantity > 0) {
/* 134 */                   items++; if (items == 1) {
/* 135 */                     list.add(TextUtil.parse(StatCollector.func_74838_a("spell.intangible:castingcost.title")));
/*     */                   }
/* 137 */                   String itemText = String.format(castFormat, new Object[] { Integer.valueOf(costQuantity), name, Float.valueOf(castingCost.getTicks() * 0.05F) });
/* 138 */                   if (castable) {
/* 139 */                     list.add(TextUtil.parse(itemText));
/*     */                   } else {
/* 141 */                     list.add(TextUtil.parse("[darkgray][i]" + TextUtil.parse(itemText) + "[/][/]"));
/*     */                   }
/*     */                 }
/*     */                 
/* 145 */                 if (maintainQuantity > 0) {
/* 146 */                   String itemText = String.format(maintainFormat, new Object[] { Integer.valueOf(maintainQuantity), name });
/* 147 */                   if (castable) {
/* 148 */                     maintainList.add(TextUtil.parse(itemText));
/*     */                   } else {
/* 150 */                     maintainList.add(TextUtil.parse("[darkgray][i]" + itemText + "[/][/]"));
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */             
/* 156 */             if (maintainList.size() > 0) {
/* 157 */               list.add(TextUtil.parse(StatCollector.func_74838_a("spell.intangible:maintaincost.title")));
/* 158 */               list.addAll(maintainList);
/*     */             }
/*     */           } else {
/* 161 */             list.add(TextUtil.parse(StatCollector.func_74838_a("spell.intangible:requiredknowledge.title")));
/* 162 */             for (IKnol knol : spellEntry.getRequiredKnowledge()) {
/* 163 */               if (playerEx.isKnowledgeLearnt(new IKnol[] { knol })) {
/* 164 */                 list.add(TextUtil.parse(StatCollector.func_74838_a("knol." + knol.getId())));
/* 165 */               } else if (player.field_71075_bZ.field_75098_d) {
/* 166 */                 list.add(TextUtil.parse("[gray][i]" + StatCollector.func_74838_a(new StringBuilder().append("knol.").append(knol.getId()).toString()) + "[/][/]"));
/*     */               } else {
/* 168 */                 list.add(TextUtil.parse("[gray][i]???[/][/]"));
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 173 */           GlStateManager.func_179109_b(0.0F, 0.0F, 1.0F);
/* 174 */           drawHoveringText(list, (int)spellX, (int)(spellY + spellH + 20.0F), font, resolution);
/* 175 */           GlStateManager.func_179109_b(0.0F, 0.0F, -1.0F);
/* 176 */         } else if (spellEntry.isActive(player)) {
/* 177 */           GlStateManager.func_179109_b(spellX + 8.0F, spellY + 8.0F, 0.0F);
/* 178 */           GlStateManager.func_179139_a(scale, scale, scale);
/* 179 */           GlStateManager.func_179109_b(-8.0F, -8.0F, 0.0F);
/* 180 */           RenderUtil.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, spellW, spellH, spellW, spellH);
/* 181 */           GlStateManager.func_179109_b(8.0F, 8.0F, 0.0F);
/* 182 */           GlStateManager.func_179139_a(invScale, invScale, invScale);
/* 183 */           GlStateManager.func_179109_b(-spellX - 8.0F, -spellY - 8.0F, 0.0F);
/*     */         }
/*     */         else {
/* 186 */           RenderUtil.drawModalRectWithCustomSizedTexture(spellX, spellY, 0.0F, 0.0F, spellW, spellH, spellW, spellH);
/*     */         }
/*     */         
/* 189 */         GlStateManager.func_179147_l();
/*     */         
/* 191 */         if (isKnown) {
/* 192 */           icon.bindTexture();
/* 193 */           RenderUtil.drawModalRectWithCustomSizedTexture(spellX + 4.0F, spellY + 4.0F, 0.0F, 0.0F, 8, 8, 8.0F, 8.0F);
/*     */           
/* 195 */           int key = playerEx.getShortcutKey(spell);
/* 196 */           if (key != -1) {
/* 197 */             FontRenderer font = mc.func_175598_ae().func_78716_a();
/* 198 */             String text = Integer.toString(key + 1);
/* 199 */             int w = font.func_78256_a(text);
/* 200 */             font.func_175065_a(text, spellX + 18.0F - w, spellY + 18.0F - font.field_78288_b, -1, true);
/*     */           }
/*     */         } else {
/* 203 */           FontRenderer font = mc.func_175598_ae().func_78716_a();
/* 204 */           String text = "?";
/* 205 */           int w = font.func_78256_a(text);
/* 206 */           font.func_175065_a(text, spellX + 8.0F - w * 0.5F, spellY + 9.0F - font.field_78288_b * 0.5F, -1, true);
/*     */         }
/*     */         
/* 209 */         if (isTop) {
/* 210 */           GlStateManager.func_179109_b(0.0F, 0.0F, -1.0F);
/*     */         }
/*     */       }
/*     */     }
/* 214 */     GlStateManager.func_179084_k();
/* 215 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   protected void drawHoveringText(List textLines, int x, int y, FontRenderer font, ScaledResolution resolution) {
/* 219 */     if (!textLines.isEmpty()) {
/* 220 */       GlStateManager.func_179101_C();
/*     */       
/*     */ 
/*     */ 
/* 224 */       int k = 0;
/* 225 */       Iterator iterator = textLines.iterator();
/*     */       
/* 227 */       while (iterator.hasNext()) {
/* 228 */         String s = (String)iterator.next();
/* 229 */         int l = font.func_78256_a(s);
/*     */         
/* 231 */         if (l > k) {
/* 232 */           k = l;
/*     */         }
/*     */       }
/*     */       
/* 236 */       int j2 = x + 12;
/* 237 */       int k2 = y - 12;
/* 238 */       int i1 = 8;
/*     */       
/* 240 */       if (textLines.size() > 1) {
/* 241 */         i1 += 2 + (textLines.size() - 1) * 10;
/*     */       }
/*     */       
/* 244 */       if (j2 + k > resolution.func_78326_a()) {
/* 245 */         j2 -= 28 + k;
/*     */       }
/*     */       
/* 248 */       if (k2 + i1 + 6 > resolution.func_78328_b()) {
/* 249 */         k2 = resolution.func_78328_b() - i1 - 6;
/*     */       }
/*     */       
/* 252 */       this.field_73735_i = 0.0F;
/* 253 */       int j1 = -267386864;
/* 254 */       func_73733_a(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1);
/* 255 */       func_73733_a(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1);
/* 256 */       func_73733_a(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1);
/* 257 */       func_73733_a(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1);
/* 258 */       func_73733_a(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1);
/* 259 */       int k1 = 1347420415;
/* 260 */       int l1 = (k1 & 0xFEFEFE) >> 1 | k1 & 0xFF000000;
/* 261 */       func_73733_a(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1);
/* 262 */       func_73733_a(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1);
/* 263 */       func_73733_a(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1);
/* 264 */       func_73733_a(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1);
/*     */       
/* 266 */       for (int i2 = 0; i2 < textLines.size(); i2++) {
/* 267 */         String s1 = (String)textLines.get(i2);
/* 268 */         font.func_175063_a(s1, j2, k2, -1);
/*     */         
/* 270 */         if (i2 == 0) {
/* 271 */           k2 += 2;
/*     */         }
/*     */         
/* 274 */         k2 += 10;
/*     */       }
/*     */       
/* 277 */       this.field_73735_i = 0.0F;
/*     */       
/*     */ 
/*     */ 
/* 281 */       GlStateManager.func_179091_B();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/SpellScreen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */