/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.entity.EntityReaper;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.util.EntityUtil;
/*     */ import emoniph.intangible.util.TickUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.apache.commons.lang3.Range;
/*     */ 
/*     */ public class SpellProcReaper implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  33 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:procreaper");
/*     */   }
/*     */   
/*  36 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_procreaper.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  40 */     return GLYPH;
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
/*  55 */     if ((target.getTarget() != null) && (target.getTarget() != player) && (target.getConsecutiveHits() >= 4) && 
/*  56 */       (!cooldownManager.isCooldownActive(this)))
/*     */     {
/*  58 */       if (!player.field_70170_p.field_72995_K) {
/*  59 */         EntityReaper reaper = new EntityReaper(player.field_70170_p).setTicksToLive(TickUtil.fromSeconds(15));
/*  60 */         if (EntityUtil.trySetRandomNearbyPosition(reaper, player.field_70170_p, EntityUtil.vecFromMidOf(target.getTarget()), Range.between(Double.valueOf(5.0D), Double.valueOf(10.0D)), 4)) {
/*  61 */           Get.fx().sendToAllNear(EnumParticleTypes.REDSTONE, reaper, 0.5F, 20, 32.0D);
/*  62 */           Sound.MOD_RANDOM_FUNERAL_MARCH.playToAllNear(target.getTarget(), 0.5F, 1.0F);
/*  63 */           player.field_70170_p.func_72838_d(reaper);
/*  64 */           reaper.func_70624_b(target.getTarget());
/*  65 */           reaper.func_70604_c(target.getTarget());
/*  66 */           target.resetHitCount();
/*  67 */           cooldownManager.setCooldown(this, TickUtil.fromSeconds(30));
/*  68 */           if ((target.getTarget() instanceof EntityPlayer)) {
/*  69 */             emoniph.intangible.util.ChatUtil.send(target.getTarget(), "spell.intangible:procreaper.warning", new Object[0]);
/*     */           }
/*     */         }
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
/*     */   @SideOnly(Side.CLIENT)
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
/* 104 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 109 */     return false;
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
/* 129 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellProcReaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */