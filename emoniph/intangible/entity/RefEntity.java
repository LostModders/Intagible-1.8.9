/*    */ package emoniph.intangible.entity;
/*    */ 
/*    */ import emoniph.intangible.Intangible;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityList;
/*    */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class RefEntity
/*    */ {
/* 19 */   private static int eggRoot = 6595;
/*    */   private final Class<? extends Entity> entityClass;
/*    */   private final String entityName;
/*    */   
/* 23 */   private static int getUniqueEggId() { do { eggRoot += 1;
/* 24 */     } while (EntityList.func_75617_a(eggRoot) != null);
/*    */     
/* 26 */     return eggRoot;
/*    */   }
/*    */   
/*    */ 
/*    */   private boolean canCapture;
/*    */   
/*    */   private boolean canSpawn;
/*    */   private boolean canGrind;
/*    */   RefEntity(int id, Class<? extends Entity> clazz, String name)
/*    */   {
/* 36 */     this(id, clazz, name, 80, 3);
/*    */   }
/*    */   
/*    */   RefEntity(int id, Class<? extends Entity> clazz, String name, int range, int updates) {
/* 40 */     this.entityClass = clazz;
/* 41 */     this.entityName = name;
/* 42 */     net.minecraftforge.fml.common.registry.EntityRegistry.registerModEntity(clazz, name, id, Intangible.INSTANCE, range, updates, true);
/*    */   }
/*    */   
/*    */   RefEntity setAutomationStats(boolean canCapture, boolean canSpawn, boolean canGrind) {
/* 46 */     this.canCapture = canCapture;
/* 47 */     this.canSpawn = canSpawn;
/* 48 */     this.canGrind = canGrind;
/* 49 */     return this;
/*    */   }
/*    */   
/*    */   RefEntity setEgg(int baseColor, int spotColor) {
/* 53 */     int eggID = getUniqueEggId();
/* 54 */     EntityList.field_75623_d.put(Integer.valueOf(eggID), this.entityClass);
/* 55 */     EntityList.field_75627_a.put(Integer.valueOf(eggID), new net.minecraft.entity.EntityList.EntityEggInfo(eggID, baseColor, spotColor));
/* 56 */     return this;
/*    */   }
/*    */   
/*    */ 
/*    */   @SideOnly(Side.CLIENT)
/*    */   final void preInit(Minecraft mc, RenderItem renderItem)
/*    */   {
/* 63 */     registerRenderFactory();
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   final void init(Minecraft mc, RenderItem renderItem) {
/* 68 */     List<Render> rendererList = new ArrayList();
/* 69 */     registerRenderer(mc.func_175598_ae(), rendererList);
/* 70 */     for (Render renderer : rendererList) {
/* 71 */       RenderingRegistry.registerEntityRenderingHandler(this.entityClass, renderer);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {}
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected void registerRenderFactory() {}
/*    */   
/*    */   void init() {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/RefEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */