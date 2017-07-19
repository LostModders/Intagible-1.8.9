/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class GolemPartRecipe
/*    */ {
/*    */   private final ItemStack output;
/*    */   private final ItemStack[] inputs;
/*    */   
/*    */   public GolemPartRecipe(net.minecraft.item.Item output, net.minecraft.item.Item input1, net.minecraft.item.Item input2, net.minecraft.item.Item input3, net.minecraft.item.Item input4) {
/* 11 */     this(new ItemStack(output), new ItemStack(input1), new ItemStack(input2), new ItemStack(input3), new ItemStack(input4));
/*    */   }
/*    */   
/*    */   public GolemPartRecipe(ItemStack output, ItemStack input1, ItemStack input2, ItemStack input3, ItemStack input4)
/*    */   {
/* 16 */     this.output = output;
/* 17 */     this.inputs = new ItemStack[] { input1, input2, input3, input4 };
/*    */   }
/*    */   
/*    */   public boolean isMatchFor(ItemStack[] stacks) {
/* 21 */     if (this.inputs.length != stacks.length) {
/* 22 */       return false;
/*    */     }
/*    */     
/* 25 */     for (int start = 0; start < this.inputs.length; start++) {
/* 26 */       int matches = 0;
/* 27 */       for (int pos = 0; pos < this.inputs.length; pos++) {
/* 28 */         int index = (start + pos) % this.inputs.length;
/* 29 */         ItemStack required = this.inputs[pos];
/* 30 */         ItemStack found = stacks[index];
/* 31 */         if (required != found) { if ((required == null) || (found == null))
/*    */             break;
/* 33 */           if (!ItemStack.func_179545_c(required, found)) break; }
/* 34 */         matches++; if (matches == this.inputs.length) {
/* 35 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public ItemStack getOutput() {
/* 46 */     return this.output;
/*    */   }
/*    */   
/*    */   public ItemStack[] getInputs() {
/* 50 */     return this.inputs;
/*    */   }
/*    */   
/*    */   public boolean decreaseStacks(ItemStack[] stacks) {
/* 54 */     if (this.inputs.length != stacks.length) {
/* 55 */       return false;
/*    */     }
/*    */     
/* 58 */     for (int start = 0; start < this.inputs.length; start++) {
/* 59 */       int matches = 0;
/* 60 */       for (int pos = 0; pos < this.inputs.length; pos++) {
/* 61 */         int index = (start + pos) % this.inputs.length;
/* 62 */         ItemStack required = this.inputs[pos];
/* 63 */         ItemStack found = stacks[index];
/* 64 */         if (required != found) { if ((required == null) || (found == null))
/*    */             break;
/* 66 */           if (!ItemStack.func_179545_c(required, found)) break; }
/* 67 */         matches++; if (matches == this.inputs.length) {
/* 68 */           for (int pos2 = 0; pos2 < this.inputs.length; pos2++) {
/* 69 */             int index2 = (start + pos2) % this.inputs.length;
/* 70 */             ItemStack required2 = this.inputs[pos2];
/* 71 */             ItemStack found2 = stacks[index2];
/* 72 */             found2.field_77994_a = Math.max(found2.field_77994_a - required2.field_77994_a, 0);
/*    */           }
/* 74 */           return true;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 81 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/GolemPartRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */