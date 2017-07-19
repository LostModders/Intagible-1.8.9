package emoniph.intangible.api;

import java.util.List;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ISoulForgeClient
{
  public abstract boolean isForgeClientValid(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, ISoulForge paramISoulForge);
  
  public abstract boolean isForgeClientActive(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, ISoulForge paramISoulForge);
  
  public abstract boolean forgeClientTick(World paramWorld, BlockPos paramBlockPos, IBlockState paramIBlockState, ISoulForge paramISoulForge);
  
  public abstract List<IBookPageResources> getBookResourcePageIds();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulForgeClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */