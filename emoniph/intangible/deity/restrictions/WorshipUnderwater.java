/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import emoniph.intangible.util.EnumDiagonalFacing;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipUnderwater implements emoniph.intangible.api.deity.IDeityWorshipRestriction
/*    */ {
/*    */   public boolean isWorshipAllowed(World world, BlockPos pos, EntityPlayer player)
/*    */   {
/* 15 */     int water = 0;
/*    */     
/* 17 */     for (EnumDiagonalFacing facing : EnumDiagonalFacing.DIAGONALS) {
/* 18 */       if (world.func_180495_p(facing.offset(pos)).func_177230_c().func_149688_o() == Material.field_151586_h)
/*    */       {
/* 20 */         water++;
/*    */       }
/*    */     }
/*    */     
/* 24 */     return (player.func_70090_H()) && (water >= 3) && (world.func_180495_p(pos.func_177984_a()).func_177230_c().func_149688_o() == Material.field_151586_h);
/*    */   }
/*    */   
/*    */   private boolean isWater(World world, BlockPos pos, net.minecraft.util.EnumFacing facing) {
/* 28 */     return world.func_180495_p(pos.func_177972_a(facing)).func_177230_c().func_149688_o() == Material.field_151586_h;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/WorshipUnderwater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */