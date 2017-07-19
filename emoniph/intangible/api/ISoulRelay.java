package emoniph.intangible.api;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ISoulRelay
{
  public abstract World getRelayWorld();
  
  public abstract BlockPos getRelayPos();
  
  public abstract boolean isRelayInvalid();
  
  public abstract boolean isRelayActive();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulRelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */