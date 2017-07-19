/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.util.BlockPos;
/*    */ 
/*    */ public enum EnumDiagonalFacing {
/*  6 */   NE(-1, -1),  SE(-1, 1),  SW(1, 1),  NW(1, -1);
/*    */   
/*    */   private final int offsetX;
/*    */   private final int offsetZ;
/*    */   
/*    */   private EnumDiagonalFacing(int x, int z) {
/* 12 */     this.offsetX = x;
/* 13 */     this.offsetZ = z;
/*    */   }
/*    */   
/*    */   public BlockPos offset(BlockPos pos) {
/* 17 */     return offset(pos, 1);
/*    */   }
/*    */   
/*    */   public BlockPos offset(BlockPos pos, int distance) {
/* 21 */     return pos.func_177982_a(this.offsetX * distance, 0, this.offsetZ * distance);
/*    */   }
/*    */   
/* 24 */   public static final EnumDiagonalFacing[] DIAGONALS = { NE, SE, SW, NW };
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/EnumDiagonalFacing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */