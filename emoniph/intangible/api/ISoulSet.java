package emoniph.intangible.api;

public abstract interface ISoulSet
{
  public abstract ISoulSet add(SoulType paramSoulType, int paramInt);
  
  public abstract ISoulSet add(ISoulSet paramISoulSet);
  
  public abstract int quantityOf(SoulType paramSoulType);
  
  public abstract boolean isEmpty();
  
  public abstract boolean equalTo(ISoulSet paramISoulSet);
  
  public abstract int size();
  
  public abstract int types();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ISoulSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */