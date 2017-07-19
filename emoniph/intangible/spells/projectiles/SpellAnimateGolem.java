/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityEarthGolem;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import emoniph.intangible.entity.GolemMaterial;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellAnimateGolem extends SpellProjectile
/*    */ {
/*    */   public SpellAnimateGolem()
/*    */   {
/* 18 */     super(3342353, 3355443);
/*    */   }
/*    */   
/*    */   public boolean impact(EntitySpell spellEntity, MovingObjectPosition movingObject, EntityLivingBase caster)
/*    */   {
/* 23 */     if (movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK) {
/* 24 */       if (!spellEntity.field_70170_p.field_72995_K) {
/* 25 */         World world = spellEntity.func_130014_f_();
/*    */         
/* 27 */         BlockPos center = movingObject.func_178782_a();
/*    */         double spawnY;
/*    */         BlockPos left;
/*    */         BlockPos right;
/*    */         EnumFacing hface;
/* 32 */         BlockPos[] poses; double spawnY; if (movingObject.field_178784_b == EnumFacing.UP) {
/* 33 */           int i = MathHelper.func_76128_c(caster.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/* 34 */           EnumFacing hface = EnumFacing.func_176731_b(i).func_176734_d();
/* 35 */           BlockPos mid = center.func_177972_a(EnumFacing.DOWN);
/* 36 */           BlockPos left = mid.func_177972_a(hface.func_176746_e());
/* 37 */           BlockPos right = mid.func_177972_a(hface.func_176735_f());
/*    */           
/*    */ 
/* 40 */           BlockPos[] poses = {center.func_177977_b(), center, center.func_177978_c(), center.func_177968_d(), center.func_177974_f(), center.func_177976_e(), center.func_177982_a(1, 0, 1), center.func_177982_a(1, 0, -1), center.func_177982_a(-1, 0, 1), center.func_177982_a(-1, 0, -1) };
/*    */           
/* 42 */           spawnY = mid.func_177956_o(); } else { double spawnY;
/* 43 */           if (movingObject.field_178784_b == EnumFacing.DOWN) {
/* 44 */             int i = MathHelper.func_76128_c(caster.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/* 45 */             EnumFacing hface = EnumFacing.func_176731_b(i).func_176734_d();
/* 46 */             BlockPos mid = center.func_177972_a(EnumFacing.UP);
/* 47 */             left = mid.func_177972_a(hface.func_176746_e());
/* 48 */             right = mid.func_177972_a(hface.func_176735_f());
/*    */             
/*    */ 
/*    */ 
/* 52 */             BlockPos[] poses = {left.func_177972_a(EnumFacing.UP), left, left.func_177972_a(EnumFacing.DOWN), mid.func_177972_a(EnumFacing.UP), mid, mid.func_177972_a(EnumFacing.DOWN), right.func_177972_a(EnumFacing.UP), right, right.func_177972_a(EnumFacing.DOWN) };
/*    */             
/* 54 */             spawnY = center.func_177956_o();
/*    */           } else {
/* 56 */             hface = movingObject.field_178784_b;
/* 57 */             BlockPos left = center.func_177972_a(hface.func_176746_e());
/* 58 */             BlockPos right = center.func_177972_a(hface.func_176735_f());
/*    */             
/*    */ 
/*    */ 
/* 62 */             poses = new BlockPos[] {left.func_177972_a(EnumFacing.UP), left, left.func_177972_a(EnumFacing.DOWN), center.func_177972_a(EnumFacing.UP), center, center.func_177972_a(EnumFacing.DOWN), right.func_177972_a(EnumFacing.UP), right, right.func_177972_a(EnumFacing.DOWN) };
/*    */             
/* 64 */             spawnY = center.func_177977_b().func_177956_o();
/*    */           }
/*    */         }
/* 67 */         IBlockState centerState = world.func_180495_p(center);
/* 68 */         if (GolemMaterial.fromBlockState(centerState) != null) {
/* 69 */           int found = 0;
/* 70 */           left = poses;right = left.length; for (BlockPos localBlockPos1 = 0; localBlockPos1 < right; localBlockPos1++) { BlockPos pos = left[localBlockPos1];
/* 71 */             IBlockState state = world.func_180495_p(pos);
/* 72 */             if ((GolemMaterial.fromBlockState(state) != null) && 
/* 73 */               (emoniph.intangible.util.BlockUtil.canEditBlock(caster, spellEntity.field_70170_p, pos))) {
/* 74 */               found++;
/*    */             }
/*    */           }
/*    */           
/* 78 */           if (found >= 5) {
/* 79 */             left = poses;right = left.length; for (BlockPos localBlockPos2 = 0; localBlockPos2 < right; localBlockPos2++) { BlockPos pos = left[localBlockPos2];
/* 80 */               world.func_175718_b(2001, pos, net.minecraft.block.Block.func_176210_f(world.func_180495_p(pos)));
/* 81 */               world.func_175698_g(pos);
/*    */             }
/* 83 */             EntityEarthGolem golem = new EntityEarthGolem(world);
/* 84 */             BlockPos forward = center.func_177972_a(movingObject.field_178784_b);
/* 85 */             BlockPos offset = forward.func_177982_a(-center.func_177958_n(), -center.func_177956_o(), -center.func_177952_p());
/* 86 */             golem.func_70080_a(center.func_177958_n() + 0.5D + 0.4D * offset.func_177958_n(), spawnY, center.func_177952_p() + 0.5D + 0.4D * offset.func_177952_p(), hface.func_176736_b() * 90, 0.0F);
/* 87 */             golem.setOwner(caster);
/* 88 */             golem.setTicksToLive(1200);
/* 89 */             golem.setMaterial(GolemMaterial.fromBlockState(centerState));
/* 90 */             if (!world.field_72995_K) {
/* 91 */               world.func_72838_d(golem);
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 97 */       return true;
/*    */     }
/* 99 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellAnimateGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */