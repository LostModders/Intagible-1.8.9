/*     */ package emoniph.intangible.player.forms;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.Sound;
/*     */ import emoniph.intangible.api.IPossessable;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.network.PacketPipeline;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerEx.PacketEntityLivingAction.Action;
/*     */ import emoniph.intangible.player.PlayerEx.PacketTryPossess;
/*     */ import emoniph.intangible.player.PlayerEx.PacketTryPossess.Command;
/*     */ import emoniph.intangible.player.PlayerForm;
/*     */ import emoniph.intangible.souls.ShellRegistry;
/*     */ import emoniph.intangible.util.WorldPos;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.settings.GameSettings;
/*     */ import net.minecraft.client.settings.KeyBinding;
/*     */ import net.minecraft.entity.EntityCreature;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.MovingObjectPosition.MovingObjectType;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent.Post;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent.Pre;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityInteractEvent;
/*     */ import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class PlayerFormIncorporeal extends PlayerForm
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   private emoniph.intangible.client.ShellRenderer shellRenderer;
/*     */   
/*     */   public void initializeOn(PlayerEx playerEx)
/*     */   {
/*  47 */     playerEx.PLAYER.func_70105_a(0.5F, 0.9F);
/*  48 */     playerEx.PLAYER.eyeHeight = 0.75F;
/*  49 */     if (playerEx.isServerWorld()) {
/*  50 */       java.util.List<EntityLiving> list = playerEx.PLAYER.field_70170_p.func_72872_a(EntityLiving.class, playerEx.PLAYER.func_174813_aQ().func_72314_b(32.0D, 32.0D, 32.0D));
/*  51 */       for (EntityLiving entity : list) {
/*  52 */         if ((entity.func_70638_az() == playerEx.PLAYER) || (entity.func_70643_av() == playerEx.PLAYER)) {
/*  53 */           entity.func_70624_b(null);
/*  54 */           entity.func_70604_c(null);
/*     */         }
/*     */       }
/*     */       
/*  58 */       if (playerEx.PLAYER.field_70153_n != null) {
/*  59 */         playerEx.PLAYER.field_70153_n.func_70078_a(null);
/*     */       }
/*     */     }
/*     */     
/*  63 */     playerEx.initIncorporeal();
/*     */   }
/*     */   
/*     */   public void onLivingUpdate(PlayerEx playerEx)
/*     */   {
/*  68 */     if ((playerEx.PLAYER == null) || (playerEx.PLAYER.field_70170_p == null)) {
/*  69 */       return;
/*     */     }
/*     */     
/*  72 */     EntityLivingBase possessed = (EntityLivingBase)playerEx.PLAYER.field_70154_o;
/*     */     
/*  74 */     EntityPlayer p = playerEx.PLAYER;
/*  75 */     playerEx.PLAYER.func_70066_B();
/*  76 */     playerEx.PLAYER.func_82142_c(true);
/*  77 */     playerEx.PLAYER.func_70050_g(300);
/*  78 */     boolean remote = playerEx.PLAYER.field_70170_p.field_72995_K;
/*  79 */     if ((remote) && (playerEx.PLAYER.field_70131_O == 255.0F)) {
/*  80 */       playerEx.PLAYER.field_70131_O = 0.9F;
/*  81 */       if (p.func_174813_aQ().field_72337_e - p.func_174813_aQ().field_72338_b > 200.0D) {
/*  82 */         p.func_70107_b(p.field_70165_t, p.field_70163_u, p.field_70161_v);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  87 */     playerEx.PLAYER.func_70105_a(0.2F, 0.9F);
/*  88 */     playerEx.PLAYER.eyeHeight = 0.75F;
/*  89 */     if (remote) {
/*  90 */       if ((possessed == null) || (possessed.field_70131_O < 1.0F)) {
/*  91 */         playerEx.PLAYER.field_70131_O = 255.0F;
/*     */       }
/*  93 */       emoniph.intangible.Intangible.PROXY.highlightPlayerSoul(p);
/*     */     }
/*  95 */     playerEx.PLAYER.field_71075_bZ.field_75101_c = true;
/*  96 */     playerEx.PLAYER.field_70143_R = 0.0F;
/*     */     
/*  98 */     playerEx.PLAYER.field_70145_X = false;
/*     */     
/* 100 */     playerEx.tickIncorporeal();
/*     */     
/*     */ 
/* 103 */     if (possessed != null)
/*     */     {
/* 105 */       p.eyeHeight = Math.max(possessed.field_70131_O * 0.4F, 0.3F);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 115 */       possessed.field_70702_br = p.field_70702_br;
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 121 */       Vec3 lookVec = playerEx.PLAYER.func_70040_Z();
/* 122 */       float maxSpeed = (float)possessed.func_110148_a(net.minecraft.entity.SharedMonsterAttributes.field_111263_d).func_111126_e();
/* 123 */       float total = Math.abs(playerEx.PLAYER.field_70701_bs) + Math.abs(playerEx.PLAYER.field_70702_br);
/* 124 */       float speedF = maxSpeed * (playerEx.PLAYER.field_70701_bs != 0.0F ? playerEx.PLAYER.field_70701_bs / total : 0.0F);
/* 125 */       float speedS = maxSpeed * (playerEx.PLAYER.field_70702_br != 0.0F ? playerEx.PLAYER.field_70702_br / total : 0.0F);
/*     */       
/* 127 */       float speedScale = 1.0F;
/*     */       
/* 129 */       Vec3 strafeVec = lookVec.func_178785_b(1.5707964F);
/* 130 */       double newX = lookVec.field_72450_a * speedF * speedScale + strafeVec.field_72450_a * speedS * speedScale;
/* 131 */       double newZ = lookVec.field_72449_c * speedF * speedScale + strafeVec.field_72449_c * speedS * speedScale;
/* 132 */       boolean kbImmune = possessed instanceof emoniph.intangible.entity.EntityWreckingGolem;
/* 133 */       if ((kbImmune) || ((possessed.field_70159_w == 0.0D) && (possessed.field_70179_y == 0.0D)) || (new Vec3(newX, 0.0D, newZ).func_72430_b(new Vec3(possessed.field_70159_w, 0.0D, possessed.field_70179_y)) > 0.0D)) {
/* 134 */         possessed.field_70159_w = newX;
/* 135 */         possessed.field_70179_y = newZ;
/*     */       }
/* 137 */       possessed.field_70701_bs = speedF;
/*     */       
/* 139 */       if ((playerEx.isServerWorld()) && ((possessed instanceof EntityPlayer)) && ((playerEx.PLAYER.field_70701_bs != 0.0F) || (playerEx.PLAYER.field_70702_br != 0.0F))) {
/* 140 */         EntityPlayer possessedPlayer = (EntityPlayer)possessed;
/* 141 */         possessed.field_70177_z = p.field_70177_z;
/* 142 */         possessed.field_70126_B = p.field_70126_B;
/* 143 */         possessed.field_70125_A = p.field_70125_A;
/* 144 */         possessed.field_70127_C = p.field_70127_C;
/* 145 */         possessed.field_70759_as = p.field_70759_as;
/* 146 */         possessed.field_70758_at = p.field_70758_at;
/* 147 */         possessed.field_70727_aS = p.field_70727_aS;
/* 148 */         possessed.field_70726_aT = p.field_70726_aT;
/*     */       }
/*     */       else {
/* 151 */         possessed.field_70177_z = p.field_70177_z;
/* 152 */         possessed.field_70126_B = p.field_70126_B;
/* 153 */         possessed.field_70125_A = p.field_70125_A;
/* 154 */         possessed.field_70127_C = p.field_70127_C;
/* 155 */         possessed.field_70759_as = p.field_70759_as;
/* 156 */         possessed.field_70758_at = p.field_70758_at;
/* 157 */         possessed.field_70727_aS = p.field_70727_aS;
/* 158 */         possessed.field_70726_aT = p.field_70726_aT;
/*     */       }
/*     */     }
/*     */     else {
/* 162 */       WorldPos shellTarget = playerEx.getShells().getSelectedShell();
/*     */       
/* 164 */       if (shellTarget != null) {
/* 165 */         double maxDist = 1024.0D;
/* 166 */         Vec3 vec = shellTarget.getVectorFrom(playerEx.PLAYER);
/* 167 */         playerEx.PLAYER.field_70145_X = true;
/* 168 */         double distSq = vec.field_72450_a * vec.field_72450_a + vec.field_72449_c * vec.field_72449_c;
/* 169 */         int tpHeight = p.field_70170_p.field_73011_w.getActualHeight() - 30;
/* 170 */         if ((distSq > maxDist) && (p.field_70163_u > tpHeight)) {
/* 171 */           p.func_70634_a(shellTarget.getX() + 0.5D, tpHeight, shellTarget.getZ() + 0.5D);
/*     */         }
/*     */         
/*     */ 
/*     */ 
/* 176 */         double SPEED = 6.0D;
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 182 */         if (distSq > maxDist) {
/* 183 */           if (p.field_70163_u > tpHeight + 15) {
/* 184 */             p.field_70159_w = 0.0D;
/* 185 */             p.field_70181_x = 0.0D;
/* 186 */             p.field_70179_y = 0.0D;
/*     */           } else {
/* 188 */             p.field_70159_w = 0.0D;
/* 189 */             p.field_70181_x = 4.0D;
/* 190 */             p.field_70179_y = 0.0D;
/*     */           }
/*     */         }
/*     */         else
/*     */         {
/* 195 */           double distSqXYZ = vec.field_72450_a * vec.field_72450_a + vec.field_72448_b * vec.field_72448_b + vec.field_72449_c * vec.field_72449_c;
/*     */           
/* 197 */           if (distSqXYZ >= 12.0D) {
/* 198 */             double factor = 6.0D / Math.max(1.0D, Math.sqrt(distSqXYZ));
/*     */             
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 204 */             p.field_70159_w = (vec.field_72450_a * factor);
/* 205 */             p.field_70181_x = (vec.field_72448_b * factor);
/* 206 */             p.field_70179_y = (vec.field_72449_c * factor);
/*     */           }
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 217 */         boolean targetReached = shellTarget.distanceSqTo(playerEx.PLAYER) < 9.0D;
/* 218 */         if (targetReached)
/*     */         {
/*     */ 
/* 221 */           playerEx.PLAYER.func_70107_b(shellTarget.getX() + 0.5D, shellTarget.getY(), shellTarget.getZ() + 0.5D);
/* 222 */           playerEx.getShells().clearSelectedShell(playerEx.PLAYER.field_70170_p);
/* 223 */           playerEx.PLAYER.field_70159_w = 0.0D;
/* 224 */           playerEx.PLAYER.field_70181_x = 0.0D;
/* 225 */           playerEx.PLAYER.field_70179_y = 0.0D;
/* 226 */           playerEx.PLAYER.func_70105_a(0.5F, 0.9F);
/* 227 */           playerEx.PLAYER.field_70145_X = false;
/*     */           
/*     */ 
/*     */ 
/* 231 */           playerEx.PLAYER.field_71075_bZ.field_75100_b = false;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 242 */     if ((playerEx.PLAYER.field_70153_n != null) && ((playerEx.PLAYER.field_70153_n instanceof EntityPlayer)) && 
/* 243 */       (playerEx.isClientWorld()))
/*     */     {
/* 245 */       playerEx.PLAYER.field_70701_bs = 0.0F;
/* 246 */       playerEx.PLAYER.field_70702_br = 0.0F;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 253 */     super.onLivingUpdate(playerEx);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onMountEntity(PlayerEx playerEx, net.minecraftforge.event.entity.EntityMountEvent event) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onJumpKey(PlayerEx playerEx)
/*     */   {
/* 281 */     EntityLivingBase possessed = (EntityLivingBase)playerEx.PLAYER.field_70154_o;
/* 282 */     if ((possessed != null) && (!Minecraft.func_71410_x().field_71456_v.func_146158_b().func_146241_e()) && ((playerEx.PLAYER.field_71070_bA == null) || (playerEx.PLAYER.field_71070_bA.field_75152_c == 0)))
/*     */     {
/* 284 */       if ((possessed instanceof IPossessable)) {
/* 285 */         IPossessable possessable = (IPossessable)possessed;
/* 286 */         possessable.onJumpKey(playerEx.PLAYER);
/*     */       }
/* 288 */       else if (possessed.field_70122_E) {
/* 289 */         Get.pipeline().sendToServer(new emoniph.intangible.player.PlayerEx.PacketEntityLivingAction(possessed, PlayerEx.PacketEntityLivingAction.Action.JUMP));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onJump(PlayerEx playerEx, net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent event) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onInteractWithEntity(PlayerEx playerEx, EntityInteractEvent event)
/*     */   {
/* 305 */     if (playerEx.isClientWorld()) {
/* 306 */       EntityLivingBase possessed = (EntityLivingBase)playerEx.PLAYER.field_70154_o;
/* 307 */       if ((possessed == null) && 
/* 308 */         ((event.target instanceof EntityLivingBase)) && (!(event.target instanceof emoniph.intangible.entity.EntitySoul))) {
/* 309 */         Get.pipeline().sendToServer(new PlayerEx.PacketTryPossess((EntityLivingBase)event.target, PlayerEx.PacketTryPossess.Command.POSSESS, new BlockPos(event.target)));
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 317 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */   public void onInteract(PlayerEx playerEx, PlayerInteractEvent event)
/*     */   {
/* 322 */     boolean allow = false;
/* 323 */     EntityLivingBase possessed = (EntityLivingBase)playerEx.PLAYER.field_70154_o;
/*     */     
/* 325 */     if ((possessed != null) && ((possessed instanceof IPossessable))) {
/* 326 */       IPossessable possessable = (IPossessable)possessed;
/* 327 */       MovingObjectPosition mop = emoniph.intangible.util.RayTraceUtil.traceBlock(playerEx.PLAYER, true, 5.0D);
/* 328 */       BlockPos pos = (mop != null) && (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) ? mop.func_178782_a() : null;
/*     */       
/* 330 */       if (event.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
/* 331 */         event.setCanceled(true);
/* 332 */         return;
/*     */       }
/* 334 */       if ((event.world.field_72995_K) && (possessable.onUseAction(playerEx.PLAYER, pos))) {
/* 335 */         Get.pipeline().sendToServer(new PlayerEx.PacketTryPossess(possessed, PlayerEx.PacketTryPossess.Command.USE, pos));
/* 336 */         event.setCanceled(true);
/* 337 */         return;
/*     */       }
/*     */     }
/*     */     
/* 341 */     if (event.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
/* 342 */       if (playerEx.getShells().getSelectedShell() != null)
/*     */       {
/* 344 */         if (playerEx.isActionPossible()) {
/* 345 */           Get.pipeline().sendToServer(new emoniph.intangible.player.PlayerEx.PacketEntityLivingAction(playerEx.PLAYER, PlayerEx.PacketEntityLivingAction.Action.RIGHT_CLICK_BLOCK));
/* 346 */           playerEx.getPlayerForm().onClientAction(playerEx, PlayerEx.PacketEntityLivingAction.Action.RIGHT_CLICK_BLOCK);
/*     */         }
/*     */         
/*     */ 
/*     */       }
/* 351 */       else if (trySelectShellTarget(playerEx))
/*     */       {
/* 353 */         if (playerEx.isActionPossible()) {
/* 354 */           playerEx.initIncorporeal();
/* 355 */           Sound.MOD_RANDOM_CHOIR1.playOnlyTo(playerEx.PLAYER, 0.1F, 0.7F);
/* 356 */           if (playerEx.isClientWorld())
/*     */           {
/* 358 */             Get.pipeline().sendToServer(new emoniph.intangible.player.PlayerEx.PacketSelectShell(playerEx.getShells().getSelectedShellIndex()));
/*     */           }
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 364 */         IBlockState state = event.world.func_180495_p(event.pos);
/* 365 */         if (state.func_177230_c() == Get.blocks().PLAYER_SHELL) {
/* 366 */           if (!Get.blocks().PLAYER_SHELL.isOwner(event.world, event.pos, state, playerEx.PLAYER)) {}
/*     */         }
/*     */         else {
/* 369 */           if (state.func_177230_c() == Get.blocks().GOLEM_FACTORY) {
/* 370 */             return;
/*     */           }
/* 372 */           BlockPos playerPos = new BlockPos(playerEx.PLAYER);
/* 373 */           BlockPos expectedPlayerPos = event.pos.func_177972_a(event.face);
/* 374 */           net.minecraft.util.EnumFacing face = event.face;
/* 375 */           if (event.pos.equals(playerPos)) {
/* 376 */             expectedPlayerPos = playerPos;
/* 377 */             face = face.func_176734_d();
/*     */           }
/*     */           
/* 380 */           BlockPos pos = event.pos;
/* 381 */           if (playerPos.equals(expectedPlayerPos)) {
/* 382 */             for (int i = 0; i < 3; i++) {
/* 383 */               pos = pos.func_177972_a(face.func_176734_d());
/* 384 */               if (playerEx.PLAYER.field_70170_p.func_180495_p(pos).func_177230_c().func_149688_o().func_76222_j()) {
/* 385 */                 if (playerEx.isServerWorld()) {
/* 386 */                   playerEx.PLAYER.func_70634_a(pos.func_177958_n() + 0.5D, pos.func_177956_o(), pos.func_177952_p() + 0.5D);
/* 387 */                   Sound.MOD_RANDOM_CHOIR1.playOnlyTo(playerEx.PLAYER, 0.1F, 0.7F);
/*     */                 }
/* 389 */                 allow = event.world.field_72995_K;
/* 390 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 399 */     if (!allow) {
/* 400 */       event.setCanceled(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onClientAction(PlayerEx playerEx, PlayerEx.PacketEntityLivingAction.Action command)
/*     */   {
/* 408 */     switch (command) {
/*     */     case RIGHT_CLICK_AIR: 
/*     */     case RIGHT_CLICK_BLOCK: 
/* 411 */       if (playerEx.getShells().getSelectedShell() != null) {
/* 412 */         playerEx.getShells().clearSelectedShell(playerEx.PLAYER.field_70170_p);
/*     */       } else {
/* 414 */         trySelectShellTarget(playerEx);
/*     */       }
/*     */       
/*     */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */   public void onMouseEvent(PlayerEx playerEx, net.minecraftforge.client.event.MouseEvent event) {}
/*     */   
/*     */   public void onMouseEventPost(PlayerEx playerEx, net.minecraftforge.fml.common.gameevent.InputEvent.MouseInputEvent event)
/*     */   {
/* 426 */     if (Minecraft.func_71410_x().field_71474_y.field_74312_F.func_151468_f()) {
/* 427 */       Minecraft.func_71410_x().field_71474_y.field_74312_F.func_74505_d();
/*     */       
/* 429 */       EntityLivingBase possessed = (EntityLivingBase)playerEx.PLAYER.field_70154_o;
/* 430 */       if ((possessed != null) && ((possessed instanceof IPossessable))) {
/* 431 */         IPossessable possessable = (IPossessable)possessed;
/* 432 */         MovingObjectPosition mop = emoniph.intangible.util.RayTraceUtil.traceBlock(playerEx.PLAYER, true, 5.0D);
/* 433 */         BlockPos pos = (mop != null) && (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) ? mop.func_178782_a() : null;
/* 434 */         if (possessable.onAttackAction(playerEx.PLAYER, pos)) {
/* 435 */           Get.pipeline().sendToServer(new PlayerEx.PacketTryPossess(possessed, PlayerEx.PacketTryPossess.Command.ATTACK, pos));
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onKeyInputEvent(PlayerEx playerEx, net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent event)
/*     */   {
/* 443 */     if (!emoniph.intangible.util.GuiUtil.isMousePointerActive()) {
/* 444 */       if (Minecraft.func_71410_x().field_71474_y.field_74312_F.func_151468_f()) {
/* 445 */         Minecraft.func_71410_x().field_71474_y.field_74312_F.func_74505_d();
/*     */         
/* 447 */         possessed = (EntityLivingBase)playerEx.PLAYER.field_70154_o;
/* 448 */         if ((possessed != null) && ((possessed instanceof IPossessable))) {
/* 449 */           possessable = (IPossessable)possessed;
/* 450 */           mop = emoniph.intangible.util.RayTraceUtil.traceBlock(playerEx.PLAYER, true, 4.0D);
/* 451 */           BlockPos pos = (mop != null) && (mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) ? mop.func_178782_a() : null;
/* 452 */           if (possessable.onAttackAction(playerEx.PLAYER, pos)) {
/* 453 */             Get.pipeline().sendToServer(new PlayerEx.PacketTryPossess(possessed, PlayerEx.PacketTryPossess.Command.ATTACK, pos));
/*     */           }
/*     */         }
/*     */       }
/*     */       
/* 458 */       if (Minecraft.func_71410_x().field_71474_y.field_74316_C.func_151468_f()) {
/* 459 */         Minecraft.func_71410_x().field_71474_y.field_74316_C.func_74505_d();
/*     */       }
/*     */       
/* 462 */       EntityLivingBase possessed = Minecraft.func_71410_x().field_71474_y.field_74324_K;IPossessable possessable = possessed.length; for (MovingObjectPosition mop = 0; mop < possessable; mop++) { KeyBinding key = possessed[mop];
/* 463 */         if (key.func_151466_e().equals("key.categories.inventory")) {
/* 464 */           key.func_74505_d();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean trySelectShellTarget(PlayerEx playerEx) {
/* 471 */     EntityPlayer player = playerEx.PLAYER;
/* 472 */     float pitch = player.field_70125_A + 90.0F;
/* 473 */     float yaw = player.field_70759_as % 360.0F;
/* 474 */     if (yaw < 0.0F) {
/* 475 */       yaw += 360.0F;
/*     */     }
/*     */     
/* 478 */     int i = -1;
/* 479 */     for (WorldPos pos : playerEx.getShells()) {
/* 480 */       i++;
/* 481 */       if (pos.isForWorld(playerEx.PLAYER.field_70170_p)) {
/* 482 */         Vec3 vec = pos.getVectorFrom(player);
/* 483 */         double vecLenH = Math.sqrt(vec.field_72450_a * vec.field_72450_a + vec.field_72449_c * vec.field_72449_c);
/* 484 */         double angleFromNormDegV = 90.0D - Math.toDegrees(Math.atan2(vec.field_72448_b, vecLenH));
/* 485 */         double angleFromNormDegH = -Math.toDegrees(Math.atan2(vec.field_72450_a, vec.field_72449_c));
/* 486 */         if (angleFromNormDegH < 0.0D) {
/* 487 */           angleFromNormDegH += 360.0D;
/*     */         }
/*     */         
/* 490 */         double vecAngleDiffV = angleFromNormDegV - pitch;
/* 491 */         double vecAngleDiffH = angleFromNormDegH - yaw;
/* 492 */         if (vecAngleDiffH < 0.0D) {
/* 493 */           vecAngleDiffH += 360.0D;
/*     */         }
/* 495 */         if ((vecAngleDiffH <= 90.0D) || (vecAngleDiffH >= 270.0D))
/*     */         {
/*     */ 
/*     */ 
/* 499 */           boolean selected = ((vecAngleDiffH > 358.5D) || (vecAngleDiffH < 1.5D)) && (vecAngleDiffV > -1.5D) && (vecAngleDiffV < 1.5D);
/* 500 */           if (selected) {
/* 501 */             playerEx.getShells().setSelectedShell(i);
/*     */             
/* 503 */             return true;
/*     */           }
/*     */         }
/*     */       } }
/* 507 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderScreenOverlays(PlayerEx playerEx, RenderGameOverlayEvent.Pre event)
/*     */   {
/* 516 */     if (playerEx.PLAYER.field_70154_o == null) {
/* 517 */       if (this.shellRenderer == null) {
/* 518 */         this.shellRenderer = new emoniph.intangible.client.ShellRenderer(Minecraft.func_71410_x());
/*     */       }
/* 520 */       this.shellRenderer.renderShells(playerEx.PLAYER, event.resolution.func_78326_a(), event.resolution.func_78328_b());
/*     */     }
/*     */   }
/*     */   
/*     */   public void onFall(PlayerEx playerEx, net.minecraftforge.event.entity.living.LivingFallEvent event)
/*     */   {
/* 526 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */   public void onEntityItemPickup(PlayerEx playerEx, EntityItemPickupEvent event) {
/* 530 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */   public void onHurtBy(PlayerEx playerEx, LivingHurtEvent event)
/*     */   {
/* 535 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */ 
/*     */   public void onDeath(PlayerEx playerEx, net.minecraftforge.event.entity.living.LivingDeathEvent event) {}
/*     */   
/*     */ 
/*     */   public void onTargeted(PlayerEx playerEx, LivingSetAttackTargetEvent event)
/*     */   {
/* 544 */     if ((playerEx.isServerWorld()) && ((event.entityLiving instanceof EntityLiving))) {
/* 545 */       EntityLiving entity = (EntityLiving)event.entity;
/* 546 */       entity.func_70624_b(null);
/* 547 */       if ((entity instanceof EntityCreature)) {
/* 548 */         EntityCreature creature = (EntityCreature)entity;
/* 549 */         if (creature.func_70643_av() == playerEx.PLAYER) {
/* 550 */           creature.func_70604_c(null);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void onTargetedByWither(PlayerEx playerEx, net.minecraft.entity.boss.EntityWither wither, int targetIndex)
/*     */   {
/* 558 */     wither.func_82211_c(targetIndex, 0);
/*     */   }
/*     */   
/*     */   public void onAttackedBy(PlayerEx playerEx, net.minecraftforge.event.entity.living.LivingAttackEvent event)
/*     */   {
/* 563 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderTickStart(PlayerEx playerEx) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderTickEnd(PlayerEx playerEx) {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void onRenderLivingBaseStart(PlayerEx ourPlayer, EntityLivingBase target, RenderLivingEvent.Pre event)
/*     */   {
/* 594 */     super.onRenderLivingBaseStart(ourPlayer, target, event);
/* 595 */     EntityLivingBase possessed = (EntityLivingBase)ourPlayer.PLAYER.field_70154_o;
/* 596 */     Minecraft mc = Minecraft.func_71410_x();
/* 597 */     if ((possessed == target) && (mc.field_71474_y.field_74320_O == 0) && (!mc.field_71474_y.field_74319_N) && (!mc.field_71442_b.func_78747_a())) {
/* 598 */       if (((possessed instanceof IPossessable)) && 
/* 599 */         (((IPossessable)possessed).allowFirstPersonRender())) {
/* 600 */         return;
/*     */       }
/*     */       
/* 603 */       event.setCanceled(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onRenderLivingBaseEnd(PlayerEx ourPlayer, EntityLivingBase target, RenderLivingEvent.Post event)
/*     */   {
/* 609 */     super.onRenderLivingBaseEnd(ourPlayer, target, event);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderPlayerStart(PlayerEx playerEx, RenderLivingEvent.Pre event)
/*     */   {
/* 615 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderPlayerEnd(PlayerEx playerEx, RenderLivingEvent.Post event) {}
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void onRenderHand(PlayerEx playerEx, net.minecraftforge.client.event.RenderHandEvent event)
/*     */   {
/* 626 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void renderNameplate(PlayerEx playerEx, net.minecraftforge.client.event.RenderLivingEvent.Specials.Pre event)
/*     */   {
/* 632 */     event.setCanceled(true);
/*     */   }
/*     */   
/*     */   public boolean isVisible()
/*     */   {
/* 637 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/forms/PlayerFormIncorporeal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */