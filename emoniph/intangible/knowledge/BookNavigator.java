/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BookNavigator
/*     */ {
/*  15 */   private Stack<String> visitedPages = new Stack();
/*     */   List<Page.Word> words;
/*     */   
/*  18 */   public String getCurrentPage() { return this.visitedPages.empty() ? null : (String)this.visitedPages.peek(); }
/*     */   
/*     */   public String goBack(Learning learning)
/*     */   {
/*  22 */     if (!this.visitedPages.empty()) {
/*  23 */       this.visitedPages.pop();
/*     */     }
/*  25 */     Page page = Get.book().getPageForId(getCurrentPage());
/*  26 */     if (page != null) {
/*  27 */       page.parsePage(this, learning);
/*  28 */       return page.getId();
/*     */     }
/*  30 */     return null;
/*     */   }
/*     */   
/*     */   public String goUp(Learning learning) {
/*  34 */     Page page = Get.book().getPageForId(getCurrentPage());
/*  35 */     if (page != null) {
/*  36 */       this.visitedPages.clear();
/*  37 */       Page parent = page.getParent();
/*  38 */       goToPage(parent == null ? null : parent.getId(), learning);
/*     */     }
/*  40 */     return getCurrentPage();
/*     */   }
/*     */   
/*     */   public boolean canGoBack() {
/*  44 */     return this.visitedPages.size() > 1;
/*     */   }
/*     */   
/*     */   public void goToPage(String id, Learning learning) {
/*  48 */     if (this.visitedPages.empty()) {
/*  49 */       this.visitedPages.push(id);
/*  50 */     } else if ((this.visitedPages.peek() == null) && (id != null)) {
/*  51 */       this.visitedPages.push(id);
/*  52 */     } else if ((this.visitedPages.peek() != null) && (!((String)this.visitedPages.peek()).equals(id))) {
/*  53 */       this.visitedPages.push(id);
/*     */     }
/*  55 */     Page page = Get.book().getPageForId(id);
/*  56 */     if (page != null) {
/*  57 */       page.parsePage(this, learning);
/*     */     }
/*     */   }
/*     */   
/*     */   public NBTTagCompound getTagCompound() {
/*  62 */     NBTTagCompound compound = new NBTTagCompound();
/*  63 */     NBTTagList list = new NBTTagList();
/*     */     
/*  65 */     for (String page : this.visitedPages) {
/*  66 */       NBTTagCompound item = new NBTTagCompound();
/*  67 */       item.func_74778_a("page", page != null ? page : "");
/*  68 */       list.func_74742_a(item);
/*     */     }
/*     */     
/*  71 */     compound.func_74782_a("list", list);
/*  72 */     return compound;
/*     */   }
/*     */   
/*     */   public static BookNavigator fromTagCompound(NBTTagCompound compound) {
/*  76 */     BookNavigator navigator = new BookNavigator();
/*  77 */     NBTTagList list = compound.func_150295_c("list", 10);
/*  78 */     int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/*  79 */       NBTTagCompound item = list.func_150305_b(i);
/*  80 */       if (item != null) {
/*  81 */         String page = item.func_74779_i("page");
/*  82 */         navigator.visitedPages.push(page.equals("") ? null : page);
/*     */       }
/*     */     }
/*     */     
/*  86 */     return navigator;
/*     */   }
/*     */   
/*     */   public static BookNavigator fromBytes(ByteBuf buf) {
/*  90 */     BookNavigator navigator = new BookNavigator();
/*  91 */     int count = buf.readInt();
/*  92 */     for (int i = 0; i < count; i++)
/*     */     {
/*  94 */       String id = ByteBufUtils.readUTF8String(buf);
/*  95 */       if (id == null) {
/*  96 */         navigator.visitedPages.push(null);
/*     */       } else {
/*  98 */         navigator.visitedPages.push(id.equals("") ? null : id);
/*     */       }
/*     */     }
/* 101 */     return navigator;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf) {
/* 105 */     buf.writeInt(this.visitedPages.size());
/* 106 */     for (String page : this.visitedPages) {
/* 107 */       ByteBufUtils.writeUTF8String(buf, page != null ? page : "");
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void cacheWords(List<Page.Word> words)
/*     */   {
/* 115 */     this.words = words;
/*     */   }
/*     */   
/*     */   public List<Page.Word> getCachedWords() {
/* 119 */     return this.words;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/BookNavigator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */