/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityMinorWorldEffect;
/*    */ import emoniph.intangible.deity.Deity;
/*    */ import emoniph.intangible.deity.IPlayerWorship;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.util.BlockUtil;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.IGrowable;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemFood;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.FoodStats;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MinorEffectNaturesBounty implements IDeityMinorWorldEffect
/*    */ {
/*    */   public void onWorldTick(World world, IDeity deity) {}
/*    */   
/*    */   public boolean onEntityJoinWorld(World world, IDeity deity, Entity entity)
/*    */   {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public boolean isResistant(World world, IDeity deity)
/*    */   {
/* 37 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void onHarvest(World world, BlockPos pos, List<ItemStack> drops, EntityPlayer harvester, Deity deity) {}
/*    */   
/*    */ 
/*    */   public void onPlayerUseItemFinish(World world, EntityPlayer player, ItemStack item, Deity deity)
/*    */   {
/* 47 */     if ((item != null) && ((item.func_77973_b() instanceof ItemFood))) {
/* 48 */       FoodStats food = player.func_71024_bL();
/* 49 */       food.func_75122_a(1, 2.0F);
/*    */     }
/*    */   }
/*    */   
/*    */   public void performPriestEffect(World world, IDeity deity, EntityPlayer player)
/*    */   {
/* 55 */     if (world.field_72995_K) {
/* 56 */       return;
/*    */     }
/* 58 */     int radius = 8;
/* 59 */     double radiusSq = radius * radius;
/* 60 */     BlockPos center = new BlockPos(player);
/* 61 */     ItemStack stack = new ItemStack(Items.field_151012_L);
/* 62 */     for (int x = -radius; x <= radius; x++) {
/* 63 */       for (z = -radius; z <= radius; z++) {
/* 64 */         if ((x + 0.5D) * (x + 0.5D) + (z + 0.5D) * (z + 0.5D) < radiusSq) {
/* 65 */           for (int y = 8; y > -8; y--) {
/* 66 */             BlockPos pos = center.func_177982_a(x, y, z);
/* 67 */             IBlockState state = world.func_180495_p(pos);
/* 68 */             if (((state.func_177230_c() instanceof IGrowable)) && (state.func_177230_c() != Blocks.field_150329_H)) {
/* 69 */               IGrowable grow = (IGrowable)state.func_177230_c();
/*    */               
/* 71 */               if (!grow.func_180670_a(world, world.field_73012_v, pos, state)) break;
/* 72 */               if (grow.func_176473_a(world, pos, state, false)) {
/* 73 */                 grow.func_176474_b(world, world.field_73012_v, pos, state); break;
/*    */               }
/* 75 */               BlockUtil.tryHarvestBlock(world, pos, (EntityPlayerMP)player, stack); break;
/*    */             }
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 86 */     List<EntityItem> items = world.func_72872_a(EntityItem.class, player.func_174813_aQ().func_72314_b(radius, radius - 2, radius));
/* 87 */     for (int z = items.iterator(); z.hasNext();) { item = (EntityItem)z.next();
/* 88 */       item.func_70634_a(player.field_70165_t, player.field_70163_u, player.field_70161_v);
/*    */     }
/*    */     EntityItem item;
/* 91 */     List<EntityPlayer> players = world.func_72872_a(EntityPlayer.class, player.func_174813_aQ().func_72314_b(radius, radius - 2, radius));
/* 92 */     for (EntityPlayer other : players) {
/* 93 */       if (PlayerEx.get(other).getWorship().isFollowerOf(world, deity)) {
/* 94 */         other.func_71024_bL().func_75122_a(10, 1.0F);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/MinorEffectNaturesBounty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */