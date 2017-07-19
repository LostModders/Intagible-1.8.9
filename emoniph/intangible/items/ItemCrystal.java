/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ 
/*    */ public class ItemCrystal extends ItemBlock implements IMeltableItem
/*    */ {
/*    */   public ItemCrystal(Block blockType)
/*    */   {
/* 11 */     super(blockType);
/*    */   }
/*    */   
/*    */   public int getMeltingTemperature() {
/* 15 */     return Get.fluids().MOLTEN_CRYSTAL_BLUE.getTemperature();
/*    */   }
/*    */   
/*    */   public Block getMoltenBlock() {
/* 19 */     return Get.blocks().MOLTEN_CRYSTAL_BLUE;
/*    */   }
/*    */   
/*    */   public boolean onEntityItemUpdate(net.minecraft.entity.item.EntityItem entity)
/*    */   {
/* 24 */     return MeltHandler.handleItemTick(entity, this);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */