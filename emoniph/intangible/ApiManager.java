/*     */ package emoniph.intangible;
/*     */ 
/*     */ import emoniph.intangible.api.ClientModRegistry;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.ILearning;
/*     */ import emoniph.intangible.api.IPassiveEffect;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.ISpell;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.api.deity.IDeityAvatarPower;
/*     */ import emoniph.intangible.api.deity.IDeityMajorWorldEffect;
/*     */ import emoniph.intangible.api.deity.IDeityShrineEffect;
/*     */ import emoniph.intangible.api.deity.IDeityWorshipEffect;
/*     */ import emoniph.intangible.api.golem.IGolemArm;
/*     */ import emoniph.intangible.api.golem.IGolemBody;
/*     */ import emoniph.intangible.api.golem.IGolemHead;
/*     */ import emoniph.intangible.api.golem.IGolemLeg;
/*     */ import emoniph.intangible.deity.ModDeityEffects;
/*     */ import emoniph.intangible.golem.GolemPartRegistry;
/*     */ import emoniph.intangible.golem.GolemPartRegistry.Part;
/*     */ import emoniph.intangible.spells.Spelling;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ 
/*     */ public class ApiManager implements emoniph.intangible.api.IModApi, emoniph.intangible.init.IModService, emoniph.intangible.init.IModInit
/*     */ {
/*     */   public void init(FMLInitializationEvent event)
/*     */   {
/*  31 */     ClientModRegistry.INSTANCE.init(this);
/*     */   }
/*     */   
/*     */   public String getModId()
/*     */   {
/*  36 */     return "intangible";
/*     */   }
/*     */   
/*     */   public emoniph.intangible.api.IPlayerProperties getPropertiesFor(net.minecraft.entity.player.EntityPlayer player)
/*     */   {
/*  41 */     return emoniph.intangible.player.PlayerEx.get(player);
/*     */   }
/*     */   
/*     */   public ISoulSet createSoulSet()
/*     */   {
/*  46 */     return new emoniph.intangible.souls.SoulSet();
/*     */   }
/*     */   
/*     */   public void registerPassiveEffect(String effectId, IPassiveEffect effect, ISoulSet soulSet)
/*     */   {
/*  51 */     Get.effects().registerEffect(effectId, effect, soulSet);
/*     */   }
/*     */   
/*     */   public emoniph.intangible.api.deity.IDeityList getDeitiesForWorld(net.minecraft.world.World world)
/*     */   {
/*  56 */     return Get.deities().forWorld(world);
/*     */   }
/*     */   
/*     */   public void registerDeityEffect(String id, IDeityMajorWorldEffect effect, ItemStack selector, ISoulSet cost)
/*     */   {
/*  61 */     Get.deityEffects().register(id, effect, selector, cost);
/*     */   }
/*     */   
/*     */   public void registerDeityEffect(String id, emoniph.intangible.api.deity.IDeityMinorWorldEffect effect, ItemStack selector, ISoulSet cost)
/*     */   {
/*  66 */     Get.deityEffects().register(id, effect, selector, cost);
/*     */   }
/*     */   
/*     */   public void registerDeityEffect(String id, IDeityWorshipEffect effect, ItemStack selector, ISoulSet cost)
/*     */   {
/*  71 */     Get.deityEffects().register(id, effect, selector, cost);
/*     */   }
/*     */   
/*     */   public void registerDeityEffect(String id, IDeityShrineEffect effect, ItemStack selector, ISoulSet cost)
/*     */   {
/*  76 */     Get.deityEffects().register(id, effect, selector, cost);
/*     */   }
/*     */   
/*     */   public void registerAvatarPower(String id, IDeityAvatarPower effect, ItemStack selector, ISoulSet cost)
/*     */   {
/*  81 */     Get.deityEffects().register(id, effect, selector, cost);
/*     */   }
/*     */   
/*     */   public void registerAvatarBody(String id, emoniph.intangible.api.deity.IDeityAvatarBody body, ItemStack selector, ISoulSet cost)
/*     */   {
/*  86 */     Get.deityEffects().register(id, body, selector, cost);
/*     */   }
/*     */   
/*     */   public void registerEntitySoulType(Class<? extends EntityLiving> entityClass, SoulType soulType, boolean trappableInSoulCage)
/*     */     throws IllegalArgumentException
/*     */   {
/*  92 */     if ((soulType == SoulType.NOBLE) || (soulType == SoulType.MALLEABLE)) {
/*  93 */       throw new IllegalArgumentException("soulType: SoulType.NOBLE and SoulType.MALLEABLE are not available for use outside of the Intangible mod. Mod authors must not use these settings.");
/*     */     }
/*  95 */     Get.souls().register(entityClass, soulType, trappableInSoulCage);
/*     */   }
/*     */   
/*     */   public IKnol registerKnowledge(String id)
/*     */   {
/* 100 */     return Get.knowledge().register(new emoniph.intangible.knowledge.Knol(id));
/*     */   }
/*     */   
/*     */   public ILearning knowledgeOf(IKnol... knols)
/*     */   {
/* 105 */     return emoniph.intangible.knowledge.Learning.of(knols);
/*     */   }
/*     */   
/*     */   public emoniph.intangible.api.IBookPage createBookIndex(String id)
/*     */   {
/* 110 */     return Get.book().createExtensionIndex(id);
/*     */   }
/*     */   
/*     */   public void addStampingRecipe(ItemStack output, ItemStack inputTopLeft, ItemStack inputTopRight, ItemStack inputBottomLeft, ItemStack inputBottomRight)
/*     */   {
/* 115 */     Get.recipes();emoniph.intangible.recipes.ModRecipes.stamping.add(new emoniph.intangible.recipes.StampingRecipe(output, inputTopLeft, inputTopRight, inputBottomLeft, inputBottomRight));
/*     */   }
/*     */   
/*     */   public ISpell registerSpell(String spellId, ISpell spell, ILearning knols, ISoulSet cost, int costCooldown, String localizedName, int iconDefaultX, int iconDefaultY, ResourceLocation iconTexture)
/*     */   {
/* 120 */     return Get.spells().registerSpell(spellId, spell, knols, new Spelling(costCooldown, cost), localizedName, new emoniph.intangible.spells.GridCoord(iconDefaultX, iconDefaultY), iconTexture);
/*     */   }
/*     */   
/*     */   public ISpell registerSpell(IPassiveEffect passiveEffect, ILearning knols, ISoulSet cost, int costCooldown, int iconDefaultX, int iconDefaultY)
/*     */   {
/* 125 */     return Get.spells().registerSpell(passiveEffect, knols, new Spelling(costCooldown, cost), new emoniph.intangible.spells.GridCoord(iconDefaultX, iconDefaultY));
/*     */   }
/*     */   
/*     */   public IGolemArm registerGolemArm(IGolemArm arm, ItemStack item)
/*     */   {
/* 130 */     GolemPartRegistry.Part<IGolemArm> part = Get.golems().register(arm, item);
/* 131 */     return part != null ? (IGolemArm)part.getItem() : null;
/*     */   }
/*     */   
/*     */   public IGolemLeg registerGolemLeg(IGolemLeg leg, ItemStack item)
/*     */   {
/* 136 */     GolemPartRegistry.Part<IGolemLeg> part = Get.golems().register(leg, item);
/* 137 */     return part != null ? (IGolemLeg)part.getItem() : null;
/*     */   }
/*     */   
/*     */   public IGolemBody registerGolemBody(IGolemBody body, ItemStack item)
/*     */   {
/* 142 */     GolemPartRegistry.Part<IGolemBody> part = Get.golems().register(body, item);
/* 143 */     return part != null ? (IGolemBody)part.getItem() : null;
/*     */   }
/*     */   
/*     */   public IGolemHead registerGolemHead(IGolemHead head, ItemStack item)
/*     */   {
/* 148 */     GolemPartRegistry.Part<IGolemHead> part = Get.golems().register(head, item);
/* 149 */     return part != null ? (IGolemHead)part.getItem() : null;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/ApiManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */