/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockBlowMold.TileEntityBlowMold;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelBlowMold;
/*    */ import emoniph.intangible.util.RenderUtil;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fluids.Fluid;
/*    */ import net.minecraftforge.fluids.FluidStack;
/*    */ import net.minecraftforge.fluids.FluidTankInfo;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderBlowMold extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 25 */   private ModelBlowMold model = new ModelBlowMold();
/*    */   
/*    */ 
/* 28 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/blowmold.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 32 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 33 */     if ((state.func_177230_c() == Get.blocks().BLOW_MOLD) && ((tile instanceof BlockBlowMold.TileEntityBlowMold)))
/*    */     {
/* 35 */       GlStateManager.func_179094_E();
/*    */       
/* 37 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*    */       
/* 39 */       BlockBlowMold.TileEntityBlowMold blowMold = (BlockBlowMold.TileEntityBlowMold)tile;
/*    */       
/* 41 */       Minecraft mc = Minecraft.func_71410_x();
/*    */       
/*    */ 
/* 44 */       net.minecraft.item.ItemStack stack = blowMold.func_70301_a(1);
/* 45 */       this.model.top.field_78806_j = (stack != null);
/* 46 */       float scale = 0.6F;
/* 47 */       if (stack != null) {
/* 48 */         float upShift = 0.4F;
/*    */         
/* 50 */         func_147499_a(TextureMap.field_110575_b);
/*    */         
/* 52 */         GlStateManager.func_179094_E();
/* 53 */         GlStateManager.func_179109_b(0.0F, upShift, 0.0F);
/* 54 */         GlStateManager.func_179152_a(scale, scale, scale);
/* 55 */         GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
/* 56 */         mc.func_175599_af().func_181564_a(stack, net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.GROUND);
/* 57 */         GlStateManager.func_179121_F();
/*    */       }
/*    */       
/* 60 */       FluidTankInfo tank = blowMold.getTankInfo(net.minecraft.util.EnumFacing.UP)[0];
/* 61 */       if ((tank != null) && (tank.fluid != null) && (tank.fluid.amount > 0)) {
/* 62 */         GlStateManager.func_179094_E();
/* 63 */         GlStateManager.func_179140_f();
/* 64 */         GlStateManager.func_179109_b(0.0F, 0.6F, 0.0F);
/*    */         
/* 66 */         GlStateManager.func_179152_a(scale, scale, scale);
/* 67 */         GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
/* 68 */         Fluid fluid = tank.fluid.getFluid();
/*    */         
/* 70 */         if (fluid.getBlock() != null) {
/* 71 */           GlStateManager.func_179144_i(mc.func_147117_R().func_110552_b());
/* 72 */           GlStateManager.func_179114_b(180.0F, 1.0F, 0.0F, 0.0F);
/* 73 */           GlStateManager.func_179137_b(-0.6D, -0.6D, 0.4D);
/* 74 */           GlStateManager.func_179139_a(0.15D, 0.15D, 0.15D);
/*    */           
/* 76 */           RenderUtil.color(fluid.getColor(tank.fluid));
/* 77 */           net.minecraft.client.renderer.texture.TextureAtlasSprite sprite = mc.func_147117_R().getTextureExtry(fluid.getStill(tank.fluid).toString());
/*    */           
/* 79 */           RenderUtil.drawTexturedModalRect(0, 0, sprite, 8, 8, 1.0F);
/*    */           
/* 81 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 82 */           GlStateManager.func_179145_e();
/* 83 */           GlStateManager.func_179121_F();
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 88 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 89 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */       
/* 91 */       func_147499_a(TEXTURE);
/*    */       
/* 93 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 95 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderBlowMold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */