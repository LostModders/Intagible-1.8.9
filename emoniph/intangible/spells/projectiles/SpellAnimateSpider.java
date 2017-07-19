/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import emoniph.intangible.entity.EntitySpiderBlock;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockPistonBase;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellAnimateSpider extends SpellProjectile
/*    */ {
/*    */   public SpellAnimateSpider()
/*    */   {
/* 17 */     super(3364113, 5583667);
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 23 */     if (movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK) {
/* 24 */       World world = spellEntity.field_70170_p;
/* 25 */       if (!world.field_72995_K) {
/* 26 */         BlockPos pos = movingObject.func_178782_a();
/* 27 */         IBlockState state = world.func_180495_p(pos);
/* 28 */         if ((BlockPistonBase.func_180696_a(state.func_177230_c(), world, pos, net.minecraft.util.EnumFacing.UP, false)) && 
/* 29 */           (emoniph.intangible.util.BlockUtil.canEditBlock(caster, world, pos))) {
/* 30 */           world.func_175718_b(2001, pos, Block.func_176210_f(world.func_180495_p(pos)));
/* 31 */           world.func_175698_g(pos);
/* 32 */           EntitySpiderBlock spider = new EntitySpiderBlock(world);
/* 33 */           spider.func_70080_a(pos.func_177958_n() + 0.5D, pos.func_177956_o(), pos.func_177952_p() + 0.5D, 0.0F, 0.0F);
/* 34 */           spider.setOwner(caster);
/* 35 */           spider.setTicksToLive(1200);
/* 36 */           spider.setMaterial(state);
/* 37 */           spider.field_70181_x = 0.6000000238418579D;
/*    */           
/* 39 */           world.func_72838_d(spider);
/*    */         }
/*    */       }
/*    */       
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellAnimateSpider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */