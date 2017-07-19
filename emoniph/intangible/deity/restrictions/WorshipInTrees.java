/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeityWorshipRestriction;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorshipInTrees implements IDeityWorshipRestriction
/*    */ {
/*    */   public boolean isWorshipAllowed(World world, BlockPos pos, EntityPlayer player)
/*    */   {
/* 15 */     int MIN_TREES = 6;
/* 16 */     int trees = 0;
/*    */     
/* 18 */     int RADIUS = 16;
/*    */     
/* 20 */     for (int x = -16; x <= 16; x++) {
/* 21 */       for (int z = -16; z <= 16; z++) {
/* 22 */         if (detectTree(world, pos.func_177982_a(x, 0, z))) {
/* 23 */           trees++;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 28 */     return trees >= 6;
/*    */   }
/*    */   
/*    */   private boolean detectTree(World world, BlockPos startPos)
/*    */   {
/* 33 */     int leaves = 0;
/* 34 */     int index = 0;
/* 35 */     Block startBlock = world.func_180495_p(startPos).func_177230_c();
/*    */     EnumFacing localEnumFacing1;
/* 37 */     EnumFacing facing; while (index < 20) {
/* 38 */       BlockPos pos = startPos.func_177981_b(index);
/* 39 */       Block block = world.func_180495_p(pos).func_177230_c();
/* 40 */       if ((!block.isWood(world, pos)) || (block != startBlock)) break;
/* 41 */       EnumFacing[] arrayOfEnumFacing1 = EnumFacing.field_176754_o;int i = arrayOfEnumFacing1.length; for (localEnumFacing1 = 0; localEnumFacing1 < i; localEnumFacing1++) { facing = arrayOfEnumFacing1[localEnumFacing1];
/* 42 */         BlockPos leafPos = pos.func_177972_a(facing);
/* 43 */         if (world.func_180495_p(leafPos).func_177230_c().isLeaves(world, leafPos)) {
/* 44 */           leaves++;
/*    */         }
/*    */       }
/* 47 */       index++;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 53 */     int downIndex = 1;
/*    */     
/* 55 */     while (downIndex < 20) {
/* 56 */       BlockPos pos = startPos.func_177979_c(downIndex);
/* 57 */       Block block = world.func_180495_p(pos).func_177230_c();
/* 58 */       if ((!block.isWood(world, pos)) || (block != startBlock)) break;
/* 59 */       EnumFacing[] arrayOfEnumFacing2 = EnumFacing.field_176754_o;localEnumFacing1 = arrayOfEnumFacing2.length; for (facing = 0; facing < localEnumFacing1; facing++) { EnumFacing facing = arrayOfEnumFacing2[facing];
/* 60 */         BlockPos leafPos = pos.func_177972_a(facing);
/* 61 */         if (world.func_180495_p(leafPos).func_177230_c().isLeaves(world, leafPos)) {
/* 62 */           leaves++;
/*    */         }
/*    */       }
/* 65 */       downIndex++;
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 71 */     int MIN_WOOD = 4;
/* 72 */     int MIN_LEAVES = 8;
/*    */     
/* 74 */     return (downIndex + index - 1 >= 4) && (leaves >= 8);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/WorshipInTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */