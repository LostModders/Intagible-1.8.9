/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ 
/*     */ 
/*     */ public class PriestCooldownManager
/*     */ {
/*  15 */   private final HashMap<ModPriestSpells.PriestSpell, Integer> effectCooldowns = new HashMap();
/*     */   
/*     */   public void setCooldown(ModPriestSpells.PriestSpell effect, int ticks) {
/*  18 */     this.effectCooldowns.put(effect, Integer.valueOf(ticks));
/*     */   }
/*     */   
/*     */   public boolean isCooldownActive(ModPriestSpells.PriestSpell effect) {
/*  22 */     return this.effectCooldowns.containsKey(effect);
/*     */   }
/*     */   
/*     */   public int getRemainingCooldown(ModPriestSpells.PriestSpell spell) {
/*  26 */     Integer cooldown = (Integer)this.effectCooldowns.get(spell);
/*  27 */     return cooldown != null ? cooldown.intValue() : 0;
/*     */   }
/*     */   
/*     */   public boolean tick() {
/*  31 */     boolean changed = false;
/*  32 */     Iterator<Map.Entry<ModPriestSpells.PriestSpell, Integer>> itr = this.effectCooldowns.entrySet().iterator();
/*  33 */     while (itr.hasNext()) {
/*  34 */       Map.Entry<ModPriestSpells.PriestSpell, Integer> entry = (Map.Entry)itr.next();
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
/*  47 */     Set<Map.Entry<ModPriestSpells.PriestSpell, Integer>> entries = this.effectCooldowns.entrySet();
/*  48 */     buf.writeInt(entries.size());
/*  49 */     for (Map.Entry<ModPriestSpells.PriestSpell, Integer> entry : entries) {
/*  50 */       int effectIndex = Get.priest().getIndexFromSpell((ModPriestSpells.PriestSpell)entry.getKey());
/*  51 */       buf.writeInt(effectIndex);
/*  52 */       buf.writeInt(((Integer)entry.getValue()).intValue());
/*     */     }
/*     */   }
/*     */   
/*     */   public static PriestCooldownManager fromBytes(ByteBuf buf) {
/*  57 */     PriestCooldownManager mgr = new PriestCooldownManager();
/*  58 */     int count = buf.readInt();
/*  59 */     for (int i = 0; i < count; i++) {
/*  60 */       int effectId = buf.readInt();
/*  61 */       int ticks = buf.readInt();
/*  62 */       ModPriestSpells.PriestSpell effect = Get.priest().getSpellFromIndex(effectId);
/*  63 */       if (effect != null) {
/*  64 */         mgr.effectCooldowns.put(effect, Integer.valueOf(ticks));
/*     */       }
/*     */     }
/*  67 */     return mgr;
/*     */   }
/*     */   
/*     */   public static PriestCooldownManager fromTagCompound(NBTTagCompound compound) {
/*  71 */     PriestCooldownManager mgr = new PriestCooldownManager();
/*  72 */     NBTTagList list = compound.func_150295_c("list", 10);
/*  73 */     int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/*  74 */       NBTTagCompound item = list.func_150305_b(i);
/*  75 */       if ((item.func_150297_b("spell", 8)) && (item.func_150297_b("ticks", 3))) {
/*  76 */         ModPriestSpells.PriestSpell effect = Get.priest().getSpellForId(item.func_74779_i("spell"));
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
/*  91 */     for (Map.Entry<ModPriestSpells.PriestSpell, Integer> entry : this.effectCooldowns.entrySet()) {
/*  92 */       String effectId = Get.priest().getIdForSpell((ModPriestSpells.PriestSpell)entry.getKey());
/*  93 */       if (effectId != null) {
/*  94 */         NBTTagCompound item = new NBTTagCompound();
/*  95 */         item.func_74778_a("spell", effectId);
/*  96 */         item.func_74768_a("ticks", ((Integer)entry.getValue()).intValue());
/*  97 */         list.func_74742_a(item);
/*     */       }
/*     */     }
/* 100 */     return compound;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/PriestCooldownManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */