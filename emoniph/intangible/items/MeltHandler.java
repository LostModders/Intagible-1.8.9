/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fluids.Fluid;
/*    */ 
/*    */ public class MeltHandler
/*    */ {
/*    */   public static boolean handleItemTick(EntityItem entity, IMeltableItem meltable)
/*    */   {
/* 12 */     World world = entity.field_70170_p;
/* 13 */     if ((entity != null) && (entity.field_70173_aa > 1)) {
/* 14 */       BlockPos pos = new BlockPos(entity);
/* 15 */       net.minecraft.block.Block block = world.func_180495_p(pos).func_177230_c();
/* 16 */       Fluid fluid = net.minecraftforge.fluids.FluidRegistry.lookupFluidForBlock(block);
/* 17 */       if ((fluid != null) && (fluid.getTemperature() > meltable.getMeltingTemperature())) {
/* 18 */         if ((!world.field_72995_K) && (entity.field_70173_aa > 100)) {
/* 19 */           world.func_72900_e(entity);
/* 20 */           world.func_175656_a(pos, meltable.getMoltenBlock().func_176223_P());
/*    */         }
/* 22 */         if (entity.field_70181_x > 0.0D) {
/* 23 */           entity.field_70181_x = 0.0D;
/*    */         }
/* 25 */         return true;
/*    */       }
/*    */     }
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/MeltHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */