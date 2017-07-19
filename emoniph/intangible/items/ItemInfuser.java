/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.blocks.BlockInfuser.TileEntityInfuser;
/*    */ import emoniph.intangible.util.BlockUtil;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.Block.SoundType;
/*    */ import net.minecraft.block.BlockSnow;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class ItemInfuser extends ItemBlock
/*    */ {
/*    */   public ItemInfuser(Block blockType)
/*    */   {
/* 22 */     super(blockType);
/*    */   }
/*    */   
/*    */   public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
/*    */   {
/* 27 */     if (worldIn.field_72995_K) {
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     IBlockState iblockstate = worldIn.func_180495_p(pos);
/* 32 */     Block block = iblockstate.func_177230_c();
/*    */     
/* 34 */     if ((block == net.minecraft.init.Blocks.field_150431_aC) && (((Integer)iblockstate.func_177229_b(BlockSnow.field_176315_a)).intValue() < 1)) {
/* 35 */       side = EnumFacing.UP;
/* 36 */     } else if (!block.func_176200_f(worldIn, pos)) {
/* 37 */       pos = pos.func_177972_a(side);
/*    */     }
/*    */     
/* 40 */     if (stack.field_77994_a == 0)
/* 41 */       return false;
/* 42 */     if (!playerIn.func_175151_a(pos, side, stack))
/* 43 */       return false;
/* 44 */     if ((pos.func_177956_o() == 255) && (this.field_150939_a.func_149688_o().func_76220_a()))
/* 45 */       return false;
/* 46 */     if (worldIn.func_175716_a(this.field_150939_a, pos, false, side, (net.minecraft.entity.Entity)null, stack)) {
/* 47 */       int i = func_77647_b(stack.func_77960_j());
/* 48 */       IBlockState iblockstate1 = this.field_150939_a.func_180642_a(worldIn, pos, side, hitX, hitY, hitZ, i, playerIn);
/*    */       
/* 50 */       if (placeBlockAt(stack, playerIn, worldIn, pos, side, hitX, hitY, hitZ, iblockstate1)) {
/* 51 */         BlockInfuser.TileEntityInfuser tile = (BlockInfuser.TileEntityInfuser)BlockUtil.getTileEntity(worldIn, pos, BlockInfuser.TileEntityInfuser.class);
/*    */         
/* 53 */         if ((tile != null) && 
/* 54 */           (stack.func_77942_o())) {
/* 55 */           tile.readItemFromNBT(stack.func_77978_p());
/* 56 */           worldIn.func_175689_h(pos);
/*    */         }
/*    */         
/*    */ 
/* 60 */         worldIn.func_72908_a(pos.func_177958_n() + 0.5F, pos.func_177956_o() + 0.5F, pos.func_177952_p() + 0.5F, this.field_150939_a.field_149762_H.func_150496_b(), (this.field_150939_a.field_149762_H.func_150497_c() + 1.0F) / 2.0F, this.field_150939_a.field_149762_H.func_150494_d() * 0.8F);
/* 61 */         stack.field_77994_a -= 1;
/*    */       }
/*    */       
/* 64 */       return true;
/*    */     }
/* 66 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_179222_a(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
/*    */   {
/* 72 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemInfuser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */