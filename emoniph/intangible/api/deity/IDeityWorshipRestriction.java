package emoniph.intangible.api.deity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface IDeityWorshipRestriction
{
  public abstract boolean isWorshipAllowed(World paramWorld, BlockPos paramBlockPos, EntityPlayer paramEntityPlayer);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityWorshipRestriction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */