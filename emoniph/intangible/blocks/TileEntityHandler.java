/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ class TileEntityHandler
/*    */ {
/*    */   final Class<? extends TileEntity> clazz;
/*    */   
/*    */   TileEntityHandler(Class<? extends TileEntity> clazz)
/*    */   {
/* 16 */     this.clazz = clazz;
/*    */   }
/*    */   
/*    */   void register(String blockName) {
/* 20 */     GameRegistry.registerTileEntityWithAlternatives(this.clazz, "intangible_" + blockName, new String[] { blockName });
/*    */   }
/*    */   
/*    */   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */   void registerRenderer(Minecraft mc, List<TileEntitySpecialRenderer> renderers) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/TileEntityHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */