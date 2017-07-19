package emoniph.intangible.api.deity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface IDeityShrineEffect
{
  public abstract void onTick(World paramWorld, BlockPos paramBlockPos, long paramLong, IDeity paramIDeity);
  
  public abstract void afterWorship(World paramWorld, BlockPos paramBlockPos, EntityPlayer paramEntityPlayer, long paramLong, boolean paramBoolean, IDeity paramIDeity);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityShrineEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */