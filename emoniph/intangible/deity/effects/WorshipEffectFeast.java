/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.util.CropUtil;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipEffectFeast implements emoniph.intangible.api.deity.IDeityWorshipEffect
/*    */ {
/*    */   public void performWorshipEffect(World world, BlockPos pos, EntityLivingBase target, IDeity deity)
/*    */   {
/* 17 */     if (!world.field_72995_K) {
/* 18 */       EntityItem entityItem = new EntityItem(world, pos.func_177958_n() + 0.5F, pos.func_177956_o() + 1.5D, pos.func_177952_p() + 0.5F, new ItemStack(emoniph.intangible.Get.items().CORNUCOPIA));
/* 19 */       entityItem.field_70181_x = 0.0D;
/* 20 */       world.func_72838_d(entityItem);
/* 21 */       entityItem.field_70181_x = 0.0D;
/*    */     }
/*    */   }
/*    */   
/*    */   public void performPriestEffect(EntityPlayer player, EntityLivingBase target, IDeity deity)
/*    */   {
/* 27 */     if (!player.field_70170_p.field_72995_K) {
/* 28 */       if ((target instanceof EntityPlayer)) {
/* 29 */         EntityPlayer other = (EntityPlayer)target;
/* 30 */         other.field_71071_by.func_70441_a(CropUtil.getRandomFood(player.field_70170_p.field_73012_v).func_77946_l());
/* 31 */         if ((player == target) && (player.field_70170_p.field_73012_v.nextInt(3) == 0)) {
/* 32 */           other.field_71071_by.func_70441_a(CropUtil.getRandomFood(player.field_70170_p.field_73012_v).func_77946_l());
/*    */         }
/*    */       } else {
/* 35 */         player.field_70170_p.func_72838_d(new EntityItem(player.field_70170_p, target.field_70165_t, target.field_70163_u + 0.5D, target.field_70161_v, CropUtil.getRandomFood(player.field_70170_p.field_73012_v).func_77946_l()));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean customTargetting()
/*    */   {
/* 42 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/WorshipEffectFeast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */