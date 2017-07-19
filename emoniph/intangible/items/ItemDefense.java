/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.BlockDefense;
/*     */ import emoniph.intangible.blocks.BlockDefense.TileEntityDefense;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.TextUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ItemDefense extends ItemBlock
/*     */ {
/*     */   public ItemDefense(Block blockType)
/*     */   {
/*  27 */     super(blockType);
/*     */   }
/*     */   
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced)
/*     */   {
/*  32 */     super.func_77624_a(stack, playerIn, tooltip, advanced);
/*     */     
/*  34 */     NBTTagCompound compound = stack.func_77978_p();
/*  35 */     if (compound != null) {
/*  36 */       EnumSoulType soulType = BlockDefense.getSoulType(compound);
/*  37 */       if (soulType != null) {
/*  38 */         tooltip.add(TextUtil.parse(soulType.getLocalizedName()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack stack, int renderPass)
/*     */   {
/*  46 */     if (renderPass == 0) {
/*  47 */       NBTTagCompound compound = stack.func_77978_p();
/*  48 */       if (compound != null) {
/*  49 */         EnumSoulType soulType = BlockDefense.getSoulType(compound);
/*  50 */         if (soulType != null) {
/*  51 */           return soulType.getColor();
/*     */         }
/*     */       }
/*     */       
/*  55 */       return 16777215;
/*     */     }
/*  57 */     return super.func_82790_a(stack, renderPass);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_180614_a(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/*  63 */     if ((worldIn.func_180495_p(pos).func_177230_c().func_176200_f(worldIn, pos)) && (side != EnumFacing.DOWN)) {
/*  64 */       side = EnumFacing.UP;
/*  65 */       pos = pos.func_177977_b();
/*     */     }
/*  67 */     if (side == EnumFacing.DOWN) {
/*  68 */       return false;
/*     */     }
/*  70 */     IBlockState iblockstate = worldIn.func_180495_p(pos);
/*  71 */     Block block = iblockstate.func_177230_c();
/*  72 */     boolean flag = block.func_176200_f(worldIn, pos);
/*     */     
/*  74 */     if (!flag) {
/*  75 */       if (!worldIn.isSideSolid(pos, side, true)) {
/*  76 */         return false;
/*     */       }
/*     */       
/*  79 */       pos = pos.func_177972_a(side);
/*     */     }
/*     */     
/*  82 */     if (!playerIn.func_175151_a(pos, side, stack))
/*  83 */       return false;
/*  84 */     if (!Get.blocks().DEFENSE.func_176196_c(worldIn, pos)) {
/*  85 */       return false;
/*     */     }
/*  87 */     if (!worldIn.field_72995_K) {
/*  88 */       if (!Get.blocks().DEFENSE.func_176198_a(worldIn, pos, side)) {
/*  89 */         return false;
/*     */       }
/*     */       
/*  92 */       worldIn.func_180501_a(pos, Get.blocks().DEFENSE.func_176223_P(), 3);
/*     */       
/*     */ 
/*  95 */       BlockDefense.TileEntityDefense tile = (BlockDefense.TileEntityDefense)BlockUtil.getTileEntity(worldIn, pos, BlockDefense.TileEntityDefense.class);
/*     */       
/*  97 */       if ((tile != null) && 
/*  98 */         (stack.func_77942_o())) {
/*  99 */         tile.readItemFromNBT(stack.func_77978_p());
/*     */       }
/*     */       
/* 102 */       IBlockState state = worldIn.func_180495_p(pos);
/* 103 */       if (state.func_177230_c() == this.field_150939_a) {
/* 104 */         this.field_150939_a.func_180633_a(worldIn, pos, state, playerIn, stack);
/*     */       }
/*     */       
/*     */ 
/* 108 */       stack.field_77994_a -= 1;
/*     */     }
/*     */     
/* 111 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_179222_a(World worldIn, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack)
/*     */   {
/* 118 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemDefense.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */