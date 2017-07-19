/*    */ package emoniph.intangible.deity;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ import net.minecraft.world.storage.MapStorage;
/*    */ 
/*    */ public class ShrineManager implements emoniph.intangible.init.IModService
/*    */ {
/* 14 */   private Map<Integer, ShrineList> shrinesByWorld = new HashMap();
/*    */   
/*    */   public void initWorld(World world) {
/* 17 */     if (!world.field_72995_K) {
/* 18 */       String key = ShrineList.fileNameForProvider(world.field_73011_w);
/* 19 */       net.minecraft.world.WorldSavedData data = world.getPerWorldStorage().func_75742_a(ShrineList.class, key);
/* 20 */       if (data == null) {
/* 21 */         data = new ShrineList(world);
/* 22 */         world.getPerWorldStorage().func_75745_a(key, data);
/*    */       }
/*    */       
/* 25 */       this.shrinesByWorld.put(Integer.valueOf(world.field_73011_w.func_177502_q()), (ShrineList)data);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isShrinesActiveFor(World world, Deity deity) {
/* 30 */     return !forWorld(world).getLocationsFor(deity).isEmpty();
/*    */   }
/*    */   
/*    */   public void addDedicatedShrine(World world, BlockPos pos, Deity deity) {
/* 34 */     if (!world.field_72995_K) {
/* 35 */       forWorld(world).addShrine(world, pos, deity);
/*    */     }
/*    */   }
/*    */   
/*    */   public void removeDedicatedShrine(World world, BlockPos pos) {
/* 40 */     if (!world.field_72995_K) {
/* 41 */       forWorld(world).removeShrine(world, pos);
/*    */     }
/*    */   }
/*    */   
/*    */   public List<BlockPos> getLocationsFor(World world, IDeity deity) {
/* 46 */     return forWorld(world).getLocationsFor(deity);
/*    */   }
/*    */   
/*    */   private ShrineList forWorld(World world) {
/* 50 */     ShrineList list = (ShrineList)this.shrinesByWorld.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/* 51 */     if (list == null) {
/* 52 */       list = new ShrineList(world);
/* 53 */       this.shrinesByWorld.put(Integer.valueOf(world.field_73011_w.func_177502_q()), list);
/*    */     }
/* 55 */     return list;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/ShrineManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */