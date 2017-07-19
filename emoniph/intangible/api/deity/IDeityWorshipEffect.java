package emoniph.intangible.api.deity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface IDeityWorshipEffect
{
  public abstract void performWorshipEffect(World paramWorld, BlockPos paramBlockPos, EntityLivingBase paramEntityLivingBase, IDeity paramIDeity);
  
  public abstract void performPriestEffect(EntityPlayer paramEntityPlayer, EntityLivingBase paramEntityLivingBase, IDeity paramIDeity);
  
  public abstract boolean customTargetting();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityWorshipEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */