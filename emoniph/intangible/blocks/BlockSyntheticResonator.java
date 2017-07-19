/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.items.ICreativeSort;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockSyntheticResonator extends BlockContainer implements IBlock, emoniph.intangible.api.golem.IGolemStartable, ICreativeSort
/*     */ {
/*     */   BlockSyntheticResonator()
/*     */   {
/*  28 */     super(Material.field_151576_e);
/*  29 */     func_149711_c(3.0F);
/*  30 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 0.8F, 1.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  35 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/*  41 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */ 
/*     */   public TileEntity func_149915_a(World world, int meta)
/*     */   {
/*  47 */     return new TileEntitySyntheticResonator();
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  52 */     return 3;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  57 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  62 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   public void startWithGolem(World world, BlockPos pos, EntityPlayer player)
/*     */   {
/*  72 */     if (!world.field_72995_K) {
/*  73 */       TileEntitySyntheticResonator tile = (TileEntitySyntheticResonator)BlockUtil.getTileEntity(world, pos, TileEntitySyntheticResonator.class);
/*  74 */       if (tile != null) {
/*  75 */         if (tile.isActivated()) {
/*  76 */           tile.activated = false;
/*     */         } else {
/*  78 */           tile.activated = true;
/*  79 */           Sound.MOD_RANDOM_METALCREEK.playToAllNear(tile, 0.5F, 1.0F);
/*     */         }
/*  81 */         world.func_175689_h(pos);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  88 */     return 69;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class TileEntitySyntheticResonator
/*     */     extends TileEntity
/*     */   {
/*     */     private boolean activated;
/*     */     
/*     */ 
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 101 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 106 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 107 */       func_145841_b(nbtTag);
/* 108 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 113 */       super.onDataPacket(net, packet);
/* 114 */       NBTTagCompound compound = packet.func_148857_g();
/* 115 */       func_145839_a(compound);
/* 116 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 121 */       super.func_145839_a(compound);
/* 122 */       this.activated = compound.func_74767_n("activated");
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 127 */       super.func_145841_b(compound);
/* 128 */       compound.func_74757_a("activated", this.activated);
/*     */     }
/*     */     
/*     */     public boolean isActivated() {
/* 132 */       return this.activated;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockSyntheticResonator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */