/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.fluids.ModFluids;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraftforge.fluids.Fluid;
/*    */ 
/*    */ 
/*    */ public class ItemShard
/*    */   extends Item
/*    */   implements IItem, IMeltableItem, ICreativeSort
/*    */ {
/*    */   public int getMeltingTemperature()
/*    */   {
/* 18 */     return Get.fluids().MOLTEN_CRYSTAL_YELLOW.getTemperature();
/*    */   }
/*    */   
/*    */   public Block getMoltenBlock() {
/* 22 */     return Get.blocks().MOLTEN_CRYSTAL_YELLOW;
/*    */   }
/*    */   
/*    */   public boolean onEntityItemUpdate(EntityItem entity)
/*    */   {
/* 27 */     return MeltHandler.handleItemTick(entity, this);
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 32 */     return 51;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemShard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */