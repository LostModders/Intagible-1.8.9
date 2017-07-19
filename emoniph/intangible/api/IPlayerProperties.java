package emoniph.intangible.api;

import net.minecraft.util.Vec3;

public abstract interface IPlayerProperties
{
  public abstract boolean enableEffect(IPassiveEffect paramIPassiveEffect);
  
  public abstract void disableEffect(IPassiveEffect paramIPassiveEffect);
  
  public abstract void learnKnowledge(Vec3 paramVec3, IKnol... paramVarArgs);
  
  public abstract boolean isKnowledgeLearnt(IKnol... paramVarArgs);
  
  public abstract void recalculateArmorCapacity();
  
  public abstract void increaseRebellion(IPassiveEffect paramIPassiveEffect);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IPlayerProperties.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */