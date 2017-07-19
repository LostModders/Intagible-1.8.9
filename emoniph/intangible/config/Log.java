/*    */ package emoniph.intangible.config;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.init.IModService;
/*    */ import net.minecraftforge.fml.common.FMLCommonHandler;
/*    */ import org.apache.logging.log4j.Level;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ public class Log implements IModService
/*    */ {
/* 12 */   private final Logger logger = LogManager.getLogger(getModPrefix() + FMLCommonHandler.instance().getEffectiveSide());
/*    */   
/*    */   private static String getModPrefix() {
/* 15 */     return "intangible: ";
/*    */   }
/*    */   
/*    */   public void warning(String msg) {
/* 19 */     this.logger.log(Level.WARN, getModPrefix() + msg);
/*    */   }
/*    */   
/*    */   public void warning(Throwable exception, String msg) {
/* 23 */     this.logger.log(Level.WARN, getModPrefix() + msg);
/* 24 */     exception.printStackTrace();
/*    */   }
/*    */   
/*    */   public void debug(String msg) {
/* 28 */     if (Get.config().DEBUG_ENABLED) {
/* 29 */       this.logger.log(Level.INFO, getModPrefix() + msg);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/config/Log.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */