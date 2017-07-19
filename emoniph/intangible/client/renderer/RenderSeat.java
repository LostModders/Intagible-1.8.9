/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySeat;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ 
/*    */ public class RenderSeat extends Render<EntitySeat>
/*    */ {
/*    */   public RenderSeat(net.minecraft.client.renderer.entity.RenderManager renderManager)
/*    */   {
/* 10 */     super(renderManager);
/*    */   }
/*    */   
/*    */   protected net.minecraft.util.ResourceLocation getEntityTexture(EntitySeat entity)
/*    */   {
/* 15 */     return null;
/*    */   }
/*    */   
/*    */   public void doRender(EntitySeat entity, double x, double y, double z, float entityYaw, float partialTicks)
/*    */   {
/* 20 */     super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */