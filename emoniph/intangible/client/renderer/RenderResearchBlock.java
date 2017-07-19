/*     */ package emoniph.intangible.client.renderer;
/*     */ 
/*     */ import emoniph.intangible.blocks.BlockResearch;
/*     */ import emoniph.intangible.blocks.BlockResearch.TileEntityResearchBlock;
/*     */ import emoniph.intangible.client.models.ModelResearchBlock;
/*     */ import emoniph.intangible.util.BlockUtil;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.client.renderer.GlStateManager;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class RenderResearchBlock extends net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer
/*     */ {
/*     */   protected final ModelResearchBlock model;
/*     */   
/*     */   protected RenderResearchBlock(ModelResearchBlock model)
/*     */   {
/*  23 */     this.model = model;
/*     */   }
/*     */   
/*     */   protected abstract net.minecraft.util.ResourceLocation getTexture();
/*     */   
/*     */   public void func_180535_a(TileEntity tile, double x, double y, double z, float partialTicks, int partialBlockDamage)
/*     */   {
/*  30 */     IBlockState mstate = tile.func_145831_w().func_180495_p(tile.func_174877_v());
/*  31 */     if ((!(mstate.func_177230_c() instanceof BlockResearch)) || (!(tile instanceof BlockResearch.TileEntityResearchBlock))) {
/*  32 */       return;
/*     */     }
/*  34 */     GlStateManager.func_179094_E();
/*  35 */     GlStateManager.func_179137_b(x + 0.5D, y + 0.5D, z + 0.5D);
/*  36 */     GlStateManager.func_179114_b(180.0F, 0.0F, 0.0F, 1.0F);
/*  37 */     GlStateManager.func_179109_b(0.0F, -1.0F, 0.0F);
/*     */     
/*  39 */     func_147499_a(getTexture());
/*     */     
/*  41 */     GlStateManager.func_179112_b(770, 771);
/*  42 */     GlStateManager.func_179092_a(516, 0.001F);
/*  43 */     GlStateManager.func_179147_l();
/*     */     
/*  45 */     BlockResearch.TileEntityResearchBlock research = (BlockResearch.TileEntityResearchBlock)tile;
/*  46 */     EnumFacing inputFace = research.getInputFace();
/*     */     
/*  48 */     this.model.getOutputTop().field_78806_j = false;
/*  49 */     this.model.getOutputBottom().field_78806_j = false;
/*  50 */     this.model.getOutputTopTop().field_78806_j = false;
/*  51 */     this.model.getOutputBottomBottom().field_78806_j = false;
/*  52 */     this.model.getOutputTopSide().field_78806_j = false;
/*  53 */     this.model.getOutputBottomSide().field_78806_j = false;
/*     */     Object facing;
/*  55 */     BlockPos otherPos; IBlockState state; if (inputFace == EnumFacing.UP)
/*     */     {
/*  57 */       this.model.getOutputTop().field_78806_j = true;
/*  58 */       this.model.getOutputTopTop().field_78806_j = true;
/*     */       
/*  60 */       for (EnumFacing facing : EnumFacing.field_176754_o) {
/*  61 */         BlockPos otherPos = tile.func_174877_v().func_177972_a(facing);
/*  62 */         IBlockState state = tile.func_145831_w().func_180495_p(otherPos);
/*  63 */         if ((state.func_177230_c() instanceof BlockResearch)) {
/*  64 */           BlockResearch block = (BlockResearch)state.func_177230_c();
/*  65 */           BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/*  66 */           if (block.isInputFace(facing.func_176734_d(), otherTile)) {
/*  67 */             this.model.getOutputBottom().field_78806_j = true;
/*  68 */             this.model.getOutputBottom().field_78796_g = (facing.func_176736_b() * 1.5707964F);
/*  69 */             this.model.getOutputBottomSide().field_78806_j = true;
/*  70 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  86 */       facing = EnumFacing.DOWN;
/*  87 */       otherPos = tile.func_174877_v().func_177972_a((EnumFacing)facing);
/*  88 */       state = tile.func_145831_w().func_180495_p(otherPos);
/*  89 */       if ((state.func_177230_c() instanceof BlockResearch)) {
/*  90 */         BlockResearch block = (BlockResearch)state.func_177230_c();
/*  91 */         BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/*  92 */         if (block.isInputFace(((EnumFacing)facing).func_176734_d(), otherTile)) {
/*  93 */           this.model.getOutputBottomBottom().field_78806_j = true;
/*  94 */           this.model.getOutputBottom().field_78806_j = true;
/*     */         } } } else { Object facing;
/*     */       BlockPos otherPos;
/*     */       IBlockState state;
/*  98 */       if (inputFace == EnumFacing.DOWN)
/*     */       {
/* 100 */         this.model.getOutputBottom().field_78806_j = true;
/* 101 */         this.model.getOutputBottomBottom().field_78806_j = true;
/*     */         
/* 103 */         facing = EnumFacing.field_176754_o;IBlockState localIBlockState1 = facing.length; for (IBlockState localIBlockState3 = 0; localIBlockState3 < localIBlockState1; localIBlockState3++) { EnumFacing facing = facing[localIBlockState3];
/* 104 */           BlockPos otherPos = tile.func_174877_v().func_177972_a(facing);
/* 105 */           IBlockState state = tile.func_145831_w().func_180495_p(otherPos);
/* 106 */           if ((state.func_177230_c() instanceof BlockResearch)) {
/* 107 */             BlockResearch block = (BlockResearch)state.func_177230_c();
/* 108 */             BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/* 109 */             if (block.isInputFace(facing.func_176734_d(), otherTile)) {
/* 110 */               this.model.getOutputBottom().field_78806_j = true;
/* 111 */               this.model.getOutputBottom().field_78796_g = (facing.func_176736_b() * 1.5707964F);
/* 112 */               this.model.getOutputBottomSide().field_78806_j = true;
/* 113 */               break;
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 118 */         facing = EnumFacing.UP;
/* 119 */         otherPos = tile.func_174877_v().func_177972_a((EnumFacing)facing);
/* 120 */         state = tile.func_145831_w().func_180495_p(otherPos);
/* 121 */         if ((state.func_177230_c() instanceof BlockResearch)) {
/* 122 */           BlockResearch block = (BlockResearch)state.func_177230_c();
/* 123 */           BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/* 124 */           if (block.isInputFace(((EnumFacing)facing).func_176734_d(), otherTile)) {
/* 125 */             this.model.getOutputTopTop().field_78806_j = true;
/* 126 */             this.model.getOutputTop().field_78806_j = true;
/*     */ 
/*     */ 
/*     */ 
/*     */           }
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */         }
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 141 */       else if (inputFace != null) {
/* 142 */         this.model.getOutputTop().field_78806_j = true;
/* 143 */         this.model.getOutputTopSide().field_78806_j = true;
/* 144 */         this.model.getOutputTop().field_78796_g = (inputFace.func_176736_b() * 1.5707964F);
/*     */         
/* 146 */         facing = EnumFacing.field_176754_o;IBlockState localIBlockState2 = facing.length; for (IBlockState localIBlockState4 = 0; localIBlockState4 < localIBlockState2; localIBlockState4++) { EnumFacing facing = facing[localIBlockState4];
/* 147 */           if (facing != inputFace) {
/* 148 */             BlockPos otherPos = tile.func_174877_v().func_177972_a(facing);
/* 149 */             IBlockState otherState = tile.func_145831_w().func_180495_p(otherPos);
/* 150 */             if ((otherState.func_177230_c() instanceof BlockResearch)) {
/* 151 */               BlockResearch otherBlock = (BlockResearch)otherState.func_177230_c();
/* 152 */               BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/* 153 */               if (otherBlock.isInputFace(facing.func_176734_d(), otherTile)) {
/* 154 */                 this.model.getOutputBottom().field_78806_j = true;
/* 155 */                 this.model.getOutputBottom().field_78796_g = (facing.func_176736_b() * 1.5707964F);
/* 156 */                 this.model.getOutputBottomSide().field_78806_j = true;
/* 157 */                 break;
/*     */               }
/*     */             }
/*     */           }
/*     */         }
/*     */         
/* 163 */         EnumFacing facing = EnumFacing.UP;
/* 164 */         BlockPos otherPos = tile.func_174877_v().func_177972_a(facing);
/* 165 */         IBlockState state = tile.func_145831_w().func_180495_p(otherPos);
/* 166 */         if ((state.func_177230_c() instanceof BlockResearch)) {
/* 167 */           BlockResearch block = (BlockResearch)state.func_177230_c();
/* 168 */           BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/* 169 */           if (block.isInputFace(facing.func_176734_d(), otherTile)) {
/* 170 */             this.model.getOutputTop().field_78806_j = true;
/* 171 */             this.model.getOutputTopTop().field_78806_j = true;
/*     */           }
/*     */         }
/*     */         
/* 175 */         facing = EnumFacing.DOWN;
/* 176 */         otherPos = tile.func_174877_v().func_177972_a(facing);
/* 177 */         state = tile.func_145831_w().func_180495_p(otherPos);
/* 178 */         if ((state.func_177230_c() instanceof BlockResearch)) {
/* 179 */           BlockResearch block = (BlockResearch)state.func_177230_c();
/* 180 */           BlockResearch.TileEntityResearchBlock otherTile = (BlockResearch.TileEntityResearchBlock)BlockUtil.getTileEntity(tile.func_145831_w(), otherPos, BlockResearch.TileEntityResearchBlock.class);
/* 181 */           if (block.isInputFace(facing.func_176734_d(), otherTile)) {
/* 182 */             this.model.getOutputBottom().field_78806_j = true;
/* 183 */             this.model.getOutputBottomBottom().field_78806_j = true;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 189 */     if (research.getSoulType() != null) {
/* 190 */       if (research.isValid()) {
/* 191 */         this.model.setColorAugment(6815743);
/*     */       } else {
/* 193 */         this.model.setColorAugment(16762623);
/*     */       }
/*     */     } else {
/* 196 */       this.model.setColorAugment(6801151);
/*     */     }
/*     */     
/* 199 */     this.model.func_78088_a(null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
/*     */     
/*     */ 
/* 202 */     GlStateManager.func_179147_l();
/* 203 */     GlStateManager.func_179121_F();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/client/renderer/RenderResearchBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */