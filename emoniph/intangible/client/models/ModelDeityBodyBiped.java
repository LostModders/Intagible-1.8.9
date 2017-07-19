/*    */ package emoniph.intangible.client.models;
/*    */ 
/*    */ import emoniph.intangible.entity.EntityAvatar;
/*    */ import net.minecraft.client.model.ModelBiped;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */ public class ModelDeityBodyBiped extends ModelBiped
/*    */ {
/*    */   public ModelDeityBodyBiped()
/*    */   {
/* 12 */     super(0.0F, 0.0F, 64, 64);
/*    */     
/* 14 */     this.field_178720_f.field_78806_j = false;
/* 15 */     this.field_78116_c.field_78806_j = false;
/*    */   }
/*    */   
/*    */   public void func_78088_a(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float p_78088_7_)
/*    */   {
/* 20 */     super.func_78088_a(p_78088_1_, p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_);
/*    */   }
/*    */   
/*    */   public void func_78087_a(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity p_78087_7_)
/*    */   {
/* 25 */     super.func_78087_a(p_78087_1_, p_78087_2_, p_78087_3_, p_78087_4_, p_78087_5_, p_78087_6_, p_78087_7_);
/*    */     
/* 27 */     EntityAvatar avatar = (EntityAvatar)p_78087_7_;
/*    */     
/* 29 */     int aoe = avatar.getAttackTimerAOE();
/* 30 */     int def = avatar.getDefenseTimerActivation();
/*    */     
/*    */ 
/* 33 */     if (def > 0) {
/* 34 */       this.field_178723_h.field_78795_f = -3.0F;
/* 35 */       this.field_178724_i.field_78795_f = -3.0F;
/* 36 */     } else if (aoe > 0) {
/* 37 */       float max = avatar.getBody() != null ? avatar.getBody().getAttackAnimationTicksAOE(avatar) : 10.0F;
/* 38 */       this.field_178723_h.field_78796_g = 1.5F;
/* 39 */       this.field_178724_i.field_78796_g = -1.5F;
/* 40 */       this.field_178723_h.field_78795_f = (-1.0F + 1.5F * func_78172_a(aoe - p_78087_6_, max));
/*    */       
/* 42 */       this.field_178724_i.field_78795_f = (-1.0F + 1.5F * func_78172_a(aoe - p_78087_6_, max));
/*    */     } else {
/* 44 */       int i = avatar.getAttackTimerStandardRight();
/* 45 */       if (i > 0) {
/* 46 */         this.field_178723_h.field_78795_f = (-1.0F + 1.5F * func_78172_a(i - p_78087_6_, 10.0F));
/*    */       }
/*    */       
/* 49 */       i = avatar.getAttackTimerStandardLeft();
/* 50 */       if (i > 0) {
/* 51 */         this.field_178724_i.field_78795_f = (-1.0F + 1.5F * func_78172_a(i - p_78087_6_, 10.0F));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   private float func_78172_a(float p_78172_1_, float p_78172_2_) {
/* 57 */     return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/models/ModelDeityBodyBiped.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */