/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import baubles.api.BaubleType;
/*     */ import baubles.api.IBauble;
/*     */ import emoniph.intangible.api.ISoulSet;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.souls.EnumSoulType;
/*     */ import emoniph.intangible.souls.SoulSet;
/*     */ import emoniph.intangible.util.TextUtil;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraftforge.fml.common.Optional.Interface;
/*     */ import net.minecraftforge.fml.common.Optional.Method;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @Optional.Interface(iface="baubles.api.IBauble", modid="Baubles", striprefs=true)
/*     */ public class ItemSoulBoundRing extends Item implements IItem, emoniph.intangible.api.ISoulArmor, IBauble, ICreativeSort
/*     */ {
/*     */   @SideOnly(Side.CLIENT)
/*     */   public EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/*  28 */     return EnumRarity.RARE;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean advancedTooltips)
/*     */   {
/*  34 */     SoulSet souls = ItemSoulArmor.getCapacity(stack);
/*  35 */     for (emoniph.intangible.api.SoulType soul : souls) {
/*  36 */       list.add(TextUtil.parse(EnumSoulType.fromSoulType(soul).getLocalizedName()));
/*     */     }
/*     */   }
/*     */   
/*     */   public void augmentCapacity(ItemStack stack, ISoulSet totalCapacity) {
/*  41 */     if (stack.func_77942_o()) {
/*  42 */       NBTTagCompound compound = stack.func_77978_p();
/*  43 */       if (compound.func_150297_b("soulCapacity", 10)) {
/*  44 */         SoulSet capacity = SoulSet.fromTagCompound(compound.func_74775_l("soulCapacity"));
/*  45 */         if (capacity != null) {
/*  46 */           totalCapacity.add(capacity);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack stack, int renderPass)
/*     */   {
/*  55 */     if (renderPass == 0) {
/*  56 */       return ItemSoulArmor.getCapacityColor(stack);
/*     */     }
/*  58 */     return super.func_82790_a(stack, renderPass);
/*     */   }
/*     */   
/*     */ 
/*     */   @Optional.Method(modid="Baubles")
/*     */   public BaubleType getBaubleType(ItemStack itemstack)
/*     */   {
/*  65 */     return BaubleType.RING;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @Optional.Method(modid="Baubles")
/*     */   public void onWornTick(ItemStack itemstack, EntityLivingBase player) {}
/*     */   
/*     */ 
/*     */   @Optional.Method(modid="Baubles")
/*     */   public void onEquipped(ItemStack itemstack, EntityLivingBase player)
/*     */   {
/*  77 */     updateArmorSouls(player);
/*     */   }
/*     */   
/*     */   @Optional.Method(modid="Baubles")
/*     */   public void onUnequipped(ItemStack itemstack, EntityLivingBase player)
/*     */   {
/*  83 */     updateArmorSouls(player);
/*     */   }
/*     */   
/*     */   private void updateArmorSouls(EntityLivingBase player) {
/*  87 */     if ((player instanceof EntityPlayer)) {
/*  88 */       PlayerEx playerEx = PlayerEx.get((EntityPlayer)player);
/*  89 */       playerEx.recalculateArmorCapacity();
/*     */     }
/*     */   }
/*     */   
/*     */   @Optional.Method(modid="Baubles")
/*     */   public boolean canEquip(ItemStack itemstack, EntityLivingBase player)
/*     */   {
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   @Optional.Method(modid="Baubles")
/*     */   public boolean canUnequip(ItemStack itemstack, EntityLivingBase player)
/*     */   {
/* 102 */     return true;
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 107 */     return 6;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemSoulBoundRing.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */