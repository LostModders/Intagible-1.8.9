/*    */ package emoniph.intangible.client.baked;
/*    */ 
/*    */ import java.util.List;
/*    */ import javax.vecmath.Matrix4f;
/*    */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*    */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
/*    */ import net.minecraft.client.renderer.texture.TextureAtlasSprite;
/*    */ import net.minecraft.client.renderer.vertex.VertexFormat;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraftforge.client.model.IFlexibleBakedModel;
/*    */ import net.minecraftforge.client.model.IPerspectiveAwareModel;
/*    */ import org.apache.commons.lang3.tuple.Pair;
/*    */ 
/*    */ public class ModelPerspectiveAwareWrapper
/*    */   implements IPerspectiveAwareModel, IFlexibleBakedModel
/*    */ {
/*    */   private IFlexibleBakedModel baseModel;
/*    */   private IPerspectiveAwareModel perspectiveModel;
/*    */   
/*    */   public ModelPerspectiveAwareWrapper(IFlexibleBakedModel model, IPerspectiveAwareModel perspectiveModel)
/*    */   {
/* 22 */     this.baseModel = model;
/* 23 */     this.perspectiveModel = perspectiveModel;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public Pair<? extends IFlexibleBakedModel, Matrix4f> handlePerspective(ItemCameraTransforms.TransformType cameraTransformType)
/*    */   {
/* 31 */     Pair<? extends IFlexibleBakedModel, Matrix4f> originalModelAndTransform = this.perspectiveModel.handlePerspective(cameraTransformType);
/* 32 */     return originalModelAndTransform;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public List func_177551_a(EnumFacing face)
/*    */   {
/* 45 */     return this.perspectiveModel.func_177551_a(face);
/*    */   }
/*    */   
/*    */   public List func_177550_a()
/*    */   {
/* 50 */     return this.perspectiveModel.func_177550_a();
/*    */   }
/*    */   
/*    */   public VertexFormat getFormat()
/*    */   {
/* 55 */     return this.perspectiveModel.getFormat();
/*    */   }
/*    */   
/*    */   public boolean func_177555_b()
/*    */   {
/* 60 */     return this.perspectiveModel.func_177555_b();
/*    */   }
/*    */   
/*    */   public boolean func_177556_c()
/*    */   {
/* 65 */     return this.perspectiveModel.func_177556_c();
/*    */   }
/*    */   
/*    */   public boolean func_177553_d()
/*    */   {
/* 70 */     return this.perspectiveModel.func_177553_d();
/*    */   }
/*    */   
/*    */   public TextureAtlasSprite func_177554_e()
/*    */   {
/* 75 */     return this.perspectiveModel.func_177554_e();
/*    */   }
/*    */   
/*    */   public ItemCameraTransforms func_177552_f()
/*    */   {
/* 80 */     return this.perspectiveModel.func_177552_f();
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/baked/ModelPerspectiveAwareWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */