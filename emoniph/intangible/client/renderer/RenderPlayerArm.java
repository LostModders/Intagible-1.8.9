/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.util.EnumArmorSlot;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelBiped;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.client.renderer.EntityRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.ItemRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderPlayer;
/*     */ import net.minecraft.client.renderer.entity.RendererLivingEntity;
/*     */ import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import org.lwjgl.util.glu.Project;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */ public class RenderPlayerArm
/*     */ {
/*     */   public static void render(float partialTicks, int renderPass, Minecraft mc)
/*     */   {
/*  27 */     EntityRenderer entityRenderer = Minecraft.func_71410_x().field_71460_t;
/*  28 */     if (!entityRenderer.field_175078_W) {
/*  29 */       GlStateManager.func_179128_n(5889);
/*  30 */       GlStateManager.func_179096_D();
/*  31 */       float f1 = 0.07F;
/*     */       
/*  33 */       if (mc.field_71474_y.field_74337_g) {
/*  34 */         GlStateManager.func_179109_b(-(renderPass * 2 - 1) * f1, 0.0F, 0.0F);
/*     */       }
/*     */       
/*  37 */       Project.gluPerspective(entityRenderer.func_78481_a(partialTicks, false), mc.field_71443_c / mc.field_71440_d, 0.05F, entityRenderer.field_78530_s * 2.0F);
/*  38 */       GlStateManager.func_179128_n(5888);
/*  39 */       GlStateManager.func_179096_D();
/*     */       
/*  41 */       if (mc.field_71474_y.field_74337_g) {
/*  42 */         GlStateManager.func_179109_b((renderPass * 2 - 1) * 0.1F, 0.0F, 0.0F);
/*     */       }
/*     */       
/*  45 */       GlStateManager.func_179094_E();
/*  46 */       entityRenderer.func_78482_e(partialTicks);
/*     */       
/*  48 */       if (mc.field_71474_y.field_74336_f) {
/*  49 */         entityRenderer.func_78475_f(partialTicks);
/*     */       }
/*     */       
/*  52 */       boolean flag = ((mc.func_175606_aa() instanceof EntityLivingBase)) && (((EntityLivingBase)mc.func_175606_aa()).func_70608_bn());
/*     */       
/*  54 */       if ((mc.field_71474_y.field_74320_O == 0) && (!flag) && (!mc.field_71474_y.field_74319_N) && (!mc.field_71442_b.func_78747_a())) {
/*  55 */         entityRenderer.func_180436_i();
/*  56 */         renderItemInFirstPerson(entityRenderer.field_78516_c, partialTicks, mc);
/*  57 */         entityRenderer.func_175072_h();
/*     */       }
/*     */       
/*  60 */       GlStateManager.func_179121_F();
/*     */       
/*  62 */       if ((mc.field_71474_y.field_74320_O == 0) && (!flag)) {
/*  63 */         entityRenderer.field_78516_c.func_78447_b(partialTicks);
/*  64 */         entityRenderer.func_78482_e(partialTicks);
/*     */       }
/*     */       
/*  67 */       if (mc.field_71474_y.field_74336_f) {
/*  68 */         entityRenderer.func_78475_f(partialTicks);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static void renderItemInFirstPerson(ItemRenderer itemRenderer, float partialTicks, Minecraft mc) {
/*  74 */     float equippedProgress = 1.0F - (itemRenderer.field_78451_d + (itemRenderer.field_78454_c - itemRenderer.field_78451_d) * partialTicks);
/*  75 */     AbstractClientPlayer entityplayersp = mc.field_71439_g;
/*  76 */     float swingProgress = entityplayersp.func_70678_g(partialTicks);
/*  77 */     float f3 = entityplayersp.field_70127_C + (entityplayersp.field_70125_A - entityplayersp.field_70127_C) * partialTicks;
/*  78 */     float f4 = entityplayersp.field_70126_B + (entityplayersp.field_70177_z - entityplayersp.field_70126_B) * partialTicks;
/*  79 */     itemRenderer.func_178101_a(f3, f4);
/*  80 */     itemRenderer.func_178109_a(entityplayersp);
/*  81 */     itemRenderer.func_178110_a((EntityPlayerSP)entityplayersp, partialTicks);
/*     */     
/*  83 */     GlStateManager.func_179091_B();
/*  84 */     GlStateManager.func_179094_E();
/*     */     
/*  86 */     if (!entityplayersp.func_82150_aj()) {
/*  87 */       drawHand(entityplayersp, equippedProgress, swingProgress, mc, itemRenderer);
/*     */     }
/*     */     
/*  90 */     GlStateManager.func_179121_F();
/*  91 */     GlStateManager.func_179101_C();
/*  92 */     net.minecraft.client.renderer.RenderHelper.func_74518_a();
/*     */   }
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
/*     */   private static void drawHand(AbstractClientPlayer player, float equippedProgress, float swingProgress, Minecraft mc, ItemRenderer itemRenderer)
/*     */   {
/* 122 */     itemRenderer.func_178095_a(player, equippedProgress, swingProgress);
/*     */     
/* 124 */     net.minecraft.client.renderer.entity.Render<AbstractClientPlayer> render = mc.func_175598_ae().func_78713_a(mc.field_71439_g);
/* 125 */     GlStateManager.func_179129_p();
/* 126 */     RenderPlayer renderplayer = (RenderPlayer)render;
/* 127 */     new ArmorArm(renderplayer).render(mc.field_71439_g);
/* 128 */     GlStateManager.func_179089_o();
/*     */   }
/*     */   
/*     */   private static class ArmorArm extends LayerBipedArmor
/*     */   {
/*     */     RendererLivingEntity entityRenderer;
/*     */     
/*     */     public ArmorArm(RendererLivingEntity entityRenderer) {
/* 136 */       super();
/* 137 */       this.entityRenderer = entityRenderer;
/*     */     }
/*     */     
/*     */     public void render(EntityLivingBase entity) {
/* 141 */       int slot = EnumArmorSlot.CHEST.armorType;
/* 142 */       ItemStack itemstack = func_177176_a(entity, EnumArmorSlot.CHEST.equipmentSlot);
/*     */       
/* 144 */       if ((itemstack != null) && ((itemstack.func_77973_b() instanceof ItemArmor))) {
/* 145 */         ItemArmor itemarmor = (ItemArmor)itemstack.func_77973_b();
/* 146 */         ModelBase modelbase = func_177175_a(slot);
/* 147 */         modelbase.func_178686_a(this.entityRenderer.func_177087_b());
/* 148 */         if (!(modelbase instanceof ModelBiped)) {
/* 149 */           return;
/*     */         }
/* 151 */         ModelBiped modelBiped = (ModelBiped)modelbase;
/*     */         
/* 153 */         modelBiped = net.minecraftforge.client.ForgeHooksClient.getArmorModel(entity, itemstack, slot, modelBiped);
/*     */         
/*     */ 
/* 156 */         func_177179_a(modelBiped, slot);
/* 157 */         boolean flag = slot == 2;
/* 158 */         this.entityRenderer.func_110776_a(getArmorResource(entity, itemstack, flag ? 2 : 1, null));
/*     */         
/*     */ 
/* 161 */         int j = itemarmor.func_82814_b(itemstack);
/* 162 */         if (j != -1)
/*     */         {
/* 164 */           float f7 = (j >> 16 & 0xFF) / 255.0F;
/* 165 */           float f8 = (j >> 8 & 0xFF) / 255.0F;
/* 166 */           float f9 = (j & 0xFF) / 255.0F;
/* 167 */           GlStateManager.func_179131_c(f7, f8, f9, 1.0F);
/*     */           
/* 169 */           modelBiped.field_78095_p = 0.0F;
/* 170 */           modelBiped.field_78117_n = false;
/* 171 */           modelBiped.func_78087_a(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F, entity);
/* 172 */           modelBiped.field_178723_h.field_78806_j = true;
/*     */           
/* 174 */           modelBiped.field_178723_h.func_78785_a(0.0625F);
/* 175 */           this.entityRenderer.func_110776_a(getArmorResource(entity, itemstack, flag ? 2 : 1, "overlay"));
/*     */         }
/*     */         
/*     */ 
/* 179 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 180 */         modelBiped.field_178723_h.func_78785_a(0.0625F);
/*     */         
/*     */ 
/* 183 */         if (itemstack.func_77948_v()) {
/* 184 */           renderGlint(entity, modelBiped);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     private void renderGlint(EntityLivingBase entity, ModelBiped model)
/*     */     {
/* 192 */       float p_177183_5_ = 0.0F;
/* 193 */       float f7 = entity.field_70173_aa + p_177183_5_;
/* 194 */       this.entityRenderer.func_110776_a(field_177188_b);
/* 195 */       GlStateManager.func_179147_l();
/* 196 */       GlStateManager.func_179143_c(514);
/* 197 */       GlStateManager.func_179132_a(false);
/* 198 */       float f8 = 0.5F;
/* 199 */       GlStateManager.func_179131_c(f8, f8, f8, 1.0F);
/*     */       
/* 201 */       for (int i = 0; i < 2; i++) {
/* 202 */         GlStateManager.func_179140_f();
/* 203 */         GlStateManager.func_179112_b(768, 1);
/* 204 */         float f9 = 0.76F;
/* 205 */         GlStateManager.func_179131_c(0.5F * f9, 0.25F * f9, 0.8F * f9, 1.0F);
/* 206 */         GlStateManager.func_179128_n(5890);
/* 207 */         GlStateManager.func_179096_D();
/* 208 */         float f10 = 0.33333334F;
/* 209 */         GlStateManager.func_179152_a(f10, f10, f10);
/* 210 */         GlStateManager.func_179114_b(30.0F - i * 60.0F, 0.0F, 0.0F, 1.0F);
/* 211 */         GlStateManager.func_179109_b(0.0F, f7 * (0.001F + i * 0.003F) * 20.0F, 0.0F);
/* 212 */         GlStateManager.func_179128_n(5888);
/* 213 */         model.field_178723_h.func_78785_a(0.0625F);
/*     */       }
/*     */       
/* 216 */       GlStateManager.func_179128_n(5890);
/* 217 */       GlStateManager.func_179096_D();
/* 218 */       GlStateManager.func_179128_n(5888);
/* 219 */       GlStateManager.func_179145_e();
/* 220 */       GlStateManager.func_179132_a(true);
/* 221 */       GlStateManager.func_179143_c(515);
/* 222 */       GlStateManager.func_179084_k();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderPlayerArm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */