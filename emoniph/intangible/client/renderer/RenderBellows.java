/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockBellows.TileEntityBellows;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelBellows;
/*    */ import net.minecraft.block.BlockDirectional;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderBellows extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 20 */   private ModelBellows model = new ModelBellows();
/*    */   
/* 22 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/bellows.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 26 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 27 */     if ((state.func_177230_c() == Get.blocks().BELLOWS) && ((tile instanceof BlockBellows.TileEntityBellows)))
/*    */     {
/* 29 */       GlStateManager.func_179094_E();
/*    */       
/* 31 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*    */       
/* 33 */       BlockBellows.TileEntityBellows bellows = (BlockBellows.TileEntityBellows)tile;
/*    */       
/*    */ 
/* 36 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 37 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */       
/*    */ 
/* 40 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 41 */       GlStateManager.func_179114_b(emoniph.intangible.util.BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*    */       
/* 43 */       func_147499_a(TEXTURE);
/*    */       
/* 45 */       float progress = 1.0F - bellows.getProgress();
/*    */       
/* 47 */       this.model.lid.field_78795_f = (progress * -0.7740535F);
/*    */       
/* 49 */       this.model.sack2.field_78795_f = (progress * -0.18203785F);
/* 50 */       this.model.sack3.field_78795_f = (progress * -0.3642502F);
/* 51 */       this.model.sack4.field_78795_f = (progress * -0.5462881F);
/* 52 */       this.model.sack5.field_78795_f = (progress * -0.7285004F);
/*    */       
/*    */ 
/* 55 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 57 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */