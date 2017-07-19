/*    */ package emoniph.intangible.util;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ 
/*    */ public enum NbtUtil
/*    */ {
/*    */   private NbtUtil() {}
/*    */   
/*    */   public static NBTTagCompound forEntity(EntityLivingBase entity)
/*    */   {
/* 13 */     NBTTagCompound root = entity.getEntityData();
/* 14 */     if (!root.func_150297_b("intangiblePersist", 10)) {
/* 15 */       root.func_74782_a("intangiblePersist", new NBTTagCompound());
/*    */     }
/* 17 */     return root.func_74775_l("intangiblePersist");
/*    */   }
/*    */   
/*    */   public static NBTTagCompound forStack(ItemStack stack) {
/* 21 */     NBTTagCompound compound = stack.func_77978_p();
/* 22 */     if (compound == null) {
/* 23 */       compound = new NBTTagCompound();
/* 24 */       stack.func_77982_d(compound);
/*    */     }
/* 26 */     return compound;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/NbtUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */