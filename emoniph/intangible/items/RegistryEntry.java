/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.CreativeTab;
/*    */ import emoniph.intangible.network.IPacketRegister;
/*    */ import emoniph.intangible.network.IRegisterPackets;
/*    */ import java.util.EnumSet;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemModelMesher;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.resources.model.ModelBakery;
/*    */ import net.minecraft.client.resources.model.ModelResourceLocation;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ class RegistryEntry
/*    */ {
/*    */   private final Item item;
/*    */   private final String itemName;
/*    */   private final boolean visibleInCreative;
/*    */   
/*    */   RegistryEntry(Item item, String itemName, EnumSet flags)
/*    */   {
/* 25 */     this.item = item;
/* 26 */     this.itemName = itemName;
/* 27 */     item.func_77655_b("intangible:" + itemName);
/* 28 */     GameRegistry.registerItem(item, itemName);
/* 29 */     this.visibleInCreative = (!flags.contains(RegistryFlags.HIDE_IN_CREATIVE));
/* 30 */     item.func_77637_a(this.visibleInCreative ? CreativeTab.INSTANCE : null);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void preInit(Minecraft mc) {
/* 35 */     if ((this.item instanceof IItemWithVariants)) {
/* 36 */       IItemWithVariants variantItem = (IItemWithVariants)this.item;
/* 37 */       VariantItemData[] variants = variantItem.getVariants();
/*    */       
/* 39 */       String[] names = new String[variants.length];
/* 40 */       for (int i = 0; i < variants.length; i++) {
/* 41 */         names[i] = ("intangible:" + this.itemName + "_" + variants[i].name);
/*    */       }
/* 43 */       ModelBakery.addVariantName(this.item, names);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   void init(Minecraft mc, RenderItem renderItem) {
/* 49 */     if ((this.item instanceof IItemWithVariants)) {
/* 50 */       IItemWithVariants variantItem = (IItemWithVariants)this.item;
/* 51 */       VariantItemData[] variants = variantItem.getVariants();
/* 52 */       ItemModelMesher mesher = renderItem.func_175037_a();
/* 53 */       for (VariantItemData variant : variants) {
/* 54 */         ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation("intangible:" + this.itemName + "_" + variant.name, "inventory");
/* 55 */         mesher.func_178086_a(this.item, variant.metadata, itemModelResourceLocation);
/*    */       }
/*    */     } else {
/* 58 */       renderItem.func_175037_a().func_178086_a(this.item, 0, new ModelResourceLocation("intangible:" + this.itemName, "inventory"));
/*    */     }
/*    */   }
/*    */   
/*    */   void registerMessages(IPacketRegister messageRegister) {
/* 63 */     if ((this.item instanceof IRegisterPackets)) {
/* 64 */       ((IRegisterPackets)this.item).registerPackets(messageRegister);
/*    */     }
/*    */   }
/*    */   
/*    */   void visit(IItemVisitor visitor) {
/* 69 */     visitor.visit(this.item, this.visibleInCreative);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/RegistryEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */