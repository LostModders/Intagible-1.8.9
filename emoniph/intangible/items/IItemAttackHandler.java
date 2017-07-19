package emoniph.intangible.items;

import emoniph.intangible.Attack;
import emoniph.intangible.player.PlayerEx;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

public abstract interface IItemAttackHandler
{
  public abstract void onHurtBy(ItemStack paramItemStack, PlayerEx paramPlayerEx, LivingHurtEvent paramLivingHurtEvent, Attack paramAttack);
  
  public abstract void onAttacking(ItemStack paramItemStack, PlayerEx paramPlayerEx, LivingHurtEvent paramLivingHurtEvent, Attack paramAttack);
  
  public abstract void onLivingAttack(ItemStack paramItemStack, PlayerEx paramPlayerEx, LivingAttackEvent paramLivingAttackEvent);
  
  public abstract void onLivingDrops(ItemStack paramItemStack, EntityPlayer paramEntityPlayer, LivingDropsEvent paramLivingDropsEvent);
}


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/IItemAttackHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */