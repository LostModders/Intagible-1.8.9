/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IBookPage;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.PageType;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem.Button;
/*     */ import emoniph.intangible.entity.EntityKnowledgeGem.ImageButton;
/*     */ import emoniph.intangible.util.Point2d;
/*     */ import emoniph.intangible.util.TextUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Stack;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class Page implements IBookPage, Iterable<Page>
/*     */ {
/*     */   private final String id;
/*     */   private String title;
/*  35 */   private List<String> paragraphs = new ArrayList();
/*     */   private Image image;
/*     */   private ISoulSet soulsConsumed;
/*     */   private ISoulSet soulsUsed;
/*     */   private ItemStack imageStack;
/*     */   private emoniph.intangible.api.IKnol[] requiredKnols;
/*  41 */   private List<Page> children = new ArrayList();
/*     */   private Page siblingNext;
/*     */   private Page siblingPrev;
/*     */   private Page parent;
/*     */   
/*     */   public Page(String id, Book book) {
/*  47 */     this.id = emoniph.intangible.util.ModUtil.withPrefix(id);
/*  48 */     book.addToBook(this);
/*  49 */     title("book." + this.id + ".title");
/*     */   }
/*     */   
/*     */   public IBookPage knowledge(emoniph.intangible.api.IKnol... knols)
/*     */   {
/*  54 */     this.requiredKnols = knols;
/*  55 */     return this;
/*     */   }
/*     */   
/*     */   public IBookPage title(String resource)
/*     */   {
/*  60 */     this.title = resource;
/*  61 */     return this;
/*     */   }
/*     */   
/*     */   public IBookPage para(String resource)
/*     */   {
/*  66 */     return para(resource, false);
/*     */   }
/*     */   
/*     */   public IBookPage para(String resource, boolean createSiblings)
/*     */   {
/*     */     int pageNumber;
/*     */     Page currentPage;
/*     */     String rootId;
/*     */     String rootTitle;
/*  75 */     if (createSiblings) {
/*  76 */       List<String> pages = paginate(StatCollector.func_74838_a(resource), 136, 120);
/*  77 */       pageNumber = 1;
/*  78 */       currentPage = this;
/*  79 */       rootId = this.id;
/*  80 */       rootTitle = this.title;
/*  81 */       for (String page : pages) {
/*  82 */         if (pageNumber == 1) {
/*  83 */           this.paragraphs.add(page);
/*     */         } else {
/*  85 */           currentPage = currentPage.addPage(new Page(rootId + pageNumber, Get.book()), PageType.SIBLING);
/*  86 */           currentPage.title(rootTitle);
/*  87 */           currentPage.paragraphs.add(page);
/*     */         }
/*  89 */         pageNumber++;
/*     */       }
/*     */     } else {
/*  92 */       this.paragraphs.add(StatCollector.func_74838_a(resource));
/*     */     }
/*  94 */     return this;
/*     */   }
/*     */   
/*     */   public IBookPage consumedSouls(ISoulSet souls)
/*     */   {
/*  99 */     this.soulsConsumed = souls;
/* 100 */     return this;
/*     */   }
/*     */   
/*     */   public IBookPage usedSouls(ISoulSet souls)
/*     */   {
/* 105 */     this.soulsUsed = souls;
/* 106 */     return this;
/*     */   }
/*     */   
/*     */   protected int getHeaderHeight(boolean firstPage) {
/* 110 */     return (this.title != null ? net.minecraft.util.MathHelper.func_76143_f(15.0D) : 0) + (firstPage ? (this.image != null ? this.image.height + 4 : 0) + (this.imageStack != null ? 18 : 0) : 0) + (firstPage ? 0 : this.soulsConsumed != null ? (this.soulsConsumed.types() + 1) * 10 : 0) + (firstPage ? 0 : this.soulsUsed != null ? (this.soulsUsed.types() + 1) * 10 : 0);
/*     */   }
/*     */   
/*     */   private List<String> paginate(String text, int maxWidth, int maxHeight)
/*     */   {
/* 115 */     List<String> pages = new ArrayList();
/*     */     
/* 117 */     int x = 0;
/* 118 */     int headerHeight = getHeaderHeight(true);
/* 119 */     int y = headerHeight;
/* 120 */     int tagDepth = 0;
/* 121 */     StringBuilder tag = null;
/* 122 */     StringBuilder word = new StringBuilder();
/*     */     
/* 124 */     int tagStartIndex = -1;
/* 125 */     int startIndex = 0;
/*     */     
/*     */ 
/* 128 */     int index = 0; for (int length = text.length(); index < length; index++) {
/* 129 */       char c = text.charAt(index);
/* 130 */       switch (c) {
/*     */       case '[': 
/* 132 */         tag = new StringBuilder();
/* 133 */         tag.append(c);
/* 134 */         if (tagDepth == 0) {
/* 135 */           tagStartIndex = index;
/*     */         }
/*     */         break;
/*     */       case ']': 
/* 139 */         if (tag != null) {
/* 140 */           tag.append(c);
/* 141 */           String tagText = tag.toString();
/* 142 */           if (tagText.equals("[br]")) {
/* 143 */             if (y + 9 + 1 > maxHeight) {
/* 144 */               int endIndex = tagStartIndex >= 0 ? tagStartIndex : index - word.length();
/* 145 */               pages.add(text.substring(startIndex, endIndex));
/* 146 */               startIndex = endIndex;
/* 147 */               x = 0;
/* 148 */               y = getHeaderHeight(false);
/* 149 */               word = new StringBuilder();
/* 150 */             } else if ((y > 0) || (x > 0)) {
/* 151 */               x = 0;
/* 152 */               y += 10;
/* 153 */               word = new StringBuilder();
/*     */             }
/* 155 */           } else if (tagText.equals("[/]")) {
/* 156 */             tagDepth--;
/*     */           } else {
/* 158 */             tagDepth++;
/*     */           }
/* 160 */           tag = null;
/* 161 */           if (tagDepth == 0) {
/* 162 */             if (y + 9 + 1 > maxHeight) {
/* 163 */               pages.add(text.substring(startIndex, tagStartIndex));
/* 164 */               startIndex = tagStartIndex;
/* 165 */               x = 0;
/* 166 */               y = getHeaderHeight(false);
/*     */             }
/* 168 */             tagStartIndex = -1;
/*     */           }
/*     */         }
/*     */         
/*     */         break;
/*     */       case '\t': 
/*     */       case ' ': 
/* 175 */         if (tag != null) {
/* 176 */           tag.append(c);
/*     */         } else {
/* 178 */           int wordLen = lengthOf(word);
/* 179 */           if (x + wordLen > maxWidth) {
/* 180 */             if (y + 9 > maxHeight) {
/* 181 */               int endIndex = tagStartIndex >= 0 ? tagStartIndex : index - word.length();
/* 182 */               pages.add(text.substring(startIndex, endIndex));
/* 183 */               startIndex = endIndex;
/* 184 */               x = 0;
/* 185 */               y = getHeaderHeight(false);
/*     */             } else {
/* 187 */               x = wordLen + 2;
/* 188 */               y += 10;
/*     */             }
/*     */           } else {
/* 191 */             x += wordLen + 2;
/*     */           }
/* 193 */           word = new StringBuilder();
/*     */         }
/* 195 */         break;
/*     */       default: 
/* 197 */         if (tag != null) {
/* 198 */           tag.append(c);
/*     */         } else {
/* 200 */           word.append(c);
/*     */         }
/*     */         break;
/*     */       }
/*     */       
/*     */     }
/* 206 */     if (startIndex >= 0) {
/* 207 */       pages.add(text.substring(startIndex, tagStartIndex >= 0 ? tagStartIndex : index));
/*     */     }
/*     */     
/* 210 */     return pages;
/*     */   }
/*     */   
/*     */   private int lengthOf(StringBuilder text) {
/* 214 */     return Minecraft.func_71410_x().field_71466_p.func_78256_a(text.toString());
/*     */   }
/*     */   
/*     */   public IBookPage image(String resource, int width, int height)
/*     */   {
/* 219 */     this.image = new Image(new ResourceLocation(resource), width, height);
/* 220 */     return this;
/*     */   }
/*     */   
/*     */   public IBookPage image(ItemStack stack)
/*     */   {
/* 225 */     this.imageStack = stack;
/* 226 */     return this;
/*     */   }
/*     */   
/*     */   public IBookPage createPage(String id, PageType pageType)
/*     */   {
/* 231 */     return addPage(new Page(id, Get.book()), pageType);
/*     */   }
/*     */   
/*     */   public IBookPage createPage(String id, PageType pageType, ItemStack stack)
/*     */   {
/* 236 */     return addPage(new ShapedRecipePage(id, Get.book(), stack), pageType);
/*     */   }
/*     */   
/*     */   public IBookPage createPage(String id, PageType pageType, emoniph.intangible.api.IMultiBlockPlan plan)
/*     */   {
/* 241 */     return addPage(new MultiBlockPage(id, Get.book(), plan), pageType);
/*     */   }
/*     */   
/*     */   public Page addPage(Page page, PageType pageType) {
/* 245 */     switch (pageType) {
/*     */     case CHILD: 
/* 247 */       this.children.add(page);
/*     */       
/* 249 */       Page currentParent = this;
/* 250 */       while (currentParent.siblingPrev != null) {
/* 251 */         currentParent = currentParent.siblingPrev;
/*     */       }
/*     */       
/* 254 */       page.setParent(currentParent);
/*     */       
/* 256 */       break;
/*     */     case SIBLING: 
/* 258 */       Page current = this;
/* 259 */       while (current.siblingNext != null) {
/* 260 */         current = current.siblingNext;
/*     */       }
/* 262 */       current.siblingNext = page;
/* 263 */       page.siblingPrev = current;
/* 264 */       page.setParent(current.parent);
/*     */     }
/*     */     
/*     */     
/* 268 */     return page;
/*     */   }
/*     */   
/*     */   public boolean hasChildren() {
/* 272 */     return !this.children.isEmpty();
/*     */   }
/*     */   
/*     */   public Page getNextSibling(BookNavigator navigator, Learning learning) {
/* 276 */     if ((this.siblingNext != null) && (isUnlocked(this.siblingNext, learning))) {
/* 277 */       return this.siblingNext;
/*     */     }
/* 279 */     return null;
/*     */   }
/*     */   
/*     */   private static class Image
/*     */   {
/*     */     final int width;
/*     */     final int height;
/*     */     final ResourceLocation resource;
/*     */     
/*     */     public Image(ResourceLocation resource, int width, int height) {
/* 289 */       this.resource = resource;
/* 290 */       this.width = width;
/* 291 */       this.height = height;
/*     */     }
/*     */   }
/*     */   
/*     */   private static boolean isUnlocked(Page page, Learning learning) {
/* 296 */     return (page != null) && ((page.requiredKnols == null) || (learning.contains(page.requiredKnols)));
/*     */   }
/*     */   
/*     */   public void setParent(Page chapter) {
/* 300 */     this.parent = chapter;
/*     */   }
/*     */   
/*     */   public Page getParent() {
/* 304 */     return this.parent;
/*     */   }
/*     */   
/*     */   public Iterator<Page> iterator() {
/* 308 */     return this.children.iterator();
/*     */   }
/*     */   
/*     */   public String getId() {
/* 312 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/* 316 */     return this.title;
/*     */   }
/*     */   
/*     */   public void parsePage(BookNavigator bookNavigator, Learning learning) {
/* 320 */     List<Word> words = new ArrayList();
/* 321 */     int p = 0; for (int pCount = this.paragraphs.size(); p < pCount; p++) {
/* 322 */       if (p > 0) {
/* 323 */         words.add(new NewLine(1.2D));
/*     */       }
/*     */       
/* 326 */       parseTextSection(((String)this.paragraphs.get(p)).trim().replaceAll("[ \\t]+", " "), words, learning);
/*     */     }
/*     */     
/* 329 */     if (hasChildren()) {
/* 330 */       if (this.paragraphs.size() > 0) {
/* 331 */         words.add(new NewLine(1.2D));
/*     */       }
/*     */       
/* 334 */       for (Page child : this.children) {
/* 335 */         if (isUnlocked(child, learning)) {
/* 336 */           String title = child.getTitle();
/* 337 */           if (title != null) {
/* 338 */             if (child.imageStack != null) {
/* 339 */               parseTextSection(String.format("[img %s;%d][link %s]%s[/][br]", new Object[] {net.minecraft.item.Item.field_150901_e
/* 340 */                 .func_177774_c(child.imageStack.func_77973_b()), 
/* 341 */                 Integer.valueOf(child.imageStack.func_77981_g() ? child.imageStack.func_77960_j() : 0), child.getId(), 
/* 342 */                 StatCollector.func_74838_a(child.getTitle()) }), words, learning);
/*     */             }
/*     */             else {
/* 345 */               parseTextSection(String.format("> [link %s]%s[/][br]", new Object[] { child.getId(), StatCollector.func_74838_a(child.getTitle()) }), words, learning);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 352 */     bookNavigator.cacheWords(words);
/*     */   }
/*     */   
/*     */   private void parseTextSection(String localizedText, List<Word> words, Learning learning) {
/* 356 */     Stack<Format> formats = new Stack();
/* 357 */     IToken currentToken = null;
/* 358 */     int i = 0; for (int count = localizedText.length(); i < count; i++) {
/* 359 */       char c = localizedText.charAt(i);
/* 360 */       switch (c) {
/*     */       case '[': 
/* 362 */         if (currentToken != null) {
/* 363 */           currentToken.finish(formats, words, learning);
/*     */         }
/* 365 */         currentToken = new Format(null);
/* 366 */         break;
/*     */       case ']': 
/* 368 */         if (currentToken != null) {
/* 369 */           currentToken.finish(formats, words, learning);
/*     */         }
/* 371 */         currentToken = null;
/* 372 */         break;
/*     */       case ' ': 
/* 374 */         if (currentToken != null) {
/* 375 */           if (currentToken.allowSpace(formats)) {
/* 376 */             currentToken.append(c);
/*     */           } else {
/* 378 */             currentToken.finish(formats, words, learning);
/* 379 */             currentToken = null;
/*     */           }
/*     */         }
/*     */         break;
/*     */       default: 
/* 384 */         if (currentToken == null) {
/* 385 */           currentToken = new Word();
/*     */         }
/* 387 */         currentToken.append(c);
/*     */       }
/*     */       
/*     */     }
/* 391 */     if (currentToken != null) {
/* 392 */       currentToken.finish(formats, words, learning);
/*     */     }
/*     */   }
/*     */   
/*     */   private static final int LINE_HEIGHT = 9;
/*     */   protected static final int PAGE_WIDTH = 136;
/*     */   private static final int SPACE_LEN = 2;
/*     */   private static Map<String, String> getFormats()
/*     */   {
/* 401 */     Map<String, String> formats = new java.util.HashMap();
/* 402 */     formats.put("black", "§0");
/* 403 */     formats.put("darkblue", "§1");
/* 404 */     formats.put("darkgreen", "§2");
/* 405 */     formats.put("darkaqua", "§3");
/* 406 */     formats.put("darkred", "§4");
/* 407 */     formats.put("darkpurple", "§5");
/* 408 */     formats.put("darkyellow", "§6");
/* 409 */     formats.put("gray", "§7");
/* 410 */     formats.put("darkgray", "§8");
/* 411 */     formats.put("blue", "§9");
/* 412 */     formats.put("green", "§a");
/* 413 */     formats.put("aqua", "§b");
/* 414 */     formats.put("red", "§c");
/* 415 */     formats.put("purple", "§d");
/* 416 */     formats.put("yellow", "§e");
/* 417 */     formats.put("white", "§f");
/* 418 */     formats.put("b", "§l");
/* 419 */     formats.put("s", "§m");
/* 420 */     formats.put("u", "§n");
/* 421 */     formats.put("i", "§o");
/* 422 */     return formats;
/*     */   }
/*     */   
/*     */   private static abstract interface IToken {
/*     */     public abstract void append(char paramChar);
/*     */     
/*     */     public abstract void finish(Stack<Page.Format> paramStack, List<Page.Word> paramList, Learning paramLearning);
/*     */     
/*     */     public abstract boolean allowSpace(Stack<Page.Format> paramStack);
/*     */   }
/*     */   
/*     */   private static class Format implements Page.IToken {
/* 434 */     StringBuilder key = new StringBuilder();
/* 435 */     StringBuilder value = new StringBuilder();
/*     */     boolean buildValue;
/* 437 */     private static final Map<String, String> styles = ;
/*     */     
/*     */     public void append(char c) {
/* 440 */       if (c == ' ') {
/* 441 */         this.buildValue = true;
/* 442 */       } else if (this.buildValue) {
/* 443 */         this.value.append(c);
/*     */       } else {
/* 445 */         this.key.append(c);
/*     */       }
/*     */     }
/*     */     
/*     */     public void finish(Stack<Format> formats, List<Page.Word> words, Learning learning)
/*     */     {
/* 451 */       String str = this.key.toString();
/* 452 */       if ((str.equals("/")) && (!formats.empty())) {
/* 453 */         formats.pop();
/* 454 */       } else if (str.equals("br")) {
/* 455 */         words.add(new Page.NewLine(1.0D));
/* 456 */       } else if (str.equals("img")) {
/* 457 */         words.add(new Page.Img(this.value.toString()));
/*     */       } else {
/* 459 */         formats.push(this);
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean allowSpace(Stack<Format> formats)
/*     */     {
/* 465 */       return true;
/*     */     }
/*     */     
/*     */     public void decorate(Page.Word word, Learning learning) {
/* 469 */       String str = this.key.toString();
/* 470 */       if (styles.containsKey(str)) {
/* 471 */         word.text.insert(0, (String)styles.get(str));
/*     */       }
/* 473 */       else if ((str.equals("link")) && (Page.isUnlocked(Get.book().getPageForId(this.value.toString()), learning))) {
/* 474 */         word.text.insert(0, (String)styles.get("darkpurple"));
/*     */         
/*     */ 
/* 477 */         word.link = new EntityKnowledgeGem.Button(this.value.toString());
/* 478 */       } else if (str.equals("tip")) {
/* 479 */         word.text.insert(0, (String)styles.get("red"));
/*     */         
/* 481 */         word.tip = this.value.toString();
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean slurpSpaces() {
/* 486 */       return this.key.toString().equals("link");
/*     */     }
/*     */   }
/*     */   
/*     */   static class Word implements Page.IToken {
/* 491 */     StringBuilder text = new StringBuilder();
/*     */     String tip;
/*     */     EntityKnowledgeGem.Button link;
/*     */     
/*     */     public void append(char c)
/*     */     {
/* 497 */       this.text.append(c);
/*     */     }
/*     */     
/*     */     public void finish(Stack<Page.Format> formats, List<Word> words, Learning learning)
/*     */     {
/* 502 */       for (Page.Format format : formats) {
/* 503 */         format.decorate(this, learning);
/*     */       }
/* 505 */       words.add(this);
/*     */     }
/*     */     
/*     */     public boolean allowSpace(Stack<Page.Format> formats)
/*     */     {
/* 510 */       for (Page.Format format : formats) {
/* 511 */         if (format.slurpSpaces()) {
/* 512 */           return true;
/*     */         }
/*     */       }
/* 515 */       return false;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public void render(Page.RenderContext context) {
/* 520 */       String text = this.text.toString();
/* 521 */       int width = context.fontRenderer.func_78256_a(text);
/* 522 */       if ((context.x > 0) && (context.x + width > context.clientWidth)) {
/* 523 */         context.x = 0;
/* 524 */         context.y += context.getLineHeight();
/*     */       }
/* 526 */       boolean hot = false;
/* 527 */       if (this.link != null) {
/* 528 */         this.link.setBounds(context.getDrawX(), context.getDrawY(), width, context.getLineHeight());
/* 529 */         hot = this.link.contains(context.pointer);
/*     */       }
/*     */       
/* 532 */       if ((this.tip != null) && 
/* 533 */         (context.pointer.containedBy(context.getDrawX(), context.getDrawY(), width, context.getLineHeight())))
/*     */       {
/*     */ 
/*     */ 
/* 537 */         context.tip = TextUtil.parse(StatCollector.func_74838_a(this.tip));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 543 */       if (hot) {
/* 544 */         context.fontRenderer.func_78276_b(text.replace("§5", "§5§n"), context.getDrawX(), context.getDrawY(), -855703552);
/*     */       } else {
/* 546 */         context.fontRenderer.func_78276_b(text, context.getDrawX(), context.getDrawY(), -872402176);
/*     */       }
/*     */       
/* 549 */       context.x += width + 2;
/*     */     }
/*     */     
/*     */     public void addButtonsTo(EntityKnowledgeGem gem) {
/* 553 */       if (this.link != null) {
/* 554 */         gem.addButton(this.link);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class NewLine extends Page.Word {
/*     */     private final double scale;
/*     */     
/*     */     public NewLine(double scale) {
/* 563 */       this.scale = scale;
/*     */     }
/*     */     
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/*     */     public void render(Page.RenderContext context)
/*     */     {
/* 570 */       if ((!context.atContentStart()) || (context.x > 0)) {
/* 571 */         context.x = 0; Page.RenderContext 
/* 572 */           tmp20_19 = context;tmp20_19.y = ((int)(tmp20_19.y + context.getLineHeight() * this.scale));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Img extends Page.Word
/*     */   {
/*     */     private final String params;
/*     */     
/*     */     public Img(String params) {
/* 582 */       this.params = params;
/*     */     }
/*     */     
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/*     */     public void render(Page.RenderContext context)
/*     */     {
/* 589 */       if (!this.params.isEmpty()) {
/* 590 */         String[] parts = this.params.split(";");
/* 591 */         if (parts.length > 0) {
/* 592 */           net.minecraft.item.Item item = net.minecraft.item.Item.func_111206_d(parts[0]);
/* 593 */           if (item != null) {
/* 594 */             int meta = 0;
/* 595 */             if (parts.length > 1) {
/*     */               try {
/* 597 */                 meta = Integer.parseInt(parts[1]);
/*     */               }
/*     */               catch (NumberFormatException localNumberFormatException) {}
/*     */             }
/*     */             
/*     */ 
/* 603 */             ItemStack stack = new ItemStack(item, 1, meta);
/* 604 */             int x = context.getDrawX();
/* 605 */             int y = context.getDrawY();
/* 606 */             emoniph.intangible.util.RenderUtil.drawStack(stack, x + 8, y + 8, Minecraft.func_71410_x().func_175599_af(), context.fontRenderer);
/* 607 */             if (context.pointer.containedBy(x, y, 16.0F, 16.0F)) {
/* 608 */               context.tip = stack.func_82833_r();
/*     */             }
/*     */             
/* 611 */             context.x += 18;
/* 612 */             context.y += 6;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected static class RenderContext {
/*     */     int x;
/*     */     int y;
/*     */     final RenderManager renderManager;
/*     */     final FontRenderer fontRenderer;
/*     */     final Point2d pointer;
/*     */     final int marginX;
/*     */     final int marginY;
/*     */     final int clientWidth;
/*     */     final int clientHeight;
/*     */     final Learning learning;
/*     */     final BookNavigator navigator;
/*     */     public String tip;
/*     */     private int contentStart;
/*     */     
/* 635 */     public RenderContext(RenderManager renderManager, Point2d pointer, Learning learning, BookNavigator navigator, int marginX, int marginY, int clientWidth, int clientHeight) { this.renderManager = renderManager;
/* 636 */       this.fontRenderer = renderManager.func_78716_a();
/* 637 */       this.pointer = pointer;
/* 638 */       this.marginX = marginX;
/* 639 */       this.marginY = marginY;
/* 640 */       this.clientWidth = clientWidth;
/* 641 */       this.clientHeight = clientHeight;
/* 642 */       this.navigator = navigator;
/* 643 */       this.learning = learning;
/*     */     }
/*     */     
/*     */     public int getLineHeight() {
/* 647 */       return this.fontRenderer.field_78288_b + 1;
/*     */     }
/*     */     
/*     */     public int getDrawX() {
/* 651 */       return this.marginX + this.x;
/*     */     }
/*     */     
/*     */     public int getDrawY() {
/* 655 */       return this.marginY + this.y;
/*     */     }
/*     */     
/*     */ 
/*     */     public void beginContent()
/*     */     {
/* 661 */       this.contentStart = this.y;
/*     */     }
/*     */     
/*     */     public boolean atContentStart() {
/* 665 */       return this.y == this.contentStart;
/*     */     }
/*     */   }
/*     */   
/*     */   private static final String FORMAT_CHAR = "§";
/*     */   private static final String FORMAT_CLEAR = "§r";
/*     */   private static final int HotTextColor = -855703552;
/*     */   private static final int TextColor = -872402176;
/*     */   private static final int TitleColor = -872410880;
/*     */   private static final int PaginateColor = -1728044544;
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void render(EntityKnowledgeGem gem, EntityPlayerSP player, BookNavigator nav, Learning learning, Point2d pointer, float partialTicks, RenderManager renderManager) {
/* 677 */     int clientWidth = 136;
/* 678 */     int marginLeft = 'Þ' / 2 - clientWidth / 2;
/*     */     
/*     */ 
/* 681 */     RenderContext context = new RenderContext(renderManager, pointer, learning, nav, marginLeft, 44, clientWidth, 300);
/*     */     
/* 683 */     if (this.title != null) {
/* 684 */       renderManager.func_78716_a().func_78276_b(StatCollector.func_74838_a(this.title), context.getDrawX(), context.getDrawY(), -872410880); RenderContext 
/* 685 */         tmp81_79 = context;tmp81_79.y = ((int)(tmp81_79.y + context.getLineHeight() * 1.5D));
/* 686 */       context.x = 0;
/*     */     }
/*     */     
/* 689 */     if (this.image != null) {
/* 690 */       context.x = (context.clientWidth / 2 - this.image.width / 2);
/* 691 */       renderManager.field_78724_e.func_110577_a(this.image.resource);
/* 692 */       GlStateManager.func_179124_c(1.0F, 1.0F, 1.0F);
/* 693 */       emoniph.intangible.util.RenderUtil.drawModalRectWithCustomSizedTexture(context.getDrawX(), context.getDrawY(), 0.0F, 0.0F, this.image.width, this.image.height, this.image.width, this.image.height); RenderContext 
/* 694 */         tmp204_202 = context;tmp204_202.y = ((int)(tmp204_202.y + (this.image.height + context.getLineHeight() * 0.5D)));
/* 695 */       context.x = 0;
/*     */     }
/*     */     
/* 698 */     if (this.imageStack != null) {
/* 699 */       context.x = (context.clientWidth / 2);
/* 700 */       emoniph.intangible.util.RenderUtil.drawStack(this.imageStack, context.getDrawX(), context.getDrawY() + 8, Minecraft.func_71410_x().func_175599_af(), context.fontRenderer); RenderContext 
/* 701 */         tmp293_291 = context;tmp293_291.y = ((int)(tmp293_291.y + (16.0D + context.getLineHeight() * 0.5D)));
/* 702 */       context.x = 0;
/*     */     }
/*     */     
/* 705 */     if (this.soulsUsed != null) {
/* 706 */       context.fontRenderer.func_78276_b(TextUtil.parse(StatCollector.func_74838_a("book.intangible:usedsouls")), context.getDrawX(), context.getDrawY(), -872402176);
/* 707 */       context.x = 0; RenderContext 
/* 708 */         tmp368_366 = context;tmp368_366.y = ((int)(tmp368_366.y + (context.getLineHeight() + 0.1D)));
/* 709 */       for (SoulType soulType : SoulType.values()) {
/* 710 */         renderSoulQuantity(context, soulType, this.soulsUsed);
/*     */       }
/* 712 */       RenderContext tmp434_432 = context;tmp434_432.y = ((int)(tmp434_432.y + context.getLineHeight() * 0.5D));
/*     */     }
/*     */     
/* 715 */     if (this.soulsConsumed != null) {
/* 716 */       context.fontRenderer.func_78276_b(TextUtil.parse(StatCollector.func_74838_a("book.intangible:consumedsouls")), context.getDrawX(), context.getDrawY(), -872402176);
/* 717 */       context.x = 0; RenderContext 
/* 718 */         tmp499_497 = context;tmp499_497.y = ((int)(tmp499_497.y + (context.getLineHeight() + 0.1D)));
/* 719 */       for (SoulType soulType : SoulType.values()) {
/* 720 */         renderSoulQuantity(context, soulType, this.soulsConsumed);
/*     */       }
/* 722 */       RenderContext tmp565_563 = context;tmp565_563.y = ((int)(tmp565_563.y + context.getLineHeight() * 0.5D));
/*     */     }
/*     */     
/* 725 */     gem.clearButtons();
/* 726 */     renderHeaderContent(gem, player, context, partialTicks);
/*     */     
/* 728 */     if (nav.getCachedWords() == null) {
/* 729 */       nav.goToPage(nav.getCurrentPage(), learning);
/*     */     }
/*     */     
/*     */ 
/* 733 */     context.beginContent();
/*     */     
/* 735 */     for (??? = nav.getCachedWords().iterator(); ((Iterator)???).hasNext();) { Word word = (Word)((Iterator)???).next();
/* 736 */       word.render(context);
/* 737 */       word.addButtonsTo(gem);
/*     */     }
/*     */     
/* 740 */     renderFooterContent(gem, player, context, partialTicks);
/*     */     
/* 742 */     int buttonHeight = 19;
/*     */     
/* 744 */     int buttonMidPoint = 'Þ' / 2;
/*     */     
/*     */ 
/* 747 */     Page sibling = getNextSibling(nav, learning);
/* 748 */     int buttonXOffset = 70;
/* 749 */     int buttonYOffset = 80;
/* 750 */     if (sibling != null) {
/* 751 */       gem.addButton(new EntityKnowledgeGem.ImageButton(buttonMidPoint + buttonXOffset, buttonHeight + buttonYOffset, 24, 24, new ResourceLocation("intangible:textures/gui/knowledge_back.png"), 0, 232, 24, 232, sibling
/* 752 */         .getId()));
/*     */     }
/*     */     
/* 755 */     if (nav.canGoBack()) {
/* 756 */       gem.addButton(new EntityKnowledgeGem.ImageButton(buttonMidPoint - 24 - buttonXOffset, buttonHeight + buttonYOffset, 24, 24, new ResourceLocation("intangible:textures/gui/knowledge_back.png"), 48, 232, 72, 232, "navigate:back"));
/*     */     }
/*     */     
/*     */ 
/* 760 */     Page parent = getParent();
/* 761 */     if (parent != null) {
/* 762 */       gem.addButton(new EntityKnowledgeGem.ImageButton(buttonMidPoint - 12, 13, 24, 24, new ResourceLocation("intangible:textures/gui/knowledge_back.png"), 96, 232, 120, 232, "navigate:up"));
/*     */     }
/*     */     
/*     */ 
/* 766 */     gem.addButton(new EntityKnowledgeGem.ImageButton(buttonMidPoint - 12, 'Ý' - 40, 24, 24, new ResourceLocation("intangible:textures/gui/knowledge_back.png"), 144, 232, 168, 232, "navigate:close"));
/*     */     
/*     */ 
/* 769 */     gem.drawButtons(renderManager, pointer);
/*     */     
/*     */ 
/* 772 */     int maxPages = 1;
/* 773 */     int currentPage = 1;
/*     */     
/* 775 */     Page current = this;
/* 776 */     while (current.siblingPrev != null) {
/* 777 */       current = current.siblingPrev;
/* 778 */       currentPage++;
/* 779 */       maxPages++;
/*     */     }
/*     */     
/* 782 */     current = this;
/* 783 */     while (current.siblingNext != null) {
/* 784 */       current = current.siblingNext;
/* 785 */       maxPages++;
/*     */     }
/*     */     
/* 788 */     if (maxPages > 1) {
/* 789 */       String pageNumber = String.format(StatCollector.func_74838_a("book.intangible:pagenumber"), new Object[] { Integer.valueOf(currentPage), Integer.valueOf(maxPages) });
/*     */       
/* 791 */       float scale = 0.5F;
/* 792 */       int invScale = (int)(1.0F / scale);
/* 793 */       GlStateManager.func_179152_a(scale, scale, 0.0F);
/* 794 */       int width = context.fontRenderer.func_78256_a(pageNumber);
/* 795 */       context.fontRenderer.func_78276_b(pageNumber, invScale * (buttonMidPoint - width / (2 * invScale)), 37 * invScale, -1728044544);
/* 796 */       GlStateManager.func_179152_a(invScale, invScale, 0.0F);
/*     */     }
/*     */     
/* 799 */     if (context.tip != null) {
/* 800 */       List list = context.fontRenderer.func_78271_c(context.tip, 150);
/* 801 */       drawHoveringText(list, (int)context.pointer.x, (int)context.pointer.y, context.fontRenderer, -0.01D);
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   private static void renderSoulQuantity(RenderContext context, SoulType soulType, ISoulSet soulSet) {
/* 807 */     int quantity = soulSet.quantityOf(soulType);
/* 808 */     if (quantity > 0) {
/* 809 */       String soulText = emoniph.intangible.souls.EnumSoulType.fromSoulType(soulType).getLocalizedName();
/* 810 */       String format = StatCollector.func_74838_a("book.intangible:soulcost");
/* 811 */       String text = String.format(format, new Object[] { soulText, Integer.valueOf(quantity) });
/* 812 */       context.fontRenderer.func_78276_b(TextUtil.parse(text), context.getDrawX(), context.getDrawY(), -872402176);
/* 813 */       context.x = 0;
/* 814 */       context.y += context.getLineHeight();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void renderFooterContent(EntityKnowledgeGem gem, EntityPlayerSP player, RenderContext context, float partialTicks) {}
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected void renderHeaderContent(EntityKnowledgeGem gem, EntityPlayerSP player, RenderContext context, float partialTicks) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected static void drawHoveringText(List textLines, int x, int y, FontRenderer font, double zLevel)
/*     */   {
/* 829 */     if (!textLines.isEmpty()) {
/* 830 */       GlStateManager.func_179101_C();
/*     */       
/*     */ 
/* 833 */       GlStateManager.func_179097_i();
/* 834 */       int k = 0;
/* 835 */       Iterator iterator = textLines.iterator();
/*     */       
/* 837 */       while (iterator.hasNext()) {
/* 838 */         String s = (String)iterator.next();
/* 839 */         int l = font.func_78256_a(s);
/*     */         
/* 841 */         if (l > k) {
/* 842 */           k = l;
/*     */         }
/*     */       }
/*     */       
/* 846 */       int j2 = x + 12;
/* 847 */       int k2 = y - 12;
/* 848 */       int i1 = 8;
/*     */       
/* 850 */       if (textLines.size() > 1) {
/* 851 */         i1 += 2 + (textLines.size() - 1) * 10;
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
/* 866 */       int j1 = -267386864;
/* 867 */       drawGradientRect(j2 - 3, k2 - 4, j2 + k + 3, k2 - 3, j1, j1, zLevel);
/* 868 */       drawGradientRect(j2 - 3, k2 + i1 + 3, j2 + k + 3, k2 + i1 + 4, j1, j1, zLevel);
/* 869 */       drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 + i1 + 3, j1, j1, zLevel);
/* 870 */       drawGradientRect(j2 - 4, k2 - 3, j2 - 3, k2 + i1 + 3, j1, j1, zLevel);
/* 871 */       drawGradientRect(j2 + k + 3, k2 - 3, j2 + k + 4, k2 + i1 + 3, j1, j1, zLevel);
/* 872 */       int k1 = 1347420415;
/* 873 */       int l1 = (k1 & 0xFEFEFE) >> 1 | k1 & 0xFF000000;
/* 874 */       drawGradientRect(j2 - 3, k2 - 3 + 1, j2 - 3 + 1, k2 + i1 + 3 - 1, k1, l1, zLevel);
/* 875 */       drawGradientRect(j2 + k + 2, k2 - 3 + 1, j2 + k + 3, k2 + i1 + 3 - 1, k1, l1, zLevel);
/* 876 */       drawGradientRect(j2 - 3, k2 - 3, j2 + k + 3, k2 - 3 + 1, k1, k1, zLevel);
/* 877 */       drawGradientRect(j2 - 3, k2 + i1 + 2, j2 + k + 3, k2 + i1 + 3, l1, l1, zLevel);
/*     */       
/* 879 */       for (int i2 = 0; i2 < textLines.size(); i2++) {
/* 880 */         String s1 = (String)textLines.get(i2);
/* 881 */         font.func_175063_a(s1, j2, k2, -1);
/*     */         
/* 883 */         if (i2 == 0) {
/* 884 */           k2 += 2;
/*     */         }
/*     */         
/* 887 */         k2 += 10;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 893 */       GlStateManager.func_179126_j();
/*     */       
/* 895 */       GlStateManager.func_179091_B();
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected static void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor, double zLevel) {
/* 901 */     float f = (startColor >> 24 & 0xFF) / 255.0F;
/* 902 */     float f1 = (startColor >> 16 & 0xFF) / 255.0F;
/* 903 */     float f2 = (startColor >> 8 & 0xFF) / 255.0F;
/* 904 */     float f3 = (startColor & 0xFF) / 255.0F;
/* 905 */     float f4 = (endColor >> 24 & 0xFF) / 255.0F;
/* 906 */     float f5 = (endColor >> 16 & 0xFF) / 255.0F;
/* 907 */     float f6 = (endColor >> 8 & 0xFF) / 255.0F;
/* 908 */     float f7 = (endColor & 0xFF) / 255.0F;
/* 909 */     GlStateManager.func_179090_x();
/* 910 */     GlStateManager.func_179147_l();
/* 911 */     GlStateManager.func_179118_c();
/* 912 */     GlStateManager.func_179120_a(770, 771, 1, 0);
/* 913 */     GlStateManager.func_179103_j(7425);
/* 914 */     Tessellator tessellator = Tessellator.func_178181_a();
/* 915 */     WorldRenderer worldrenderer = tessellator.func_178180_c();
/*     */     
/*     */ 
/* 918 */     worldrenderer.func_181668_a(7, net.minecraft.client.renderer.vertex.DefaultVertexFormats.field_181706_f);
/*     */     
/* 920 */     worldrenderer.func_181662_b(right, top, zLevel).func_181666_a(f1, f2, f3, f).func_181675_d();
/* 921 */     worldrenderer.func_181662_b(left, top, zLevel).func_181666_a(f1, f2, f3, f).func_181675_d();
/*     */     
/* 923 */     worldrenderer.func_181662_b(left, bottom, zLevel).func_181666_a(f5, f6, f7, f4).func_181675_d();
/* 924 */     worldrenderer.func_181662_b(right, bottom, zLevel).func_181666_a(f5, f6, f7, f4).func_181675_d();
/* 925 */     tessellator.func_78381_a();
/* 926 */     GlStateManager.func_179103_j(7424);
/* 927 */     GlStateManager.func_179084_k();
/* 928 */     GlStateManager.func_179141_d();
/* 929 */     GlStateManager.func_179098_w();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/Page.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */