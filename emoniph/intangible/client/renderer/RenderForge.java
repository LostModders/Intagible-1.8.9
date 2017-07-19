/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.blocks.BlockSoulForge.TileEntitySoulForge;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelSoulForge;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderForge extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  18 */   private ModelSoulForge model = new ModelSoulForge();
/*     */   
/*  20 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/soulforge.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  24 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  25 */     if ((state.func_177230_c() == emoniph.intangible.Get.blocks().SOUL_FORGE) && (state.func_177229_b(emoniph.intangible.blocks.BlockSoulForge.PART) == emoniph.intangible.blocks.BlockSoulForge.EnumPart.BOTTOM) && ((tile instanceof BlockSoulForge.TileEntitySoulForge))) {
/*  26 */       GlStateManager.func_179094_E();
/*  27 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*  28 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  29 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*  31 */       func_147499_a(TEXTURE);
/*     */       
/*  33 */       Minecraft mc = Minecraft.func_71410_x();
/*     */       
/*  35 */       BlockSoulForge.TileEntitySoulForge forge = (BlockSoulForge.TileEntitySoulForge)tile;
/*     */       
/*  37 */       float activeTicks = forge.activeTicks;
/*     */       
/*     */ 
/*  40 */       float MIN = -24.0F;
/*  41 */       float MAX = -14.0F;
/*  42 */       float progress = Math.min(activeTicks, 100.0F) / 100.0F;
/*  43 */       this.model.outerWingShift = (progress * 0.6F);
/*  44 */       this.model.innerWingShift = (progress * 0.2F);
/*  45 */       this.model.upperWingShift = (progress * 0.3F);
/*  46 */       for (int i = 0; i < this.model.wingInner.length; i++)
/*     */       {
/*  48 */         this.model.wingUpper[i].field_78797_d = (MIN + progress * (MAX - MIN));
/*     */       }
/*     */       
/*  51 */       float HALF_PI = 1.5707964F;
/*     */       
/*  53 */       if (forge.isActive()) {
/*  54 */         double angle = mc.field_71441_e.func_82737_E() % 360L;
/*     */         
/*  56 */         for (int i = 0; i < this.model.wingInner.length; i++) {
/*  57 */           this.model.wingOuter[i].field_78796_g = ((float)Math.toRadians(angle * 3.0D) + 1.5707964F * i);
/*  58 */           this.model.wingUpper[i].field_78796_g = (-(float)Math.toRadians(angle * 5.0D) + 1.5707964F * i);
/*  59 */           this.model.wingInner[i].field_78796_g = (-(float)Math.toRadians(angle * 2.0D) + 1.5707964F * i);
/*     */         }
/*     */         
/*  62 */         this.model.coreLower.field_78796_g = (this.model.coreMiddle.field_78796_g = this.model.coreUpper.field_78796_g = (float)Math.toRadians(angle * 7.0D));
/*     */         
/*  64 */         this.model.crystalA.field_78808_h = ((float)Math.toRadians(angle) + 0.7853982F);
/*  65 */         this.model.crystalB.field_78808_h = ((float)Math.toRadians(angle) - 0.7853982F);
/*     */       }
/*     */       else {
/*  68 */         for (int i = 0; i < this.model.wingInner.length; i++) {
/*  69 */           this.model.wingOuter[i].field_78796_g = (i * 1.5707964F);
/*  70 */           this.model.wingInner[i].field_78796_g = (i * 1.5707964F);
/*  71 */           this.model.wingUpper[i].field_78796_g = (i * 1.5707964F);
/*  72 */           this.model.coreLower.field_78796_g = (this.model.coreMiddle.field_78796_g = this.model.coreUpper.field_78796_g = 0.0F);
/*     */         }
/*     */         
/*  75 */         this.model.crystalA.field_78796_g = 0.0F;
/*  76 */         this.model.crystalA.field_78808_h = 0.7853982F;
/*  77 */         this.model.crystalA.field_78795_f = 0.7853982F;
/*     */         
/*  79 */         this.model.crystalB.field_78796_g = 0.0F;
/*  80 */         this.model.crystalB.field_78808_h = -0.7853982F;
/*  81 */         this.model.crystalB.field_78795_f = -0.7853982F;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/* 123 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderForge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */