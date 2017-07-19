package emoniph.intangible.blocks;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;

public abstract interface IMultiBlock
{
  public abstract BlockPos getMultiBlockCorePos(IBlockAccess paramIBlockAccess, BlockPos paramBlockPos, IBlockState paramIBlockState);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/IMultiBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */