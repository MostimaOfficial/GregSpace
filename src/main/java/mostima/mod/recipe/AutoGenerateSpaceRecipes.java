package mostima.mod.recipe;

import firemerald.mc4.init.MC4Items;
import gregtech.api.recipes.Recipe;
import gregtech.api.recipes.RecipeMaps;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AutoGenerateSpaceRecipes {
    public static void init()
    {
        int[] dims = {1, -1};
        for (Recipe r : RecipeMaps.MACERATOR_RECIPES.getRecipeList())
        {
            ModRecipeMaps.MACERATOR_RECIPES.recipeBuilder().append(r, 1, false).buildAndRegister();
        }

        for (Recipe r : RecipeMaps.ALLOY_SMELTER_RECIPES.getRecipeList())
        {
            ModRecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder().append(r, 1, false).buildAndRegister();
        }

        ModRecipeMaps.ALLOY_SMELTER_RECIPES.recipeBuilder()
                .inputs(Items.DIAMOND.getDefaultInstance(), Items.ACACIA_BOAT.getDefaultInstance())
                .output(MC4Items.AETHER_PORTAL)
                .duration(20)
                .dimension(1)
                .EUt(32767)
                .buildAndRegister();
    }
}
