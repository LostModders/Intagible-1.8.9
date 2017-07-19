package emoniph.intangible.entity.ai;

import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;

public abstract interface IDefender
{
  public abstract EntityCreature getDefenderCreature();
  
  public abstract boolean hasOwner();
  
  public abstract List<EntityLivingBase> getOwnerEntities();
  
  public abstract boolean func_142018_a(EntityLivingBase paramEntityLivingBase1, EntityLivingBase paramEntityLivingBase2);
  
  public abstract boolean isSitting();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/ai/IDefender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */