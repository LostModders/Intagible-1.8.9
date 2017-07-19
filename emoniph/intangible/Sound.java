/*     */ package emoniph.intangible;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public enum Sound
/*     */ {
/*  11 */   RANDOM_ORB("random.orb"), 
/*  12 */   RANDOM_FIZZ("random.fizz"), 
/*  13 */   RANDOM_LEVELUP("random.levelup"), 
/*  14 */   RANDOM_EXPLODE("random.explode"), 
/*  15 */   RANDOM_POP("random.pop"), 
/*  16 */   NOTE_SNARE("note.snare"), 
/*  17 */   NOTE_HARP("note.harp"), 
/*  18 */   NOTE_PLING("note.pling"), 
/*  19 */   DAMAGE_HIT("damage.hit"), 
/*  20 */   FIRE_FIRE("fire.fire"), 
/*  21 */   FIRE_IGNITE("fire.ignite"), 
/*  22 */   FIREWORKS_BLAST1("fireworks.blast"), 
/*  23 */   WATER_SPLASH("game.player.swim.splash"), 
/*  24 */   WATER_SWIM("game.player.swim"), 
/*  25 */   LIQUID_GLOP("liquid.lava"), 
/*  26 */   LIQUID_LAVA_POP("liquid.lavapop"), 
/*  27 */   MOB_IRONGOLEM_HIT("mob.irongolem.hit"), 
/*     */   
/*  29 */   MOD_RANDOM_WINGBEAT("intangible:random.wingbeat"), 
/*  30 */   MOD_RANDOM_CHOIR1("intangible:random.choir1"), 
/*  31 */   MOD_RANDOM_GONG1("intangible:random.gong1"), 
/*  32 */   MOD_RANDOM_BONECREEK_OPEN("intangible:random.bonecreek_open"), 
/*  33 */   MOD_RANDOM_BONECREEK_CLOSE("intangible:random.bonecreek_close"), 
/*  34 */   MOD_RANDOM_DISCOVERY("intangible:random.discovery"), 
/*  35 */   MOD_RANDOM_SLURP("intangible:random.slurp"), 
/*  36 */   MOD_RANDOM_CLINK("intangible:random.clink"), 
/*  37 */   MOD_RANDOM_CLUNK("intangible:random.clunk"), 
/*  38 */   MOD_RANDOM_BELLOW_OUT("intangible:random.bellowout"), 
/*  39 */   MOD_RANDOM_BELLOW_IN("intangible:random.bellowin"), 
/*  40 */   MOD_RANDOM_POWER_UP("intangible:random.power_up"), 
/*  41 */   MOD_RANDOM_POWER_DOWN("intangible:random.power_down"), 
/*  42 */   MOD_RANDOM_SPELLFAIL("intangible:random.spellfail"), 
/*  43 */   MOD_RANDOM_SPELLFAIL2("intangible:random.spellfail2"), 
/*  44 */   MOD_RANDOM_MACHINE("intangible:random.machine"), 
/*  45 */   MOD_RANDOM_WRENCH("intangible:random.wrench"), 
/*  46 */   MOD_RANDOM_REND_SOUL("intangible:random.rendsoul"), 
/*  47 */   MOD_RANDOM_YOUR_SOUL_IS_MINE("intangible:random.yoursoulismine"), 
/*  48 */   MOD_RANDOM_DIRT_HIT("intangible:random.dirthit"), 
/*  49 */   MOD_RANDOM_ROCK_HIT("intangible:random.rockhit"), 
/*  50 */   MOD_RANDOM_JETPACK("intangible:random.jetpack"), 
/*  51 */   MOD_RANDOM_METALCREEK("intangible:random.metalcreek"), 
/*  52 */   MOD_RANDOM_CLANK("intangible:random.clank"), 
/*  53 */   MOD_RANDOM_GOLEM_POWERUP("intangible:random.golem_powerup"), 
/*  54 */   MOD_RANDOM_GOLEM_POWERDOWN("intangible:random.golem_powerdown"), 
/*  55 */   MOD_RANDOM_SWOOSH("intangible:random.swoosh"), 
/*  56 */   MOD_RANDOM_SPELL1("intangible:random.spell1"), 
/*  57 */   MOD_RANDOM_SPELL2("intangible:random.spell2"), 
/*  58 */   MOD_RANDOM_SPELL3("intangible:random.spell3"), 
/*  59 */   MOD_RANDOM_SQUELCH("intangible:random.squelch"), 
/*  60 */   MOD_RANDOM_BIG_LASER("intangible:random.biglaser"), 
/*  61 */   MOD_RANDOM_CLICK("intangible:random.click"), 
/*  62 */   MOD_RANDOM_GOLEM_BROKEN("intangible:random.golem_broken"), 
/*  63 */   MOD_RANDOM_MELEE("intangible:random.melee"), 
/*  64 */   MOD_RANDOM_PEACE("intangible:random.peace"), 
/*  65 */   MOD_RANDOM_ENERGY_SHIELD("intangible:random.energyshield"), 
/*  66 */   MOD_RANDOM_FUNERAL_MARCH("intangible:random.funeralmarch"), 
/*  67 */   MOD_RANDOM_THUMP("intangible:random.thump"), 
/*     */   
/*  69 */   MOD_AVATAR_HIT("intangible:avatar.hit"), 
/*     */   
/*  71 */   MOD_RANDOM_DEITY_1("intangible:random.deity1"), 
/*  72 */   MOD_RANDOM_DEITY_2("intangible:random.deity2"), 
/*  73 */   MOD_RANDOM_DEITY_3("intangible:random.deity3"), 
/*  74 */   MOD_RANDOM_DEITY_4("intangible:random.deity4");
/*     */   
/*     */   public final String LOCATION;
/*     */   
/*     */   private Sound(String location)
/*     */   {
/*  80 */     this.LOCATION = location;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/*  85 */     return this.LOCATION;
/*     */   }
/*     */   
/*     */   public void playToAllNear(Entity entity) {
/*  89 */     playToAllNear(entity, getDefaultVolume(entity.func_130014_f_()));
/*     */   }
/*     */   
/*     */   public void playToAllNear(Entity entity, float volume) {
/*  93 */     playToAllNear(entity, volume, getPitchVariation(entity.func_130014_f_()));
/*     */   }
/*     */   
/*     */   public void playToAllNear(Entity entity, float volume, float pitch) {
/*  97 */     if (!entity.field_70170_p.field_72995_K) {
/*  98 */       entity.field_70170_p.func_72956_a(entity, this.LOCATION, volume, pitch);
/*     */     } else {
/* 100 */       entity.field_70170_p.func_72980_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, this.LOCATION, volume, pitch, false);
/*     */     }
/*     */   }
/*     */   
/*     */   public void playToAllNear(TileEntity tile) {
/* 105 */     playToAllNear(tile, getDefaultVolume(tile.func_145831_w()));
/*     */   }
/*     */   
/*     */   public void playToAllNear(TileEntity tile, float volume) {
/* 109 */     playToAllNear(tile, volume, getPitchVariation(tile.func_145831_w()));
/*     */   }
/*     */   
/*     */   public void playToAllNear(TileEntity tile, float volume, float pitch) {
/* 113 */     playToAllNear(tile.func_145831_w(), tile.func_174877_v(), volume, pitch);
/*     */   }
/*     */   
/*     */   public void playToAllNear(World world, BlockPos pos) {
/* 117 */     playToAllNear(world, pos, getDefaultVolume(world));
/*     */   }
/*     */   
/*     */   public void playToAllNear(World world, BlockPos pos, float volume) {
/* 121 */     playToAllNear(world, pos, volume, getPitchVariation(world));
/*     */   }
/*     */   
/*     */   public void playToAllNear(World world, BlockPos pos, float volume, float pitch) {
/* 125 */     if (!world.field_72995_K) {
/* 126 */       world.func_72908_a(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, this.LOCATION, volume, pitch);
/*     */     } else {
/* 128 */       world.func_72980_b(pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, this.LOCATION, volume, pitch, false);
/*     */     }
/*     */   }
/*     */   
/*     */   public void playOnlyTo(EntityPlayer player) {
/* 133 */     playOnlyTo(player, getDefaultVolume(player.func_130014_f_()));
/*     */   }
/*     */   
/* 136 */   public void playOnlyTo(EntityPlayer player, float volume) { playOnlyTo(player, volume, getPitchVariation(player.func_130014_f_())); }
/*     */   
/*     */   public void playOnlyTo(EntityPlayer player, float volume, float pitch) {
/* 139 */     if (!player.field_70170_p.field_72995_K) {
/* 140 */       Get.pipeline().sendTo(new net.minecraft.network.play.server.S29PacketSoundEffect(this.LOCATION, player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v, volume, pitch), player);
/*     */     } else {
/* 142 */       player.func_85030_a(this.LOCATION, volume, pitch);
/*     */     }
/*     */   }
/*     */   
/*     */   public static Sound forDeityVariant(int variant) {
/* 147 */     switch (variant) {
/*     */     case 0: default: 
/* 149 */       return MOD_RANDOM_DEITY_1;
/*     */     case 1: 
/* 151 */       return MOD_RANDOM_DEITY_2;
/*     */     }
/* 153 */     return MOD_RANDOM_DEITY_3;
/*     */   }
/*     */   
/*     */   private static float getPitchVariation(World world)
/*     */   {
/* 158 */     return 0.4F / ((float)world.field_73012_v.nextDouble() * 0.4F + 0.8F);
/*     */   }
/*     */   
/*     */   private static float getDefaultVolume(World world) {
/* 162 */     return 1.0F;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/Sound.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */