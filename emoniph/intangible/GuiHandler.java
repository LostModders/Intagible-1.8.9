/*    */ package emoniph.intangible;
/*    */ 
/*    */ import emoniph.intangible.potions.PotionPickpocket.MobIntentoryWrapper;
/*    */ import net.minecraft.client.multiplayer.WorldClient;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.common.network.IGuiHandler;
/*    */ 
/*    */ public class GuiHandler implements IGuiHandler
/*    */ {
/*    */   public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
/*    */   {
/* 14 */     switch (id)
/*    */     {
/*    */     case 1: 
/* 17 */       return new emoniph.intangible.potions.PotionPickpocket.ContainerMobInventory(player.field_71071_by, new PotionPickpocket.MobIntentoryWrapper((EntityLiving)world.func_73045_a(x)), player);
/*    */     }
/*    */     
/*    */     
/* 21 */     return null;
/*    */   }
/*    */   
/*    */   public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
/*    */   {
/* 26 */     if ((world instanceof WorldClient)) {
/* 27 */       switch (id)
/*    */       {
/*    */       case 1: 
/* 30 */         return new emoniph.intangible.client.gui.GuiMobInventory(new PotionPickpocket.MobIntentoryWrapper((EntityLiving)world.func_73045_a(x)), player.field_71071_by);
/*    */       }
/*    */       
/*    */     }
/*    */     
/* 35 */     return null;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/GuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */