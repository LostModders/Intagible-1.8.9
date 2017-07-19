/*    */ package emoniph.intangible;
/*    */ 
/*    */ import net.minecraftforge.fml.common.Mod;
/*    */ import net.minecraftforge.fml.common.Mod.EventHandler;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
/*    */ 
/*    */ @Mod(modid="intangible", version="0.0.25", guiFactory="emoniph.intangible.config.GuiFactory", dependencies="required-after:Forge@[11.15.1.1740,);before:JEI;after:Waila;after:ForgeMultipart;after:Baubles", useMetadata=false, acceptedMinecraftVersions="[1.8.9]")
/*    */ public class Intangible
/*    */ {
/*    */   @net.minecraftforge.fml.common.Mod.Instance("intangible")
/*    */   public static Intangible INSTANCE;
/*    */   @net.minecraftforge.fml.common.SidedProxy(serverSide="emoniph.intangible.CommonProxy", clientSide="emoniph.intangible.client.ClientProxy")
/*    */   public static CommonProxy PROXY;
/*    */   
/*    */   @Mod.EventHandler
/*    */   public void preInit(FMLPreInitializationEvent event)
/*    */   {
/* 23 */     PROXY.preInit(event);
/*    */   }
/*    */   
/*    */   @Mod.EventHandler
/*    */   public void init(FMLInitializationEvent event) {
/* 28 */     PROXY.init(event);
/*    */   }
/*    */   
/*    */   @Mod.EventHandler
/*    */   public void postInit(FMLPostInitializationEvent event) {
/* 33 */     PROXY.postInit(event);
/*    */   }
/*    */   
/*    */   @Mod.EventHandler
/*    */   public void serverStarting(FMLServerStartingEvent event) {
/* 38 */     PROXY.serverStarting(event);
/*    */   }
/*    */   
/*    */   @Mod.EventHandler
/*    */   public void serverStopping(FMLServerStoppingEvent event) {
/* 43 */     PROXY.serverStopping(event);
/*    */   }
/*    */   
/*    */   @Mod.EventHandler
/*    */   public void handleIMC(FMLInterModComms.IMCEvent event) {
/* 48 */     PROXY.handleIMC(event);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/Intangible.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */