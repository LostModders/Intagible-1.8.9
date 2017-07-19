/*    */ package emoniph.intangible.items;
/*    */ 
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.entity.EntityKnowledgeGem;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemKnowledgeGem extends net.minecraft.item.Item implements IItem, ICreativeSort
/*    */ {
/*    */   public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
/*    */   {
/* 14 */     if (!worldIn.field_72995_K) {
/* 15 */       if (worldIn.func_72872_a(EntityKnowledgeGem.class, playerIn.func_174813_aQ().func_72314_b(16.0D, 5.0D, 16.0D)).size() < 2) {
/* 16 */         Sound.MOD_RANDOM_GONG1.playOnlyTo(playerIn, 0.5F, 1.0F);
/* 17 */         EntityKnowledgeGem gem = new EntityKnowledgeGem(worldIn, playerIn);
/* 18 */         worldIn.func_72838_d(gem);
/*    */       } else {
/* 20 */         Sound.MOD_RANDOM_SPELLFAIL.playOnlyTo(playerIn, 0.5F, 1.0F);
/*    */       }
/*    */     }
/*    */     
/* 24 */     return itemStackIn;
/*    */   }
/*    */   
/*    */   public int getCreativeSortIndex()
/*    */   {
/* 29 */     return 1;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemKnowledgeGem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */