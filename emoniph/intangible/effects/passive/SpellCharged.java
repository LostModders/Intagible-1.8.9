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
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.util.TickUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class SpellCharged implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  36 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:charged");
/*     */   }
/*     */   
/*  39 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_charged.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  43 */     return GLYPH;
/*     */   }
/*     */   
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager)
/*     */   {
/*  48 */     if ((!player.field_70170_p.field_72995_K) && 
/*  49 */       (!cooldownManager.isCooldownActive(this)) && 
/*  50 */       (attack.getDamageSource().func_76346_g() != null) && ((attack.getDamageSource().func_76346_g() instanceof EntityLivingBase))) {
/*  51 */       boolean overclock = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player);
/*  52 */       boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, player);
/*  53 */       cooldownManager.setCooldown(this, overclock ? TickUtil.fromSeconds(4) : TickUtil.fromSeconds(5));
/*  54 */       EntityLivingBase source = (EntityLivingBase)attack.getDamageSource().func_76346_g();
/*  55 */       if ((overclock) && (unexpected)) {
/*  56 */         source.func_70097_a(DamageSource.func_76354_b(source, source), attack.getOriginalDamage() * 0.5F);
/*     */       } else {
/*  58 */         source.func_70097_a(attack.getDamageSource(), attack.getOriginalDamage() * 0.5F);
/*     */       }
/*     */       
/*  61 */       Get.fx().GLOW.sendToAllNear(player, 1.0F, 30, 1087897, emoniph.intangible.util.EntityUtil.vecFromMidOf(source), 0.9F, 32.0D);
/*  62 */       Sound.MOD_RANDOM_MACHINE.playToAllNear(source, 0.5F, 1.2F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void startEffectOn(EntityPlayer player, boolean initialTrigger) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void stopEffectOn(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  83 */   private static final ResourceLocation TEXTURE1 = new ResourceLocation("intangible", "textures/particles/chargeball.png");
/*     */   
/*     */   public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  88 */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) { if (!cooldownManager.isCooldownActive(this)) {
/*  89 */       GlStateManager.func_179094_E();
/*     */       
/*  91 */       GlStateManager.func_179137_b((float)renderX, (float)renderY + player.field_70131_O / 2.0F - 0.2D, (float)renderZ);
/*  92 */       GlStateManager.func_179114_b(player.field_70173_aa * 8 % 360, 0.0F, 1.0F, 0.0F);
/*  93 */       GlStateManager.func_179147_l();
/*  94 */       GlStateManager.func_179132_a(false);
/*  95 */       GlStateManager.func_179112_b(770, 1);
/*     */       
/*  97 */       GlStateManager.func_179092_a(516, 0.001F);
/*     */       
/*  99 */       Tessellator tessellator = Tessellator.func_178181_a();
/* 100 */       WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 101 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(TEXTURE1);
/*     */       
/* 103 */       float[] colorOuter = { 0.2F, 0.9F, 0.9F, 1.0F };
/* 104 */       float[] colorInner = { 0.2F, 0.9F, 0.9F, firstPerson ? 0.4F : 1.0F };
/*     */       
/* 106 */       int b0 = 16;
/* 107 */       for (int i = 0; (i < b0) && (i < 2); i++)
/* 108 */         if (i % 2 != 0)
/*     */         {
/*     */ 
/* 111 */           float x1 = MathHelper.func_76126_a(i % b0 * 3.1415927F * 2.0F / b0);
/* 112 */           float z1 = MathHelper.func_76134_b(i % b0 * 3.1415927F * 2.0F / b0);
/*     */           
/* 114 */           float x2 = MathHelper.func_76126_a((i + 1 % b0) * 3.1415927F * 2.0F / b0);
/* 115 */           float z2 = MathHelper.func_76134_b((i + 1 % b0) * 3.1415927F * 2.0F / b0);
/*     */           
/* 117 */           float uvExtent = 1.0F;
/*     */           
/* 119 */           worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */           
/* 121 */           float height = 0.5F;
/*     */           
/* 123 */           worldrenderer.func_181662_b(x2, 0.0D, z2).func_181673_a(uvExtent, uvExtent).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 124 */           worldrenderer.func_181662_b(x2, height, z2).func_181673_a(uvExtent, 0.0D).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 125 */           worldrenderer.func_181662_b(x1, height, z1).func_181673_a(0.0D, 0.0D).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 126 */           worldrenderer.func_181662_b(x1, 0.0D, z1).func_181673_a(0.0D, uvExtent).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 127 */           tessellator.func_78381_a();
/*     */           
/* 129 */           worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */           
/*     */ 
/* 132 */           worldrenderer.func_181662_b(x1, 0.0D, z1).func_181673_a(0.0D, uvExtent).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/* 133 */           worldrenderer.func_181662_b(x1, height, z1).func_181673_a(0.0D, 0.0D).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/* 134 */           worldrenderer.func_181662_b(x2, height, z2).func_181673_a(uvExtent, 0.0D).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/* 135 */           worldrenderer.func_181662_b(x2, 0.0D, z2).func_181673_a(uvExtent, uvExtent).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/*     */           
/* 137 */           tessellator.func_78381_a();
/*     */         }
/* 139 */       GlStateManager.func_179084_k();
/* 140 */       GlStateManager.func_179132_a(true);
/* 141 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
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
/* 162 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 167 */     return false;
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
/* 188 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellCharged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */