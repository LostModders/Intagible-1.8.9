package emoniph.intangible.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ISoulForgeInventory
{
  public abstract boolean isForgeInventoryValid(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, ISoulForge paramISoulForge);
  
  public abstract IInventoryItem requestItemFromInventory(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, ItemStack paramItemStack, ISoulForge paramISoulForge);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulForgeInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */