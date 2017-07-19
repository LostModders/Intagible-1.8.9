/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.blocks.BlockInfuser.TileEntityInfuser;
/*     */ import emoniph.intangible.blocks.BlockInfuser.TileEntityInfuser.FaceData;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelInfuser;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderInfuser extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  23 */   private ModelInfuser model = new ModelInfuser();
/*     */   
/*  25 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/infuser.png");
/*     */   
/*  27 */   private static final ResourceLocation[] RADIAL_GLYPHS = { new ResourceLocation("intangible", "textures/gui/radial_glyph_0.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_1.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_2.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_3.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_4.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_5.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_6.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_7.png") };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ResourceLocation soulToGlyph(SoulType soul)
/*     */   {
/*  39 */     return RADIAL_GLYPHS[soul.ordinal()];
/*     */   }
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  44 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  45 */     if ((state.func_177230_c() == emoniph.intangible.Get.blocks().INFUSER) && ((tile instanceof BlockInfuser.TileEntityInfuser))) {
/*  46 */       GlStateManager.func_179094_E();
/*     */       
/*  48 */       GlStateManager.func_179147_l();
/*  49 */       GlStateManager.func_179112_b(770, 771);
/*  50 */       GlStateManager.func_179092_a(516, 0.01F);
/*     */       
/*  52 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*  53 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  54 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*  56 */       func_147499_a(TEXTURE);
/*     */       
/*  58 */       Minecraft mc = Minecraft.func_71410_x();
/*  59 */       BlockInfuser.TileEntityInfuser infuser = (BlockInfuser.TileEntityInfuser)tile;
/*     */       
/*  61 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/*  63 */       long progressTicks = infuser.getProgress() * 20 + infuser.getCounter() % 20L;
/*  64 */       if ((progressTicks >= 100L) && (progressTicks < 400L)) {
/*  65 */         long modTicks = progressTicks - 100L;
/*  66 */         progressFactor = 0.0F;
/*  67 */         if (modTicks <= 150L) {
/*  68 */           progressFactor = (float)modTicks / 150.0F;
/*  69 */         } else if (modTicks <= 300L) {
/*  70 */           progressFactor = (300.0F - (float)modTicks) / 150.0F;
/*     */         }
/*  72 */         move = progressFactor * 36.0F;
/*  73 */         this.model.shieldInner.field_78797_d = (8.0F - move);
/*  74 */         this.model.shieldOuter.field_78797_d = (8.0F - move);
/*  75 */         this.model.shieldInner.field_78796_g = ((float)Math.toRadians(infuser.getCounter() * 4L % 360L));
/*  76 */         this.model.shieldOuter.field_78796_g = ((float)Math.toRadians(360L - infuser.getCounter() * 3L % 360L));
/*     */         
/*  78 */         float alpha = progressFactor < 0.1F ? progressFactor / 0.1F * 0.4F : 0.4F;
/*  79 */         GlStateManager.func_179131_c(0.0F, 0.3F, 0.7F, alpha);
/*  80 */         this.model.shieldInner.func_78785_a(0.0625F);
/*  81 */         this.model.shieldOuter.func_78785_a(0.0625F);
/*  82 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       }
/*     */       
/*  85 */       GlStateManager.func_179152_a(0.0625F, 0.0625F, 0.0625F);
/*     */       
/*  87 */       FontRenderer font = mc.field_71466_p;
/*     */       
/*  89 */       GlStateManager.func_179140_f();
/*     */       
/*  91 */       EnumFacing[] arrayOfEnumFacing = EnumFacing.field_176754_o;float progressFactor = arrayOfEnumFacing.length; for (float move = 0; move < progressFactor; move++) { EnumFacing facing = arrayOfEnumFacing[move];
/*  92 */         BlockInfuser.TileEntityInfuser.FaceData face = infuser.getFace(facing);
/*  93 */         if (face != null) {
/*  94 */           float rotation = facing.func_176734_d().func_176736_b() * 90.0F;
/*     */           
/*  96 */           float scale = 0.5F;
/*  97 */           float invScale = 1.0F / scale;
/*     */           
/*  99 */           float shiftX = -4.0F * invScale;
/* 100 */           float shiftY = 14.5F * invScale;
/* 101 */           float shiftZ = -6.6F * invScale;
/*     */           
/* 103 */           GlStateManager.func_179152_a(scale, scale, scale);
/* 104 */           GlStateManager.func_179114_b(rotation, 0.0F, 1.0F, 0.0F);
/* 105 */           GlStateManager.func_179109_b(shiftX, shiftY, shiftZ);
/*     */           
/* 107 */           func_147499_a(soulToGlyph(face.getSoul()));
/*     */           
/* 109 */           emoniph.intangible.util.RenderUtil.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, 8, 8, 8.0F, 8.0F);
/*     */           
/* 111 */           GlStateManager.func_179152_a(scale, scale, scale);
/* 112 */           String text = Integer.valueOf(face.getQuantity()).toString();
/* 113 */           int len = font.func_78256_a(text);
/* 114 */           font.func_175065_a(text, 27.5F - len, 4.5F, -1, false);
/* 115 */           GlStateManager.func_179152_a(invScale, invScale, invScale);
/*     */           
/* 117 */           GlStateManager.func_179109_b(-shiftX, -shiftY, -shiftZ);
/* 118 */           GlStateManager.func_179114_b(-rotation, 0.0F, 1.0F, 0.0F);
/* 119 */           GlStateManager.func_179152_a(invScale, invScale, invScale);
/*     */         }
/*     */       }
/*     */       
/* 123 */       GlStateManager.func_179145_e();
/* 124 */       GlStateManager.func_179084_k();
/* 125 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderInfuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */