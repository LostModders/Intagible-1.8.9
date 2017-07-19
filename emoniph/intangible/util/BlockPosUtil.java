/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.util.BlockPos;
/*    */ 
/*    */ public enum BlockPosUtil
/*    */ {
/*    */   private BlockPosUtil() {}
/*    */   
/*    */   public static net.minecraft.util.Vec3 centerOf(BlockPos pos) {
/* 10 */     return new net.minecraft.util.Vec3(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/BlockPosUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */