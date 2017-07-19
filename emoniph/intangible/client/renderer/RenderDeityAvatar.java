/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeityAvatarBody;
/*    */ import emoniph.intangible.client.models.ModelDeityAvatar;
/*    */ import emoniph.intangible.deity.ModDeityEffects;
/*    */ import emoniph.intangible.entity.EntityAvatar;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderDeityAvatar extends RenderLiving
/*    */ {
/*    */   public RenderDeityAvatar(RenderManager renderManager)
/*    */   {
/* 21 */     super(renderManager, new ModelDeityAvatar(), 0.5F);
/*    */   }
/*    */   
/*    */   public void doRenderAvatar(EntityAvatar entity, double par2, double par4, double par6, float par8, float par9) {
/* 25 */     net.minecraft.entity.boss.BossStatus.func_82824_a(entity, true);
/* 26 */     super.func_76986_a(entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */   
/*    */   protected void rotateAvatarCorpse(EntityAvatar entity, float par2, float par3, float par4) {
/* 30 */     super.func_77043_a(entity, par2, par3, par4);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getAvatarTexture(EntityAvatar entity) {
/* 34 */     IDeityAvatarBody body = emoniph.intangible.Get.deityEffects().getAvatarBody(entity);
/* 35 */     return body.getTexture(entity);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 40 */     return getAvatarTexture((EntityAvatar)entity);
/*    */   }
/*    */   
/*    */   public void func_76986_a(EntityLiving entity, double par2, double par4, double par6, float par8, float par9)
/*    */   {
/* 45 */     doRenderAvatar((EntityAvatar)entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */   
/*    */   protected void func_77043_a(EntityLivingBase par1EntityLivingBase, float par2, float par3, float par4)
/*    */   {
/* 50 */     rotateAvatarCorpse((EntityAvatar)par1EntityLivingBase, par2, par3, par4);
/*    */   }
/*    */   
/*    */   public void func_76986_a(EntityLivingBase par1, double par2, double par4, double par6, float par8, float par9)
/*    */   {
/* 55 */     doRenderAvatar((EntityAvatar)par1, par2, par4, par6, par8, par9);
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double par2, double par4, double par6, float par8, float par9)
/*    */   {
/* 60 */     doRenderAvatar((EntityAvatar)entity, par2, par4, par6, par8, par9);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderDeityAvatar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */