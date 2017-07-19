/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class StampingRecipe
/*    */ {
/*    */   private final ItemStack output;
/*    */   private final ItemStack[] inputs;
/*    */   
/*    */   public StampingRecipe(net.minecraft.item.Item output, net.minecraft.item.Item inputTopLeft, net.minecraft.item.Item inputTopRight, net.minecraft.item.Item inputBottomLeft, net.minecraft.item.Item inputBottomRight) {
/* 11 */     this(new ItemStack(output), new ItemStack(inputTopLeft), new ItemStack(inputTopRight), new ItemStack(inputBottomLeft), new ItemStack(inputBottomRight));
/*    */   }
/*    */   
/*    */   public StampingRecipe(ItemStack output, ItemStack inputTopLeft, ItemStack inputTopRight, ItemStack inputBottomLeft, ItemStack inputBottomRight)
/*    */   {
/* 16 */     this.output = output;
/* 17 */     this.inputs = new ItemStack[] { inputTopLeft, inputTopRight, inputBottomLeft, inputBottomRight };
/*    */   }
/*    */   
/*    */   public boolean isMatchFor(ItemStack[] stacksIn) {
/* 21 */     if (stacksIn.length != this.inputs.length) {
/* 22 */       return false;
/*    */     }
/* 24 */     int i = 0; for (int count = this.inputs.length; i < count; i++) {
/* 25 */       if (!ItemStack.func_179545_c(stacksIn[i], this.inputs[i])) {
/* 26 */         return false;
/*    */       }
/*    */     }
/*    */     
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public ItemStack getOutput()
/*    */   {
/* 35 */     return this.output;
/*    */   }
/*    */   
/*    */   public ItemStack[] getInputs() {
/* 39 */     return this.inputs;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/StampingRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */