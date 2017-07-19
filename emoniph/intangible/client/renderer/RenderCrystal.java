/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockCrystal;
/*    */ import emoniph.intangible.blocks.BlockCrystal.Plane;
/*    */ import emoniph.intangible.blocks.BlockCrystal.TileEntityCrystal;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.client.models.ModelCrystal;
/*    */ import emoniph.intangible.util.BlockUtil;
/*    */ import net.minecraft.block.BlockDirectional;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderCrystal extends TileEntitySpecialRenderer
/*    */ {
/* 24 */   private ModelCrystal model = new ModelCrystal();
/*    */   
/* 26 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/crystal.png");
/*    */   
/*    */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*    */   {
/* 30 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/* 31 */     if ((state.func_177230_c() == Get.blocks().CRYSTAL) && ((tile instanceof BlockCrystal.TileEntityCrystal))) {
/* 32 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 33 */       BlockCrystal.Plane plane = (BlockCrystal.Plane)state.func_177229_b(BlockCrystal.PLANE);
/* 34 */       BlockCrystal.TileEntityCrystal crystal = (BlockCrystal.TileEntityCrystal)tile;
/*    */       
/* 36 */       GlStateManager.func_179094_E();
/*    */       
/* 38 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*    */       
/* 40 */       switch (plane) {
/*    */       case FLOOR: 
/* 42 */         GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 43 */         GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/* 44 */         GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/* 45 */         break;
/*    */       case WALL: 
/* 47 */         GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 48 */         GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/* 49 */         GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
/* 50 */         GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/* 51 */         break;
/*    */       case CEILING: 
/* 53 */         GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/* 54 */         GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*    */       }
/*    */       
/*    */       
/* 58 */       GlStateManager.func_179112_b(770, 771);
/* 59 */       GlStateManager.func_179092_a(516, 0.01F);
/* 60 */       GlStateManager.func_179147_l();
/*    */       
/* 62 */       func_147499_a(TEXTURE);
/*    */       
/* 64 */       int variant = crystal.getVariant();
/* 65 */       int stage = crystal.getGrowthStage();
/*    */       
/* 67 */       this.model.rarePillar = (crystal.isRare() ? variant : 0);
/* 68 */       this.model.pillarColor = crystal.getColor();
/* 69 */       this.model.rarePillarColor = crystal.getRareColor();
/*    */       
/* 71 */       int show = 1;
/*    */       
/* 73 */       this.model.shoot1.field_78806_j = (stage >= 1);
/* 74 */       this.model.pillar1.field_78806_j = ((variant != 1) && (stage >= ++show));
/* 75 */       this.model.pillar2.field_78806_j = ((variant != 2) && (stage >= ++show));
/* 76 */       this.model.pillar3.field_78806_j = ((variant != 3) && (stage >= ++show));
/* 77 */       this.model.pillar4.field_78806_j = ((variant != 4) && (stage >= ++show));
/* 78 */       this.model.pillar5.field_78806_j = ((variant != 5) && (stage >= ++show));
/*    */       
/*    */ 
/* 81 */       float crystalGrowthTicks = crystal.getGrowthTicks();
/* 82 */       float maxGrowth = 50.0F;
/* 83 */       this.model.lastPillarScale = (crystalGrowthTicks / maxGrowth);
/*    */       
/* 85 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*    */       
/* 87 */       GlStateManager.func_179084_k();
/* 88 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderCrystal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */