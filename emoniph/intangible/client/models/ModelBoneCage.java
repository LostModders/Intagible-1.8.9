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
/*     */ public class ModelBoneCage
/*     */   extends ModelBase
/*     */ {
/*     */   public ModelRenderer base;
/*     */   public ModelRenderer barBack1;
/*     */   public ModelRenderer barBack2;
/*     */   public ModelRenderer barBack3;
/*     */   public ModelRenderer barBack4;
/*     */   public ModelRenderer top;
/*     */   public ModelRenderer barBackRight;
/*     */   public ModelRenderer barBackLeft;
/*     */   public ModelRenderer barLeft1;
/*     */   public ModelRenderer barLeft2;
/*     */   public ModelRenderer barLeft3;
/*     */   public ModelRenderer barRight1;
/*     */   public ModelRenderer barRight2;
/*     */   public ModelRenderer barLeft4;
/*     */   public ModelRenderer barRight3;
/*     */   public ModelRenderer rightDoor;
/*     */   public ModelRenderer leftDoor;
/*     */   public ModelRenderer barRight4;
/*     */   public ModelRenderer barLeft5;
/*     */   public ModelRenderer barLeft6;
/*     */   public ModelRenderer barRight5;
/*     */   public ModelRenderer barRight6;
/*     */   public ModelRenderer barBack5;
/*     */   public ModelRenderer rightDoor1;
/*     */   public ModelRenderer rightDoor2;
/*     */   public ModelRenderer rightDoor3;
/*     */   public ModelRenderer rightDoor4;
/*     */   public ModelRenderer rightDoor5;
/*     */   public ModelRenderer leftDoor1;
/*     */   public ModelRenderer leftDoor2;
/*     */   public ModelRenderer leftDoor3;
/*     */   public ModelRenderer leftDoor4;
/*     */   public ModelRenderer leftDoor5;
/*     */   
/*     */   public ModelBoneCage()
/*     */   {
/*  50 */     this.field_78090_t = 64;
/*  51 */     this.field_78089_u = 64;
/*  52 */     this.barLeft4 = new ModelRenderer(this, 0, 0);
/*  53 */     this.barLeft4.func_78793_a(0.0F, -7.0F, 0.0F);
/*  54 */     this.barLeft4.func_78790_a(6.9F, 12.0F, -1.7F, 1, 18, 1, 0.0F);
/*  55 */     setRotateAngle(this.barLeft4, 0.13665928F, 0.0F, 0.0F);
/*  56 */     this.base = new ModelRenderer(this, 0, 16);
/*  57 */     this.base.func_78793_a(0.0F, 23.0F, 0.0F);
/*  58 */     this.base.func_78790_a(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
/*  59 */     this.barLeft2 = new ModelRenderer(this, 0, 0);
/*  60 */     this.barLeft2.func_78793_a(0.0F, -7.0F, 0.0F);
/*  61 */     this.barLeft2.func_78790_a(6.8F, 0.0F, 1.0F, 1, 30, 1, 0.0F);
/*  62 */     setRotateAngle(this.barLeft2, -0.091106184F, 0.0F, 0.0F);
/*  63 */     this.top = new ModelRenderer(this, 0, 16);
/*  64 */     this.top.func_78793_a(0.0F, -8.0F, 0.0F);
/*  65 */     this.top.func_78790_a(-8.0F, 0.0F, -8.0F, 16, 1, 16, 0.0F);
/*  66 */     this.barLeft3 = new ModelRenderer(this, 0, 0);
/*  67 */     this.barLeft3.func_78793_a(0.0F, -7.0F, 0.0F);
/*  68 */     this.barLeft3.func_78790_a(6.8F, 0.0F, -5.7F, 1, 30, 1, 0.0F);
/*  69 */     setRotateAngle(this.barLeft3, 0.045553092F, 0.0F, 0.0F);
/*  70 */     this.barRight1 = new ModelRenderer(this, 0, 0);
/*  71 */     this.barRight1.func_78793_a(0.0F, -7.0F, 0.0F);
/*  72 */     this.barRight1.func_78790_a(-7.9F, 0.0F, 4.0F, 1, 30, 1, 0.0F);
/*  73 */     setRotateAngle(this.barRight1, 0.045553092F, 0.0F, 0.0F);
/*  74 */     this.leftDoor2 = new ModelRenderer(this, 0, 0);
/*  75 */     this.leftDoor2.func_78793_a(0.0F, 0.0F, 0.0F);
/*  76 */     this.leftDoor2.func_78790_a(-3.5F, 1.0F, -0.4F, 1, 28, 1, 0.0F);
/*  77 */     setRotateAngle(this.leftDoor2, 0.0F, 0.0F, -0.045553092F);
/*  78 */     this.leftDoor4 = new ModelRenderer(this, 5, 3);
/*  79 */     this.leftDoor4.field_78809_i = true;
/*  80 */     this.leftDoor4.func_78793_a(0.0F, 0.0F, 0.0F);
/*  81 */     this.leftDoor4.func_78790_a(-6.5F, 29.0F, -0.5F, 6, 1, 1, 0.0F);
/*  82 */     this.barBack1 = new ModelRenderer(this, 0, 0);
/*  83 */     this.barBack1.func_78793_a(0.0F, -7.0F, 0.0F);
/*  84 */     this.barBack1.func_78790_a(-5.0F, 0.0F, 6.8F, 1, 30, 1, 0.0F);
/*  85 */     setRotateAngle(this.barBack1, 0.0F, 0.0F, -0.045553092F);
/*  86 */     this.rightDoor1 = new ModelRenderer(this, 0, 0);
/*  87 */     this.rightDoor1.func_78793_a(0.0F, 0.0F, 0.0F);
/*  88 */     this.rightDoor1.func_78790_a(5.5F, 1.0F, -0.5F, 1, 28, 1, 0.0F);
/*  89 */     this.rightDoor3 = new ModelRenderer(this, 5, 0);
/*  90 */     this.rightDoor3.func_78793_a(0.0F, 0.0F, 0.0F);
/*  91 */     this.rightDoor3.func_78790_a(0.5F, 0.0F, -0.5F, 6, 1, 1, 0.0F);
/*  92 */     this.barRight2 = new ModelRenderer(this, 0, 0);
/*  93 */     this.barRight2.func_78793_a(0.0F, -7.0F, 0.0F);
/*  94 */     this.barRight2.func_78790_a(-7.8F, 0.0F, 1.0F, 1, 30, 1, 0.0F);
/*  95 */     setRotateAngle(this.barRight2, -0.091106184F, 0.0F, 0.0F);
/*  96 */     this.barBackRight = new ModelRenderer(this, 0, 0);
/*  97 */     this.barBackRight.func_78793_a(0.0F, -7.0F, 0.0F);
/*  98 */     this.barBackRight.func_78790_a(-7.8F, 0.0F, 6.8F, 1, 30, 1, 0.0F);
/*  99 */     this.leftDoor3 = new ModelRenderer(this, 5, 0);
/* 100 */     this.leftDoor3.field_78809_i = true;
/* 101 */     this.leftDoor3.func_78793_a(0.0F, 0.0F, 0.0F);
/* 102 */     this.leftDoor3.func_78790_a(-6.5F, 0.0F, -0.5F, 6, 1, 1, 0.0F);
/* 103 */     this.barRight3 = new ModelRenderer(this, 0, 0);
/* 104 */     this.barRight3.func_78793_a(0.0F, -7.0F, 0.0F);
/* 105 */     this.barRight3.func_78790_a(-7.7F, 0.0F, -5.7F, 1, 30, 1, 0.0F);
/* 106 */     setRotateAngle(this.barRight3, 0.045553092F, 0.0F, 0.0F);
/* 107 */     this.barLeft5 = new ModelRenderer(this, 0, 0);
/* 108 */     this.barLeft5.func_78793_a(0.0F, -7.0F, 0.0F);
/* 109 */     this.barLeft5.func_78790_a(6.9F, 2.5F, -6.1F, 1, 20, 1, 0.0F);
/* 110 */     setRotateAngle(this.barLeft5, 0.22759093F, 0.0F, 0.0F);
/* 111 */     this.barBack2 = new ModelRenderer(this, 0, 0);
/* 112 */     this.barBack2.func_78793_a(0.0F, -7.0F, 0.0F);
/* 113 */     this.barBack2.func_78790_a(-0.5F, 4.0F, 7.0F, 1, 23, 1, 0.0F);
/* 114 */     this.rightDoor4 = new ModelRenderer(this, 5, 3);
/* 115 */     this.rightDoor4.func_78793_a(0.0F, 0.0F, 0.0F);
/* 116 */     this.rightDoor4.func_78790_a(0.5F, 29.0F, -0.5F, 6, 1, 1, 0.0F);
/* 117 */     this.barLeft1 = new ModelRenderer(this, 0, 0);
/* 118 */     this.barLeft1.func_78793_a(0.0F, -7.0F, 0.0F);
/* 119 */     this.barLeft1.func_78790_a(6.9F, 0.0F, 4.0F, 1, 30, 1, 0.0F);
/* 120 */     setRotateAngle(this.barLeft1, 0.045553092F, 0.0F, 0.0F);
/* 121 */     this.barLeft6 = new ModelRenderer(this, 0, 0);
/* 122 */     this.barLeft6.func_78793_a(0.0F, -7.0F, 0.0F);
/* 123 */     this.barLeft6.func_78790_a(6.8F, 0.0F, 4.0F, 1, 19, 1, 0.0F);
/* 124 */     setRotateAngle(this.barLeft6, -0.13665928F, 0.0F, 0.0F);
/* 125 */     this.barBack5 = new ModelRenderer(this, 0, 0);
/* 126 */     this.barBack5.func_78793_a(0.0F, -7.0F, 0.0F);
/* 127 */     this.barBack5.func_78790_a(-3.5F, 5.2F, 6.9F, 1, 22, 1, 0.0F);
/* 128 */     setRotateAngle(this.barBack5, 0.0F, 0.0F, -0.22759093F);
/* 129 */     this.barBack3 = new ModelRenderer(this, 0, 0);
/* 130 */     this.barBack3.func_78793_a(0.0F, -7.0F, 0.0F);
/* 131 */     this.barBack3.func_78790_a(4.0F, 0.0F, 6.8F, 1, 30, 1, 0.0F);
/* 132 */     setRotateAngle(this.barBack3, 0.0F, 0.0F, 0.045553092F);
/* 133 */     this.rightDoor2 = new ModelRenderer(this, 0, 0);
/* 134 */     this.rightDoor2.func_78793_a(0.0F, 0.0F, 0.0F);
/* 135 */     this.rightDoor2.func_78790_a(2.5F, 0.9F, -0.4F, 1, 28, 1, 0.0F);
/* 136 */     setRotateAngle(this.rightDoor2, 0.0F, 0.0F, 0.045553092F);
/* 137 */     this.leftDoor1 = new ModelRenderer(this, 0, 0);
/* 138 */     this.leftDoor1.func_78793_a(0.0F, 0.0F, 0.0F);
/* 139 */     this.leftDoor1.func_78790_a(-6.5F, 1.0F, -0.5F, 1, 28, 1, 0.0F);
/* 140 */     this.barRight5 = new ModelRenderer(this, 0, 0);
/* 141 */     this.barRight5.func_78793_a(0.0F, -7.0F, 0.0F);
/* 142 */     this.barRight5.func_78790_a(-7.9F, 12.0F, -1.7F, 1, 18, 1, 0.0F);
/* 143 */     setRotateAngle(this.barRight5, 0.13665928F, 0.0F, 0.0F);
/* 144 */     this.barBackLeft = new ModelRenderer(this, 0, 0);
/* 145 */     this.barBackLeft.func_78793_a(0.0F, -7.0F, 0.0F);
/* 146 */     this.barBackLeft.func_78790_a(6.8F, 0.0F, 6.8F, 1, 30, 1, 0.0F);
/* 147 */     this.barRight4 = new ModelRenderer(this, 0, 0);
/* 148 */     this.barRight4.func_78793_a(0.0F, -7.0F, 0.0F);
/* 149 */     this.barRight4.func_78790_a(-7.8F, 0.0F, 4.0F, 1, 19, 1, 0.0F);
/* 150 */     setRotateAngle(this.barRight4, -0.13665928F, 0.0F, 0.0F);
/* 151 */     this.barBack4 = new ModelRenderer(this, 0, 0);
/* 152 */     this.barBack4.func_78793_a(0.0F, -7.0F, 0.0F);
/* 153 */     this.barBack4.func_78790_a(2.5F, 5.2F, 6.9F, 1, 22, 1, 0.0F);
/* 154 */     setRotateAngle(this.barBack4, 0.0F, 0.0F, 0.22759093F);
/* 155 */     this.leftDoor = new ModelRenderer(this, 0, 0);
/* 156 */     this.leftDoor.func_78793_a(7.3F, -7.0F, -7.3F);
/* 157 */     this.leftDoor.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 30, 1, 0.0F);
/* 158 */     this.barRight6 = new ModelRenderer(this, 0, 0);
/* 159 */     this.barRight6.func_78793_a(0.0F, -7.0F, 0.0F);
/* 160 */     this.barRight6.func_78790_a(-7.9F, 2.5F, -6.1F, 1, 20, 1, 0.0F);
/* 161 */     setRotateAngle(this.barRight6, 0.22759093F, 0.0F, 0.0F);
/* 162 */     this.rightDoor5 = new ModelRenderer(this, 0, 0);
/* 163 */     this.rightDoor5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 164 */     this.rightDoor5.func_78790_a(-0.8F, 12.6F, -0.45F, 1, 14, 1, 0.0F);
/* 165 */     setRotateAngle(this.rightDoor5, 0.0F, 0.0F, -0.22759093F);
/* 166 */     this.rightDoor = new ModelRenderer(this, 0, 0);
/* 167 */     this.rightDoor.func_78793_a(-7.3F, -7.0F, -7.3F);
/* 168 */     this.rightDoor.func_78790_a(-0.5F, 0.0F, -0.5F, 1, 30, 1, 0.0F);
/* 169 */     this.leftDoor5 = new ModelRenderer(this, 0, 0);
/* 170 */     this.leftDoor5.func_78793_a(0.0F, 0.0F, 0.0F);
/* 171 */     this.leftDoor5.func_78790_a(-0.2F, 12.6F, -0.45F, 1, 14, 1, 0.0F);
/* 172 */     setRotateAngle(this.leftDoor5, 0.0F, 0.0F, 0.22759093F);
/* 173 */     this.leftDoor.func_78792_a(this.leftDoor2);
/* 174 */     this.leftDoor.func_78792_a(this.leftDoor4);
/* 175 */     this.rightDoor.func_78792_a(this.rightDoor1);
/* 176 */     this.rightDoor.func_78792_a(this.rightDoor3);
/* 177 */     this.leftDoor.func_78792_a(this.leftDoor3);
/* 178 */     this.rightDoor.func_78792_a(this.rightDoor4);
/* 179 */     this.rightDoor.func_78792_a(this.rightDoor2);
/* 180 */     this.leftDoor.func_78792_a(this.leftDoor1);
/* 181 */     this.rightDoor.func_78792_a(this.rightDoor5);
/* 182 */     this.leftDoor.func_78792_a(this.leftDoor5);
/*     */   }
/*     */   
/*     */   public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
/*     */   {
/* 187 */     this.barLeft4.func_78785_a(f5);
/* 188 */     this.base.func_78785_a(f5);
/* 189 */     this.barLeft2.func_78785_a(f5);
/* 190 */     this.top.func_78785_a(f5);
/* 191 */     this.barLeft3.func_78785_a(f5);
/* 192 */     this.barRight1.func_78785_a(f5);
/* 193 */     this.barBack1.func_78785_a(f5);
/* 194 */     this.barRight2.func_78785_a(f5);
/* 195 */     this.barBackRight.func_78785_a(f5);
/* 196 */     this.barRight3.func_78785_a(f5);
/* 197 */     this.barLeft5.func_78785_a(f5);
/* 198 */     this.barBack2.func_78785_a(f5);
/* 199 */     this.barLeft1.func_78785_a(f5);
/* 200 */     this.barLeft6.func_78785_a(f5);
/* 201 */     this.barBack5.func_78785_a(f5);
/* 202 */     this.barBack3.func_78785_a(f5);
/* 203 */     this.barRight5.func_78785_a(f5);
/* 204 */     this.barBackLeft.func_78785_a(f5);
/* 205 */     this.barRight4.func_78785_a(f5);
/* 206 */     this.barBack4.func_78785_a(f5);
/* 207 */     this.leftDoor.func_78785_a(f5);
/* 208 */     this.barRight6.func_78785_a(f5);
/* 209 */     this.rightDoor.func_78785_a(f5);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
/*     */   {
/* 216 */     modelRenderer.field_78795_f = x;
/* 217 */     modelRenderer.field_78796_g = y;
/* 218 */     modelRenderer.field_78808_h = z;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelBoneCage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */