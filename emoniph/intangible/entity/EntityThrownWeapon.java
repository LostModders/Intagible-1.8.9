/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class EntityThrownWeapon extends EntityThrowable implements net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData
/*     */ {
/*     */   private ItemStack stack;
/*     */   private int impactStrength;
/*     */   
/*     */   public EntityThrownWeapon(World worldIn)
/*     */   {
/*  24 */     super(worldIn);
/*     */   }
/*     */   
/*     */   public EntityThrownWeapon(World worldIn, EntityLivingBase throwerIn, ItemStack stack, int impactStrength) {
/*  28 */     super(worldIn, throwerIn);
/*  29 */     this.stack = stack;
/*  30 */     this.impactStrength = impactStrength;
/*     */   }
/*     */   
/*     */   public EntityThrownWeapon(World worldIn, double x, double y, double z, ItemStack stack, int impactStrength) {
/*  34 */     super(worldIn, x, y, z);
/*  35 */     this.stack = stack;
/*  36 */     this.impactStrength = impactStrength;
/*     */   }
/*     */   
/*     */   public String func_70005_c_()
/*     */   {
/*  41 */     return this.stack == null ? super.func_70005_c_() : this.stack.func_82833_r();
/*     */   }
/*     */   
/*     */   protected void func_70184_a(MovingObjectPosition objectPosition)
/*     */   {
/*  46 */     if (objectPosition != null) {
/*  47 */       if ((objectPosition.field_72308_g != null) && ((objectPosition.field_72308_g instanceof EntityLivingBase))) {
/*  48 */         float damage = 4.0F;
/*  49 */         if ((this.stack != null) && (this.stack.func_77973_b() != null)) {
/*  50 */           Block block = Block.func_149634_a(this.stack.func_77973_b());
/*  51 */           if (block != null) {
/*  52 */             damage += (float)Math.min(Math.round(Math.sqrt(Math.max(1.0F, block.func_149638_a(this) * 5.0F))), 10L);
/*     */           }
/*     */         }
/*  55 */         objectPosition.field_72308_g.func_70097_a(DamageSource.func_76356_a(this, func_85052_h()), damage);
/*  56 */         if (!this.field_70170_p.field_72995_K) {
/*  57 */           Sound.MOD_RANDOM_SQUELCH.playToAllNear(this, 0.5F, 1.5F);
/*     */         }
/*     */       }
/*  60 */       if ((this.impactStrength > 0) && (objectPosition.field_72313_a != net.minecraft.util.MovingObjectPosition.MovingObjectType.MISS) && 
/*  61 */         (!this.field_70170_p.field_72995_K)) {
/*  62 */         this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.impactStrength, true);
/*     */       }
/*     */       
/*  65 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/*  71 */     super.func_70014_b(compound);
/*  72 */     if (this.stack != null) {
/*  73 */       compound.func_74782_a("stack", this.stack.func_77955_b(new NBTTagCompound()));
/*  74 */       compound.func_74768_a("impact", this.impactStrength);
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/*  80 */     super.func_70037_a(compound);
/*  81 */     if (compound.func_150297_b("stack", 10)) {
/*  82 */       this.stack = ItemStack.func_77949_a(compound.func_74775_l("stack"));
/*  83 */       this.impactStrength = (compound.func_74764_b("impact") ? compound.func_74762_e("impact") : 0);
/*     */     } else {
/*  85 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf buf)
/*     */   {
/*  91 */     ByteBufUtils.writeItemStack(buf, this.stack);
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf buf)
/*     */   {
/*  96 */     this.stack = ByteBufUtils.readItemStack(buf);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ItemStack getItemStack() {
/* 101 */     return this.stack;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityThrownWeapon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */