package emoniph.intangible.api;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface ITriggerClient
{
  public abstract void onTriggeredBySpell(World paramWorld1, BlockPos paramBlockPos1, IBlockState paramIBlockState, World paramWorld2, BlockPos paramBlockPos2, EntityPlayer paramEntityPlayer);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ITriggerClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */