package emoniph.intangible.api;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ISoulWell
{
  public abstract World getWellWorld();
  
  public abstract BlockPos getWellPos();
  
  public abstract boolean isWellInvalid();
  
  public abstract boolean isWellActive();
  
  public abstract boolean tryUseSouls(ISoulSet paramISoulSet, int paramInt);
  
  public abstract boolean tryTakeSouls(ISoulSet paramISoulSet);
  
  public abstract ISoulSet reportAvailableSoulsFrom(ISoulSet paramISoulSet);
  
  public abstract void add(ISoulSet paramISoulSet);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulWell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */