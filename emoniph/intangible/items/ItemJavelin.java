/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityJavelin;
/*    */ import net.minecraft.enchantment.Enchantment;
/*    */ import net.minecraft.enchantment.EnchantmentHelper;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.InventoryPlayer;
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemJavelin extends net.minecraft.item.Item implements IItem, ICreativeSort
/*    */ {
/*    */   public ItemJavelin()
/*    */   {
/* 17 */     func_77625_d(4);
/*    */   }
/*    */   
/*    */   public void func_77615_a(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft)
/*    */   {
/* 22 */     int i = func_77626_a(stack) - timeLeft;
/*    */     
/* 24 */     float f = i / 20.0F;
/* 25 */     f = (f * f + f * 2.0F) / 3.0F;
/*    */     
/* 27 */     if (f < 0.1D) {
/* 28 */       return;
/*    */     }
/*    */     
/* 31 */     if (f > 1.0F) {
/* 32 */       f = 1.0F;
/*    */     }
/*    */     
/* 35 */     EntityJavelin entityJavelin = new EntityJavelin(worldIn, playerIn, f * 0.8F);
/*    */     
/* 37 */     if (f == 1.0F) {
/* 38 */       entityJavelin.setIsCritical(true);
/*    */     }
/*    */     
/* 41 */     entityJavelin.setDamage(6.0D);
/*    */     
/* 43 */     int j = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, stack);
/*    */     
/* 45 */     if (j > 0) {
/* 46 */       entityJavelin.setDamage(entityJavelin.getDamage() + j * 0.5D + 0.5D);
/*    */     }
/*    */     
/* 49 */     int k = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, stack);
/*    */     
/* 51 */     if (k > 0) {
/* 52 */       entityJavelin.setKnockbackStrength(k + 1);
/*    */     }
/*    */     
/* 55 */     if (EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, stack) > 0) {
/* 56 */       entityJavelin.func_70015_d(100);
/*    */     }
/*    */     
/* 59 */     if (!playerIn.field_71075_bZ.field_75098_d) { if (--stack.field_77994_a <= 0) {
/* 60 */         playerIn.field_71071_by.func_70299_a(playerIn.field_71071_by.field_70461_c, null);
/*    */       }
/*    */     }
/* 63 */     worldIn.func_72956_a(playerIn, "random.bow", 1.0F, 1.0F / (field_77697_d.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
/*    */     
/* 65 */     if (!worldIn.field_72995_K) {
/* 66 */       worldIn.func_72838_d(entityJavelin);
/* 67 */       emoniph.intangible.util.EntityUtil.correctProjectileTrackerSync(worldIn, entityJavelin);
/*    */     }
/*    */   }
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack stack, World worldIn, EntityPlayer playerIn) {
/* 72 */     return stack;
/*    */   }
/*    */   
/*    */   public int func_77626_a(ItemStack stack) {
/* 76 */     return 72000;
/*    */   }
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack stack) {
/* 80 */     return EnumAction.BOW;
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
/* 84 */     playerIn.func_71008_a(itemStackIn, func_77626_a(itemStackIn));
/* 85 */     return itemStackIn;
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack stack)
/*    */   {
/* 90 */     return EnumRarity.UNCOMMON;
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 95 */     return 87;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemJavelin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */