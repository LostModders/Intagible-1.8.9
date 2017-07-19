/*    */ package emoniph.intangible.potions;
/*    */ 
/*    */ import com.google.common.base.Predicate;
/*    */ import emoniph.intangible.util.EntityUtil;
/*    */ import java.util.List;
/*    */ import javax.annotation.Nullable;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.potion.Potion;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PotionCowardly
/*    */   extends Potion
/*    */ {
/*    */   protected PotionCowardly(ResourceLocation location)
/*    */   {
/* 23 */     super(location, false, 16766976);
/* 24 */     func_76390_b("potion.intangible:cowardly");
/*    */   }
/*    */   
/*    */   public boolean func_76397_a(int duration, int amplifier)
/*    */   {
/* 29 */     return duration % 4 == 0;
/*    */   }
/*    */   
/*    */   public void func_76394_a(final EntityLivingBase entity, int amplifier)
/*    */   {
/* 34 */     if ((entity.field_70170_p.field_72995_K) && (!(entity instanceof EntityPlayer)))
/* 35 */       return;
/* 36 */     if ((!entity.field_70170_p.field_72995_K) && ((entity instanceof EntityPlayer))) {
/* 37 */       return;
/*    */     }
/*    */     
/* 40 */     double range = 8.0D + amplifier * 2.0D;
/* 41 */     List<EntityLivingBase> threats = entity.field_70170_p.func_175647_a(EntityLivingBase.class, entity
/* 42 */       .func_174813_aQ().func_72314_b(range, range - 2.0D, range), new Predicate()
/*    */       {
/*    */         public boolean apply(@Nullable EntityLivingBase input)
/*    */         {
/* 46 */           return (entity != input) && (((input instanceof EntityPlayer)) || (input.func_110148_a(SharedMonsterAttributes.field_111264_e) != null));
/*    */         }
/* 48 */       });
/* 49 */     EntityLivingBase threat = (EntityLivingBase)EntityUtil.getClosestFrom(threats, entity);
/* 50 */     if (threat != null) {
/* 51 */       Vec3 vec = new Vec3(entity.field_70165_t - threat.field_70165_t, 0.0D, entity.field_70161_v - threat.field_70161_v).func_72432_b();
/* 52 */       double speed = 0.5D;
/* 53 */       entity.field_70159_w = (vec.field_72450_a * speed);
/* 54 */       entity.field_70179_y = (vec.field_72449_c * speed);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/potions/PotionCowardly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */