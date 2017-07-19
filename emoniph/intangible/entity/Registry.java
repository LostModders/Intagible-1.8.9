/*    */ package emoniph.intangible.entity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.entity.RenderItem;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ class Registry
/*    */ {
/* 12 */   private final List<RefEntity> registeredEntities = new ArrayList();
/*    */   
/*    */   RefEntity add(RefEntity entityRef) {
/* 15 */     this.registeredEntities.add(entityRef);
/* 16 */     return entityRef;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void preInit(Minecraft mc, RenderItem renderItem) {
/* 21 */     for (RefEntity entityRef : this.registeredEntities) {
/* 22 */       entityRef.preInit(mc, renderItem);
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void init(Minecraft mc, RenderItem renderItem) {
/* 28 */     for (RefEntity entityRef : this.registeredEntities) {
/* 29 */       entityRef.init(mc, renderItem);
/*    */     }
/*    */   }
/*    */   
/*    */   public void init() {
/* 34 */     for (RefEntity entityRef : this.registeredEntities) {
/* 35 */       entityRef.init();
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/Registry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */