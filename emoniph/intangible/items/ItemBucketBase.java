/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import net.minecraft.item.ItemBucket;
/*    */ 
/*    */ public class ItemBucketBase extends ItemBucket implements IItem, ICreativeSort
/*    */ {
/*    */   public ItemBucketBase(net.minecraft.block.Block containedBlock) {
/*  8 */     super(containedBlock);
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 13 */     return 201;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemBucketBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */