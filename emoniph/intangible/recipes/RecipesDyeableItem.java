/*     */ package emoniph.intangible.recipes;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.passive.EntitySheep;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.InventoryCrafting;
/*     */ import net.minecraft.item.EnumDyeColor;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RecipesDyeableItem
/*     */   implements IRecipe
/*     */ {
/*     */   public boolean func_77569_a(InventoryCrafting inventory, World worldIn)
/*     */   {
/*  24 */     ItemStack armorStack = null;
/*  25 */     List<ItemStack> list = Lists.newArrayList();
/*     */     
/*  27 */     for (int i = 0; i < inventory.func_70302_i_(); i++) {
/*  28 */       ItemStack stackIn = inventory.func_70301_a(i);
/*     */       
/*  30 */       if (stackIn != null) {
/*  31 */         if ((stackIn.func_77973_b() instanceof IDyeable)) {
/*  32 */           if (armorStack != null) {
/*  33 */             return false;
/*     */           }
/*     */           
/*  36 */           armorStack = stackIn;
/*     */         } else {
/*  38 */           if (stackIn.func_77973_b() != Items.field_151100_aR) {
/*  39 */             return false;
/*     */           }
/*     */           
/*  42 */           list.add(stackIn);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  47 */     return (armorStack != null) && (!list.isEmpty());
/*     */   }
/*     */   
/*     */   public ItemStack func_77572_b(InventoryCrafting inventory) {
/*  51 */     ItemStack stackOut = null;
/*  52 */     int[] aint = new int[3];
/*  53 */     int i = 0;
/*  54 */     int j = 0;
/*  55 */     IDyeable itemDyeable = null;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  62 */     for (int k = 0; k < inventory.func_70302_i_(); k++) {
/*  63 */       ItemStack stackIn = inventory.func_70301_a(k);
/*     */       
/*  65 */       if (stackIn != null) {
/*  66 */         if ((stackIn.func_77973_b() instanceof IDyeable)) {
/*  67 */           itemDyeable = (IDyeable)stackIn.func_77973_b();
/*     */           
/*  69 */           if (stackOut != null) {
/*  70 */             return null;
/*     */           }
/*     */           
/*  73 */           stackOut = stackIn.func_77946_l();
/*  74 */           stackOut.field_77994_a = 1;
/*     */           
/*  76 */           if (itemDyeable.hasDyeColor(stackIn)) {
/*  77 */             int l = itemDyeable.getDyeColor(stackOut);
/*  78 */             float f = (l >> 16 & 0xFF) / 255.0F;
/*  79 */             float f1 = (l >> 8 & 0xFF) / 255.0F;
/*  80 */             float f2 = (l & 0xFF) / 255.0F;
/*  81 */             i = (int)(i + Math.max(f, Math.max(f1, f2)) * 255.0F);
/*  82 */             aint[0] = ((int)(aint[0] + f * 255.0F));
/*  83 */             aint[1] = ((int)(aint[1] + f1 * 255.0F));
/*  84 */             aint[2] = ((int)(aint[2] + f2 * 255.0F));
/*  85 */             j++;
/*     */           }
/*     */         } else {
/*  88 */           if (stackIn.func_77973_b() != Items.field_151100_aR) {
/*  89 */             return null;
/*     */           }
/*     */           
/*  92 */           float[] afloat = EntitySheep.func_175513_a(EnumDyeColor.func_176766_a(stackIn.func_77960_j()));
/*  93 */           int j1 = (int)(afloat[0] * 255.0F);
/*  94 */           int k1 = (int)(afloat[1] * 255.0F);
/*  95 */           int l1 = (int)(afloat[2] * 255.0F);
/*  96 */           i += Math.max(j1, Math.max(k1, l1));
/*  97 */           aint[0] += j1;
/*  98 */           aint[1] += k1;
/*  99 */           aint[2] += l1;
/* 100 */           j++;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 105 */     if (itemDyeable == null) {
/* 106 */       return null;
/*     */     }
/* 108 */     k = aint[0] / j;
/* 109 */     int newColor = aint[1] / j;
/* 110 */     int l = aint[2] / j;
/* 111 */     float f = i / j;
/* 112 */     float f1 = Math.max(k, Math.max(newColor, l));
/* 113 */     k = (int)(k * f / f1);
/* 114 */     newColor = (int)(newColor * f / f1);
/* 115 */     l = (int)(l * f / f1);
/* 116 */     int l1 = (k << 8) + newColor;
/* 117 */     l1 = (l1 << 8) + l;
/* 118 */     itemDyeable.setDyeColor(stackOut, l1);
/* 119 */     return stackOut;
/*     */   }
/*     */   
/*     */   public int func_77570_a()
/*     */   {
/* 124 */     return 10;
/*     */   }
/*     */   
/*     */   public ItemStack func_77571_b() {
/* 128 */     return null;
/*     */   }
/*     */   
/*     */   public ItemStack[] func_179532_b(InventoryCrafting inventory) {
/* 132 */     ItemStack[] remainingStacks = new ItemStack[inventory.func_70302_i_()];
/*     */     
/* 134 */     for (int i = 0; i < remainingStacks.length; i++) {
/* 135 */       ItemStack stackIn = inventory.func_70301_a(i);
/* 136 */       remainingStacks[i] = ForgeHooks.getContainerItem(stackIn);
/*     */     }
/*     */     
/* 139 */     return remainingStacks;
/*     */   }
/*     */   
/*     */   public static abstract interface IDyeable
/*     */   {
/*     */     public abstract boolean hasDyeColor(ItemStack paramItemStack);
/*     */     
/*     */     public abstract int getDyeColor(ItemStack paramItemStack);
/*     */     
/*     */     public abstract void setDyeColor(ItemStack paramItemStack, int paramInt);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/recipes/RecipesDyeableItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */