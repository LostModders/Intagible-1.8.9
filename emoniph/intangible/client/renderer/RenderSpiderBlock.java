/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.client.models.ModelSpiderBlock;
/*     */ import emoniph.intangible.entity.EntitySpiderBlock;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.BlockModelShapes;
/*     */ import net.minecraft.client.renderer.BlockRendererDispatcher;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.block.model.BakedQuad;
/*     */ import net.minecraft.client.renderer.entity.RenderLiving;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.resources.model.IBakedModel;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.model.ISmartBlockModel;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderSpiderBlock extends RenderLiving
/*     */ {
/*  33 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/spiderblock.png");
/*     */   
/*     */   public RenderSpiderBlock(RenderManager rm) {
/*  36 */     super(rm, new ModelSpiderBlock(), 1.0F);
/*     */   }
/*     */   
/*     */   public void func_76986_a(EntityLiving entity, double x, double y, double z, float rotYaw, float partialTicks)
/*     */   {
/*  41 */     if (entity == null) {
/*  42 */       return;
/*     */     }
/*  44 */     EntitySpiderBlock spider = (EntitySpiderBlock)entity;
/*     */     
/*  46 */     func_110776_a(TextureMap.field_110575_b);
/*  47 */     IBlockState state = spider.getMaterial();
/*  48 */     if (state == null) {
/*  49 */       return;
/*     */     }
/*  51 */     Block block = state.func_177230_c();
/*  52 */     BlockPos pos = new BlockPos(entity);
/*  53 */     net.minecraft.world.World world = entity.field_70170_p;
/*     */     
/*  55 */     if (block.func_149645_b() == 3) {
/*  56 */       GlStateManager.func_179094_E();
/*  57 */       GlStateManager.func_179137_b(x, y, z);
/*  58 */       float yaw = func_77034_a(entity.field_70760_ar, entity.field_70761_aq, partialTicks);
/*  59 */       float yawFix = (180.0F - yaw) % 90.0F;
/*  60 */       GlStateManager.func_179114_b(yawFix, 0.0F, 1.0F, 0.0F);
/*  61 */       GlStateManager.func_179140_f();
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */       int i = pos.func_177958_n();
/*  68 */       int j = pos.func_177956_o();
/*  69 */       int k = pos.func_177952_p();
/*     */       
/*     */ 
/*  72 */       GlStateManager.func_179137_b(0.0D, 0.7D, 0.0D);
/*  73 */       float scale = 1.8F;
/*  74 */       float invScale = 1.0F / scale;
/*     */       
/*  76 */       GlStateManager.func_179152_a(scale, scale, scale);
/*     */       
/*     */ 
/*  79 */       BlockModelShapes bms = Minecraft.func_71410_x().func_175602_ab().func_175023_a();
/*     */       
/*  81 */       IBakedModel model = bms.func_178125_b(state);
/*  82 */       if (model != null) {
/*  83 */         if ((model instanceof ISmartBlockModel)) {
/*  84 */           ISmartBlockModel smartModel = (ISmartBlockModel)model;
/*  85 */           model = smartModel.handleBlockState(state);
/*     */         }
/*  87 */         if (model != null)
/*     */         {
/*     */ 
/*  90 */           renderItem(model, state);
/*     */         }
/*     */       }
/*     */       
/*  94 */       GlStateManager.func_179152_a(invScale, invScale, invScale);
/*  95 */       GlStateManager.func_179137_b(0.0D, -0.7D, 0.0D);
/*     */       
/*     */ 
/*     */ 
/*  99 */       GlStateManager.func_179145_e();
/* 100 */       GlStateManager.func_179121_F();
/* 101 */       super.func_76986_a(entity, x, y, z, yaw, partialTicks);
/*     */     }
/*     */   }
/*     */   
/*     */   public void renderItem(IBakedModel model, IBlockState state)
/*     */   {
/* 107 */     GlStateManager.func_179094_E();
/* 108 */     GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/*     */     
/*     */ 
/* 111 */     GlStateManager.func_179109_b(-0.5F, -0.5F, -0.5F);
/* 112 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 113 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 114 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_176599_b);
/*     */     
/* 116 */     int color = state.func_177230_c().func_180644_h(state);
/*     */     
/* 118 */     for (EnumFacing enumfacing : EnumFacing.values()) {
/* 119 */       renderQuads(worldrenderer, model.func_177551_a(enumfacing), color);
/*     */     }
/*     */     
/* 122 */     renderQuads(worldrenderer, model.func_177550_a(), color);
/* 123 */     tessellator.func_78381_a();
/*     */     
/*     */ 
/* 126 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   private void renderQuads(WorldRenderer renderer, List<BakedQuad> quads, int color) {
/* 130 */     boolean flag = color == -1;
/* 131 */     int i = 0;
/*     */     
/* 133 */     for (int j = quads.size(); i < j; i++) {
/* 134 */       BakedQuad bakedquad = (BakedQuad)quads.get(i);
/* 135 */       int k = color;
/*     */       
/* 137 */       if (bakedquad.func_178212_b())
/*     */       {
/*     */ 
/* 140 */         if (net.minecraft.client.renderer.EntityRenderer.field_78517_a) {
/* 141 */           k = net.minecraft.client.renderer.texture.TextureUtil.func_177054_c(k);
/*     */         }
/*     */         
/* 144 */         k |= 0xFF000000;
/* 145 */         net.minecraftforge.client.model.pipeline.LightUtil.renderQuadColor(renderer, bakedquad, k);
/*     */       } else {
/* 147 */         renderer.func_178981_a(bakedquad.func_178209_a());
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected float getDeathMaxRotation(EntitySpiderBlock spider)
/*     */   {
/* 155 */     return 180.0F;
/*     */   }
/*     */   
/*     */   protected ResourceLocation getEntityTexture(EntitySpiderBlock spider) {
/* 159 */     return TEXTURE;
/*     */   }
/*     */   
/*     */   protected float func_77037_a(EntityLivingBase entity) {
/* 163 */     return getDeathMaxRotation((EntitySpiderBlock)entity);
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity) {
/* 167 */     return getEntityTexture((EntitySpiderBlock)entity);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderSpiderBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */