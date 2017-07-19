/*    */ package emoniph.intangible.potions;
/*    */ 
/*    */ import emoniph.intangible.capabilities.CapabilityKillTracker;
/*    */ import emoniph.intangible.capabilities.IKillTracker;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.util.EntityDamageSource;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class PotionBloodlust extends Potion
/*    */ {
/*    */   private static final double DAMAGE_BOOST = 4.0D;
/*    */   private static final float SELF_DAMAGE = 4.0F;
/* 19 */   public static final int DEFAULT_DURATION = TickUtil.fromSeconds(300);
/* 20 */   private static final int PULSE_TICKS = TickUtil.fromSeconds(10);
/*    */   private static final int PULSE_MILLISECS = 12000;
/*    */   
/*    */   protected PotionBloodlust(ResourceLocation location) {
/* 24 */     super(location, false, 3342336);
/* 25 */     func_76390_b("potion.intangible:bloodlust");
/* 26 */     func_111184_a(SharedMonsterAttributes.field_111264_e, "9319EA83-C025-44FC-BF11-EEA74100DF6B", 4.0D, 2);
/*    */   }
/*    */   
/*    */   public boolean func_76397_a(int duration, int amplifier)
/*    */   {
/* 31 */     return duration % PULSE_TICKS == 0;
/*    */   }
/*    */   
/*    */   public void func_76394_a(EntityLivingBase entity, int amplifier)
/*    */   {
/* 36 */     if (!entity.field_70170_p.field_72995_K) {
/* 37 */       IKillTracker killTracker = (IKillTracker)entity.getCapability(CapabilityKillTracker.KILL_TRACKER_CAPABILITY, EnumFacing.UP);
/* 38 */       if (killTracker != null) {
/* 39 */         long diff = killTracker.getTicksSinceLastKillFor(entity);
/* 40 */         if (diff > 12000L) {
/* 41 */           if ((entity instanceof EntityPlayer)) {
/* 42 */             entity.func_70097_a(new EntityDamageSource("player", entity).func_76348_h(), 4.0F);
/*    */           } else {
/* 44 */             entity.func_70097_a(new EntityDamageSource("mob", entity).func_76348_h(), 4.0F);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/potions/PotionBloodlust.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */