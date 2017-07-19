/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBase;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ModelGolemHead
/*    */   extends ModelBase
/*    */ {
/*    */   public ModelRenderer head;
/*    */   
/*    */   protected void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*    */   {
/* 17 */     modelRenderer.field_78795_f = x;
/* 18 */     modelRenderer.field_78796_g = y;
/* 19 */     modelRenderer.field_78808_h = z;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemHead.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */