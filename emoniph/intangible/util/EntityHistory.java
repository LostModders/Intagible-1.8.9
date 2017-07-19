/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.network.NetHandlerPlayServer;
/*    */ 
/*    */ public class EntityHistory
/*    */ {
/*    */   private class Position
/*    */   {
/*    */     private double x;
/*    */     private double y;
/*    */     private double z;
/*    */     private float pitch;
/*    */     private float yaw;
/*    */     
/*    */     private Position() {}
/*    */     
/*    */     public void setFrom(EntityLivingBase entity)
/*    */     {
/* 21 */       this.x = entity.field_70165_t;
/* 22 */       this.y = entity.field_70163_u;
/* 23 */       this.z = entity.field_70161_v;
/* 24 */       this.pitch = entity.field_70125_A;
/* 25 */       this.yaw = entity.field_70177_z;
/*    */     }
/*    */     
/* 28 */     public void setTo(EntityLivingBase entity) { if ((entity instanceof EntityPlayerMP)) {
/* 29 */         ((EntityPlayerMP)entity).field_71135_a.func_147364_a(this.x, this.y, this.z, this.yaw, this.pitch);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 36 */   private Position[] history = new Position[100];
/*    */   private int end;
/*    */   
/*    */   public void clear() {
/* 40 */     for (Position pos : this.history) {
/* 41 */       this.history[this.end] = null;
/* 42 */       this.end = 0;
/*    */     }
/*    */   }
/*    */   
/*    */   public void push(EntityLivingBase entity) {
/* 47 */     if (this.history[this.end] == null) {
/* 48 */       this.history[this.end] = new Position(null);
/*    */     }
/*    */     
/* 51 */     this.history[this.end].setFrom(entity);
/*    */     
/* 53 */     if (++this.end == this.history.length) {
/* 54 */       this.end = 0;
/*    */     }
/*    */   }
/*    */   
/*    */   public void pop(EntityLivingBase entity) {
/* 59 */     if (--this.end < 0) {
/* 60 */       this.end = (this.history.length - 1);
/*    */     }
/*    */     
/* 63 */     if (this.history[this.end] != null) {
/* 64 */       this.history[this.end].setTo(entity);
/* 65 */       this.history[this.end] = null;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/EntityHistory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */