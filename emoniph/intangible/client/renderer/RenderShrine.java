/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.blocks.BlockShrine.TileEntityShrine;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelShrine;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderShrine extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  21 */   private ModelShrine model = new ModelShrine();
/*     */   
/*     */ 
/*  24 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/shrine.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  28 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  29 */     if ((state.func_177230_c() != emoniph.intangible.Get.blocks().SHRINE) || (!(tile instanceof BlockShrine.TileEntityShrine))) {
/*  30 */       return;
/*     */     }
/*  32 */     GlStateManager.func_179094_E();
/*     */     
/*  34 */     GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*     */     
/*  36 */     BlockShrine.TileEntityShrine shrine = (BlockShrine.TileEntityShrine)tile;
/*     */     
/*  38 */     float rotation = shrine.getRotation() * 360 / 16.0F;
/*     */     
/*  40 */     GlStateManager.func_179114_b(-rotation, 0.0F, 1.0F, 0.0F);
/*     */     
/*  42 */     ItemStack stackA = shrine.getItemA();
/*  43 */     ItemStack stackB = shrine.getItemB();
/*  44 */     ItemStack stackC = shrine.getItemC();
/*  45 */     if (stackA != null) {
/*  46 */       GlStateManager.func_179094_E();
/*     */       
/*  48 */       float upShift = -0.08F;
/*  49 */       GlStateManager.func_179109_b(0.0F, upShift, 0.0F);
/*     */       
/*  51 */       float scale = 0.4F;
/*     */       
/*     */ 
/*  54 */       Minecraft mc = Minecraft.func_71410_x();
/*     */       
/*     */ 
/*     */ 
/*  58 */       GlStateManager.func_179094_E();
/*  59 */       GlStateManager.func_179137_b(0.0D, 0.02D, 0.0D);
/*  60 */       GlStateManager.func_179152_a(scale, scale, scale);
/*  61 */       mc.func_175599_af().func_181564_a(stackA, ItemCameraTransforms.TransformType.GROUND);
/*  62 */       GlStateManager.func_179121_F();
/*     */       
/*  64 */       scale = 0.375F;
/*     */       
/*  66 */       GlStateManager.func_179094_E();
/*  67 */       GlStateManager.func_179137_b(-0.2D, -0.05D, 0.0D);
/*  68 */       GlStateManager.func_179114_b(45.0F, 0.0F, 0.0F, 1.0F);
/*  69 */       GlStateManager.func_179152_a(scale, scale, scale);
/*  70 */       mc.func_175599_af().func_181564_a(stackB, ItemCameraTransforms.TransformType.GROUND);
/*  71 */       GlStateManager.func_179121_F();
/*     */       
/*  73 */       GlStateManager.func_179094_E();
/*  74 */       GlStateManager.func_179137_b(0.2D, -0.05D, 0.0D);
/*  75 */       GlStateManager.func_179114_b(-45.0F, 0.0F, 0.0F, 1.0F);
/*  76 */       GlStateManager.func_179152_a(scale, scale, scale);
/*  77 */       mc.func_175599_af().func_181564_a(stackB, ItemCameraTransforms.TransformType.GROUND);
/*  78 */       GlStateManager.func_179121_F();
/*     */       
/*  80 */       GlStateManager.func_179094_E();
/*  81 */       GlStateManager.func_179137_b(0.0D, -0.05D, -0.2D);
/*     */       
/*  83 */       GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
/*  84 */       GlStateManager.func_179114_b(-45.0F, 0.0F, 0.0F, 1.0F);
/*  85 */       GlStateManager.func_179152_a(scale, scale, scale);
/*  86 */       mc.func_175599_af().func_181564_a(stackC, ItemCameraTransforms.TransformType.GROUND);
/*  87 */       GlStateManager.func_179121_F();
/*     */       
/*  89 */       GlStateManager.func_179094_E();
/*  90 */       GlStateManager.func_179137_b(0.0D, -0.05D, 0.2D);
/*  91 */       GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
/*  92 */       GlStateManager.func_179114_b(-45.0F, 0.0F, 0.0F, 1.0F);
/*  93 */       GlStateManager.func_179152_a(scale, scale, scale);
/*  94 */       mc.func_175599_af().func_181564_a(stackC, ItemCameraTransforms.TransformType.GROUND);
/*  95 */       GlStateManager.func_179121_F();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 100 */       GlStateManager.func_179121_F();
/* 101 */       emoniph.intangible.util.RenderUtil.color(shrine.getColor());
/*     */     }
/*     */     
/* 104 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 105 */     GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */     
/* 107 */     func_147499_a(TEXTURE);
/*     */     
/* 109 */     this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */     
/* 111 */     GlStateManager.func_179121_F();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderShrine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */