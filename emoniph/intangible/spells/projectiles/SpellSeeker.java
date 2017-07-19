/*    */ package emoniph.intangible.spells.projectiles;
/*    */ 
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.entity.EntitySeeker;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class SpellSeeker extends SpellProjectile
/*    */ {
/*    */   private int quantity;
/*    */   
/*    */   public SpellSeeker(int colorInner, int colorOuter, int quantity)
/*    */   {
/* 18 */     super(colorInner, colorOuter);
/* 19 */     this.quantity = quantity;
/*    */   }
/*    */   
/*    */   public void invoke(EntityPlayer player)
/*    */   {
/* 24 */     launchSwarm(player);
/* 25 */     Sound.RANDOM_FIZZ.playToAllNear(player);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public void launchSwarm(EntityLivingBase source, EntityLivingBase target)
/*    */   {
/* 58 */     if ((source != null) && (source.func_70089_S())) {
/* 59 */       World world = source.func_130014_f_();
/* 60 */       if ((world != null) && (!world.field_72995_K)) {
/* 61 */         Vec3 look = source.func_70040_Z();
/* 62 */         float increment = 360.0F / this.quantity;
/*    */         
/* 64 */         for (int i = 0; i < this.quantity; i++) {
/* 65 */           EntitySeeker projectile = new EntitySeeker(world, source, target, this);
/* 66 */           double variation = 0.2D;
/*    */           
/* 68 */           double increments = Math.toRadians(i * increment);
/* 69 */           Vec3 aug = look.func_178789_a((float)Math.sin(increments)).func_178785_b((float)Math.cos(increments));
/*    */           
/*    */ 
/*    */ 
/* 73 */           double length = 1.0D;
/* 74 */           projectile.field_70159_w += aug.field_72450_a * length;
/* 75 */           projectile.field_70181_x += aug.field_72448_b * length;
/* 76 */           projectile.field_70179_y += aug.field_72449_c * length;
/*    */           
/* 78 */           projectile.setColor(this.colorInner, this.colorOuter, 1.0F);
/* 79 */           world.func_72838_d(projectile);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void launchSwarm(EntityLivingBase source) {
/* 86 */     if ((source != null) && (source.func_70089_S()))
/*    */     {
/* 88 */       World world = source.func_130014_f_();
/* 89 */       if ((world != null) && (!world.field_72995_K)) {
/* 90 */         MovingObjectPosition mop = emoniph.intangible.util.RayTraceUtil.traceEntity(source, 64.0D, true, null);
/* 91 */         EntityLivingBase target = null;
/* 92 */         if ((mop != null) && (mop.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.ENTITY) && ((mop.field_72308_g instanceof EntityLivingBase))) {
/* 93 */           target = (EntityLivingBase)mop.field_72308_g;
/*    */         }
/* 95 */         launchSwarm(source, target);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public abstract boolean impact(EntitySpell paramEntitySpell, MovingObjectPosition paramMovingObjectPosition, EntityLivingBase paramEntityLivingBase);
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/projectiles/SpellSeeker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */