/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import emoniph.intangible.entity.EntityProxy;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockBed;
/*     */ import net.minecraft.block.BlockBed.EnumPartType;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.BlockDirectional;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.AbstractClientPlayer;
/*     */ import net.minecraft.client.network.NetworkPlayerInfo;
/*     */ import net.minecraft.client.resources.DefaultPlayerSkin;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockShell extends BlockContainer implements IBlock
/*     */ {
/*     */   BlockShell()
/*     */   {
/*  45 */     super(Material.field_151576_e);
/*  46 */     func_149722_s();
/*  47 */     func_149752_b(9999.0F);
/*  48 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT));
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  53 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_180654_a(IBlockAccess worldIn, BlockPos pos)
/*     */   {
/*  59 */     IBlockState state = worldIn.func_180495_p(pos);
/*  60 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*  61 */     float h = state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT ? 1.0F : 0.875F;
/*  62 */     float w = 0.5F;
/*  63 */     float d = 0.5F;
/*  64 */     float hw = w * 0.5F;
/*  65 */     float hd = d * 0.5F;
/*  66 */     switch (facing) {
/*     */     case NORTH: 
/*     */     case SOUTH: 
/*  69 */       func_149676_a(0.5F - hw, 0.0F, 0.5F - hd, 0.5F + hw, h, 0.5F + hd);
/*  70 */       break;
/*     */     case EAST: 
/*     */     case WEST: 
/*  73 */       func_149676_a(0.5F - hd, 0.0F, 0.5F - hw, 0.5F + hd, h, 0.5F + hw);
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_180638_a(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity)
/*     */   {
/*  82 */     func_180654_a(worldIn, pos);
/*  83 */     super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  88 */     IBlockState state = func_176203_a(meta);
/*  89 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) {
/*  90 */       return new TileEntityShell();
/*     */     }
/*  92 */     return new TileEntityVoid();
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_149645_b()
/*     */   {
/*  98 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/* 108 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 119 */     EnumFacing facing = (EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N);
/*     */     
/* 121 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 122 */       if (worldIn.func_180495_p(pos.func_177977_b()).func_177230_c() != this) {
/* 123 */         worldIn.func_175698_g(pos);
/*     */       }
/* 125 */     } else if (worldIn.func_180495_p(pos.func_177984_a()).func_177230_c() == this) {}
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Item func_180665_b(World worldIn, BlockPos pos)
/*     */   {
/* 136 */     return null;
/*     */   }
/*     */   
/*     */   public Item func_180660_a(IBlockState state, Random rand, int fortune)
/*     */   {
/* 141 */     return null;
/*     */   }
/*     */   
/*     */   public void func_180653_a(World worldIn, BlockPos pos, IBlockState state, float chance, int fortune)
/*     */   {
/* 146 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.FOOT) {
/* 147 */       super.func_180653_a(worldIn, pos, state, chance, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176208_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
/*     */   {
/* 153 */     if ((player.field_71075_bZ.field_75098_d) && (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD)) {
/* 154 */       BlockPos footPos = pos.func_177977_b();
/* 155 */       if (worldIn.func_180495_p(footPos).func_177230_c() == this) {
/* 156 */         worldIn.func_175698_g(footPos);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 163 */     EnumFacing facing = EnumFacing.func_176731_b(meta & 0x3);
/* 164 */     BlockBed.EnumPartType part = (meta >> 2 & 0x1) != 0 ? BlockBed.EnumPartType.HEAD : BlockBed.EnumPartType.FOOT;
/*     */     
/*     */ 
/* 167 */     return func_176223_P().func_177226_a(BlockDirectional.field_176387_N, facing).func_177226_a(BlockBed.field_176472_a, part);
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 172 */     int bits = 0;
/* 173 */     bits |= ((EnumFacing)state.func_177229_b(BlockDirectional.field_176387_N)).func_176736_b();
/* 174 */     bits |= (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD ? 4 : 0);
/* 175 */     return bits;
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/* 180 */     return new BlockState(this, new IProperty[] { BlockDirectional.field_176387_N, BlockBed.field_176472_a });
/*     */   }
/*     */   
/*     */   public boolean place(World world, BlockPos pos, EntityPlayer player)
/*     */   {
/* 185 */     int i = net.minecraft.util.MathHelper.func_76128_c(player.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3;
/* 186 */     EnumFacing facing = EnumFacing.func_176731_b(i);
/* 187 */     return place(world, pos, player, facing.func_176734_d());
/*     */   }
/*     */   
/*     */   public boolean place(World world, BlockPos pos, EntityPlayer player, EnumFacing facing) {
/* 191 */     if (!world.field_72995_K)
/*     */     {
/*     */ 
/* 194 */       if ((!world.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) || 
/* 195 */         (!world.func_180495_p(pos.func_177984_a()).func_177230_c().func_149688_o().func_76222_j())) {
/* 196 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 200 */       world.func_175698_g(pos);
/* 201 */       world.func_175698_g(pos.func_177984_a());
/*     */       
/*     */ 
/*     */ 
/* 205 */       IBlockState stateFoot = func_176223_P().func_177226_a(BlockBed.field_176387_N, facing).func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.FOOT);
/*     */       
/* 207 */       if (world.func_180501_a(pos, stateFoot, 3)) {
/* 208 */         IBlockState stateHead = stateFoot.func_177226_a(BlockBed.field_176472_a, BlockBed.EnumPartType.HEAD);
/* 209 */         world.func_180501_a(pos.func_177984_a(), stateHead, 3);
/*     */         
/* 211 */         TileEntityShell tile = (TileEntityShell)BlockUtil.getTileEntity(world, pos, TileEntityShell.class);
/* 212 */         if (tile != null) {
/* 213 */           tile.setOwner(player);
/*     */         }
/*     */       }
/*     */     }
/* 217 */     return true;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/* 222 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*     */   {
/* 227 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 228 */       pos = pos.func_177977_b();
/*     */     }
/*     */     
/* 231 */     TileEntityShell tile = (TileEntityShell)BlockUtil.getTileEntity(worldIn, pos, TileEntityShell.class);
/* 232 */     if ((tile != null) && (tile.isOwner(playerIn))) {
/* 233 */       PlayerEx playerEx = PlayerEx.get(playerIn);
/* 234 */       playerEx.enterPlayerShell(worldIn, pos, state);
/* 235 */       return true;
/*     */     }
/*     */     
/* 238 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isOwner(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 242 */     if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 243 */       pos = pos.func_177977_b();
/*     */     }
/*     */     
/* 246 */     TileEntityShell tile = (TileEntityShell)BlockUtil.getTileEntity(world, pos, TileEntityShell.class);
/* 247 */     return (tile != null) && (tile.isOwner(player));
/*     */   }
/*     */   
/*     */   public void removeBody(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
/* 251 */     if (!world.field_72995_K) {
/* 252 */       if (state.func_177229_b(BlockBed.field_176472_a) == BlockBed.EnumPartType.HEAD) {
/* 253 */         pos = pos.func_177977_b();
/*     */       }
/*     */       
/* 256 */       TileEntityShell tile = (TileEntityShell)BlockUtil.getTileEntity(world, pos, TileEntityShell.class);
/* 257 */       if ((tile != null) && (tile.isOwner(player))) {
/* 258 */         PlayerEx playerEx = PlayerEx.get(player);
/* 259 */         playerEx.removePlayerShell(world, pos);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TileEntityShell
/*     */     extends TileEntity implements emoniph.intangible.api.ISoulShell
/*     */   {
/*     */     private UUID ownerUUID;
/*     */     private String ownerName;
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 272 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 277 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 278 */       func_145841_b(nbtTag);
/* 279 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 284 */       super.onDataPacket(net, packet);
/* 285 */       func_145839_a(packet.func_148857_g());
/* 286 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 291 */       super.func_145839_a(compound);
/* 292 */       if ((compound.func_74764_b("ownerName")) && (compound.func_74764_b("ownerIDL")) && (compound.func_74764_b("ownerIDM"))) {
/* 293 */         this.ownerName = compound.func_74779_i("ownerName");
/* 294 */         this.ownerUUID = new UUID(compound.func_74763_f("ownerIDM"), compound.func_74763_f("ownerIDL"));
/*     */       } else {
/* 296 */         this.ownerName = null;
/* 297 */         this.ownerUUID = null;
/*     */       }
/*     */       
/* 300 */       NBTTagList itemList = compound.func_150295_c("ModItems", 10);
/* 301 */       this.gear = new ItemStack[5];
/* 302 */       for (int i = 0; i < itemList.func_74745_c(); i++) {
/* 303 */         NBTTagCompound itemCompound = itemList.func_150305_b(i);
/* 304 */         int j = itemCompound.func_74771_c("Slot") & 0xFF;
/*     */         
/* 306 */         if ((j >= 0) && (j < this.gear.length)) {
/* 307 */           this.gear[j] = ItemStack.func_77949_a(itemCompound);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 315 */       super.func_145841_b(compound);
/* 316 */       if ((this.ownerName != null) && (this.ownerUUID != null)) {
/* 317 */         compound.func_74778_a("ownerName", this.ownerName);
/* 318 */         compound.func_74772_a("ownerIDM", this.ownerUUID.getMostSignificantBits());
/* 319 */         compound.func_74772_a("ownerIDL", this.ownerUUID.getLeastSignificantBits());
/*     */         
/* 321 */         NBTTagList itemList = new NBTTagList();
/*     */         
/* 323 */         for (int i = 0; i < this.gear.length; i++) {
/* 324 */           if (this.gear[i] != null) {
/* 325 */             NBTTagCompound itemCompound = new NBTTagCompound();
/* 326 */             itemCompound.func_74774_a("Slot", (byte)i);
/* 327 */             this.gear[i].func_77955_b(itemCompound);
/* 328 */             itemList.func_74742_a(itemCompound);
/*     */           }
/*     */         }
/*     */         
/* 332 */         compound.func_74782_a("ModItems", itemList);
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 339 */       return new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(1, 2, 1));
/*     */     }
/*     */     
/*     */     public void setOwner(EntityPlayer player) {
/* 343 */       if ((player != null) && (player.func_146103_bH() != null) && (!player.field_70170_p.field_72995_K)) {
/* 344 */         this.ownerUUID = player.func_146103_bH().getId();
/* 345 */         this.ownerName = player.func_146103_bH().getName();
/*     */         
/* 347 */         this.gear = new ItemStack[5];
/* 348 */         for (int i = 0; i < this.gear.length; i++) {
/* 349 */           this.gear[i] = player.func_71124_b(i);
/*     */         }
/* 351 */         player.field_70170_p.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 357 */     private ItemStack[] gear = new ItemStack[5];
/*     */     
/*     */     public static final String DefaultSlimCharModel = "slim";
/*     */     private String skinType;
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public String getSkinType()
/*     */     {
/* 365 */       if (this.skinType == null) {
/* 366 */         if (this.ownerUUID == null) {
/* 367 */           this.skinType = "slim";
/*     */         } else {
/* 369 */           NetworkPlayerInfo info = Minecraft.func_71410_x().func_147114_u().func_175102_a(this.ownerUUID);
/* 370 */           if (info != null) {
/* 371 */             this.skinType = info.func_178851_f();
/*     */           } else {
/* 373 */             return DefaultPlayerSkin.func_177332_b(this.ownerUUID);
/*     */           }
/*     */         }
/*     */       }
/* 377 */       return this.skinType;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     private net.minecraft.client.renderer.ThreadDownloadImageData downloadImageSkin;
/*     */     @SideOnly(Side.CLIENT)
/*     */     private ResourceLocation locationSkin;
/*     */     @SideOnly(Side.CLIENT)
/*     */     private EntityProxy proxy;
/*     */     @SideOnly(Side.CLIENT)
/*     */     public ResourceLocation getLocationSkin() {
/* 388 */       if (this.locationSkin == null) {
/* 389 */         setupCustomSkin();
/*     */       }
/* 391 */       if (this.locationSkin != null) {
/* 392 */         return this.locationSkin;
/*     */       }
/* 394 */       return null;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     private void setupCustomSkin()
/*     */     {
/* 400 */       if ((this.ownerName != null) && (!this.ownerName.isEmpty())) {
/* 401 */         this.locationSkin = AbstractClientPlayer.func_110311_f(this.ownerName);
/* 402 */         this.downloadImageSkin = AbstractClientPlayer.func_110304_a(this.locationSkin, this.ownerName);
/*     */       } else {
/* 404 */         this.locationSkin = null;
/* 405 */         this.downloadImageSkin = null;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     @SideOnly(Side.CLIENT)
/*     */     public EntityProxy getProxyEntity()
/*     */     {
/* 414 */       if ((this.proxy == null) || (this.proxy.func_130014_f_() != this.field_145850_b)) {
/* 415 */         this.proxy = new EntityProxy(this.field_145850_b);
/* 416 */         for (int i = 0; i < this.gear.length; i++) {
/* 417 */           this.proxy.func_70062_b(i, this.gear[i]);
/*     */         }
/*     */       }
/*     */       
/*     */ 
/* 422 */       return this.proxy;
/*     */     }
/*     */     
/*     */     public boolean isOwner(EntityPlayer player) {
/* 426 */       return (player != null) && (player.func_146103_bH().getId().equals(this.ownerUUID));
/*     */     }
/*     */     
/*     */     public boolean isActive()
/*     */     {
/* 431 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockShell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */