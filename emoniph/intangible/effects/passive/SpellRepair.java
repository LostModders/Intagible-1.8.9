/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.ISoulArmor;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.util.EnumArmorSlot;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellRepair implements emoniph.intangible.api.IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  25 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:repair");
/*     */   }
/*     */   
/*  28 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_repair.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  32 */     return GLYPH;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void startEffectOn(EntityPlayer player, boolean initialTrigger) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void stopEffectOn(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/*  62 */     if ((!player.field_70170_p.field_72995_K) && (player.field_70173_aa % 20 == 0)) {
/*  63 */       repair(player, EnumArmorSlot.HEAD, Get.items().SOUL_HELMET);
/*  64 */       repair(player, EnumArmorSlot.CHEST, Get.items().SOUL_CHESTPLATE);
/*  65 */       repair(player, EnumArmorSlot.LEGS, Get.items().SOUL_TROUSERS);
/*  66 */       repair(player, EnumArmorSlot.FEET, Get.items().SOUL_BOOTS);
/*  67 */       ItemStack stack = player.func_70694_bm();
/*  68 */       if ((stack != null) && (stack.func_77973_b() == Get.items().SOUL_SPEAR) && (stack.func_77951_h())) {
/*  69 */         stack.func_77964_b(stack.func_77952_i() - 1);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void repair(EntityLivingBase player, EnumArmorSlot armorSlot, Item armorType) {
/*  75 */     ItemStack stack = player.func_71124_b(armorSlot.equipmentSlot);
/*  76 */     if ((stack != null) && (stack.func_77973_b() == armorType) && (stack.func_77951_h())) {
/*  77 */       stack.func_77964_b(stack.func_77952_i() - 1);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onApplyToNearbyEntities(EntityPlayer player, java.util.List<Entity> target, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void augmentArmorProperties(EntityLivingBase entity, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/*  98 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onRightClickAir(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onSwing(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPostRenderTick(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isPrerequisitesMet(EntityPlayer PLAYER, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet)
/*     */   {
/* 122 */     return ((head != null) && ((head.func_77973_b() instanceof ISoulArmor))) || ((chest != null) && ((chest.func_77973_b() instanceof ISoulArmor))) || ((legs != null) && ((legs.func_77973_b() instanceof ISoulArmor))) || ((feet != null) && ((feet.func_77973_b() instanceof ISoulArmor)));
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellRepair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */