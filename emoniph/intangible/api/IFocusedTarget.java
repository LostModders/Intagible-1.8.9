package emoniph.intangible.api;

import net.minecraft.entity.EntityLivingBase;

public abstract interface IFocusedTarget
{
  public abstract EntityLivingBase getTarget();
  
  public abstract int getConsecutiveHits();
  
  public abstract void resetHitCount();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IFocusedTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */