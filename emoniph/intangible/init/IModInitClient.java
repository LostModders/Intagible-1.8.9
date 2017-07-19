package emoniph.intangible.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract interface IModInitClient
{
  @SideOnly(Side.CLIENT)
  public abstract void init(Minecraft paramMinecraft, RenderItem paramRenderItem);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/init/IModInitClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */