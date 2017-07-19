/*     */ package emoniph.intangible.util;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.IMultiBlock;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.network.play.server.S23PacketBlockChange;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.WorldSettings.GameType;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.common.util.FakePlayerFactory;
/*     */ import net.minecraftforge.event.world.BlockEvent.BreakEvent;
/*     */ import net.minecraftforge.fml.common.eventhandler.EventBus;
/*     */ 
/*     */ public enum BlockUtil
/*     */ {
/*     */   private BlockUtil() {}
/*     */   
/*     */   public static boolean isSoundDampned(World world, BlockPos pos)
/*     */   {
/*  36 */     for (EnumFacing face : EnumFacing.field_82609_l) {
/*  37 */       if (world.func_180495_p(pos.func_177972_a(face)).func_177230_c() == Blocks.field_150325_L) {
/*  38 */         return true;
/*     */       }
/*     */     }
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   public static <T> T getTileEntity(IBlockAccess worldIn, BlockPos pos, Class<T> clazz) {
/*  45 */     IBlockState state = worldIn.func_180495_p(pos);
/*  46 */     return (T)getTileEntity(worldIn, pos, clazz, state);
/*     */   }
/*     */   
/*     */   public static <T> T getTileEntity(IBlockAccess worldIn, BlockPos pos, Class<T> clazz, IBlockState state) {
/*  50 */     if ((state.func_177230_c() instanceof IMultiBlock)) {
/*  51 */       IMultiBlock mb = (IMultiBlock)state.func_177230_c();
/*  52 */       pos = mb.getMultiBlockCorePos(worldIn, pos, state);
/*     */     }
/*  54 */     TileEntity tile = worldIn.func_175625_s(pos);
/*  55 */     if ((tile != null) && (clazz.isAssignableFrom(tile.getClass()))) {
/*  56 */       return (T)clazz.cast(tile);
/*     */     }
/*  58 */     return null;
/*     */   }
/*     */   
/*     */   public static AxisAlignedBB getBounds(BlockPos pos, double radius) {
/*  62 */     return getBounds(pos, radius, radius);
/*     */   }
/*     */   
/*     */   public static AxisAlignedBB getBounds(BlockPos pos, double radiusHorizontal, double radiusVertical) {
/*  66 */     return AxisAlignedBB.func_178781_a(0.5D + pos
/*  67 */       .func_177958_n() - radiusHorizontal, 0.5D + pos
/*  68 */       .func_177956_o() - radiusVertical, 0.5D + pos
/*  69 */       .func_177952_p() - radiusHorizontal, 0.5D + pos
/*  70 */       .func_177958_n() + radiusHorizontal, 0.5D + pos
/*  71 */       .func_177956_o() + radiusVertical, 0.5D + pos
/*  72 */       .func_177952_p() + radiusHorizontal);
/*     */   }
/*     */   
/*     */   public static void notifyDiagonals(World worldIn, BlockPos pos, Block blockType) {
/*  76 */     worldIn.func_180496_d(pos.func_177982_a(1, 0, 1), blockType);
/*  77 */     worldIn.func_180496_d(pos.func_177982_a(1, 0, -1), blockType);
/*  78 */     worldIn.func_180496_d(pos.func_177982_a(-1, 0, 1), blockType);
/*  79 */     worldIn.func_180496_d(pos.func_177982_a(-1, 0, -1), blockType);
/*     */   }
/*     */   
/*     */   public static int facingToHorizonatalAngle(EnumFacing facing) {
/*  83 */     return facing.func_176736_b() * 90;
/*     */   }
/*     */   
/*     */   public static boolean canEditBlock(EntityPlayer player, World world, BlockPos pos) {
/*  87 */     IBlockState state = world.func_180495_p(pos);
/*  88 */     if (!player.func_175142_cm())
/*  89 */       return false;
/*  90 */     if (state.func_177230_c().func_176195_g(world, pos) == -1.0F)
/*  91 */       return false;
/*  92 */     if (Get.config().CHECK_FOR_BLOCK_BREAK_PERMISSION) {
/*  93 */       BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, player);
/*  94 */       event.setCanceled(false);
/*  95 */       event.setExpToDrop(-1);
/*  96 */       MinecraftForge.EVENT_BUS.post(event);
/*  97 */       if (event.isCanceled()) {
/*  98 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean canEditBlock(EntityLivingBase entity, World world, BlockPos pos) {
/* 106 */     if ((entity != null) && ((entity instanceof EntityPlayer)))
/* 107 */       return canEditBlock((EntityPlayer)entity, world, pos);
/* 108 */     if ((world instanceof WorldServer)) {
/* 109 */       EntityPlayer fakePlayer = FakePlayerFactory.getMinecraft((WorldServer)world);
/* 110 */       return canEditBlock(fakePlayer, world, pos);
/*     */     }
/* 112 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean canEditBlock(World world, BlockPos pos)
/*     */   {
/* 117 */     if ((world instanceof WorldServer)) {
/* 118 */       EntityPlayer fakePlayer = FakePlayerFactory.getMinecraft((WorldServer)world);
/* 119 */       return canEditBlock(fakePlayer, world, pos);
/*     */     }
/* 121 */     return true;
/*     */   }
/*     */   
/*     */   public static boolean tryHarvestBlock(World world, BlockPos pos, EntityPlayerMP player, ItemStack stack)
/*     */   {
/* 126 */     int exp = onBlockBreakEvent(world, WorldSettings.GameType.SURVIVAL, player, pos);
/* 127 */     if (exp == -1) {
/* 128 */       return false;
/*     */     }
/* 130 */     IBlockState iblockstate = world.func_180495_p(pos);
/* 131 */     TileEntity tileentity = world.func_175625_s(pos);
/*     */     
/* 133 */     if ((stack != null) && (stack.func_77973_b().onBlockStartBreak(stack, pos, player))) {
/* 134 */       return false;
/*     */     }
/*     */     
/* 137 */     world.func_175718_b(2001, pos, Block.func_176210_f(iblockstate));
/* 138 */     boolean flag1 = false;
/*     */     
/* 140 */     if (player.field_71075_bZ.field_75098_d) {
/* 141 */       flag1 = removeBlock(world, pos, player);
/* 142 */       player.field_71135_a.func_147359_a(new S23PacketBlockChange(world, pos));
/*     */     } else {
/* 144 */       boolean flag = (stack == null) || (iblockstate.func_177230_c().canHarvestBlock(world, pos, player));
/*     */       
/* 146 */       if (flag) {
/* 147 */         if (stack != null) {
/* 148 */           stack.func_179548_a(world, iblockstate.func_177230_c(), pos, player);
/*     */         }
/*     */         
/* 151 */         flag1 = removeBlock(world, pos, player, flag);
/* 152 */         if ((flag1) && (flag)) {
/* 153 */           iblockstate.func_177230_c().func_180657_a(world, player, pos, iblockstate, tileentity);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 159 */     if ((!player.field_71075_bZ.field_75098_d) && (flag1) && (exp > 0)) {
/* 160 */       iblockstate.func_177230_c().func_180637_b(world, pos, exp);
/*     */     }
/* 162 */     return flag1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static int onBlockBreakEvent(World world, WorldSettings.GameType gameType, EntityPlayerMP entityPlayer, BlockPos pos)
/*     */   {
/* 169 */     boolean preCancelEvent = false;
/* 170 */     if ((gameType.func_77145_d()) && (entityPlayer.func_70694_bm() != null) && ((entityPlayer.func_70694_bm().func_77973_b() instanceof net.minecraft.item.ItemSword))) {
/* 171 */       preCancelEvent = true;
/*     */     }
/* 173 */     if (gameType.func_82752_c())
/*     */     {
/* 175 */       if (gameType == WorldSettings.GameType.SPECTATOR) {
/* 176 */         preCancelEvent = true;
/*     */       }
/* 178 */       if (!entityPlayer.func_175142_cm())
/*     */       {
/* 180 */         ItemStack itemstack = entityPlayer.func_71045_bC();
/* 181 */         if ((itemstack == null) || (!itemstack.func_179544_c(world.func_180495_p(pos).func_177230_c()))) {
/* 182 */           preCancelEvent = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 187 */     if (world.func_175625_s(pos) == null)
/*     */     {
/* 189 */       S23PacketBlockChange packet = new S23PacketBlockChange(world, pos);
/* 190 */       packet.field_148883_d = Blocks.field_150350_a.func_176223_P();
/*     */       
/* 192 */       if (entityPlayer.field_71135_a != null) {
/* 193 */         entityPlayer.field_71135_a.func_147359_a(packet);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 198 */     IBlockState state = world.func_180495_p(pos);
/* 199 */     BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(world, pos, state, entityPlayer);
/* 200 */     event.setCanceled(preCancelEvent);
/* 201 */     MinecraftForge.EVENT_BUS.post(event);
/*     */     
/*     */ 
/* 204 */     if (event.isCanceled())
/*     */     {
/*     */ 
/* 207 */       if (entityPlayer.field_71135_a != null) {
/* 208 */         entityPlayer.field_71135_a.func_147359_a(new S23PacketBlockChange(world, pos));
/*     */       }
/*     */       
/*     */ 
/* 212 */       TileEntity tileentity = world.func_175625_s(pos);
/* 213 */       if (tileentity != null)
/*     */       {
/* 215 */         net.minecraft.network.Packet pkt = tileentity.func_145844_m();
/* 216 */         if (pkt != null)
/*     */         {
/* 218 */           if (entityPlayer.field_71135_a != null) {
/* 219 */             entityPlayer.field_71135_a.func_147359_a(pkt);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 224 */     return event.isCanceled() ? -1 : event.getExpToDrop();
/*     */   }
/*     */   
/*     */   private static boolean removeBlock(World world, BlockPos pos, EntityPlayer player) {
/* 228 */     return removeBlock(world, pos, player, false);
/*     */   }
/*     */   
/*     */   private static boolean removeBlock(World world, BlockPos pos, EntityPlayer player, boolean canHarvest) {
/* 232 */     IBlockState iblockstate = world.func_180495_p(pos);
/* 233 */     iblockstate.func_177230_c().func_176208_a(world, pos, iblockstate, player);
/* 234 */     boolean flag = iblockstate.func_177230_c().removedByPlayer(world, pos, player, canHarvest);
/*     */     
/* 236 */     if (flag) {
/* 237 */       iblockstate.func_177230_c().func_176206_d(world, pos, iblockstate);
/*     */     }
/*     */     
/* 240 */     return flag;
/*     */   }
/*     */   
/*     */   public static boolean tryPlaceItemBlock(World world, BlockPos pos, EntityPlayer player, ItemStack stack) {
/* 244 */     if ((stack.func_77973_b() instanceof net.minecraft.item.ItemBlock)) {
/* 245 */       return stack.func_179546_a(player, world, pos, EnumFacing.UP, 0.0F, 0.0F, 0.0F);
/*     */     }
/* 247 */     return false;
/*     */   }
/*     */   
/*     */   public static BlockPos[] offset(BlockPos[] posList, EnumFacing facing) {
/* 251 */     BlockPos[] newList = new BlockPos[posList.length];
/* 252 */     for (int i = 0; i < posList.length; i++) {
/* 253 */       newList[i] = posList[i].func_177972_a(facing);
/*     */     }
/* 255 */     return newList;
/*     */   }
/*     */   
/*     */   public static Vec3 midBlockToVec3(BlockPos pos) {
/* 259 */     return new Vec3(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D);
/*     */   }
/*     */   
/*     */   public static boolean isBlockNearby(World world, BlockPos pos, int radius, Block... blocks) {
/* 263 */     for (int x = -radius; x <= radius; x++) {
/* 264 */       for (int z = -radius; z <= radius; z++) {
/* 265 */         BlockPos testPos = pos.func_177982_a(x, 0, z);
/* 266 */         for (int i = 0; i < blocks.length; i++) {
/* 267 */           if (world.func_180495_p(testPos).func_177230_c() == blocks[i]) {
/* 268 */             return true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 273 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/BlockUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */