/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.passive.EntitySheep;
/*     */ import net.minecraft.item.EnumDyeColor;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.RegistryNamespacedDefaultedByKey;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.common.util.FakePlayerFactory;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntitySkyBeam extends Entity
/*     */ {
/*     */   private int ticksToLive;
/*     */   
/*     */   public EntitySkyBeam(World worldIn)
/*     */   {
/*  31 */     super(worldIn);
/*  32 */     func_70105_a(0.5F, 0.5F);
/*  33 */     this.field_70178_ae = true;
/*  34 */     this.field_70158_ak = true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected void func_70088_a() {}
/*     */   
/*     */ 
/*     */   protected void func_70037_a(NBTTagCompound tagCompund)
/*     */   {
/*  44 */     this.ticksToLive = tagCompund.func_74762_e("ttl");
/*     */     
/*  46 */     this.xTile = tagCompund.func_74765_d("xTile");
/*  47 */     this.yTile = tagCompund.func_74765_d("yTile");
/*  48 */     this.zTile = tagCompund.func_74765_d("zTile");
/*     */     
/*     */ 
/*  51 */     if (tagCompund.func_150297_b("inTile", 8)) {
/*  52 */       this.inTile = Block.func_149684_b(tagCompund.func_74779_i("inTile"));
/*     */     } else {
/*  54 */       this.inTile = Block.func_149729_e(tagCompund.func_74771_c("inTile") & 0xFF);
/*     */     }
/*     */     
/*  57 */     this.inGround = (tagCompund.func_74771_c("inGround") == 1);
/*     */     
/*     */ 
/*  60 */     if (tagCompund.func_150297_b("direction", 9)) {
/*  61 */       NBTTagList nbttaglist = tagCompund.func_150295_c("direction", 6);
/*  62 */       this.field_70159_w = nbttaglist.func_150309_d(0);
/*  63 */       this.field_70181_x = nbttaglist.func_150309_d(1);
/*  64 */       this.field_70179_y = nbttaglist.func_150309_d(2);
/*     */     } else {
/*  66 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound tagCompound)
/*     */   {
/*  72 */     tagCompound.func_74768_a("ttl", this.ticksToLive);
/*     */     
/*  74 */     tagCompound.func_74777_a("xTile", (short)this.xTile);
/*  75 */     tagCompound.func_74777_a("yTile", (short)this.yTile);
/*  76 */     tagCompound.func_74777_a("zTile", (short)this.zTile);
/*  77 */     ResourceLocation resourcelocation = (ResourceLocation)Block.field_149771_c.func_177774_c(this.inTile);
/*  78 */     tagCompound.func_74778_a("inTile", resourcelocation == null ? "" : resourcelocation.toString());
/*  79 */     tagCompound.func_74774_a("inGround", (byte)(this.inGround ? 1 : 0));
/*  80 */     tagCompound.func_74782_a("direction", func_70087_a(new double[] { this.field_70159_w, this.field_70181_x, this.field_70179_y }));
/*     */   }
/*     */   
/*     */   public void setTicksToLive(int ticks) {
/*  84 */     this.yTile = 255;
/*  85 */     this.ticksToLive = ticks;
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70110_aj() {}
/*     */   
/*     */ 
/*     */   public boolean func_70097_a(DamageSource source, float amount)
/*     */   {
/*  94 */     return false;
/*     */   }
/*     */   
/*  97 */   private int xTile = -1;
/*  98 */   private int yTile = -1;
/*  99 */   private int zTile = -1;
/*     */   
/*     */   private Block inTile;
/*     */   private boolean inGround;
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/* 106 */     super.func_70071_h_();
/*     */     double rsq;
/* 108 */     if (!this.field_70170_p.field_72995_K) {
/* 109 */       if (--this.ticksToLive <= 0) {
/* 110 */         func_70106_y();
/* 111 */       } else if (!this.inGround)
/*     */       {
/* 113 */         for (int y = this.yTile; y > 1; y--) {
/* 114 */           BlockPos pos = new BlockPos(this.field_70165_t, y, this.field_70161_v);
/* 115 */           IBlockState state = this.field_70170_p.func_180495_p(pos);
/* 116 */           if ((!state.func_177230_c().func_149688_o().func_76222_j()) && (state.func_177230_c() != net.minecraft.init.Blocks.field_150357_h)) {
/* 117 */             if (!BlockUtil.tryHarvestBlock(this.field_70170_p, pos, FakePlayerFactory.getMinecraft((WorldServer)this.field_70170_p), null)) {
/* 118 */               this.inGround = true;
/*     */             }
/* 120 */             this.yTile = y;
/* 121 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 126 */       if (this.field_70173_aa % 20 == 0) {
/* 127 */         double r = 3.0D;
/* 128 */         rsq = r * r;
/* 129 */         AxisAlignedBB bb = new AxisAlignedBB(this.field_70165_t - r, this.yTile, this.field_70161_v - r, this.field_70165_t + r, 255.0D, this.field_70161_v + r);
/* 130 */         List<EntityLivingBase> list = this.field_70170_p.func_72872_a(EntityLivingBase.class, bb);
/* 131 */         for (EntityLivingBase entity : list) {
/* 132 */           if ((entity.func_70068_e(entity) <= rsq) && (entity.func_70089_S())) {
/* 133 */             entity.func_70097_a(DamageSource.field_76376_m, 4.0F);
/*     */           }
/*     */         }
/*     */       }
/* 137 */     } else if ((this.field_70173_aa == 1) || (this.field_70173_aa % 80 == 0)) {
/* 138 */       func_174908_m();
/*     */     }
/*     */   }
/*     */   
/*     */   protected float getMotionFactor() {
/* 143 */     return 0.95F;
/*     */   }
/*     */   
/* 146 */   private final List beamSegmentList = com.google.common.collect.Lists.newArrayList();
/*     */   @SideOnly(Side.CLIENT)
/*     */   private long field_146016_i;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private float field_146014_j;
/*     */   
/*     */   public static class BeamSegment
/*     */   {
/*     */     private final float[] field_177266_a;
/*     */     private int field_177265_b;
/*     */     
/*     */     public BeamSegment(float[] p_i45669_1_)
/*     */     {
/* 159 */       this.field_177266_a = p_i45669_1_;
/* 160 */       this.field_177265_b = 1;
/*     */     }
/*     */     
/*     */     protected void func_177262_a() {
/* 164 */       this.field_177265_b += 1;
/*     */     }
/*     */     
/*     */     public float[] func_177263_b() {
/* 168 */       return this.field_177266_a;
/*     */     }
/*     */     
/*     */     @SideOnly(Side.CLIENT)
/*     */     public int func_177264_c() {
/* 173 */       return this.field_177265_b;
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List getBeamSegmentsUp() {
/* 179 */     return this.beamSegmentList;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float shouldBeamRender() {
/* 184 */     int i = (int)(this.field_70170_p.func_82737_E() - this.field_146016_i);
/* 185 */     this.field_146016_i = this.field_70170_p.func_82737_E();
/*     */     
/* 187 */     if (i > 1) {
/* 188 */       this.field_146014_j -= i / 40.0F;
/*     */       
/* 190 */       if (this.field_146014_j < 0.0F) {
/* 191 */         this.field_146014_j = 0.0F;
/*     */       }
/*     */     }
/*     */     
/* 195 */     this.field_146014_j += 0.025F;
/*     */     
/* 197 */     if (this.field_146014_j > 1.0F) {
/* 198 */       this.field_146014_j = 1.0F;
/*     */     }
/*     */     
/* 201 */     return this.field_146014_j;
/*     */   }
/*     */   
/*     */   private void func_174908_m() {
/* 205 */     int posY = (int)this.field_70163_u;
/* 206 */     this.beamSegmentList.clear();
/* 207 */     BeamSegment beamsegment = new BeamSegment(EntitySheep.func_175513_a(EnumDyeColor.LIGHT_BLUE));
/* 208 */     this.beamSegmentList.add(beamsegment);
/*     */     
/* 210 */     for (int i1 = 3; i1 < this.field_70170_p.func_72940_L(); i1++) {
/* 211 */       beamsegment.func_177262_a();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySkyBeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */