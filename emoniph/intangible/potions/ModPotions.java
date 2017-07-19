/*    */ package emoniph.intangible.potions;
/*    */ 
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ public class ModPotions implements emoniph.intangible.init.IModService
/*    */ {
/*  8 */   public static final Potion BLOODLUST = new PotionBloodlust(new ResourceLocation("intangible:bloodlust"));
/*  9 */   public static final Potion COWARDLY = new PotionCowardly(new ResourceLocation("intangible:cowardly"));
/* 10 */   public static final PotionTank TANK = new PotionTank(new ResourceLocation("intangible:tank"));
/* 11 */   public static final PotionPickpocket PICKPOCKET = new PotionPickpocket(new ResourceLocation("intangible:pickpocket"));
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/potions/ModPotions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */