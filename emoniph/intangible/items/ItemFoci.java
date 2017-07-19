/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import emoniph.intangible.player.PlayerTempCache.RadialMenuData;
/*     */ import emoniph.intangible.spells.ModSpells.PacketCastSpell;
/*     */ import emoniph.intangible.spells.ModSpells.SpellEntry;
/*     */ import emoniph.intangible.spells.SpellIcon;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemFoci extends net.minecraft.item.Item implements IItem, ICreativeSort
/*     */ {
/*     */   ItemFoci()
/*     */   {
/*  19 */     func_77625_d(1);
/*  20 */     func_77656_e(0);
/*     */   }
/*     */   
/*     */   public net.minecraft.item.EnumAction func_77661_b(ItemStack stack)
/*     */   {
/*  25 */     return net.minecraft.item.EnumAction.BLOCK;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack stack)
/*     */   {
/*  30 */     return 1000;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack stack, World worldIn, EntityPlayer playerIn)
/*     */   {
/*  35 */     PlayerEx playerEx = PlayerEx.get(playerIn);
/*  36 */     if ((!playerEx.hasReadySpell()) && (!playerIn.func_70093_af())) {
/*  37 */       playerEx.CACHE.pushRadialMenuData(new PlayerTempCache.RadialMenuData(playerIn));
/*     */     }
/*  39 */     playerIn.func_71008_a(stack, func_77626_a(stack));
/*  40 */     return stack;
/*     */   }
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer playerIn, int count)
/*     */   {
/*  45 */     PlayerEx playerEx = PlayerEx.get(playerIn);
/*  46 */     if (!playerEx.hasReadySpell()) {
/*  47 */       PlayerTempCache.RadialMenuData radialMenu = playerEx.CACHE.getRadialMenuData();
/*     */       
/*  49 */       if (radialMenu == null) {
/*  50 */         return;
/*     */       }
/*     */       
/*  53 */       if (Get.effects().isActiveFor(Get.effects().INCORPOREAL, playerIn)) {
/*  54 */         playerIn.func_71041_bz();
/*  55 */         return;
/*     */       }
/*     */       
/*  58 */       if (playerIn.func_70093_af()) {
/*  59 */         radialMenu.reset(playerIn);
/*  60 */         return;
/*     */       }
/*     */       
/*  63 */       if (playerIn.field_70170_p.field_72995_K) {
/*  64 */         float partialTicks = Intangible.PROXY.getPartialTicks();
/*  65 */         float dy = -radialMenu.getPitchDiff(playerIn, partialTicks);
/*  66 */         float dx = -radialMenu.getYawDiff(playerIn, partialTicks);
/*     */         SpellIcon icon;
/*  68 */         if (emoniph.intangible.client.KeyboardHandler.INSTANCE.INVENTORY.isDown())
/*     */         {
/*  70 */           icon = playerEx.getLastSpellIcon();
/*  71 */           if (icon != null) {
/*  72 */             icon.setX((int)dx - 8);
/*  73 */             icon.setY((int)dy - 8);
/*     */           } else {
/*  75 */             for (ModSpells.SpellEntry spell : Get.spells()) {
/*  76 */               if (spell.canPlayerCast(playerIn)) {
/*  77 */                 icon = playerEx.getSpellIconFor(spell.getSpell());
/*  78 */                 if ((icon != null) && (icon.contains(dx, dy))) {
/*  79 */                   icon.setX((int)dx - 8);
/*  80 */                   icon.setY((int)dy - 8);
/*  81 */                   playerEx.setLastSpellIcon(icon);
/*  82 */                   break;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         } else {
/*  88 */           playerEx.setLastSpellIcon(null);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void checkShortcut(EntityPlayer player, int key) {
/*  95 */     ItemStack active = player.func_71011_bu();
/*  96 */     if ((active != null) && (active.func_77973_b() == this)) {
/*  97 */       PlayerEx playerEx = PlayerEx.get(player);
/*  98 */       PlayerTempCache.RadialMenuData radialMenu = playerEx.CACHE.getRadialMenuData();
/*     */       
/* 100 */       if (radialMenu == null) {
/* 101 */         return;
/*     */       }
/*     */       
/* 104 */       float partialTicks = Intangible.PROXY.getPartialTicks();
/* 105 */       float dy = -radialMenu.getPitchDiff(player, partialTicks);
/* 106 */       float dx = -radialMenu.getYawDiff(player, partialTicks);
/*     */       
/* 108 */       boolean set = false;
/* 109 */       for (ModSpells.SpellEntry spell : Get.spells()) {
/* 110 */         if (spell.canPlayerCast(player)) {
/* 111 */           SpellIcon icon = playerEx.getSpellIconFor(spell.getSpell());
/* 112 */           if ((icon != null) && (icon.contains(dx, dy))) {
/* 113 */             playerEx.setSpellShortcut(key, spell.getSpell());
/* 114 */             set = true;
/* 115 */             break;
/*     */           }
/*     */         }
/*     */       }
/* 119 */       if (!set) {
/* 120 */         emoniph.intangible.api.ISpell shortcut = playerEx.getSpellShortcut(key);
/* 121 */         if (shortcut != null) {
/* 122 */           Get.pipeline().sendToServer(new ModSpells.PacketCastSpell(shortcut, true));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77615_a(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
/*     */   {
/* 130 */     PlayerEx playerEx = PlayerEx.get(playerIn);
/* 131 */     PlayerTempCache.RadialMenuData radialMenu = playerEx.CACHE.getRadialMenuData();
/* 132 */     playerEx.CACHE.clearRadialMenuData();
/*     */     float dy;
/* 134 */     float dx; if (playerEx.hasReadySpell()) {
/* 135 */       if (playerEx.isServerWorld()) {
/* 136 */         if (radialMenu == null) {
/* 137 */           playerEx.triggerReadySpell(true);
/*     */         }
/*     */       }
/* 140 */       else if (radialMenu == null) {
/* 141 */         playerIn.func_71038_i();
/*     */       }
/*     */       
/*     */     }
/* 145 */     else if ((radialMenu != null) && (playerEx.isClientWorld())) {
/* 146 */       dy = radialMenu.getPitchDiff(playerIn);
/* 147 */       dx = radialMenu.getYawDiff(playerIn);
/* 148 */       for (ModSpells.SpellEntry spell : Get.spells()) {
/* 149 */         if (spell.canPlayerCast(playerIn)) {
/* 150 */           SpellIcon icon = playerEx.getSpellIconFor(spell.getSpell());
/* 151 */           if ((icon != null) && (icon.contains(-dx, -dy))) {
/* 152 */             Get.pipeline().sendToServer(new ModSpells.PacketCastSpell(spell.getSpell(), false));
/* 153 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 163 */     return 2;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemFoci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */