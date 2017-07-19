/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelWreckingGolem;
/*    */ import emoniph.intangible.entity.EntityWreckingGolem;
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
/*    */ public class RenderWreckingGolem extends RenderLiving
/*    */ {
/* 17 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/wreckinggolem.png");
/*    */   
/*    */   public RenderWreckingGolem(RenderManager p_i46133_1_) {
/* 20 */     super(p_i46133_1_, new ModelWreckingGolem(), 0.5F);
/*    */   }
/*    */   
/*    */   public void func_76986_a(EntityLiving entity, double x, double y, double z, float p_76986_8_, float partialTicks)
/*    */   {
/* 25 */     super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityWreckingGolem entity) {
/* 29 */     return TEXTURE;
/*    */   }
/*    */   
/*    */   protected void rotateCorpse(EntityWreckingGolem entity, float p_180588_2_, float p_180588_3_, float p_180588_4_) {
/* 33 */     super.func_77043_a(entity, p_180588_2_, p_180588_3_, p_180588_4_);
/*    */     
/* 35 */     if (((entity.getSeat() == null) || (entity.getSeat().field_70153_n == null)) && 
/* 36 */       (entity.field_70721_aZ >= 0.01D)) {
/* 37 */       float f3 = 13.0F;
/* 38 */       float f4 = entity.field_70754_ba - entity.field_70721_aZ * (1.0F - p_180588_4_) + 6.0F;
/* 39 */       float f5 = (Math.abs(f4 % f3 - f3 * 0.5F) - f3 * 0.25F) / (f3 * 0.25F);
/* 40 */       net.minecraft.client.renderer.GlStateManager.func_179114_b(6.5F * f5, 0.0F, 0.0F, 1.0F);
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   protected void func_77043_a(EntityLivingBase entity, float p_77043_2_, float p_77043_3_, float p_77043_4_)
/*    */   {
/* 47 */     rotateCorpse((EntityWreckingGolem)entity, p_77043_2_, p_77043_3_, p_77043_4_);
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity)
/*    */   {
/* 52 */     return getEntityTexture((EntityWreckingGolem)entity);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderWreckingGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */