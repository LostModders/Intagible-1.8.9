/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class WorshipCache
/*     */ {
/*  16 */   private final Map<UUID, WorshipDetails> worshipMap = new HashMap();
/*     */   
/*     */ 
/*     */   public static class WorshipDetails
/*     */   {
/*     */     public int worship;
/*     */     public String name;
/*     */     public ItemStack itemA;
/*     */     public ItemStack itemB;
/*     */     public ItemStack itemC;
/*     */     
/*     */     private WorshipDetails() {}
/*     */     
/*     */     public WorshipDetails(IDeity deity)
/*     */     {
/*  31 */       this.worship = deity.getCurrentWorship();
/*  32 */       this.name = deity.getName();
/*  33 */       this.itemA = deity.getSacredItemA();
/*  34 */       this.itemB = deity.getSacredItemB();
/*  35 */       this.itemC = deity.getSacredItemC();
/*     */     }
/*     */     
/*     */     public boolean equals(Object obj)
/*     */     {
/*  40 */       if ((obj == null) || (obj.getClass() != getClass())) {
/*  41 */         return false;
/*     */       }
/*     */       
/*  44 */       if (obj == this) {
/*  45 */         return true;
/*     */       }
/*     */       
/*  48 */       WorshipDetails other = (WorshipDetails)obj;
/*  49 */       return other.worship == this.worship;
/*     */     }
/*     */     
/*     */     public NBTTagCompound getTagCompound() {
/*  53 */       NBTTagCompound compound = new NBTTagCompound();
/*     */       
/*  55 */       compound.func_74768_a("worship", this.worship);
/*  56 */       compound.func_74778_a("name", this.name);
/*  57 */       compound.func_74782_a("a", this.itemA.func_77955_b(new NBTTagCompound()));
/*  58 */       compound.func_74782_a("b", this.itemB.func_77955_b(new NBTTagCompound()));
/*  59 */       compound.func_74782_a("c", this.itemC.func_77955_b(new NBTTagCompound()));
/*     */       
/*  61 */       return compound;
/*     */     }
/*     */     
/*     */     public static WorshipDetails fromTagCompound(NBTTagCompound compound) {
/*  65 */       WorshipDetails details = new WorshipDetails();
/*  66 */       details.worship = compound.func_74762_e("worship");
/*  67 */       details.name = compound.func_74779_i("name");
/*  68 */       details.itemA = ItemStack.func_77949_a(compound.func_74775_l("a"));
/*  69 */       details.itemB = ItemStack.func_77949_a(compound.func_74775_l("b"));
/*  70 */       details.itemC = ItemStack.func_77949_a(compound.func_74775_l("c"));
/*  71 */       return details;
/*     */     }
/*     */   }
/*     */   
/*     */   public static WorshipCache fromDeities(DeityList deities)
/*     */   {
/*  77 */     WorshipCache cache = new WorshipCache();
/*  78 */     Iterator<IDeity> itr = deities.iterator();
/*  79 */     while (itr.hasNext()) {
/*  80 */       IDeity deity = (IDeity)itr.next();
/*  81 */       cache.worshipMap.put(deity.getId(), new WorshipDetails(deity));
/*     */     }
/*     */     
/*  84 */     return cache;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/*  89 */     if ((obj == null) || (obj.getClass() != getClass())) {
/*  90 */       return false;
/*     */     }
/*     */     
/*  93 */     if (obj == this) {
/*  94 */       return true;
/*     */     }
/*     */     
/*  97 */     WorshipCache other = (WorshipCache)obj;
/*  98 */     if (other.worshipMap.size() != this.worshipMap.size()) {
/*  99 */       return false;
/*     */     }
/* 101 */     Iterator<Map.Entry<UUID, WorshipDetails>> i = this.worshipMap.entrySet().iterator();
/* 102 */     while (i.hasNext()) {
/* 103 */       Map.Entry<UUID, WorshipDetails> e = (Map.Entry)i.next();
/* 104 */       UUID key = (UUID)e.getKey();
/* 105 */       WorshipDetails value = (WorshipDetails)e.getValue();
/* 106 */       if (value == null) {
/* 107 */         if ((other.worshipMap.get(key) != null) || (!other.worshipMap.containsKey(key))) {
/* 108 */           return false;
/*     */         }
/* 110 */       } else if (!value.equals(other.worshipMap.get(key))) {
/* 111 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 115 */     return true;
/*     */   }
/*     */   
/*     */   public NBTTagCompound getTagCompound() {
/* 119 */     NBTTagCompound compound = new NBTTagCompound();
/* 120 */     NBTTagList list = new NBTTagList();
/* 121 */     compound.func_74782_a("list", list);
/*     */     
/* 123 */     for (Map.Entry<UUID, WorshipDetails> entry : this.worshipMap.entrySet()) {
/* 124 */       NBTTagCompound item = new NBTTagCompound();
/* 125 */       item.func_74772_a("msb", ((UUID)entry.getKey()).getMostSignificantBits());
/* 126 */       item.func_74772_a("lsb", ((UUID)entry.getKey()).getLeastSignificantBits());
/* 127 */       item.func_74782_a("w", ((WorshipDetails)entry.getValue()).getTagCompound());
/* 128 */       list.func_74742_a(item);
/*     */     }
/*     */     
/* 131 */     return compound;
/*     */   }
/*     */   
/*     */   public static WorshipCache fromTagCompound(NBTTagCompound compound) {
/* 135 */     WorshipCache cache = new WorshipCache();
/*     */     
/* 137 */     if (compound.func_150297_b("list", 9)) {
/* 138 */       NBTTagList list = compound.func_150295_c("list", 10);
/* 139 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 140 */         NBTTagCompound item = list.func_150305_b(i);
/* 141 */         if ((item.func_150297_b("msb", 4)) && (item.func_150297_b("lsb", 4)) && (item.func_150297_b("w", 10))) {
/* 142 */           UUID id = new UUID(item.func_74763_f("msb"), item.func_74763_f("lsb"));
/* 143 */           cache.worshipMap.put(id, WorshipDetails.fromTagCompound(item.func_74775_l("w")));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 148 */     return cache;
/*     */   }
/*     */   
/*     */   public WorshipDetails getWorshipFor(UUID deityId) {
/* 152 */     if ((this.worshipMap != null) && (this.worshipMap.containsKey(deityId))) {
/* 153 */       return (WorshipDetails)this.worshipMap.get(deityId);
/*     */     }
/* 155 */     return null;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/WorshipCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */