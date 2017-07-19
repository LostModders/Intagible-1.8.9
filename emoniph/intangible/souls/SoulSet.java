/*     */ package emoniph.intangible.souls;
/*     */ 
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ 
/*     */ public class SoulSet implements ISoulSet, Iterable<SoulType>
/*     */ {
/*  12 */   private final int[] souls = new int[SoulType.values().length];
/*     */   
/*     */   private int total;
/*     */   
/*     */   public SoulSet() {}
/*     */   
/*     */   public SoulSet(ISoulSet other)
/*     */   {
/*  20 */     for (SoulType soulType : SoulType.values()) {
/*  21 */       add(soulType, other.quantityOf(soulType));
/*     */     }
/*     */   }
/*     */   
/*     */   public ISoulSet add(SoulType soulType, int quantity)
/*     */   {
/*  27 */     this.souls[soulType.ordinal()] += quantity;
/*  28 */     this.total += quantity;
/*  29 */     return this;
/*     */   }
/*     */   
/*     */   public int quantityOf(SoulType soulType)
/*     */   {
/*  34 */     return this.souls[soulType.ordinal()];
/*     */   }
/*     */   
/*     */   public boolean isEmpty()
/*     */   {
/*  39 */     return this.total == 0;
/*     */   }
/*     */   
/*     */   public boolean equalTo(ISoulSet other)
/*     */   {
/*  44 */     for (SoulType soulType : ) {
/*  45 */       if (quantityOf(soulType) != other.quantityOf(soulType)) {
/*  46 */         return false;
/*     */       }
/*     */     }
/*     */     
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public boolean trySubtract(ISoulSet costs) {
/*  54 */     if (!contains(costs)) {
/*  55 */       return false;
/*     */     }
/*     */     
/*  58 */     SoulType[] soulTypes = SoulType.values();
/*  59 */     for (int i = 0; i < this.souls.length; i++) {
/*  60 */       int quantity = costs.quantityOf(soulTypes[i]);
/*  61 */       this.souls[i] -= quantity;
/*  62 */       this.total -= quantity;
/*     */     }
/*     */     
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   public boolean subtract(SoulType soulType, int quantity) {
/*  69 */     if (this.souls[soulType.ordinal()] >= quantity) {
/*  70 */       this.souls[soulType.ordinal()] -= quantity;
/*  71 */       this.total -= quantity;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public ISoulSet add(ISoulSet costs)
/*     */   {
/*  79 */     SoulType[] soulTypes = SoulType.values();
/*  80 */     for (int i = 0; i < this.souls.length; i++) {
/*  81 */       int quantity = costs.quantityOf(soulTypes[i]);
/*  82 */       this.souls[i] += quantity;
/*  83 */       this.total += quantity;
/*     */     }
/*  85 */     return this;
/*     */   }
/*     */   
/*     */   public void addTo(SoulSet other) {
/*  89 */     SoulType[] soulTypes = SoulType.values();
/*  90 */     for (int i = 0; i < this.souls.length; i++) {
/*  91 */       other.add(soulTypes[i], quantityOf(soulTypes[i]));
/*     */     }
/*     */   }
/*     */   
/*     */   public ISoulSet intersectionWith(ISoulSet soulsIn) {
/*  96 */     SoulSet intersection = new SoulSet();
/*  97 */     for (SoulType soulType : SoulType.values()) {
/*  98 */       intersection.add(soulType, Math.min(soulsIn.quantityOf(soulType), this.souls[soulType.ordinal()]));
/*     */     }
/* 100 */     return intersection;
/*     */   }
/*     */   
/*     */   public boolean contains(ISoulSet costs) {
/* 104 */     SoulType[] soulTypes = SoulType.values();
/* 105 */     for (int i = 0; i < this.souls.length; i++) {
/* 106 */       if (costs.quantityOf(soulTypes[i]) > this.souls[i]) {
/* 107 */         return false;
/*     */       }
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */   
/*     */   public NBTTagCompound toTagCompound() {
/* 114 */     NBTTagCompound compound = new NBTTagCompound();
/* 115 */     for (int i = 0; i < this.souls.length; i++) {
/* 116 */       compound.func_74768_a("soulType" + i, this.souls[i]);
/*     */     }
/* 118 */     return compound;
/*     */   }
/*     */   
/*     */   public static SoulSet fromTagCompound(NBTTagCompound compound) {
/* 122 */     SoulSet set = new SoulSet();
/* 123 */     for (int i = 0; i < set.souls.length; i++) {
/* 124 */       set.souls[i] = compound.func_74762_e("soulType" + i);
/* 125 */       set.total += set.souls[i];
/*     */     }
/* 127 */     return set;
/*     */   }
/*     */   
/*     */   public static SoulSet fromBytes(ByteBuf buf) {
/* 131 */     SoulSet set = new SoulSet();
/* 132 */     for (int i = 0; i < set.souls.length; i++) {
/* 133 */       set.souls[i] = buf.readInt();
/* 134 */       set.total += set.souls[i];
/*     */     }
/* 136 */     return set;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf) {
/* 140 */     for (int i = 0; i < this.souls.length; i++) {
/* 141 */       buf.writeInt(this.souls[i]);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/* 147 */     if ((obj == null) || (getClass() != obj.getClass()))
/* 148 */       return false;
/* 149 */     if (obj == this) {
/* 150 */       return true;
/*     */     }
/* 152 */     return Arrays.equals(this.souls, ((SoulSet)obj).souls);
/*     */   }
/*     */   
/*     */ 
/*     */   public int hashCode()
/*     */   {
/* 158 */     int result = 17;
/* 159 */     for (int i = 0; i < this.souls.length; i++) {
/* 160 */       result = 37 * result + this.souls[i];
/*     */     }
/* 162 */     return result;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 167 */     StringBuilder sb = new StringBuilder();
/* 168 */     for (SoulType soulType : SoulType.values()) {
/* 169 */       if (sb.length() > 0) {
/* 170 */         sb.append(", ");
/*     */       }
/* 172 */       sb.append(soulType.toString());
/* 173 */       sb.append(":");
/* 174 */       sb.append(quantityOf(soulType));
/*     */     }
/* 176 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public Iterator<SoulType> iterator()
/*     */   {
/* 181 */     return new SoulTypeIterator(this, null);
/*     */   }
/*     */   
/*     */   public Iterator<SoulType> iterator(SoulType[] order) {
/* 185 */     return new SoulTypeIterator(this, order);
/*     */   }
/*     */   
/*     */   public int size() {
/* 189 */     return this.total;
/*     */   }
/*     */   
/*     */   public int types()
/*     */   {
/* 194 */     int count = 0;
/* 195 */     for (int i = 0; i < this.souls.length; i++) {
/* 196 */       if (this.souls[i] > 0) {
/* 197 */         count++;
/*     */       }
/*     */     }
/* 200 */     return count;
/*     */   }
/*     */   
/*     */   public int generateColor() {
/* 204 */     SoulType largest = null;
/* 205 */     int l = 0;
/* 206 */     for (SoulType soulType : SoulType.values()) {
/* 207 */       int q = quantityOf(soulType);
/* 208 */       if (q > l) {
/* 209 */         largest = soulType;
/* 210 */         l = q;
/*     */       }
/*     */     }
/*     */     
/* 214 */     return largest != null ? EnumSoulType.fromSoulType(largest).getColor() : 2236962;
/*     */   }
/*     */   
/*     */   public static class SoulTypeIterator implements Iterator<SoulType>
/*     */   {
/*     */     private final SoulSet souls;
/*     */     private final SoulType[] order;
/* 221 */     int position = 0;
/*     */     
/*     */     private SoulTypeIterator(SoulSet souls) {
/* 224 */       this(souls, SoulType.values());
/*     */     }
/*     */     
/*     */     public SoulTypeIterator(SoulSet souls, SoulType[] order) {
/* 228 */       this.souls = souls;
/* 229 */       this.order = order;
/*     */     }
/*     */     
/*     */     public boolean hasNext()
/*     */     {
/* 234 */       return this.position < this.souls.total;
/*     */     }
/*     */     
/*     */     public SoulType next()
/*     */     {
/* 239 */       this.position += 1;
/* 240 */       int total = 0;
/* 241 */       for (SoulType soulType : this.order) {
/* 242 */         total += this.souls.quantityOf(soulType);
/* 243 */         if (this.position <= total) {
/* 244 */           return soulType;
/*     */         }
/*     */       }
/*     */       
/* 248 */       return null;
/*     */     }
/*     */     
/*     */     public void remove() {}
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/SoulSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */