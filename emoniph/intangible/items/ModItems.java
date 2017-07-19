/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.blocks.ModBlocks;
/*     */ import emoniph.intangible.fluids.ModFluids;
/*     */ import emoniph.intangible.init.IModInitClient;
/*     */ import emoniph.intangible.init.IModPreInitClient;
/*     */ import emoniph.intangible.network.IPacketRegister;
/*     */ import emoniph.intangible.util.EnumArmorSlot;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.renderer.entity.RenderItem;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry.FluidContainerData;
/*     */ import net.minecraftforge.fluids.FluidStack;
/*     */ import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
/*     */ import net.minecraftforge.fml.relauncher.Side;
/*     */ import net.minecraftforge.fml.relauncher.SideOnly;
/*     */ 
/*     */ public class ModItems implements emoniph.intangible.init.IModService, emoniph.intangible.init.IModPreInit, IModPreInitClient, IModInitClient, emoniph.intangible.network.IRegisterPackets
/*     */ {
/*  24 */   private final Registry registry = new Registry();
/*     */   
/*     */ 
/*  27 */   public final ItemFoci FOCI = (ItemFoci)this.registry.add(new ItemFoci(), "foci");
/*  28 */   public final ItemSoulArmor SOUL_HELMET = (ItemSoulArmor)this.registry.add(new ItemSoulArmor(EnumArmorSlot.HEAD), "soulhelmet");
/*  29 */   public final ItemSoulArmor SOUL_CHESTPLATE = (ItemSoulArmor)this.registry.add(new ItemSoulArmor(EnumArmorSlot.CHEST), "soulchestplate");
/*  30 */   public final ItemSoulArmor SOUL_TROUSERS = (ItemSoulArmor)this.registry.add(new ItemSoulArmor(EnumArmorSlot.LEGS), "soulleggings");
/*  31 */   public final ItemSoulArmor SOUL_BOOTS = (ItemSoulArmor)this.registry.add(new ItemSoulArmor(EnumArmorSlot.FEET), "soulboots");
/*     */   
/*  33 */   public final Item SOUL_LEASH = this.registry.add(new ItemSoulLeash(), "soulleash");
/*     */   
/*  35 */   public final Item KNOWLEDGE_GEM = this.registry.add(new ItemKnowledgeGem(), "knowledgegem");
/*  36 */   public final Item SOUL_BONE = this.registry.add(new ItemSoulBone(), "soulbone");
/*  37 */   public final Item SHARD = this.registry.add(new ItemShard(), "shard");
/*     */   
/*  39 */   public final Item PART = this.registry.add(new ItemPart(), "part");
/*     */   
/*  41 */   public final Item BUCKET_MOLTEN_CRYSTAL_BLUE = ((ItemBucketBase)this.registry.add(new ItemBucketBase(Get.blocks().MOLTEN_CRYSTAL_BLUE), "bucketmoltencrystalblue"))
/*  42 */     .func_77642_a(Items.field_151133_ar);
/*     */   
/*  44 */   public final Item BUCKET_MOLTEN_CRYSTAL_YELLOW = ((ItemBucketBase)this.registry.add(new ItemBucketBase(Get.blocks().MOLTEN_CRYSTAL_YELLOW), "bucketmoltencrystalyellow"))
/*  45 */     .func_77642_a(Items.field_151133_ar);
/*     */   
/*  47 */   public final Item BUCKET_MOLTEN_GLASS = ((ItemBucketBase)this.registry.add(new ItemBucketBase(Get.blocks().MOLTEN_GLASS), "bucketmoltenglass"))
/*  48 */     .func_77642_a(Items.field_151133_ar);
/*     */   
/*  50 */   public final ItemMold MOLD_FUNNEL = (ItemMold)this.registry.add(new ItemMold(new ItemStack(
/*  51 */     Get.blocks().FUNNEL), new FluidStack(Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000)), "moldfunnel");
/*  52 */   public final ItemMold MOLD_DECANTER = (ItemMold)this.registry.add(new ItemMold(new ItemStack(
/*  53 */     Get.blocks().DECANTER), new FluidStack(Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000)), "molddecanter");
/*  54 */   public final ItemMold MOLD_SPITTER = (ItemMold)this.registry.add(new ItemMold(new ItemStack(
/*  55 */     Get.blocks().SPLITER), new FluidStack(Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000)), "moldsplitter");
/*  56 */   public final ItemMold MOLD_GOURD = (ItemMold)this.registry.add(new ItemMold(new ItemStack(
/*  57 */     Get.blocks().GOARD), new FluidStack(Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000)), "moldgourd");
/*  58 */   public final ItemMold MOLD_SPIRAL = (ItemMold)this.registry.add(new ItemMold(new ItemStack(
/*  59 */     Get.blocks().SPIRAL), new FluidStack(Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000)), "moldspiral");
/*     */   
/*  61 */   public final ItemMold MOLD_GEMS = (ItemMold)this.registry.add(new ItemMold(new ItemMold.Recipe[] { new ItemMold.Recipe(new ItemStack(this.PART, 3, ItemPart.EnumPart.BLUE_GEM
/*     */   
/*  63 */     .getMetadata()), new FluidStack(
/*  64 */     Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000)), new ItemMold.Recipe(new ItemStack(this.PART, 3, ItemPart.EnumPart.YELLOW_GEM
/*     */     
/*  66 */     .getMetadata()), new FluidStack(
/*  67 */     Get.fluids().MOLTEN_CRYSTAL_YELLOW, 1000)) }), "moldgems");
/*     */   
/*  69 */   public final ItemMold MOLD_BOTTLE = (ItemMold)this.registry.add(new ItemMold(new ItemStack(Items.field_151069_bo, 6), new FluidStack(
/*  70 */     Get.fluids().MOLTEN_GLASS, 1000)), "moldbottle");
/*  71 */   public final ItemMold MOLD_PANE = (ItemMold)this.registry.add(new ItemMold(new ItemStack(net.minecraft.init.Blocks.field_150410_aZ, 5), new FluidStack(
/*  72 */     Get.fluids().MOLTEN_GLASS, 1000)), "moldpane");
/*     */   
/*  74 */   public final ItemGlass GLASS = (ItemGlass)this.registry.add(new ItemGlass(), "glass");
/*     */   
/*  76 */   public final ItemSoulBoundRing SOULBOUND_RING = (ItemSoulBoundRing)this.registry.add(new ItemSoulBoundRing(), "boundring");
/*     */   
/*  78 */   public final ItemRod ROD = (ItemRod)this.registry.add(new ItemRod(), "rod");
/*     */   
/*  80 */   public final ItemVillageFinder VILLAGE_FINDER = (ItemVillageFinder)this.registry.add(new ItemVillageFinder(), "villagefinder");
/*     */   
/*  82 */   public final ItemCrystalArmor BLUE_CRYSTAL_HELMET = (ItemCrystalArmor)this.registry.add(new ItemCrystalArmor(EnumArmorSlot.HEAD, Get.armorBlueCrystalMaterial()), "bluecrystalhelmet");
/*  83 */   public final ItemCrystalArmor YELLOW_CRYSTAL_HELMET = (ItemCrystalArmor)this.registry.add(new ItemCrystalArmor(EnumArmorSlot.HEAD, Get.armorYellowCrystalMaterial()), "yellowcrystalhelmet");
/*  84 */   public final ItemCrystalArmor BLUE_CRYSTAL_CHESTPLATE = (ItemCrystalArmor)this.registry.add(new ItemCrystalArmor(EnumArmorSlot.CHEST, Get.armorBlueCrystalMaterial()), "bluecrystalchestplate");
/*  85 */   public final ItemCrystalArmor BLUE_CRYSTAL_TROUSERS = (ItemCrystalArmor)this.registry.add(new ItemCrystalArmor(EnumArmorSlot.LEGS, Get.armorBlueCrystalMaterial()), "bluecrystalleggings");
/*  86 */   public final ItemCrystalArmor BLUE_CRYSTAL_BOOTS = (ItemCrystalArmor)this.registry.add(new ItemCrystalArmor(EnumArmorSlot.FEET, Get.armorBlueCrystalMaterial()), "bluecrystalboots");
/*     */   
/*  88 */   public final ItemChariot CHARIOT = (ItemChariot)this.registry.add(new ItemChariot(), "chariot");
/*  89 */   public final ItemJavelin JAVELIN = (ItemJavelin)this.registry.add(new ItemJavelin(), "javelin");
/*     */   
/*  91 */   public final Item CORNUCOPIA = this.registry.add(new ItemCornucopia(), "cornucopia");
/*     */   
/*  93 */   public final ItemBoneSpear SOUL_SPEAR = (ItemBoneSpear)this.registry.add(new ItemBoneSpear(), "soulspear");
/*     */   
/*     */   public void preInit(FMLPreInitializationEvent event)
/*     */   {
/*  97 */     Get.pipeline().registerPacketProvider(this);
/*     */     
/*  99 */     FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(new FluidStack(
/*     */     
/* 101 */       Get.fluids().MOLTEN_CRYSTAL_BLUE, 1000), new ItemStack(this.BUCKET_MOLTEN_CRYSTAL_BLUE), new ItemStack(Items.field_151133_ar)));
/*     */     
/*     */ 
/*     */ 
/* 105 */     FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(new FluidStack(
/*     */     
/* 107 */       Get.fluids().MOLTEN_CRYSTAL_YELLOW, 1000), new ItemStack(this.BUCKET_MOLTEN_CRYSTAL_YELLOW), new ItemStack(Items.field_151133_ar)));
/*     */     
/*     */ 
/*     */ 
/* 111 */     FluidContainerRegistry.registerFluidContainer(new FluidContainerRegistry.FluidContainerData(new FluidStack(
/*     */     
/* 113 */       Get.fluids().MOLTEN_GLASS, 1000), new ItemStack(this.BUCKET_MOLTEN_GLASS), new ItemStack(Items.field_151133_ar)));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void preInit(Minecraft mc)
/*     */   {
/* 121 */     this.registry.preInit(mc);
/*     */   }
/*     */   
/*     */   public void registerPackets(IPacketRegister messageRegister)
/*     */   {
/* 126 */     this.registry.registerMessages(messageRegister);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void init(Minecraft mc, RenderItem renderItem)
/*     */   {
/* 132 */     this.registry.init(mc, renderItem);
/*     */   }
/*     */   
/*     */   public void foreach(IItemVisitor visitor) {
/* 136 */     this.registry.foreach(visitor);
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ModItems.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */