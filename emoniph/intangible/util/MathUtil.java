/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public enum MathUtil {
/*    */   public static final float SIXTEENTH = 0.0625F;
/*    */   public static final float PI_FLOAT = 3.1415927F;
/*    */   public static final float TWO_PI_FLOAT = 6.2831855F;
/*    */   public static final float HALF_PI_FLOAT = 1.5707964F;
/*    */   public static final float QUARTER_PI_FLOAT = 0.7853982F;
/*    */   
/*    */   private MathUtil() {}
/*    */   
/*    */   public static float sixteenth(int quantity) {
/* 15 */     return quantity * 0.0625F;
/*    */   }
/*    */   
/*    */   public static float interpolateRotation(float prevRotation, float rotation, float partialRenderTicks)
/*    */   {
/* 20 */     for (float f3 = rotation - prevRotation; f3 < -180.0F; f3 += 360.0F) {}
/*    */     
/*    */ 
/*    */ 
/* 24 */     while (f3 >= 180.0F) {
/* 25 */       f3 -= 360.0F;
/*    */     }
/*    */     
/* 28 */     return prevRotation + partialRenderTicks * f3;
/*    */   }
/*    */   
/*    */   public static net.minecraft.util.Vec3 getVectorForRotation(float pitch, float yaw, float scale) {
/* 32 */     float f2 = MathHelper.func_76134_b(-yaw * 0.017453292F - 3.1415927F);
/* 33 */     float f3 = MathHelper.func_76126_a(-yaw * 0.017453292F - 3.1415927F);
/* 34 */     float f4 = -MathHelper.func_76134_b(-pitch * 0.017453292F);
/* 35 */     float f5 = MathHelper.func_76126_a(-pitch * 0.017453292F);
/* 36 */     return new net.minecraft.util.Vec3(f3 * f4 * scale, f5 * scale, f2 * f4 * scale);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/MathUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */