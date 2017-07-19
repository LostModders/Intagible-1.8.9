/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockSoulWard.TileEntitySoulWard;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelSoulWard;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockBed;
/*    */ import net.minecraft.block.BlockBed.EnumPartType;
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
/*    */ public class RenderWard extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 23 */   private ModelSoulWard model = new ModelSoulWard();
/*    */   
/* 25 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/soulward.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 29 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 30 */     if ((state.func_177230_c() == Get.blocks().SOUL_WARD) && (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) && ((tile instanceof BlockSoulWard.TileEntitySoulWard)))
/*    */     {
/* 32 */       GlStateManager.func_179094_E();
/* 33 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/* 34 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 35 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */       
/* 37 */       BlockSoulWard.TileEntitySoulWard ward = (BlockSoulWard.TileEntitySoulWard)tile;
/* 38 */       long ticks = ward.getTicks();
/*    */       
/* 40 */       int MAX_TICKS = 100;
/*    */       
/* 42 */       if ((ticks >= 0L) && (ticks < MAX_TICKS)) {
/* 43 */         GlStateManager.func_179109_b(0.0F, 2.0F - 2.0F * (float)ticks / 100.0F, 0.0F);
/* 44 */         if ((ticks > 0L) && (ticks % 5L == 0L)) {
/* 45 */           tile.func_145831_w().func_175718_b(2001, tile.func_174877_v().func_177977_b(), Block.func_149682_b(net.minecraft.init.Blocks.field_150348_b));
/*    */         }
/*    */       }
/*    */       
/* 49 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*    */       
/* 51 */       GlStateManager.func_179114_b(emoniph.intangible.util.BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*    */       
/* 53 */       func_147499_a(TEXTURE);
/*    */       
/* 55 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 57 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderWard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */