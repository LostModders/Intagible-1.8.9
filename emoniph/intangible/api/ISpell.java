package emoniph.intangible.api;

import net.minecraft.entity.player.EntityPlayer;

public abstract interface ISpell
{
  public abstract void invoke(EntityPlayer paramEntityPlayer);
  
  public abstract CastingStyle getCastingStyle(EntityPlayer paramEntityPlayer, boolean paramBoolean);
  
  public abstract ISoulSet getMaintainCost();
  
  public abstract boolean arePrerequisitesMet(EntityPlayer paramEntityPlayer);
  
  public abstract boolean isActive(EntityPlayer paramEntityPlayer);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISpell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */