/*    */ package emoniph.intangible.config;
/*    */ 
/*    */ import java.util.Set;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraftforge.fml.client.IModGuiFactory;
/*    */ import net.minecraftforge.fml.client.IModGuiFactory.RuntimeOptionCategoryElement;
/*    */ import net.minecraftforge.fml.client.IModGuiFactory.RuntimeOptionGuiHandler;
/*    */ 
/*    */ public class GuiFactory implements IModGuiFactory
/*    */ {
/*    */   public void initialize(Minecraft mc) {}
/*    */   
/*    */   public Class<? extends GuiScreen> mainConfigGuiClass()
/*    */   {
/* 16 */     return ConfigGui.class;
/*    */   }
/*    */   
/*    */   public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories()
/*    */   {
/* 21 */     return null;
/*    */   }
/*    */   
/*    */   public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element)
/*    */   {
/* 26 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/config/GuiFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */