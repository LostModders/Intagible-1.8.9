package emoniph.intangible.api.deity;

import java.util.UUID;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public abstract interface IAvatar
{
  public abstract World getAvatarWorld();
  
  public abstract AxisAlignedBB getAvatarBounds();
  
  public abstract boolean attackEntityAsAvatarBasic(EntityLivingBase paramEntityLivingBase, float paramFloat);
  
  public abstract boolean attackEntityAsAvatarNormally(EntityLivingBase paramEntityLivingBase);
  
  public abstract EntityLiving getAvatarEntity();
  
  public abstract UUID getDeityId();
  
  public abstract int getDeityColor();
  
  public abstract int getAttackTimerStandardRight();
  
  public abstract int getAttackTimerStandardLeft();
  
  public abstract int getAttackTimerAOE();
  
  public abstract int getAttackTimerProjectile();
  
  public abstract int getDefenseTimerActivation();
  
  public abstract int getDefenseTimer();
  
  public abstract void addTargetPlayerId(UUID paramUUID);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */