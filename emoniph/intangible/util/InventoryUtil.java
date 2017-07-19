/*     */ package emoniph.intangible.util;
/*     */ 
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public enum InventoryUtil
/*     */ {
/*     */   private InventoryUtil() {}
/*     */   
/*     */   private static int getFirstEmptyStack(IInventory inv)
/*     */   {
/*  12 */     for (int i = 0; i < inv.func_70302_i_(); i++) {
/*  13 */       if (inv.func_70301_a(i) == null) {
/*  14 */         return i;
/*     */       }
/*     */     }
/*     */     
/*  18 */     return -1;
/*     */   }
/*     */   
/*     */   private static int storeItemStack(ItemStack stack, IInventory inv) {
/*  22 */     for (int i = 0; i < inv.func_70302_i_(); i++) {
/*  23 */       ItemStack slotStack = inv.func_70301_a(i);
/*  24 */       if ((slotStack != null) && (slotStack.func_77973_b() == stack.func_77973_b()) && (slotStack.func_77985_e()) && (slotStack.field_77994_a < slotStack.func_77976_d()) && (slotStack.field_77994_a < inv.func_70297_j_()) && ((!slotStack.func_77981_g()) || (slotStack.func_77960_j() == stack.func_77960_j())) && (ItemStack.func_77970_a(slotStack, stack))) {
/*  25 */         return i;
/*     */       }
/*     */     }
/*     */     
/*  29 */     return -1;
/*     */   }
/*     */   
/*     */   private static int storePartialItemStack(ItemStack stackIn, IInventory inv) {
/*  33 */     net.minecraft.item.Item item = stackIn.func_77973_b();
/*  34 */     int i = stackIn.field_77994_a;
/*  35 */     int j = storeItemStack(stackIn, inv);
/*     */     
/*  37 */     if (j < 0) {
/*  38 */       j = getFirstEmptyStack(inv);
/*     */     }
/*     */     
/*  41 */     if (j < 0) {
/*  42 */       return i;
/*     */     }
/*     */     
/*  45 */     if (inv.func_70301_a(j) == null) {
/*  46 */       inv.func_70299_a(j, new ItemStack(item, 0, stackIn.func_77960_j()));
/*     */       
/*  48 */       if (stackIn.func_77942_o()) {
/*  49 */         inv.func_70301_a(j).func_77982_d((net.minecraft.nbt.NBTTagCompound)stackIn.func_77978_p().func_74737_b());
/*     */       }
/*     */     }
/*     */     
/*  53 */     int k = i;
/*     */     
/*  55 */     if (i > inv.func_70301_a(j).func_77976_d() - inv.func_70301_a(j).field_77994_a) {
/*  56 */       k = inv.func_70301_a(j).func_77976_d() - inv.func_70301_a(j).field_77994_a;
/*     */     }
/*     */     
/*  59 */     if (k > inv.func_70297_j_() - inv.func_70301_a(j).field_77994_a) {
/*  60 */       k = inv.func_70297_j_() - inv.func_70301_a(j).field_77994_a;
/*     */     }
/*     */     
/*  63 */     if (k == 0) {
/*  64 */       return i;
/*     */     }
/*  66 */     i -= k;
/*  67 */     inv.func_70301_a(j).field_77994_a += k;
/*  68 */     inv.func_70301_a(j).field_77992_b = 5;
/*  69 */     return i;
/*     */   }
/*     */   
/*     */ 
/*     */   public static boolean addItemStackToInventory(ItemStack stackIn, IInventory inv)
/*     */   {
/*  75 */     if ((stackIn != null) && (stackIn.field_77994_a != 0) && (stackIn.func_77973_b() != null))
/*     */     {
/*     */       try
/*     */       {
/*  79 */         if (stackIn.func_77951_h()) {
/*  80 */           int i = getFirstEmptyStack(inv);
/*     */           
/*  82 */           if (i >= 0) {
/*  83 */             inv.func_70299_a(i, ItemStack.func_77944_b(stackIn));
/*  84 */             inv.func_70301_a(i).field_77992_b = 5;
/*  85 */             stackIn.field_77994_a = 0;
/*  86 */             return true;
/*     */           }
/*  88 */           return false;
/*     */         }
/*     */         int i;
/*     */         do {
/*  92 */           i = stackIn.field_77994_a;
/*  93 */           stackIn.field_77994_a = storePartialItemStack(stackIn, inv);
/*     */         }
/*  95 */         while ((stackIn.field_77994_a > 0) && (stackIn.field_77994_a < i));
/*     */         
/*  97 */         return stackIn.field_77994_a < i;
/*     */       }
/*     */       catch (Throwable throwable) {
/* 100 */         return false;
/*     */       }
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public static boolean consumeInventoryItem(IInventory inv, ItemStack refStack)
/*     */   {
/* 108 */     int i = getInventorySlotContainItem(inv, refStack);
/*     */     
/* 110 */     if (i < 0) {
/* 111 */       return false;
/*     */     }
/* 113 */     if (--inv.func_70301_a(i).field_77994_a <= 0) {
/* 114 */       inv.func_70299_a(i, null);
/*     */     }
/*     */     
/* 117 */     return true;
/*     */   }
/*     */   
/*     */   public static int getInventorySlotContainItem(IInventory inv, ItemStack refStack)
/*     */   {
/* 122 */     int i = 0; for (int count = inv.func_70302_i_(); i < count; i++) {
/* 123 */       ItemStack stack = inv.func_70301_a(i);
/* 124 */       if ((stack != null) && (stack.func_77969_a(refStack))) {
/* 125 */         return i;
/*     */       }
/*     */     }
/*     */     
/* 129 */     return -1;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/InventoryUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */