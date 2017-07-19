/*    */ package emoniph.intangible.souls;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public class BusySouls
/*    */ {
/*    */   private SoulSet souls;
/*    */   private int ticksRemaining;
/*    */   
/*    */   public BusySouls(emoniph.intangible.api.ISoulSet souls, int cooldownTicks)
/*    */   {
/* 12 */     this.souls = new SoulSet(souls);
/* 13 */     this.ticksRemaining = cooldownTicks;
/*    */   }
/*    */   
/*    */   public NBTTagCompound getTagCompound() {
/* 17 */     NBTTagCompound compound = new NBTTagCompound();
/* 18 */     compound.func_74782_a("souls", this.souls.toTagCompound());
/* 19 */     compound.func_74768_a("cooldown", this.ticksRemaining);
/* 20 */     return compound;
/*    */   }
/*    */   
/*    */   public static BusySouls fromTagCompound(NBTTagCompound compound) {
/* 24 */     SoulSet souls = SoulSet.fromTagCompound(compound.func_74775_l("souls"));
/* 25 */     int ticks = compound.func_74762_e("cooldown");
/* 26 */     BusySouls busySouls = new BusySouls(souls, ticks);
/* 27 */     return busySouls;
/*    */   }
/*    */   
/*    */   public boolean tickAndTryReleaseSouls(SoulSet soulPool) {
/* 31 */     if (--this.ticksRemaining <= 0) {
/* 32 */       addTo(soulPool);
/* 33 */       return true;
/*    */     }
/* 35 */     return false;
/*    */   }
/*    */   
/*    */   public void immediateReleaseSouls(SoulSet soulPool)
/*    */   {
/* 40 */     addTo(soulPool);
/*    */   }
/*    */   
/*    */   public void addTo(SoulSet soulPool) {
/* 44 */     soulPool.add(this.souls);
/*    */   }
/*    */   
/*    */   public void writeTo(io.netty.buffer.ByteBuf buf) {
/* 48 */     this.souls.writeTo(buf);
/* 49 */     buf.writeInt(this.ticksRemaining);
/*    */   }
/*    */   
/*    */   public static BusySouls readFrom(io.netty.buffer.ByteBuf buf) {
/* 53 */     SoulSet souls = SoulSet.fromBytes(buf);
/* 54 */     if (souls == null) {
/* 55 */       return null;
/*    */     }
/*    */     
/* 58 */     int ticks = buf.readInt();
/*    */     
/* 60 */     BusySouls busy = new BusySouls(souls, ticks);
/*    */     
/* 62 */     return busy;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/BusySouls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */