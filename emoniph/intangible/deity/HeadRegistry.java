/*    */ package emoniph.intangible.deity;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HeadRegistry
/*    */ {
/* 14 */   private Map<UUID, HeadSpec> registry = new HashMap();
/*    */   
/*    */   public void add(UUID uuid, HeadSpec headSpec) {
/* 17 */     this.registry.put(uuid, headSpec);
/*    */   }
/*    */   
/*    */   public HeadSpec getHeadFor(UUID uuid) {
/* 21 */     return (HeadSpec)this.registry.get(uuid);
/*    */   }
/*    */   
/*    */   public NBTTagCompound toTagCompound() {
/* 25 */     NBTTagCompound compound = new NBTTagCompound();
/* 26 */     NBTTagList list = new NBTTagList();
/* 27 */     compound.func_74782_a("list", list);
/*    */     
/* 29 */     for (Map.Entry<UUID, HeadSpec> entry : this.registry.entrySet()) {
/* 30 */       NBTTagCompound item = new NBTTagCompound();
/* 31 */       item.func_74778_a("uuid", ((UUID)entry.getKey()).toString());
/* 32 */       item.func_74782_a("head", ((HeadSpec)entry.getValue()).toTagCompound());
/* 33 */       list.func_74742_a(item);
/*    */     }
/*    */     
/* 36 */     return compound;
/*    */   }
/*    */   
/*    */   public static HeadRegistry fromTagCompound(NBTTagCompound compound) {
/* 40 */     HeadRegistry headRegistry = new HeadRegistry();
/* 41 */     if (compound.func_150297_b("list", 10)) {
/* 42 */       NBTTagList list = compound.func_150295_c("list", 10);
/* 43 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 44 */         NBTTagCompound item = list.func_150305_b(i);
/* 45 */         if ((item.func_150297_b("uuid", 8)) && (item.func_150297_b("head", 10))) {
/* 46 */           HeadSpec headSpec = HeadSpec.fromTagCompound(item.func_74775_l("head"));
/* 47 */           UUID uuid = UUID.fromString(item.func_74779_i("uuid"));
/* 48 */           headRegistry.registry.put(uuid, headSpec);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 53 */     return headRegistry;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/HeadRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */