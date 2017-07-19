/*    */ package emoniph.intangible.golem;
/*    */ 
/*    */ import emoniph.intangible.api.golem.IGolem;
/*    */ import emoniph.intangible.client.models.ModelGolemHead;
/*    */ import net.minecraft.client.model.ModelRenderer;
/*    */ import net.minecraft.entity.item.EntityItem;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.util.BlockPos;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class GolemHeadHoover extends GolemHead
/*    */ {
/*    */   private final int suctionRange;
/*    */   private final int halfSuctionRange;
/*    */   
/*    */   public GolemHeadHoover(int healthBonus, int suctionRange, ResourceLocation texture)
/*    */   {
/* 21 */     super(healthBonus, 0, texture);
/* 22 */     this.suctionRange = suctionRange;
/* 23 */     this.halfSuctionRange = (suctionRange / 2);
/*    */   }
/*    */   
/*    */   public void onUpdate(IGolem golem, BlockPos prevBlockPos)
/*    */   {
/* 28 */     World world = golem.getGolemWorld();
/* 29 */     if (!world.field_72995_K) {
/* 30 */       java.util.List<EntityItem> items = world.func_72872_a(EntityItem.class, golem
/* 31 */         .getGolemBoundingBox().func_72314_b(this.suctionRange, this.halfSuctionRange, this.suctionRange));
/* 32 */       for (EntityItem item : items) {
/* 33 */         if (item.func_70089_S()) {
/* 34 */           golem.tryAddEntityItemToGolemInventory(item);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public ModelRenderer getModel()
/*    */   {
/* 43 */     if (this.model == null) {
/* 44 */       this.model = new emoniph.intangible.client.models.ModelGolemHeadHoover();
/*    */     }
/* 46 */     return this.model.head;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemHeadHoover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */