/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import emoniph.intangible.api.IFakePlayerProvider;
/*    */ import emoniph.intangible.client.models.ModelGolemArm;
/*    */ import emoniph.intangible.client.models.ModelGolemArmSwarm;
/*    */ import emoniph.intangible.entity.EntitySeeker;
/*    */ import emoniph.intangible.spells.ModSpells;
/*    */ import emoniph.intangible.util.RayTraceUtil;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemArmSwarm extends GolemArm
/*    */ {
/*    */   public int getCooldownTicks()
/*    */   {
/* 27 */     return 100;
/*    */   }
/*    */   
/*    */   public boolean canPoint()
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean canStartBlocks()
/*    */   {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected ModelGolemArm createModel(BodySide side)
/*    */   {
/* 43 */     return new ModelGolemArmSwarm(side);
/*    */   }
/*    */   
/*    */   public boolean onUseAction(final World world, final EntityPlayer player, final EntityLiving golem, IFakePlayerProvider fakePlayerProvider, BlockPos targetPos, final BodySide side)
/*    */   {
/* 48 */     if (!world.field_72995_K) {
/* 49 */       ((WorldServer)world).func_152344_a(new Runnable()
/*    */       {
/*    */         public void run() {
/* 52 */           int quantity = 12;
/* 53 */           MovingObjectPosition mop = RayTraceUtil.traceEntity(player, 64.0D, true, new EntityLivingBase[] { golem });
/* 54 */           EntityLivingBase target = (mop != null) && (mop.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.ENTITY) ? (EntityLivingBase)mop.field_72308_g : null;
/*    */           
/* 56 */           Vec3 look = player.func_70040_Z();
/* 57 */           float increment = 360.0F / quantity;
/*    */           
/* 59 */           Vec3 vec = golem.func_70040_Z().func_178787_e(golem.func_70040_Z().func_178785_b(side == BodySide.RIGHT ? -90.0F : 90.0F));
/* 60 */           for (int i = 0; i < quantity; i++) {
/* 61 */             EntitySeeker projectile = new EntitySeeker(world, golem, target, Get.spells().SWARM);
/* 62 */             double increments = Math.toRadians(i * increment);
/* 63 */             Vec3 aug = look.func_178789_a((float)Math.sin(increments)).func_178785_b((float)Math.cos(increments));
/* 64 */             double length = 1.0D;
/*    */             
/*    */ 
/* 67 */             projectile.field_70165_t += vec.field_72450_a * 0.7D;
/* 68 */             projectile.field_70161_v += vec.field_72449_c * 0.7D;
/* 69 */             projectile.field_70163_u -= 0.4D;
/*    */             
/* 71 */             projectile.field_70159_w += aug.field_72450_a * length;
/* 72 */             projectile.field_70181_x += aug.field_72448_b * length;
/* 73 */             projectile.field_70179_y += aug.field_72449_c * length;
/*    */             
/* 75 */             projectile.setColor(16777215, 65280, 0.8F);
/* 76 */             Sound.RANDOM_FIZZ.playToAllNear(player);
/* 77 */             world.func_72838_d(projectile);
/*    */           }
/*    */         }
/*    */       });
/*    */     }
/* 82 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemArmSwarm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */