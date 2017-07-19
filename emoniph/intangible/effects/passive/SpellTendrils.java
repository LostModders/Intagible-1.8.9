/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.entity.EntitySpellBase;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.item.EntityXPOrb;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.entity.projectile.EntityFireball;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellTendrils implements emoniph.intangible.api.IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  30 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:tendrils");
/*     */   }
/*     */   
/*  33 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_tendrils.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  37 */     return GLYPH;
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
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onApplyToNearbyEntities(EntityPlayer player, List<Entity> targets, ICooldownManager cooldownManager)
/*     */   {
/*  74 */     if (targets.size() > 0) {
/*  75 */       Entity closest = null;
/*  76 */       double closestDistance = Double.MAX_VALUE;
/*  77 */       for (Entity target : targets) {
/*  78 */         double distance = target.func_70068_e(player);
/*  79 */         if ((target.func_70089_S()) && (distance < closestDistance)) {
/*  80 */           closestDistance = distance;
/*  81 */           closest = target;
/*     */         }
/*     */       }
/*     */       
/*  85 */       if (closest != null) {
/*  86 */         if ((closest instanceof EntityArrow)) {
/*  87 */           EntityArrow arrow = (EntityArrow)closest;
/*  88 */           if (arrow.field_70250_c == player) {
/*  89 */             return;
/*     */           }
/*  91 */           closest.field_70159_w = (-closest.field_70159_w);
/*  92 */           closest.field_70181_x = (-closest.field_70181_x);
/*  93 */           closest.field_70179_y = (-closest.field_70179_y);
/*  94 */         } else if ((closest instanceof EntitySpellBase)) {
/*  95 */           EntitySpellBase arrow = (EntitySpellBase)closest;
/*  96 */           if (arrow.shootingEntity == player) {
/*  97 */             return;
/*     */           }
/*  99 */           closest.field_70159_w = (-closest.field_70159_w);
/* 100 */           closest.field_70181_x = (-closest.field_70181_x);
/* 101 */           closest.field_70179_y = (-closest.field_70179_y);
/* 102 */         } else if ((closest instanceof EntityThrowable)) {
/* 103 */           EntityThrowable arrow = (EntityThrowable)closest;
/* 104 */           if (arrow.func_85052_h() == player) {
/* 105 */             return;
/*     */           }
/* 107 */           closest.field_70159_w = (-closest.field_70159_w);
/* 108 */           closest.field_70181_x = (-closest.field_70181_x);
/* 109 */           closest.field_70179_y = (-closest.field_70179_y);
/* 110 */         } else if ((closest instanceof EntityFireball)) {
/* 111 */           EntityFireball arrow = (EntityFireball)closest;
/* 112 */           if (arrow.field_70235_a == player) {
/* 113 */             return;
/*     */           }
/* 115 */           closest.field_70159_w = (-closest.field_70159_w);
/* 116 */           closest.field_70181_x = (-closest.field_70181_x);
/* 117 */           closest.field_70179_y = (-closest.field_70179_y);
/* 118 */         } else if ((closest instanceof net.minecraft.entity.IProjectile)) {
/* 119 */           closest.field_70159_w = (-closest.field_70159_w);
/* 120 */           closest.field_70181_x = (-closest.field_70181_x);
/* 121 */           closest.field_70179_y = (-closest.field_70179_y);
/* 122 */         } else if ((closest instanceof EntityItem)) {
/* 123 */           if (!player.field_70170_p.field_72995_K) {
/* 124 */             EntityItem item = (EntityItem)closest;
/* 125 */             item.func_70100_b_(player);
/*     */           }
/* 127 */         } else if ((closest instanceof EntityXPOrb)) {
/* 128 */           if (!player.field_70170_p.field_72995_K) {
/* 129 */             EntityXPOrb item = (EntityXPOrb)closest;
/* 130 */             item.func_70100_b_(player);
/*     */           }
/* 132 */         } else if (((closest instanceof EntityLivingBase)) && 
/* 133 */           ((closest instanceof net.minecraft.entity.monster.EntityCreeper))) {
/* 134 */           float speed = 1.6F;
/* 135 */           float lift = 0.5F;
/*     */           
/* 137 */           Vec3 vec = new Vec3(closest.field_70165_t - player.field_70165_t, closest.field_70163_u - player.field_70163_u, closest.field_70161_v - player.field_70161_v).func_72432_b();
/* 138 */           double dx = vec.field_72450_a * speed;
/* 139 */           double dy = lift;
/* 140 */           double dz = vec.field_72449_c * speed;
/* 141 */           if ((closest instanceof EntityPlayer)) {
/* 142 */             EntityPlayer otherPlayer = (EntityPlayer)closest;
/* 143 */             Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(otherPlayer, dx, dy, dz), otherPlayer);
/*     */           } else {
/* 145 */             closest.field_70159_w = dx;
/* 146 */             closest.field_70181_x = dy;
/* 147 */             closest.field_70179_y = dz;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void augmentArmorProperties(EntityLivingBase entity, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/* 163 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 168 */     return false;
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
/* 189 */     return (chest != null) && ((chest.func_77973_b() instanceof emoniph.intangible.api.ISoulArmor));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onAttackedBy(EntityPlayer player, emoniph.intangible.player.FocusedTarget focusedTarget, emoniph.intangible.Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/* 199 */     if (Get.effects().isActiveFor(Get.effects().UNEXPECTED, player)) {
/* 200 */       int blockX = MathHelper.func_76128_c(player.field_70165_t);
/* 201 */       int blockY = MathHelper.func_76128_c(player.field_70163_u + 1.0D);
/* 202 */       int blockZ = MathHelper.func_76128_c(player.field_70161_v);
/*     */       
/* 204 */       if (player.field_70170_p.func_180495_p(new net.minecraft.util.BlockPos(blockX, blockY, blockZ)).func_177230_c().func_149688_o().func_76220_a()) {
/* 205 */         player.field_70181_x *= 0.6D;
/*     */       }
/*     */       
/* 208 */       if (player.field_70123_F) {
/* 209 */         player.field_70181_x = 0.3D;
/*     */       }
/*     */       
/* 212 */       if ((player.func_70093_af()) && (player.field_70123_F)) {
/* 213 */         player.field_70181_x = 0.0D;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellTendrils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */