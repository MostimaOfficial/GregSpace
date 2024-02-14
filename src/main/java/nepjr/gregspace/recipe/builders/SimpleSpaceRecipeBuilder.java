package nepjr.gregspace.recipe.builders;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeBuilder;
import gregtech.api.recipes.RecipeMap;
import gregtech.api.util.GTLog;
import nepjr.gregspace.cfg.ModConfig;
import nepjr.gregspace.recipe.properties.SpaceDimensionProperty;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.jetbrains.annotations.NotNull;

public class SimpleSpaceRecipeBuilder extends RecipeBuilder<SimpleSpaceRecipeBuilder> {
	
	int[] empty = {};

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
        	this.dimension((int[]) value);
        	return true;
        }
        return super.applyProperty(key, value);
    }

    public SimpleSpaceRecipeBuilder dimension(int dimensionID) {
    	int[] dimensionIDs = getDimensionIDs();
        dimensionIDs[0] = dimensionID;
        this.applyProperty(SpaceDimensionProperty.getInstance(), dimensionIDs);
        return this;
    }
    
    public SimpleSpaceRecipeBuilder dimension(int[] dimensionID) {
    	System.out.println(dimensionID);
        if (dimensionID.length == 0) {
            GTLog.logger.error("Dimension cannot be blank. Defaulting to spaceDims config value",
                    new IllegalArgumentException());
            this.applyProperty(SpaceDimensionProperty.getInstance(), ModConfig.space.spaceDims);
        }
        this.applyProperty(SpaceDimensionProperty.getInstance(), dimensionID);
        return this;
    }

    public int[] getDimensionIDs() {
    	return this.recipePropertyStorage.getRecipePropertyValue(SpaceDimensionProperty.getInstance(),
        		ModConfig.space.spaceDims);
                
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .appendSuper(super.toString())
                .append(SpaceDimensionProperty.getInstance().getKey(), getDimensionIDs().toString())
                .toString();
    }
}
