package emoniph.intangible.api.deity;

import emoniph.intangible.api.IAttack;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract interface IDeityAvatarBody
{
  @SideOnly(Side.CLIENT)
  public abstract ResourceLocation getTexture(IAvatar paramIAvatar);
  
  @SideOnly(Side.CLIENT)
  public abstract ModelBase getModel(IAvatar paramIAvatar);
  
  @SideOnly(Side.CLIENT)
  public abstract void spawnParticles(IAvatar paramIAvatar);
  
  @SideOnly(Side.CLIENT)
  public abstract float[] getHeadOffset(IAvatar paramIAvatar);
  
  @SideOnly(Side.CLIENT)
  public abstract float getRenderAlpha(IAvatar paramIAvatar);
  
  @SideOnly(Side.CLIENT)
  public abstract float getGlintAlpha(IAvatar paramIAvatar);
  
  @SideOnly(Side.CLIENT)
  public abstract void applyRenderTransforms(IAvatar paramIAvatar);
  
  public abstract float getHealthRegenPerTick(IAvatar paramIAvatar);
  
  public abstract int getTeleportCooldownTicks(IAvatar paramIAvatar);
  
  public abstract float getDamageFor(IAvatar paramIAvatar, Entity paramEntity);
  
  public abstract int getKnockbackModifierFor(IAvatar paramIAvatar, Entity paramEntity);
  
  public abstract float getLaunchSpeedFor(IAvatar paramIAvatar, Entity paramEntity);
  
  public abstract int getFireAspectModifierFor(IAvatar paramIAvatar, Entity paramEntity);
  
  public abstract float getProjectileMinRangeSq(IAvatar paramIAvatar);
  
  public abstract int getProjectileCooldownTicks(IAvatar paramIAvatar);
  
  public abstract void performAttackProjectile(IAvatar paramIAvatar, EntityLivingBase paramEntityLivingBase, float paramFloat);
  
  public abstract double getAttackRangeAOE(IAvatar paramIAvatar);
  
  public abstract void performAttackAOE(IAvatar paramIAvatar);
  
  public abstract int getAttackAnimationTicksAOE(IAvatar paramIAvatar);
  
  public abstract int getAttackAnimationTicksProjectile(IAvatar paramIAvatar);
  
  public abstract boolean shouldDefenseCountdownActivate(IAvatar paramIAvatar);
  
  public abstract int getDefenseActivationTicks(IAvatar paramIAvatar);
  
  public abstract int getDefenseDurationTicks(IAvatar paramIAvatar);
  
  public abstract void onDefenseStart(IAvatar paramIAvatar);
  
  public abstract void onDefenseTick(IAvatar paramIAvatar);
  
  public abstract void onDefenseHurtBy(IAvatar paramIAvatar, IAttack paramIAttack);
  
  public abstract void onDefenseStop(IAvatar paramIAvatar);
  
  public abstract int getTotalArmorValue();
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/deity/IDeityAvatarBody.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */