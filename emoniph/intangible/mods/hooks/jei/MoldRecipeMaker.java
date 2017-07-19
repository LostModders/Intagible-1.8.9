/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.IMold;
/*    */ import emoniph.intangible.fluids.ModFluids;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mezz.jei.api.IItemRegistry;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ 
/*    */ public class MoldRecipeMaker
/*    */ {
/*    */   @javax.annotation.Nonnull
/*    */   public static List<MoldRecipeWrapper> getRecipes(IItemRegistry itemRegistry)
/*    */   {
/* 18 */     List<MoldRecipeWrapper> recipeWrappers = new java.util.ArrayList();
/* 19 */     Iterator<Item> iterator = Item.field_150901_e.iterator();
/*    */     
/* 21 */     FluidStack[] fluids = { new FluidStack(Get.fluids().MOLTEN_GLASS, 1000), new FluidStack(Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000), new FluidStack(Get.fluids().MOLTEN_CRYSTAL_YELLOW, 1000) };
/*    */     
/* 23 */     while (iterator.hasNext()) {
/* 24 */       Item item = (Item)iterator.next();
/* 25 */       if ((item instanceof IMold)) {
/* 26 */         IMold mold = (IMold)item;
/* 27 */         for (FluidStack fluid : fluids) {
/* 28 */           ItemStack stack = mold.getResultForFluid(fluid);
/* 29 */           if (stack != null) {
/* 30 */             recipeWrappers.add(new MoldRecipeWrapper(new ItemStack(item), fluid, stack));
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 36 */     return recipeWrappers;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/MoldRecipeMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */