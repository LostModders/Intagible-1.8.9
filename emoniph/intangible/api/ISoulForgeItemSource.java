package emoniph.intangible.api;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ISoulForgeItemSource
{
  public abstract IInventoryItem getSoulForgeItemStack(World paramWorld, BlockPos paramBlockPos1, ISoulForgeClient paramISoulForgeClient, BlockPos paramBlockPos2, ISoulForge paramISoulForge, boolean paramBoolean);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulForgeItemSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */