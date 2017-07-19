/*    */ package emoniph.intangible.spells;
/*    */ 
/*    */ import emoniph.intangible.api.CastingStyle;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.souls.SoulSet;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public abstract class Spell implements emoniph.intangible.api.ISpell
/*    */ {
/*    */   private final CastingStyle castingStyle;
/*    */   
/*    */   public Spell(CastingStyle castingStyle)
/*    */   {
/* 14 */     this.castingStyle = castingStyle;
/*    */   }
/*    */   
/*    */   public CastingStyle getCastingStyle(EntityPlayer player, boolean defaultIcon)
/*    */   {
/* 19 */     return this.castingStyle;
/*    */   }
/*    */   
/* 22 */   protected static final SoulSet NONE = new SoulSet();
/*    */   
/*    */   public emoniph.intangible.api.ISoulSet getMaintainCost()
/*    */   {
/* 26 */     return NONE;
/*    */   }
/*    */   
/*    */   public boolean arePrerequisitesMet(EntityPlayer player)
/*    */   {
/* 31 */     return PlayerEx.get(player).isRebellionAvailable(getInitialRebellionCost());
/*    */   }
/*    */   
/*    */   public int getInitialRebellionCost() {
/* 35 */     return 0;
/*    */   }
/*    */   
/*    */   public boolean isActive(EntityPlayer player)
/*    */   {
/* 40 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/Spell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */