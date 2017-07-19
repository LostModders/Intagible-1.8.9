/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.deity.WorshipCache;
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyBool;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockPantheon extends BlockContainer implements IBlock, ICreativeSort
/*     */ {
/*  34 */   public static final PropertyBool POWERED = PropertyBool.func_177716_a("powered");
/*     */   
/*     */   BlockPantheon() {
/*  37 */     super(Material.field_151576_e);
/*  38 */     func_149711_c(3.0F);
/*  39 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(POWERED, Boolean.valueOf(false)));
/*  40 */     func_149675_a(true);
/*     */     
/*  42 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8F, 1.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  47 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand) {
/*  51 */     TileEntityPantheon tile = (TileEntityPantheon)BlockUtil.getTileEntity(worldIn, pos, TileEntityPantheon.class);
/*  52 */     if (tile != null) {
/*  53 */       tile.syncWorship();
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/*  60 */     return EnumWorldBlockLayer.CUTOUT;
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/*  65 */     return func_176223_P().func_177226_a(POWERED, Boolean.valueOf((meta & 0x1) == 1));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/*  70 */     return ((Boolean)state.func_177229_b(POWERED)).booleanValue() ? 1 : 0;
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  75 */     updateState(worldIn, pos, state);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state) {}
/*     */   
/*     */ 
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/*  85 */     updateState(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private void updateState(World worldIn, BlockPos pos, IBlockState state) {
/*  89 */     if (!worldIn.field_72995_K) {
/*  90 */       boolean currentPowered = ((Boolean)state.func_177229_b(POWERED)).booleanValue();
/*  91 */       if (worldIn.func_175640_z(pos)) {
/*  92 */         if (!currentPowered) {
/*  93 */           worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(true)));
/*  94 */           TileEntityPantheon tile = (TileEntityPantheon)BlockUtil.getTileEntity(worldIn, pos, TileEntityPantheon.class);
/*  95 */           if (tile != null) {
/*  96 */             tile.triggerStateChange();
/*     */           }
/*     */         }
/*     */       }
/* 100 */       else if (currentPowered) {
/* 101 */         worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(false)));
/* 102 */         TileEntityPantheon tile = (TileEntityPantheon)BlockUtil.getTileEntity(worldIn, pos, TileEntityPantheon.class);
/* 103 */         if (tile != null) {
/* 104 */           tile.triggerStateChange();
/*     */         }
/*     */       }
/*     */       
/* 108 */       if (currentPowered != ((Boolean)state.func_177229_b(POWERED)).booleanValue()) {
/* 109 */         worldIn.func_175685_c(pos, this);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/* 116 */     return new TileEntityPantheon();
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/* 121 */     return new BlockState(this, new IProperty[] { POWERED });
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/* 126 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/* 131 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/* 136 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 141 */     return false;
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 146 */     return 80;
/*     */   }
/*     */   
/*     */   public static class TileEntityPantheon extends TileEntity {
/*     */     public long timeOfLastStateChange;
/*     */     public WorshipCache currentCache;
/*     */     
/*     */     public void func_145834_a(World worldIn) {
/* 154 */       super.func_145834_a(worldIn);
/* 155 */       syncWorship();
/*     */     }
/*     */     
/*     */     void triggerStateChange() {
/* 159 */       this.timeOfLastStateChange = this.field_145850_b.func_82737_E();
/* 160 */       syncWorship();
/* 161 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 167 */       AxisAlignedBB aabb = new AxisAlignedBB(func_174877_v().func_177982_a(-2, 0, -2), func_174877_v().func_177982_a(3, 3, 3));
/* 168 */       return aabb;
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 173 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public Packet func_145844_m()
/*     */     {
/* 178 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 179 */       func_145841_b(nbtTag);
/* 180 */       if (this.currentCache != null) {
/* 181 */         nbtTag.func_74782_a("deityCache", this.currentCache.getTagCompound());
/*     */       }
/* 183 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 188 */       super.onDataPacket(net, packet);
/* 189 */       NBTTagCompound compound = packet.func_148857_g();
/* 190 */       func_145839_a(compound);
/* 191 */       if (compound.func_150297_b("deityCache", 10)) {
/* 192 */         this.currentCache = WorshipCache.fromTagCompound(compound.func_74775_l("deityCache"));
/*     */       }
/* 194 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 199 */       super.func_145839_a(compound);
/* 200 */       this.timeOfLastStateChange = compound.func_74763_f("timeOfLastStateChange");
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 206 */       super.func_145841_b(compound);
/* 207 */       compound.func_74772_a("timeOfLastStateChange", this.timeOfLastStateChange);
/*     */     }
/*     */     
/*     */ 
/*     */     public void syncWorship()
/*     */     {
/* 213 */       if (!this.field_145850_b.field_72995_K) {
/* 214 */         WorshipCache cache = WorshipCache.fromDeities(Get.deities().forWorld(this.field_145850_b));
/* 215 */         if ((cache != null) && ((this.currentCache == null) || (!this.currentCache.equals(cache)))) {
/* 216 */           this.currentCache = cache;
/* 217 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockPantheon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */