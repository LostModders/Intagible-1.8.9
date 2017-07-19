/*     */ package emoniph.intangible.util;
/*     */ 
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldProvider;
/*     */ 
/*     */ public class WorldPos
/*     */ {
/*     */   private final int dimensionId;
/*     */   private final BlockPos pos;
/*     */   
/*     */   public WorldPos(World world, BlockPos pos)
/*     */   {
/*  19 */     this.dimensionId = world.field_73011_w.func_177502_q();
/*  20 */     this.pos = pos;
/*     */   }
/*     */   
/*     */   public WorldPos(int dimensionId, BlockPos pos) {
/*  24 */     this.dimensionId = dimensionId;
/*  25 */     this.pos = pos;
/*     */   }
/*     */   
/*     */   public BlockPos asBlockPos() {
/*  29 */     return this.pos;
/*     */   }
/*     */   
/*     */   public WorldPos add(double x, double y, double z) {
/*  33 */     return new WorldPos(this.dimensionId, this.pos.func_177963_a(x, y, z));
/*     */   }
/*     */   
/*     */   public WorldPos add(int x, int y, int z) {
/*  37 */     return new WorldPos(this.dimensionId, this.pos.func_177982_a(x, y, z));
/*     */   }
/*     */   
/*     */   public WorldPos add(net.minecraft.util.Vec3i vec) {
/*  41 */     return new WorldPos(this.dimensionId, this.pos.func_177971_a(vec));
/*     */   }
/*     */   
/*     */   public WorldPos up() {
/*  45 */     return up(1);
/*     */   }
/*     */   
/*     */   public WorldPos up(int n) {
/*  49 */     return offset(EnumFacing.UP, n);
/*     */   }
/*     */   
/*     */   public WorldPos down() {
/*  53 */     return down(1);
/*     */   }
/*     */   
/*     */   public WorldPos down(int n) {
/*  57 */     return offset(EnumFacing.DOWN, n);
/*     */   }
/*     */   
/*     */   public WorldPos north() {
/*  61 */     return north(1);
/*     */   }
/*     */   
/*     */   public WorldPos north(int n) {
/*  65 */     return offset(EnumFacing.NORTH, n);
/*     */   }
/*     */   
/*     */   public WorldPos south() {
/*  69 */     return south(1);
/*     */   }
/*     */   
/*     */   public WorldPos south(int n) {
/*  73 */     return offset(EnumFacing.SOUTH, n);
/*     */   }
/*     */   
/*     */   public WorldPos west() {
/*  77 */     return west(1);
/*     */   }
/*     */   
/*     */   public WorldPos west(int n) {
/*  81 */     return offset(EnumFacing.WEST, n);
/*     */   }
/*     */   
/*     */   public WorldPos east() {
/*  85 */     return east(1);
/*     */   }
/*     */   
/*     */   public WorldPos east(int n) {
/*  89 */     return offset(EnumFacing.EAST, n);
/*     */   }
/*     */   
/*     */   public WorldPos offset(EnumFacing facing) {
/*  93 */     return offset(facing, 1);
/*     */   }
/*     */   
/*     */   public WorldPos offset(EnumFacing facing, int n) {
/*  97 */     return new WorldPos(this.dimensionId, this.pos.func_177967_a(facing, n));
/*     */   }
/*     */   
/*     */   public NBTTagCompound toTagCompound() {
/* 101 */     NBTTagCompound compound = new NBTTagCompound();
/* 102 */     compound.func_74768_a("dim", this.dimensionId);
/* 103 */     compound.func_74772_a("pos", this.pos.func_177986_g());
/* 104 */     return compound;
/*     */   }
/*     */   
/*     */   public static WorldPos fromTagCompound(NBTTagCompound compound) {
/* 108 */     if ((compound.func_150297_b("dim", 3)) && (compound.func_150297_b("pos", 4))) {
/* 109 */       return new WorldPos(compound.func_74762_e("dim"), BlockPos.func_177969_a(compound.func_74763_f("pos")));
/*     */     }
/* 111 */     return null;
/*     */   }
/*     */   
/*     */   public void writeTo(ByteBuf buf)
/*     */   {
/* 116 */     buf.writeInt(this.dimensionId);
/* 117 */     buf.writeLong(this.pos.func_177986_g());
/*     */   }
/*     */   
/*     */   public static WorldPos readFrom(ByteBuf buf) {
/* 121 */     int dim = buf.readInt();
/* 122 */     long pos = buf.readLong();
/* 123 */     return new WorldPos(dim, BlockPos.func_177969_a(pos));
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj)
/*     */   {
/* 128 */     if ((obj == null) || (obj.getClass() != getClass()))
/* 129 */       return false;
/* 130 */     if (obj == this) {
/* 131 */       return true;
/*     */     }
/*     */     
/* 134 */     WorldPos other = (WorldPos)obj;
/* 135 */     return (this.dimensionId == other.dimensionId) && (this.pos.equals(other.pos));
/*     */   }
/*     */   
/*     */   public int hashCode()
/*     */   {
/* 140 */     int result = 17;
/* 141 */     result = 37 * result + this.dimensionId;
/* 142 */     result = 37 * result + this.pos.hashCode();
/* 143 */     return result;
/*     */   }
/*     */   
/*     */   public String toString()
/*     */   {
/* 148 */     return "Dim:" + this.dimensionId + " Pos:" + this.pos.toString();
/*     */   }
/*     */   
/*     */   public Vec3 getVectorFrom(Entity entity) {
/* 152 */     double dx = this.pos.func_177958_n() + 0.5D - entity.field_70165_t;
/* 153 */     double dy = this.pos.func_177956_o() + 0.5D - (entity.field_70163_u + entity.func_70047_e());
/* 154 */     double dz = this.pos.func_177952_p() + 0.5D - entity.field_70161_v;
/* 155 */     return new Vec3(dx, dy, dz);
/*     */   }
/*     */   
/*     */   public double distanceSqTo(Entity entity) {
/* 159 */     return entity.field_70170_p.field_73011_w.func_177502_q() == this.dimensionId ? entity.func_174818_b(this.pos) : Double.MAX_VALUE;
/*     */   }
/*     */   
/*     */   public double getZ() {
/* 163 */     return this.pos.func_177952_p();
/*     */   }
/*     */   
/*     */   public double getY() {
/* 167 */     return this.pos.func_177956_o();
/*     */   }
/*     */   
/*     */   public double getX() {
/* 171 */     return this.pos.func_177958_n();
/*     */   }
/*     */   
/*     */   public World getWorldServer() {
/* 175 */     return net.minecraft.server.MinecraftServer.func_71276_C().func_71218_a(this.dimensionId);
/*     */   }
/*     */   
/*     */   public boolean isForWorld(World world) {
/* 179 */     return this.dimensionId == world.field_73011_w.func_177502_q();
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/util/WorldPos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */