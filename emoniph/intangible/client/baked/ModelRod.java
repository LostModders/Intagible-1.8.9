/*     */ package emoniph.intangible.client.baked;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.deity.HeadSpec;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import javax.vecmath.Vector3f;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.WorldClient;
/*     */ import net.minecraft.client.renderer.ItemModelMesher;
/*     */ import net.minecraft.client.resources.model.IBakedModel;
/*     */ import net.minecraft.client.resources.model.ModelResourceLocation;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraftforge.client.model.IFlexibleBakedModel;
/*     */ import net.minecraftforge.client.model.ISmartItemModel;
/*     */ import net.minecraftforge.client.model.MultiModel.Baked;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ 
/*     */ public class ModelRod implements ISmartItemModel
/*     */ {
/*  26 */   public static final ModelResourceLocation RESOURCE_LOCATION = new ModelResourceLocation("intangible:rod", "inventory");
/*     */   private IFlexibleBakedModel baseModel;
/*     */   
/*     */   public ModelRod(IFlexibleBakedModel baseModel)
/*     */   {
/*  31 */     this.baseModel = baseModel;
/*     */   }
/*     */   
/*     */ 
/*  35 */   private static Map<Pair<Integer, UUID>, IFlexibleBakedModel> cache = new HashMap();
/*     */   
/*     */   public static void resetCache() {
/*  38 */     cache.clear();
/*     */   }
/*     */   
/*     */   public IBakedModel handleItemState(ItemStack stack)
/*     */   {
/*  43 */     Minecraft mc = Minecraft.func_71410_x();
/*  44 */     UUID deityId = Get.items().ROD.getDeityId(mc.field_71441_e, stack);
/*  45 */     if (deityId != null) {
/*  46 */       HeadSpec deityInfo = Get.deities().getClientDeityFor(mc.field_71441_e, deityId);
/*  47 */       if (deityInfo != null) {
/*  48 */         long ticks = mc.field_71441_e.func_82737_E();
/*  49 */         long speed = ticks * 2L / 3L;
/*  50 */         int moment = (int)(speed % 45L);
/*     */         
/*     */ 
/*     */ 
/*  54 */         Pair<Integer, UUID> key = Pair.of(Integer.valueOf(moment), deityId);
/*  55 */         IFlexibleBakedModel cachedModel = (IFlexibleBakedModel)cache.get(key);
/*  56 */         if (cachedModel != null) {
/*  57 */           return cachedModel;
/*     */         }
/*     */         
/*  60 */         ImmutableMap.Builder<String, IFlexibleBakedModel> builder = com.google.common.collect.ImmutableMap.builder();
/*     */         
/*     */ 
/*  63 */         Vector3f translationOffset = new Vector3f(0.0F, 0.2F, 0.0F);
/*     */         
/*  65 */         float scale = 0.15F;
/*  66 */         float baseY = 0.58F;
/*     */         
/*  68 */         Vector3f rotationPoint = new Vector3f(0.0F, (float)(Math.sin(Math.toRadians(speed * 2L % 45L * 8L)) * 0.1D + baseY), 0.0F);
/*  69 */         addTo(builder, 1, deityInfo.getItemA(), rotationPoint, (float)Math.toRadians(speed % 45L) * 8.0F, translationOffset, scale);
/*     */         
/*  71 */         rotationPoint.setY((float)(Math.sin(Math.toRadians((speed * 2L + 15L) * 8L)) * 0.1D + baseY));
/*  72 */         addTo(builder, 2, deityInfo.getItemB(), rotationPoint, (float)Math.toRadians(speed + 15L) * 8.0F, translationOffset, scale);
/*  73 */         rotationPoint.setY((float)(Math.sin(Math.toRadians((speed * 2L + 30L) * 8L)) * 0.1D + baseY));
/*  74 */         addTo(builder, 3, deityInfo.getItemC(), rotationPoint, (float)Math.toRadians(speed + 30L) * 8.0F, translationOffset, scale);
/*     */         
/*  76 */         MultiModel.Baked bakedModel = new MultiModel.Baked(null, true, this.baseModel, builder.build());
/*     */         
/*  78 */         ModelPerspectiveAwareWrapper finalModel = new ModelPerspectiveAwareWrapper(this.baseModel, bakedModel);
/*  79 */         cache.put(key, finalModel);
/*     */         
/*  81 */         return finalModel;
/*     */       }
/*     */     }
/*     */     
/*  85 */     return this.baseModel;
/*     */   }
/*     */   
/*     */   private void addTo(ImmutableMap.Builder<String, IFlexibleBakedModel> builder, int index, ItemStack stack, Vector3f rotationPoint, float rotation, Vector3f translationOffset, float scale)
/*     */   {
/*  90 */     IBakedModel model = stack != null ? Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178089_a(stack) : null;
/*  91 */     if ((model != null) && ((model instanceof IFlexibleBakedModel))) {
/*  92 */       builder.put(String.valueOf(index), new RTRSRBakedModel((IFlexibleBakedModel)model, rotationPoint, new Vector3f(1.5707964F, 1.5707964F, rotation), translationOffset, scale, null));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public List func_177551_a(EnumFacing face)
/*     */   {
/* 102 */     return this.baseModel.func_177551_a(face);
/*     */   }
/*     */   
/*     */   public List func_177550_a()
/*     */   {
/* 107 */     return this.baseModel.func_177550_a();
/*     */   }
/*     */   
/*     */   public boolean func_177555_b()
/*     */   {
/* 112 */     return this.baseModel.func_177555_b();
/*     */   }
/*     */   
/*     */   public boolean func_177556_c()
/*     */   {
/* 117 */     return this.baseModel.func_177556_c();
/*     */   }
/*     */   
/*     */   public boolean func_177553_d()
/*     */   {
/* 122 */     return this.baseModel.func_177553_d();
/*     */   }
/*     */   
/*     */   public net.minecraft.client.renderer.texture.TextureAtlasSprite func_177554_e()
/*     */   {
/* 127 */     return this.baseModel.func_177554_e();
/*     */   }
/*     */   
/*     */   public net.minecraft.client.renderer.block.model.ItemCameraTransforms func_177552_f()
/*     */   {
/* 132 */     return this.baseModel.func_177552_f();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/baked/ModelRod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */