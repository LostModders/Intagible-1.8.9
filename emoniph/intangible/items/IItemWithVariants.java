package emoniph.intangible.items;

import net.minecraft.item.ItemStack;

abstract interface IItemWithVariants
{
  public abstract VariantItemData[] getVariants();
  
  public abstract String getUnlocalizedName(ItemStack paramItemStack);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/IItemWithVariants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */