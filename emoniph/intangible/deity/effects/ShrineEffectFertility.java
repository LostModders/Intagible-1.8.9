/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.IGrowable;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ShrineEffectFertility implements emoniph.intangible.api.deity.IDeityShrineEffect
/*    */ {
/*    */   public void onTick(World world, BlockPos pos, long shrineWorship, IDeity deity)
/*    */   {
/* 16 */     int range = 8;
/* 17 */     int rangeY = 6;
/*    */     
/* 19 */     int tries = 1;
/*    */     
/* 21 */     double rangeSq = range * range;
/*    */     
/* 23 */     for (int i = 0; i < tries; i++) {
/* 24 */       int dx = world.field_73012_v.nextInt(range * 2) - range + 1;
/* 25 */       int dz = world.field_73012_v.nextInt(range * 2) - range + 1;
/* 26 */       if ((dx + 0.5D) * (dz + 0.5D) + (dz + 0.5D) * (dz + 0.5D) < rangeSq) {
/* 27 */         BlockPos testPos = pos.func_177982_a(dx, world.field_73012_v.nextInt(rangeY * 2) - rangeY + 1, dz);
/* 28 */         IBlockState state = world.func_180495_p(testPos);
/* 29 */         if ((state.func_177230_c() instanceof IGrowable)) {
/* 30 */           IGrowable growable = (IGrowable)state.func_177230_c();
/* 31 */           if ((growable.func_176473_a(world, testPos, state, false)) && (growable.func_180670_a(world, world.field_73012_v, testPos, state)) && 
/* 32 */             ((state.func_177230_c() != Blocks.field_150349_c) || (world.field_73012_v.nextInt(5) == 0)) && (state.func_177230_c() != Blocks.field_150329_H)) {
/* 33 */             growable.func_176474_b(world, world.field_73012_v, testPos, state);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 41 */     tries = 0;
/* 42 */     if (shrineWorship > 10L) {
/* 43 */       range = 16;
/* 44 */       tries = 1;
/* 45 */     } else if (shrineWorship > 20L) {
/* 46 */       range = 24;
/* 47 */       tries = 2;
/* 48 */     } else if (shrineWorship > 100L) {
/* 49 */       range = 32;
/* 50 */       tries = 3;
/*    */     }
/*    */     
/* 53 */     rangeSq = range * range;
/*    */     
/* 55 */     for (int i = 0; i < tries; i++) {
/* 56 */       int dx = world.field_73012_v.nextInt(range * 2) - range + 1;
/* 57 */       int dz = world.field_73012_v.nextInt(range * 2) - range + 1;
/* 58 */       if ((dx + 0.5D) * (dz + 0.5D) + (dz + 0.5D) * (dz + 0.5D) < rangeSq) {
/* 59 */         BlockPos testPos = pos.func_177982_a(dx, world.field_73012_v.nextInt(rangeY * 2) - rangeY + 1, dz);
/* 60 */         IBlockState state = world.func_180495_p(testPos);
/* 61 */         if ((state.func_177230_c() instanceof IGrowable)) {
/* 62 */           IGrowable growable = (IGrowable)state.func_177230_c();
/* 63 */           if ((growable.func_176473_a(world, testPos, state, false)) && (growable.func_180670_a(world, world.field_73012_v, testPos, state)) && 
/* 64 */             ((state.func_177230_c() != Blocks.field_150349_c) || (world.field_73012_v.nextInt(5) == 0)) && (state.func_177230_c() != Blocks.field_150329_H)) {
/* 65 */             growable.func_176474_b(world, world.field_73012_v, testPos, state);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void afterWorship(World world, BlockPos pos, EntityPlayer player, long shrineWorship, boolean worshipSucceeded, IDeity deity) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/ShrineEffectFertility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */