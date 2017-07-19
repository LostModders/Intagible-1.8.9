/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import emoniph.intangible.client.baked.RTRSRBakedModel;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import javax.vecmath.Vector3f;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.BlockModelShapes;
/*     */ import net.minecraft.client.renderer.BlockRendererDispatcher;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.block.model.BakedQuad;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*     */ import net.minecraft.client.resources.model.IBakedModel;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.model.IFlexibleBakedModel;
/*     */ import net.minecraftforge.client.model.ISmartBlockModel;
/*     */ import net.minecraftforge.client.model.MultiModel.Baked;
/*     */ import net.minecraftforge.client.model.TRSRTransformation;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class ModelDeityHead extends ModelBase
/*     */ {
/*     */   public ModelRenderer root;
/*  38 */   private List<ModelRenderer> renderers = new ArrayList();
/*     */   private IFlexibleBakedModel model;
/*     */   
/*  41 */   public ModelDeityHead() { this.field_78090_t = 32;
/*  42 */     this.field_78089_u = 32;
/*  43 */     this.root = new ModelRenderer(this, 0, 0);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entityIn, float f, float f1, float f2, float f3, float f4, float scale)
/*     */   {
/*  48 */     render(entityIn, f, f1, f2, f3, f4, scale, entityIn.field_70170_p);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, World world)
/*     */   {
/*  56 */     if (this.model == null) {
/*  57 */       ImmutableMap.Builder<String, IFlexibleBakedModel> builder = com.google.common.collect.ImmutableMap.builder();
/*  58 */       int index = 0;
/*  59 */       BlockModelShapes bms = Minecraft.func_71410_x().func_175602_ab().func_175023_a();
/*  60 */       IBakedModel blockModel; if (this.bricks.size() == 0) {
/*  61 */         blockModel = bms.func_178125_b(Blocks.field_150348_b.func_176223_P());
/*  62 */         if (blockModel != null) {
/*  63 */           builder.put(String.valueOf(index++), new RTRSRBakedModel((IFlexibleBakedModel)blockModel, new TRSRTransformation(new Vector3f(0.0F, 0.0F, 0.0F), null, null, null), 
/*  64 */             Integer.valueOf(Blocks.field_150348_b.func_149635_D())));
/*     */         }
/*     */       } else {
/*  67 */         for (blockModel = this.bricks.iterator(); blockModel.hasNext();) { brick = (Brick)blockModel.next();
/*  68 */           blockModel = bms.func_178125_b(brick.state);
/*  69 */           if ((blockModel instanceof ISmartBlockModel)) {
/*  70 */             smartModel = (ISmartBlockModel)blockModel;
/*  71 */             blockModel = smartModel.handleBlockState(brick.state);
/*     */           }
/*  73 */           if (blockModel != null) {
/*  74 */             builder.put(String.valueOf(index++), new RTRSRBakedModel((IFlexibleBakedModel)blockModel, new TRSRTransformation(new Vector3f(brick.x, brick.y, brick.z), null, null, null), 
/*     */             
/*     */ 
/*  77 */               Integer.valueOf(brick.state.func_177230_c().func_180644_h(brick.state))));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*  82 */       final MultiModel.Baked bakedModel = new MultiModel.Baked(null, true, null, builder.build());
/*  83 */       this.model = new IFlexibleBakedModel()
/*     */       {
/*     */         public net.minecraft.client.renderer.vertex.VertexFormat getFormat() {
/*  86 */           return bakedModel.getFormat();
/*     */         }
/*     */         
/*     */         public List<BakedQuad> func_177551_a(EnumFacing facing)
/*     */         {
/*  91 */           return bakedModel.func_177551_a(facing);
/*     */         }
/*     */         
/*     */         public List<BakedQuad> func_177550_a()
/*     */         {
/*  96 */           return bakedModel.func_177550_a();
/*     */         }
/*     */         
/*     */         public boolean func_177555_b()
/*     */         {
/* 101 */           return false;
/*     */         }
/*     */         
/*     */         public boolean func_177556_c()
/*     */         {
/* 106 */           return bakedModel.func_177556_c();
/*     */         }
/*     */         
/*     */         public boolean func_177553_d()
/*     */         {
/* 111 */           return false;
/*     */         }
/*     */         
/*     */         public net.minecraft.client.renderer.texture.TextureAtlasSprite func_177554_e()
/*     */         {
/* 116 */           return bakedModel.func_177554_e();
/*     */         }
/*     */         
/*     */         public net.minecraft.client.renderer.block.model.ItemCameraTransforms func_177552_f()
/*     */         {
/* 121 */           return bakedModel.func_177552_f();
/*     */         }
/*     */       };
/*     */     }
/*     */     
/*     */ 
/* 127 */     float scale = 0.125F;
/* 128 */     float invScale = 1.0F / scale;
/* 129 */     GlStateManager.func_179094_E();
/* 130 */     GlStateManager.func_179089_o();
/* 131 */     GlStateManager.func_179140_f();
/* 132 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/* 133 */     GlStateManager.func_179152_a(scale, scale, scale);
/* 134 */     GlStateManager.func_179137_b(-1.5D, 0.2D, -1.5D);
/*     */     
/*     */ 
/* 137 */     Minecraft.func_71410_x().func_175599_af().func_180454_a(new ItemStack(Blocks.field_150348_b), this.model);
/*     */     
/* 139 */     GlStateManager.func_179094_E();
/* 140 */     GlStateManager.func_179152_a(0.5F, 0.5F, 0.5F);
/* 141 */     GlStateManager.func_179109_b(-0.5F, -0.5F, -0.5F);
/*     */     
/*     */ 
/*     */ 
/* 145 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 146 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/* 147 */     worldrenderer.func_181668_a(7, DefaultVertexFormats.field_176599_b);
/* 148 */     Brick brick = EnumFacing.values();IBakedModel blockModel = brick.length; for (ISmartBlockModel smartModel = 0; smartModel < blockModel; smartModel++) { EnumFacing enumfacing = brick[smartModel];
/* 149 */       renderQuads(worldrenderer, this.model.func_177551_a(enumfacing));
/*     */     }
/* 151 */     renderQuads(worldrenderer, this.model.func_177550_a());
/* 152 */     tessellator.func_78381_a();
/*     */     
/* 154 */     GlStateManager.func_179121_F();
/*     */     
/*     */ 
/* 157 */     GlStateManager.func_179145_e();
/* 158 */     GlStateManager.func_179152_a(invScale, invScale, invScale);
/* 159 */     GlStateManager.func_179129_p();
/* 160 */     GlStateManager.func_179121_F();
/*     */   }
/*     */   
/*     */   private void renderQuads(WorldRenderer renderer, List<BakedQuad> quads)
/*     */   {
/* 165 */     int i = 0;
/*     */     
/* 167 */     for (int j = quads.size(); i < j; i++) {
/* 168 */       BakedQuad bakedquad = (BakedQuad)quads.get(i);
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
/* 181 */       renderer.func_178981_a(bakedquad.func_178209_a());
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Brick
/*     */   {
/*     */     final int x;
/*     */     final int y;
/*     */     final int z;
/*     */     final IBlockState state;
/*     */     
/*     */     public Brick(IBlockState state, int x, int y, int z) {
/* 193 */       this.state = state;
/* 194 */       this.x = x;
/* 195 */       this.y = y;
/* 196 */       this.z = z;
/*     */     }
/*     */   }
/*     */   
/* 200 */   private final List<Brick> bricks = new ArrayList();
/*     */   
/*     */   public void addBlock(Block block, int meta, int x, int y, int z) {
/* 203 */     this.bricks.add(new Brick(block.func_176203_a(meta), x, y, z));
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDeityHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */