/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockOfferingPlate.TileEntityOfferingPlate;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelPlate;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPlate extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 22 */   private ModelPlate model = new ModelPlate();
/*    */   
/*    */ 
/* 25 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/plate.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 29 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 30 */     if ((state.func_177230_c() == emoniph.intangible.Get.blocks().OFFERING_PLATE) && ((tile instanceof BlockOfferingPlate.TileEntityOfferingPlate))) {
/* 31 */       GlStateManager.func_179094_E();
/*    */       
/* 33 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*    */       
/* 35 */       BlockOfferingPlate.TileEntityOfferingPlate plate = (BlockOfferingPlate.TileEntityOfferingPlate)tile;
/* 36 */       net.minecraft.item.ItemStack stack = plate.func_70301_a(0);
/* 37 */       if (stack != null) {
/* 38 */         GlStateManager.func_179094_E();
/* 39 */         GlStateManager.func_179140_f();
/*    */         
/* 41 */         float upShift = -0.35F;
/* 42 */         GlStateManager.func_179109_b(0.0F, upShift, 0.0F);
/*    */         
/*    */ 
/* 45 */         float scale = 0.3F;
/* 46 */         GlStateManager.func_179152_a(scale, scale, scale);
/*    */         
/* 48 */         Minecraft mc = Minecraft.func_71410_x();
/*    */         
/* 50 */         double dx = tile.func_174877_v().func_177958_n() + 0.5D - mc.field_71439_g.field_70165_t;
/* 51 */         double dz = tile.func_174877_v().func_177952_p() + 0.5D - mc.field_71439_g.field_70161_v;
/*    */         
/* 53 */         int angle = MathHelper.func_76143_f(Math.atan2(dx, dz) * 180.0D / 3.141592653589793D);
/*    */         
/* 55 */         GlStateManager.func_179114_b(angle, 0.0F, 1.0F, 0.0F);
/* 56 */         GlStateManager.func_179114_b(55.0F, 1.0F, 0.0F, 0.0F);
/*    */         
/* 58 */         func_147499_a(TextureMap.field_110575_b);
/* 59 */         mc.func_175599_af().func_181564_a(stack, net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.GROUND);
/*    */         
/* 61 */         GlStateManager.func_179145_e();
/* 62 */         GlStateManager.func_179121_F();
/*    */       }
/*    */       
/* 65 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 66 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */       
/* 68 */       GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/* 69 */       func_147499_a(TEXTURE);
/*    */       
/* 71 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 73 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderPlate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */