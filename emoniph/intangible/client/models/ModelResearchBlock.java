/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ 
/*    */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public abstract class ModelResearchBlock extends net.minecraft.client.model.ModelBase
/*    */ {
/*    */   protected int augmentedColor;
/*    */   
/*    */   public abstract ModelRenderer getOutputTop();
/*    */   
/*    */   public abstract ModelRenderer getOutputBottom();
/*    */   
/*    */   public abstract ModelRenderer getOutputTopTop();
/*    */   
/*    */   public abstract ModelRenderer getOutputBottomBottom();
/*    */   
/*    */   public abstract ModelRenderer getOutputTopSide();
/*    */   
/*    */   public abstract ModelRenderer getOutputBottomSide();
/*    */   
/*    */   public void setColorAugment(int color)
/*    */   {
/* 24 */     this.augmentedColor = color;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelResearchBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */