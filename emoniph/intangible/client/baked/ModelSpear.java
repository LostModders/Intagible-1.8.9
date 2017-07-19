/*     */ package emoniph.intangible.client.baked;
/*     */ 
/*     */ import com.google.common.collect.ImmutableMap.Builder;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.items.ItemBoneSpear;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.vecmath.Vector3f;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.ItemModelMesher;
/*     */ import net.minecraft.client.renderer.block.model.BakedQuad;
/*     */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.resources.model.IBakedModel;
/*     */ import net.minecraft.client.resources.model.ModelManager;
/*     */ import net.minecraft.client.resources.model.ModelResourceLocation;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraftforge.client.model.IFlexibleBakedModel;
/*     */ import net.minecraftforge.client.model.ISmartItemModel;
/*     */ import net.minecraftforge.client.model.MultiModel.Baked;
/*     */ import org.apache.commons.lang3.tuple.Pair;
/*     */ 
/*     */ public class ModelSpear implements ISmartItemModel
/*     */ {
/*  28 */   public static final ModelResourceLocation RESOURCE_LOCATION = new ModelResourceLocation("intangible:soulspear_basic", "inventory");
/*  29 */   public static final ModelResourceLocation SHIELD_RESOURCE_LOCATION = new ModelResourceLocation("intangible:soulspear_shield", "inventory");
/*  30 */   public static final ModelResourceLocation EXTENDED_RESOURCE_LOCATION = new ModelResourceLocation("intangible:soulspear_extended", "inventory");
/*     */   private IFlexibleBakedModel baseModel;
/*     */   
/*     */   public ModelSpear(IFlexibleBakedModel baseModel)
/*     */   {
/*  35 */     this.baseModel = baseModel;
/*     */   }
/*     */   
/*  38 */   private static Map<Pair<String, Integer>, IFlexibleBakedModel> cache = new HashMap();
/*     */   
/*     */   public static void resetCache() {
/*  41 */     cache.clear();
/*     */   }
/*     */   
/*     */   public IBakedModel handleItemState(ItemStack stack)
/*     */   {
/*  46 */     IBakedModel model = this.baseModel;
/*  47 */     if (Get.items().SOUL_SPEAR.isExtended(stack))
/*     */     {
/*  49 */       model = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(EXTENDED_RESOURCE_LOCATION);
/*  50 */     } else if (Get.items().SOUL_SPEAR.isShield(stack))
/*     */     {
/*  52 */       model = Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178083_a().func_174953_a(SHIELD_RESOURCE_LOCATION);
/*     */     }
/*     */     
/*  55 */     ItemStack item = Get.items().SOUL_SPEAR.getThrowable(stack);
/*  56 */     if (item != null) {
/*  57 */       Pair<String, Integer> key = Pair.of(item.func_77977_a(), Integer.valueOf(item.func_77981_g() ? item.func_77952_i() : 0));
/*  58 */       IFlexibleBakedModel cachedModel = (IFlexibleBakedModel)cache.get(key);
/*  59 */       if (cachedModel != null) {
/*  60 */         model = cachedModel;
/*     */       } else {
/*  62 */         ImmutableMap.Builder<String, IFlexibleBakedModel> builder = com.google.common.collect.ImmutableMap.builder();
/*  63 */         IBakedModel itemModel = stack != null ? Minecraft.func_71410_x().func_175599_af().func_175037_a().func_178089_a(item) : null;
/*  64 */         if (itemModel != null) {
/*  65 */           builder.put(String.valueOf(1), new RTRSRBakedModel((IFlexibleBakedModel)itemModel, new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 0.0F, 0.0F), new Vector3f(0.0F, 1.1F, 0.0F), 0.5F, null));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*  70 */           MultiModel.Baked bakedModel = new MultiModel.Baked(null, true, this.baseModel, builder.build());
/*  71 */           cache.put(key, bakedModel);
/*  72 */           model = bakedModel;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  77 */     return model;
/*     */   }
/*     */   
/*     */   public List<BakedQuad> func_177551_a(EnumFacing face)
/*     */   {
/*  82 */     return this.baseModel.func_177551_a(face);
/*     */   }
/*     */   
/*     */   public List<BakedQuad> func_177550_a()
/*     */   {
/*  87 */     return this.baseModel.func_177550_a();
/*     */   }
/*     */   
/*     */   public boolean func_177555_b()
/*     */   {
/*  92 */     return this.baseModel.func_177555_b();
/*     */   }
/*     */   
/*     */   public boolean func_177556_c()
/*     */   {
/*  97 */     return this.baseModel.func_177556_c();
/*     */   }
/*     */   
/*     */   public boolean func_177553_d()
/*     */   {
/* 102 */     return this.baseModel.func_177553_d();
/*     */   }
/*     */   
/*     */   public net.minecraft.client.renderer.texture.TextureAtlasSprite func_177554_e()
/*     */   {
/* 107 */     return this.baseModel.func_177554_e();
/*     */   }
/*     */   
/*     */   public ItemCameraTransforms func_177552_f()
/*     */   {
/* 112 */     return this.baseModel.func_177552_f();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/baked/ModelSpear.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */