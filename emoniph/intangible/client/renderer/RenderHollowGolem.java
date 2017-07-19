/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntityHollowIronGolem;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderIronGolem;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.monster.EntityIronGolem;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderHollowGolem
/*     */   extends RenderIronGolem
/*     */ {
/*     */   public RenderHollowGolem(RenderManager rm)
/*     */   {
/*  22 */     super(rm);
/*     */   }
/*     */   
/*  25 */   private static final ResourceLocation GLINT_TEXTURE_LOCATION = new ResourceLocation("textures/misc/enchanted_item_glint.png");
/*     */   private int pass;
/*     */   
/*     */   public void doRender(EntityIronGolem entity, double x, double y, double z, float p_76986_8_, float partialTicks) {
/*  29 */     this.pass = 0;
/*  30 */     super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
/*     */     
/*     */ 
/*  33 */     EntityHollowIronGolem golem = (EntityHollowIronGolem)entity;
/*  34 */     SoulType soulType = golem.getTrappedSoul();
/*  35 */     int color = 16777215;
/*  36 */     if ((soulType != null) || (golem.isUpgraded())) {
/*  37 */       GlStateManager.func_179094_E();
/*  38 */       GlStateManager.func_179147_l();
/*     */       
/*     */ 
/*  41 */       float f10 = 0.5F;
/*  42 */       GlStateManager.func_179131_c(f10, f10, f10, 1.0F);
/*  43 */       GlStateManager.func_179143_c(514);
/*  44 */       GlStateManager.func_179132_a(false);
/*     */       
/*  46 */       if (soulType != null) {
/*  47 */         color = EnumSoulType.fromSoulType(soulType).getColor();
/*     */       }
/*     */       
/*  50 */       float r = (color >> 16 & 0xFF) / 256.0F;
/*  51 */       float g = (color >> 8 & 0xFF) / 256.0F;
/*  52 */       float b = (color & 0xFF) / 256.0F;
/*     */       
/*  54 */       float alpha = 1.0F;
/*     */       
/*  56 */       func_110776_a(GLINT_TEXTURE_LOCATION);
/*     */       
/*  58 */       for (int k = 0; k < 2; k++) {
/*  59 */         GlStateManager.func_179140_f();
/*  60 */         float f11 = 0.76F;
/*     */         
/*  62 */         GlStateManager.func_179131_c(r * f11, g * f11, b * f11, alpha);
/*     */         
/*  64 */         GlStateManager.func_179112_b(768, 1);
/*     */         
/*     */ 
/*  67 */         GlStateManager.func_179128_n(5890);
/*  68 */         GlStateManager.func_179096_D();
/*  69 */         float f12 = golem.field_70173_aa * (0.001F + k * 0.003F) * 20.0F;
/*  70 */         float f13 = 0.33333334F;
/*  71 */         GlStateManager.func_179152_a(f13, f13, f13);
/*  72 */         GlStateManager.func_179114_b(30.0F - k * 60.0F, 0.0F, 0.0F, 1.0F);
/*  73 */         GlStateManager.func_179109_b(0.0F, f12, 0.0F);
/*  74 */         GlStateManager.func_179128_n(5888);
/*     */         
/*  76 */         this.pass = 1;
/*  77 */         super.func_76986_a(entity, x, y, z, p_76986_8_, partialTicks);
/*  78 */         this.pass = 0;
/*     */       }
/*     */       
/*  81 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*  82 */       GlStateManager.func_179128_n(5890);
/*  83 */       GlStateManager.func_179132_a(true);
/*  84 */       GlStateManager.func_179096_D();
/*  85 */       GlStateManager.func_179128_n(5888);
/*  86 */       GlStateManager.func_179145_e();
/*  87 */       GlStateManager.func_179084_k();
/*  88 */       GlStateManager.func_179143_c(515);
/*  89 */       GlStateManager.func_179112_b(770, 771);
/*  90 */       GlStateManager.func_179121_F();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected ResourceLocation func_110775_a(EntityIronGolem entity)
/*     */   {
/* 101 */     if (this.pass != 1) {
/* 102 */       return super.func_110775_a(entity);
/*     */     }
/* 104 */     return GLINT_TEXTURE_LOCATION;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderHollowGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */