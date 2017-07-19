/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockPlinth.TileEntityPlinth;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelPlinth;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderPlinth extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  25 */   private ModelPlinth model = new ModelPlinth();
/*     */   
/*     */ 
/*  28 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/plinth.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  32 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  33 */     if ((state.func_177230_c() == Get.blocks().PLINTH) && ((tile instanceof BlockPlinth.TileEntityPlinth))) {
/*  34 */       GlStateManager.func_179094_E();
/*     */       
/*  36 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*     */       
/*  38 */       BlockPlinth.TileEntityPlinth plinth = (BlockPlinth.TileEntityPlinth)tile;
/*     */       
/*  40 */       Minecraft mc = Minecraft.func_71410_x();
/*     */       
/*  42 */       ItemStack stack = plinth != null ? plinth.func_70301_a(0) : null;
/*  43 */       if (stack != null)
/*     */       {
/*     */ 
/*  46 */         GlStateManager.func_179094_E();
/*     */         
/*  48 */         float upShift = 0.4F;
/*  49 */         GlStateManager.func_179109_b(0.0F, upShift, 0.0F);
/*     */         
/*  51 */         float scale = 0.35F;
/*  52 */         GlStateManager.func_179152_a(scale, scale, scale);
/*     */         
/*     */ 
/*  55 */         double dx = tile.func_174877_v().func_177958_n() + 0.5D - mc.field_71439_g.field_70165_t;
/*  56 */         double dz = tile.func_174877_v().func_177952_p() + 0.5D - mc.field_71439_g.field_70161_v;
/*  57 */         int angle = MathHelper.func_76143_f(Math.atan2(dx, dz) * 180.0D / 3.141592653589793D);
/*  58 */         GlStateManager.func_179114_b(angle, 0.0F, 1.0F, 0.0F);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  64 */         func_147499_a(TextureMap.field_110575_b);
/*  65 */         mc.func_175599_af().func_181564_a(stack, net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType.GROUND);
/*     */         
/*  67 */         GlStateManager.func_179121_F();
/*     */       }
/*     */       
/*     */ 
/*  71 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  72 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*  74 */       GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/*  75 */       func_147499_a(TEXTURE);
/*     */       
/*  77 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/*  79 */       GlStateManager.func_179121_F();
/*     */       
/*  81 */       if (plinth != null) {
/*  82 */         String text = plinth.func_70005_c_();
/*     */         
/*  84 */         double dsq = mc.field_71439_g.func_174818_b(tile.func_174877_v());
/*  85 */         if ((dsq < 12.0D) && (((text != null) && (!text.isEmpty())) || ((stack != null) && (stack.field_77994_a > 1)))) {
/*  86 */           GlStateManager.func_179094_E();
/*     */           
/*  88 */           GlStateManager.func_179137_b(x + 0.5D, y + 1.3D, z + 0.5D);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  94 */           GlStateManager.func_179114_b(-mc.func_175598_ae().field_78735_i, 0.0F, 1.0F, 0.0F);
/*  95 */           GlStateManager.func_179114_b(mc.func_175598_ae().field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 101 */           double scale = 0.015D * (1.0D - dsq / 12.0D);
/* 102 */           GlStateManager.func_179139_a(-scale, -scale, scale);
/*     */           
/* 104 */           GlStateManager.func_179140_f();
/*     */           
/* 106 */           GlStateManager.func_179120_a(770, 771, 1, 0);
/* 107 */           GlStateManager.func_179147_l();
/* 108 */           FontRenderer fontRenderer = mc.func_175598_ae().func_78716_a();
/*     */           
/*     */ 
/* 111 */           if ((text != null) && (!text.isEmpty())) {
/* 112 */             GlStateManager.func_179132_a(false);
/* 113 */             GlStateManager.func_179097_i();
/*     */             
/* 115 */             int wrapWidth = 55;
/* 116 */             List lines = fontRenderer.func_78271_c(text, wrapWidth);
/* 117 */             int maxWidth = 0;
/* 118 */             int[] widths = new int[lines.size()];
/* 119 */             int i = 0; for (int count = lines.size(); i < count; i++) {
/* 120 */               widths[i] = fontRenderer.func_78256_a((String)lines.get(i));
/* 121 */               maxWidth = Math.max(widths[i], maxWidth);
/*     */             }
/* 123 */             int height = fontRenderer.field_78288_b * lines.size();
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
/* 137 */             int textX = -maxWidth / 2;
/* 138 */             int textY = 0;
/*     */             
/*     */ 
/*     */ 
/*     */ 
/* 143 */             GlStateManager.func_179126_j();
/* 144 */             GlStateManager.func_179132_a(true);
/*     */             
/*     */ 
/* 147 */             textY = -1;
/* 148 */             int i = 0; for (int count = lines.size(); i < count; textY += fontRenderer.field_78288_b) {
/* 149 */               fontRenderer.func_175065_a((String)lines.get(i), textX + (maxWidth - widths[i]) / 2, textY, -1862270977, false);i++;
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 154 */           GlStateManager.func_179145_e();
/* 155 */           GlStateManager.func_179084_k();
/* 156 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 157 */           GlStateManager.func_179121_F();
/*     */         }
/*     */         
/* 160 */         if ((dsq < 12.0D) && (stack != null) && (stack.field_77994_a > 1)) {
/* 161 */           GlStateManager.func_179094_E();
/*     */           
/* 163 */           GlStateManager.func_179137_b(x + 0.5D, y + 0.9D, z + 0.5D);
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
/* 175 */           GlStateManager.func_179114_b(-mc.func_175598_ae().field_78735_i, 0.0F, 1.0F, 0.0F);
/* 176 */           GlStateManager.func_179114_b(mc.func_175598_ae().field_78732_j, 1.0F, 0.0F, 0.0F);
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 182 */           double scale = 0.015D * (1.0D - dsq / 12.0D);
/* 183 */           GlStateManager.func_179139_a(-scale, -scale, scale);
/*     */           
/* 185 */           GlStateManager.func_179140_f();
/*     */           
/* 187 */           GlStateManager.func_179120_a(770, 771, 1, 0);
/* 188 */           GlStateManager.func_179147_l();
/* 189 */           FontRenderer fontRenderer = mc.func_175598_ae().func_78716_a();
/*     */           
/*     */ 
/* 192 */           String num = Integer.valueOf(stack.field_77994_a).toString();
/* 193 */           int width = fontRenderer.func_78256_a(num);
/* 194 */           fontRenderer.func_175065_a(num, 20 - width, 0.0F, -1862270977, false);
/*     */           
/*     */ 
/* 197 */           GlStateManager.func_179145_e();
/* 198 */           GlStateManager.func_179084_k();
/* 199 */           GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 200 */           GlStateManager.func_179121_F();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderPlinth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */