/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityConstraint;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ConstraintNoKilling implements IDeityConstraint
/*    */ {
/*    */   public long getWorshipReductionAfterAttack(EntityPlayer player, IDeity deity, EntityLivingBase target, long totalTicks)
/*    */   {
/* 18 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterKill(EntityPlayer player, IDeity deity, EntityLivingBase target, long totalTicks)
/*    */   {
/* 23 */     if (((target instanceof EntityVillager)) || ((target instanceof EntityPlayer))) {
/* 24 */       return 1L;
/*    */     }
/* 26 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterTick(EntityPlayer player, IDeity deity, long lastWorshipTime, long totalTicks)
/*    */   {
/* 31 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterHarvest(EntityPlayer player, IDeity deity, World world, BlockPos pos, IBlockState state, List<ItemStack> drops, long totalTicks)
/*    */   {
/* 36 */     return 0L;
/*    */   }
/*    */   
/*    */   public long getWorshipReductionAfterWorshipping(EntityPlayer player, IDeity deity, IDeity worshippedDeity, long totalTicks)
/*    */   {
/* 41 */     return 0L;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/ConstraintNoKilling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */