/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityConstraint;
/*    */ import emoniph.intangible.capabilities.CapabilityKillTracker;
/*    */ import emoniph.intangible.capabilities.IKillTracker;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ConstraintMustKill implements IDeityConstraint
/*    */ {
/*    */   public long getWorshipReductionAfterAttack(EntityPlayer player, IDeity deity, EntityLivingBase target, long totalTicks)
/*    */   {
/* 19 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterKill(EntityPlayer player, IDeity deity, EntityLivingBase target, long totalTicks)
/*    */   {
/* 24 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterTick(EntityPlayer player, IDeity deity, long lastWorshipTime, long totalTicks)
/*    */   {
/* 29 */     if ((!player.field_70170_p.field_72995_K) && (player.field_70173_aa % 100 == 1) && 
/* 30 */       (((IKillTracker)player.getCapability(CapabilityKillTracker.KILL_TRACKER_CAPABILITY, net.minecraft.util.EnumFacing.UP)).getLastKillServerTime() + 24000L < totalTicks)) {
/* 31 */       return 1L;
/*    */     }
/*    */     
/* 34 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterHarvest(EntityPlayer player, IDeity deity, World world, BlockPos pos, IBlockState state, List<ItemStack> drops, long totalTicks)
/*    */   {
/* 39 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterWorshipping(EntityPlayer player, IDeity deity, IDeity worshippedDeity, long totalTicks)
/*    */   {
/* 44 */     return 0L;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/ConstraintMustKill.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */