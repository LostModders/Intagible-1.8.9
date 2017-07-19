/*     */ package emoniph.intangible.golem;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.BodySide;
/*     */ import emoniph.intangible.api.IFakePlayerProvider;
/*     */ import emoniph.intangible.client.models.ModelGolemArm;
/*     */ import emoniph.intangible.util.RayTraceUtil;
/*     */ import java.util.Random;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class GolemArmClaw extends GolemArm
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
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected ModelGolemArm createModel(BodySide side)
/*     */   {
/*  40 */     return new emoniph.intangible.client.models.ModelGolemArmClaw(side);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean onUseAction(World world, EntityPlayer player, final EntityLiving golem, IFakePlayerProvider fakePlayerProvider, BlockPos targetPos, BodySide side)
/*     */   {
/*  46 */     if (!world.field_72995_K) {
/*  47 */       Sound.MOD_RANDOM_CLUNK.playToAllNear(player, 0.7F, 1.0F);
/*     */     }
/*     */     
/*  50 */     final MovingObjectPosition pos = RayTraceUtil.traceEntity(player, 3.0D, true, new net.minecraft.entity.EntityLivingBase[] { golem });
/*  51 */     BlockPos left; if ((pos != null) && (pos.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.ENTITY))
/*     */     {
/*  53 */       if (!world.field_72995_K) {
/*  54 */         ((WorldServer)world).func_152344_a(new Runnable()
/*     */         {
/*     */           public void run() {
/*  57 */             boolean flag = pos.field_72308_g.func_70097_a(DamageSource.func_76358_a(golem), 10 + golem.field_70170_p.field_73012_v.nextInt(15));
/*  58 */             if (flag) {
/*  59 */               pos.field_72308_g.field_70181_x += 0.1000000059604645D;
/*     */             }
/*     */             
/*  62 */             golem.func_85030_a("mob.irongolem.throw", 1.0F, 1.0F);
/*     */           }
/*     */           
/*     */ 
/*     */         });
/*     */       }
/*     */     }
/*  69 */     else if ((!world.field_72995_K) && (targetPos != null)) {
/*  70 */       MovingObjectPosition mop = RayTraceUtil.traceBlock(player, false, 5.0D);
/*  71 */       if (mop != null) {
/*  72 */         ItemStack stack = new ItemStack(Items.field_151047_v);
/*  73 */         EntityPlayer fake = fakePlayerProvider.getFakePlayer();
/*  74 */         fake.func_70062_b(0, stack);
/*     */         
/*  76 */         switch (mop.field_178784_b) {
/*     */         case UP: 
/*     */         case DOWN: 
/*  79 */           if (breakBlock(fake, mop.func_178782_a(), stack, true)) {
/*  80 */             breakBlock(fake, mop.func_178782_a().func_177978_c(), stack, false);
/*  81 */             breakBlock(fake, mop.func_178782_a().func_177978_c().func_177974_f(), stack, false);
/*  82 */             breakBlock(fake, mop.func_178782_a().func_177978_c().func_177976_e(), stack, false);
/*  83 */             breakBlock(fake, mop.func_178782_a().func_177974_f(), stack, false);
/*  84 */             breakBlock(fake, mop.func_178782_a().func_177976_e(), stack, false);
/*  85 */             breakBlock(fake, mop.func_178782_a().func_177968_d(), stack, false);
/*  86 */             breakBlock(fake, mop.func_178782_a().func_177968_d().func_177974_f(), stack, false);
/*  87 */             breakBlock(fake, mop.func_178782_a().func_177968_d().func_177976_e(), stack, false);
/*     */           }
/*     */           break;
/*     */         default: 
/*  91 */           if (breakBlock(fake, mop.func_178782_a(), stack, true)) {
/*  92 */             breakBlock(fake, mop.func_178782_a().func_177984_a(), stack, false);
/*  93 */             breakBlock(fake, mop.func_178782_a().func_177977_b(), stack, false);
/*  94 */             breakBlock(fake, mop.func_178782_a().func_177979_c(2), stack, false);
/*     */             
/*     */ 
/*  97 */             BlockPos right = mop.func_178782_a().func_177972_a(mop.field_178784_b.func_176746_e());
/*  98 */             breakBlock(fake, right, stack, false);
/*  99 */             breakBlock(fake, right.func_177984_a(), stack, false);
/* 100 */             breakBlock(fake, right.func_177977_b(), stack, false);
/* 101 */             breakBlock(fake, right.func_177979_c(2), stack, false);
/*     */             
/* 103 */             left = mop.func_178782_a().func_177972_a(mop.field_178784_b.func_176735_f());
/* 104 */             breakBlock(fake, left, stack, false);
/* 105 */             breakBlock(fake, left.func_177984_a(), stack, false);
/* 106 */             breakBlock(fake, left.func_177977_b(), stack, false);
/* 107 */             breakBlock(fake, left.func_177979_c(2), stack, false);
/*     */           }
/*     */           
/*     */           break;
/*     */         }
/*     */         
/* 113 */         java.util.List<EntityItem> items = world.func_72872_a(EntityItem.class, golem.func_174813_aQ().func_72314_b(5.0D, 2.0D, 5.0D));
/* 114 */         for (Entity item : items) {
/* 115 */           item.func_70634_a(golem.field_70165_t, golem.field_70163_u, golem.field_70161_v);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 120 */     return true;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemArmClaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */