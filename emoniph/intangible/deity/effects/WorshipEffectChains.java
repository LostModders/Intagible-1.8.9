/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipEffectChains implements emoniph.intangible.api.deity.IDeityWorshipEffect
/*    */ {
/*    */   public void performWorshipEffect(World world, BlockPos pos, EntityLivingBase target, IDeity deity)
/*    */   {
/* 15 */     target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 3600, 2, true, false));
/* 16 */     target.func_70690_d(new PotionEffect(Potion.field_76419_f.field_76415_H, 1200, 1, true, false));
/*    */   }
/*    */   
/*    */   public void performPriestEffect(EntityPlayer player, EntityLivingBase target, IDeity deity)
/*    */   {
/* 21 */     switch (player.field_70170_p.field_73012_v.nextInt(3)) {
/*    */     default: 
/* 23 */       target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 1200, 0, true, false));
/* 24 */       break;
/*    */     case 1: 
/* 26 */       target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 800, 1, true, false));
/* 27 */       break;
/*    */     case 2: 
/* 29 */       target.func_70690_d(new PotionEffect(Potion.field_76421_d.field_76415_H, 400, 2, true, false));
/*    */     }
/*    */     
/*    */   }
/*    */   
/*    */   public boolean customTargetting()
/*    */   {
/* 36 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/WorshipEffectChains.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */