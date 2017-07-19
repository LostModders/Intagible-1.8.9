/*    */ package emoniph.intangible.spells.anchors;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.effects.EffectRegistry;
/*    */ import emoniph.intangible.entity.EntitySpellAnchor;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class SpellGravityWell
/*    */   extends SpellAnchor
/*    */ {
/* 16 */   public SpellGravityWell() { super(4473975, 10061977); }
/*    */   
/*    */   public boolean update(EntitySpellAnchor anchor, List<EntityLivingBase> linked) {
/*    */     float radiusSq;
/*    */     boolean unexpected;
/* 21 */     if (anchor.field_70173_aa % 5 == 0) {
/* 22 */       boolean overclocked = Get.effects().isActiveFor(Get.effects().OVERCLOCK, anchor.shootingEntity);
/* 23 */       float radius = overclocked ? 16.0F : 8.0F;
/* 24 */       List<Entity> list = anchor.field_70170_p.func_72872_a(Entity.class, anchor.func_174813_aQ().func_72314_b(radius, radius, radius));
/* 25 */       if (list.size() > 0) {
/* 26 */         radiusSq = radius * radius;
/* 27 */         unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, anchor.shootingEntity);
/* 28 */         for (Entity entity : list) {
/* 29 */           if ((entity != anchor) && (entity.func_70089_S())) {
/* 30 */             double dSq = entity.func_70068_e(anchor);
/* 31 */             if (dSq < radiusSq) {
/* 32 */               double dx = anchor.field_70165_t - entity.field_70165_t;
/* 33 */               double dy = anchor.field_70163_u - entity.field_70163_u;
/* 34 */               double dz = anchor.field_70161_v - entity.field_70161_v;
/* 35 */               float f = net.minecraft.util.MathHelper.func_76133_a(dx * dx + dy * dy + dz * dz);
/* 36 */               double d0 = (anchor.field_70165_t - entity.field_70165_t) / f;
/* 37 */               double d1 = (anchor.field_70163_u - entity.field_70163_u) / f;
/* 38 */               double d2 = (anchor.field_70161_v - entity.field_70161_v) / f;
/* 39 */               double speed = f * 0.25D;
/* 40 */               double mx = d0 * Math.abs(d0) * speed;
/* 41 */               double my = d1 * Math.abs(d1) * speed;
/* 42 */               double mz = d2 * Math.abs(d2) * speed;
/* 43 */               if ((unexpected) && (dSq < 0.5D) && ((entity instanceof EntityLivingBase))) {
/* 44 */                 EntityLivingBase living = (EntityLivingBase)entity;
/* 45 */                 living.func_70097_a(net.minecraft.util.DamageSource.func_76354_b(anchor, anchor.shootingEntity), 1.0F);
/*    */               }
/* 47 */               if ((entity instanceof EntityPlayer)) {
/* 48 */                 EntityPlayer player = (EntityPlayer)entity;
/*    */                 
/* 50 */                 PlayerEx playerEx = PlayerEx.get(player);
/* 51 */                 playerEx.enableEffectWithCooldown(Get.effects().SLOWFALL, 100);
/*    */                 
/* 53 */                 Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(player, mx, my, mz, true), player);
/*    */               } else {
/* 55 */                 entity.field_70159_w += mx;
/* 56 */                 entity.field_70181_x += my;
/* 57 */                 entity.field_70179_y += mz;
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 65 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/anchors/SpellGravityWell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */