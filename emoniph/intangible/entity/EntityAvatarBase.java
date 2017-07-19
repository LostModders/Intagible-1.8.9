/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IPossessable;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.deity.DeityList;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.deity.HeadSpec;
/*     */ import emoniph.intangible.souls.ISoulHost;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.enchantment.EnchantmentHelper;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAILookIdle;
/*     */ import net.minecraft.entity.ai.EntityAISwimming;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.EntityAIWander;
/*     */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*     */ import net.minecraft.entity.ai.attributes.BaseAttributeMap;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.EnumSkyBlock;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class EntityAvatarBase extends EntityCreature implements IPossessable, emoniph.intangible.api.deity.IAvatar, ISoulHost
/*     */ {
/*     */   public EntityAvatarBase(World worldIn)
/*     */   {
/*  42 */     super(worldIn);
/*  43 */     func_70105_a(0.6F, 1.8F);
/*  44 */     this.field_70728_aV = 0;
/*  45 */     this.field_70178_ae = true;
/*     */   }
/*     */   
/*     */   public World getAvatarWorld()
/*     */   {
/*  50 */     return this.field_70170_p;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70110_aj() {}
/*     */   
/*     */ 
/*     */   public SoulType getSoulType()
/*     */   {
/*  59 */     return SoulType.NOBLE;
/*     */   }
/*     */   
/*     */   public boolean isTrappableInBoneCage()
/*     */   {
/*  64 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorporeal()
/*     */   {
/*  69 */     return true;
/*     */   }
/*     */   
/*     */   protected int func_70682_h(int air)
/*     */   {
/*  74 */     return air;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  78 */     super.func_70088_a();
/*  79 */     this.field_70180_af.func_75682_a(16, "");
/*  80 */     this.field_70180_af.func_75682_a(17, Integer.valueOf(0));
/*  81 */     this.field_70180_af.func_75682_a(18, Integer.valueOf(0));
/*  82 */     this.field_70180_af.func_75682_a(19, Integer.valueOf(0));
/*  83 */     this.field_70180_af.func_75682_a(20, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public boolean isIncorporeal() {
/*  87 */     return this.field_70180_af.func_75683_a(20) == 1;
/*     */   }
/*     */   
/*     */   public void setIncorporeal(boolean incorporeal) {
/*  91 */     this.field_70180_af.func_75692_b(20, Byte.valueOf((byte)(incorporeal ? 1 : 0)));
/*  92 */     if ((!this.field_70170_p.field_72995_K) && (incorporeal)) {
/*  93 */       this.field_70715_bh.field_75782_a.clear();
/*  94 */       this.field_70714_bg.field_75782_a.clear();
/*  95 */       this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
/*  96 */       this.field_70714_bg.func_75776_a(2, new EntityAIWander(this, 0.8D));
/*  97 */       this.field_70714_bg.func_75776_a(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
/*  98 */       this.field_70714_bg.func_75776_a(3, new EntityAILookIdle(this));
/*     */     }
/*     */   }
/*     */   
/*     */   public AxisAlignedBB getAvatarBounds()
/*     */   {
/* 104 */     return func_174813_aQ();
/*     */   }
/*     */   
/*     */   public boolean canBePossessedBy(EntityPlayer player)
/*     */   {
/* 109 */     return false;
/*     */   }
/*     */   
/*     */   public boolean onAttackAction(EntityPlayer player, BlockPos targetPos)
/*     */   {
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public boolean onUseAction(EntityPlayer player, BlockPos targetPos)
/*     */   {
/* 119 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onJumpKey(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void possessBy(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */   public void setDeityId(UUID id)
/*     */   {
/* 133 */     this.field_70180_af.func_75692_b(16, id.toString());
/*     */   }
/*     */   
/*     */   public UUID getDeityId()
/*     */   {
/* 138 */     String id = this.field_70180_af.func_75681_e(16);
/* 139 */     if ((id != null) && (!id.isEmpty())) {
/* 140 */       return UUID.fromString(id);
/*     */     }
/* 142 */     return null;
/*     */   }
/*     */   
/*     */   public void setDeityColor(int color)
/*     */   {
/* 147 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(color));
/*     */   }
/*     */   
/*     */   public int getDeityColor() {
/* 151 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void setDeityBodyIndex(int index) {
/* 155 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(index));
/*     */   }
/*     */   
/*     */   public int getDeityBodyIndex() {
/* 159 */     return this.field_70180_af.func_75679_c(18);
/*     */   }
/*     */   
/*     */   public int getAvatarPowerIndex() {
/* 163 */     return this.field_70180_af.func_75679_c(19);
/*     */   }
/*     */   
/*     */   public void setAvatarPowerIndex(int index) {
/* 167 */     this.field_70180_af.func_75692_b(19, Integer.valueOf(index));
/*     */   }
/*     */   
/*     */   public String func_70005_c_()
/*     */   {
/* 172 */     UUID deityId = getDeityId();
/* 173 */     if (deityId != null) {
/* 174 */       if (!this.field_70170_p.field_72995_K) {
/* 175 */         IDeity deity = Get.deities().forWorld(this.field_70170_p).getDeityById(deityId);
/* 176 */         if (deity != null) {
/* 177 */           return StatCollector.func_74837_a("entity.intangible.avatarof.name", new Object[] { deity.getName() });
/*     */         }
/*     */       } else {
/* 180 */         HeadSpec head = Get.deities().getClientDeityFor(this.field_70170_p, deityId);
/* 181 */         if (head != null) {
/* 182 */           return StatCollector.func_74837_a("entity.intangible.avatarof.name", new Object[] { head.getName() });
/*     */         }
/*     */       }
/*     */     }
/* 186 */     return super.func_70005_c_();
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/* 190 */     super.func_110147_ax();
/* 191 */     func_110140_aT().func_111150_b(SharedMonsterAttributes.field_111264_e);
/*     */   }
/*     */   
/* 194 */   protected int incorporeal = -1;
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 198 */     super.func_70014_b(compound);
/* 199 */     compound.func_74778_a("deityid", getDeityId().toString());
/* 200 */     compound.func_74768_a("deitybody", getDeityBodyIndex());
/* 201 */     compound.func_74768_a("deitycolor", getDeityColor());
/* 202 */     compound.func_74768_a("deitypower", getAvatarPowerIndex());
/* 203 */     compound.func_74768_a("incorporeal", this.incorporeal);
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 208 */     super.func_70037_a(compound);
/* 209 */     if (compound.func_150297_b("deityid", 8)) {
/* 210 */       setDeityId(UUID.fromString(compound.func_74779_i("deityid")));
/*     */     }
/*     */     
/* 213 */     if (compound.func_150297_b("deitybody", 3)) {
/* 214 */       setDeityBodyIndex(compound.func_74762_e("deitybody"));
/*     */     }
/*     */     
/* 217 */     if (compound.func_150297_b("deitycolor", 3)) {
/* 218 */       setDeityColor(compound.func_74762_e("deitycolor"));
/*     */     }
/*     */     
/* 221 */     if (compound.func_150297_b("deitypower", 3)) {
/* 222 */       setAvatarPowerIndex(compound.func_74762_e("deitypower"));
/*     */     }
/*     */     
/* 225 */     if (compound.func_150297_b("incorporeal", 3)) {
/* 226 */       this.incorporeal = compound.func_74762_e("incorporeal");
/* 227 */       setIncorporeal(this.incorporeal >= 0);
/*     */     } else {
/* 229 */       this.incorporeal = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70645_a(DamageSource cause)
/*     */   {
/* 235 */     if (!isIncorporeal())
/*     */     {
/* 237 */       this.incorporeal = 600;
/* 238 */       setIncorporeal(true);
/* 239 */       func_70606_j(1.0F);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70636_d() {
/* 244 */     func_82168_bl();
/* 245 */     float f = func_70013_c(1.0F);
/*     */     
/* 247 */     if (f > 0.5F) {
/* 248 */       this.field_70708_bq += 2;
/*     */     }
/*     */     
/* 251 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 255 */     if (this.incorporeal > 0) {
/* 256 */       this.incorporeal -= 1;
/*     */     }
/*     */     
/* 259 */     super.func_70071_h_();
/*     */     
/* 261 */     if ((!this.field_70170_p.field_72995_K) && (this.field_70170_p.func_175659_aa() == EnumDifficulty.PEACEFUL)) {
/* 262 */       func_70106_y();
/*     */     }
/*     */     
/* 265 */     if (this.field_70170_p.field_72995_K) {
/* 266 */       onUpdateClient();
/*     */     }
/*     */     
/* 269 */     if (this.incorporeal == 0) {
/* 270 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onUpdateClient() {}
/*     */   
/*     */   protected String func_145776_H()
/*     */   {
/* 279 */     return "game.hostile.swim";
/*     */   }
/*     */   
/*     */   protected String func_145777_O() {
/* 283 */     return "game.hostile.swim.splash";
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource source, float amount) {
/* 287 */     if (func_180431_b(source))
/* 288 */       return false;
/* 289 */     if (super.func_70097_a(source, amount)) {
/* 290 */       Entity entity = source.func_76346_g();
/* 291 */       return (this.field_70153_n != entity) && (this.field_70154_o != entity);
/*     */     }
/* 293 */     return false;
/*     */   }
/*     */   
/*     */   protected String func_70621_aR()
/*     */   {
/* 298 */     return "game.hostile.hurt";
/*     */   }
/*     */   
/*     */   protected String func_70673_aS() {
/* 302 */     return "game.hostile.die";
/*     */   }
/*     */   
/*     */   protected String func_146067_o(int damageValue) {
/* 306 */     return damageValue > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity p_70652_1_)
/*     */   {
/* 311 */     float f = (float)func_110148_a(SharedMonsterAttributes.field_111264_e).func_111126_e();
/* 312 */     int i = 0;
/*     */     
/* 314 */     if ((p_70652_1_ instanceof EntityLivingBase)) {
/* 315 */       f += EnchantmentHelper.func_152377_a(func_70694_bm(), ((EntityLivingBase)p_70652_1_).func_70668_bt());
/* 316 */       i += EnchantmentHelper.func_77501_a(this);
/*     */     }
/*     */     
/* 319 */     boolean flag = p_70652_1_.func_70097_a(DamageSource.func_76358_a(this), f);
/*     */     
/* 321 */     if (flag) {
/* 322 */       if (i > 0) {
/* 323 */         p_70652_1_.func_70024_g(-MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F, 0.1D, MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F) * i * 0.5F);
/* 324 */         this.field_70159_w *= 0.6D;
/* 325 */         this.field_70179_y *= 0.6D;
/*     */       }
/*     */       
/* 328 */       int j = EnchantmentHelper.func_90036_a(this);
/*     */       
/* 330 */       if (j > 0) {
/* 331 */         p_70652_1_.func_70015_d(j * 4);
/*     */       }
/*     */       
/* 334 */       func_174815_a(this, p_70652_1_);
/*     */     }
/*     */     
/* 337 */     return flag;
/*     */   }
/*     */   
/*     */   public float func_180484_a(BlockPos p_180484_1_) {
/* 341 */     return 0.5F - this.field_70170_p.func_175724_o(p_180484_1_);
/*     */   }
/*     */   
/*     */   protected boolean isValidLightLevel() {
/* 345 */     BlockPos blockpos = new BlockPos(this.field_70165_t, func_174813_aQ().field_72338_b, this.field_70161_v);
/*     */     
/* 347 */     if (this.field_70170_p.func_175642_b(EnumSkyBlock.SKY, blockpos) > this.field_70146_Z.nextInt(32)) {
/* 348 */       return false;
/*     */     }
/* 350 */     int i = this.field_70170_p.func_175671_l(blockpos);
/*     */     
/* 352 */     if (this.field_70170_p.func_72911_I()) {
/* 353 */       int j = this.field_70170_p.func_175657_ab();
/* 354 */       this.field_70170_p.func_175692_b(10);
/* 355 */       i = this.field_70170_p.func_175671_l(blockpos);
/* 356 */       this.field_70170_p.func_175692_b(j);
/*     */     }
/*     */     
/* 359 */     return i <= this.field_70146_Z.nextInt(8);
/*     */   }
/*     */   
/*     */   public boolean func_70601_bi()
/*     */   {
/* 364 */     return (this.field_70170_p.func_175659_aa() != EnumDifficulty.PEACEFUL) && (isValidLightLevel()) && (super.func_70601_bi());
/*     */   }
/*     */   
/*     */   protected boolean func_146066_aG()
/*     */   {
/* 369 */     return true;
/*     */   }
/*     */   
/*     */   public boolean allowFirstPersonRender()
/*     */   {
/* 374 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean func_70692_ba()
/*     */   {
/* 379 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityAvatarBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */