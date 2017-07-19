/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelFoci;
/*    */ import emoniph.intangible.util.MathUtil;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class RenderFoci
/*    */ {
/* 14 */   private ModelFoci model = new ModelFoci();
/* 15 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/foci.png");
/*    */   
/*    */   public void render(EntityPlayer player, double x, double y, double z, float partialTicks, RendererLivingEntity renderer) {
/* 18 */     float f2 = MathUtil.interpolateRotation(player.field_70760_ar, player.field_70761_aq, partialTicks);
/* 19 */     float f3 = MathUtil.interpolateRotation(player.field_70758_at, player.field_70759_as, partialTicks);
/* 20 */     float f4 = f3 - f2;
/* 21 */     float f9 = player.field_70127_C + (player.field_70125_A - player.field_70127_C) * partialTicks;
/*    */     
/* 23 */     this.model.gem.field_78796_g = (f4 / 57.295776F);
/* 24 */     this.model.gem.field_78795_f = (f9 / 57.295776F);
/*    */     
/* 26 */     if (player.func_70093_af()) {
/* 27 */       this.model.gem.field_78797_d = 4.0F;
/*    */     } else {
/* 29 */       this.model.gem.field_78797_d = 0.0F;
/*    */     }
/*    */     
/* 32 */     GlStateManager.func_179094_E();
/* 33 */     GlStateManager.func_179137_b(x, y, z);
/* 34 */     GlStateManager.func_179114_b(180.0F - f2, 0.0F, 1.0F, 0.0F);
/* 35 */     GlStateManager.func_179091_B();
/* 36 */     GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
/* 37 */     float f1 = 0.9375F;
/* 38 */     GlStateManager.func_179152_a(f1, f1, f1);
/* 39 */     GlStateManager.func_179109_b(0.0F, -1.5078125F, 0.0F);
/*    */     
/* 41 */     renderer.func_110776_a(TEXTURE);
/* 42 */     this.model.func_78088_a(player, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/* 43 */     GlStateManager.func_179121_F();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderFoci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */