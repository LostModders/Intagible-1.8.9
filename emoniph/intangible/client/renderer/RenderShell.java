/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockShell.TileEntityShell;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.entity.EntityProxy;
/*    */ import emoniph.intangible.util.BlockUtil;
/*    */ import net.minecraft.block.BlockDirectional;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelPlayer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderShell extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 28 */   private static final ModelPlayer steve = new ModelPlayer(0.0F, false);
/* 29 */   private static final ModelPlayer alex = new ModelPlayer(0.0F, true);
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 33 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 34 */     if ((state.func_177230_c() != Get.blocks().PLAYER_SHELL) || (!(tile instanceof BlockShell.TileEntityShell))) {
/* 35 */       return;
/*    */     }
/*    */     
/* 38 */     GlStateManager.func_179094_E();
/*    */     
/* 40 */     GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*    */     
/* 42 */     BlockShell.TileEntityShell shell = (BlockShell.TileEntityShell)tile;
/*    */     
/* 44 */     Minecraft mc = Minecraft.func_71410_x();
/*    */     
/* 46 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 47 */     GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */     
/* 49 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 50 */     GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*    */     
/* 52 */     final ResourceLocation texture = shell.getLocationSkin();
/* 53 */     if (texture != null) {
/* 54 */       func_147499_a(texture);
/* 55 */       ModelPlayer model = shell.getSkinType().equals("slim") ? alex : steve;
/* 56 */       model.field_78091_s = false;
/* 57 */       model.field_78093_q = false;
/* 58 */       model.field_78117_n = false;
/* 59 */       model.field_78120_m = (shell.getProxyEntity().func_70694_bm() != null ? 1 : 0);
/* 60 */       float f1 = 0.9375F;
/*    */       
/* 62 */       RendererLivingEntity r = new RendererLivingEntity(mc.func_175598_ae(), model, 0.5F)
/*    */       {
/*    */         protected ResourceLocation func_110775_a(Entity entity) {
/* 65 */           return texture;
/*    */         }
/*    */         
/* 68 */       };
/* 69 */       GlStateManager.func_179152_a(f1, f1, f1);
/* 70 */       GlStateManager.func_179109_b(0.0F, (1.0F - f1) * 1.8F, 0.0F);
/* 71 */       model.func_78088_a(shell.getProxyEntity(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 73 */       new LayerBipedArmor(r).func_177141_a(shell.getProxyEntity(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/* 74 */       new LayerHeldItem(r).func_177141_a(shell.getProxyEntity(), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */     }
/*    */     
/* 77 */     GlStateManager.func_179121_F();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */