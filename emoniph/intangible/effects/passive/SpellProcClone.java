/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.entity.EntityClone;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.util.TickUtil;
/*     */ import java.util.EnumSet;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.network.play.server.S08PacketPlayerPosLook.EnumFlags;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SpellProcClone
/*     */   implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  36 */     return StatCollector.func_74838_a("effect.intangible:procclone");
/*     */   }
/*     */   
/*  39 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_procclone.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  43 */     return GLYPH;
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
/*  89 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/*  94 */     return false;
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
/* 114 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget playersTarget, Attack attack, ICooldownManager cooldownManager)
/*     */   {
/* 119 */     if ((playersTarget.getTarget() != null) && (playersTarget.getTarget() == attack.getDamageSource().func_76364_f()) && (playersTarget.getConsecutiveHits() >= 3) && 
/* 120 */       (!cooldownManager.isCooldownActive(this))) {
/* 121 */       attack.setDamage(0.0F);
/* 122 */       playersTarget.resetHitCount();
/* 123 */       cooldownManager.setCooldown(this, TickUtil.fromSeconds(10));
/* 124 */       if (!player.field_70170_p.field_72995_K) {
/* 125 */         EntityClone clone = new EntityClone(player, TickUtil.fromSeconds(10));
/* 126 */         player.field_70170_p.func_72838_d(clone);
/* 127 */         playersTarget.getTarget().func_70604_c(clone);
/* 128 */         Vec3 look = player.func_70040_Z();
/* 129 */         float distance = 2.0F;
/* 130 */         ((EntityPlayerMP)player).field_71135_a.func_175089_a(player.field_70165_t + look.field_72450_a * distance, player.field_70163_u, player.field_70161_v + look.field_72449_c * distance, 180.0F, ((EntityPlayerMP)player).field_70125_A, EnumSet.of(S08PacketPlayerPosLook.EnumFlags.Y_ROT));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellProcClone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */