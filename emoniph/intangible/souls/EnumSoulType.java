/*     */ package emoniph.intangible.souls;
/*     */ 
/*     */ import emoniph.intangible.api.SoulType;
/*     */ import emoniph.intangible.init.IUnlocalizedName;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.util.IStringSerializable;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraft.util.StatCollector;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public enum EnumSoulType
/*     */   implements IStringSerializable, IUnlocalizedName
/*     */ {
/*  16 */   NOBLE(0, "noble", "noble", SoulType.NOBLE, 16755200, true, 6), 
/*  17 */   BENIGN(1, "benign", "benign", SoulType.BENIGN, 5636095, false, 4), 
/*  18 */   IMMUTABLE(2, "immutable", "immutable", SoulType.IMMUTABLE, 11184810, true, 5), 
/*  19 */   PREDATORY(3, "predatory", "predatory", SoulType.PREDATORY, 11141290, false, 4), 
/*  20 */   DOOMED(4, "doomed", "doomed", SoulType.DOOMED, 170, true, 6), 
/*  21 */   UNHINGED(5, "unhinged", "unhinged", SoulType.UNHINGED, 16733525, false, 4), 
/*  22 */   MALLEABLE(6, "malleable", "malleable", SoulType.MALLEABLE, 43520, false, 5), 
/*  23 */   WISE(7, "wise", "wise", SoulType.WISE, 5635925, false, 5);
/*     */   
/*     */   private static final EnumSoulType[] META_LOOKUP;
/*     */   private static final String[] ALL_UNLOCALIZED_NAMES;
/*     */   private static final int[] ALL_METADATA;
/*     */   private static final Map<SoulType, EnumSoulType> FROM_SOULTYPE;
/*     */   private final int meta;
/*     */   private final String name;
/*     */   private final String unlocalizedName;
/*     */   private final SoulType type;
/*     */   private final int color;
/*     */   private boolean strongSoul;
/*     */   private int minSoulsToSave;
/*     */   
/*     */   private EnumSoulType(int meta, String name, String unlocalizedName, SoulType type, int color, boolean strong, int minSoulsToSave)
/*     */   {
/*  39 */     this.meta = meta;
/*  40 */     this.name = name;
/*  41 */     this.unlocalizedName = unlocalizedName;
/*  42 */     this.type = type;
/*  43 */     this.color = color;
/*  44 */     this.strongSoul = strong;
/*  45 */     this.minSoulsToSave = minSoulsToSave;
/*     */   }
/*     */   
/*     */   public int getColor() {
/*  49 */     return this.color;
/*     */   }
/*     */   
/*     */   public int getMetadata() {
/*  53 */     return this.meta;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  57 */     return this.name;
/*     */   }
/*     */   
/*     */   public static EnumSoulType byMetadata(int meta) {
/*  61 */     if ((meta < 0) || (meta >= META_LOOKUP.length)) {
/*  62 */       meta = 0;
/*     */     }
/*     */     
/*  65 */     return META_LOOKUP[meta];
/*     */   }
/*     */   
/*     */   public String func_176610_l() {
/*  69 */     return this.name;
/*     */   }
/*     */   
/*     */   public String getUnlocalizedName() {
/*  73 */     return this.unlocalizedName;
/*     */   }
/*     */   
/*     */   public String getLocalizedName() {
/*  77 */     return StatCollector.func_74838_a("soul.intangible:" + this.unlocalizedName);
/*     */   }
/*     */   
/*     */   static
/*     */   {
/*  25 */     META_LOOKUP = new EnumSoulType[values().length];
/*  26 */     ALL_UNLOCALIZED_NAMES = new String[values().length];
/*  27 */     ALL_METADATA = new int[values().length];
/*  28 */     FROM_SOULTYPE = new HashMap();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  81 */     for (EnumSoulType soulType : values()) {
/*  82 */       META_LOOKUP[soulType.getMetadata()] = soulType;
/*  83 */       ALL_UNLOCALIZED_NAMES[soulType.getMetadata()] = soulType.getUnlocalizedName();
/*  84 */       ALL_METADATA[soulType.getMetadata()] = soulType.getMetadata();
/*  85 */       if (soulType.type != null) {
/*  86 */         FROM_SOULTYPE.put(soulType.type, soulType);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static EnumSoulType fromSoulType(SoulType soulType) {
/*  92 */     return (EnumSoulType)FROM_SOULTYPE.get(soulType);
/*     */   }
/*     */   
/*     */   public SoulType toSoulType() {
/*  96 */     return this.type;
/*     */   }
/*     */   
/*     */   public EnumSoulType forward() {
/* 100 */     return byMetadata((getMetadata() + 1) % (values().length + 1));
/*     */   }
/*     */   
/*     */   public EnumSoulType backwards() {
/* 104 */     return byMetadata(getMetadata() == 0 ? values().length - 1 : getMetadata() - 1);
/*     */   }
/*     */   
/* 107 */   private static final ResourceLocation[] RADIAL_GLYPHS = { new ResourceLocation("intangible", "textures/gui/radial_glyph_0.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_1.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_2.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_3.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_4.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_5.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_6.png"), new ResourceLocation("intangible", "textures/gui/radial_glyph_7.png") };
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public ResourceLocation getIcon()
/*     */   {
/* 120 */     return RADIAL_GLYPHS[getMetadata()];
/*     */   }
/*     */   
/*     */   public boolean isStrongSoul()
/*     */   {
/* 125 */     return this.strongSoul;
/*     */   }
/*     */   
/*     */   public int getMinSoulsToSave() {
/* 129 */     return this.minSoulsToSave;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/souls/EnumSoulType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */