/*    */ package emoniph.intangible.souls;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.nbt.NBTTagList;
/*    */ 
/*    */ 
/*    */ public class BusySoulSet
/*    */ {
/* 13 */   private List<BusySouls> busySoulsList = new ArrayList();
/*    */   
/*    */   public boolean isEmpty() {
/* 16 */     return this.busySoulsList.isEmpty();
/*    */   }
/*    */   
/*    */   public void add(BusySouls busySouls) {
/* 20 */     this.busySoulsList.add(busySouls);
/*    */   }
/*    */   
/*    */   public void addTo(SoulSet souls) {
/* 24 */     for (BusySouls busySouls : this.busySoulsList) {
/* 25 */       busySouls.addTo(souls);
/*    */     }
/*    */   }
/*    */   
/*    */   public NBTTagCompound toTagCompound() {
/* 30 */     NBTTagCompound compound = new NBTTagCompound();
/* 31 */     NBTTagList list = new NBTTagList();
/* 32 */     int i = 0; for (int count = this.busySoulsList.size(); i < count; i++) {
/* 33 */       NBTTagCompound busySoulTag = ((BusySouls)this.busySoulsList.get(i)).getTagCompound();
/* 34 */       if (busySoulTag != null) {
/* 35 */         list.func_74742_a(busySoulTag);
/*    */       }
/*    */     }
/* 38 */     compound.func_74782_a("list", list);
/* 39 */     return compound;
/*    */   }
/*    */   
/*    */   public static BusySoulSet fromTagCompound(NBTTagCompound compound) {
/* 43 */     BusySoulSet set = new BusySoulSet();
/* 44 */     NBTTagList list = compound.func_150295_c("list", 10);
/* 45 */     int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 46 */       NBTTagCompound busySoulTag = list.func_150305_b(i);
/* 47 */       if (busySoulTag != null) {
/* 48 */         BusySouls busySouls = BusySouls.fromTagCompound(busySoulTag);
/* 49 */         if (busySouls != null) {
/* 50 */           set.add(busySouls);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 55 */     return set;
/*    */   }
/*    */   
/*    */   public boolean tickAndTryReleaseSouls(SoulSet soulPool) {
/* 59 */     boolean soulsReleased = false;
/* 60 */     if (this.busySoulsList.size() > 0) {
/* 61 */       Iterator<BusySouls> itr = this.busySoulsList.iterator();
/* 62 */       while (itr.hasNext()) {
/* 63 */         BusySouls busy = (BusySouls)itr.next();
/* 64 */         if (busy.tickAndTryReleaseSouls(soulPool)) {
/* 65 */           itr.remove();
/* 66 */           soulsReleased = true;
/*    */         }
/*    */       }
/*    */     }
/* 70 */     return soulsReleased;
/*    */   }
/*    */   
/*    */   public void immediateReleaseSouls(SoulSet soulPool) {
/* 74 */     Iterator<BusySouls> itr = this.busySoulsList.iterator();
/* 75 */     while (itr.hasNext()) {
/* 76 */       BusySouls busy = (BusySouls)itr.next();
/* 77 */       busy.immediateReleaseSouls(soulPool);
/* 78 */       itr.remove();
/*    */     }
/*    */   }
/*    */   
/*    */   public void writeTo(ByteBuf buf) {
/* 83 */     buf.writeInt(this.busySoulsList.size());
/* 84 */     int i = 0; for (int count = this.busySoulsList.size(); i < count; i++) {
/* 85 */       ((BusySouls)this.busySoulsList.get(i)).writeTo(buf);
/*    */     }
/*    */   }
/*    */   
/*    */   public static BusySoulSet fromBytes(ByteBuf buf)
/*    */   {
/* 91 */     BusySoulSet set = new BusySoulSet();
/* 92 */     int count = buf.readInt();
/* 93 */     for (int i = 0; i < count; i++) {
/* 94 */       BusySouls souls = BusySouls.readFrom(buf);
/* 95 */       if (souls != null) {
/* 96 */         set.busySoulsList.add(souls);
/*    */       }
/*    */     }
/* 99 */     return set;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/BusySoulSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */