/*    */ package emoniph.intangible.deity.effects;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.api.deity.IDeity;
/*    */ import emoniph.intangible.api.deity.IDeityShrineEffect;
/*    */ import emoniph.intangible.deity.IPlayerWorship;
/*    */ import emoniph.intangible.deity.ShrineManager;
/*    */ import emoniph.intangible.network.PacketPipeline;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ShrineEffectTravel implements IDeityShrineEffect
/*    */ {
/*    */   public void onTick(World world, BlockPos pos, long shrineWorship, IDeity deity) {}
/*    */   
/*    */   public void afterWorship(World world, BlockPos pos, EntityPlayer player, long shrineWorship, boolean worshipSucceeded, IDeity deity)
/*    */   {
/* 21 */     if (!world.field_72995_K) {
/* 22 */       PlayerEx playerEx = PlayerEx.get(player);
/* 23 */       int level = playerEx.getWorship().getFollowerLevelOf(world, deity);
/* 24 */       if ((level >= 2) || ((level == 1) && (playerEx.getWorship().getWorshipFor(world, deity.getId()) > 3L))) {
/* 25 */         List<BlockPos> shrines = Get.shrines().getLocationsFor(world, deity);
/* 26 */         shrines.remove(pos);
/* 27 */         if (shrines.size() > 0) {
/* 28 */           Get.pipeline().sendTo(new emoniph.intangible.player.PlayerEx.PacketTravelDestinations(shrines, worshipSucceeded), player);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/effects/ShrineEffectTravel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */