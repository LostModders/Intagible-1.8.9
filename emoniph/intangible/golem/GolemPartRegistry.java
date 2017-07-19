/*     */ package emoniph.intangible.golem;
/*     */ 
/*     */ import emoniph.intangible.Get;
/*     */ import emoniph.intangible.api.IBookPageResources;
/*     */ import emoniph.intangible.api.IKnol;
/*     */ import emoniph.intangible.api.golem.IGolemArm;
/*     */ import emoniph.intangible.api.golem.IGolemBody;
/*     */ import emoniph.intangible.api.golem.IGolemHead;
/*     */ import emoniph.intangible.api.golem.IGolemLeg;
/*     */ import emoniph.intangible.items.ItemPart.EnumPart;
/*     */ import emoniph.intangible.knowledge.Knowledge;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ 
/*     */ public class GolemPartRegistry implements emoniph.intangible.init.IModService
/*     */ {
/*  19 */   public final List<Part<IGolemArm>> arms = new ArrayList();
/*  20 */   public final List<Part<IGolemLeg>> legs = new ArrayList();
/*  21 */   public final List<Part<IGolemHead>> heads = new ArrayList();
/*  22 */   public final List<Part<IGolemBody>> bodies = new ArrayList();
/*     */   
/*  24 */   public final Part<IGolemArm> ARM_CLAW = register(new GolemArmClaw(), ItemPart.EnumPart.GOLEM_ARM_CLAW.stackOf(1));
/*  25 */   public final Part<IGolemArm> ARM_HAMMER = register(new GolemArmHammer(), ItemPart.EnumPart.GOLEM_ARM_HAMMER.stackOf(1));
/*  26 */   public final Part<IGolemArm> ARM_AXE = register(new GolemArmAxe(), ItemPart.EnumPart.GOLEM_ARM_AXE.stackOf(1));
/*  27 */   public final Part<IGolemArm> ARM_BURST = register(new GolemArmBurst(), ItemPart.EnumPart.GOLEM_ARM_BURST.stackOf(1));
/*  28 */   public final Part<IGolemArm> ARM_SWARM = register(new GolemArmSwarm(), ItemPart.EnumPart.GOLEM_ARM_SWARM.stackOf(1));
/*     */   
/*  30 */   public final Part<IGolemHead> HEAD_ARMORED = register(new GolemHead(100, 5, new ResourceLocation("intangible:textures/entity/wreckinggolem.png")), ItemPart.EnumPart.GOLEM_HEAD_ARMORED
/*  31 */     .stackOf(1));
/*     */   
/*  33 */   public final Part<IGolemHead> HEAD_REGEN = register(new GolemHeadEars(50, 2, 100, new ResourceLocation("intangible:textures/entity/wreckinggolem.png")), ItemPart.EnumPart.GOLEM_HEAD_REGEN
/*  34 */     .stackOf(1));
/*     */   
/*  36 */   public final Part<IGolemHead> HEAD_SUCTION = register(new GolemHeadHoover(0, 4, new ResourceLocation("intangible:textures/entity/wreckinggolemheadhoover.png")), ItemPart.EnumPart.GOLEM_HEAD_HOOVER
/*  37 */     .stackOf(1));
/*     */   
/*  39 */   public final Part<IGolemLeg> LEG_JUMP = register(new GolemLeg(0.1D, 1, new ResourceLocation("intangible:textures/entity/wreckinggolem.png")), ItemPart.EnumPart.GOLEM_LEG_JUMP
/*  40 */     .stackOf(1));
/*     */   
/*  42 */   public final Part<IGolemLeg> LEG_FAST = register(new GolemFastLeg(0.2D, 0, new ResourceLocation("intangible:textures/entity/wreckinggolem.png")), ItemPart.EnumPart.GOLEM_LEG_FAST
/*  43 */     .stackOf(1));
/*     */   
/*  45 */   public final Part<IGolemLeg> LEG_CANDLE = register(new GolemCandleLeg(0.1D, 0, new ResourceLocation("intangible:textures/entity/wreckinggolemalt.png")), ItemPart.EnumPart.GOLEM_LEG_CANDLE
/*  46 */     .stackOf(1));
/*     */   
/*  48 */   public final Part<IGolemBody> BODY_NORMAL = register(new GolemBody(300.0F, 8, new ResourceLocation("intangible:textures/entity/wreckinggolem.png")), ItemPart.EnumPart.GOLEM_BODY
/*  49 */     .stackOf(1));
/*     */   
/*  51 */   public final Part<IGolemBody> BODY_TURRET = register(new GolemBodyTurret(200.0F, 8), ItemPart.EnumPart.GOLEM_BODY_TURRET.stackOf(1));
/*     */   
/*     */   public <T extends IGolemHead> Part<IGolemHead> register(T head, ItemStack stack) {
/*  54 */     if (isStackRegistered(stack)) {
/*  55 */       return null;
/*     */     }
/*  57 */     Part<IGolemHead> item = new Part(head, this.heads.size(), stack);
/*  58 */     this.heads.add(item);
/*  59 */     return item;
/*     */   }
/*     */   
/*     */   public <T extends IGolemArm> Part<IGolemArm> register(T arm, ItemStack stack) {
/*  63 */     if (isStackRegistered(stack)) {
/*  64 */       return null;
/*     */     }
/*  66 */     Part<IGolemArm> item = new Part(arm, this.arms.size(), stack);
/*  67 */     this.arms.add(item);
/*  68 */     return item;
/*     */   }
/*     */   
/*     */   public <T extends IGolemLeg> Part<IGolemLeg> register(T leg, ItemStack stack) {
/*  72 */     if (isStackRegistered(stack)) {
/*  73 */       return null;
/*     */     }
/*  75 */     Part<IGolemLeg> item = new Part(leg, this.legs.size(), stack);
/*  76 */     this.legs.add(item);
/*  77 */     return item;
/*     */   }
/*     */   
/*     */   public <T extends IGolemBody> Part<IGolemBody> register(T body, ItemStack stack) {
/*  81 */     if (isStackRegistered(stack)) {
/*  82 */       return null;
/*     */     }
/*  84 */     Part<IGolemBody> item = new Part(body, this.bodies.size(), stack);
/*  85 */     this.bodies.add(item);
/*  86 */     return item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private boolean isStackRegistered(ItemStack stack)
/*     */   {
/*  93 */     return (isStackRegistered(this.arms, stack)) || (isStackRegistered(this.legs, stack)) || (isStackRegistered(this.bodies, stack)) || (isStackRegistered(this.heads, stack));
/*     */   }
/*     */   
/*     */   private <T> boolean isStackRegistered(List<Part<T>> list, ItemStack stack) {
/*  97 */     for (Part<T> part : list) {
/*  98 */       if (ItemStack.func_179545_c(part.getStack(), stack)) {
/*  99 */         return true;
/*     */       }
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public List<IBookPageResources> getPageResource() {
/* 106 */     List<IBookPageResources> list = new ArrayList();
/* 107 */     addPageResources(this.bodies, list);
/* 108 */     addPageResources(this.heads, list);
/* 109 */     addPageResources(this.legs, list);
/* 110 */     addPageResources(this.arms, list);
/* 111 */     return list;
/*     */   }
/*     */   
/*     */   private <T> void addPageResources(List<Part<T>> list, List<IBookPageResources> pageList) {
/* 115 */     for (Part<T> part : list) {
/* 116 */       pageList.add(new emoniph.intangible.knowledge.PageResources(part.getStack().func_77977_a().substring(5), part.getStack().func_77977_a() + ".name", part.getStack().func_77977_a() + ".p1", part.getStack(), new IKnol[] { Get.knowledge().SKILL_SOUL_MANIPULATION, Get.knowledge().SOUL_MALLEABLE }));
/*     */     }
/*     */   }
/*     */   
/*     */   public Part<IGolemArm> getArmByIndex(int index) {
/* 121 */     if ((index >= 0) && (index < this.arms.size())) {
/* 122 */       return (Part)this.arms.get(index);
/*     */     }
/* 124 */     return null;
/*     */   }
/*     */   
/*     */   public Part<IGolemHead> getHeadByIndex(int index)
/*     */   {
/* 129 */     if ((index >= 0) && (index < this.heads.size())) {
/* 130 */       return (Part)this.heads.get(index);
/*     */     }
/* 132 */     return null;
/*     */   }
/*     */   
/*     */   public Part<IGolemBody> getBodyByIndex(int index)
/*     */   {
/* 137 */     if ((index >= 0) && (index < this.bodies.size())) {
/* 138 */       return (Part)this.bodies.get(index);
/*     */     }
/* 140 */     return null;
/*     */   }
/*     */   
/*     */   public Part<IGolemLeg> getLegByIndex(int index)
/*     */   {
/* 145 */     if ((index >= 0) && (index < this.legs.size())) {
/* 146 */       return (Part)this.legs.get(index);
/*     */     }
/* 148 */     return null;
/*     */   }
/*     */   
/*     */   public Part<IGolemArm> getArmByStack(ItemStack stack)
/*     */   {
/* 153 */     for (Part<IGolemArm> arm : this.arms) {
/* 154 */       if (ItemStack.func_179545_c(arm.stack, stack)) {
/* 155 */         return arm;
/*     */       }
/*     */     }
/* 158 */     return null;
/*     */   }
/*     */   
/*     */   public Part<IGolemLeg> getLegByStack(ItemStack stack) {
/* 162 */     for (Part<IGolemLeg> leg : this.legs) {
/* 163 */       if (ItemStack.func_179545_c(leg.stack, stack)) {
/* 164 */         return leg;
/*     */       }
/*     */     }
/* 167 */     return null;
/*     */   }
/*     */   
/*     */   public Part<IGolemHead> getHeadByStack(ItemStack stack) {
/* 171 */     for (Part<IGolemHead> head : this.heads) {
/* 172 */       if (ItemStack.func_179545_c(head.stack, stack)) {
/* 173 */         return head;
/*     */       }
/*     */     }
/* 176 */     return null;
/*     */   }
/*     */   
/*     */   public Part<IGolemBody> getBodyByStack(ItemStack stack) {
/* 180 */     for (Part<IGolemBody> body : this.bodies) {
/* 181 */       if (ItemStack.func_179545_c(body.stack, stack)) {
/* 182 */         return body;
/*     */       }
/*     */     }
/* 185 */     return null;
/*     */   }
/*     */   
/*     */   public static class Part<T>
/*     */   {
/*     */     private final T item;
/*     */     private final int index;
/*     */     private final ItemStack stack;
/*     */     
/*     */     public Part(T item, int index, ItemStack stack) {
/* 195 */       this.item = item;
/* 196 */       this.index = index;
/* 197 */       this.stack = stack;
/*     */     }
/*     */     
/*     */     public T getItem() {
/* 201 */       return (T)this.item;
/*     */     }
/*     */     
/*     */     public int getIndex() {
/* 205 */       return this.index;
/*     */     }
/*     */     
/*     */     public ItemStack getStack() {
/* 209 */       return this.stack;
/*     */     }
/*     */   }
/*     */ }


/* Location:              /Users/shannon/Documents/Curse/Minecraft/Instances/MagiTech Team Presents Industrilization/mods/intangible-1.8.9-0.0.25.jar!/emoniph/intangible/golem/GolemPartRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */