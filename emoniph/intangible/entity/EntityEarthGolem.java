/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.entity.ai.EntityAIDefendedHurtByTarget;
/*     */ import emoniph.intangible.entity.ai.EntityAIDefendedHurtTarget;
/*     */ import emoniph.intangible.souls.ISoulHost;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.ai.EntityAIHurtByTarget;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.ai.attributes.IAttributeInstance;
/*     */ import net.minecraft.entity.monster.EntityIronGolem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.server.management.PreYggdrasilConverter;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ 
/*     */ public class EntityEarthGolem extends EntityIronGolem implements IEntityAdditionalSpawnData, emoniph.intangible.entity.ai.IDefender, ISoulHost
/*     */ {
/*     */   public void writeSpawnData(ByteBuf buffer)
/*     */   {
/*  37 */     buffer.writeFloat(this.field_70177_z);
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf buffer)
/*     */   {
/*  42 */     this.field_70760_ar = (this.field_70761_aq = this.field_70126_B = this.field_70758_at = this.field_70177_z = this.field_70759_as = buffer.readFloat());
/*     */   }
/*     */   
/*     */   public emoniph.intangible.api.SoulType getSoulType()
/*     */   {
/*  47 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isTrappableInBoneCage()
/*     */   {
/*  52 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorporeal()
/*     */   {
/*  57 */     return true;
/*     */   }
/*     */   
/*  60 */   private int ticksToLive = -1;
/*     */   
/*     */   public EntityEarthGolem(World worldIn) {
/*  63 */     super(worldIn);
/*     */     
/*  65 */     this.field_70715_bh.field_75782_a.clear();
/*  66 */     this.field_70715_bh.func_75776_a(1, new EntityAIDefendedHurtByTarget(this));
/*  67 */     this.field_70715_bh.func_75776_a(2, new EntityAIDefendedHurtTarget(this));
/*  68 */     this.field_70715_bh.func_75776_a(3, new EntityAIHurtByTarget(this, false, new Class[0]));
/*     */     
/*  70 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/*  75 */     super.func_70088_a();
/*  76 */     this.field_70180_af.func_75682_a(17, "");
/*  77 */     this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)GolemMaterial.DIRT.getId()));
/*     */   }
/*     */   
/*     */   public GolemMaterial getMaterial() {
/*  81 */     return GolemMaterial.idToMat(this.field_70180_af.func_75683_a(18));
/*     */   }
/*     */   
/*     */   public void setMaterial(GolemMaterial material) {
/*  85 */     this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)material.getId()));
/*  86 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(material.getHealth());
/*     */   }
/*     */   
/*     */   public void setTicksToLive(int ticks) {
/*  90 */     this.ticksToLive = ticks;
/*     */   }
/*     */   
/*     */   public int getTicksToLive() {
/*  94 */     return this.ticksToLive;
/*     */   }
/*     */   
/*     */   public void setOwner(EntityLivingBase entity) {
/*  98 */     if ((entity instanceof EntityPlayer)) {
/*  99 */       EntityPlayer player = (EntityPlayer)entity;
/* 100 */       setOwnerId(player.func_110124_au().toString());
/*     */     }
/* 102 */     func_70849_f(true);
/*     */   }
/*     */   
/*     */   public EntityCreature getDefenderCreature()
/*     */   {
/* 107 */     return this;
/*     */   }
/*     */   
/*     */   private String getOwnerId() {
/* 111 */     return this.field_70180_af.func_75681_e(17);
/*     */   }
/*     */   
/*     */   private void setOwnerId(String ownerUuid) {
/* 115 */     this.field_70180_af.func_75692_b(17, ownerUuid);
/*     */   }
/*     */   
/*     */   public List<EntityLivingBase> getOwnerEntities() {
/*     */     try {
/* 120 */       UUID uuid = UUID.fromString(getOwnerId());
/* 121 */       return uuid == null ? null : Arrays.asList(new EntityLivingBase[] { this.field_70170_p.func_152378_a(uuid) });
/*     */     } catch (IllegalArgumentException illegalargumentexception) {}
/* 123 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean hasOwner()
/*     */   {
/* 132 */     return getOwnerId() != "";
/*     */   }
/*     */   
/*     */   public boolean isSitting() {
/* 136 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_142018_a(EntityLivingBase p_142018_1_, EntityLivingBase p_142018_2_) {
/* 140 */     return true;
/*     */   }
/*     */   
/*     */   protected void func_110147_ax()
/*     */   {
/* 145 */     super.func_110147_ax();
/* 146 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(80.0D);
/*     */   }
/*     */   
/*     */   public boolean func_70652_k(Entity targetEntity)
/*     */   {
/* 151 */     this.field_70855_f = 10;
/* 152 */     this.field_70170_p.func_72960_a(this, (byte)4);
/* 153 */     GolemMaterial material = getMaterial();
/* 154 */     boolean flag = targetEntity.func_70097_a(DamageSource.func_76358_a(this), material.getBaseDamage() + this.field_70146_Z.nextInt(material.getRandomDamage()));
/*     */     
/* 156 */     if (flag) {
/* 157 */       targetEntity.field_70181_x += material.getKnockBack();
/* 158 */       func_174815_a(this, targetEntity);
/*     */     }
/*     */     
/* 161 */     func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
/* 162 */     return flag;
/*     */   }
/*     */   
/*     */   public void func_70636_d()
/*     */   {
/* 167 */     if ((func_70089_S()) && (this.ticksToLive >= 0) && (--this.ticksToLive == 0)) {
/* 168 */       if (!this.field_70170_p.field_72995_K) {
/* 169 */         BlockPos pos = new BlockPos(this);
/* 170 */         GolemMaterial m = getMaterial();
/* 171 */         for (int i = 0; i < 3; i++) {
/* 172 */           List<EntityLivingBase> owners = getOwnerEntities();
/* 173 */           if (BlockUtil.canEditBlock((owners != null) && (!owners.isEmpty()) ? (EntityLivingBase)owners.get(0) : this, this.field_70170_p, pos)) {
/* 174 */             IBlockState state = m.getBlocks()[0].func_176223_P();
/* 175 */             this.field_70170_p.func_175656_a(pos, state);
/* 176 */             this.field_70170_p.func_175718_b(2001, pos, Block.func_176210_f(state));
/*     */           }
/* 178 */           pos = pos.func_177984_a();
/*     */         }
/* 180 */         func_70106_y();
/*     */       }
/* 182 */       return;
/*     */     }
/* 184 */     super.func_70636_d();
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 189 */     super.func_70014_b(compound);
/* 190 */     compound.func_74768_a("mat", getMaterial().getId());
/* 191 */     if (this.ticksToLive >= 0) {
/* 192 */       compound.func_74768_a("ttl", this.ticksToLive);
/*     */     }
/*     */     
/* 195 */     if (getOwnerId() == null) {
/* 196 */       compound.func_74778_a("OwnerUUID", "");
/*     */     } else {
/* 198 */       compound.func_74778_a("OwnerUUID", getOwnerId());
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 204 */     super.func_70037_a(compound);
/* 205 */     setMaterial(GolemMaterial.idToMat(compound.func_74762_e("mat")));
/* 206 */     if (compound.func_150297_b("ttl", 3)) {
/* 207 */       this.ticksToLive = compound.func_74762_e("ttl");
/*     */     } else {
/* 209 */       this.ticksToLive = -1;
/*     */     }
/*     */     
/* 212 */     String s = "";
/*     */     
/* 214 */     if (compound.func_150297_b("OwnerUUID", 8)) {
/* 215 */       s = compound.func_74779_i("OwnerUUID");
/*     */     } else {
/* 217 */       String s1 = compound.func_74779_i("Owner");
/* 218 */       s = PreYggdrasilConverter.func_152719_a(s1);
/*     */     }
/*     */     
/* 221 */     if (s.length() > 0) {
/* 222 */       setOwnerId(s);
/*     */     }
/*     */   }
/*     */   
/*     */   protected String func_70621_aR()
/*     */   {
/* 228 */     return getMaterial().getHurtSound().LOCATION;
/*     */   }
/*     */   
/*     */   protected String func_70673_aS()
/*     */   {
/* 233 */     return getMaterial().getHurtSound().LOCATION;
/*     */   }
/*     */   
/*     */   protected void func_70628_a(boolean recentlyHit, int p_70628_2_)
/*     */   {
/* 238 */     ItemStack[] drops = getMaterial().getDrops();
/* 239 */     for (ItemStack stack : drops) {
/* 240 */       func_70099_a(stack.func_77946_l(), 0.0F);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityEarthGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */