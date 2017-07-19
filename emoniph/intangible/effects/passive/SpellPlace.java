/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.server.management.ItemInWorldManager;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellPlace implements emoniph.intangible.api.IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  29 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:place");
/*     */   }
/*     */   
/*  32 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_place.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  36 */     return GLYPH;
/*     */   }
/*     */   
/*     */   public void startEffectOn(EntityPlayer player, boolean initialTrigger)
/*     */   {
/*  41 */     if (!player.field_70170_p.field_72995_K) {
/*  42 */       EntityPlayerMP playerMP = (EntityPlayerMP)player;
/*  43 */       playerMP.field_71134_c.setBlockReachDistance(20.0D);
/*     */     }
/*     */   }
/*     */   
/*     */   public void stopEffectOn(EntityPlayer player)
/*     */   {
/*  49 */     if (!player.field_70170_p.field_72995_K) {
/*  50 */       EntityPlayerMP playerMP = (EntityPlayerMP)player;
/*  51 */       playerMP.field_71134_c.setBlockReachDistance(5.0D);
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
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
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
/*     */   public void augmentArmorProperties(EntityLivingBase player, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer player)
/*     */   {
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public void onRightClickAir(EntityPlayer player)
/*     */   {
/*  95 */     if ((!player.field_70170_p.field_72995_K) && (player.func_70093_af()) && (player.func_70694_bm() != null)) {
/*  96 */       net.minecraft.util.MovingObjectPosition hitBlock = emoniph.intangible.util.RayTraceUtil.traceBlock(player, true, 2.0D);
/*  97 */       if (hitBlock == null) {
/*  98 */         ItemStack stack = player.func_70694_bm();
/*  99 */         Vec3 look = player.func_70676_i(2.0F);
/*     */         
/* 101 */         BlockPos pos = new BlockPos(player.field_70165_t + look.field_72450_a, player.field_70163_u + player.func_70047_e() + look.field_72448_b, player.field_70161_v + look.field_72449_c);
/*     */         
/* 103 */         if ((stack.func_77973_b() instanceof ItemBlock)) {
/* 104 */           ItemBlock blockItem = (ItemBlock)stack.func_77973_b();
/* 105 */           Block block = player.field_70170_p.func_180495_p(pos).func_177230_c();
/*     */           
/* 107 */           EnumFacing side = EnumFacing.DOWN;
/* 108 */           if ((block == net.minecraft.init.Blocks.field_150431_aC) && (block.func_176200_f(player.field_70170_p, pos))) {
/* 109 */             side = EnumFacing.UP;
/* 110 */           } else if (!block.func_176200_f(player.field_70170_p, pos)) {
/* 111 */             pos = pos.func_177972_a(side);
/*     */           }
/*     */           
/* 114 */           if (player.field_70170_p.func_175716_a(block, pos, false, side, (Entity)null, stack))
/*     */           {
/* 116 */             blockItem.func_180614_a(stack, player, player.field_70170_p, pos, EnumFacing.DOWN, 0.0F, 0.0F, 0.0F);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
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
/* 136 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellPlace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */