/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.entity.EntitySoul;
/*     */ import emoniph.intangible.fx.ParticleFactory;
/*     */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*     */ import emoniph.intangible.souls.BusySoulSet;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.RelayNetwork;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.TextUtil;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class BlockWellOfSoulsCore extends BlockContainer implements IBlock
/*     */ {
/*     */   BlockWellOfSoulsCore()
/*     */   {
/*  43 */     super(emoniph.intangible.materials.MaterialSoulWell.INSTANCE);
/*  44 */     func_149722_s();
/*  45 */     func_149752_b(9999.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  50 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_176225_a(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
/*  55 */     return (side == EnumFacing.DOWN) && (super.func_176225_a(worldIn, pos, side));
/*     */   }
/*     */   
/*     */   public boolean func_149662_c() {
/*  59 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d() {
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   public int func_149745_a(Random random) {
/*  67 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Item func_180665_b(World worldIn, BlockPos pos)
/*     */   {
/*  73 */     return null;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  78 */     return new TileEntityWellOfSoulsCore();
/*     */   }
/*     */   
/*     */   public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand)
/*     */   {
/*  83 */     super.func_180655_c(worldIn, pos, state, rand);
/*     */   }
/*     */   
/*     */   public void func_176213_c(World worldIn, BlockPos pos, IBlockState state)
/*     */   {
/*  88 */     TileEntityWellOfSoulsCore tile = (TileEntityWellOfSoulsCore)BlockUtil.getTileEntity(worldIn, pos, TileEntityWellOfSoulsCore.class);
/*  89 */     if (tile != null) {
/*  90 */       Get.relays().addRelay(tile, worldIn);
/*  91 */       Get.wells().addWell(tile, worldIn);
/*     */     }
/*  93 */     super.func_176213_c(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   public void func_180663_b(World worldIn, BlockPos pos, IBlockState state) {
/*     */     Object itr;
/*  98 */     if (!worldIn.field_72995_K) {
/*  99 */       TileEntityWellOfSoulsCore tile = (TileEntityWellOfSoulsCore)BlockUtil.getTileEntity(worldIn, pos, TileEntityWellOfSoulsCore.class);
/* 100 */       if (tile != null) {
/* 101 */         Get.relays().removeRelay(tile);
/* 102 */         Get.wells().removeWell(tile);
/*     */         
/* 104 */         tile.busySouls.immediateReleaseSouls(tile.freeSouls);
/* 105 */         if (!tile.freeSouls.isEmpty())
/*     */         {
/* 107 */           if (Get.wells().addSoulsToClosestWell(worldIn, pos, 128.0D, tile.freeSouls, new Vec3(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 1.5D, pos.func_177952_p() + 0.5D))) {
/* 108 */             tile.freeSouls = new SoulSet();
/*     */           }
/*     */           else
/*     */           {
/* 112 */             int maxSouls = 30;
/* 113 */             for (SoulType soulType : SoulType.values()) {
/* 114 */               int safe = EnumSoulType.fromSoulType(soulType).getMinSoulsToSave();
/* 115 */               for (int i = 0; (i < safe) && (tile.freeSouls.subtract(soulType, 1)); i++) {
/* 116 */                 releaseSoulEntities(worldIn, pos, soulType);
/* 117 */                 maxSouls--;
/*     */               }
/*     */             }
/*     */             
/* 121 */             for (itr = tile.freeSouls.iterator(new SoulType[] { SoulType.NOBLE, SoulType.DOOMED, SoulType.MALLEABLE, SoulType.IMMUTABLE, SoulType.WISE, SoulType.UNHINGED, SoulType.PREDATORY, SoulType.BENIGN }); (((Iterator)itr).hasNext()) && 
/* 122 */                   (maxSouls-- >= 0);)
/*     */             {
/*     */ 
/* 125 */               releaseSoulEntities(worldIn, pos, (SoulType)((Iterator)itr).next());
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 134 */     super.func_180663_b(worldIn, pos, state);
/*     */   }
/*     */   
/*     */   private void releaseSoulEntities(World worldIn, BlockPos pos, SoulType soulType) {
/* 138 */     EntitySoul soul = new EntitySoul(worldIn);
/* 139 */     emoniph.intangible.util.EntityUtil.trySetRandomNearbyPosition(soul, worldIn, BlockUtil.midBlockToVec3(pos), org.apache.commons.lang3.Range.between(Double.valueOf(2.0D), Double.valueOf(8.0D)), 5);
/* 140 */     soul.setEntityTypeBySoul(soulType);
/* 141 */     worldIn.func_72838_d(soul);
/* 142 */     Get.fx().GLOW.sendToAllNear(worldIn, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 1.5D, pos.func_177952_p() + 0.5D, 2.0F, 50, 6710818, 1, new Vec3(soul.field_70165_t, soul.field_70163_u, soul.field_70161_v), 0.5F, 32.0D);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/* 148 */     return EnumWorldBlockLayer.SOLID;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static class TileEntityWellOfSoulsCore
/*     */     extends TileEntity
/*     */     implements net.minecraft.util.ITickable, IMultiBlockController, emoniph.intangible.api.ISoulRelay, emoniph.intangible.api.ISoulWell
/*     */   {
/*     */     private long ticks;
/*     */     
/* 159 */     private SoulSet freeSouls = new SoulSet();
/* 160 */     private BusySoulSet busySouls = new BusySoulSet();
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 164 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public void func_145834_a(World worldIn)
/*     */     {
/* 169 */       super.func_145834_a(worldIn);
/*     */     }
/*     */     
/*     */     public void func_145829_t()
/*     */     {
/* 174 */       super.func_145829_t();
/*     */     }
/*     */     
/*     */     public void onLoad()
/*     */     {
/* 179 */       super.onLoad();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     public void func_145843_s()
/*     */     {
/* 188 */       super.func_145843_s();
/*     */     }
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/* 193 */       if (++this.ticks <= 0L) {
/* 194 */         this.ticks = 1L;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 206 */       if (!this.field_145850_b.field_72995_K) {
/* 207 */         boolean sync = this.busySouls.tickAndTryReleaseSouls(this.freeSouls);
/*     */         
/* 209 */         if (this.ticks % 20L == 0L) {
/* 210 */           java.util.List<EntitySoul> souls = this.field_145850_b.func_72872_a(EntitySoul.class, new net.minecraft.util.AxisAlignedBB(this.field_174879_c.func_177982_a(-3, -1, -3), this.field_174879_c.func_177982_a(4, 4, 4)));
/* 211 */           for (EntitySoul soul : souls) {
/* 212 */             Get.fx().GLOW.sendToAllNear(soul, 0.25F, 10, 61547, new Vec3(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 1.5D, this.field_174879_c.func_177952_p() + 0.5D), 0.1F);
/* 213 */             this.field_145850_b.func_72900_e(soul);
/* 214 */             SoulType soulType = Get.souls().getSoulForSoul(soul);
/* 215 */             if (soulType != null) {
/* 216 */               this.freeSouls.add(soulType, 1);
/* 217 */               sync = true;
/*     */             } else {
/* 219 */               Get.log().debug("Well tried to slurp a soul without a soul type! Entity removed anyway.");
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 224 */         if (sync) {
/* 225 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */         }
/*     */       }
/* 228 */       else if ((this.ticks > 100L) && (this.ticks % 3L == 0L)) {
/* 229 */         int baseColor = 49344;
/* 230 */         int variationColor = 64;
/*     */         
/* 232 */         if (this.ticks > 150L)
/*     */         {
/*     */ 
/*     */ 
/* 236 */           Intangible.PROXY.glow(this.field_145850_b, 0.5D + this.field_174879_c.func_177958_n(), 3.5D + this.field_174879_c.func_177956_o(), 0.5D + this.field_174879_c.func_177952_p()).scaleExact(10.0F + this.field_145850_b.field_73012_v.nextFloat() * 1.0F).color(baseColor, variationColor).duration(9);
/*     */         }
/*     */         
/*     */ 
/* 240 */         float speed = 0.015F;
/* 241 */         Intangible.PROXY.glow(this.field_145850_b, 1.5D + this.field_174879_c.func_177958_n(), 0.5F + this.field_174879_c.func_177956_o(), 1.5D + this.field_174879_c.func_177952_p()).motion(-speed, 0.05000000074505806D, -speed).scale(1.0F + this.field_145850_b.field_73012_v.nextFloat() * 0.2F).color(baseColor, variationColor).duration(55);
/* 242 */         Intangible.PROXY.glow(this.field_145850_b, -0.5D + this.field_174879_c.func_177958_n(), 0.5F + this.field_174879_c.func_177956_o(), 1.5D + this.field_174879_c.func_177952_p()).motion(speed, 0.05000000074505806D, -speed).scale(1.0F + this.field_145850_b.field_73012_v.nextFloat() * 0.2F).color(baseColor, variationColor).duration(55);
/* 243 */         Intangible.PROXY.glow(this.field_145850_b, 1.5D + this.field_174879_c.func_177958_n(), 0.5F + this.field_174879_c.func_177956_o(), -0.5D + this.field_174879_c.func_177952_p()).motion(-speed, 0.05000000074505806D, speed).scale(1.0F + this.field_145850_b.field_73012_v.nextFloat() * 0.2F).color(baseColor, variationColor).duration(55);
/* 244 */         Intangible.PROXY.glow(this.field_145850_b, -0.5D + this.field_174879_c.func_177958_n(), 0.5F + this.field_174879_c.func_177956_o(), -0.5D + this.field_174879_c.func_177952_p()).motion(speed, 0.05000000074505806D, speed).scale(1.0F + this.field_145850_b.field_73012_v.nextFloat() * 0.2F).color(baseColor, variationColor).duration(55);
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public String formatSouls()
/*     */     {
/* 251 */       StringBuilder sb = new StringBuilder();
/* 252 */       SoulSet all = new SoulSet(this.freeSouls);
/* 253 */       this.busySouls.addTo(all);
/* 254 */       sb.append(StatCollector.func_74838_a("tile.intangible:wellofsoulscore.report.title"));
/* 255 */       if (all.isEmpty()) {
/* 256 */         sb.append(StatCollector.func_74838_a("tile.intangible:wellofsoulscore.report.empty"));
/*     */       } else {
/* 258 */         String format = TextUtil.parse(StatCollector.func_74838_a("tile.intangible:wellofsoulscore.report.row"));
/* 259 */         for (SoulType soulType : SoulType.values()) {
/* 260 */           int total = all.quantityOf(soulType);
/* 261 */           if (total > 0) {
/* 262 */             sb.append(String.format(format, new Object[] {
/* 263 */               EnumSoulType.fromSoulType(soulType).getLocalizedName(), 
/* 264 */               Integer.valueOf(this.freeSouls.quantityOf(soulType)), 
/* 265 */               Integer.valueOf(total) }));
/*     */           }
/*     */         }
/*     */       }
/* 269 */       return TextUtil.parse(sb.toString());
/*     */     }
/*     */     
/*     */     public boolean tryUseSouls(ISoulSet souls, int cooldownTicks) {
/* 273 */       if (this.freeSouls.trySubtract(souls)) {
/* 274 */         this.busySouls.add(new emoniph.intangible.souls.BusySouls(souls, cooldownTicks));
/* 275 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 276 */         return true;
/*     */       }
/* 278 */       return false;
/*     */     }
/*     */     
/*     */     public boolean tryTakeSouls(ISoulSet souls) {
/* 282 */       if (this.freeSouls.trySubtract(souls)) {
/* 283 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/* 284 */         return true;
/*     */       }
/* 286 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */     public ISoulSet reportAvailableSoulsFrom(ISoulSet souls)
/*     */     {
/* 292 */       return this.freeSouls.intersectionWith(souls);
/*     */     }
/*     */     
/*     */     public void add(ISoulSet souls)
/*     */     {
/* 297 */       if ((souls != null) && (!souls.isEmpty())) {
/* 298 */         this.freeSouls.add(souls);
/* 299 */         this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */       }
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 305 */       super.func_145841_b(compound);
/*     */       
/* 307 */       compound.func_74772_a("ticksExisted", this.ticks);
/* 308 */       compound.func_74782_a("freeSouls", this.freeSouls.toTagCompound());
/* 309 */       compound.func_74782_a("busySouls", this.busySouls.toTagCompound());
/*     */     }
/*     */     
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 314 */       super.func_145839_a(compound);
/* 315 */       this.ticks = compound.func_74763_f("ticksExisted");
/* 316 */       if (compound.func_150297_b("freeSouls", 10)) {
/* 317 */         this.freeSouls = SoulSet.fromTagCompound(compound.func_74775_l("freeSouls"));
/*     */       }
/*     */       
/* 320 */       if (compound.func_150297_b("busySouls", 10)) {
/* 321 */         this.busySouls = BusySoulSet.fromTagCompound(compound.func_74775_l("busySouls"));
/*     */       }
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 327 */       NBTTagCompound nbtTag = new NBTTagCompound();
/* 328 */       func_145841_b(nbtTag);
/* 329 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, nbtTag);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 334 */       super.onDataPacket(net, packet);
/* 335 */       func_145839_a(packet.func_148857_g());
/* 336 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     public long getTicks()
/*     */     {
/* 341 */       return this.ticks;
/*     */     }
/*     */     
/*     */     public BlockPos getControllerPos()
/*     */     {
/* 346 */       return this.field_174879_c;
/*     */     }
/*     */     
/*     */     public boolean isRelayActive()
/*     */     {
/* 351 */       return this.ticks > 150L;
/*     */     }
/*     */     
/*     */     public BlockPos getRelayPos()
/*     */     {
/* 356 */       return this.field_174879_c;
/*     */     }
/*     */     
/*     */     public World getRelayWorld()
/*     */     {
/* 361 */       return this.field_145850_b;
/*     */     }
/*     */     
/*     */     public boolean isRelayInvalid()
/*     */     {
/* 366 */       return func_145837_r();
/*     */     }
/*     */     
/*     */     public boolean isWellActive()
/*     */     {
/* 371 */       return isRelayActive();
/*     */     }
/*     */     
/*     */     public BlockPos getWellPos()
/*     */     {
/* 376 */       return this.field_174879_c;
/*     */     }
/*     */     
/*     */     public World getWellWorld()
/*     */     {
/* 381 */       return this.field_145850_b;
/*     */     }
/*     */     
/*     */     public boolean isWellInvalid()
/*     */     {
/* 386 */       return func_145837_r();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockWellOfSoulsCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */