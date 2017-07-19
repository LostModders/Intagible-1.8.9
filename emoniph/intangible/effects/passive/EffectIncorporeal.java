/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.config.Log;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerForms;
/*     */ import emoniph.intangible.util.TickUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class EffectIncorporeal implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  33 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:incorporeal");
/*     */   }
/*     */   
/*  36 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_incorporeal.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  40 */     return GLYPH;
/*     */   }
/*     */   
/*     */   public void startEffectOn(EntityPlayer player, boolean initialTrigger)
/*     */   {
/*  45 */     Get.log().debug("Starting incorporeal on " + player.getDisplayNameString());
/*  46 */     PlayerEx playerEx = PlayerEx.get(player);
/*  47 */     if (initialTrigger)
/*     */     {
/*  49 */       playerEx.createPlayerShell(player.field_70170_p, new BlockPos(player), true);
/*     */     }
/*     */     
/*  52 */     playerEx.setPlayerForm(Get.forms().INCORPOREAL);
/*     */   }
/*     */   
/*     */   public void stopEffectOn(EntityPlayer player)
/*     */   {
/*  57 */     Get.log().debug("Stopping incorporeal on " + player.getDisplayNameString());
/*  58 */     PlayerEx playerEx = PlayerEx.get(player);
/*  59 */     playerEx.setPlayerForm(Get.forms().DEFAULT);
/*  60 */     if (!player.field_70170_p.field_72995_K) {
/*  61 */       player.func_70690_d(new net.minecraft.potion.PotionEffect(Potion.field_76437_t.field_76415_H, TickUtil.fromSeconds(10), 1, false, false));
/*     */     }
/*     */   }
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
/*  98 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 103 */     return false;
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
/*     */   public boolean isPrerequisitesMet(EntityPlayer player, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet)
/*     */   {
/* 123 */     if (PlayerEx.get(player).isRecentlyHit()) {
/* 124 */       return false;
/*     */     }
/* 126 */     BlockPos pos = new BlockPos(player);
/* 127 */     IBlockState down = player.field_70170_p.func_180495_p(pos.func_177977_b());
/* 128 */     return (!down.func_177230_c().func_149688_o().func_76222_j()) && (player.field_70170_p.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) && (player.field_70170_p.func_180495_p(pos.func_177984_a()).func_177230_c().func_149688_o().func_76222_j()) && (down.func_177230_c() != net.minecraft.init.Blocks.field_150425_aM);
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/EffectIncorporeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */