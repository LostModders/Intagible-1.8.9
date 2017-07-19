/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityMinorWorldEffect;
/*    */ import emoniph.intangible.deity.Deity;
/*    */ import emoniph.intangible.potions.ModPotions;
/*    */ import emoniph.intangible.potions.PotionTank;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MinorEffectResistant implements IDeityMinorWorldEffect
/*    */ {
/*    */   public void onWorldTick(World world, IDeity deity) {}
/*    */   
/*    */   public boolean onEntityJoinWorld(World world, IDeity deity, Entity entity)
/*    */   {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isResistant(World world, IDeity deity)
/*    */   {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public void performPriestEffect(World world, IDeity deity, EntityPlayer player)
/*    */   {
/* 34 */     if (!world.field_72995_K) {
/* 35 */       Get.potions();player.func_70690_d(new PotionEffect(ModPotions.TANK.field_76415_H, TickUtil.fromSeconds(30)));
/*    */     }
/*    */   }
/*    */   
/*    */   public void onHarvest(World world, BlockPos pos, List<ItemStack> drops, EntityPlayer harvester, Deity deity) {}
/*    */   
/*    */   public void onPlayerUseItemFinish(World worldObj, EntityPlayer entityPlayer, ItemStack item, Deity deity) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/MinorEffectResistant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */