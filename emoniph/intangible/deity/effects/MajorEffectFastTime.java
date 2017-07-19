/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.config.Config;
/*    */ import emoniph.intangible.deity.Deity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MajorEffectFastTime implements emoniph.intangible.api.deity.IDeityMajorWorldEffect
/*    */ {
/*    */   private final int bonusTicksPerTick;
/*    */   private final int timeOfDayStart;
/*    */   private final int timeOfDayEnd;
/*    */   private final boolean reversed;
/*    */   
/*    */   public MajorEffectFastTime(int bonusTicksPerTick, int timeOfDayStart, int timeOfDayEnd)
/*    */   {
/* 22 */     this.bonusTicksPerTick = bonusTicksPerTick;
/* 23 */     this.timeOfDayStart = timeOfDayStart;
/* 24 */     this.timeOfDayEnd = timeOfDayEnd;
/* 25 */     this.reversed = (timeOfDayStart > timeOfDayEnd);
/*    */   }
/*    */   
/*    */   public void onWorldTick(World world, IDeity deity) {
/* 29 */     if ((world != null) && (world.func_82736_K().func_82766_b("doDaylightCycle"))) {
/* 30 */       long timeOfDay = world.func_72820_D() % 24000L;
/* 31 */       if (this.reversed) {
/* 32 */         if ((timeOfDay >= this.timeOfDayStart + Get.config().FAST_TIME_NIGHT_START_OFFSET_TICKS) || (timeOfDay <= this.timeOfDayEnd)) {
/* 33 */           world.func_72877_b(world.func_72820_D() + this.bonusTicksPerTick);
/*    */         }
/*    */       }
/* 36 */       else if ((timeOfDay >= this.timeOfDayStart + Get.config().FAST_TIME_DAY_START_OFFSET_TICKS) && (timeOfDay <= this.timeOfDayEnd)) {
/* 37 */         world.func_72877_b(world.func_72820_D() + this.bonusTicksPerTick);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean onEntityJoinWorld(World world, IDeity deity, Entity entity)
/*    */   {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public void onHarvest(World world, BlockPos pos, java.util.List<ItemStack> drops, EntityPlayer harvester, Deity deity) {}
/*    */   
/*    */   public void onPlayerUseItemFinish(World worldObj, EntityPlayer entityPlayer, ItemStack item, Deity topDeity) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/MajorEffectFastTime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */