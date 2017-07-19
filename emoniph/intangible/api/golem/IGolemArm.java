package emoniph.intangible.api.golem;

import emoniph.intangible.api.BodySide;
import emoniph.intangible.api.IFakePlayerProvider;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract interface IGolemArm
{
  public abstract int getCooldownTicks();
  
  public abstract boolean onUseAction(World paramWorld, EntityPlayer paramEntityPlayer, EntityLiving paramEntityLiving, IFakePlayerProvider paramIFakePlayerProvider, BlockPos paramBlockPos, BodySide paramBodySide);
  
  public abstract boolean canSwing();
  
  public abstract boolean canPoint();
  
  public abstract boolean canStartBlocks();
  
  @SideOnly(Side.CLIENT)
  public abstract ResourceLocation getTexture(BodySide paramBodySide);
  
  @SideOnly(Side.CLIENT)
  public abstract ModelRenderer getModel(BodySide paramBodySide);
  
  @SideOnly(Side.CLIENT)
  public abstract void updateModelRotation(EntityLiving paramEntityLiving, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, BodySide paramBodySide);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/golem/IGolemArm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */