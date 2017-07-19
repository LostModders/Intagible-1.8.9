/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBed;
/*     */ import net.minecraft.block.BlockBed.EnumPartType;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyBool;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
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
/*     */ public class BlockSoulWard extends BlockContainer implements IBlock, ICreativeSort
/*     */ {
/*  39 */   public static final PropertyBool STRUCTURE = PropertyBool.func_177716_a("structure");
/*     */   
/*     */   BlockSoulWard() {
/*  42 */     super(Material.field_151576_e);
/*  43 */     func_149711_c(60.0F);
/*  44 */     func_149752_b(9999.0F);
/*  45 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT));
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  51 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  56 */     return new TileEntitySoulWard();
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  61 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  66 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  76 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  81 */     BlockUtil.notifyDiagonals(worldIn, pos, this);
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  86 */     return false;
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/*  91 */     EnumFacing enumfacing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */     
/*  93 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/*  94 */       if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) {
/*  95 */         worldIn.func_175698_g(pos);
/*     */       }
/*  97 */     } else if (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() != this) {
/*  98 */       worldIn.func_175698_g(pos);
/*     */       
/* 100 */       if (!worldIn.field_72995_K) {
/* 101 */         func_176226_b(worldIn, pos, state, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
/*     */   {
/* 108 */     return super.getDrops(world, pos, state, fortune);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/* 114 */     return EnumWorldBlockLayer.SOLID;
/*     */   }
/*     */   
/*     */   public Item func_180660_a(IBlockState state, Random rand, int fortune)
/*     */   {
/* 119 */     return state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD ? null : Item.func_150898_a(this);
/*     */   }
/*     */   
/*     */   public void func_180654_a(IBlockAccess worldIn, BlockPos pos)
/*     */   {
/* 124 */     IBlockState state = worldIn.func_180495_p(pos);
/* 125 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 126 */     BlockBed.EnumPartType part = (BlockBed.EnumPartType)state.func_177229_b(BlockBed.field_176472_a);
/*     */     float radius2;
/*     */     float radius2;
/*     */     float radius;
/* 130 */     if ((facing == EnumFacing.EAST) || (facing == EnumFacing.WEST)) {
/* 131 */       float radius = 0.09F;
/* 132 */       radius2 = 0.28125F;
/*     */     } else {
/* 134 */       radius2 = 0.09F;
/* 135 */       radius = 0.28125F;
/*     */     }
/*     */     
/* 138 */     func_149676_a(0.0F + radius, 0.0F, 0.0F + radius2, 1.0F - radius, 1.0F, 1.0F - radius2);
/*     */   }
/*     */   
/*     */   public void func_180638_a(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity)
/*     */   {
/* 143 */     func_180654_a(worldIn, pos);
/* 144 */     super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */   }
/*     */   
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
/*     */   {
/* 149 */     if ((state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) && (!((Boolean)state.func_177229_b(STRUCTURE)).booleanValue())) {
/* 150 */       super.func_180653_a(worldIn, pos, state, chance, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
/*     */   {
/* 156 */     if ((player.field_71075_bZ.field_75098_d) && (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD)) {
/* 157 */       BlockPos footPos = pos.func_177977_b();
/* 158 */       if (worldIn.func_180495_p(footPos).func_177230_c() == this) {
/* 159 */         worldIn.func_175698_g(footPos);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 166 */     EnumFacing facing = EnumFacing.func_176731_b(meta & 0x3);
/* 167 */     BlockBed.EnumPartType part = (meta >> 2 & 0x1) != 0 ? BlockBed.EnumPartType.HEAD : BlockBed.EnumPartType.FOOT;
/* 168 */     boolean multiblock = (meta >> 3 & 0x1) != 0;
/*     */     
/*     */ 
/*     */ 
/* 172 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, facing).func_177226_a(BlockBed.field_176472_a, part).func_177226_a(STRUCTURE, Boolean.valueOf(multiblock));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 177 */     int bits = 0;
/* 178 */     bits |= ((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N)).func_176736_b();
/* 179 */     bits |= (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD ? 4 : 0);
/* 180 */     bits |= (((Boolean)state.func_177229_b(STRUCTURE)).booleanValue() ? 8 : 0);
/* 181 */     return bits;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/* 186 */     return new BlockState(this, new IProperty[] { BlockDirectional.field_176387_N, BlockBed.field_176472_a, STRUCTURE });
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 191 */     return 61;
/*     */   }
/*     */   
/*     */   public static class TileEntitySoulWard extends TileEntity
/*     */   {
/*     */     private IMultiBlockController controller;
/*     */     private BlockPos controllerPos;
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 201 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public Packet func_145844_m()
/*     */     {
/* 206 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 207 */       func_145841_b(nbtTag);
/* 208 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 213 */       super.onDataPacket(net, packet);
/* 214 */       func_145839_a(packet.func_148857_g());
/* 215 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 220 */       super.func_145839_a(compound);
/*     */       
/* 222 */       if (compound.func_150297_b("Controller", 4)) {
/* 223 */         this.controllerPos = BlockPos.func_177969_a(compound.func_74763_f("Controller"));
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 229 */       super.func_145841_b(compound);
/* 230 */       if (this.controller != null) {
/* 231 */         compound.func_74772_a("Controller", this.controller.getControllerPos().func_177986_g());
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 238 */       AxisAlignedBB aabb = new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(1, 2, 1));
/* 239 */       return aabb;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMultiBlockController(IMultiBlockController controller)
/*     */     {
/* 246 */       this.controller = controller;
/* 247 */       if ((this.field_145850_b != null) && (!this.field_145850_b.field_72995_K)) {
/* 248 */         this.field_145850_b.func_175689_h(func_174877_v());
/*     */       }
/*     */     }
/*     */     
/*     */     public long getTicks() {
/* 253 */       if ((this.controller == null) && (this.controllerPos != null)) {
/* 254 */         this.controller = ((IMultiBlockController)BlockUtil.getTileEntity(this.field_145850_b, this.controllerPos, IMultiBlockController.class));
/*     */       }
/* 256 */       return this.controller != null ? this.controller.getTicks() : -1L;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockSoulWard.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */