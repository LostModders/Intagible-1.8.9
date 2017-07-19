/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ public class TileEntityVoid extends TileEntity
/*    */ {
/*    */   private net.minecraft.util.BlockPos ownerPos;
/*    */   
/*    */   public void setOwner(TileEntity owner)
/*    */   {
/* 12 */     this.ownerPos = owner.func_174877_v();
/*    */   }
/*    */   
/*    */   public net.minecraft.util.BlockPos getOwnerPos() {
/* 16 */     return this.ownerPos;
/*    */   }
/*    */   
/*    */   public void func_145839_a(NBTTagCompound compound) {
/* 20 */     super.func_145839_a(compound);
/* 21 */     if (compound.func_150297_b("ownerPos", 4)) {
/* 22 */       this.ownerPos = net.minecraft.util.BlockPos.func_177969_a(compound.func_74763_f("ownerPos"));
/*    */     } else {
/* 24 */       this.ownerPos = null;
/*    */     }
/*    */   }
/*    */   
/*    */   public void func_145841_b(NBTTagCompound compound) {
/* 29 */     super.func_145841_b(compound);
/* 30 */     if (this.ownerPos != null) {
/* 31 */       compound.func_74772_a("ownerPos", this.ownerPos.func_177986_g());
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/TileEntityVoid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */