/*    */ package emoniph.intangible.entity;
/*    */ 
/*    */ import emoniph.intangible.util.ByteBufUtil;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.util.UUID;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;
/*    */ 
/*    */ public class EntitySeat extends Entity implements IEntityAdditionalSpawnData
/*    */ {
/*    */   private UUID ownerId;
/*    */   
/*    */   public EntitySeat(World worldIn)
/*    */   {
/* 18 */     this(worldIn, null);
/*    */   }
/*    */   
/*    */   public EntitySeat(World worldIn, EntityLiving owner) {
/* 22 */     super(worldIn);
/* 23 */     func_70105_a(0.25F, 0.25F);
/* 24 */     this.field_70145_X = true;
/* 25 */     this.ownerId = func_110124_au();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void func_70108_f(Entity entityIn) {}
/*    */   
/*    */ 
/*    */ 
/*    */   protected void func_70088_a() {}
/*    */   
/*    */ 
/*    */   public void func_70071_h_()
/*    */   {
/* 39 */     super.func_70071_h_();
/*    */   }
/*    */   
/*    */   public boolean func_70039_c(NBTTagCompound compound)
/*    */   {
/* 44 */     String s = func_70022_Q();
/*    */     
/* 46 */     if ((!this.field_70128_L) && (s != null)) {
/* 47 */       compound.func_74778_a("id", s);
/* 48 */       func_70109_d(compound);
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void func_70037_a(NBTTagCompound compound)
/*    */   {
/* 57 */     if ((compound.func_74764_b("ownerMsb")) && (compound.func_74764_b("ownerLsb"))) {
/* 58 */       this.ownerId = new UUID(compound.func_74763_f("ownerMsb"), compound.func_74763_f("ownerLsb"));
/*    */     }
/*    */   }
/*    */   
/*    */   protected void func_70014_b(NBTTagCompound compound)
/*    */   {
/* 64 */     if (this.ownerId != null) {
/* 65 */       compound.func_74772_a("ownerMsb", this.ownerId.getMostSignificantBits());
/* 66 */       compound.func_74772_a("ownerLsb", this.ownerId.getLeastSignificantBits());
/*    */     }
/*    */   }
/*    */   
/*    */   public double func_70042_X()
/*    */   {
/* 72 */     return 1.85D;
/*    */   }
/*    */   
/*    */   public boolean shouldDismountInWater(Entity rider)
/*    */   {
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isOwnedBy(EntityWreckingGolem other) {
/* 81 */     return (this.ownerId != null) && (this.ownerId.equals(other.getSeatId()));
/*    */   }
/*    */   
/*    */   public void writeSpawnData(ByteBuf buf)
/*    */   {
/* 86 */     ByteBufUtil.writeUuid(buf, this.ownerId);
/*    */   }
/*    */   
/*    */   public void readSpawnData(ByteBuf buf)
/*    */   {
/* 91 */     this.ownerId = ByteBufUtil.readUuid(buf);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySeat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */