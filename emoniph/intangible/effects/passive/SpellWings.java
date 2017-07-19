/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellWings implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  28 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:wings");
/*     */   }
/*     */   
/*  31 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_wings.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  35 */     return GLYPH;
/*     */   }
/*     */   
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager)
/*     */   {
/*  40 */     emoniph.intangible.Get.log().debug("hurt");
/*     */   }
/*     */   
/*     */   public void startEffectOn(EntityPlayer entity, boolean initialTrigger)
/*     */   {
/*  45 */     if (!entity.field_71075_bZ.field_75098_d) {
/*  46 */       entity.field_71075_bZ.field_75101_c = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopEffectOn(EntityPlayer entity)
/*     */   {
/*  52 */     if (!entity.field_71075_bZ.field_75098_d) {
/*  53 */       entity.field_71075_bZ.field_75101_c = false;
/*  54 */       entity.field_71075_bZ.field_75100_b = false;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer entity, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onUpdate(EntityPlayer entity, ICooldownManager cooldownManager)
/*     */   {
/*  71 */     if (entity.field_70170_p.field_72995_K) {
/*  72 */       float f = (float)Math.sin(entity.field_70173_aa / 4.0F);
/*  73 */       float f1 = (float)Math.sin((entity.field_70173_aa - 1) / 4.0F);
/*  74 */       float f2 = (float)Math.sin((entity.field_70173_aa - 2) / 4.0F);
/*  75 */       if ((f > f1) && (f1 < f2) && ((entity instanceof EntityPlayer)) && 
/*  76 */         (Minecraft.func_71410_x().field_71439_g.func_70068_e(entity) < 1024.0D)) {
/*  77 */         EntityPlayer player = entity;
/*  78 */         if (emoniph.intangible.util.EntityUtil.isInAir(player, false)) {
/*  79 */           entity.field_70170_p.func_72980_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, Sound.MOD_RANDOM_WINGBEAT.LOCATION, 1.0F, 1.0F, false);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*  84 */     else if ((!entity.field_71075_bZ.field_75098_d) && 
/*  85 */       (entity.field_71075_bZ.field_75100_b) && (!entity.field_70122_E) && 
/*  86 */       (entity.field_70173_aa % 20 == 0)) {
/*  87 */       PlayerEx.get(entity).increaseRebellion();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */     if (!entity.field_71075_bZ.field_75101_c) {
/*  95 */       entity.field_71075_bZ.field_75101_c = true;
/*     */     }
/*     */     
/*  98 */     if (!entity.field_71075_bZ.field_75098_d) {
/*  99 */       if (!entity.field_71075_bZ.field_75100_b) {
/* 100 */         entity.field_71075_bZ.field_75100_b = (entity.field_70143_R > 1.0F);
/*     */       } else {
/* 102 */         entity.field_70143_R = 0.0F;
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
/*     */   public void augmentArmorProperties(EntityLivingBase entity, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 124 */     return false;
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
/* 144 */     return (chest != null) && ((chest.func_77973_b() instanceof emoniph.intangible.api.ISoulArmor));
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellWings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */