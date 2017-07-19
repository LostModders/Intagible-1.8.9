/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.network.IPacketRegister;
/*    */ import java.util.ArrayList;
/*    */ import java.util.EnumSet;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ class Registry
/*    */ {
/* 15 */   private List<RegistryEntry> itemRegistry = new ArrayList();
/*    */   
/*    */   <T extends Item,  extends IItem> T add(T item, String itemName) {
/* 18 */     return add(item, itemName, EnumSet.noneOf(RegistryFlags.class));
/*    */   }
/*    */   
/*    */   <T extends Item,  extends IItem> T add(T item, String itemName, EnumSet flags) {
/* 22 */     RegistryEntry itemRegistration = new RegistryEntry(item, itemName, flags);
/* 23 */     this.itemRegistry.add(itemRegistration);
/* 24 */     return item;
/*    */   }
/*    */   
/*    */   void registerMessages(IPacketRegister messageRegister) {
/* 28 */     for (RegistryEntry item : this.itemRegistry) {
/* 29 */       item.registerMessages(messageRegister);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   void init(Minecraft mc, RenderItem renderItem) {
/* 35 */     for (RegistryEntry item : this.itemRegistry) {
/* 36 */       item.init(mc, renderItem);
/*    */     }
/*    */   }
/*    */   
/*    */   void foreach(IItemVisitor visitor) {
/* 41 */     for (RegistryEntry item : this.itemRegistry) {
/* 42 */       item.visit(visitor);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void preInit(Minecraft mc) {
/* 48 */     for (RegistryEntry item : this.itemRegistry) {
/* 49 */       item.preInit(mc);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/Registry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */