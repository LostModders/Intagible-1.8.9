/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.enchantment.Enchantment;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityAgeable;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIArrowAttack;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.projectile.EntityArrow;
/*     */ import net.minecraft.item.ItemBow;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.ItemTool;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.pathfinding.PathNavigate;
/*     */ import net.minecraft.pathfinding.PathNavigateGround;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.util.FakePlayer;
/*     */ 
/*     */ public class EntityTool extends EntityTameable implements net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData, net.minecraft.entity.IRangedAttackMob
/*     */ {
/*     */   private int attackTimerStandardRight;
/*  37 */   private EntityAIArrowAttack aiArrowAttack = new EntityAIArrowAttack(this, 1.0D, 20, 60, 15.0F);
/*  38 */   private EntityAIAttackOnCollide aiAttackOnCollide = new EntityAIAttackOnCollide(this, EntityLivingBase.class, 1.2D, false);
/*     */   private EnumFacing direction;
/*     */   
/*     */   public EntityTool(World worldIn) {
/*  42 */     super(worldIn);
/*  43 */     func_70105_a(0.6F, 1.1F);
/*  44 */     ((PathNavigateGround)func_70661_as()).func_179690_a(false);
/*  45 */     ((PathNavigateGround)func_70661_as()).func_179693_d(true);
/*  46 */     this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAISwimming(this));
/*     */     
/*     */ 
/*     */ 
/*  50 */     this.field_70715_bh.func_75776_a(1, new net.minecraft.entity.ai.EntityAIOwnerHurtByTarget(this));
/*  51 */     this.field_70715_bh.func_75776_a(2, new net.minecraft.entity.ai.EntityAIOwnerHurtTarget(this));
/*  52 */     this.field_70715_bh.func_75776_a(3, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, true, new Class[0]));
/*     */     
/*  54 */     this.field_70728_aV = 0;
/*     */     
/*  56 */     if ((worldIn != null) && (!worldIn.field_72995_K)) {
/*  57 */       setCombatTask();
/*     */     }
/*     */   }
/*     */   
/*  61 */   private int ticksToLive = -1;
/*     */   private FakePlayer fakePlayer;
/*     */   
/*  64 */   public EntityTool(World worldIn, ItemStack stack) { this(worldIn);
/*  65 */     func_70062_b(0, stack);
/*     */   }
/*     */   
/*     */   public EntityTool setTicksToLive(int ticksToLive) {
/*  69 */     this.ticksToLive = ticksToLive;
/*  70 */     return this;
/*     */   }
/*     */   
/*     */   public int getTicksToLive() {
/*  74 */     return this.ticksToLive;
/*     */   }
/*     */   
/*     */   public void func_70636_d() {
/*  78 */     super.func_70636_d();
/*  79 */     if ((!this.field_70170_p.field_72995_K) && 
/*  80 */       (this.ticksToLive >= 0) && (--this.ticksToLive == 0)) {
/*  81 */       func_70106_y();
/*  82 */       func_70099_a(func_70694_bm(), 1.0F);
/*  83 */       emoniph.intangible.Get.fx().sendToAllNear(net.minecraft.util.EnumParticleTypes.SMOKE_NORMAL, this, 0.5F, 20, 16.0D);
/*     */     }
/*     */     
/*     */ 
/*  87 */     if ((!this.field_70170_p.field_72995_K) && ((func_70694_bm().func_77973_b() instanceof ItemTool)) && (this.field_70173_aa % 20 == 0) && (this.attackTimerStandardRight == 0)) {
/*  88 */       if ((this.direction != null) && (func_70661_as().func_75500_f())) {
/*  89 */         BlockPos pos = new BlockPos(this).func_177967_a(this.direction, 2);
/*     */         
/*  91 */         func_70661_as().func_75492_a(pos.func_177958_n() + 0.5D, pos.func_177956_o(), pos.func_177952_p() + 0.5D, 0.5D);
/*  92 */         swingArmRight();
/*     */       } else {
/*  94 */         swingArmRight();
/*     */       }
/*     */     }
/*     */     
/*  98 */     if ((this.attackTimerStandardRight > 0) && 
/*  99 */       (--this.attackTimerStandardRight == 0)) {
/* 100 */       if ((!this.field_70170_p.field_72995_K) && ((func_70694_bm().func_77973_b() instanceof ItemBow)) && (func_70638_az() != null)) {
/* 101 */         EntityArrow entityarrow = new EntityArrow(this.field_70170_p, this, func_70638_az(), 1.6F, 14 - this.field_70170_p.func_175659_aa().func_151525_a() * 4);
/* 102 */         int i = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, func_70694_bm());
/* 103 */         int j = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, func_70694_bm());
/* 104 */         entityarrow.func_70239_b(this.nextDamageAugment * 2.0F + this.field_70146_Z.nextGaussian() * 0.25D + this.field_70170_p.func_175659_aa().func_151525_a() * 0.11F);
/*     */         
/* 106 */         if (i > 0) {
/* 107 */           entityarrow.func_70239_b(entityarrow.func_70242_d() + i * 0.5D + 0.5D);
/*     */         }
/*     */         
/* 110 */         if (j > 0) {
/* 111 */           entityarrow.func_70240_a(j);
/*     */         }
/*     */         
/* 114 */         if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, func_70694_bm()) > 0) {
/* 115 */           entityarrow.func_70015_d(100);
/*     */         }
/*     */         
/* 118 */         func_85030_a("random.bow", 1.0F, 1.0F / (func_70681_au().nextFloat() * 0.4F + 0.8F));
/* 119 */         this.field_70170_p.func_72838_d(entityarrow);
/* 120 */       } else if ((!this.field_70170_p.field_72995_K) && ((func_70694_bm().func_77973_b() instanceof ItemTool))) {
/* 121 */         FakePlayer fake = getFakePlayer();
/* 122 */         fake.func_70062_b(0, func_70694_bm());
/*     */         
/* 124 */         if (this.direction != null) {
/* 125 */           int k = MathHelper.func_76128_c(this.field_70163_u);
/* 126 */           boolean done = false;
/* 127 */           for (int i = 0; (i < 4) && (!done); i++) {
/* 128 */             int j = MathHelper.func_76128_c(this.field_70165_t + (i % 2 * 2 - 1) * 0.5F);
/* 129 */             int l = MathHelper.func_76128_c(this.field_70161_v + (i / 2 % 2 * 2 - 1) * 0.5F);
/*     */             
/* 131 */             for (int y = 0; (y < 2) && (!done); y++) {
/* 132 */               BlockPos pos = new BlockPos(j, k + y, l).func_177972_a(this.direction);
/* 133 */               IBlockState state = this.field_70170_p.func_180495_p(pos);
/* 134 */               if (state.func_177230_c() != net.minecraft.init.Blocks.field_150350_a) {
/* 135 */                 if ((state.func_177230_c().func_176195_g(this.field_70170_p, pos) == -1.0F) || (state.func_177230_c().hasTileEntity(state)) || 
/* 136 */                   (!BlockUtil.tryHarvestBlock(this.field_70170_p, pos, fake, func_70694_bm()))) {
/* 137 */                   this.ticksToLive = 1;
/*     */                 }
/* 139 */                 done = true;
/*     */               }
/*     */             }
/*     */           }
/*     */         } else {
/* 144 */           int k = MathHelper.func_76128_c(this.field_70163_u - 1.0D);
/* 145 */           for (int i = 0; i < 4; i++) {
/* 146 */             int j = MathHelper.func_76128_c(this.field_70165_t + (i % 2 * 2 - 1) * 0.5F);
/* 147 */             int l = MathHelper.func_76128_c(this.field_70161_v + (i / 2 % 2 * 2 - 1) * 0.5F);
/*     */             
/* 149 */             BlockPos pos = new BlockPos(j, k, l);
/* 150 */             IBlockState state = this.field_70170_p.func_180495_p(pos);
/* 151 */             if (state.func_177230_c() != net.minecraft.init.Blocks.field_150350_a) {
/* 152 */               if ((state.func_177230_c().func_176195_g(this.field_70170_p, pos) != -1.0F) && (!state.func_177230_c().hasTileEntity(state)) && 
/* 153 */                 (BlockUtil.tryHarvestBlock(this.field_70170_p, pos, fake, func_70694_bm()))) break;
/* 154 */               this.ticksToLive = 1; break;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 161 */         this.fakePlayer.func_70062_b(0, null);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 170 */   private static final GameProfile FAKE_PLAYER_PROFILE = new GameProfile(java.util.UUID.fromString("cc367aa8-b802-41ab-897a-5420b8fe26ae"), "[animatedtool]");
/*     */   float nextDamageAugment;
/*     */   
/* 173 */   public FakePlayer getFakePlayer() { if ((!this.field_70170_p.field_72995_K) && ((this.fakePlayer == null) || (this.fakePlayer.field_70170_p != this.field_70170_p))) {
/* 174 */       this.fakePlayer = net.minecraftforge.common.util.FakePlayerFactory.get((net.minecraft.world.WorldServer)this.field_70170_p, FAKE_PLAYER_PROFILE);
/*     */     }
/* 176 */     return this.fakePlayer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void swingArmRight()
/*     */   {
/* 183 */     this.attackTimerStandardRight = 10;
/* 184 */     this.field_70170_p.func_72960_a(this, (byte)4);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void func_70103_a(byte data)
/*     */   {
/* 192 */     if (data == 4) {
/* 193 */       this.attackTimerStandardRight = 10;
/*     */     }
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public int getAttackTimerStandardRight() {
/* 199 */     return this.attackTimerStandardRight;
/*     */   }
/*     */   
/*     */   protected void func_70628_a(boolean p_70628_1_, int p_70628_2_)
/*     */   {
/* 204 */     if (!this.field_70170_p.field_72995_K) {
/* 205 */       func_70099_a(func_70694_bm(), 1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/* 210 */     super.func_110147_ax();
/* 211 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
/* 212 */     func_110148_a(SharedMonsterAttributes.field_111264_e).func_111128_a(1.0D);
/* 213 */     func_110148_a(SharedMonsterAttributes.field_111263_d).func_111128_a(0.3D);
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity entityIn)
/*     */   {
/* 218 */     swingArmRight();
/* 219 */     float f = (float)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/* 220 */     int i = 0;
/*     */     
/* 222 */     if ((entityIn instanceof EntityLivingBase)) {
/* 223 */       f += EnchantmentHelper.func_152377_a(func_70694_bm(), ((EntityLivingBase)entityIn).func_70668_bt());
/* 224 */       i += EnchantmentHelper.func_77501_a(this);
/*     */     }
/*     */     
/* 227 */     boolean flag = entityIn.func_70097_a(net.minecraft.util.DamageSource.func_76358_a(this), f);
/*     */     
/* 229 */     if (flag) {
/* 230 */       if (i > 0) {
/* 231 */         entityIn.func_70024_g(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F, 0.1D, MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F);
/* 232 */         this.field_70159_w *= 0.6D;
/* 233 */         this.field_70179_y *= 0.6D;
/*     */       }
/*     */       
/* 236 */       int j = EnchantmentHelper.func_90036_a(this);
/*     */       
/* 238 */       if (j > 0) {
/* 239 */         entityIn.func_70015_d(j * 4);
/*     */       }
/*     */       
/* 242 */       func_174815_a(this, entityIn);
/*     */     }
/*     */     
/* 245 */     return flag;
/*     */   }
/*     */   
/*     */   public void setCombatTask() {
/* 249 */     this.field_70714_bg.func_85156_a(this.aiAttackOnCollide);
/* 250 */     this.field_70714_bg.func_85156_a(this.aiArrowAttack);
/* 251 */     ItemStack itemstack = func_70694_bm();
/*     */     
/* 253 */     if (itemstack != null) {
/* 254 */       if ((itemstack.func_77973_b() instanceof ItemBow)) {
/* 255 */         this.field_70714_bg.func_75776_a(2, this.aiArrowAttack);
/* 256 */       } else if ((itemstack.func_77973_b() instanceof net.minecraft.item.ItemSword)) {
/* 257 */         this.field_70714_bg.func_75776_a(2, this.aiAttackOnCollide);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public EntityAgeable func_90011_a(EntityAgeable ageable)
/*     */   {
/* 265 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static final int ATTACK_TICKS = 10;
/*     */   
/*     */   public void writeSpawnData(ByteBuf buffer) {}
/*     */   
/*     */ 
/*     */   public void readSpawnData(ByteBuf additionalData) {}
/*     */   
/*     */ 
/*     */   public void func_82196_d(EntityLivingBase targetEntity, float p_82196_2_)
/*     */   {
/* 280 */     this.nextDamageAugment = p_82196_2_;
/* 281 */     swingArmRight();
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound tagCompund) {
/* 285 */     super.func_70037_a(tagCompund);
/* 286 */     setCombatTask();
/* 287 */     setTicksToLive(tagCompund.func_74762_e("ttl"));
/* 288 */     if (tagCompund.func_74764_b("direction")) {
/* 289 */       this.direction = EnumFacing.func_82600_a(tagCompund.func_74762_e("direction"));
/*     */     } else {
/* 291 */       this.direction = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound tagCompound)
/*     */   {
/* 297 */     super.func_70014_b(tagCompound);
/* 298 */     tagCompound.func_74768_a("ttl", getTicksToLive());
/* 299 */     if (this.direction != null) {
/* 300 */       tagCompound.func_74768_a("direction", this.direction.func_176745_a());
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70062_b(int slotIn, ItemStack stack) {
/* 305 */     super.func_70062_b(slotIn, stack);
/*     */     
/* 307 */     if ((!this.field_70170_p.field_72995_K) && (slotIn == 0)) {
/* 308 */       setCombatTask();
/*     */     }
/*     */   }
/*     */   
/*     */   public void setDirection(EnumFacing direction) {
/* 313 */     this.direction = direction;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */