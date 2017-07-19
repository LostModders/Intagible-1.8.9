/*    */ package emoniph.intangible.entity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ 
/*    */ public class RefEntityLiving extends RefEntity
/*    */ {
/*    */   private final Class<? extends EntityLiving> livingClass;
/* 10 */   private final List<SpawnRule> spawnRules = new ArrayList();
/*    */   
/*    */   RefEntityLiving(int id, Class<? extends EntityLiving> clazz, String name) {
/* 13 */     super(id, clazz, name, 80, 3);
/* 14 */     this.livingClass = clazz;
/*    */   }
/*    */   
/*    */   RefEntityLiving(int id, Class<? extends EntityLiving> clazz, String name, int range, int updates) {
/* 18 */     super(id, clazz, name, range, updates);
/* 19 */     this.livingClass = clazz;
/*    */   }
/*    */   
/*    */   RefEntityLiving addSpawn(SpawnRule spawnRule) {
/* 23 */     this.spawnRules.add(spawnRule);
/* 24 */     return this;
/*    */   }
/*    */   
/*    */   void init()
/*    */   {
/* 29 */     for (SpawnRule spawnRule : this.spawnRules) {
/* 30 */       spawnRule.register(this.livingClass);
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/RefEntityLiving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */