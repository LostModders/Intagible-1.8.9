/*    */ package emoniph.intangible.config;
/*    */ 
/*    */ import net.minecraftforge.fml.client.config.GuiConfig;
/*    */ 
/*    */ public class ConfigGui extends GuiConfig
/*    */ {
/*    */   public ConfigGui(net.minecraft.client.gui.GuiScreen parent)
/*    */   {
/*  9 */     super(parent, emoniph.intangible.Get.config().getConfigElements(), "intangible", false, false, 
/* 10 */       GuiConfig.getAbridgedConfigPath(emoniph.intangible.Get.config().getPath()));
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/config/ConfigGui.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */