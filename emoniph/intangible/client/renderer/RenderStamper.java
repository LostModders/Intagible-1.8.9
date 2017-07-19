/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockStamper.TileEntityStamper;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelStamper;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderStamper extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  24 */   private ModelStamper model = new ModelStamper();
/*     */   
/*     */ 
/*  27 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/stamper.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  31 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  32 */     if ((state.func_177230_c() != Get.blocks().CIRCUIT_STAMPER) || (!(tile instanceof BlockStamper.TileEntityStamper))) {
/*  33 */       return;
/*     */     }
/*     */     
/*  36 */     GlStateManager.func_179094_E();
/*     */     
/*  38 */     GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*     */     
/*  40 */     BlockStamper.TileEntityStamper stamper = (BlockStamper.TileEntityStamper)tile;
/*     */     
/*  42 */     Minecraft mc = Minecraft.func_71410_x();
/*     */     
/*  44 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  52 */     this.model.lid.field_78795_f = stamper.getAnimationProgress();
/*     */     
/*     */ 
/*  55 */     func_147499_a(TextureMap.field_110575_b);
/*     */     
/*  57 */     float SIXTEENTH = 0.0625F;
/*     */     
/*  59 */     GlStateManager.func_179114_b(-BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*     */     
/*  61 */     drawStack(stamper.func_70301_a(1), 0.22F, -0.21875F, 0.22F, mc);
/*  62 */     drawStack(stamper.func_70301_a(2), -0.22F, -0.21875F, 0.22F, mc);
/*  63 */     drawStack(stamper.func_70301_a(3), 0.22F, -0.21875F, -0.22F, mc);
/*  64 */     drawStack(stamper.func_70301_a(4), -0.22F, -0.21875F, -0.22F, mc);
/*     */     
/*  66 */     drawStack(stamper.func_70301_a(0), 0.0F, -0.40625F, -0.45F, mc);
/*     */     
/*     */ 
/*  69 */     GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*     */     
/*  71 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  72 */     GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */     
/*  74 */     GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*     */     
/*  76 */     GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  77 */     func_147499_a(TEXTURE);
/*     */     
/*  79 */     this.model.handle.field_78806_j = false;
/*  80 */     this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */     
/*  82 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   private void drawStack(ItemStack stack, float x, float y, float z, Minecraft mc) {
/*  86 */     if (stack != null) {
/*  87 */       float itemScale = 0.25F;
/*  88 */       double scale = 0.015D;
/*     */       
/*  90 */       GlStateManager.func_179094_E();
/*  91 */       GlStateManager.func_179140_f();
/*     */       
/*  93 */       if (stack.field_77994_a > 1) {
/*  94 */         GlStateManager.func_179137_b(x, y + 0.05D, z);
/*  95 */         FontRenderer fontRenderer = mc.func_175598_ae().func_78716_a();
/*  96 */         String s = Integer.valueOf(stack.field_77994_a).toString();
/*  97 */         int width = 12 - fontRenderer.func_78256_a(s);
/*     */         
/*  99 */         GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
/* 100 */         GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
/* 101 */         GlStateManager.func_179139_a(scale, scale, scale);
/*     */         
/* 103 */         GlStateManager.func_179109_b(width, 4.0F, 0.0F);
/*     */         
/* 105 */         GlStateManager.func_179139_a(1.1D, 1.1D, 1.1D);
/* 106 */         fontRenderer.func_175065_a(s, 0.0F, 0.0F, 0, false);
/* 107 */         GlStateManager.func_179139_a(0.9090909090909091D, 0.9090909090909091D, 0.9090909090909091D);
/* 108 */         GlStateManager.func_179137_b(0.0D, 0.0D, -0.01D);
/*     */         
/*     */ 
/* 111 */         fontRenderer.func_175065_a(s.toString(), 0.0F, 0.0F, -1, false);
/*     */         
/*     */ 
/* 114 */         GlStateManager.func_179137_b(-width, -4.0D, 0.01D);
/*     */         
/* 116 */         GlStateManager.func_179139_a(1.0D / scale, 1.0D / scale, 1.0D / scale);
/*     */         
/* 118 */         GlStateManager.func_179114_b(-90.0F, 1.0F, 0.0F, 0.0F);
/* 119 */         GlStateManager.func_179114_b(-180.0F, 0.0F, 1.0F, 0.0F);
/* 120 */         GlStateManager.func_179137_b(-x, -y - 0.05D, -z);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 125 */       GlStateManager.func_179109_b(x, y, z);
/* 126 */       GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
/*     */       
/* 128 */       GlStateManager.func_179152_a(itemScale, itemScale, itemScale);
/* 129 */       mc.func_175599_af().func_181564_a(stack, net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.GROUND);
/*     */       
/* 131 */       GlStateManager.func_179145_e();
/* 132 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderStamper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */