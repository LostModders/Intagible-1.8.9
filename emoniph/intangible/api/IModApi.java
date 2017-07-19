package emoniph.intangible.api;

import emoniph.intangible.api.deity.IDeityAvatarBody;
import emoniph.intangible.api.deity.IDeityAvatarPower;
import emoniph.intangible.api.deity.IDeityList;
import emoniph.intangible.api.deity.IDeityMajorWorldEffect;
import emoniph.intangible.api.deity.IDeityMinorWorldEffect;
import emoniph.intangible.api.deity.IDeityShrineEffect;
import emoniph.intangible.api.deity.IDeityWorshipEffect;
import emoniph.intangible.api.golem.IGolemArm;
import emoniph.intangible.api.golem.IGolemBody;
import emoniph.intangible.api.golem.IGolemHead;
import emoniph.intangible.api.golem.IGolemLeg;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public abstract interface IModApi
{
  public abstract String getModId();
  
  public abstract IPlayerProperties getPropertiesFor(EntityPlayer paramEntityPlayer);
  
  public abstract ISoulSet createSoulSet();
  
  public abstract void registerPassiveEffect(String paramString, IPassiveEffect paramIPassiveEffect, ISoulSet paramISoulSet);
  
  public abstract IDeityList getDeitiesForWorld(World paramWorld);
  
  public abstract void registerDeityEffect(String paramString, IDeityMajorWorldEffect paramIDeityMajorWorldEffect, ItemStack paramItemStack, ISoulSet paramISoulSet);
  
  public abstract void registerDeityEffect(String paramString, IDeityMinorWorldEffect paramIDeityMinorWorldEffect, ItemStack paramItemStack, ISoulSet paramISoulSet);
  
  public abstract void registerDeityEffect(String paramString, IDeityWorshipEffect paramIDeityWorshipEffect, ItemStack paramItemStack, ISoulSet paramISoulSet);
  
  public abstract void registerDeityEffect(String paramString, IDeityShrineEffect paramIDeityShrineEffect, ItemStack paramItemStack, ISoulSet paramISoulSet);
  
  public abstract void registerAvatarPower(String paramString, IDeityAvatarPower paramIDeityAvatarPower, ItemStack paramItemStack, ISoulSet paramISoulSet);
  
  public abstract void registerAvatarBody(String paramString, IDeityAvatarBody paramIDeityAvatarBody, ItemStack paramItemStack, ISoulSet paramISoulSet);
  
  public abstract void registerEntitySoulType(Class<? extends EntityLiving> paramClass, SoulType paramSoulType, boolean paramBoolean);
  
  public abstract IKnol registerKnowledge(String paramString);
  
  public abstract ILearning knowledgeOf(IKnol... paramVarArgs);
  
  public abstract IBookPage createBookIndex(String paramString);
  
  public abstract void addStampingRecipe(ItemStack paramItemStack1, ItemStack paramItemStack2, ItemStack paramItemStack3, ItemStack paramItemStack4, ItemStack paramItemStack5);
  
  public abstract ISpell registerSpell(String paramString1, ISpell paramISpell, ILearning paramILearning, ISoulSet paramISoulSet, int paramInt1, String paramString2, int paramInt2, int paramInt3, ResourceLocation paramResourceLocation);
  
  public abstract ISpell registerSpell(IPassiveEffect paramIPassiveEffect, ILearning paramILearning, ISoulSet paramISoulSet, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract IGolemArm registerGolemArm(IGolemArm paramIGolemArm, ItemStack paramItemStack);
  
  public abstract IGolemLeg registerGolemLeg(IGolemLeg paramIGolemLeg, ItemStack paramItemStack);
  
  public abstract IGolemBody registerGolemBody(IGolemBody paramIGolemBody, ItemStack paramItemStack);
  
  public abstract IGolemHead registerGolemHead(IGolemHead paramIGolemHead, ItemStack paramItemStack);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/IModApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */