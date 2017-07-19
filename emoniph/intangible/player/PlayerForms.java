/*    */ package emoniph.intangible.player;
/*    */ 
/*    */ import emoniph.intangible.init.IModService;
/*    */ import emoniph.intangible.player.forms.PlayerFormDefault;
/*    */ import emoniph.intangible.player.forms.PlayerFormIncorporeal;
/*    */ import emoniph.intangible.util.ModUtil;
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class PlayerForms implements IModService
/*    */ {
/* 14 */   private final Map<String, Entry> entryById = new HashMap();
/* 15 */   private final List<PlayerForm> forms = new ArrayList();
/* 16 */   private final Map<PlayerForm, Entry> entryByForm = new HashMap();
/*    */   
/* 18 */   public final PlayerForm DEFAULT = register("default", new PlayerFormDefault());
/* 19 */   public final PlayerForm INCORPOREAL = register("incorporeal", new PlayerFormIncorporeal());
/*    */   
/*    */   private <T extends PlayerForm> T register(String id, T playerForm) {
/* 22 */     id = ModUtil.withPrefix(id);
/*    */     
/* 24 */     if (!this.entryById.containsKey(id)) {
/* 25 */       int index = this.forms.size();
/* 26 */       this.forms.add(playerForm);
/* 27 */       Entry entry = new Entry(id, index, playerForm);
/* 28 */       this.entryById.put(id, entry);
/* 29 */       this.entryByForm.put(playerForm, entry);
/*    */     }
/* 31 */     return playerForm;
/*    */   }
/*    */   
/*    */   public int getIndexForForm(PlayerForm form) {
/* 35 */     Entry entry = (Entry)this.entryByForm.get(form);
/* 36 */     return entry != null ? entry.index : -1;
/*    */   }
/*    */   
/*    */   public PlayerForm getFormForIndex(int index) {
/* 40 */     return (index >= 0) && (index < this.forms.size()) ? (PlayerForm)this.forms.get(index) : null;
/*    */   }
/*    */   
/*    */   public String getIdForForm(PlayerForm form) {
/* 44 */     Entry entry = (Entry)this.entryByForm.get(form);
/* 45 */     return entry != null ? entry.id : null;
/*    */   }
/*    */   
/*    */   public PlayerForm getFormForId(String id) {
/* 49 */     Entry entry = (Entry)this.entryById.get(id);
/* 50 */     return entry != null ? entry.form : null;
/*    */   }
/*    */   
/*    */   private static class Entry {
/*    */     String id;
/*    */     int index;
/*    */     PlayerForm form;
/*    */     
/* 58 */     Entry(String id, int index, PlayerForm form) { this.id = id;
/* 59 */       this.index = index;
/* 60 */       this.form = form;
/*    */     }
/*    */   }
/*    */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/player/PlayerForms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */