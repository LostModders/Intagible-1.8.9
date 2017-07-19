/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public abstract class AugmentingSoulRecipe extends SoulRecipe
/*    */ {
/*    */   public AugmentingSoulRecipe(ItemStack output, ItemStack[] ingredients, emoniph.intangible.api.ISoulSet souls) {
/*  8 */     super(output, ingredients, souls);
/*    */   }
/*    */   
/*    */   public ItemStack getOutput(ItemStack[] stacks)
/*    */   {
/* 13 */     for (ItemStack stack : stacks) {
/* 14 */       if (areItemsEqual(this.output, stack)) {
/* 15 */         return augment(stack);
/*    */       }
/*    */     }
/* 18 */     return this.output.func_77946_l();
/*    */   }
/*    */   
/*    */   protected abstract ItemStack augment(ItemStack paramItemStack);
/*    */   
/*    */   protected boolean isAugmentation()
/*    */   {
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/AugmentingSoulRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */