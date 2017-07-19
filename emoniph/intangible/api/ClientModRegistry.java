/*    */ package emoniph.intangible.api;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class ClientModRegistry
/*    */ {
/* 15 */   public static final ClientModRegistry INSTANCE = new ClientModRegistry();
/*    */   
/* 17 */   private final List<IClientMod> clientMods = new ArrayList();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public final void register(IClientMod clientMod)
/*    */   {
/* 24 */     this.clientMods.add(clientMod);
/*    */   }
/*    */   
/*    */   public final void init(IModApi modApi)
/*    */   {
/* 29 */     for (IClientMod clientMod : this.clientMods) {
/* 30 */       clientMod.init(modApi);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/ClientModRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */