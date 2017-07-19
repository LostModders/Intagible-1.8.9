/*    */ package emoniph.intangible;
/*    */ 
/*    */ public class GlowServer implements IGlow {
/*  4 */   public static GlowServer INSTANCE = new GlowServer();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public IGlow motion(double x, double y, double z)
/*    */   {
/* 12 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow acceleration(float x, float y, float z)
/*    */   {
/* 17 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow color(int color, int variation)
/*    */   {
/* 22 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow color(float r, float g, float b, float variation)
/*    */   {
/* 27 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow color(int color)
/*    */   {
/* 32 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow color(float r, float g, float b)
/*    */   {
/* 37 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow scale(float scaleFactor)
/*    */   {
/* 42 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow scaleExact(float scale)
/*    */   {
/* 47 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow durationScale(float scale)
/*    */   {
/* 52 */     return this;
/*    */   }
/*    */   
/*    */   public IGlow duration(int ticks)
/*    */   {
/* 57 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   public IGlow dampening(float dampening)
/*    */   {
/* 63 */     return this;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/GlowServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */