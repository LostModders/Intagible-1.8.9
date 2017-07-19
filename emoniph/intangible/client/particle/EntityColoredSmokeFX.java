/*    */ package emoniph.intangible.client.particle;
/*    */ 
/*    */ import net.minecraft.client.particle.EntitySmokeFX;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class EntityColoredSmokeFX extends EntitySmokeFX
/*    */ {
/*    */   public EntityColoredSmokeFX(World worldIn, double x, double y, double z, double motionX, double motionY, double motionZ)
/*    */   {
/* 11 */     super(worldIn, x, y, z, motionX, motionY, motionZ, 1.0F);
/*    */   }
/*    */   
/*    */   public EntityColoredSmokeFX color(int color) {
/* 15 */     this.field_70552_h = ((color >> 16 & 0xFF) / 256.0F);
/* 16 */     this.field_70553_i = ((color >> 8 & 0xFF) / 256.0F);
/* 17 */     this.field_70551_j = ((color & 0xFF) / 256.0F);
/* 18 */     return this;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/particle/EntityColoredSmokeFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */