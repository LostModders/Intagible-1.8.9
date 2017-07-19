/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.ActionQueue;
/*     */ import emoniph.intangible.ActionQueue.IAction;
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class SpellProcLaunch implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  29 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:proclaunch");
/*     */   }
/*     */   
/*  32 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_proclaunch.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  36 */     return GLYPH;
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
/*     */   public void onAttacking(final EntityPlayer player, final IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager)
/*     */   {
/*  51 */     if ((target.getTarget() != null) && (target.getTarget() != player) && (target.getConsecutiveHits() >= 3) && 
/*  52 */       (!cooldownManager.isCooldownActive(this))) {
/*  53 */       cooldownManager.setCooldown(this, 240);
/*  54 */       target.resetHitCount();
/*  55 */       Get.actions().queue(player.func_130014_f_(), new ActionQueue.IAction() {
/*  56 */         private final EntityLivingBase victim = target.getTarget();
/*     */         
/*     */         public void doAction(World world) {
/*  59 */           double SPEED = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player) ? 1.4D : 1.2D;
/*  60 */           if ((this.victim instanceof EntityPlayer)) {
/*  61 */             EntityPlayer otherPlayer = (EntityPlayer)this.victim;
/*  62 */             Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(otherPlayer, 0.0D, SPEED, 0.0D), otherPlayer);
/*     */           } else {
/*  64 */             this.victim.field_70181_x = SPEED;
/*     */           }
/*     */         }
/*     */       });
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
/*  99 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 104 */     return false;
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
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellProcLaunch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */