package emoniph.intangible.api;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

public abstract interface IMold
{
  public abstract FluidStack getRequiredFluid(ItemStack paramItemStack);
  
  public abstract ItemStack getResultForFluid(FluidStack paramFluidStack);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IMold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */