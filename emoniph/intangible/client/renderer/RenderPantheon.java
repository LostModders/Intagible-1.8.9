/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockPantheon.TileEntityPantheon;
/*     */ import emoniph.intangible.client.models.ModelDeityHead;
/*     */ import emoniph.intangible.client.models.ModelPantheon;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.deity.HeadSpec;
/*     */ import emoniph.intangible.deity.WorshipCache;
/*     */ import emoniph.intangible.deity.WorshipCache.WorshipDetails;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderPantheon extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  28 */   private ModelPantheon model = new ModelPantheon();
/*     */   
/*  30 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/pantheon.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  34 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  35 */     if ((state.func_177230_c() == Get.blocks().PANTHEON) && ((tile instanceof BlockPantheon.TileEntityPantheon))) {
/*  36 */       Minecraft mc = Minecraft.func_71410_x();
/*     */       
/*  38 */       GlStateManager.func_179094_E();
/*  39 */       GlStateManager.func_179112_b(770, 771);
/*  40 */       GlStateManager.func_179092_a(516, 0.01F);
/*  41 */       GlStateManager.func_179147_l();
/*     */       
/*  43 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*  44 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  45 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*  47 */       BlockPantheon.TileEntityPantheon pantheon = (BlockPantheon.TileEntityPantheon)tile;
/*     */       
/*  49 */       double distSq = mc.field_71439_g.func_174818_b(pantheon.func_174877_v());
/*  50 */       boolean closeBy = distSq <= 12.0D;
/*     */       
/*  52 */       boolean powered = ((Boolean)state.func_177229_b(emoniph.intangible.blocks.BlockPantheon.POWERED)).booleanValue();
/*     */       
/*  54 */       long max = 100L;
/*     */       
/*  56 */       long time = pantheon.func_145831_w().func_82737_E();
/*  57 */       long ticksSinceStateChange = Math.min(time - pantheon.timeOfLastStateChange, 100L);
/*     */       
/*  59 */       float progress = powered ? (float)ticksSinceStateChange / 100.0F : 1.0F - (float)ticksSinceStateChange / 100.0F;
/*     */       
/*  61 */       float fastProgress = Math.min(progress * 2.0F, 1.0F);
/*     */       
/*  63 */       float cubeY = 14.0F - 10.0F * fastProgress;
/*     */       
/*  65 */       this.model.cubeA.field_78797_d = cubeY;
/*  66 */       this.model.cubeB.field_78797_d = cubeY;
/*     */       
/*  68 */       float HALF_PI = 1.5707964F;
/*  69 */       float angle2; float offset; int i; float projectionProgress; float projection; float scale; int totalWorship; int topWorship; int bottomWorship; if (fastProgress == 1.0F)
/*     */       {
/*  71 */         float angle = (float)time * 2.0F % 360.0F;
/*  72 */         this.model.cubeA.field_78795_f = 0.7853982F;
/*  73 */         this.model.cubeB.field_78795_f = -0.7853982F;
/*     */         
/*  75 */         this.model.cubeA.field_78808_h = ((float)Math.toRadians(angle) + 0.7853982F);
/*  76 */         this.model.cubeB.field_78808_h = ((float)Math.toRadians(angle) - 0.7853982F);
/*     */         
/*  78 */         mc.field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*  79 */         List<HeadSpec> heads = Get.deities().getAllHeadsFor(pantheon.func_145831_w());
/*     */         
/*  81 */         if (heads != null) {
/*  82 */           angle2 = (float)time * 0.1F % 360.0F;
/*  83 */           offset = 360.0F / heads.size();
/*  84 */           i = 0;
/*     */           
/*  86 */           projectionProgress = (progress - 0.5F) * 2.0F;
/*  87 */           projection = projectionProgress + heads.size() * 0.1F * 0.4F;
/*  88 */           scale = 0.01F + 0.8F * progress;
/*     */           
/*  90 */           totalWorship = 0;
/*  91 */           topWorship = 0;
/*  92 */           bottomWorship = Integer.MAX_VALUE;
/*  93 */           if (pantheon.currentCache != null) {
/*  94 */             for (HeadSpec head : heads) {
/*  95 */               UUID deityId = Get.deities().getIdForHead(pantheon.func_145831_w(), head);
/*  96 */               if (deityId != null) {
/*  97 */                 WorshipCache.WorshipDetails worshipDetails = pantheon.currentCache.getWorshipFor(deityId);
/*  98 */                 if (worshipDetails != null) {
/*  99 */                   totalWorship += worshipDetails.worship;
/* 100 */                   if (worshipDetails.worship > topWorship) {
/* 101 */                     topWorship = worshipDetails.worship;
/*     */                   }
/* 103 */                   if (worshipDetails.worship < bottomWorship) {
/* 104 */                     bottomWorship = worshipDetails.worship;
/*     */                   }
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */           
/* 111 */           topWorship -= bottomWorship;
/* 112 */           for (HeadSpec head : heads) {
/* 113 */             float vfactor = 0.0F;
/* 114 */             UUID deityId = Get.deities().getIdForHead(pantheon.func_145831_w(), head);
/* 115 */             if ((deityId != null) && (pantheon.currentCache != null)) {
/* 116 */               WorshipCache.WorshipDetails worshipDetails = pantheon.currentCache.getWorshipFor(deityId);
/* 117 */               if (worshipDetails != null)
/*     */               {
/* 119 */                 if ((totalWorship > 0) && (topWorship > 0)) {
/* 120 */                   vfactor = (worshipDetails.worship - bottomWorship) / topWorship;
/*     */                 }
/*     */                 
/*     */ 
/* 124 */                 float vshift = -1.0F * vfactor * projectionProgress;
/*     */                 
/* 126 */                 float rotate = angle2 + i * offset;
/* 127 */                 GlStateManager.func_179114_b(rotate, 0.0F, 1.0F, 0.0F);
/* 128 */                 GlStateManager.func_179109_b(projection, 0.3F + vshift, 0.0F);
/* 129 */                 GlStateManager.func_179114_b(90.0F, 0.0F, 1.0F, 0.0F);
/* 130 */                 GlStateManager.func_179152_a(scale, scale, scale);
/*     */                 
/* 132 */                 if (closeBy)
/*     */                 {
/* 134 */                   FontRenderer fontRenderer = mc.func_175598_ae().func_78716_a();
/* 135 */                   GlStateManager.func_179094_E();
/* 136 */                   GlStateManager.func_179140_f();
/* 137 */                   GlStateManager.func_179147_l();
/* 138 */                   GlStateManager.func_179137_b(0.0D, -0.7D, 0.0D);
/* 139 */                   GlStateManager.func_179139_a(0.01D, 0.01D, 0.01D);
/*     */                   
/* 141 */                   int w = fontRenderer.func_78256_a(worshipDetails.name);
/* 142 */                   fontRenderer.func_175065_a(worshipDetails.name, -w / 2, 0.0F, 0xFF000000 | head.getColor(), false);
/* 143 */                   GlStateManager.func_179084_k();
/* 144 */                   GlStateManager.func_179145_e();
/* 145 */                   GlStateManager.func_179121_F();
/*     */                 }
/*     */                 
/* 148 */                 Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*     */                 
/*     */ 
/* 151 */                 ModelDeityHead headModel = head.createModel();
/* 152 */                 headModel.root.field_78795_f = 0.0F;
/* 153 */                 headModel.root.field_78796_g = 0.0F;
/* 154 */                 headModel.root.field_78808_h = 0.0F;
/*     */                 
/*     */ 
/* 157 */                 GlStateManager.func_179147_l();
/*     */                 
/* 159 */                 emoniph.intangible.util.RenderUtil.color(16777215, 1.0F * projectionProgress);
/*     */                 
/* 161 */                 headModel.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, tile.func_145831_w());
/*     */                 
/* 163 */                 float f9 = (float)time;
/* 164 */                 Minecraft.func_71410_x().field_71446_o.func_110577_a(new ResourceLocation("textures/misc/enchanted_item_glint.png"));
/*     */                 
/* 166 */                 float f10 = 0.5F;
/* 167 */                 GlStateManager.func_179131_c(f10, f10, f10, 1.0F);
/* 168 */                 GlStateManager.func_179143_c(514);
/* 169 */                 GlStateManager.func_179132_a(false);
/*     */                 
/* 171 */                 float r = (head.getColor() >> 16 & 0xFF) / 256.0F;
/* 172 */                 float g = (head.getColor() >> 8 & 0xFF) / 256.0F;
/* 173 */                 float b = (head.getColor() & 0xFF) / 256.0F;
/*     */                 
/* 175 */                 for (int k = 0; k < 1; k++) {
/* 176 */                   GlStateManager.func_179140_f();
/* 177 */                   float f11 = 0.76F;
/*     */                   
/* 179 */                   GlStateManager.func_179131_c(r * f11, g * f11, b * f11, 1.0F * projectionProgress);
/*     */                   
/* 181 */                   GlStateManager.func_179112_b(768, 1);
/* 182 */                   GlStateManager.func_179128_n(5890);
/* 183 */                   GlStateManager.func_179096_D();
/* 184 */                   float f12 = f9 * (0.001F + k * 0.003F) * 20.0F;
/* 185 */                   float f13 = 0.33333334F;
/* 186 */                   GlStateManager.func_179152_a(f13, f13, f13);
/* 187 */                   GlStateManager.func_179114_b(30.0F - k * 60.0F, 0.0F, 0.0F, 1.0F);
/* 188 */                   GlStateManager.func_179109_b(0.0F, f12, 0.0F);
/* 189 */                   GlStateManager.func_179128_n(5888);
/*     */                   
/* 191 */                   headModel.render(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, tile.func_145831_w());
/*     */                 }
/*     */                 
/* 194 */                 GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 195 */                 GlStateManager.func_179128_n(5890);
/* 196 */                 GlStateManager.func_179132_a(true);
/* 197 */                 GlStateManager.func_179096_D();
/* 198 */                 GlStateManager.func_179128_n(5888);
/* 199 */                 GlStateManager.func_179145_e();
/* 200 */                 GlStateManager.func_179084_k();
/* 201 */                 GlStateManager.func_179143_c(515);
/*     */                 
/* 203 */                 GlStateManager.func_179112_b(770, 771);
/*     */                 
/* 205 */                 if (closeBy)
/*     */                 {
/* 207 */                   float itemScale = 0.15F;
/* 208 */                   float vShift = -0.55F;
/* 209 */                   GlStateManager.func_179094_E();
/* 210 */                   GlStateManager.func_179109_b(0.15F, vShift, 0.0F);
/* 211 */                   GlStateManager.func_179152_a(-itemScale, -itemScale, itemScale);
/* 212 */                   mc.func_175599_af().func_181564_a(worshipDetails.itemB, ItemCameraTransforms.TransformType.GROUND);
/* 213 */                   GlStateManager.func_179121_F();
/*     */                   
/* 215 */                   GlStateManager.func_179094_E();
/* 216 */                   GlStateManager.func_179109_b(0.0F, vShift, 0.0F);
/* 217 */                   GlStateManager.func_179152_a(-itemScale, -itemScale, itemScale);
/* 218 */                   mc.func_175599_af().func_181564_a(worshipDetails.itemA, ItemCameraTransforms.TransformType.GROUND);
/* 219 */                   GlStateManager.func_179121_F();
/*     */                   
/* 221 */                   GlStateManager.func_179094_E();
/* 222 */                   GlStateManager.func_179109_b(-0.15F, vShift, 0.0F);
/* 223 */                   GlStateManager.func_179152_a(-itemScale, -itemScale, itemScale);
/* 224 */                   mc.func_175599_af().func_181564_a(worshipDetails.itemC, ItemCameraTransforms.TransformType.GROUND);
/* 225 */                   GlStateManager.func_179121_F();
/*     */                 }
/*     */                 
/* 228 */                 GlStateManager.func_179152_a(1.0F / scale, 1.0F / scale, 1.0F / scale);
/* 229 */                 GlStateManager.func_179114_b(-90.0F, 0.0F, 1.0F, 0.0F);
/* 230 */                 GlStateManager.func_179109_b(-projection, -(0.3F + vshift), 0.0F);
/* 231 */                 GlStateManager.func_179114_b(-rotate, 0.0F, 1.0F, 0.0F);
/*     */               }
/*     */             }
/*     */             
/* 235 */             i++;
/*     */           }
/*     */         }
/*     */       } else {
/* 239 */         this.model.cubeA.field_78795_f = 0.7853982F;
/* 240 */         this.model.cubeB.field_78795_f = -0.7853982F;
/* 241 */         this.model.cubeA.field_78808_h = 0.7853982F;
/* 242 */         this.model.cubeB.field_78808_h = -0.7853982F;
/*     */       }
/*     */       
/* 245 */       GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/* 246 */       GlStateManager.func_179147_l();
/* 247 */       func_147499_a(TEXTURE);
/* 248 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/*     */ 
/* 251 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderPantheon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */