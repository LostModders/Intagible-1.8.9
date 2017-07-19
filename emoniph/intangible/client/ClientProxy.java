/*     */ package emoniph.intangible.client;
/*     */ 
/*     */ import emoniph.intangible.CommonProxy;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.Intangible;
/*     */ import emoniph.intangible.client.particle.EntityGlowFX;
/*     */ import emoniph.intangible.init.IModInitClient;
/*     */ import emoniph.intangible.init.IModPreInitClient;
/*     */ import emoniph.intangible.init.IModService;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.particle.EffectRenderer;
/*     */ import net.minecraft.client.renderer.texture.TextureManager;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.event.FMLInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.Sphere;
/*     */ 
/*     */ @net.minecraftforge.fml.relauncher.SideOnly(Side.CLIENT)
/*     */ public class ClientProxy extends CommonProxy
/*     */ {
/*     */   int sphereInnerID;
/*     */   int sphereOuterID;
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  37 */     super.preInit(event);
/*  38 */     Minecraft mc; if (event.getSide() == Side.CLIENT) {
/*  39 */       EventHandlers eventHandlers = new EventHandlers();
/*     */       
/*  41 */       net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(eventHandlers);
/*  42 */       mc = Minecraft.func_71410_x();
/*  43 */       for (IModService service : this.services) {
/*  44 */         if ((service instanceof IModPreInitClient)) {
/*  45 */           ((IModPreInitClient)service).preInit(mc);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getSphereInnerID()
/*     */   {
/*  58 */     return this.sphereInnerID;
/*     */   }
/*     */   
/*     */   public int getSphereOuterID() {
/*  62 */     return this.sphereOuterID;
/*     */   }
/*     */   
/*     */   public void init(FMLInitializationEvent event)
/*     */   {
/*  67 */     super.init(event);
/*     */     net.minecraft.client.renderer.entity.RenderItem renderItem;
/*  69 */     Minecraft mc; if (event.getSide() == Side.CLIENT) {
/*  70 */       renderItem = Minecraft.func_71410_x().func_175599_af();
/*  71 */       mc = Minecraft.func_71410_x();
/*  72 */       for (IModService service : this.services) {
/*  73 */         if ((service instanceof IModInitClient)) {
/*  74 */           ((IModInitClient)service).init(mc, renderItem);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  82 */     this.sphereOuterID = createPreRenderedSphere(100020, new ResourceLocation("intangible:textures/entity/bubble.png"));
/*  83 */     this.sphereInnerID = createPreRenderedSphere(100021, new ResourceLocation("intangible:textures/entity/bubble.png"));
/*     */   }
/*     */   
/*     */   public void serverStarting(FMLServerStartingEvent event)
/*     */   {
/*  88 */     super.serverStarting(event);
/*     */   }
/*     */   
/*     */ 
/*     */   private int createPreRenderedSphere(int orientation, ResourceLocation texture)
/*     */   {
/*  94 */     Sphere sphere = new Sphere();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*  99 */     sphere.setDrawStyle(100012);
/*     */     
/*     */ 
/*     */ 
/* 103 */     sphere.setNormals(100000);
/*     */     
/* 105 */     sphere.setOrientation(orientation);
/*     */     
/* 107 */     sphere.setTextureFlag(true);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 114 */     int result = GL11.glGenLists(1);
/*     */     
/*     */ 
/*     */ 
/* 118 */     GL11.glNewList(result, 4864);
/* 119 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(texture);
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 125 */     sphere.draw(0.5F, 16, 16);
/*     */     
/*     */ 
/* 128 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(net.minecraft.client.renderer.texture.TextureMap.field_110575_b);
/* 129 */     GL11.glEndList();
/*     */     
/* 131 */     return result;
/*     */   }
/*     */   
/*     */   public EntityPlayer getPlayer(MessageContext ctx)
/*     */   {
/* 136 */     if (ctx.side == Side.CLIENT) {
/* 137 */       return Minecraft.func_71410_x().field_71439_g;
/*     */     }
/* 139 */     return super.getPlayer(ctx);
/*     */   }
/*     */   
/*     */ 
/*     */   public World getWorldForDimension(int dimensionId)
/*     */   {
/* 145 */     return Minecraft.func_71410_x().field_71441_e.field_73011_w.func_177502_q() == dimensionId ? Minecraft.func_71410_x().field_71441_e : null;
/*     */   }
/*     */   
/*     */   public float getPartialTicks()
/*     */   {
/* 150 */     return Minecraft.func_71410_x().field_71428_T.field_74281_c;
/*     */   }
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
/*     */   public IGlow glow(World world, double x, double y, double z)
/*     */   {
/* 176 */     return glow(world, x, y, z, 0.0D);
/*     */   }
/*     */   
/*     */   public IGlow glow(World world, BlockPos pos)
/*     */   {
/* 181 */     return glow(world, pos, 0.0D);
/*     */   }
/*     */   
/*     */   public IGlow glow(World world, BlockPos pos, double offset)
/*     */   {
/* 186 */     return glow(world, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, offset);
/*     */   }
/*     */   
/*     */   public IGlow glow(World world, double x, double y, double z, double offset)
/*     */   {
/* 191 */     EntityGlowFX glow = new EntityGlowFX(world, x, y, z, offset);
/* 192 */     Minecraft.func_71410_x().field_71452_i.func_78873_a(glow);
/* 193 */     return glow;
/*     */   }
/*     */   
/*     */   public void knolFX(World world, Vec3 start, EntityPlayer player)
/*     */   {
/* 198 */     Minecraft.func_71410_x().field_71452_i.func_78873_a(new emoniph.intangible.client.particle.EntityKnowledgeFX(world, start, player));
/*     */   }
/*     */   
/*     */   public void queue(MessageContext ctx, Runnable runnable)
/*     */   {
/* 203 */     Minecraft.func_71410_x().func_152344_a(runnable);
/*     */   }
/*     */   
/*     */   public void highlightPlayerSoul(EntityPlayer playerToHighlight)
/*     */   {
/* 208 */     Minecraft mc = Minecraft.func_71410_x();
/* 209 */     EntityPlayer us = Minecraft.func_71410_x().field_71439_g;
/* 210 */     if ((PlayerEx.get(us).isKnowledgeLearnt(new emoniph.intangible.api.IKnol[] { emoniph.intangible.Get.knowledge().SOULS })) && ((us != playerToHighlight) || ((mc.field_71474_y.field_74320_O != 0) && (!mc.field_71474_y.field_74319_N) && 
/* 211 */       (!emoniph.intangible.util.GuiUtil.isMousePointerActive()) && (!mc.field_71442_b.func_78747_a()))))
/*     */     {
/*     */ 
/*     */ 
/* 215 */       Intangible.PROXY.glow(playerToHighlight.field_70170_p, playerToHighlight.field_70169_q + playerToHighlight.field_70159_w, playerToHighlight.field_70163_u + 0.5D + playerToHighlight.field_70181_x, playerToHighlight.field_70166_s + playerToHighlight.field_70179_y, 0.10000000149011612D).color(295278950, 32).duration(2).scaleExact(playerToHighlight.field_70170_p.field_73012_v.nextFloat() * 0.6F + 0.8F).motion(playerToHighlight.field_70159_w, playerToHighlight.field_70181_x, playerToHighlight.field_70179_y);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/ClientProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */