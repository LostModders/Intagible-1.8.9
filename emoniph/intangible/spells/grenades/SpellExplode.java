/*    */ package emoniph.intangible.spells.grenades;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySpikeBall;
/*    */ 
/*    */ public class SpellExplode extends SpellGrenade
/*    */ {
/*    */   public SpellExplode()
/*    */   {
/*  9 */     super(-1711341517, emoniph.intangible.util.TickUtil.fromSeconds(8));
/*    */   }
/*    */   
/*    */   public boolean explode(EntitySpikeBall spellEntity, net.minecraft.entity.EntityLivingBase caster)
/*    */   {
/* 14 */     spellEntity.field_70170_p.func_72876_a(caster, spellEntity.field_70165_t, spellEntity.field_70163_u, spellEntity.field_70161_v, 3.0F, false);
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/grenades/SpellExplode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */