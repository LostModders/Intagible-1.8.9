/*    */ package emoniph.intangible;
/*    */ 
/*    */ import emoniph.intangible.items.ICreativeSort;
/*    */ import emoniph.intangible.items.ModItems;
/*    */ import java.util.Collections;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public final class CreativeTab extends CreativeTabs
/*    */ {
/* 14 */   public static final CreativeTab INSTANCE = new CreativeTab();
/*    */   private ItemStack iconItemStack;
/*    */   
/* 17 */   private CreativeTab() { super("tabintangible"); }
/*    */   
/*    */ 
/*    */   public Item func_78016_d()
/*    */   {
/* 22 */     return Get.items().KNOWLEDGE_GEM;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public ItemStack func_151244_d()
/*    */   {
/* 29 */     if (this.iconItemStack == null) {
/* 30 */       this.iconItemStack = new ItemStack(func_78016_d());
/*    */     }
/* 32 */     return this.iconItemStack;
/*    */   }
/*    */   
/*    */   public void func_78018_a(List<ItemStack> list)
/*    */   {
/* 37 */     super.func_78018_a(list);
/* 38 */     Collections.sort(list, new java.util.Comparator()
/*    */     {
/*    */       public int compare(ItemStack a, ItemStack b) {
/* 41 */         return Integer.compare(CreativeTab.this.getSortIndex(a), CreativeTab.this.getSortIndex(b));
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */   private int getSortIndex(ItemStack stack) {
/* 47 */     if ((stack.func_77973_b() instanceof ICreativeSort)) {
/* 48 */       return ((ICreativeSort)stack.func_77973_b()).getCreativeSortIndex();
/*    */     }
/* 50 */     Block block = Block.func_149634_a(stack.func_77973_b());
/* 51 */     if ((block != null) && ((block instanceof ICreativeSort))) {
/* 52 */       return ((ICreativeSort)block).getCreativeSortIndex();
/*    */     }
/*    */     
/* 55 */     return 0;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/CreativeTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */