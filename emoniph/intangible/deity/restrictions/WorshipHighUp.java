/*    */ package emoniph.intangible.deity.restrictions;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.WorldProvider;
/*    */ 
/*    */ public class WorshipHighUp implements emoniph.intangible.api.deity.IDeityWorshipRestriction
/*    */ {
/*    */   public boolean isWorshipAllowed(World world, BlockPos pos, EntityPlayer player)
/*    */   {
/* 12 */     return (world != null) && (world.field_73011_w != null) && (world.field_73011_w.func_76569_d()) && (pos.func_177956_o() >= world.func_72940_L() * 0.75F);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/restrictions/WorshipHighUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */