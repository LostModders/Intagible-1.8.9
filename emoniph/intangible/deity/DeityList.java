/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.WorldSavedData;
/*     */ import net.minecraftforge.event.entity.player.PlayerUseItemEvent.Finish;
/*     */ import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
/*     */ 
/*     */ public class DeityList extends WorldSavedData implements emoniph.intangible.api.deity.IDeityList
/*     */ {
/*  21 */   private List<Deity> deityList = new ArrayList();
/*  22 */   private Map<UUID, Deity> idToDeityMap = new java.util.HashMap();
/*  23 */   private List<Deity> deityKillList = new ArrayList();
/*     */   private Deity topDeity;
/*     */   
/*  26 */   public DeityList(String name) { super(name); }
/*     */   
/*     */   public DeityList(World worldIn)
/*     */   {
/*  30 */     super(fileNameForProvider(worldIn.field_73011_w));
/*     */   }
/*     */   
/*     */   public static String fileNameForProvider(WorldProvider provider) {
/*  34 */     return "intangibleDeityList" + provider.func_177498_l();
/*     */   }
/*     */   
/*     */   public void createNewDeity(Deity deity) {
/*  38 */     this.deityList.add(deity);
/*  39 */     this.idToDeityMap.put(deity.getId(), deity);
/*  40 */     func_76185_a();
/*     */   }
/*     */   
/*     */   public Deity getDeityForOfferings(List<net.minecraft.item.ItemStack> offerings) {
/*  44 */     for (Deity deity : this.deityList) {
/*  45 */       if (deity.isFullOffering(offerings)) {
/*  46 */         return deity;
/*     */       }
/*     */     }
/*  49 */     return null;
/*     */   }
/*     */   
/*     */   public Deity getDeityById(UUID deityId) {
/*  53 */     return (Deity)this.idToDeityMap.get(deityId);
/*     */   }
/*     */   
/*     */   public Deity getDeityByName(String name) {
/*  57 */     String lowerName = name.toLowerCase();
/*  58 */     for (Deity d : this.deityList) {
/*  59 */       if (d.getName().toLowerCase().equals(lowerName)) {
/*  60 */         return d;
/*     */       }
/*     */     }
/*  63 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_76184_a(NBTTagCompound compound)
/*     */   {
/*  69 */     if (compound.func_150297_b("list", 9)) {
/*  70 */       NBTTagList list = compound.func_150295_c("list", 10);
/*  71 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/*  72 */         Deity deity = Deity.fromTagCompound(list.func_150305_b(i));
/*  73 */         if (deity != null) {
/*  74 */           this.deityList.add(deity);
/*  75 */           this.idToDeityMap.put(deity.getId(), deity);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_76187_b(NBTTagCompound compound)
/*     */   {
/*  83 */     NBTTagList list = new NBTTagList();
/*  84 */     compound.func_74782_a("list", list);
/*     */     
/*  86 */     for (Deity deity : this.deityList) {
/*  87 */       list.func_74742_a(deity.toTagCompound());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int size()
/*     */   {
/*  98 */     return this.deityList.size();
/*     */   }
/*     */   
/*     */   public Iterator<IDeity> iterator()
/*     */   {
/* 103 */     return new DeityIterator(this.deityList, null);
/*     */   }
/*     */   
/*     */ 
/*     */   void tick(World world)
/*     */   {
/* 109 */     Deity top = null;
/* 110 */     int maxWorship = 0;
/* 111 */     for (Deity deity : this.deityList) {
/* 112 */       if (deity.getCurrentWorship() > 3) {
/* 113 */         if (deity.getCurrentWorship() > maxWorship) {
/* 114 */           top = deity;
/* 115 */           maxWorship = deity.getCurrentWorship();
/* 116 */         } else if (deity.getCurrentWorship() == maxWorship) {
/* 117 */           top = null;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 122 */     if (this.topDeity != top) {
/* 123 */       this.topDeity = top;
/* 124 */       if (this.topDeity != null) {
/* 125 */         this.topDeity.syncEffectsTo(world);
/*     */       } else {
/* 127 */         Get.pipeline().sendToDimension(new DeityManager.PacketEffectsToClient(world), world.field_73011_w.func_177502_q());
/*     */       }
/*     */     }
/*     */     
/* 131 */     for (??? = this.deityList.iterator(); ???.hasNext();) { deity = (Deity)???.next();
/* 132 */       deity.tick(world, deity == top);
/*     */     }
/*     */     Deity deity;
/* 135 */     boolean sync = false;
/* 136 */     for (Deity deity : this.deityKillList) {
/* 137 */       this.deityList.remove(deity);
/* 138 */       this.idToDeityMap.remove(deity.getId());
/* 139 */       Get.pipeline().sendToDimension(new DeityManager.PacketSyncHeadToClient(world, deity, null), world.field_73011_w.func_177502_q());
/* 140 */       sync = true;
/*     */     }
/* 142 */     if (sync) {
/* 143 */       this.deityKillList.clear();
/* 144 */       func_76185_a();
/*     */     }
/*     */   }
/*     */   
/*     */   public void onHarvest(BlockEvent.HarvestDropsEvent event) {
/* 149 */     if (this.topDeity != null) {
/* 150 */       this.topDeity.getMajorEffect().onHarvest(event.world, event.pos, event.drops, event.harvester, this.topDeity);
/*     */     }
/* 152 */     for (Deity deity : this.deityList) {
/* 153 */       if (deity.getCurrentWorship() > 3) {
/* 154 */         deity.getMinorEffect().onHarvest(event.world, event.pos, event.drops, event.harvester, deity);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onPlayerUseItemFinish(PlayerUseItemEvent.Finish event) {
/* 160 */     if (this.topDeity != null) {
/* 161 */       this.topDeity.getMajorEffect().onPlayerUseItemFinish(event.entity.field_70170_p, event.entityPlayer, event.item, this.topDeity);
/*     */     }
/* 163 */     for (Deity deity : this.deityList) {
/* 164 */       if (deity.getCurrentWorship() > 3) {
/* 165 */         deity.getMinorEffect().onPlayerUseItemFinish(event.entity.field_70170_p, event.entityPlayer, event.item, deity);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   void syncHeadsTo(World world, EntityPlayer player) {
/* 171 */     for (Deity deity : this.deityList) {
/* 172 */       deity.syncHeadTo(world, player);
/*     */     }
/*     */   }
/*     */   
/*     */   void syncEffectsTo(World world, EntityPlayer player) {
/* 177 */     if (this.topDeity != null) {
/* 178 */       this.topDeity.syncEffectsTo(world, player);
/*     */     }
/*     */   }
/*     */   
/*     */   public void killDeity(Deity deity) {
/* 183 */     this.deityKillList.add(deity);
/*     */   }
/*     */   
/*     */   public UUID createUniqueId(World world) {
/* 187 */     long maxId = 0L;
/* 188 */     for (Deity deity : this.deityList) {
/* 189 */       long deityWorldId = deity.getId().getLeastSignificantBits();
/* 190 */       if (deityWorldId > maxId) {
/* 191 */         maxId = deityWorldId;
/*     */       }
/*     */     }
/* 194 */     return new UUID(world.field_73011_w.func_177502_q(), maxId + 1L);
/*     */   }
/*     */   
/*     */   private class DeityIterator
/*     */     implements Iterator<IDeity>
/*     */   {
/*     */     final Iterator<Deity> iterator;
/*     */     
/*     */     private DeityIterator()
/*     */     {
/* 204 */       this.iterator = list.iterator();
/*     */     }
/*     */     
/*     */     public boolean hasNext()
/*     */     {
/* 209 */       return this.iterator.hasNext();
/*     */     }
/*     */     
/*     */     public IDeity next()
/*     */     {
/* 214 */       return (IDeity)this.iterator.next();
/*     */     }
/*     */     
/*     */     public void remove()
/*     */     {
/* 219 */       throw new UnsupportedOperationException("Remove operation is not supported by deity iterators.");
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/DeityList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */