/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityMajorWorldEffect;
/*    */ import emoniph.intangible.deity.Deity;
/*    */ import emoniph.intangible.util.CropUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MajorEffectBumperHarvest
/*    */   implements IDeityMajorWorldEffect
/*    */ {
/*    */   public void onWorldTick(World world, IDeity deity) {}
/*    */   
/*    */   public boolean onEntityJoinWorld(World world, IDeity deity, Entity entity)
/*    */   {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void onHarvest(World world, BlockPos pos, List<ItemStack> drops, EntityPlayer harvester, Deity deity)
/*    */   {
/* 35 */     boolean isFullMoon = world.func_130001_d() == 0.0D;
/* 36 */     List<ItemStack> bonus = new ArrayList();
/* 37 */     for (Iterator<ItemStack> itr = drops.iterator(); itr.hasNext();) {
/* 38 */       ItemStack stack = (ItemStack)itr.next();
/* 39 */       if (CropUtil.isCrop(stack)) {
/* 40 */         if (isFullMoon) {
/* 41 */           itr.remove();
/*    */         } else {
/* 43 */           bonus.add(stack.func_77946_l());
/*    */         }
/*    */       }
/*    */     }
/* 47 */     drops.addAll(bonus);
/*    */   }
/*    */   
/*    */   public void onPlayerUseItemFinish(World worldObj, EntityPlayer entityPlayer, ItemStack item, Deity topDeity) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/MajorEffectBumperHarvest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */