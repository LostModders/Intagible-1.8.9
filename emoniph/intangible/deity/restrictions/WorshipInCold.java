/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeityWorshipRestriction;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class WorshipInCold implements IDeityWorshipRestriction
/*    */ {
/*    */   public boolean isWorshipAllowed(World world, BlockPos pos, EntityPlayer player)
/*    */   {
/* 13 */     if (world == null) {
/* 14 */       return false;
/*    */     }
/* 16 */     BiomeGenBase biome = world.func_180494_b(pos);
/* 17 */     return (biome != null) && (biome.func_150559_j());
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/WorshipInCold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */