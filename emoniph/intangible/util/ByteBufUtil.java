/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ public enum ByteBufUtil
/*    */ {
/*    */   private ByteBufUtil() {}
/*    */   
/*    */   public static void writeUuid(ByteBuf buf, java.util.UUID uuid) {
/* 10 */     buf.writeLong(uuid.getMostSignificantBits());
/* 11 */     buf.writeLong(uuid.getLeastSignificantBits());
/*    */   }
/*    */   
/*    */   public static java.util.UUID readUuid(ByteBuf buf) {
/* 15 */     long msb = buf.readLong();
/* 16 */     long lsb = buf.readLong();
/* 17 */     return new java.util.UUID(msb, lsb);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/ByteBufUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */