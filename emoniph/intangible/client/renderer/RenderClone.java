/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityClone;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.client.model.ModelPlayer;
/*    */ import net.minecraft.client.renderer.entity.RenderBiped;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
/*    */ import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderClone
/*    */   extends RenderBiped<EntityClone>
/*    */ {
/*    */   public RenderClone(RenderManager renderManagerIn)
/*    */   {
/* 22 */     super(renderManagerIn, new ModelBiped(), 0.5F);
/* 23 */     func_177094_a(new LayerBipedArmor(this));
/* 24 */     func_177094_a(new LayerHeldItem(this));
/*    */   }
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityClone entity)
/*    */   {
/* 29 */     return entity.getSkinLocation();
/*    */   }
/*    */   
/* 32 */   private static final ModelPlayer steve = new ModelPlayer(0.0F, false);
/* 33 */   private static final ModelPlayer alex = new ModelPlayer(0.0F, true);
/*    */   
/*    */   public void doRender(EntityClone entity, double x, double y, double z, float entityYaw, float partialTicks)
/*    */   {
/* 37 */     ModelPlayer model = entity.getSkinType().equals("slim") ? alex : steve;
/* 38 */     this.field_77045_g = model;
/*    */     
/*    */ 
/* 41 */     ItemStack heldStack = entity.func_71124_b(0);
/*    */     
/*    */ 
/*    */ 
/* 45 */     super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
/*    */   }
/*    */   
/*    */   protected boolean canRenderName(EntityClone entity)
/*    */   {
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderClone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */