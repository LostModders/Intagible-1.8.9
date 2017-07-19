/*    */ package emoniph.intangible.mods;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ 
/*    */ public abstract class Hook
/*    */ {
/*  7 */   protected boolean initialized = false;
/*    */   public final String MOD_ID;
/*    */   
/*    */   protected Hook(String modId) {
/* 11 */     this.MOD_ID = modId;
/*    */   }
/*    */   
/*    */   final void init() {
/* 15 */     this.initialized = ((Get.config().MOD_HOOKS_ENABLED) && (net.minecraftforge.fml.common.Loader.isModLoaded(this.MOD_ID)));
/* 16 */     if (this.initialized) {
/*    */       try {
/* 18 */         doInit();
/* 19 */         Get.log().debug(String.format("Mod: %s support initialized", new Object[] { this.MOD_ID }));
/*    */       } catch (Throwable ex) {
/* 21 */         Get.log().warning(ex, String.format("Mod: %s, Exception occurred during init", new Object[] { this.MOD_ID }));
/*    */       }
/*    */     } else {
/* 24 */       Get.log().debug(String.format("Mod: %s not found", new Object[] { this.MOD_ID }));
/*    */     }
/*    */   }
/*    */   
/*    */   final void postInit() {
/* 29 */     if (this.initialized) {
/*    */       try {
/* 31 */         doPostInit();
/* 32 */         Get.log().debug(String.format("Mod: %s support post initialized", new Object[] { this.MOD_ID }));
/*    */       } catch (Throwable ex) {
/* 34 */         Get.log().warning(ex, String.format("Mod: %s, Exception occurred during post init", new Object[] { this.MOD_ID }));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   protected abstract void doInit();
/*    */   
/*    */   protected abstract void doPostInit();
/*    */   
/*    */   public String toString()
/*    */   {
/* 45 */     return this.MOD_ID;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/Hook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */