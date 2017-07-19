/*     */ package emoniph.intangible.golem;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.golem.IGolem;
/*     */ import emoniph.intangible.api.golem.IGolemBody;
/*     */ import emoniph.intangible.client.models.ModelGolemBody;
/*     */ import emoniph.intangible.client.models.ModelGolemTurret;
/*     */ import emoniph.intangible.entity.EntitySeat;
/*     */ import emoniph.intangible.entity.EntitySpell;
/*     */ import emoniph.intangible.entity.EntityWreckingGolem;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class GolemBodyTurret
/*     */   implements IGolemBody
/*     */ {
/*     */   private final float healthBoost;
/*     */   private final int armorBonus;
/*     */   
/*     */   public GolemBodyTurret(float healthBoost, int armorBonus)
/*     */   {
/*  33 */     this.healthBoost = healthBoost;
/*  34 */     this.armorBonus = armorBonus;
/*     */   }
/*     */   
/*     */   public float getHealthBonus()
/*     */   {
/*  39 */     return this.healthBoost;
/*     */   }
/*     */   
/*     */   public int getArmorBonus()
/*     */   {
/*  44 */     return this.armorBonus;
/*     */   }
/*     */   
/*     */   public boolean seatRiderInteract(EntityLiving entity, final EntityPlayer player)
/*     */   {
/*  49 */     final World w = player.field_70170_p;
/*  50 */     if (!w.field_72995_K) {
/*  51 */       ((WorldServer)w).func_152344_a(new Runnable()
/*     */       {
/*     */         public void run() {
/*  54 */           EntitySpell spell = new EntitySpell(w, player, Get.spells().MINI_BOLT, 0.4D);
/*  55 */           spell.setColor(16777215, 10027042, 0.25F);
/*  56 */           Sound.MOD_RANDOM_SPELL1.playToAllNear(player, 0.5F, 2.0F);
/*  57 */           Vec3 vec = player.func_70040_Z().func_178787_e(player.func_70040_Z().func_178785_b(30.0F));
/*  58 */           double dist = 0.4D;
/*  59 */           spell.field_70165_t += vec.field_72450_a * dist;
/*  60 */           spell.field_70161_v += vec.field_72449_c * dist;
/*     */           
/*  62 */           w.func_72838_d(spell);
/*     */         }
/*     */       });
/*     */     }
/*     */     
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public boolean requiresSeat()
/*     */   {
/*  72 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  80 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/turret.png");
/*     */   
/*     */   public void onUpdate(IGolem golem, BlockPos prevBlockPos) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  85 */   public ResourceLocation getTexture() { return TEXTURE; }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected ModelGolemBody model;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelRenderer getModel()
/*     */   {
/*  94 */     if (this.model == null) {
/*  95 */       this.model = new ModelGolemTurret();
/*     */     }
/*  97 */     return this.model.body;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks)
/*     */   {
/* 103 */     if (this.model != null) {
/* 104 */       ModelGolemTurret turret = (ModelGolemTurret)this.model;
/* 105 */       EntityWreckingGolem golem = (EntityWreckingGolem)entity;
/* 106 */       if ((golem.getSeat() != null) && (golem.getSeat().field_70153_n != null) && ((golem.getSeat().field_70153_n instanceof EntityLivingBase)))
/*     */       {
/* 108 */         EntityLivingBase rider = (EntityLivingBase)golem.getSeat().field_70153_n;
/*     */         
/* 110 */         double golemYaw = golem.field_70177_z % 360.0F;
/* 111 */         if (golemYaw < 0.0D) {
/* 112 */           golemYaw += 360.0D;
/*     */         }
/*     */         
/* 115 */         double riderYaw = rider.field_70759_as % 360.0F;
/* 116 */         if (riderYaw < 0.0D) {
/* 117 */           riderYaw += 360.0D;
/*     */         }
/*     */         
/*     */ 
/* 121 */         double yaw = (riderYaw - golemYaw) % 360.0D;
/* 122 */         if (yaw < 0.0D) {
/* 123 */           yaw += 360.0D;
/*     */         }
/*     */         
/* 126 */         turret.top.field_78796_g = ((float)Math.toRadians(yaw));
/*     */         
/* 128 */         turret.gun.field_78795_f = ((float)Math.toRadians(((EntityLivingBase)golem.getSeat().field_70153_n).field_70125_A));
/*     */       } else {
/* 130 */         turret.top.field_78796_g = 0.0F;
/* 131 */         turret.gun.field_78795_f = 0.0F;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemBodyTurret.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */