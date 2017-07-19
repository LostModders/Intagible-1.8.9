/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.effects.EffectRegistry;
/*    */ import emoniph.intangible.entity.EntityClone;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellMirrorImage extends SpellProjectile
/*    */ {
/*    */   public SpellMirrorImage()
/*    */   {
/* 17 */     super(13141, 3342591);
/*    */   }
/*    */   
/*    */ 
/*    */   public int getMaxAirTicks()
/*    */   {
/* 23 */     return 10;
/*    */   }
/*    */   
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 28 */     if ((!spellEntity.field_70170_p.field_72995_K) && ((caster instanceof EntityPlayerMP)) && (movingObject != null) && (movingObject.field_72313_a != net.minecraft.util.MovingObjectPosition.MovingObjectType.MISS)) {
/* 29 */       EntityPlayerMP player = (EntityPlayerMP)caster;
/*    */       
/* 31 */       if (Get.effects().isActiveFor(Get.effects().OVERCLOCK, player)) {
/* 32 */         EntityClone clone = new EntityClone(player, TickUtil.fromSeconds(10));
/* 33 */         player.field_70170_p.func_72838_d(clone);
/*    */         
/* 35 */         player.field_71135_a.func_175089_a(spellEntity.field_70165_t, spellEntity.field_70163_u, spellEntity.field_70161_v, 180.0F, player.field_70125_A, java.util.EnumSet.of(net.minecraft.network.play.server.S08PacketPlayerPosLook.EnumFlags.Y_ROT));
/* 36 */         if (Get.effects().isActiveFor(Get.effects().UNEXPECTED, player)) {
/* 37 */           clone = new EntityClone(player, TickUtil.fromSeconds(10));
/* 38 */           player.field_70170_p.func_72838_d(clone);
/*    */         }
/*    */       } else {
/* 41 */         EntityClone clone = new EntityClone(player, TickUtil.fromSeconds(10));
/* 42 */         clone.func_70107_b(spellEntity.field_70165_t, spellEntity.field_70163_u, spellEntity.field_70161_v);
/* 43 */         player.field_70170_p.func_72838_d(clone);
/* 44 */         if (Get.effects().isActiveFor(Get.effects().UNEXPECTED, player)) {
/* 45 */           clone = new EntityClone(player, TickUtil.fromSeconds(10));
/* 46 */           player.field_70170_p.func_72838_d(clone);
/*    */         }
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 52 */       return true;
/*    */     }
/* 54 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellMirrorImage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */