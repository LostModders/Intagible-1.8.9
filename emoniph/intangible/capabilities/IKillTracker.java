package emoniph.intangible.capabilities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public abstract interface IKillTracker
{
  public abstract void addKill(Entity paramEntity, EntityLivingBase paramEntityLivingBase);
  
  public abstract long getLastKillServerTime();
  
  public abstract long getTicksSinceLastKillFor(EntityLivingBase paramEntityLivingBase);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/capabilities/IKillTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */