/*    */ package emoniph.intangible.spells.grenades;
/*    */ 
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.api.CastingStyle;
/*    */ import emoniph.intangible.entity.EntitySpikeBall;
/*    */ import emoniph.intangible.spells.Spell;
/*    */ import emoniph.intangible.util.RayTraceUtil;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class SpellGrenade extends Spell
/*    */ {
/*    */   protected int color;
/*    */   protected int fuse;
/*    */   
/*    */   public SpellGrenade(int color, int fuse)
/*    */   {
/* 22 */     super(CastingStyle.PREPARED);
/* 23 */     this.color = color;
/* 24 */     this.fuse = fuse;
/*    */   }
/*    */   
/*    */   public void invoke(EntityPlayer player)
/*    */   {
/* 29 */     MovingObjectPosition mop = RayTraceUtil.traceEntity(player, 24.0D, true, null);
/* 30 */     if ((mop != null) && (mop.field_72308_g != null)) {
/* 31 */       throwGrenade(player, (EntityLivingBase)mop.field_72308_g);
/*    */     } else {
/* 33 */       throwGrenade(player);
/*    */     }
/* 35 */     Sound.MOD_RANDOM_SPELL1.playToAllNear(player, 0.5F, 1.0F);
/*    */   }
/*    */   
/*    */   public void throwGrenade(EntityLivingBase shooter) {
/* 39 */     float f = 1.0F;
/* 40 */     double motionX = -MathHelper.func_76126_a(shooter.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(shooter.field_70125_A / 180.0F * 3.1415927F) * f;
/* 41 */     double motionZ = MathHelper.func_76134_b(shooter.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(shooter.field_70125_A / 180.0F * 3.1415927F) * f;
/* 42 */     double motionY = -MathHelper.func_76126_a(shooter.field_70125_A / 180.0F * 3.1415927F) * f;
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 49 */     throwGrenade(shooter, motionX, motionY, motionZ);
/*    */   }
/*    */   
/*    */   public void throwGrenade(EntityLivingBase source, EntityLivingBase target)
/*    */   {
/* 54 */     double leading = 1.0D;
/*    */     
/* 56 */     double dx = target.field_70165_t + target.field_70159_w * 1.0D - source.field_70165_t;
/* 57 */     double dy = target.field_70163_u + target.field_70181_x * 1.0D - source.field_70163_u;
/* 58 */     double dz = target.field_70161_v + target.field_70179_y * 1.0D - source.field_70161_v;
/*    */     
/* 60 */     double distance = Math.sqrt(dx * dx + dy * dy + dz * dz);
/*    */     
/* 62 */     double speed = 0.4D;
/*    */     
/* 64 */     double factor = 0.4D / distance;
/* 65 */     double vel_x = dx * factor;
/* 66 */     double vel_y = dy * factor;
/* 67 */     double vel_z = dz * factor;
/*    */     
/* 69 */     double time = distance / 0.4D;
/*    */     
/* 71 */     float g = 0.8F;
/*    */     
/* 73 */     double angle = 0.07D;
/*    */     
/* 75 */     throwGrenade(source, vel_x, vel_y + 0.028000000417232516D * time, vel_z);
/*    */   }
/*    */   
/*    */   public void throwGrenade(EntityLivingBase shooter, double motionX, double motionY, double motionZ) {
/* 79 */     World world = shooter.func_130014_f_();
/* 80 */     EntitySpikeBall projectile = new EntitySpikeBall(world, shooter, this);
/*    */     
/* 82 */     projectile.func_70012_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v, shooter.field_70177_z, shooter.field_70125_A);
/* 83 */     projectile.func_70107_b(shooter.field_70165_t, shooter.field_70163_u + shooter.func_70047_e(), shooter.field_70161_v);
/*    */     
/* 85 */     double d8 = 1.5D;
/* 86 */     Vec3 vec3 = shooter.func_70676_i(1.0F);
/* 87 */     projectile.field_70165_t = (shooter.field_70165_t + vec3.field_72450_a * 1.5D);
/* 88 */     projectile.field_70163_u = (shooter.field_70163_u + shooter.func_70047_e() - 0.10000000149011612D + vec3.field_72448_b * 1.5D);
/* 89 */     projectile.field_70161_v = (shooter.field_70161_v + vec3.field_72449_c * 1.5D);
/*    */     
/* 91 */     projectile.field_70159_w = motionX;
/* 92 */     projectile.field_70181_x = motionY;
/* 93 */     projectile.field_70179_y = motionZ;
/*    */     
/* 95 */     projectile.setColor(this.color, 1.0F);
/* 96 */     projectile.setFuse(this.fuse);
/*    */     
/* 98 */     world.func_72838_d(projectile);
/*    */   }
/*    */   
/*    */   public abstract boolean explode(EntitySpikeBall paramEntitySpikeBall, EntityLivingBase paramEntityLivingBase);
/*    */   
/*    */   public void tick(EntitySpikeBall spellEntity, EntityLivingBase caster) {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/grenades/SpellGrenade.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */