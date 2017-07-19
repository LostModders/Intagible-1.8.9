/*     */ package emoniph.intangible.client.particle;
/*     */ 
/*     */ import emoniph.intangible.IGlow;
/*     */ import java.util.Random;
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.client.renderer.ActiveRenderInfo;
/*     */ import net.minecraft.client.renderer.WorldRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityGlowFX
/*     */   extends EntityFX implements IBatchParticle, IGlow
/*     */ {
/*  19 */   private float accelerationX = 0.0F; private float accelerationZ = 0.0F; private float dampening = 0.9999F;
/*     */   
/*     */   public EntityGlowFX(World worldIn, double x, double y, double z, double offset) {
/*  22 */     super(worldIn, offsetCoord(x, offset, worldIn), offsetCoord(y, offset, worldIn), offsetCoord(z, offset, worldIn));
/*  23 */     this.field_70159_w = (this.field_70181_x = this.field_70179_y = 0.0D);
/*  24 */     this.field_70145_X = true;
/*  25 */     func_70105_a(0.01F, 0.01F);
/*     */     
/*     */ 
/*     */ 
/*  29 */     this.field_70169_q = this.field_70165_t;
/*  30 */     this.field_70167_r = this.field_70163_u;
/*  31 */     this.field_70166_s = this.field_70161_v;
/*  32 */     this.field_82339_as = 0.9F;
/*     */     
/*  34 */     this.field_70545_g = 0.0F;
/*     */     
/*     */ 
/*  37 */     float MIN_AGE_TICKS = 2.0F;
/*  38 */     this.field_70547_e = ((int)(2.0F / (this.field_70146_Z.nextFloat() * 0.9F + 0.1F)));
/*     */   }
/*     */   
/*     */   private static double offsetCoord(double coord, double offset, World world) {
/*  42 */     if (offset > 0.0D) {
/*  43 */       coord = coord - offset + world.field_73012_v.nextDouble() * 2.0D * offset;
/*     */     }
/*     */     
/*  46 */     return coord;
/*     */   }
/*     */   
/*     */   public IGlow motion(double x, double y, double z)
/*     */   {
/*  51 */     this.field_70159_w = x;
/*  52 */     this.field_70181_x = y;
/*  53 */     this.field_70179_y = z;
/*  54 */     return this;
/*     */   }
/*     */   
/*     */   public IGlow acceleration(float x, float y, float z)
/*     */   {
/*  59 */     this.field_70545_g = y;
/*  60 */     this.accelerationX = x;
/*  61 */     this.accelerationZ = z;
/*  62 */     return this;
/*     */   }
/*     */   
/*     */   public IGlow color(int color)
/*     */   {
/*  67 */     float r = (color >> 16 & 0xFF) / 256.0F;
/*  68 */     float g = (color >> 8 & 0xFF) / 256.0F;
/*  69 */     float b = (color & 0xFF) / 256.0F;
/*  70 */     return color(r, g, b);
/*     */   }
/*     */   
/*     */   public IGlow color(int color, int variation)
/*     */   {
/*  75 */     float r = (color >> 16 & 0xFF) / 256.0F;
/*  76 */     float g = (color >> 8 & 0xFF) / 256.0F;
/*  77 */     float b = (color & 0xFF) / 256.0F;
/*  78 */     return color(r, g, b, variation / 256.0F);
/*     */   }
/*     */   
/*     */   public IGlow color(float r, float g, float b)
/*     */   {
/*  83 */     func_70538_b(r, g, b);
/*  84 */     return this;
/*     */   }
/*     */   
/*     */   public IGlow color(float r, float g, float b, float variation)
/*     */   {
/*  89 */     r = MathHelper.func_76131_a(r - variation + this.field_70146_Z.nextFloat() * 2.0F * variation, 0.0F, 1.0F);
/*  90 */     g = MathHelper.func_76131_a(g - variation + this.field_70146_Z.nextFloat() * 2.0F * variation, 0.0F, 1.0F);
/*  91 */     b = MathHelper.func_76131_a(b - variation + this.field_70146_Z.nextFloat() * 2.0F * variation, 0.0F, 1.0F);
/*     */     
/*  93 */     return color(r, g, b);
/*     */   }
/*     */   
/*     */   public IGlow scaleExact(float scale)
/*     */   {
/*  98 */     this.field_70544_f = scale;
/*  99 */     return this;
/*     */   }
/*     */   
/*     */   public IGlow scale(float scaleFactor)
/*     */   {
/* 104 */     this.field_70544_f *= scaleFactor;
/* 105 */     return this;
/*     */   }
/*     */   
/*     */   public IGlow duration(int ticks)
/*     */   {
/* 110 */     this.field_70547_e = ticks;
/* 111 */     return this;
/*     */   }
/*     */   
/*     */   public IGlow durationScale(float scale)
/*     */   {
/* 116 */     return duration((int)(28.0D / (Math.random() * 0.1D + 0.9D) * scale));
/*     */   }
/*     */   
/*     */   public IGlow dampening(float dampening)
/*     */   {
/* 121 */     this.dampening = dampening;
/* 122 */     return this;
/*     */   }
/*     */   
/*     */   public int func_70537_b()
/*     */   {
/* 127 */     return 3;
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/* 132 */     if ((!this.field_70170_p.field_72995_K) || (this.field_70546_d++ >= this.field_70547_e) || (this.field_70163_u > 255.0D) || (this.field_70163_u < 0.0D)) {
/* 133 */       func_70106_y();
/*     */     } else {
/* 135 */       this.field_70169_q = this.field_70165_t;
/* 136 */       this.field_70167_r = this.field_70163_u;
/* 137 */       this.field_70166_s = this.field_70161_v;
/*     */       
/* 139 */       this.field_70181_x -= 0.04D * this.field_70545_g;
/* 140 */       this.field_70159_w -= 0.04D * this.accelerationX;
/* 141 */       this.field_70179_y -= 0.04D * this.accelerationZ;
/*     */       
/* 143 */       double px = this.field_70165_t + this.field_70159_w;
/* 144 */       double py = this.field_70163_u + this.field_70181_x;
/* 145 */       double pz = this.field_70161_v + this.field_70179_y;
/* 146 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 147 */       this.field_70165_t = px;
/* 148 */       this.field_70163_u = py;
/* 149 */       this.field_70161_v = pz;
/*     */       
/*     */ 
/* 152 */       this.field_70159_w *= this.dampening;
/* 153 */       this.field_70181_x *= this.dampening;
/* 154 */       this.field_70179_y *= this.dampening;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isParticleAlive()
/*     */   {
/* 160 */     return func_70089_S();
/*     */   }
/*     */   
/* 163 */   private static final ResourceLocation particles = new ResourceLocation("intangible", "textures/particles/glow.png");
/*     */   private float renderPartialTicks;
/*     */   
/*     */   public ResourceLocation getTextureLocation() {
/* 167 */     return particles;
/*     */   }
/*     */   
/*     */   private float renderRotX;
/*     */   private float renderRotXZ;
/*     */   private float renderRotZ;
/*     */   private float renderRotYZ;
/*     */   private float renderRotXY;
/*     */   public void renderParticle(WorldRenderer renderer) {
/* 176 */     float scale = 0.1F * this.field_70544_f;
/* 177 */     float renderX = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * this.renderPartialTicks - field_70556_an);
/* 178 */     float renderY = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * this.renderPartialTicks - field_70554_ao);
/* 179 */     float renderZ = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * this.renderPartialTicks - field_70555_ap);
/*     */     
/* 181 */     int i = func_70070_b(this.renderPartialTicks);
/* 182 */     int j = i >> 16 & 0xFFFF;
/* 183 */     int k = i & 0xFFFF;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 188 */     renderer.func_181662_b(renderX - this.renderRotX * scale - this.renderRotYZ * scale, renderY - this.renderRotXZ * scale, renderZ - this.renderRotZ * scale - this.renderRotXY * scale)
/* 189 */       .func_181673_a(0.0D, 1.0D)
/*     */       
/* 191 */       .func_181666_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 0.5F)
/* 192 */       .func_181671_a(j, k)
/* 193 */       .func_181675_d();
/*     */     
/* 195 */     renderer.func_181662_b(renderX - this.renderRotX * scale + this.renderRotYZ * scale, renderY + this.renderRotXZ * scale, renderZ - this.renderRotZ * scale + this.renderRotXY * scale)
/* 196 */       .func_181673_a(1.0D, 1.0D)
/* 197 */       .func_181666_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 0.5F)
/* 198 */       .func_181671_a(j, k)
/*     */       
/* 200 */       .func_181675_d();
/*     */     
/* 202 */     renderer.func_181662_b(renderX + this.renderRotX * scale + this.renderRotYZ * scale, renderY + this.renderRotXZ * scale, renderZ + this.renderRotZ * scale + this.renderRotXY * scale)
/* 203 */       .func_181673_a(1.0D, 0.0D)
/* 204 */       .func_181666_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 0.5F)
/* 205 */       .func_181671_a(j, k)
/*     */       
/*     */ 
/* 208 */       .func_181675_d();
/*     */     
/* 210 */     renderer.func_181662_b(renderX + this.renderRotX * scale - this.renderRotYZ * scale, renderY - this.renderRotXZ * scale, renderZ + this.renderRotZ * scale - this.renderRotXY * scale)
/* 211 */       .func_181673_a(0.0D, 0.0D)
/* 212 */       .func_181666_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, 0.5F)
/* 213 */       .func_181671_a(j, k)
/*     */       
/* 215 */       .func_181675_d();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void func_180434_a(WorldRenderer worldRenderer, Entity entity, float partialTicks, float rotationX, float rotationXZ, float rotationZ, float rotationYZ, float rotationXY)
/*     */   {
/* 223 */     if (func_70089_S()) {
/* 224 */       this.renderPartialTicks = partialTicks;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 231 */       this.renderRotX = ActiveRenderInfo.func_178808_b();
/* 232 */       this.renderRotXZ = ActiveRenderInfo.func_178809_c();
/* 233 */       this.renderRotZ = ActiveRenderInfo.func_178803_d();
/* 234 */       this.renderRotYZ = ActiveRenderInfo.func_178805_e();
/* 235 */       this.renderRotXY = ActiveRenderInfo.func_178807_f();
/*     */       
/* 237 */       ParticleRenderQueue.INSTANCE.enqueue(this);
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/particle/EntityGlowFX.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */