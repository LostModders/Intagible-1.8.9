/*     */ package emoniph.intangible.effects;
/*     */ 
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.effects.passive.SpellStarve;
/*     */ import emoniph.intangible.effects.passive.SpellUnexpected;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.souls.SoulCapacity;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class EffectRegistry implements emoniph.intangible.init.IModService
/*     */ {
/*  19 */   private Map<String, EffectEntry> effectsById = new HashMap();
/*  20 */   private Map<IPassiveEffect, EffectEntry> effectsByInterface = new HashMap();
/*  21 */   private List<IPassiveEffect> effects = new java.util.ArrayList();
/*     */   
/*  23 */   public final IPassiveEffect CLAWS = register("claws", new emoniph.intangible.effects.passive.SpellClaws(), new SoulSet().add(SoulType.PREDATORY, 1));
/*  24 */   public final IPassiveEffect MOMENTUM = register("momentum", new emoniph.intangible.effects.passive.SpellMomentum(), new SoulSet().add(SoulType.IMMUTABLE, 3));
/*  25 */   public final IPassiveEffect TENDRILS = register("tendrils", new emoniph.intangible.effects.passive.SpellTendrils(), new SoulSet().add(SoulType.WISE, 1));
/*  26 */   public final IPassiveEffect ARMOR = register("armor", new emoniph.intangible.effects.passive.SpellArmor(), new SoulSet().add(SoulType.IMMUTABLE, 1));
/*  27 */   public final IPassiveEffect SHIELD = register("shield", new emoniph.intangible.effects.passive.SpellShield(), new SoulSet().add(SoulType.IMMUTABLE, 1).add(SoulType.MALLEABLE, 1));
/*  28 */   public final IPassiveEffect WINGS = register("wings", new emoniph.intangible.effects.passive.SpellWings(), new SoulSet().add(SoulType.NOBLE, 3));
/*  29 */   public final IPassiveEffect PROC_BURN = register("procburn", new emoniph.intangible.effects.passive.SpellProcBurn(), new SoulSet().add(SoulType.UNHINGED, 2));
/*  30 */   public final IPassiveEffect PROC_LAUNCH = register("proclaunch", new emoniph.intangible.effects.passive.SpellProcLaunch(), new SoulSet().add(SoulType.NOBLE, 2));
/*  31 */   public final IPassiveEffect REPAIR = register("repair", new emoniph.intangible.effects.passive.SpellRepair(), new SoulSet().add(SoulType.BENIGN, 1));
/*  32 */   public final IPassiveEffect DIG = register("dig", new emoniph.intangible.effects.passive.SpellDig(), new SoulSet().add(SoulType.MALLEABLE, 3));
/*  33 */   public final IPassiveEffect PLACE = register("place", new emoniph.intangible.effects.passive.SpellPlace(), new SoulSet().add(SoulType.MALLEABLE, 1).add(SoulType.WISE, 2));
/*  34 */   public final IPassiveEffect VISION = register("vision", new emoniph.intangible.effects.passive.SpellVision(), new SoulSet().add(SoulType.WISE, 1));
/*  35 */   public final IPassiveEffect SWIPE = register("swipe", new emoniph.intangible.effects.passive.SpellSonicSwipe(), new SoulSet().add(SoulType.IMMUTABLE, 1));
/*     */   
/*  37 */   public final IPassiveEffect INCORPOREAL = register("incorporeal", new emoniph.intangible.effects.passive.EffectIncorporeal(), new SoulSet(), 50);
/*  38 */   public final IPassiveEffect OVERCLOCK = register("overclock", new emoniph.intangible.effects.passive.SpellOverclock(), new SoulSet().add(SoulType.MALLEABLE, 1));
/*  39 */   public final IPassiveEffect UNEXPECTED = register("unexpected", new SpellUnexpected(), new SoulSet().add(SoulType.UNHINGED, 3));
/*  40 */   public final IPassiveEffect PUSH = register("push", new emoniph.intangible.effects.passive.SpellPush(), new SoulSet().add(SoulType.BENIGN, 2));
/*     */   
/*  42 */   public final IPassiveEffect SLOWFALL = register("slowfall", new emoniph.intangible.effects.passive.SpellSlowfall(), new SoulSet());
/*  43 */   public final IPassiveEffect STRENGTH = register("strength", new emoniph.intangible.effects.passive.SpellStrength(), new SoulSet().add(SoulType.PREDATORY, 1));
/*     */   
/*  45 */   public final IPassiveEffect PROC_HEAL = register("procheal", new emoniph.intangible.effects.passive.SpellProcHeal(), new SoulSet().add(SoulType.BENIGN, 2));
/*  46 */   public final IPassiveEffect PROC_DODGE = register("procdodge", new emoniph.intangible.effects.passive.SpellProcDodge(), new SoulSet().add(SoulType.IMMUTABLE, 2));
/*  47 */   public final IPassiveEffect PROC_CLONE = register("procclone", new emoniph.intangible.effects.passive.SpellProcClone(), new SoulSet().add(SoulType.MALLEABLE, 2));
/*  48 */   public final IPassiveEffect PROC_REAPER = register("procreaper", new emoniph.intangible.effects.passive.SpellProcReaper(), new SoulSet().add(SoulType.DOOMED, 2));
/*     */   
/*  50 */   public final IPassiveEffect PACIFIED = register("pacified", new emoniph.intangible.effects.passive.SpellPacified(), new SoulSet());
/*  51 */   public final IPassiveEffect CHARGED = register("charged", new emoniph.intangible.effects.passive.SpellCharged(), new SoulSet().add(SoulType.DOOMED, 1));
/*  52 */   public final IPassiveEffect CLOUD_WALK = register("cloudwalk", new emoniph.intangible.effects.passive.SpellCloudWalk(), new SoulSet().add(SoulType.NOBLE, 2));
/*     */   
/*  54 */   public final IPassiveEffect COWARD = register("coward", new emoniph.intangible.effects.passive.SpellCoward(), new SoulSet());
/*  55 */   public final IPassiveEffect STARVING = register("starving", new SpellStarve(), new SoulSet());
/*     */   
/*     */   private <T extends IPassiveEffect> T register(String id, T passiveEffect, ISoulSet cost)
/*     */   {
/*  59 */     return register(id, passiveEffect, cost, 0);
/*     */   }
/*     */   
/*     */   private <T extends IPassiveEffect> T register(String id, T passiveEffect, ISoulSet cost, int initialRebellion) {
/*  63 */     registerEffect(id, passiveEffect, cost, initialRebellion);
/*  64 */     return passiveEffect;
/*     */   }
/*     */   
/*     */   public boolean isIncorporeal(EntityLivingBase entity) {
/*  68 */     return isActiveFor(emoniph.intangible.Get.effects().INCORPOREAL, entity);
/*     */   }
/*     */   
/*     */   public boolean tryDeductCostsFor(IPassiveEffect effect, SoulCapacity capacity) {
/*  72 */     EffectEntry entry = (EffectEntry)this.effectsByInterface.get(effect);
/*  73 */     if (entry == null) {
/*  74 */       return false;
/*     */     }
/*     */     
/*  77 */     return (capacity.contains(entry.cost)) && (capacity.deduct(entry.cost.size()) >= 0);
/*     */   }
/*     */   
/*     */   public boolean tryDeductCostsFor(IPassiveEffect effect, SoulSet capacity) {
/*  81 */     EffectEntry entry = (EffectEntry)this.effectsByInterface.get(effect);
/*  82 */     if (entry == null) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     return capacity.trySubtract(entry.cost);
/*     */   }
/*     */   
/*     */   public void tryReplenishCostsFor(IPassiveEffect effect, SoulSet souls) {
/*  90 */     EffectEntry entry = (EffectEntry)this.effectsByInterface.get(effect);
/*  91 */     if (entry == null) {
/*  92 */       return;
/*     */     }
/*     */     
/*  95 */     souls.add(entry.cost);
/*     */   }
/*     */   
/*     */   public IPassiveEffect getEffectFromIndex(int effectIndex) {
/*  99 */     return (effectIndex >= 0) && (effectIndex < this.effects.size()) ? (IPassiveEffect)this.effects.get(effectIndex) : null;
/*     */   }
/*     */   
/*     */   public int getIndexFromEffect(IPassiveEffect effect) {
/* 103 */     EffectEntry entry = (EffectEntry)this.effectsByInterface.get(effect);
/* 104 */     return entry != null ? entry.index : -1;
/*     */   }
/*     */   
/*     */   public String getIdForEffect(IPassiveEffect effect) {
/* 108 */     EffectEntry entry = (EffectEntry)this.effectsByInterface.get(effect);
/* 109 */     return entry != null ? entry.id : null;
/*     */   }
/*     */   
/*     */   public IPassiveEffect getEffectForId(String effectId) {
/* 113 */     EffectEntry entry = (EffectEntry)this.effectsById.get(effectId);
/* 114 */     return entry != null ? entry.effect : null;
/*     */   }
/*     */   
/*     */   public boolean isActiveFor(IPassiveEffect effect, EntityLivingBase entity) {
/* 118 */     if ((entity instanceof EntityPlayer)) {
/* 119 */       PlayerEx playerEx = PlayerEx.get((EntityPlayer)entity);
/* 120 */       return (playerEx.getActiveEffects().contains(effect)) || (playerEx.getClientEffectTimers().containsKey(effect));
/*     */     }
/* 122 */     return false;
/*     */   }
/*     */   
/*     */   public ISoulSet getCostsFor(IPassiveEffect effect) {
/* 126 */     return ((EffectEntry)this.effectsByInterface.get(effect)).cost;
/*     */   }
/*     */   
/*     */   public int getInitialRebellionCostsFor(IPassiveEffect passiveEffect) {
/* 130 */     return ((EffectEntry)this.effectsByInterface.get(passiveEffect)).initialRebellion;
/*     */   }
/*     */   
/*     */   private static class EffectEntry
/*     */   {
/*     */     private final String id;
/*     */     private final IPassiveEffect effect;
/*     */     private final ISoulSet cost;
/*     */     private final int initialRebellion;
/*     */     private final int index;
/*     */     
/*     */     EffectEntry(String id, IPassiveEffect effect, ISoulSet cost, int initialRebellion, int index)
/*     */     {
/* 143 */       this.id = id;
/* 144 */       this.effect = effect;
/* 145 */       this.cost = cost;
/* 146 */       this.index = index;
/* 147 */       this.initialRebellion = initialRebellion;
/*     */     }
/*     */   }
/*     */   
/*     */   public void registerEffect(String id, IPassiveEffect effect, ISoulSet cost) {
/* 152 */     registerEffect(id, effect, cost, 0);
/*     */   }
/*     */   
/*     */   public void registerEffect(String id, IPassiveEffect effect, ISoulSet cost, int initialRebellion) {
/* 156 */     id = emoniph.intangible.util.ModUtil.withPrefix(id);
/*     */     
/* 158 */     if (!this.effectsById.containsKey(id)) {
/* 159 */       this.effects.add(effect);
/* 160 */       EffectEntry entry = new EffectEntry(id, effect, cost, initialRebellion, this.effects.size() - 1);
/* 161 */       this.effectsById.put(entry.id, entry);
/* 162 */       this.effectsByInterface.put(entry.effect, entry);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/EffectRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */