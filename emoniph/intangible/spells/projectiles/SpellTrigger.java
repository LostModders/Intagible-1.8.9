/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.blocks.BlockTrigger;
/*    */ import emoniph.intangible.blocks.BlockTrigger.TileEntityTrigger;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.util.BlockUtil;
/*    */ import emoniph.intangible.util.WorldPos;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellTrigger extends SpellProjectile
/*    */ {
/*    */   public SpellTrigger()
/*    */   {
/* 22 */     super(13056, 8336128);
/*    */   }
/*    */   
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 27 */     World world = spellEntity.field_70170_p;
/* 28 */     if ((!world.field_72995_K) && 
/* 29 */       ((caster instanceof EntityPlayer)) && (movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK)) {
/* 30 */       EntityPlayer player = (EntityPlayer)caster;
/* 31 */       PlayerEx playerEx = PlayerEx.get(player);
/*    */       
/* 33 */       WorldPos triggerPos = playerEx.getTriggerPos();
/* 34 */       if (triggerPos == null)
/*    */       {
/* 36 */         BlockPos pos = movingObject.func_178782_a().func_177972_a(movingObject.field_178784_b);
/* 37 */         if ((spellEntity.field_70170_p.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) && (BlockUtil.canEditBlock(player, world, pos))) {
/* 38 */           world.func_180501_a(pos, Get.blocks().TRIGGER.func_176223_P(), 3);
/* 39 */           playerEx.setTriggerPos(new WorldPos(world, pos));
/* 40 */           Get.blocks().TRIGGER.setOwner(world, pos, player);
/*    */         }
/*    */       } else {
/* 43 */         BlockPos pos = movingObject.func_178782_a();
/* 44 */         IBlockState state = world.func_180495_p(pos);
/* 45 */         if ((state.func_177230_c() == Get.blocks().TRIGGER) && (Get.blocks().TRIGGER.isOwner(world, pos, player)))
/*    */         {
/* 47 */           world.func_175698_g(pos);
/* 48 */           playerEx.setTriggerPos(null);
/*    */         }
/*    */         else {
/* 51 */           World triggerWorld = triggerPos.getWorldServer();
/* 52 */           if (triggerWorld != null) {
/* 53 */             BlockPos triggerBlockPos = triggerPos.asBlockPos();
/* 54 */             IBlockState triggerState = triggerWorld.func_180495_p(triggerBlockPos);
/* 55 */             if (triggerState.func_177230_c() == Get.blocks().TRIGGER) {
/* 56 */               BlockTrigger.TileEntityTrigger tile = (BlockTrigger.TileEntityTrigger)BlockUtil.getTileEntity(triggerWorld, triggerBlockPos, BlockTrigger.TileEntityTrigger.class);
/* 57 */               if (tile != null) {
/* 58 */                 tile.triggerBlock(player, world, new BlockPos(spellEntity));
/*    */               }
/*    */             } else {
/* 61 */               playerEx.setTriggerPos(null);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 68 */       return true;
/*    */     }
/*    */     
/* 71 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */