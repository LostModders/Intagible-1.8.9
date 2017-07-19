package emoniph.intangible.api.deity;

import java.util.UUID;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public abstract interface IDeity
{
  public abstract UUID getId();
  
  public abstract String getName();
  
  public abstract World getWorld();
  
  public abstract int getCurrentWorship();
  
  public abstract void talkToWorld(World paramWorld, String paramString);
  
  public abstract void manifest(World paramWorld, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5);
  
  public abstract IAvatar summonAvatarAtPos(World paramWorld, double paramDouble1, double paramDouble2, double paramDouble3);
  
  public abstract ItemStack getSacredItemA();
  
  public abstract ItemStack getSacredItemB();
  
  public abstract ItemStack getSacredItemC();
  
  public abstract IDeityMajorWorldEffect getMajorEffect();
  
  public abstract IDeityMinorWorldEffect getMinorEffect();
  
  public abstract IDeityWorshipEffect getBlessingEffect();
  
  public abstract IDeityWorshipEffect getCurseEffect();
  
  public abstract int getColor();
  
  public abstract void talkAt(EntityPlayer paramEntityPlayer);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */