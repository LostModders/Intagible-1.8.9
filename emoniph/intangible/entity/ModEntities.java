/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.client.renderer.RenderKnowledgeGem;
/*     */ import emoniph.intangible.client.renderer.RenderSpell;
/*     */ import emoniph.intangible.init.IModInitClient;
/*     */ import emoniph.intangible.init.IModPreInitClient;
/*     */ import java.util.List;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderFallingBlock;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.client.registry.IRenderFactory;
/*     */ import net.minecraftforge.fml.client.registry.RenderingRegistry;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ModEntities implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModInit, IModPreInitClient, IModInitClient
/*     */ {
/*  22 */   private final Registry registry = new Registry();
/*     */   
/*  24 */   public final RefEntity SPELL = this.registry.add(new RefEntity(1, EntitySpell.class, "spell") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  26 */       rendererList.add(new RenderSpell(renderManager, 0.5F));
/*     */     }
/*  24 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  30 */   public final RefEntity SEEKER = this.registry.add(new RefEntity(2, EntitySeeker.class, "seeker") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  32 */       rendererList.add(new emoniph.intangible.client.renderer.RenderSeeker(renderManager, 0.5F));
/*     */     }
/*  30 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  36 */   public final RefEntity AVATAR = this.registry.add(new RefEntity(3, EntityAvatar.class, "avatarbiped") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  38 */       rendererList.add(new emoniph.intangible.client.renderer.RenderDeityAvatar(renderManager));
/*     */     }
/*  36 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  42 */   public final RefEntity SOUL = this.registry.add(new RefEntity(4, EntitySoul.class, "soul") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  44 */       rendererList.add(new emoniph.intangible.client.renderer.RenderSoul(renderManager));
/*     */     }
/*  42 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  48 */   public final RefEntity KNOWLEDGE_GEM = this.registry.add(new RefEntity(5, EntityKnowledgeGem.class, "knowledgegem") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  50 */       rendererList.add(new RenderKnowledgeGem(renderManager));
/*     */     }
/*  48 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  54 */   public final RefEntity RAISING_BLOCK = this.registry.add(new RefEntity(6, EntityRaisingBlock.class, "raisingblock", 160, 20)
/*     */   {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  57 */       rendererList.add(new RenderFallingBlock(renderManager));
/*     */     }
/*  54 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  61 */   public final RefEntity GOLEM = this.registry.add(new RefEntity(7, EntityEarthGolem.class, "earthgolem") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  63 */       rendererList.add(new emoniph.intangible.client.renderer.RenderEarthGolem(renderManager));
/*     */     }
/*  61 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  67 */   public final RefEntity SPIDER = this.registry.add(new RefEntity(8, EntitySpiderBlock.class, "spiderblock") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  69 */       rendererList.add(new emoniph.intangible.client.renderer.RenderSpiderBlock(renderManager));
/*     */     }
/*  67 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  73 */   public final RefEntity WRECKING_GOLEM = this.registry.add(new RefEntity(9, EntityWreckingGolem.class, "wreckinggolem") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  75 */       rendererList.add(new emoniph.intangible.client.renderer.RenderWreckingGolem(renderManager));
/*     */     }
/*  73 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  79 */   public final RefEntity PIG_VILLAGER = this.registry.add(new RefEntity(10, EntityPigVillager.class, "pigvillager") {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  81 */       rendererList.add(new emoniph.intangible.client.renderer.RenderPigVillager(renderManager));
/*     */     }
/*  79 */   })
/*     */   
/*     */ 
/*     */ 
/*  83 */     .setEgg(4468520, 15636891);
/*     */   
/*  85 */   public final RefEntity SPIKE_BALL = this.registry.add(new RefEntity(11, EntitySpikeBall.class, "spikeball")
/*     */   {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  88 */       rendererList.add(new emoniph.intangible.client.renderer.RenderSpikeBall(renderManager));
/*     */     }
/*  85 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  92 */   public final RefEntity HOLLOW_IRON_GOLEM = this.registry.add(new RefEntity(12, EntityHollowIronGolem.class, "hollowirongolem")
/*     */   {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/*  95 */       rendererList.add(new emoniph.intangible.client.renderer.RenderHollowGolem(renderManager));
/*     */     }
/*  92 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  99 */   public final RefEntity SKY_BEAM = this.registry.add(new RefEntity(13, EntitySkyBeam.class, "skybeam")
/*     */   {
/*     */     protected void registerRenderer(RenderManager renderManager, List<Render> rendererList) {
/* 102 */       rendererList.add(new emoniph.intangible.client.renderer.RenderSkyBeam(renderManager));
/*     */     }
/*  99 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 106 */   public final RefEntity SPELL_ANCHOR = this.registry.add(new RefEntity(14, EntitySpellAnchor.class, "spellanchor")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 110 */       RenderingRegistry.registerEntityRenderingHandler(EntitySpellAnchor.class, new IRenderFactory() {
/*     */         public Render<EntitySpellAnchor> createRenderFor(RenderManager manager) {
/* 112 */           return new emoniph.intangible.client.renderer.RenderSpellAnchor(manager, 1.0F);
/*     */         }
/*     */       });
/*     */     }
/* 106 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 118 */   public final RefEntity CLONE = this.registry.add(new RefEntity(15, EntityClone.class, "clone")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 122 */       RenderingRegistry.registerEntityRenderingHandler(EntityClone.class, new IRenderFactory() {
/*     */         public Render<EntityClone> createRenderFor(RenderManager manager) {
/* 124 */           return new emoniph.intangible.client.renderer.RenderClone(manager);
/*     */         }
/*     */       });
/*     */     }
/* 118 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 130 */   public final RefEntity REAPER = this.registry.add(new RefEntity(16, EntityReaper.class, "reaper")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 134 */       RenderingRegistry.registerEntityRenderingHandler(EntityReaper.class, new IRenderFactory() {
/*     */         public Render<EntityReaper> createRenderFor(RenderManager manager) {
/* 136 */           return new emoniph.intangible.client.renderer.RenderReaper(manager);
/*     */         }
/*     */       });
/*     */     }
/* 130 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 142 */   public final RefEntity TOOL = this.registry.add(new RefEntity(17, EntityTool.class, "tool")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 146 */       RenderingRegistry.registerEntityRenderingHandler(EntityTool.class, new IRenderFactory() {
/*     */         public Render<EntityTool> createRenderFor(RenderManager manager) {
/* 148 */           return new emoniph.intangible.client.renderer.RenderTool(manager);
/*     */         }
/*     */       });
/*     */     }
/* 142 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 154 */   public final RefEntity CHARIOT = this.registry.add(new RefEntity(18, EntityChariot.class, "chariot")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 158 */       RenderingRegistry.registerEntityRenderingHandler(EntityChariot.class, new IRenderFactory() {
/*     */         public Render<EntityChariot> createRenderFor(RenderManager manager) {
/* 160 */           return new emoniph.intangible.client.renderer.RenderChariot(manager);
/*     */         }
/*     */       });
/*     */     }
/* 154 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 166 */   public final RefEntity JAVELIN = this.registry.add(new RefEntity(19, EntityJavelin.class, "javelin")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 170 */       RenderingRegistry.registerEntityRenderingHandler(EntityJavelin.class, new IRenderFactory() {
/*     */         public Render<EntityJavelin> createRenderFor(RenderManager manager) {
/* 172 */           return new emoniph.intangible.client.renderer.RenderJavelin(manager);
/*     */         }
/*     */       });
/*     */     }
/* 166 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 178 */   public final RefEntity FOOD = this.registry.add(new RefEntity(20, EntityFood.class, "food")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 182 */       RenderingRegistry.registerEntityRenderingHandler(EntityFood.class, new IRenderFactory() {
/*     */         public Render<EntityFood> createRenderFor(RenderManager manager) {
/* 184 */           return new emoniph.intangible.client.renderer.RenderFood(manager);
/*     */         }
/*     */       });
/*     */     }
/* 178 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 190 */   public final RefEntity SEAT = this.registry.add(new RefEntity(21, EntitySeat.class, "seat")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 194 */       RenderingRegistry.registerEntityRenderingHandler(EntitySeat.class, new IRenderFactory() {
/*     */         public Render<EntitySeat> createRenderFor(RenderManager manager) {
/* 196 */           return new emoniph.intangible.client.renderer.RenderSeat(manager);
/*     */         }
/*     */       });
/*     */     }
/* 190 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 202 */   public final RefEntity THROWN_WEAPON = this.registry.add(new RefEntity(22, EntityThrownWeapon.class, "thrownweapon")
/*     */   {
/*     */     @SideOnly(Side.CLIENT)
/*     */     protected void registerRenderFactory() {
/* 206 */       RenderingRegistry.registerEntityRenderingHandler(EntityThrownWeapon.class, new IRenderFactory() {
/*     */         public Render<EntityThrownWeapon> createRenderFor(RenderManager manager) {
/* 208 */           return new emoniph.intangible.client.renderer.RenderThrownWeapon(manager);
/*     */         }
/*     */       });
/*     */     }
/* 202 */   });
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void init(FMLInitializationEvent event)
/*     */   {
/* 216 */     this.registry.init();
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void preInit(Minecraft mc)
/*     */   {
/* 222 */     this.registry.preInit(mc, mc.func_175599_af());
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void init(Minecraft mc, RenderItem renderItem)
/*     */   {
/* 228 */     this.registry.init(mc, renderItem);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/ModEntities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */