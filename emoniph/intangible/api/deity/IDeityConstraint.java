package emoniph.intangible.api.deity;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface IDeityConstraint
{
  public abstract long getWorshipReductionAfterAttack(EntityPlayer paramEntityPlayer, IDeity paramIDeity, EntityLivingBase paramEntityLivingBase, long paramLong);
  
  public abstract long getWorshipReductionAfterKill(EntityPlayer paramEntityPlayer, IDeity paramIDeity, EntityLivingBase paramEntityLivingBase, long paramLong);
  
  public abstract long getWorshipReductionAfterTick(EntityPlayer paramEntityPlayer, IDeity paramIDeity, long paramLong1, long paramLong2);
  
  public abstract long getWorshipReductionAfterHarvest(EntityPlayer paramEntityPlayer, IDeity paramIDeity, World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, List<ItemStack> paramList, long paramLong);
  
  public abstract long getWorshipReductionAfterWorshipping(EntityPlayer paramEntityPlayer, IDeity paramIDeity1, IDeity paramIDeity2, long paramLong);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityConstraint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */