/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.common.IPlantable;
/*    */ 
/*    */ 
/*    */ public enum CropUtil
/*    */ {
/* 18 */   private static final List<ItemStack> CROP_ITEMS = Arrays.asList(new ItemStack[] { new ItemStack(Items.field_151034_e), new ItemStack(Items.field_151015_O), new ItemStack(Items.field_151172_bF), new ItemStack(Items.field_151174_bG), new ItemStack(Blocks.field_150338_P), new ItemStack(Blocks.field_150337_Q) });
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 27 */   private static final List<ItemStack> PLANTABLES = Arrays.asList(new ItemStack[] { new ItemStack(Items.field_151014_N) });
/*    */   
/*    */   private CropUtil() {}
/*    */   
/*    */   public static boolean isCrop(ItemStack stack) {
/* 32 */     if (stack != null) {
/* 33 */       for (ItemStack crop : CROP_ITEMS) {
/* 34 */         if (ItemStack.func_179545_c(crop, stack)) {
/* 35 */           return true;
/*    */         }
/*    */       }
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public static IBlockState getRandomCrop(World world, BlockPos pos, Random rand) {
/* 43 */     ItemStack stack = (ItemStack)PLANTABLES.get(rand.nextInt(PLANTABLES.size()));
/* 44 */     IPlantable plantable = (IPlantable)stack.func_77973_b();
/* 45 */     return plantable.getPlant(world, pos);
/*    */   }
/*    */   
/*    */   private static class WeightedItemStack {
/*    */     private final ItemStack stack;
/*    */     private final int weight;
/*    */     
/*    */     public WeightedItemStack(ItemStack stack, int weight) {
/* 53 */       this.stack = stack;
/* 54 */       this.weight = weight;
/*    */     }
/*    */   }
/*    */   
/* 58 */   private static final List<WeightedItemStack> FOODS = Arrays.asList(new WeightedItemStack[] { new WeightedItemStack(new ItemStack(Items.field_151034_e), 5), new WeightedItemStack(new ItemStack(Items.field_151158_bO), 1), new WeightedItemStack(new ItemStack(Items.field_151105_aU), 1), new WeightedItemStack(new ItemStack(Items.field_151168_bH), 3), new WeightedItemStack(new ItemStack(Items.field_151172_bF), 5), new WeightedItemStack(new ItemStack(Items.field_151025_P), 4), new WeightedItemStack(new ItemStack(Items.field_151106_aX), 2), new WeightedItemStack(new ItemStack(Items.field_151127_ba), 5) });
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static ItemStack getRandomFood(Random rand)
/*    */   {
/* 70 */     int count = 0;
/* 71 */     for (Iterator localIterator = FOODS.iterator(); localIterator.hasNext();) { stack = (WeightedItemStack)localIterator.next();
/* 72 */       count += stack.weight; }
/*    */     WeightedItemStack stack;
/* 74 */     int index = rand.nextInt(count);
/* 75 */     count = 0;
/* 76 */     for (WeightedItemStack stack : FOODS) {
/* 77 */       count += stack.weight;
/* 78 */       if (index < count) {
/* 79 */         return stack.stack;
/*    */       }
/*    */     }
/* 82 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/CropUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */