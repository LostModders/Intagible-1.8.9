/*     */ package emoniph.intangible.client.models;
/*     */ 
/*     */ import net.minecraft.client.model.ModelBase;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class ModelBellows
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer standRight1;
/*     */   public ModelRenderer standRight2;
/*     */   public ModelRenderer standRight3;
/*     */   public ModelRenderer standLeft3;
/*     */   public ModelRenderer standLeft2;
/*     */   public ModelRenderer standLeft1;
/*     */   public ModelRenderer tray;
/*     */   public ModelRenderer lid;
/*     */   public ModelRenderer sack1;
/*     */   public ModelRenderer sack2;
/*     */   public ModelRenderer sack5;
/*     */   public ModelRenderer sack4;
/*     */   public ModelRenderer sack3;
/*     */   public ModelRenderer nozzle;
/*     */   public ModelRenderer tray1;
/*     */   public ModelRenderer tray2;
/*     */   public ModelRenderer tray3;
/*     */   public ModelRenderer tray4;
/*     */   public ModelRenderer lid1;
/*     */   public ModelRenderer lid2;
/*     */   public ModelRenderer lid3;
/*     */   public ModelRenderer lid4;
/*     */   public ModelRenderer handle;
/*     */   public ModelRenderer handleRight;
/*     */   public ModelRenderer handleLeft;
/*     */   
/*     */   public ModelBellows()
/*     */   {
/*  42 */     this.field_78090_t = 64;
/*  43 */     this.field_78089_u = 64;
/*  44 */     this.lid = new ModelRenderer(this, 0, 42);
/*  45 */     this.lid.func_78793_a(0.0F, 18.0F, 6.0F);
/*  46 */     this.lid.func_78790_a(-6.0F, -2.0F, -12.0F, 12, 1, 12, 0.0F);
/*  47 */     setRotateAngle(this.lid, -0.7740535F, 0.0F, 0.0F);
/*  48 */     this.standRight1 = new ModelRenderer(this, 0, 17);
/*  49 */     this.standRight1.func_78793_a(0.0F, 20.0F, 0.0F);
/*  50 */     this.standRight1.func_78790_a(-7.5F, 0.0F, -7.0F, 4, 1, 14, 0.0F);
/*  51 */     this.handleRight = new ModelRenderer(this, 0, 0);
/*  52 */     this.handleRight.func_78793_a(0.0F, 0.0F, 0.0F);
/*  53 */     this.handleRight.func_78790_a(-3.0F, -1.5F, -13.0F, 1, 1, 1, 0.0F);
/*  54 */     this.standLeft1 = new ModelRenderer(this, 0, 17);
/*  55 */     this.standLeft1.field_78809_i = true;
/*  56 */     this.standLeft1.func_78793_a(0.0F, 20.0F, 0.0F);
/*  57 */     this.standLeft1.func_78790_a(3.5F, 0.0F, -7.0F, 4, 1, 14, 0.0F);
/*  58 */     this.lid4 = new ModelRenderer(this, 0, 38);
/*  59 */     this.lid4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  60 */     this.lid4.func_78790_a(-6.0F, -1.0F, 0.0F, 11, 1, 1, 0.0F);
/*  61 */     setRotateAngle(this.lid4, 0.0F, 3.1415927F, 0.0F);
/*  62 */     this.standRight3 = new ModelRenderer(this, 0, 25);
/*  63 */     this.standRight3.func_78793_a(0.0F, 21.0F, 0.0F);
/*  64 */     this.standRight3.func_78790_a(-6.5F, 0.0F, -6.5F, 2, 3, 2, 0.0F);
/*  65 */     setRotateAngle(this.standRight3, 0.0F, 1.5707964F, 0.0F);
/*  66 */     this.standLeft2 = new ModelRenderer(this, 0, 25);
/*  67 */     this.standLeft2.field_78809_i = true;
/*  68 */     this.standLeft2.func_78793_a(0.0F, 21.0F, 0.0F);
/*  69 */     this.standLeft2.func_78790_a(-6.5F, 0.0F, -6.5F, 2, 3, 2, 0.0F);
/*  70 */     setRotateAngle(this.standLeft2, 0.0F, -1.5707964F, 0.0F);
/*  71 */     this.sack5 = new ModelRenderer(this, 24, 18);
/*  72 */     this.sack5.func_78793_a(0.0F, 18.0F, 6.0F);
/*  73 */     this.sack5.func_78790_a(-5.0F, -1.0F, -10.5F, 10, 2, 10, 0.0F);
/*  74 */     setRotateAngle(this.sack5, -0.7285004F, 0.0F, 0.0F);
/*  75 */     this.tray4 = new ModelRenderer(this, 40, 0);
/*  76 */     this.tray4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  77 */     this.tray4.func_78790_a(-6.0F, -1.0F, -6.0F, 11, 1, 1, 0.0F);
/*  78 */     setRotateAngle(this.tray4, 0.0F, 3.1415927F, 0.0F);
/*  79 */     this.tray3 = new ModelRenderer(this, 40, 0);
/*  80 */     this.tray3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.tray3.func_78790_a(-6.0F, -1.0F, -6.0F, 11, 1, 1, 0.0F);
/*  82 */     setRotateAngle(this.tray3, 0.0F, -1.5707964F, 0.0F);
/*  83 */     this.standRight2 = new ModelRenderer(this, 0, 25);
/*  84 */     this.standRight2.func_78793_a(0.0F, 21.0F, 0.0F);
/*  85 */     this.standRight2.func_78790_a(-6.5F, 0.0F, -6.5F, 2, 3, 2, 0.0F);
/*  86 */     this.sack2 = new ModelRenderer(this, 32, 31);
/*  87 */     this.sack2.func_78793_a(0.0F, 18.0F, 6.0F);
/*  88 */     this.sack2.func_78790_a(-4.0F, -1.0F, -9.0F, 8, 2, 8, 0.0F);
/*  89 */     setRotateAngle(this.sack2, -0.18203785F, 0.0F, 0.0F);
/*  90 */     this.lid1 = new ModelRenderer(this, 0, 38);
/*  91 */     this.lid1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  92 */     this.lid1.func_78790_a(-6.0F, -1.0F, -12.0F, 11, 1, 1, 0.0F);
/*  93 */     this.sack3 = new ModelRenderer(this, 24, 18);
/*  94 */     this.sack3.func_78793_a(0.0F, 18.0F, 6.0F);
/*  95 */     this.sack3.func_78790_a(-4.9F, -1.0F, -10.5F, 10, 2, 10, 0.0F);
/*  96 */     setRotateAngle(this.sack3, -0.3642502F, 0.0F, 0.0F);
/*  97 */     this.nozzle = new ModelRenderer(this, 0, 7);
/*  98 */     this.nozzle.func_78793_a(0.0F, 17.8F, 6.0F);
/*  99 */     this.nozzle.func_78790_a(-1.0F, -1.0F, 0.0F, 2, 2, 3, 0.0F);
/* 100 */     this.standLeft3 = new ModelRenderer(this, 0, 25);
/* 101 */     this.standLeft3.field_78809_i = true;
/* 102 */     this.standLeft3.func_78793_a(0.0F, 21.0F, 0.0F);
/* 103 */     this.standLeft3.func_78790_a(-6.5F, 0.0F, -6.5F, 2, 3, 2, 0.0F);
/* 104 */     setRotateAngle(this.standLeft3, 0.0F, 3.1415927F, 0.0F);
/* 105 */     this.tray = new ModelRenderer(this, 16, 3);
/* 106 */     this.tray.func_78793_a(0.0F, 19.0F, 0.0F);
/* 107 */     this.tray.func_78790_a(-6.0F, 0.0F, -6.0F, 12, 1, 12, 0.0F);
/* 108 */     this.handle = new ModelRenderer(this, 0, 3);
/* 109 */     this.handle.func_78793_a(0.0F, 0.0F, 0.0F);
/* 110 */     this.handle.func_78790_a(-3.0F, -1.5F, -14.0F, 6, 1, 1, 0.0F);
/* 111 */     this.tray2 = new ModelRenderer(this, 40, 0);
/* 112 */     this.tray2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 113 */     this.tray2.func_78790_a(-6.0F, -1.0F, -6.0F, 11, 1, 1, 0.0F);
/* 114 */     setRotateAngle(this.tray2, 0.0F, 1.5707964F, 0.0F);
/* 115 */     this.handleLeft = new ModelRenderer(this, 0, 0);
/* 116 */     this.handleLeft.func_78793_a(0.0F, 0.0F, 0.0F);
/* 117 */     this.handleLeft.func_78790_a(2.0F, -1.5F, -13.0F, 1, 1, 1, 0.0F);
/* 118 */     this.sack4 = new ModelRenderer(this, 32, 31);
/* 119 */     this.sack4.func_78793_a(0.0F, 18.0F, 6.0F);
/* 120 */     this.sack4.func_78790_a(-4.0F, -1.0F, -9.0F, 8, 2, 8, 0.0F);
/* 121 */     setRotateAngle(this.sack4, -0.5462881F, 0.0F, 0.0F);
/* 122 */     this.tray1 = new ModelRenderer(this, 40, 0);
/* 123 */     this.tray1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 124 */     this.tray1.func_78790_a(-6.0F, -1.0F, -6.0F, 11, 1, 1, 0.0F);
/* 125 */     this.lid3 = new ModelRenderer(this, 0, 38);
/* 126 */     this.lid3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 127 */     this.lid3.func_78790_a(-12.0F, -1.0F, -6.0F, 11, 1, 1, 0.0F);
/* 128 */     setRotateAngle(this.lid3, 0.0F, -1.5707964F, 0.0F);
/* 129 */     this.sack1 = new ModelRenderer(this, 24, 18);
/* 130 */     this.sack1.func_78793_a(0.0F, 18.0F, 6.0F);
/* 131 */     this.sack1.func_78790_a(-5.1F, -1.0F, -10.5F, 10, 2, 10, 0.0F);
/* 132 */     this.lid2 = new ModelRenderer(this, 0, 38);
/* 133 */     this.lid2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 134 */     this.lid2.func_78790_a(0.0F, -1.0F, -6.0F, 11, 1, 1, 0.0F);
/* 135 */     setRotateAngle(this.lid2, 0.0F, 1.5707964F, 0.0F);
/* 136 */     this.lid.func_78792_a(this.handleRight);
/* 137 */     this.lid.func_78792_a(this.lid4);
/* 138 */     this.tray.func_78792_a(this.tray4);
/* 139 */     this.tray.func_78792_a(this.tray3);
/* 140 */     this.lid.func_78792_a(this.lid1);
/* 141 */     this.lid.func_78792_a(this.handle);
/* 142 */     this.tray.func_78792_a(this.tray2);
/* 143 */     this.lid.func_78792_a(this.handleLeft);
/* 144 */     this.tray.func_78792_a(this.tray1);
/* 145 */     this.lid.func_78792_a(this.lid3);
/* 146 */     this.lid.func_78792_a(this.lid2);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 151 */     this.lid.func_78785_a(f5);
/* 152 */     this.standRight1.func_78785_a(f5);
/* 153 */     this.standLeft1.func_78785_a(f5);
/* 154 */     this.standRight3.func_78785_a(f5);
/* 155 */     this.standLeft2.func_78785_a(f5);
/* 156 */     this.sack5.func_78785_a(f5);
/* 157 */     this.standRight2.func_78785_a(f5);
/* 158 */     this.sack2.func_78785_a(f5);
/* 159 */     this.sack3.func_78785_a(f5);
/* 160 */     this.nozzle.func_78785_a(f5);
/* 161 */     this.standLeft3.func_78785_a(f5);
/* 162 */     this.tray.func_78785_a(f5);
/* 163 */     this.sack4.func_78785_a(f5);
/* 164 */     this.sack1.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 171 */     modelRenderer.field_78795_f = x;
/* 172 */     modelRenderer.field_78796_g = y;
/* 173 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelBellows.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */