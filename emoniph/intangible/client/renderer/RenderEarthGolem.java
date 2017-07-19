/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityEarthGolem;
/*    */ import net.minecraft.client.renderer.entity.RenderIronGolem;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.monster.EntityIronGolem;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class RenderEarthGolem extends RenderIronGolem
/*    */ {
/*    */   public RenderEarthGolem(RenderManager rm)
/*    */   {
/* 15 */     super(rm);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(EntityIronGolem entity)
/*    */   {
/* 20 */     EntityEarthGolem golem = (EntityEarthGolem)entity;
/* 21 */     return golem.getMaterial().getSkinTexture();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderEarthGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */