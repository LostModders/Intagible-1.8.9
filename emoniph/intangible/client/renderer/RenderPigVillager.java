/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelPigVillager;
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.entity.RenderLiving;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerCustomHead;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.passive.EntityVillager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderPigVillager extends RenderLiving
/*    */ {
/* 19 */   private static final ResourceLocation villagerTextures = new ResourceLocation("intangible:textures/entity/pigvillager.png");
/* 20 */   private static final ResourceLocation farmerVillagerTextures = new ResourceLocation("intangible:textures/entity/pigvillager_farmer.png");
/* 21 */   private static final ResourceLocation librarianVillagerTextures = new ResourceLocation("intangible:textures/entity/pigvillager_librarian.png");
/* 22 */   private static final ResourceLocation priestVillagerTextures = new ResourceLocation("intangible:textures/entity/pigvillager_priest.png");
/* 23 */   private static final ResourceLocation smithVillagerTextures = new ResourceLocation("intangible:textures/entity/pigvillager_smith.png");
/* 24 */   private static final ResourceLocation butcherVillagerTextures = new ResourceLocation("intangible:textures/entity/pigvillager_butcher.png");
/*    */   
/*    */   public RenderPigVillager(RenderManager renderManager) {
/* 27 */     super(renderManager, new ModelPigVillager(0.0F), 0.5F);
/* 28 */     func_177094_a(new LayerCustomHead(getPigVillagerModel().head));
/*    */   }
/*    */   
/*    */   public ModelPigVillager getPigVillagerModel() {
/* 32 */     return (ModelPigVillager)super.func_177087_b();
/*    */   }
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityVillager entity) {
/* 36 */     switch (entity.func_70946_n()) {
/*    */     case 0: 
/* 38 */       return farmerVillagerTextures;
/*    */     case 1: 
/* 40 */       return librarianVillagerTextures;
/*    */     case 2: 
/* 42 */       return priestVillagerTextures;
/*    */     case 3: 
/* 44 */       return smithVillagerTextures;
/*    */     case 4: 
/* 46 */       return butcherVillagerTextures;
/*    */     }
/* 48 */     return farmerVillagerTextures;
/*    */   }
/*    */   
/*    */   protected void preRenderCallback(EntityVillager p_77041_1_, float p_77041_2_)
/*    */   {
/* 53 */     float f1 = 0.9375F;
/*    */     
/* 55 */     if (p_77041_1_.func_70874_b() < 0) {
/* 56 */       f1 = (float)(f1 * 0.5D);
/* 57 */       this.field_76989_e = 0.25F;
/*    */     } else {
/* 59 */       this.field_76989_e = 0.5F;
/*    */     }
/*    */     
/* 62 */     GlStateManager.func_179152_a(f1, f1, f1);
/*    */   }
/*    */   
/*    */   protected void func_77041_b(EntityLivingBase p_77041_1_, float p_77041_2_) {
/* 66 */     preRenderCallback((EntityVillager)p_77041_1_, p_77041_2_);
/*    */   }
/*    */   
/*    */   public ModelBase func_177087_b() {
/* 70 */     return getPigVillagerModel();
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 74 */     return getEntityTexture((EntityVillager)entity);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderPigVillager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */