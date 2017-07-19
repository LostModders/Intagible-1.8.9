/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySeeker;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class RenderSeeker extends Render
/*    */ {
/*    */   private float scale;
/*    */   
/*    */   public RenderSeeker(RenderManager renderManager, float scale)
/*    */   {
/* 18 */     super(renderManager);
/* 19 */     this.scale = scale;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void doRender(EntitySeeker entity, double x, double y, double z, float p_76986_8_, float partialTicks)
/*    */   {
/* 50 */     super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
/*    */   }
/*    */   
/*    */   private ResourceLocation getEntityTexture(EntitySpell entity) {
/* 54 */     return net.minecraft.client.renderer.texture.TextureMap.field_110575_b;
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 58 */     return getEntityTexture((EntitySpell)entity);
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
/* 62 */     doRender((EntitySeeker)entity, x, y, z, p_76986_8_, partialTicks);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSeeker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */