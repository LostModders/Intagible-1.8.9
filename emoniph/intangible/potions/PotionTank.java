/*    */ package emoniph.intangible.potions;
/*    */ 
/*    */ import emoniph.intangible.Attack;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.util.DamageSource;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*    */ 
/*    */ public class PotionTank extends Potion
/*    */ {
/*    */   protected PotionTank(ResourceLocation location)
/*    */   {
/* 14 */     super(location, false, 3397632);
/* 15 */     func_76390_b("potion.intangible:tank");
/* 16 */     func_111184_a(net.minecraft.entity.SharedMonsterAttributes.field_111263_d, "233C8D69-F989-474B-85D1-26900825F14A", 0.2D, 2);
/*    */   }
/*    */   
/*    */   public void onHurtBy(PlayerEx playerEx, LivingHurtEvent event, Attack attack) {
/* 20 */     if ((attack.getDamage() > 0.0F) && (playerEx.PLAYER.func_70644_a(this))) {
/* 21 */       if ((event.source.func_76346_g() != null) && ((event.source.func_76346_g() instanceof net.minecraft.entity.EntityLivingBase))) {
/* 22 */         event.source.func_76346_g().func_70097_a(event.source, attack.getDamage());
/*    */       }
/* 24 */       attack.setDamage(0.0F);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/potions/PotionTank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */