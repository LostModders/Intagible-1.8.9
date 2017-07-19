/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelSpikeBall;
/*    */ import emoniph.intangible.entity.EntitySpikeBall;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class RenderSpikeBall extends RenderLiving
/*    */ {
/* 16 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/spikeball.png");
/*    */   
/*    */   public RenderSpikeBall(RenderManager renderManager) {
/* 19 */     super(renderManager, new ModelSpikeBall(), 0.25F);
/*    */   }
/*    */   
/*    */   public void doRenderBall(EntitySpikeBall entity, double par2, double par4, double par6, float par8, float par9) {
/* 23 */     super.func_76986_a(entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */   
/*    */   protected void rotateBallCorpse(EntitySpikeBall entity, float par2, float par3, float par4) {
/* 27 */     super.func_77043_a(entity, par2, par3, par4);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getBallTexture(EntitySpikeBall entity)
/*    */   {
/* 32 */     return TEXTURE;
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 37 */     return getBallTexture((EntitySpikeBall)entity);
/*    */   }
/*    */   
/*    */   public void func_76986_a(EntityLiving entity, double par2, double par4, double par6, float par8, float par9)
/*    */   {
/* 42 */     doRenderBall((EntitySpikeBall)entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */   
/*    */   protected void func_77043_a(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
/*    */   {
/* 47 */     rotateBallCorpse((EntitySpikeBall)par1EntityLivingBase, par2, par3, par4);
/*    */   }
/*    */   
/*    */   public void func_76986_a(EntityLivingBase par1, double par2, double par4, double par6, float par8, float par9)
/*    */   {
/* 52 */     doRenderBall((EntitySpikeBall)par1, par2, par4, par6, par8, par9);
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double par2, double par4, double par6, float par8, float par9)
/*    */   {
/* 57 */     doRenderBall((EntitySpikeBall)entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSpikeBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */