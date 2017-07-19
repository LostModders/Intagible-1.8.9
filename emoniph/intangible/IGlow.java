package emoniph.intangible;

public abstract interface IGlow
{
  public abstract IGlow motion(double paramDouble1, double paramDouble2, double paramDouble3);
  
  public abstract IGlow acceleration(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract IGlow color(int paramInt);
  
  public abstract IGlow color(int paramInt1, int paramInt2);
  
  public abstract IGlow color(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract IGlow color(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract IGlow scale(float paramFloat);
  
  public abstract IGlow scaleExact(float paramFloat);
  
  public abstract IGlow duration(int paramInt);
  
  public abstract IGlow durationScale(float paramFloat);
  
  public abstract IGlow dampening(float paramFloat);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/IGlow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */