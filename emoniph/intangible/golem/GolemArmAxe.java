/*     */ package emoniph.intangible.golem;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.BodySide;
/*     */ import emoniph.intangible.api.IFakePlayerProvider;
/*     */ import emoniph.intangible.client.models.ModelGolemArm;
/*     */ import emoniph.intangible.client.models.ModelGolemArmAxe;
/*     */ import emoniph.intangible.util.RayTraceUtil;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class GolemArmAxe
/*     */   extends GolemArm
/*     */ {
/*     */   public boolean canSwing()
/*     */   {
/*  37 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canStartBlocks()
/*     */   {
/*  42 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected ModelGolemArm createModel(BodySide side)
/*     */   {
/*  48 */     return new ModelGolemArmAxe(side);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onUseAction(World world, EntityPlayer player, final EntityLiving golem, IFakePlayerProvider fakePlayerProvider, BlockPos targetPos, BodySide side)
/*     */   {
/*  54 */     Vec3 look = golem.func_70040_Z();
/*  55 */     List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, golem.func_174813_aQ().func_72314_b(1.0D, 2.0D, 1.0D));
/*  56 */     boolean targets = false;
/*     */     
/*  58 */     if (!world.field_72995_K) {
/*  59 */       Sound.MOD_RANDOM_MELEE.playToAllNear(player, 0.7F);
/*     */     }
/*     */     
/*  62 */     for (EntityLivingBase entity : list) {
/*  63 */       if ((entity != golem) && (look.func_72430_b(new Vec3(entity.field_70165_t - golem.field_70165_t, entity.field_70163_u - golem.field_70163_u, entity.field_70161_v - golem.field_70161_v)) > 0.0D) && (entity != player))
/*     */       {
/*  65 */         if (!world.field_72995_K) {
/*  66 */           final EntityLivingBase targetEntity = entity;
/*  67 */           ((WorldServer)world).func_152344_a(new Runnable()
/*     */           {
/*     */             public void run() {
/*  70 */               golem.func_70652_k(targetEntity);
/*     */             }
/*     */           });
/*     */         }
/*  74 */         targets = true;
/*     */       }
/*     */     }
/*     */     
/*  78 */     if ((!targets) && (!world.field_72995_K) && (targetPos != null)) {
/*  79 */       MovingObjectPosition mop = RayTraceUtil.traceBlock(player, false, 5.0D);
/*  80 */       if (mop != null) {
/*  81 */         ItemStack stack = new ItemStack(Items.field_151056_x);
/*  82 */         EntityPlayer fake = fakePlayerProvider.getFakePlayer();
/*  83 */         fake.func_70062_b(0, stack);
/*     */         
/*  85 */         IBlockState state = world.func_180495_p(mop.func_178782_a());
/*  86 */         if ((ForgeHooks.canHarvestBlock(state.func_177230_c(), player, world, mop.func_178782_a())) && 
/*  87 */           (state.func_177230_c().func_176195_g(world, mop.func_178782_a()) >= 0.0F) && 
/*  88 */           (!state.func_177230_c().hasTileEntity(state)) && 
/*  89 */           (ForgeHooks.isToolEffective(world, mop.func_178782_a(), stack)) && 
/*  90 */           (state.func_177230_c().isWood(world, mop.func_178782_a())) && 
/*  91 */           (isTree(world, mop.func_178782_a(), state.func_177230_c())))
/*     */         {
/*  93 */           Set<BlockPos> visited = new HashSet();
/*  94 */           harvestTree(world, mop.func_178782_a(), fake, stack, state.func_177230_c(), visited, mop.func_178782_a());
/*     */         }
/*     */         else {
/*  97 */           breakBlock(fake, mop.func_178782_a(), stack, true);
/*     */         }
/*     */         
/*     */ 
/* 101 */         List<EntityItem> items = world.func_72872_a(EntityItem.class, golem.func_174813_aQ().func_72314_b(5.0D, 2.0D, 5.0D));
/* 102 */         for (Entity item : items) {
/* 103 */           item.func_70634_a(golem.field_70165_t, golem.field_70163_u, golem.field_70161_v);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 108 */     return true;
/*     */   }
/*     */   
/*     */   private void harvestTree(World world, BlockPos pos, EntityPlayer player, ItemStack tool, Block woodBlock, Set<BlockPos> visited, BlockPos startPos) {
/* 112 */     for (int x = pos.func_177958_n() - 1; x <= pos.func_177958_n() + 1; x++) {
/* 113 */       for (int z = pos.func_177952_p() - 1; z <= pos.func_177952_p() + 1; z++) {
/* 114 */         for (int y = pos.func_177956_o() - 1; y <= pos.func_177956_o() + 1; y++) {
/* 115 */           int dx = startPos.func_177958_n() - x;
/* 116 */           int dy = startPos.func_177956_o() - y;
/* 117 */           int dz = startPos.func_177952_p() - z;
/* 118 */           if (dx * dx + dz * dz < 16) {
/* 119 */             BlockPos newPos = new BlockPos(x, y, z);
/* 120 */             if (!visited.contains(newPos)) {
/* 121 */               IBlockState state = world.func_180495_p(newPos);
/* 122 */               if ((state.func_177230_c().isWood(world, newPos)) || (state.func_177230_c().isLeaves(world, newPos))) {
/* 123 */                 visited.add(newPos);
/* 124 */                 breakBlock(player, newPos, tool);
/* 125 */                 harvestTree(world, newPos, player, tool, woodBlock, visited, startPos);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean isTree(World world, BlockPos pos, Block startingBlock) {
/* 135 */     int leaves = 0;
/* 136 */     EnumFacing facing; for (facing : EnumFacing.field_176754_o) {
/* 137 */       if (world.func_180495_p(pos.func_177972_a(facing)).func_177230_c().isLeaves(world, pos)) {
/* 138 */         leaves++;
/*     */       }
/*     */     }
/*     */     
/* 142 */     BlockPos topPos = pos;
/* 143 */     boolean foundTop = false;
/* 144 */     while (!foundTop) {
/* 145 */       BlockPos up = topPos.func_177984_a();
/* 146 */       if (world.func_180495_p(up).func_177230_c() == startingBlock) {
/* 147 */         for (EnumFacing facing : EnumFacing.field_176754_o) {
/* 148 */           if (world.func_180495_p(topPos.func_177972_a(facing)).func_177230_c().isLeaves(world, topPos)) {
/* 149 */             leaves++;
/*     */           }
/*     */         }
/* 152 */         topPos = up;
/*     */       } else {
/* 154 */         foundTop = true;
/*     */       }
/*     */     }
/*     */     
/* 158 */     int maxLeaves = 3;
/* 159 */     return leaves >= 3;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemArmAxe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */