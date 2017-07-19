/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class RenderSpell extends Render
/*    */ {
/*    */   private float scale;
/*    */   
/*    */   public RenderSpell(RenderManager renderManager, float scale)
/*    */   {
/* 17 */     super(renderManager);
/* 18 */     this.scale = scale;
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
/*    */   public void doRender(EntitySpell entity, double x, double y, double z, float p_76986_8_, float partialTicks)
/*    */   {
/* 49 */     super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
/*    */   }
/*    */   
/*    */   private ResourceLocation getEntityTexture(EntitySpell entity) {
/* 53 */     return net.minecraft.client.renderer.texture.TextureMap.field_110575_b;
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 57 */     return getEntityTexture((EntitySpell)entity);
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
/* 61 */     doRender((EntitySpell)entity, x, y, z, p_76986_8_, partialTicks);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSpell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */