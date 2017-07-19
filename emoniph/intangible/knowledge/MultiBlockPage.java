/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.api.IMultiBlockPlan;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem.Button;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class MultiBlockPage extends Page
/*     */ {
/*     */   protected final IMultiBlockPlan plan;
/*     */   
/*     */   public MultiBlockPage(String id, Book book, IMultiBlockPlan plan)
/*     */   {
/*  24 */     super(id, book);
/*  25 */     this.plan = plan;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void drawStack(EntityKnowledgeGem gem, ItemStack stack, float x, float y, float z, float scale, RenderItem renderItem, Page.RenderContext context, boolean interactive) {
/*  30 */     if (stack != null)
/*     */     {
/*  32 */       Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*     */       
/*  34 */       GlStateManager.func_179140_f();
/*  35 */       GlStateManager.func_179091_B();
/*  36 */       GlStateManager.func_179141_d();
/*  37 */       GlStateManager.func_179092_a(516, 0.1F);
/*  38 */       GlStateManager.func_179147_l();
/*  39 */       GlStateManager.func_179112_b(770, 771);
/*  40 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */       
/*  42 */       float offsetZ = 0.0F;
/*  43 */       if (z > 0.0F) {
/*  44 */         offsetZ = z * 0.01F;
/*     */       }
/*  46 */       float invScale = 1.0F / scale;
/*  47 */       float scaledX = x * invScale;
/*  48 */       float scaledY = y * invScale;
/*  49 */       GlStateManager.func_179152_a(scale, scale, scale);
/*  50 */       GlStateManager.func_179109_b(x, y, -offsetZ);
/*  51 */       GlStateManager.func_179152_a(32.0F, 32.0F, 0.0078125F);
/*  52 */       GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*     */       
/*  54 */       renderItem.func_180454_a(stack, renderItem
/*  55 */         .func_175037_a().func_178089_a(stack.func_77952_i() == 32767 ? new ItemStack(stack
/*  56 */         .func_77973_b()) : stack));
/*     */       
/*  58 */       GlStateManager.func_179152_a(0.03125F, 0.03125F, 128.0F);
/*  59 */       GlStateManager.func_179114_b(-180.0F, 0.0F, 0.0F, 1.0F);
/*  60 */       GlStateManager.func_179109_b(-x, -y, offsetZ);
/*  61 */       GlStateManager.func_179152_a(invScale, invScale, invScale);
/*     */       
/*  63 */       if (context.pointer.containedBy(x * scale, y * scale, 16.0F * scale, 16.0F * scale)) {
/*  64 */         StringBuilder builder = new StringBuilder();
/*  65 */         for (Object s : stack.func_82840_a(Minecraft.func_71410_x().field_71439_g, false)) {
/*  66 */           if (builder.length() > 0) {
/*  67 */             builder.append("\n");
/*     */           }
/*  69 */           builder.append(s.toString());
/*     */         }
/*  71 */         context.tip = builder.toString();
/*     */         
/*  73 */         String pageName = stack.func_77977_a().substring(5);
/*  74 */         if ((emoniph.intangible.Get.book().exists(pageName)) && (!context.navigator.getCurrentPage().equals(pageName))) {
/*  75 */           gem.addButton(new EntityKnowledgeGem.Button(pageName).setBounds((int)(x * scale), (int)(y * scale), (int)(16.0F * scale), (int)(16.0F * scale)));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void drawText(String text, int color, float x, float y, float scale, Page.RenderContext context, EntityKnowledgeGem gem) {
/*  83 */     float invScale = 1.0F / scale;
/*  84 */     float scaledX = invScale * x;
/*  85 */     float scaledY = invScale * y;
/*     */     
/*  87 */     GlStateManager.func_179152_a(scale, scale, 1.0F);
/*  88 */     context.fontRenderer.func_175065_a(text, scaledX, scaledY, color, false);
/*  89 */     GlStateManager.func_179152_a(invScale, invScale, 1.0F);
/*     */   }
/*     */   
/*     */   protected int getHeaderHeight(boolean firstPage)
/*     */   {
/*  94 */     return super.getHeaderHeight(firstPage) + (firstPage ? 68 : 0);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void renderHeaderContent(EntityKnowledgeGem gem, EntityPlayerSP player, Page.RenderContext cxt, float partialTicks)
/*     */   {
/* 101 */     GlStateManager.func_179094_E();
/*     */     
/* 103 */     RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */     
/* 105 */     GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 106 */     cxt.renderManager.field_78724_e.func_110577_a(TextureMap.field_110575_b);
/*     */     
/*     */ 
/* 109 */     ItemStack[][][] layers = this.plan.getPlan();
/*     */     
/* 111 */     float scale = this.plan.getPlanRenderScale();
/* 112 */     float invScale = 1.0F / scale;
/*     */     
/* 114 */     float marginX = cxt.getDrawX() * invScale;
/* 115 */     float marginY = cxt.getDrawY() * invScale;
/* 116 */     float pespectiveX = 2.0F;
/* 117 */     float pespectiveZ = 2.0F;
/*     */     
/* 119 */     int EXTRA_BEATS_ON_FULL_PLAN = 4;
/* 120 */     GlStateManager.func_179109_b(8.0F * scale, 8.0F * scale, 0.0F);
/* 121 */     int maxLayer = Math.min(gem.field_70173_aa / 20 % (layers.length + 4) + 1, layers.length);
/* 122 */     String layerText = String.format(StatCollector.func_74838_a("book.intangible:layernumber"), new Object[] { Integer.valueOf(maxLayer), Integer.valueOf(layers.length) });
/* 123 */     float textScale = 0.7F;
/* 124 */     float textWidth = cxt.fontRenderer.func_78256_a(layerText) * textScale;
/* 125 */     drawText(layerText, -872397824, cxt.getDrawX() + cxt.clientWidth - textWidth, cxt.getDrawY(), textScale, cxt, gem);
/*     */     
/* 127 */     layerText = String.format(StatCollector.func_74838_a("book.intangible:layersize"), new Object[] { Integer.valueOf(layers[(maxLayer - 1)][0].length), Integer.valueOf(layers[(maxLayer - 1)].length) });
/* 128 */     textWidth = cxt.fontRenderer.func_78256_a(layerText) * textScale;
/* 129 */     drawText(layerText, -872397824, cxt.getDrawX() + cxt.clientWidth - textWidth, cxt.getDrawY() + cxt.getLineHeight(), textScale, cxt, gem);
/*     */     
/* 131 */     for (int layer = 0; layer < maxLayer; layer++) {
/* 132 */       for (int z = 0; z < layers[layer].length; z++) {
/* 133 */         for (int x = 0; x < layers[layer][z].length; x++) {
/* 134 */           ItemStack s = layers[layer][z][x];
/* 135 */           if (s != null) {
/* 136 */             drawStack(gem, s, marginX + x * 20 + layer * pespectiveX, marginY + z * 20 + layer * pespectiveZ, layer, scale, ri, cxt, layer == maxLayer - 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 143 */     GlStateManager.func_179109_b(-8.0F * scale, -8.0F * scale, 0.0F);
/*     */     
/* 145 */     GlStateManager.func_179121_F(); Page.RenderContext 
/*     */     
/* 147 */       tmp464_463 = cxt;tmp464_463.y = ((int)(tmp464_463.y + (5.0F + layers[0].length * 20 * scale)));
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/MultiBlockPage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */