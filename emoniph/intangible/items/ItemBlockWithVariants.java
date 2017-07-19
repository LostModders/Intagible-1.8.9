/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.blocks.IBlockWithVariants;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ 
/*    */ public class ItemBlockWithVariants extends ItemBlock
/*    */ {
/*    */   public ItemBlockWithVariants(net.minecraft.block.Block block)
/*    */   {
/* 10 */     super(block);
/* 11 */     func_77656_e(0);
/* 12 */     func_77627_a(true);
/*    */   }
/*    */   
/*    */   public int func_77647_b(int metadata)
/*    */   {
/* 17 */     return metadata;
/*    */   }
/*    */   
/*    */   public String func_77667_c(net.minecraft.item.ItemStack stack)
/*    */   {
/* 22 */     return ((IBlockWithVariants)this.field_150939_a).getUnlocalizedName(stack);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemBlockWithVariants.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */