/*     */ package emoniph.intangible.souls;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.config.Log;
/*     */ import emoniph.intangible.util.WorldPos;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class ShellRegistry implements Iterable<WorldPos>
/*     */ {
/*  17 */   private final List<WorldPos> shells = new java.util.ArrayList();
/*  18 */   private int selectedShell = -1;
/*     */   
/*     */   public void add(World world, BlockPos pos) {
/*  21 */     WorldPos worldPos = new WorldPos(world, pos);
/*  22 */     if (!this.shells.contains(worldPos)) {
/*  23 */       this.shells.add(worldPos);
/*     */     } else {
/*  25 */       Get.log().debug(String.format("World pos [%s] already present in shells for player", new Object[] { worldPos }));
/*     */     }
/*     */   }
/*     */   
/*     */   public void remove(World world, BlockPos pos) {
/*  30 */     WorldPos worldPos = new WorldPos(world, pos);
/*  31 */     if (!this.shells.remove(worldPos)) {
/*  32 */       Get.log().debug(String.format("World pos [%s] not present in shells for player", new Object[] { worldPos }));
/*     */     }
/*     */   }
/*     */   
/*     */   public WorldPos getSelectedShell() {
/*  37 */     if ((this.selectedShell >= 0) && (this.selectedShell < this.shells.size())) {
/*  38 */       return (WorldPos)this.shells.get(this.selectedShell);
/*     */     }
/*  40 */     this.selectedShell = -1;
/*  41 */     return null;
/*     */   }
/*     */   
/*     */   public int getSelectedShellIndex()
/*     */   {
/*  46 */     return this.selectedShell;
/*     */   }
/*     */   
/*     */   public void setSelectedShell(int index) {
/*  50 */     if ((index >= 0) && (index < this.shells.size())) {
/*  51 */       this.selectedShell = index;
/*     */     } else {
/*  53 */       this.selectedShell = -1;
/*     */     }
/*     */   }
/*     */   
/*     */   public NBTTagCompound toTagCompound() {
/*  58 */     NBTTagCompound compound = new NBTTagCompound();
/*     */     
/*  60 */     NBTTagList list = new NBTTagList();
/*  61 */     for (WorldPos pos : this.shells) {
/*  62 */       list.func_74742_a(pos.toTagCompound());
/*     */     }
/*  64 */     compound.func_74782_a("list", list);
/*  65 */     if ((this.selectedShell >= 0) && (this.selectedShell < this.shells.size())) {
/*  66 */       compound.func_74768_a("sel", this.selectedShell);
/*     */     }
/*     */     
/*  69 */     return compound;
/*     */   }
/*     */   
/*     */   public static ShellRegistry fromTagCompound(NBTTagCompound compound) {
/*  73 */     if (compound.func_150297_b("list", 9)) {
/*  74 */       ShellRegistry registry = new ShellRegistry();
/*  75 */       NBTTagList list = compound.func_150295_c("list", 10);
/*  76 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/*  77 */         WorldPos pos = WorldPos.fromTagCompound(list.func_150305_b(i));
/*  78 */         if (pos != null) {
/*  79 */           registry.shells.add(pos);
/*     */         }
/*     */       }
/*  82 */       if (compound.func_150297_b("sel", 3)) {
/*  83 */         registry.selectedShell = compound.func_74762_e("sel");
/*     */       } else {
/*  85 */         registry.selectedShell = -1;
/*     */       }
/*     */       
/*  88 */       return registry;
/*     */     }
/*  90 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */   public void writeTo(ByteBuf buf)
/*     */   {
/*  96 */     buf.writeInt(this.shells.size());
/*  97 */     buf.writeInt(this.selectedShell);
/*  98 */     for (WorldPos pos : this.shells) {
/*  99 */       pos.writeTo(buf);
/*     */     }
/*     */   }
/*     */   
/*     */   public static ShellRegistry readFrom(ByteBuf buf) {
/* 104 */     ShellRegistry registry = new ShellRegistry();
/*     */     
/* 106 */     int count = buf.readInt();
/* 107 */     registry.selectedShell = buf.readInt();
/* 108 */     for (int i = 0; i < count; i++) {
/* 109 */       WorldPos pos = WorldPos.readFrom(buf);
/* 110 */       registry.shells.add(pos);
/*     */     }
/*     */     
/* 113 */     return registry;
/*     */   }
/*     */   
/*     */   public Iterator<WorldPos> iterator()
/*     */   {
/* 118 */     return this.shells.iterator();
/*     */   }
/*     */   
/*     */   public void clearSelectedShell(World worldObj) {
/* 122 */     if (this.selectedShell != -1) {
/* 123 */       WorldPos pos = getSelectedShell();
/* 124 */       if ((pos != null) && (pos.isForWorld(worldObj)) && (worldObj.func_180495_p(pos.asBlockPos()).func_177230_c() != Get.blocks().PLAYER_SHELL)) {
/* 125 */         this.shells.remove(this.selectedShell);
/*     */       }
/* 127 */       this.selectedShell = -1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/ShellRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */