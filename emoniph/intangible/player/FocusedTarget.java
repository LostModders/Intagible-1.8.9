/*    */ package emoniph.intangible.player;
/*    */ 
/*    */ import java.lang.ref.WeakReference;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class FocusedTarget implements emoniph.intangible.api.IFocusedTarget
/*    */ {
/*    */   private WeakReference<EntityLivingBase> target;
/*    */   private int hitCount;
/*    */   
/*    */   public void targetHit(EntityLivingBase newTarget)
/*    */   {
/* 13 */     if (newTarget == null) {
/* 14 */       this.target = null;
/* 15 */       this.hitCount = 0;
/* 16 */     } else if ((this.target == null) || (this.target.get() == null) || (this.target.get() != newTarget)) {
/* 17 */       this.target = new WeakReference(newTarget);
/* 18 */       this.hitCount = 1;
/*    */     } else {
/* 20 */       this.hitCount += 1;
/*    */     }
/*    */   }
/*    */   
/*    */   public EntityLivingBase getTarget()
/*    */   {
/* 26 */     return this.target != null ? (EntityLivingBase)this.target.get() : null;
/*    */   }
/*    */   
/*    */   public int getConsecutiveHits()
/*    */   {
/* 31 */     return this.hitCount;
/*    */   }
/*    */   
/*    */   public void resetHitCount()
/*    */   {
/* 36 */     this.hitCount = 0;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/FocusedTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */