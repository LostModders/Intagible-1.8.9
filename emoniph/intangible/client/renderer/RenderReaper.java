/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelReaper;
/*    */ import emoniph.intangible.entity.EntityReaper;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class RenderReaper extends RenderLiving<EntityReaper>
/*    */ {
/* 13 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/reaper.png");
/*    */   
/*    */   public RenderReaper(RenderManager renderManager) {
/* 16 */     super(renderManager, new ModelReaper(), 0.5F);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityReaper entity)
/*    */   {
/* 21 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderReaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */