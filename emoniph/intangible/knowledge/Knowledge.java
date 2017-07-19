/*     */ package emoniph.intangible.knowledge;
/*     */ 
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class Knowledge implements emoniph.intangible.init.IModService, Iterable<IKnol>
/*     */ {
/*  16 */   private final List<IKnol> knols = new java.util.ArrayList();
/*  17 */   private final Map<IKnol, Integer> knolToIndex = new HashMap();
/*  18 */   private final Map<String, IKnol> idToKnol = new HashMap();
/*     */   
/*  20 */   public final IKnol SOULS = register(new Knol("souls"));
/*  21 */   public final IKnol SOUL_BENIGN = register(new Knol("benign"));
/*  22 */   public final IKnol SOUL_IMMUTABLE = register(new Knol("immutable"));
/*  23 */   public final IKnol SOUL_PREDATORY = register(new Knol("predatory"));
/*  24 */   public final IKnol SOUL_DOOMED = register(new Knol("doomed"));
/*  25 */   public final IKnol SOUL_UNHINGED = register(new Knol("unhinged"));
/*  26 */   public final IKnol SOUL_MALLEABLE = register(new Knol("malleable"));
/*  27 */   public final IKnol SOUL_WISE = register(new Knol("wise"));
/*  28 */   public final IKnol SOUL_NOBLE = register(new Knol("noble"));
/*     */   
/*  30 */   public final IKnol MAT_SOULBONE = register(new Knol("soulbone"));
/*  31 */   public final IKnol MAT_CRYSTAL = register(new Knol("crystal"));
/*     */   
/*  33 */   public final IKnol SKILL_SOUL_MANIPULATION = register(new Knol("soulmanipulation"));
/*  34 */   public final IKnol SKILL_SOUL_TRANSFUSION = register(new Knol("soultransfusion"));
/*     */   
/*  36 */   private final IKnol[] soulIndexToKnol = { this.SOUL_NOBLE, this.SOUL_BENIGN, this.SOUL_IMMUTABLE, this.SOUL_PREDATORY, this.SOUL_DOOMED, this.SOUL_UNHINGED, this.SOUL_MALLEABLE, this.SOUL_WISE };
/*     */   
/*     */ 
/*     */ 
/*     */   public IKnol[] getAllSoulKNowledge()
/*     */   {
/*  42 */     return this.soulIndexToKnol;
/*     */   }
/*     */   
/*     */   public IKnol[] toArray() {
/*  46 */     return (IKnol[])this.knols.toArray(new IKnol[this.knols.size()]);
/*     */   }
/*     */   
/*     */   public <T extends Knol> T register(T knol) {
/*  50 */     int index = this.knols.size();
/*  51 */     this.knols.add(knol);
/*  52 */     this.knolToIndex.put(knol, Integer.valueOf(index));
/*  53 */     this.idToKnol.put(knol.id, knol);
/*  54 */     return knol;
/*     */   }
/*     */   
/*     */   public IKnol getKnolFromIndex(int index) {
/*  58 */     if ((index >= 0) && (index < this.knols.size())) {
/*  59 */       return (IKnol)this.knols.get(index);
/*     */     }
/*  61 */     return null;
/*     */   }
/*     */   
/*     */   public IKnol getKnolFromId(String id)
/*     */   {
/*  66 */     if (id != null) {
/*  67 */       return (IKnol)this.idToKnol.get(id);
/*     */     }
/*  69 */     return null;
/*     */   }
/*     */   
/*     */   public int getIndexFromKnol(IKnol knol)
/*     */   {
/*  74 */     if (knol != null) {
/*  75 */       return ((Integer)this.knolToIndex.get(knol)).intValue();
/*     */     }
/*  77 */     return -1;
/*     */   }
/*     */   
/*     */   public IKnol getKnolForSoul(SoulType soul)
/*     */   {
/*  82 */     int ordinal = soul.ordinal();
/*  83 */     if ((ordinal >= 0) && (ordinal < this.soulIndexToKnol.length)) {
/*  84 */       return this.soulIndexToKnol[soul.ordinal()];
/*     */     }
/*  86 */     return null;
/*     */   }
/*     */   
/*     */   public boolean giveKnolsToNearestPlayer(World world, BlockPos pos, int radius, IKnol... knols)
/*     */   {
/*  91 */     float radiusSq = radius * radius;
/*     */     
/*  93 */     AxisAlignedBB bb = new AxisAlignedBB(pos.func_177982_a(-radius, -2, -radius), pos.func_177982_a(radius + 1, 4, radius + 1));
/*  94 */     List<EntityPlayer> players = world.func_72872_a(EntityPlayer.class, bb);
/*  95 */     PlayerEx closest = null;
/*  96 */     double bestDistance = Double.MAX_VALUE;
/*  97 */     for (EntityPlayer player : players) {
/*  98 */       PlayerEx playerEx = PlayerEx.get(player);
/*  99 */       double distance = player.func_70092_e(pos.func_177958_n() + 0.5D, player.field_70163_u, pos.func_177952_p() + 0.5D);
/* 100 */       if ((distance <= radiusSq) && (!playerEx.isKnowledgeLearnt(knols)) && (
/* 101 */         (closest == null) || (distance < bestDistance))) {
/* 102 */         closest = playerEx;
/* 103 */         bestDistance = distance;
/*     */       }
/*     */     }
/*     */     
/* 107 */     if (closest != null) {
/* 108 */       closest.learnKnowledge(emoniph.intangible.util.BlockUtil.midBlockToVec3(pos), knols);
/* 109 */       return true;
/*     */     }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public void giveKnolsToNearbyPlayers(World world, BlockPos pos, int radius, IKnol... knols)
/*     */   {
/* 116 */     float radiusSq = radius * radius;
/*     */     
/* 118 */     AxisAlignedBB bb = new AxisAlignedBB(pos.func_177982_a(-radius, -2, -radius), pos.func_177982_a(radius + 1, 4, radius + 1));
/* 119 */     List<EntityPlayer> players = world.func_72872_a(EntityPlayer.class, bb);
/*     */     
/* 121 */     for (EntityPlayer player : players) {
/* 122 */       PlayerEx playerEx = PlayerEx.get(player);
/* 123 */       double distance = player.func_174818_b(pos);
/* 124 */       if ((distance <= radiusSq) && (!playerEx.isKnowledgeLearnt(knols))) {
/* 125 */         playerEx.learnKnowledge(emoniph.intangible.util.BlockUtil.midBlockToVec3(pos), knols);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public java.util.Iterator<IKnol> iterator()
/*     */   {
/* 132 */     return this.knols.iterator();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/Knowledge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */