/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ import org.apache.commons.lang3.Range;
/*    */ 
/*    */ public class WorshipInStoneBuildings implements emoniph.intangible.api.deity.IDeityWorshipRestriction
/*    */ {
/*    */   public boolean isWorshipAllowed(World world, BlockPos startPos, EntityPlayer player)
/*    */   {
/* 16 */     int walls = 0;
/* 17 */     for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 18 */       if (isWall(world, startPos, facing, Range.between(Integer.valueOf(2), Integer.valueOf(16)))) {
/* 19 */         walls++;
/*    */       }
/*    */     }
/*    */     
/* 23 */     return (isWall(world, startPos, EnumFacing.UP, Range.between(Integer.valueOf(2), Integer.valueOf(16)))) && (walls >= 3);
/*    */   }
/*    */   
/*    */   private boolean isWall(World world, BlockPos startPos, EnumFacing direction, Range<Integer> range) {
/* 27 */     for (int i = ((Integer)range.getMinimum()).intValue(); i <= ((Integer)range.getMaximum()).intValue(); i++) {
/* 28 */       BlockPos pos = startPos.func_177967_a(direction, i);
/* 29 */       IBlockState state = world.func_180495_p(pos);
/* 30 */       if (!state.func_177230_c().func_149688_o().func_76222_j()) {
/* 31 */         if (direction != EnumFacing.UP) {
/* 32 */           if ((isWall(world, pos.func_177984_a())) && (isWall(world, pos.func_177981_b(2))) && (isWall(world, pos.func_177972_a(direction.func_176746_e()))) && (isWall(world, pos.func_177972_a(direction.func_176735_f())))) {
/* 33 */             return true;
/*    */           }
/*    */         }
/* 36 */         else if ((isWall(world, pos.func_177978_c())) && (isWall(world, pos.func_177968_d())) && (isWall(world, pos.func_177974_f())) && (isWall(world, pos.func_177976_e())) && 
/* 37 */           (isWall(world, pos.func_177982_a(1, 0, 1))) && (isWall(world, pos.func_177982_a(1, 0, -1))) && (isWall(world, pos.func_177982_a(-1, 0, 1))) && (isWall(world, pos.func_177982_a(-1, 0, -1))) && 
/* 38 */           (isWall(world, pos.func_177964_d(2))) && (isWall(world, pos.func_177970_e(2))) && (isWall(world, pos.func_177965_g(2))) && (isWall(world, pos.func_177985_f(2)))) {
/* 39 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   private boolean isWall(World world, BlockPos pos) {
/* 49 */     IBlockState state = world.func_180495_p(pos);
/* 50 */     return state.func_177230_c().func_149688_o() == Material.field_151576_e;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/WorshipInStoneBuildings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */