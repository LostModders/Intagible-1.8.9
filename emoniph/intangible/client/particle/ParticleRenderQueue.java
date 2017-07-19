/*    */ package emoniph.intangible.client.particle;
/*    */ 
/*    */ import java.util.ArrayDeque;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Queue;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.WorldRenderer;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ParticleRenderQueue
/*    */ {
/* 21 */   public static final ParticleRenderQueue INSTANCE = new ParticleRenderQueue();
/*    */   
/*    */   private class RenderQueue {
/* 24 */     final Queue<IBatchParticle> queue = new ArrayDeque();
/*    */     final ResourceLocation texture;
/*    */     
/*    */     RenderQueue(IBatchParticle particle) {
/* 28 */       this.texture = particle.getTextureLocation();
/*    */     }
/*    */   }
/*    */   
/* 32 */   private static HashMap<Class, RenderQueue> renderJobs = new HashMap();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public void enqueue(IBatchParticle particle)
/*    */   {
/* 39 */     RenderQueue queue = (RenderQueue)renderJobs.get(particle.getClass());
/* 40 */     if (queue == null) {
/* 41 */       queue = new RenderQueue(particle);
/* 42 */       renderJobs.put(particle.getClass(), queue);
/*    */     }
/* 44 */     queue.queue.add(particle);
/*    */   }
/*    */   
/*    */   public static void render() {
/* 48 */     boolean isLightingEnabled = GL11.glGetBoolean(2896);
/*    */     
/* 50 */     GlStateManager.func_179132_a(false);
/* 51 */     GlStateManager.func_179147_l();
/*    */     
/* 53 */     GlStateManager.func_179112_b(770, 1);
/* 54 */     GlStateManager.func_179092_a(516, 0.003921569F);
/* 55 */     if (isLightingEnabled) {
/* 56 */       GlStateManager.func_179140_f();
/*    */     }
/*    */     
/* 59 */     Tessellator tessellator = Tessellator.func_178181_a();
/*    */     
/* 61 */     for (Map.Entry<Class, RenderQueue> entry : renderJobs.entrySet()) {
/* 62 */       RenderQueue renderQueue = (RenderQueue)entry.getValue();
/* 63 */       if (!renderQueue.queue.isEmpty())
/*    */       {
/* 65 */         Minecraft.func_71410_x().field_71446_o.func_110577_a(renderQueue.texture);
/* 66 */         WorldRenderer renderer = tessellator.func_178180_c();
/* 67 */         renderer.func_181668_a(7, DefaultVertexFormats.field_181704_d);
/* 68 */         for (IBatchParticle glow : renderQueue.queue) {
/* 69 */           if (glow.isParticleAlive()) {
/* 70 */             glow.renderParticle(renderer);
/*    */           }
/*    */         }
/* 73 */         tessellator.func_78381_a();
/*    */         
/* 75 */         ((RenderQueue)entry.getValue()).queue.clear();
/*    */       }
/*    */     }
/*    */     
/* 79 */     if (isLightingEnabled) {
/* 80 */       GlStateManager.func_179145_e();
/*    */     }
/*    */     
/* 83 */     GlStateManager.func_179092_a(516, 0.1F);
/* 84 */     GlStateManager.func_179084_k();
/* 85 */     GlStateManager.func_179132_a(true);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/particle/ParticleRenderQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */