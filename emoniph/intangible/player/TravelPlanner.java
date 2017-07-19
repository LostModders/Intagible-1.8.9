/*    */ package emoniph.intangible.player;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ 
/*    */ public class TravelPlanner
/*    */ {
/*    */   private final EntityPlayer player;
/*    */   private final BlockPos start;
/*    */   private final java.util.List<BlockPos> destinations;
/*    */   private final boolean free;
/*    */   
/*    */   public TravelPlanner(EntityPlayer player, BlockPos start, java.util.List<BlockPos> destinations, boolean free)
/*    */   {
/* 15 */     this.player = player;
/* 16 */     this.start = start;
/* 17 */     this.destinations = destinations;
/* 18 */     this.free = free;
/*    */   }
/*    */   
/*    */   public java.util.List<BlockPos> getDestinations() {
/* 22 */     return this.destinations;
/*    */   }
/*    */   
/*    */   public boolean isMovedTooFar(EntityPlayer player) {
/* 26 */     return player.func_174818_b(this.start) > 4.0D;
/*    */   }
/*    */   
/*    */   public boolean isFree() {
/* 30 */     return this.free;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/TravelPlanner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */