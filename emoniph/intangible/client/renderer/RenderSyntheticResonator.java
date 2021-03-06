/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockSyntheticResonator.TileEntitySyntheticResonator;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelSyntheticResonator;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderSyntheticResonator extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 17 */   private ModelSyntheticResonator model = new ModelSyntheticResonator();
/*    */   
/* 19 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/syntheticresonator.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 23 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 24 */     if ((state.func_177230_c() != emoniph.intangible.Get.blocks().SYNTHETIC_RESONATOR) || (!(tile instanceof BlockSyntheticResonator.TileEntitySyntheticResonator))) {
/* 25 */       return;
/*    */     }
/*    */     
/* 28 */     GlStateManager.func_179094_E();
/*    */     
/* 30 */     GlStateManager.func_179112_b(770, 771);
/* 31 */     GlStateManager.func_179092_a(516, 0.01F);
/* 32 */     GlStateManager.func_179147_l();
/*    */     
/* 34 */     GlStateManager.func_179145_e();
/* 35 */     GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*    */     
/* 37 */     BlockSyntheticResonator.TileEntitySyntheticResonator resonator = (BlockSyntheticResonator.TileEntitySyntheticResonator)tile;
/*    */     
/* 39 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 40 */     GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */     
/* 42 */     func_147499_a(TEXTURE);
/*    */     
/* 44 */     if (resonator.isActivated()) {
/* 45 */       float ticks = (float)resonator.func_145831_w().func_82737_E() / 4.0F % 360.0F;
/* 46 */       this.model.top.field_78796_g = ((float)Math.toRadians(ticks));
/*    */     }
/* 48 */     this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */     
/* 50 */     GlStateManager.func_179084_k();
/* 51 */     GlStateManager.func_179121_F();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSyntheticResonator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */