/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.deity.IAvatar;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.api.deity.IDeityMinorWorldEffect;
/*     */ import emoniph.intangible.api.deity.IDeityWorshipEffect;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import emoniph.intangible.entity.ai.IDefender;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.network.IPacketRegister;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntityTameable;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ import org.apache.commons.lang3.Range;
/*     */ 
/*     */ public class ModPriestSpells implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModPreInit, emoniph.intangible.network.IRegisterPackets, Iterable<PriestSpell>
/*     */ {
/*  42 */   private List<PriestSpell> spells = new ArrayList();
/*  43 */   private Map<PriestSpell, Integer> spellToIndex = new HashMap();
/*  44 */   private Map<String, PriestSpell> idToSpell = new HashMap();
/*     */   
/*  46 */   public final PriestSpell BLESS = register(new PriestSpell("bless", 0, 600, false, 1, 0, "intangible:textures/gui/priest_bless.png", "priest.intangible:blessing")
/*     */   {
/*     */     protected ModPriestSpells.SpellResult onCast(World world, EntityPlayer player, IDeity deity) {
/*  49 */       IDeityWorshipEffect effect = deity.getBlessingEffect();
/*     */       
/*  51 */       if (!effect.customTargetting()) {
/*  52 */         float radius = 8.0F;
/*  53 */         float radiusSq = 64.0F;
/*  54 */         float radiusY = 4.0F;
/*     */         
/*  56 */         List<EntityLivingBase> targets = world.func_72872_a(EntityLivingBase.class, player
/*  57 */           .func_174813_aQ().func_72314_b(8.0D, 4.0D, 8.0D));
/*     */         
/*  59 */         for (EntityLivingBase target : targets) {
/*  60 */           if (player.func_70092_e(target.field_70165_t, player.field_70163_u, target.field_70161_v) < 64.0D) {
/*  61 */             if ((target instanceof EntityPlayer)) {
/*  62 */               if (PlayerEx.get((EntityPlayer)target).getWorship().isFollowerOf(world, deity)) {
/*  63 */                 effect.performPriestEffect(player, target, deity);
/*     */               }
/*  65 */             } else if ((target instanceof EntityTameable)) {
/*  66 */               EntityTameable tameable = (EntityTameable)target;
/*  67 */               if (tameable.func_70902_q() == player) {
/*  68 */                 effect.performPriestEffect(player, target, deity);
/*     */               }
/*  70 */             } else if ((target instanceof IDefender)) {
/*  71 */               IDefender defender = (IDefender)target;
/*  72 */               if (defender.getOwnerEntities().contains(player)) {
/*  73 */                 effect.performPriestEffect(player, target, deity);
/*     */               }
/*  75 */             } else if ((target instanceof IAvatar)) {
/*  76 */               IAvatar avatar = (IAvatar)target;
/*  77 */               if (avatar.getDeityId().equals(deity.getId())) {
/*  78 */                 effect.performPriestEffect(player, target, deity);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       } else {
/*  84 */         effect.performPriestEffect(player, null, deity);
/*     */       }
/*     */       
/*  87 */       Get.fx().GLOW.sendToAllNear(player, 0.7F, 20, deity.getColor(), new Vec3(player.field_70165_t, player.field_70163_u + 3.0D, player.field_70161_v), 0.1F);
/*  88 */       deity.talkAt(player);
/*  89 */       return ModPriestSpells.SpellResult.SUCCEEDED;
/*     */     }
/*  46 */   });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  93 */   public final PriestSpell CURSE = register(new PriestSpell("curse", 0, 900, false, -1, 0, "intangible:textures/gui/priest_curse.png", "priest.intangible:curse")
/*     */   {
/*     */     protected ModPriestSpells.SpellResult onCast(World world, EntityPlayer player, IDeity deity) {
/*  96 */       IDeityWorshipEffect effect = deity.getCurseEffect();
/*     */       
/*  98 */       int targetsHit = 0;
/*     */       
/* 100 */       if (!effect.customTargetting()) {
/* 101 */         float radius = 8.0F;
/* 102 */         float radiusSq = 64.0F;
/* 103 */         float radiusY = 4.0F;
/*     */         
/* 105 */         List<EntityLivingBase> targets = world.func_72872_a(EntityLivingBase.class, player
/* 106 */           .func_174813_aQ().func_72314_b(8.0D, 4.0D, 8.0D));
/*     */         
/* 108 */         for (EntityLivingBase target : targets) {
/* 109 */           if (player.func_70092_e(target.field_70165_t, player.field_70163_u, target.field_70161_v) < 64.0D) {
/* 110 */             if ((target instanceof EntityPlayer)) {
/* 111 */               if (!PlayerEx.get((EntityPlayer)target).getWorship().isDevoutFollowerOf(world, deity)) {}
/*     */ 
/*     */             }
/* 114 */             else if ((target instanceof EntityTameable)) {
/* 115 */               EntityTameable tameable = (EntityTameable)target;
/* 116 */               if (tameable.func_70902_q() == player) {
/*     */                 continue;
/*     */               }
/* 119 */             } else if ((target instanceof IDefender)) {
/* 120 */               IDefender defender = (IDefender)target;
/* 121 */               if (defender.getOwnerEntities().contains(player)) {
/*     */                 continue;
/*     */               }
/* 124 */             } else if ((target instanceof IAvatar)) {
/* 125 */               IAvatar avatar = (IAvatar)target;
/* 126 */               if (avatar.getDeityId().equals(deity.getId())) {
/*     */                 continue;
/*     */               }
/*     */             }
/*     */             
/* 131 */             targetsHit++;
/* 132 */             effect.performPriestEffect(player, target, deity);
/*     */           }
/*     */         }
/*     */       } else {
/* 136 */         effect.performPriestEffect(player, null, deity);
/* 137 */         targetsHit = 1;
/*     */       }
/*     */       
/* 140 */       if (targetsHit > 0) {
/* 141 */         Get.fx().GLOW.sendToAllNear(player, 0.7F, 20, deity.getColor(), new Vec3(player.field_70165_t, player.field_70163_u + 3.0D, player.field_70161_v), 0.1F);
/* 142 */         deity.talkAt(player);
/* 143 */         return ModPriestSpells.SpellResult.SUCCEEDED;
/*     */       }
/* 145 */       return ModPriestSpells.SpellResult.FAILED;
/*     */     }
/*  93 */   });
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
/* 150 */   public final PriestSpell MINOR = register(new PriestSpell("minorpower", 1, 2400, false, 0, -1, "intangible:textures/gui/priest_minor.png", "priest.intangible:minorpower")
/*     */   {
/*     */     protected ModPriestSpells.SpellResult onCast(World world, EntityPlayer player, IDeity deity) {
/* 153 */       IDeityMinorWorldEffect effect = deity.getMinorEffect();
/* 154 */       effect.performPriestEffect(world, deity, player);
/* 155 */       Get.fx().GLOW.sendToAllNear(player, 0.7F, 20, deity.getColor(), new Vec3(player.field_70165_t, player.field_70163_u + 3.0D, player.field_70161_v), 0.1F);
/* 156 */       deity.talkAt(player);
/* 157 */       return ModPriestSpells.SpellResult.SUCCEEDED;
/*     */     }
/* 150 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static enum SpellResult
/*     */   {
/* 161 */     FAILED,  SUCCEEDED,  SUCCEEDED_NO_COST;
/*     */     private SpellResult() {} }
/* 163 */   public final PriestSpell SUMMON = register(new PriestSpell("summonavatar", 5, 6000, false, 0, 1, "intangible:textures/gui/priest_summon.png", "priest.intangible:summonavatar")
/*     */   {
/*     */     protected ModPriestSpells.SpellResult onCast(World world, EntityPlayer player, IDeity deity) {
/* 166 */       float radius = 32.0F;
/* 167 */       float radiusSq = 1024.0F;
/*     */       
/* 169 */       float dispellRadius = 10.0F;
/* 170 */       float dispellRadiusSq = 100.0F;
/*     */       
/* 172 */       List<EntityAvatar> targets = world.func_72872_a(EntityAvatar.class, player
/* 173 */         .func_174813_aQ().func_72314_b(32.0D, 32.0D, 32.0D));
/*     */       
/* 175 */       boolean failed = false;
/* 176 */       for (EntityAvatar target : targets) {
/* 177 */         if ((player.func_70092_e(target.field_70165_t, player.field_70163_u, target.field_70161_v) < 100.0D) && 
/* 178 */           (target.getDeityId().equals(deity.getId()))) {
/* 179 */           if (!world.field_72995_K) {
/* 180 */             target.func_70106_y();
/* 181 */             Get.fx().GLOW.sendToAllNear(target, 1.0F, 40, deity != null ? deity.getColor() : 10040115, 16.0D);
/*     */           }
/* 183 */           return ModPriestSpells.SpellResult.SUCCEEDED_NO_COST;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 189 */       for (EntityAvatar target : targets) {
/* 190 */         if ((player.func_70092_e(target.field_70165_t, player.field_70163_u, target.field_70161_v) < 1024.0D) && 
/* 191 */           (target.getDeityId().equals(deity.getId()))) {
/* 192 */           failed = true;
/* 193 */           break;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 198 */       if (!failed) {
/* 199 */         Deity deityInner = Get.deities().forWorld(world).getDeityById(deity.getId());
/* 200 */         if (deityInner != null) {
/* 201 */           EntityAvatar avatar = deityInner.createAvatar(world);
/* 202 */           if ((avatar != null) && (emoniph.intangible.util.EntityUtil.trySetRandomNearbyPosition(avatar.getAvatarEntity(), world, 
/* 203 */             emoniph.intangible.util.BlockUtil.midBlockToVec3(new BlockPos(player)), Range.between(Double.valueOf(1.0D), Double.valueOf(8.0D)), 8))) {
/* 204 */             world.func_72942_c(new net.minecraft.entity.effect.EntityLightningBolt(world, avatar.field_70165_t, avatar.field_70163_u, avatar.field_70161_v));
/* 205 */             world.func_72838_d(avatar);
/* 206 */             Get.fx().GLOW.sendToAllNear(world, new BlockPos(avatar.field_70165_t, avatar.field_70163_u + 2.0D, avatar.field_70161_v), 1.5F, 100, deity
/* 207 */               .getColor(), 32.0D);
/* 208 */             Get.fx().GLOW.sendToAllNear(player, 0.7F, 20, deity.getColor(), new Vec3(player.field_70165_t, player.field_70163_u + 3.0D, player.field_70161_v), 0.1F);
/* 209 */             deity.talkAt(player);
/* 210 */             return ModPriestSpells.SpellResult.SUCCEEDED;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 215 */       return ModPriestSpells.SpellResult.FAILED;
/*     */     }
/* 163 */   });
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
/*     */   private <T extends PriestSpell> T register(T spell)
/*     */   {
/* 220 */     this.spells.add(spell);
/* 221 */     this.spellToIndex.put(spell, Integer.valueOf(this.spells.size() - 1));
/* 222 */     this.idToSpell.put(spell.getId(), spell);
/* 223 */     return spell;
/*     */   }
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/* 228 */     Get.pipeline().registerPacketProvider(this);
/*     */   }
/*     */   
/*     */   public java.util.Iterator<PriestSpell> iterator()
/*     */   {
/* 233 */     return this.spells.iterator();
/*     */   }
/*     */   
/*     */   public int getIndexFromSpell(PriestSpell spell) {
/* 237 */     Integer index = (Integer)this.spellToIndex.get(spell);
/* 238 */     if (index != null) {
/* 239 */       return index.intValue();
/*     */     }
/* 241 */     return -1;
/*     */   }
/*     */   
/*     */   public PriestSpell getSpellFromIndex(int index)
/*     */   {
/* 246 */     if ((index >= 0) && (index < this.spells.size())) {
/* 247 */       return (PriestSpell)this.spells.get(index);
/*     */     }
/* 249 */     return null;
/*     */   }
/*     */   
/*     */   public String getIdForSpell(PriestSpell spell)
/*     */   {
/* 254 */     return spell.id;
/*     */   }
/*     */   
/*     */   public PriestSpell getSpellForId(String spellId) {
/* 258 */     return (PriestSpell)this.idToSpell.get(spellId);
/*     */   }
/*     */   
/*     */   public void registerPackets(IPacketRegister packetRegister)
/*     */   {
/* 263 */     packetRegister.registerPacket(ModPriestSpells.PacketCastPriestSpell.Handler.class, PacketCastPriestSpell.class, Side.SERVER);
/*     */   }
/*     */   
/*     */   public static abstract class PriestSpell
/*     */   {
/*     */     public static final int WIDTH = 16;
/*     */     public static final int HEIGHT = 16;
/*     */     private static final int GRID_CELL_SIZE = 24;
/*     */     private final int cost;
/*     */     private final int cooldown;
/*     */     private final int x;
/*     */     private final int y;
/*     */     protected final boolean topDeityOnly;
/*     */     private final ResourceLocation image;
/*     */     private final String title;
/*     */     private final String id;
/*     */     
/*     */     public PriestSpell(String id, int worshipCost, int cooldown, boolean topOnly, int gridX, int gridY, String imagePath, String titleId) {
/* 281 */       this.id = emoniph.intangible.util.ModUtil.withPrefix(id);
/* 282 */       this.cooldown = cooldown;
/* 283 */       this.cost = worshipCost;
/* 284 */       this.x = (gridX * 24 - 12 + 4);
/* 285 */       this.y = (gridY * 24 - 12 + 4);
/* 286 */       this.topDeityOnly = topOnly;
/* 287 */       this.image = new ResourceLocation(imagePath);
/* 288 */       this.title = titleId;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public ResourceLocation getImage() {
/* 293 */       return this.image;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public String getTranslatedTitle(String deityName) {
/* 298 */       return StatCollector.func_74837_a(this.title + ".title", new Object[] { deityName });
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public String getTranslatedText(String deityName) {
/* 303 */       return StatCollector.func_74837_a(this.title + ".details", new Object[] { deityName });
/*     */     }
/*     */     
/*     */     public int getX() {
/* 307 */       return this.x;
/*     */     }
/*     */     
/*     */     public int getY() {
/* 311 */       return this.y;
/*     */     }
/*     */     
/*     */     public int getCooldown() {
/* 315 */       return this.cooldown;
/*     */     }
/*     */     
/*     */     public int getWorshipCost() {
/* 319 */       return this.cost;
/*     */     }
/*     */     
/*     */     public boolean contains(float mx, float my) {
/* 323 */       return (mx >= this.x) && (mx <= this.x + 16) && (my >= this.y) && (my <= this.y + 16);
/*     */     }
/*     */     
/*     */     final void cast(EntityPlayer player) {
/* 327 */       PlayerEx playerEx = PlayerEx.get(player);
/* 328 */       if ((!playerEx.isCooldownActive(this)) || (player.field_71075_bZ.field_75098_d)) {
/* 329 */         UUID deityId = playerEx.getWorship().getDevoutDeityId(player.field_70170_p);
/* 330 */         if (deityId != null) {
/* 331 */           IDeity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(deityId);
/* 332 */           if ((deity != null) && (
/* 333 */             (getWorshipCost() == 0) || (playerEx.getWorship().isWorshipEqualOrGreaterThan(player.field_70170_p, deity, getWorshipCost())))) {
/* 334 */             ModPriestSpells.SpellResult result = onCast(player.field_70170_p, player, deity);
/* 335 */             if (result != ModPriestSpells.SpellResult.FAILED) {
/* 336 */               playerEx.setCooldown(this);
/* 337 */               if ((getWorshipCost() > 0) && (result == ModPriestSpells.SpellResult.SUCCEEDED)) {
/* 338 */                 playerEx.tryReduceWorship(player.field_70170_p, deity, getWorshipCost());
/*     */               }
/* 340 */               return;
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 347 */       Sound.MOD_RANDOM_SPELLFAIL.playOnlyTo(player);
/*     */     }
/*     */     
/*     */     protected abstract ModPriestSpells.SpellResult onCast(World paramWorld, EntityPlayer paramEntityPlayer, IDeity paramIDeity);
/*     */     
/*     */     public String getId() {
/* 353 */       return this.id;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class PacketCastPriestSpell implements IMessage
/*     */   {
/*     */     private ModPriestSpells.PriestSpell spell;
/*     */     private boolean reset;
/*     */     
/*     */     public PacketCastPriestSpell() {}
/*     */     
/*     */     public PacketCastPriestSpell(ModPriestSpells.PriestSpell spell, boolean reset) {
/* 365 */       this.spell = spell;
/* 366 */       this.reset = reset;
/*     */     }
/*     */     
/*     */     public void fromBytes(ByteBuf buf)
/*     */     {
/* 371 */       this.spell = Get.priest().getSpellFromIndex(buf.readInt());
/* 372 */       this.reset = buf.readBoolean();
/*     */     }
/*     */     
/*     */     public void toBytes(ByteBuf buf)
/*     */     {
/* 377 */       buf.writeInt(Get.priest().getIndexFromSpell(this.spell));
/* 378 */       buf.writeBoolean(this.reset);
/*     */     }
/*     */     
/*     */     public static class Handler implements net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler<ModPriestSpells.PacketCastPriestSpell, IMessage>
/*     */     {
/*     */       public IMessage onMessage(final ModPriestSpells.PacketCastPriestSpell message, final MessageContext ctx)
/*     */       {
/* 385 */         Intangible.PROXY.queue(ctx, new Runnable() {
/*     */           public void run() {
/* 387 */             EntityPlayer player = Intangible.PROXY.getPlayer(ctx);
/* 388 */             if ((player != null) && (message.spell != null)) {
/* 389 */               if (message.reset) {
/* 390 */                 PlayerEx playerEx = PlayerEx.get(player);
/* 391 */                 playerEx.CACHE.clearRadialMenuData();
/*     */               }
/* 393 */               message.spell.cast(player);
/*     */             }
/*     */             
/*     */           }
/* 397 */         });
/* 398 */         return null;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/ModPriestSpells.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */