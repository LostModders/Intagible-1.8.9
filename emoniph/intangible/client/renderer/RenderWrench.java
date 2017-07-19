/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockSoulWrench.TileEntitySoulWrench;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelWrench;
/*    */ import emoniph.intangible.client.particle.BeamFX;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderWrench extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*    */ {
/* 19 */   private ModelWrench model = new ModelWrench();
/*    */   
/* 21 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/soulwrench.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 25 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 26 */     if ((state.func_177230_c() != emoniph.intangible.Get.blocks().SOUL_WRENCH) || (!(tile instanceof BlockSoulWrench.TileEntitySoulWrench))) {
/* 27 */       return;
/*    */     }
/*    */     
/* 30 */     GlStateManager.func_179094_E();
/* 31 */     GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/* 32 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 33 */     GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */     
/* 35 */     func_147499_a(TEXTURE);
/*    */     
/* 37 */     Minecraft mc = Minecraft.func_71410_x();
/*    */     
/* 39 */     BlockSoulWrench.TileEntitySoulWrench wrench = (BlockSoulWrench.TileEntitySoulWrench)tile;
/*    */     
/* 41 */     float activeTicks = wrench.getActiveTicks();
/*    */     
/* 43 */     if (wrench.isActive()) {
/* 44 */       double angle = Math.toRadians(mc.field_71441_e.func_72820_D() % 360L);
/* 45 */       double rotation = angle * 3.0D % 3.141592653589793D;
/* 46 */       double rotation2 = angle * 6.0D % 3.141592653589793D;
/*    */       
/* 48 */       this.model.core.field_78796_g = ((float)rotation);
/* 49 */       this.model.gyro.field_78796_g = ((float)-rotation2);
/*    */     } else {
/* 51 */       this.model.core.field_78796_g = 0.0F;
/* 52 */       this.model.gyro.field_78796_g = 0.0F;
/*    */     }
/*    */     
/* 55 */     float MIN = -0.273F;
/* 56 */     float MAX = -0.5F;
/*    */     
/* 58 */     float progress = Math.min(activeTicks, 100.0F) / 100.0F;
/*    */     
/* 60 */     float range = MAX - MIN;
/* 61 */     float spreadAngle = MIN + progress * range;
/*    */     
/* 63 */     this.model.arm1.field_78795_f = spreadAngle;
/* 64 */     this.model.arm2.field_78795_f = spreadAngle;
/* 65 */     this.model.arm3.field_78795_f = spreadAngle;
/* 66 */     this.model.arm4.field_78795_f = spreadAngle;
/*    */     
/*    */ 
/* 69 */     float GYRO_MIN = 6.0F;
/* 70 */     float GYRO_MAX = -5.5F;
/*    */     
/* 72 */     float gyroRange = GYRO_MAX - GYRO_MIN;
/*    */     
/* 74 */     float position = GYRO_MIN + progress * gyroRange;
/*    */     
/* 76 */     this.model.gyro.field_78797_d = position;
/*    */     
/* 78 */     this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */     
/* 80 */     GlStateManager.func_179121_F();
/*    */     
/* 82 */     if (wrench.getTarget() != null) {
/* 83 */       BeamFX.draw(wrench.func_174877_v(), x, y, z, 0.0F, (int)wrench.getCounter(), wrench.getTarget());
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderWrench.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */