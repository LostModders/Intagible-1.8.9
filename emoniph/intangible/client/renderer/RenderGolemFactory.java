/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockGolemFactory;
/*     */ import emoniph.intangible.blocks.BlockGolemFactory.TileEntityGolemFactory;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelGolemFactory;
/*     */ import emoniph.intangible.entity.EntityWreckingGolem;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderLiving;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderGolemFactory extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  24 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/golemfactory.png");
/*     */   
/*  26 */   private ModelGolemFactory model = new ModelGolemFactory();
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  30 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  31 */     if ((state.func_177230_c() == Get.blocks().GOLEM_FACTORY) && (state.func_177229_b(BlockGolemFactory.PART) == emoniph.intangible.blocks.BlockGolemFactory.EnumPart.BOTTOM) && ((tile instanceof BlockGolemFactory.TileEntityGolemFactory)))
/*     */     {
/*  33 */       BlockGolemFactory.TileEntityGolemFactory factory = (BlockGolemFactory.TileEntityGolemFactory)tile;
/*     */       
/*  35 */       GlStateManager.func_179094_E();
/*  36 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*     */       
/*     */ 
/*     */ 
/*  40 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */       
/*  42 */       EntityWreckingGolem golem = factory.getProxy();
/*  43 */       if (golem != null) {
/*  44 */         GlStateManager.func_179094_E();
/*  45 */         golem.field_70122_E = true;
/*  46 */         RenderLiving renderer = (RenderLiving)Minecraft.func_71410_x().func_175598_ae().field_78729_o.get(golem.getClass());
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */         float rotate = 0.0F;
/*  65 */         switch (facing) {
/*     */         case NORTH: 
/*  67 */           rotate = 0.0F;
/*  68 */           break;
/*     */         case SOUTH: 
/*  70 */           rotate = 180.0F;
/*  71 */           break;
/*     */         case EAST: 
/*  73 */           rotate = 270.0F;
/*  74 */           break;
/*     */         case WEST: 
/*  76 */           rotate = 90.0F;
/*     */         }
/*     */         
/*     */         
/*  80 */         golem.field_70177_z = (golem.field_70126_B = rotate);
/*  81 */         golem.field_70125_A = (golem.field_70127_C = 0.0F);
/*     */         
/*     */ 
/*  84 */         GlStateManager.func_179114_b(golem.field_70177_z, 0.0F, 1.0F, 0.0F);
/*  85 */         GlStateManager.func_179137_b(0.0D, -0.35D, 0.1D);
/*     */         
/*  87 */         renderer.func_76986_a(golem, 0.0D, 0.0D, 0.0D, 0.0F, 0.0625F);
/*     */         
/*  89 */         GlStateManager.func_179121_F();
/*     */       }
/*     */       
/*  92 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  93 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*  94 */       GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*     */       
/*  96 */       func_147499_a(TEXTURE);
/*     */       
/*  98 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/* 100 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderGolemFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */