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
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class SpellPacified implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  32 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:pacified");
/*     */   }
/*     */   
/*  35 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_pacified.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  39 */     return GLYPH;
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
/*  59 */     if (!player.field_70170_p.field_72995_K) {
/*  60 */       PlayerEx.get(player).disableEffect(this);
/*  61 */       if (!player.field_71075_bZ.field_75098_d) {
/*  62 */         player.func_70606_j(0.0F);
/*  63 */         player.func_70645_a(DamageSource.field_76376_m);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson)
/*     */   {
/*     */     
/*  72 */     if (firstPerson) {
/*  73 */       Vec3 look = player.func_70040_Z();
/*  74 */       GlStateManager.func_179137_b(look.field_72450_a * 0.5D, -0.2D, look.field_72449_c * 0.5D);
/*     */     }
/*     */     
/*     */ 
/*  78 */     GlStateManager.func_179137_b(renderX, renderY + player.field_70131_O + 0.8D + Math.sin(player.field_70173_aa * 0.5F) * 0.1D, renderZ);
/*     */     
/*  80 */     GlStateManager.func_179114_b(-player.field_70177_z + player.field_70173_aa, 0.0F, 1.0F, 0.0F);
/*  81 */     float scale = 0.6F;
/*     */     
/*  83 */     GlStateManager.func_179114_b(-135.0F, 0.0F, 0.0F, 1.0F);
/*  84 */     GlStateManager.func_179152_a(scale, scale, scale);
/*     */     
/*  86 */     Minecraft.func_71410_x().func_175599_af().func_181564_a(new ItemStack(Items.field_151040_l), net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.GROUND);
/*     */     
/*  88 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/*  93 */     if ((!player.field_70170_p.field_72995_K) && 
/*  94 */       (!cooldownManager.isCooldownActive(this))) {
/*  95 */       PlayerEx.get(player).disableEffectFuture(this);
/*     */     }
/*     */   }
/*     */   
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
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 117 */     return false;
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
/* 138 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellPacified.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */