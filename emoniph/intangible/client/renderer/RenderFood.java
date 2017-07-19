/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityFood;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class RenderFood extends Render<EntityFood>
/*    */ {
/*    */   public RenderFood(RenderManager renderManager)
/*    */   {
/* 17 */     super(renderManager);
/*    */   }
/*    */   
/*    */   public void doRender(EntityFood entity, double x, double y, double z, float entityYaw, float partialTicks) {
/* 21 */     GlStateManager.func_179094_E();
/* 22 */     GlStateManager.func_179109_b((float)x, (float)y, (float)z);
/* 23 */     GlStateManager.func_179091_B();
/* 24 */     GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/* 25 */     GlStateManager.func_179114_b(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 26 */     GlStateManager.func_179114_b(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 27 */     func_110776_a(getEntityTexture(entity));
/* 28 */     Minecraft.func_71410_x().func_175599_af().func_181564_a(entity.getItemStack(), net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.GROUND);
/* 29 */     GlStateManager.func_179101_C();
/* 30 */     GlStateManager.func_179121_F();
/* 31 */     super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
/*    */   }
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityFood entity) {
/* 35 */     return net.minecraft.client.renderer.texture.TextureMap.field_110575_b;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */