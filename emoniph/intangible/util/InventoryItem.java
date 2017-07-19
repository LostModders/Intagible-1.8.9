/*     */ package emoniph.intangible.util;
/*     */ 
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class InventoryItem implements emoniph.intangible.api.IInventoryItem
/*     */ {
/*     */   private final IInventory inventory;
/*     */   private final int slot;
/*     */   private ItemStack reserved;
/*     */   
/*     */   public InventoryItem(IInventory inventory, int slot)
/*     */   {
/*  16 */     this.inventory = inventory;
/*  17 */     this.slot = slot;
/*     */   }
/*     */   
/*     */   public ItemStack getStackInSlot()
/*     */   {
/*  22 */     if (this.reserved != null) {
/*  23 */       return this.reserved;
/*     */     }
/*  25 */     return this.inventory.func_70301_a(this.slot);
/*     */   }
/*     */   
/*     */ 
/*     */   public ItemStack decrStackInSlot(int count)
/*     */   {
/*  31 */     return this.inventory.func_70298_a(this.slot, count);
/*     */   }
/*     */   
/*     */   public void reserve()
/*     */   {
/*  36 */     this.reserved = this.inventory.func_70298_a(this.slot, 1);
/*     */   }
/*     */   
/*     */   public void rollback(World world, BlockPos pos)
/*     */   {
/*  41 */     if (this.reserved != null) {
/*  42 */       ItemStack stack = this.inventory.func_70301_a(this.slot);
/*  43 */       if (stack == null) {
/*  44 */         this.inventory.func_70299_a(this.slot, this.reserved);
/*  45 */       } else if ((ItemStack.func_179545_c(stack, this.reserved)) && (ItemStack.func_77970_a(stack, this.reserved))) {
/*  46 */         stack.field_77994_a += this.reserved.field_77994_a;
/*     */       } else {
/*  48 */         emoniph.intangible.Get.log().debug(String.format("Trying to add stack %s back to where it came from but that now contains %s. Spawning in world...", new Object[] { this.reserved.toString(), stack.toString() }));
/*  49 */         world.func_72838_d(new net.minecraft.entity.item.EntityItem(world, pos.func_177958_n() + 0.5D, pos.func_177956_o() + 0.5D, pos.func_177952_p() + 0.5D, this.reserved));
/*     */       }
/*  51 */       this.reserved = null;
/*     */     }
/*     */   }
/*     */   
/*     */   public void commit()
/*     */   {
/*  57 */     this.reserved = null;
/*     */   }
/*     */   
/*     */   public static class Empty implements emoniph.intangible.api.IInventoryItem
/*     */   {
/*     */     public ItemStack getStackInSlot()
/*     */     {
/*  64 */       return null;
/*     */     }
/*     */     
/*     */     public ItemStack decrStackInSlot(int count)
/*     */     {
/*  69 */       return null;
/*     */     }
/*     */     
/*     */ 
/*     */     public void reserve() {}
/*     */     
/*     */ 
/*     */     public void rollback(World world, BlockPos pos) {}
/*     */     
/*     */ 
/*     */     public void commit() {}
/*     */   }
/*     */   
/*     */ 
/*     */   public static class ReadOnly
/*     */     implements emoniph.intangible.api.IInventoryItem
/*     */   {
/*     */     private final IInventory inventory;
/*     */     
/*     */     private final int slot;
/*     */     
/*     */     public ReadOnly(IInventory inventory, int slot)
/*     */     {
/*  92 */       this.inventory = inventory;
/*  93 */       this.slot = slot;
/*     */     }
/*     */     
/*     */     public ItemStack getStackInSlot()
/*     */     {
/*  98 */       return this.inventory.func_70301_a(this.slot);
/*     */     }
/*     */     
/*     */     public ItemStack decrStackInSlot(int count)
/*     */     {
/* 103 */       return null;
/*     */     }
/*     */     
/*     */     public void reserve() {}
/*     */     
/*     */     public void rollback(World world, BlockPos pos) {}
/*     */     
/*     */     public void commit() {}
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/InventoryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */