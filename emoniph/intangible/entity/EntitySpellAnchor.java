/*     */ package emoniph.intangible.entity;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.IGlow;
/*     */ import emoniph.intangible.spells.ModSpells;
/*     */ import emoniph.intangible.spells.anchors.SpellAnchor;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.UUID;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntitySpellAnchor extends EntitySpellBase implements net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData
/*     */ {
/*     */   private SpellAnchor spell;
/*     */   boolean impact;
/*  23 */   private List<EntityLivingBase> linked = new java.util.ArrayList();
/*     */   
/*     */   public EntitySpellAnchor(World worldIn) {
/*  26 */     super(worldIn);
/*  27 */     func_70105_a(0.25F, 0.25F);
/*     */   }
/*     */   
/*     */   public EntitySpellAnchor(World worldIn, EntityLivingBase shooter, SpellAnchor spell, double speed, List<EntityLivingBase> targets) {
/*  31 */     super(worldIn, shooter, 0.0D, 0.0D, 0.0D, speed);
/*  32 */     func_70105_a(0.25F, 0.25F);
/*  33 */     setSpell(spell);
/*  34 */     this.linked = targets;
/*     */   }
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
/*     */   protected void func_70088_a()
/*     */   {
/*  48 */     super.func_70088_a();
/*  49 */     func_70096_w().func_75682_a(12, Integer.valueOf(0));
/*  50 */     func_70096_w().func_75682_a(13, Integer.valueOf(0));
/*  51 */     func_70096_w().func_75682_a(14, Float.valueOf(1.0F));
/*  52 */     func_70096_w().func_75682_a(15, Integer.valueOf(-1));
/*     */   }
/*     */   
/*     */   public void writeSpawnData(ByteBuf buf)
/*     */   {
/*  57 */     buf.writeInt(this.linked.size());
/*  58 */     for (EntityLivingBase entity : this.linked) {
/*  59 */       buf.writeInt(entity.func_145782_y());
/*     */     }
/*     */   }
/*     */   
/*     */   public void readSpawnData(ByteBuf buf)
/*     */   {
/*  65 */     int size = buf.readInt();
/*  66 */     for (int i = 0; i < size; i++) {
/*  67 */       int entityId = buf.readInt();
/*  68 */       Entity entity = this.field_70170_p.func_73045_a(entityId);
/*  69 */       if ((entity != null) && ((entity instanceof EntityLivingBase))) {
/*  70 */         this.linked.add((EntityLivingBase)entity);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public EntitySpellAnchor setColor(int color) {
/*  76 */     return setColor(color, color, 1.0F);
/*     */   }
/*     */   
/*     */   public EntitySpellAnchor setColor(int innerColor, int outerColor, float scale) {
/*  80 */     func_70096_w().func_75692_b(12, Integer.valueOf(innerColor));
/*  81 */     func_70096_w().func_75692_b(13, Integer.valueOf(outerColor));
/*  82 */     func_70096_w().func_75692_b(14, Float.valueOf(scale));
/*  83 */     return this;
/*     */   }
/*     */   
/*     */   private void setSpell(SpellAnchor spell) {
/*  87 */     this.spell = spell;
/*  88 */     func_70096_w().func_75692_b(15, Integer.valueOf(Get.spells().getIndexFromSpell(spell)));
/*     */   }
/*     */   
/*     */   public SpellAnchor getSpell() {
/*  92 */     if (this.spell == null) {
/*  93 */       int index = func_70096_w().func_75679_c(15);
/*  94 */       this.spell = ((SpellAnchor)Get.spells().getSpellFromIndex(index));
/*     */     }
/*  96 */     return this.spell;
/*     */   }
/*     */   
/*     */   public int getInnerColor() {
/* 100 */     return func_70096_w().func_75679_c(12);
/*     */   }
/*     */   
/*     */   public int getOuterColor() {
/* 104 */     return func_70096_w().func_75679_c(13);
/*     */   }
/*     */   
/*     */   public float getScale() {
/* 108 */     return func_70096_w().func_111145_d(14);
/*     */   }
/*     */   
/*     */   protected float getGravityVelocity()
/*     */   {
/* 113 */     return 0.03F;
/*     */   }
/*     */   
/*     */   protected float getMotionFactor()
/*     */   {
/* 118 */     return 0.99F;
/*     */   }
/*     */   
/*     */   protected float getAccelerationModifier()
/*     */   {
/* 123 */     return 0.85F;
/*     */   }
/*     */   
/*     */   protected int getMaxTicksInGround()
/*     */   {
/* 128 */     return getSpell().getTicksInGround(this);
/*     */   }
/*     */   
/*     */   protected int getMaxTicksInAir()
/*     */   {
/* 133 */     return getSpell().getTicksInAir(this);
/*     */   }
/*     */   
/*     */   protected void onImpact(MovingObjectPosition movingObject)
/*     */   {
/* 138 */     if ((movingObject.field_72313_a == net.minecraft.util.MovingObjectPosition.MovingObjectType.BLOCK) || ((movingObject.field_72308_g instanceof EntityLivingBase))) {
/* 139 */       this.field_70159_w = (this.field_70181_x = this.field_70179_y = 0.0D);
/* 140 */       this.impact = true;
/*     */     }
/*     */   }
/*     */   
/*     */   @net.minecraftforge.fml.relauncher.SideOnly(net.minecraftforge.fml.relauncher.Side.CLIENT)
/*     */   public boolean drawConnectingLine() {
/* 146 */     return getSpell().drawConnectingLine(this);
/*     */   }
/*     */   
/*     */   public void func_70071_h_()
/*     */   {
/* 151 */     super.func_70071_h_();
/*     */     
/* 153 */     if ((this.field_70173_aa == 1) && (!this.loadLinked.isEmpty())) {
/* 154 */       for (int i = 0; i < this.field_70170_p.field_72996_f.size(); i++) {
/* 155 */         Entity entity = (Entity)this.field_70170_p.field_72996_f.get(i);
/*     */         
/* 157 */         if (this.loadLinked.contains(entity.func_110124_au())) {
/* 158 */           this.linked.add((EntityLivingBase)entity);
/*     */         }
/*     */       }
/* 161 */       this.loadLinked.clear();
/*     */     }
/*     */     
/* 164 */     float scale = getScale();
/*     */     
/* 166 */     if (this.field_70170_p.field_72995_K)
/*     */     {
/*     */ 
/* 169 */       emoniph.intangible.Intangible.PROXY.glow(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v).scale(3.0F * scale).color(getOuterColor()).duration(2);
/*     */       
/* 171 */       emoniph.intangible.Intangible.PROXY.glow(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v).scale(2.0F * scale)
/* 172 */         .color(getInnerColor())
/* 173 */         .duration(1);
/*     */     }
/* 175 */     else if ((this.impact) && 
/* 176 */       (getSpell().update(this, this.linked))) {
/* 177 */       func_70106_y();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public void func_70014_b(NBTTagCompound compound)
/*     */   {
/* 184 */     super.func_70014_b(compound);
/* 185 */     compound.func_74768_a("colorInner", getInnerColor());
/* 186 */     compound.func_74768_a("colorOuter", getOuterColor());
/* 187 */     String spellId = Get.spells().getIdForSpell(this.spell);
/* 188 */     if ((spellId == null) || (spellId.isEmpty())) {
/* 189 */       Get.log().warning("Trying to save a spell entity with an empty spell id!");
/* 190 */       func_70106_y();
/*     */     } else {
/* 192 */       compound.func_74778_a("spell", spellId);
/*     */     }
/* 194 */     compound.func_74776_a("spellScale", getScale());
/* 195 */     compound.func_74757_a("impacted", this.impact);
/*     */     
/*     */ 
/* 198 */     NBTTagList list = new NBTTagList();
/* 199 */     for (EntityLivingBase entity : this.linked) {
/* 200 */       NBTTagCompound item = new NBTTagCompound();
/* 201 */       item.func_74772_a("msb", entity.func_110124_au().getMostSignificantBits());
/* 202 */       item.func_74772_a("lsb", entity.func_110124_au().getLeastSignificantBits());
/* 203 */       list.func_74742_a(item);
/*     */     }
/* 205 */     compound.func_74782_a("linked", list);
/*     */   }
/*     */   
/* 208 */   private Set<UUID> loadLinked = new java.util.HashSet();
/*     */   
/*     */   public void func_70037_a(NBTTagCompound compound)
/*     */   {
/* 212 */     super.func_70037_a(compound);
/* 213 */     float scale = compound.func_74760_g("spellScale");
/* 214 */     if (scale <= 0.0F) {
/* 215 */       scale = 1.0F;
/*     */     }
/* 217 */     setColor(compound.func_74762_e("colorInner"), compound.func_74762_e("colorOuter"), scale);
/* 218 */     if (compound.func_150297_b("spell", 8)) {
/* 219 */       setSpell((SpellAnchor)Get.spells().getSpellForId(compound.func_74779_i("spell")));
/*     */     } else {
/* 221 */       func_70106_y();
/*     */     }
/* 223 */     this.impact = compound.func_74767_n("impacted");
/*     */     
/* 225 */     this.linked = new java.util.ArrayList();
/* 226 */     this.loadLinked = new java.util.HashSet();
/* 227 */     if (compound.func_150297_b("linked", 9)) {
/* 228 */       NBTTagList list = compound.func_150295_c("linked", 10);
/* 229 */       int i = 0; for (int count = list.func_74745_c(); i < count; i++) {
/* 230 */         NBTTagCompound item = list.func_150305_b(i);
/* 231 */         if (item != null) {
/* 232 */           UUID id = new UUID(item.func_74763_f("msb"), item.func_74763_f("lsb"));
/* 233 */           this.loadLinked.add(id);
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_70106_y()
/*     */   {
/* 241 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public List<EntityLivingBase> getLinkedEntities() {
/* 245 */     return this.linked;
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/entity/EntitySpellAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */