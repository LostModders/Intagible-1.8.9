/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellMomentum implements IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  33 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:momentum");
/*     */   }
/*     */   
/*  36 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_momentum.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  40 */     return GLYPH;
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
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/*  71 */     double ACTIVATE_SPEED = 0.075D;
/*  72 */     double ACTIVATE_SPEED_SQ = 0.005625D;
/*     */     
/*  74 */     if ((!player.field_70170_p.field_72995_K) && ((player instanceof EntityPlayerMP))) {
/*  75 */       EntityPlayerMP playerMP = (EntityPlayerMP)player;
/*     */       
/*  77 */       if ((player.func_70051_ag()) || (playerMP.field_70181_x < -1.0D))
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  84 */         PlayerEx playerEx = PlayerEx.get(playerMP);
/*     */         
/*  86 */         double SCALE = 3.0D;
/*  87 */         double motionX = (playerMP.field_70165_t - playerEx.CACHE.prevX) * 3.0D;
/*  88 */         double motionY = (playerMP.field_70163_u - playerEx.CACHE.prevY) * 3.0D;
/*  89 */         double motionZ = (playerMP.field_70161_v - playerEx.CACHE.prevZ) * 3.0D;
/*     */         
/*     */ 
/*  92 */         BlockPos blockpos = new BlockPos(player.func_174813_aQ().field_72340_a - 0.1D + motionX, player.func_174813_aQ().field_72338_b + 0.01D + motionY, player.func_174813_aQ().field_72339_c - 0.1D + motionZ);
/*  93 */         BlockPos blockpos1 = new BlockPos(player.func_174813_aQ().field_72336_d + 0.1D + motionX, player.func_174813_aQ().field_72337_e - 0.01D + motionY, player.func_174813_aQ().field_72334_f + 0.1D + motionZ);
/*     */         
/*  95 */         if (player.field_70170_p.func_175707_a(blockpos, blockpos1)) {
/*  96 */           boolean blockBroken = false;
/*  97 */           for (int i = blockpos.func_177958_n(); i <= blockpos1.func_177958_n(); i++) {
/*  98 */             for (int j = blockpos.func_177956_o(); j <= blockpos1.func_177956_o(); j++) {
/*  99 */               for (int k = blockpos.func_177952_p(); k <= blockpos1.func_177952_p(); k++) {
/* 100 */                 BlockPos blockpos2 = new BlockPos(i, j, k);
/* 101 */                 IBlockState state = player.field_70170_p.func_180495_p(blockpos2);
/* 102 */                 if (state.func_177230_c().func_149688_o().func_76220_a()) {
/* 103 */                   boolean canHarvest = false;
/* 104 */                   if ((state.func_177230_c().func_176195_g(playerMP.field_70170_p, blockpos2) >= 0.0F) && (!state.func_177230_c().hasTileEntity(state))) {
/* 105 */                     if (state.func_177230_c().func_149688_o().func_76229_l()) {
/* 106 */                       canHarvest = true;
/*     */                     }
/*     */                     
/* 109 */                     String tool = state.func_177230_c().getHarvestTool(state);
/*     */                     
/* 111 */                     ItemStack stack = new ItemStack(Items.field_151035_b);
/* 112 */                     int toolLevel = stack != null ? stack.func_77973_b().getHarvestLevel(stack, tool) : 0;
/* 113 */                     if (toolLevel < 0) {
/* 114 */                       canHarvest = true;
/*     */                     }
/*     */                     
/* 117 */                     if (toolLevel >= state.func_177230_c().getHarvestLevel(state)) {
/* 118 */                       canHarvest = true;
/*     */                     }
/*     */                   }
/*     */                   
/*     */ 
/* 123 */                   if (canHarvest) {
/* 124 */                     ((EntityPlayerMP)player).field_70170_p.func_175718_b(2001, blockpos2, Block.func_149682_b(state.func_177230_c()));
/* 125 */                     emoniph.intangible.util.BlockUtil.tryHarvestBlock(player.field_70170_p, blockpos2, playerMP, new ItemStack(Items.field_151035_b));
/* 126 */                     blockBroken = true;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/* 132 */           if (blockBroken) {
/* 133 */             playerEx.increaseRebellion();
/* 134 */             if (playerMP.field_70181_x < -1.0D) {
/* 135 */               playerMP.field_70181_x *= 0.9D;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
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
/* 156 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer entity)
/*     */   {
/* 161 */     return false;
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
/* 181 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellMomentum.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */