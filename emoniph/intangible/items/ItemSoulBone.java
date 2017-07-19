/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.blocks.BlockCrystal.TileEntityCrystal;
/*    */ import emoniph.intangible.blocks.ModBlocks;
/*    */ import emoniph.intangible.fx.ParticleFactory;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.EnumDyeColor;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumParticleTypes;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemSoulBone extends net.minecraft.item.Item implements IItem, ICreativeSort
/*    */ {
/*    */   private static final int MIN_WAIT = 1200;
/*    */   
/*    */   public boolean onEntityItemUpdate(EntityItem entity)
/*    */   {
/*    */     World world;
/*    */     BlockPos pos;
/*    */     List<EntityItem> items;
/* 29 */     if (!entity.field_70170_p.field_72995_K) {
/* 30 */       int MIN_AGE = 1200;
/* 31 */       if (entity.field_70292_b % 20 == 2) {
/* 32 */         world = entity.field_70170_p;
/* 33 */         pos = new BlockPos(entity);
/* 34 */         if (entity.field_70292_b >= 1200) {
/* 35 */           IBlockState state = world.func_180495_p(pos);
/* 36 */           if ((state.func_177230_c() == Blocks.field_150355_j) || (state.func_177230_c() == Blocks.field_150358_i)) {
/* 37 */             items = world.func_72872_a(EntityItem.class, entity.func_174813_aQ().func_72314_b(1.0D, 1.0D, 1.0D));
/* 38 */             for (EntityItem item : items) {
/* 39 */               ItemStack otherStack = item.func_92059_d();
/* 40 */               if ((otherStack.func_77973_b() == Items.field_151100_aR) && (EnumDyeColor.func_176766_a(otherStack.func_77952_i()) == EnumDyeColor.BLUE) && 
/* 41 */                 (new BlockPos(item).equals(pos)) && (item.field_70292_b >= 1200)) {
/* 42 */                 if (--otherStack.field_77994_a == 0) {
/* 43 */                   world.func_72900_e(entity);
/*    */                 }
/* 45 */                 if (--entity.func_92059_d().field_77994_a == 0) {
/* 46 */                   world.func_72900_e(item);
/*    */                 }
/* 48 */                 world.func_175656_a(pos, Get.blocks().CRYSTAL.func_176223_P());
/* 49 */                 BlockCrystal.TileEntityCrystal crystal = (BlockCrystal.TileEntityCrystal)emoniph.intangible.util.BlockUtil.getTileEntity(world, pos, BlockCrystal.TileEntityCrystal.class);
/* 50 */                 if (crystal != null) {
/* 51 */                   crystal.requiresFullGrowth();
/*    */                 }
/* 53 */                 Sound.MOD_RANDOM_CLINK.playToAllNear(world, pos);
/*    */                 
/* 55 */                 Get.fx().sendToAllNear(EnumParticleTypes.WATER_BUBBLE, world, pos, 0.5F, 40);
/* 56 */                 break;
/*    */               }
/*    */             }
/*    */           }
/*    */         }
/* 61 */         else if (entity.field_70292_b % 40 == 2) {
/* 62 */           List<EntityItem> items = world.func_72872_a(EntityItem.class, entity.func_174813_aQ().func_72314_b(1.0D, 1.0D, 1.0D));
/* 63 */           for (EntityItem item : items) {
/* 64 */             ItemStack otherStack = item.func_92059_d();
/* 65 */             if ((otherStack.func_77973_b() == Items.field_151100_aR) && (EnumDyeColor.func_176766_a(otherStack.func_77952_i()) == EnumDyeColor.BLUE)) {
/* 66 */               Get.fx().sendToAllNear(EnumParticleTypes.WATER_BUBBLE, world, pos, 0.25F, 10);
/* 67 */               break;
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 78 */     return 49;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemSoulBone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */