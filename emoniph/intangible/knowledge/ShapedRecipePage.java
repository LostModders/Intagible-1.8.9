/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IMold;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.recipes.GolemPartRecipe;
/*     */ import emoniph.intangible.recipes.ModRecipes;
/*     */ import emoniph.intangible.recipes.SoulRecipe;
/*     */ import emoniph.intangible.recipes.StampingRecipe;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.Point2d;
/*     */ import emoniph.intangible.util.RenderUtil;
/*     */ import java.lang.reflect.Field;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.renderer.texture.TextureMap;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.item.crafting.ShapedRecipes;
/*     */ import net.minecraft.item.crafting.ShapelessRecipes;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import net.minecraftforge.oredict.ShapedOreRecipe;
/*     */ import net.minecraftforge.oredict.ShapelessOreRecipe;
/*     */ 
/*     */ public class ShapedRecipePage extends Page
/*     */ {
/*     */   private final ItemStack stack;
/*  45 */   private final List<RecipeRenderer> recipeRenderers = new ArrayList();
/*  46 */   private final List<ShapedRecipes> vanillaShaped = new ArrayList();
/*  47 */   private final List<ShapedOreRecipe> oreShaped = new ArrayList();
/*  48 */   private final List<ShapelessRecipes> vanillaShapeless = new ArrayList();
/*  49 */   private final List<ShapelessOreRecipe> oreShapeless = new ArrayList();
/*     */   
/*     */ 
/*     */   protected int getHeaderHeight(boolean firstPage)
/*     */   {
/*  54 */     return super.getHeaderHeight(firstPage) + (firstPage ? 68 : 0);
/*     */   }
/*     */   
/*     */   private static abstract class RecipeRenderer {
/*     */     protected static final int ICON_WIDTH = 22;
/*     */     protected static final int ICON_MARGIN = 2;
/*     */     protected static final int ARROW_WIDTH = 20;
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     abstract void render(EntityKnowledgeGem paramEntityKnowledgeGem, EntityPlayerSP paramEntityPlayerSP, ItemStack paramItemStack, Page.RenderContext paramRenderContext, float paramFloat);
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void drawStack(EntityKnowledgeGem gem, ItemStack stack, float x, float y, RenderItem renderItem, Page.RenderContext context) {
/*  67 */       drawStack(gem, stack, x, y, 0.0F, renderItem, context, true);
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void drawStack(EntityKnowledgeGem gem, ItemStack stack, float x, float y, float z, RenderItem renderItem, Page.RenderContext context, boolean interactive) {
/*  72 */       if (stack != null)
/*     */       {
/*  74 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(TextureMap.field_110575_b);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  79 */         GlStateManager.func_179140_f();
/*     */         
/*  81 */         GlStateManager.func_179141_d();
/*  82 */         GlStateManager.func_179092_a(516, 0.1F);
/*  83 */         GlStateManager.func_179147_l();
/*  84 */         GlStateManager.func_179112_b(770, 771);
/*  85 */         GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/*     */         
/*  87 */         float offsetZ = 0.0F;
/*  88 */         if (z > 0.0F) {
/*  89 */           offsetZ = z * 0.001F;
/*     */         }
/*     */         
/*  92 */         GlStateManager.func_179109_b(x, y, -offsetZ);
/*  93 */         GlStateManager.func_179152_a(32.0F, 32.0F, 0.0078125F);
/*  94 */         GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*     */         
/*     */ 
/*  97 */         renderItem.func_180454_a(stack, renderItem.func_175037_a().func_178089_a(stack.func_77952_i() == 32767 ? new ItemStack(stack.func_77973_b()) : stack));
/*     */         
/*     */ 
/*     */ 
/* 101 */         GlStateManager.func_179152_a(0.03125F, 0.03125F, 128.0F);
/* 102 */         GlStateManager.func_179114_b(-180.0F, 0.0F, 0.0F, 1.0F);
/* 103 */         GlStateManager.func_179109_b(-x, -y, offsetZ);
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 108 */         if (stack.field_77994_a > 1) {
/* 109 */           GlStateManager.func_179097_i();
/*     */           
/* 111 */           String sz = Integer.valueOf(stack.field_77994_a).toString();
/* 112 */           context.fontRenderer.func_175063_a(sz, x + 12.0F - context.fontRenderer.func_78256_a(sz), y + 4.0F, 16777215);
/*     */           
/* 114 */           GlStateManager.func_179126_j();
/*     */         }
/*     */         
/* 117 */         GlStateManager.func_179126_j();
/*     */         
/*     */ 
/*     */ 
/* 121 */         if ((interactive) && (context.pointer.containedBy(x, y, 16.0F, 16.0F))) {
/* 122 */           StringBuilder builder = new StringBuilder();
/* 123 */           for (Object s : stack.func_82840_a(Minecraft.func_71410_x().field_71439_g, false)) {
/* 124 */             if (builder.length() > 0) {
/* 125 */               builder.append("\n");
/*     */             }
/* 127 */             builder.append(s.toString());
/*     */           }
/* 129 */           context.tip = builder.toString();
/*     */           
/* 131 */           String pageName = stack.func_77977_a().substring(5);
/* 132 */           if ((Get.book().exists(pageName)) && (!context.navigator.getCurrentPage().equals(pageName))) {
/* 133 */             gem.addButton(new emoniph.intangible.entity.EntityKnowledgeGem.Button(pageName).setBounds((int)x, (int)y, 16, 16));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public void drawText(String text, int color, float x, float y, float scale, Page.RenderContext context, EntityKnowledgeGem gem) {
/* 141 */       float invScale = 1.0F / scale;
/* 142 */       float scaledX = invScale * x;
/* 143 */       float scaledY = invScale * y;
/*     */       
/* 145 */       GlStateManager.func_179152_a(scale, scale, 1.0F);
/* 146 */       context.fontRenderer.func_175065_a(text, scaledX, scaledY, color, false);
/* 147 */       GlStateManager.func_179152_a(invScale, invScale, 1.0F); }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/* 150 */     protected ResourceLocation DEFAULT_TEXTURE = new ResourceLocation("intangible:textures/gui/craftgrid.png");
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public ResourceLocation getBackgroundTexture()
/*     */     {
/* 155 */       return this.DEFAULT_TEXTURE;
/*     */     }
/*     */     
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/* 160 */     public boolean isActiveFor(EntityPlayerSP player) { return true; }
/*     */   }
/*     */   
/*     */   private static class ShapedRecipeRenderer extends ShapedRecipePage.RecipeRenderer {
/*     */     private final ShapedRecipes recipe;
/*     */     
/*     */     public ShapedRecipeRenderer(ShapedRecipes recipe) {
/* 167 */       super();
/* 168 */       this.recipe = recipe;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 174 */       RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */       
/* 176 */       for (int x = 0; x < this.recipe.field_77576_b; x++) {
/* 177 */         for (int y = 0; y < this.recipe.field_77577_c; y++) {
/* 178 */           ItemStack piece = this.recipe.field_77574_d[(y * this.recipe.field_77576_b + x)];
/* 179 */           drawStack(gem, piece, cxt.marginX + 2 + x * 22, cxt.getDrawY() + 2 + y * 22, ri, cxt);
/*     */         }
/*     */       }
/*     */       
/* 183 */       drawStack(gem, this.recipe.func_77571_b(), cxt.marginX + 2 + 20 + 66, cxt.getDrawY() + 2 + 22, ri, cxt);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class ShapedOreRecipeRenderer
/*     */     extends ShapedRecipePage.RecipeRenderer
/*     */   {
/*     */     private static Field oreShapedWidth;
/*     */     
/*     */     private static Field oreShapedHeight;
/*     */     
/*     */     private final ShapedOreRecipe recipe;
/*     */     
/*     */ 
/*     */     public ShapedOreRecipeRenderer(ShapedOreRecipe recipe)
/*     */     {
/* 200 */       super();oreShapedWidth = ShapedOreRecipe.class.getDeclaredFields()[4];oreShapedWidth.setAccessible(true);oreShapedHeight = ShapedOreRecipe.class.getDeclaredFields()[5];oreShapedHeight.setAccessible(true);
/* 201 */       this.recipe = recipe;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 207 */       RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */       
/* 209 */       int rows = 1;
/* 210 */       int cols = 1;
/*     */       try
/*     */       {
/* 213 */         cols = ((Integer)oreShapedWidth.get(this.recipe)).intValue();
/* 214 */         rows = ((Integer)oreShapedHeight.get(this.recipe)).intValue();
/*     */       }
/*     */       catch (Exception localException) {}
/*     */       
/* 218 */       for (int x = 0; x < cols; x++) {
/* 219 */         for (int y = 0; y < rows; y++) {
/* 220 */           Object[] items = this.recipe.getInput();
/* 221 */           Object thing = items[(y * cols + x)];
/* 222 */           ItemStack piece = (ItemStack)((thing instanceof List) ? ((List)thing).get(0) : thing);
/* 223 */           drawStack(gem, piece, cxt.marginX + 2 + x * 22, cxt.getDrawY() + 2 + y * 22, ri, cxt);
/*     */         }
/*     */       }
/*     */       
/* 227 */       drawStack(gem, this.recipe.func_77571_b(), cxt.marginX + 2 + 20 + 66, cxt.getDrawY() + 2 + 22, ri, cxt);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ShapelessRecipeRenderer extends ShapedRecipePage.RecipeRenderer {
/*     */     private final ShapelessRecipes recipe;
/*     */     
/* 234 */     public ShapelessRecipeRenderer(ShapelessRecipes recipe) { super();
/* 235 */       this.recipe = recipe;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 241 */       RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */       
/* 243 */       int cols = this.recipe.field_77579_b.size() >= 5 ? 3 : 2;
/* 244 */       for (int i = 0; i < this.recipe.field_77579_b.size(); i++) {
/* 245 */         ItemStack piece = (ItemStack)this.recipe.field_77579_b.get(i);
/* 246 */         int x = i % cols;
/* 247 */         int y = i / cols;
/* 248 */         drawStack(gem, piece, cxt.marginX + 2 + x * 22, cxt.getDrawY() + 2 + y * 22, ri, cxt);
/*     */       }
/*     */       
/* 251 */       drawStack(gem, this.recipe.func_77571_b(), cxt.marginX + 2 + 20 + 66, cxt.getDrawY() + 2 + 22, ri, cxt);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ShapelessOreRecipeRenderer extends ShapedRecipePage.RecipeRenderer {
/*     */     private final ShapelessOreRecipe recipe;
/*     */     
/* 258 */     public ShapelessOreRecipeRenderer(ShapelessOreRecipe recipe) { super();
/* 259 */       this.recipe = recipe;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 265 */       RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */       
/* 267 */       for (int i = 0; i < this.recipe.getInput().size(); i++) {
/* 268 */         ItemStack piece = (ItemStack)this.recipe.getInput().get(i);
/* 269 */         int x = i % 3;
/* 270 */         int y = i / 3;
/* 271 */         drawStack(gem, piece, cxt.marginX + 2 + x * 22, cxt.getDrawY() + 2 + y * 22, ri, cxt);
/*     */       }
/*     */       
/* 274 */       drawStack(gem, this.recipe.func_77571_b(), cxt.marginX + 2 + 20 + 66, cxt.getDrawY() + 2 + 22, ri, cxt);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class StampingRecipeRenderer extends ShapedRecipePage.RecipeRenderer {
/*     */     private final StampingRecipe recipe;
/*     */     
/* 281 */     public StampingRecipeRenderer(StampingRecipe recipe) { super();
/* 282 */       this.recipe = recipe;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 288 */       RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */       
/* 290 */       cxt.fontRenderer.func_78276_b(StatCollector.func_74838_a("book.intangible:recipestamping"), cxt.getDrawX(), cxt.getDrawY() - 8, -872410880);
/*     */       
/* 292 */       for (int i = 0; i < this.recipe.getInputs().length; i++) {
/* 293 */         ItemStack piece = this.recipe.getInputs()[i];
/* 294 */         int x = i % 2;
/* 295 */         int y = i / 2;
/* 296 */         drawStack(gem, piece, cxt.marginX + 10 + 2 + x * 22, cxt.getDrawY() + 11 + 2 + y * 22, ri, cxt);
/*     */       }
/*     */       
/* 299 */       drawStack(gem, this.recipe.getOutput(), cxt.marginX + 2 + 20 + 66, cxt.getDrawY() + 2 + 22, ri, cxt); }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/* 302 */     protected ResourceLocation STAMPING_TEXTURE = new ResourceLocation("intangible:textures/gui/stampinggrid.png");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/* 308 */     public ResourceLocation getBackgroundTexture() { return this.STAMPING_TEXTURE; }
/*     */   }
/*     */   
/*     */   private static class MoldRecipeRenderer extends ShapedRecipePage.RecipeRenderer {
/*     */     private final ItemStack mold;
/*     */     private final FluidStack input;
/*     */     private final ItemStack result;
/*     */     
/*     */     public MoldRecipeRenderer(Item moldItem, FluidStack input, ItemStack result) {
/* 317 */       super();
/* 318 */       this.mold = new ItemStack(moldItem);
/* 319 */       this.input = input;
/* 320 */       this.result = result;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 326 */       Minecraft mc = Minecraft.func_71410_x();
/* 327 */       RenderItem ri = mc.func_175599_af();
/*     */       
/* 329 */       cxt.fontRenderer.func_78276_b(StatCollector.func_74838_a("book.intangible:recipemold"), cxt.getDrawX(), cxt.getDrawY() - 8, -872410880);
/*     */       
/* 331 */       drawStack(gem, this.mold, cxt.marginX + 23, cxt.getDrawY() + 12, ri, cxt);
/* 332 */       drawStack(gem, this.result, cxt.marginX + 2 + 20 + 66, cxt.getDrawY() + 2 + 22, ri, cxt);
/*     */       
/* 334 */       GlStateManager.func_179144_i(mc.func_147117_R().func_110552_b());
/*     */       
/* 336 */       if (cxt.pointer.containedBy(cxt.marginX + 23, cxt.getDrawY() + 33, 16.0F, 16.0F)) {
/* 337 */         cxt.tip = this.input.getLocalizedName();
/*     */       }
/*     */       
/* 340 */       double z = -1.0D;
/* 341 */       GlStateManager.func_179137_b(0.0D, 0.0D, z);
/*     */       
/* 343 */       RenderUtil.color(this.input.getFluid().getColor(this.input));
/* 344 */       net.minecraft.client.renderer.texture.TextureAtlasSprite sprite = mc.func_147117_R().getTextureExtry(this.input.getFluid().getStill(this.input).toString());
/*     */       
/* 346 */       RenderUtil.drawTexturedModalRect(cxt.marginX + 15, cxt.getDrawY() + 25, sprite, 16, 16, 1.0F);
/* 347 */       GlStateManager.func_179137_b(0.0D, 0.0D, -z); }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/* 350 */     protected ResourceLocation MOLD_TEXTURE = new ResourceLocation("intangible:textures/gui/moldgrid.png");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/* 356 */     public ResourceLocation getBackgroundTexture() { return this.MOLD_TEXTURE; }
/*     */   }
/*     */   
/*     */   private static class SoulRecipeRenderer extends ShapedRecipePage.RecipeRenderer {
/*     */     private final SoulRecipe recipe;
/*     */     
/*     */     public SoulRecipeRenderer(SoulRecipe soulRecipe) {
/* 363 */       super();
/* 364 */       this.recipe = soulRecipe;
/*     */     }
/*     */     
/*     */     public boolean isActiveFor(EntityPlayerSP player)
/*     */     {
/* 369 */       return PlayerEx.get(player).isKnowledgeLearnt(this.recipe.getRequiredSouls());
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 375 */       RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */       
/*     */ 
/* 378 */       int W = 10;
/* 379 */       int H = 10;
/*     */       
/* 381 */       String title = StatCollector.func_74838_a("book.intangible:recipeforge");
/* 382 */       drawText(title, -872397824, cxt.getDrawX() + 6 * W, cxt.getDrawY() - 8, 0.7F, cxt, gem);
/*     */       
/* 384 */       float deg45 = (float)(6.283185307179586D / this.recipe.getInputs().length);
/* 385 */       float ticks = (float)Minecraft.func_71410_x().field_71441_e.func_82737_E() / 100.0F;
/* 386 */       float distance = 28.0F;
/* 387 */       for (int i = 0; i < this.recipe.getInputs().length; i++) {
/* 388 */         float px = distance * (float)Math.cos(deg45 * i + ticks);
/* 389 */         py = distance * (float)Math.sin(deg45 * i + ticks);
/* 390 */         piece = this.recipe.getInputs()[i];
/* 391 */         drawStack(gem, piece, cxt.getDrawX() + 30 + px, cxt.getDrawY() - 6 + 3 * H + py, ri, cxt);
/*     */       }
/*     */       
/* 394 */       drawStack(gem, this.recipe.getOutput(this.recipe.getCloneOfInputs()), cxt.getDrawX() + 3 * W, cxt.getDrawY() - 6 + 3 * H, ri, cxt);
/*     */       
/* 396 */       ISoulSet souls = this.recipe.getRequiredSouls();
/* 397 */       int i = 0;
/* 398 */       float py = SoulType.values();ItemStack piece = py.length; for (ItemStack localItemStack1 = 0; localItemStack1 < piece; localItemStack1++) { SoulType soul = py[localItemStack1];
/* 399 */         int quantity = souls.quantityOf(soul);
/* 400 */         if (quantity > 0) {
/* 401 */           int px = cxt.marginX + 8 * W;
/* 402 */           int py = cxt.getDrawY() + 10 + (cxt.fontRenderer.field_78288_b + 1) * i;
/* 403 */           cxt.renderManager.field_78724_e.func_110577_a(EnumSoulType.fromSoulType(soul).getIcon());
/* 404 */           RenderUtil.drawModalRectWithCustomSizedTexture(px, py, 0.0F, 0.0F, 8, 8, 8.0F, 8.0F);
/* 405 */           cxt.fontRenderer.func_78276_b("" + quantity, px + 9, py, -872410880);
/*     */           
/* 407 */           if (cxt.pointer.containedBy(px + 8, py + 8, 8.0F, 8.0F)) {
/* 408 */             cxt.tip = emoniph.intangible.util.TextUtil.parse(EnumSoulType.fromSoulType(soul).getLocalizedName());
/*     */           }
/*     */           
/* 411 */           i++;
/*     */         }
/*     */       } }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/* 416 */     protected ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/gui/soulgrid.png");
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/* 422 */     public ResourceLocation getBackgroundTexture() { return this.TEXTURE; }
/*     */   }
/*     */   
/*     */   private static class GolemPartRecipeRenderer extends ShapedRecipePage.RecipeRenderer {
/*     */     private final GolemPartRecipe recipe;
/*     */     
/*     */     public GolemPartRecipeRenderer(GolemPartRecipe soulRecipe) {
/* 429 */       super();
/* 430 */       this.recipe = soulRecipe;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     void render(EntityKnowledgeGem gem, EntityPlayerSP player, ItemStack stack, Page.RenderContext cxt, float partialTicks)
/*     */     {
/* 436 */       RenderItem ri = Minecraft.func_71410_x().func_175599_af();
/*     */       
/*     */ 
/* 439 */       int W = 10;
/* 440 */       int H = 10;
/*     */       
/* 442 */       cxt.fontRenderer.func_78276_b(StatCollector.func_74838_a("book.intangible:recipegolempart"), cxt.getDrawX() + 6 * W, cxt.getDrawY() - 8, -872410880);
/*     */       
/* 444 */       float deg45 = (float)(6.283185307179586D / this.recipe.getInputs().length);
/* 445 */       float ticks = (float)Minecraft.func_71410_x().field_71441_e.func_82737_E() / 100.0F;
/* 446 */       float distance = 28.0F;
/* 447 */       for (int i = 0; i < this.recipe.getInputs().length; i++) {
/* 448 */         float px = distance * (float)Math.cos(deg45 * i + ticks);
/* 449 */         py = distance * (float)Math.sin(deg45 * i + ticks);
/* 450 */         piece = this.recipe.getInputs()[i];
/* 451 */         drawStack(gem, piece, cxt.getDrawX() + 30 + px, cxt.getDrawY() - 6 + 3 * H + py, ri, cxt);
/*     */       }
/*     */       
/* 454 */       drawStack(gem, this.recipe.getOutput(), cxt.getDrawX() + 3 * W, cxt.getDrawY() - 6 + 3 * H, ri, cxt);
/*     */       
/* 456 */       ISoulSet souls = new SoulSet().add(SoulType.MALLEABLE, 1);
/* 457 */       int i = 0;
/* 458 */       float py = SoulType.values();ItemStack piece = py.length; for (ItemStack localItemStack1 = 0; localItemStack1 < piece; localItemStack1++) { SoulType soul = py[localItemStack1];
/* 459 */         int quantity = souls.quantityOf(soul);
/* 460 */         if (quantity > 0) {
/* 461 */           int px = cxt.marginX + 8 * W;
/* 462 */           int py = cxt.getDrawY() + 10 + (cxt.fontRenderer.field_78288_b + 1) * i;
/* 463 */           cxt.renderManager.field_78724_e.func_110577_a(EnumSoulType.fromSoulType(soul).getIcon());
/* 464 */           RenderUtil.drawModalRectWithCustomSizedTexture(px, py, 0.0F, 0.0F, 8, 8, 8.0F, 8.0F);
/* 465 */           cxt.fontRenderer.func_78276_b("" + quantity, px + 9, py, -872410880);
/*     */           
/* 467 */           if (cxt.pointer.containedBy(px + 8, py + 8, 8.0F, 8.0F)) {
/* 468 */             cxt.tip = emoniph.intangible.util.TextUtil.parse(EnumSoulType.fromSoulType(soul).getLocalizedName());
/*     */           }
/*     */           
/* 471 */           i++;
/*     */         }
/*     */       } }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/* 476 */     protected ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/gui/soulgrid.png");
/*     */     
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/*     */     public ResourceLocation getBackgroundTexture()
/*     */     {
/* 482 */       return this.TEXTURE;
/*     */     }
/*     */   }
/*     */   
/*     */   public ShapedRecipePage(String id, Book book, ItemStack stack) {
/* 487 */     super(id, book);
/* 488 */     this.stack = stack;
/*     */     
/* 490 */     List recipes = net.minecraft.item.crafting.CraftingManager.func_77594_a().func_77592_b();
/* 491 */     Iterator iterator = recipes.iterator();
/* 492 */     while (iterator.hasNext()) {
/* 493 */       IRecipe irecipe = (IRecipe)iterator.next();
/* 494 */       if ((irecipe.func_77571_b() != null) && (irecipe.func_77571_b().func_77969_a(stack))) {
/* 495 */         if ((irecipe instanceof ShapedRecipes)) {
/* 496 */           this.recipeRenderers.add(new ShapedRecipeRenderer((ShapedRecipes)irecipe));
/* 497 */         } else if ((irecipe instanceof ShapedOreRecipe)) {
/* 498 */           this.recipeRenderers.add(new ShapedOreRecipeRenderer((ShapedOreRecipe)irecipe));
/* 499 */         } else if ((irecipe instanceof ShapelessOreRecipe)) {
/* 500 */           this.recipeRenderers.add(new ShapelessOreRecipeRenderer((ShapelessOreRecipe)irecipe));
/* 501 */         } else if ((irecipe instanceof ShapelessRecipes)) {
/* 502 */           this.recipeRenderers.add(new ShapelessRecipeRenderer((ShapelessRecipes)irecipe));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 507 */     Get.recipes();StampingRecipe stampingRecipe = ModRecipes.stamping.getRecipeForOutput(stack);
/* 508 */     if (stampingRecipe != null) {
/* 509 */       this.recipeRenderers.add(new StampingRecipeRenderer(stampingRecipe));
/*     */     }
/*     */     
/* 512 */     iterator = Item.field_150901_e.iterator();
/* 513 */     Item item; while (iterator.hasNext()) {
/* 514 */       item = (Item)iterator.next();
/* 515 */       if ((item instanceof IMold)) {
/* 516 */         IMold mold = (IMold)item;
/* 517 */         FluidStack fluid = mold.getRequiredFluid(stack);
/* 518 */         if (fluid != null) {
/* 519 */           this.recipeRenderers.add(new MoldRecipeRenderer(item, fluid, mold.getResultForFluid(fluid)));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 524 */     Get.recipes(); for (SoulRecipe soulRecipe : ModRecipes.souls.getRecipesForOutput(stack, id.endsWith("_tempering") ? emoniph.intangible.recipes.SoulRecipeManager.Selector.TEMPERING : emoniph.intangible.recipes.SoulRecipeManager.Selector.MAIN)) {
/* 525 */       this.recipeRenderers.add(new SoulRecipeRenderer(soulRecipe));
/*     */     }
/*     */     
/* 528 */     Get.recipes();GolemPartRecipe golemPartRecipe = ModRecipes.golemParts.getRecipeForOutput(stack);
/* 529 */     if (golemPartRecipe != null) {
/* 530 */       this.recipeRenderers.add(new GolemPartRecipeRenderer(golemPartRecipe));
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void renderHeaderContent(EntityKnowledgeGem gem, EntityPlayerSP player, Page.RenderContext context, float partialTicks)
/*     */   {
/* 537 */     if (this.recipeRenderers.size() > 0)
/*     */     {
/*     */ 
/* 540 */       int index = player.field_70173_aa / 40 % this.recipeRenderers.size();
/*     */       
/* 542 */       RecipeRenderer renderer = null;
/*     */       
/* 544 */       for (int i = 0; i < this.recipeRenderers.size(); i++) {
/* 545 */         int loc = (index + i) % this.recipeRenderers.size();
/* 546 */         if (((RecipeRenderer)this.recipeRenderers.get(loc)).isActiveFor(player)) {
/* 547 */           renderer = (RecipeRenderer)this.recipeRenderers.get(loc);
/* 548 */           break;
/*     */         }
/*     */       }
/*     */       
/* 552 */       if (renderer == null) {
/* 553 */         return;
/*     */       }
/*     */       
/* 556 */       GlStateManager.func_179094_E();
/* 557 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.4F);
/*     */       
/* 559 */       if (renderer.getBackgroundTexture() != null) {
/* 560 */         context.renderManager.field_78724_e.func_110577_a(renderer.getBackgroundTexture());
/*     */         
/* 562 */         RenderUtil.drawModalRectWithCustomSizedTexture(context.getDrawX(), context.getDrawY(), 0.0F, 0.0F, 108, 64, 108.0F, 64.0F);
/*     */       }
/*     */       
/*     */ 
/* 566 */       GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 567 */       context.renderManager.field_78724_e.func_110577_a(TextureMap.field_110575_b);
/* 568 */       GlStateManager.func_179109_b(8.0F, 8.0F, 0.0F);
/* 569 */       renderer.render(gem, player, this.stack, context, partialTicks);
/* 570 */       GlStateManager.func_179109_b(-8.0F, -8.0F, 0.0F);
/*     */       
/* 572 */       GlStateManager.func_179121_F();
/*     */       
/* 574 */       context.y += 64;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/ShapedRecipePage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */