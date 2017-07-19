/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityWorshipEffect;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorshipEffectNothing
/*    */   implements IDeityWorshipEffect
/*    */ {
/*    */   public void performWorshipEffect(World world, BlockPos pos, EntityLivingBase target, IDeity deity) {}
/*    */   
/*    */   public void performPriestEffect(EntityPlayer player, EntityLivingBase target, IDeity deity) {}
/*    */   
/*    */   public boolean customTargetting()
/*    */   {
/* 23 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/WorshipEffectNothing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */