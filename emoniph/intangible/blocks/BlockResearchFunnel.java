/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.entity.EntityHollowIronGolem;
/*    */ import emoniph.intangible.souls.SoulRegistry;
/*    */ import emoniph.intangible.util.BlockUtil;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class BlockResearchFunnel
/*    */   extends BlockResearch
/*    */ {
/*    */   BlockResearchFunnel()
/*    */   {
/* 21 */     super(Material.field_151592_s, 0);
/* 22 */     func_149711_c(1.0F);
/* 23 */     func_149676_a(0.2F, 0.0F, 0.2F, 0.8F, 0.9F, 0.8F);
/*    */   }
/*    */   
/*    */   public boolean isInputFace(EnumFacing face, BlockResearch.TileEntityResearchBlock tile)
/*    */   {
/* 28 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isOutputFace(EnumFacing face, BlockResearch.TileEntityResearchBlock tile)
/*    */   {
/* 33 */     return face.func_176736_b() >= 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   protected void onPowerChanged(World worldIn, BlockPos pos, IBlockState state, boolean powered)
/*    */   {
/* 40 */     super.onPowerChanged(worldIn, pos, state, powered);
/*    */     
/* 42 */     if (worldIn.field_72995_K) {
/* 43 */       return;
/*    */     }
/*    */     
/* 46 */     TileEntityResearchFunnel tile = (TileEntityResearchFunnel)BlockUtil.getTileEntity(worldIn, pos, TileEntityResearchFunnel.class);
/* 47 */     if (tile != null) {
/* 48 */       if (powered) {
/* 49 */         for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 50 */           BlockPos cagePos = pos.func_177972_a(facing);
/* 51 */           IBlockState cageState = worldIn.func_180495_p(cagePos);
/* 52 */           if (cageState.func_177230_c() == Get.blocks().BONE_CAGE) {
/* 53 */             BlockBoneCage.TileEntityBoneCage cage = (BlockBoneCage.TileEntityBoneCage)BlockUtil.getTileEntity(worldIn, cagePos, BlockBoneCage.TileEntityBoneCage.class, cageState);
/* 54 */             if (cage == null) break;
/* 55 */             EntityLiving entity = cage.getTrappedEntity();
/* 56 */             if ((entity != null) && 
/* 57 */               (Get.souls().isSoulPresent(entity, true))) {
/* 58 */               BlockBoneCage.RelayField instability = cage.isInRelayField();
/* 59 */               if ((entity instanceof EntityHollowIronGolem)) {
/* 60 */                 tile.setSoulType(((EntityHollowIronGolem)entity).getTrappedSoulType(), instability, cage.func_174877_v());
/*    */               } else {
/* 62 */                 tile.setSoulType(entity.getClass(), instability, cage.func_174877_v());
/*    */               }
/* 64 */               return;
/*    */             }
/*    */             
/* 67 */             break;
/*    */           }
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 73 */       tile.setSoulType(null, BlockBoneCage.RelayField.NONE, null);
/*    */     }
/*    */   }
/*    */   
/*    */   public TileEntity func_149915_a(World world, int meta)
/*    */   {
/* 79 */     return new TileEntityResearchFunnel();
/*    */   }
/*    */   
/*    */   public static class TileEntityResearchFunnel
/*    */     extends BlockResearch.TileEntityResearchBlock
/*    */   {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockResearchFunnel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */