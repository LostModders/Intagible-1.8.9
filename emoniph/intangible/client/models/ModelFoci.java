/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelFoci extends net.minecraft.client.model.ModelBase
/*    */ {
/*    */   public ModelRenderer gem;
/*    */   
/*    */   public ModelFoci()
/*    */   {
/* 14 */     this.field_78090_t = 32;
/* 15 */     this.field_78089_u = 32;
/* 16 */     this.gem = new ModelRenderer(this, 0, 0);
/*    */     
/*    */ 
/*    */ 
/* 20 */     this.gem.func_78793_a(0.0F, 0.0F, 0.0F);
/* 21 */     this.gem.func_78790_a(-1.5F, -9.0F, -5.0F, 3, 3, 1, 0.0F);
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*    */   {
/* 26 */     this.gem.func_78785_a(f5);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelFoci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */