/*     */ package emoniph.intangible.potions;
/*     */ 
/*     */ import emoniph.intangible.player.PlayerEx;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.event.entity.player.EntityInteractEvent;
/*     */ 
/*     */ public class PotionPickpocket extends Potion
/*     */ {
/*     */   protected PotionPickpocket(ResourceLocation location)
/*     */   {
/*  18 */     super(location, false, 10040132);
/*  19 */     func_76390_b("potion.intangible:pickpocket");
/*     */   }
/*     */   
/*     */   public void onInteractWithEntity(PlayerEx playerEx, EntityInteractEvent event) {
/*  23 */     if (playerEx.PLAYER.func_70644_a(this)) {
/*  24 */       if ((event.target instanceof EntityPlayer)) {
/*  25 */         EntityPlayer victim = (EntityPlayer)event.target;
/*     */         
/*  27 */         playerEx.PLAYER.func_71007_a(victim.field_71071_by);
/*     */       }
/*  29 */       else if ((event.target instanceof EntityLiving)) {
/*  30 */         EntityLiving victim = (EntityLiving)event.target;
/*  31 */         playerEx.PLAYER.openGui(emoniph.intangible.Intangible.INSTANCE, 1, playerEx.PLAYER.field_70170_p, victim.func_145782_y(), 0, 0);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static class ContainerMobInventory extends Container {
/*     */     private IInventory lowerChestInventory;
/*     */     private int numRows;
/*     */     
/*     */     public ContainerMobInventory(IInventory playerInventory, IInventory chestInventory, EntityPlayer player) {
/*  41 */       this.lowerChestInventory = chestInventory;
/*  42 */       this.numRows = 1;
/*  43 */       chestInventory.func_174889_b(player);
/*  44 */       int i = (this.numRows - 4) * 18;
/*     */       
/*  46 */       for (int j = 0; j < this.numRows; j++) {
/*  47 */         for (int k = 0; k < chestInventory.func_70302_i_(); k++) {
/*  48 */           func_75146_a(new Slot(chestInventory, k + j * 9, 8 + k * 18, 18 + j * 18));
/*     */         }
/*     */       }
/*     */       
/*  52 */       for (int l = 0; l < 3; l++) {
/*  53 */         for (int j1 = 0; j1 < 9; j1++) {
/*  54 */           func_75146_a(new Slot(playerInventory, j1 + l * 9 + 9, 8 + j1 * 18, 103 + l * 18 + i));
/*     */         }
/*     */       }
/*     */       
/*  58 */       for (int i1 = 0; i1 < 9; i1++) {
/*  59 */         func_75146_a(new Slot(playerInventory, i1, 8 + i1 * 18, 161 + i));
/*     */       }
/*     */     }
/*     */     
/*     */     public boolean func_75145_c(EntityPlayer playerIn) {
/*  64 */       return this.lowerChestInventory.func_70300_a(playerIn);
/*     */     }
/*     */     
/*     */     public ItemStack func_82846_b(EntityPlayer playerIn, int index) {
/*  68 */       ItemStack itemstack = null;
/*  69 */       Slot slot = (Slot)this.field_75151_b.get(index);
/*     */       
/*  71 */       if ((slot != null) && (slot.func_75216_d())) {
/*  72 */         ItemStack itemstack1 = slot.func_75211_c();
/*  73 */         itemstack = itemstack1.func_77946_l();
/*     */         
/*  75 */         if (index < this.numRows * 9) {
/*  76 */           if (!func_75135_a(itemstack1, this.numRows * 9, this.field_75151_b.size(), true)) {
/*  77 */             return null;
/*     */           }
/*  79 */         } else if (!func_75135_a(itemstack1, 0, this.numRows * 9, false)) {
/*  80 */           return null;
/*     */         }
/*     */         
/*  83 */         if (itemstack1.field_77994_a == 0) {
/*  84 */           slot.func_75215_d((ItemStack)null);
/*     */         } else {
/*  86 */           slot.func_75218_e();
/*     */         }
/*     */       }
/*     */       
/*  90 */       return itemstack;
/*     */     }
/*     */     
/*     */     public void func_75134_a(EntityPlayer playerIn) {
/*  94 */       super.func_75134_a(playerIn);
/*  95 */       this.lowerChestInventory.func_174886_c(playerIn);
/*     */     }
/*     */     
/*     */     public IInventory getLowerChestInventory() {
/*  99 */       return this.lowerChestInventory;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class MobIntentoryWrapper implements IInventory
/*     */   {
/*     */     private final EntityLiving mob;
/*     */     
/*     */     public MobIntentoryWrapper(EntityLiving mob) {
/* 108 */       this.mob = mob;
/*     */     }
/*     */     
/*     */     public int func_70302_i_()
/*     */     {
/* 113 */       ItemStack[] inv = this.mob.func_70035_c();
/* 114 */       return inv.length;
/*     */     }
/*     */     
/*     */     public ItemStack func_70301_a(int index)
/*     */     {
/* 119 */       ItemStack[] inv = this.mob.func_70035_c();
/* 120 */       return index < inv.length ? inv[index] : null;
/*     */     }
/*     */     
/*     */     public ItemStack func_70298_a(int index, int count)
/*     */     {
/* 125 */       ItemStack[] inv = this.mob.func_70035_c();
/* 126 */       if ((index < inv.length) && (inv[index] != null)) {
/* 127 */         if (inv[index].field_77994_a <= count) {
/* 128 */           ItemStack itemstack1 = inv[index];
/* 129 */           inv[index] = null;
/* 130 */           func_70296_d();
/* 131 */           return itemstack1;
/*     */         }
/* 133 */         ItemStack itemstack = inv[index].func_77979_a(count);
/*     */         
/* 135 */         if (inv[index].field_77994_a == 0) {
/* 136 */           inv[index] = null;
/*     */         }
/*     */         
/* 139 */         func_70296_d();
/* 140 */         return itemstack;
/*     */       }
/*     */       
/* 143 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public ItemStack func_70304_b(int index)
/*     */     {
/* 149 */       ItemStack[] inv = this.mob.func_70035_c();
/* 150 */       if ((index < inv.length) && (inv[index] != null)) {
/* 151 */         ItemStack itemstack = inv[index];
/* 152 */         inv[index] = null;
/* 153 */         return itemstack;
/*     */       }
/* 155 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70299_a(int index, ItemStack stack)
/*     */     {
/* 161 */       ItemStack[] inv = this.mob.func_70035_c();
/* 162 */       if (index < inv.length) {
/* 163 */         inv[index] = stack;
/*     */         
/* 165 */         if ((stack != null) && (stack.field_77994_a > func_70297_j_())) {
/* 166 */           stack.field_77994_a = func_70297_j_();
/*     */         }
/*     */         
/* 169 */         func_70296_d();
/*     */       }
/*     */     }
/*     */     
/*     */     public int func_70297_j_()
/*     */     {
/* 175 */       return 64;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_70296_d() {}
/*     */     
/*     */ 
/*     */     public boolean func_70300_a(EntityPlayer player)
/*     */     {
/* 184 */       return player.func_70068_e(this.mob) <= 64.0D;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void func_174889_b(EntityPlayer player) {}
/*     */     
/*     */ 
/*     */     public void func_174886_c(EntityPlayer player) {}
/*     */     
/*     */ 
/*     */     public boolean func_94041_b(int index, ItemStack stack)
/*     */     {
/* 197 */       ItemStack[] inv = this.mob.func_70035_c();
/* 198 */       return index < inv.length;
/*     */     }
/*     */     
/*     */     public int func_174887_a_(int id)
/*     */     {
/* 203 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_174885_b(int id, int value) {}
/*     */     
/*     */ 
/*     */     public int func_174890_g()
/*     */     {
/* 212 */       return 0;
/*     */     }
/*     */     
/*     */ 
/*     */     public void func_174888_l() {}
/*     */     
/*     */ 
/*     */     public String func_70005_c_()
/*     */     {
/* 221 */       return this.mob.func_70005_c_();
/*     */     }
/*     */     
/*     */     public boolean func_145818_k_()
/*     */     {
/* 226 */       return this.mob.func_145818_k_();
/*     */     }
/*     */     
/*     */     public net.minecraft.util.IChatComponent func_145748_c_()
/*     */     {
/* 231 */       return this.mob.func_145748_c_();
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/potions/PotionPickpocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */