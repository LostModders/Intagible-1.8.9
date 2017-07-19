/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import emoniph.intangible.CreativeTab;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemMeshDefinition;
/*    */ import net.minecraft.client.renderer.ItemModelMesher;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.resources.model.ModelBakery;
/*    */ import net.minecraft.client.resources.model.ModelResourceLocation;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.client.model.ModelLoader;
/*    */ import net.minecraftforge.fluids.IFluidBlock;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ class RegistryEntry
/*    */ {
/*    */   protected final Block block;
/*    */   protected final String blockName;
/*    */   private final boolean visibleInCreative;
/*    */   private final boolean hasItemModel;
/*    */   
/*    */   RegistryEntry(Block block, String blockName, Class<? extends ItemBlock> blockItemClass, EnumSet flags)
/*    */   {
/* 30 */     this.block = block;
/* 31 */     this.blockName = blockName;
/*    */     
/* 33 */     block.func_149663_c("intangible:" + blockName);
/*    */     
/* 35 */     this.hasItemModel = (!flags.contains(RegistryFlags.NO_INVENTORY_MODEL));
/*    */     
/* 37 */     if (!this.hasItemModel) {
/* 38 */       GameRegistry.registerBlock(block, null, blockName);
/* 39 */     } else if (blockItemClass == null) {
/* 40 */       GameRegistry.registerBlock(block, blockName);
/*    */     } else {
/* 42 */       GameRegistry.registerBlock(block, blockItemClass, blockName);
/*    */     }
/*    */     
/* 45 */     this.visibleInCreative = (!flags.contains(RegistryFlags.HIDE_IN_CREATIVE));
/* 46 */     block.func_149647_a(this.visibleInCreative ? CreativeTab.INSTANCE : null);
/*    */   }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void preInit(Minecraft mc)
/*    */   {
/* 53 */     if ((this.block instanceof IBlockWithVariants)) {
/* 54 */       IBlockWithVariants variantBlock = (IBlockWithVariants)this.block;
/* 55 */       VariantBlockData[] variants = variantBlock.getVariants();
/*    */       
/* 57 */       Item itemBlockVariants = GameRegistry.findItem("intangible", this.blockName);
/* 58 */       String[] names = new String[variants.length];
/* 59 */       for (int i = 0; i < variants.length; i++) {
/* 60 */         names[i] = ("intangible:" + this.blockName + "_" + variants[i].name);
/*    */       }
/* 62 */       ModelBakery.addVariantName(itemBlockVariants, names);
/* 63 */     } else if ((this.block instanceof IFluidBlock)) {
/* 64 */       Item fluidItem = Item.func_150898_a(this.block);
/* 65 */       ModelBakery.addVariantName(fluidItem, new String[0]);
/* 66 */       final ModelResourceLocation fluidLocation = new ModelResourceLocation("intangible:" + this.blockName, "fluid");
/* 67 */       ModelLoader.setCustomMeshDefinition(fluidItem, new ItemMeshDefinition() {
/*    */         public ModelResourceLocation func_178113_a(ItemStack stack) {
/* 69 */           return fluidLocation;
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void init(Minecraft mc, RenderItem renderItem) {
/* 77 */     if ((this.block instanceof IBlockWithVariants)) {
/* 78 */       IBlockWithVariants variantBlock = (IBlockWithVariants)this.block;
/* 79 */       VariantBlockData[] variants = variantBlock.getVariants();
/*    */       
/* 81 */       Item itemBlockVariants = GameRegistry.findItem("intangible", this.blockName);
/* 82 */       ItemModelMesher mesher = renderItem.func_175037_a();
/* 83 */       for (VariantBlockData variant : variants) {
/* 84 */         ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("intangible:" + this.blockName + "_" + variant.name, "inventory");
/* 85 */         mesher.func_178086_a(itemBlockVariants, variant.metadata, itemModelResourceLocation);
/*    */       }
/* 87 */     } else if (!(this.block instanceof IFluidBlock))
/*    */     {
/*    */ 
/* 90 */       if (this.hasItemModel) {
/* 91 */         renderItem.func_175037_a().func_178086_a(Item.func_150898_a(this.block), 0, new ModelResourceLocation("intangible:" + this.blockName, "inventory"));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   void visit(IBlockVisitor visitor)
/*    */   {
/* 98 */     visitor.visit(this.block, this.visibleInCreative);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/RegistryEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */