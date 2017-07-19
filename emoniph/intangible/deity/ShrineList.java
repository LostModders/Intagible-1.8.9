/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ import net.minecraft.world.WorldSavedData;
/*     */ 
/*     */ public class ShrineList extends WorldSavedData
/*     */ {
/*  16 */   private Set<Shrine> shrines = new java.util.HashSet();
/*     */   
/*     */   public List<BlockPos> getLocationsFor(IDeity deity) {
/*  19 */     List<BlockPos> results = new java.util.ArrayList();
/*  20 */     for (Shrine shrine : this.shrines) {
/*  21 */       if (shrine.deityId.equals(deity.getId())) {
/*  22 */         results.add(shrine.pos);
/*     */       }
/*     */     }
/*  25 */     return results;
/*     */   }
/*     */   
/*     */   private static class Shrine {
/*     */     private final BlockPos pos;
/*     */     private final UUID deityId;
/*     */     
/*     */     Shrine(BlockPos pos, UUID deityId) {
/*  33 */       this.pos = pos;
/*  34 */       this.deityId = deityId;
/*     */     }
/*     */     
/*     */     public boolean equals(Object obj)
/*     */     {
/*  39 */       if ((obj == null) || (obj.getClass() != getClass())) {
/*  40 */         return false;
/*     */       }
/*     */       
/*  43 */       if (obj == this) {
/*  44 */         return true;
/*     */       }
/*  46 */       Shrine other = (Shrine)obj;
/*  47 */       return this.pos.equals(other.pos);
/*     */     }
/*     */     
/*     */     public int hashCode()
/*     */     {
/*  52 */       return this.pos.hashCode();
/*     */     }
/*     */     
/*     */     public NBTTagCompound toTagCompound() {
/*  56 */       NBTTagCompound compound = new NBTTagCompound();
/*  57 */       compound.func_74772_a("pos", this.pos.func_177986_g());
/*  58 */       compound.func_74772_a("dmsb", this.deityId.getMostSignificantBits());
/*  59 */       compound.func_74772_a("dlsb", this.deityId.getLeastSignificantBits());
/*  60 */       return compound;
/*     */     }
/*     */     
/*     */     public static Shrine fromTagCompound(NBTTagCompound compound) {
/*  64 */       if ((compound.func_74764_b("pos")) && (compound.func_74764_b("dmsb")) && (compound.func_74764_b("dlsb")))
/*     */       {
/*  66 */         return new Shrine(BlockPos.func_177969_a(compound.func_74763_f("pos")), new UUID(compound.func_74763_f("dmsb"), compound.func_74763_f("dlsb")));
/*     */       }
/*  68 */       return null;
/*     */     }
/*     */   }
/*     */   
/*     */   public ShrineList(String name)
/*     */   {
/*  74 */     super(name);
/*     */   }
/*     */   
/*     */   public ShrineList(World worldIn) {
/*  78 */     super(fileNameForProvider(worldIn.field_73011_w));
/*     */   }
/*     */   
/*     */   public static String fileNameForProvider(WorldProvider provider) {
/*  82 */     return "intangibleShrineList" + provider.func_177498_l();
/*     */   }
/*     */   
/*     */   public void addShrine(World world, BlockPos pos, Deity deity) {
/*  86 */     this.shrines.add(new Shrine(pos, deity.getId()));
/*  87 */     func_76185_a();
/*     */   }
/*     */   
/*     */   public void removeShrine(World world, BlockPos pos) {
/*  91 */     if (this.shrines.remove(new Shrine(pos, null))) {
/*  92 */       func_76185_a();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_76187_b(NBTTagCompound compound)
/*     */   {
/*  99 */     NBTTagList list = new NBTTagList();
/* 100 */     for (Shrine shrine : this.shrines) {
/* 101 */       if (shrine != null) {
/* 102 */         list.func_74742_a(shrine.toTagCompound());
/*     */       }
/*     */     }
/* 105 */     compound.func_74782_a("list", list);
/*     */   }
/*     */   
/*     */   public void func_76184_a(NBTTagCompound compound)
/*     */   {
/* 110 */     this.shrines.clear();
/* 111 */     if (compound.func_150297_b("list", 9)) {
/* 112 */       NBTTagList list = compound.func_150295_c("list", 10);
/* 113 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 114 */         Shrine shrine = Shrine.fromTagCompound(list.func_150305_b(i));
/* 115 */         if (shrine != null) {
/* 116 */           this.shrines.add(shrine);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/ShrineList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */