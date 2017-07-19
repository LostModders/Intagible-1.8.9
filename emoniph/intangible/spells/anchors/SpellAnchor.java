/*    */ package emoniph.intangible.spells.anchors;
/*    */ 
/*    */ import emoniph.intangible.Sound;
/*    */ import emoniph.intangible.api.CastingStyle;
/*    */ import emoniph.intangible.entity.EntitySpellAnchor;
/*    */ import emoniph.intangible.spells.Spell;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public abstract class SpellAnchor extends Spell
/*    */ {
/*    */   protected int colorInner;
/*    */   protected int colorOuter;
/*    */   
/*    */   public SpellAnchor(int colorInner, int colorOuter)
/*    */   {
/* 22 */     super(CastingStyle.PREPARED);
/* 23 */     this.colorInner = colorInner;
/* 24 */     this.colorOuter = colorOuter;
/*    */   }
/*    */   
/*    */   public abstract boolean update(EntitySpellAnchor paramEntitySpellAnchor, List<EntityLivingBase> paramList);
/*    */   
/*    */   public int getTicksInAir(EntitySpellAnchor anchor) {
/* 30 */     return 200;
/*    */   }
/*    */   
/*    */   public int getTicksInGround(EntitySpellAnchor anchor) {
/* 34 */     return 600;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean drawConnectingLine(EntitySpellAnchor anchor) {
/* 39 */     return false;
/*    */   }
/*    */   
/*    */   public void invoke(EntityPlayer player)
/*    */   {
/* 44 */     List<EntityLivingBase> targets = new ArrayList();
/*    */     
/* 46 */     throwAnchor(player, this.colorInner, this.colorOuter, targets);
/* 47 */     Sound.MOD_RANDOM_SPELL2.playToAllNear(player, 0.5F);
/*    */   }
/*    */   
/*    */   public void throwAnchor(EntityLivingBase source, int colorInner, int colorOuter, List<EntityLivingBase> targets) {
/* 51 */     World world = source.func_130014_f_();
/* 52 */     EntitySpellAnchor entity = new EntitySpellAnchor(world, source, this, 0.2D, targets);
/* 53 */     entity.setColor(colorInner, colorOuter, 1.0F);
/* 54 */     world.func_72838_d(entity);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/anchors/SpellAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */