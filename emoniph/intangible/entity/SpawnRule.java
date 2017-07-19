/*    */ package emoniph.intangible.entity;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ class SpawnRule {
/*    */   private final int weight;
/*    */   private final VariableQuantity quantity;
/*    */   private final net.minecraft.entity.EnumCreatureType creatureType;
/*    */   private final BiomeGenBase[] biomeList;
/*    */   
/*    */   static class VariableQuantity { private final int from;
/*    */     private final int to;
/*    */     
/* 14 */     VariableQuantity(int from, int to) { this.from = from;
/* 15 */       this.to = to;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   SpawnRule(int weight, VariableQuantity quantity, net.minecraft.entity.EnumCreatureType creatureType, BiomeGenBase... biomeList)
/*    */   {
/* 25 */     this.weight = weight;
/* 26 */     this.quantity = quantity;
/* 27 */     this.creatureType = creatureType;
/* 28 */     this.biomeList = biomeList;
/*    */   }
/*    */   
/*    */   void register(Class<? extends net.minecraft.entity.EntityLiving> livingClass) {
/* 32 */     net.minecraftforge.fml.common.registry.EntityRegistry.addSpawn(livingClass, this.weight, this.quantity.from, this.quantity.to, this.creatureType, this.biomeList);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/SpawnRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */