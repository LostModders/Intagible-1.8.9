package emoniph.intangible.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public abstract interface IBellowsClient
{
  public abstract void bellowsTick(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, EnumFacing paramEnumFacing);
  
  public abstract void bellowsComplete(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, EnumFacing paramEnumFacing);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IBellowsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */