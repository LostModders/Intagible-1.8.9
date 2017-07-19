/*    */ package emoniph.intangible;
/*    */ 
/*    */ import emoniph.intangible.init.IModService;
/*    */ import java.util.ArrayDeque;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Queue;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ 
/*    */ public class ActionQueue implements IModService
/*    */ {
/* 13 */   private Map<Integer, Queue<IAction>> worldActions = new HashMap();
/*    */   
/*    */   public void queue(World world, IAction action) {
/* 16 */     Queue<IAction> queue = (Queue)this.worldActions.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/* 17 */     if (queue == null) {
/* 18 */       queue = new ArrayDeque();
/* 19 */       this.worldActions.put(Integer.valueOf(world.field_73011_w.func_177502_q()), queue);
/*    */     }
/*    */     
/* 22 */     queue.offer(action);
/*    */   }
/*    */   
/*    */   public void processQueue(World world, int maxItems) {
/* 26 */     Queue<IAction> queue = (Queue)this.worldActions.get(Integer.valueOf(world.field_73011_w.func_177502_q()));
/* 27 */     if (queue != null) {
/*    */       IAction action;
/* 29 */       while (((action = (IAction)queue.poll()) != null) && (maxItems-- > 0)) {
/* 30 */         action.doAction(world);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public static abstract interface IAction
/*    */   {
/*    */     public abstract void doAction(World paramWorld);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/ActionQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */