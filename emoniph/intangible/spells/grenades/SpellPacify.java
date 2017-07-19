/*    */ package emoniph.intangible.spells.grenades;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.entity.EntitySpikeBall;
/*    */ import emoniph.intangible.fx.ParticleFactory;
/*    */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.souls.ISoulHost;
/*    */ import emoniph.intangible.util.EntityUtil;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.ai.EntityAITasks;
/*    */ 
/*    */ public class SpellPacify extends SpellGrenade
/*    */ {
/*    */   public SpellPacify()
/*    */   {
/* 20 */     super(-1724671591, TickUtil.fromSeconds(4));
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean explode(EntitySpikeBall spellEntity, EntityLivingBase caster)
/*    */   {
/* 26 */     if (!spellEntity.field_70170_p.field_72995_K) {
/* 27 */       net.minecraft.util.Vec3 mid = EntityUtil.vecFromMidOf(spellEntity);
/* 28 */       Get.fx().GLOW.sendToAllNear(spellEntity, 0.5F, 30, 3381555, 3, mid, 0.1F, 16.0D);
/* 29 */       emoniph.intangible.Sound.MOD_RANDOM_PEACE.playToAllNear(spellEntity, 0.5F, 1.0F);
/* 30 */       double radius = 8.0D;
/*    */       
/* 32 */       List<EntityLivingBase> list = spellEntity.field_70170_p.func_72872_a(EntityLivingBase.class, spellEntity.func_174813_aQ().func_72314_b(radius, radius, radius));
/*    */       
/*    */ 
/* 35 */       for (EntityLivingBase entity : list) {
/* 36 */         if (entity.func_70089_S()) {
/* 37 */           if ((entity instanceof net.minecraft.entity.player.EntityPlayer)) {
/* 38 */             PlayerEx.get((net.minecraft.entity.player.EntityPlayer)entity).enableEffectWithCooldown(Get.effects().PACIFIED, TickUtil.fromSeconds(60));
/* 39 */             Get.fx().GLOW.sendToAllNear(entity, 0.5F, 20, this.color, EntityUtil.vecFromMidOf(entity, 0.0D, 2.0D, 0.0D), 0.1F, 16.0D);
/* 40 */           } else if ((entity instanceof EntityLiving)) {
/* 41 */             EntityLiving living = (EntityLiving)entity;
/* 42 */             if (canBePacified(living)) {
/* 43 */               living.field_70715_bh.field_75782_a.clear();
/* 44 */               living.func_70624_b(null);
/* 45 */               living.func_70604_c(null);
/* 46 */               living.getEntityData().func_74757_a("intangible_pacified", true);
/* 47 */               Get.fx().GLOW.sendToAllNear(entity, 0.5F, 20, this.color, EntityUtil.vecFromMidOf(entity, 0.0D, 2.0D, 0.0D), 0.1F, 16.0D);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 54 */     return true;
/*    */   }
/*    */   
/*    */   public static void initPacified(EntityLiving living) {
/* 58 */     if (living.getEntityData().func_74767_n("intangible_pacified")) {
/* 59 */       living.field_70715_bh.field_75782_a.clear();
/* 60 */       living.func_70624_b(null);
/* 61 */       living.func_70604_c(null);
/*    */     }
/*    */   }
/*    */   
/*    */   private static boolean canBePacified(EntityLiving living) {
/* 66 */     if ((living instanceof net.minecraft.entity.boss.IBossDisplayData))
/* 67 */       return false;
/* 68 */     if (((living instanceof ISoulHost)) && (!((ISoulHost)living).isTrappableInBoneCage())) {
/* 69 */       return false;
/*    */     }
/*    */     
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/grenades/SpellPacify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */