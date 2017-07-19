/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.ISoulRelay;
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.souls.RelayNetwork;
/*     */ import emoniph.intangible.util.BlockUtil;
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
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockSoulRelay extends BlockContainer implements IBlock, ICreativeSort
/*     */ {
/*  30 */   public static final PropertyBool POWERED = PropertyBool.func_177716_a("powered");
/*     */   
/*     */   BlockSoulRelay() {
/*  33 */     super(Material.field_151576_e);
/*  34 */     func_149711_c(3.0F);
/*     */     
/*  36 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(POWERED, Boolean.valueOf(false)));
/*  37 */     float inset = 0.125F;
/*  38 */     func_149676_a(inset, 0.0F, inset, 1.0F - inset, 1.0F, 1.0F - inset);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  43 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/*  48 */     return func_176223_P().func_177226_a(POWERED, Boolean.valueOf((meta & 0x1) == 1));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/*  53 */     return ((Boolean)state.func_177229_b(POWERED)).booleanValue() ? 1 : 0;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  58 */     return new TileEntitySoulRelay();
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/*  63 */     return new BlockState(this, new IProperty[] { POWERED });
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  68 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  73 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int func_176211_b(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/*  83 */     return super.func_180656_a(worldIn, pos, state, side);
/*     */   }
/*     */   
/*     */   public int func_180656_a(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/*  88 */     return (side == EnumFacing.DOWN) && (((Boolean)state.func_177229_b(POWERED)).booleanValue()) ? 1 : 0;
/*     */   }
/*     */   
/*     */   public boolean func_149744_f()
/*     */   {
/*  93 */     return true;
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  98 */     updateState(worldIn, pos, state);
/*  99 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/* 100 */     TileEntitySoulRelay tile = (TileEntitySoulRelay)BlockUtil.getTileEntity(worldIn, pos, TileEntitySoulRelay.class);
/* 101 */     if (tile != null) {
/* 102 */       Get.relays().addRelay(tile, worldIn);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 108 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/* 109 */     TileEntitySoulRelay tile = (TileEntitySoulRelay)BlockUtil.getTileEntity(worldIn, pos, TileEntitySoulRelay.class);
/* 110 */     if (tile != null) {
/* 111 */       Get.relays().removeRelay(tile);
/*     */     }
/* 113 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 118 */     updateState(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private void updateState(World worldIn, BlockPos pos, IBlockState state) {
/* 122 */     if (!worldIn.field_72995_K) {
/* 123 */       boolean currentPower = ((Boolean)state.func_177229_b(POWERED)).booleanValue();
/* 124 */       if (worldIn.func_175640_z(pos)) {
/* 125 */         worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(true)));
/*     */       } else {
/* 127 */         worldIn.func_175656_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(false)));
/*     */       }
/* 129 */       if (currentPower != ((Boolean)state.func_177229_b(POWERED)).booleanValue()) {
/* 130 */         worldIn.func_175685_c(pos, this);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 142 */     return 57;
/*     */   }
/*     */   
/*     */   public static class TileEntitySoulRelay
/*     */     extends TileEntity
/*     */     implements ISoulRelay
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     public int ticks;
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public int getNextAnimationTick()
/*     */     {
/* 155 */       if (this.field_145850_b.func_180495_p(this.field_174879_c).func_177229_b(BlockSoulRelay.POWERED) == Boolean.TRUE) {
/* 156 */         if (++this.ticks >= 360) {
/* 157 */           this.ticks = 0;
/*     */         }
/*     */       }
/* 160 */       else if (this.ticks >= 0) {
/* 161 */         this.ticks -= 1;
/*     */       }
/*     */       
/* 164 */       return this.ticks;
/*     */     }
/*     */     
/*     */     public void func_145834_a(World worldIn)
/*     */     {
/* 169 */       super.func_145834_a(worldIn);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_145829_t()
/*     */     {
/* 176 */       super.func_145829_t();
/*     */     }
/*     */     
/*     */     public void onLoad()
/*     */     {
/* 181 */       super.onLoad();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_145843_s()
/*     */     {
/* 188 */       super.func_145843_s();
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 193 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 198 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 199 */       func_145841_b(nbtTag);
/* 200 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 205 */       super.onDataPacket(net, packet);
/* 206 */       func_145839_a(packet.func_148857_g());
/* 207 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 212 */       super.func_145839_a(compound);
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 217 */       super.func_145841_b(compound);
/*     */     }
/*     */     
/*     */     public boolean isRelayActive()
/*     */     {
/* 222 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/*     */       
/*     */ 
/* 225 */       return (state.func_177230_c() == Get.blocks().SOUL_RELAY) && (state.func_177229_b(BlockSoulRelay.POWERED) == Boolean.TRUE) && (this.field_145850_b.func_180495_p(this.field_174879_c.func_177977_b()).func_177230_c() != Get.blocks().SOUL_RELAY) && (this.field_145850_b.func_180495_p(this.field_174879_c.func_177984_a()).func_177230_c() != Get.blocks().SOUL_RELAY);
/*     */     }
/*     */     
/*     */     public World getRelayWorld()
/*     */     {
/* 230 */       return this.field_145850_b;
/*     */     }
/*     */     
/*     */     public BlockPos getRelayPos()
/*     */     {
/* 235 */       return this.field_174879_c;
/*     */     }
/*     */     
/*     */     public boolean isRelayInvalid()
/*     */     {
/* 240 */       return func_145837_r();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockSoulRelay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */