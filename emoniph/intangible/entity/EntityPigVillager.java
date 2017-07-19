/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityLivingData;
/*     */ import net.minecraft.entity.ai.EntityAITasks;
/*     */ import net.minecraft.entity.monster.EntityPigZombie;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.passive.EntityPig;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.village.Village;
/*     */ import net.minecraft.world.DifficultyInstance;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ 
/*     */ public class EntityPigVillager extends EntityVillager
/*     */ {
/*     */   public EntityPigVillager(World worldIn)
/*     */   {
/*  26 */     this(worldIn, 0);
/*     */   }
/*     */   
/*     */   public EntityPigVillager(World worldIn, int professionId) {
/*  30 */     super(worldIn, professionId);
/*     */     
/*  32 */     this.field_70714_bg.field_75782_a.clear();
/*     */     
/*  34 */     this.field_70714_bg.func_75776_a(0, new net.minecraft.entity.ai.EntityAISwimming(this));
/*  35 */     this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6D, 0.6D));
/*  36 */     this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAITradePlayer(this));
/*  37 */     this.field_70714_bg.func_75776_a(1, new net.minecraft.entity.ai.EntityAILookAtTradePlayer(this));
/*  38 */     this.field_70714_bg.func_75776_a(2, new net.minecraft.entity.ai.EntityAIMoveIndoors(this));
/*  39 */     this.field_70714_bg.func_75776_a(3, new net.minecraft.entity.ai.EntityAIRestrictOpenDoor(this));
/*  40 */     this.field_70714_bg.func_75776_a(4, new net.minecraft.entity.ai.EntityAIOpenDoor(this, true));
/*  41 */     this.field_70714_bg.func_75776_a(5, new net.minecraft.entity.ai.EntityAIMoveTowardsRestriction(this, 0.6D));
/*  42 */     this.field_70714_bg.func_75776_a(6, new EntityAIPigVillagerMate(this));
/*  43 */     this.field_70714_bg.func_75776_a(7, new net.minecraft.entity.ai.EntityAIFollowGolem(this));
/*  44 */     this.field_70714_bg.func_75776_a(9, new net.minecraft.entity.ai.EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
/*  45 */     this.field_70714_bg.func_75776_a(9, new net.minecraft.entity.ai.EntityAIVillagerInteract(this));
/*  46 */     this.field_70714_bg.func_75776_a(9, new net.minecraft.entity.ai.EntityAIWander(this, 0.6D));
/*  47 */     this.field_70714_bg.func_75776_a(10, new net.minecraft.entity.ai.EntityAIWatchClosest(this, net.minecraft.entity.EntityLiving.class, 8.0F));
/*     */   }
/*     */   
/*  50 */   private static final Map<String, String> sounds = new java.util.HashMap();
/*     */   
/*     */   static {
/*  53 */     sounds.put("mob.villager.hit", "intangible:pigvillager.hit");
/*  54 */     sounds.put("mob.villager.haggle", "intangible:pigvillager.haggle");
/*  55 */     sounds.put("mob.villager.idle", "intangible:pigvillager.idle");
/*  56 */     sounds.put("mob.villager.death", "intangible:pigvillager.death");
/*  57 */     sounds.put("mob.villager.yes", "intangible:pigvillager.yes");
/*  58 */     sounds.put("mob.villager.no", "intangible:pigvillager.no");
/*     */   }
/*     */   
/*     */   public void func_85030_a(String name, float volume, float pitch)
/*     */   {
/*  63 */     String translated = (String)sounds.get(name);
/*  64 */     super.func_85030_a(translated != null ? translated : name, volume, pitch);
/*     */   }
/*     */   
/*     */ 
/*     */   public EntityVillager func_90011_a(net.minecraft.entity.EntityAgeable mate)
/*     */   {
/*  70 */     EntityPigVillager entity = new EntityPigVillager(this.field_70170_p);
/*  71 */     entity.func_180482_a(this.field_70170_p.func_175649_E(new BlockPos(entity)), null);
/*  72 */     return entity;
/*     */   }
/*     */   
/*     */   public void func_70077_a(net.minecraft.entity.effect.EntityLightningBolt lightningBolt)
/*     */   {
/*  77 */     if (!this.field_70170_p.field_72995_K) {
/*  78 */       EntityPig entity = new EntityPig(this.field_70170_p);
/*  79 */       entity.func_70012_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A);
/*  80 */       entity.func_180482_a(this.field_70170_p.func_175649_E(new BlockPos(entity)), null);
/*  81 */       this.field_70170_p.func_72838_d(entity);
/*  82 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   public IEntityLivingData func_180482_a(DifficultyInstance p_180482_1_, IEntityLivingData p_180482_2_)
/*     */   {
/*  88 */     IEntityLivingData result = super.func_180482_a(p_180482_1_, p_180482_2_);
/*  89 */     return result;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70645_a(DamageSource cause)
/*     */   {
/*  95 */     if (this.field_70954_d != null) {
/*  96 */       Entity entity = cause.func_76346_g();
/*     */       
/*  98 */       if (entity != null) {
/*  99 */         if ((entity instanceof EntityPlayer)) {
/* 100 */           this.field_70954_d.func_82688_a(entity.func_70005_c_(), -2);
/* 101 */         } else if ((entity instanceof net.minecraft.entity.monster.IMob)) {
/* 102 */           this.field_70954_d.func_82692_h();
/*     */         }
/*     */       } else {
/* 105 */         EntityPlayer entityplayer = this.field_70170_p.func_72890_a(this, 16.0D);
/*     */         
/* 107 */         if (entityplayer != null) {
/* 108 */           this.field_70954_d.func_82692_h();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 114 */     if (ForgeHooks.onLivingDeath(this, cause)) {
/* 115 */       return;
/*     */     }
/*     */     
/* 118 */     Entity entity = cause.func_76346_g();
/* 119 */     EntityLivingBase entitylivingbase = func_94060_bK();
/*     */     
/* 121 */     if ((this.field_70744_aE >= 0) && (entitylivingbase != null)) {
/* 122 */       entitylivingbase.func_70084_c(this, this.field_70744_aE);
/*     */     }
/*     */     
/* 125 */     if (entity != null) {
/* 126 */       if ((entity instanceof EntityZombie)) {
/* 127 */         if ((this.field_70170_p.func_175659_aa() == EnumDifficulty.HARD) || (
/* 128 */           (this.field_70170_p.func_175659_aa() == EnumDifficulty.NORMAL) && (this.field_70146_Z.nextBoolean()))) {
/* 129 */           EntityPigZombie entityzombie = new EntityPigZombie(this.field_70170_p);
/* 130 */           entityzombie.func_82149_j(this);
/* 131 */           this.field_70170_p.func_72900_e(this);
/* 132 */           entityzombie.func_180482_a(this.field_70170_p.func_175649_E(new BlockPos(entityzombie)), null);
/*     */           
/*     */ 
/* 135 */           if (func_70631_g_()) {
/* 136 */             entityzombie.func_82227_f(true);
/*     */           }
/* 138 */           this.field_70170_p.func_72838_d(entityzombie);
/* 139 */           this.field_70170_p.func_180498_a(null, 1016, new BlockPos(this), 0);
/*     */         }
/*     */       } else {
/* 142 */         entity.func_70074_a(this);
/*     */       }
/*     */     }
/*     */     
/* 146 */     this.field_70729_aU = true;
/* 147 */     func_110142_aN().func_94549_h();
/*     */     
/* 149 */     if (!this.field_70170_p.field_72995_K) {
/* 150 */       int i = 0;
/*     */       
/* 152 */       if ((entity instanceof EntityPlayer)) {
/* 153 */         i = net.minecraft.enchantment.EnchantmentHelper.func_77519_f((EntityLivingBase)entity);
/*     */       }
/*     */       
/* 156 */       this.captureDrops = true;
/* 157 */       this.capturedDrops.clear();
/*     */       
/* 159 */       if ((func_146066_aG()) && (this.field_70170_p.func_82736_K().func_82766_b("doMobLoot"))) {
/* 160 */         func_70628_a(this.field_70718_bc > 0, i);
/* 161 */         func_82160_b(this.field_70718_bc > 0, i);
/*     */         
/* 163 */         if ((this.field_70718_bc > 0) && (this.field_70146_Z.nextFloat() < 0.025F + i * 0.01F)) {
/* 164 */           func_82164_bB();
/*     */         }
/*     */       }
/*     */       
/* 168 */       this.captureDrops = false;
/*     */       
/* 170 */       if (!ForgeHooks.onLivingDrops(this, cause, this.capturedDrops, i, this.field_70718_bc > 0)) {
/* 171 */         for (net.minecraft.entity.item.EntityItem item : this.capturedDrops) {
/* 172 */           this.field_70170_p.func_72838_d(item);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 177 */     this.field_70170_p.func_72960_a(this, (byte)3);
/*     */   }
/*     */   
/*     */   private static class EntityAIPigVillagerMate extends net.minecraft.entity.ai.EntityAIBase {
/*     */     private EntityPigVillager villagerObj;
/*     */     private EntityPigVillager mate;
/*     */     private World worldObj;
/*     */     private int matingTimeout;
/*     */     private Village villageObj;
/*     */     
/*     */     public EntityAIPigVillagerMate(EntityPigVillager villager) {
/* 188 */       this.villagerObj = villager;
/* 189 */       this.worldObj = villager.field_70170_p;
/* 190 */       func_75248_a(3);
/*     */     }
/*     */     
/*     */     public boolean func_75250_a() {
/* 194 */       if (this.villagerObj.func_70874_b() != 0)
/* 195 */         return false;
/* 196 */       if (this.villagerObj.func_70681_au().nextInt(500) != 0) {
/* 197 */         return false;
/*     */       }
/* 199 */       this.villageObj = this.worldObj.func_175714_ae().func_176056_a(new BlockPos(this.villagerObj), 0);
/*     */       
/* 201 */       if (this.villageObj == null)
/* 202 */         return false;
/* 203 */       if ((checkSufficientDoorsPresentForNewVillager()) && (this.villagerObj.func_175550_n(true))) {
/* 204 */         Entity entity = this.worldObj.func_72857_a(EntityPigVillager.class, this.villagerObj.func_174813_aQ().func_72314_b(8.0D, 3.0D, 8.0D), this.villagerObj);
/*     */         
/* 206 */         if (entity == null) {
/* 207 */           return false;
/*     */         }
/* 209 */         this.mate = ((EntityPigVillager)entity);
/* 210 */         return (this.mate.func_70874_b() == 0) && (this.mate.func_175550_n(true));
/*     */       }
/*     */       
/* 213 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_75249_e()
/*     */     {
/* 219 */       this.matingTimeout = 300;
/* 220 */       this.villagerObj.func_70947_e(true);
/*     */     }
/*     */     
/*     */     public void func_75251_c() {
/* 224 */       this.villageObj = null;
/* 225 */       this.mate = null;
/* 226 */       this.villagerObj.func_70947_e(false);
/*     */     }
/*     */     
/*     */     public boolean func_75253_b()
/*     */     {
/* 231 */       return (this.matingTimeout >= 0) && (checkSufficientDoorsPresentForNewVillager()) && (this.villagerObj.func_70874_b() == 0) && (this.villagerObj.func_175550_n(false));
/*     */     }
/*     */     
/*     */     public void func_75246_d() {
/* 235 */       this.matingTimeout -= 1;
/* 236 */       this.villagerObj.func_70671_ap().func_75651_a(this.mate, 10.0F, 30.0F);
/*     */       
/* 238 */       if (this.villagerObj.func_70068_e(this.mate) > 2.25D) {
/* 239 */         this.villagerObj.func_70661_as().func_75497_a(this.mate, 0.25D);
/* 240 */       } else if ((this.matingTimeout == 0) && (this.mate.func_70941_o())) {
/* 241 */         giveBirth();
/*     */       }
/*     */       
/* 244 */       if (this.villagerObj.func_70681_au().nextInt(35) == 0) {
/* 245 */         this.worldObj.func_72960_a(this.villagerObj, (byte)12);
/*     */       }
/*     */     }
/*     */     
/*     */     private boolean checkSufficientDoorsPresentForNewVillager() {
/* 250 */       if (!this.villageObj.func_82686_i()) {
/* 251 */         return false;
/*     */       }
/* 253 */       int i = (int)(this.villageObj.func_75567_c() * 0.35D);
/* 254 */       return this.villageObj.func_75562_e() < i;
/*     */     }
/*     */     
/*     */     private void giveBirth()
/*     */     {
/* 259 */       EntityVillager entityvillager = this.villagerObj.func_90011_a(this.mate);
/* 260 */       this.mate.func_70873_a(6000);
/* 261 */       this.villagerObj.func_70873_a(6000);
/* 262 */       this.mate.func_175549_o(false);
/* 263 */       this.villagerObj.func_175549_o(false);
/* 264 */       entityvillager.func_70873_a(41536);
/* 265 */       entityvillager.func_70012_b(this.villagerObj.field_70165_t, this.villagerObj.field_70163_u, this.villagerObj.field_70161_v, 0.0F, 0.0F);
/* 266 */       this.worldObj.func_72838_d(entityvillager);
/* 267 */       this.worldObj.func_72960_a(entityvillager, (byte)12);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityPigVillager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */