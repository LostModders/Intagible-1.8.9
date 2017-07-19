/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockResearchSpiral extends BlockResearch
/*    */ {
/*    */   BlockResearchSpiral()
/*    */   {
/* 10 */     super(net.minecraft.block.material.Material.field_151592_s, 1);
/* 11 */     func_149711_c(0.5F);
/*    */   }
/*    */   
/*    */   public TileEntity func_149915_a(World world, int meta)
/*    */   {
/* 16 */     return new TileEntityResearchSpiral();
/*    */   }
/*    */   
/*    */   public static class TileEntityResearchSpiral
/*    */     extends BlockResearch.TileEntityResearchBlock
/*    */   {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockResearchSpiral.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */