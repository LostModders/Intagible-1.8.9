/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import emoniph.intangible.entity.EntityTool;
/*    */ import emoniph.intangible.util.EntityUtil;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellAnimateTool extends SpellProjectile
/*    */ {
/*    */   public SpellAnimateTool()
/*    */   {
/* 19 */     super(13107, 3342591);
/*    */   }
/*    */   
/*    */   protected int getRebellionIncrease(EntityPlayer player, boolean unexpected, boolean overclocked)
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 30 */     if ((movingObject != null) && (movingObject.field_72313_a != net.minecraft.util.MovingObjectPosition.MovingObjectType.MISS)) {
/* 31 */       if (!spellEntity.field_70170_p.field_72995_K) {
/* 32 */         double r = 2.0D;
/* 33 */         java.util.List<EntityItem> list = spellEntity.field_70170_p.func_72872_a(EntityItem.class, spellEntity
/* 34 */           .func_174813_aQ().func_72314_b(r, r * 0.5D, r));
/* 35 */         EntityItem closest = (EntityItem)EntityUtil.getClosestFrom(list, spellEntity);
/* 36 */         if (closest != null) {
/* 37 */           EntityTool tool = new EntityTool(spellEntity.field_70170_p, closest.func_92059_d()).setTicksToLive(TickUtil.fromSeconds(spellEntity.isBehaviourOverclocked() ? 120 : 60));
/* 38 */           if ((caster instanceof EntityPlayer)) {
/* 39 */             tool.func_152115_b(caster.func_110124_au().toString());
/* 40 */             tool.func_70903_f(true);
/*    */           }
/* 42 */           closest.func_70106_y();
/* 43 */           tool.func_70012_b(spellEntity.field_70165_t, spellEntity.field_70163_u, spellEntity.field_70161_v, 0.0F, 0.0F);
/* 44 */           tool.func_175449_a(new net.minecraft.util.BlockPos(spellEntity), 8);
/* 45 */           if (spellEntity.isBehaviourUnexpected()) {
/* 46 */             if (Math.abs(spellEntity.accelerationX) > Math.abs(spellEntity.accelerationZ)) {
/* 47 */               if (spellEntity.accelerationX > 0.0D) {
/* 48 */                 tool.setDirection(EnumFacing.EAST);
/*    */               } else {
/* 50 */                 tool.setDirection(EnumFacing.WEST);
/*    */               }
/*    */             }
/* 53 */             else if (spellEntity.accelerationZ > 0.0D) {
/* 54 */               tool.setDirection(EnumFacing.SOUTH);
/*    */             } else {
/* 56 */               tool.setDirection(EnumFacing.NORTH);
/*    */             }
/*    */           }
/*    */           else {
/* 60 */             tool.setDirection(null);
/*    */           }
/*    */           
/* 63 */           spellEntity.field_70170_p.func_72838_d(tool);
/*    */         }
/*    */       }
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellAnimateTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */