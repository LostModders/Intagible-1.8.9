/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelResearchSplitter;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderResearchSplitter
/*    */   extends RenderResearchBlock
/*    */ {
/* 12 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/splitter.png");
/*    */   
/*    */   public RenderResearchSplitter() {
/* 15 */     super(new ModelResearchSplitter());
/*    */   }
/*    */   
/*    */   protected ResourceLocation getTexture()
/*    */   {
/* 20 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderResearchSplitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */