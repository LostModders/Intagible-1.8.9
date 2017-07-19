/*    */ package emoniph.intangible.mods.hooks.waila;
/*    */ 
/*    */ import emoniph.intangible.Get;
/*    */ import emoniph.intangible.effects.EffectRegistry;
/*    */ import emoniph.intangible.entity.EntityKnowledgeGem;
/*    */ import java.util.List;
/*    */ import mcp.mobius.waila.api.IWailaConfigHandler;
/*    */ import mcp.mobius.waila.api.IWailaEntityAccessor;
/*    */ import mcp.mobius.waila.api.IWailaRegistrar;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WailaRegistrar implements mcp.mobius.waila.api.IWailaEntityProvider
/*    */ {
/*    */   public static void callbackRegister(IWailaRegistrar registrar)
/*    */   {
/* 20 */     WailaRegistrar provider = new WailaRegistrar();
/* 21 */     registrar.registerOverrideEntityProvider(provider, EntityKnowledgeGem.class);
/* 22 */     registrar.registerOverrideEntityProvider(provider, EntityPlayer.class);
/*    */   }
/*    */   
/*    */ 
/*    */   public Entity getWailaOverride(IWailaEntityAccessor accessor, IWailaConfigHandler config)
/*    */   {
/* 28 */     if ((accessor.getEntity() instanceof EntityKnowledgeGem))
/* 29 */       return null;
/* 30 */     if (((accessor.getEntity() instanceof EntityPlayer)) && 
/* 31 */       (Get.effects().isActiveFor(Get.effects().INCORPOREAL, (EntityPlayer)accessor.getEntity()))) {
/* 32 */       return null;
/*    */     }
/*    */     
/* 35 */     return accessor.getEntity();
/*    */   }
/*    */   
/* 38 */   private static final List<String> EMPTY = new java.util.ArrayList();
/*    */   
/*    */ 
/*    */   public List<String> getWailaHead(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config)
/*    */   {
/* 43 */     return currenttip;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<String> getWailaBody(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config)
/*    */   {
/* 49 */     return currenttip;
/*    */   }
/*    */   
/*    */ 
/*    */   public List<String> getWailaTail(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor, IWailaConfigHandler config)
/*    */   {
/* 55 */     return currenttip;
/*    */   }
/*    */   
/*    */   public NBTTagCompound getNBTData(EntityPlayerMP player, Entity ent, NBTTagCompound tag, World world)
/*    */   {
/* 60 */     return tag;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/mods/hooks/waila/WailaRegistrar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */