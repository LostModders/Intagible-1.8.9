/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.fx.ParticleFactory;
/*    */ import emoniph.intangible.fx.ParticleFactory.GlowParticle;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.souls.EnumSoulType;
/*    */ import emoniph.intangible.souls.SoulSet;
/*    */ import emoniph.intangible.util.TickUtil;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.network.NetHandlerPlayServer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.EnumWorldBlockLayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockCrystalBlock extends Block implements IBlock, emoniph.intangible.items.ICreativeSort
/*    */ {
/*    */   public BlockCrystalBlock()
/*    */   {
/* 26 */     super(Material.field_151576_e);
/* 27 */     func_149711_c(5.0F);
/* 28 */     func_149752_b(10.0F);
/* 29 */     func_149672_a(field_149777_j);
/*    */   }
/*    */   
/*    */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */   public EnumWorldBlockLayer func_180664_k() {
/* 34 */     return EnumWorldBlockLayer.TRANSLUCENT;
/*    */   }
/*    */   
/*    */   public boolean func_149686_d() {
/* 38 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_149662_c() {
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
/*    */   {
/* 47 */     if (!worldIn.field_72995_K) {
/* 48 */       BlockPos exitPos = pos;
/* 49 */       EnumFacing face = side.func_176734_d();
/* 50 */       int range = this == Get.blocks().YELLOW_CRYSTAL_BLOCK ? 32 : 16;
/* 51 */       for (int i = 0; i < range; i++) {
/* 52 */         exitPos = exitPos.func_177972_a(face);
/* 53 */         if (worldIn.func_180495_p(exitPos).func_177230_c() != this)
/*    */         {
/*    */ 
/* 56 */           if (!isValidExit(worldIn, exitPos)) {
/* 57 */             exitPos = exitPos.func_177984_a();
/*    */           }
/* 59 */           if (!isValidExit(worldIn, exitPos)) break;
/* 60 */           PlayerEx playerEx = PlayerEx.get(playerIn);
/* 61 */           if (playerEx.tryConsumeSouls(new SoulSet().add(emoniph.intangible.api.SoulType.UNHINGED, 1), TickUtil.fromSeconds(30))) {
/* 62 */             Get.fx().GLOW.sendToAllNear(playerIn, 0.5F, 50, EnumSoulType.UNHINGED.getColor(), 1, emoniph.intangible.util.BlockUtil.midBlockToVec3(exitPos.func_177972_a(side)), 0.75F, 16.0D);
/* 63 */             Sound.MOD_RANDOM_SPELL1.playToAllNear(playerIn, 0.5F, 1.5F);
/* 64 */             ((EntityPlayerMP)playerIn).field_71135_a.func_147364_a(exitPos.func_177958_n() + 0.5D, exitPos.func_177956_o() - 1, exitPos.func_177952_p() + 0.5D, playerIn.field_70177_z, playerIn.field_70125_A);
/*    */             
/* 66 */             Sound.MOD_RANDOM_SPELL1.playToAllNear(playerIn, 0.5F, 1.5F);
/* 67 */             return true;
/*    */           }
/* 69 */           break;
/*    */         }
/*    */       }
/*    */       
/* 73 */       return false;
/*    */     }
/* 75 */     return true;
/*    */   }
/*    */   
/*    */   private boolean isValidExit(World world, BlockPos pos) {
/* 79 */     return (world.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) && (world.func_180495_p(pos.func_177977_b()).func_177230_c().func_149688_o().func_76222_j());
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 84 */     return 52;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockCrystalBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */