package emoniph.intangible.api;

public abstract interface ICooldownManager
{
  public abstract void setCooldown(IPassiveEffect paramIPassiveEffect, int paramInt);
  
  public abstract boolean isCooldownActive(IPassiveEffect paramIPassiveEffect);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ICooldownManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */