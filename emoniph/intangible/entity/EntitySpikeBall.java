/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.config.Log;
/*     */ import emoniph.intangible.souls.ISoulHost;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import emoniph.intangible.spells.grenades.SpellGrenade;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySpikeBall extends EntityLiving implements net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData, ISoulHost
/*     */ {
/*     */   private SpellGrenade spell;
/*     */   public EntityLivingBase shootingEntity;
/*     */   public UUID shooterId;
/*     */   private int fuse;
/*     */   private int maxFuse;
/*     */   public float rotX;
/*     */   private static final float TWO_PI = 6.2831855F;
/*     */   
/*     */   public EntitySpikeBall(World worldIn)
/*     */   {
/*  29 */     super(worldIn);
/*  30 */     func_70105_a(0.5F, 0.5F);
/*  31 */     this.field_70747_aH = 0.3F;
/*     */     
/*  33 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */   public EntitySpikeBall(World worldIn, EntityLivingBase shooter, SpellGrenade spell) {
/*  37 */     super(worldIn);
/*  38 */     func_70105_a(0.5F, 0.5F);
/*     */     
/*  40 */     this.spell = spell;
/*  41 */     this.field_70747_aH = 0.3F;
/*     */     
/*  43 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70612_e(float p_70612_1_, float p_70612_2_)
/*     */   {
/*  49 */     super.func_70612_e(p_70612_1_, p_70612_2_);
/*  50 */     if (!this.field_70122_E) {
/*  51 */       this.field_70159_w /= 0.91D;
/*  52 */       this.field_70159_w *= 0.99999999D;
/*     */       
/*  54 */       this.field_70179_y /= 0.91D;
/*  55 */       this.field_70179_y *= 0.99999999D;
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/*  61 */     super.func_70088_a();
/*  62 */     func_70096_w().func_75682_a(12, Integer.valueOf(0));
/*  63 */     func_70096_w().func_75682_a(13, Float.valueOf(1.0F));
/*     */   }
/*     */   
/*     */   public EntitySpikeBall setColor(int color, float scale)
/*     */   {
/*  68 */     func_70096_w().func_75692_b(12, Integer.valueOf(color));
/*  69 */     func_70096_w().func_75692_b(13, Float.valueOf(scale));
/*  70 */     return this;
/*     */   }
/*     */   
/*     */   public int getColor() {
/*  74 */     return func_70096_w().func_75679_c(12);
/*     */   }
/*     */   
/*     */   public float getScale() {
/*  78 */     return func_70096_w().func_75679_c(12);
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource source, float amount) {
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public void setFuse(int fuse) {
/*  86 */     this.fuse = fuse;
/*  87 */     this.maxFuse = fuse;
/*     */   }
/*     */   
/*     */   public int getFuse() {
/*  91 */     return this.fuse;
/*     */   }
/*     */   
/*     */   public int ticksRemaining() {
/*  95 */     return this.fuse;
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 100 */     super.func_70014_b(compound);
/* 101 */     compound.func_74768_a("colorInner", getColor());
/* 102 */     compound.func_74768_a("fuse", this.fuse);
/* 103 */     compound.func_74768_a("maxFuse", this.maxFuse);
/* 104 */     String spellId = Get.spells().getIdForSpell(this.spell);
/* 105 */     if ((spellId == null) || (spellId.isEmpty())) {
/* 106 */       Get.log().warning("Trying to save a spell entity with an empty spell id!");
/* 107 */       func_70106_y();
/*     */     } else {
/* 109 */       compound.func_74778_a("spell", spellId);
/*     */     }
/* 111 */     compound.func_74776_a("spellScale", getScale());
/*     */     
/* 113 */     if ((this.shootingEntity != null) && (this.shootingEntity.func_70089_S())) {
/* 114 */       String uuid = this.shootingEntity.func_110124_au().toString();
/* 115 */       if ((uuid == null) || (uuid.isEmpty())) {
/* 116 */         Get.log().warning("Trying to save a spell entity with an empty shooter id!");
/*     */       }
/* 118 */       compound.func_74778_a("shooter", uuid);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 124 */     super.func_70037_a(compound);
/* 125 */     float scale = compound.func_74760_g("spellScale");
/*     */     
/* 127 */     if (scale <= 0.0F) {
/* 128 */       scale = 1.0F;
/*     */     }
/* 130 */     setColor(compound.func_74762_e("color"), scale);
/* 131 */     this.fuse = compound.func_74762_e("fuse");
/* 132 */     this.maxFuse = compound.func_74762_e("maxFuse");
/* 133 */     if (compound.func_150297_b("spell", 8)) {
/* 134 */       this.spell = ((SpellGrenade)Get.spells().getSpellForId(compound.func_74779_i("spell")));
/*     */     } else {
/* 136 */       func_70106_y();
/*     */     }
/*     */     
/* 139 */     if (compound.func_150297_b("shooter", 8)) {
/* 140 */       this.shooterId = UUID.fromString(compound.func_74779_i("shooter"));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70030_z()
/*     */   {
/* 149 */     if ((this.field_70159_w != 0.0D) && (this.field_70179_y != 0.0D))
/*     */     {
/* 151 */       double dx = this.field_70165_t - this.field_70169_q;
/* 152 */       double dy = this.field_70163_u - this.field_70167_r;
/* 153 */       double dz = this.field_70161_v - this.field_70166_s;
/*     */       
/* 155 */       float dist = (float)Math.sqrt(dx * dx + dy * dy + dz * dz);
/*     */       
/* 157 */       if (dist > 0.0F) {
/* 158 */         this.rotX = ((this.rotX + dist / 0.125F) % 6.2831855F);
/*     */       }
/*     */     }
/*     */     
/* 162 */     super.func_70030_z();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 167 */     if ((!this.field_70170_p.field_72995_K) && (this.shooterId != null)) {
/* 168 */       double range = 128.0D;
/* 169 */       java.util.List<EntityLivingBase> list = this.field_70170_p.func_72872_a(EntityLivingBase.class, func_174813_aQ().func_72314_b(128.0D, 128.0D, 128.0D));
/* 170 */       for (EntityLivingBase entity : list) {
/* 171 */         if (entity.func_110124_au().equals(this.shooterId)) {
/* 172 */           this.shootingEntity = entity;
/* 173 */           break;
/*     */         }
/*     */       }
/* 176 */       this.shooterId = null;
/*     */     }
/*     */     
/* 179 */     if (--this.fuse <= 0) {
/* 180 */       if (!this.field_70170_p.field_72995_K) {
/* 181 */         this.spell.explode(this, this.shootingEntity);
/* 182 */         func_70106_y();
/*     */       }
/*     */     }
/* 185 */     else if ((func_70089_S()) && (this.spell != null)) {
/* 186 */       this.spell.tick(this, this.shootingEntity);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void writeSpawnData(ByteBuf buf)
/*     */   {
/* 193 */     buf.writeInt(this.maxFuse);
/* 194 */     buf.writeInt(this.fuse);
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf buf)
/*     */   {
/* 199 */     this.maxFuse = buf.readInt();
/* 200 */     this.fuse = buf.readInt();
/*     */   }
/*     */   
/*     */   public emoniph.intangible.api.SoulType getSoulType()
/*     */   {
/* 205 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isTrappableInBoneCage()
/*     */   {
/* 210 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isCorporeal()
/*     */   {
/* 215 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySpikeBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */