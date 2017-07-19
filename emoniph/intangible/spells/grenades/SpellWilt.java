/*    */ package emoniph.intangible.spells.grenades;
/*    */ 
/*    */ import emoniph.intangible.entity.EntitySpikeBall;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.BlockCrops;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class SpellWilt extends SpellGrenade
/*    */ {
/*    */   public SpellWilt()
/*    */   {
/* 16 */     super(1717249024, emoniph.intangible.util.TickUtil.fromSeconds(600));
/*    */   }
/*    */   
/*    */   public boolean explode(EntitySpikeBall spellEntity, EntityLivingBase caster)
/*    */   {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public void tick(EntitySpikeBall spellEntity, EntityLivingBase caster)
/*    */   {
/* 26 */     World world = spellEntity.field_70170_p;
/* 27 */     if (!world.field_72995_K) {
/* 28 */       int tries = 1;
/* 29 */       int range = 8;
/* 30 */       int rangeY = 4;
/* 31 */       BlockPos pos = new BlockPos(spellEntity);
/* 32 */       for (int i = 0; i < tries; i++) {
/* 33 */         int dx = world.field_73012_v.nextInt(range * 2) - range + 1;
/* 34 */         int dz = world.field_73012_v.nextInt(range * 2) - range + 1;
/* 35 */         BlockPos testPos = pos.func_177982_a(dx, world.field_73012_v.nextInt(rangeY * 2) - rangeY + 1, dz);
/* 36 */         IBlockState state = world.func_180495_p(testPos);
/* 37 */         if (((state.func_177230_c() instanceof net.minecraft.block.BlockFlower)) || ((state.func_177230_c() instanceof BlockCrops))) {
/* 38 */           IBlockState below = world.func_180495_p(testPos.func_177977_b());
/* 39 */           if ((below.func_177230_c() == Blocks.field_150458_ak) || (below.func_177230_c() == Blocks.field_150349_c)) {
/* 40 */             world.func_175656_a(testPos, Blocks.field_150346_d.func_176223_P());
/*    */           }
/* 42 */           world.func_175656_a(testPos, Blocks.field_150330_I.func_176223_P());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/grenades/SpellWilt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */