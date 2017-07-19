/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelResearchGourd;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderResearchGourd extends RenderResearchBlock
/*    */ {
/* 11 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/gourd.png");
/*    */   
/*    */   public RenderResearchGourd() {
/* 14 */     super(new ModelResearchGourd());
/*    */   }
/*    */   
/*    */   protected ResourceLocation getTexture()
/*    */   {
/* 19 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderResearchGourd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */