package nepjr.gregspace.recipe;

import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;

public class AutoGenerateSpaceRecipes {
    public static void init()
    {
        int[] dims = {-1, 1};
        for (Recipe r : RecipeMaps.MACERATOR_RECIPES.getRecipeList())
        {
            ModRecipeMaps.MACERATOR_RECIPES.recipeBuilder().append(r, 1, false).buildAndRegister();
        }

        for (Recipe r : RecipeMaps.ALLOY_SMELTER_RECIPES.getRecipeList())
        {
            ModRecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().append(r, 1, false).buildAndRegister();
        }
    }
}
