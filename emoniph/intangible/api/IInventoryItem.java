package emoniph.intangible.api;

import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface IInventoryItem
{
  public abstract ItemStack getStackInSlot();
  
  public abstract ItemStack decrStackInSlot(int paramInt);
  
  public abstract void reserve();
  
  public abstract void rollback(World paramWorld, BlockPos paramBlockPos);
  
  public abstract void commit();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IInventoryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */