/*    */ package emoniph.intangible.mods.hooks.jei;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import mezz.jei.api.IItemRegistry;
/*    */ import mezz.jei.api.IJeiHelpers;
/*    */ import mezz.jei.api.IJeiRuntime;
/*    */ import mezz.jei.api.IModRegistry;
/*    */ import mezz.jei.api.IRecipeRegistry;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ @mezz.jei.api.JEIPlugin
/*    */ public class ModJEIPlugin implements mezz.jei.api.IModPlugin
/*    */ {
/*    */   private IItemRegistry itemRegistry;
/*    */   private IJeiHelpers jeiHelpers;
/*    */   
/*    */   public void onJeiHelpersAvailable(IJeiHelpers jeiHelpers)
/*    */   {
/* 20 */     this.jeiHelpers = jeiHelpers;
/*    */     
/* 22 */     Get.blocks().foreach(new emoniph.intangible.blocks.IBlockVisitor()
/*    */     {
/*    */       public void visit(Block block, boolean visibleInCreative) {
/* 25 */         if (!visibleInCreative) {}
/*    */ 
/*    */ 
/*    */       }
/*    */       
/*    */ 
/*    */ 
/*    */ 
/* 33 */     });
/* 34 */     Get.items().foreach(new emoniph.intangible.items.IItemVisitor()
/*    */     {
/*    */       public void visit(Item item, boolean visibleInCreative) {
/* 37 */         if (!visibleInCreative) {}
/*    */       }
/*    */     });
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void onItemRegistryAvailable(IItemRegistry itemRegistry)
/*    */   {
/* 48 */     this.itemRegistry = itemRegistry;
/*    */   }
/*    */   
/*    */   public void register(IModRegistry registry)
/*    */   {
/* 53 */     mezz.jei.api.IGuiHelper guiHelper = this.jeiHelpers.getGuiHelper();
/* 54 */     registry.addRecipeCategories(new mezz.jei.api.recipe.IRecipeCategory[] { new StamperRecipeCategory(guiHelper), new MoldRecipeCategory(guiHelper), new GolemPartsRecipeCategory(guiHelper), new SoulForgeRecipeCategory(guiHelper) });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 60 */     registry.addRecipeHandlers(new mezz.jei.api.recipe.IRecipeHandler[] { new StamperRecipeHandler(), new MoldRecipeHandler(), new GolemPartsRecipeHandler(), new SoulforgeRecipeHandler() });
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 66 */     registry.addRecipes(StamperRecipeMaker.getRecipes(this.itemRegistry));
/* 67 */     registry.addRecipes(MoldRecipeMaker.getRecipes(this.itemRegistry));
/* 68 */     registry.addRecipes(GolemPartsRecipeMaker.getRecipes(this.itemRegistry));
/* 69 */     registry.addRecipes(SoulForgeRecipeMaker.getRecipes(this.itemRegistry));
/*    */   }
/*    */   
/*    */   public void onRecipeRegistryAvailable(IRecipeRegistry recipeRegistry) {}
/*    */   
/*    */   public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/jei/ModJEIPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */