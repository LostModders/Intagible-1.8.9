/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelGolemHeadHoover extends ModelGolemHead
/*    */ {
/*    */   public ModelRenderer headHoover1;
/*    */   public ModelRenderer headHoover2;
/*    */   
/*    */   public ModelGolemHeadHoover()
/*    */   {
/* 14 */     this.field_78090_t = 32;
/* 15 */     this.field_78089_u = 32;
/* 16 */     this.head = new ModelRenderer(this, 0, 0);
/* 17 */     this.head.func_78793_a(0.0F, -12.0F, -1.0F);
/* 18 */     this.head.func_78790_a(-4.0F, -10.0F, -4.0F, 8, 8, 8, 0.0F);
/*    */     
/* 20 */     this.headHoover1 = new ModelRenderer(this, 0, 16);
/* 21 */     this.headHoover1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 22 */     this.headHoover1.func_78790_a(-1.5F, -3.5F, 4.2F, 3, 12, 2, 0.0F);
/* 23 */     setRotateAngle(this.headHoover1, 0.7285004F, 0.0F, 0.0F);
/*    */     
/* 25 */     this.headHoover2 = new ModelRenderer(this, 12, 17);
/* 26 */     this.headHoover2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 27 */     this.headHoover2.func_78790_a(-3.0F, 8.5F, 3.5F, 6, 4, 4, 0.0F);
/*    */     
/* 29 */     this.head.func_78792_a(this.headHoover1);
/* 30 */     this.headHoover1.func_78792_a(this.headHoover2);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelGolemHeadHoover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */