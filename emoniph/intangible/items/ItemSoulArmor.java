/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.client.models.ModelSoulArmor;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.entity.EntityClone;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.EnumArmorSlot;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ItemSoulArmor extends ItemArmor implements IItem, emoniph.intangible.api.ISoulArmor, net.minecraftforge.common.ISpecialArmor, emoniph.intangible.recipes.RecipesDyeableItem.IDyeable, ICreativeSort
/*     */ {
/*     */   private EnumArmorSlot armorSlot;
/*     */   
/*     */   ItemSoulArmor(EnumArmorSlot armorSlot)
/*     */   {
/*  39 */     super(Get.armorBoneMaterial(), 0, armorSlot.armorType);
/*  40 */     this.armorSlot = armorSlot;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/*  46 */     return EnumRarity.RARE;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean advancedTooltips)
/*     */   {
/*  52 */     SoulSet souls = getCapacity(stack);
/*  53 */     for (SoulType soul : souls) {
/*  54 */       list.add(emoniph.intangible.util.TextUtil.parse(EnumSoulType.fromSoulType(soul).getLocalizedName()));
/*     */     }
/*     */   }
/*     */   
/*  58 */   private static final ISpecialArmor.ArmorProperties[] EMPTY_ARMOR = ;
/*     */   
/*     */   private static ISpecialArmor.ArmorProperties[] createEmptyArmor() {
/*  61 */     ISpecialArmor.ArmorProperties[] props = new ISpecialArmor.ArmorProperties[EnumArmorSlot.values().length];
/*  62 */     for (EnumArmorSlot slot : EnumArmorSlot.values()) {
/*  63 */       props[slot.getArmorSlot()] = new ISpecialArmor.ArmorProperties(0, 0.0D, 0);
/*  64 */       props[slot.getArmorSlot()].Slot = slot.getArmorSlot();
/*     */     }
/*     */     
/*  67 */     return props;
/*     */   }
/*     */   
/*     */   public static boolean isUnblockableSource(DamageSource source) {
/*  71 */     if ((source == null) || (!source.func_76363_c())) {
/*  72 */       return false;
/*     */     }
/*     */     
/*  75 */     if ((source.func_82725_o()) || ((source instanceof net.minecraft.util.EntityDamageSource)) || ((source instanceof net.minecraft.util.EntityDamageSourceIndirect)))
/*     */     {
/*     */ 
/*  78 */       return false;
/*     */     }
/*     */     
/*  81 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isBookEnchantable(ItemStack stack, ItemStack book)
/*     */   {
/*  86 */     return super.isBookEnchantable(stack, book);
/*     */   }
/*     */   
/*     */   public int getItemEnchantability(ItemStack stack)
/*     */   {
/*  91 */     return super.getItemEnchantability(stack);
/*     */   }
/*     */   
/*     */   public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase entity, ItemStack armor, DamageSource source, double damage, int slot)
/*     */   {
/*  96 */     if (isBroken(armor)) {
/*  97 */       return EMPTY_ARMOR[slot];
/*     */     }
/*     */     
/* 100 */     double reduction = this.field_77879_b;
/*     */     
/* 102 */     if (isUnblockableSource(source)) {
/* 103 */       reduction = 0.0D;
/*     */     }
/*     */     
/* 106 */     ISpecialArmor.ArmorProperties props = new ISpecialArmor.ArmorProperties(0, reduction / 25.0D, Math.max(armor.func_77958_k() + 1 - armor.func_77952_i(), 1));
/*     */     
/* 108 */     props.Slot = slot;
/*     */     PlayerEx playerEx;
/* 110 */     if ((entity instanceof EntityPlayer)) {
/* 111 */       EntityPlayer player = (EntityPlayer)entity;
/* 112 */       playerEx = PlayerEx.get(player);
/* 113 */       if (!Get.effects().isIncorporeal(player)) {
/* 114 */         for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 115 */           effect.augmentArmorProperties(entity, props, armor, source, damage, playerEx);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 120 */     return props;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_150895_a(Item itemIn, CreativeTabs tab, List subItems)
/*     */   {
/* 126 */     super.func_150895_a(itemIn, tab, subItems);
/*     */     
/* 128 */     ItemStack powered = new ItemStack(this, 1, 0);
/* 129 */     SoulSet souls = new SoulSet();
/* 130 */     souls.add(SoulType.BENIGN, 1).add(SoulType.PREDATORY, 1).add(SoulType.UNHINGED, 1).add(SoulType.IMMUTABLE, 1).add(SoulType.DOOMED, 1).add(SoulType.MALLEABLE, 1).add(SoulType.NOBLE, 1).add(SoulType.WISE, 1);
/* 131 */     setCapacity(powered, souls);
/*     */     
/* 133 */     subItems.add(powered);
/*     */   }
/*     */   
/*     */   public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
/*     */   {
/* 138 */     if (isBroken(armor)) {
/* 139 */       return 0;
/*     */     }
/*     */     
/* 142 */     double reduction = this.field_77879_b;
/*     */     
/* 144 */     ISpecialArmor.ArmorProperties props = new ISpecialArmor.ArmorProperties(0, reduction / 25.0D, Math.max(armor.func_77958_k() + 1 - armor.func_77952_i(), 1));
/* 145 */     props.Slot = slot;
/*     */     
/* 147 */     PlayerEx playerEx = PlayerEx.get(player);
/*     */     
/* 149 */     if (!Get.effects().isIncorporeal(playerEx.PLAYER)) {
/* 150 */       for (IPassiveEffect effect : playerEx.getActiveEffects()) {
/* 151 */         effect.augmentArmorProperties(player, props, armor, null, 0.0D, playerEx);
/*     */       }
/*     */     }
/*     */     
/* 155 */     return net.minecraft.util.MathHelper.func_76143_f(props.AbsorbRatio * 25.0D);
/*     */   }
/*     */   
/*     */   public boolean isBroken(ItemStack stack)
/*     */   {
/* 160 */     return stack.func_77952_i() > stack.func_77958_k();
/*     */   }
/*     */   
/*     */   public void setDamage(ItemStack stack, int damage)
/*     */   {
/* 165 */     int maxDamage = getMaxDamage(stack) + 1;
/* 166 */     super.setDamage(stack, damage < maxDamage ? damage : maxDamage);
/*     */   }
/*     */   
/*     */   public void damageArmor(EntityLivingBase entityIn, ItemStack stack, DamageSource source, int damage, int slot)
/*     */   {
/* 171 */     if (((!(entityIn instanceof EntityPlayer)) || (!((EntityPlayer)entityIn).field_71075_bZ.field_75098_d)) && 
/* 172 */       (!isBroken(stack)) && 
/* 173 */       (stack.func_96631_a(damage, entityIn.func_70681_au()))) {
/* 174 */       entityIn.func_70669_a(stack);
/*     */       
/* 176 */       if ((entityIn instanceof EntityPlayer)) {
/* 177 */         EntityPlayer player = (EntityPlayer)entityIn;
/* 178 */         PlayerEx playerEx = PlayerEx.get(player);
/* 179 */         playerEx.recalculateArmorCapacity();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelSoulArmor model;
/*     */   
/*     */   public void onArmorTick(World world, EntityPlayer player, ItemStack stack) {}
/*     */   
/*     */ 
/*     */   public void augmentCapacity(ItemStack stack, ISoulSet totalCapacity)
/*     */   {
/* 194 */     if ((stack.func_77942_o()) && (!isBroken(stack))) {
/* 195 */       NBTTagCompound compound = stack.func_77978_p();
/* 196 */       if (compound.func_150297_b("soulCapacity", 10)) {
/* 197 */         SoulSet capacity = SoulSet.fromTagCompound(compound.func_74775_l("soulCapacity"));
/* 198 */         if (capacity != null) {
/* 199 */           totalCapacity.add(capacity);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setCapacity(ItemStack stack, SoulSet capacity) {
/* 206 */     if (capacity != null) {
/* 207 */       if (!stack.func_77942_o()) {
/* 208 */         stack.func_77982_d(new NBTTagCompound());
/*     */       }
/*     */       
/* 211 */       NBTTagCompound compound = stack.func_77978_p();
/* 212 */       compound.func_74782_a("soulCapacity", capacity.toTagCompound());
/* 213 */       compound.func_74768_a("soulColor", capacity.generateColor());
/*     */     }
/*     */   }
/*     */   
/*     */   public static SoulSet getCapacity(ItemStack stack) {
/* 218 */     if (stack.func_77942_o()) {
/* 219 */       NBTTagCompound compound = stack.func_77978_p();
/* 220 */       if (compound.func_150297_b("soulCapacity", 10)) {
/* 221 */         SoulSet capacity = SoulSet.fromTagCompound(compound.func_74775_l("soulCapacity"));
/* 222 */         return capacity;
/*     */       }
/*     */     }
/* 225 */     return new SoulSet();
/*     */   }
/*     */   
/*     */   public static int getCapacityColor(ItemStack stack) {
/* 229 */     if (stack.func_77942_o()) {
/* 230 */       NBTTagCompound compound = stack.func_77978_p();
/* 231 */       int color = compound.func_74762_e("soulColor");
/* 232 */       if (color != 0) {
/* 233 */         return color;
/*     */       }
/*     */     }
/* 236 */     return 16777164;
/*     */   }
/*     */   
/*     */   public boolean func_82816_b_(ItemStack stack)
/*     */   {
/* 241 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack stack, int renderPass)
/*     */   {
/* 247 */     if (renderPass == 0) {
/* 248 */       return func_82814_b(stack);
/*     */     }
/* 250 */     return super.func_82790_a(stack, renderPass);
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_82814_b(ItemStack stack)
/*     */   {
/* 256 */     NBTTagCompound compound = stack.func_77978_p();
/* 257 */     if (compound != null) {
/* 258 */       NBTTagCompound display = compound.func_74775_l("display");
/* 259 */       if ((display != null) && (display.func_150297_b("color", 3))) {
/* 260 */         return display.func_74762_e("color");
/*     */       }
/*     */     }
/*     */     
/* 264 */     return 665649;
/*     */   }
/*     */   
/*     */   public void func_82813_b(ItemStack stack, int color)
/*     */   {
/* 269 */     NBTTagCompound compound = stack.func_77978_p();
/* 270 */     if (compound == null) {
/* 271 */       compound = new NBTTagCompound();
/* 272 */       stack.func_77982_d(compound);
/*     */     }
/*     */     
/* 275 */     NBTTagCompound display = compound.func_74775_l("display");
/* 276 */     if (!compound.func_150297_b("display", 10)) {
/* 277 */       compound.func_74782_a("display", display);
/*     */     }
/*     */     
/* 280 */     display.func_74768_a("color", color);
/*     */   }
/*     */   
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
/*     */   {
/* 285 */     boolean renderUnderlay = type == null;
/*     */     
/* 287 */     if (stack == null)
/* 288 */       return null;
/* 289 */     if (this.armorSlot == EnumArmorSlot.LEGS) {
/* 290 */       if (renderUnderlay) {
/* 291 */         return "intangible:textures/entity/soularmor_legs.png";
/*     */       }
/* 293 */       return "intangible:textures/entity/soularmor_legs_overlay.png";
/*     */     }
/*     */     
/* 296 */     if (renderUnderlay) {
/* 297 */       return "intangible:textures/entity/soularmor.png";
/*     */     }
/* 299 */     return "intangible:textures/entity/soularmor_overlay.png";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   private boolean isHoldingFoci(EntityPlayer player)
/*     */   {
/* 309 */     for (int i = 0; i < 9; i++) {
/* 310 */       ItemStack stack = player.field_71071_by.func_70301_a(i);
/* 311 */       if ((stack != null) && (stack.func_77973_b() == Get.items().FOCI)) {
/* 312 */         return true;
/*     */       }
/*     */     }
/* 315 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int slot)
/*     */   {
/* 321 */     if (this.model == null) {
/* 322 */       this.model = new ModelSoulArmor(0.3F);
/*     */     }
/*     */     
/*     */ 
/* 326 */     if ((stack != null) && (stack.func_77973_b().getClass() == getClass())) {
/*     */       ModelSoulArmor armorModel;
/*     */       ModelSoulArmor armorModel;
/* 329 */       if (this.armorSlot != EnumArmorSlot.LEGS) {
/* 330 */         armorModel = this.model;
/*     */       } else {
/* 332 */         armorModel = this.model;
/*     */       }
/*     */       
/* 335 */       if (armorModel != null) {
/* 336 */         boolean isVisible = true;
/*     */         
/* 338 */         if ((entityLiving instanceof EntityPlayer)) {
/* 339 */           EntityPlayer player = (EntityPlayer)entityLiving;
/* 340 */           PlayerEx playerEx = PlayerEx.get(player);
/* 341 */           isVisible = playerEx.getPlayerForm().isVisible();
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 349 */         armorModel.field_78116_c.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.HEAD));
/*     */         
/* 351 */         armorModel.field_178720_f.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.HEAD));
/*     */         
/* 353 */         armorModel.field_78115_e.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/*     */         
/* 355 */         armorModel.belt.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.LEGS));
/*     */         
/* 357 */         armorModel.chest.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 358 */         armorModel.field_178723_h.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/*     */         
/* 360 */         armorModel.field_178724_i.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/*     */         
/* 362 */         armorModel.field_178721_j.field_78806_j = ((isVisible) && ((this.armorSlot == EnumArmorSlot.LEGS) || (this.armorSlot == EnumArmorSlot.FEET)));
/*     */         
/* 364 */         armorModel.field_178722_k.field_78806_j = ((isVisible) && ((this.armorSlot == EnumArmorSlot.LEGS) || (this.armorSlot == EnumArmorSlot.FEET)));
/*     */         
/* 366 */         armorModel.shoeLeft.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.FEET));
/* 367 */         armorModel.shoeRight.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.FEET));
/*     */         
/*     */ 
/* 370 */         boolean clawsVisible = (isVisible) && (this.armorSlot == EnumArmorSlot.CHEST) && (Get.effects().isActiveFor(Get.effects().CLAWS, entityLiving));
/* 371 */         armorModel.clawLeft.field_78806_j = clawsVisible;
/* 372 */         armorModel.clawRight.field_78806_j = clawsVisible;
/*     */         
/* 374 */         boolean tendrilsVisible = (isVisible) && (this.armorSlot == EnumArmorSlot.CHEST) && (Get.effects().isActiveFor(Get.effects().TENDRILS, entityLiving));
/* 375 */         armorModel.tendrils.field_78806_j = tendrilsVisible;
/*     */         
/* 377 */         boolean armorVisible = Get.effects().isActiveFor(Get.effects().ARMOR, entityLiving);
/* 378 */         armorModel.shoulderLeftUpper1.field_78806_j = armorVisible;
/* 379 */         armorModel.shoulderLeftUpper2.field_78806_j = armorVisible;
/* 380 */         armorModel.shoulderLeftUpper3.field_78806_j = armorVisible;
/* 381 */         armorModel.shoulderRightUpper1.field_78806_j = armorVisible;
/* 382 */         armorModel.shoulderRightUpper2.field_78806_j = armorVisible;
/* 383 */         armorModel.shoulderRightUpper3.field_78806_j = armorVisible;
/* 384 */         armorModel.helmetSpike1.field_78806_j = armorVisible;
/* 385 */         armorModel.helmetSpike2.field_78806_j = armorVisible;
/* 386 */         armorModel.helmetSpike3.field_78806_j = armorVisible;
/* 387 */         armorModel.helmetSpike4.field_78806_j = armorVisible;
/* 388 */         armorModel.helmetSpike5.field_78806_j = armorVisible;
/* 389 */         armorModel.helmetSpike6.field_78806_j = armorVisible;
/* 390 */         armorModel.helmetSpike7.field_78806_j = armorVisible;
/* 391 */         armorModel.helmetSpike8.field_78806_j = armorVisible;
/* 392 */         armorModel.helmetSpike9.field_78806_j = armorVisible;
/*     */         
/* 394 */         armorModel.chestRibFront4.field_78806_j = armorVisible;
/* 395 */         armorModel.chestRibFront8.field_78806_j = armorVisible;
/* 396 */         armorModel.chestRibBack2.field_78806_j = armorVisible;
/* 397 */         armorModel.chestRibBack4.field_78806_j = armorVisible;
/* 398 */         armorModel.chestRibLeft2.field_78806_j = armorVisible;
/* 399 */         armorModel.chestRibRight2.field_78806_j = armorVisible;
/*     */         
/* 401 */         boolean isFlying = false;
/*     */         
/* 403 */         if ((entityLiving instanceof EntityPlayer)) {
/* 404 */           isFlying = emoniph.intangible.util.EntityUtil.isInAir((EntityPlayer)entityLiving, entityLiving == Minecraft.func_71410_x().field_71439_g);
/*     */         }
/*     */         
/* 407 */         armorModel.wing.field_78806_j = ((isVisible) && (Get.effects().isActiveFor(Get.effects().WINGS, entityLiving)) && (isFlying));
/*     */         
/* 409 */         armorModel.field_78117_n = entityLiving.func_70093_af();
/* 410 */         armorModel.field_78093_q = entityLiving.func_70115_ae();
/* 411 */         armorModel.field_78091_s = entityLiving.func_70631_g_();
/* 412 */         armorModel.field_78095_p = entityLiving.func_70678_g(Minecraft.func_71410_x().field_71428_T.field_74281_c);
/*     */         
/* 414 */         ItemStack heldStack = entityLiving.func_71124_b(0);
/* 415 */         armorModel.field_78120_m = ((heldStack != null) && (!(entityLiving instanceof EntityClone)) ? 1 : 0);
/* 416 */         armorModel.field_78118_o = false;
/*     */         
/* 418 */         if (((entityLiving instanceof EntityPlayer)) && (heldStack != null) && 
/* 419 */           (((EntityPlayer)entityLiving).func_71057_bx() > 0)) {
/* 420 */           EnumAction enumaction = heldStack.func_77975_n();
/*     */           
/* 422 */           if (enumaction == EnumAction.BLOCK) {
/* 423 */             armorModel.field_78120_m = 3;
/*     */           }
/*     */           
/* 426 */           armorModel.field_78118_o = (enumaction == EnumAction.BOW);
/*     */         }
/*     */         
/* 429 */         return armorModel;
/*     */       }
/*     */     }
/* 432 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isEquipped(EntityLivingBase entity) {
/* 436 */     ItemStack stack = entity != null ? entity.func_71124_b(this.armorSlot.equipmentSlot) : null;
/* 437 */     return (stack != null) && (stack.func_77973_b() == this);
/*     */   }
/*     */   
/*     */   public boolean hasDyeColor(ItemStack stack)
/*     */   {
/* 442 */     return func_82816_b_(stack);
/*     */   }
/*     */   
/*     */   public int getDyeColor(ItemStack stack)
/*     */   {
/* 447 */     return func_82814_b(stack);
/*     */   }
/*     */   
/*     */   public void setDyeColor(ItemStack stack, int color)
/*     */   {
/* 452 */     func_82813_b(stack, color);
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 457 */     return 4;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemSoulArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */