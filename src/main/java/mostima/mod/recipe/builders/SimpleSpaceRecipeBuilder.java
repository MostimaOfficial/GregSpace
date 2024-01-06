package mostima.mod.recipe.builders;

import crafttweaker.CraftTweakerAPI;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
import it.unimi.dsi.fastutil.ints.IntLists;
import mostima.mod.recipe.properties.SpaceDimensionProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SimpleSpaceRecipeBuilder extends RecipeBuilder<SimpleSpaceRecipeBuilder>{

    public SimpleSpaceRecipeBuilder() {}

    public SimpleSpaceRecipeBuilder(Recipe recipe, RecipeMap<SimpleSpaceRecipeBuilder> recipeMap) {
        super(recipe, recipeMap);
    }

    public SimpleSpaceRecipeBuilder(RecipeBuilder<SimpleSpaceRecipeBuilder> recipeBuilder) {
        super(recipeBuilder);
    }

    @Override
    public SimpleSpaceRecipeBuilder copy() {
        return new SimpleSpaceRecipeBuilder(this);
    }

    @Override
    public boolean applyProperty(@NotNull String key, Object value) {
        if (key.equals(SpaceDimensionProperty.KEY)) {
            if (value instanceof Integer) {
                this.dimension((Integer) value);
            } else if (value instanceof List && !((List<?>) value).isEmpty() &&
                    ((List<?>) value).get(0) instanceof Integer) {
                IntList dimensionIDs = getDimensionIDs();
                if (dimensionIDs == IntLists.EMPTY_LIST) {
                    dimensionIDs = new IntArrayList();
                    this.applyProperty(SpaceDimensionProperty.getInstance(), dimensionIDs);
                }
                dimensionIDs.addAll((List<Integer>) value);
            } else {
                if (isCTRecipe) {
                    CraftTweakerAPI.logError("Dimension for Gas Collector needs to be a Integer");
                    return false;
                }
                throw new IllegalArgumentException("Invalid Dimension Property Type!");
            }
            return true;
        }
        return super.applyProperty(key, value);
    }

    public SimpleSpaceRecipeBuilder dimension(int dimensionID) {
        IntList dimensionIDs = getDimensionIDs();
        if (dimensionIDs == IntLists.EMPTY_LIST) {
            dimensionIDs = new IntArrayList();
            this.applyProperty(SpaceDimensionProperty.getInstance(), dimensionIDs);
        }
        dimensionIDs.add(dimensionID);
        return this;
    }

    public IntList getDimensionIDs() {
        return this.recipePropertyStorage == null ? IntLists.EMPTY_LIST :
                this.recipePropertyStorage.getRecipePropertyValue(SpaceDimensionProperty.getInstance(),
                        IntLists.EMPTY_LIST);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(SpaceDimensionProperty.getInstance().getKey(), getDimensionIDs().toString())
                .toString();
    }
}
