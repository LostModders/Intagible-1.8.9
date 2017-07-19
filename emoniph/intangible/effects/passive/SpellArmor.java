/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.ISoulArmor;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.items.ItemSoulArmor;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellArmor implements emoniph.intangible.api.IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  26 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:armor");
/*     */   }
/*     */   
/*  29 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_armor.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  33 */     return GLYPH;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void startEffectOn(EntityPlayer player, boolean initialTrigger) {}
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
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager)
/*     */   {
/*  53 */     boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, player);
/*  54 */     if ((unexpected) && (attack.getDamageSource() != DamageSource.field_76371_c) && (
/*  55 */       (attack.getDamageSource().func_94541_c()) || (attack.getDamageSource().func_76347_k()))) {
/*  56 */       attack.setDamage(0.0F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*  76 */   private static final int[] REDUCTION_BONUS = { 1, 2, 2, 1 };
/*  77 */   private static final int[] BOOSTED_BONUS = { 1, 3, 3, 2 };
/*  78 */   private static final int[] TURBO_BONUS = { 2, 4, 3, 2 };
/*     */   
/*     */   public void onApplyToNearbyEntities(EntityPlayer player, java.util.List<Entity> target, ICooldownManager cooldownManager) {}
/*     */   
/*  82 */   public void augmentArmorProperties(EntityLivingBase entity, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) { if ((armor != null) && ((armor.func_77973_b() instanceof ItemSoulArmor)))
/*     */     {
/*  84 */       if (Get.effects().isActiveFor(Get.effects().OVERCLOCK, entity))
/*     */       {
/*  86 */         boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, entity);
/*  87 */         if (unexpected) {
/*  88 */           props.AbsorbRatio += TURBO_BONUS[props.Slot] / 25.0D;
/*     */         } else {
/*  90 */           props.AbsorbRatio += BOOSTED_BONUS[props.Slot] / 25.0D;
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  96 */         if ((source != null) && (Get.config().REDUCE_OVERCLOCKED_ARMOR_IF_ENCHANTED)) {
/*  97 */           int k = Math.min(net.minecraft.enchantment.EnchantmentHelper.func_77508_a(new ItemStack[] { armor }, source), 20);
/*  98 */           if (k > 0) {
/*  99 */             double reduction = 0.5D * k / 25.0D;
/* 100 */             props.AbsorbRatio = Math.max(0.0D, props.AbsorbRatio - reduction);
/*     */           }
/*     */         }
/*     */       }
/* 104 */       else if (!ItemSoulArmor.isUnblockableSource(source)) {
/* 105 */         props.AbsorbRatio += REDUCTION_BONUS[props.Slot] / 25.0D;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/* 113 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 118 */     return false;
/*     */   }
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
/* 141 */     return ((head != null) && ((head.func_77973_b() instanceof ISoulArmor))) || ((chest != null) && ((chest.func_77973_b() instanceof ISoulArmor))) || ((legs != null) && ((legs.func_77973_b() instanceof ISoulArmor))) || ((feet != null) && ((feet.func_77973_b() instanceof ISoulArmor)));
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager)
/*     */   {
/* 146 */     if ((!player.field_70170_p.field_72995_K) && 
/* 147 */       (Get.effects().isActiveFor(Get.effects().OVERCLOCK, player)) && (player.field_70170_p.field_73012_v.nextInt(4) == 0)) {
/* 148 */       PlayerEx.get(player).increaseRebellion(1, true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */