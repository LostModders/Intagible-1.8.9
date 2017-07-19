/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.EnumSet;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraftforge.fml.client.registry.ClientRegistry;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ class RegistryEntryTileEntity extends RegistryEntry
/*    */ {
/*    */   private final TileEntityHandler tileEntityHandler;
/*    */   
/*    */   RegistryEntryTileEntity(BlockContainer block, String blockName, TileEntityHandler tileEntityHandler, Class<? extends ItemBlock> blockItemClass, EnumSet flags)
/*    */   {
/* 21 */     super(block, blockName, blockItemClass, flags);
/* 22 */     this.tileEntityHandler = tileEntityHandler;
/* 23 */     tileEntityHandler.register(blockName);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void preInit(Minecraft mc)
/*    */   {
/* 29 */     super.preInit(mc);
/*    */   }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void init(Minecraft mc, RenderItem renderItem)
/*    */   {
/* 36 */     super.init(mc, renderItem);
/* 37 */     List<TileEntitySpecialRenderer> renderers = new ArrayList();
/* 38 */     this.tileEntityHandler.registerRenderer(mc, renderers);
/* 39 */     for (TileEntitySpecialRenderer renderer : renderers) {
/* 40 */       ClientRegistry.bindTileEntitySpecialRenderer(this.tileEntityHandler.clazz, renderer);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/RegistryEntryTileEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */