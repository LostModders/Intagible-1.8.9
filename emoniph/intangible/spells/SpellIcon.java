/*    */ package emoniph.intangible.spells;
/*    */ 
/*    */ import emoniph.intangible.api.ISpell;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.relauncher.SideOnly;
/*    */ 
/*    */ public class SpellIcon
/*    */ {
/*    */   public static final float WIDTH = 16.0F;
/*    */   public static final float HEIGHT = 16.0F;
/*    */   private float x;
/*    */   private float y;
/*    */   private final ISpell spell;
/*    */   private final String displayName;
/*    */   private final String displayText;
/*    */   private final ResourceLocation texture;
/*    */   
/*    */   public SpellIcon(ISpell spell, String serialized, String localizedName, String localizedText, ResourceLocation iconTexture)
/*    */   {
/* 21 */     this.spell = spell;
/* 22 */     this.displayName = localizedName;
/* 23 */     this.displayText = localizedText;
/* 24 */     this.texture = iconTexture;
/* 25 */     String[] parts = serialized.split(":");
/* 26 */     if (parts.length == 2) {
/* 27 */       this.x = Float.parseFloat(parts[0]);
/* 28 */       this.y = Float.parseFloat(parts[1]);
/*    */     }
/*    */   }
/*    */   
/*    */   public ISpell getSpell() {
/* 33 */     return this.spell;
/*    */   }
/*    */   
/*    */   public float getX() {
/* 37 */     return this.x;
/*    */   }
/*    */   
/*    */   public void setX(float x) {
/* 41 */     this.x = x;
/*    */   }
/*    */   
/*    */   public float getY() {
/* 45 */     return this.y;
/*    */   }
/*    */   
/*    */   public void setY(float y) {
/* 49 */     this.y = y;
/*    */   }
/*    */   
/*    */   public boolean contains(float mx, float my) {
/* 53 */     return (mx >= this.x) && (mx <= this.x + 16.0F) && (my >= this.y) && (my <= this.y + 16.0F);
/*    */   }
/*    */   
/*    */   public String getDisplayName() {
/* 57 */     return this.displayName;
/*    */   }
/*    */   
/* 60 */   public String getDisplayText() { return this.displayText; }
/*    */   
/*    */   @SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*    */   public void bindTexture()
/*    */   {
/* 65 */     Minecraft.func_71410_x().func_110434_K().func_110577_a(this.texture);
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 70 */     return String.format("%s:%s", new Object[] { Double.toString(Math.round(this.x * 10.0F) / 10), Double.toString(Math.round(this.y * 10.0F) / 10) });
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/SpellIcon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */