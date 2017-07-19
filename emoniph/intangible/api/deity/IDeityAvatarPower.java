package emoniph.intangible.api.deity;

import emoniph.intangible.api.IAttack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;

public abstract interface IDeityAvatarPower
{
  public abstract void onAttacking(IAvatar paramIAvatar, IAttack paramIAttack, Entity paramEntity);
  
  public abstract void onHurtBy(IAvatar paramIAvatar, IAttack paramIAttack);
  
  public abstract void onTick(IAvatar paramIAvatar);
  
  public abstract void onDeath(IAvatar paramIAvatar, DamageSource paramDamageSource);
  
  public abstract void onGive(IAvatar paramIAvatar, EntityPlayer paramEntityPlayer);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityAvatarPower.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */