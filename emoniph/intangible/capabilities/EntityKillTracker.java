/*    */ package emoniph.intangible.capabilities;
/*    */ 
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class EntityKillTracker implements IKillTracker, IKillTrackerSetter
/*    */ {
/*    */   private long lastKillServerTime;
/*    */   
/*    */   public void addKill(net.minecraft.entity.Entity us, EntityLivingBase entity)
/*    */   {
/* 14 */     if (!entity.field_70170_p.field_72995_K) {
/* 15 */       if ((us instanceof EntityPlayer)) {
/* 16 */         this.lastKillServerTime = PlayerEx.get((EntityPlayer)us).getTotalTicks();
/*    */       } else {
/* 18 */         this.lastKillServerTime = MinecraftServer.func_130071_aq();
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public long getLastKillServerTime()
/*    */   {
/* 25 */     return this.lastKillServerTime;
/*    */   }
/*    */   
/*    */   public long getTicksSinceLastKillFor(EntityLivingBase us)
/*    */   {
/* 30 */     if (!us.field_70170_p.field_72995_K) {
/* 31 */       if ((us instanceof EntityPlayer)) {
/* 32 */         return PlayerEx.get((EntityPlayer)us).getTotalTicks() - this.lastKillServerTime;
/*    */       }
/* 34 */       return MinecraftServer.func_130071_aq() - this.lastKillServerTime;
/*    */     }
/*    */     
/* 37 */     return 0L;
/*    */   }
/*    */   
/*    */   public void setLastKillServerTime(long serverTime)
/*    */   {
/* 42 */     this.lastKillServerTime = serverTime;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/capabilities/EntityKillTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */