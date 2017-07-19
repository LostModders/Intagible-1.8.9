package emoniph.intangible.api;

import net.minecraft.item.ItemStack;

public abstract interface IBookPage
{
  public abstract IBookPage title(String paramString);
  
  public abstract IBookPage knowledge(IKnol... paramVarArgs);
  
  public abstract IBookPage para(String paramString);
  
  public abstract IBookPage para(String paramString, boolean paramBoolean);
  
  public abstract IBookPage image(String paramString, int paramInt1, int paramInt2);
  
  public abstract IBookPage image(ItemStack paramItemStack);
  
  public abstract IBookPage consumedSouls(ISoulSet paramISoulSet);
  
  public abstract IBookPage usedSouls(ISoulSet paramISoulSet);
  
  public abstract IBookPage createPage(String paramString, PageType paramPageType);
  
  public abstract IBookPage createPage(String paramString, PageType paramPageType, ItemStack paramItemStack);
  
  public abstract IBookPage createPage(String paramString, PageType paramPageType, IMultiBlockPlan paramIMultiBlockPlan);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IBookPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */