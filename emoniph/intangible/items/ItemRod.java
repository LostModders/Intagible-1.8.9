/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import com.google.common.collect.Multimap;
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.deity.Deity;
/*     */ import emoniph.intangible.deity.DeityList;
/*     */ import emoniph.intangible.deity.DeityManager;
/*     */ import emoniph.intangible.deity.IPlayerWorship;
/*     */ import emoniph.intangible.deity.ModPriestSpells.PriestSpell;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.player.PlayerTempCache;
/*     */ import emoniph.intangible.player.PlayerTempCache.RadialMenuData;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ItemRod extends Item implements IItem, ICreativeSort
/*     */ {
/*     */   private float attackDamage;
/*     */   
/*     */   public ItemRod()
/*     */   {
/*  30 */     func_77625_d(1);
/*  31 */     this.attackDamage = 4.0F;
/*     */   }
/*     */   
/*     */   public Multimap getAttributeModifiers(ItemStack stack)
/*     */   {
/*  36 */     Multimap multimap = super.getAttributeModifiers(stack);
/*  37 */     multimap.put(net.minecraft.entity.SharedMonsterAttributes.field_111264_e.func_111108_a(), new net.minecraft.entity.ai.attributes.AttributeModifier(field_111210_e, "Weapon modifier", this.attackDamage, 0));
/*  38 */     return multimap;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack stack, int renderPass)
/*     */   {
/*  44 */     return -3342388;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_77662_d()
/*     */   {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public EnumAction func_77661_b(ItemStack stack)
/*     */   {
/*  55 */     return EnumAction.BLOCK;
/*     */   }
/*     */   
/*     */   public EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/*  60 */     return EnumRarity.UNCOMMON;
/*     */   }
/*     */   
/*     */   public boolean func_77636_d(ItemStack stack)
/*     */   {
/*  65 */     return hasDeity(stack);
/*     */   }
/*     */   
/*     */   private void setDeity(ItemStack stack, World world, Deity deity) {
/*  69 */     if (deity != null) {
/*  70 */       if (!stack.func_77942_o()) {
/*  71 */         stack.func_77982_d(new NBTTagCompound());
/*     */       }
/*     */       
/*  74 */       stack.func_77978_p().func_74772_a("deityidm", deity.getId().getMostSignificantBits());
/*  75 */       stack.func_77978_p().func_74772_a("deityidl", deity.getId().getLeastSignificantBits());
/*  76 */       stack.func_151001_c(net.minecraft.util.StatCollector.func_74837_a("item.intangible:rod.dedicated", new Object[] { deity.getName() }));
/*     */     }
/*     */   }
/*     */   
/*     */   public void setDeity(ItemStack stack, World world, UUID deityId) {
/*  81 */     setDeity(stack, world, Get.deities().forWorld(world).getDeityById(deityId));
/*     */   }
/*     */   
/*     */   public Deity getDeity(World world, ItemStack stack) {
/*  85 */     if (hasDeity(stack)) {
/*  86 */       UUID deityId = new UUID(stack.func_77978_p().func_74763_f("deityidm"), stack.func_77978_p().func_74763_f("deityidl"));
/*  87 */       return Get.deities().forWorld(world).getDeityById(deityId);
/*     */     }
/*  89 */     return null;
/*     */   }
/*     */   
/*     */   public UUID getDeityId(World world, ItemStack stack)
/*     */   {
/*  94 */     if (hasDeity(stack)) {
/*  95 */       UUID deityId = new UUID(stack.func_77978_p().func_74763_f("deityidm"), stack.func_77978_p().func_74763_f("deityidl"));
/*  96 */       return deityId;
/*     */     }
/*  98 */     return null;
/*     */   }
/*     */   
/*     */   public boolean hasDeity(ItemStack stack)
/*     */   {
/* 103 */     return (stack != null) && (stack.func_77973_b() == this) && (stack.func_77942_o()) && (stack.func_77978_p().func_74764_b("deityidl"));
/*     */   }
/*     */   
/*     */   public boolean dedicate(World world, ItemStack stack, EntityPlayer player, UUID deityId) {
/* 107 */     if ((!hasDeity(stack)) && (PlayerEx.get(player).getWorship().isDevoutFollowerOf(world, deityId))) {
/* 108 */       setDeity(stack, world, deityId);
/* 109 */       return true;
/*     */     }
/*     */     
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public int func_77626_a(ItemStack stack)
/*     */   {
/* 117 */     return 1000;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack stack, World worldIn, EntityPlayer playerIn)
/*     */   {
/* 122 */     PlayerEx playerEx = PlayerEx.get(playerIn);
/*     */     
/* 124 */     if (hasDeity(stack))
/*     */     {
/* 126 */       if (PlayerEx.get(playerIn).getWorship().isDevoutFollowerOf(worldIn, getDeityId(worldIn, stack)))
/*     */       {
/* 128 */         if (!playerIn.func_70093_af()) {
/* 129 */           playerEx.CACHE.pushPriestMenuData(new PlayerTempCache.RadialMenuData(playerIn));
/*     */         }
/* 131 */         playerIn.func_71008_a(stack, func_77626_a(stack));
/*     */ 
/*     */       }
/* 134 */       else if ((!worldIn.field_72995_K) && (worldIn.field_73012_v.nextInt(25) == 0)) {
/* 135 */         worldIn.func_72942_c(new net.minecraft.entity.effect.EntityLightningBolt(worldIn, playerIn.field_70165_t, playerIn.field_70163_u, playerIn.field_70161_v));
/*     */       }
/*     */     }
/*     */     
/* 139 */     return stack;
/*     */   }
/*     */   
/*     */   public void onUsingTick(ItemStack stack, EntityPlayer playerIn, int count)
/*     */   {
/* 144 */     PlayerEx playerEx = PlayerEx.get(playerIn);
/*     */     
/* 146 */     PlayerTempCache.RadialMenuData radialMenu = playerEx.CACHE.getPriestMenuData();
/*     */     
/* 148 */     if (radialMenu == null) {
/* 149 */       return;
/*     */     }
/*     */     
/* 152 */     if (playerIn.func_70093_af()) {
/* 153 */       radialMenu.reset(playerIn);
/* 154 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_77615_a(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
/*     */   {
/* 160 */     PlayerEx playerEx = PlayerEx.get(playerIn);
/* 161 */     PlayerTempCache.RadialMenuData radialMenu = playerEx.CACHE.getPriestMenuData();
/* 162 */     playerEx.CACHE.clearPriestMenuData();
/*     */     float dy;
/* 164 */     float dx; if ((radialMenu != null) && (playerEx.isClientWorld()) && 
/* 165 */       (hasDeity(stack)) && (PlayerEx.get(playerIn).getWorship().isDevoutFollowerOf(worldIn, getDeityId(worldIn, stack)))) {
/* 166 */       dy = radialMenu.getPitchDiff(playerIn);
/* 167 */       dx = radialMenu.getYawDiff(playerIn);
/*     */       
/*     */ 
/* 170 */       for (ModPriestSpells.PriestSpell spell : Get.priest()) {
/* 171 */         if (spell.contains(-dx, -dy)) {
/* 172 */           Get.pipeline().sendToServer(new emoniph.intangible.deity.ModPriestSpells.PacketCastPriestSpell(spell, false));
/* 173 */           break;
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 182 */     return 84;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemRod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */