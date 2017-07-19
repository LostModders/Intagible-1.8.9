/*    */ package emoniph.intangible.deity;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeityVoice;
/*    */ 
/*    */ public class DeityVoice implements IDeityVoice
/*    */ {
/*    */   private final String sound;
/*    */   
/*    */   public DeityVoice(String sound) {
/* 10 */     this.sound = sound;
/*    */   }
/*    */   
/*    */   public String getSound()
/*    */   {
/* 15 */     return this.sound;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/DeityVoice.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */