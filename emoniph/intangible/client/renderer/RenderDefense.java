/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockDefense.TileEntityDefense;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelDefense;
/*    */ import emoniph.intangible.util.RenderUtil;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderDefense extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 19 */   private ModelDefense model = new ModelDefense();
/*    */   
/* 21 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/defense.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 25 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 26 */     if ((state.func_177230_c() == emoniph.intangible.Get.blocks().DEFENSE) && ((tile instanceof BlockDefense.TileEntityDefense)))
/*    */     {
/* 28 */       GlStateManager.func_179094_E();
/* 29 */       GlStateManager.func_179112_b(770, 771);
/* 30 */       GlStateManager.func_179092_a(516, 0.01F);
/* 31 */       GlStateManager.func_179147_l();
/* 32 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/* 33 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 34 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */       
/* 36 */       BlockDefense.TileEntityDefense defense = (BlockDefense.TileEntityDefense)tile;
/*    */       
/*    */ 
/* 39 */       func_147499_a(TEXTURE);
/*    */       
/* 41 */       int bands = 3 + defense.getDetectRadius() + defense.getEffectRadius();
/*    */       
/*    */ 
/*    */ 
/* 45 */       int i = 0;int yellow = 2 + defense.getEffectRadius(); for (int blue = 1 + defense.getDetectRadius(); i < bands; i++) {
/* 46 */         if ((yellow > 0) && (blue > 0)) {
/* 47 */           if (i % 2 == 0) {
/* 48 */             RenderUtil.color(14666772);
/* 49 */             yellow--;
/*    */           } else {
/* 51 */             RenderUtil.color(29695);
/* 52 */             blue--;
/*    */           }
/* 54 */         } else if (yellow > 0) {
/* 55 */           RenderUtil.color(14666772);
/* 56 */         } else if (blue > 0) {
/* 57 */           RenderUtil.color(29695);
/*    */         }
/*    */         
/* 60 */         this.model.band.field_78796_g = ((float)(6.283185307179586D / bands * i + (float)defense.func_145831_w().func_82737_E() / 20.0F % 6.283185307179586D));
/* 61 */         this.model.band.field_78797_d = 16.0F;
/* 62 */         this.model.band.func_78785_a(0.0625F);
/*    */       }
/*    */       
/*    */ 
/* 66 */       RenderUtil.color(defense.getColor());
/*    */       
/* 68 */       GlStateManager.func_179114_b((float)(-defense.func_145831_w().func_82737_E() % 360L), 0.0F, 1.0F, 0.0F);
/* 69 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 71 */       GlStateManager.func_179084_k();
/* 72 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderDefense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */