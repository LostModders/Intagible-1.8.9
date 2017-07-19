/*     */ package emoniph.intangible.commands;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.deity.IDeity;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.deity.DeityList;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.entity.EntityAvatar;
/*     */ import emoniph.intangible.items.ItemRod;
/*     */ import emoniph.intangible.items.ModItems;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import emoniph.intangible.util.ChatUtil;
/*     */ import emoniph.intangible.util.EntityUtil;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.entity.effect.EntityLightningBolt;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.commons.lang3.Range;
/*     */ 
/*     */ public class DeityCommands implements ICommand
/*     */ {
/*  30 */   private final List<String> aliases = new java.util.ArrayList();
/*     */   
/*     */   public DeityCommands() {
/*  33 */     this.aliases.add(func_71517_b());
/*     */   }
/*     */   
/*     */ 
/*     */   public String func_71517_b()
/*     */   {
/*  39 */     return "deity";
/*     */   }
/*     */   
/*     */   public String func_71518_a(ICommandSender sender)
/*     */   {
/*  44 */     return String.format("/%s list [<deityid>] | resetname <deityid> | kill <deityid> | spawn <itemA> <itemB> <itemC>", new Object[] { func_71517_b() });
/*     */   }
/*     */   
/*     */   public List func_71514_a()
/*     */   {
/*  49 */     return this.aliases;
/*     */   }
/*     */   
/*     */   public void func_71515_b(ICommandSender sender, String[] args)
/*     */     throws net.minecraft.command.CommandException
/*     */   {
/*  55 */     if ((!func_71519_b(sender)) || (args.length == 0) || (args[0] == null)) {
/*  56 */       ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/*  57 */       return;
/*     */     }
/*     */     
/*  60 */     EntityPlayer player = (EntityPlayer)sender;
/*  61 */     String keyword = args[0].toLowerCase(java.util.Locale.US);
/*     */     
/*  63 */     if (keyword.equals("list")) {
/*  64 */       if (args.length < 2) {
/*  65 */         DeityList deities = Get.deities().forWorld(player.field_70170_p);
/*  66 */         if (deities.size() == 0) {
/*  67 */           ChatUtil.send(EnumChatFormatting.YELLOW, sender, "command.intangible:deitylist.empty", new Object[0]);
/*  68 */           return;
/*     */         }
/*  70 */         for (IDeity deity : deities) {
/*  71 */           ChatUtil.send(EnumChatFormatting.BLUE, sender, "%s: %s", new Object[] { deity.getId(), deity.getName() });
/*     */         }
/*     */       } else {
/*     */         try {
/*  75 */           UUID deityId = UUID.fromString(args[1]);
/*  76 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(deityId);
/*  77 */           if (deity == null) {
/*  78 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/*  79 */             return;
/*     */           }
/*     */           
/*  82 */           ChatUtil.send(EnumChatFormatting.BLUE, sender, deity.toString(), new Object[0]);
/*     */         } catch (Throwable ex) {
/*  84 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityByName(args[1]);
/*  85 */           if (deity == null) {
/*  86 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/*  87 */             return;
/*     */           }
/*  89 */           ChatUtil.send(EnumChatFormatting.BLUE, sender, deity.toString(), new Object[0]);
/*     */         }
/*     */       }
/*  92 */     } else { if (keyword.equals("resetname")) {
/*  93 */         if ((args.length < 2) || (args[1] == null)) {
/*  94 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/*  95 */           return;
/*     */         }
/*     */         try {
/*  98 */           UUID deityId = UUID.fromString(args[1]);
/*  99 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(deityId);
/* 100 */           if (deity == null) {
/* 101 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 102 */             return;
/*     */           }
/*     */           
/* 105 */           Get.deities().rename(player.field_70170_p, deityId);
/*     */         } catch (Throwable ex) {
/* 107 */           ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 108 */           return;
/*     */         } }
/* 110 */       if (keyword.equals("kill")) {
/* 111 */         if ((args.length < 2) || (args[1] == null)) {
/* 112 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/* 113 */           return;
/*     */         }
/*     */         try {
/* 116 */           UUID deityId = UUID.fromString(args[1]);
/* 117 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(deityId);
/* 118 */           if (deity == null) {
/* 119 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 120 */             return;
/*     */           }
/*     */           
/* 123 */           Get.deities().killDeity(player.field_70170_p, deity);
/*     */         } catch (Throwable ex) {
/* 125 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityByName(args[1]);
/* 126 */           if (deity == null) {
/* 127 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 128 */             return;
/*     */           }
/* 130 */           Get.deities().killDeity(player.field_70170_p, deity);
/*     */         } }
/* 132 */       if (keyword.equals("summon")) {
/* 133 */         if ((args.length < 2) || (args[1] == null)) {
/* 134 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/* 135 */           return;
/*     */         }
/*     */         try {
/* 138 */           UUID deityId = UUID.fromString(args[1]);
/* 139 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(deityId);
/* 140 */           if (deity == null) {
/* 141 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 142 */             return;
/*     */           }
/*     */           
/* 145 */           EntityAvatar avatar = deity.createAvatar(player.field_70170_p);
/* 146 */           if ((avatar != null) && (EntityUtil.trySetRandomNearbyPosition(avatar.getAvatarEntity(), player.field_70170_p, 
/* 147 */             BlockUtil.midBlockToVec3(new BlockPos(player)), Range.between(Double.valueOf(1.0D), Double.valueOf(8.0D)), 8))) {
/* 148 */             player.field_70170_p.func_72942_c(new EntityLightningBolt(player.field_70170_p, avatar.field_70165_t, avatar.field_70163_u, avatar.field_70161_v));
/* 149 */             player.field_70170_p.func_72838_d(avatar);
/* 150 */             deity.talkAt(player);
/*     */           }
/*     */         } catch (Throwable ex) {
/* 153 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityByName(args[1]);
/* 154 */           if (deity == null) {
/* 155 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 156 */             return;
/*     */           }
/* 158 */           EntityAvatar avatar = deity.createAvatar(player.field_70170_p);
/* 159 */           if ((avatar != null) && (EntityUtil.trySetRandomNearbyPosition(avatar.getAvatarEntity(), player.field_70170_p, 
/* 160 */             BlockUtil.midBlockToVec3(new BlockPos(player)), Range.between(Double.valueOf(1.0D), Double.valueOf(8.0D)), 8))) {
/* 161 */             player.field_70170_p.func_72942_c(new EntityLightningBolt(player.field_70170_p, avatar.field_70165_t, avatar.field_70163_u, avatar.field_70161_v));
/* 162 */             player.field_70170_p.func_72838_d(avatar);
/* 163 */             deity.talkAt(player);
/*     */           }
/*     */         } }
/* 166 */       if (keyword.equals("rod")) {
/* 167 */         if ((args.length < 2) || (args[1] == null)) {
/* 168 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/* 169 */           return;
/*     */         }
/*     */         try {
/* 172 */           UUID deityId = UUID.fromString(args[1]);
/* 173 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityById(deityId);
/* 174 */           if (deity == null) {
/* 175 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 176 */             return;
/*     */           }
/*     */           
/* 179 */           ItemStack stack = new ItemStack(Get.items().ROD);
/* 180 */           Get.items().ROD.setDeity(stack, player.field_70170_p, deityId);
/* 181 */           player.field_70170_p.func_72838_d(new EntityItem(player.field_70170_p, player.field_70165_t, player.field_70163_u, player.field_70161_v, stack));
/*     */         } catch (Throwable ex) {
/* 183 */           Deity deity = Get.deities().forWorld(player.field_70170_p).getDeityByName(args[1]);
/* 184 */           if (deity == null) {
/* 185 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deitysetname.unknowndeity", new Object[] { args[1] });
/* 186 */             return;
/*     */           }
/* 188 */           ItemStack stack = new ItemStack(Get.items().ROD);
/* 189 */           Get.items().ROD.setDeity(stack, player.field_70170_p, deity.getId());
/* 190 */           player.field_70170_p.func_72838_d(new EntityItem(player.field_70170_p, player.field_70165_t, player.field_70163_u, player.field_70161_v, stack));
/*     */         } }
/* 192 */       if (keyword.equals("spawn")) {
/* 193 */         if ((args.length < 4) || (args[1] == null)) {
/* 194 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/* 195 */           return;
/*     */         }
/*     */         try
/*     */         {
/* 199 */           Item ia = Item.func_111206_d(args[1]);
/* 200 */           Item ib = Item.func_111206_d(args[2]);
/* 201 */           Item ic = Item.func_111206_d(args[3]);
/* 202 */           if ((ia == null) || (ib == null) || (ic == null)) {
/* 203 */             ChatUtil.send(EnumChatFormatting.RED, sender, "command.intangible:deityspawn.invaliditems", new Object[0]);
/* 204 */             return;
/*     */           }
/* 206 */           ItemStack a = new ItemStack(ia);
/* 207 */           ItemStack b = new ItemStack(ib);
/* 208 */           ItemStack c = new ItemStack(ic);
/* 209 */           Deity deity = Deity.createRandom(player.field_70170_p, new BlockPos(player).func_177984_a(), a, b, c);
/* 210 */           Get.deities().createDeity(player.field_70170_p, deity);
/* 211 */           deity.talkToWorld(player.field_70170_p, "entity.intangible.deity.awakened");
/*     */         } catch (Throwable ex) {
/* 213 */           ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/* 214 */           return;
/*     */         }
/*     */       }
/*     */       
/* 218 */       ChatUtil.send(EnumChatFormatting.RED, sender, "USAGE: %s", new Object[] { func_71518_a(sender) });
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean func_71519_b(ICommandSender sender)
/*     */   {
/* 224 */     if ((sender.func_174793_f() instanceof EntityPlayer)) {
/* 225 */       EntityPlayer player = (EntityPlayer)sender;
/* 226 */       return player.field_71075_bZ.field_75098_d;
/*     */     }
/* 228 */     return false;
/*     */   }
/*     */   
/*     */   public List func_180525_a(ICommandSender sender, String[] args, BlockPos pos)
/*     */   {
/* 233 */     return null;
/*     */   }
/*     */   
/*     */   public boolean func_82358_a(String[] args, int index)
/*     */   {
/* 238 */     return false;
/*     */   }
/*     */   
/*     */   public int compareTo(ICommand o)
/*     */   {
/* 243 */     if (o == null) {
/* 244 */       return -1;
/*     */     }
/*     */     
/* 247 */     if (o == this) {
/* 248 */       return 0;
/*     */     }
/*     */     
/* 251 */     return func_71517_b().compareTo(o.func_71517_b());
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/commands/DeityCommands.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */