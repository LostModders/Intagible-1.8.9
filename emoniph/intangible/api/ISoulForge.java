package emoniph.intangible.api;

import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ISoulForge
{
  public abstract BlockPos getPos();
  
  public abstract IInventoryItem requestItemFromInventory(ItemStack paramItemStack);
  
  public abstract boolean requestSoulsForWork(ISoulSet paramISoulSet, int paramInt, World paramWorld, BlockPos paramBlockPos);
  
  public abstract boolean requestSoulsForConsumption(ISoulSet paramISoulSet, World paramWorld, BlockPos paramBlockPos);
  
  public abstract void spawnItemDramatically(ItemStack paramItemStack, BlockPos paramBlockPos1, BlockPos[] paramArrayOfBlockPos, World paramWorld, BlockPos paramBlockPos2, int paramInt);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */