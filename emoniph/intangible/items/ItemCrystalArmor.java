/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.client.models.ModelCrystalArmor;
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import emoniph.intangible.util.EnumArmorSlot;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumAction;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemArmor.ArmorMaterial;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraftforge.common.ISpecialArmor.ArmorProperties;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ItemCrystalArmor extends ItemArmor implements IItem, net.minecraftforge.common.ISpecialArmor, ICreativeSort
/*     */ {
/*     */   private EnumArmorSlot armorSlot;
/*     */   
/*     */   ItemCrystalArmor(EnumArmorSlot armorSlot, ItemArmor.ArmorMaterial material)
/*     */   {
/*  27 */     super(material, 0, armorSlot.armorType);
/*  28 */     this.armorSlot = armorSlot;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public net.minecraft.item.EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/*  34 */     return net.minecraft.item.EnumRarity.UNCOMMON;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_77624_a(ItemStack stack, EntityPlayer player, List list, boolean advancedTooltips)
/*     */   {
/*  40 */     list.add(net.minecraft.util.StatCollector.func_74838_a(func_77658_a() + ".info"));
/*     */   }
/*     */   
/*  43 */   private static final ISpecialArmor.ArmorProperties[] EMPTY_ARMOR = ;
/*     */   
/*     */   private static ISpecialArmor.ArmorProperties[] createEmptyArmor() {
/*  46 */     ISpecialArmor.ArmorProperties[] props = new ISpecialArmor.ArmorProperties[EnumArmorSlot.values().length];
/*  47 */     for (EnumArmorSlot slot : EnumArmorSlot.values()) {
/*  48 */       props[slot.getArmorSlot()] = new ISpecialArmor.ArmorProperties(0, 0.0D, 0);
/*  49 */       props[slot.getArmorSlot()].Slot = slot.getArmorSlot();
/*     */     }
/*     */     
/*  52 */     return props;
/*     */   }
/*     */   
/*     */   public ISpecialArmor.ArmorProperties getProperties(EntityLivingBase entity, ItemStack armor, DamageSource source, double damage, int slot)
/*     */   {
/*  57 */     if (isBroken(armor)) {
/*  58 */       return EMPTY_ARMOR[slot];
/*     */     }
/*  60 */     if (armor.func_77942_o()) {
/*  61 */       ISpecialArmor.ArmorProperties props = new ISpecialArmor.ArmorProperties(0, 0.04D, Math.max(armor.func_77958_k() + 1 - armor.func_77952_i(), 1));
/*  62 */       props.Slot = slot;
/*  63 */       return props;
/*     */     }
/*  65 */     ISpecialArmor.ArmorProperties props = new ISpecialArmor.ArmorProperties(0, this.field_77879_b / 25.0D, Math.max(armor.func_77958_k() + 1 - armor.func_77952_i(), 1));
/*  66 */     props.Slot = slot;
/*  67 */     return props;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void func_150895_a(Item itemIn, net.minecraft.creativetab.CreativeTabs tab, List subItems)
/*     */   {
/*  74 */     super.func_150895_a(itemIn, tab, subItems);
/*     */   }
/*     */   
/*     */   public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot)
/*     */   {
/*  79 */     if (isBroken(armor)) {
/*  80 */       return 0;
/*     */     }
/*  82 */     if (armor.func_77942_o()) {
/*  83 */       ISpecialArmor.ArmorProperties props = new ISpecialArmor.ArmorProperties(0, 0.04D, Math.max(armor.func_77958_k() + 1 - armor.func_77952_i(), 1));
/*  84 */       props.Slot = slot;
/*  85 */       return MathHelper.func_76143_f(props.AbsorbRatio * 25.0D);
/*     */     }
/*  87 */     ISpecialArmor.ArmorProperties props = new ISpecialArmor.ArmorProperties(0, this.field_77879_b / 25.0D, Math.max(armor.func_77958_k() + 1 - armor.func_77952_i(), 1));
/*  88 */     props.Slot = slot;
/*  89 */     return MathHelper.func_76143_f(props.AbsorbRatio * 25.0D);
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean isBroken(ItemStack stack)
/*     */   {
/*  95 */     return stack.func_77952_i() > stack.func_77958_k();
/*     */   }
/*     */   
/*     */   public void setDamage(ItemStack stack, int damage)
/*     */   {
/* 100 */     int maxDamage = getMaxDamage(stack) + 1;
/* 101 */     super.setDamage(stack, damage < maxDamage ? damage : maxDamage);
/*     */   }
/*     */   
/*     */   public void damageArmor(EntityLivingBase entityIn, ItemStack stack, DamageSource source, int damage, int slot)
/*     */   {
/* 106 */     if ((!(entityIn instanceof EntityPlayer)) || (!((EntityPlayer)entityIn).field_71075_bZ.field_75098_d)) {
/* 107 */       stack.func_77972_a(damage * 2, entityIn);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelCrystalArmor modelAll;
/*     */   
/*     */ 
/*     */   public boolean func_82816_b_(ItemStack stack)
/*     */   {
/* 119 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_82790_a(ItemStack stack, int renderPass)
/*     */   {
/* 125 */     if (renderPass == 0) {
/* 126 */       return func_82814_b(stack);
/*     */     }
/* 128 */     return super.func_82790_a(stack, renderPass);
/*     */   }
/*     */   
/*     */ 
/*     */   public int func_82814_b(ItemStack stack)
/*     */   {
/* 134 */     if (func_82812_d() == emoniph.intangible.Get.armorYellowCrystalMaterial()) {
/* 135 */       return 14666772;
/*     */     }
/* 137 */     return 29695;
/*     */   }
/*     */   
/*     */ 
/*     */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
/*     */   {
/* 143 */     boolean renderUnderlay = type == null;
/*     */     
/* 145 */     if (stack == null)
/* 146 */       return null;
/* 147 */     if (this.armorSlot == EnumArmorSlot.LEGS) {
/* 148 */       if (renderUnderlay) {
/* 149 */         return "intangible:textures/entity/crystalarmor_legs.png";
/*     */       }
/* 151 */       return "intangible:textures/entity/crystalarmor_legs_overlay.png";
/*     */     }
/*     */     
/* 154 */     if (renderUnderlay) {
/* 155 */       return "intangible:textures/entity/crystalarmor.png";
/*     */     }
/* 157 */     return "intangible:textures/entity/crystalarmor_overlay.png";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelCrystalArmor modelLegs;
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public net.minecraft.client.model.ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack stack, int slot)
/*     */   {
/* 171 */     if (this.modelAll == null) {
/* 172 */       this.modelAll = new ModelCrystalArmor(0.5F);
/* 173 */       this.modelLegs = new ModelCrystalArmor(0.3F);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 179 */     if ((stack != null) && (stack.func_77973_b().getClass() == getClass())) {
/*     */       ModelCrystalArmor armorModel;
/*     */       ModelCrystalArmor armorModel;
/* 182 */       if (this.armorSlot != EnumArmorSlot.LEGS) {
/* 183 */         armorModel = this.modelAll;
/*     */       } else {
/* 185 */         armorModel = this.modelLegs;
/*     */       }
/*     */       
/* 188 */       if (armorModel != null) {
/* 189 */         boolean isVisible = true;
/*     */         
/* 191 */         if ((entityLiving instanceof EntityPlayer)) {
/* 192 */           EntityPlayer player = (EntityPlayer)entityLiving;
/* 193 */           PlayerEx playerEx = PlayerEx.get(player);
/* 194 */           isVisible = playerEx.getPlayerForm().isVisible();
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 203 */         armorModel.field_78116_c.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.HEAD));
/* 204 */         armorModel.field_178720_f.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.HEAD));
/* 205 */         armorModel.field_78115_e.field_78806_j = ((isVisible) && ((this.armorSlot == EnumArmorSlot.CHEST) || (this.armorSlot == EnumArmorSlot.LEGS)));
/* 206 */         armorModel.field_178723_h.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 207 */         armorModel.field_178724_i.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 208 */         armorModel.field_178721_j.field_78806_j = ((isVisible) && ((this.armorSlot == EnumArmorSlot.LEGS) || (this.armorSlot == EnumArmorSlot.FEET)));
/* 209 */         armorModel.field_178722_k.field_78806_j = ((isVisible) && ((this.armorSlot == EnumArmorSlot.LEGS) || (this.armorSlot == EnumArmorSlot.FEET)));
/* 210 */         armorModel.toeLeft.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.FEET));
/* 211 */         armorModel.kneeLeft.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.LEGS));
/* 212 */         armorModel.toeRight.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.FEET));
/* 213 */         armorModel.kneeRight.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.LEGS));
/*     */         
/* 215 */         armorModel.b1.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.LEGS));
/* 216 */         armorModel.b2.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.LEGS));
/* 217 */         armorModel.b3.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.LEGS));
/* 218 */         armorModel.b4.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.LEGS));
/*     */         
/*     */ 
/* 221 */         armorModel.n1.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 222 */         armorModel.n2.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 223 */         armorModel.shape15_36.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 224 */         armorModel.shape15_32.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 225 */         armorModel.shape15_38.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 226 */         armorModel.shape15_34.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 227 */         armorModel.shape15_43.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 228 */         armorModel.shape15_31.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 229 */         armorModel.shape15_40.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 230 */         armorModel.shape15_29.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 231 */         armorModel.shape15_30.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 232 */         armorModel.shape15_41.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 233 */         armorModel.shape15_33.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 234 */         armorModel.shape15_37.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 235 */         armorModel.shape15_35.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 236 */         armorModel.shape15_39.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/* 237 */         armorModel.shape15_42.field_78806_j = ((isVisible) && (this.armorSlot == EnumArmorSlot.CHEST));
/*     */         
/* 239 */         armorModel.field_78117_n = entityLiving.func_70093_af();
/* 240 */         armorModel.field_78093_q = entityLiving.func_70115_ae();
/* 241 */         armorModel.field_78091_s = entityLiving.func_70631_g_();
/* 242 */         armorModel.field_78095_p = entityLiving.func_70678_g(net.minecraft.client.Minecraft.func_71410_x().field_71428_T.field_74281_c);
/*     */         
/* 244 */         ItemStack heldStack = entityLiving.func_71124_b(0);
/* 245 */         armorModel.field_78120_m = (heldStack != null ? 1 : 0);
/* 246 */         armorModel.field_78118_o = false;
/*     */         
/* 248 */         if (((entityLiving instanceof EntityPlayer)) && (heldStack != null) && 
/* 249 */           (((EntityPlayer)entityLiving).func_71057_bx() > 0)) {
/* 250 */           EnumAction enumaction = heldStack.func_77975_n();
/*     */           
/* 252 */           if (enumaction == EnumAction.BLOCK) {
/* 253 */             armorModel.field_78120_m = 3;
/*     */           }
/*     */           
/* 256 */           armorModel.field_78118_o = (enumaction == EnumAction.BOW);
/*     */         }
/*     */         
/* 259 */         return armorModel;
/*     */       }
/*     */     }
/* 262 */     return null;
/*     */   }
/*     */   
/*     */   public boolean isEquipped(EntityLivingBase entity) {
/* 266 */     ItemStack stack = entity != null ? entity.func_71124_b(this.armorSlot.equipmentSlot) : null;
/* 267 */     return (stack != null) && (stack.func_77973_b() == this);
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 272 */     return 5;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemCrystalArmor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */