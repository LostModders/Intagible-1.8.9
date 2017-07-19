/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.monster.EntityIronGolem;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityHollowIronGolem extends EntityIronGolem
/*     */ {
/*     */   private String entityClass;
/*     */   private float entityWidth;
/*     */   private float entityHeight;
/*     */   
/*     */   public EntityHollowIronGolem(World worldIn)
/*     */   {
/*  20 */     super(worldIn);
/*     */     
/*  22 */     setTrappedSoul(null, null, 0.0F, 0.0F);
/*     */     
/*  24 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/*  29 */     super.func_70088_a();
/*  30 */     this.field_70180_af.func_75682_a(17, Byte.valueOf((byte)0));
/*  31 */     this.field_70180_af.func_75682_a(18, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public boolean isUpgraded() {
/*  35 */     return this.field_70180_af.func_75683_a(18) == 1;
/*     */   }
/*     */   
/*     */   private void setUpgraded(boolean upgraded) {
/*  39 */     this.field_70180_af.func_75692_b(18, Byte.valueOf((byte)(upgraded ? 1 : 0)));
/*     */   }
/*     */   
/*     */   public boolean func_110164_bC()
/*     */   {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/*  49 */     super.func_70071_h_();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SoulType getTrappedSoul()
/*     */   {
/*  64 */     byte b = this.field_70180_af.func_75683_a(17);
/*  65 */     if (b < 0) {
/*  66 */       return null;
/*     */     }
/*  68 */     return EnumSoulType.byMetadata(b).toSoulType();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setTrappedSoul(SoulType soulType, String entityClass, float width, float height)
/*     */   {
/*  77 */     if (!this.field_70170_p.field_72995_K) {
/*  78 */       byte meta = -1;
/*  79 */       if (soulType != null) {
/*  80 */         meta = (byte)EnumSoulType.fromSoulType(soulType).getMetadata();
/*  81 */         this.entityClass = entityClass;
/*  82 */         this.entityHeight = width;
/*  83 */         this.entityHeight = height;
/*  84 */         if (soulType == SoulType.NOBLE) {
/*  85 */           setUpgraded(true);
/*     */         }
/*  87 */         this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAISwimming(this));
/*  88 */         this.field_70714_bg.func_75776_a(2, new net.minecraft.entity.ai.EntityAIWander(this, 0.8D));
/*  89 */         this.field_70714_bg.func_75776_a(3, new net.minecraft.entity.ai.EntityAIWatchClosest(this, net.minecraft.entity.player.EntityPlayer.class, 8.0F));
/*  90 */         this.field_70714_bg.func_75776_a(3, new net.minecraft.entity.ai.EntityAILookIdle(this));
/*     */       } else {
/*  92 */         this.field_70715_bh.field_75782_a.clear();
/*  93 */         this.field_70714_bg.field_75782_a.clear();
/*  94 */         this.entityClass = null;
/*  95 */         this.entityWidth = 0.0F;
/*  96 */         this.entityHeight = 0.0F;
/*     */       }
/*     */       
/*  99 */       this.field_70180_af.func_75692_b(17, Byte.valueOf(meta));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 105 */     super.func_70014_b(compound);
/* 106 */     SoulType soulType = getTrappedSoul();
/* 107 */     if (soulType != null) {
/* 108 */       compound.func_74768_a("trappedSoul", EnumSoulType.fromSoulType(soulType).getMetadata());
/* 109 */       if (this.entityClass != null) {
/* 110 */         compound.func_74778_a("trappedClass", this.entityClass);
/* 111 */         compound.func_74776_a("trappedWidth", this.entityWidth);
/* 112 */         compound.func_74776_a("trappedHeight", this.entityHeight);
/*     */       }
/*     */     }
/*     */     
/* 116 */     compound.func_74757_a("upgraded", isUpgraded());
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 121 */     super.func_70037_a(compound);
/* 122 */     if ((compound.func_150297_b("trappedSoul", 3)) && (compound.func_150297_b("trappedClass", 8)))
/*     */     {
/* 124 */       setTrappedSoul(EnumSoulType.byMetadata(compound.func_74762_e("trappedSoul")).toSoulType(), compound
/* 125 */         .func_74779_i("trappedClass"), compound.func_74760_g("trappedWidth"), compound.func_74760_g("trappedHeight"));
/*     */     } else {
/* 127 */       setTrappedSoul(null, null, 0.0F, 0.0F);
/*     */     }
/*     */     
/* 130 */     if (compound.func_74764_b("upgraded")) {
/* 131 */       setUpgraded(compound.func_74767_n("upgraded"));
/*     */     }
/*     */   }
/*     */   
/*     */   public static boolean hasSoul(EntityLivingBase entity) {
/* 136 */     return ((entity instanceof EntityHollowIronGolem)) && (((EntityHollowIronGolem)entity).getTrappedSoul() != null);
/*     */   }
/*     */   
/*     */   public void syncToSoul(EntitySoul soul) {
/* 140 */     soul.setEntityType(this.entityClass);
/* 141 */     soul.func_70105_a(0.5F, Math.max(1.0F, this.entityHeight));
/*     */   }
/*     */   
/*     */   public Class<? extends net.minecraft.entity.EntityLiving> getTrappedSoulType() {
/* 145 */     return (Class)net.minecraft.entity.EntityList.field_75625_b.get(this.entityClass);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityHollowIronGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */