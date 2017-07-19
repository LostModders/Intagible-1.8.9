/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import emoniph.intangible.player.PlayerEx.PacketMotion;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumParticleTypes;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntityFood extends EntityThrowable implements net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData
/*     */ {
/*     */   private ItemStack stack;
/*     */   
/*     */   public EntityFood(World worldIn)
/*     */   {
/*  28 */     super(worldIn);
/*     */   }
/*     */   
/*     */   public EntityFood(World worldIn, EntityLivingBase throwerIn, ItemStack stack) {
/*  32 */     super(worldIn, throwerIn);
/*  33 */     this.stack = stack;
/*     */   }
/*     */   
/*     */   public EntityFood(World worldIn, double x, double y, double z, ItemStack stack) {
/*  37 */     super(worldIn, x, y, z);
/*  38 */     this.stack = stack;
/*     */   }
/*     */   
/*     */   public String func_70005_c_()
/*     */   {
/*  43 */     return this.stack == null ? super.func_70005_c_() : this.stack.func_82833_r();
/*     */   }
/*     */   
/*     */   protected void func_70184_a(MovingObjectPosition objectPosition)
/*     */   {
/*  48 */     if (objectPosition.field_72308_g != null) {
/*  49 */       float damage = 2.0F;
/*  50 */       objectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, func_85052_h()), damage);
/*  51 */       if (!this.field_70170_p.field_72995_K) {
/*  52 */         if ((objectPosition.field_72308_g instanceof net.minecraft.entity.boss.IBossDisplayData)) {
/*  53 */           objectPosition.field_72308_g.field_70159_w = 0.0D;
/*  54 */           objectPosition.field_72308_g.field_70179_y = 0.0D;
/*  55 */           return;
/*     */         }
/*     */         
/*  58 */         Vec3 motion = new Vec3(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72432_b();
/*     */         
/*  60 */         double speed = 0.5D;
/*  61 */         double mx = motion.field_72450_a * speed;
/*  62 */         double my = motion.field_72448_b * speed;
/*  63 */         double mz = motion.field_72449_c * speed;
/*     */         
/*     */ 
/*  66 */         if ((objectPosition.field_72308_g instanceof EntityPlayer)) {
/*  67 */           EntityPlayer player = (EntityPlayer)objectPosition.field_72308_g;
/*  68 */           Get.pipeline().sendTo(new PlayerEx.PacketMotion(player, mx, my, mz), player);
/*     */         } else {
/*  70 */           objectPosition.field_72308_g.field_70159_w = mx;
/*  71 */           objectPosition.field_72308_g.field_70181_x = my;
/*  72 */           objectPosition.field_72308_g.field_70179_y = mz;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  77 */     for (int j = 0; j < 8; j++) {
/*  78 */       this.field_70170_p.func_175688_a(EnumParticleTypes.SNOWBALL, this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D, new int[0]);
/*     */     }
/*     */     
/*  81 */     if (!this.field_70170_p.field_72995_K) {
/*  82 */       func_70106_y();
/*  83 */       EntityItem item = new EntityItem(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.stack);
/*  84 */       item.field_70159_w = 0.0D;
/*  85 */       item.field_70181_x = 0.0D;
/*  86 */       item.field_70179_y = 0.0D;
/*  87 */       this.field_70170_p.func_72838_d(item);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/*  93 */     super.func_70014_b(compound);
/*  94 */     if (this.stack != null) {
/*  95 */       compound.func_74782_a("stack", this.stack.func_77955_b(new NBTTagCompound()));
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 101 */     super.func_70037_a(compound);
/* 102 */     if (compound.func_150297_b("stack", 10)) {
/* 103 */       this.stack = ItemStack.func_77949_a(compound.func_74775_l("stack"));
/*     */     } else {
/* 105 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf buf)
/*     */   {
/* 111 */     ByteBufUtils.writeItemStack(buf, this.stack);
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf buf)
/*     */   {
/* 116 */     this.stack = ByteBufUtils.readItemStack(buf);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ItemStack getItemStack() {
/* 121 */     return this.stack;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityFood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */