/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.entity.EntityFood;
/*    */ import emoniph.intangible.util.CropUtil;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.EnumAction;
/*    */ import net.minecraft.item.EnumRarity;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class ItemCornucopia extends Item implements IItem, ICreativeSort
/*    */ {
/*    */   public ItemCornucopia()
/*    */   {
/* 19 */     func_77625_d(1);
/* 20 */     func_77656_e(39);
/*    */   }
/*    */   
/*    */ 
/*    */   public void func_77615_a(ItemStack stack, World worldIn, EntityPlayer playerIn, int timeLeft) {}
/*    */   
/*    */   public void onUsingTick(ItemStack stack, EntityPlayer player, int count)
/*    */   {
/* 28 */     if (count % 10 == 0) {
/* 29 */       if (!player.field_70170_p.field_72995_K) {
/* 30 */         Sound.MOD_RANDOM_THUMP.playToAllNear(player, 0.5F, 1.0F);
/* 31 */         ItemStack crop = CropUtil.getRandomFood(player.field_70170_p.field_73012_v);
/* 32 */         if (crop != null) {
/* 33 */           EntityFood food = new EntityFood(player.field_70170_p, player, crop.func_77946_l());
/* 34 */           player.field_70170_p.func_72838_d(food);
/*    */         }
/*    */       }
/* 37 */       stack.func_77972_a(1, player);
/*    */     }
/*    */   }
/*    */   
/*    */   public ItemStack func_77654_b(ItemStack stack, World worldIn, EntityPlayer playerIn) {
/* 42 */     return stack;
/*    */   }
/*    */   
/*    */   public int func_77626_a(ItemStack stack) {
/* 46 */     return 72000;
/*    */   }
/*    */   
/*    */   public EnumAction func_77661_b(ItemStack stack) {
/* 50 */     return EnumAction.BOW;
/*    */   }
/*    */   
/*    */   public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
/* 54 */     playerIn.func_71008_a(itemStackIn, func_77626_a(itemStackIn));
/* 55 */     return itemStackIn;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_77636_d(ItemStack stack)
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   public EnumRarity func_77613_e(ItemStack stack)
/*    */   {
/* 66 */     return EnumRarity.EPIC;
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 71 */     return 86;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemCornucopia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */