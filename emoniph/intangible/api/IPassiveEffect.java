package emoniph.intangible.api;

import emoniph.intangible.Attack;
import emoniph.intangible.player.FocusedTarget;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract interface IPassiveEffect
{
  public abstract String getLocalizedName();
  
  public abstract ResourceLocation getHudGlyph();
  
  public abstract void startEffectOn(EntityPlayer paramEntityPlayer, boolean paramBoolean);
  
  public abstract void stopEffectOn(EntityPlayer paramEntityPlayer);
  
  public abstract void onAttacking(EntityPlayer paramEntityPlayer, IFocusedTarget paramIFocusedTarget, IAttack paramIAttack, ICooldownManager paramICooldownManager);
  
  public abstract void onHurtBy(EntityPlayer paramEntityPlayer, IFocusedTarget paramIFocusedTarget, IAttack paramIAttack, ICooldownManager paramICooldownManager);
  
  @SideOnly(Side.CLIENT)
  public abstract void onPostRender(EntityPlayer paramEntityPlayer, double paramDouble1, double paramDouble2, double paramDouble3, ICooldownManager paramICooldownManager, boolean paramBoolean);
  
  public abstract void onUpdate(EntityPlayer paramEntityPlayer, ICooldownManager paramICooldownManager);
  
  public abstract void onApplyToNearbyEntities(EntityPlayer paramEntityPlayer, List<Entity> paramList, ICooldownManager paramICooldownManager);
  
  public abstract void augmentArmorProperties(EntityLivingBase paramEntityLivingBase, ISpecialArmor.ArmorProperties paramArmorProperties, ItemStack paramItemStack, DamageSource paramDamageSource, double paramDouble, ICooldownManager paramICooldownManager);
  
  public abstract boolean requiresClientTimer();
  
  public abstract boolean isChanneling(EntityPlayer paramEntityPlayer);
  
  public abstract void onRightClickAir(EntityPlayer paramEntityPlayer);
  
  public abstract void onSwing(EntityPlayer paramEntityPlayer, ICooldownManager paramICooldownManager);
  
  public abstract void onPostRenderTick(EntityPlayer paramEntityPlayer);
  
  public abstract boolean isPrerequisitesMet(EntityPlayer paramEntityPlayer, ItemStack paramItemStack1, ItemStack paramItemStack2, ItemStack paramItemStack3, ItemStack paramItemStack4);
  
  public abstract void onAttackedBy(EntityPlayer paramEntityPlayer, FocusedTarget paramFocusedTarget, Attack paramAttack, ICooldownManager paramICooldownManager);
  
  @SideOnly(Side.CLIENT)
  public abstract void onPreClientTick(EntityPlayer paramEntityPlayer, ICooldownManager paramICooldownManager);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IPassiveEffect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */