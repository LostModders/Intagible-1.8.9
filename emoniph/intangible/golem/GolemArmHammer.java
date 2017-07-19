/*     */ package emoniph.intangible.golem;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.BodySide;
/*     */ import emoniph.intangible.api.IFakePlayerProvider;
/*     */ import emoniph.intangible.client.models.ModelGolemArm;
/*     */ import emoniph.intangible.util.RayTraceUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class GolemArmHammer extends GolemArm
/*     */ {
/*     */   public boolean canSwing()
/*     */   {
/*  29 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canStartBlocks()
/*     */   {
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   protected ModelGolemArm createModel(BodySide side)
/*     */   {
/*  40 */     return new emoniph.intangible.client.models.ModelGolemArmHammer(side);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onUseAction(World world, EntityPlayer player, final EntityLiving golem, IFakePlayerProvider fakePlayerProvider, BlockPos targetPos, BodySide side)
/*     */   {
/*  46 */     Vec3 look = golem.func_70040_Z();
/*  47 */     List<EntityLivingBase> list = world.func_72872_a(EntityLivingBase.class, golem.func_174813_aQ().func_72314_b(1.0D, 2.0D, 1.0D));
/*  48 */     boolean targets = false;
/*     */     
/*  50 */     if (!world.field_72995_K) {
/*  51 */       Sound.MOD_RANDOM_MELEE.playToAllNear(player, 0.7F);
/*     */     }
/*     */     
/*  54 */     for (EntityLivingBase entity : list) {
/*  55 */       if ((entity != golem) && (look.func_72430_b(new Vec3(entity.field_70165_t - golem.field_70165_t, entity.field_70163_u - golem.field_70163_u, entity.field_70161_v - golem.field_70161_v)) > 0.0D) && (entity != player))
/*     */       {
/*  57 */         if (!world.field_72995_K) {
/*  58 */           final EntityLivingBase targetEntity = entity;
/*  59 */           ((WorldServer)world).func_152344_a(new Runnable()
/*     */           {
/*     */             public void run() {
/*  62 */               golem.func_70652_k(targetEntity);
/*     */             }
/*     */           });
/*     */         }
/*  66 */         targets = true;
/*     */       }
/*     */     }
/*     */     BlockPos left;
/*  70 */     if ((!targets) && (!world.field_72995_K) && (targetPos != null)) {
/*  71 */       MovingObjectPosition mop = RayTraceUtil.traceBlock(player, false, 5.0D);
/*  72 */       if (mop != null) {
/*  73 */         ItemStack stack = new ItemStack(Items.field_151046_w);
/*  74 */         EntityPlayer fake = fakePlayerProvider.getFakePlayer();
/*  75 */         fake.func_70062_b(0, stack);
/*     */         
/*     */ 
/*  78 */         switch (mop.field_178784_b) {
/*     */         case UP: 
/*     */         case DOWN: 
/*  81 */           if (breakBlock(fake, mop.func_178782_a(), stack, true)) {
/*  82 */             breakBlock(fake, mop.func_178782_a().func_177978_c(), stack, false);
/*  83 */             breakBlock(fake, mop.func_178782_a().func_177978_c().func_177974_f(), stack, false);
/*  84 */             breakBlock(fake, mop.func_178782_a().func_177978_c().func_177976_e(), stack, false);
/*  85 */             breakBlock(fake, mop.func_178782_a().func_177974_f(), stack, false);
/*     */             
/*  87 */             breakBlock(fake, mop.func_178782_a().func_177976_e(), stack, false);
/*  88 */             breakBlock(fake, mop.func_178782_a().func_177968_d(), stack, false);
/*  89 */             breakBlock(fake, mop.func_178782_a().func_177968_d().func_177974_f(), stack, false);
/*  90 */             breakBlock(fake, mop.func_178782_a().func_177968_d().func_177976_e(), stack, false);
/*     */           }
/*     */           break;
/*     */         default: 
/*  94 */           if (breakBlock(fake, mop.func_178782_a(), stack, true)) {
/*  95 */             breakBlock(fake, mop.func_178782_a().func_177984_a(), stack, false);
/*  96 */             breakBlock(fake, mop.func_178782_a().func_177977_b(), stack, false);
/*  97 */             breakBlock(fake, mop.func_178782_a().func_177979_c(2), stack, false);
/*     */             
/*     */ 
/* 100 */             BlockPos right = mop.func_178782_a().func_177972_a(mop.field_178784_b.func_176746_e());
/* 101 */             breakBlock(fake, right, stack, false);
/* 102 */             breakBlock(fake, right.func_177984_a(), stack, false);
/* 103 */             breakBlock(fake, right.func_177977_b(), stack, false);
/* 104 */             breakBlock(fake, right.func_177979_c(2), stack, false);
/*     */             
/* 106 */             left = mop.func_178782_a().func_177972_a(mop.field_178784_b.func_176735_f());
/* 107 */             breakBlock(fake, left, stack, false);
/* 108 */             breakBlock(fake, left.func_177984_a(), stack, false);
/* 109 */             breakBlock(fake, left.func_177977_b(), stack, false);
/* 110 */             breakBlock(fake, left.func_177979_c(2), stack, false);
/*     */           }
/*     */           
/*     */           break;
/*     */         }
/*     */         
/* 116 */         List<EntityItem> items = world.func_72872_a(EntityItem.class, golem.func_174813_aQ().func_72314_b(5.0D, 2.0D, 5.0D));
/* 117 */         for (Entity item : items) {
/* 118 */           item.func_70634_a(golem.field_70165_t, golem.field_70163_u, golem.field_70161_v);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 123 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemArmHammer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */