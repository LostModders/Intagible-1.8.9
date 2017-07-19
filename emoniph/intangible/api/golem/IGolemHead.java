package emoniph.intangible.api.golem;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract interface IGolemHead
{
  public abstract float getHealthBonus();
  
  public abstract void onUpdate(IGolem paramIGolem, BlockPos paramBlockPos);
  
  @SideOnly(Side.CLIENT)
  public abstract ResourceLocation getTexture();
  
  @SideOnly(Side.CLIENT)
  public abstract ModelRenderer getModel();
  
  public abstract int getArmorBonus();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/golem/IGolemHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */