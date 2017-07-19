/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockSoulRelay.TileEntitySoulRelay;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelSoulRelay;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderRelay extends TileEntitySpecialRenderer
/*    */ {
/* 19 */   private ModelSoulRelay model = new ModelSoulRelay();
/*    */   
/* 21 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/soulrelay.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 25 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 26 */     if ((state.func_177230_c() == Get.blocks().SOUL_RELAY) && ((tile instanceof BlockSoulRelay.TileEntitySoulRelay))) {
/* 27 */       GlStateManager.func_179094_E();
/*    */       
/* 29 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/* 30 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 31 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*    */       
/* 33 */       BlockSoulRelay.TileEntitySoulRelay relay = (BlockSoulRelay.TileEntitySoulRelay)tile;
/*    */       
/* 35 */       int ticks = relay.getNextAnimationTick();
/* 36 */       if (ticks >= 0) {
/* 37 */         double angle = (float)Math.toRadians(ticks / 2);
/* 38 */         double rotation = angle * 2.0D % 6.283185307179586D;
/* 39 */         double rotation2 = angle * 4.0D % 6.283185307179586D;
/* 40 */         double rotation3 = angle * 3.0D % 6.283185307179586D;
/* 41 */         double rotation4 = angle * 1.0D % 6.283185307179586D;
/* 42 */         this.model.layer1.field_78796_g = ((float)rotation);
/* 43 */         this.model.layer2.field_78796_g = ((float)-rotation2);
/* 44 */         this.model.layer3.field_78796_g = ((float)rotation3);
/* 45 */         this.model.layer4.field_78796_g = ((float)-rotation4);
/* 46 */         this.model.layer5.field_78796_g = ((float)rotation2);
/* 47 */         this.model.layer6.field_78796_g = ((float)-rotation3);
/* 48 */         this.model.layer7.field_78796_g = ((float)rotation4);
/*    */       } else {
/* 50 */         this.model.layer1.field_78796_g = 0.0F;
/* 51 */         this.model.layer2.field_78796_g = 0.0F;
/* 52 */         this.model.layer3.field_78796_g = 0.0F;
/* 53 */         this.model.layer4.field_78796_g = 0.0F;
/* 54 */         this.model.layer5.field_78796_g = 0.0F;
/* 55 */         this.model.layer6.field_78796_g = 0.0F;
/* 56 */         this.model.layer7.field_78796_g = 0.0F;
/*    */       }
/*    */       
/* 59 */       func_147499_a(TEXTURE);
/* 60 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 62 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderRelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */