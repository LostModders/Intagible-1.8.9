/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.block.ITileEntityProvider;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityFallingBlock;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.world.GameRules;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ 
/*     */ public class EntityRaisingBlock extends EntityFallingBlock implements IEntityAdditionalSpawnData
/*     */ {
/*     */   public EntityRaisingBlock(World worldIn)
/*     */   {
/*  26 */     super(worldIn);
/*     */   }
/*     */   
/*     */   public EntityRaisingBlock(World worldIn, double x, double y, double z, IBlockState fallingBlockState) {
/*  30 */     super(worldIn, x, y, z, fallingBlockState);
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/*  35 */     Block block = func_175131_l().func_177230_c();
/*     */     
/*  37 */     if (block.func_149688_o() == net.minecraft.block.material.Material.field_151579_a) {
/*  38 */       func_70106_y();
/*     */     } else {
/*  40 */       this.field_70169_q = this.field_70165_t;
/*  41 */       this.field_70167_r = this.field_70163_u;
/*  42 */       this.field_70166_s = this.field_70161_v;
/*     */       
/*     */ 
/*  45 */       if (this.field_145812_b++ == 0) {
/*  46 */         BlockPos blockpos = new BlockPos(this);
/*     */         
/*  48 */         if (this.field_70170_p.func_180495_p(blockpos).func_177230_c() == block) {
/*  49 */           this.field_70170_p.func_175698_g(blockpos);
/*  50 */         } else if (!this.field_70170_p.field_72995_K) {
/*  51 */           func_70106_y();
/*  52 */           return;
/*     */         }
/*     */       }
/*     */       
/*  56 */       this.field_70181_x += 0.03999999910593033D;
/*  57 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  58 */       this.field_70159_w *= 0.9800000190734863D;
/*  59 */       this.field_70181_x *= 0.9800000190734863D;
/*  60 */       this.field_70179_y *= 0.9800000190734863D;
/*     */       
/*  62 */       if (!this.field_70170_p.field_72995_K) {
/*  63 */         BlockPos blockpos = new BlockPos(this);
/*     */         
/*  65 */         if ((this.field_70122_E) || (!BlockFalling.func_180685_d(this.field_70170_p, blockpos.func_177984_a()))) {
/*  66 */           this.field_70159_w *= 0.699999988079071D;
/*  67 */           this.field_70179_y *= 0.699999988079071D;
/*  68 */           this.field_70181_x *= -0.5D;
/*     */           
/*  70 */           if (this.field_70170_p.func_180495_p(blockpos).func_177230_c() != net.minecraft.init.Blocks.field_180384_M) {
/*  71 */             func_70106_y();
/*     */             
/*  73 */             if ((!this.field_145808_f) && 
/*  74 */               (this.field_70170_p.func_175716_a(block, blockpos, true, EnumFacing.UP, (Entity)null, (ItemStack)null)) && 
/*  75 */               (!BlockFalling.func_180685_d(this.field_70170_p, blockpos.func_177984_a())) && 
/*  76 */               (this.field_70170_p.func_180501_a(blockpos, func_175131_l(), 3))) {
/*  77 */               if ((block instanceof BlockFalling)) {
/*  78 */                 ((BlockFalling)block).func_176502_a_(this.field_70170_p, blockpos);
/*     */               }
/*     */               
/*  81 */               if ((this.field_145810_d != null) && ((block instanceof ITileEntityProvider))) {
/*  82 */                 TileEntity tileentity = this.field_70170_p.func_175625_s(blockpos);
/*     */                 
/*  84 */                 if (tileentity != null) {
/*  85 */                   NBTTagCompound nbttagcompound = new NBTTagCompound();
/*  86 */                   tileentity.func_145841_b(nbttagcompound);
/*  87 */                   Iterator iterator = this.field_145810_d.func_150296_c().iterator();
/*     */                   
/*  89 */                   while (iterator.hasNext()) {
/*  90 */                     String s = (String)iterator.next();
/*  91 */                     NBTBase nbtbase = this.field_145810_d.func_74781_a(s);
/*     */                     
/*  93 */                     if ((!s.equals("x")) && (!s.equals("y")) && (!s.equals("z"))) {
/*  94 */                       nbttagcompound.func_74782_a(s, nbtbase.func_74737_b());
/*     */                     }
/*     */                   }
/*     */                   
/*  98 */                   tileentity.func_145839_a(nbttagcompound);
/*  99 */                   tileentity.func_70296_d();
/*     */                 }
/*     */               }
/* 102 */             } else if ((this.field_145813_c) && (!this.field_145808_f) && (this.field_70170_p.func_82736_K().func_82766_b("doTileDrops"))) {
/* 103 */               func_70099_a(new ItemStack(block, 1, block.func_180651_a(func_175131_l())), 0.0F);
/*     */             }
/*     */           }
/* 106 */         } else if (((this.field_145812_b > 100) && (!this.field_70170_p.field_72995_K) && ((blockpos.func_177956_o() < 1) || (blockpos.func_177956_o() > 256))) || (this.field_145812_b > 600)) {
/* 107 */           if ((this.field_145813_c) && (this.field_70170_p.func_82736_K().func_82766_b("doTileDrops"))) {
/* 108 */             func_70099_a(new ItemStack(block, 1, block.func_180651_a(func_175131_l())), 0.0F);
/*     */           }
/*     */           
/* 111 */           func_70106_y();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf buffer)
/*     */   {
/* 119 */     int stateId = Block.func_176210_f(func_175131_l());
/* 120 */     buffer.writeInt(stateId);
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf additionalData)
/*     */   {
/* 125 */     IBlockState state = Block.func_176220_d(additionalData.readInt() & 0xFFFF);
/* 126 */     this.field_175132_d = state;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntityRaisingBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */