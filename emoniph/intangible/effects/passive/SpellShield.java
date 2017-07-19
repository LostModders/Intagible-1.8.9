/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.player.PlayerEx;
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
/*     */ import net.minecraft.util.Timer;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class SpellShield implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  36 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:shield");
/*     */   }
/*     */   
/*  39 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_shield.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  43 */     return GLYPH;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
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
/*  63 */     if ((Get.effects().isActiveFor(Get.effects().UNEXPECTED, player)) && (player.func_70093_af())) {
/*  64 */       cooldownManager.setCooldown(this, Get.effects().isActiveFor(Get.effects().OVERCLOCK, player) ? 80 : 100);
/*     */     }
/*     */   }
/*     */   
/*  68 */   private static final ResourceLocation TEXTURE1 = new ResourceLocation("intangible", "textures/particles/circle.png");
/*     */   
/*     */   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson)
/*     */   {
/*  73 */     if (!cooldownManager.isCooldownActive(this)) {
/*  74 */       if ((player.func_70093_af()) && (Get.effects().isActiveFor(Get.effects().UNEXPECTED, player))) {
/*  75 */         GlStateManager.func_179094_E();
/*  76 */         float scale = 3.0F;
/*  77 */         GlStateManager.func_179147_l();
/*  78 */         GlStateManager.func_179112_b(770, 1);
/*  79 */         GlStateManager.func_179092_a(516, 0.001F);
/*  80 */         GlStateManager.func_179132_a(false);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  85 */         GlStateManager.func_179137_b((float)renderX, (float)renderY + player.field_70131_O / 2.0F - 0.2D, (float)renderZ);
/*     */         
/*  87 */         float yaw = player.field_70126_B + (player.field_70177_z - player.field_70126_B) * Minecraft.func_71410_x().field_71428_T.field_74279_e;
/*  88 */         GlStateManager.func_179114_b(-yaw + 90.0F, 0.0F, 1.0F, 0.0F);
/*     */         
/*  90 */         GlStateManager.func_179152_a(2.0F, scale, 2.0F);
/*     */         
/*  92 */         GlStateManager.func_179124_c(0.5F, 1.0F, 0.5F);
/*  93 */         GlStateManager.func_179148_o(Intangible.PROXY.getSphereOuterID());
/*  94 */         GlStateManager.func_179131_c(0.9F, 1.0F, 0.5F, firstPerson ? 0.1F : 1.0F);
/*  95 */         GlStateManager.func_179148_o(Intangible.PROXY.getSphereInnerID());
/*     */         
/*  97 */         GlStateManager.func_179112_b(770, 771);
/*  98 */         GlStateManager.func_179092_a(516, 0.1F);
/*  99 */         GlStateManager.func_179132_a(true);
/* 100 */         GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/* 101 */         GlStateManager.func_179084_k();
/* 102 */         GlStateManager.func_179121_F();
/*     */       }
/*     */       else {
/* 105 */         GlStateManager.func_179094_E();
/* 106 */         GlStateManager.func_179137_b((float)renderX, (float)renderY + player.field_70131_O / 2.0F - 0.2D, (float)renderZ);
/* 107 */         GlStateManager.func_179114_b(player.field_70173_aa % 360, 0.0F, 1.0F, 0.0F);
/* 108 */         GlStateManager.func_179147_l();
/* 109 */         GlStateManager.func_179132_a(false);
/* 110 */         GlStateManager.func_179112_b(770, 1);
/*     */         
/* 112 */         GlStateManager.func_179092_a(516, 0.001F);
/*     */         
/* 114 */         Tessellator tessellator = Tessellator.func_178181_a();
/* 115 */         WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 116 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TEXTURE1);
/*     */         
/*     */ 
/* 119 */         float yaw = player.field_70126_B + (player.field_70177_z - player.field_70126_B) * Minecraft.func_71410_x().field_71428_T.field_74279_e;
/* 120 */         GlStateManager.func_179114_b(-yaw + 90.0F, 0.0F, 1.0F, 0.0F);
/*     */         
/* 122 */         float[] colorOuter = { 0.5F, 1.0F, 0.5F, 1.0F };
/* 123 */         float[] colorInner = { 0.9F, 1.0F, 0.5F, firstPerson ? 0.3F : 1.0F };
/*     */         
/* 125 */         int b0 = 16;
/* 126 */         for (int i = 0; i < b0; i++)
/* 127 */           if (i % 2 != 0)
/*     */           {
/*     */ 
/* 130 */             float x1 = MathHelper.func_76126_a(i % b0 * 3.1415927F * 2.0F / b0);
/* 131 */             float z1 = MathHelper.func_76134_b(i % b0 * 3.1415927F * 2.0F / b0);
/*     */             
/* 133 */             float x2 = MathHelper.func_76126_a((i + 1 % b0) * 3.1415927F * 2.0F / b0);
/* 134 */             float z2 = MathHelper.func_76134_b((i + 1 % b0) * 3.1415927F * 2.0F / b0);
/*     */             
/* 136 */             float uvExtent = 1.0F;
/*     */             
/* 138 */             worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */             
/* 140 */             float height = 0.75F;
/*     */             
/* 142 */             worldrenderer.func_181662_b(x2, 0.0D, z2).func_181673_a(uvExtent, uvExtent).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 143 */             worldrenderer.func_181662_b(x2, height, z2).func_181673_a(uvExtent, 0.0D).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 144 */             worldrenderer.func_181662_b(x1, height, z1).func_181673_a(0.0D, 0.0D).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 145 */             worldrenderer.func_181662_b(x1, 0.0D, z1).func_181673_a(0.0D, uvExtent).func_181666_a(colorOuter[0], colorOuter[1], colorOuter[2], colorOuter[3]).func_181675_d();
/* 146 */             tessellator.func_78381_a();
/*     */             
/* 148 */             worldrenderer.func_181668_a(7, DefaultVertexFormats.field_181709_i);
/*     */             
/*     */ 
/* 151 */             worldrenderer.func_181662_b(x1, 0.0D, z1).func_181673_a(0.0D, uvExtent).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/* 152 */             worldrenderer.func_181662_b(x1, height, z1).func_181673_a(0.0D, 0.0D).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/* 153 */             worldrenderer.func_181662_b(x2, height, z2).func_181673_a(uvExtent, 0.0D).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/* 154 */             worldrenderer.func_181662_b(x2, 0.0D, z2).func_181673_a(uvExtent, uvExtent).func_181666_a(colorInner[0], colorInner[1], colorInner[2], colorInner[3]).func_181675_d();
/*     */             
/* 156 */             tessellator.func_78381_a();
/*     */           }
/* 158 */         GlStateManager.func_179084_k();
/* 159 */         GlStateManager.func_179132_a(true);
/* 160 */         GlStateManager.func_179121_F();
/*     */       }
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
/* 182 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 187 */     return false;
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
/* 208 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager)
/*     */   {
/* 213 */     if ((!cooldownManager.isCooldownActive(this)) && (
/* 214 */       ((attack.getDamageSource().func_76346_g() instanceof EntityLivingBase)) || (attack.getDamageSource().func_76352_a()) || (attack.getDamageSource().func_94541_c()))) {
/* 215 */       attack.setDamage(0.0F);
/* 216 */       Sound.MOD_RANDOM_ENERGY_SHIELD.playToAllNear(player, 0.5F, 1.0F);
/* 217 */       if ((!Get.effects().isActiveFor(Get.effects().UNEXPECTED, player)) || (!player.func_70093_af())) {
/* 218 */         cooldownManager.setCooldown(this, Get.effects().isActiveFor(Get.effects().OVERCLOCK, player) ? 80 : 100);
/*     */       } else {
/* 220 */         PlayerEx.get(player).increaseRebellion(2, true);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellShield.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */