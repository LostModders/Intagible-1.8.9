package emoniph.intangible.api;

import net.minecraft.item.ItemStack;

public abstract interface IBookPageResources
{
  public abstract String getPageId();
  
  public abstract String getTitleId();
  
  public abstract String getContentResourceId();
  
  public abstract ItemStack getStack();
  
  public abstract IKnol[] getKnowledge();
  
  public abstract ISoulSet getUsedSouls();
  
  public abstract ISoulSet getConsumedSouls();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IBookPageResources.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */