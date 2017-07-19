/*     */ package emoniph.intangible.effects;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ public class EffectSet implements Iterable<IPassiveEffect>
/*     */ {
/*  16 */   private Set<IPassiveEffect> effects = new HashSet();
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isEmpty()
/*     */   {
/*  22 */     return this.effects.isEmpty();
/*     */   }
/*     */   
/*     */   public void addTo(SoulSet souls) {
/*  26 */     for (IPassiveEffect effect : this.effects) {
/*  27 */       souls.add(Get.effects().getCostsFor(effect));
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean contains(IPassiveEffect newEffect)
/*     */   {
/*  33 */     return this.effects.contains(newEffect);
/*     */   }
/*     */   
/*     */   public void add(IPassiveEffect newEffect) {
/*  37 */     this.effects.add(newEffect);
/*     */   }
/*     */   
/*     */   public void remove(IPassiveEffect effectToRemove) {
/*  41 */     this.effects.remove(effectToRemove);
/*     */   }
/*     */   
/*     */   public static EffectSet fromBytes(ByteBuf buf) {
/*  45 */     EffectSet set = new EffectSet();
/*  46 */     int count = buf.readInt();
/*  47 */     for (int i = 0; i < count; i++) {
/*  48 */       int effectIndex = buf.readInt();
/*  49 */       IPassiveEffect effect = Get.effects().getEffectFromIndex(effectIndex);
/*  50 */       if (effect != null) {
/*  51 */         set.add(effect);
/*     */       }
/*     */     }
/*  54 */     return set;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf) {
/*  58 */     buf.writeInt(this.effects.size());
/*  59 */     for (IPassiveEffect effect : this.effects) {
/*  60 */       int effectIndex = Get.effects().getIndexFromEffect(effect);
/*  61 */       if (effectIndex >= 0) {
/*  62 */         buf.writeInt(effectIndex);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public NBTTagCompound toTagCompound() {
/*  68 */     NBTTagCompound compound = new NBTTagCompound();
/*  69 */     NBTTagList list = new NBTTagList();
/*  70 */     for (IPassiveEffect effect : this.effects) {
/*  71 */       String effectId = Get.effects().getIdForEffect(effect);
/*  72 */       if (effectId != null) {
/*  73 */         list.func_74742_a(new net.minecraft.nbt.NBTTagString(effectId));
/*     */       }
/*     */     }
/*     */     
/*  77 */     compound.func_74782_a("list", list);
/*  78 */     return compound;
/*     */   }
/*     */   
/*     */   public static EffectSet fromTagCompound(NBTTagCompound compound) {
/*  82 */     EffectSet set = new EffectSet();
/*  83 */     NBTTagList list = compound.func_150295_c("list", 8);
/*  84 */     int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/*  85 */       String effectId = list.func_150307_f(i);
/*  86 */       IPassiveEffect effect = Get.effects().getEffectForId(effectId);
/*  87 */       if (effect != null) {
/*  88 */         set.add(effect);
/*     */       }
/*     */     }
/*     */     
/*  92 */     return set;
/*     */   }
/*     */   
/*     */   public Iterator<IPassiveEffect> iterator() {
/*  96 */     return this.effects.iterator();
/*     */   }
/*     */   
/*     */   public void updateClientTimers(HashMap<IPassiveEffect, EffectTimer> clientEffectTimers, EffectSet currentEffects) {
/* 100 */     Set<IPassiveEffect> activeTimers = new HashSet(clientEffectTimers.keySet());
/* 101 */     Set<IPassiveEffect> activeEffects = new HashSet(currentEffects.effects);
/*     */     
/* 103 */     for (IPassiveEffect effect : this.effects) {
/* 104 */       if (effect.requiresClientTimer()) {
/* 105 */         if (!currentEffects.contains(effect)) {
/* 106 */           clientEffectTimers.put(effect, new EffectTimer(30, 0));
/*     */         }
/* 108 */         activeTimers.remove(effect);
/* 109 */         activeEffects.remove(effect);
/*     */       }
/*     */     }
/*     */     
/* 113 */     for (IPassiveEffect effect : activeTimers) {
/* 114 */       if (clientEffectTimers.containsKey(effect)) {
/* 115 */         ((EffectTimer)clientEffectTimers.get(effect)).setLimit(30);
/* 116 */         activeEffects.remove(effect);
/*     */       }
/*     */     }
/*     */     
/* 120 */     for (IPassiveEffect effect : activeEffects) {
/* 121 */       clientEffectTimers.put(effect, new EffectTimer(0, 30));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/EffectSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */