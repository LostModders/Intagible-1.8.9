package emoniph.intangible.client.particle;

import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public abstract interface IBatchParticle
{
  public abstract void renderParticle(WorldRenderer paramWorldRenderer);
  
  public abstract boolean isParticleAlive();
  
  public abstract ResourceLocation getTextureLocation();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/particle/IBatchParticle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */