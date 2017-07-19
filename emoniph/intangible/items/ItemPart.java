/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import java.util.List;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ItemPart extends Item implements IItem, IItemWithVariants, ICreativeSort
/*     */ {
/*     */   public int getCreativeSortIndex()
/*     */   {
/*  15 */     return 100;
/*     */   }
/*     */   
/*     */   public static enum PartGroup {
/*  19 */     GENERIC,  FORGE_MATERIAL,  GOLEM,  GOLEM_COMPONENT;
/*     */     
/*     */     private PartGroup() {} }
/*  22 */   public static enum EnumPart { IRON_CASE(0, "ironcase", ItemPart.PartGroup.GENERIC), 
/*  23 */     BONE_SPLINTERS(1, "soulbonesplinters", ItemPart.PartGroup.GENERIC), 
/*  24 */     BONE_CONDUIT(2, "soulboneconduit", ItemPart.PartGroup.GENERIC), 
/*  25 */     STONE_RING(3, "stonering", ItemPart.PartGroup.GENERIC), 
/*  26 */     CONTROL_CIRCUIT(4, "controlcircuit", ItemPart.PartGroup.GENERIC), 
/*  27 */     CRYSTALLIZED_SOULBONE(5, "crystallizedsoulbone", ItemPart.PartGroup.FORGE_MATERIAL), 
/*  28 */     BLUE_GEM(6, "bluegem", ItemPart.PartGroup.GENERIC), 
/*  29 */     YELLOW_GEM(7, "yellowgem", ItemPart.PartGroup.GENERIC), 
/*  30 */     EMITTER(8, "emitter", ItemPart.PartGroup.GENERIC), 
/*  31 */     QUANTIFIER(9, "quantifier", ItemPart.PartGroup.GENERIC), 
/*  32 */     PONDERANCE_LATTICE(10, "ponderancelattice", ItemPart.PartGroup.GENERIC), 
/*  33 */     GOLEM_HEAD_ARMORED(11, "golemheadarmored", ItemPart.PartGroup.GOLEM), 
/*  34 */     GOLEM_BODY(12, "golembody", ItemPart.PartGroup.GOLEM), 
/*  35 */     GOLEM_LEG_JUMP(13, "golemleg", ItemPart.PartGroup.GOLEM), 
/*  36 */     GOLEM_ARM_CLAW(14, "golemarmclaw", ItemPart.PartGroup.GOLEM), 
/*  37 */     GOLEM_ARM_HAMMER(15, "golemarmhammer", ItemPart.PartGroup.GOLEM), 
/*  38 */     GOLEM_ARM_BURST(16, "golemarmburst", ItemPart.PartGroup.GOLEM), 
/*  39 */     GOLEM_ARM_SWARM(17, "golemarmswarm", ItemPart.PartGroup.GOLEM), 
/*  40 */     GOLEM_HEAD_REGEN(18, "golemheadregen", ItemPart.PartGroup.GOLEM), 
/*  41 */     GOLEM_ARM_AXE(19, "golemarmaxe", ItemPart.PartGroup.GOLEM), 
/*  42 */     GOLEM_HEAD_HOOVER(20, "golemheadhoover", ItemPart.PartGroup.GOLEM), 
/*  43 */     GOLEM_CONDENSED_STONE_PLATE(21, "condensedstoneplate", ItemPart.PartGroup.GOLEM_COMPONENT), 
/*  44 */     GOLEM_ARMORED_PLATE(22, "golemarmoredplate", ItemPart.PartGroup.GOLEM_COMPONENT), 
/*  45 */     GOLEM_CONTROL_CORE(23, "golemcore", ItemPart.PartGroup.GOLEM_COMPONENT), 
/*  46 */     GOLEM_JOINT(24, "golemjoint", ItemPart.PartGroup.GOLEM_COMPONENT), 
/*  47 */     GOLEM_SHOULDER_JOINT(25, "golemshoulder", ItemPart.PartGroup.GOLEM_COMPONENT), 
/*  48 */     GOLEM_OCULUS(26, "golemoculus", ItemPart.PartGroup.GOLEM_COMPONENT), 
/*  49 */     GOLEM_THRUSTER(27, "golemthruster", ItemPart.PartGroup.GOLEM_COMPONENT), 
/*  50 */     GOLEM_LEG_FAST(28, "golemlegfast", ItemPart.PartGroup.GOLEM), 
/*  51 */     GOLEM_LEG_CANDLE(29, "golemlegcandle", ItemPart.PartGroup.GOLEM), 
/*  52 */     GOLEM_BODY_TURRET(30, "golembodyturret", ItemPart.PartGroup.GOLEM);
/*     */     
/*     */     private static final EnumPart[] META_LOOKUP;
/*     */     public static final String[] ALL_UNLOCALIZED_NAMES;
/*     */     public static final int[] ALL_METADATA;
/*     */     private final int meta;
/*     */     private final String name;
/*     */     private final ItemPart.PartGroup group;
/*     */     private ItemStack stack;
/*     */     private static final VariantItemData[] VARIANTS_ITEMS;
/*     */     
/*     */     private EnumPart(int meta, String name, ItemPart.PartGroup group)
/*     */     {
/*  65 */       this.meta = meta;
/*  66 */       this.name = name;
/*  67 */       this.group = group;
/*     */     }
/*     */     
/*     */     public int getMetadata()
/*     */     {
/*  72 */       return this.meta;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  76 */       return this.name;
/*     */     }
/*     */     
/*     */     public ItemStack getRefStack() {
/*  80 */       if (this.stack == null) {
/*  81 */         this.stack = new ItemStack(Get.items().PART, 1, this.meta);
/*     */       }
/*  83 */       return this.stack;
/*     */     }
/*     */     
/*     */     public static EnumPart byMetadata(int meta) {
/*  87 */       if ((meta < 0) || (meta >= META_LOOKUP.length)) {
/*  88 */         meta = 0;
/*     */       }
/*     */       
/*  91 */       return META_LOOKUP[meta];
/*     */     }
/*     */     
/*     */     public String getUnlocalizedName() {
/*  95 */       return this.name;
/*     */     }
/*     */     
/*     */     public ItemStack stackOf(int quantity) {
/*  99 */       return new ItemStack(Get.items().PART, quantity, this.meta);
/*     */     }
/*     */     
/*     */     static
/*     */     {
/*  55 */       META_LOOKUP = new EnumPart[values().length];
/*  56 */       ALL_UNLOCALIZED_NAMES = new String[values().length];
/*  57 */       ALL_METADATA = new int[values().length];
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
/* 102 */       VARIANTS_ITEMS = new VariantItemData[values().length];
/*     */       
/*     */ 
/* 105 */       for (EnumPart part : values()) {
/* 106 */         META_LOOKUP[part.getMetadata()] = part;
/* 107 */         ALL_UNLOCALIZED_NAMES[part.getMetadata()] = part.getUnlocalizedName();
/* 108 */         ALL_METADATA[part.getMetadata()] = part.getMetadata();
/* 109 */         VARIANTS_ITEMS[part.getMetadata()] = new VariantItemData(part.getUnlocalizedName(), part.getMetadata());
/*     */       }
/*     */     }
/*     */     
/*     */     public ItemPart.PartGroup getGroup() {
/* 114 */       return this.group;
/*     */     }
/*     */   }
/*     */   
/*     */   public VariantItemData[] getVariants()
/*     */   {
/* 120 */     return EnumPart.VARIANTS_ITEMS;
/*     */   }
/*     */   
/*     */   public String func_77667_c(ItemStack stack)
/*     */   {
/* 125 */     return super.func_77667_c(stack) + "_" + EnumPart.byMetadata(stack.func_77960_j()).getUnlocalizedName();
/*     */   }
/*     */   
/*     */   public ItemPart() {
/* 129 */     func_77656_e(0);
/* 130 */     func_77627_a(true);
/*     */   }
/*     */   
/*     */   public int func_77647_b(int damage)
/*     */   {
/* 135 */     return damage;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_150895_a(Item itemIn, CreativeTabs tab, List subItems) {
/* 140 */     for (VariantItemData item : EnumPart.VARIANTS_ITEMS) {
/* 141 */       subItems.add(new ItemStack(itemIn, 1, item.metadata));
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */