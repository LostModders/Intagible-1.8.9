/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import emoniph.intangible.api.ISoulSet;
/*    */ import emoniph.intangible.api.SoulType;
/*    */ import emoniph.intangible.blocks.BlockDefense;
/*    */ import emoniph.intangible.souls.EnumSoulType;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class CrystalInfuseSoulRecipe
/*    */   extends AugmentingSoulRecipe
/*    */ {
/*    */   private final SoulType soul;
/*    */   
/*    */   public CrystalInfuseSoulRecipe(SoulType soul, ItemStack[] ingredients, ISoulSet souls)
/*    */   {
/* 16 */     super(ingredients[0], ingredients, souls);
/* 17 */     this.soul = soul;
/*    */   }
/*    */   
/*    */   protected boolean isFoundValid(ItemStack stack)
/*    */   {
/* 22 */     EnumSoulType soulFound = BlockDefense.getSoulType(stack);
/* 23 */     return soulFound != EnumSoulType.fromSoulType(this.soul);
/*    */   }
/*    */   
/*    */   protected ItemStack augment(ItemStack stack)
/*    */   {
/* 28 */     BlockDefense.setSoulType(stack, EnumSoulType.fromSoulType(this.soul));
/* 29 */     return stack;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/CrystalInfuseSoulRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */