/*    */ package emoniph.intangible.client.models.extended;
/*    */ 
/*    */ import net.minecraft.client.model.ModelBox;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.client.model.PositionTextureVertex;
/*    */ import net.minecraft.client.model.TexturedQuad;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class CustomModelBox
/*    */   extends ModelBox
/*    */ {
/*    */   public CustomModelBox(ModelRenderer renderer, int textureOffsetX, int textureOffsetY, float offsetX, float offsetY, float offsetZ, int width, int height, int depth, float scale, boolean mirror)
/*    */   {
/* 18 */     super(renderer, textureOffsetX, textureOffsetY, offsetX, offsetY, offsetZ, width, height, depth, scale, mirror);
/*    */     
/* 20 */     this.field_78254_i[0] = new TexturedQuad(new PositionTextureVertex[] { this.field_78253_h[5], this.field_78253_h[1], this.field_78253_h[2], this.field_78253_h[6] }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 31 */     this.field_78254_i[1] = new TexturedQuad(new PositionTextureVertex[] { this.field_78253_h[0], this.field_78253_h[4], this.field_78253_h[7], this.field_78253_h[3] }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 42 */     this.field_78254_i[2] = new TexturedQuad(new PositionTextureVertex[] { this.field_78253_h[5], this.field_78253_h[4], this.field_78253_h[0], this.field_78253_h[1] }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 53 */     this.field_78254_i[3] = new TexturedQuad(new PositionTextureVertex[] { this.field_78253_h[2], this.field_78253_h[3], this.field_78253_h[7], this.field_78253_h[6] }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 64 */     this.field_78254_i[4] = new TexturedQuad(new PositionTextureVertex[] { this.field_78253_h[1], this.field_78253_h[0], this.field_78253_h[3], this.field_78253_h[2] }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 75 */     this.field_78254_i[5] = new TexturedQuad(new PositionTextureVertex[] { this.field_78253_h[4], this.field_78253_h[5], this.field_78253_h[6], this.field_78253_h[7] }, textureOffsetX, textureOffsetY + depth, textureOffsetX + depth, textureOffsetY + depth + height, renderer.field_78801_a, renderer.field_78799_b);
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 87 */     if (mirror) {
/* 88 */       for (int j1 = 0; j1 < this.field_78254_i.length; j1++) {
/* 89 */         this.field_78254_i[j1].func_78235_a();
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/extended/CustomModelBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */