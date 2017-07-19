/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.util.MathUtil;
/*     */ import net.minecraft.block.BlockButton;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockLargeButton extends BlockButton implements IBlock, emoniph.intangible.api.golem.IGolemStartable, ICreativeSort
/*     */ {
/*     */   protected BlockLargeButton()
/*     */   {
/*  18 */     super(false);
/*     */   }
/*     */   
/*     */   public void startWithGolem(World worldIn, BlockPos pos, EntityPlayer player)
/*     */   {
/*  23 */     IBlockState state = worldIn.func_180495_p(pos);
/*  24 */     if (((Boolean)state.func_177229_b(field_176584_b)).booleanValue()) {
/*  25 */       return;
/*     */     }
/*  27 */     worldIn.func_180501_a(pos, state.func_177226_a(field_176584_b, Boolean.valueOf(true)), 3);
/*  28 */     worldIn.func_175704_b(pos, pos);
/*  29 */     worldIn.func_72908_a(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, "random.click", 0.3F, 0.6F);
/*     */     
/*  31 */     worldIn.func_175685_c(pos, this);
/*  32 */     worldIn.func_175685_c(pos.func_177972_a(((EnumFacing)state.func_177229_b(field_176585_a)).func_176734_d()), this);
/*     */     
/*  34 */     worldIn.func_175684_a(pos, this, func_149738_a(worldIn));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/*  41 */     return true;
/*     */   }
/*     */   
/*     */   public void func_180654_a(IBlockAccess worldIn, BlockPos pos)
/*     */   {
/*  46 */     IBlockState state = worldIn.func_180495_p(pos);
/*  47 */     EnumFacing enumfacing = (EnumFacing)state.func_177229_b(field_176585_a);
/*  48 */     boolean flag = ((Boolean)state.func_177229_b(field_176584_b)).booleanValue();
/*  49 */     float height = (flag ? 1 : 2) / 16.0F;
/*  50 */     float xRadius = MathUtil.sixteenth(4);
/*  51 */     float zRadius = MathUtil.sixteenth(3);
/*     */     
/*  53 */     switch (SwitchEnumFacing.FACING_LOOKUP[enumfacing.ordinal()]) {
/*     */     case 1: 
/*  55 */       func_149676_a(0.0F, 0.5F - zRadius, 0.5F - xRadius, height, 0.5F + zRadius, 0.5F + xRadius);
/*  56 */       break;
/*     */     case 2: 
/*  58 */       func_149676_a(1.0F - height, 0.5F - zRadius, 0.5F - xRadius, 1.0F, 0.5F + zRadius, 0.5F + xRadius);
/*  59 */       break;
/*     */     case 3: 
/*  61 */       func_149676_a(0.5F - xRadius, 0.5F - zRadius, 0.0F, 0.5F + xRadius, 0.5F + zRadius, height);
/*  62 */       break;
/*     */     case 4: 
/*  64 */       func_149676_a(0.5F - xRadius, 0.5F - zRadius, 1.0F - height, 0.5F + xRadius, 0.5F + zRadius, 1.0F);
/*  65 */       break;
/*     */     case 5: 
/*  67 */       func_149676_a(0.5F - xRadius, 0.0F, 0.5F - zRadius, 0.5F + xRadius, 0.0F + height, 0.5F + zRadius);
/*  68 */       break;
/*     */     case 6: 
/*  70 */       func_149676_a(0.5F - xRadius, 1.0F - height, 0.5F - zRadius, 0.5F + xRadius, 1.0F, 0.5F + zRadius);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public void func_149683_g()
/*     */   {
/*  77 */     float xRadius = MathUtil.sixteenth(4);
/*  78 */     float yRadius = MathUtil.sixteenth(3);
/*  79 */     float zRadius = MathUtil.sixteenth(2);
/*  80 */     func_149676_a(0.5F - xRadius, 0.5F - yRadius, 0.5F - zRadius, 0.5F + xRadius, 0.5F + yRadius, 0.5F + zRadius);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_180634_a(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {}
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  90 */     return 71;
/*     */   }
/*     */   
/*     */   static final class SwitchEnumFacing {
/*  94 */     static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];
/*     */     
/*     */     static {
/*     */       try {
/*  98 */         FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 1;
/*     */       }
/*     */       catch (NoSuchFieldError localNoSuchFieldError1) {}
/*     */       try
/*     */       {
/* 103 */         FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 2;
/*     */       }
/*     */       catch (NoSuchFieldError localNoSuchFieldError2) {}
/*     */       try
/*     */       {
/* 108 */         FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 3;
/*     */       }
/*     */       catch (NoSuchFieldError localNoSuchFieldError3) {}
/*     */       try
/*     */       {
/* 113 */         FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 4;
/*     */       }
/*     */       catch (NoSuchFieldError localNoSuchFieldError4) {}
/*     */       try
/*     */       {
/* 118 */         FACING_LOOKUP[EnumFacing.UP.ordinal()] = 5;
/*     */       }
/*     */       catch (NoSuchFieldError localNoSuchFieldError5) {}
/*     */       try
/*     */       {
/* 123 */         FACING_LOOKUP[EnumFacing.DOWN.ordinal()] = 6;
/*     */       }
/*     */       catch (NoSuchFieldError localNoSuchFieldError6) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockLargeButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */