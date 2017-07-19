/*    */ package emoniph.intangible.fluids;
/*    */ 
/*    */ import emoniph.intangible.init.IModPreInitClient;
/*    */ import emoniph.intangible.init.IModService;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.block.statemap.StateMapperBase;
/*    */ import net.minecraft.client.resources.model.ModelResourceLocation;
/*    */ import net.minecraftforge.client.model.ModelLoader;
/*    */ import net.minecraftforge.fluids.Fluid;
/*    */ import net.minecraftforge.fluids.FluidRegistry;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class ModFluids implements IModService, IModPreInitClient
/*    */ {
/* 20 */   private final List<Fluid> registry = new ArrayList();
/*    */   
/* 22 */   public final Fluid MOLTEN_CRYSTAL_BLUE = register(new FluidMoltenCrystal("intangible:moltencrystalblue", -301960193));
/*    */   
/* 24 */   public final Fluid MOLTEN_CRYSTAL_YELLOW = register(new FluidMoltenCrystal("intangible:moltencrystalyellow", -285212928));
/*    */   
/* 26 */   public final Fluid MOLTEN_GLASS = register(new FluidMoltenCrystal("intangible:moltenglass", -285229056));
/*    */   
/*    */   private <T extends Fluid> T register(T fluid) {
/* 29 */     FluidRegistry.registerFluid(fluid);
/* 30 */     this.registry.add(fluid);
/* 31 */     return fluid;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void preInit(Minecraft mc)
/*    */   {
/* 37 */     for (Fluid fluid : this.registry) {
/* 38 */       Block block = fluid.getBlock();
/*    */       
/* 40 */       final ModelResourceLocation fluidLocation = new ModelResourceLocation(block.func_149739_a().substring(5), "fluid");
/* 41 */       ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
/*    */         protected ModelResourceLocation func_178132_a(IBlockState state) {
/* 43 */           return fluidLocation;
/*    */         }
/*    */       });
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/fluids/ModFluids.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */