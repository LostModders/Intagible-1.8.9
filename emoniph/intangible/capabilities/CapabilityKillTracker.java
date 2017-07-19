/*    */ package emoniph.intangible.capabilities;
/*    */ 
/*    */ import java.util.concurrent.Callable;
/*    */ import net.minecraft.nbt.NBTBase;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraftforge.common.capabilities.Capability;
/*    */ import net.minecraftforge.common.capabilities.CapabilityInject;
/*    */ import net.minecraftforge.common.capabilities.CapabilityManager;
/*    */ 
/*    */ public class CapabilityKillTracker
/*    */ {
/*    */   @CapabilityInject(IKillTracker.class)
/* 14 */   public static Capability<IKillTracker> KILL_TRACKER_CAPABILITY = null;
/*    */   
/*    */   public static void register() {
/* 17 */     CapabilityManager.INSTANCE.register(IKillTracker.class, new net.minecraftforge.common.capabilities.Capability.IStorage()
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 34 */       new Callable
/*    */       {
/*    */         public NBTBase writeNBT(Capability<IKillTracker> capability, IKillTracker instance, EnumFacing side) {
/* 20 */           NBTTagCompound compound = new NBTTagCompound();
/*    */           
/* 22 */           compound.func_74772_a("lastKillTime", instance.getLastKillServerTime());
/*    */           
/* 24 */           return compound;
/*    */         }
/*    */         
/*    */         public void readNBT(Capability<IKillTracker> capability, IKillTracker instance, EnumFacing side, NBTBase base)
/*    */         {
/* 29 */           if (!(instance instanceof IKillTrackerSetter)) {
/* 30 */             throw new RuntimeException("IKillTracker instance does not implement IKillTracker");
/*    */           }
/* 32 */           IKillTrackerSetter setter = (IKillTrackerSetter)instance;
/* 33 */           NBTTagCompound compound = (NBTTagCompound)base;
/* 34 */           setter.setLastKillServerTime(compound.func_74763_f("lastKillTime")); } }, new Callable()
/*    */       {
/*    */         public EntityKillTracker call()
/*    */           throws Exception
/*    */         {
/* 39 */           return new EntityKillTracker();
/*    */         }
/*    */       });
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/capabilities/CapabilityKillTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */