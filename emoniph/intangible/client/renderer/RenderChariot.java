/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.client.models.ModelChariot;
/*     */ import emoniph.intangible.entity.EntityChariot;
/*     */ import java.util.Map;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.item.EnumDyeColor;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class RenderChariot
/*     */   extends Render<EntityChariot>
/*     */ {
/*  22 */   private final ResourceLocation[] TEXTURES = new ResourceLocation[EnumDyeColor.values().length];
/*     */   private ModelChariot model;
/*     */   
/*     */   public RenderChariot(RenderManager renderManager)
/*     */   {
/*  27 */     super(renderManager);
/*  28 */     this.field_76989_e = 1.6F;
/*  29 */     this.model = new ModelChariot();
/*     */     
/*  31 */     this.TEXTURES[EnumDyeColor.WHITE.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_white.png");
/*  32 */     this.TEXTURES[EnumDyeColor.ORANGE.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_orange.png");
/*  33 */     this.TEXTURES[EnumDyeColor.MAGENTA.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_magenta.png");
/*  34 */     this.TEXTURES[EnumDyeColor.LIGHT_BLUE.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_light_blue.png");
/*  35 */     this.TEXTURES[EnumDyeColor.YELLOW.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_yellow.png");
/*  36 */     this.TEXTURES[EnumDyeColor.LIME.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_lime.png");
/*  37 */     this.TEXTURES[EnumDyeColor.PINK.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_pink.png");
/*  38 */     this.TEXTURES[EnumDyeColor.GRAY.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_gray.png");
/*  39 */     this.TEXTURES[EnumDyeColor.SILVER.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_silver.png");
/*  40 */     this.TEXTURES[EnumDyeColor.CYAN.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_cyan.png");
/*  41 */     this.TEXTURES[EnumDyeColor.PURPLE.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_purple.png");
/*  42 */     this.TEXTURES[EnumDyeColor.BLUE.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_blue.png");
/*  43 */     this.TEXTURES[EnumDyeColor.BROWN.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_brown.png");
/*  44 */     this.TEXTURES[EnumDyeColor.GREEN.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_green.png");
/*  45 */     this.TEXTURES[EnumDyeColor.RED.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_red.png");
/*  46 */     this.TEXTURES[EnumDyeColor.BLACK.func_176767_b()] = new ResourceLocation("intangible:textures/entity/chariot_black.png");
/*     */   }
/*     */   
/*     */   protected ResourceLocation getEntityTexture(EntityChariot entity)
/*     */   {
/*  51 */     if (entity == null) {
/*  52 */       return this.TEXTURES[0];
/*     */     }
/*  54 */     return this.TEXTURES[entity.getColor().func_176767_b()];
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void doRender(EntityChariot entity, double x, double y, double z, float entityYaw, float partialTicks)
/*     */   {
/*  62 */     GlStateManager.func_179094_E();
/*  63 */     GlStateManager.func_179137_b((float)x, (float)y + 1.5D, (float)z);
/*  64 */     GlStateManager.func_179114_b(90.0F - entityYaw, 0.0F, 1.0F, 0.0F);
/*  65 */     GlStateManager.func_179152_a(-1.0F, -1.0F, 1.0F);
/*  66 */     func_180548_c(entity);
/*  67 */     int hits = entity.getHits();
/*  68 */     boolean activeBonus = hits < 40;
/*  69 */     this.model.scythe[0].field_78806_j = activeBonus;
/*  70 */     this.model.scythe[1].field_78806_j = activeBonus;
/*  71 */     this.model.func_78088_a(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
/*  72 */     GlStateManager.func_179121_F();
/*     */     
/*     */ 
/*  75 */     EntityLiving proxy = entity.getProxyLeadEntity();
/*  76 */     if (proxy != null) {
/*  77 */       Render renderer = (Render)Minecraft.func_71410_x().func_175598_ae().field_78729_o.get(proxy.getClass());
/*  78 */       if (renderer != null) {
/*  79 */         proxy.field_70721_aZ = entity.limbSwingAmount;
/*  80 */         proxy.field_70722_aY = entity.prevLimbSwingAmount;
/*  81 */         proxy.field_70177_z = (proxy.field_70126_B = entity.field_70177_z);
/*  82 */         proxy.field_70125_A = (proxy.field_70127_C = 0.0F);
/*     */         
/*  84 */         double vecX = Math.cos((entity.field_70177_z + 90.0F) * 3.141592653589793D / 180.0D);
/*  85 */         double vecZ = Math.sin((entity.field_70177_z + 90.0F) * 3.141592653589793D / 180.0D);
/*     */         
/*  87 */         double[] proxyOffsets = { 0.5D, -0.5D };
/*     */         
/*  89 */         for (int i = 0; i < proxyOffsets.length; i++) {
/*  90 */           proxy.field_70754_ba = (entity.limbSwing + 4 * i);
/*  91 */           proxy.field_70173_aa = (entity.field_70173_aa + i);
/*     */           
/*  93 */           GlStateManager.func_179094_E();
/*  94 */           GlStateManager.func_179137_b(x + vecX * proxyOffsets[i], y, z + vecZ * proxyOffsets[i]);
/*  95 */           GlStateManager.func_179114_b(-90.0F - proxy.field_70177_z, 0.0F, 1.0F, 0.0F);
/*  96 */           renderer.func_76986_a(proxy, 0.0D, 0.0D, 0.0D, 0.0F, 0.0625F);
/*  97 */           GlStateManager.func_179121_F();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 102 */     super.func_76986_a(entity, x, y, z, entityYaw, partialTicks);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderChariot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */