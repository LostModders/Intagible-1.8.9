/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.entity.EntityChariot;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ItemChariot extends net.minecraft.item.Item implements IItem, ICreativeSort
/*     */ {
/*     */   public ItemChariot()
/*     */   {
/*  19 */     this.field_77777_bU = 1;
/*     */   }
/*     */   
/*     */   public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
/*     */   {
/*  24 */     float f = 1.0F;
/*  25 */     float f1 = playerIn.field_70127_C + (playerIn.field_70125_A - playerIn.field_70127_C) * f;
/*  26 */     float f2 = playerIn.field_70126_B + (playerIn.field_70177_z - playerIn.field_70126_B) * f;
/*  27 */     double d0 = playerIn.field_70169_q + (playerIn.field_70165_t - playerIn.field_70169_q) * f;
/*  28 */     double d1 = playerIn.field_70167_r + (playerIn.field_70163_u - playerIn.field_70167_r) * f + playerIn.func_70047_e();
/*  29 */     double d2 = playerIn.field_70166_s + (playerIn.field_70161_v - playerIn.field_70166_s) * f;
/*  30 */     Vec3 vec3 = new Vec3(d0, d1, d2);
/*  31 */     float f3 = MathHelper.func_76134_b(-f2 * 0.017453292F - 3.1415927F);
/*  32 */     float f4 = MathHelper.func_76126_a(-f2 * 0.017453292F - 3.1415927F);
/*  33 */     float f5 = -MathHelper.func_76134_b(-f1 * 0.017453292F);
/*  34 */     float f6 = MathHelper.func_76126_a(-f1 * 0.017453292F);
/*  35 */     float f7 = f4 * f5;
/*  36 */     float f8 = f3 * f5;
/*  37 */     double d3 = 5.0D;
/*  38 */     Vec3 vec31 = vec3.func_72441_c(f7 * d3, f6 * d3, f8 * d3);
/*  39 */     MovingObjectPosition movingobjectposition = worldIn.func_72901_a(vec3, vec31, true);
/*     */     
/*  41 */     if (movingobjectposition == null) {
/*  42 */       return itemStackIn;
/*     */     }
/*  44 */     Vec3 vec32 = playerIn.func_70676_i(f);
/*  45 */     boolean flag = false;
/*  46 */     float f9 = 1.0F;
/*  47 */     List<Entity> list = worldIn.func_72839_b(playerIn, playerIn.func_174813_aQ().func_72321_a(vec32.field_72450_a * d3, vec32.field_72448_b * d3, vec32.field_72449_c * d3).func_72314_b(f9, f9, f9));
/*     */     
/*  49 */     for (int i = 0; i < list.size(); i++) {
/*  50 */       Entity entity = (Entity)list.get(i);
/*     */       
/*  52 */       if (entity.func_70067_L()) {
/*  53 */         float f10 = entity.func_70111_Y();
/*  54 */         AxisAlignedBB axisalignedbb = entity.func_174813_aQ().func_72314_b(f10, f10, f10);
/*     */         
/*  56 */         if (axisalignedbb.func_72318_a(vec3)) {
/*  57 */           flag = true;
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  62 */     if (flag) {
/*  63 */       return itemStackIn;
/*     */     }
/*  65 */     if (movingobjectposition.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK) {
/*  66 */       BlockPos blockpos = movingobjectposition.func_178782_a();
/*     */       
/*  68 */       if (worldIn.func_180495_p(blockpos).func_177230_c() == net.minecraft.init.Blocks.field_150431_aC) {
/*  69 */         blockpos = blockpos.func_177977_b();
/*     */       }
/*     */       
/*  72 */       EntityChariot entityChariot = new EntityChariot(worldIn, blockpos.func_177958_n() + 0.5F, blockpos.func_177956_o() + 1.0F, blockpos.func_177952_p() + 0.5F);
/*  73 */       entityChariot.field_70177_z = (((MathHelper.func_76128_c(playerIn.field_70177_z * 4.0F / 360.0F + 0.5D) & 0x3) - 1) * 90);
/*     */       
/*  75 */       if (!worldIn.func_72945_a(entityChariot, entityChariot.func_174813_aQ().func_72314_b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
/*  76 */         return itemStackIn;
/*     */       }
/*     */       
/*  79 */       if (!worldIn.field_72995_K) {
/*  80 */         worldIn.func_72838_d(entityChariot);
/*     */       }
/*     */       
/*  83 */       if (!playerIn.field_71075_bZ.field_75098_d) {
/*  84 */         itemStackIn.field_77994_a -= 1;
/*     */       }
/*     */       
/*  87 */       playerIn.func_71029_a(net.minecraft.stats.StatList.field_75929_E[net.minecraft.item.Item.func_150891_b(this)]);
/*     */     }
/*     */     
/*  90 */     return itemStackIn;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean func_77636_d(ItemStack stack)
/*     */   {
/*  97 */     return true;
/*     */   }
/*     */   
/*     */   public net.minecraft.item.EnumRarity func_77613_e(ItemStack stack)
/*     */   {
/* 102 */     return net.minecraft.item.EnumRarity.EPIC;
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 107 */     return 85;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemChariot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */