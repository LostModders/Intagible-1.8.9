/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.entity.ai.EntityAIDefendedHurtByTarget;
/*     */ import emoniph.intangible.entity.ai.EntityAIDefendedHurtTarget;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureAttribute;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIAttackOnCollide;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.attributes.AttributeModifier;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.monster.EntitySpider;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.RegistryNamespacedDefaultedByKey;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySpiderBlock extends EntitySpider implements emoniph.intangible.entity.ai.IDefender, emoniph.intangible.souls.ISoulHost
/*     */ {
/*     */   public EntitySpiderBlock(World worldIn)
/*     */   {
/*  35 */     super(worldIn);
/*  36 */     func_70105_a(0.9F, 0.9F);
/*     */     
/*  38 */     this.field_70714_bg.func_75776_a(4, new AISpiderAttack2(EntityLivingBase.class));
/*  39 */     this.field_70714_bg.func_75776_a(4, new emoniph.intangible.entity.ai.EntityAIFollowDefended(this, 1.0D, 10.0F, 2.0F));
/*  40 */     this.field_70715_bh.field_75782_a.clear();
/*  41 */     this.field_70715_bh.func_75776_a(1, new EntityAIDefendedHurtByTarget(this));
/*  42 */     this.field_70715_bh.func_75776_a(2, new EntityAIDefendedHurtTarget(this));
/*  43 */     this.field_70715_bh.func_75776_a(3, new net.minecraft.entity.ai.EntityAIHurtByTarget(this, false, new Class[0]));
/*     */   }
/*     */   
/*     */   public emoniph.intangible.api.SoulType getSoulType()
/*     */   {
/*  48 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isTrappableInBoneCage()
/*     */   {
/*  53 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorporeal()
/*     */   {
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   private class AISpiderAttack2 extends EntityAIAttackOnCollide {
/*     */     public AISpiderAttack2(Class p_i45819_2_) {
/*  63 */       super(p_i45819_2_, 1.0D, true);
/*     */     }
/*     */     
/*     */     protected double func_179512_a(EntityLivingBase p_179512_1_) {
/*  67 */       return 4.0F + p_179512_1_.field_70130_N;
/*     */     }
/*     */   }
/*     */   
/*  71 */   private int ticksToLive = -1;
/*     */   private IBlockState state;
/*     */   
/*     */   protected void func_70088_a() {
/*  75 */     super.func_70088_a();
/*  76 */     this.field_70180_af.func_75682_a(17, "");
/*  77 */     this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
/*  78 */     this.field_70180_af.func_75682_a(19, "");
/*     */   }
/*     */   
/*     */   public IBlockState getMaterial() {
/*  82 */     if (this.state == null) {
/*  83 */       Block block = Block.func_149684_b(this.field_70180_af.func_75681_e(19));
/*  84 */       int meta = this.field_70180_af.func_75683_a(18);
/*  85 */       if (block != null) {
/*  86 */         this.state = block.func_176203_a(meta);
/*     */       }
/*     */     }
/*  89 */     return this.state;
/*     */   }
/*     */   
/*     */   public void setMaterial(IBlockState state) {
/*  93 */     Block block = state != null ? state.func_177230_c() : Blocks.field_150350_a;
/*  94 */     ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.func_177774_c(block);
/*  95 */     this.state = state;
/*  96 */     this.field_70180_af.func_75692_b(19, resourcelocation == null ? "" : resourcelocation.toString());
/*  97 */     this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)block.func_176201_c(state)));
/*     */   }
/*     */   
/*     */   public void setTicksToLive(int ticks) {
/* 101 */     this.ticksToLive = ticks;
/*     */   }
/*     */   
/*     */   public int getTicksToLive() {
/* 105 */     return this.ticksToLive;
/*     */   }
/*     */   
/*     */   public void setOwner(EntityLivingBase entity) {
/* 109 */     if ((entity instanceof EntityPlayer)) {
/* 110 */       EntityPlayer player = (EntityPlayer)entity;
/* 111 */       setOwnerId(player.func_110124_au().toString());
/*     */     }
/*     */   }
/*     */   
/*     */   private String getOwnerId() {
/* 116 */     return this.field_70180_af.func_75681_e(17);
/*     */   }
/*     */   
/*     */   private void setOwnerId(String ownerUuid) {
/* 120 */     this.field_70180_af.func_75692_b(17, ownerUuid);
/*     */   }
/*     */   
/*     */   public net.minecraft.entity.EntityCreature getDefenderCreature()
/*     */   {
/* 125 */     return this;
/*     */   }
/*     */   
/*     */   public boolean hasOwner()
/*     */   {
/* 130 */     return getOwnerId() != "";
/*     */   }
/*     */   
/*     */   public List<EntityLivingBase> getOwnerEntities()
/*     */   {
/*     */     try {
/* 136 */       UUID uuid = UUID.fromString(getOwnerId());
/* 137 */       return uuid == null ? null : Arrays.asList(new EntityLivingBase[] { this.field_70170_p.func_152378_a(uuid) });
/*     */     } catch (IllegalArgumentException illegalargumentexception) {}
/* 139 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_)
/*     */   {
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   public boolean isSitting()
/*     */   {
/* 151 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_110147_ax()
/*     */   {
/* 156 */     super.func_110147_ax();
/* 157 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80.0D);
/*     */   }
/*     */   
/*     */   public void func_70636_d()
/*     */   {
/* 162 */     if ((func_70089_S()) && (this.ticksToLive >= 0) && (--this.ticksToLive == 0)) {
/* 163 */       if (!this.field_70170_p.field_72995_K) {
/* 164 */         List<EntityLivingBase> owners = getOwnerEntities();
/* 165 */         BlockPos pos = new BlockPos(this);
/* 166 */         if (this.state != null) if (emoniph.intangible.util.BlockUtil.canEditBlock((owners != null) && (!owners.isEmpty()) ? (EntityLivingBase)owners.get(0) : this, this.field_70170_p, pos)) {
/* 167 */             this.field_70170_p.func_175656_a(pos, getMaterial());
/* 168 */             this.field_70170_p.func_175718_b(2001, pos, Block.func_176210_f(this.state));
/*     */           }
/* 170 */         func_70106_y();
/*     */       }
/* 172 */       return;
/*     */     }
/* 174 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 181 */     super.func_70014_b(compound);
/*     */     
/* 183 */     Block block = this.state != null ? this.state.func_177230_c() : Blocks.field_150350_a;
/* 184 */     ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.func_177774_c(block);
/* 185 */     compound.func_74778_a("Block", resourcelocation == null ? "" : resourcelocation.toString());
/* 186 */     compound.func_74774_a("Data", (byte)block.func_176201_c(this.state));
/*     */     
/* 188 */     if (this.ticksToLive >= 0) {
/* 189 */       compound.func_74768_a("ttl", this.ticksToLive);
/*     */     }
/*     */     
/* 192 */     if (getOwnerId() == null) {
/* 193 */       compound.func_74778_a("OwnerUUID", "");
/*     */     } else {
/* 195 */       compound.func_74778_a("OwnerUUID", getOwnerId());
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 201 */     super.func_70037_a(compound);
/*     */     
/* 203 */     int i = compound.func_74771_c("Data") & 0xFF;
/*     */     
/* 205 */     if (compound.func_150297_b("Block", 8)) {
/* 206 */       setMaterial(Block.func_149684_b(compound.func_74779_i("Block")).func_176203_a(i));
/*     */     }
/*     */     
/* 209 */     if (compound.func_150297_b("ttl", 3)) {
/* 210 */       this.ticksToLive = compound.func_74762_e("ttl");
/*     */     } else {
/* 212 */       this.ticksToLive = -1;
/*     */     }
/*     */     
/*     */     String s;
/*     */     String s;
/* 217 */     if (compound.func_150297_b("OwnerUUID", 8)) {
/* 218 */       s = compound.func_74779_i("OwnerUUID");
/*     */     } else {
/* 220 */       String s1 = compound.func_74779_i("Owner");
/* 221 */       s = net.minecraft.server.management.PreYggdrasilConverter.func_152719_a(s1);
/*     */     }
/*     */     
/* 224 */     if (s.length() > 0) {
/* 225 */       setOwnerId(s);
/*     */     }
/*     */   }
/*     */   
/*     */   protected String func_70621_aR()
/*     */   {
/* 231 */     if (getMaterial().func_177230_c().func_149688_o() == net.minecraft.block.material.Material.field_151576_e) {
/* 232 */       return Sound.MOD_RANDOM_ROCK_HIT.LOCATION;
/*     */     }
/* 234 */     return Sound.MOD_RANDOM_DIRT_HIT.LOCATION;
/*     */   }
/*     */   
/*     */ 
/*     */   protected String func_70673_aS()
/*     */   {
/* 240 */     return func_70621_aR();
/*     */   }
/*     */   
/*     */   protected String func_70639_aQ()
/*     */   {
/* 245 */     return "none";
/*     */   }
/*     */   
/*     */   protected int func_70693_a(EntityPlayer player)
/*     */   {
/* 250 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_70628_a(boolean recentlyHit, int p_70628_2_) {}
/*     */   
/*     */ 
/*     */   public EnumCreatureAttribute func_70668_bt()
/*     */   {
/* 260 */     return EnumCreatureAttribute.UNDEFINED;
/*     */   }
/*     */   
/*     */   public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData spawnData)
/*     */   {
/* 265 */     func_110148_a(SharedMonsterAttributes.field_111265_b).func_111121_a(new AttributeModifier("Random spawn bonus", this.field_70146_Z.nextGaussian() * 0.05D, 1));
/* 266 */     return spawnData;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySpiderBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */