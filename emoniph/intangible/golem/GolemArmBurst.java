/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.api.BodySide;
/*    */ import emoniph.intangible.api.IFakePlayerProvider;
/*    */ import emoniph.intangible.client.models.ModelGolemArmBurst;
/*    */ import emoniph.intangible.entity.EntitySpell;
/*    */ import emoniph.intangible.spells.ModSpells;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldServer;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemArmBurst extends GolemArm
/*    */ {
/*    */   public int getCooldownTicks()
/*    */   {
/* 23 */     return 40;
/*    */   }
/*    */   
/*    */   public boolean canPoint()
/*    */   {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public boolean canStartBlocks()
/*    */   {
/* 33 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected emoniph.intangible.client.models.ModelGolemArm createModel(BodySide side)
/*    */   {
/* 39 */     return new ModelGolemArmBurst(side);
/*    */   }
/*    */   
/*    */   public boolean onUseAction(final World world, final EntityPlayer player, final EntityLiving golem, IFakePlayerProvider fakePlayerProvider, BlockPos targetPos, final BodySide side)
/*    */   {
/* 44 */     if (!world.field_72995_K) {
/* 45 */       ((WorldServer)world).func_152344_a(new Runnable()
/*    */       {
/*    */         public void run() {
/* 48 */           EntitySpell spell = new EntitySpell(world, player, Get.spells().DOOM_BOLT, 0.3D);
/* 49 */           spell.setColor(16777215, 10027042, 1.0F);
/* 50 */           Sound.RANDOM_FIZZ.playToAllNear(player);
/* 51 */           Vec3 vec = golem.func_70040_Z().func_178787_e(golem.func_70040_Z().func_178785_b(side == BodySide.RIGHT ? -90.0F : 90.0F));
/* 52 */           spell.field_70165_t += vec.field_72450_a * 0.4D;
/* 53 */           spell.field_70161_v += vec.field_72449_c * 0.4D;
/* 54 */           spell.field_70163_u -= 0.4D;
/* 55 */           world.func_72838_d(spell);
/*    */         }
/*    */       });
/*    */     }
/*    */     
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemArmBurst.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */