/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class SpellProcDodge implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  29 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:procdodge");
/*     */   }
/*     */   
/*  32 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_procdodge.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  36 */     return GLYPH;
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
/*  82 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/*  87 */     return false;
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
/* 107 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget playersTarget, Attack attack, ICooldownManager cooldownManager)
/*     */   {
/* 112 */     if ((playersTarget.getTarget() != null) && (playersTarget.getTarget() == attack.getDamageSource().func_76364_f()) && (playersTarget.getConsecutiveHits() >= 4) && 
/* 113 */       (!cooldownManager.isCooldownActive(this))) {
/* 114 */       attack.setDamage(0.0F);
/*     */       
/* 116 */       playersTarget.resetHitCount();
/* 117 */       cooldownManager.setCooldown(this, 140);
/* 118 */       if (!player.field_70170_p.field_72995_K) {
/* 119 */         Entity attacker = attack.getDamageSource().func_76364_f();
/* 120 */         double vx = player.field_70165_t - attacker.field_70165_t;
/* 121 */         double vy = player.field_70163_u - attacker.field_70163_u;
/* 122 */         double vz = player.field_70161_v - attacker.field_70161_v;
/* 123 */         Vec3 vec = new Vec3(vx, 0.0D, vz).func_72432_b().func_178785_b(player.field_70170_p.field_73012_v.nextBoolean() ? 90.0F : -90.0F);
/*     */         
/* 125 */         Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(player, vec.field_72450_a * 1.0D, 0.0D, vec.field_72449_c * 1.0D, false), player);
/* 126 */         Sound.MOD_RANDOM_BELLOW_OUT.playToAllNear(player, 0.5F, 2.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellProcDodge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */