package emoniph.intangible.api.deity;

import java.util.Iterator;

public abstract interface IDeityList
  extends Iterable<IDeity>
{
  public abstract int size();
  
  public abstract Iterator<IDeity> iterator();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */