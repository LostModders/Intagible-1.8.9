/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellClaws implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  25 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:claws");
/*     */   }
/*     */   
/*  28 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_claws.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  32 */     return GLYPH;
/*     */   }
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
/*     */   public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager)
/*     */   {
/*  47 */     ItemStack heldStack = player.func_70694_bm();
/*     */     
/*     */ 
/*  50 */     if ((Get.items().SOUL_CHESTPLATE.isEquipped(player)) && ((heldStack == null) || (player.func_110148_a(net.minecraft.entity.SharedMonsterAttributes.field_111264_e).func_111126_e() <= 1.0D))) {
/*  51 */       DamageSource source = attack.getDamageSource();
/*  52 */       if (((source instanceof net.minecraft.util.EntityDamageSource)) && (
/*  53 */         (source.func_76355_l().equals("player")) || (source.func_76355_l().equals("mob")))) {
/*  54 */         float CLAW_DAMAGE_BONUS = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player) ? 11.0F : 7.0F;
/*  55 */         if (Get.effects().isActiveFor(Get.effects().UNEXPECTED, player)) {
/*  56 */           float health = target.getTarget().func_110143_aJ();
/*  57 */           if (health > 3.0F) {
/*  58 */             target.getTarget().func_70606_j(health - 2.0F);
/*     */           }
/*     */         }
/*  61 */         attack.setDamage(attack.getDamage() + CLAW_DAMAGE_BONUS);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
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
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onApplyToNearbyEntities(EntityPlayer player, List<Entity> target, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void augmentArmorProperties(EntityLivingBase entity, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/*  99 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onRightClickAir(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onSwing(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onPostRenderTick(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isPrerequisitesMet(EntityPlayer PLAYER, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet)
/*     */   {
/* 119 */     return (chest != null) && ((chest.func_77973_b() instanceof emoniph.intangible.api.ISoulArmor));
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellClaws.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */