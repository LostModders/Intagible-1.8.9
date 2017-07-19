/*    */ package emoniph.intangible.recipes;
/*    */ 
/*    */ import emoniph.intangible.api.ISoulSet;
/*    */ import emoniph.intangible.api.SoulType;
/*    */ import emoniph.intangible.souls.SoulSet;
/*    */ import java.lang.reflect.Constructor;
/*    */ import java.lang.reflect.InvocationTargetException;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class CreatureRecipe
/*    */ {
/*    */   private final Class<? extends EntityLiving> result;
/*    */   private final Class<? extends EntityLiving> inputCreature;
/*    */   private final SoulType[] inputSouls;
/*    */   private final String bookKey;
/*    */   
/*    */   public CreatureRecipe(Class<? extends EntityLiving> result, Class<? extends EntityLiving> inputCreature, SoulType inputSoul, String bookKey)
/*    */   {
/* 22 */     this(result, inputCreature, new SoulType[] { inputSoul }, bookKey);
/*    */   }
/*    */   
/*    */   public CreatureRecipe(Class<? extends EntityLiving> result, Class<? extends EntityLiving> inputCreature, SoulType[] inputSouls, String bookKey) {
/* 26 */     this.result = result;
/* 27 */     this.inputCreature = inputCreature;
/* 28 */     this.inputSouls = inputSouls;
/* 29 */     this.bookKey = bookKey;
/*    */   }
/*    */   
/*    */   public boolean isMatchFor(EntityLiving entity)
/*    */   {
/* 34 */     return entity.getClass() == this.inputCreature;
/*    */   }
/*    */   
/*    */   public ISoulSet getSoulSet() {
/* 38 */     SoulSet souls = new SoulSet();
/* 39 */     for (SoulType soul : this.inputSouls) {
/* 40 */       souls.add(soul, 1);
/*    */     }
/* 42 */     return souls;
/*    */   }
/*    */   
/*    */   public String getBookKey() {
/* 46 */     return this.bookKey;
/*    */   }
/*    */   
/*    */   public EntityLiving createResult(World world, BlockPos pos) {
/*    */     try {
/* 51 */       Constructor<? extends EntityLiving> con = this.result.getConstructor(new Class[] { World.class });
/* 52 */       EntityLiving entity = (EntityLiving)con.newInstance(new Object[] { world });
/* 53 */       entity.func_70080_a(pos.func_177958_n() + 0.5D, pos.func_177956_o(), pos.func_177952_p() + 0.5D, 0.0F, 0.0F);
/* 54 */       entity.func_180482_a(world.func_175649_E(pos), null);
/* 55 */       return entity;
/*    */     } catch (NoSuchMethodException e) {
/* 57 */       return null;
/*    */     } catch (InstantiationException e) {
/* 59 */       return null;
/*    */     } catch (IllegalAccessException e) {
/* 61 */       return null;
/*    */     } catch (InvocationTargetException e) {}
/* 63 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/CreatureRecipe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */