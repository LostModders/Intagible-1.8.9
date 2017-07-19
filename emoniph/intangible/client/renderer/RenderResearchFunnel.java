/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockResearch;
/*    */ import emoniph.intangible.blocks.BlockResearch.TileEntityResearchBlock;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelResearchFunnel;
/*    */ import emoniph.intangible.util.BlockUtil;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderResearchFunnel extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 22 */   private ModelResearchFunnel model = new ModelResearchFunnel();
/*    */   
/* 24 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/funnel.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 28 */     IBlockState mstate = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 29 */     if ((!(mstate.func_177230_c() instanceof emoniph.intangible.blocks.BlockResearchFunnel)) || (!(tile instanceof BlockResearch.TileEntityResearchBlock))) {
/* 30 */       return;
/*    */     }
/*    */     
/* 33 */     GlStateManager.func_179094_E();
/* 34 */     GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/* 35 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 36 */     GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */     
/* 38 */     func_147499_a(TEXTURE);
/*    */     
/* 40 */     GlStateManager.func_179112_b(770, 771);
/* 41 */     GlStateManager.func_179092_a(516, 0.001F);
/* 42 */     GlStateManager.func_179147_l();
/*    */     
/* 44 */     BlockResearch.TileEntityResearchBlock research = (BlockResearch.TileEntityResearchBlock)tile;
/*    */     
/*    */ 
/* 47 */     this.model.inputTube.field_78806_j = false;
/* 48 */     for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 49 */       IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v().func_177972_a(facing));
/* 50 */       if (state.func_177230_c() == Get.blocks().BONE_CAGE) {
/* 51 */         this.model.inputTube.field_78796_g = (facing.func_176736_b() * 1.5707964F);
/* 52 */         this.model.inputTube.field_78806_j = true;
/* 53 */         break;
/*    */       }
/*    */     }
/*    */     
/* 57 */     this.model.output.field_78806_j = false;
/* 58 */     for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 59 */       BlockPos otherPos = tile.func_174877_v().func_177972_a(facing);
/* 60 */       IBlockState state = tile.func_145831_w().func_180495_p(otherPos);
/* 61 */       if ((state.func_177230_c() instanceof BlockResearch)) {
/* 62 */         BlockResearch block = (BlockResearch)state.func_177230_c();
/* 63 */         BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/* 64 */         if (block.isInputFace(facing.func_176734_d(), otherTile)) {
/* 65 */           this.model.output.field_78806_j = true;
/* 66 */           this.model.output.field_78796_g = (facing.func_176736_b() * 1.5707964F);
/* 67 */           break;
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 72 */     if (research.getSoulType() != null) {
/* 73 */       if (research.isValid()) {
/* 74 */         this.model.setColorAugment(6815743);
/*    */       } else {
/* 76 */         this.model.setColorAugment(16762623);
/*    */       }
/*    */     } else {
/* 79 */       this.model.setColorAugment(6801151);
/*    */     }
/*    */     
/* 82 */     this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */     
/*    */ 
/* 85 */     GlStateManager.func_179147_l();
/* 86 */     GlStateManager.func_179121_F();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderResearchFunnel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */