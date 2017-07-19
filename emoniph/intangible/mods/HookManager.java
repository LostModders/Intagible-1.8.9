/*    */ package emoniph.intangible.mods;
/*    */ 
/*    */ import emoniph.intangible.init.IModInit;
/*    */ import emoniph.intangible.init.IModPostInit;
/*    */ import emoniph.intangible.init.IModService;
/*    */ import emoniph.intangible.mods.hooks.waila.HookWaila;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*    */ import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
/*    */ 
/*    */ public class HookManager implements IModService, IModInit, IModPostInit
/*    */ {
/* 14 */   private final List<Hook> hooks = new ArrayList();
/*    */   
/* 16 */   private final Hook WAILA = register(new HookWaila());
/*    */   
/*    */   public void init(FMLInitializationEvent event)
/*    */   {
/* 20 */     for (Hook hook : this.hooks) {
/* 21 */       hook.init();
/*    */     }
/*    */   }
/*    */   
/*    */   public void postInit(FMLPostInitializationEvent event)
/*    */   {
/* 27 */     for (Hook hook : this.hooks) {
/* 28 */       hook.postInit();
/*    */     }
/*    */   }
/*    */   
/*    */   private <T extends Hook> T register(T hook) {
/* 33 */     this.hooks.add(hook);
/* 34 */     return hook;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/HookManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */