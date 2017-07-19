package emoniph.intangible.api.golem;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public abstract interface IGolem
{
  public abstract boolean tryAddEntityItemToGolemInventory(EntityItem paramEntityItem);
  
  public abstract World getGolemWorld();
  
  public abstract AxisAlignedBB getGolemBoundingBox();
  
  public abstract int getGolemTicksExisted();
  
  public abstract void healGolem(float paramFloat);
  
  public abstract double getGolemX();
  
  public abstract double getGolemY();
  
  public abstract double getGolemZ();
  
  public abstract boolean tryRemoveItemFromInventory(ItemStack paramItemStack);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/golem/IGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */