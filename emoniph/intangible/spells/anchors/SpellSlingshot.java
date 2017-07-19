/*     */ package emoniph.intangible.spells.anchors;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.entity.EntitySpellAnchor;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class SpellSlingshot extends SpellAnchor
/*     */ {
/*     */   private static final double SMALL_SPEED = 0.009999999776482582D;
/*     */   
/*     */   public SpellSlingshot()
/*     */   {
/*  19 */     super(16777215, 3377305);
/*     */   }
/*     */   
/*     */   public void invoke(EntityPlayer player)
/*     */   {
/*  24 */     List<EntityLivingBase> targets = new java.util.ArrayList();
/*  25 */     boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, player);
/*  26 */     boolean overclocked = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player);
/*  27 */     float radiusSq; if (unexpected) {
/*  28 */       float radius = overclocked ? 8.0F : 4.0F;
/*  29 */       radiusSq = radius * radius;
/*  30 */       List<EntityLivingBase> list = player.field_70170_p.func_72872_a(EntityLivingBase.class, player.func_174813_aQ().func_72314_b(radius, radius * 0.5F, radius));
/*  31 */       for (EntityLivingBase entity : list) {
/*  32 */         if ((entity != player) && (entity.func_70068_e(player) <= radiusSq) && (entity.func_70089_S())) {
/*  33 */           targets.add(entity);
/*     */         }
/*     */       }
/*     */     } else {
/*  37 */       targets.add(player);
/*     */     }
/*  39 */     throwAnchor(player, this.colorInner, this.colorOuter, targets);
/*  40 */     emoniph.intangible.Sound.MOD_RANDOM_SPELL2.playToAllNear(player, 0.5F);
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public boolean drawConnectingLine(EntitySpellAnchor anchor)
/*     */   {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   private boolean isNoMovement(double speed)
/*     */   {
/*  51 */     double SMALL_SPEED = 0.02D;
/*  52 */     return (speed >= -0.02D) && (speed <= 0.02D);
/*     */   }
/*     */   
/*     */   public boolean update(EntitySpellAnchor anchor, List<EntityLivingBase> linked)
/*     */   {
/*  57 */     for (Iterator<EntityLivingBase> itr = linked.iterator(); itr.hasNext();) {
/*  58 */       EntityLivingBase entity = (EntityLivingBase)itr.next();
/*     */       
/*  60 */       boolean still = (isNoMovement(entity.field_70701_bs)) && (isNoMovement(entity.field_70702_br)) && (isNoMovement(entity.field_70159_w)) && (isNoMovement(entity.field_70179_y));
/*  61 */       if ((still) && ((entity instanceof EntityPlayer))) {
/*  62 */         PlayerEx playerEx = PlayerEx.get((EntityPlayer)entity);
/*  63 */         still = (playerEx.CACHE.prevX == entity.field_70165_t) && (playerEx.CACHE.prevZ == entity.field_70161_v);
/*     */       }
/*  65 */       if (still)
/*     */       {
/*  67 */         double dx = anchor.field_70165_t - entity.field_70165_t;
/*  68 */         double dy = anchor.field_70163_u - entity.field_70163_u;
/*  69 */         double dz = anchor.field_70161_v - entity.field_70161_v;
/*     */         
/*     */ 
/*  72 */         float f = net.minecraft.util.MathHelper.func_76133_a(dx * dx + dy * dy + dz * dz);
/*  73 */         if (f < 4.0F) {
/*  74 */           return false;
/*     */         }
/*     */         
/*  77 */         double d0 = (anchor.field_70165_t - entity.field_70165_t) / f;
/*  78 */         double d1 = (anchor.field_70163_u - entity.field_70163_u) / f;
/*  79 */         double d2 = (anchor.field_70161_v - entity.field_70161_v) / f;
/*  80 */         double speed = Math.min(f * 0.5D, 11.0D);
/*  81 */         double mx = d0 * Math.abs(d0) * speed;
/*  82 */         double my = d1 * Math.abs(d1) * speed;
/*  83 */         my = my > 1.0D ? my : my + 1.0D;
/*  84 */         double mz = d2 * Math.abs(d2) * speed;
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
/*     */ 
/*     */ 
/*     */ 
/*  99 */         if ((entity instanceof EntityPlayer)) {
/* 100 */           EntityPlayer player = (EntityPlayer)entity;
/*     */           
/* 102 */           PlayerEx playerEx = PlayerEx.get(player);
/* 103 */           playerEx.enableEffectWithCooldown(Get.effects().SLOWFALL, 100);
/* 104 */           entity.field_70159_w += mx;
/* 105 */           entity.field_70181_x += my;
/* 106 */           entity.field_70179_y += mz;
/* 107 */           Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketMotion(player, mx, my, mz, true), player);
/*     */         } else {
/* 109 */           entity.field_70159_w += mx;
/* 110 */           entity.field_70181_x += my;
/* 111 */           entity.field_70179_y += mz;
/*     */         }
/*     */         
/* 114 */         if (f > 12.0F)
/*     */         {
/* 116 */           itr.remove();
/* 117 */           if (linked.isEmpty()) {
/* 118 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 124 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/anchors/SpellSlingshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */