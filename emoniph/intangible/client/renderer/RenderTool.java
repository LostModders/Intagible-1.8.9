/*    */ package emoniph.intangible.client.renderer;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityTool;
/*    */ import emoniph.intangible.util.EntityUtil;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.client.renderer.ItemRenderer;
/*    */ import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.renderer.texture.TextureMap;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemBlock;
/*    */ import net.minecraft.item.ItemBow;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.item.ItemSword;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class RenderTool
/*    */   extends Render<EntityTool>
/*    */ {
/*    */   public RenderTool(RenderManager renderManager)
/*    */   {
/* 30 */     super(renderManager);
/*    */   }
/*    */   
/*    */   public void doRender(EntityTool entity, double x, double y, double z, float entityYaw, float partialTicks)
/*    */   {
/* 35 */     ItemStack itemstack = entity.func_70694_bm();
/*    */     
/* 37 */     if (itemstack != null)
/*    */     {
/* 39 */       GlStateManager.func_179094_E();
/*    */       
/* 41 */       GlStateManager.func_179137_b(x, y + 0.5D, z);
/*    */       
/* 43 */       float yaw = EntityUtil.interpolateRotation(entity.field_70760_ar, entity.field_70761_aq, partialTicks);
/* 44 */       float yawFix = (180.0F - yaw) % 90.0F;
/* 45 */       GlStateManager.func_179114_b(yawFix, 0.0F, 1.0F, 0.0F);
/*    */       
/* 47 */       GlStateManager.func_179114_b(90.0F, 1.0F, 0.0F, 0.0F);
/* 48 */       if (entity.getAttackTimerStandardRight() > 0) {
/* 49 */         if ((entity.func_70694_bm().func_77973_b() instanceof ItemBow)) {
/* 50 */           itemstack.func_77964_b((10 - entity.getAttackTimerStandardRight()) / 3);
/* 51 */         } else if ((itemstack.func_77973_b() instanceof ItemSword)) {
/* 52 */           GlStateManager.func_179114_b(90.0F * (10.0F - entity.getAttackTimerStandardRight()) / 10.0F, 1.0F, 0.0F, 0.0F);
/*    */         } else {
/* 54 */           GlStateManager.func_179114_b(180.0F * (10.0F - entity.getAttackTimerStandardRight()) / 10.0F, 1.0F, 0.0F, 0.0F);
/*    */         }
/*    */       } else {
/* 57 */         itemstack.func_77964_b(0);
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 62 */       Item item = itemstack.func_77973_b();
/* 63 */       Minecraft minecraft = Minecraft.func_71410_x();
/*    */       
/* 65 */       if (((item instanceof ItemBlock)) && (Block.func_149634_a(item).func_149645_b() == 2))
/*    */       {
/* 67 */         GlStateManager.func_179109_b(0.0F, 0.1875F, -0.3125F);
/* 68 */         GlStateManager.func_179114_b(20.0F, 1.0F, 0.0F, 0.0F);
/* 69 */         GlStateManager.func_179114_b(45.0F, 0.0F, 1.0F, 0.0F);
/* 70 */         float f1 = 0.375F;
/* 71 */         GlStateManager.func_179152_a(-f1, -f1, f1);
/*    */       }
/* 73 */       if (((itemstack.func_77973_b() instanceof ItemBow)) && (!itemstack.func_77942_o())) {
/* 74 */         itemstack.func_77982_d(new NBTTagCompound());
/* 75 */         itemstack.func_77978_p().func_74757_a("Unbreakable", true);
/*    */       }
/*    */       
/* 78 */       minecraft.func_175597_ag().func_178099_a(entity, itemstack, ItemCameraTransforms.TransformType.THIRD_PERSON);
/* 79 */       GlStateManager.func_179121_F();
/*    */     }
/*    */   }
/*    */   
/*    */   protected ResourceLocation getEntityTexture(EntityTool entity)
/*    */   {
/* 85 */     return TextureMap.field_110575_b;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */