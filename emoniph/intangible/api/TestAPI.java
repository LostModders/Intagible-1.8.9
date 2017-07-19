/*     */ package emoniph.intangible.api;
/*     */ 
/*     */ import emoniph.intangible.Attack;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class TestAPI implements IClientMod
/*     */ {
/*     */   IModApi api;
/*     */   
/*     */   private class GlowEffect implements IPassiveEffect
/*     */   {
/*     */     public GlowEffect() {}
/*     */     
/*     */     public String getLocalizedName()
/*     */     {
/*  24 */       return null;
/*     */     }
/*     */     
/*     */     public ResourceLocation getHudGlyph()
/*     */     {
/*  29 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void startEffectOn(EntityPlayer player, boolean initialTrigger) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void stopEffectOn(EntityPlayer player) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void onApplyToNearbyEntities(EntityPlayer player, List<Entity> target, ICooldownManager cooldownManager) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void augmentArmorProperties(EntityLivingBase entity, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean requiresClientTimer()
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isChanneling(EntityPlayer entity)
/*     */     {
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onRightClickAir(EntityPlayer player) {}
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     public void onSwing(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void onPostRenderTick(EntityPlayer player) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isPrerequisitesMet(EntityPlayer PLAYER, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet)
/*     */     {
/* 100 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, Attack attack, ICooldownManager cooldownManager) {}
/*     */     
/*     */ 
/*     */ 
/*     */     public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void init(IModApi api)
/*     */   {
/* 116 */     this.api = api;
/*     */     
/* 118 */     IKnol secretPowers = api.registerKnowledge("secret_powers");
/* 119 */     IKnol megaPowers = api.registerKnowledge("mega_powers");
/*     */     
/* 121 */     IPassiveEffect glowEffect = new GlowEffect();
/* 122 */     api.registerPassiveEffect("glow", glowEffect, api.createSoulSet().add(SoulType.BENIGN, 1).add(SoulType.DOOMED, 6));
/* 123 */     api.registerSpell(glowEffect, api.knowledgeOf(new IKnol[] { secretPowers }), api.createSoulSet(), 0, -4, -4);
/* 124 */     api.registerSpell("burn", new ISpell()
/*     */     {
/*     */       public void invoke(EntityPlayer player) {
/* 127 */         player.func_70015_d(3);
/*     */       }
/*     */       
/*     */       public CastingStyle getCastingStyle(EntityPlayer player, boolean defaultIcon)
/*     */       {
/* 132 */         return CastingStyle.INSTANT;
/*     */       }
/*     */       
/*     */       public ISoulSet getMaintainCost()
/*     */       {
/* 137 */         return null;
/*     */       }
/*     */       
/*     */       public boolean arePrerequisitesMet(EntityPlayer player)
/*     */       {
/* 142 */         return false;
/*     */       }
/*     */       
/*     */       public boolean isActive(EntityPlayer player)
/*     */       {
/* 147 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 151 */     }, api.knowledgeOf(new IKnol[] { secretPowers }), api.createSoulSet().add(SoulType.UNHINGED, 1), 100, "Burn Me", -3, -3, new ResourceLocation("fire"));
/*     */     
/* 153 */     IBookPage index = api.createBookIndex("index").title("yourmod:titlepage");
/* 154 */     IBookPage c1 = index.createPage("c1", PageType.CHILD).title("yourmod:chapter1");
/* 155 */     c1.createPage("c1p1", PageType.SIBLING).title("yourmod:c1p1.title").para("yourmod:c1p1.para1").para("yourmod:c1p1.para2");
/* 156 */     c1.createPage("c1p2", PageType.SIBLING).title("yourmod:c1p2.title").para("yourmod:c1p2.para1").image("yourmod:textures/gui/image.png", 30, 30);
/* 157 */     c1.createPage("c1p3", PageType.SIBLING).title("yourmod:c1p3.title").para("yourmod:c1p3.para1");
/*     */     
/* 159 */     IBookPage c2 = index.createPage("c2", PageType.CHILD).title("yourmod:chapter2").knowledge(new IKnol[] { secretPowers });
/* 160 */     IBookPage c2sub1 = index.createPage("c2.1", PageType.CHILD).title("yourmod:chapter2.1");
/* 161 */     c2sub1.createPage("c2.1p1", PageType.SIBLING).title("...");
/* 162 */     c2sub1.createPage("c2.1p2", PageType.SIBLING).title("...");
/*     */     
/* 164 */     IBookPage c2sub2 = index.createPage("c2.2", PageType.CHILD).title("yourmod:chapter2.2");
/*     */     
/* 166 */     IBookPage c3 = index.createPage("c3", PageType.CHILD).title("yourmod:chapter3").knowledge(new IKnol[] { megaPowers });
/* 167 */     c3.createPage("c3p1", PageType.SIBLING).title("yourmod:c3p1.title").para("yourmod:c3p1.para1");
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/api/TestAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */