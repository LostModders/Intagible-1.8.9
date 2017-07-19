/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.config.Log;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import emoniph.intangible.spells.projectiles.SpellProjectile;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySpell extends EntitySpellBase
/*     */ {
/*     */   private SpellProjectile spell;
/*     */   
/*     */   public EntitySpell(World worldIn)
/*     */   {
/*  23 */     super(worldIn);
/*  24 */     func_70105_a(0.8F, 0.8F);
/*     */   }
/*     */   
/*     */   public EntitySpell(World worldIn, EntityLivingBase shooter, SpellProjectile spell, double speed) {
/*  28 */     super(worldIn, shooter, 0.0D, 0.0D, 0.0D, speed);
/*  29 */     func_70105_a(0.8F, 0.8F);
/*  30 */     setSpell(spell);
/*     */   }
/*     */   
/*     */   public EntitySpell(World worldIn, EntityLivingBase shooter, SpellProjectile spell, double speed, float angle)
/*     */   {
/*  35 */     super(worldIn, shooter, 0.0D, 0.0D, 0.0D, speed, angle);
/*  36 */     func_70105_a(0.8F, 0.8F);
/*  37 */     setSpell(spell);
/*     */   }
/*     */   
/*     */   public EntitySpell(World worldIn, EntityLivingBase shooter, EntityLivingBase target, SpellProjectile spell, double speed)
/*     */   {
/*  42 */     super(worldIn, shooter, shooter, target, 0.0D, 0.0D, 0.0D, speed);
/*  43 */     func_70105_a(0.8F, 0.8F);
/*  44 */     setSpell(spell);
/*     */   }
/*     */   
/*     */   public EntitySpell(World worldIn, EntityLivingBase shooter, Entity proxySource, EntityLivingBase target, SpellProjectile spell, double speed)
/*     */   {
/*  49 */     super(worldIn, shooter, proxySource, target, 0.0D, 0.0D, 0.0D, speed);
/*  50 */     func_70105_a(0.8F, 0.8F);
/*  51 */     setSpell(spell);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean ignoreIncorporeal()
/*     */   {
/*  57 */     return (getSpell() == null) || (!getSpell().canTargetIncorporealEntities());
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/*  62 */     super.func_70088_a();
/*  63 */     func_70096_w().func_75682_a(12, Integer.valueOf(0));
/*  64 */     func_70096_w().func_75682_a(13, Integer.valueOf(0));
/*  65 */     func_70096_w().func_75682_a(14, Float.valueOf(1.0F));
/*  66 */     func_70096_w().func_75682_a(15, Integer.valueOf(-1));
/*     */   }
/*     */   
/*     */   public EntitySpell setColor(int color) {
/*  70 */     return setColor(color, color, 1.0F);
/*     */   }
/*     */   
/*     */   public EntitySpell setColor(int innerColor, int outerColor, float scale) {
/*  74 */     func_70096_w().func_75692_b(12, Integer.valueOf(innerColor));
/*  75 */     func_70096_w().func_75692_b(13, Integer.valueOf(outerColor));
/*  76 */     func_70096_w().func_75692_b(14, Float.valueOf(scale));
/*  77 */     return this;
/*     */   }
/*     */   
/*     */   private void setSpell(SpellProjectile spell) {
/*  81 */     this.spell = spell;
/*  82 */     func_70096_w().func_75692_b(15, Integer.valueOf(Get.spells().getIndexFromSpell(spell)));
/*     */   }
/*     */   
/*     */   public SpellProjectile getSpell() {
/*  86 */     if (this.spell == null) {
/*  87 */       int index = func_70096_w().func_75679_c(15);
/*  88 */       this.spell = ((SpellProjectile)Get.spells().getSpellFromIndex(index));
/*     */     }
/*  90 */     return this.spell;
/*     */   }
/*     */   
/*     */   public int getInnerColor() {
/*  94 */     return func_70096_w().func_75679_c(12);
/*     */   }
/*     */   
/*     */   public int getOuterColor() {
/*  98 */     return func_70096_w().func_75679_c(13);
/*     */   }
/*     */   
/*     */   public float getScale() {
/* 102 */     return func_70096_w().func_111145_d(14);
/*     */   }
/*     */   
/*     */   protected int getMaxTicksInAir()
/*     */   {
/* 107 */     return getSpell() != null ? getSpell().getMaxAirTicks() : 200;
/*     */   }
/*     */   
/*     */   protected int getMaxTicksInGround()
/*     */   {
/* 112 */     return getSpell() != null ? getSpell().getMaxGroundTicks() : 600;
/*     */   }
/*     */   
/*     */   protected void onImpact(MovingObjectPosition movingObject)
/*     */   {
/* 117 */     if ((!this.field_70170_p.field_72995_K) && ((movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK) || ((movingObject.field_72308_g instanceof EntityLivingBase))) && 
/* 118 */       (getSpell() != null) && 
/* 119 */       (getSpell().impact(this, movingObject, this.shootingEntity))) {
/* 120 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_70071_h_()
/*     */   {
/* 129 */     super.func_70071_h_();
/* 130 */     float scale = getScale();
/*     */     
/* 132 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/*     */ 
/*     */ 
/* 136 */       Intangible.PROXY.glow(this.field_70170_p, this.field_70169_q, this.field_70167_r, this.field_70166_s).scale(2.0F * this.field_70130_N * scale).color(getOuterColor()).duration(2).motion(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       
/* 138 */       Intangible.PROXY.glow(this.field_70170_p, this.field_70169_q, this.field_70167_r, this.field_70166_s).scale(1.5F * this.field_70130_N * scale)
/* 139 */         .color(getInnerColor())
/* 140 */         .duration(1)
/* 141 */         .motion(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 148 */     super.func_70014_b(compound);
/* 149 */     compound.func_74768_a("colorInner", getInnerColor());
/* 150 */     compound.func_74768_a("colorOuter", getOuterColor());
/* 151 */     String spellId = Get.spells().getIdForSpell(getSpell());
/* 152 */     if ((spellId == null) || (spellId.isEmpty())) {
/* 153 */       Get.log().warning("Trying to save a spell entity with an empty spell id!");
/* 154 */       func_70106_y();
/*     */     } else {
/* 156 */       compound.func_74778_a("spell", spellId);
/*     */     }
/* 158 */     compound.func_74776_a("spellScale", getScale());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 165 */     super.func_70037_a(compound);
/* 166 */     float scale = compound.func_74760_g("spellScale");
/* 167 */     if (scale <= 0.0F) {
/* 168 */       scale = 1.0F;
/*     */     }
/* 170 */     setColor(compound.func_74762_e("colorInner"), compound.func_74762_e("colorOuter"), scale);
/* 171 */     if (compound.func_150297_b("spell", 8)) {
/* 172 */       setSpell((SpellProjectile)Get.spells().getSpellForId(compound.func_74779_i("spell")));
/*     */     } else {
/* 174 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_70106_y()
/*     */   {
/* 182 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void setAcceleration(double motionX, double motionY, double motionZ) {
/* 186 */     this.accelerationX = motionX;
/* 187 */     this.accelerationY = motionY;
/* 188 */     this.accelerationZ = motionZ;
/*     */   }
/*     */   
/*     */   public void increaseAcceleration(double motionX, double motionY, double motionZ) {
/* 192 */     this.accelerationX += motionX;
/* 193 */     this.accelerationY += motionY;
/* 194 */     this.accelerationZ += motionZ;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySpell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */