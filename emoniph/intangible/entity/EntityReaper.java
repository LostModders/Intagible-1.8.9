/*    */ package emoniph.intangible.entity;
/*    */ 
/*    */ import emoniph.intangible.fx.ParticleFactory;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.SharedMonsterAttributes;
/*    */ import net.minecraft.entity.ai.EntityAITasks;
/*    */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*    */ import net.minecraft.entity.monster.EntityMob;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.pathfinding.PathNavigateGround;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityReaper extends EntityMob
/*    */ {
/* 17 */   private int ticksToLive = -1;
/*    */   
/*    */   public EntityReaper(World worldIn) {
/* 20 */     super(worldIn);
/* 21 */     ((PathNavigateGround)func_70661_as()).func_179688_b(true);
/* 22 */     this.field_70714_bg.func_75776_a(0, new net.minecraft.entity.ai.EntityAISwimming(this));
/* 23 */     this.field_70714_bg.func_75776_a(2, new net.minecraft.entity.ai.EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.0D, false));
/* 24 */     this.field_70714_bg.func_75776_a(5, new net.minecraft.entity.ai.EntityAIMoveTowardsRestriction(this, 1.0D));
/* 25 */     this.field_70714_bg.func_75776_a(7, new net.minecraft.entity.ai.EntityAIWander(this, 1.0D));
/* 26 */     this.field_70714_bg.func_75776_a(8, new net.minecraft.entity.ai.EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 8.0F));
/* 27 */     this.field_70714_bg.func_75776_a(8, new net.minecraft.entity.ai.EntityAILookIdle(this));
/* 28 */     this.field_70715_bh.func_75776_a(1, new net.minecraft.entity.ai.EntityAINearestAttackableTarget(this, EntityLivingBase.class, true));
/* 29 */     func_70105_a(0.2F, 0.9F);
/*    */     
/* 31 */     this.field_70728_aV = 0;
/*    */   }
/*    */   
/*    */   public EntityReaper setTicksToLive(int ticksToLive) {
/* 35 */     this.ticksToLive = ticksToLive;
/* 36 */     return this;
/*    */   }
/*    */   
/*    */   public int getTicksToLive() {
/* 40 */     return this.ticksToLive;
/*    */   }
/*    */   
/*    */   protected void func_110147_ax() {
/* 44 */     super.func_110147_ax();
/* 45 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111128_a(80.0D);
/* 46 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3D);
/* 47 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(100.0D);
/* 48 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(30.0D);
/*    */   }
/*    */   
/*    */   protected void func_70088_a() {
/* 52 */     super.func_70088_a();
/*    */   }
/*    */   
/*    */   public int func_70658_aO() {
/* 56 */     return super.func_70658_aO();
/*    */   }
/*    */   
/*    */   public void func_70636_d()
/*    */   {
/* 61 */     super.func_70636_d();
/* 62 */     if ((!this.field_70170_p.field_72995_K) && (
/* 63 */       ((this.ticksToLive >= 0) && (--this.ticksToLive == 0)) || (func_70638_az() == null) || (!func_70638_az().func_70089_S()))) {
/* 64 */       func_70106_y();
/* 65 */       emoniph.intangible.Get.fx().sendToAllNear(net.minecraft.util.EnumParticleTypes.SMOKE_NORMAL, this, 0.5F, 20, 16.0D);
/*    */     }
/*    */   }
/*    */   
/*    */   protected String func_70639_aQ()
/*    */   {
/* 71 */     return super.func_70639_aQ();
/*    */   }
/*    */   
/*    */   protected String func_70621_aR() {
/* 75 */     return super.func_70621_aR();
/*    */   }
/*    */   
/*    */   protected String func_70673_aS() {
/* 79 */     return super.func_70673_aS();
/*    */   }
/*    */   
/*    */   protected void func_180429_a(BlockPos pos, Block blockIn) {
/* 83 */     func_85030_a("mob.zombie.step", 0.15F, 1.0F);
/*    */   }
/*    */   
/*    */   public void func_70014_b(NBTTagCompound compound) {
/* 87 */     super.func_70014_b(compound);
/*    */     
/* 89 */     compound.func_74768_a("ttl", getTicksToLive());
/*    */   }
/*    */   
/*    */   public void func_70037_a(NBTTagCompound compound) {
/* 93 */     super.func_70037_a(compound);
/*    */     
/* 95 */     setTicksToLive(compound.func_74762_e("ttl"));
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityReaper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */