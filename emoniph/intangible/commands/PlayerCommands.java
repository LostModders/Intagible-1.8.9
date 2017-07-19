/*     */ package emoniph.intangible.commands;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.effects.EffectRegistry;
/*     */ import emoniph.intangible.entity.EntitySoul;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.util.ChatUtil;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ public class PlayerCommands implements ICommand
/*     */ {
/*  27 */   private final List<String> aliases = new java.util.ArrayList();
/*     */   
/*     */   public PlayerCommands() {
/*  30 */     this.aliases.add(func_71517_b());
/*     */   }
/*     */   
/*     */   public String func_71517_b()
/*     */   {
/*  35 */     return "intangible";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender sender)
/*     */   {
/*  40 */     return String.format("/%s toggleincorporeal [<player>] | toggleeffect <effect> <cooldown> [<player>] | listknol [<player|all>] | setknol <knolid|all|souls> <on|off> [<player>]", new Object[] { func_71517_b() });
/*     */   }
/*     */   
/*     */   public List func_71514_a()
/*     */   {
/*  45 */     return this.aliases;
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender sender, String[] args) throws net.minecraft.command.CommandException
/*     */   {
/*  50 */     if ((!func_71519_b(sender)) || (args.length == 0) || (args[0] == null)) {
/*  51 */       ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/*  52 */       return;
/*     */     }
/*     */     
/*  55 */     EntityPlayer player = (EntityPlayer)sender;
/*  56 */     String keyword = args[0].toLowerCase(Locale.US);
/*     */     
/*  58 */     if (keyword.equals("toggleincorporeal")) {
/*  59 */       if (args.length > 1) {
/*  60 */         EntityPlayer otherPlayer = findPlayerByName(args[1]);
/*  61 */         if (otherPlayer == null) {
/*  62 */           ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:toggleincorporeal.playernotfound", new Object[] { args[1] });
/*  63 */           return;
/*     */         }
/*  65 */         player = otherPlayer;
/*     */       }
/*     */       
/*  68 */       PlayerEx playerEx = PlayerEx.get(player);
/*  69 */       if (playerEx != null)
/*  70 */         if (Get.effects().isActiveFor(Get.effects().INCORPOREAL, player)) {
/*  71 */           playerEx.disableEffect(Get.effects().INCORPOREAL);
/*  72 */           ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:toggleincorporeal.playercorporeal", new Object[] { player.func_146103_bH().getName() });
/*     */         } else {
/*  74 */           playerEx.enableEffect(Get.effects().INCORPOREAL);
/*  75 */           ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:toggleincorporeal.playerincorporeal", new Object[] { player.func_146103_bH().getName() });
/*     */         }
/*     */     } else { EntitySoul soul;
/*  78 */       if (keyword.equals("extractsouls")) {
/*  79 */         if (args.length < 2) {
/*  80 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/*  81 */           return;
/*     */         }
/*     */         try {
/*  84 */           int radius = Integer.parseInt(args[1]);
/*  85 */           List<EntityLiving> list = player.field_70170_p.func_72872_a(EntityLiving.class, player.func_174813_aQ().func_72314_b(radius, radius, radius));
/*  86 */           for (EntityLiving living : list) {
/*  87 */             emoniph.intangible.api.SoulType soulType = Get.souls().getSoulFor(living.getClass());
/*  88 */             if (soulType != null) {
/*  89 */               soul = EntitySoul.removeSoulAsEntity(living);
/*  90 */               if (soul != null) {
/*  91 */                 soul.func_82149_j(living);
/*  92 */                 player.field_70170_p.func_72838_d(soul);
/*  93 */                 living.func_70097_a(net.minecraft.util.DamageSource.func_92087_a(player), 1000.0F);
/*     */               }
/*     */             }
/*     */           }
/*     */         } catch (Throwable ex) {
/*  98 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/*  99 */           return;
/*     */         }
/* 101 */       } else if (keyword.equals("toggleeffect")) {
/* 102 */         if (args.length < 3) {
/* 103 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/* 104 */           return;
/*     */         }
/*     */         
/* 107 */         if (args.length > 3) {
/* 108 */           EntityPlayer otherPlayer = findPlayerByName(args[3]);
/* 109 */           if (otherPlayer == null) {
/* 110 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:toggleincorporeal.playernotfound", new Object[] { args[3] });
/* 111 */             return;
/*     */           }
/* 113 */           player = otherPlayer;
/*     */         }
/*     */         
/* 116 */         PlayerEx playerEx = PlayerEx.get(player);
/* 117 */         if (playerEx != null) {
/* 118 */           emoniph.intangible.api.IPassiveEffect effect = Get.effects().getEffectForId(args[1]);
/* 119 */           if (effect == null) {
/* 120 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:toggleeffect.effectdoesnotexist", new Object[] { args[1] });
/* 121 */             return;
/*     */           }
/*     */           
/* 124 */           if (Get.effects().isActiveFor(effect, player)) {
/* 125 */             playerEx.disableEffect(effect);
/* 126 */             ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:toggleeffect.inactive", new Object[] { args[1], player.func_146103_bH().getName() });
/*     */           } else {
/*     */             try {
/* 129 */               int cooldown = Integer.parseInt(args[2]);
/* 130 */               if (cooldown > 0) {
/* 131 */                 playerEx.enableEffectWithCooldown(effect, cooldown);
/*     */               } else {
/* 133 */                 playerEx.enableEffect(effect);
/*     */               }
/* 135 */               ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:toggleeffect.active", new Object[] { args[1], player.func_146103_bH().getName() });
/*     */             } catch (NumberFormatException ex) {
/* 137 */               ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:toggleeffect.invalidcooldown", new Object[0]);
/*     */             }
/*     */           }
/*     */         }
/* 141 */       } else if (keyword.equals("listknol")) {
/* 142 */         if (args.length < 1) {
/* 143 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) }); return;
/*     */         }
/*     */         
/*     */         EntityPlayer otherPlayer;
/* 147 */         if ((args.length > 1) && (args[1] != null)) {
/* 148 */           if (args[1].toLowerCase(Locale.US).equals("all")) {
/* 149 */             player = null;
/*     */           } else {
/* 151 */             otherPlayer = findPlayerByName(args[1]);
/* 152 */             if (otherPlayer == null) {
/* 153 */               ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:toggleincorporeal.playernotfound", new Object[] { args[1] });
/* 154 */               return;
/*     */             }
/* 156 */             player = otherPlayer;
/*     */           }
/*     */         }
/*     */         
/* 160 */         if (player == null) {
/* 161 */           for (IKnol knol : Get.knowledge()) {
/* 162 */             ChatUtil.send(EnumChatFormatting.BLUE, sender, "%s", new Object[] { knol.getId() });
/*     */           }
/*     */         } else {
/* 165 */           PlayerEx playerEx = PlayerEx.get(player);
/* 166 */           int count = 0;
/* 167 */           for (ex = Get.knowledge().iterator(); ((Iterator)ex).hasNext();) { IKnol knol = (IKnol)((Iterator)ex).next();
/* 168 */             if (playerEx.isKnowledgeLearnt(new IKnol[] { knol })) {
/* 169 */               count++;
/* 170 */               ChatUtil.send(EnumChatFormatting.BLUE, sender, "%s", new Object[] { knol.getId() });
/*     */             }
/*     */           }
/* 173 */           if (count == 0) {
/* 174 */             ChatUtil.send(EnumChatFormatting.YELLOW, sender, "command.intangible:listknol.nothingknown", new Object[] { player.getDisplayNameString() });
/*     */           }
/*     */         }
/* 177 */       } else if (keyword.equals("setknol")) {
/* 178 */         if ((args.length < 3) || (args[1] == null) || (args[2] == null)) {
/* 179 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/* 180 */           return;
/*     */         }
/*     */         
/* 183 */         if ((args.length > 3) && (args[3] != null)) {
/* 184 */           EntityPlayer otherPlayer = findPlayerByName(args[3]);
/* 185 */           if (otherPlayer == null) {
/* 186 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:toggleincorporeal.playernotfound", new Object[] { args[3] });
/* 187 */             return;
/*     */           }
/* 189 */           player = otherPlayer;
/*     */         }
/*     */         
/* 192 */         PlayerEx playerEx = PlayerEx.get(player);
/* 193 */         if (playerEx != null)
/*     */         {
/* 195 */           boolean souls = false;
/* 196 */           IKnol knol; if (args[1].toLowerCase(Locale.US).equals("all")) {
/* 197 */             IKnol knol = null;
/* 198 */             souls = false;
/* 199 */           } else if (args[1].toLowerCase(Locale.US).equals("souls")) {
/* 200 */             IKnol knol = null;
/* 201 */             souls = true;
/*     */           } else {
/* 203 */             knol = Get.knowledge().getKnolFromId(args[1]);
/* 204 */             if (knol == null) {
/* 205 */               ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:setknol.notfound", new Object[] { args[1] });
/* 206 */               return;
/*     */             }
/*     */           }
/*     */           
/* 210 */           String flag = args[2].toLowerCase(Locale.US);
/*     */           boolean activate;
/* 212 */           if ((flag.equals("on")) || (flag.equals("1"))) {
/* 213 */             activate = true; } else { boolean activate;
/* 214 */             if ((flag.equals("off")) || (flag.equals("0"))) {
/* 215 */               activate = false;
/*     */             } else {
/* 217 */               ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) }); return;
/*     */             }
/*     */           }
/*     */           boolean activate;
/* 221 */           if (knol == null) {
/* 222 */             if (activate) {
/* 223 */               playerEx.learnKnowledge(new Vec3(player.field_70165_t, player.field_70163_u + player.field_70131_O + 1.0D, player.field_70161_v), souls ? Get.knowledge().getAllSoulKNowledge() : Get.knowledge().toArray());
/* 224 */               ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:setknol.addedall", new Object[] { player.func_146103_bH().getName() });
/*     */             } else {
/* 226 */               if (souls) {
/* 227 */                 for (IKnol knolPiece : Get.knowledge().getAllSoulKNowledge()) {
/* 228 */                   if (playerEx.isKnowledgeLearnt(new IKnol[] { knolPiece })) {
/* 229 */                     playerEx.removeKnowledge(knolPiece);
/*     */                   }
/*     */                 }
/*     */               } else {
/* 233 */                 playerEx.removeKnowledgeAll();
/*     */               }
/* 235 */               ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:setknol.removedall", new Object[] { player.func_146103_bH().getName() });
/*     */             }
/*     */           } else {
/* 238 */             boolean known = playerEx.isKnowledgeLearnt(new IKnol[] { knol });
/* 239 */             if ((known) && (activate)) {
/* 240 */               ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:setknol.alreadyknown", new Object[] { player.func_146103_bH().getName(), knol.getId() });
/* 241 */             } else if ((!known) && (!activate)) {
/* 242 */               ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:setknol.alreadyunknown", new Object[] { player.func_146103_bH().getName(), knol.getId() });
/* 243 */             } else if (activate) {
/* 244 */               playerEx.learnKnowledge(new Vec3(player.field_70165_t, player.field_70163_u + player.field_70131_O + 1.0D, player.field_70161_v), new IKnol[] { knol });
/* 245 */               ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:setknol.added", new Object[] { knol.getId(), player.func_146103_bH().getName() });
/*     */             } else {
/* 247 */               playerEx.removeKnowledge(knol);
/* 248 */               ChatUtil.send(EnumChatFormatting.DARK_GREEN, sender, "command.intangible:setknol.removed", new Object[] { knol.getId(), player.func_146103_bH().getName() });
/*     */             }
/*     */           }
/*     */         }
/*     */       } else {
/* 253 */         ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/* 258 */   private EntityPlayer findPlayerByName(String playerName) { if ((playerName != null) && (!playerName.trim().isEmpty())) {
/* 259 */       for (WorldServer world : MinecraftServer.func_71276_C().field_71305_c) {
/* 260 */         EntityPlayer found = world.func_72924_a(playerName);
/* 261 */         if (found != null) {
/* 262 */           return found;
/*     */         }
/*     */       }
/*     */     }
/* 266 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender sender)
/*     */   {
/* 271 */     if ((sender.func_174793_f() instanceof EntityPlayer)) {
/* 272 */       EntityPlayer player = (EntityPlayer)sender;
/* 273 */       return player.field_71075_bZ.field_75098_d;
/*     */     }
/* 275 */     return false;
/*     */   }
/*     */   
/*     */   public List func_180525_a(ICommandSender sender, String[] args, BlockPos pos)
/*     */   {
/* 280 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_82358_a(String[] args, int index)
/*     */   {
/* 285 */     return false;
/*     */   }
/*     */   
/*     */   public int compareTo(ICommand o)
/*     */   {
/* 290 */     if (o == null) {
/* 291 */       return -1;
/*     */     }
/*     */     
/* 294 */     if (o == this) {
/* 295 */       return 0;
/*     */     }
/*     */     
/* 298 */     return func_71517_b().compareTo(o.func_71517_b());
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/commands/PlayerCommands.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */