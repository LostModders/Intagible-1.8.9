/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemHeadEars extends ModelGolemHeadArmored
/*    */ {
/*    */   public ModelRenderer earR;
/*    */   public ModelRenderer earL;
/*    */   
/*    */   public ModelGolemHeadEars()
/*    */   {
/* 14 */     this.earR = new ModelRenderer(this, 86, 0);
/* 15 */     this.earR.func_78793_a(0.0F, 0.0F, 0.0F);
/* 16 */     this.earR.func_78790_a(-4.5F, -12.0F, -1.0F, 1, 10, 2, 0.0F);
/*    */     
/* 18 */     this.earL = new ModelRenderer(this, 86, 0);
/* 19 */     this.earL.field_78809_i = true;
/* 20 */     this.earL.func_78793_a(0.0F, 0.0F, 0.0F);
/* 21 */     this.earL.func_78790_a(3.5F, -12.0F, -1.0F, 1, 10, 2, 0.0F);
/*    */     
/* 23 */     this.head.func_78792_a(this.earR);
/* 24 */     this.head.func_78792_a(this.earL);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemHeadEars.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */