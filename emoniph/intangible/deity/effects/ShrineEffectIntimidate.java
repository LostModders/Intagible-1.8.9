/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.deity.IPlayerWorship;
/*    */ import emoniph.intangible.network.PacketPipeline;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ShrineEffectIntimidate implements emoniph.intangible.api.deity.IDeityShrineEffect
/*    */ {
/*    */   public void onTick(World world, BlockPos pos, long shrineWorship, IDeity deity)
/*    */   {
/* 19 */     if ((world.field_72995_K) || (world.func_82737_E() % 4L != 0L)) {
/* 20 */       return;
/*    */     }
/*    */     
/* 23 */     int range = 4;
/* 24 */     if (shrineWorship > 10L) {
/* 25 */       range = 8;
/* 26 */     } else if (shrineWorship > 20L) {
/* 27 */       range = 16;
/* 28 */     } else if (shrineWorship > 100L) {
/* 29 */       range = 24;
/*    */     }
/*    */     
/* 32 */     double rangeSq = range * range;
/*    */     
/* 34 */     java.util.List<EntityLivingBase> entities = world.func_72872_a(EntityLivingBase.class, new AxisAlignedBB(pos.func_177982_a(-range, -range, -range), pos.func_177982_a(range + 1, range + 1, range + 1)));
/*    */     
/* 36 */     for (EntityLivingBase target : entities) {
/* 37 */       if (target.func_174818_b(pos) < rangeSq) {
/* 38 */         double force = isValidTarget(world, deity, 1, target);
/* 39 */         if (force != 0.0D) {
/* 40 */           Vec3 vec = new Vec3(target.field_70165_t - pos.func_177958_n() + 0.5D, target.field_70163_u - pos.func_177956_o() + 0.5D, target.field_70161_v - pos.func_177952_p() + 0.5D).func_72432_b();
/* 41 */           double speed = force;
/* 42 */           double dx = vec.field_72450_a * speed;
/* 43 */           double dy = 0.05D;
/* 44 */           double dz = vec.field_72449_c * speed;
/* 45 */           if ((target instanceof EntityPlayer)) {
/* 46 */             EntityPlayer otherPlayer = (EntityPlayer)target;
/* 47 */             Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(otherPlayer, dx, dy, dz), otherPlayer);
/*    */           } else {
/* 49 */             target.field_70159_w = dx;
/* 50 */             target.field_70181_x = dy;
/* 51 */             target.field_70179_y = dz;
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   public void afterWorship(World world, BlockPos pos, EntityPlayer player, long shrineWorship, boolean worshipSucceeded, IDeity deity) {}
/*    */   
/*    */ 
/*    */   private static double isValidTarget(World world, IDeity deity, int requiredWorship, EntityLivingBase target)
/*    */   {
/* 64 */     if (!target.func_70104_M())
/* 65 */       return 0.0D;
/* 66 */     if ((target instanceof EntityPlayer)) {
/* 67 */       EntityPlayer player = (EntityPlayer)target;
/* 68 */       PlayerEx playerEx = PlayerEx.get(player);
/* 69 */       if (playerEx.getWorship().isDevoutFollowerOf(world, deity))
/* 70 */         return 0.0D;
/* 71 */       if (playerEx.getWorship().isMostWorshippedDeity(world, deity)) {
/* 72 */         return playerEx.getWorship().isWorshipEqualOrGreaterThan(world, deity, 5) ? 0.0D : 0.15D;
/*    */       }
/* 74 */     } else if (target.func_70662_br()) {
/* 75 */       return 0.0D;
/*    */     }
/* 77 */     return 0.5D;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/ShrineEffectIntimidate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */