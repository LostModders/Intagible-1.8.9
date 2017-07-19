/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityWorshipEffect;
/*    */ import emoniph.intangible.entity.EntityChariot;
/*    */ import emoniph.intangible.items.ModItems;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipEffectChariot implements IDeityWorshipEffect
/*    */ {
/*    */   public void performWorshipEffect(World world, BlockPos pos, EntityLivingBase target, IDeity deity)
/*    */   {
/*    */     EntityItem entityItem;
/* 22 */     if (!world.field_72995_K) {
/* 23 */       int radius = 16;
/* 24 */       List<EntityChariot> list = world.func_72872_a(EntityChariot.class, new AxisAlignedBB(pos.func_177982_a(-radius, -radius / 2, -radius), pos
/* 25 */         .func_177982_a(radius + 1, radius / 2 + 1, radius + 1)));
/* 26 */       if (list.size() == 0) {
/* 27 */         entityItem = new EntityItem(world, pos.func_177958_n() + 0.5F, pos.func_177956_o() + 1.5D, pos.func_177952_p() + 0.5F, new ItemStack(Get.items().CHARIOT));
/* 28 */         entityItem.field_70181_x = 0.0D;
/* 29 */         world.func_72838_d(entityItem);
/* 30 */         entityItem.field_70181_x = 0.0D;
/*    */       } else {
/* 32 */         for (EntityChariot chariot : list) {
/* 33 */           chariot.setHits(0);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void performPriestEffect(EntityPlayer player, EntityLivingBase target, IDeity deity)
/*    */   {
/* 41 */     if (target == player) {
/* 42 */       ItemStack stack = new ItemStack(Get.items().JAVELIN);
/* 43 */       if ((!player.field_70170_p.field_72995_K) && (!player.field_71071_by.func_70441_a(stack))) {
/* 44 */         player.field_70170_p.func_72838_d(new EntityItem(player.field_70170_p, player.field_70165_t, player.field_70163_u + 0.5D, player.field_70161_v, stack));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean customTargetting()
/*    */   {
/* 51 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/WorshipEffectChariot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */