package emoniph.intangible.api.golem;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract interface IGolemBody
{
  public abstract void onUpdate(IGolem paramIGolem, BlockPos paramBlockPos);
  
  @SideOnly(Side.CLIENT)
  public abstract ResourceLocation getTexture();
  
  @SideOnly(Side.CLIENT)
  public abstract ModelRenderer getModel();
  
  @SideOnly(Side.CLIENT)
  public abstract void updateModelRotation(EntityLiving paramEntityLiving, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt);
  
  public abstract float getHealthBonus();
  
  public abstract int getArmorBonus();
  
  public abstract boolean seatRiderInteract(EntityLiving paramEntityLiving, EntityPlayer paramEntityPlayer);
  
  public abstract boolean requiresSeat();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/golem/IGolemBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */