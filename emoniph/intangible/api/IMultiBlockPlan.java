package emoniph.intangible.api;

import net.minecraft.item.ItemStack;

public abstract interface IMultiBlockPlan
{
  public abstract ItemStack[][][] getPlan();
  
  public abstract float getPlanRenderScale();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IMultiBlockPlan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */