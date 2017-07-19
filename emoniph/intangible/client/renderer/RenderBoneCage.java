/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockBoneCage.TileEntityBoneCage;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.client.models.ModelBoneCage;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.MathUtil;
/*     */ import net.minecraft.block.BlockBed;
/*     */ import net.minecraft.block.BlockBed.EnumPartType;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderBoneCage extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*  27 */   private ModelBoneCage model = new ModelBoneCage();
/*     */   
/*  29 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible", "textures/blocks/bonecage.png");
/*  30 */   private static final ResourceLocation TEXTURE2 = new ResourceLocation("intangible", "textures/blocks/bonecage_reconstructor.png");
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  34 */     IBlockState state = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  35 */     if ((state.func_177230_c() == Get.blocks().BONE_CAGE) && (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) && ((tile instanceof BlockBoneCage.TileEntityBoneCage)))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  40 */       BlockBoneCage.TileEntityBoneCage cage = (BlockBoneCage.TileEntityBoneCage)tile;
/*     */       
/*  42 */       if (cage.getTrappedEntity() != null) {
/*  43 */         GlStateManager.func_179094_E();
/*  44 */         Render renderer = (Render)Minecraft.func_71410_x().func_175598_ae().field_78729_o.get(cage.getTrappedEntity().getClass());
/*     */         
/*  46 */         float scale = 1.0F;
/*  47 */         float maxHeight = MathUtil.sixteenth(30);
/*  48 */         maxWidth = MathUtil.sixteenth(13);
/*  49 */         if ((cage.getTrappedEntity().field_70131_O > maxHeight) || (cage.getTrappedEntity().field_70130_N > maxWidth))
/*     */         {
/*  51 */           scale = Math.min(maxHeight / cage.getTrappedEntity().field_70131_O, maxWidth / cage.getTrappedEntity().field_70130_N);
/*     */           
/*  53 */           GlStateManager.func_179137_b(x, y, z);
/*  54 */           GlStateManager.func_179152_a(scale, scale, scale);
/*  55 */           GlStateManager.func_179137_b(-x, -y, -z);
/*     */         }
/*     */         
/*  58 */         factor = 1.0F / scale;
/*     */         
/*  60 */         GlStateManager.func_179137_b(x + 0.5D * factor, y + 0.0625D, z + 0.5D * factor);
/*  61 */         trapped = cage.getTrappedEntity();
/*  62 */         EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */         
/*  64 */         float rotate = 0.0F;
/*  65 */         switch (facing) {
/*     */         case NORTH: 
/*  67 */           rotate = 0.0F;
/*  68 */           break;
/*     */         case SOUTH: 
/*  70 */           rotate = 180.0F;
/*  71 */           break;
/*     */         case EAST: 
/*  73 */           rotate = 270.0F;
/*  74 */           break;
/*     */         case WEST: 
/*  76 */           rotate = 90.0F;
/*     */         }
/*     */         
/*     */         
/*  80 */         trapped.field_70177_z = (trapped.field_70126_B = rotate);
/*  81 */         trapped.field_70125_A = (trapped.field_70127_C = 0.0F);
/*     */         
/*  83 */         GlStateManager.func_179114_b(trapped.field_70177_z, 0.0F, 1.0F, 0.0F);
/*     */         
/*  85 */         renderer.func_76986_a(trapped, 0.0D, 0.0D, 0.0D, 0.0F, 0.0625F);
/*     */         
/*  87 */         GlStateManager.func_179121_F();
/*     */       }
/*     */       
/*     */ 
/*  91 */       GlStateManager.func_179094_E();
/*  92 */       GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*  93 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  94 */       GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */       
/*     */ 
/*  97 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */       
/*  99 */       GlStateManager.func_179114_b(BlockUtil.facingToHorizonatalAngle(facing), 0.0F, 1.0F, 0.0F);
/*     */       
/* 101 */       boolean isReconstructor = tile.func_145831_w().func_180495_p(tile.func_174877_v().func_177977_b()).func_177230_c() == Get.blocks().RECONSTRUCTOR;
/*     */       
/* 103 */       func_147499_a(isReconstructor ? TEXTURE2 : TEXTURE);
/*     */       
/* 105 */       ModelRenderer[] rs = { this.model.rightDoor5, this.model.rightDoor2, this.model.leftDoor5, this.model.leftDoor2, this.model.barLeft4, this.model.barLeft5, this.model.barLeft6, this.model.barRight4, this.model.barRight5, this.model.barRight6, this.model.barBack2 };
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
/* 119 */       float maxWidth = rs;float factor = maxWidth.length; for (Entity trapped = 0; trapped < factor; trapped++) { ModelRenderer r = maxWidth[trapped];
/* 120 */         r.field_78806_j = (!isReconstructor);
/*     */       }
/*     */       
/* 123 */       if (cage.isOpen()) {
/* 124 */         this.model.leftDoor.field_78796_g = -1.5707964F;
/* 125 */         this.model.rightDoor.field_78796_g = 1.5707964F;
/*     */       } else {
/* 127 */         this.model.leftDoor.field_78796_g = 0.0F;
/* 128 */         this.model.rightDoor.field_78796_g = 0.0F;
/*     */       }
/*     */       
/* 131 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 132 */       this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */       
/*     */ 
/* 135 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderBoneCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */