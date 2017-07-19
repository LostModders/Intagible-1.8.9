/*     */ package emoniph.intangible.golem;
/*     */ 
/*     */ import emoniph.intangible.api.BodySide;
/*     */ import emoniph.intangible.api.IFakePlayerProvider;
/*     */ import emoniph.intangible.api.golem.IGolemArm;
/*     */ import emoniph.intangible.client.models.ModelGolemArm;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.model.ModelRenderer;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraftforge.common.ForgeHooks;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public abstract class GolemArm implements IGolemArm
/*     */ {
/*     */   public int getCooldownTicks()
/*     */   {
/*  26 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */   public abstract boolean onUseAction(World paramWorld, EntityPlayer paramEntityPlayer, EntityLiving paramEntityLiving, IFakePlayerProvider paramIFakePlayerProvider, BlockPos paramBlockPos, BodySide paramBodySide);
/*     */   
/*     */   public boolean canSwing()
/*     */   {
/*  34 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canPoint()
/*     */   {
/*  39 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canStartBlocks()
/*     */   {
/*  44 */     return false;
/*     */   }
/*     */   
/*  47 */   private static final ResourceLocation TEXTURE = new ResourceLocation("intangible:textures/entity/wreckinggolem.png");
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelGolemArm modelLeft;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*  52 */   public ResourceLocation getTexture(BodySide side) { return TEXTURE; }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelGolemArm modelRight;
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   private ModelGolemArm getModelForSide(BodySide side)
/*     */   {
/*  63 */     switch (side) {
/*     */     case RIGHT: 
/*  65 */       if (this.modelRight == null) {
/*  66 */         this.modelRight = createModel(side);
/*     */       }
/*  68 */       return this.modelRight;
/*     */     }
/*     */     
/*  71 */     if (this.modelLeft == null) {
/*  72 */       this.modelLeft = createModel(side);
/*     */     }
/*  74 */     return this.modelLeft;
/*     */   }
/*     */   
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelRenderer getModel(BodySide side)
/*     */   {
/*  81 */     return getModelForSide(side).arm;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void updateModelRotation(EntityLiving entity, float limbSwing, float prevLimbSwingAmount, float partialTicks, int attackTicks, BodySide side)
/*     */   {
/*  87 */     getModelForSide(side).updateModelRotation(entity, limbSwing, prevLimbSwingAmount, partialTicks, attackTicks, side);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected abstract ModelGolemArm createModel(BodySide paramBodySide);
/*     */   
/*     */   protected void breakBlock(final EntityPlayer player, final BlockPos blockPos, final ItemStack item) {
/*  94 */     if (!player.field_70170_p.field_72995_K) {
/*  95 */       ((WorldServer)player.field_70170_p).func_152344_a(new Runnable()
/*     */       {
/*     */         public void run() {
/*  98 */           emoniph.intangible.util.BlockUtil.tryHarvestBlock(player.field_70170_p, blockPos, (net.minecraft.entity.player.EntityPlayerMP)player, item);
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   protected boolean breakBlock(EntityPlayer player, BlockPos pos, ItemStack stack, boolean impactPoint) {
/* 105 */     World world = player.field_70170_p;
/* 106 */     IBlockState state = player.field_70170_p.func_180495_p(pos);
/* 107 */     Block block = state.func_177230_c();
/* 108 */     if ((ForgeHooks.canHarvestBlock(block, player, world, pos)) && (block.func_176195_g(world, pos) >= 0.0F) && (!block.hasTileEntity(state)))
/*     */     {
/* 110 */       String harvestTool = block.getHarvestTool(state);
/*     */       
/* 112 */       boolean effective = (ForgeHooks.isToolEffective(world, pos, stack)) || (harvestTool == null) || (harvestTool.equals(stack.func_77973_b().getToolClasses(stack)));
/* 113 */       if ((impactPoint) || (effective)) {
/* 114 */         breakBlock(player, pos, stack);
/*     */       }
/* 116 */       return effective;
/*     */     }
/* 118 */     return false;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemArm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */