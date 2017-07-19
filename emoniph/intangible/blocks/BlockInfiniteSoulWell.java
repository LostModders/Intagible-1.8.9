/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.ISoulWell;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockInfiniteSoulWell extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   public BlockInfiniteSoulWell()
/*     */   {
/*  22 */     super(net.minecraft.block.material.Material.field_151576_e);
/*     */   }
/*     */   
/*     */   public int func_149645_b() {
/*  26 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  31 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  36 */     TileEntityInfiniteSoulWell tile = (TileEntityInfiniteSoulWell)BlockUtil.getTileEntity(worldIn, pos, TileEntityInfiniteSoulWell.class);
/*  37 */     if (tile != null) {
/*  38 */       Get.wells().addWell(tile, worldIn);
/*     */     }
/*  40 */     super.func_176213_c(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  45 */     TileEntityInfiniteSoulWell tile = (TileEntityInfiniteSoulWell)BlockUtil.getTileEntity(worldIn, pos, TileEntityInfiniteSoulWell.class);
/*  46 */     if (tile != null) {
/*  47 */       Get.wells().removeWell(tile);
/*     */     }
/*  49 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  54 */     return new TileEntityInfiniteSoulWell();
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  59 */     return 150;
/*     */   }
/*     */   
/*     */   public static class TileEntityInfiniteSoulWell extends TileEntity implements ISoulWell
/*     */   {
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/*  66 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public boolean isWellActive()
/*     */     {
/*  71 */       return true;
/*     */     }
/*     */     
/*     */     public boolean tryUseSouls(ISoulSet souls, int cooldownTicks)
/*     */     {
/*  76 */       return true;
/*     */     }
/*     */     
/*     */     public boolean tryTakeSouls(ISoulSet souls)
/*     */     {
/*  81 */       return true;
/*     */     }
/*     */     
/*     */     public ISoulSet reportAvailableSoulsFrom(ISoulSet souls)
/*     */     {
/*  86 */       return new SoulSet(souls);
/*     */     }
/*     */     
/*     */     public void onLoad()
/*     */     {
/*  91 */       super.onLoad();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_145843_s()
/*     */     {
/*  98 */       super.func_145843_s();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void add(ISoulSet souls) {}
/*     */     
/*     */ 
/*     */     public World getWellWorld()
/*     */     {
/* 108 */       return this.field_145850_b;
/*     */     }
/*     */     
/*     */     public BlockPos getWellPos()
/*     */     {
/* 113 */       return this.field_174879_c;
/*     */     }
/*     */     
/*     */     public boolean isWellInvalid()
/*     */     {
/* 118 */       return func_145837_r();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockInfiniteSoulWell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */