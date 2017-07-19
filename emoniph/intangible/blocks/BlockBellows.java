/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IBellowsClient;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityFurnace;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.ITickable;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockBellows extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   public BlockBellows()
/*     */   {
/*  37 */     super(Material.field_151573_f);
/*  38 */     func_149711_c(3.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  43 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/*  48 */     EnumFacing enumfacing = EnumFacing.func_176731_b(meta & 0x3);
/*  49 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, enumfacing);
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/*  54 */     int face = ((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N)).func_176736_b();
/*  55 */     return face;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  60 */     return new TileEntityBellows();
/*     */   }
/*     */   
/*     */   public IBlockState func_180642_a(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
/*  64 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, placer.func_174811_aO());
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/*  69 */     return new BlockState(this, new IProperty[] { BlockDirectional.field_176387_N });
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  74 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149740_M()
/*     */   {
/*  94 */     return true;
/*     */   }
/*     */   
/*     */   public int func_180641_l(World worldIn, BlockPos pos)
/*     */   {
/*  99 */     TileEntityBellows tile = (TileEntityBellows)BlockUtil.getTileEntity(worldIn, pos, TileEntityBellows.class);
/* 100 */     if ((tile != null) && (tile.pulse > 0)) {
/* 101 */       return 1;
/*     */     }
/* 103 */     return 0;
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 108 */     TileEntityBellows tile = (TileEntityBellows)BlockUtil.getTileEntity(worldIn, pos, TileEntityBellows.class);
/* 109 */     if ((tile != null) && 
/* 110 */       (worldIn.func_175640_z(pos))) {
/* 111 */       tile.tryPulse(state);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/* 120 */     return EnumWorldBlockLayer.CUTOUT;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 126 */     TileEntityBellows tile = (TileEntityBellows)BlockUtil.getTileEntity(worldIn, pos, TileEntityBellows.class);
/* 127 */     if (tile != null) {
/* 128 */       tile.tryPulse(state);
/* 129 */       return true;
/*     */     }
/* 131 */     return false;
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 136 */     return 54;
/*     */   }
/*     */   
/*     */   public static class TileEntityBellows extends TileEntity implements ITickable
/*     */   {
/* 141 */     private int MAX_DELAY = 15;
/* 142 */     private int REQUIRED_PROGRESS = 100;
/*     */     private int lastPulse;
/*     */     private int progress;
/*     */     int pulse;
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 149 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 150 */       if (state.func_177230_c() != Get.blocks().BELLOWS) {
/* 151 */         return;
/*     */       }
/*     */       
/* 154 */       if (this.pulse > 0) {
/* 155 */         this.pulse -= 1;
/*     */       }
/*     */       
/* 158 */       if (this.lastPulse >= 0) {
/* 159 */         if (this.progress > this.lastPulse + this.MAX_DELAY * 2) {
/* 160 */           this.lastPulse = -1;
/* 161 */           if (!BlockUtil.isSoundDampned(this.field_145850_b, this.field_174879_c)) {
/* 162 */             Sound.MOD_RANDOM_BELLOW_IN.playToAllNear(this);
/*     */           }
/* 164 */           this.progress = Math.max(this.progress - 5, 0);
/*     */         } else {
/* 166 */           this.progress += 1;
/* 167 */           if (this.progress == this.REQUIRED_PROGRESS) {
/* 168 */             if (!BlockUtil.isSoundDampned(this.field_145850_b, this.field_174879_c)) {
/* 169 */               Sound.MOD_RANDOM_BELLOW_IN.playToAllNear(this);
/*     */             }
/* 171 */             this.lastPulse = -1;
/* 172 */             finish();
/*     */           }
/*     */         }
/* 175 */       } else if (this.progress > 0)
/* 176 */         this.progress = Math.max(this.progress - 5, 0);
/*     */       double dx;
/*     */       double dy;
/* 179 */       double dz; if ((!this.field_145850_b.field_72995_K) && (this.lastPulse >= 0) && 
/* 180 */         (state.func_177230_c() == Get.blocks().BELLOWS)) {
/* 181 */         EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 182 */         BlockPos nextPos = this.field_174879_c.func_177972_a(facing);
/* 183 */         if (this.field_145850_b.func_180495_p(nextPos).func_177230_c().func_149688_o().func_76222_j()) {
/* 184 */           AxisAlignedBB aabb = new AxisAlignedBB(this.field_174879_c.func_177967_a(facing, 2).func_177982_a(0, 0, 0), this.field_174879_c.func_177967_a(facing, 6).func_177982_a(1, 1, 1));
/* 185 */           java.util.List<EntityItem> items = this.field_145850_b.func_72872_a(EntityItem.class, aabb);
/* 186 */           dx = nextPos.func_177958_n() - this.field_174879_c.func_177958_n();
/* 187 */           dy = 0.05D;
/* 188 */           dz = nextPos.func_177952_p() - this.field_174879_c.func_177952_p();
/* 189 */           for (EntityItem entity : items) {
/* 190 */             if (entity.func_70089_S()) {
/* 191 */               entity.field_70181_x = dy;
/* 192 */               entity.field_70159_w = (dx * 0.08D);
/* 193 */               entity.field_70179_y = (dz * 0.08D);
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     private void finish()
/*     */     {
/* 204 */       if (this.field_145850_b != null) {
/* 205 */         IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 206 */         if (state.func_177230_c() == Get.blocks().BELLOWS) {
/* 207 */           EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 208 */           BlockPos otherPos = this.field_174879_c.func_177972_a(facing);
/* 209 */           IBlockState otherState = this.field_145850_b.func_180495_p(otherPos);
/* 210 */           if (otherState != null) {
/* 211 */             Block otherBlock = otherState.func_177230_c();
/* 212 */             if ((otherBlock != null) && 
/* 213 */               ((otherBlock instanceof IBellowsClient))) {
/* 214 */               IBellowsClient client = (IBellowsClient)otherBlock;
/* 215 */               client.bellowsComplete(this.field_145850_b, otherPos, otherState, facing.func_176734_d());
/*     */             }
/*     */           }
/*     */           
/*     */ 
/* 220 */           this.pulse = 2;
/* 221 */           this.field_145850_b.func_175685_c(this.field_174879_c, state.func_177230_c());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void tryPulse(IBlockState state) {
/* 227 */       if ((this.lastPulse == -1) && (this.progress == 0)) {
/* 228 */         this.lastPulse = 0;
/* 229 */         if (!BlockUtil.isSoundDampned(this.field_145850_b, this.field_174879_c)) {
/* 230 */           Sound.MOD_RANDOM_BELLOW_OUT.playToAllNear(this, 1.0F, 1.0F);
/*     */         }
/* 232 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 233 */         sendBellowTick(state);
/* 234 */       } else if ((this.lastPulse >= 0) && (this.progress > this.lastPulse + this.MAX_DELAY)) {
/* 235 */         this.lastPulse = this.progress;
/* 236 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 237 */         sendBellowTick(state);
/*     */       }
/*     */     }
/*     */     
/*     */     private void sendBellowTick(IBlockState state) {
/* 242 */       EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/* 243 */       BlockPos otherPos = this.field_174879_c.func_177972_a(facing);
/* 244 */       IBlockState otherState = this.field_145850_b.func_180495_p(otherPos);
/* 245 */       Block otherBlock = otherState.func_177230_c();
/* 246 */       if ((otherBlock instanceof IBellowsClient)) {
/* 247 */         IBellowsClient client = (IBellowsClient)otherBlock;
/* 248 */         client.bellowsTick(this.field_145850_b, otherPos, otherState, facing.func_176734_d());
/* 249 */       } else if (otherBlock == net.minecraft.init.Blocks.field_150470_am) {
/* 250 */         TileEntityFurnace furnace = (TileEntityFurnace)BlockUtil.getTileEntity(this.field_145850_b, otherPos, TileEntityFurnace.class);
/* 251 */         if (furnace != null) {
/* 252 */           int initialCook = furnace.field_174906_k;
/* 253 */           furnace.field_174906_k = Math.min(furnace.field_174906_k + 5, furnace.field_174905_l - 1);
/* 254 */           if (initialCook < furnace.field_174906_k) {
/* 255 */             furnace.field_145956_a = Math.max(furnace.field_145956_a - 2, 1);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public float getProgress() {
/* 263 */       return this.progress / this.REQUIRED_PROGRESS;
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 268 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 273 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 274 */       func_145841_b(nbtTag);
/* 275 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 280 */       super.onDataPacket(net, packet);
/* 281 */       func_145839_a(packet.func_148857_g());
/* 282 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 287 */       super.func_145839_a(compound);
/* 288 */       this.lastPulse = compound.func_74762_e("lastPulse");
/* 289 */       this.progress = compound.func_74762_e("progress");
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 294 */       super.func_145841_b(compound);
/* 295 */       compound.func_74768_a("lastPulse", this.lastPulse);
/* 296 */       compound.func_74768_a("progress", this.progress);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */