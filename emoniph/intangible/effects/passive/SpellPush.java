/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
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
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellPush implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  28 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:push");
/*     */   }
/*     */   
/*  31 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_push.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  35 */     return GLYPH;
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
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
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
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/*  85 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onRightClickAir(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onSwing(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/*  96 */     if ((!player.field_70170_p.field_72995_K) && (!cooldownManager.isCooldownActive(this)) && 
/*  97 */       (player.func_70093_af())) {
/*  98 */       World world = player.field_70170_p;
/*  99 */       cooldownManager.setCooldown(this, 100);
/* 100 */       if (!world.field_72995_K)
/*     */       {
/* 102 */         AxisAlignedBB bounds = player.func_174813_aQ();
/* 103 */         boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, player);
/* 104 */         double range = unexpected ? 14.0D : 3.0D;
/* 105 */         List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, bounds.func_72314_b(range, 0.0D, range));
/*     */         
/* 107 */         boolean overclock = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player);
/*     */         
/* 109 */         float speed = overclock ? 2.0F : 1.6F;
/* 110 */         float lift = overclock ? 1.0F : 0.5F;
/* 111 */         for (EntityLivingBase target : list) {
/* 112 */           if ((player != target) && (target.func_70068_e(player) <= range * range)) {
/* 113 */             if (unexpected) {
/* 114 */               emoniph.intangible.util.EntityUtil.pullTowards(world, target, new Vec3(player.field_70165_t, player.field_70163_u, player.field_70161_v), 0.06D, 0.2D);
/*     */             } else {
/* 116 */               Vec3 vec = new Vec3(target.field_70165_t - player.field_70165_t, target.field_70163_u - player.field_70163_u, target.field_70161_v - player.field_70161_v).func_72432_b();
/* 117 */               double dx = vec.field_72450_a * speed;
/* 118 */               double dy = lift;
/* 119 */               double dz = vec.field_72449_c * speed;
/* 120 */               if ((target instanceof EntityPlayer)) {
/* 121 */                 EntityPlayer otherPlayer = (EntityPlayer)target;
/* 122 */                 Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(otherPlayer, dx, dy, dz), otherPlayer);
/*     */               } else {
/* 124 */                 target.field_70159_w = dx;
/* 125 */                 target.field_70181_x = dy;
/* 126 */                 target.field_70179_y = dz;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/* 133 */         Sound.MOD_RANDOM_BELLOW_OUT.playToAllNear(player, 0.5F, 1.0F);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onPostRenderTick(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isPrerequisitesMet(EntityPlayer PLAYER, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet)
/*     */   {
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellPush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */