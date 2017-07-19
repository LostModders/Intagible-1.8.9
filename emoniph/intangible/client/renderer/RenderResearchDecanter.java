/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.client.models.ModelResearchDecanter;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderResearchDecanter extends RenderResearchBlock
/*    */ {
/*    */   public RenderResearchDecanter()
/*    */   {
/* 13 */     super(new ModelResearchDecanter());
/*    */   }
/*    */   
/* 16 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/decanter.png");
/*    */   
/*    */   protected ResourceLocation getTexture()
/*    */   {
/* 20 */     return TEXTURE;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderResearchDecanter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */