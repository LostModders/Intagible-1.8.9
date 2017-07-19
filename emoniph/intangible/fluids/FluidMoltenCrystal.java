/*    */ package emoniph.intangible.fluids;
/*    */ 
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class FluidMoltenCrystal extends net.minecraftforge.fluids.Fluid
/*    */ {
/*    */   private final int color;
/*    */   
/*    */   public FluidMoltenCrystal(String id, int color) {
/* 10 */     super(id, new ResourceLocation("intangible:blocks/moltencrystal_still"), new ResourceLocation("intangible:blocks/moltencrystal_flow"));
/*    */     
/* 12 */     this.color = color;
/* 13 */     setLuminosity(10);
/* 14 */     setDensity(3000);
/* 15 */     setViscosity(6000);
/* 16 */     setTemperature(1000);
/*    */   }
/*    */   
/*    */   public int getColor()
/*    */   {
/* 21 */     return this.color;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/fluids/FluidMoltenCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */