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
/*    */ public class WorshipEffectStoneWall implements emoniph.intangible.api.deity.IDeityWorshipEffect
/*    */ {
/*    */   public void performWorshipEffect(World world, BlockPos pos, EntityLivingBase target, IDeity deity)
/*    */   {
/* 15 */     target.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 6000, 1, true, false));
/* 16 */     target.func_70690_d(new PotionEffect(Potion.field_76422_e.field_76415_H, 1200, 1, true, false));
/*    */   }
/*    */   
/*    */   public void performPriestEffect(EntityPlayer player, EntityLivingBase target, IDeity deity)
/*    */   {
/* 21 */     target.func_70690_d(new PotionEffect(Potion.field_76429_m.field_76415_H, 1200, 0, true, false));
/*    */   }
/*    */   
/*    */   public boolean customTargetting()
/*    */   {
/* 26 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/WorshipEffectStoneWall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */