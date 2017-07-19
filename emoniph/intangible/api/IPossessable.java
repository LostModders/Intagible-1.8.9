package emoniph.intangible.api;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

public abstract interface IPossessable
{
  public abstract boolean canBePossessedBy(EntityPlayer paramEntityPlayer);
  
  public abstract boolean onAttackAction(EntityPlayer paramEntityPlayer, BlockPos paramBlockPos);
  
  public abstract boolean onUseAction(EntityPlayer paramEntityPlayer, BlockPos paramBlockPos);
  
  public abstract boolean allowFirstPersonRender();
  
  public abstract void onJumpKey(EntityPlayer paramEntityPlayer);
  
  public abstract void possessBy(EntityPlayer paramEntityPlayer);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IPossessable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */