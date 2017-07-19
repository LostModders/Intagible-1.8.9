/*    */ package emoniph.intangible.deity.avatar;
/*    */ 
/*    */ import emoniph.intangible.api.IAttack;
/*    */ import emoniph.intangible.api.deity.IAvatar;
/*    */ import emoniph.intangible.deity.IPlayerWorship;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.potion.PotionEffect;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class AvatarPowerWarrior implements emoniph.intangible.api.deity.IDeityAvatarPower
/*    */ {
/*    */   public void onAttacking(IAvatar avatar, IAttack attack, Entity target)
/*    */   {
/* 23 */     attack.setDamage(attack.getDamage() + 6.0F);
/*    */   }
/*    */   
/*    */   public void onHurtBy(IAvatar avatar, IAttack attack)
/*    */   {
/* 28 */     if ((attack.getDamageSource().func_76346_g() instanceof EntityLivingBase)) {
/* 29 */       EntityLivingBase entity = (EntityLivingBase)attack.getDamageSource().func_76346_g();
/* 30 */       ItemStack stack = entity.func_70694_bm();
/* 31 */       if ((stack != null) && (stack.func_77948_v())) {
/* 32 */         return;
/*    */       }
/*    */     }
/*    */     
/* 36 */     attack.setDamage(0.0F);
/*    */   }
/*    */   
/*    */   public void onTick(IAvatar avatar)
/*    */   {
/* 41 */     World world = avatar.getAvatarWorld();
/* 42 */     if ((!world.field_72995_K) && (avatar.getAvatarEntity().field_70173_aa % 100 == 0)) {
/* 43 */       UUID deity = avatar.getDeityId();
/* 44 */       if (deity != null) {
/* 45 */         float RADIUS_W = 8.0F;
/* 46 */         float RADIUS_W_SQ = 16.0F;
/* 47 */         float RADIUS_H = 2.0F;
/* 48 */         java.util.List<EntityPlayer> players = world.func_72872_a(EntityPlayer.class, avatar
/* 49 */           .getAvatarEntity().func_174813_aQ().func_72314_b(8.0D, 2.0D, 8.0D));
/* 50 */         for (EntityPlayer player : players) {
/* 51 */           if (avatar.getAvatarEntity().func_70092_e(player.field_70165_t, avatar.getAvatarEntity().field_70163_u, player.field_70161_v) < 16.0D) {
/* 52 */             PlayerEx playerEx = PlayerEx.get(player);
/* 53 */             switch (playerEx.getWorship().getFollowerLevelOf(avatar.getAvatarWorld(), avatar.getDeityId())) {
/*    */             case 3: 
/* 55 */               player.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, TickUtil.fromSeconds(6), 1));
/*    */             case 2: 
/* 57 */               player.func_70690_d(new PotionEffect(Potion.field_76420_g.field_76415_H, TickUtil.fromSeconds(6), 0));
/*    */             }
/*    */             
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onDeath(IAvatar avatar, DamageSource cause)
/*    */   {
/* 70 */     World world = avatar.getAvatarWorld();
/* 71 */     UUID deity; if (!world.field_72995_K) {
/* 72 */       deity = avatar.getDeityId();
/* 73 */       if (deity != null) {
/* 74 */         for (Object playerObj : world.field_73010_i) {
/* 75 */           EntityPlayer player = (EntityPlayer)playerObj;
/* 76 */           if (!PlayerEx.get(player).getWorship().isFollowerOf(world, deity)) {
/* 77 */             player.func_70097_a(DamageSource.func_76358_a(avatar.getAvatarEntity()).func_82726_p(), 6.0F);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void onGive(IAvatar avatar, EntityPlayer player) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/avatar/AvatarPowerWarrior.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */