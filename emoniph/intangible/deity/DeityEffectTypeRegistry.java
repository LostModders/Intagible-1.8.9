/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class DeityEffectTypeRegistry<T> implements Iterable<DeityEffectTypeRegistry<T>.EffectEntry>
/*     */ {
/*  14 */   private Map<String, DeityEffectTypeRegistry<T>.EffectEntry> effectsById = new HashMap();
/*  15 */   private Map<T, DeityEffectTypeRegistry<T>.EffectEntry> effectsByInterface = new HashMap();
/*  16 */   private Map<DeityEffectTypeRegistry<T>.ItemStackComparator, DeityEffectTypeRegistry<T>.EffectEntry> effectsBySelector = new HashMap();
/*  17 */   private List<T> effects = new ArrayList();
/*  18 */   private List<DeityEffectTypeRegistry<T>.EffectEntry> effectEntries = new ArrayList();
/*     */   
/*     */   public T getEffectFromIndex(int effectIndex) {
/*  21 */     return (T)((effectIndex >= 0) && (effectIndex < this.effects.size()) ? this.effects.get(effectIndex) : null);
/*     */   }
/*     */   
/*     */   public int getIndexFromEffect(T effect) {
/*  25 */     DeityEffectTypeRegistry<T>.EffectEntry entry = (EffectEntry)this.effectsByInterface.get(effect);
/*  26 */     return (entry != null ? Integer.valueOf(entry.index) : null).intValue();
/*     */   }
/*     */   
/*     */   public String getIdForEffect(T effect) {
/*  30 */     DeityEffectTypeRegistry<T>.EffectEntry entry = (EffectEntry)this.effectsByInterface.get(effect);
/*  31 */     return entry != null ? entry.id : null;
/*     */   }
/*     */   
/*     */   public T getEffectForId(String effectId) {
/*  35 */     DeityEffectTypeRegistry<T>.EffectEntry entry = (EffectEntry)this.effectsById.get(effectId);
/*  36 */     return (T)(entry != null ? entry.effect : null);
/*     */   }
/*     */   
/*     */   public T getEffectForSelector(ItemStack stack) {
/*  40 */     if (stack == null) {
/*  41 */       return null;
/*     */     }
/*  43 */     DeityEffectTypeRegistry<T>.EffectEntry entry = (EffectEntry)this.effectsBySelector.get(new ItemStackComparator(stack, null));
/*  44 */     return (T)(entry != null ? entry.effect : null);
/*     */   }
/*     */   
/*     */   public void addCostsFor(T item, ISoulSet souls)
/*     */   {
/*  49 */     if (item != null) {
/*  50 */       DeityEffectTypeRegistry<T>.EffectEntry entry = (EffectEntry)this.effectsByInterface.get(item);
/*  51 */       if (entry != null) {
/*  52 */         for (emoniph.intangible.api.SoulType soulType : emoniph.intangible.api.SoulType.values()) {
/*  53 */           souls.add(soulType, entry.cost.quantityOf(soulType));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.Iterator<DeityEffectTypeRegistry<T>.EffectEntry> iterator()
/*     */   {
/*  61 */     return this.effectEntries.iterator();
/*     */   }
/*     */   
/*     */   public T getRandom(Random r) {
/*  65 */     return (T)this.effects.get(r.nextInt(this.effects.size()));
/*     */   }
/*     */   
/*     */   public class EffectEntry {
/*     */     private final String id;
/*     */     private final T effect;
/*     */     private final ItemStack selector;
/*     */     private final ISoulSet cost;
/*     */     private final int index;
/*     */     
/*     */     EffectEntry(T id, ItemStack effect, ISoulSet selector, int cost) {
/*  76 */       this.id = id;
/*  77 */       this.effect = effect;
/*  78 */       this.selector = selector;
/*  79 */       this.index = index;
/*  80 */       this.cost = cost;
/*     */     }
/*     */     
/*     */     public ItemStack getSelector() {
/*  84 */       return this.selector;
/*     */     }
/*     */     
/*     */     public ISoulSet getCost() {
/*  88 */       return this.cost;
/*     */     }
/*     */     
/*     */     public String getId() {
/*  92 */       return this.id;
/*     */     }
/*     */   }
/*     */   
/*     */   private class ItemStackComparator {
/*     */     private ItemStack stack;
/*     */     
/*     */     private ItemStackComparator(ItemStack stack) {
/* 100 */       this.stack = stack;
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/* 105 */       int result = 17;
/* 106 */       result = 37 * result + net.minecraft.item.Item.func_150891_b(this.stack.func_77973_b());
/* 107 */       result = 37 * result + this.stack.func_77952_i();
/* 108 */       return result;
/*     */     }
/*     */     
/*     */     public boolean equals(Object obj) {
/* 112 */       if ((obj == null) || (obj.getClass() != getClass())) {
/* 113 */         return false;
/*     */       }
/*     */       
/* 116 */       if (obj == this) {
/* 117 */         return true;
/*     */       }
/*     */       
/* 120 */       DeityEffectTypeRegistry<T>.ItemStackComparator other = (ItemStackComparator)obj;
/* 121 */       return (this.stack.func_77973_b() == other.stack.func_77973_b()) && (this.stack.func_77952_i() == other.stack.func_77952_i());
/*     */     }
/*     */   }
/*     */   
/*     */   public void registerEffect(String id, T effect, ItemStack selector, ISoulSet cost) {
/* 126 */     id = emoniph.intangible.util.ModUtil.withPrefix(id);
/*     */     
/* 128 */     if (!this.effectsById.containsKey(id)) {
/* 129 */       DeityEffectTypeRegistry<T>.EffectEntry registeredEffect = (EffectEntry)this.effectsBySelector.get(new ItemStackComparator(selector, null));
/* 130 */       if (registeredEffect == null) {
/* 131 */         this.effects.add(effect);
/* 132 */         DeityEffectTypeRegistry<T>.EffectEntry entry = new EffectEntry(id, effect, selector, cost, this.effects.size() - 1);
/* 133 */         this.effectsById.put(entry.id, entry);
/* 134 */         this.effectsByInterface.put(entry.effect, entry);
/* 135 */         this.effectsBySelector.put(new ItemStackComparator(selector, null), entry);
/* 136 */         this.effectEntries.add(entry);
/*     */       } else {
/* 138 */         Get.log().warning(String.format("ERROR: Another mod tried to register an effect (id=%s) with the same ItemStack requirement as a registered effect (id=%s), registration skipped.", new Object[] { id, registeredEffect.id }));
/*     */       }
/*     */     } else {
/* 141 */       Get.log().warning(String.format("ERROR: Another mod tried to overwrite the registered deity effect id=%s, registration skipped.", new Object[] { id }));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/DeityEffectTypeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */