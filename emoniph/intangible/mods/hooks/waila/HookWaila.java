/*    */ package emoniph.intangible.mods.hooks.waila;
/*    */ 
/*    */ import emoniph.intangible.mods.Hook;
/*    */ 
/*    */ public class HookWaila extends Hook
/*    */ {
/*    */   public HookWaila() {
/*  8 */     super("Waila");
/*    */   }
/*    */   
/*    */   protected void doInit()
/*    */   {
/* 13 */     net.minecraftforge.fml.common.event.FMLInterModComms.sendMessage(this.MOD_ID, "register", "emoniph.intangible.mods.hooks.waila.WailaRegistrar.callbackRegister");
/*    */   }
/*    */   
/*    */   protected void doPostInit() {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/waila/HookWaila.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */