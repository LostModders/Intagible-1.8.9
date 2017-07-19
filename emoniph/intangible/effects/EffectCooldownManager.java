/*     */ package emoniph.intangible.effects;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ 
/*     */ public class EffectCooldownManager
/*     */   implements ICooldownManager
/*     */ {
/*  18 */   private final HashMap<IPassiveEffect, Integer> effectCooldowns = new HashMap();
/*     */   
/*     */   public void setCooldown(IPassiveEffect effect, int ticks)
/*     */   {
/*  22 */     this.effectCooldowns.put(effect, Integer.valueOf(ticks));
/*     */   }
/*     */   
/*     */   public boolean isCooldownActive(IPassiveEffect effect)
/*     */   {
/*  27 */     return this.effectCooldowns.containsKey(effect);
/*     */   }
/*     */   
/*     */   public boolean tick() {
/*  31 */     boolean changed = false;
/*  32 */     Iterator<Map.Entry<IPassiveEffect, Integer>> itr = this.effectCooldowns.entrySet().iterator();
/*  33 */     while (itr.hasNext()) {
/*  34 */       Map.Entry<IPassiveEffect, Integer> entry = (Map.Entry)itr.next();
/*  35 */       int ticks = ((Integer)entry.getValue()).intValue() - 1;
/*  36 */       if (ticks <= 0) {
/*  37 */         itr.remove();
/*  38 */         changed = true;
/*     */       } else {
/*  40 */         entry.setValue(Integer.valueOf(ticks));
/*     */       }
/*     */     }
/*  43 */     return changed;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf) {
/*  47 */     Set<Map.Entry<IPassiveEffect, Integer>> entries = this.effectCooldowns.entrySet();
/*  48 */     buf.writeInt(entries.size());
/*  49 */     for (Map.Entry<IPassiveEffect, Integer> entry : entries) {
/*  50 */       int effectIndex = Get.effects().getIndexFromEffect((IPassiveEffect)entry.getKey());
/*  51 */       buf.writeInt(effectIndex);
/*  52 */       buf.writeInt(((Integer)entry.getValue()).intValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public static EffectCooldownManager fromBytes(ByteBuf buf) {
/*  57 */     EffectCooldownManager mgr = new EffectCooldownManager();
/*  58 */     int count = buf.readInt();
/*  59 */     for (int i = 0; i < count; i++) {
/*  60 */       int effectId = buf.readInt();
/*  61 */       int ticks = buf.readInt();
/*  62 */       IPassiveEffect effect = Get.effects().getEffectFromIndex(effectId);
/*  63 */       if (effect != null) {
/*  64 */         mgr.effectCooldowns.put(effect, Integer.valueOf(ticks));
/*     */       }
/*     */     }
/*  67 */     return mgr;
/*     */   }
/*     */   
/*     */   public static EffectCooldownManager fromTagCompound(NBTTagCompound compound) {
/*  71 */     EffectCooldownManager mgr = new EffectCooldownManager();
/*  72 */     NBTTagList list = compound.func_150295_c("list", 10);
/*  73 */     int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/*  74 */       NBTTagCompound item = list.func_150305_b(i);
/*  75 */       if ((item.func_150297_b("effect", 8)) && (item.func_150297_b("ticks", 3))) {
/*  76 */         IPassiveEffect effect = Get.effects().getEffectForId(item.func_74779_i("effect"));
/*  77 */         int ticks = item.func_74762_e("ticks");
/*  78 */         if (effect != null) {
/*  79 */           mgr.effectCooldowns.put(effect, Integer.valueOf(ticks));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  84 */     return mgr;
/*     */   }
/*     */   
/*     */   public NBTTagCompound toTagCompound() {
/*  88 */     NBTTagCompound compound = new NBTTagCompound();
/*  89 */     NBTTagList list = new NBTTagList();
/*  90 */     compound.func_74782_a("list", list);
/*  91 */     for (Map.Entry<IPassiveEffect, Integer> entry : this.effectCooldowns.entrySet()) {
/*  92 */       String effectId = Get.effects().getIdForEffect((IPassiveEffect)entry.getKey());
/*  93 */       if (effectId != null) {
/*  94 */         NBTTagCompound item = new NBTTagCompound();
/*  95 */         item.func_74778_a("effect", effectId);
/*  96 */         item.func_74768_a("ticks", ((Integer)entry.getValue()).intValue());
/*  97 */         list.func_74742_a(item);
/*     */       }
/*     */     }
/* 100 */     return compound;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/EffectCooldownManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */