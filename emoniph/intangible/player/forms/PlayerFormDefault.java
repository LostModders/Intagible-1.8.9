/*     */ package emoniph.intangible.player.forms;
/*     */ 
/*     */ import emoniph.intangible.client.DestinationRenderer;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerForm;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ 
/*     */ public class PlayerFormDefault extends PlayerForm
/*     */ {
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   private DestinationRenderer destinationRenderer;
/*     */   
/*     */   public void initializeOn(PlayerEx playerEx)
/*     */   {
/*  20 */     EntityPlayer player = playerEx.PLAYER;
/*  21 */     player.func_70105_a(0.6F, 1.8F);
/*  22 */     player.eyeHeight = player.getDefaultEyeHeight();
/*  23 */     if (!player.func_70644_a(net.minecraft.potion.Potion.field_76441_p)) {
/*  24 */       playerEx.PLAYER.func_82142_c(false);
/*     */     }
/*     */     
/*  27 */     if (!player.field_71075_bZ.field_75098_d) {
/*  28 */       player.field_71075_bZ.field_75101_c = false;
/*  29 */       if (player.field_71075_bZ.field_75100_b) {
/*  30 */         player.field_71075_bZ.field_75100_b = false;
/*     */       }
/*     */     }
/*     */     
/*  34 */     playerEx.getShells().clearSelectedShell(playerEx.PLAYER.field_70170_p);
/*  35 */     playerEx.PLAYER.field_70145_X = false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public void renderScreenOverlays(PlayerEx playerEx, RenderGameOverlayEvent.Pre event)
/*     */   {
/*  45 */     if (this.destinationRenderer == null) {
/*  46 */       this.destinationRenderer = new DestinationRenderer(net.minecraft.client.Minecraft.func_71410_x());
/*     */     }
/*  48 */     this.destinationRenderer.render(playerEx.PLAYER, event.resolution.func_78326_a(), event.resolution.func_78328_b());
/*     */   }
/*     */   
/*     */   public void onInteract(PlayerEx playerEx, PlayerInteractEvent event)
/*     */   {
/*  53 */     super.onInteract(playerEx, event);
/*  54 */     if ((playerEx.getTravelDestinations() != null) && (event.action == net.minecraftforge.event.entity.player.PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
/*  55 */       trySelectShellTarget(playerEx);
/*     */     }
/*     */   }
/*     */   
/*     */   public void onClientAction(PlayerEx playerEx, emoniph.intangible.player.PlayerEx.PacketEntityLivingAction.Action command)
/*     */   {
/*  61 */     switch (command) {
/*     */     case RIGHT_CLICK_AIR: 
/*     */     case RIGHT_CLICK_BLOCK: 
/*  64 */       if (playerEx.getTravelDestinations() != null) {
/*  65 */         trySelectShellTarget(playerEx); return;
/*     */       }
/*     */       break;
/*     */     }
/*     */     
/*  70 */     super.onClientAction(playerEx, command);
/*     */   }
/*     */   
/*     */   private boolean trySelectShellTarget(PlayerEx playerEx) {
/*  74 */     EntityPlayer player = playerEx.PLAYER;
/*  75 */     float pitch = player.field_70125_A + 90.0F;
/*  76 */     float yaw = player.field_70759_as % 360.0F;
/*  77 */     if (yaw < 0.0F) {
/*  78 */       yaw += 360.0F;
/*     */     }
/*     */     int i;
/*  81 */     if (playerEx.getTravelDestinations() != null) {
/*  82 */       i = -1;
/*  83 */       for (BlockPos pos : playerEx.getTravelDestinations()) {
/*  84 */         i++;
/*     */         
/*  86 */         Vec3 vec = getVectorFrom(pos, player);
/*  87 */         double vecLenH = Math.sqrt(vec.field_72450_a * vec.field_72450_a + vec.field_72449_c * vec.field_72449_c);
/*  88 */         double angleFromNormDegV = 90.0D - Math.toDegrees(Math.atan2(vec.field_72448_b, vecLenH));
/*  89 */         double angleFromNormDegH = -Math.toDegrees(Math.atan2(vec.field_72450_a, vec.field_72449_c));
/*  90 */         if (angleFromNormDegH < 0.0D) {
/*  91 */           angleFromNormDegH += 360.0D;
/*     */         }
/*     */         
/*  94 */         double vecAngleDiffV = angleFromNormDegV - pitch;
/*  95 */         double vecAngleDiffH = angleFromNormDegH - yaw;
/*  96 */         if (vecAngleDiffH < 0.0D) {
/*  97 */           vecAngleDiffH += 360.0D;
/*     */         }
/*  99 */         if ((vecAngleDiffH <= 90.0D) || (vecAngleDiffH >= 270.0D))
/*     */         {
/*     */ 
/*     */ 
/* 103 */           boolean selected = ((vecAngleDiffH > 358.5D) || (vecAngleDiffH < 1.5D)) && (vecAngleDiffV > -1.5D) && (vecAngleDiffV < 1.5D);
/* 104 */           if (selected) {
/* 105 */             playerEx.travelToDestination(pos);
/*     */             
/* 107 */             return true;
/*     */           }
/*     */         }
/*     */       } }
/* 111 */     return false;
/*     */   }
/*     */   
/*     */   public Vec3 getVectorFrom(BlockPos pos, Entity entity) {
/* 115 */     double dx = pos.func_177958_n() + 0.5D - entity.field_70165_t;
/* 116 */     double dy = pos.func_177956_o() + 0.5D - (entity.field_70163_u + entity.func_70047_e());
/* 117 */     double dz = pos.func_177952_p() + 0.5D - entity.field_70161_v;
/* 118 */     return new Vec3(dx, dy, dz);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/forms/PlayerFormDefault.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */