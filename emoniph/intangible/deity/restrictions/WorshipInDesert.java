/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.BiomeDictionary;
/*    */ import net.minecraftforge.common.BiomeDictionary.Type;
/*    */ 
/*    */ public class WorshipInDesert implements emoniph.intangible.api.deity.IDeityWorshipRestriction
/*    */ {
/*    */   public boolean isWorshipAllowed(World world, BlockPos pos, EntityPlayer player)
/*    */   {
/* 13 */     net.minecraft.world.biome.BiomeGenBase biome = world.func_180494_b(pos);
/*    */     
/*    */ 
/* 16 */     return (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.HOT)) && (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.DRY)) && (BiomeDictionary.isBiomeOfType(biome, BiomeDictionary.Type.SANDY));
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/WorshipInDesert.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */