/*     */ package emoniph.intangible.client.baked;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableList.Builder;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.Maps;
/*     */ import java.util.EnumMap;
/*     */ import java.util.List;
/*     */ import javax.vecmath.Matrix3f;
/*     */ import javax.vecmath.Matrix4f;
/*     */ import javax.vecmath.Vector3f;
/*     */ import javax.vecmath.Vector4f;
/*     */ import net.minecraft.client.renderer.block.model.BakedQuad;
/*     */ import net.minecraft.client.renderer.vertex.VertexFormat;
/*     */ import net.minecraft.client.renderer.vertex.VertexFormatElement.EnumUsage;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraftforge.client.model.IFlexibleBakedModel;
/*     */ import net.minecraftforge.client.model.TRSRTransformation;
/*     */ import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
/*     */ import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad.Builder;
/*     */ import net.minecraftforge.client.model.pipeline.VertexTransformer;
/*     */ 
/*     */ public class RTRSRBakedModel implements IFlexibleBakedModel
/*     */ {
/*     */   private final ImmutableList<BakedQuad> general;
/*     */   private final ImmutableMap<EnumFacing, ImmutableList<BakedQuad>> faces;
/*     */   private final IFlexibleBakedModel original;
/*     */   
/*     */   public RTRSRBakedModel(IFlexibleBakedModel original, Vector3f rotatePoint, Vector3f rotate, Vector3f translate, float scale, Integer tint)
/*     */   {
/*  31 */     this(original, new TRSRTransformation(rotatePoint, 
/*  32 */       TRSRTransformation.quatFromYXZ(rotate.y, rotate.x, rotate.z), null, null)
/*  33 */       .compose(new TRSRTransformation(translate, TRSRTransformation.quatFromYXZ(0.0F, -1.5707964F, 0.0F), new Vector3f(scale, scale, scale), null)), tint);
/*     */   }
/*     */   
/*     */   public RTRSRBakedModel(IFlexibleBakedModel original, TRSRTransformation transform, Integer tint) {
/*  37 */     this.original = original;
/*     */     
/*     */ 
/*  40 */     ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
/*     */     
/*  42 */     transform = TRSRTransformation.blockCenterToCorner(transform);
/*     */     
/*  44 */     EnumMap<EnumFacing, ImmutableList<BakedQuad>> faces = Maps.newEnumMap(EnumFacing.class);
/*  45 */     for (EnumFacing face : EnumFacing.values()) {
/*  46 */       List<BakedQuad> faceQuads = original.func_177551_a(face);
/*  47 */       if (faceQuads != null) {
/*  48 */         for (BakedQuad quad : faceQuads) {
/*  49 */           Transformer transformer = new Transformer(transform, original.getFormat());
/*  50 */           if (tint != null) {
/*  51 */             transformer.setQuadColor(tint.intValue());
/*     */           }
/*  53 */           quad.pipe(transformer);
/*  54 */           builder.add(transformer.build());
/*     */         }
/*     */       }
/*  57 */       faces.put(face, ImmutableList.of());
/*     */     }
/*     */     
/*  60 */     Object generalQuads = original.func_177550_a();
/*  61 */     if (generalQuads != null) {
/*  62 */       for (BakedQuad quad : (List)generalQuads) {
/*  63 */         Transformer transformer = new Transformer(transform, original.getFormat());
/*  64 */         if (tint != null) {
/*  65 */           transformer.setQuadColor(tint.intValue());
/*     */         }
/*  67 */         quad.pipe(transformer);
/*  68 */         builder.add(transformer.build());
/*     */       }
/*     */     }
/*     */     
/*  72 */     this.general = builder.build();
/*  73 */     this.faces = Maps.immutableEnumMap(faces);
/*     */   }
/*     */   
/*     */   public List<BakedQuad> func_177551_a(EnumFacing side)
/*     */   {
/*  78 */     return (List)this.faces.get(side);
/*     */   }
/*     */   
/*     */   public List<BakedQuad> func_177550_a()
/*     */   {
/*  83 */     return this.general;
/*     */   }
/*     */   
/*     */   public boolean func_177555_b()
/*     */   {
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_177556_c()
/*     */   {
/*  93 */     return this.original.func_177556_c();
/*     */   }
/*     */   
/*     */   public boolean func_177553_d()
/*     */   {
/*  98 */     return this.original.func_177553_d();
/*     */   }
/*     */   
/*     */   public net.minecraft.client.renderer.texture.TextureAtlasSprite func_177554_e()
/*     */   {
/* 103 */     return this.original.func_177554_e();
/*     */   }
/*     */   
/*     */   public net.minecraft.client.renderer.block.model.ItemCameraTransforms func_177552_f()
/*     */   {
/* 108 */     return this.original.func_177552_f();
/*     */   }
/*     */   
/*     */   public VertexFormat getFormat()
/*     */   {
/* 113 */     return this.original.getFormat();
/*     */   }
/*     */   
/*     */   public static class Transformer extends VertexTransformer
/*     */   {
/*     */     protected Matrix4f transformation;
/*     */     protected Matrix3f normalTransformation;
/*     */     
/*     */     public Transformer(TRSRTransformation transformation, VertexFormat format)
/*     */     {
/* 123 */       super();
/* 124 */       this.transformation = transformation.getMatrix();
/* 125 */       this.normalTransformation = new Matrix3f();
/* 126 */       this.transformation.getRotationScale(this.normalTransformation);
/* 127 */       this.normalTransformation.invert();
/* 128 */       this.normalTransformation.transpose();
/*     */     }
/*     */     
/*     */     public void setQuadTint(int tint)
/*     */     {
/* 133 */       super.setQuadTint(tint);
/* 134 */       this.colored = (tint != -1);
/*     */     }
/*     */     
/*     */     public void put(int element, float... data)
/*     */     {
/* 139 */       VertexFormatElement.EnumUsage usage = this.parent.getVertexFormat().func_177348_c(element).func_177375_c();
/*     */       
/* 141 */       if (usage == VertexFormatElement.EnumUsage.POSITION) {
/* 142 */         Vector4f vec = new Vector4f(data);
/* 143 */         vec.setW(1.0F);
/* 144 */         this.transformation.transform(vec);
/* 145 */         data = new float[4];
/* 146 */         vec.get(data);
/* 147 */         super.put(element, data);
/* 148 */       } else if (usage == VertexFormatElement.EnumUsage.NORMAL) {
/* 149 */         Vector3f vec = new Vector3f(data);
/* 150 */         this.normalTransformation.transform(vec);
/* 151 */         vec.normalize();
/* 152 */         data = new float[4];
/* 153 */         vec.get(data);
/* 154 */         super.put(element, data);
/* 155 */       } else if (usage == VertexFormatElement.EnumUsage.COLOR) {
/* 156 */         System.arraycopy(this.auxColor, 0, this.buf, 0, this.buf.length);
/* 157 */         if (this.colored) {
/* 158 */           for (int i = 0; i < 4; i++) {
/* 159 */             this.buf[i] *= data[i];
/*     */           }
/* 161 */           super.put(element, this.buf);
/*     */         } else {
/* 163 */           super.put(element, data);
/*     */         }
/*     */       }
/*     */       else {
/* 167 */         super.put(element, data);
/*     */       }
/*     */     }
/*     */     
/*     */     public UnpackedBakedQuad build() {
/* 172 */       return ((UnpackedBakedQuad.Builder)this.parent).build();
/*     */     }
/*     */     
/* 175 */     private float[] auxColor = { 1.0F, 1.0F, 1.0F, 1.0F };
/* 176 */     private float[] buf = new float[4];
/* 177 */     private boolean colored = false;
/*     */     
/*     */     public void setQuadColor(int quadColor)
/*     */     {
/* 181 */       float a = (quadColor >> 24 & 0xFF) / 256.0F;
/* 182 */       float r = (quadColor >> 16 & 0xFF) / 256.0F;
/* 183 */       float g = (quadColor >> 8 & 0xFF) / 256.0F;
/* 184 */       float b = (quadColor & 0xFF) / 256.0F;
/* 185 */       System.arraycopy(new float[] { r, g, b, 1.0F }, 0, this.auxColor, 0, this.auxColor.length);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/baked/RTRSRBakedModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */