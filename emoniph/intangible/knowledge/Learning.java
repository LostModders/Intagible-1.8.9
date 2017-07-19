/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.ILearning;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class Learning
/*     */   implements ILearning
/*     */ {
/*  17 */   private final Set<IKnol> learnings = new HashSet();
/*     */   
/*     */   public boolean contains(IKnol knol) {
/*  20 */     return this.learnings.contains(knol);
/*     */   }
/*     */   
/*     */   public boolean contains(IKnol[] knols) {
/*  24 */     for (int i = 0; i < knols.length; i++) {
/*  25 */       if (!this.learnings.contains(knols[i])) {
/*  26 */         return false;
/*     */       }
/*     */     }
/*  29 */     return true;
/*     */   }
/*     */   
/*     */   public boolean containedBy(ILearning other) {
/*  33 */     for (IKnol knol : this.learnings) {
/*  34 */       if (!other.contains(knol)) {
/*  35 */         return false;
/*     */       }
/*     */     }
/*  38 */     return true;
/*     */   }
/*     */   
/*     */   public void add(IKnol knol) {
/*  42 */     this.learnings.add(knol);
/*     */   }
/*     */   
/*     */   public void remove(IKnol knol) {
/*  46 */     this.learnings.remove(knol);
/*     */   }
/*     */   
/*     */   public void removeAll() {
/*  50 */     this.learnings.clear();
/*     */   }
/*     */   
/*     */   public Iterator<IKnol> iterator()
/*     */   {
/*  55 */     return this.learnings.iterator();
/*     */   }
/*     */   
/*     */   public static Learning of(IKnol... knols) {
/*  59 */     Learning learning = new Learning();
/*  60 */     learning.learnings.addAll(Arrays.asList(knols));
/*  61 */     return learning;
/*     */   }
/*     */   
/*     */   public NBTTagCompound toTagCompound() {
/*  65 */     NBTTagCompound compound = new NBTTagCompound();
/*  66 */     NBTTagList list = new NBTTagList();
/*  67 */     for (IKnol knol : this.learnings) {
/*  68 */       NBTTagCompound item = new NBTTagCompound();
/*  69 */       item.func_74778_a("id", knol.getId());
/*  70 */       list.func_74742_a(item);
/*     */     }
/*  72 */     compound.func_74782_a("list", list);
/*  73 */     return compound;
/*     */   }
/*     */   
/*     */   public static Learning fromTagCompound(NBTTagCompound compound) {
/*  77 */     Learning learning = new Learning();
/*  78 */     NBTTagList list = compound.func_150295_c("list", 10);
/*  79 */     int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/*  80 */       NBTTagCompound item = list.func_150305_b(i);
/*  81 */       if (item != null) {
/*  82 */         IKnol knol = Get.knowledge().getKnolFromId(item.func_74779_i("id"));
/*  83 */         if (knol != null) {
/*  84 */           learning.learnings.add(knol);
/*     */         }
/*     */       }
/*     */     }
/*  88 */     return learning;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf) {
/*  92 */     buf.writeInt(this.learnings.size());
/*  93 */     for (IKnol knol : this.learnings) {
/*  94 */       int index = Get.knowledge().getIndexFromKnol(knol);
/*  95 */       if (index >= 0) {
/*  96 */         buf.writeInt(index);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static Learning fromBytes(ByteBuf buf) {
/* 102 */     Learning learning = new Learning();
/* 103 */     int count = buf.readInt();
/* 104 */     for (int i = 0; i < count; i++) {
/* 105 */       int index = buf.readInt();
/* 106 */       IKnol knol = Get.knowledge().getKnolFromIndex(index);
/* 107 */       if (knol != null) {
/* 108 */         learning.learnings.add(knol);
/*     */       }
/*     */     }
/*     */     
/* 112 */     return learning;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/Learning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */