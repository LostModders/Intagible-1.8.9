/*     */ package emoniph.intangible.deity;
/*     */ 
/*     */ import emoniph.intangible.client.models.ModelDeityHead;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFire;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.fml.common.network.ByteBufUtils;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class HeadSpec
/*     */ {
/*     */   private String serialized;
/*     */   private int color;
/*     */   private ItemStack itemA;
/*     */   private ItemStack itemB;
/*     */   private ItemStack itemC;
/*     */   private String name;
/*     */   @SideOnly(Side.CLIENT)
/*     */   ModelDeityHead model;
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ModelDeityHead createModel()
/*     */   {
/*  36 */     if (this.model == null) {
/*  37 */       String[] blockSpecs = this.serialized.split(";");
/*     */       
/*  39 */       this.model = new ModelDeityHead();
/*     */       
/*  41 */       int WIDTH = 7;
/*  42 */       int count = 0;
/*  43 */       for (int x = 0; x < 7; x++) {
/*  44 */         for (int z = 0; z < 7; z++) {
/*  45 */           for (int y = 0; y < 7; y++) {
/*  46 */             if (count < blockSpecs.length) {
/*  47 */               String[] parts = blockSpecs[count].split(",");
/*     */               
/*  49 */               int meta = 0;
/*  50 */               if (parts.length > 1) {
/*  51 */                 meta = Integer.parseInt(parts[1]);
/*     */               }
/*     */               
/*  54 */               if (parts[0].length() > 0) {
/*  55 */                 Block block = Block.func_149684_b("minecraft:" + parts[0]);
/*  56 */                 this.model.addBlock(block, meta, x, y, z);
/*     */               }
/*     */             }
/*  59 */             count++;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*  65 */     return this.model;
/*     */   }
/*     */   
/*     */   public NBTTagCompound toTagCompound() {
/*  69 */     NBTTagCompound compound = new NBTTagCompound();
/*  70 */     compound.func_74778_a("schematic", this.serialized);
/*  71 */     compound.func_74768_a("color", this.color);
/*  72 */     return compound;
/*     */   }
/*     */   
/*     */   public static HeadSpec fromTagCompound(NBTTagCompound compound) {
/*  76 */     HeadSpec headSpec = new HeadSpec();
/*  77 */     if (compound.func_150297_b("schematic", 8)) {
/*  78 */       headSpec.serialized = compound.func_74779_i("schematic");
/*     */     }
/*  80 */     if (compound.func_150297_b("color", 3)) {
/*  81 */       headSpec.color = compound.func_74762_e("color");
/*     */     } else {
/*  83 */       headSpec.color = 6710886;
/*     */     }
/*     */     
/*  86 */     return headSpec;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf) {
/*  90 */     buf.writeInt(this.color);
/*  91 */     StringCompressor.writeCompressedString(buf, this.serialized);
/*     */   }
/*     */   
/*     */   public static HeadSpec readFrom(ByteBuf buf) {
/*  95 */     HeadSpec headSpec = new HeadSpec();
/*     */     
/*  97 */     headSpec.color = buf.readInt();
/*  98 */     headSpec.serialized = StringCompressor.readCompressedString(buf);
/*  99 */     return headSpec;
/*     */   }
/*     */   
/*     */   public static boolean isHeadValid(World worldIn, BlockPos posIn) {
/* 103 */     int WIDTH = 7;
/* 104 */     BlockPos start = posIn.func_177982_a(-3, -8, -3);
/* 105 */     int blocks = 0;
/* 106 */     for (int x = 0; x < 7; x++) {
/* 107 */       for (int z = 0; z < 7; z++) {
/* 108 */         for (int y = 0; y < 7; y++) {
/* 109 */           BlockPos location = start.func_177982_a(x, y, z);
/* 110 */           IBlockState state = worldIn.func_180495_p(location);
/* 111 */           if ((!state.func_177230_c().isAir(worldIn, location)) && (!state.func_177230_c().func_149688_o().func_76224_d())) {
/* 112 */             blocks++;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 117 */     return blocks > 6;
/*     */   }
/*     */   
/*     */   public static HeadSpec digitizeHead(World worldIn, BlockPos posIn, int color, boolean removeBlock)
/*     */   {
/* 122 */     int WIDTH = 7;
/* 123 */     BlockPos start = posIn.func_177982_a(-3, -8, -3);
/* 124 */     StringBuilder s = new StringBuilder();
/* 125 */     for (int x = 0; x < 7; x++) {
/* 126 */       for (int z = 0; z < 7; z++) {
/* 127 */         for (int y = 0; y < 7; y++) {
/* 128 */           BlockPos location = start.func_177982_a(x, y, z);
/* 129 */           IBlockState state = worldIn.func_180495_p(location);
/* 130 */           if ((!state.func_177230_c().isAir(worldIn, location)) && (!state.func_177230_c().func_149688_o().func_76224_d())) {
/* 131 */             ResourceLocation blockName = (ResourceLocation)Block.field_149771_c.func_177774_c(state.func_177230_c());
/* 132 */             s.append(blockName.func_110624_b().equals("minecraft") ? blockName.func_110623_a() : blockName.toString());
/* 133 */             int meta = state.func_177230_c().func_176201_c(state);
/* 134 */             if (meta != 0) {
/* 135 */               s.append(",");
/* 136 */               s.append(meta);
/*     */             }
/*     */             
/* 139 */             if (removeBlock) {
/* 140 */               if (y == 0) {
/* 141 */                 worldIn.func_180501_a(location, net.minecraft.init.Blocks.field_150480_ab.func_176223_P(), 3);
/*     */               } else {
/* 143 */                 worldIn.func_175698_g(location);
/*     */               }
/*     */             }
/*     */           }
/* 147 */           s.append(";");
/*     */         }
/*     */       }
/*     */     }
/* 151 */     HeadSpec headSpec = new HeadSpec();
/* 152 */     headSpec.serialized = s.toString();
/* 153 */     headSpec.color = color;
/* 154 */     return headSpec;
/*     */   }
/*     */   
/*     */   public int getColor() {
/* 158 */     return this.color;
/*     */   }
/*     */   
/*     */   public ItemStack getItemA() {
/* 162 */     return this.itemA;
/*     */   }
/*     */   
/*     */   public ItemStack getItemB() {
/* 166 */     return this.itemB;
/*     */   }
/*     */   
/*     */   public ItemStack getItemC() {
/* 170 */     return this.itemC;
/*     */   }
/*     */   
/*     */   public String getName() {
/* 174 */     return this.name;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void setClientInfo(ItemStack itemA, ItemStack itemB, ItemStack itemC, String name) {
/* 179 */     this.itemA = itemA;
/* 180 */     this.itemB = itemB;
/* 181 */     this.itemC = itemC;
/* 182 */     this.name = name;
/*     */   }
/*     */   
/*     */   static enum StringCompressor
/*     */   {
/*     */     private StringCompressor() {}
/*     */     
/*     */     public static void writeCompressedString(ByteBuf to, String text) {
/* 190 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */       try {
/* 192 */         OutputStream out = new java.util.zip.DeflaterOutputStream(baos);
/* 193 */         out.write(text.getBytes("UTF-8"));
/* 194 */         out.close();
/*     */       } catch (IOException e) {
/* 196 */         throw new AssertionError(e);
/*     */       }
/*     */       
/* 199 */       byte[] bytes = baos.toByteArray();
/* 200 */       org.apache.commons.lang3.Validate.isTrue(ByteBufUtils.varIntByteCount(bytes.length) < 3, "The string is too long for this encoding.", new Object[0]);
/* 201 */       ByteBufUtils.writeVarInt(to, bytes.length, 2);
/* 202 */       to.writeBytes(bytes);
/*     */     }
/*     */     
/*     */     public static String readCompressedString(ByteBuf from) {
/* 206 */       int bytesToRead = ByteBufUtils.readVarInt(from, 2);
/* 207 */       byte[] bytes = new byte[bytesToRead];
/* 208 */       from.readBytes(bytes, 0, bytesToRead);
/*     */       
/* 210 */       InputStream in = new java.util.zip.InflaterInputStream(new java.io.ByteArrayInputStream(bytes));
/* 211 */       ByteArrayOutputStream baos = new ByteArrayOutputStream();
/*     */       try {
/* 213 */         byte[] buffer = new byte[' '];
/*     */         int len;
/* 215 */         while ((len = in.read(buffer)) > 0)
/* 216 */           baos.write(buffer, 0, len);
/* 217 */         return new String(baos.toByteArray(), "UTF-8");
/*     */       } catch (IOException e) {
/* 219 */         throw new AssertionError(e);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/deity/HeadSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */