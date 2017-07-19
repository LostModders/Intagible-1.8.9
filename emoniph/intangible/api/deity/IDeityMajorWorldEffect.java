package emoniph.intangible.api.deity;

import emoniph.intangible.deity.Deity;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public abstract interface IDeityMajorWorldEffect
{
  public abstract void onWorldTick(World paramWorld, IDeity paramIDeity);
  
  public abstract boolean onEntityJoinWorld(World paramWorld, IDeity paramIDeity, Entity paramEntity);
  
  public abstract void onHarvest(World paramWorld, BlockPos paramBlockPos, List<ItemStack> paramList, EntityPlayer paramEntityPlayer, Deity paramDeity);
  
  public abstract void onPlayerUseItemFinish(World paramWorld, EntityPlayer paramEntityPlayer, ItemStack paramItemStack, Deity paramDeity);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityMajorWorldEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */