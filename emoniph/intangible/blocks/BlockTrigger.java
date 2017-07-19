/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.api.ITriggerClient;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.Random;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.properties.IProperty;
/*     */ import net.minecraft.block.properties.PropertyBool;
/*     */ import net.minecraft.block.state.BlockState;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockTrigger extends BlockContainer implements IBlock
/*     */ {
/*  30 */   public static final PropertyBool POWERED = PropertyBool.func_177716_a("powered");
/*     */   
/*     */   protected BlockTrigger(boolean on) {
/*  33 */     super(Material.field_151578_c);
/*  34 */     func_149722_s();
/*  35 */     func_149752_b(99999.0F);
/*  36 */     func_180632_j(this.field_176227_L.func_177621_b().func_177226_a(POWERED, Boolean.valueOf(false)));
/*  37 */     func_149675_a(true);
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  42 */     return 3;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_180640_a(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  47 */     return super.func_180640_a(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
/*     */   {
/*  52 */     return false;
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
/*     */   public boolean func_149744_f()
/*     */   {
/*  67 */     return true;
/*     */   }
/*     */   
/*     */   public void func_180645_a(World worldIn, BlockPos pos, IBlockState state, Random random)
/*     */   {
/*  72 */     super.func_180645_a(worldIn, pos, state, random);
/*     */   }
/*     */   
/*     */   public void func_180650_b(World worldIn, BlockPos pos, IBlockState state, Random rand)
/*     */   {
/*  77 */     if ((!worldIn.field_72995_K) && 
/*  78 */       (state.func_177229_b(POWERED) == Boolean.TRUE)) {
/*  79 */       if (!worldIn.func_175709_b(pos.func_177977_b(), EnumFacing.DOWN)) {
/*  80 */         worldIn.func_180501_a(pos, state.func_177226_a(POWERED, Boolean.valueOf(false)), 3);
/*     */       } else {
/*  82 */         worldIn.func_175684_a(pos, worldIn.func_180495_p(pos).func_177230_c(), 20);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  90 */     return !(entity instanceof EntityLiving);
/*     */   }
/*     */   
/*     */   protected BlockState func_180661_e()
/*     */   {
/*  95 */     return new BlockState(this, new IProperty[] { POWERED });
/*     */   }
/*     */   
/*     */   public IBlockState func_176203_a(int meta)
/*     */   {
/* 100 */     return func_176223_P().func_177226_a(POWERED, Boolean.valueOf((meta & 0x1) == 1));
/*     */   }
/*     */   
/*     */   public int func_176201_c(IBlockState state)
/*     */   {
/* 105 */     return ((Boolean)state.func_177229_b(POWERED)).booleanValue() ? 1 : 0;
/*     */   }
/*     */   
/*     */   public int func_176211_b(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/* 110 */     return super.func_180656_a(worldIn, pos, state, side);
/*     */   }
/*     */   
/*     */   public int func_180656_a(IBlockAccess worldIn, BlockPos pos, IBlockState state, EnumFacing side)
/*     */   {
/* 115 */     return ((Boolean)state.func_177229_b(POWERED)).booleanValue() ? 15 : 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state) {}
/*     */   
/*     */ 
/*     */   public void func_180655_c(World world, BlockPos pos, IBlockState state, Random rand)
/*     */   {
/* 125 */     float radius = 0.25F;
/* 126 */     double x = pos.func_177958_n() + 0.5D;
/* 127 */     double y = pos.func_177956_o() + 0.5D;
/* 128 */     double z = pos.func_177952_p() + 0.5D;
/*     */     
/* 130 */     boolean powered = state.func_177229_b(POWERED) == Boolean.TRUE;
/* 131 */     for (int i = 0; i < 3; i++) {
/* 132 */       double x2 = x - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/* 133 */       double y2 = y - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/* 134 */       double z2 = z - radius + 2.0F * world.field_73012_v.nextFloat() * radius;
/*     */       
/* 136 */       Get.glow(world, x2, y2, z2)
/* 137 */         .color(powered ? 12582912 : 12632064, 64);
/*     */     }
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/* 143 */     return new TileEntityTrigger();
/*     */   }
/*     */   
/*     */   public boolean isOwner(World world, BlockPos pos, EntityPlayer player) {
/* 147 */     TileEntityTrigger tile = (TileEntityTrigger)BlockUtil.getTileEntity(world, pos, TileEntityTrigger.class);
/* 148 */     return (tile != null) && (tile.owner != null) && (tile.owner.equals(player.func_146103_bH().getId()));
/*     */   }
/*     */   
/*     */   public void setOwner(World world, BlockPos pos, EntityPlayer player) {
/* 152 */     TileEntityTrigger tile = (TileEntityTrigger)BlockUtil.getTileEntity(world, pos, TileEntityTrigger.class);
/* 153 */     if (tile != null) {
/* 154 */       tile.owner = player.func_146103_bH().getId();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_176204_a(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
/*     */   {
/* 160 */     boolean isOn = state.func_177229_b(POWERED) == Boolean.TRUE;
/* 161 */     if ((isOn) && (!worldIn.func_175709_b(pos.func_177977_b(), EnumFacing.UP))) {}
/*     */   }
/*     */   
/*     */   public static class TileEntityTrigger
/*     */     extends TileEntity
/*     */   {
/*     */     private UUID owner;
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 171 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public void triggerBlock(EntityPlayer player, World targetWorld, BlockPos targetPos) {
/* 175 */       if (!this.field_145850_b.field_72995_K) {
/* 176 */         IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/* 177 */         if (state.func_177229_b(BlockTrigger.POWERED) == Boolean.FALSE) {
/* 178 */           this.field_145850_b.func_175656_a(this.field_174879_c, state.func_177226_a(BlockTrigger.POWERED, Boolean.valueOf(true)));
/* 179 */           this.field_145850_b.func_175684_a(this.field_174879_c, Get.blocks().TRIGGER, 20);
/* 180 */           for (EnumFacing facing : EnumFacing.field_82609_l) {
/* 181 */             BlockPos checkPos = this.field_174879_c.func_177972_a(facing);
/* 182 */             IBlockState checkState = this.field_145850_b.func_180495_p(checkPos);
/* 183 */             if ((checkState.func_177230_c() instanceof ITriggerClient)) {
/* 184 */               ITriggerClient client = (ITriggerClient)checkState.func_177230_c();
/* 185 */               client.onTriggeredBySpell(this.field_145850_b, checkPos, checkState, targetWorld, targetPos, player);
/*     */             }
/*     */           }
/*     */           
/* 189 */           this.field_145850_b.func_175685_c(this.field_174879_c, state.func_177230_c());
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 196 */       super.func_145841_b(compound);
/* 197 */       if (this.owner != null) {
/* 198 */         compound.func_74778_a("owner", this.owner.toString());
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 204 */       super.func_145839_a(compound);
/* 205 */       if (compound.func_150297_b("owner", 8)) {
/* 206 */         this.owner = UUID.fromString(compound.func_74779_i("owner"));
/*     */       } else {
/* 208 */         this.owner = null;
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockTrigger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */