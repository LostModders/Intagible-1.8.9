package emoniph.intangible.deity;

import emoniph.intangible.api.deity.IDeity;
import java.util.UUID;
import net.minecraft.world.World;

public abstract interface IPlayerWorship
{
  public abstract boolean isFollowerOf(World paramWorld, IDeity paramIDeity);
  
  public abstract boolean isFollowerOf(World paramWorld, UUID paramUUID);
  
  public abstract boolean isDevoutFollowerOf(World paramWorld, IDeity paramIDeity);
  
  public abstract boolean isDevoutFollowerOf(World paramWorld, UUID paramUUID);
  
  public abstract boolean isMostWorshippedDeity(World paramWorld, IDeity paramIDeity);
  
  public abstract boolean isMostWorshippedDeity(World paramWorld, UUID paramUUID);
  
  public abstract boolean isWorshipEqualOrGreaterThan(World paramWorld, IDeity paramIDeity, int paramInt);
  
  public abstract UUID getDevoutDeityId(World paramWorld);
  
  public abstract long getWorshipFor(World paramWorld, IDeity paramIDeity);
  
  public abstract long getWorshipFor(World paramWorld, UUID paramUUID);
  
  public abstract long getLastGiftTime(World paramWorld, UUID paramUUID);
  
  public abstract void setLastGiftTime(World paramWorld, UUID paramUUID, long paramLong);
  
  public abstract int getFollowerLevelOf(World paramWorld, IDeity paramIDeity);
  
  public abstract int getFollowerLevelOf(World paramWorld, UUID paramUUID);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/IPlayerWorship.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */