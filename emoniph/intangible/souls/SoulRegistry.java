/*     */ package emoniph.intangible.souls;
/*     */ 
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntityHollowIronGolem;
/*     */ import emoniph.intangible.entity.EntitySoul;
/*     */ import emoniph.intangible.entity.EntityWreckingGolem;
/*     */ import emoniph.intangible.util.EntityUtil;
/*     */ import emoniph.intangible.util.NbtUtil;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.monster.EntityGuardian;
/*     */ import net.minecraft.entity.monster.EntityPigZombie;
/*     */ import net.minecraft.entity.monster.EntityWitch;
/*     */ import net.minecraft.entity.passive.EntityCow;
/*     */ import net.minecraft.entity.passive.EntityPig;
/*     */ import net.minecraft.entity.passive.EntityVillager;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ 
/*     */ public class SoulRegistry implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModPreInit
/*     */ {
/*  31 */   private final Map<Class<? extends EntityLiving>, Entry> soulMap = new HashMap();
/*  32 */   private final Map<SoulType, List<Entry>> typeToClass = new HashMap();
/*     */   
/*     */   static class Entry
/*     */   {
/*     */     private final Class<? extends EntityLiving> entityClass;
/*     */     private final SoulType soulType;
/*     */     private final Class<? extends EntityLiving> soullessClass;
/*     */     private final boolean trappable;
/*     */     
/*     */     public Entry(Class<? extends EntityLiving> entityClass, SoulType soulType, boolean trappable, Class<? extends EntityLiving> soullessClass)
/*     */     {
/*  43 */       this.entityClass = entityClass;
/*  44 */       this.soulType = soulType;
/*  45 */       this.soullessClass = soullessClass;
/*  46 */       this.trappable = trappable;
/*     */     }
/*     */   }
/*     */   
/*     */   public void register(Class<? extends EntityLiving> entityClass, SoulType soulType, boolean trappableInSoulcage) {
/*  51 */     register(entityClass, soulType, trappableInSoulcage, null);
/*     */   }
/*     */   
/*     */   public void register(Class<? extends EntityLiving> entityClass, SoulType soulType, boolean trappableInSoulcage, Class<? extends EntityLiving> soullessClass) {
/*  55 */     Entry entry = new Entry(entityClass, soulType, trappableInSoulcage, soullessClass);
/*  56 */     this.soulMap.put(entityClass, entry);
/*  57 */     List<Entry> list = (List)this.typeToClass.get(soulType);
/*  58 */     if (list == null) {
/*  59 */       list = new ArrayList();
/*  60 */       this.typeToClass.put(soulType, list);
/*     */     }
/*  62 */     list.add(entry);
/*     */   }
/*     */   
/*     */   public SoulType getSoulFor(Class<? extends EntityLivingBase> entityClass) {
/*  66 */     if (entityClass == null)
/*  67 */       return null;
/*  68 */     if (entityClass.isAssignableFrom(EntityPlayer.class)) {
/*  69 */       return SoulType.WISE;
/*     */     }
/*     */     
/*  72 */     Entry entry = (Entry)this.soulMap.get(entityClass);
/*  73 */     if (entry != null)
/*  74 */       return entry.soulType;
/*  75 */     if (EntityVillager.class.isAssignableFrom(entityClass)) {
/*  76 */       return SoulType.WISE;
/*     */     }
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isEntityRegistered(Class<? extends EntityLiving> entityClass) {
/*  82 */     if (entityClass == null) {
/*  83 */       return false;
/*     */     }
/*     */     
/*  86 */     return this.soulMap.get(entityClass) != null;
/*     */   }
/*     */   
/*     */   public boolean isStrongSoul(EntityLiving entity) {
/*  90 */     SoulType soul = getSoulFor(entity.getClass());
/*  91 */     if (soul == null) {
/*  92 */       return false;
/*     */     }
/*  94 */     return EnumSoulType.fromSoulType(soul).isStrongSoul();
/*     */   }
/*     */   
/*     */   public boolean isTrappable(EntityLiving entity) {
/*  98 */     if (entity == null) {
/*  99 */       return false;
/*     */     }
/* 101 */     if ((entity instanceof ISoulHost)) {
/* 102 */       return ((ISoulHost)entity).isTrappableInBoneCage();
/*     */     }
/* 104 */     Entry entry = (Entry)this.soulMap.get(entity.getClass());
/* 105 */     if (entry != null)
/* 106 */       return entry.trappable;
/* 107 */     if (EntityVillager.class.isAssignableFrom(entity.getClass())) {
/* 108 */       return true;
/*     */     }
/* 110 */     return !(entity instanceof net.minecraft.entity.boss.IBossDisplayData);
/*     */   }
/*     */   
/*     */   public SoulType getSoulForSoul(EntitySoul soul) {
/* 114 */     return getSoulFor((Class)EntityList.field_75625_b.get(soul.getEntityType()));
/*     */   }
/*     */   
/*     */   public String getDefaultEntityFor(SoulType soulType) {
/* 118 */     List<Entry> list = (List)this.typeToClass.get(soulType);
/* 119 */     if ((list != null) && (!list.isEmpty()) && (list.get(0) != null)) {
/* 120 */       return (String)EntityList.field_75626_c.get(((Entry)list.get(0)).entityClass);
/*     */     }
/* 122 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isSoulPresent(EntityLivingBase entity, boolean ignoreChildren) {
/* 126 */     if ((entity instanceof EntityPlayer))
/* 127 */       return true;
/* 128 */     if (EntityHollowIronGolem.hasSoul(entity))
/* 129 */       return true;
/* 130 */     if ((NbtUtil.forEntity(entity) != null) && (NbtUtil.forEntity(entity).func_74767_n("noSoul")))
/* 131 */       return false;
/* 132 */     if (((entity instanceof EntityVillager)) && (entity.func_70631_g_()) && (ignoreChildren)) {
/* 133 */       return false;
/*     */     }
/* 135 */     return true;
/*     */   }
/*     */   
/*     */   public void setSoulInEntity(EntityLivingBase entity, boolean hasSoul)
/*     */   {
/* 140 */     if (!(entity instanceof EntityPlayer)) {
/* 141 */       NbtUtil.forEntity(entity).func_74757_a("noSoul", !hasSoul);
/* 142 */       syncSoulInEntity(entity);
/*     */     }
/*     */   }
/*     */   
/*     */   public void syncSoulInEntity(EntityLivingBase entity) {
/* 147 */     if (((entity instanceof EntityLiving)) && 
/* 148 */       (!entity.field_70170_p.field_72995_K) && (!isSoulPresent(entity, false))) {
/* 149 */       EntityLiving livingEntity = (EntityLiving)entity;
/* 150 */       EntityUtil.clearTasks(livingEntity, livingEntity.field_70714_bg);
/* 151 */       EntityUtil.clearTasks(livingEntity, livingEntity.field_70715_bh);
/* 152 */       livingEntity.func_70624_b(null);
/* 153 */       livingEntity.func_70604_c(null);
/*     */     }
/*     */   }
/*     */   
/*     */   public EntityLiving createSoullessEntityFor(World world, EntityLiving entity)
/*     */   {
/* 159 */     Entry entry = (Entry)this.soulMap.get(entity.getClass());
/* 160 */     if ((entry != null) && (entry.soullessClass != null)) {
/*     */       try {
/* 162 */         Constructor<? extends EntityLiving> constructor = entry.soullessClass.getConstructor(new Class[] { World.class });
/* 163 */         EntityLiving proxyEntity = (EntityLiving)constructor.newInstance(new Object[] { world });
/* 164 */         proxyEntity.func_70107_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/*     */         
/* 166 */         proxyEntity.field_70142_S = entity.field_70142_S;
/* 167 */         proxyEntity.field_70137_T = entity.field_70137_T;
/* 168 */         proxyEntity.field_70136_U = entity.field_70136_U;
/*     */         
/* 170 */         proxyEntity.field_70159_w = entity.field_70159_w;
/* 171 */         proxyEntity.field_70181_x = entity.field_70181_x;
/* 172 */         proxyEntity.field_70179_y = entity.field_70179_y;
/*     */         
/* 174 */         proxyEntity.field_70701_bs = entity.field_70701_bs;
/* 175 */         proxyEntity.field_70702_br = entity.field_70702_br;
/*     */         
/* 177 */         proxyEntity.field_70122_E = entity.field_70122_E;
/*     */         
/* 179 */         proxyEntity.field_70169_q = entity.field_70169_q;
/* 180 */         proxyEntity.field_70167_r = entity.field_70167_r;
/* 181 */         proxyEntity.field_70166_s = entity.field_70166_s;
/*     */         
/* 183 */         proxyEntity.field_70125_A = entity.field_70125_A;
/* 184 */         proxyEntity.field_70177_z = entity.field_70177_z;
/* 185 */         proxyEntity.field_70759_as = entity.field_70759_as;
/*     */         
/* 187 */         proxyEntity.field_70127_C = entity.field_70127_C;
/* 188 */         proxyEntity.field_70126_B = entity.field_70126_B;
/* 189 */         proxyEntity.field_70758_at = entity.field_70758_at;
/*     */         
/* 191 */         proxyEntity.field_70754_ba = entity.field_70754_ba;
/*     */         
/* 193 */         proxyEntity.field_70721_aZ = entity.field_70721_aZ;
/* 194 */         proxyEntity.field_70722_aY = entity.field_70722_aY;
/* 195 */         proxyEntity.field_82175_bq = entity.field_82175_bq;
/*     */         
/* 197 */         proxyEntity.field_70733_aJ = entity.field_70733_aJ;
/* 198 */         proxyEntity.field_70732_aI = entity.field_70732_aI;
/*     */         
/* 200 */         proxyEntity.field_70761_aq = entity.field_70761_aq;
/* 201 */         proxyEntity.field_70760_ar = entity.field_70760_ar;
/*     */         
/* 203 */         return proxyEntity;
/*     */       }
/*     */       catch (NoSuchMethodException localNoSuchMethodException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InvocationTargetException localInvocationTargetException) {}catch (InstantiationException localInstantiationException) {}
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 211 */     return null;
/*     */   }
/*     */   
/*     */   public void updateLivingSoul(EntityLivingBase entity) {
/* 215 */     if ((entity.field_70173_aa % 100 == 0) && (!entity.field_70170_p.field_72995_K) && ((entity instanceof EntityLiving)) && (!isSoulPresent(entity, false))) {
/* 216 */       entity.func_70097_a(emoniph.intangible.util.DamageSourceSoul.SOULLESS, 4.0F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/* 226 */     register(net.minecraft.entity.passive.EntityBat.class, SoulType.BENIGN, true);
/* 227 */     register(EntityPig.class, SoulType.BENIGN, true);
/* 228 */     register(net.minecraft.entity.passive.EntitySheep.class, SoulType.BENIGN, true);
/* 229 */     register(EntityCow.class, SoulType.BENIGN, true);
/* 230 */     register(net.minecraft.entity.passive.EntityChicken.class, SoulType.BENIGN, true);
/* 231 */     register(net.minecraft.entity.passive.EntitySquid.class, SoulType.BENIGN, true);
/* 232 */     register(net.minecraft.entity.passive.EntityHorse.class, SoulType.BENIGN, true);
/* 233 */     register(net.minecraft.entity.passive.EntityRabbit.class, SoulType.BENIGN, true);
/* 234 */     register(net.minecraft.entity.passive.EntityMooshroom.class, SoulType.BENIGN, true);
/*     */     
/*     */ 
/* 237 */     register(net.minecraft.entity.monster.EntityIronGolem.class, SoulType.IMMUTABLE, true, EntityHollowIronGolem.class);
/*     */     
/*     */ 
/* 240 */     register(net.minecraft.entity.passive.EntityWolf.class, SoulType.PREDATORY, true);
/* 241 */     register(net.minecraft.entity.passive.EntityOcelot.class, SoulType.PREDATORY, true);
/* 242 */     register(net.minecraft.entity.monster.EntitySpider.class, SoulType.PREDATORY, true);
/* 243 */     register(net.minecraft.entity.monster.EntityCaveSpider.class, SoulType.PREDATORY, true);
/* 244 */     register(net.minecraft.entity.monster.EntitySilverfish.class, SoulType.PREDATORY, true);
/* 245 */     register(EntityGuardian.class, SoulType.PREDATORY, true);
/* 246 */     register(net.minecraft.entity.monster.EntityEndermite.class, SoulType.PREDATORY, true);
/*     */     
/* 248 */     register(net.minecraft.entity.monster.EntityGhast.class, SoulType.PREDATORY, true);
/* 249 */     register(net.minecraft.entity.monster.EntityBlaze.class, SoulType.PREDATORY, true);
/* 250 */     register(net.minecraft.entity.monster.EntitySlime.class, SoulType.PREDATORY, true);
/* 251 */     register(net.minecraft.entity.monster.EntityMagmaCube.class, SoulType.PREDATORY, true);
/* 252 */     register(net.minecraft.entity.monster.EntitySnowman.class, SoulType.PREDATORY, true);
/*     */     
/*     */ 
/* 255 */     register(net.minecraft.entity.boss.EntityWither.class, SoulType.DOOMED, false);
/* 256 */     register(net.minecraft.entity.boss.EntityDragon.class, SoulType.DOOMED, false);
/*     */     
/*     */ 
/* 259 */     register(net.minecraft.entity.monster.EntityEnderman.class, SoulType.UNHINGED, true);
/* 260 */     register(net.minecraft.entity.monster.EntityCreeper.class, SoulType.UNHINGED, true);
/*     */     
/*     */ 
/* 263 */     register(emoniph.intangible.entity.EntityPigVillager.class, SoulType.MALLEABLE, true);
/*     */     
/*     */ 
/* 266 */     register(EntityVillager.class, SoulType.WISE, true);
/* 267 */     register(EntityWitch.class, SoulType.WISE, true);
/*     */     
/*     */ 
/* 270 */     register(emoniph.intangible.entity.EntityAvatar.class, SoulType.NOBLE, false);
/*     */     
/*     */ 
/* 273 */     register(net.minecraft.entity.monster.EntitySkeleton.class, null, true);
/* 274 */     register(net.minecraft.entity.monster.EntityZombie.class, null, true);
/* 275 */     register(net.minecraft.entity.monster.EntityGiantZombie.class, null, true);
/* 276 */     register(EntityPigZombie.class, null, true);
/*     */     
/* 278 */     register(EntityWreckingGolem.class, null, false);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/SoulRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */