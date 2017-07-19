/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockGolemPartAssembler.TileEntityGolemPartAssembler;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelGolemPartAssembler;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderGolemPartAssembler extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  24 */   private ModelGolemPartAssembler model = new ModelGolemPartAssembler();
/*     */   
/*  26 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/golempartassembler.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  30 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  31 */     if ((state.func_177230_c() == Get.blocks().GOLEM_PART_ASSEMBLER) && ((tile instanceof BlockGolemPartAssembler.TileEntityGolemPartAssembler))) {
/*  32 */       GlStateManager.func_179094_E();
/*     */       
/*  34 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*     */       
/*  36 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  37 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*  39 */       BlockGolemPartAssembler.TileEntityGolemPartAssembler assembler = (BlockGolemPartAssembler.TileEntityGolemPartAssembler)tile;
/*     */       
/*  41 */       Minecraft mc = Minecraft.func_71410_x();
/*     */       
/*  43 */       ModelRenderer[] plates = { this.model.armPlateF, this.model.armPlateL, this.model.armPlateB, this.model.armPlateR };
/*  44 */       ModelRenderer[] arms = { this.model.armF, this.model.armL, this.model.armB, this.model.armR };
/*     */       
/*  46 */       float progress = assembler.getAssembleTime();
/*     */       
/*     */ 
/*  49 */       FontRenderer font = mc.func_175598_ae().func_78716_a();
/*  50 */       float itemScale = emoniph.intangible.util.MathUtil.sixteenth(1);
/*  51 */       float itemUpScale = 3.0F;
/*     */       
/*  53 */       for (EnumFacing facing : EnumFacing.field_176754_o) {
/*  54 */         float angle = 0.0F;
/*  55 */         float shift = 0.0F;
/*  56 */         if (progress < 100.0F) {
/*  57 */           angle = 350.0F - 180.0F * progress / 100.0F;
/*  58 */           shift = 0.0F;
/*  59 */         } else if (progress < 300.0F) {
/*  60 */           angle = 170.0F;
/*  61 */           shift = 2.0F * (progress < 200.0F ? (progress - 100.0F) / 100.0F : (100.0F - (progress - 200.0F)) / 100.0F);
/*  62 */         } else if (progress < 400.0F) {
/*  63 */           angle = 350.0F - (180.0F - 180.0F * (progress - 300.0F) / 100.0F);
/*  64 */           shift = 0.0F;
/*     */         } else {
/*  66 */           angle = 350.0F;
/*     */         }
/*  68 */         int slot = facing.func_176736_b();
/*  69 */         if ((slot == 0) || (slot == 2)) {
/*  70 */           plates[slot].field_78795_f = ((float)Math.toRadians(angle));
/*     */         } else {
/*  72 */           plates[slot].field_78808_h = ((float)Math.toRadians(-angle));
/*     */         }
/*     */         
/*  75 */         if (slot == 0) {
/*  76 */           arms[slot].field_78798_e = (-4.0F + shift);
/*  77 */         } else if (slot == 2) {
/*  78 */           arms[slot].field_78798_e = (4.0F - shift);
/*  79 */         } else if (slot == 1) {
/*  80 */           arms[slot].field_78800_c = (4.0F - shift);
/*  81 */         } else if (slot == 3) {
/*  82 */           arms[slot].field_78800_c = (-4.0F + shift);
/*     */         }
/*     */         
/*  85 */         ItemStack stack = assembler.func_70301_a(slot + 1);
/*  86 */         if (stack != null)
/*     */         {
/*  88 */           GlStateManager.func_179094_E();
/*  89 */           GlStateManager.func_179140_f();
/*     */           
/*  91 */           GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*  92 */           GlStateManager.func_179152_a(itemScale, itemScale, itemScale);
/*  93 */           GlStateManager.func_179137_b(0.0D, 12.5D, 6.5D - shift);
/*  94 */           GlStateManager.func_179114_b(-angle, 1.0F, 0.0F, 0.0F);
/*  95 */           GlStateManager.func_179109_b(0.0F, 0.0F, 2.0F);
/*  96 */           GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*     */           
/*  98 */           drawStackText(stack, font);
/*     */           
/* 100 */           GlStateManager.func_179152_a(itemUpScale, itemUpScale, itemUpScale);
/* 101 */           mc.func_175599_af().func_181564_a(stack, ItemCameraTransforms.TransformType.GROUND);
/*     */           
/* 103 */           GlStateManager.func_179145_e();
/* 104 */           GlStateManager.func_179121_F();
/*     */         }
/*     */       }
/*     */       
/* 108 */       ItemStack stack = assembler.func_70301_a(0);
/* 109 */       if (stack != null) {
/* 110 */         GlStateManager.func_179094_E();
/* 111 */         GlStateManager.func_179140_f();
/*     */         
/* 113 */         GlStateManager.func_179152_a(itemScale, itemScale, itemScale);
/* 114 */         GlStateManager.func_179109_b(0.0F, 11.0F, 0.0F);
/* 115 */         GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
/* 116 */         GlStateManager.func_179109_b(0.0F, 0.0F, 2.0F);
/*     */         
/* 118 */         drawStackText(stack, font);
/*     */         
/* 120 */         GlStateManager.func_179152_a(itemUpScale, itemUpScale, itemUpScale);
/* 121 */         mc.func_175599_af().func_181564_a(stack, ItemCameraTransforms.TransformType.GROUND);
/*     */         
/* 123 */         GlStateManager.func_179145_e();
/* 124 */         GlStateManager.func_179121_F();
/*     */       }
/*     */       
/* 127 */       GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/* 128 */       func_147499_a(TEXTURE);
/* 129 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/* 131 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */   
/*     */   private void drawStackText(ItemStack stack, FontRenderer font) {
/* 136 */     if (stack.field_77994_a > 1) {
/* 137 */       String s = Integer.valueOf(stack.field_77994_a).toString();
/* 138 */       int width = 12 - font.func_78256_a(s);
/*     */       
/* 140 */       GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
/* 141 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 142 */       float scale = 0.125F;
/* 143 */       GlStateManager.func_179152_a(scale, scale, scale);
/* 144 */       GlStateManager.func_179137_b(width, 4.0D, -6.1D);
/*     */       
/* 146 */       GlStateManager.func_179139_a(1.1D, 1.1D, 1.1D);
/* 147 */       font.func_175065_a(s, 0.0F, 0.0F, 0, false);
/* 148 */       GlStateManager.func_179139_a(0.9090909090909091D, 0.9090909090909091D, 0.9090909090909091D);
/*     */       
/* 150 */       GlStateManager.func_179137_b(0.0D, 0.0D, -0.01D);
/* 151 */       font.func_175065_a(s.toString(), 0.0F, 0.0F, -1, false);
/*     */       
/* 153 */       GlStateManager.func_179137_b(-width, -4.0D, 6.2D);
/*     */       
/* 155 */       GlStateManager.func_179152_a(1.0F / scale, 1.0F / scale, 1.0F / scale);
/* 156 */       GlStateManager.func_179114_b(-180.0F, 0.0F, 1.0F, 0.0F);
/* 157 */       GlStateManager.func_179114_b(-180.0F, 0.0F, 0.0F, 1.0F);
/*     */       
/* 159 */       GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   private void drawStack(ItemStack stack, float x, float y, float z, Minecraft mc) {
/* 164 */     if (stack != null) {
/* 165 */       float itemScale = 0.25F;
/* 166 */       double scale = 0.007D;
/*     */       
/* 168 */       GlStateManager.func_179094_E();
/* 169 */       GlStateManager.func_179140_f();
/*     */       
/* 171 */       if (stack.field_77994_a > 1) {
/* 172 */         GlStateManager.func_179137_b(x, y + 0.05D, z);
/* 173 */         FontRenderer fontRenderer = mc.func_175598_ae().func_78716_a();
/* 174 */         String s = Integer.valueOf(stack.field_77994_a).toString();
/* 175 */         int width = 12 - fontRenderer.func_78256_a(s);
/*     */         
/* 177 */         GlStateManager.func_179114_b(180.0F, 0.0F, 1.0F, 0.0F);
/*     */         
/* 179 */         GlStateManager.func_179139_a(scale, scale, scale);
/*     */         
/* 181 */         GlStateManager.func_179109_b(width, 4.0F, 0.0F);
/*     */         
/* 183 */         GlStateManager.func_179139_a(1.1D, 1.1D, 1.1D);
/* 184 */         fontRenderer.func_175065_a(s, 0.0F, 0.0F, 0, false);
/* 185 */         GlStateManager.func_179139_a(0.9090909090909091D, 0.9090909090909091D, 0.9090909090909091D);
/* 186 */         GlStateManager.func_179137_b(0.0D, 0.0D, -0.01D);
/*     */         
/*     */ 
/* 189 */         fontRenderer.func_175065_a(s.toString(), 0.0F, 0.0F, -1, false);
/*     */         
/*     */ 
/* 192 */         GlStateManager.func_179137_b(-width, -4.0D, 0.01D);
/*     */         
/* 194 */         GlStateManager.func_179139_a(1.0D / scale, 1.0D / scale, 1.0D / scale);
/*     */         
/*     */ 
/* 197 */         GlStateManager.func_179114_b(-180.0F, 0.0F, 1.0F, 0.0F);
/* 198 */         GlStateManager.func_179137_b(-x, -y - 0.05D, -z);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 203 */       GlStateManager.func_179109_b(x, y, z);
/* 204 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*     */       
/* 206 */       GlStateManager.func_179152_a(itemScale, itemScale, itemScale);
/* 207 */       mc.func_175599_af().func_181564_a(stack, ItemCameraTransforms.TransformType.GROUND);
/*     */       
/* 209 */       GlStateManager.func_179145_e();
/* 210 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderGolemPartAssembler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */