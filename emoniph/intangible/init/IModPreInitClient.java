package emoniph.intangible.init;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract interface IModPreInitClient
{
  @SideOnly(Side.CLIENT)
  public abstract void preInit(Minecraft paramMinecraft);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/init/IModPreInitClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */