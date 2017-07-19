/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.EnumSet;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ class Registry
/*    */ {
/* 16 */   private final List<RegistryEntry> blockRegistry = new ArrayList();
/*    */   
/*    */   <T extends BlockContainer,  extends IBlock> T add(String blockName, T block, TileEntityHandler tileEntityHandler) {
/* 19 */     return add(blockName, block, tileEntityHandler, null, EnumSet.noneOf(RegistryFlags.class));
/*    */   }
/*    */   
/*    */   <T extends BlockContainer,  extends IBlock> T add(String blockName, T block, TileEntityHandler tileEntityHandler, EnumSet flags) {
/* 23 */     return add(blockName, block, tileEntityHandler, null, flags);
/*    */   }
/*    */   
/*    */   <T extends BlockContainer,  extends IBlock> T add(String blockName, T block, TileEntityHandler tileEntityHandler, Class<? extends ItemBlock> blockItemClass) {
/* 27 */     return add(blockName, block, tileEntityHandler, blockItemClass, EnumSet.noneOf(RegistryFlags.class));
/*    */   }
/*    */   
/*    */   <T extends BlockContainer,  extends IBlock> T add(String blockName, T block, TileEntityHandler tileEntityHandler, Class<? extends ItemBlock> blockItemClass, EnumSet flags) {
/* 31 */     this.blockRegistry.add(new RegistryEntryTileEntity(block, blockName, tileEntityHandler, blockItemClass, flags));
/* 32 */     return block;
/*    */   }
/*    */   
/*    */   <T extends Block,  extends IBlock> T add(String blockName, T block) {
/* 36 */     return add(blockName, block, null, EnumSet.noneOf(RegistryFlags.class));
/*    */   }
/*    */   
/*    */   <T extends Block,  extends IBlock> T add(String blockName, T block, EnumSet flags) {
/* 40 */     return add(blockName, block, null, flags);
/*    */   }
/*    */   
/*    */   <T extends Block,  extends IBlock> T add(String blockName, T block, Class<? extends ItemBlock> blockItemClass) {
/* 44 */     return add(blockName, block, blockItemClass, EnumSet.noneOf(RegistryFlags.class));
/*    */   }
/*    */   
/*    */   <T extends Block,  extends IBlock> T add(String blockName, T block, Class<? extends ItemBlock> blockItemClass, EnumSet flags) {
/* 48 */     this.blockRegistry.add(new RegistryEntry(block, blockName, blockItemClass, flags));
/* 49 */     return block;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void preInit(Minecraft mc) {
/* 54 */     for (RegistryEntry entry : this.blockRegistry) {
/* 55 */       entry.preInit(mc);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void init(Minecraft mc, RenderItem renderItem) {
/* 61 */     for (RegistryEntry entry : this.blockRegistry) {
/* 62 */       entry.init(mc, renderItem);
/*    */     }
/*    */   }
/*    */   
/*    */   void foreach(IBlockVisitor visitor) {
/* 67 */     for (RegistryEntry registryEntry : this.blockRegistry) {
/* 68 */       registryEntry.visit(visitor);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/Registry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */