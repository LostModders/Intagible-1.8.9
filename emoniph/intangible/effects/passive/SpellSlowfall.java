/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class SpellSlowfall implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  27 */     return StatCollector.func_74838_a("effect.intangible:slowfall");
/*     */   }
/*     */   
/*  30 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_slowfall.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  34 */     return GLYPH;
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
/*     */ 
/*     */   public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/*  65 */     if (!player.field_70170_p.field_72995_K) {
/*  66 */       if (cooldownManager.isCooldownActive(this)) {
/*  67 */         player.field_70143_R = 0.0F;
/*     */       } else {
/*  69 */         PlayerEx.get(player).disableEffectFuture(this);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onApplyToNearbyEntities(EntityPlayer player, List<Entity> target, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void augmentArmorProperties(EntityLivingBase player, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer player)
/*     */   {
/*  91 */     return true;
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
/*     */   public void onPostRenderTick(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isPrerequisitesMet(EntityPlayer PLAYER, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet)
/*     */   {
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellSlowfall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */