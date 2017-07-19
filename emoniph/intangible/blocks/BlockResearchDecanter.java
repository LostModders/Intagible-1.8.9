/*    */ package emoniph.intangible.blocks;
/*    */ 
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockResearchDecanter extends BlockResearch
/*    */ {
/*    */   BlockResearchDecanter()
/*    */   {
/*  9 */     super(net.minecraft.block.material.Material.field_151592_s, 3);
/* 10 */     func_149711_c(0.5F);
/*    */   }
/*    */   
/*    */   public net.minecraft.tileentity.TileEntity func_149915_a(World world, int meta)
/*    */   {
/* 15 */     return new TileEntityResearchDecanter();
/*    */   }
/*    */   
/*    */   public static class TileEntityResearchDecanter
/*    */     extends BlockResearch.TileEntityResearchBlock
/*    */   {}
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/blocks/BlockResearchDecanter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */