/*     */ package emoniph.intangible.player;
/*     */ 
/*     */ import emoniph.intangible.util.EntityHistory;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerTempCache
/*     */ {
/*     */   final EntityPlayer PLAYER;
/*     */   public double prevX;
/*     */   public double prevY;
/*     */   public double prevZ;
/*     */   
/*     */   PlayerTempCache(EntityPlayer player)
/*     */   {
/*  18 */     this.PLAYER = player;
/*     */   }
/*     */   
/*  21 */   ItemStack[] armorCache = new ItemStack[4];
/*     */   private double ySize;
/*     */   private float eyeHeight;
/*     */   
/*     */   public double pushYSize(double eyeHeight)
/*     */   {
/*  27 */     this.ySize = (this.PLAYER.func_70033_W() - eyeHeight + this.PLAYER.getDefaultEyeHeight());
/*  28 */     return this.ySize;
/*     */   }
/*     */   
/*     */   public double popYSize() {
/*  32 */     return this.ySize;
/*     */   }
/*     */   
/*     */ 
/*     */   public float pushEyeHeight()
/*     */   {
/*  38 */     this.eyeHeight = this.PLAYER.eyeHeight;
/*  39 */     return this.eyeHeight;
/*     */   }
/*     */   
/*     */   public float popEyeHeight() {
/*  43 */     return this.eyeHeight;
/*     */   }
/*     */   
/*  46 */   private EntityHistory history = new EntityHistory();
/*     */   
/*  48 */   public EntityHistory getPosHistory() { return this.history; }
/*     */   
/*     */   public static class RadialMenuData
/*     */   {
/*     */     private static final int MAX_STROKES = 16;
/*     */     private float yaw;
/*     */     private float pitch;
/*     */     private int stroke;
/*     */     private boolean strokeChanged;
/*     */     
/*     */     public RadialMenuData(EntityPlayer player) {
/*  59 */       reset(player);
/*     */     }
/*     */     
/*     */     public void reset(EntityPlayer player)
/*     */     {
/*  64 */       this.yaw = player.field_70759_as;
/*  65 */       this.pitch = player.field_70125_A;
/*  66 */       this.stroke = -1;
/*     */     }
/*     */     
/*     */     public float getYawDiff(EntityPlayer player) {
/*  70 */       return this.yaw - player.field_70759_as;
/*     */     }
/*     */     
/*     */     public float getPitchDiff(EntityPlayer player) {
/*  74 */       return this.pitch - player.field_70125_A;
/*     */     }
/*     */     
/*     */     public float getYawDiff(EntityPlayer player, float partialTicks) {
/*  78 */       float diff = this.yaw - (player.field_70758_at + (player.field_70759_as - player.field_70758_at) * partialTicks);
/*  79 */       return Math.round(diff * 10.0F) * 0.1F;
/*     */     }
/*     */     
/*     */     public float getPitchDiff(EntityPlayer player, float partialTicks) {
/*  83 */       float diff = this.pitch - (player.field_70127_C + (player.field_70125_A - player.field_70127_C) * partialTicks);
/*  84 */       return Math.round(diff * 10.0F) * 0.1F;
/*     */     }
/*     */     
/*     */     public void setStroke(int value) {
/*  88 */       if (this.stroke == -1) {
/*  89 */         this.stroke = value;
/*  90 */         this.strokeChanged = true;
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean update(EntityPlayer player) {
/*  95 */       if (this.strokeChanged) {
/*  96 */         this.strokeChanged = false;
/*  97 */         this.yaw = player.field_70759_as;
/*  98 */         this.pitch = player.field_70125_A;
/*  99 */         return true;
/*     */       }
/* 101 */       return false;
/*     */     }
/*     */     
/*     */     public int getLastStroke() {
/* 105 */       return this.stroke;
/*     */     }
/*     */     
/*     */     public boolean hasStroke() {
/* 109 */       return this.stroke != -1;
/*     */     }
/*     */   }
/*     */   
/*     */   private RadialMenuData radialMenuData;
/*     */   public void pushRadialMenuData(RadialMenuData data)
/*     */   {
/* 116 */     this.radialMenuData = data;
/*     */   }
/*     */   
/*     */   public RadialMenuData getRadialMenuData() {
/* 120 */     return this.radialMenuData;
/*     */   }
/*     */   
/*     */   public void clearRadialMenuData() {
/* 124 */     this.radialMenuData = null;
/*     */   }
/*     */   
/*     */   public boolean hasRadialMenuData() {
/* 128 */     return this.radialMenuData != null;
/*     */   }
/*     */   
/*     */ 
/*     */   private RadialMenuData priestMenuData;
/*     */   public void pushPriestMenuData(RadialMenuData data)
/*     */   {
/* 135 */     this.priestMenuData = data;
/*     */   }
/*     */   
/*     */   public RadialMenuData getPriestMenuData() {
/* 139 */     return this.priestMenuData;
/*     */   }
/*     */   
/*     */   public void clearPriestMenuData() {
/* 143 */     this.priestMenuData = null;
/*     */   }
/*     */   
/*     */   public boolean hasPriestMenuData() {
/* 147 */     return this.priestMenuData != null;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/PlayerTempCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */