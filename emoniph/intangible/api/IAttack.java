package emoniph.intangible.api;

import net.minecraft.util.DamageSource;

public abstract interface IAttack
{
  public abstract DamageSource getOriginalDamageSource();
  
  public abstract float getOriginalDamage();
  
  public abstract DamageSource getDamageSource();
  
  public abstract void setDamageSource(DamageSource paramDamageSource);
  
  public abstract float getDamage();
  
  public abstract void setDamage(float paramFloat);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IAttack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */