package emoniph.intangible.api;

public abstract interface ILearning
  extends Iterable<IKnol>
{
  public abstract boolean contains(IKnol paramIKnol);
  
  public abstract boolean containedBy(ILearning paramILearning);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ILearning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */