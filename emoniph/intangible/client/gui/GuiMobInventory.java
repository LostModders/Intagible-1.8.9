/*    */ package emoniph.intangible.client.gui;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class GuiMobInventory extends GuiContainer
/*    */ {
/* 14 */   private static final ResourceLocation CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
/*    */   private IInventory upperChestInventory;
/*    */   private IInventory lowerChestInventory;
/*    */   private int inventoryRows;
/*    */   
/*    */   public GuiMobInventory(IInventory upperInv, IInventory lowerInv) {
/* 20 */     super(new emoniph.intangible.potions.PotionPickpocket.ContainerMobInventory(lowerInv, upperInv, Minecraft.func_71410_x().field_71439_g));
/* 21 */     this.upperChestInventory = upperInv;
/* 22 */     this.lowerChestInventory = lowerInv;
/* 23 */     this.field_146291_p = false;
/* 24 */     int i = 222;
/* 25 */     int j = i - 108;
/* 26 */     this.inventoryRows = 1;
/* 27 */     this.field_147000_g = (j + this.inventoryRows * 18);
/*    */   }
/*    */   
/*    */   protected void func_146979_b(int mouseX, int mouseY) {
/* 31 */     this.field_146289_q.func_78276_b(this.lowerChestInventory.func_145748_c_().func_150260_c(), 8, 6, 4210752);
/* 32 */     this.field_146289_q.func_78276_b(this.upperChestInventory.func_145748_c_().func_150260_c(), 8, this.field_147000_g - 96 + 2, 4210752);
/*    */   }
/*    */   
/*    */   protected void func_146976_a(float partialTicks, int mouseX, int mouseY) {
/* 36 */     net.minecraft.client.renderer.GlStateManager.func_179131_c(1.0F, 1.0F, 1.0F, 1.0F);
/* 37 */     this.field_146297_k.func_110434_K().func_110577_a(CHEST_GUI_TEXTURE);
/* 38 */     int i = (this.field_146294_l - this.field_146999_f) / 2;
/* 39 */     int j = (this.field_146295_m - this.field_147000_g) / 2;
/* 40 */     func_73729_b(i, j, 0, 0, this.field_146999_f, this.inventoryRows * 18 + 17);
/* 41 */     func_73729_b(i, j + this.inventoryRows * 18 + 17, 0, 126, this.field_146999_f, 96);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/gui/GuiMobInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */