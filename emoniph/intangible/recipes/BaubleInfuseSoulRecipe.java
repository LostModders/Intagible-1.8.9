/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import emoniph.intangible.api.SoulType;
/*    */ import emoniph.intangible.souls.SoulSet;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class BaubleInfuseSoulRecipe extends AugmentingSoulRecipe
/*    */ {
/*    */   private final SoulType soul;
/*    */   
/*    */   public BaubleInfuseSoulRecipe(SoulType soul, ItemStack[] ingredients, emoniph.intangible.api.ISoulSet souls)
/*    */   {
/* 13 */     super(ingredients[0], ingredients, souls);
/* 14 */     this.soul = soul;
/*    */   }
/*    */   
/*    */   protected boolean isFoundValid(ItemStack stack)
/*    */   {
/* 19 */     SoulSet soulset = emoniph.intangible.items.ItemSoulArmor.getCapacity(stack);
/* 20 */     return soulset.quantityOf(this.soul) == 0;
/*    */   }
/*    */   
/*    */   protected ItemStack augment(ItemStack stack)
/*    */   {
/* 25 */     SoulSet soulset = new SoulSet();
/* 26 */     soulset.add(this.soul, 1);
/* 27 */     emoniph.intangible.items.ItemSoulArmor.setCapacity(stack, soulset);
/* 28 */     return stack;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/BaubleInfuseSoulRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */