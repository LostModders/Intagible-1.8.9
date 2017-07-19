/*    */ package emoniph.intangible.deity.avatar;
/*    */ 
/*    */ import emoniph.intangible.api.IAttack;
/*    */ import emoniph.intangible.api.deity.IAvatar;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.util.CropUtil;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.FoodStats;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class AvatarPowerHarvester implements emoniph.intangible.api.deity.IDeityAvatarPower
/*    */ {
/*    */   public void onAttacking(IAvatar avatar, IAttack attack, Entity target)
/*    */   {
/* 24 */     attack.setDamage(attack.getDamage() + 6.0F);
/*    */   }
/*    */   
/*    */ 
/*    */   public void onHurtBy(IAvatar avatar, IAttack attack) {}
/*    */   
/*    */ 
/*    */   public void onTick(IAvatar avatar)
/*    */   {
/* 33 */     World world = avatar.getAvatarWorld();
/* 34 */     if ((!world.field_72995_K) && (avatar.getAvatarEntity().field_70173_aa % 100 == 0)) {
/* 35 */       java.util.UUID deity = avatar.getDeityId();
/* 36 */       if (deity != null) {
/* 37 */         float RADIUS_W = 8.0F;
/* 38 */         float RADIUS_W_SQ = 16.0F;
/* 39 */         float RADIUS_H = 2.0F;
/* 40 */         java.util.List<EntityPlayer> players = world.func_72872_a(EntityPlayer.class, avatar
/* 41 */           .getAvatarEntity().func_174813_aQ().func_72314_b(8.0D, 2.0D, 8.0D));
/* 42 */         for (EntityPlayer player : players) {
/* 43 */           if (avatar.getAvatarEntity().func_70092_e(player.field_70165_t, avatar.getAvatarEntity().field_70163_u, player.field_70161_v) < 16.0D) {
/* 44 */             PlayerEx playerEx = PlayerEx.get(player);
/* 45 */             switch (playerEx.getWorship().getFollowerLevelOf(avatar.getAvatarWorld(), avatar.getDeityId())) {
/*    */             case 3: 
/* 47 */               player.func_71024_bL().func_75122_a(2, 1.0F);
/*    */             case 2: 
/* 49 */               player.func_71024_bL().func_75122_a(1, 1.0F);
/* 50 */               break;
/*    */             default: 
/* 52 */               player.func_71020_j(1.5F);
/*    */             }
/*    */             
/*    */           }
/*    */         }
/*    */       }
/*    */       
/* 59 */       int k = MathHelper.func_76128_c(avatar.getAvatarEntity().field_70163_u - 1.0D);
/* 60 */       boolean isWaterNear = emoniph.intangible.util.BlockUtil.isBlockNearby(world, new BlockPos(avatar.getAvatarEntity()).func_177977_b(), 5, new Block[] { Blocks.field_150355_j, Blocks.field_150358_i });
/* 61 */       for (int i = 0; i < 4; i++) {
/* 62 */         int j = MathHelper.func_76128_c(avatar.getAvatarEntity().field_70165_t + (i % 2 * 2 - 1) * 0.5F);
/* 63 */         int l = MathHelper.func_76128_c(avatar.getAvatarEntity().field_70161_v + (i / 2 % 2 * 2 - 1) * 0.5F);
/*    */         
/* 65 */         BlockPos pos = new BlockPos(j, k, l);
/* 66 */         IBlockState state = world.func_180495_p(pos);
/* 67 */         IBlockState stateUp = world.func_180495_p(pos.func_177984_a());
/* 68 */         if ((state.func_177230_c() == Blocks.field_150458_ak) && (stateUp.func_177230_c().func_149688_o().func_76222_j()) && (!stateUp.func_177230_c().func_149688_o().func_76224_d())) {
/* 69 */           world.func_175656_a(pos.func_177984_a(), CropUtil.getRandomCrop(world, pos, world.field_73012_v));
/* 70 */         } else if ((isWaterNear) && ((state.func_177230_c() == Blocks.field_150346_d) || (state.func_177230_c() == Blocks.field_150349_c)) && 
/* 71 */           (!stateUp.func_177230_c().func_149688_o().func_76224_d())) {
/* 72 */           world.func_175656_a(pos, Blocks.field_150458_ak.func_176223_P());
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void onDeath(IAvatar avatar, DamageSource cause) {}
/*    */   
/*    */   public void onGive(IAvatar avatar, EntityPlayer player) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/avatar/AvatarPowerHarvester.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */