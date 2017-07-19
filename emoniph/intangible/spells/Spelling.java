/*    */ package emoniph.intangible.spells;
/*    */ 
/*    */ import emoniph.intangible.api.ISoulSet;
/*    */ import emoniph.intangible.api.SoulType;
/*    */ import emoniph.intangible.player.PlayerEx;
/*    */ import emoniph.intangible.souls.EnumSoulType;
/*    */ import emoniph.intangible.util.TextUtil;
/*    */ import java.util.List;
/*    */ import net.minecraft.util.StatCollector;
/*    */ 
/*    */ public class Spelling
/*    */ {
/*    */   private final int ticks;
/*    */   private final ISoulSet souls;
/*    */   
/*    */   public Spelling()
/*    */   {
/* 18 */     this(0, new emoniph.intangible.souls.SoulSet());
/*    */   }
/*    */   
/*    */   public Spelling(int ticks, ISoulSet souls) {
/* 22 */     this.ticks = ticks;
/* 23 */     this.souls = souls;
/*    */   }
/*    */   
/*    */   public boolean tryConsumeFrom(PlayerEx playerEx) {
/* 27 */     return playerEx.tryConsumeSouls(this.souls, this.ticks);
/*    */   }
/*    */   
/*    */   public boolean canConsumeFrom(PlayerEx playerEx) {
/* 31 */     return playerEx.canConsumeSouls(this.souls);
/*    */   }
/*    */   
/*    */   public void addLocalizedTextTo(List<String> list) {
/* 35 */     int items = 0;
/* 36 */     String format = StatCollector.func_74838_a("spell.intangible:castingcost.item");
/* 37 */     for (SoulType soulType : SoulType.values()) {
/* 38 */       int quantity = this.souls.quantityOf(soulType);
/* 39 */       if (quantity > 0) {
/* 40 */         items++; if (items == 1) {
/* 41 */           list.add(TextUtil.parse(StatCollector.func_74838_a("spell.intangible:castingcost.title")));
/*    */         }
/* 43 */         String name = EnumSoulType.fromSoulType(soulType).getLocalizedName();
/* 44 */         list.add(TextUtil.parse(String.format(format, new Object[] { Integer.valueOf(quantity), name, Float.valueOf(this.ticks * 0.05F) })));
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public int getTicks() {
/* 50 */     return this.ticks;
/*    */   }
/*    */   
/*    */   public ISoulSet getSouls() {
/* 54 */     return this.souls;
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/spells/Spelling.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */