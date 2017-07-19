/*     */ package emoniph.intangible.blocks;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.recipes.CreatureRecipe;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.souls.WellNetwork;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.BlockContainer;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumWorldBlockLayer;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class BlockReconstructor extends BlockContainer implements IBlock, emoniph.intangible.items.ICreativeSort
/*     */ {
/*     */   protected BlockReconstructor()
/*     */   {
/*  37 */     super(net.minecraft.block.material.Material.field_151576_e);
/*  38 */     func_149711_c(5.0F);
/*  39 */     func_149672_a(field_149769_e);
/*  40 */     func_149676_a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public boolean canEntityDestroy(IBlockAccess world, BlockPos pos, Entity entity)
/*     */   {
/*  45 */     return !(entity instanceof net.minecraft.entity.EntityLiving);
/*     */   }
/*     */   
/*     */   public int func_149645_b()
/*     */   {
/*  50 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean func_149662_c()
/*     */   {
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_149686_d()
/*     */   {
/*  60 */     return false;
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public EnumWorldBlockLayer func_180664_k()
/*     */   {
/*  66 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*     */   }
/*     */   
/*     */   public TileEntity func_149915_a(World worldIn, int meta)
/*     */   {
/*  71 */     return new TileEntityReconstructor();
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  76 */     return 60;
/*     */   }
/*     */   
/*     */ 
/*     */   public static class TileEntityReconstructor
/*     */     extends TileEntity
/*     */     implements net.minecraft.util.ITickable, IMultiBlockController
/*     */   {
/*     */     private long counter;
/*     */     
/*     */     private int progress;
/*     */     
/*     */     private long start;
/*     */     
/*     */     public void func_73660_a()
/*     */     {
/*  92 */       IBlockState state = this.field_145850_b.func_180495_p(this.field_174879_c);
/*  93 */       if (state.func_177230_c() != Get.blocks().RECONSTRUCTOR) {
/*  94 */         return;
/*     */       }
/*     */       
/*  97 */       this.counter += 1L;
/*     */       
/*  99 */       if (this.counter % 20L == 0L) {
/* 100 */         if (this.field_145850_b.func_175640_z(this.field_174879_c)) {
/* 101 */           if (this.start == -1L) {
/* 102 */             this.start = this.counter;
/* 103 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/* 105 */           if (this.field_145850_b.func_175623_d(this.field_174879_c.func_177984_a())) {
/* 106 */             updateReconstruction();
/* 107 */           } else if (this.field_145850_b.func_180495_p(this.field_174879_c.func_177984_a()).func_177230_c() == Get.blocks().BONE_CAGE) {
/* 108 */             updateResouler();
/*     */           } else {
/* 110 */             this.progress = 0;
/*     */           }
/*     */         } else {
/* 113 */           this.progress = 0;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     private void updateResouler() {
/* 119 */       if (!this.field_145850_b.field_72995_K) {
/* 120 */         boolean created = false;
/* 121 */         for (EnumFacing face : EnumFacing.field_176754_o) {
/* 122 */           BlockPos m = this.field_174879_c.func_177967_a(face, 2);
/* 123 */           BlockPos l = m.func_177972_a(face.func_176746_e());
/* 124 */           BlockPos r = m.func_177972_a(face.func_176735_f());
/* 125 */           IBlockState benign = Get.blocks().SOUL_CAGE.func_176223_P().func_177226_a(BlockSoulCage.VARIANT, emoniph.intangible.souls.EnumSoulType.BENIGN);
/* 126 */           for (BlockPos p : new BlockPos[] { l, r }) {
/* 127 */             if (this.field_145850_b.func_180495_p(p) == benign) {
/* 128 */               BlockPos up = p.func_177984_a();
/* 129 */               if (this.field_145850_b.func_180495_p(up).func_177230_c() != Get.blocks().SOUL_WARD) {
/* 130 */                 emoniph.intangible.items.ItemSoulWard.place(this.field_145850_b, up, face, true);
/* 131 */                 BlockSoulWard.TileEntitySoulWard tile = (BlockSoulWard.TileEntitySoulWard)BlockUtil.getTileEntity(this.field_145850_b, up, BlockSoulWard.TileEntitySoulWard.class);
/* 132 */                 if (tile != null) {
/* 133 */                   tile.setMultiBlockController(this);
/* 134 */                   created = true;
/*     */                 }
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/* 140 */         if (created) {
/* 141 */           this.start = -1L;
/* 142 */           this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */         }
/*     */       }
/*     */       
/* 146 */       this.progress += 1;
/* 147 */       if ((this.field_145850_b.field_72995_K) && 
/* 148 */         (this.progress >= 5) && (this.progress < 20)) {
/* 149 */         for (int i = 0; i < 20 + this.progress * 2; i++)
/*     */         {
/*     */ 
/*     */ 
/* 153 */           Intangible.PROXY.glow(this.field_145850_b, this.field_174879_c.func_177984_a(), 0.25D + this.progress * 0.01D).motion(0.0D, 0.1D, 0.0D).duration(15).color(8913049, 64);
/*     */         }
/*     */         
/* 156 */         Sound.MOD_RANDOM_MACHINE.playToAllNear(this, 0.5F, 1.0F);
/*     */       }
/*     */       
/* 159 */       double MAX_WELL_RANGE = 16.0D;
/* 160 */       BlockPos cagePos = this.field_174879_c.func_177984_a();
/* 161 */       net.minecraft.util.Vec3 cagePosVec = BlockUtil.midBlockToVec3(cagePos);
/* 162 */       BlockBoneCage.TileEntityBoneCage cage = (BlockBoneCage.TileEntityBoneCage)BlockUtil.getTileEntity(this.field_145850_b, cagePos, BlockBoneCage.TileEntityBoneCage.class);
/* 163 */       Get.recipes();CreatureRecipe recipe = cage != null ? emoniph.intangible.recipes.ModRecipes.creatures.getRecipeForInput(cage.getTrappedEntity()) : null;
/* 164 */       if (recipe != null) {
/* 165 */         if (this.progress == 5) {
/* 166 */           if ((!this.field_145850_b.field_72995_K) && (!Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet()
/* 167 */             .add(SoulType.BENIGN, 1), 100, cagePosVec))) {
/* 168 */             this.progress = 0;
/* 169 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/* 171 */         } else if (this.progress == 10) {
/* 172 */           if ((!this.field_145850_b.field_72995_K) && (!Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet()
/* 173 */             .add(SoulType.UNHINGED, 1), 100, cagePosVec))) {
/* 174 */             this.progress = 0;
/* 175 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/* 177 */         } else if (this.progress == 15) {
/* 178 */           if ((!this.field_145850_b.field_72995_K) && (!Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet()
/* 179 */             .add(SoulType.PREDATORY, 1), 100, cagePosVec))) {
/* 180 */             this.progress = 0;
/* 181 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/* 183 */         } else if (this.progress == 20) {
/* 184 */           if (!this.field_145850_b.field_72995_K) {
/* 185 */             if (Get.wells().consumeSouls(this.field_145850_b, this.field_174879_c, 16.0D, recipe.getSoulSet(), BlockUtil.midBlockToVec3(this.field_174879_c.func_177984_a()))) {
/* 186 */               Get.fx().GLOW.sendToAllNear(this.field_145850_b, cagePos.func_177984_a(), 2.0F, 50, 10040200, 1, null, 0.0F, 16.0D);
/* 187 */               Sound.MOD_RANDOM_POWER_UP.playToAllNear(this, 0.5F, 1.0F);
/* 188 */               cage.setTrappedEntity(recipe.createResult(this.field_145850_b, cagePos), true);
/* 189 */               Get.knowledge().giveKnolsToNearestPlayer(this.field_145850_b, this.field_174879_c, 8, new emoniph.intangible.api.IKnol[] { Get.knowledge().SKILL_SOUL_TRANSFUSION });
/*     */             } else {
/* 191 */               Sound.MOD_RANDOM_POWER_DOWN.playToAllNear(this, 0.5F, 1.0F);
/*     */             }
/*     */           }
/* 194 */         } else if (this.progress >= 40) {
/* 195 */           this.progress = 0;
/*     */         }
/*     */       } else {
/* 198 */         this.progress = 0;
/*     */       }
/*     */     }
/*     */     
/*     */     private void updateReconstruction() {
/* 203 */       List<EntityPlayer> players = this.field_145850_b.func_72872_a(EntityPlayer.class, new AxisAlignedBB(this.field_174879_c, this.field_174879_c
/* 204 */         .func_177982_a(1, 2, 1)));
/* 205 */       if ((players.size() == 1) && 
/* 206 */         (Get.effects().isActiveFor(Get.effects().INCORPOREAL, (net.minecraft.entity.EntityLivingBase)players.get(0)))) {
/* 207 */         this.progress += 1;
/*     */         
/*     */ 
/* 210 */         if ((this.field_145850_b.field_72995_K) && 
/* 211 */           (this.progress >= 5) && (this.progress < 20)) {
/* 212 */           for (int i = 0; i < 20 + this.progress * 2; i++)
/*     */           {
/*     */ 
/*     */ 
/* 216 */             Intangible.PROXY.glow(this.field_145850_b, this.field_174879_c.func_177984_a(), 0.25D + this.progress * 0.01D).motion(0.0D, 0.1D, 0.0D).duration(15).color(8952064, 64);
/*     */           }
/*     */           
/* 219 */           Sound.MOD_RANDOM_MACHINE.playToAllNear(this, 0.5F, 1.0F);
/*     */         }
/*     */         
/* 222 */         double MAX_WELL_RANGE = 16.0D;
/* 223 */         EntityPlayer player = (EntityPlayer)players.get(0);
/* 224 */         if (this.progress == 5) {
/* 225 */           if ((!this.field_145850_b.field_72995_K) && (!Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet()
/* 226 */             .add(SoulType.BENIGN, 1), 100, BlockUtil.midBlockToVec3(this.field_174879_c)))) {
/* 227 */             this.progress = 0;
/* 228 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/* 230 */         } else if (this.progress == 10) {
/* 231 */           if ((!this.field_145850_b.field_72995_K) && (!Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet()
/* 232 */             .add(SoulType.MALLEABLE, 2), 100, BlockUtil.midBlockToVec3(this.field_174879_c)))) {
/* 233 */             this.progress = 0;
/* 234 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/* 236 */         } else if (this.progress == 15) {
/* 237 */           if ((!this.field_145850_b.field_72995_K) && (!Get.wells().requestSoulsForWork(this.field_145850_b, this.field_174879_c, 16.0D, new SoulSet()
/* 238 */             .add(SoulType.IMMUTABLE, 2), 100, BlockUtil.midBlockToVec3(this.field_174879_c)))) {
/* 239 */             this.progress = 0;
/* 240 */             this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */           }
/* 242 */         } else if (this.progress == 20) {
/* 243 */           if (!this.field_145850_b.field_72995_K) {
/* 244 */             PlayerEx playerEx = PlayerEx.get(player);
/* 245 */             ISoulSet souls = new SoulSet().add(SoulType.UNHINGED, 1).add(SoulType.IMMUTABLE, 1);
/* 246 */             if (Get.wells().consumeSouls(this.field_145850_b, this.field_174879_c, 16.0D, souls, BlockUtil.midBlockToVec3(this.field_174879_c))) {
/* 247 */               playerEx.tryToggleEffect(Get.effects().INCORPOREAL);
/* 248 */               Sound.MOD_RANDOM_POWER_DOWN.playToAllNear(player, 0.5F, 1.0F);
/*     */             } else {
/* 250 */               this.progress = 0;
/* 251 */               this.field_145850_b.func_175689_h(this.field_174879_c);
/*     */             }
/*     */           }
/* 254 */         } else if (this.progress >= 40) {
/* 255 */           this.progress = 0;
/*     */         }
/*     */       } else {
/* 258 */         this.progress = 0;
/*     */       }
/*     */     }
/*     */     
/*     */     public BlockPos getControllerPos()
/*     */     {
/* 264 */       return this.field_174879_c;
/*     */     }
/*     */     
/*     */     public long getTicks()
/*     */     {
/* 269 */       return this.start >= 0L ? this.counter - this.start : 0L;
/*     */     }
/*     */     
/*     */     public int getProgress() {
/* 273 */       return this.progress;
/*     */     }
/*     */     
/*     */     public long getCounter() {
/* 277 */       return this.counter;
/*     */     }
/*     */     
/*     */     public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newState)
/*     */     {
/* 282 */       return oldState.func_177230_c() != newState.func_177230_c();
/*     */     }
/*     */     
/*     */     public void func_145841_b(NBTTagCompound compound)
/*     */     {
/* 287 */       super.func_145841_b(compound);
/* 288 */       compound.func_74768_a("progress", this.progress);
/* 289 */       compound.func_74772_a("counter", this.counter);
/* 290 */       compound.func_74772_a("start", this.start);
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_145839_a(NBTTagCompound compound)
/*     */     {
/* 296 */       super.func_145839_a(compound);
/* 297 */       this.progress = compound.func_74762_e("progress");
/* 298 */       this.counter = compound.func_74763_f("counter");
/* 299 */       this.start = compound.func_74763_f("start");
/*     */     }
/*     */     
/*     */     public net.minecraft.network.Packet func_145844_m()
/*     */     {
/* 304 */       NBTTagCompound compound = new NBTTagCompound();
/* 305 */       func_145841_b(compound);
/* 306 */       return new S35PacketUpdateTileEntity(func_174877_v(), 1, compound);
/*     */     }
/*     */     
/*     */     public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet)
/*     */     {
/* 311 */       super.onDataPacket(net, packet);
/* 312 */       NBTTagCompound compound = packet.func_148857_g();
/* 313 */       func_145839_a(compound);
/* 314 */       this.field_145850_b.func_175689_h(func_174877_v());
/*     */     }
/*     */     
/*     */     @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */     public AxisAlignedBB getRenderBoundingBox()
/*     */     {
/* 320 */       return new AxisAlignedBB(func_174877_v(), func_174877_v().func_177982_a(1, 3, 1));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockReconstructor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */