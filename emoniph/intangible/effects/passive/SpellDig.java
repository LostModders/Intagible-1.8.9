/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.RayTraceUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellDig implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  30 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:dig");
/*     */   }
/*     */   
/*  33 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_dig.png");
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
/*     */   public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson)
/*     */   {
/*  63 */     if ((player.func_70093_af()) && (player.func_71039_bw())) {
/*  64 */       MovingObjectPosition hitBlock = RayTraceUtil.traceBlock(player, false, 20.0D);
/*  65 */       if (hitBlock != null) {
/*  66 */         emoniph.intangible.client.particle.BeamFX.draw(player, renderX, renderY, renderZ, Minecraft.func_71410_x().field_71428_T.field_74281_c, hitBlock.field_72307_f.func_72441_c(0.0D, 0.75D, 0.0D), 0.0F, -9754112);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/*  73 */     if ((!player.field_70170_p.field_72995_K) && (player.field_70173_aa % 5 == 0)) {
/*  74 */       EntityPlayerMP playerMP = (EntityPlayerMP)player;
/*  75 */       if ((player.func_71039_bw()) && (player.func_70093_af())) {
/*  76 */         MovingObjectPosition hitBlock = RayTraceUtil.traceBlock(playerMP, false, 20.0D);
/*  77 */         if (hitBlock != null) {
/*  78 */           IBlockState state = player.field_70170_p.func_180495_p(hitBlock.func_178782_a());
/*  79 */           if ((state.func_177230_c().func_176195_g(player.field_70170_p, hitBlock.func_178782_a()) >= 0.0F) && (!state.func_177230_c().hasTileEntity(state))) {
/*  80 */             BlockUtil.tryHarvestBlock(player.field_70170_p, hitBlock.func_178782_a(), playerMP, null);
/*     */           }
/*     */         }
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
/*     */   public void augmentArmorProperties(EntityLivingBase player, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer player)
/*     */   {
/* 104 */     return true;
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
/* 125 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellDig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */