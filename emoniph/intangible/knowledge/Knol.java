/*    */ package emoniph.intangible.knowledge;
/*    */ 
/*    */ import emoniph.intangible.util.ModUtil;
/*    */ 
/*    */ public class Knol implements emoniph.intangible.api.IKnol
/*    */ {
/*    */   final String id;
/*    */   
/*    */   public Knol(String id)
/*    */   {
/* 11 */     id = ModUtil.withPrefix(id);
/* 12 */     this.id = id;
/*    */   }
/*    */   
/*    */   public String getId() {
/* 16 */     return this.id;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 21 */     return this.id.hashCode();
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 26 */     if ((obj == null) || (obj.getClass() != getClass()))
/* 27 */       return false;
/* 28 */     if (obj == this) {
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     Knol other = (Knol)obj;
/*    */     
/* 34 */     return this.id.equals(other.id);
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/knowledge/Knol.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */