/*     */ package emoniph.intangible.effects.passive;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IAttack;
/*     */ import emoniph.intangible.api.ICooldownManager;
/*     */ import emoniph.intangible.api.IFocusedTarget;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.player.FocusedTarget;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockPistonBase;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.BlockPistonStructureHelper;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityFallingBlock;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ 
/*     */ public class SpellStrength implements emoniph.intangible.api.IPassiveEffect
/*     */ {
/*     */   public String getLocalizedName()
/*     */   {
/*  34 */     return net.minecraft.util.StatCollector.func_74838_a("effect.intangible:strength");
/*     */   }
/*     */   
/*  37 */   private static final ResourceLocation GLYPH = new ResourceLocation("intangible", "textures/gui/effect_strength.png");
/*     */   
/*     */   public ResourceLocation getHudGlyph()
/*     */   {
/*  41 */     return GLYPH;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void startEffectOn(EntityPlayer player, boolean initialTrigger) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void stopEffectOn(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onAttacking(EntityPlayer player, IFocusedTarget target, IAttack attack, ICooldownManager cooldownManager)
/*     */   {
/*  56 */     if ((!cooldownManager.isCooldownActive(this)) && 
/*  57 */       (attack.getDamageSource().func_76364_f() == player)) {
/*  58 */       boolean overclock = Get.effects().isActiveFor(Get.effects().OVERCLOCK, player);
/*  59 */       boolean unexpected = Get.effects().isActiveFor(Get.effects().UNEXPECTED, player);
/*  60 */       float bonus = 2 + (overclock ? 2 : 0);
/*     */       
/*  62 */       if (unexpected) {
/*  63 */         bonus -= 1.0F;
/*  64 */         float health = target.getTarget().func_110143_aJ();
/*  65 */         if (health > bonus) {
/*  66 */           target.getTarget().func_70606_j(health - bonus);
/*     */         }
/*     */       } else {
/*  69 */         attack.setDamage(attack.getDamage() + bonus);
/*     */       }
/*  71 */       cooldownManager.setCooldown(this, emoniph.intangible.util.TickUtil.fromSeconds(1));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onHurtBy(EntityPlayer player, IFocusedTarget playersTarget, IAttack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void onPostRender(EntityPlayer player, double renderX, double renderY, double renderZ, ICooldownManager cooldownManager, boolean firstPerson) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onUpdate(EntityPlayer player, ICooldownManager cooldownManager)
/*     */   {
/*  90 */     if (Get.effects().isActiveFor(Get.effects().UNEXPECTED, player))
/*     */     {
/*  92 */       PlayerEx playerEx = PlayerEx.get(player);
/*  93 */       World world = player.field_70170_p;
/*  94 */       if (!world.field_72995_K) {
/*  95 */         EnumFacing facing = EnumFacing.func_176733_a(player.field_70759_as);
/*  96 */         BlockPos pos = new BlockPos(player);
/*     */         
/*  98 */         Vec3 motion = new Vec3(player.field_70165_t - playerEx.CACHE.prevX, 0.0D, player.field_70161_v - playerEx.CACHE.prevZ);
/*     */         
/* 100 */         if (motion.func_72430_b(player.func_70040_Z()) > 0.0D) {
/* 101 */           BlockPos blockPos = pos.func_177972_a(facing);
/*     */           
/* 103 */           double dx = blockPos.func_177958_n() + 0.5F - player.field_70165_t;
/* 104 */           double dz = blockPos.func_177952_p() + 0.5F - player.field_70161_v;
/* 105 */           if (Math.sqrt(dx * dx + dz * dz) < 0.95D)
/*     */           {
/* 107 */             BlockPos spacePos = pos.func_177967_a(facing, 2);
/* 108 */             IBlockState state = world.func_180495_p(blockPos);
/* 109 */             boolean fall = false;
/* 110 */             if ((BlockPistonBase.func_180696_a(state.func_177230_c(), world, blockPos, facing, false)) && 
/* 111 */               (!state.func_177230_c().func_149688_o().func_76222_j()) && 
/* 112 */               (world.func_180495_p(spacePos).func_177230_c().func_149688_o().func_76222_j())) {
/* 113 */               world.func_175718_b(2001, blockPos, Block.func_176210_f(state));
/* 114 */               world.func_175656_a(spacePos, state);
/* 115 */               world.func_175698_g(blockPos);
/* 116 */               if (world.func_180495_p(spacePos.func_177977_b()).func_177230_c().func_149688_o().func_76222_j()) {
/* 117 */                 EntityFallingBlock fallingBlock = new EntityFallingBlock(world, spacePos.func_177958_n() + 0.5D, spacePos.func_177956_o(), spacePos.func_177952_p() + 0.5D, state);
/* 118 */                 world.func_72838_d(fallingBlock);
/* 119 */                 fall = true;
/*     */               }
/*     */             }
/*     */             
/* 123 */             blockPos = pos.func_177972_a(facing).func_177984_a();
/* 124 */             spacePos = pos.func_177967_a(facing, 2).func_177984_a();
/* 125 */             state = world.func_180495_p(blockPos);
/* 126 */             if ((BlockPistonBase.func_180696_a(state.func_177230_c(), world, blockPos, facing, false)) && 
/* 127 */               (!state.func_177230_c().func_149688_o().func_76222_j()) && 
/* 128 */               (world.func_180495_p(spacePos).func_177230_c().func_149688_o().func_76222_j())) {
/* 129 */               world.func_175718_b(2001, blockPos, Block.func_176210_f(state));
/* 130 */               world.func_175656_a(spacePos, state);
/* 131 */               world.func_175698_g(blockPos);
/* 132 */               if (fall) {
/* 133 */                 EntityFallingBlock fallingBlock = new EntityFallingBlock(world, spacePos.func_177958_n() + 0.5D, spacePos.func_177956_o(), spacePos.func_177952_p() + 0.5D, state);
/* 134 */                 world.func_72838_d(fallingBlock);
/*     */               }
/*     */             }
/*     */           }
/* 138 */         } else if ((player.func_70093_af()) && (motion.func_72430_b(player.func_70040_Z()) < 0.0D)) {
/* 139 */           BlockPos blockPos = pos.func_177967_a(facing, 2);
/*     */           
/* 141 */           double dx = blockPos.func_177958_n() + 0.5F - player.field_70165_t;
/* 142 */           double dz = blockPos.func_177952_p() + 0.5F - player.field_70161_v;
/* 143 */           if (Math.sqrt(dx * dx + dz * dz) >= 2.0D)
/*     */           {
/* 145 */             BlockPos spacePos = pos.func_177972_a(facing);
/* 146 */             IBlockState state = world.func_180495_p(blockPos);
/* 147 */             boolean fall = false;
/* 148 */             if ((BlockPistonBase.func_180696_a(state.func_177230_c(), world, blockPos, facing, false)) && 
/* 149 */               (!state.func_177230_c().func_149688_o().func_76222_j()) && 
/* 150 */               (world.func_180495_p(spacePos).func_177230_c().func_149688_o().func_76222_j())) {
/* 151 */               world.func_175718_b(2001, blockPos, Block.func_176210_f(state));
/* 152 */               world.func_175656_a(spacePos, state);
/* 153 */               world.func_175698_g(blockPos);
/* 154 */               if (world.func_180495_p(spacePos.func_177977_b()).func_177230_c().func_149688_o().func_76222_j()) {
/* 155 */                 EntityFallingBlock fallingBlock = new EntityFallingBlock(world, spacePos.func_177958_n() + 0.5D, spacePos.func_177956_o(), spacePos.func_177952_p() + 0.5D, state);
/* 156 */                 world.func_72838_d(fallingBlock);
/* 157 */                 fall = true;
/*     */               }
/*     */             }
/*     */             
/* 161 */             blockPos = pos.func_177967_a(facing, 2).func_177984_a();
/* 162 */             spacePos = pos.func_177972_a(facing).func_177984_a();
/* 163 */             state = world.func_180495_p(blockPos);
/* 164 */             if ((BlockPistonBase.func_180696_a(state.func_177230_c(), world, blockPos, facing, false)) && 
/* 165 */               (!state.func_177230_c().func_149688_o().func_76222_j()) && 
/* 166 */               (world.func_180495_p(spacePos).func_177230_c().func_149688_o().func_76222_j())) {
/* 167 */               world.func_175718_b(2001, blockPos, Block.func_176210_f(state));
/* 168 */               world.func_175656_a(spacePos, state);
/* 169 */               world.func_175698_g(blockPos);
/* 170 */               if (fall) {
/* 171 */                 EntityFallingBlock fallingBlock = new EntityFallingBlock(world, spacePos.func_177958_n() + 0.5D, spacePos.func_177956_o(), spacePos.func_177952_p() + 0.5D, state);
/* 172 */                 world.func_72838_d(fallingBlock);
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean doMove(World worldIn, BlockPos pos, EnumFacing direction, boolean extending) {
/* 182 */     if (!extending) {
/* 183 */       worldIn.func_175698_g(pos.func_177972_a(direction));
/*     */     }
/*     */     
/* 186 */     BlockPistonStructureHelper blockpistonstructurehelper = new BlockPistonStructureHelper(worldIn, pos, direction, extending);
/* 187 */     List<BlockPos> list = blockpistonstructurehelper.func_177254_c();
/* 188 */     List<BlockPos> list1 = blockpistonstructurehelper.func_177252_d();
/*     */     
/* 190 */     if (!blockpistonstructurehelper.func_177253_a()) {
/* 191 */       return false;
/*     */     }
/* 193 */     int i = list.size() + list1.size();
/* 194 */     Block[] ablock = new Block[i];
/* 195 */     EnumFacing enumfacing = extending ? direction : direction.func_176734_d();
/*     */     
/* 197 */     for (int j = list1.size() - 1; j >= 0; j--) {
/* 198 */       BlockPos blockpos = (BlockPos)list1.get(j);
/* 199 */       Block block = worldIn.func_180495_p(blockpos).func_177230_c();
/*     */       
/* 201 */       float chance = (block instanceof net.minecraft.block.BlockSnow) ? -1.0F : 1.0F;
/* 202 */       block.func_180653_a(worldIn, blockpos, worldIn.func_180495_p(blockpos), chance, 0);
/* 203 */       worldIn.func_175698_g(blockpos);
/* 204 */       i--;
/* 205 */       ablock[i] = block;
/*     */     }
/*     */     
/* 208 */     for (int k = list.size() - 1; k >= 0; k--) {
/* 209 */       BlockPos blockpos2 = (BlockPos)list.get(k);
/* 210 */       IBlockState iblockstate = worldIn.func_180495_p(blockpos2);
/* 211 */       Block block1 = iblockstate.func_177230_c();
/* 212 */       block1.func_176201_c(iblockstate);
/* 213 */       worldIn.func_175698_g(blockpos2);
/* 214 */       blockpos2 = blockpos2.func_177972_a(enumfacing);
/*     */       
/*     */ 
/* 217 */       i--;
/* 218 */       ablock[i] = block1;
/*     */     }
/*     */     
/* 221 */     BlockPos blockpos1 = pos.func_177972_a(direction);
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
/* 232 */     for (int l = list1.size() - 1; l >= 0; l--) {
/* 233 */       worldIn.func_175685_c((BlockPos)list1.get(l), ablock[(i++)]);
/*     */     }
/*     */     
/* 236 */     for (int i1 = list.size() - 1; i1 >= 0; i1--) {
/* 237 */       worldIn.func_175685_c((BlockPos)list.get(i1), ablock[(i++)]);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 246 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onApplyToNearbyEntities(EntityPlayer player, List<Entity> target, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void augmentArmorProperties(EntityLivingBase player, ISpecialArmor.ArmorProperties props, ItemStack armor, DamageSource source, double damage, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean requiresClientTimer()
/*     */   {
/* 262 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isChanneling(EntityPlayer player)
/*     */   {
/* 267 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onRightClickAir(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onSwing(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public void onPostRenderTick(EntityPlayer player) {}
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isPrerequisitesMet(EntityPlayer PLAYER, ItemStack head, ItemStack chest, ItemStack legs, ItemStack feet)
/*     */   {
/* 288 */     return true;
/*     */   }
/*     */   
/*     */   public void onAttackedBy(EntityPlayer player, FocusedTarget focusedTarget, emoniph.intangible.Attack attack, ICooldownManager cooldownManager) {}
/*     */   
/*     */   public void onPreClientTick(EntityPlayer player, ICooldownManager cooldownManager) {}
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/effects/passive/SpellStrength.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */