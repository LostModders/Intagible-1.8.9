/*     */ package emoniph.intangible.items;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.BlockPos;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.ChunkProviderFlat;
/*     */ import net.minecraft.world.gen.ChunkProviderGenerate;
/*     */ import net.minecraft.world.gen.ChunkProviderServer;
/*     */ import net.minecraft.world.gen.structure.MapGenVillage;
/*     */ 
/*     */ public class ItemVillageFinder extends Item implements IItem, IItemWithVariants, ICreativeSort
/*     */ {
/*     */   public ItemVillageFinder()
/*     */   {
/*  19 */     func_77625_d(1);
/*  20 */     func_77656_e(0);
/*     */   }
/*     */   
/*     */   public void func_77663_a(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
/*     */   {
/*  25 */     if ((!worldIn.field_72995_K) && (worldIn.func_82737_E() % 20L == 4L)) {
/*  26 */       BlockPos pos = new BlockPos(entityIn);
/*  27 */       net.minecraft.world.chunk.IChunkProvider cp = worldIn.func_72863_F();
/*  28 */       while ((cp != null) && ((cp instanceof ChunkProviderServer))) {
/*  29 */         cp = ((ChunkProviderServer)cp).field_73246_d;
/*     */       }
/*     */       
/*  32 */       if (cp != null) { Iterator iterator;
/*  33 */         if ((cp instanceof ChunkProviderFlat)) {
/*  34 */           for (iterator = ((ChunkProviderFlat)cp).field_82696_f.iterator(); iterator.hasNext();) {
/*  35 */             Object nextItem = iterator.next();
/*  36 */             if ((nextItem != null) && ((nextItem instanceof MapGenVillage))) {
/*  37 */               updateDisplayedRange(stack, worldIn, entityIn, pos, (MapGenVillage)nextItem);
/*  38 */               return;
/*     */             }
/*     */           }
/*  41 */         } else if ((cp instanceof ChunkProviderGenerate)) {
/*  42 */           updateDisplayedRange(stack, worldIn, entityIn, pos, ((ChunkProviderGenerate)cp).field_73224_v);
/*  43 */           return;
/*     */         }
/*     */       }
/*     */       
/*  47 */       setDamageIfChanged(stack, 0);
/*     */     }
/*     */   }
/*     */   
/*     */   private void updateDisplayedRange(ItemStack stack, World worldIn, Entity entityIn, BlockPos pos, MapGenVillage village) {
/*  52 */     if (village != null) {
/*  53 */       BlockPos newPos = village.func_180706_b(worldIn, pos);
/*  54 */       if (newPos != null) {
/*  55 */         double rangeSq = entityIn.func_70092_e(newPos.func_177958_n(), entityIn.field_70163_u, newPos.func_177952_p());
/*  56 */         if (rangeSq < 4096.0D) {
/*  57 */           setDamageIfChanged(stack, 5);
/*  58 */         } else if (rangeSq < 16384.0D) {
/*  59 */           setDamageIfChanged(stack, 4);
/*  60 */         } else if (rangeSq < 65536.0D) {
/*  61 */           setDamageIfChanged(stack, 3);
/*  62 */         } else if (rangeSq < 262144.0D) {
/*  63 */           setDamageIfChanged(stack, 2);
/*  64 */         } else if (rangeSq < 1048576.0D) {
/*  65 */           setDamageIfChanged(stack, 1);
/*     */         } else {
/*  67 */           setDamageIfChanged(stack, 0);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void setDamageIfChanged(ItemStack stack, int damage) {
/*  74 */     if (stack.func_77952_i() != damage) {
/*  75 */       stack.func_77964_b(damage);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean onDroppedByPlayer(ItemStack stack, EntityPlayer player)
/*     */   {
/*  81 */     setDamageIfChanged(stack, 0);
/*  82 */     return super.onDroppedByPlayer(stack, player);
/*     */   }
/*     */   
/*     */   public VariantItemData[] getVariants()
/*     */   {
/*  87 */     return VARIANTS_ITEMS;
/*     */   }
/*     */   
/*  90 */   private static final VariantItemData[] VARIANTS_ITEMS = new VariantItemData[6];
/*     */   
/*     */   static {
/*  93 */     for (int i = 0; i < VARIANTS_ITEMS.length; i++) {
/*  94 */       VARIANTS_ITEMS[i] = new VariantItemData("" + i, i);
/*     */     }
/*     */   }
/*     */   
/*     */   public int getCreativeSortIndex()
/*     */   {
/* 100 */     return 6;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/items/ItemVillageFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */