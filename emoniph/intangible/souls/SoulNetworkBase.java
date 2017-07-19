/*    */ package emoniph.intangible.souls;
/*    */ 
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ public class SoulNetworkBase
/*    */ {
/*    */   protected TileEntity getLoadedTileEntityAt(net.minecraft.world.World world, net.minecraft.util.BlockPos pos)
/*    */   {
/*  9 */     for (Object obj : world.field_147482_g) {
/* 10 */       TileEntity tile = (TileEntity)obj;
/* 11 */       if (tile.func_174877_v().equals(pos)) {
/* 12 */         return tile;
/*    */       }
/*    */     }
/* 15 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/SoulNetworkBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */