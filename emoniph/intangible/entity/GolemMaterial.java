/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Sound;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public enum GolemMaterial
/*     */ {
/*  14 */   DIRT(0, 80.0F, 4.0F, 4, 0.2F, Sound.MOD_RANDOM_DIRT_HIT, new ResourceLocation("intangible:textures/entity/dirtgolem.png"), new ItemStack[] { new ItemStack(Blocks.field_150346_d, 4) }, new Block[] { Blocks.field_150346_d, Blocks.field_150349_c, Blocks.field_150424_aL }), 
/*     */   
/*     */ 
/*     */ 
/*  18 */   CLAY(1, 70.0F, 5.0F, 8, 0.3F, Sound.MOD_RANDOM_DIRT_HIT, new ResourceLocation("intangible:textures/entity/claygolem.png"), new ItemStack[] { new ItemStack(Blocks.field_150435_aG, 4) }, new Block[] { Blocks.field_150435_aG, Blocks.field_150405_ch, Blocks.field_150406_ce }), 
/*     */   
/*     */ 
/*  21 */   STONE(2, 60.0F, 6.0F, 10, 0.4F, Sound.MOD_RANDOM_ROCK_HIT, new ResourceLocation("intangible:textures/entity/stonegolem.png"), new ItemStack[] { new ItemStack(Blocks.field_150348_b, 4) }, new Block[] { Blocks.field_150348_b, Blocks.field_150377_bs });
/*     */   
/*     */ 
/*     */   private final int id;
/*     */   private final float health;
/*     */   private final float baseDamage;
/*     */   private final int randomDamage;
/*     */   private final float knockback;
/*     */   private final Sound hurtSound;
/*     */   private final ResourceLocation texture;
/*     */   private final ItemStack[] drops;
/*     */   private final Block[] blocks;
/*     */   private static GolemMaterial[] ID_TO_MAT;
/*     */   private static Map<Block, GolemMaterial> BLOCK_TO_MATERIAL;
/*     */   
/*     */   private GolemMaterial(int id, float health, float baseDamage, int randomDamage, float knockback, Sound hurtSound, ResourceLocation texture, ItemStack[] drops, Block[] blocks)
/*     */   {
/*  38 */     this.id = id;
/*  39 */     this.health = health;
/*  40 */     this.baseDamage = baseDamage;
/*  41 */     this.randomDamage = randomDamage;
/*  42 */     this.knockback = knockback;
/*  43 */     this.hurtSound = hurtSound;
/*  44 */     this.texture = texture;
/*  45 */     this.drops = drops;
/*  46 */     this.blocks = blocks;
/*     */   }
/*     */   
/*     */   public ResourceLocation getSkinTexture() {
/*  50 */     return this.texture;
/*     */   }
/*     */   
/*     */   public int getId() {
/*  54 */     return this.id;
/*     */   }
/*     */   
/*     */   static {
/*  58 */     BLOCK_TO_MATERIAL = new HashMap();
/*     */     
/*     */ 
/*  61 */     ID_TO_MAT = new GolemMaterial[values().length];
/*  62 */     for (GolemMaterial m : values()) {
/*  63 */       ID_TO_MAT[m.id] = m;
/*  64 */       for (Block block : m.blocks) {
/*  65 */         BLOCK_TO_MATERIAL.put(block, m);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public static GolemMaterial idToMat(int matId) {
/*  71 */     return ID_TO_MAT[matId];
/*     */   }
/*     */   
/*     */   public static GolemMaterial fromBlockState(IBlockState state) {
/*  75 */     return state != null ? (GolemMaterial)BLOCK_TO_MATERIAL.get(state.func_177230_c()) : null;
/*     */   }
/*     */   
/*     */   public float getHealth() {
/*  79 */     return this.health;
/*     */   }
/*     */   
/*     */   public float getBaseDamage() {
/*  83 */     return this.baseDamage;
/*     */   }
/*     */   
/*     */   public int getRandomDamage() {
/*  87 */     return this.randomDamage;
/*     */   }
/*     */   
/*     */   public double getKnockBack() {
/*  91 */     return this.knockback;
/*     */   }
/*     */   
/*     */   public Block[] getBlocks() {
/*  95 */     return this.blocks;
/*     */   }
/*     */   
/*     */   public Sound getHurtSound() {
/*  99 */     return this.hurtSound;
/*     */   }
/*     */   
/*     */   public ItemStack[] getDrops() {
/* 103 */     return this.drops;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/GolemMaterial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */