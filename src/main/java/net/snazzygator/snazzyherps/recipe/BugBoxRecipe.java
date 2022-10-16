package net.snazzygator.snazzyherps.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.snazzygator.snazzyherps.SnazzyHerps;

import javax.annotation.Nullable;

public class BugBoxRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack result;
    private final NonNullList<Ingredient> recipeItems;

    public BugBoxRecipe(ResourceLocation id, ItemStack result,
                        NonNullList<Ingredient> recipeItems) {
        this.id = id;
        this.result = result;
        this.recipeItems = recipeItems;
    }

    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        return recipeItems.get(0).test(pContainer.getItem(0))
                && recipeItems.get(1).test(pContainer.getItem(1));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return recipeItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer) {
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return result.copy();
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(SimpleContainer pContainer) {
        NonNullList<ItemStack> inputs = NonNullList.withSize(pContainer.getContainerSize(), ItemStack.EMPTY);

        for(int i = 0; i < inputs.size(); ++i) {
            ItemStack item = pContainer.getItem(i);
            if (item.hasContainerItem()) {
                inputs.set(i, item.getContainerItem());
            }
        }

        return inputs;
    }

    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<BugBoxRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "bugbox_breeding";
    }

    public static class Serializer implements RecipeSerializer<BugBoxRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID =
                new ResourceLocation(SnazzyHerps.MOD_ID,"bugbox_breeding");

        @Override
        public BugBoxRecipe fromJson(ResourceLocation id, JsonObject json) {
            ItemStack result = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new BugBoxRecipe(id, result, inputs);
        }

        @Override
        public BugBoxRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            ItemStack result = buf.readItem();
            return new BugBoxRecipe(id, result, inputs);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, BugBoxRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeItemStack(recipe.getResultItem(), false);
        }

        @Override
        public RecipeSerializer<?> setRegistryName(ResourceLocation name) {
            return INSTANCE;
        }

        @Nullable
        @Override
        public ResourceLocation getRegistryName() {
            return ID;
        }

        @Override
        public Class<RecipeSerializer<?>> getRegistryType() {
            return Serializer.castClass(RecipeSerializer.class);
        }

        @SuppressWarnings("unchecked") // Need this wrapper, because generics
        private static <G> Class<G> castClass(Class<?> cls) {
            return (Class<G>)cls;
        }
    }
}
