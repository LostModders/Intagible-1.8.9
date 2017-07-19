/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockReconstructor.TileEntityReconstructor;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelReconstructor;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderReconstructor
/*    */   extends TileEntitySpecialRenderer
/*    */ {
/* 25 */   private ModelReconstructor model = new ModelReconstructor();
/*    */   
/* 27 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/reconstructor.png");
/*    */   
/*    */ 
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 32 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 33 */     if ((state.func_177230_c() == Get.blocks().RECONSTRUCTOR) && ((tile instanceof BlockReconstructor.TileEntityReconstructor))) {
/* 34 */       GlStateManager.func_179094_E();
/*    */       
/* 36 */       GlStateManager.func_179147_l();
/* 37 */       GlStateManager.func_179112_b(770, 771);
/* 38 */       GlStateManager.func_179092_a(516, 0.01F);
/*    */       
/* 40 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/* 41 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 42 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */       
/* 44 */       func_147499_a(TEXTURE);
/*    */       
/* 46 */       Minecraft mc = Minecraft.func_71410_x();
/* 47 */       BlockReconstructor.TileEntityReconstructor infuser = (BlockReconstructor.TileEntityReconstructor)tile;
/*    */       
/* 49 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 51 */       long progressTicks = infuser.getProgress() * 20 + infuser.getCounter() % 20L;
/* 52 */       if ((progressTicks >= 100L) && (progressTicks < 400L)) {
/* 53 */         long modTicks = progressTicks - 100L;
/* 54 */         float progressFactor = 0.0F;
/* 55 */         if (modTicks <= 150L) {
/* 56 */           progressFactor = (float)modTicks / 150.0F;
/* 57 */         } else if (modTicks <= 300L) {
/* 58 */           progressFactor = (300.0F - (float)modTicks) / 150.0F;
/*    */         }
/* 60 */         float move = progressFactor * 36.0F;
/* 61 */         this.model.shieldInner.field_78797_d = (8.0F - move);
/* 62 */         this.model.shieldOuter.field_78797_d = (8.0F - move);
/* 63 */         this.model.shieldInner.field_78796_g = ((float)Math.toRadians(infuser.getCounter() * 4L % 360L));
/* 64 */         this.model.shieldOuter.field_78796_g = ((float)Math.toRadians(360L - infuser.getCounter() * 3L % 360L));
/*    */         
/* 66 */         float alpha = progressFactor < 0.1F ? progressFactor / 0.1F * 0.4F : 0.4F;
/* 67 */         GlStateManager.func_179131_c(0.5F, 0.5F, 0.0F, alpha);
/* 68 */         this.model.shieldInner.func_78785_a(0.0625F);
/* 69 */         this.model.shieldOuter.func_78785_a(0.0625F);
/* 70 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*    */       }
/*    */       
/* 73 */       GlStateManager.func_179084_k();
/* 74 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderReconstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */