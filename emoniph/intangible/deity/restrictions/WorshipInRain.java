/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipInRain implements emoniph.intangible.api.deity.IDeityWorshipRestriction
/*    */ {
/*    */   public boolean isWorshipAllowed(World world, BlockPos pos, EntityPlayer player)
/*    */   {
/* 11 */     return (world.func_180494_b(pos).func_76738_d()) && (world.func_72896_J());
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/WorshipInRain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */