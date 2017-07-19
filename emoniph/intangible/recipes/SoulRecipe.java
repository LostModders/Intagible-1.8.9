/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class SoulRecipe
/*    */ {
/*    */   protected final ItemStack output;
/*    */   protected final ItemStack[] ingredients;
/*    */   protected final emoniph.intangible.api.ISoulSet souls;
/*    */   
/*    */   public SoulRecipe(ItemStack output, ItemStack[] ingredients, emoniph.intangible.api.ISoulSet souls) {
/* 12 */     this.output = output;
/* 13 */     this.ingredients = ingredients;
/* 14 */     this.souls = souls;
/*    */   }
/*    */   
/*    */   public boolean isMatchFor(ItemStack[] stacks) {
/* 18 */     if (this.ingredients.length != stacks.length) {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     for (int start = 0; start < this.ingredients.length; start++) {
/* 23 */       int matches = 0;
/* 24 */       for (int pos = 0; pos < this.ingredients.length; pos++) {
/* 25 */         int index = (start + pos) % this.ingredients.length;
/* 26 */         ItemStack required = this.ingredients[pos];
/* 27 */         ItemStack found = stacks[index];
/* 28 */         if (required != found) { if ((required == null) || (found == null))
/*    */             break;
/* 30 */           if ((!areItemsEqual(required, found)) || (!isFoundValid(found))) break; }
/* 31 */         matches++; if (matches == this.ingredients.length) {
/* 32 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   protected static boolean areItemsEqual(ItemStack stackA, ItemStack stackB)
/*    */   {
/* 44 */     if ((stackA == null) && (stackB == null))
/* 45 */       return true;
/* 46 */     if ((stackA != null) && (stackB != null)) {
/* 47 */       if (stackA.func_77973_b() != stackB.func_77973_b())
/* 48 */         return false;
/* 49 */       if ((stackA.func_77973_b().func_77614_k()) && (stackA.func_77952_i() != stackB.func_77952_i())) {
/* 50 */         return false;
/*    */       }
/* 52 */       return true;
/*    */     }
/*    */     
/* 55 */     return false;
/*    */   }
/*    */   
/*    */   protected boolean isFoundValid(ItemStack found)
/*    */   {
/* 60 */     return true;
/*    */   }
/*    */   
/*    */   public ItemStack getOutput(ItemStack[] stacks) {
/* 64 */     return this.output.func_77946_l();
/*    */   }
/*    */   
/*    */   public emoniph.intangible.api.ISoulSet getRequiredSouls() {
/* 68 */     return this.souls;
/*    */   }
/*    */   
/*    */   public ItemStack[] getInputs() {
/* 72 */     return this.ingredients;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isMatchForOutput(ItemStack stack, SoulRecipeManager.Selector selector)
/*    */   {
/* 78 */     return (areItemsEqual(stack, this.output)) && ((selector == SoulRecipeManager.Selector.All) || ((selector == SoulRecipeManager.Selector.MAIN) && (!isAugmentation())) || ((selector == SoulRecipeManager.Selector.TEMPERING) && (isAugmentation())));
/*    */   }
/*    */   
/*    */   protected boolean isAugmentation() {
/* 82 */     return false;
/*    */   }
/*    */   
/*    */   public ItemStack[] getCloneOfInputs() {
/* 86 */     ItemStack[] stacks = new ItemStack[this.ingredients.length];
/* 87 */     for (int i = 0; i < this.ingredients.length; i++) {
/* 88 */       if (this.ingredients[i] != null) {
/* 89 */         stacks[i] = this.ingredients[i].func_77946_l();
/*    */       }
/*    */     }
/* 92 */     return stacks;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/SoulRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */