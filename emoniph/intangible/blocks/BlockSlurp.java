/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.MapColor;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockSlurp
/*     */   extends BlockContainer implements IBlock
/*     */ {
/*     */   public static class MaterialTransparentish extends Material
/*     */   {
/*     */     public MaterialTransparentish(MapColor color)
/*     */     {
/*  27 */       super();
/*  28 */       func_76225_o();
/*     */     }
/*     */     
/*     */     public boolean func_76220_a()
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*     */     public boolean func_76228_b() {
/*  37 */       return false;
/*     */     }
/*     */     
/*     */     public boolean func_76230_c() {
/*  41 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   protected BlockSlurp() {
/*  46 */     super(new MaterialTransparentish(MapColor.field_151660_b));
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  51 */     return new TileEntitySlurp();
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  56 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  61 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  71 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_176209_a(IBlockState state, boolean hitIfLiquid)
/*     */   {
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  81 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {}
/*     */   
/*     */ 
/*     */   public void replaceBlockAt(World world, BlockPos pos, int timeoutTicks)
/*     */   {
/*  95 */     if (!world.field_72995_K) {
/*  96 */       IBlockState state = world.func_180495_p(pos);
/*  97 */       if ((state.func_177230_c() != Blocks.field_150350_a) && 
/*  98 */         (state.func_177230_c().func_176195_g(world, pos) >= 0.0F) && 
/*  99 */         (!state.func_177230_c().hasTileEntity(state)) && 
/* 100 */         (state.func_177230_c() != Get.blocks().SOUL_CAGE) && 
/* 101 */         (BlockUtil.canEditBlock(world, pos))) {
/* 102 */         world.func_175656_a(pos, func_176223_P());
/* 103 */         TileEntitySlurp tile = (TileEntitySlurp)BlockUtil.getTileEntity(world, pos, TileEntitySlurp.class);
/* 104 */         if (tile != null) {
/* 105 */           tile.savedState = Block.func_176210_f(state);
/* 106 */           tile.timeout = timeoutTicks;
/*     */         }
/* 108 */         world.func_175684_a(pos, this, timeoutTicks);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void extendSlurp(World world, BlockPos pos, int timeoutTicks) {
/* 114 */     if (!world.field_72995_K) {
/* 115 */       TileEntitySlurp tile = (TileEntitySlurp)BlockUtil.getTileEntity(world, pos, TileEntitySlurp.class);
/* 116 */       if (tile != null) {
/* 117 */         tile.repeat = true;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand)
/*     */   {
/* 125 */     if (!worldIn.field_72995_K) {
/* 126 */       TileEntitySlurp tile = (TileEntitySlurp)BlockUtil.getTileEntity(worldIn, pos, TileEntitySlurp.class);
/* 127 */       if ((tile != null) && (tile.timeout > 0)) {
/* 128 */         if (tile.repeat) {
/* 129 */           tile.repeat = false;
/* 130 */           worldIn.func_175684_a(pos, this, tile.timeout);
/*     */         } else {
/* 132 */           worldIn.func_175656_a(pos, Block.func_176220_d(tile.savedState));
/*     */         }
/*     */       } else {
/* 135 */         worldIn.func_175698_g(pos);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class TileEntitySlurp
/*     */     extends TileEntity
/*     */   {
/* 145 */     private int savedState = 0;
/* 146 */     private int timeout = -1;
/*     */     private boolean repeat;
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 151 */       super.func_145841_b(compound);
/* 152 */       compound.func_74768_a("timeout", this.timeout);
/* 153 */       compound.func_74768_a("savedState", this.savedState);
/* 154 */       compound.func_74757_a("repeat", this.repeat);
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 159 */       super.func_145839_a(compound);
/* 160 */       this.timeout = compound.func_74762_e("timeout");
/* 161 */       this.savedState = compound.func_74762_e("savedState");
/* 162 */       this.repeat = compound.func_74767_n("repeat");
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 167 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockSlurp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */