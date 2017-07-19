package emoniph.intangible.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ISoulShell
{
  public abstract World getWorld();
  
  public abstract BlockPos getPos();
  
  public abstract boolean isInvalid();
  
  public abstract boolean isActive();
  
  public abstract boolean isOwner(EntityPlayer paramEntityPlayer);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */