/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerEx.PacketSyncToServer;
/*     */ import emoniph.intangible.player.PlayerEx.PacketSyncToServer.SyncProp;
/*     */ import emoniph.intangible.util.Point2d;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntityKnowledgeGem extends EntityLiving implements IDissolve, emoniph.intangible.souls.ISoulHost
/*     */ {
/*  29 */   private int xTile = -1;
/*  30 */   private int yTile = -1;
/*  31 */   private int zTile = -1;
/*     */   private Block inTile;
/*     */   protected boolean inGround;
/*     */   private EntityLivingBase thrower;
/*     */   private String throwerName;
/*     */   private int ticksInGround;
/*     */   private int ticksInAir;
/*     */   public static final int MAX_DISSOLVE_TICKS = 10;
/*     */   
/*  40 */   public EntityKnowledgeGem(World worldIn) { super(worldIn);
/*  41 */     func_70105_a(2.0F, 2.0F);
/*     */     
/*  43 */     this.field_70728_aV = 0;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M()
/*     */   {
/*  48 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_145773_az()
/*     */   {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   protected void func_110147_ax() {
/*  57 */     super.func_110147_ax();
/*     */   }
/*     */   
/*     */   public boolean shouldRenderInPass(int pass)
/*     */   {
/*  62 */     return pass == 1;
/*     */   }
/*     */   
/*     */   public EntityKnowledgeGem(World worldIn, EntityLivingBase throwerIn) {
/*  66 */     super(worldIn);
/*  67 */     this.field_70145_X = false;
/*  68 */     this.thrower = throwerIn;
/*  69 */     func_70105_a(2.0F, 2.0F);
/*  70 */     func_70012_b(throwerIn.field_70165_t, throwerIn.field_70163_u + throwerIn.func_70047_e(), throwerIn.field_70161_v, throwerIn.field_70177_z, throwerIn.field_70125_A);
/*  71 */     this.field_70165_t -= MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  72 */     this.field_70163_u -= 0.10000000149011612D;
/*  73 */     this.field_70161_v -= MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F;
/*  74 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  75 */     float f = 0.4F;
/*  76 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  77 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  78 */     this.field_70181_x = (-MathHelper.func_76126_a((this.field_70125_A + getInaccuracy()) / 180.0F * 3.1415927F) * f);
/*  79 */     setThrowableHeading(this.field_70159_w, this.field_70181_x, this.field_70179_y, getVelocity(), 1.0F);
/*     */   }
/*     */   
/*     */   public EntityKnowledgeGem(World worldIn, double x, double y, double p_i1778_6_) {
/*  83 */     super(worldIn);
/*  84 */     this.ticksInGround = 0;
/*  85 */     func_70105_a(0.25F, 0.25F);
/*  86 */     func_70107_b(x, y, p_i1778_6_);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void dissolve()
/*     */   {
/*  94 */     setDissolveTicks(10);
/*     */   }
/*     */   
/*     */   public emoniph.intangible.api.SoulType getSoulType()
/*     */   {
/*  99 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isTrappableInBoneCage()
/*     */   {
/* 104 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/* 109 */   public boolean isCorporeal() { return false; }
/*     */   
/*     */   public static class Button {
/*     */     float x;
/*     */     float y;
/*     */     int width;
/*     */     int height;
/*     */     String link;
/*     */     
/* 118 */     public Button(String link) { this.link = link; }
/*     */     
/*     */     public Button setBounds(int x, int y, int width, int height)
/*     */     {
/* 122 */       this.x = x;
/* 123 */       this.y = y;
/* 124 */       this.width = width;
/* 125 */       this.height = height;
/* 126 */       return this;
/*     */     }
/*     */     
/*     */     public boolean contains(Point2d point) {
/* 130 */       return (point.x >= this.x) && (point.x <= this.x + this.width) && (point.y >= this.y) && (point.y <= this.y + this.height);
/*     */     }
/*     */     
/*     */     public void click(EntityPlayer player, Point2d point, EntityKnowledgeGem gem) {
/* 134 */       if (player.field_70170_p.field_72995_K) {
/* 135 */         player.func_85030_a("gui.button.press", 0.2F, 1.0F);
/* 136 */         PlayerEx playerEx = PlayerEx.get(player);
/* 137 */         if (this.link.equals("navigate:up")) {
/* 138 */           playerEx.getBookNavigator().goUp(playerEx.getLearning());
/* 139 */           Get.pipeline().sendToServer(new PlayerEx.PacketSyncToServer(playerEx, PlayerEx.PacketSyncToServer.SyncProp.book));
/* 140 */         } else if (this.link.equals("navigate:back")) {
/* 141 */           playerEx.getBookNavigator().goBack(playerEx.getLearning());
/* 142 */           Get.pipeline().sendToServer(new PlayerEx.PacketSyncToServer(playerEx, PlayerEx.PacketSyncToServer.SyncProp.book));
/* 143 */         } else if (this.link.equals("navigate:close")) {
/* 144 */           Get.pipeline().sendToServer(new emoniph.intangible.player.PlayerEx.PacketEntityLivingAction(gem, emoniph.intangible.player.PlayerEx.PacketEntityLivingAction.Action.DISSOLVE));
/*     */         } else {
/* 146 */           playerEx.getBookNavigator().goToPage(this.link, playerEx.getLearning());
/* 147 */           Get.pipeline().sendToServer(new PlayerEx.PacketSyncToServer(playerEx, PlayerEx.PacketSyncToServer.SyncProp.book));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public void draw(RenderManager renderManager, Point2d pointer) {}
/*     */   }
/*     */   
/*     */   public static class ImageButton extends EntityKnowledgeGem.Button {
/*     */     final ResourceLocation texture;
/*     */     final int u;
/*     */     final int v;
/*     */     final int uHot;
/*     */     final int vHot;
/*     */     
/* 163 */     public ImageButton(int x, int y, int width, int height, ResourceLocation texture, int u, int v, int uHot, int vHot, String link) { super();
/* 164 */       setBounds(x, y, width, height);
/* 165 */       this.texture = texture;
/* 166 */       this.u = u;
/* 167 */       this.v = v;
/* 168 */       this.uHot = uHot;
/* 169 */       this.vHot = vHot;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public void draw(RenderManager renderManager, Point2d pointer) {
/* 174 */       net.minecraft.client.renderer.GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 0.3F);
/* 175 */       renderManager.field_78724_e.func_110577_a(this.texture);
/* 176 */       boolean hot = contains(pointer);
/* 177 */       emoniph.intangible.util.RenderUtil.drawScaledCustomSizeModalRect(this.x, this.y, hot ? this.uHot : this.u, hot ? this.vHot : this.v, this.width, this.height, this.width, this.height, 256.0F, 256.0F);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/* 182 */   private List<Button> buttons = new java.util.ArrayList();
/*     */   public static final int backWidth = 222;
/*     */   
/* 185 */   public void clearButtons() { this.buttons.clear(); }
/*     */   
/*     */   public void addButton(Button button)
/*     */   {
/* 189 */     this.buttons.add(button);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void drawButtons(RenderManager renderManager, Point2d pointer) {
/* 194 */     for (Button button : this.buttons) {
/* 195 */       button.draw(renderManager, pointer);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean func_70085_c(EntityPlayer playerIn)
/*     */   {
/*     */     Point2d pointer;
/*     */     
/* 204 */     if (this.field_70170_p.field_72995_K) {
/* 205 */       pointer = getPointer(playerIn);
/* 206 */       for (Button button : this.buttons) {
/* 207 */         if (button.contains(pointer)) {
/* 208 */           button.click(playerIn, pointer, this);
/* 209 */           break;
/*     */         }
/*     */       }
/*     */     }
/* 213 */     return true;
/*     */   }
/*     */   
/*     */   public Point2d getPointer(EntityPlayer playerIn) {
/* 217 */     double reach = playerIn.func_70011_f(this.field_70165_t, playerIn.field_70163_u, this.field_70161_v);
/*     */     
/* 219 */     double dX = playerIn.field_70165_t - this.field_70165_t;
/* 220 */     double dZ = playerIn.field_70161_v - this.field_70161_v;
/* 221 */     double angle = Math.atan2(dX, dZ);
/*     */     
/* 223 */     double dx = -Math.sin(Math.toRadians(playerIn.field_70759_as) + angle) * reach;
/* 224 */     double dy = Math.tan(Math.toRadians(playerIn.field_70125_A)) * Math.sqrt(reach * reach - dx * dx);
/*     */     
/* 226 */     float wscale = this.field_70130_N / 222.0F;
/* 227 */     float hscale = this.field_70131_O / 221.0F;
/*     */     
/* 229 */     double pointerX = (dx + this.field_70130_N / 2.0D) / wscale;
/* 230 */     double pointerY = (dy + (this.field_70163_u + this.field_70131_O - (playerIn.field_70163_u + playerIn.func_70047_e()))) / hscale;
/*     */     
/* 232 */     return new Point2d(pointerX, pointerY);
/*     */   }
/*     */   
/*     */   protected void func_70088_a()
/*     */   {
/* 237 */     super.func_70088_a();
/* 238 */     this.field_70180_af.func_75682_a(16, Integer.valueOf(-1));
/*     */   }
/*     */   
/*     */   private void setDissolveTicks(int ticks) {
/* 242 */     this.field_70180_af.func_75692_b(16, Integer.valueOf(ticks));
/*     */   }
/*     */   
/*     */   public int getDisolveTicks() {
/* 246 */     return this.field_70180_af.func_75679_c(16);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double distance)
/*     */   {
/* 252 */     double d1 = func_174813_aQ().func_72320_b() * 4.0D;
/* 253 */     d1 *= 64.0D;
/* 254 */     return distance < d1 * d1;
/*     */   }
/*     */   
/*     */   protected float getGravityVelocity() {
/* 258 */     return 0.0F;
/*     */   }
/*     */   
/*     */   protected float getVelocity() {
/* 262 */     return 0.5F;
/*     */   }
/*     */   
/*     */   protected float getInaccuracy() {
/* 266 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy) {
/* 270 */     float f2 = MathHelper.func_76133_a(x * x + y * y + z * z);
/* 271 */     x /= f2;
/* 272 */     y /= f2;
/* 273 */     z /= f2;
/* 274 */     x += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * inaccuracy;
/* 275 */     y += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * inaccuracy;
/* 276 */     z += this.field_70146_Z.nextGaussian() * 0.007499999832361937D * inaccuracy;
/* 277 */     x *= velocity;
/* 278 */     y *= velocity;
/* 279 */     z *= velocity;
/* 280 */     this.field_70159_w = x;
/* 281 */     this.field_70181_x = y;
/* 282 */     this.field_70179_y = z;
/* 283 */     float f3 = MathHelper.func_76133_a(x * x + z * z);
/* 284 */     this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(x, z) * 180.0D / 3.141592653589793D));
/* 285 */     this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(y, f3) * 180.0D / 3.141592653589793D));
/* 286 */     this.ticksInGround = 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double x, double y, double z)
/*     */   {
/* 292 */     this.field_70159_w = x;
/* 293 */     this.field_70181_x = y;
/* 294 */     this.field_70179_y = z;
/*     */     
/* 296 */     if ((this.field_70127_C == 0.0F) && (this.field_70126_B == 0.0F)) {
/* 297 */       float f = MathHelper.func_76133_a(x * x + z * z);
/* 298 */       this.field_70126_B = (this.field_70177_z = (float)(Math.atan2(x, z) * 180.0D / 3.141592653589793D));
/* 299 */       this.field_70127_C = (this.field_70125_A = (float)(Math.atan2(y, f) * 180.0D / 3.141592653589793D));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/* 305 */     int dissolveTicks = getDisolveTicks();
/* 306 */     if (dissolveTicks > 0) {
/* 307 */       if (!this.field_70170_p.field_72995_K) {
/* 308 */         dissolveTicks--;
/* 309 */         setDissolveTicks(dissolveTicks);
/*     */       }
/* 311 */     } else if (dissolveTicks == 0) {
/* 312 */       if (!this.field_70170_p.field_72995_K) {
/* 313 */         func_70106_y();
/*     */       }
/*     */     }
/* 316 */     else if ((dissolveTicks == -1) && 
/* 317 */       (!this.field_70170_p.field_72995_K) && 
/* 318 */       (this.field_70170_p.func_72872_a(EntityPlayer.class, func_174813_aQ().func_72314_b(8.0D, 8.0D, 8.0D)).size() == 0)) {
/* 319 */       dissolve();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 324 */     if (!this.impacted) {
/* 325 */       float max = 5.0F;
/* 326 */       float scale = Math.min(this.ticksInAir, max) / max;
/* 327 */       emoniph.intangible.Intangible.PROXY.glow(this.field_70170_p, this.field_70165_t, this.field_70163_u + scale * this.field_70131_O / 2.0F, this.field_70161_v).scaleExact(2.0F).color(17561).durationScale(0.3F);
/*     */     }
/*     */     
/* 330 */     this.field_70142_S = this.field_70165_t;
/* 331 */     this.field_70137_T = this.field_70163_u;
/* 332 */     this.field_70136_U = this.field_70161_v;
/* 333 */     if (this.impacted) {
/* 334 */       this.field_70159_w = (this.field_70181_x = this.field_70179_y = 0.0D);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 340 */     if (this.inGround) {
/* 341 */       if (this.field_70170_p.func_180495_p(new net.minecraft.util.BlockPos(this.xTile, this.yTile, this.zTile)).func_177230_c() == this.inTile) {
/* 342 */         this.ticksInGround += 1;
/*     */         
/* 344 */         if (this.ticksInGround == 200) {
/* 345 */           func_70106_y();
/* 346 */           return;
/*     */         }
/*     */         
/*     */ 
/* 350 */         return;
/*     */       }
/*     */       
/* 353 */       this.inGround = false;
/* 354 */       this.field_70159_w *= this.field_70146_Z.nextFloat() * 0.2F;
/* 355 */       this.field_70181_x *= this.field_70146_Z.nextFloat() * 0.2F;
/* 356 */       this.field_70179_y *= this.field_70146_Z.nextFloat() * 0.2F;
/* 357 */       this.ticksInGround = 0;
/* 358 */       this.ticksInAir = 0;
/*     */     }
/*     */     else {
/* 361 */       this.ticksInAir += 1;
/*     */     }
/*     */     
/* 364 */     Vec3 vec3 = new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 365 */     Vec3 vec31 = new Vec3(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 366 */     MovingObjectPosition movingobjectposition = this.field_70170_p.func_72933_a(vec3, vec31);
/*     */     
/*     */ 
/*     */ 
/* 370 */     if (movingobjectposition == null)
/*     */     {
/*     */ 
/* 373 */       if (this.ticksInAir >= 8) {
/* 374 */         movingobjectposition = new MovingObjectPosition(net.minecraft.util.MovingObjectPosition.MovingObjectType.MISS, new Vec3(this.field_70165_t, this.field_70163_u, this.field_70161_v), null, null);
/*     */       }
/*     */     }
/*     */     
/* 378 */     if (movingobjectposition != null) {
/* 379 */       if ((movingobjectposition.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK) && (this.field_70170_p.func_180495_p(movingobjectposition.func_178782_a()).func_177230_c() == net.minecraft.init.Blocks.field_150427_aO)) {
/* 380 */         this.field_71087_bX = true;
/*     */       } else {
/* 382 */         onImpact(movingobjectposition);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 387 */     this.field_70165_t += this.field_70159_w;
/* 388 */     this.field_70163_u += this.field_70181_x;
/* 389 */     this.field_70161_v += this.field_70179_y;
/* 390 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 391 */     this.field_70177_z = ((float)(Math.atan2(this.field_70159_w, this.field_70179_y) * 180.0D / 3.141592653589793D));
/*     */     
/* 393 */     for (this.field_70125_A = ((float)(Math.atan2(this.field_70181_x, f1) * 180.0D / 3.141592653589793D)); this.field_70125_A - this.field_70127_C < -180.0F; this.field_70127_C -= 360.0F) {}
/*     */     
/*     */ 
/*     */ 
/* 397 */     while (this.field_70125_A - this.field_70127_C >= 180.0F) {
/* 398 */       this.field_70127_C += 360.0F;
/*     */     }
/*     */     
/* 401 */     while (this.field_70177_z - this.field_70126_B < -180.0F) {
/* 402 */       this.field_70126_B -= 360.0F;
/*     */     }
/*     */     
/* 405 */     while (this.field_70177_z - this.field_70126_B >= 180.0F) {
/* 406 */       this.field_70126_B += 360.0F;
/*     */     }
/*     */     
/* 409 */     this.field_70125_A = (this.field_70127_C + (this.field_70125_A - this.field_70127_C) * 0.2F);
/* 410 */     this.field_70177_z = (this.field_70126_B + (this.field_70177_z - this.field_70126_B) * 0.2F);
/* 411 */     float f2 = 0.99F;
/* 412 */     float f3 = getGravityVelocity();
/*     */     
/* 414 */     if (func_70090_H()) {
/* 415 */       for (int i = 0; i < 4; i++) {
/* 416 */         float f4 = 0.25F;
/* 417 */         this.field_70170_p.func_175688_a(net.minecraft.util.EnumParticleTypes.WATER_BUBBLE, this.field_70165_t - this.field_70159_w * f4, this.field_70163_u - this.field_70181_x * f4, this.field_70161_v - this.field_70179_y * f4, this.field_70159_w, this.field_70181_x, this.field_70179_y, new int[0]);
/*     */       }
/*     */       
/* 420 */       f2 = 0.8F;
/*     */     }
/*     */     
/* 423 */     this.field_70159_w *= f2;
/* 424 */     this.field_70181_x *= f2;
/* 425 */     this.field_70179_y *= f2;
/* 426 */     this.field_70181_x -= f3;
/* 427 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   public static final int backHeight = 221;
/*     */   public boolean impacted;
/*     */   public void func_70014_b(NBTTagCompound tagCompound)
/*     */   {
/* 434 */     tagCompound.func_74777_a("xTile", (short)this.xTile);
/* 435 */     tagCompound.func_74777_a("yTile", (short)this.yTile);
/* 436 */     tagCompound.func_74777_a("zTile", (short)this.zTile);
/* 437 */     ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.func_177774_c(this.inTile);
/* 438 */     tagCompound.func_74778_a("inTile", resourcelocation == null ? "" : resourcelocation.toString());
/* 439 */     tagCompound.func_74768_a("dissolve", getDisolveTicks());
/* 440 */     tagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/*     */     
/* 442 */     if (((this.throwerName == null) || (this.throwerName.length() == 0)) && ((this.thrower instanceof EntityPlayer))) {
/* 443 */       this.throwerName = this.thrower.func_70005_c_();
/*     */     }
/*     */     
/* 446 */     tagCompound.func_74778_a("ownerName", this.throwerName == null ? "" : this.throwerName);
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound tagCompund)
/*     */   {
/* 451 */     this.xTile = tagCompund.func_74765_d("xTile");
/* 452 */     this.yTile = tagCompund.func_74765_d("yTile");
/* 453 */     this.zTile = tagCompund.func_74765_d("zTile");
/*     */     
/* 455 */     if (tagCompund.func_150297_b("inTile", 8)) {
/* 456 */       this.inTile = Block.func_149684_b(tagCompund.func_74779_i("inTile"));
/*     */     } else {
/* 458 */       this.inTile = Block.func_149729_e(tagCompund.func_74771_c("inTile") & 0xFF);
/*     */     }
/*     */     
/* 461 */     if (tagCompund.func_150297_b("dissolve", 3)) {
/* 462 */       setDissolveTicks(tagCompund.func_74762_e("dissolve"));
/*     */     } else {
/* 464 */       setDissolveTicks(-1);
/*     */     }
/*     */     
/*     */ 
/* 468 */     this.inGround = (tagCompund.func_74771_c("inGround") == 1);
/* 469 */     this.throwerName = tagCompund.func_74779_i("ownerName");
/*     */     
/* 471 */     if ((this.throwerName != null) && (this.throwerName.length() == 0)) {
/* 472 */       this.throwerName = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public EntityLivingBase getThrower()
/*     */   {
/* 478 */     if ((this.thrower == null) && (this.throwerName != null) && (this.throwerName.length() > 0)) {
/* 479 */       this.thrower = this.field_70170_p.func_72924_a(this.throwerName);
/*     */     }
/*     */     
/* 482 */     return this.thrower;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean func_70097_a(net.minecraft.util.DamageSource source, float amount)
/*     */   {
/* 488 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void onImpact(MovingObjectPosition movingObject)
/*     */   {
/* 495 */     this.field_70159_w = (this.field_70181_x = this.field_70179_y = 0.0D);
/*     */     
/* 497 */     if (!this.impacted) {
/* 498 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 499 */       this.impacted = true;
/*     */     }
/*     */     
/* 502 */     if (!this.field_70170_p.field_72995_K) {}
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityKnowledgeGem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */